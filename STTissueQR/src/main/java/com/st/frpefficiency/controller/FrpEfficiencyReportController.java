/**
 * 
 */
package com.st.frpefficiency.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.common.Columns;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.frpefficiency.model.FrpEffSummaryPrimary;
import com.st.frpefficiency.model.FrpEffSummarySecondary;
import com.st.frpefficiency.model.FrpEfficiency;
import com.st.frpefficiency.model.FrpPrimaryCode;
import com.st.frpefficiency.model.FrpSecondaryCode;
import com.st.frpefficiency.service.FrpEfficiencyCodeService;
import com.st.frpefficiency.service.FrpEfficiencyService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/frpefficiencyreport")
public class FrpEfficiencyReportController {
	
	//private static Logger logger=LoggerFactory.getLogger(EfficencyReportController.class);

	@Autowired
	private ServletContext context;
	

	@Autowired
	private FrpEfficiencyCodeService frpEfficiencyCodeService;
	@Autowired
	private FrpEfficiencyService frpEfficiencyService;
	
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Model model) {
		Calendar calendar=Calendar.getInstance();
		model.addAttribute("sdate", dateFormat.format(calendar.getTime()));
		model.addAttribute("edate", dateFormat.format(calendar.getTime()));
		
		model.addAttribute("pcodes", frpEfficiencyCodeService.getPrimaryCodes());
		model.addAttribute("scodes", frpEfficiencyCodeService.getSecondaryCodes());
		model.addAttribute("showTable", false);
		
		return "frpEfficiencyReport";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(HttpServletRequest request,
			HttpServletResponse response,
			RedirectAttributes redirectAttributes,
			Model model) {
		
		
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		if(sdate==null){
			redirectAttributes.addFlashAttribute("error", "Invalid start date");
			return "redirect:/frpefficiencyreport/main";
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
			return "redirect:/frpefficiencyreport/main";
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
		model.addAttribute("pcodes", frpEfficiencyCodeService.getPrimaryCodes());
		model.addAttribute("scodes", frpEfficiencyCodeService.getSecondaryCodes());
		model.addAttribute("pcode", pcode);
		model.addAttribute("scode", scode);
		model.addAttribute("showTable", true);
		
		FrpEfficiency efficiency=new FrpEfficiency();
		efficiency.setStartDate(scal.getTime());
		efficiency.setEndDate(ecal.getTime());
		efficiency.setPcode(pcode);
		efficiency.setScode(scode);
		
		List<Map<String, Object>> datas=new ArrayList<>();
		List<FrpEfficiency> efficiencies=frpEfficiencyService.getEfficiencies(efficiency);
		
		int hh=0;
		int mm=0;
		for (FrpEfficiency efficiency2 : efficiencies) {
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
				
		return "frpEfficiencyReport";
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
		model.addAttribute("pcodes", frpEfficiencyCodeService.getPrimaryCodes());
		model.addAttribute("scodes", frpEfficiencyCodeService.getSecondaryCodes());
		model.addAttribute("pcode", pcode);
		model.addAttribute("scode", scode);
		model.addAttribute("showTable", true);
		
		FrpEfficiency efficiency=new FrpEfficiency();
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
		List<FrpEfficiency> efficiencies=frpEfficiencyService.getEfficiencies(efficiency);
		
		
		datas=formatData(efficiencies);
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=ST FRP-Efficiency-Report.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/FRP Efficiency Report.xls");

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
			
			HSSFCell COL_12=row.createCell(Columns.COL_06);
			COL_12.setCellStyle(rowCellStyle);
			COL_12.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString()));
			
			
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
		
		return workbook;
	}

	/**
	 * @param efficiencies
	 * @return
	 */
	private List<Map<String, Object>> formatData(List<FrpEfficiency> efficiencies) {
		
		
		
		
		List<Map<String, Object>> datas=new ArrayList<>();
		
		for (FrpEfficiency efficiency : efficiencies) {
			Map<String, Object> map=new HashMap<String, Object>(); 
			map.put(ColumnsOfTable.COL_01, efficiency.getId());
			map.put(ColumnsOfTable.COL_02, dateFormat.format(efficiency.getDate()));
			map.put(ColumnsOfTable.COL_03, efficiency.getShift());
			map.put(ColumnsOfTable.COL_04, efficiency.getCrew());
			map.put(ColumnsOfTable.COL_05, timeFormat.format(efficiency.getStartTime()));
			map.put(ColumnsOfTable.COL_06, timeFormat.format(efficiency.getEndTime()));
			map.put(ColumnsOfTable.COL_07, efficiency.getBatchNo());
			
			String grade=efficiency.getGrade();
			if(grade!=null & !(grade.trim().equals(""))){
				grade=FrpCommon.getGrade().get(grade);
			}
			
			map.put(ColumnsOfTable.COL_08, grade);
			map.put(ColumnsOfTable.COL_09, efficiency.getComment());
			FrpSecondaryCode secondaryCode=efficiency.getSecondaryCode();
			FrpPrimaryCode primaryCode=null;
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

	
	@RequestMapping(value="/summary", method=RequestMethod.GET)
	public String mainSummary(Model model) {
		Calendar calendar=Calendar.getInstance();
		model.addAttribute("sdate", dateFormat.format(calendar.getTime()));
		model.addAttribute("edate", dateFormat.format(calendar.getTime()));
		
	//	model.addAttribute("pcodes", efficiencyCodeService.getPrimaryCodes());
	//	model.addAttribute("scodes", efficiencyCodeService.getSecondaryCodes());
		model.addAttribute("showTable", false);
		
		return "frpEfficiencySummaryReport";
	}
	
	@RequestMapping(value="/viewsummary",method=RequestMethod.GET)
	public String viewSummary(HttpServletRequest request,
			HttpServletResponse response,
			RedirectAttributes redirectAttributes,
			Model model) {
		
		
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		if(sdate==null){
			redirectAttributes.addFlashAttribute("error", "Invalid start date");
			return "redirect:/frpefficiencyreport/summary";
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
			return "redirect:/frpefficiencyreport/summary";
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
		model.addAttribute("pcodes", frpEfficiencyCodeService.getPrimaryCodes());
		model.addAttribute("scodes", frpEfficiencyCodeService.getSecondaryCodes());
		model.addAttribute("pcode", pcode);
		model.addAttribute("scode", scode);
		model.addAttribute("showTable", true);
		
		
		Map<String, Object> datas=new HashMap<>();
	
		List<FrpEffSummaryPrimary> summaryPrimaries=new ArrayList<>();
		try {
			summaryPrimaries=formatSummaryData(scal.getTime(),ecal.getTime(),pcode,scode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		int totalmin=0;
		for (FrpEffSummaryPrimary effSummaryPrimary : summaryPrimaries) {
			totalmin+=effSummaryPrimary.getTotalMin();
		}
		datas.put("summaryPrimaries", summaryPrimaries);
		datas.put("hh", totalmin/60);
		datas.put("mm", totalmin%60);
		
		
		model.addAttribute("datas", datas);
				
		return "frpEfficiencySummaryReport";
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
		List<FrpEffSummaryPrimary> summaryPrimaries=new ArrayList<>();
		try {
			summaryPrimaries=formatSummaryData(scal.getTime(),ecal.getTime(),pcode,scode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		int totalmin=0;
		for (FrpEffSummaryPrimary effSummaryPrimary : summaryPrimaries) {
			totalmin+=effSummaryPrimary.getTotalMin();
		}
		datas.put("summaryPrimaries", summaryPrimaries);
		datas.put("hh", totalmin/60);
		datas.put("mm", totalmin%60);
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=FRP Efficiency Summary-Report.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/FRP Efficiency Summary Report.xls");

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
		rowCellStyle.setAlignment(HorizontalAlignment.LEFT);
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
		List<FrpEffSummaryPrimary> effSummaryPrimaries=(List<FrpEffSummaryPrimary>) datas.get("summaryPrimaries");
		for (FrpEffSummaryPrimary effSummaryPrimary : effSummaryPrimaries) {
			
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			HSSFCell pCodeCell=row.createCell(0);
			pCodeCell.setCellStyle(rowCellStyle);
			pCodeCell.setCellValue(effSummaryPrimary.getCode());
			
			row.createCell(1).setCellStyle(rowCellStyle);
			row.createCell(2).setCellStyle(rowCellStyle);
			
			List<FrpEffSummarySecondary> effSummarySecondaries=effSummaryPrimary.getSummarySecondaries();
			for (FrpEffSummarySecondary effSummarySecondary : effSummarySecondaries) {
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

	private List<FrpEffSummaryPrimary> formatSummaryData(Date sdate, Date edate,int pcode,int scode) {
		

		
		List<FrpEfficiency> efficiencies=frpEfficiencyCodeService.getSummaryData(sdate,edate,pcode,scode);
		
		List<FrpEffSummaryPrimary> effSummaryPrimaries=new ArrayList<>();
		
		for (FrpEfficiency efficiency : efficiencies) {
			FrpEffSummaryPrimary effSummaryPrimary=getEffSummaryPrimary(effSummaryPrimaries,efficiency.getPcode());
			if(effSummaryPrimary==null){
				effSummaryPrimary=new FrpEffSummaryPrimary();
				effSummaryPrimary.setCode(efficiency.getPcode());
				
				
				//Secondary code
				FrpEffSummarySecondary effSummarySecondary=new FrpEffSummarySecondary();
				effSummarySecondary.setCode(efficiency.getScode());
				int hh=CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
				int mm=CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
				int total=(hh*60)+mm;
				effSummarySecondary.setTotalMin(total);
				effSummarySecondary.setHh(effSummarySecondary.getTotalMin()/60);
				effSummarySecondary.setMm(effSummarySecondary.getTotalMin()%60);
				effSummaryPrimary.getSummarySecondaries().add(effSummarySecondary);
				
				effSummarySecondary.setCounter(1);
				
				effSummaryPrimaries.add(effSummaryPrimary);
			}else{
				List<FrpEffSummarySecondary> effSummarySecondaries=effSummaryPrimary.getSummarySecondaries();
				FrpEffSummarySecondary effSummarySecondary=getEffSummarySecondary(effSummarySecondaries,efficiency.getScode());
				if(effSummarySecondary==null){
					effSummarySecondary=new FrpEffSummarySecondary();
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
		
		for (FrpEffSummaryPrimary effSummaryPrimary : effSummaryPrimaries) {
			int total=0;
			for (FrpEffSummarySecondary effSummarySecondary : effSummaryPrimary.getSummarySecondaries()) {
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
	private FrpEffSummarySecondary getEffSummarySecondary(
			List<FrpEffSummarySecondary> effSummarySecondaries, String scode) {
		FrpEffSummarySecondary effSummarySecondary=null;
		for (FrpEffSummarySecondary ess : effSummarySecondaries) {
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
	private FrpEffSummaryPrimary getEffSummaryPrimary(
			List<FrpEffSummaryPrimary> effSummaryPrimaries, String pcode) {
		FrpEffSummaryPrimary effSummaryPrimary=null;
		for (FrpEffSummaryPrimary esp : effSummaryPrimaries) {
			if(esp.getCode().equals(pcode)){
				effSummaryPrimary=esp;
				break;
			}
		}
		return effSummaryPrimary;
	}
	
}
