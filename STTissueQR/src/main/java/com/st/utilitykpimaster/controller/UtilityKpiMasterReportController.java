/**
 * 
 */
package com.st.utilitykpimaster.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.UtilityKpiMasterCommon;
import com.st.common.Workbook2007Util;
import com.st.common.exception.ProductionException;
import com.st.common.exception.TrackerException;
import com.st.frppressquality.service.FrpPressQualityService;
import com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService;
import com.st.utilitykpimaster.automailer.UtilityKpiMasterAutoMailer;
import com.st.utilitykpimaster.model.KpiRecordableDate;
import com.st.utilitykpimaster.model.MasterData;
import com.st.utilitykpimaster.model.UtilityData;
import com.st.utilitykpimaster.report.UtilityKpiMasterReportHandler;
import com.st.utilitykpimaster.service.KpiRecordableDateService;
import com.st.utilitykpimaster.service.MasterDataService;
import com.st.utilitykpimaster.service.UtilityDataService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping(value="/utilitykpimasterreport")
public class UtilityKpiMasterReportController {
	@Autowired
	private UtilityDataService utilityDataService;
	
	@Autowired
	private MasterDataService masterDataService;
	
	@Autowired
	private UtilityKpiMasterAutoMailer utilityKpiMasterAutoMailer;
	
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private KpiRecordableDateService kpiRecordableDateService;
	
	
	@Autowired
	private UtilityKpiMasterReportHandler utilityKpiMasterReportHandler;
	
	//Code Starts From Here Done By Roshan Tailor Date :-03/21/2016
	
	@Autowired
	private FrpProdcutionOperatorDataEntryService frpprodcutionoperatordataentryservice ;
	
	@Autowired
	private FrpPressQualityService frpPressQualityService;
	
	//Code Ends Here Done By Roshan Tailor Date :- 03/21/2016
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(Model model) {
		
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("pages", UtilityKpiMasterCommon.getEntryPages());
		
		return "utilityKpiMasterView";
		
	}
	
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String viewData(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws TrackerException, ProductionException {
		
		String type=CommonUtil.checkNull(request.getParameter("type"));
		
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("page", type);
		model.addAttribute("edate", edate);
		model.addAttribute("pages", UtilityKpiMasterCommon.getEntryPages());
		
		List<Map<String, String>> datas=new ArrayList<>();
		
		if(type!=null){
			if(type.equalsIgnoreCase("U")){
				List<UtilityData> utilityDatas=utilityDataService.getPrevUtilityData(sDate,eDate);
				datas=masterDataService.getReportData(utilityDatas,type);
			}else if(type.equalsIgnoreCase("M")){
				List<MasterData> masterDatas=masterDataService.getMasterDatas(sDate,eDate);
				
				//Code Starts From Here Done By Roshan Tailor Date :- 03/21/2016
				
				
				
			/*	System.out.println("Details::"+details.size());
				System.out.println("sludgeHaulings::"+sludgeHaulings.size());*/
				//Code Ends Here Done By Roshan Tailor date :- 03/21/2016
				
				datas=masterDataService.getReportData(masterDatas,type);
				
			}else if(type.equalsIgnoreCase("K")){
				List<MasterData> masterDatas=masterDataService.getMasterDatas(sDate,eDate);
				datas=masterDataService.getReportData(masterDatas,type);
				
				KpiRecordableDate kpiRecordableDate=kpiRecordableDateService.getLastKpiRecordableDate();
				if(kpiRecordableDate!=null){
					int days=CommonUtil.getDaysDiffernce(kpiRecordableDate.getDate(), eDate);
					
					if(days>0){
						model.addAttribute("lrdate", dateFormat.format(kpiRecordableDate.getDate()));
						model.addAttribute("lrdays", days);
						model.addAttribute("lrcdate", edate);
					}

				}
				
			}
		}
		
		model.addAttribute("datas", datas);
		return "utilityKpiMasterView";
		
	}
	
	
	@RequestMapping(value="/exportutility",method=RequestMethod.POST)
	public void exportUtilityData(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException, TrackerException, ProductionException {
		
		String type=CommonUtil.checkNull(request.getParameter("type"));
		
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<Map<String, String>> datas=new ArrayList<>();
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		
		if(type!=null){
			if(type.equalsIgnoreCase("U")){
				List<UtilityData> utilityDatas=utilityDataService.getPrevUtilityData(sDate,eDate);
				datas=masterDataService.getReportData(utilityDatas,type);
				
				
				
				response.setHeader("Content-Disposition", "attachment; filename=Utiility Report.xlsx");
				File file=new File(context.getRealPath("/")+"WEB-INF/Utiility Report.xlsx");

				XSSFWorkbook workbook=getFormatedWorkbook(file,datas,type);
				workbook.write(response.getOutputStream());
				
				
				
			}
		}
		
	}
	
	@RequestMapping(value="/exportmaster",method=RequestMethod.POST)
	public void exportMasterData(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException, TrackerException, ProductionException {
		
		String type=CommonUtil.checkNull(request.getParameter("type"));
		
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<Map<String, String>> datas=new ArrayList<>();
		
		response.setContentType("application/vnd.ms-excel");
		
		if(type!=null){
			if(type.equalsIgnoreCase("M")){
				List<MasterData> masterDatas=masterDataService.getMasterDatas(sDate,eDate);
				datas=masterDataService.getReportData(masterDatas,type);
				
				response.setHeader("Content-Disposition", "attachment; filename=Master Report.xlsx");
				File file=new File(context.getRealPath("/")+"WEB-INF/Master Report.xlsx");

				XSSFWorkbook workbook=getFormatedWorkbook(file,datas,type);
				workbook.write(response.getOutputStream());

			}
		}
		
	}
	
	@RequestMapping(value="/exportkpi",method=RequestMethod.POST)
	public void exportKPIData(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException, TrackerException, ProductionException {
		
		String type=CommonUtil.checkNull(request.getParameter("type"));
		
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		
		if(type!=null){
			if(type.equalsIgnoreCase("K")){
				List<Map<String, String>> datas=new ArrayList<>();
				List<MasterData> masterDatas=masterDataService.getMasterDatas(sDate,eDate);
				datas=masterDataService.getReportData(masterDatas,type);
				
				response.setHeader("Content-Disposition", "attachment; filename=KPI Report.xlsx");
				File file=new File(context.getRealPath("/")+"WEB-INF/KPI Report.xlsx");

				XSSFWorkbook workbook=getFormatedWorkbook(file,datas,type);
				
				KpiRecordableDate kpiRecordableDate=kpiRecordableDateService.getLastKpiRecordableDate();
				if(kpiRecordableDate!=null){
					int days=CommonUtil.getDaysDiffernce(kpiRecordableDate.getDate(), eDate);
					
					if(days>0){
						XSSFSheet sheet=workbook.getSheetAt(0);
						XSSFRow row=sheet.getRow(0);
						XSSFCell sdateCell=row.getCell(15);
						sdateCell.setCellValue(kpiRecordableDate.getDate());
						
						XSSFCell dayCell=row.getCell(20);
						dayCell.setCellValue(days);
						
						XSSFCell currentDateCell=row.getCell(22);
						currentDateCell.setCellValue(eDate);
					}

				}
				
				
				workbook.write(response.getOutputStream());

			}
		}
		
	}
	

	
	@RequestMapping(value="/exportkpi/pdf",method=RequestMethod.GET)
	public void exportKpiPdf(@RequestParam("type")String type,
			@RequestParam("sdate")String sdate,
			@RequestParam("edate")String edate,
			HttpServletResponse response) throws Exception {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<Map<String, String>> datas=new ArrayList<Map<String,String>>();
		if(type!=null){
			if(type.equalsIgnoreCase("K")){
				List<MasterData> masterDatas=masterDataService.getMasterDatas(sDate,eDate);
				datas=masterDataService.getReportData(masterDatas,type);
				
			}
		}
		
		
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=\"STTissue_KPI.pdf\"");
		KpiRecordableDate kpiRecordableDate=kpiRecordableDateService.getLastKpiRecordableDate();
		Date recordableDate=null;
		if(kpiRecordableDate!=null){
			recordableDate=kpiRecordableDate.getDate();
		}
		
		utilityKpiMasterReportHandler.createKpiPdf(datas,recordableDate,eDate,response.getOutputStream());
		
	}
	
	/**
	 * @param file
	 * @param datas
	 * @param type
	 * @return
	 * @throws IOException 
	 */
	private XSSFWorkbook getFormatedWorkbook(File file,
			List<Map<String, String>> datas, String type) throws IOException {
		
	
		Workbook2007Util util=new Workbook2007Util(file, 0);
		short height=280;
		int col=0;
		if(type.equalsIgnoreCase("U")){
			int rowCount=2;
			for (Map<String, String> map : datas) {
				col=0;
				
				util.addValue(rowCount, col++, CommonUtil.checkNull(map.get(ColumnsOfTable.COL_02).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkNull(map.get(ColumnsOfTable.COL_03).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
//				util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_04).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
//				util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
//				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_08).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
//				util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_12).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				rowCount++;
			}
		}else if(type.equalsIgnoreCase("M")){
			int rowCount=5;
			
			double TOTAL_02=0;
			double TOTAL_03=0;
			double TOTAL_04=0;
			double TOTAL_05=0;
			double TOTAL_06=0;
			double TOTAL_07=0;
			double TOTAL_08=0;
			double TOTAL_09=0;
			double TOTAL_10=0;
			double TOTAL_11=0;
			double TOTAL_12=0;
			@SuppressWarnings("unused")
			double TOTAL_13=0;
			double TOTAL_14=0;
		//	double TOTAL_15=0;
			double TOTAL_16=0;
			double TOTAL_17=0;
			double TOTAL_18=0;
			@SuppressWarnings("unused")
			double TOTAL_19=0;
			double TOTAL_20=0;
			double TOTAL_21=0;
			@SuppressWarnings("unused")
			double TOTAL_22=0;
			double TOTAL_23=0;
			@SuppressWarnings("unused")
			double TOTAL_24=0;
			double TOTAL_25=0;
		//	double TOTAL_26=0;
			double TOTAL_27=0;
			double TOTAL_28=0;
		//	double TOTAL_29=0;
			double TOTAL_30=0;
			double TOTAL_31=0;
			double TOTAL_32=0;
			double TOTAL_33=0;
			double TOTAL_34=0;
			double TOTAL_35=0;
			double TOTAL_36=0;
			double TOTAL_37=0;
			double TOTAL_38=0;
			double TOTAL_39=0;
			double TOTAL_40=0;
		//	double TOTAL_41=0;
			double TOTAL_42=0;
			double TOTAL_43=0;
			@SuppressWarnings("unused")
			double TOTAL_44=0;
			double TOTAL_45=0;
			double TOTAL_46=0;
			double TOTAL_47=0;
			double TOTAL_48=0;
			double TOTAL_49=0;
			double TOTAL_50=0;
			double TOTAL_51=0;
			double TOTAL_52=0;
			double TOTAL_53=0;
			double TOTAL_54=0;
			double TOTAL_55=0;
			double TOTAL_56=0;
			double TOTAL_57=0;
			double TOTAL_58=0;
			double TOTAL_59=0;
			double TOTAL_60=0;
			double TOTAL_61=0;
			//double TOTAL_62=0;
			double TOTAL_63=0;
			double TOTAL_64=0;
			double TOTAL_65=0;
			double TOTAL_66=0;
		//	double TOTAL_67=0;
			@SuppressWarnings("unused")
			double TOTAL_68=0;
		//	double TOTAL_69=0;
			double TOTAL_70=0;
			double TOTAL_71=0;
		//	double TOTAL_72=0;
			double TOTAL_73=0;
		//	double TOTAL_74=0;
		//	double TOTAL_75=0;
		//	double TOTAL_76=0;
		//	double TOTAL_77=0;
		//	double TOTAL_78=0;
			double TOTAL_79=0;
			double TOTAL_80=0;
			double TOTAL_81=0;
			double TOTAL_82=0;
			double TOTAL_83=0;
			double TOTAL_84=0;
			double TOTAL_85=0;
			
			
			double TOTAL_86=0;
			double TOTAL_87=0;
			double TOTAL_88=0;
			
			int TOTAL=datas.size();
			
			for (Map<String, String> map : datas) {
			
				

				col=0;
				
				util.addValue(rowCount, col++, CommonUtil.checkNull(map.get(ColumnsOfTable.COL_02).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_03).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_04).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_05).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_06).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_07).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_08).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_09).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_10).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_12).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_13).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_14).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_15).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_16).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_17).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_18).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_19).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_20).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_21).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_22).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_23).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				//Power cell
				util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				
				
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_24).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_25).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_26).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_27).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_28).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_29).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				 
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_30).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				 
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_31).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				double db =CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_85))/1000000;
				
				util.addValue(rowCount, col++, CommonUtil.round(db, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_86).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_87).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				
				/*util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_32).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);*/
				
				//
				/*util.addValue(rowCount, col++, CommonUtil.round(Double.parseDouble(map.get(ColumnsOfTable.COL_28))+Double.parseDouble(map.get(ColumnsOfTable.COL_31))+Double.parseDouble(map.get(ColumnsOfTable.COL_87)), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);*/
				util.addValue(rowCount, col++, CommonUtil.round(Double.parseDouble(map.get(ColumnsOfTable.COL_28))+Double.parseDouble(map.get(ColumnsOfTable.COL_87)), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				//
				
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_33).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_34).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_35).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_36).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_37).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_38).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_39).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_40).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_41).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkNull( map.get(ColumnsOfTable.COL_42).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_43).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_44).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_45).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_46).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_47).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_48).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_49).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_50).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_51).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_52).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_53).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_54).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_55).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_56).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_57).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_58).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_59).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_60).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_61).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_62).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
	
				
				
				//Blank Cell
				util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_63).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_64).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_65).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_66).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_67).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_68).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				
				//Blank Cell
				util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_69).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_70).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_71).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_72).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
			
				//Blank Cell
				util.addValue(rowCount, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				/*util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_73).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_74).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_75).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_76).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_77).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_78).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
			*/
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_79).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_80).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_81).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_82).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_83).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_84).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				rowCount++;
				
				
				
				TOTAL_02+=Double.parseDouble(map.get(ColumnsOfTable.COL_03).toString());
				TOTAL_03+=Double.parseDouble(map.get(ColumnsOfTable.COL_04).toString());
				TOTAL_04+=Double.parseDouble(map.get(ColumnsOfTable.COL_05).toString());
				TOTAL_05+=Double.parseDouble(map.get(ColumnsOfTable.COL_06).toString());
				TOTAL_06+=Double.parseDouble(map.get(ColumnsOfTable.COL_07).toString());
				TOTAL_07+=Double.parseDouble(map.get(ColumnsOfTable.COL_08).toString());
				TOTAL_08+=Double.parseDouble(map.get(ColumnsOfTable.COL_09).toString());
				TOTAL_09+=Double.parseDouble(map.get(ColumnsOfTable.COL_10).toString());
				TOTAL_10+=Double.parseDouble(map.get(ColumnsOfTable.COL_11).toString());
				TOTAL_11+=Double.parseDouble(map.get(ColumnsOfTable.COL_12).toString());
				TOTAL_12+=Double.parseDouble(map.get(ColumnsOfTable.COL_13).toString());
				TOTAL_13+=Double.parseDouble(map.get(ColumnsOfTable.COL_14).toString());
				TOTAL_14+=Double.parseDouble(map.get(ColumnsOfTable.COL_15).toString());
			//	TOTAL_15+=Double.parseDouble(map.get(ColumnsOfTable.COL_16).toString());
				TOTAL_16+=Double.parseDouble(map.get(ColumnsOfTable.COL_17).toString());
				TOTAL_17+=Double.parseDouble(map.get(ColumnsOfTable.COL_18).toString());
				TOTAL_18+=Double.parseDouble(map.get(ColumnsOfTable.COL_19).toString());
				TOTAL_19+=Double.parseDouble(map.get(ColumnsOfTable.COL_20).toString());
				TOTAL_20+=Double.parseDouble(map.get(ColumnsOfTable.COL_21).toString());
				TOTAL_21+=Double.parseDouble(map.get(ColumnsOfTable.COL_22).toString());
				TOTAL_22+=Double.parseDouble(map.get(ColumnsOfTable.COL_23).toString());
				TOTAL_23+=Double.parseDouble(map.get(ColumnsOfTable.COL_24).toString());
				TOTAL_24+=Double.parseDouble(map.get(ColumnsOfTable.COL_25).toString());
				TOTAL_25+=Double.parseDouble(map.get(ColumnsOfTable.COL_26).toString());
			//	TOTAL_26+=Double.parseDouble(map.get(ColumnsOfTable.COL_27).toString());
				TOTAL_27+=Double.parseDouble(map.get(ColumnsOfTable.COL_28).toString());
				TOTAL_28+=Double.parseDouble(map.get(ColumnsOfTable.COL_29).toString());
			//	TOTAL_29+=Double.parseDouble(map.get(ColumnsOfTable.COL_30).toString());
				TOTAL_30+=Double.parseDouble(map.get(ColumnsOfTable.COL_31).toString());
				TOTAL_31+=Double.parseDouble(map.get(ColumnsOfTable.COL_32).toString());
				TOTAL_32+=Double.parseDouble(map.get(ColumnsOfTable.COL_33).toString());
				TOTAL_33+=Double.parseDouble(map.get(ColumnsOfTable.COL_34).toString());
				TOTAL_34+=Double.parseDouble(map.get(ColumnsOfTable.COL_35).toString());
				TOTAL_35+=Double.parseDouble(map.get(ColumnsOfTable.COL_36).toString());
				TOTAL_36+=Double.parseDouble(map.get(ColumnsOfTable.COL_37).toString());
				TOTAL_37+=Double.parseDouble(map.get(ColumnsOfTable.COL_38).toString());
				TOTAL_38+=Double.parseDouble(map.get(ColumnsOfTable.COL_39).toString());
				TOTAL_39+=Double.parseDouble(map.get(ColumnsOfTable.COL_40).toString());
				TOTAL_40+=Double.parseDouble(map.get(ColumnsOfTable.COL_41).toString());
				

				TOTAL_42+=Double.parseDouble(map.get(ColumnsOfTable.COL_43).toString());
				TOTAL_43+=Double.parseDouble(map.get(ColumnsOfTable.COL_44).toString());
				TOTAL_44+=Double.parseDouble(map.get(ColumnsOfTable.COL_45).toString());
				TOTAL_45+=Double.parseDouble(map.get(ColumnsOfTable.COL_46).toString());
				TOTAL_46+=Double.parseDouble(map.get(ColumnsOfTable.COL_47).toString());
				TOTAL_47+=Double.parseDouble(map.get(ColumnsOfTable.COL_48).toString());
				TOTAL_48+=Double.parseDouble(map.get(ColumnsOfTable.COL_49).toString());
				TOTAL_49+=Double.parseDouble(map.get(ColumnsOfTable.COL_50).toString());
				TOTAL_50+=Double.parseDouble(map.get(ColumnsOfTable.COL_51).toString());
				TOTAL_51+=Double.parseDouble(map.get(ColumnsOfTable.COL_52).toString());
				TOTAL_52+=Double.parseDouble(map.get(ColumnsOfTable.COL_53).toString());
				TOTAL_53+=Double.parseDouble(map.get(ColumnsOfTable.COL_54).toString());
				TOTAL_54+=Double.parseDouble(map.get(ColumnsOfTable.COL_55).toString());
				TOTAL_55+=Double.parseDouble(map.get(ColumnsOfTable.COL_56).toString());
				TOTAL_56+=Double.parseDouble(map.get(ColumnsOfTable.COL_57).toString());
				TOTAL_57+=Double.parseDouble(map.get(ColumnsOfTable.COL_58).toString());
				TOTAL_58+=Double.parseDouble(map.get(ColumnsOfTable.COL_59).toString());
				TOTAL_59+=Double.parseDouble(map.get(ColumnsOfTable.COL_60).toString());
				TOTAL_60+=Double.parseDouble(map.get(ColumnsOfTable.COL_61).toString());
				TOTAL_61+=Double.parseDouble(map.get(ColumnsOfTable.COL_62).toString());
				
				TOTAL_63+=Double.parseDouble(map.get(ColumnsOfTable.COL_63).toString());
				TOTAL_64+=Double.parseDouble(map.get(ColumnsOfTable.COL_64).toString());
				TOTAL_65+=Double.parseDouble(map.get(ColumnsOfTable.COL_65).toString());
				TOTAL_66+=Double.parseDouble(map.get(ColumnsOfTable.COL_66).toString());
			//	TOTAL_67+=Double.parseDouble(map.get(ColumnsOfTable.COL_67).toString());
				TOTAL_68+=Double.parseDouble(map.get(ColumnsOfTable.COL_68).toString());
				
				TOTAL_70+=Double.parseDouble(map.get(ColumnsOfTable.COL_69).toString());
				TOTAL_71+=Double.parseDouble(map.get(ColumnsOfTable.COL_70).toString());
			//	TOTAL_72+=Double.parseDouble(map.get(ColumnsOfTable.COL_71).toString());
//				TOTAL_73+=Double.parseDouble(map.get(ColumnsOfTable.COL_72).toString());
				
//				TOTAL_75+=Double.parseDouble(map.get(ColumnsOfTable.COL_73).toString());
//				TOTAL_76+=Double.parseDouble(map.get(ColumnsOfTable.COL_74).toString());
			//	TOTAL_77+=Double.parseDouble(map.get(ColumnsOfTable.COL_75).toString());
			//	TOTAL_78+=Double.parseDouble(map.get(ColumnsOfTable.COL_76).toString());
			//	TOTAL_79+=Double.parseDouble(map.get(ColumnsOfTable.COL_77).toString());
			//	TOTAL_80+=Double.parseDouble(map.get(ColumnsOfTable.COL_78).toString());
				
				
				TOTAL_79+=Double.parseDouble(map.get(ColumnsOfTable.COL_79).toString());
				TOTAL_80+=Double.parseDouble(map.get(ColumnsOfTable.COL_80).toString());
				TOTAL_81+=Double.parseDouble(map.get(ColumnsOfTable.COL_81).toString());
				TOTAL_82+=Double.parseDouble(map.get(ColumnsOfTable.COL_82).toString());
				TOTAL_83+=Double.parseDouble(map.get(ColumnsOfTable.COL_83).toString());
				TOTAL_84+=Double.parseDouble(map.get(ColumnsOfTable.COL_84).toString());
				
				
				/*TOTAL_85+=CommonUtil.round(Double.parseDouble(map.get(ColumnsOfTable.COL_28))+Double.parseDouble(map.get(ColumnsOfTable.COL_31))+Double.parseDouble(map.get(ColumnsOfTable.COL_87)), 2);*/
				TOTAL_85+=CommonUtil.round(Double.parseDouble(map.get(ColumnsOfTable.COL_28))+Double.parseDouble(map.get(ColumnsOfTable.COL_87)), 2);
				
				TOTAL_86+=db;
				TOTAL_87+=Double.parseDouble(map.get(ColumnsOfTable.COL_86).toString());
				TOTAL_88+=Double.parseDouble(map.get(ColumnsOfTable.COL_87).toString());
				
				
				
				
			}
			//rowCount++;
			
			{
				
				col=0;
				
				util.addValue(rowCount, col++,"Avg", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_02/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_03/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_04/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_05/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_06/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_07/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_08/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_09/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_10/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_11/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_12/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_14/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_16/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_17/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_18/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				//Changed on 2015-03-28 by Sunil
				double avg150lbs=TOTAL_17/(TOTAL_09+TOTAL_10);
				util.addValue(rowCount, col++,CommonUtil.round(avg150lbs,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//End
				
				
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_21/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				//Changed on 2015-03-28 by Sunil
				double totalGasFlow=TOTAL_21/(TOTAL_09+TOTAL_10);
				util.addValue(rowCount, col++,CommonUtil.round(totalGasFlow,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//End
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_23/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				double millTotalCons=TOTAL_23*1000000/(TOTAL_09+TOTAL_10);
				util.addValue(rowCount, col++,CommonUtil.round(millTotalCons,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_25/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_27/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				/*util.addValue(rowCount, col++,CommonUtil.round(TOTAL_28/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);*/
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_28/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_30/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_86/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_87/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_88/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				/*util.addValue(rowCount, col++,CommonUtil.round(TOTAL_31/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);*/
				
				
				
				//
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_85/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_32/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				 
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_33/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_34/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_35/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_36/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_37/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_38/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_39/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_40/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round((TOTAL_42/TOTAL_43)*100,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_45/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_46/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_47/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_48/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_49/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_50/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_51/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_52/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_53/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_54/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_55/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_56/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_57/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_58/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_59/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_60/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_61/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_63/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_64/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_65/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				
				//Changes 2015-03-28
				double electrical=TOTAL_66/(TOTAL_09+TOTAL_10);
				util.addValue(rowCount, col++,CommonUtil.round(electrical, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				double electricalTotal=electrical+CommonUtil.round(TOTAL_64/TOTAL,2)+CommonUtil.round(TOTAL_65/TOTAL,2);
				
				util.addValue(rowCount, col++,CommonUtil.round(electricalTotal,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_70/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_71/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_73/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				/*util.addValue(rowCount, col++,CommonUtil.round(TOTAL_75/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_76/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);*/
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				
				rowCount++;

				
			}
			
			{
				
				col=0;
				
				util.addValue(rowCount, col++,"Total", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);

				util.addValue(rowCount, col++,TOTAL_03, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_04, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_05, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_06, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_07, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_08, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_09, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_10, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_11, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_12, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_14, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_16, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_17, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
			
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
			
				util.addValue(rowCount, col++,TOTAL_20, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_21, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,TOTAL_23, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_25, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				/*util.addValue(rowCount, col++,TOTAL_28, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);*/
				util.addValue(rowCount, col++,TOTAL_28, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				 
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_86, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_87, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_88, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				/*util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);*/
				 
				
				
				util.addValue(rowCount, col++,TOTAL_85, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_35, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_36, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_37, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_38, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_39, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_40, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_42, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_43, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_45, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_46, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_47, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_48, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_49, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_50, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_51, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_52, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_53, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_54, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_55, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_56, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_57, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_58, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_59, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_60, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);

				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,TOTAL_63, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,TOTAL_66, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);

				
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				
				
				double efficienyPerc=0;
				if(TOTAL_70!=0){
					efficienyPerc=(TOTAL_71*8.33/TOTAL_70/1000)*100;
				}
				
				util.addValue(rowCount, col++,CommonUtil.round(efficienyPerc, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				/*util.addValue(rowCount, col++,TOTAL_75, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_76, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
	
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);*/
				
				util.addValue(rowCount, col++,TOTAL_79, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_80, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_81, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_82, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_83, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_84, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
			}
			
		}else if(type.equalsIgnoreCase("K")){
			int rowCount=4;
			
			double TOTAL_02=0;
			double TOTAL_03=0;
			double TOTAL_04=0;
			double TOTAL_05=0;
			double TOTAL_06=0;
			double TOTAL_07=0;
			@SuppressWarnings("unused")
			double TOTAL_08=0;
			@SuppressWarnings("unused")
			double TOTAL_09=0;
			@SuppressWarnings("unused")
			double TOTAL_10=0;
			@SuppressWarnings("unused")
			double TOTAL_11=0;
			double TOTAL_12=0;
			double TOTAL_13=0;
			double TOTAL_14=0;
			double TOTAL_15=0;
			double TOTAL_16=0;
			double TOTAL_17=0;
			double TOTAL_18=0;
			double TOTAL_19=0;
			double TOTAL_20=0;
			double TOTAL_21=0;
			double TOTAL_22=0;
			double TOTAL_23=0;
			double TOTAL_24=0;//Downtime
			double TOTAL_41=0;
			double TOTAL_42=0;
			
			//Mill
			double TOTAL_27=0;
			
			
			int TOTAL=datas.size();
			
			for (Map<String, String> map : datas) {
				
				col=0;
				
				util.addValue(rowCount, col++, CommonUtil.checkNull(map.get(ColumnsOfTable.COL_01).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_02).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_03).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_04).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_05).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_06).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_07).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_08).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_09).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_10).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_27).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_12).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				//
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_31).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_32).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				//
				
				util.addValue(rowCount, col++, CommonUtil.round((Double.parseDouble(map.get(ColumnsOfTable.COL_12))+Double.parseDouble(map.get(ColumnsOfTable.COL_32))), 0), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);//Total Water Consumption
				
				
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_13).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				//util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_14).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				//
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_30).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				
				// Add New Colum
				
				util.addValue(rowCount, col++, (Double.parseDouble(map.get(ColumnsOfTable.COL_30))+Double.parseDouble(map.get(ColumnsOfTable.COL_13))), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				
				//
				//util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_15).toString())+"Roshan", Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_16).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_17).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_18).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				//util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_19).toString())+"Tailor", Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_20).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_21).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_22).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				util.addValue(rowCount, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_23).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, height);
				
				


				TOTAL_02+=Double.parseDouble(map.get(ColumnsOfTable.COL_02).toString());
				TOTAL_03+=Double.parseDouble(map.get(ColumnsOfTable.COL_03).toString());
				TOTAL_04+=Double.parseDouble(map.get(ColumnsOfTable.COL_04).toString());
				TOTAL_05+=Double.parseDouble(map.get(ColumnsOfTable.COL_05).toString());
				TOTAL_06+=Double.parseDouble(map.get(ColumnsOfTable.COL_06).toString());
				TOTAL_07+=Double.parseDouble(map.get(ColumnsOfTable.COL_07).toString());
				TOTAL_08+=Double.parseDouble(map.get(ColumnsOfTable.COL_08).toString());
				TOTAL_09+=Double.parseDouble(map.get(ColumnsOfTable.COL_09).toString());
				TOTAL_10+=Double.parseDouble(map.get(ColumnsOfTable.COL_10).toString());
				TOTAL_11+=Double.parseDouble(map.get(ColumnsOfTable.COL_11).toString());
				TOTAL_12+=Double.parseDouble(map.get(ColumnsOfTable.COL_12).toString());
				TOTAL_13+=Double.parseDouble(map.get(ColumnsOfTable.COL_13).toString());
			    TOTAL_14+=Double.parseDouble(map.get(ColumnsOfTable.COL_30).toString());
				TOTAL_15+=Double.parseDouble(map.get(ColumnsOfTable.COL_15).toString());
				TOTAL_16+=Double.parseDouble(map.get(ColumnsOfTable.COL_16).toString());
				TOTAL_17+=Double.parseDouble(map.get(ColumnsOfTable.COL_17).toString());
				TOTAL_18+=Double.parseDouble(map.get(ColumnsOfTable.COL_18).toString());
				TOTAL_19+=Double.parseDouble(map.get(ColumnsOfTable.COL_19).toString());
				TOTAL_20+=Double.parseDouble(map.get(ColumnsOfTable.COL_20).toString());
				TOTAL_21+=Double.parseDouble(map.get(ColumnsOfTable.COL_21).toString());
				TOTAL_22+=Double.parseDouble(map.get(ColumnsOfTable.COL_22).toString());
				TOTAL_23+=Double.parseDouble(map.get(ColumnsOfTable.COL_23).toString());
				TOTAL_24+=Double.parseDouble(map.get(ColumnsOfTable.COL_24).toString());
				
				TOTAL_27+=Double.parseDouble(map.get(ColumnsOfTable.COL_27).toString());
				
				TOTAL_41+=Double.parseDouble(map.get(ColumnsOfTable.COL_30))+Double.parseDouble(map.get(ColumnsOfTable.COL_13));
				
				TOTAL_42+=Double.parseDouble(map.get(ColumnsOfTable.COL_12))+Double.parseDouble(map.get(ColumnsOfTable.COL_32));
				
				
				rowCount++;
				
			}
			
			{
				col=0;
	
				util.addValue(rowCount, col++,"Avg/Day", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_02/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_03/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_04/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_05/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_06/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_07/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_27/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_12/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_42/TOTAL,0), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_13/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_14/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_41/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//
				//util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//
				//util.addValue(rowCount, col++,CommonUtil.round(TOTAL_15/TOTAL,2)+"Roshan", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_16/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_17/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_18/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//util.addValue(rowCount, col++,CommonUtil.round(TOTAL_19/TOTAL,2)+"Tailor", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_20/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_21/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_22/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_23/TOTAL,2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				

				
				rowCount++;
			}
			
			{
				
				
				double uptime=0;
				if(TOTAL>0){
					uptime=((1440*TOTAL)-TOTAL_24)/(1440*TOTAL);
				}
				
				double yield=0;
				if(TOTAL_02!=0){
					yield=(TOTAL_07/TOTAL_02);
				}
				
				double quality=0;
				if(TOTAL_07!=0){
					quality=(TOTAL_04/TOTAL_07);
				}
				
				double efficiency=uptime*yield*quality;
				
				col=0;
				
				util.addValue(rowCount, col++,"Total", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_02, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_03, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_04, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_05, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_06, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_07, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(uptime*100, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(quality*100, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(yield*100, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(efficiency*100, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,TOTAL_27, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_12, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,CommonUtil.round(TOTAL_42, 0), Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//
				util.addValue(rowCount, col++,TOTAL_13, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,TOTAL_14, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				
				util.addValue(rowCount, col++,TOTAL_41, Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				//util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);
				util.addValue(rowCount, col++,"", Workbook2007Util.Style.STYLE_BOLD_CENTER, height);

				
				rowCount++;
			}
		}
		
		return util.getWorkbook();
	}


	@RequestMapping(value="/kpiemail",method=RequestMethod.POST)
	public @ResponseBody boolean email(HttpServletResponse response){
		
		try {
			utilityKpiMasterAutoMailer.sendKPIMail();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
				
	}

}
