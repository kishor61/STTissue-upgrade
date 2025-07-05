/**
 * 
 */
package com.st.frpprojection.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.common.WorkbookUtil;
import com.st.frpprojection.model.FrpProjection;
import com.st.frpprojection.model.FrpProjectionData;
import com.st.frpprojection.service.FrpProjectionService;
import com.st.tracker.model.ProjectionData;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/fiberpurchasingreport")
public class FiberPurchasingReportController {
	
	@Autowired
	private FrpProjectionService frpProjectionService;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private ServletContext context;
	
	
	@RequestMapping(value="/view" ,method=RequestMethod.GET)
	public String view(HttpServletRequest request,Model model) {
		
		CommonUtil.save(CommonUtil.FIBER_PURCHASING_PAGE, request.getRequestURI());
		model.addAttribute(CommonUtil.FIBER_PURCHASING_PAGE, request.getRequestURI());
		
		model.addAttribute("frpgrade", FrpCommon.getGrade());
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("showFlag", false);
		
		return "frp/fiberPurchasingView";
	}
	
	@RequestMapping(value="/view/white" ,method=RequestMethod.GET)
	public String viewWhite(HttpServletRequest request,Model model) {
		
		CommonUtil.save(CommonUtil.FIBER_PURCHASING_PAGE_WHITE, request.getRequestURI());
		model.addAttribute(CommonUtil.FIBER_PURCHASING_PAGE_WHITE, request.getRequestURI());
		
		model.addAttribute("frpgrade", FrpCommon.getGrade());
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("showFlag", false);
		
		return "frp/fiberPurchasingView_white";
	}
	
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String viewData(HttpServletRequest request,Model model) {
		
		
		CommonUtil.save(CommonUtil.FIBER_PURCHASING_PAGE, request.getRequestURI()+"?"+request.getQueryString());
		model.addAttribute(CommonUtil.FIBER_PURCHASING_PAGE, request.getRequestURI()+"?"+request.getQueryString());
		
		
		//String type=CommonUtil.checkNull(request.getParameter("type"));
		String dateS=CommonUtil.checkNull(request.getParameter("sdate"));
		String dateE=CommonUtil.checkNull(request.getParameter("edate"));
		//String oldtype=CommonUtil.checkNull(request.getParameter("oldtype"));
		String temp=CommonUtil.checkNull(request.getParameter("r"));
		
		List<String> productIds=new ArrayList<>();
		if(request.getParameterValues("pid[]")!=null){
			productIds=new ArrayList<>(Arrays.asList(request.getParameterValues("pid[]")));	
		}
		/*if(!(oldtype.equals(type))&& productIds.size()>0){
			productIds.clear();
		}
		oldtype=type;*/
	
		
		Date sdate=CommonUtil.checkDate(dateS, dateFormat);
		Date edate=CommonUtil.checkDate(dateE, dateFormat);
		
		model.addAttribute("frpgrade", FrpCommon.getGrade());
		model.addAttribute("frpgradetype", FrpCommon.getGradeType());
		
		//model.addAttribute("type", type);
		//model.addAttribute("oldtype", oldtype);
		
		model.addAttribute("sdate", dateS);
		model.addAttribute("edate", dateE);
		model.addAttribute("showFlag", true);
		model.addAttribute("productIds", productIds);
		
		
		//Projection
		List<FrpProjection> projections=frpProjectionService.getProjectionFormulae();
		model.addAttribute("projections", projections);
		
		FrpProjectionData projectionData=frpProjectionService.getFiberPurchasingData(sdate,edate,productIds,temp);
		
		model.addAttribute("projectionData", projectionData);
		
		
		return "frp/fiberPurchasingView";
	}
	
	@RequestMapping(value="/view/data/white",method=RequestMethod.GET)
	public String viewDataWhite(HttpServletRequest request,Model model) {
		
		
		CommonUtil.save(CommonUtil.FIBER_PURCHASING_PAGE_WHITE, request.getRequestURI()+"?"+request.getQueryString());
		model.addAttribute(CommonUtil.FIBER_PURCHASING_PAGE_WHITE, request.getRequestURI()+"?"+request.getQueryString());
		
		
		//String type=CommonUtil.checkNull(request.getParameter("type"));
		String dateS=CommonUtil.checkNull(request.getParameter("sdate"));
		String dateE=CommonUtil.checkNull(request.getParameter("edate"));
		//String oldtype=CommonUtil.checkNull(request.getParameter("oldtype"));
		String temp=CommonUtil.checkNull(request.getParameter("r"));
		
		List<String> productIds=new ArrayList<>();
		if(request.getParameterValues("pid[]")!=null){
			productIds=new ArrayList<>(Arrays.asList(request.getParameterValues("pid[]")));	
		}
		/*if(!(oldtype.equals(type))&& productIds.size()>0){
			productIds.clear();
		}
		oldtype=type;*/
	
		
		Date sdate=CommonUtil.checkDate(dateS, dateFormat);
		Date edate=CommonUtil.checkDate(dateE, dateFormat);
		
		model.addAttribute("frpgrade", FrpCommon.getGrade());
		model.addAttribute("frpgradetype", FrpCommon.getGradeType());
		
		//model.addAttribute("type", type);
		//model.addAttribute("oldtype", oldtype);
		
		model.addAttribute("sdate", dateS);
		model.addAttribute("edate", dateE);
		model.addAttribute("showFlag", true);
		model.addAttribute("productIds", productIds);
		
		
		//Projection
		List<FrpProjection> projections=frpProjectionService.getProjectionFormulae();
		model.addAttribute("projections", projections);
		
		FrpProjectionData projectionData=frpProjectionService.getFiberPurchasingData(sdate,edate,productIds,temp);
		
		model.addAttribute("projectionData", projectionData);
		
		
		return "frp/fiberPurchasingView_white";
	}
	
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		
		String type=CommonUtil.checkNull(request.getParameter("type"));
		String dateS=CommonUtil.checkNull(request.getParameter("sdate"));
		String dateE=CommonUtil.checkNull(request.getParameter("edate"));
		
		List<String> productIds=new ArrayList<>();
		if(request.getParameterValues("pid[]")!=null){
			productIds=new ArrayList<>(Arrays.asList(request.getParameterValues("pid[]")));	
		}
		
		Date sdate=CommonUtil.checkDate(dateS, dateFormat);
		Date edate=CommonUtil.checkDate(dateE, dateFormat);
		
		//System.out.println(productIds);
	
		
		
		//FrpProjectionData projectionData=frpProjectionService.getFrpProjectionData(sdate,edate,productIds,"O");

		FrpProjectionData projectionData=frpProjectionService.getFiberPurchasingData(sdate,edate,productIds,"O");
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=FRP Projection Report.xls");
		
		//File file=new File(context.getRealPath("/")+"WEB-INF/excel template/frp/Fiber_Purchasing_Report.xls");
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/frp/FRP Projection Report.xls");

		HSSFWorkbook workbook=getFormatedWorkbookForWrapperRedCode(file,projectionData,sdate,edate,type);
		workbook.write(response.getOutputStream());
		
		
	}

	/**
	 * @param file
	 * @param projectionData
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws IOException 
	 */
	private HSSFWorkbook getFormatedWorkbookForWrapperRedCode(File file,
			FrpProjectionData projectionData, Date sdate, Date edate,String type) throws IOException {
		FileInputStream inputStream=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);

		
		HSSFSheet sheet=workbook.getSheetAt(0);
		
		int rowCount=0;
		int colCount=0;
		
		HSSFRow row1=sheet.createRow(0);
		HSSFRow row2=sheet.createRow(1);
		HSSFRow row3=sheet.createRow(2);
		int dateCount=0;
		for(int i=0;i<projectionData.getLength()+5;i++){
			if(i==0){
				WorkbookUtil.createCellHeader(workbook,row1, "Grade Code", colCount++);
				WorkbookUtil.mergeCell(workbook, 0, 0, 2,  colCount-1, colCount-1);
				
			}else if(i==1){
				WorkbookUtil.createCellHeader(workbook,row1,"Grade", colCount++);
				WorkbookUtil.mergeCell(workbook, 0, 0, 2,  colCount-1, colCount-1);
			}else if(i==2){
				WorkbookUtil.createCellHeader(workbook,row1,  dateFormat.format(sdate), colCount++);
				WorkbookUtil.mergeCell(workbook, 0, 0, 2,  colCount-1, colCount-1);
			}else if(i==(projectionData.getLength()+4)){
				WorkbookUtil.createCellHeader(workbook,row1, "Total", colCount++);
				WorkbookUtil.mergeCell(workbook, 0, 0, 2,  colCount-1, colCount-1);
				
			}else{
				WorkbookUtil.createCellHeader(workbook,row1, "Inbound", colCount++);
				if(dateCount<projectionData.getDays().size()){
					WorkbookUtil.createCellHeader(workbook,row2, projectionData.getDays().get(dateCount), colCount-1);
				}
				if(dateCount<projectionData.getDates().size()){
					WorkbookUtil.createCellHeader(workbook,row3, projectionData.getDates().get(dateCount), colCount-1);
				}
				
				dateCount++;
			}
			
		}
		
		rowCount=3;
		colCount=0;
		
		List<ProjectionData> projectionDatas=projectionData.getProjectionDatas();
		double totalWeight=0;
		double netWeight=0;
		for (ProjectionData prodData : projectionDatas) {
			
			double total=0;
			
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			System.out.println(""+prodData.getGradeCode());
			WorkbookUtil.createCell(workbook, row, prodData.getGradeCode(), colCount++);
			WorkbookUtil.createCell(workbook, row, prodData.getGrade(), colCount++);
			WorkbookUtil.createCell(workbook, row, CommonUtil.round(prodData.getWeight(), 2), colCount++);
			totalWeight+=prodData.getWeight();
			total+=prodData.getWeight();
			List<Integer> inbounds=prodData.getInbounds();
			for (Integer inbound : inbounds) {
				WorkbookUtil.createCell(workbook, row, inbound, colCount++);
				total+=inbound;
			}
			WorkbookUtil.createCell(workbook, row, CommonUtil.round(total, 2), colCount++);
			colCount=0;
			
			netWeight+=total;
		}
		
		{
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			WorkbookUtil.createCellRight(workbook, row, "Total", colCount++);
			WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount);
			colCount=2;
			WorkbookUtil.createCell(workbook, row, CommonUtil.round(totalWeight, 2), colCount++);
			
			for (int i=0;i<projectionData.getLength()+1;i++) {
				int total=0;
				for (ProjectionData prodData : projectionDatas) {
					total+=prodData.getInbounds().get(i);
				}
				WorkbookUtil.createCell(workbook, row, total, colCount++);
			}
			WorkbookUtil.createCell(workbook, row, CommonUtil.round(netWeight, 2), colCount++);
			
		}
		
		
		colCount=0;
		{
			
			HSSFRow row=sheet.createRow(rowCount++);
			row.setHeight((short)280);
			
			WorkbookUtil.createCellLeft(workbook, row, "Predicted inventory at the end of the day", colCount++);
			WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, 0, projectionData.getLength()+4);
		}
		
		
		colCount=0;
		
		/*if(type!=null){
			if(type.equalsIgnoreCase("WH")){*/
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "MWL & SWL (1/7)", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getMwlAndSwl();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
			/*	{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "SOW", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getSow();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}*/
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "SOW (13)", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getSowAndCbs();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "Groundwood(6/8/9)", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getGrowndwood();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "DLK(24)", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getDlk();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "OCC(23)", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getOcc();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "Mail-Undeliverable(20)", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getMail();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "Mixed Paper (30)", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getMixedPaper();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "Cut Book (21)", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getCutBook();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "Others(60/65)", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getOthers();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				//Code Starts From Here Done By Roshan Tailor
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "HW & Unpert SBS (11/14)", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getHwAndUnprtSBS();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				//Code Ends Here Done By Roshan Tailor
				
				{
					//Projection
					List<FrpProjection> projections=frpProjectionService.getProjectionFormulae();

					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					
					for (int i = 0; i < projectionData.getLength()+1; i++) {
						String value="";
						for (FrpProjection frpProjection : projections) {
							List<String> prodIds=projectionData.getProductionIds();
							
							if(NumberUtils.toInt(prodIds.get(i),0)==frpProjection.getId()){
								value=FrpCommon.getGradeType().get(frpProjection.getType2())+"-"+frpProjection.getInput();
								
							}
						}
						WorkbookUtil.createCellLeft(workbook, row, value, colCount++);
						
					}
					
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellRight(workbook, row, "Total avail", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					
					for (int i = 0; i < projectionData.getLength()+1; i++) {
						double value=
									projectionData.getMwlAndSwl().get(i)+
									projectionData.getSowAndCbs().get(i)+
									projectionData.getGrowndwood().get(i)+
									projectionData.getDlk().get(i)+
									projectionData.getOcc().get(i)+
									projectionData.getMail().get(i)+
									projectionData.getMixedPaper().get(i)+
									projectionData.getCutBook().get(i)+
									projectionData.getOthers().get(i)+
									projectionData.getHwAndUnprtSBS().get(i);//This Is Added By Roshan TAilor
						WorkbookUtil.createCellLeft(workbook, row, CommonUtil.round(value, 2), colCount++);
					}
					
					colCount=0;
				}
				
		/*	}else if(type.equalsIgnoreCase("KF")){
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "DLK", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getDlk();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "OCC", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getOcc();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "Sow And Mail", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getSowAndMail();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "Groundwood", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getGrowndwood();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "Others", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					List<Double> datas=projectionData.getOthers();
					for (Double value : datas) {
						if(value<0){
							WorkbookUtil.createCellRed(workbook, row, CommonUtil.round(value, 2), colCount++);
						}else{
							WorkbookUtil.createCell(workbook, row, CommonUtil.round(value, 2), colCount++);
						}
					}
					colCount=0;
				}
				
				{
					
					//Projection
					List<FrpProjection> projections=frpProjectionService.getProjectionFormulae();
					
					
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellLeft(workbook, row, "", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					
					for (int i = 0; i < projectionData.getLength()+1; i++) {
						String value="";
						for (FrpProjection frpProjection : projections) {
							List<String> prodIds=projectionData.getProductionIds();
							
							if(NumberUtils.toInt(prodIds.get(i),0)==frpProjection.getId()){
								value=FrpCommon.getGradeType().get(frpProjection.getType2())+"-"+frpProjection.getInput();
								
							}
						}
						WorkbookUtil.createCellLeft(workbook, row, value, colCount++);
						
					}
					
					colCount=0;
				}
				{
					HSSFRow row=sheet.createRow(rowCount++);
					row.setHeight((short)280);
					WorkbookUtil.createCellRight(workbook, row, "Total avail", colCount++);
					WorkbookUtil.mergeCell(workbook, 0, rowCount-1, rowCount-1, colCount-1, colCount+1);
					colCount=3;
					
					for (int i = 0; i < projectionData.getLength()+1; i++) {
						double value=projectionData.getDlk().get(i)+
									projectionData.getOcc().get(i)+
									projectionData.getSowAndMail().get(i)+
									projectionData.getGrowndwood().get(i)+
									projectionData.getOthers().get(i);
						WorkbookUtil.createCellLeft(workbook, row, CommonUtil.round(value, 2), colCount++);
					}
					
					colCount=0;
				}
			}
		}*/
		
		
		colCount=0;
		{
			
		}
		
		return workbook;
	}
	
	
}
