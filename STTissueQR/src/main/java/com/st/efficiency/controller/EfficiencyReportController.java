/**
 * 
 */
package com.st.efficiency.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.common.Columns;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
//import com.st.customercomplaint.model.CustomerComplaint;
import com.st.efficiency.automailer.EfficiencyAutoMailer;
import com.st.efficiency.model.EffSummaryPrimary;
import com.st.efficiency.model.EffSummarySecondary;
import com.st.efficiency.model.Efficiency;
import com.st.efficiency.model.EfficiencyShiftData;
import com.st.efficiency.model.PrimaryCode;
import com.st.efficiency.model.SecondaryCode;
import com.st.efficiency.report.EfficiencyReportHandler;
import com.st.efficiency.service.EfficiencyCodeService;
import com.st.efficiency.service.EfficiencyService;
import com.st.qualitypm6.service.GradeService;
import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;
import com.st.winderbreakmonitoring.model.WinderBreakMonitoringComman;
import com.st.efficiency.report.*;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/efficiencyreport")
public class EfficiencyReportController {
	
	//private static Logger logger=LoggerFactory.getLogger(EfficencyReportController.class);

	@Autowired
	private ServletContext context;
	
	@Autowired
	private GradeService gradeService;
	@Autowired
	private EfficiencyCodeService efficiencyCodeService;
	@Autowired
	private EfficiencyService efficiencyService;
	
	@Autowired
	private EfficiencyReportHandler reportHandler;
	
	@Autowired
	private EfficiencyReportByDCSHandler efficiencyreportbydcshandler; 
	
	@Autowired
	private EfficiencyAutoMailer efficiencyAutoMailer;
	
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Model model) {
		Calendar calendar=Calendar.getInstance();
		model.addAttribute("sdate", dateFormat.format(calendar.getTime()));
		model.addAttribute("edate", dateFormat.format(calendar.getTime()));
		
		model.addAttribute("pcodes", efficiencyCodeService.getPrimaryCodes());
		model.addAttribute("scodes", efficiencyCodeService.getSecondaryCodes());
		model.addAttribute("showTable", false);
		
		return "efficiencyReport";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(HttpServletRequest request,
			HttpServletResponse response,
			RedirectAttributes redirectAttributes,
			Model model) {
		
		
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		if(sdate==null){
			redirectAttributes.addFlashAttribute("error", "Invalid start date");
			return "redirect:/efficiencyreport/main";
		}
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
	//	System.out.println("Start date:-"+scal.getTime());
		
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		if(edate==null){
			redirectAttributes.addFlashAttribute("error", "Invalid end date");
			return "redirect:/efficiencyreport/main";
		}
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
	//	System.out.println("End date:-"+ecal.getTime());
		
		String pcode=CommonUtil.checkNull(request.getParameter("pcode"));
		String scode=CommonUtil.checkNull(request.getParameter("scode"));
		
		model.addAttribute("sdate", request.getParameter("sdate"));
		model.addAttribute("edate", request.getParameter("edate"));
		model.addAttribute("pcodes", efficiencyCodeService.getPrimaryCodes());
		model.addAttribute("scodes", efficiencyCodeService.getSecondaryCodes());
		model.addAttribute("pcode", pcode);
		model.addAttribute("scode", scode);
		model.addAttribute("showTable", true);
		
		Efficiency efficiency=new Efficiency();
		efficiency.setStartDate(scal.getTime());
		efficiency.setEndDate(ecal.getTime());
		efficiency.setPcode(pcode);
		efficiency.setScode(scode);
		
		List<Map<String, Object>> datas=new ArrayList<>();
		List<Efficiency> efficiencies=efficiencyService.getEfficiencies(efficiency);
		
		int hh=0;
		int mm=0;
		for (Efficiency efficiency2 : efficiencies) {
			hh+=CommonUtil.getHoursDuration(efficiency2.getStartTime(), efficiency2.getEndTime());
			mm+=CommonUtil.getMinutesDuration(efficiency2.getStartTime(), efficiency2.getEndTime());
		}
		int totalmm=hh*60+mm;
	
		model.addAttribute("totalhh", (totalmm/60));
		model.addAttribute("totalmm", (totalmm%60));
		try {
			datas=formatData(efficiencies);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		model.addAttribute("datas", datas);
				
		return "efficiencyReport";
	}
	
	
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception {
		
		
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		if(sdate==null){
			throw new  Exception("Invalid start date");
		}
		
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		if(edate==null){
			throw new  Exception("Invalid End date");
		}
		
		String pcode=CommonUtil.checkNull(request.getParameter("pcode"));
		String scode=CommonUtil.checkNull(request.getParameter("scode"));
		
		model.addAttribute("sdate", request.getParameter("sdate"));
		model.addAttribute("edate", request.getParameter("edate"));
		model.addAttribute("pcodes", efficiencyCodeService.getPrimaryCodes());
		model.addAttribute("scodes", efficiencyCodeService.getSecondaryCodes());
		model.addAttribute("pcode", pcode);
		model.addAttribute("scode", scode);
		model.addAttribute("showTable", true);
		
		Efficiency efficiency=new Efficiency();
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		efficiency.setStartDate(scal.getTime());
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		efficiency.setEndDate(ecal.getTime());
		efficiency.setPcode(pcode);
		efficiency.setScode(scode);
		
		List<Map<String, Object>> datas=new ArrayList<>();
		List<Efficiency> efficiencies=efficiencyService.getEfficiencies(efficiency);
		
		
		datas=formatData(efficiencies);
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=ST Efficiency-Report.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/Efficiency Report.xls");

		HSSFWorkbook workbook=getFormatedWorkbook(file,datas);
		workbook.write(response.getOutputStream());

	}
	
	

	/**
	 * @param file
	 * @param datas
	 * @return
	 * @throws IOException 
	 */
	private HSSFWorkbook getFormatedWorkbook(File file,
			List<Map<String, Object>> datas) throws IOException {

		
		
		FileInputStream inputStream=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
		HSSFCellStyle headerCellStyle=workbook.createCellStyle();
		headerCellStyle.setWrapText(true);
		headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle.setBorderBottom(BorderStyle.THIN);
		headerCellStyle.setBorderLeft(BorderStyle.THIN);
		headerCellStyle.setBorderRight(BorderStyle.THIN);
		headerCellStyle.setBorderTop(BorderStyle.THIN);
		
		Font headerFont=workbook.createFont();
		headerFont.setBold(false);
		headerCellStyle.setFont(headerFont);
		
		
		
		HSSFSheet sheet=workbook.getSheetAt(0);


		Font fontRow=workbook.createFont();
		fontRow.setBold(true);
		fontRow.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle rowCellStyle=workbook.createCellStyle();
		rowCellStyle.setBorderBottom(BorderStyle.THIN);
		rowCellStyle.setBorderLeft(BorderStyle.THIN);
		rowCellStyle.setBorderRight(BorderStyle.THIN);
		rowCellStyle.setBorderTop(BorderStyle.THIN);
		rowCellStyle.setFont(fontRow);
		rowCellStyle.setAlignment(HorizontalAlignment.CENTER);
		rowCellStyle.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle.setWrapText(true);
		
	
		int rowCount=3;
		int hh=0;
		int mm=0;
		
		for (Map<String, Object> map : datas) {
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			HSSFCell COL_01=row.createCell(Columns.COL_00);
			COL_01.setCellStyle(rowCellStyle);
			COL_01.setCellValue(map.get(ColumnsOfTable.COL_02).toString());
			
			HSSFCell COL_02=row.createCell(Columns.COL_01);
			COL_02.setCellStyle(rowCellStyle);
			COL_02.setCellValue(map.get(ColumnsOfTable.COL_03).toString());
			
			HSSFCell COL_03=row.createCell(Columns.COL_02);
			COL_03.setCellStyle(rowCellStyle);
			COL_03.setCellValue(map.get(ColumnsOfTable.COL_04).toString());
			
			HSSFCell COL_04=row.createCell(Columns.COL_03);
			COL_04.setCellStyle(rowCellStyle);
			COL_04.setCellValue(map.get(ColumnsOfTable.COL_05).toString());
			
			HSSFCell COL_05=row.createCell(Columns.COL_04);
			COL_05.setCellStyle(rowCellStyle);
			COL_05.setCellValue(map.get(ColumnsOfTable.COL_06).toString());
			
			
			HSSFCell COL_11=row.createCell(Columns.COL_05);
			COL_11.setCellStyle(rowCellStyle);
			COL_11.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_12).toString()));
			
			hh+=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_12).toString());
			
			HSSFCell COL_12=row.createCell(Columns.COL_06);
			COL_12.setCellStyle(rowCellStyle);
			COL_12.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString()));
			
			mm+=CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString());
			
			HSSFCell COL_06=row.createCell(Columns.COL_07);
			COL_06.setCellStyle(rowCellStyle);
			COL_06.setCellValue(map.get(ColumnsOfTable.COL_07).toString());
			
			HSSFCell COL_07=row.createCell(Columns.COL_08);
			COL_07.setCellStyle(rowCellStyle);
			COL_07.setCellValue(map.get(ColumnsOfTable.COL_08).toString());
			
			HSSFCell COL_08=row.createCell(Columns.COL_09);
			COL_08.setCellStyle(rowCellStyle);
			COL_08.setCellValue(map.get(ColumnsOfTable.COL_10).toString());
			
			HSSFCell COL_09=row.createCell(Columns.COL_10);
			COL_09.setCellStyle(rowCellStyle);
			COL_09.setCellValue(map.get(ColumnsOfTable.COL_11).toString());
			
			HSSFCell COL_10=row.createCell(Columns.COL_11);
			COL_10.setCellStyle(rowCellStyle);
			COL_10.setCellValue(map.get(ColumnsOfTable.COL_09).toString());

		}
		
		{
			// Code for adding total duration -- Roshan - 2015-03-02
			
			
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			HSSFCell COL_01=row.createCell(Columns.COL_00);
			COL_01.setCellStyle(rowCellStyle);
			COL_01.setCellValue("");
			
			HSSFCell COL_02=row.createCell(Columns.COL_01);
			COL_02.setCellStyle(rowCellStyle);
			COL_02.setCellValue("");
			
			HSSFCell COL_03=row.createCell(Columns.COL_02);
			COL_03.setCellStyle(rowCellStyle);
			COL_03.setCellValue("");
			
			HSSFCell COL_04=row.createCell(Columns.COL_03);
			COL_04.setCellStyle(rowCellStyle);
			COL_04.setCellValue("");
			
			HSSFCell COL_05=row.createCell(Columns.COL_04);
			COL_05.setCellStyle(rowCellStyle);
			COL_05.setCellValue("Duration");
			
			
			int totalH=hh*60+mm;
			
			HSSFCell COL_11=row.createCell(Columns.COL_05);
			COL_11.setCellStyle(rowCellStyle);
			COL_11.setCellValue(totalH/60);
			
			
			HSSFCell COL_12=row.createCell(Columns.COL_06);
			COL_12.setCellStyle(rowCellStyle);
			COL_12.setCellValue(totalH%60);
			
			
			HSSFCell COL_06=row.createCell(Columns.COL_07);
			COL_06.setCellStyle(rowCellStyle);
			COL_06.setCellValue("");
			
			HSSFCell COL_07=row.createCell(Columns.COL_08);
			COL_07.setCellStyle(rowCellStyle);
			COL_07.setCellValue("");
			
			HSSFCell COL_08=row.createCell(Columns.COL_09);
			COL_08.setCellStyle(rowCellStyle);
			COL_08.setCellValue("");
			
			HSSFCell COL_09=row.createCell(Columns.COL_10);
			COL_09.setCellStyle(rowCellStyle);
			COL_09.setCellValue("");
			
			HSSFCell COL_10=row.createCell(Columns.COL_11);
			COL_10.setCellStyle(rowCellStyle);
			COL_10.setCellValue("");
			
		}
		
		return workbook;
	}

	/**
	 * @param efficiencies
	 * @return
	 */
	private List<Map<String, Object>> formatData(List<Efficiency> efficiencies) {
		
		
		
		
		List<Map<String, Object>> datas=new ArrayList<>();
		
		for (Efficiency efficiency : efficiencies) {
			Map<String, Object> map=new HashMap<String, Object>(); 
			map.put(ColumnsOfTable.COL_01, efficiency.getId());
			map.put(ColumnsOfTable.COL_02, dateFormat.format(efficiency.getDate()));
			map.put(ColumnsOfTable.COL_03, efficiency.getShift());
			map.put(ColumnsOfTable.COL_04, efficiency.getCrew());
			map.put(ColumnsOfTable.COL_05, timeFormat.format(efficiency.getStartTime()));
			map.put(ColumnsOfTable.COL_06, timeFormat.format(efficiency.getEndTime()));
			map.put(ColumnsOfTable.COL_07, efficiency.getReel());
			map.put(ColumnsOfTable.COL_08, efficiency.getGradeCode());
			map.put(ColumnsOfTable.COL_09, efficiency.getComment());
			SecondaryCode secondaryCode=efficiency.getSecondaryCode();
			PrimaryCode primaryCode=null;
			if(secondaryCode!=null){
				map.put(ColumnsOfTable.COL_10, secondaryCode.getCode());
				primaryCode=secondaryCode.getPrimaryCode();
			}else{
				map.put(ColumnsOfTable.COL_10, "");
			}
				
			if(primaryCode!=null){
				map.put(ColumnsOfTable.COL_11, primaryCode.getCode());
			}else{
				map.put(ColumnsOfTable.COL_11, "");
			}
			
		
			Calendar scal=Calendar.getInstance();
			scal.setTime(efficiency.getStartTime());
			
			Calendar ecal=Calendar.getInstance();
			ecal.setTime(efficiency.getEndTime());
			
			map.put(ColumnsOfTable.COL_12, CommonUtil.getHoursDuration(new Date(efficiency.getStartTime().getTime()), new Date(efficiency.getEndTime().getTime())));
			map.put(ColumnsOfTable.COL_13, CommonUtil.getMinutesDuration(new Date(efficiency.getStartTime().getTime()), new Date(efficiency.getEndTime().getTime())));
			
			datas.add(map);
		} 
		
		return datas;
	}

	
	
	//Summary Report
	
	
	@RequestMapping(value="/summary", method=RequestMethod.GET)
	public String mainSummary(Model model) {
		Calendar calendar=Calendar.getInstance();
		model.addAttribute("sdate", dateFormat.format(calendar.getTime()));
		model.addAttribute("edate", dateFormat.format(calendar.getTime()));
		
	//	model.addAttribute("pcodes", efficiencyCodeService.getPrimaryCodes());
	//	model.addAttribute("scodes", efficiencyCodeService.getSecondaryCodes());
		model.addAttribute("showTable", false);
		
		return "efficiencyReportSummary";
	}
	
	@RequestMapping(value="/viewsummary",method=RequestMethod.GET)
	public String viewSummary(HttpServletRequest request,
			HttpServletResponse response,
			RedirectAttributes redirectAttributes,
			Model model) {
		
		
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		if(sdate==null){
			redirectAttributes.addFlashAttribute("error", "Invalid start date");
			return "redirect:/efficiencyreport/summary";
		}
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
	//	System.out.println("Start date:-"+scal.getTime());
		
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		if(edate==null){
			redirectAttributes.addFlashAttribute("error", "Invalid end date");
			return "redirect:/efficiencyreport/summary";
		}
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
	//	System.out.println("End date:-"+ecal.getTime());
		
		int pcode=CommonUtil.checkInt(request.getParameter("pcode"));
		int scode=CommonUtil.checkInt(request.getParameter("scode"));
		
		model.addAttribute("sdate", request.getParameter("sdate"));
		model.addAttribute("edate", request.getParameter("edate"));
		model.addAttribute("pcodes", efficiencyCodeService.getPrimaryCodes());
		model.addAttribute("scodes", efficiencyCodeService.getSecondaryCodes());
		model.addAttribute("pcode", pcode);
		model.addAttribute("scode", scode);
		model.addAttribute("showTable", true);
		
		
		Map<String, Object> datas=new HashMap<>();
	
		List<EffSummaryPrimary> summaryPrimaries=new ArrayList<>();
		try {
			summaryPrimaries=formatSummaryData(scal.getTime(),ecal.getTime(),pcode,scode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		int totalmin=0;
		for (EffSummaryPrimary effSummaryPrimary : summaryPrimaries) {
			totalmin+=effSummaryPrimary.getTotalMin();
		}
		datas.put("summaryPrimaries", summaryPrimaries);
		datas.put("hh", totalmin/60);
		datas.put("mm", totalmin%60);
		
		
		model.addAttribute("datas", datas);
				
		return "efficiencyReportSummary";
	}
	
	
	@RequestMapping(value="/exportsummary",method=RequestMethod.POST)
	public void exportSummary(HttpServletRequest request,
			HttpServletResponse response,
			RedirectAttributes redirectAttributes,
			Model model) throws IOException {
		
		
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);


		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
	//	System.out.println("Start date:-"+scal.getTime());
		
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 0);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
	//	System.out.println("End date:-"+ecal.getTime());
		
		int pcode=CommonUtil.checkInt(request.getParameter("pcode"));
		int scode=CommonUtil.checkInt(request.getParameter("scode"));
		
		
		Map<String, Object> datas=new HashMap<>();
		List<EffSummaryPrimary> summaryPrimaries=new ArrayList<>();
		try {
			summaryPrimaries=formatSummaryData(scal.getTime(),ecal.getTime(),pcode,scode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		int totalmin=0;
		for (EffSummaryPrimary effSummaryPrimary : summaryPrimaries) {
			totalmin+=effSummaryPrimary.getTotalMin();
		}
		datas.put("summaryPrimaries", summaryPrimaries);
		datas.put("hh", totalmin/60);
		datas.put("mm", totalmin%60);
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=ST Efficiency Summary-Report.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/Efficiency Summary Report.xls");

		HSSFWorkbook workbook=getFormatedSummaryWorkbook(file,datas);
		workbook.write(response.getOutputStream());
	}
	


	/**
	 * @param file
	 * @param datas
	 * @return
	 * @throws IOException 
	 */
	private HSSFWorkbook getFormatedSummaryWorkbook(File file,
			Map<String, Object> datas) throws IOException {
		
		FileInputStream inputStream=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
		HSSFCellStyle headerCellStyle=workbook.createCellStyle();
		headerCellStyle.setWrapText(true);
		headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle.setBorderBottom(BorderStyle.THIN);
		headerCellStyle.setBorderLeft(BorderStyle.THIN);
		headerCellStyle.setBorderRight(BorderStyle.THIN);
		headerCellStyle.setBorderTop(BorderStyle.THIN);
		
		Font headerFont=workbook.createFont();
		headerFont.setBold(false);
		headerCellStyle.setFont(headerFont);
		
		
		
		HSSFSheet sheet=workbook.getSheetAt(0);


		Font fontRow=workbook.createFont();
		fontRow.setBold(true);
		fontRow.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle rowCellStyle=workbook.createCellStyle();
		rowCellStyle.setBorderBottom(BorderStyle.THIN);
		rowCellStyle.setBorderLeft(BorderStyle.THIN);
		rowCellStyle.setBorderRight(BorderStyle.THIN);
		rowCellStyle.setBorderTop(BorderStyle.THIN);
		rowCellStyle.setFont(fontRow);
		rowCellStyle.setAlignment(HorizontalAlignment.LEFT
				);
		rowCellStyle.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle.setWrapText(true);
		
		Font fontRow2=workbook.createFont();
		fontRow2.setBold(true);
		fontRow2.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle rowCellStyle2=workbook.createCellStyle();
		rowCellStyle2.setBorderBottom(BorderStyle.THIN);
		rowCellStyle2.setBorderLeft(BorderStyle.THIN);
		rowCellStyle2.setBorderRight(BorderStyle.THIN);
		rowCellStyle2.setBorderTop(BorderStyle.THIN);
		rowCellStyle2.setFont(fontRow2);
		rowCellStyle2.setAlignment(HorizontalAlignment.LEFT);
		rowCellStyle2.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle2.setWrapText(true);
		
		
		Font fontRow2_1=workbook.createFont();
		fontRow2_1.setBold(false);
		fontRow2_1.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle rowCellStyle2_1=workbook.createCellStyle();
		rowCellStyle2_1.setBorderBottom(BorderStyle.THIN);
		rowCellStyle2_1.setBorderLeft(BorderStyle.THIN);
		rowCellStyle2_1.setBorderRight(BorderStyle.THIN);
		rowCellStyle2_1.setBorderTop(BorderStyle.THIN);
		rowCellStyle2_1.setFont(fontRow2_1);
		rowCellStyle2_1.setAlignment(HorizontalAlignment.CENTER);
		rowCellStyle2_1.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle2_1.setWrapText(true);
		
		
		Font objectFontCol=workbook.createFont();
		objectFontCol.setBold(true);
		objectFontCol.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle objectCellStyleCol=workbook.createCellStyle();
		objectCellStyleCol.setBorderBottom(BorderStyle.THIN);
		objectCellStyleCol.setBorderLeft(BorderStyle.THIN);
		objectCellStyleCol.setBorderRight(BorderStyle.THIN);
		objectCellStyleCol.setBorderTop(BorderStyle.THIN);
		objectCellStyleCol.setAlignment(HorizontalAlignment.RIGHT);
		objectCellStyleCol.setFont(objectFontCol);
		objectCellStyleCol.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		objectCellStyleCol.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		objectCellStyleCol.setWrapText(true);
		
		Font objectFontCol_1=workbook.createFont();
		objectFontCol_1.setBold(true);
		objectFontCol_1.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle objectCellStyleCol_1=workbook.createCellStyle();
		objectCellStyleCol_1.setBorderBottom(BorderStyle.THIN);
		objectCellStyleCol_1.setBorderLeft(BorderStyle.THIN);
		objectCellStyleCol_1.setBorderRight(BorderStyle.THIN);
		objectCellStyleCol_1.setBorderTop(BorderStyle.THIN);
		objectCellStyleCol_1.setAlignment(HorizontalAlignment.CENTER);
		objectCellStyleCol_1.setFont(objectFontCol_1);
		objectCellStyleCol_1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		objectCellStyleCol_1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		objectCellStyleCol_1.setWrapText(true);
		
		Font objectFontCol2=workbook.createFont();
		objectFontCol2.setBold(true);
		objectFontCol2.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle objectCellStyleCol2=workbook.createCellStyle();
		objectCellStyleCol2.setBorderBottom(BorderStyle.THIN);
		objectCellStyleCol2.setBorderLeft(BorderStyle.THIN);
		objectCellStyleCol2.setBorderRight(BorderStyle.THIN);
		objectCellStyleCol2.setBorderTop(BorderStyle.THIN);
		objectCellStyleCol2.setAlignment(HorizontalAlignment.RIGHT);
		objectCellStyleCol2.setFont(objectFontCol2);
		objectCellStyleCol2.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
		objectCellStyleCol2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		objectCellStyleCol2.setWrapText(true);
		
		Font objectFontCol2_1=workbook.createFont();
		objectFontCol2_1.setBold(true);
		objectFontCol2_1.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle objectCellStyleCol2_1=workbook.createCellStyle();
		objectCellStyleCol2_1.setBorderBottom(BorderStyle.THIN);
		objectCellStyleCol2_1.setBorderLeft(BorderStyle.THIN);
		objectCellStyleCol2_1.setBorderRight(BorderStyle.THIN);
		objectCellStyleCol2_1.setBorderTop(BorderStyle.THIN);
		objectCellStyleCol2_1.setAlignment(HorizontalAlignment.CENTER);
		objectCellStyleCol2_1.setFont(objectFontCol2_1);
		objectCellStyleCol2_1.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
		objectCellStyleCol2_1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		objectCellStyleCol2_1.setWrapText(true);
		
		int rowCount=2;
		
		@SuppressWarnings("unchecked")
		List<EffSummaryPrimary> effSummaryPrimaries=(List<EffSummaryPrimary>) datas.get("summaryPrimaries");
		for (EffSummaryPrimary effSummaryPrimary : effSummaryPrimaries) {
			
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			HSSFCell pCodeCell=row.createCell(0);
			pCodeCell.setCellStyle(rowCellStyle);
			pCodeCell.setCellValue(effSummaryPrimary.getCode());
			
			row.createCell(1).setCellStyle(rowCellStyle);
			row.createCell(2).setCellStyle(rowCellStyle);
			
			List<EffSummarySecondary> effSummarySecondaries=effSummaryPrimary.getSummarySecondaries();
			for (EffSummarySecondary effSummarySecondary : effSummarySecondaries) {
				HSSFRow row2=sheet.createRow(rowCount++);
				row2.setHeight((short)280);
				
				HSSFCell sCodeCell1=row2.createCell(0);
				sCodeCell1.setCellStyle(rowCellStyle2);
				sCodeCell1.setCellValue(effSummarySecondary.getCode());
				
				HSSFCell sCodeCell2=row2.createCell(1);
				sCodeCell2.setCellStyle(rowCellStyle2_1);
				sCodeCell2.setCellValue(effSummarySecondary.getHh());
				
				HSSFCell sCodeCell3=row2.createCell(2);
				sCodeCell3.setCellStyle(rowCellStyle2_1);
				sCodeCell3.setCellValue(effSummarySecondary.getMm());
				
				HSSFCell sCodeCell4=row2.createCell(3);
				sCodeCell4.setCellStyle(rowCellStyle2_1);
				sCodeCell4.setCellValue(effSummarySecondary.getCounter());
			}
			
			{
				HSSFRow row2=sheet.createRow(rowCount++);
				row2.setHeight((short)280);
				
				HSSFCell sCodeCell1=row2.createCell(0);
				sCodeCell1.setCellStyle(objectCellStyleCol);
				sCodeCell1.setCellValue("TOTAL");
				
				HSSFCell sCodeCell2=row2.createCell(1);
				sCodeCell2.setCellStyle(objectCellStyleCol_1);
				sCodeCell2.setCellValue(effSummaryPrimary.getHh());
				
				HSSFCell sCodeCell3=row2.createCell(2);
				sCodeCell3.setCellStyle(objectCellStyleCol_1);
				sCodeCell3.setCellValue(effSummaryPrimary.getMm());
				
				HSSFCell sCodeCell4=row2.createCell(3);
				sCodeCell4.setCellStyle(objectCellStyleCol_1);
			}
			
		}
		
		{
			{
				HSSFRow row2=sheet.createRow(rowCount++);
				row2.setHeight((short)280);
				
				HSSFCell sCodeCell1=row2.createCell(0);
				sCodeCell1.setCellStyle(objectCellStyleCol2);
				sCodeCell1.setCellValue("GRAND TOTAL");
				
				HSSFCell sCodeCell2=row2.createCell(1);
				sCodeCell2.setCellStyle(objectCellStyleCol2_1);
				sCodeCell2.setCellValue(NumberUtils.toInt(datas.get("hh")==null?"":datas.get("hh").toString(),0));
				
				HSSFCell sCodeCell3=row2.createCell(2);
				sCodeCell3.setCellStyle(objectCellStyleCol2_1);
				sCodeCell3.setCellValue(NumberUtils.toInt(datas.get("mm")==null?"":datas.get("mm").toString(),0));
				
				HSSFCell sCodeCell4=row2.createCell(3);
				sCodeCell4.setCellStyle(objectCellStyleCol2_1);
			}
		}
		
		return workbook;
	}

	private List<EffSummaryPrimary> formatSummaryData(Date sdate, Date edate,int pcode,int scode) {
		

		
		List<Efficiency> efficiencies=efficiencyCodeService.getSummaryData(sdate,edate,pcode,scode);
		
		List<EffSummaryPrimary> effSummaryPrimaries=new ArrayList<>();
		
		for (Efficiency efficiency : efficiencies) {
			EffSummaryPrimary effSummaryPrimary=getEffSummaryPrimary(effSummaryPrimaries,efficiency.getPcode());
			if(effSummaryPrimary==null){
				effSummaryPrimary=new EffSummaryPrimary();
				effSummaryPrimary.setCode(efficiency.getPcode());
				
				
				//Secondary code
				EffSummarySecondary effSummarySecondary=new EffSummarySecondary();
				effSummarySecondary.setCode(efficiency.getScode());
				int hh=CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
				int mm=CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
				int total=(hh*60)+mm;
				effSummarySecondary.setTotalMin(total);
				effSummarySecondary.setHh(effSummarySecondary.getTotalMin()/60);
				effSummarySecondary.setMm(effSummarySecondary.getTotalMin()%60);
				effSummaryPrimary.getSummarySecondaries().add(effSummarySecondary);
				
				
				//Set Counter;
				effSummarySecondary.setCounter(1);
				effSummaryPrimaries.add(effSummaryPrimary);
				
			}else{
				List<EffSummarySecondary> effSummarySecondaries=effSummaryPrimary.getSummarySecondaries();
				EffSummarySecondary effSummarySecondary=getEffSummarySecondary(effSummarySecondaries,efficiency.getScode());
				if(effSummarySecondary==null){
					effSummarySecondary=new EffSummarySecondary();
					effSummarySecondary.setCode(efficiency.getScode());
					int hh=CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int mm=CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int total=(hh*60)+mm;
					effSummarySecondary.setTotalMin(total);
					effSummarySecondary.setHh(effSummarySecondary.getTotalMin()/60);
					effSummarySecondary.setMm(effSummarySecondary.getTotalMin()%60);
					effSummarySecondaries.add(effSummarySecondary);
					effSummarySecondary.setCounter(1);
					
					
				}else{
					int hh=CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int mm=CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int total=(hh*60)+mm;
					effSummarySecondary.setTotalMin(effSummarySecondary.getTotalMin()+total);
					effSummarySecondary.setHh(effSummarySecondary.getTotalMin()/60);
					effSummarySecondary.setMm(effSummarySecondary.getTotalMin()%60);
					
					effSummarySecondary.setCounter(effSummarySecondary.getCounter()+1);
				}
			}
		}
		
		for (EffSummaryPrimary effSummaryPrimary : effSummaryPrimaries) {
			int total=0;
			for (EffSummarySecondary effSummarySecondary : effSummaryPrimary.getSummarySecondaries()) {
				total+=effSummarySecondary.getTotalMin();
			}
			effSummaryPrimary.setTotalMin(total);
			effSummaryPrimary.setHh(total/60);
			effSummaryPrimary.setMm(total%60);
		}
		
		return effSummaryPrimaries;
	}

	/**
	 * @param effSummarySecondaries
	 * @param scode
	 * @return
	 */
	private EffSummarySecondary getEffSummarySecondary(
			List<EffSummarySecondary> effSummarySecondaries, String scode) {
		EffSummarySecondary effSummarySecondary=null;
		for (EffSummarySecondary ess : effSummarySecondaries) {
			if(ess.getCode().equals(scode)){
				effSummarySecondary=ess;
				break;
			}
		}
		return effSummarySecondary;
	}

	/**
	 * @param effSummaryPrimaries
	 * @param pcode
	 * @return
	 */
	private EffSummaryPrimary getEffSummaryPrimary(
			List<EffSummaryPrimary> effSummaryPrimaries, String pcode) {
		EffSummaryPrimary effSummaryPrimary=null;
		for (EffSummaryPrimary esp : effSummaryPrimaries) {
			if(esp.getCode().equals(pcode)){
				effSummaryPrimary=esp;
				break;
			}
		}
		return effSummaryPrimary;
	}
	
	/*
	 * @RequestMapping(value="/viewsummary",method=RequestMethod.GET)
	public String viewSummary(HttpServletRequest request,
	*/
	
	@RequestMapping(value="/byShift",method=RequestMethod.GET)
	public String efficiencyReportByShift(Model model){
		
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
	//	model.addAttribute("shift", "ALL");
		
		model.addAttribute("showFlag", false);
		
		return "efficiencyReportSummaryByShift";
	}
	
	@RequestMapping(value="/byShift/data",method=RequestMethod.GET)
	public String efficiencyReportByShiftData(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
		//	@RequestParam("shift")String shift,
			Model model) throws ParseException{
		
		List<EfficiencyShiftData> datas=null;
		List<EfficiencyShiftData> datas1=null;
		datas1=efficiencyService.getEfficiencyShiftData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat),"");
		
		
		final List<String> list1 = new ArrayList<String>();
		for (EfficiencyShiftData data : datas1) {
			list1.add(dateFormat.format(data.getDate()));
		}

		//Set<String> uniqueSet = new HashSet<String>(list1);
		for (String temp : list1) {
			//System.out.println(temp + ": " + Collections.frequency(list1, temp));
			
			Date currentDate=new Date();
			//System.out.println("currentDate::"+currentDate);
			if(temp.equals(dateFormat.format(currentDate))){
				
			}else{
				if(Collections.frequency(list1, temp)==1){
					
					datas = new ArrayList<EfficiencyShiftData>();
					EfficiencyShiftData cash = new EfficiencyShiftData();
					
					Date date = dateFormat.parse(temp);
					
					cash.setDate(date);
					//cash.setCrew("A");
					cash.setCrew("C");
					cash.setShift("");
					cash.setActualWt(0.0);
					cash.setSlabOff(0);
					cash.setWrapWhite(10.80);
					cash.setWrapRed(0);
					cash.setWrapRej(0);
					cash.setWrapTotal(10.80);
					cash.setVariance(0);
					cash.setVariancePer(0);
					//cash.setDowntime(0);//Here This Is Important Term
					//cash.setUptime(0.0);
					cash.setQuality(0);
					cash.setYield(0);
					cash.setEffTotal(100);
					datas.add(cash);
					
				}else{
					
				}
			}
			
		}
		
		List<EfficiencyShiftData> newList = new ArrayList<EfficiencyShiftData>();
		if(datas==null){
			
		}else{
			newList.addAll(datas);
		}
			newList.addAll(datas1);
		
		Collections.sort(newList, new Comparator<EfficiencyShiftData>() {
			  public int compare(EfficiencyShiftData o1, EfficiencyShiftData o2) {
			      return o1.getDate().compareTo(o2.getDate());
			  }
			});
		
		
		model.addAttribute("datas", newList);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
	//	model.addAttribute("shift", shift);
		model.addAttribute("showFlag", true);
		model.addAttribute("aData", new EfficiencyShiftData().totalA(newList));
		model.addAttribute("bData", new EfficiencyShiftData().totalB(newList));
		model.addAttribute("cData", new EfficiencyShiftData().totalC(newList));
		model.addAttribute("dData", new EfficiencyShiftData().totalD(newList));
		model.addAttribute("totalData", new EfficiencyShiftData().total(newList));
		
		
		
		//model.addAttribute("nightData", new EfficiencyShiftData().totalNight(datas));
		
		
		
		return "efficiencyReportSummaryByShift";
	}
	
	@RequestMapping(value="/byShift/exoprt",method=RequestMethod.POST)
	public void efficiencyReportByShiftExport(@RequestParam("sDate")String sDate,
			@RequestParam("eDate")String eDate,
			@RequestParam("sht")String sht,
			HttpServletResponse response) throws IOException, ParseException{
		
		
		List<EfficiencyShiftData> datas1=null;
		List<EfficiencyShiftData> datas=null;
		datas1=efficiencyService.getEfficiencyShiftData(CommonUtil.checkDate(sDate, dateFormat),CommonUtil.checkDate(eDate, dateFormat),sht);
		

		final List<String> list1 = new ArrayList<String>();
		for (EfficiencyShiftData data : datas1) {
			list1.add(dateFormat.format(data.getDate()));
		}

		//Set<String> uniqueSet = new HashSet<String>(list1);
		for (String temp : list1) {
			//System.out.println(temp + ": " + Collections.frequency(list1, temp));
			
			Date currentDate=new Date();
			//System.out.println("currentDate::"+currentDate);
			if(temp.equals(dateFormat.format(currentDate))){
				
			}else{
				if(Collections.frequency(list1, temp)==1){
					
					datas = new ArrayList<EfficiencyShiftData>();
					EfficiencyShiftData cash = new EfficiencyShiftData();
					
					Date date = dateFormat.parse(temp);
					
					cash.setDate(date);
					//cash.setCrew("A");
					cash.setCrew("C");
					cash.setShift("");
					cash.setActualWt(0.0);
					cash.setSlabOff(0);
					cash.setWrapWhite(10.80);
					cash.setWrapRed(0);
					cash.setWrapRej(0);
					cash.setWrapTotal(10.80);
					cash.setVariance(0);
					cash.setVariancePer(0);
					//cash.setDowntime(0);//Here This Is Important Term
					//cash.setUptime(0.0);
					cash.setQuality(0);
					cash.setYield(0);
					cash.setEffTotal(100);
					datas.add(cash);
					
				}else{
					
				}
			}
			
		}
		
		List<EfficiencyShiftData> newList = new ArrayList<EfficiencyShiftData>();
		if(datas==null){
			
		}else{
			newList.addAll(datas);
		}
		newList.addAll(datas1);
		
		Collections.sort(newList, new Comparator<EfficiencyShiftData>() {
			  public int compare(EfficiencyShiftData o1, EfficiencyShiftData o2) {
			      return o1.getDate().compareTo(o2.getDate());
			  }
			});
		
		
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Efficiency_Shift_Report.xlsx");
		
		reportHandler.createEfficiencyShiftReport(newList,response.getOutputStream());
		
	}
	
	@RequestMapping(value="/byShift/email",method=RequestMethod.POST)
	public @ResponseBody boolean efficiencyReportByShiftEmail() throws IOException{
		
		try {
			efficiencyAutoMailer.sendEfficiencyByShiftMail();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
		
	}
	//Code Starts From Here Done By Roshan Tailor Date :-11/23/2015
	@RequestMapping(value="/byDcs",method=RequestMethod.GET)
	public String efficiencyReportByDCSView(Model model){
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		//model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("showFlag", false);
		model.addAttribute("shifts", WinderBreakMonitoringComman.getShift());
		return "efficiencyReportSummaryByDCS";
	}
	
	@RequestMapping(value="/byDcs/save",method=RequestMethod.POST)
	public String efficiencyReportByDCSData(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes){
		
		//final BarcodeComman barcodeComman=new BarcodeComman();
		final EfficiencyShiftData eSD= new EfficiencyShiftData();
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		System.out.println("sdate::"+sdate);
		
		String shift=CommonUtil.checkNull(request.getParameter("shift"));
		double tons=CommonUtil.checkDouble(request.getParameter("tons"));
		
		System.out.println(sdate);
		System.out.println(shift);
		System.out.println(CommonUtil.round(tons, 2));
		
		List<EfficiencyShiftData> checkTon=efficiencyService.checkTonPresentOrNot(sdate,shift);
		if(checkTon.size()>0){
			
			redirectAttributes.addFlashAttribute("message", "You Have Already Done The Entry For This Date And Shift.");
			redirectAttributes.addFlashAttribute("checkTon", checkTon);
			redirectAttributes.addFlashAttribute("checkTonResult", true);
			
			return "redirect:/efficiencyreport/byDcs";
		}else{
			eSD.setDate(sdate);
			eSD.setShift(shift);
			eSD.setActualWt(tons);
			
			Map<String , Object> map=new HashMap<String,Object>();
			try{
				
				int key=efficiencyService.saveDCSData(eSD);
				map.put("id", key);
				map.put("status", true);
				model.addAttribute("message", "Data Saved Successfully");
				
			}catch(Exception rlt){
				rlt.printStackTrace();
			}
			redirectAttributes.addFlashAttribute("message", "Data saved successfully.");
			return "redirect:/efficiencyreport/byDcs";
		}
		
		
	}
	
	//Code Ends Here Done By Roshan Tailor
	
	@RequestMapping(value="/byDcs/report",method=RequestMethod.GET)
	public String efficiencyReportByDCSReport(Model model){
		
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("showFlag", false);
		
		return "efficiencyReportSummaryByDCSReport";
	}
	
	
	@RequestMapping(value="/byDcs/report/view",method=RequestMethod.GET)
	public String efficiencyReportByDCSReportView(@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
		//	@RequestParam("shift")String shift,
			Model model) throws ParseException{
		
		List<EfficiencyShiftData> datas=efficiencyService.getEfficiencyShiftData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat),"");
		List<EfficiencyShiftData> datas1=efficiencyService.getEfficiencyDCSDataReport(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		for(EfficiencyShiftData outdata : datas){
			//Date date1=(Date)sdf.parse(""+outdata.getDate());
			Date date1 = new Date();
			date1=outdata.getDate();
			//System.out.println("Date1::"+date1);
			String shift1=outdata.getShift();
			for(EfficiencyShiftData innerdata : datas1){
					//Date date2=(Date)sdf.parse(""+innerdata.getDate());
					Date date2 = new Date();
					date2=innerdata.getDate();
					//System.out.println("Date2::"+date2);
					String shift2=innerdata.getShift();
					int results = date1.compareTo(date2);
					
					if(results > 0){
						
					}else if(results < 0){
						
					}else {
						if(shift1.equalsIgnoreCase(shift2)){
							//System.out.println("Shift And Date Are Equals");
							double actualTon=innerdata.getActualWt();
							//System.out.println("actualTon::"+actualTon);
							outdata.setActualWt(actualTon);
						}else{
							
						}
					}
			}
		}
		model.addAttribute("datas", datas);
		model.addAttribute("datas1", datas1);
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("showFlag", true);
		model.addAttribute("aData", new EfficiencyShiftData().totalA(datas));
		model.addAttribute("bData", new EfficiencyShiftData().totalB(datas));
		model.addAttribute("cData", new EfficiencyShiftData().totalC(datas));
		model.addAttribute("dData", new EfficiencyShiftData().totalD(datas));
		model.addAttribute("totalData", new EfficiencyShiftData().total(datas));
		
		
		return "efficiencyReportSummaryByDCSReport";
	}
	@RequestMapping(value="/byDcs/report/export",method=RequestMethod.POST)
	public void byEfficiencyDCSReportExport(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws Exception{
		
		List<EfficiencyShiftData> datas=efficiencyService.getEfficiencyShiftData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat),"");
		List<EfficiencyShiftData> datas1=efficiencyService.getEfficiencyDCSDataReport(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		for(EfficiencyShiftData outdata : datas){
			//Date date1=(Date)sdf.parse(""+outdata.getDate());
			Date date1 = new Date();
			date1=outdata.getDate();
			//System.out.println("Date1::"+date1);
			String shift1=outdata.getShift();
			for(EfficiencyShiftData innerdata : datas1){
					//Date date2=(Date)sdf.parse(""+innerdata.getDate());
					Date date2 = new Date();
					date2=innerdata.getDate();
					//System.out.println("Date2::"+date2);
					String shift2=innerdata.getShift();
					int results = date1.compareTo(date2);
					
					if(results > 0){
						
					}else if(results < 0){
						
					}else {
						if(shift1.equalsIgnoreCase(shift2)){
							System.out.println("Shift And Date Are Equals");
							double actualTon=innerdata.getActualWt();
							outdata.setActualWt(actualTon);
						}else{
							
						}
					}
			}
		}
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Efficiency Summary By Shift - DCS.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/Efficiency Summary By Shift - DCS.xlsx");
		
		efficiencyreportbydcshandler.getByEfficiencyDCSReportExport(datas,datas1,file,response.getOutputStream());
		}
	@RequestMapping(value="/byDcs/edit/{id}",method=RequestMethod.GET)
	public String Edit(@PathVariable("id")int id,HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
	List<EfficiencyShiftData> reportDataEdit=efficiencyService.editDCSReport(id);
	model.addAttribute("reportDataEdit", reportDataEdit);
	model.addAttribute("editForEdit", id);
	model.addAttribute("edit", true);
	model.addAttribute("sdate", dateFormat.format(new Date()));
	return"efficiencyReportSummaryByDCS";
}
	@RequestMapping(value="/byDcs/editton",method=RequestMethod.POST)
	public String editDCSTon(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes){
		
		//final BarcodeComman barcodeComman=new BarcodeComman();
		final EfficiencyShiftData eSD= new EfficiencyShiftData();
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		int id=CommonUtil.checkInt(request.getParameter("id"));
		String shift=CommonUtil.checkNull(request.getParameter("shift"));
		double tons=CommonUtil.checkDouble(request.getParameter("tons"));
		
		System.out.println(id);
		System.out.println(sdate);
		System.out.println(shift);
		System.out.println(tons);
		
			eSD.setId(id);
			eSD.setDate(sdate);
			eSD.setShift(shift);
			eSD.setActualWt(tons);
			
			Map<String , Object> map=new HashMap<String,Object>();
			try{
				
				efficiencyService.updateDCSData(eSD);
			}catch(Exception rlt){
				rlt.printStackTrace();
			}
			redirectAttributes.addFlashAttribute("message", "Data Updated successfully.");
			return "redirect:/efficiencyreport/byDcs";
		}
		
}
