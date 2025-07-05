/**
 *Apr 24, 2015
 *FrpYieldSummaryController.java
 * TODO
 *com.st.frpyieldsummary.controller
 *FrpYieldSummaryController.java
 *Sunil Singh Bora
 */
package com.st.frpyieldsummary.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.common.exception.TrackerException;
import com.st.frpyield.model.FrpYield;
import com.st.frpyield.service.FrpYieldService;
import com.st.frpyieldreport.controller.FrpYieldSummaryReportHandler;
import com.st.utilitykpimaster.model.MasterData;
import com.st.utilitykpimaster.service.MasterDataService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/frpdailyyieldsummary")
public class FrpYieldSummaryController {

	private static final String MAIN_PAGE="mainpage";
	private static final String RESULT_PAGE="resultpage";
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	@Autowired
	private FrpYieldService frpYieldService;
	
	@Autowired
	private FrpYieldSummaryReportHandler frpYieldSummaReportHandler;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private MasterDataService masterDataService;
	
	@RequestMapping("/view")
	public String view(Model model) {
		
		model.addAttribute(MAIN_PAGE, true);
		model.addAttribute(RESULT_PAGE, false);
		
		model.addAttribute("startdate", dateFormat.format(new Date()));
		model.addAttribute("enddate", dateFormat.format(new Date()));
		return "frpYieldDailySummaryView";
	}
	
	@RequestMapping(value="/viewsummary",method=RequestMethod.GET)
	public String viewsummary(HttpServletRequest request,Model model) throws TrackerException, ProductionException{
		
		Date startdate=CommonUtil.checkDate(request.getParameter("startdate"), dateFormat);
		Date enddate=CommonUtil.checkDate(request.getParameter("enddate"), dateFormat);
		

		Date sdate=CommonUtil.checkDate(request.getParameter("startdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("enddate"), dateFormat);
		
		model.addAttribute(MAIN_PAGE, false);
		model.addAttribute(RESULT_PAGE, true);
		
		model.addAttribute("startdate",dateFormat.format(startdate));
		model.addAttribute("enddate", dateFormat.format(enddate));

		List<FrpYield> frpyieldsummary=frpYieldService.getFrpYieldSummaryData(startdate,enddate);
		
		//Code Starts From Here, Data Coming From Main Table (Master Data)
		List<MasterData> masterDatas=masterDataService.getMasterDatas(sdate,edate);
		List<Map<String, String>> qualityDatas=masterDataService.getReportData(masterDatas, "M");
		//Code Ends Here, Data Coming From Main Table (Master Data)
		
		for (Map<String, String> map : qualityDatas) {
		FrpYield frpYield=getFrpYield(frpyieldsummary,map.get(ColumnsOfTable.COL_02));
			if(frpYield!=null){
				frpYield.setYlswdcswastepaperfed(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_44)));
				frpYield.setYlswdcsfrpproduction(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_43)));
				frpYield.setYlswdcsfrpyield(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_29)));
				//System.out.println("dcsfrpproduction::"+map.get(ColumnsOfTable.COL_43)+"Roshan::"+map.get(ColumnsOfTable.COL_29));
			}
		}
		
		model.addAttribute("frpsummary", frpyieldsummary);
		return "frpYieldDailySummaryView";
	}

	/**
	 * @param frpyieldsummary
	 * @param string
	 * @return
	 */
	private FrpYield getFrpYield(List<FrpYield> frpyieldsummary, String string) {
		
		FrpYield frpYieldN=null;
		for (FrpYield frpYield : frpyieldsummary) {
			if(dateFormat.format(frpYield.getDate()).equalsIgnoreCase(string)){
				frpYieldN=frpYield;
				break;
			}
		}
		
		return frpYieldN;
	}

	@RequestMapping(value="/summaryreport/export",method=RequestMethod.POST)
	public void export(@RequestParam("startdate")String sdate,
					   @RequestParam("enddate")String edate,
					   HttpServletResponse response) throws Exception{
		//System.out.println(sdate);
		//System.out.println(edate);
		List<FrpYield> dailyreportdata=frpYieldService.getDailyReportData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Frp_Yield_Summary_Report.xlsx");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/Frp_Yield_Summary_Report.xlsx");
		
		List<MasterData> masterDatas=masterDataService.getMasterDatas(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(sdate, dateFormat));
		List<Map<String, String>> qualityDatas=masterDataService.getReportData(masterDatas, "M");
		
		for (Map<String, String> map : qualityDatas) {
			FrpYield frpYield1=getFrpYield(dailyreportdata,map.get(ColumnsOfTable.COL_02));
				if(frpYield1!=null){
					frpYield1.setYlswdcswastepaperfed(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_44)));
					frpYield1.setYlswdcsfrpproduction(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_43)));
					frpYield1.setYlswdcsfrpyield(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_29)));
					//System.out.println("DWW::"+map.get(ColumnsOfTable.COL_29));
				}
			}
		
		
		frpYieldSummaReportHandler.createFrpDailyReport(dailyreportdata,file,response.getOutputStream());
	}
}











