/**
 * 
 */
package com.st.safetylog.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.common.CommonUtil;
import com.st.safetylog.model.SafetyLog;
import com.st.safetylog.service.SafetyLogService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/safetylogreport")
public class SafetyLogReportController {

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private SafetyLogService safetyLogService;
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	@RequestMapping(value="/view" ,method=RequestMethod.GET)
	public String view(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("showFlag", false);
		
		return "safetylog/safetyLogView";
	}
	
	
	
	@RequestMapping(value="/view/{sdate}/{edate}" ,method=RequestMethod.GET)
	public String viewData(@PathVariable("sdate")String sdate,@PathVariable("edate")String edate,Model model) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("showFlag", true);
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<SafetyLog> safetyLogs=safetyLogService.getSafetyLogs(sDate,eDate);
		model.addAttribute("safetyLogs", safetyLogs);
		
		return "safetylog/safetyLogView";
	}
	
	@RequestMapping(value="/view2" ,method=RequestMethod.GET)
	public String view2(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("showFlag", false);
		
		return "safetylog/safetyLogView2";
	}
	
	@RequestMapping(value="/view2/{sdate}/{edate}" ,method=RequestMethod.GET)
	public String viewData2(@PathVariable("sdate")String sdate,@PathVariable("edate")String edate,Model model) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("showFlag", true);
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<SafetyLog> safetyLogs=safetyLogService.getSafetyLogs(sDate,eDate);
		model.addAttribute("safetyLogs", safetyLogs);
		
		return "safetylog/safetyLogView2";
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
		
		List<SafetyLog> safetyLogs=safetyLogService.getSafetyLogs(sdate,edate);
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=ST Tissue Safety Log-Report.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/safetylog/SafetyLogData.xls");

		HSSFWorkbook workbook=getFormatedWorkbook(file,safetyLogs);
		workbook.write(response.getOutputStream());

	}

	@RequestMapping(value="/export2",method=RequestMethod.POST)
	public void export2(HttpServletRequest request,
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
		
		List<SafetyLog> safetyLogs=safetyLogService.getSafetyLogs(sdate,edate);
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=ST Tissue Safety Log-Report.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/safetylog/SafetyLogData2.xls");

		HSSFWorkbook workbook=getFormatedWorkbook2(file,safetyLogs);
		workbook.write(response.getOutputStream());

	}


	/**
	 * @param file
	 * @param safetyLogs 
	 * @return
	 * @throws IOException 
	 */
	private HSSFWorkbook getFormatedWorkbook(File file, List<SafetyLog> safetyLogs) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		FileInputStream inputStream=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
		
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
		
		Font fontRow2=workbook.createFont();
		fontRow2.setBold(false);
		fontRow2.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle rowCellStyle2=workbook.createCellStyle();
		rowCellStyle2.setBorderBottom(BorderStyle.THIN);
		rowCellStyle2.setBorderLeft(BorderStyle.THIN);
		rowCellStyle2.setBorderRight(BorderStyle.THIN);
		rowCellStyle2.setBorderTop(BorderStyle.THIN);
		rowCellStyle2.setFont(fontRow2);
		rowCellStyle2.setAlignment(HorizontalAlignment.CENTER);
		rowCellStyle2.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle2.setWrapText(true);
		
		
		int rowCount=1;
		
		int forkliftShutdown=0;
		int propertyDamage=0;
		int unsafeWork=0;
		int fire=0;
		int nearMiss=0;
		int firstAid=0;
		int recordable=0;
		int lostTime=0;
		int other=0;
		
		for (SafetyLog safetyLog : safetyLogs) {
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)300);
			
			HSSFCell cell01=row.createCell(0);
			HSSFCell cell02=row.createCell(1);
			HSSFCell cell03=row.createCell(2);
			HSSFCell cell04=row.createCell(3);
			HSSFCell cell05=row.createCell(4);
			HSSFCell cell06=row.createCell(5);
			HSSFCell cell07=row.createCell(6);
			HSSFCell cell08=row.createCell(7);
			HSSFCell cell09=row.createCell(8);
			HSSFCell cell10=row.createCell(9);
			HSSFCell cell11=row.createCell(10);
			HSSFCell cell12=row.createCell(11);
			HSSFCell cell13=row.createCell(12);
			HSSFCell cell14=row.createCell(13);
			HSSFCell cell15=row.createCell(14);
			HSSFCell cell16=row.createCell(15);
			
			cell01.setCellStyle(rowCellStyle2);
			cell02.setCellStyle(rowCellStyle2);
			cell03.setCellStyle(rowCellStyle2);
			cell04.setCellStyle(rowCellStyle2);
			cell05.setCellStyle(rowCellStyle2);
			cell06.setCellStyle(rowCellStyle2);
			cell07.setCellStyle(rowCellStyle2);
			cell08.setCellStyle(rowCellStyle2);
			cell09.setCellStyle(rowCellStyle2);
			cell10.setCellStyle(rowCellStyle2);
			cell11.setCellStyle(rowCellStyle2);
			cell12.setCellStyle(rowCellStyle2);
			cell13.setCellStyle(rowCellStyle2);
			cell14.setCellStyle(rowCellStyle2);
			
			cell15.setCellStyle(rowCellStyle2);
			cell16.setCellStyle(rowCellStyle2);
			
			cell01.setCellValue(dateFormat.format(safetyLog.getDate()));
			cell02.setCellValue(safetyLog.getDescription()==null?"":safetyLog.getDescription());
			cell03.setCellValue(safetyLog.getEmployee()==null?"":safetyLog.getEmployee());
			
			cell04.setCellValue(safetyLog.getActionitems()==null?"":safetyLog.getActionitems());
			cell05.setCellValue(safetyLog.getCategoryofincidents()==null?"":safetyLog.getCategoryofincidents());
			
			if(safetyLog.getForkliftShutdown()>0){
				cell06.setCellValue(safetyLog.getForkliftShutdown());
			}else{
				cell06.setCellValue("");
			}
			forkliftShutdown+=safetyLog.getForkliftShutdown();
			
			if(safetyLog.getPropertyDamage()>0){
				cell07.setCellValue(safetyLog.getPropertyDamage());
			}else{
				cell07.setCellValue("");
			}
			propertyDamage+=safetyLog.getPropertyDamage();
			
			if(safetyLog.getUnsafeWork()>0){
				cell08.setCellValue(safetyLog.getUnsafeWork());
			}else{
				cell08.setCellValue("");
			}
			unsafeWork+=safetyLog.getUnsafeWork();
			
			if(safetyLog.getFire()>0){
				cell09.setCellValue(safetyLog.getFire());
			}else{
				cell09.setCellValue("");
			}
			fire+=safetyLog.getFire();
			
			if(safetyLog.getNearMiss()>0){
				cell10.setCellValue(safetyLog.getNearMiss());
			}else{
				cell10.setCellValue("");
			}
			nearMiss+=safetyLog.getNearMiss();
			
			if(safetyLog.getFirstAid()>0){
				cell11.setCellValue(safetyLog.getFirstAid());
			}else{
				cell11.setCellValue("");
			}
			firstAid+=safetyLog.getFirstAid();
			
			if(safetyLog.getRecordable()>0){
				cell12.setCellValue(safetyLog.getRecordable());
			}else{
				cell12.setCellValue("");
			}
			recordable+=safetyLog.getRecordable();
			
			if(safetyLog.getLostTime()>0){
				cell13.setCellValue(safetyLog.getLostTime());
			}else{
				cell13.setCellValue("");
			}
			lostTime+=safetyLog.getLostTime();
			
			if(safetyLog.getOther()>0){
				cell14.setCellValue(safetyLog.getOther());
			}else{
				cell14.setCellValue("");
			}
			other+=safetyLog.getOther();
			
			cell15.setCellValue(safetyLog.getArea()==null?"":safetyLog.getArea());
			cell16.setCellValue(safetyLog.getRemarks()==null?"":safetyLog.getRemarks());
			
		}
		{
			HSSFRow row=sheet.createRow(rowCount++);
			
			HSSFCell cell01=row.createCell(0);
			HSSFCell cell02=row.createCell(1);
			HSSFCell cell03=row.createCell(2);
			HSSFCell cell04=row.createCell(3);
			HSSFCell cell05=row.createCell(4);
			HSSFCell cell06=row.createCell(5);
			HSSFCell cell07=row.createCell(6);
			HSSFCell cell08=row.createCell(7);
			HSSFCell cell09=row.createCell(8);
			HSSFCell cell10=row.createCell(9);
			HSSFCell cell11=row.createCell(10);
			HSSFCell cell12=row.createCell(11);
			HSSFCell cell13=row.createCell(12);
			HSSFCell cell14=row.createCell(13);
			HSSFCell cell15=row.createCell(14);
			HSSFCell cell16=row.createCell(15);
			
			cell01.setCellStyle(rowCellStyle);
			cell02.setCellStyle(rowCellStyle);
			cell03.setCellStyle(rowCellStyle);
			cell04.setCellStyle(rowCellStyle);
			cell05.setCellStyle(rowCellStyle);
			cell06.setCellStyle(rowCellStyle);
			cell07.setCellStyle(rowCellStyle);
			cell08.setCellStyle(rowCellStyle);
			cell09.setCellStyle(rowCellStyle);
			cell10.setCellStyle(rowCellStyle);
			cell11.setCellStyle(rowCellStyle);
			cell12.setCellStyle(rowCellStyle);
			cell13.setCellStyle(rowCellStyle);
			cell14.setCellStyle(rowCellStyle);
			
			cell01.setCellValue("");
			cell02.setCellValue("");
			cell03.setCellValue("");
			cell04.setCellValue("");
			cell05.setCellValue("TOTAL");
			
			cell06.setCellValue(forkliftShutdown);
			cell07.setCellValue(propertyDamage);
			cell08.setCellValue(unsafeWork);
			cell09.setCellValue(fire);
			cell10.setCellValue(nearMiss);
			cell11.setCellValue(firstAid);
			cell12.setCellValue(recordable);
			cell13.setCellValue(lostTime);
			cell14.setCellValue(other);
			cell15.setCellValue("");
			cell16.setCellValue("");
		
		}
		return workbook;
	}
	
	private HSSFWorkbook getFormatedWorkbook2(File file, List<SafetyLog> safetyLogs) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		FileInputStream inputStream=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
		
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
		
		Font fontRow2=workbook.createFont();
		fontRow2.setBold(false);
		fontRow2.setColor(IndexedColors.BLACK.getIndex());
		HSSFCellStyle rowCellStyle2=workbook.createCellStyle();
		rowCellStyle2.setBorderBottom(BorderStyle.THIN);
		rowCellStyle2.setBorderLeft(BorderStyle.THIN);
		rowCellStyle2.setBorderRight(BorderStyle.THIN);
		rowCellStyle2.setBorderTop(BorderStyle.THIN);
		rowCellStyle2.setFont(fontRow2);
		rowCellStyle2.setAlignment(HorizontalAlignment.CENTER);
		rowCellStyle2.setVerticalAlignment(VerticalAlignment.TOP);
		rowCellStyle2.setWrapText(true);
		
		
		int rowCount=1;
		
		for (SafetyLog safetyLog : safetyLogs) {
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)300);
			
			HSSFCell cell01=row.createCell(0);
			HSSFCell cell02=row.createCell(1);
			HSSFCell cell03=row.createCell(2);
			HSSFCell cell04=row.createCell(3);
			HSSFCell cell05=row.createCell(4);
			HSSFCell cell06=row.createCell(5);
			HSSFCell cell07=row.createCell(6);

			
			cell01.setCellStyle(rowCellStyle2);
			cell02.setCellStyle(rowCellStyle2);
			cell03.setCellStyle(rowCellStyle2);
			cell04.setCellStyle(rowCellStyle2);
			cell05.setCellStyle(rowCellStyle2);
			cell06.setCellStyle(rowCellStyle2);
			cell07.setCellStyle(rowCellStyle2);
			
			cell01.setCellValue(dateFormat.format(safetyLog.getDate()));
			if(safetyLog.getIncidentDate()!=null){
				cell02.setCellValue(dateFormat.format(safetyLog.getIncidentDate()));
				cell03.setCellValue(safetyLog.getDaysToReport());
			}else{
				cell02.setCellValue("");
				cell03.setCellValue("");
			}
			
			cell04.setCellValue(safetyLog.getDescription()==null?"":safetyLog.getDescription());
			cell05.setCellValue(safetyLog.getNumOfdays());
			cell06.setCellValue(safetyLog.getEmployee()==null?"":safetyLog.getEmployee());
			cell07.setCellValue(safetyLog.getArea()==null?"":safetyLog.getArea());
			
			
		}
		
		return workbook;
	}
	
}
