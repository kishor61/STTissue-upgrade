/**
 *Apr 24, 2015
 *FrpYieldDailyReportController.java
 * TODO
 *com.st.frpyieldreport.controller
 *FrpYieldDailyReportController.java
 *Sunil Singh Bora
 */
package com.st.frpyieldreport.controller;

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
import com.st.utilitykpimaster.model.MasterData;
import com.st.utilitykpimaster.service.MasterDataService;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/frpdailyyieldreport")
public class FrpYieldDailyReportController {
	
	private static final String EDIT_PAGE="editpage";
	private static final String VIEW_PAGE="viewpage";
	
	@Autowired
	private ServletContext context;
	
	
	@Autowired
	private FrpYieldService frpYieldService;	
	
	@Autowired
	private MasterDataService masterDataService;	
	
	@Autowired
	private FrpYieldReportHandler frpYieldReportHandler;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("startdate", dateFormat.format(new Date()));
		model.addAttribute("enddate", dateFormat.format(new Date()));
		return "frpYieldDailyReportView";
	}
	
	@RequestMapping(value="/view/load",method=RequestMethod.GET)
	public String viewData(HttpServletRequest request,
			Model model) throws TrackerException, ProductionException{
		Date startdate=CommonUtil.checkDate(request.getParameter("startdate"), dateFormat);
		Date enddate=CommonUtil.checkDate(request.getParameter("enddate"), dateFormat);
		
		Date sdate=CommonUtil.checkDate(request.getParameter("startdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("enddate"), dateFormat);
		
		List<FrpYield> frpYields=frpYieldService.getFrpYieldData(startdate,enddate);
		
//		Code Starts From Here For Data From MAster Report

		List<MasterData> masterDatas=masterDataService.getMasterDatas(sdate,edate);
		List<Map<String, String>> qualityDatas=masterDataService.getReportData(masterDatas, "M");
	

		
//		try{
//			model.addAttribute(EDIT_PAGE, false);
//			model.addAttribute(VIEW_PAGE, true);
//			frpqualities=formatData(frpYield);
//		}catch(Exception e){
//			System.out.println("Roshan Says, You Have A Problem In FrpYieldReportController At viewData Method.");
//			e.printStackTrace();
//		}
//		
//		model.addAttribute("startdate", dateFormat.format(startdate));
//		model.addAttribute("enddate", dateFormat.format(enddate));
		
		for (Map<String, String> map : qualityDatas) {
			FrpYield frpYield1=getFrpYield(frpYields,map.get(ColumnsOfTable.COL_02));
				if(frpYield1!=null){
					frpYield1.setYlswdcswastepaperfed(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_44)));
					frpYield1.setYlswdcsfrpproduction(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_45)));
					frpYield1.setDwwflowrommill(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_29)));
					//System.out.println("DWW::"+map.get(ColumnsOfTable.COL_29));
				}
			}
		//frpqualities=formatData(frpYields);
		model.addAttribute("startdate", dateFormat.format(startdate));
		model.addAttribute("enddate", dateFormat.format(enddate));
		model.addAttribute(EDIT_PAGE, false);
		model.addAttribute(VIEW_PAGE, true);
		model.addAttribute("frpqualities", frpYields);
		return "frpYieldDailyReportView";
	}

	
	/**
	 * @param frpyieldsummary
	 * @param string
	 * @return
	 */
	private FrpYield getFrpYield(List<FrpYield> frpYield, String string) {
		
		FrpYield frpYieldN=null;
		for (FrpYield frpYield1 : frpYield) {
			if(dateFormat.format(frpYield1.getDate()).equalsIgnoreCase(string)){
				frpYieldN=frpYield1;
				break;
			}
		}
		
		return frpYieldN;
	}

	/**
	 * @param frpyieldsummary
	 * @return
	 */
	
	
	@RequestMapping(value="/dailyreport/export",method=RequestMethod.POST)
	public void export(@RequestParam("startdate")String sdate,
			@RequestParam("enddate")String edate,
			HttpServletResponse response) throws Exception{
	//	System.out.println(sdate);
	//	System.out.println(edate);
		List<FrpYield> dailyreportdata=frpYieldService.getDailyReportData(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(edate, dateFormat));
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=FRP_Yield_Daily_Report.xlsx");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/FRP_Yield_Daily_Report.xlsx");
		
		List<MasterData> masterDatas=masterDataService.getMasterDatas(CommonUtil.checkDate(sdate, dateFormat),CommonUtil.checkDate(sdate, dateFormat));
		List<Map<String, String>> qualityDatas=masterDataService.getReportData(masterDatas, "M");
		
		for (Map<String, String> map : qualityDatas) {
			FrpYield frpYield1=getFrpYield(dailyreportdata,map.get(ColumnsOfTable.COL_02));
				if(frpYield1!=null){
					frpYield1.setDwwflowrommill(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_29)));
				}
			}
		
		
		frpYieldReportHandler.createFrpDailyReport(dailyreportdata,file,response.getOutputStream());
		
	}
}
