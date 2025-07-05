/**
 *Oct 15, 2019
 *QulityCheck_Pm6Controller.java
 * TODO
 *com.st.qualitypm6.controller
 *QulityCheck_Pm6Controller.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.CommonUtil;

import com.st.qualitypm5.service.QulityCheckPm5Service;
import com.st.qualitypm6.model.Grade;
import com.st.qualitypm6.model.QulityCheck_Pm6;
import com.st.qualitypm6.service.CustomerService;
import com.st.qualitypm6.service.GradeService;




/**
 * @author sohan
 *
 */
@Controller
@RequestMapping("/qulitycheck_pm5")
public class QulityCheck_Pm5Controller {
	
	
	//private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private QulityCheckPm5Service qulitycheckpm6Service;
	
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String qulitycheck_pm6(Model model) {
		
		List<QulityCheck_Pm6> data=qulitycheckpm6Service.getDataOfQulityCheck_Pm6(CommonUtil.getShiftDate());
		List<Grade> gradecode=gradeService.getGrades();
		List<String> customers = customerService.getCustomers();
		
		 long diff, diffHours,diffMinutes,totaldiff=0,totalmin=0,h=0,min=0;
		 if(data.size()>0) {
			 		  
			  Date stime,etime;
			 
			  for(QulityCheck_Pm6 dt:data)
			  {
				  stime=dt.getStime();
				  etime=dt.getEtime();
				  diff =Math.abs( etime.getTime() -  stime.getTime());
				  diffMinutes = diff / (60 * 1000) % 60;
				  diffHours = diff / (60 * 60 * 1000) % 24;
				  System.out.println("mm="+diffMinutes+"    hh"+diffHours);
   			   		totaldiff=totaldiff+diffHours;
   			   		totalmin=totalmin+diffMinutes;
   			   		h=totalmin/60;
   			   		min=totalmin%60;			 
			  }
			  totaldiff=totaldiff+h;
			  System.out.println("totaldiff "+totaldiff+"   min"+min);	
		 }
		 	
		 	String hm=totaldiff+":"+min;
		 	
		 	model.addAttribute("currentdate", dateFormat.format(CommonUtil.getShiftDate()));
			model.addAttribute("data", data);
			model.addAttribute("gradecode", gradecode);
			model.addAttribute("customers", customers);
			model.addAttribute("showForm", false);
			model.addAttribute("date", dateFormat.format(CommonUtil.getShiftDate()));
			model.addAttribute("totaldiff", hm);
		 
		return "PM5/qualitycheckpm5";
	}
	@RequestMapping(value="/qualitychecklist/check",method=RequestMethod.POST)
	public void productspecificationsignoffsheetcheck(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes) throws Exception {
		
		response.setContentType("application/json");
				
		Map<String, Object> map=new HashMap<String, Object>();
		
		Date date=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date sd=timeFormat.parse(request.getParameter("sd"));
		
		String cuDate= timeFormat.format(sd);
		Date MainDate= CommonUtil.getDateTime(date, timeFormat.parse(cuDate));
			
		 List<QulityCheck_Pm6> data=qulitycheckpm6Service.getDataOfQulityCheck_Pm6(date);
		 Date stime,etime;
		  
		  long diff, diffHours,lossentry=0;
		  long count=0;
		  boolean check=true;
		 
		if(data.size()>0) 
		{
			 for(QulityCheck_Pm6 dt:data)
			 {
				 if(MainDate.getTime()-dt.getEtime().getTime()<=0)
				 {
					 check=false;
					 break;
				 }
				
			 }
			 
			 stime=null;etime=null;
				
			   diff=0; diffHours=0;lossentry=0;
			   long diffMinutes=0,totaldiff=0,totalmin=0,h=0,min=0;
			   count=0;
			 
			   for(QulityCheck_Pm6 dt:data)
			  {
				  stime=dt.getStime();
				  etime=dt.getEtime();
					  diff =Math.abs( etime.getTime() -  stime.getTime());
	   			  diffHours = diff / (60 * 60 * 1000) % 24;
	   			  diffMinutes = diff / (60 * 1000) % 60;
	   			  
	   			  if(dt.getMachinedown().equalsIgnoreCase("No"))
				 			count++;
	   			   
	   			   totaldiff=totaldiff+diffHours;
	 			   		totalmin=totalmin+diffMinutes;
	 			   		h=totalmin/60;
	 			   		min=totalmin%60;			 
			  }
			  
			  totaldiff=totaldiff+h;
			  double tmin=(totaldiff*60)+min;
			  
			  lossentry=Math.round(tmin/180);
			  count=count+lossentry; 
			  System.out.println("diffHours = "+totaldiff+" lossentry =  "+lossentry+"  min = "+min+" Total entry  = "+count);				  
		}
		boolean counter=false;
		if(count<8)
			counter=true;
		 map.put("check", check);	
		 map.put("count", counter);
				
			response.getWriter().write(new Gson().toJson(map));
	}
	@RequestMapping(value="/qualitychecklist/save",method=RequestMethod.POST)
	public void productspecificationsignoffsheetsave(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		QulityCheck_Pm6 wm=new QulityCheck_Pm6();
		
			int id=CommonUtil.checkInt(request.getParameter("id"));
			Date date=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
			String time=CommonUtil.checkNull(request.getParameter("time"));
			
			Date currentTime=null;
			if(time.equals("7 AM")) {
				currentTime=timeFormat.parse("7:00");
			}else if(time.equals("10 AM")) {
				currentTime=timeFormat.parse("10:00");
				
			}else if(time.equals("1 PM")) {
				currentTime=timeFormat.parse("13:00");
			}else if(time.equals("4 PM")) {
				currentTime=timeFormat.parse("16:00");
				
			}else if(time.equals("7 PM")) {
				currentTime=timeFormat.parse("19:00");
				
			}else if(time.equals("10 PM")) {
				currentTime=timeFormat.parse("22:00");
				
			}else if(time.equals("1 AM")) {
				currentTime=timeFormat.parse("1:00");
				Calendar nextcal = Calendar.getInstance();
		        nextcal.setTime(date);
		        nextcal.add(5, 1);
		        date = nextcal.getTime();
				
			}else if(time.equals("4 AM")) {
				currentTime=timeFormat.parse("4:00");
				Calendar nextcal = Calendar.getInstance();
		        nextcal.setTime(date);
		        nextcal.add(5, 1);
		        date = nextcal.getTime();
				
			}
			Date stime=timeFormat.parse("00:00");
			Date etime=timeFormat.parse("00:00");
			String cuDate= timeFormat.format(currentTime);
			Date MainDate= CommonUtil.getDateTime(date, timeFormat.parse(cuDate));
			
			
			
			
			
		
		 String machinedown="No"; 
			
			String gradecode =CommonUtil.checkNull(request.getParameter("gradecode"));
			String customer=CommonUtil.checkNull(request.getParameter("customer"));
			String core=CommonUtil.checkNull(request.getParameter("core"));
			String holes=CommonUtil.checkNull(request.getParameter("holes"));
			String corrugation=CommonUtil.checkNull(request.getParameter("corrugation"));
			String EdgeQulity=CommonUtil.checkNull(request.getParameter("EdgeQulity"));
			String setnumber=CommonUtil.checkNull(request.getParameter("setnumber"));
			String position=CommonUtil.checkNull(request.getParameter("position"));
			String diameterofroll=CommonUtil.checkNull(request.getParameter("diameterofroll"));
			
			String widthofroll=CommonUtil.checkNull(request.getParameter("widthofroll"));
			String r1r2initial=CommonUtil.checkNull(request.getParameter("r1r2initial"));
			String auditerinitial=CommonUtil.checkNull(request.getParameter("auditerinitial"));
			
		
			
			
			
			wm.setId(id);
			wm.setDate(MainDate);
			wm.setTime(time);
			wm.setCustomer(customer);
			wm.setGradecode(gradecode);
			wm.setCore(core);
			wm.setHoles(holes);
			wm.setCorrugation(corrugation);
			wm.setEdgequlity(EdgeQulity);
			wm.setSetnumber(setnumber);
			wm.setPosition(position);
			wm.setDiameterofroll(diameterofroll);
			wm.setWidthofroll(widthofroll);
			wm.setR1r2initial(r1r2initial);
			wm.setAuditerinitial(auditerinitial);
			wm.setStime(stime);
			wm.setEtime(etime);
			wm.setMachinedown(machinedown);
			
			
			
			
			
			
			
			response.setContentType("application/json");
			try {
				
				if(wm.getId()==0){
					//Insert
					int key=qulitycheckpm6Service.savequalitychecklist(wm);
					map.put("status", true);
					map.put("id", key);
					map.put("message", "Data saved successfully.");
					
				}else{
					//Update
					qulitycheckpm6Service.updatequalitychecklist(wm);
					map.put("status", true);
					map.put("id", wm.getId());
					map.put("message", "Data updated successfully.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error in saving data", e);
				
			}
			response.getWriter().write(new Gson().toJson(map));
	}
	
	
	
	@RequestMapping(value="/productspecificationsignoffsheet/delete", method=RequestMethod.POST)
	public void productspecificationsignoffsheetdelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		int id =CommonUtil.checkInt(request.getParameter("id"));
		Map<String, Object> map= new HashMap<String, Object>();
		try{
			qulitycheckpm6Service.qualitychecklistdelete(id);
			map.put("status", true);
		}catch(Exception e){
			System.out.println("Roshan Says That You Have A Problem In WinderBreakMonitoringController.java At Delete Method");
			e.printStackTrace();
		}
	response.setContentType("application/json");
	response.getWriter().write(new Gson().toJson(map));
	}
	@RequestMapping(value="/productspecificationsignoffsheet/view/{date}",method=RequestMethod.GET)
	public String productspecificationsignoffsheetviewDateWise(@PathVariable("date")String date,HttpServletRequest request,HttpServletResponse response,Model model){
	
	Date sdate=CommonUtil.checkDate(date, dateFormat);
	Date edate=sdate;
	
	List<QulityCheck_Pm6> data=qulitycheckpm6Service.getDataOfQulityCheck_Pm6(sdate,edate);
	List<Grade> gradecode=gradeService.getGrades();
	List<String> customers = customerService.getCustomers();
	model.addAttribute("currentdate", dateFormat.format(sdate));
	model.addAttribute("data", data);
	model.addAttribute("gradecode", gradecode);
	model.addAttribute("customers", customers);
	model.addAttribute("showForm", false);
	model.addAttribute("date", dateFormat.format(sdate));
	
	 long diff, diffHours,diffMinutes,totaldiff=0,totalmin=0,h=0,min=0;
	 if(data.size()>0) {
		 		  
		  Date stime,etime;
		 
		  for(QulityCheck_Pm6 dt:data)
		  {
			  stime=dt.getStime();
			  etime=dt.getEtime();
			  diff =Math.abs( etime.getTime() -  stime.getTime());
			  diffMinutes = diff / (60 * 1000) % 60;
			  diffHours = diff / (60 * 60 * 1000) % 24;
			  System.out.println("mm="+diffMinutes+"    hh"+diffHours);
			   		totaldiff=totaldiff+diffHours;
			   		totalmin=totalmin+diffMinutes;
			   		h=totalmin/60;
			   		min=totalmin%60;			 
		  }
		  totaldiff=totaldiff+h;
		 
	 }
	 	
	 	String hm=totaldiff+":"+min;
	 	 System.out.println("hm "+hm);	
	
	 	model.addAttribute("totaldiff", hm);
	
	return "PM5/qualitycheckpm5";
	
	}
	@RequestMapping(value="/timediff/save",method=RequestMethod.POST)
	public void machinedown(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		QulityCheck_Pm6 wm=new QulityCheck_Pm6();
		SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
		
			int id=CommonUtil.checkInt(request.getParameter("id"));
			Date date=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
			
			String time=CommonUtil.checkNull(request.getParameter("time"));
			
			
			String currentdate= dateFormat.format(new Date());
			Date currentdateNew=CommonUtil.checkDate(currentdate, dateFormat);
			
			
		
			String machineflag=CommonUtil.checkNull(request.getParameter("machinedown"));
			
		
		/* String skucode=CommonUtil.checkNull(request.getParameter("skucode")); */
			
			String gradecode =CommonUtil.checkNull(request.getParameter("gradecode"));
			String customer=CommonUtil.checkNull(request.getParameter("customer"));
			String core=CommonUtil.checkNull(request.getParameter("core"));
			String holes=CommonUtil.checkNull(request.getParameter("holes"));
			String corrugation=CommonUtil.checkNull(request.getParameter("corrugation"));
			String EdgeQulity=CommonUtil.checkNull(request.getParameter("EdgeQulity"));
			String setnumber=CommonUtil.checkNull(request.getParameter("setnumber"));
			String position=CommonUtil.checkNull(request.getParameter("position"));
			String diameterofroll=CommonUtil.checkNull(request.getParameter("diameterofroll"));
			
			String widthofroll=CommonUtil.checkNull(request.getParameter("widthofroll"));
			String r1r2initial=CommonUtil.checkNull(request.getParameter("r1r2initial"));
			String auditerinitial=CommonUtil.checkNull(request.getParameter("auditerinitial"));
			String shift=CommonUtil.checkNull(request.getParameter("shift"));
			Date stime=timeFormat.parse(request.getParameter("sd"));
			Date etime=timeFormat.parse(request.getParameter("ed"));
			
			String cuDate= timeFormat.format(stime);
			Date MainDate= CommonUtil.getDateTime(date, timeFormat.parse(cuDate));
			String cutimes=timeFormat.format(MainDate);
			Date mainTime=timeFormat.parse(cutimes);
			Date sDate= CommonUtil.getDateTime(date, timeFormat.parse(cuDate));
			String euDate= timeFormat.format(etime);
			Date EMainDate= CommonUtil.getDateTime(date, timeFormat.parse(euDate));
			String times1=timeFormat.format(EMainDate);
			Date emainTime=timeFormat.parse(times1);
			 
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DAY_OF_MONTH, 1);
			Date dt=CommonUtil.checkDate(dateFormat.format(c.getTime()), dateFormat);
			
			Date etdate=timeFormat.parse("00:01");
			String et=timeFormat.format(etdate);
			Date etDate= CommonUtil.getDateTime(date, timeFormat.parse(et));			
			String ettimes=timeFormat.format(etDate);
			Date etTime=timeFormat.parse(ettimes);
			
			Date etdate1=timeFormat.parse("08:00");
			String et1=timeFormat.format(etdate1);
			Date etDate1= CommonUtil.getDateTime(date, timeFormat.parse(et1));			
			String ettimes1=timeFormat.format(etDate1);
			Date etTime1=timeFormat.parse(ettimes1);
			
			
			if(mainTime.getTime()>etTime1.getTime()&&etTime.getTime()<emainTime.getTime()&&emainTime.getTime()<etTime1.getTime()) {
				 EMainDate= CommonUtil.getDateTime(dt, timeFormat.parse(euDate));				 
				System.out.println("cunt shift "+ EMainDate);
			}
			 
			
			long diff, diffHours,diffMinutes,totaldiff=0,h=0;
			
			  diff =Math.abs( EMainDate.getTime() - MainDate.getTime());
			  diffMinutes = diff / (60 * 1000) % 60;
			  diffHours = diff / (60 * 60 * 1000) % 24;
			  System.out.println("diffMinutes "+ diffMinutes+"diffHours "+diffHours);		 
			  totaldiff=totaldiff+h; 		
		 
		 
			  
			 
	            
	          /*  String times=timeFormat.format(MainDate);
	            Date dt1=timeFormat.parse(times);
			  long st=dt1.getTime();
			  long st2=MainDate.getTime();
			  
			  System.out.println("st"+st+"st2"+st2);
			  */
			  
			  
			  
			  
			  
			  
			
			wm.setId(id);
			wm.setDate(MainDate);
			wm.setTime(time);
			wm.setCustomer(customer);
			wm.setGradecode(gradecode);
			wm.setCore(core);
			wm.setHoles(holes);
			wm.setCorrugation(corrugation);
			wm.setEdgequlity(EdgeQulity);
			wm.setSetnumber(setnumber);
			wm.setPosition(position);
			wm.setDiameterofroll(diameterofroll);
			wm.setWidthofroll(widthofroll);
			wm.setR1r2initial(r1r2initial);
			wm.setAuditerinitial(auditerinitial);
			wm.setStime(sDate);
			wm.setEtime(EMainDate);
			wm.setMachinedown(machineflag);
			wm.setShift(shift);
			//wm.setTotalDuration(diff);
			
			
			response.setContentType("application/json");
			int key=qulitycheckpm6Service.savequalitychecklist(wm);
			if(key>0) {
				map.put("status", true);
				map.put("message", "Data saved successfully.");
			}
		
			response.getWriter().write(new Gson().toJson(map));
			
		
	}
	/*
	 * @RequestMapping(value="/productspecificationsignoffsheet/data/edit/{id}",
	 * method=RequestMethod.GET) public String Edit(@PathVariable("id")int
	 * id,HttpServletRequest request,HttpServletResponse response,Model model)
	 * throws Exception{
	 * 
	 * System.out.println(id);
	 * 
	 * List<ConvertingLine> skucode=convertinglineservice.getAllSkuCode();
	 * List<ProductSpecificationSignOffSheet>
	 * data=convertinglineservice.getDataOfProductSpecificationSignOffSheetToEdit(id
	 * );
	 * 
	 * Date d=null; for(ProductSpecificationSignOffSheet datas:data){
	 * 
	 * d=datas.getDate(); }
	 * 
	 * model.addAttribute("currentdate", dateFormat1.format(d));
	 * model.addAttribute("date", dateFormat1.format(d)); model.addAttribute("data",
	 * data); model.addAttribute("skucode", skucode); model.addAttribute("showForm",
	 * false); model.addAttribute("grades",
	 * convertinglinecustomerrolltestingService.getGrades());
	 * model.addAttribute("date", dateFormat1.format(new Date())); return
	 * "convertingline/productspecificationsignoffsheet"; }
	 */
	
	
	@RequestMapping(value = "/qualityChecklist/report", method = RequestMethod.GET)
	public String productspecificationsignoffsheetreport(Model model) {
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));	
		return "PM5/qualitychecklistReportPm5";

	}

	
	@RequestMapping(value = "/qualitychecklist/report/show", method = RequestMethod.GET)
	public String productspecificationsignoffsheetreportshow(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes) {
		Date dates=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date datee=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		List<QulityCheck_Pm6> data=qulitycheckpm6Service.getDataOfQulityCheck_Pm6(dates,datee);
		 long days=CommonUtil.getDaysDiffernce(dates, datee)+1;
		 double TotalEntry =0;
		 double percentage=0;
		 if(data.size()>0) {
			 
			  TotalEntry =days*8;
			    
			  Date stime,etime;
			
			  long diff, diffHours,lossentry=0,diffMinutes=0,totaldiff=0,totalmin=0,h=0,min=0;
			  long count=0;
			  for(QulityCheck_Pm6 dt:data)
			  {
				  stime=dt.getStime();
				  etime=dt.getEtime();
				  diff =Math.abs( etime.getTime() -  stime.getTime());
    			  diffHours = diff / (60 * 60 * 1000) % 24;
    			  diffMinutes = diff / (60 * 1000) % 60;
    			  
    			  if(dt.getMachinedown().equalsIgnoreCase("No"))
			 			count++;
    			   
    			   totaldiff=totaldiff+diffHours;
  			   		totalmin=totalmin+diffMinutes;
  			   		h=totalmin/60;
  			   		min=totalmin%60;			 
			  }
			  
			  totaldiff=totaldiff+h;
			  double tmin=(totaldiff*60)+min;
			  double s=tmin/180;
			  lossentry=Math.round(tmin/180);
			  
			  System.out.println("diffHours = "+totaldiff+" lossentry =  "+lossentry+"  min = "+min+" s = "+s);	
			  
			 count=count+lossentry;
			  
			  percentage= count/TotalEntry;
			 /* if(percentage>=1)
				  percentage=1;*/
			  System.out.println(percentage*100);  
		}
		
		
		
		model.addAttribute("data", data);
		model.addAttribute("percentage", Math.round(percentage*100));
		model.addAttribute("sdate", dateFormat.format(dates));
		model.addAttribute("edate", dateFormat.format(datee));		
		return "PM5/qualitychecklistReportPm5";

	}
	
	@RequestMapping(value="/qualitychecklist/data/edit/{id}",method=RequestMethod.GET)
	public String Edit(@PathVariable("id")int id,HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
	
		/*
		 * Date sdate=CommonUtil.checkDate(date, dateFormat); Date edate=sdate;
		 */
		
		List<QulityCheck_Pm6> data=qulitycheckpm6Service.getDataOfQulityCheck_Pm6(id);
		List<Grade> gradecode=gradeService.getGrades();
		List<String> customers = customerService.getCustomers();
		model.addAttribute("currentdate", dateFormat.format(new Date()));
		model.addAttribute("data", data);
		model.addAttribute("gradecode", gradecode);
		model.addAttribute("customers", customers);
		model.addAttribute("showForm", false);
		model.addAttribute("date", dateFormat.format(new Date()));
		
		return "PM5/qualitycheckpm5";
		

	}
	
	

}
