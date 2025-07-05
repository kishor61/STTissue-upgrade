package com.st.wastepaper.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import org.jfree.chart.needle.ShipNeedle;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.common.CommonUtil;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastePaperTruckUnload;
import com.st.wastepaper.report.WastePaperTruckUnloadReportHandler;
import com.st.wastepaper.report.WastePaperUnloadBalesReportHandler;
import com.st.wastepaper.service.WastePaperTrucksUnloadService;

@Controller
@RequestMapping("/wastepapertrucksunload")
public class WastePaperTrucksUnloadController {

	private static final String VIEW_PAGE="viewpage";
	
	private static final String LANDING_PAGE="landingpage";
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WastePaperTrucksUnloadService wastepapertrucksunloadservice;
	
	@Autowired
	private WastePaperTruckUnloadReportHandler wastepapertruckunloadreporthandler;
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String wastePaperDetailedReport(Model model){
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute(VIEW_PAGE, false);
		model.addAttribute(LANDING_PAGE, true);
		
		return"trucksUnloadReport";
	}
	
	@RequestMapping(value="/viewreport",method=RequestMethod.GET)
	public String viewreport(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
	
	Date startdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
	Date enddate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);

	List<WastePaperTruckUnload> unloadtrucksdata=wastepapertrucksunloadservice.getUnloadTrucks(startdate,enddate);
	
	
	Calendar calendar=Calendar.getInstance();
	calendar.setTime(startdate);
	
	int days=CommonUtil.getDaysDiffernce(startdate, enddate);
	
	
	List<WastePaperTruckUnload> unloadTrucks= new ArrayList<WastePaperTruckUnload>();
	
	for (int i = 0; i <=days; i++) {
		
		Date dateS=calendar.getTime();
		
		final WastePaperTruckUnload wastePaperUnloadTrucks=new WastePaperTruckUnload();
		wastePaperUnloadTrucks.setUnloaddate(dateS);
		System.out.println("Roshan Date::"+dateFormat.format(dateS));
		
		int totalTrucks=0;
		int totalDayShiftTrucks=0;
		int totalNightShiftTrucks=0;
		
		int loopCountDay=0;
		int loopCountNight=0;
		for(final WastePaperTruckUnload data:unloadtrucksdata){
			String dayshift=data.getDayshift();
			String nightshift=data.getNightshift();
			
			
			Date comdb=data.getUnloaddate();
			
			if(dateFormat.format(comdb).equals(dateFormat.format(dateS))){
				System.out.println("Matching");
				if(dayshift!=null || nightshift!=null ){
					if(dayshift.equalsIgnoreCase("Day")){
						loopCountDay++;
						totalDayShiftTrucks=totalDayShiftTrucks+loopCountDay;
						wastePaperUnloadTrucks.setDayshifttrucks(loopCountDay);
					}else if(nightshift.equalsIgnoreCase("Night")){
						loopCountNight++;
						totalNightShiftTrucks=totalNightShiftTrucks+loopCountNight;
						wastePaperUnloadTrucks.setNightshifttrucks(loopCountNight);
					}
				}
			}else{
				System.out.println("Not matching");
			}
			
			
		}
		
		
		wastePaperUnloadTrucks.setTruckcount(loopCountDay+loopCountNight);
		unloadTrucks.add(wastePaperUnloadTrucks);
		
		model.addAttribute("unloadtrucksdata", unloadTrucks);
		calendar.add(Calendar.DATE, 1);
		
	}
	
	System.out.println("unloadtrucksdata:::"+unloadtrucksdata.size());
	model.addAttribute(VIEW_PAGE, true);
	model.addAttribute(LANDING_PAGE, false);
	//model.addAttribute("unloadtrucksdata", unloadTrucks);
	model.addAttribute("sdate", dateFormat.format(startdate));
	model.addAttribute("edate", dateFormat.format(enddate));
	return"trucksUnloadReport";
}
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void export(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,
			HttpServletResponse response) throws Exception{
		
		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date startdate=CommonUtil.checkDate(sdate, df);
		Date enddate=CommonUtil.checkDate(edate, df);
		
		String flag="Unload";
		
		List<WastePaperTruckUnload> unloadtrucksdata=wastepapertrucksunloadservice.getUnloadTrucks(startdate,enddate);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(startdate);
		
		int days=CommonUtil.getDaysDiffernce(startdate, enddate);
		
		
		List<WastePaperTruckUnload> unloadTrucks= new ArrayList<WastePaperTruckUnload>();
		
		for (int i = 0; i <=days; i++) {
			
			Date dateS=calendar.getTime();
			
			final WastePaperTruckUnload wastePaperUnloadTrucks=new WastePaperTruckUnload();
			wastePaperUnloadTrucks.setUnloaddate(dateS);
			System.out.println("Roshan Date::"+dateFormat.format(dateS));
			
			int totalTrucks=0;
			int totalDayShiftTrucks=0;
			int totalNightShiftTrucks=0;
			
			int loopCountDay=0;
			int loopCountNight=0;
			for(final WastePaperTruckUnload data:unloadtrucksdata){
				String dayshift=data.getDayshift();
				String nightshift=data.getNightshift();
				
				
				Date comdb=data.getUnloaddate();
				
				if(dateFormat.format(comdb).equals(dateFormat.format(dateS))){
					System.out.println("Matching");
					if(dayshift!=null || nightshift!=null ){
						if(dayshift.equalsIgnoreCase("Day")){
							loopCountDay++;
							totalDayShiftTrucks=totalDayShiftTrucks+loopCountDay;
							wastePaperUnloadTrucks.setDayshifttrucks(loopCountDay);
						}else if(nightshift.equalsIgnoreCase("Night")){
							loopCountNight++;
							totalNightShiftTrucks=totalNightShiftTrucks+loopCountNight;
							wastePaperUnloadTrucks.setNightshifttrucks(loopCountNight);
						}
					}
				}else{
					System.out.println("Not matching");
				}
				
				
			}
			
			
			wastePaperUnloadTrucks.setTruckcount(loopCountDay+loopCountNight);
			unloadTrucks.add(wastePaperUnloadTrucks);
			calendar.add(Calendar.DATE, 1);
			
		}
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Waste Paper-Trucks_Unload_Detail_Report.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/Waste Paper-Trucks_Unload_Detail_Report.xlsx");
		
		//wastepapertruckunloadreporthandler.getUnloadTrucksReport(unloadtrucksdata,flag,file,response.getOutputStream());
		wastepapertruckunloadreporthandler.getUnloadTrucksReport(unloadTrucks,flag,file,response.getOutputStream());
		}
}
