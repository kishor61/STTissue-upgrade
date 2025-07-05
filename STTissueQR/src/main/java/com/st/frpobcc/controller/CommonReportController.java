/**
 *09-Dec-2019
 *commonExcelReport.java
 * TODO
 *com.st.frpobcc.controller
 *commonExcelReport.java
 *Sohan Lal Bairwa
 */
package com.st.frpobcc.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.frpobcc.handler.ExcelReportHandler;
import com.st.frpobcc.handler.PdfReportHandler;
import com.st.frpobcc.model.Common;
import com.st.frpobcc.model.OpRoute_1;
import com.st.frpobcc.model.OpRoute_2;
import com.st.frpobcc.model.OpRoute_3;
import com.st.frpobcc.model.OpRoute_4;
import com.st.frpobcc.model.OpRoute_5;
import com.st.frpobcc.model.OpRoute_6;
import com.st.frpobcc.model.OpRoute_7;
import com.st.frpobcc.model.OpRoute_8;
import com.st.frpobcc.model.OpRoute_9;
import com.st.frpobcc.service.OpRoute_1ServiceImp;
import com.st.frpobcc.service.OpRoute_2ServiceImp;
import com.st.frpobcc.service.OpRoute_3ServiceImp;
import com.st.frpobcc.service.OpRoute_4ServiceImp;
import com.st.frpobcc.service.OpRoute_5ServiceImp;
import com.st.frpobcc.service.OpRoute_6ServiceImp;
import com.st.frpobcc.service.OpRoute_7ServiceImp;
import com.st.frpobcc.service.OpRoute_8ServiceImp;
import com.st.frpobcc.service.OpRoute_9ServiceImp;

/**
 * @author sohan
 *
 */
@Controller
@RequestMapping("/frpobccReport")
public class CommonReportController {
	
	@Autowired
	private ServletContext context;
	@Autowired
	private ExcelReportHandler excelreporthandler;
	@Autowired
	private PdfReportHandler pdfreporthandler;
	@Autowired
	private OpRoute_1ServiceImp oproute_1service;
	@Autowired
	private OpRoute_2ServiceImp oproute_2service;
	@Autowired
	private OpRoute_3ServiceImp oproute_3service;
	@Autowired
	private OpRoute_4ServiceImp oproute_4service;
	@Autowired
	private OpRoute_5ServiceImp oproute_5service;
	@Autowired
	private OpRoute_6ServiceImp oproute_6service;
	@Autowired
	private OpRoute_7ServiceImp oproute_7service;
	@Autowired
	private OpRoute_8ServiceImp oproute_8service;
	@Autowired
	private OpRoute_9ServiceImp oproute_9service;
	
	private SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String View(Model model) {
		Common data=new Common();
		data.setDate(format.format(new Date()));
		model.addAttribute("data", data);
		
		return "NewFrp/commonreportfrp";
	}
	@RequestMapping(value="/ViewDownload", method=RequestMethod.GET)
	public String ViewDownload(Model model) {
		model.addAttribute("startDate",
				format.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("endDate", format.format(new Date()));
		
		return "NewFrp/frpObccDownloadReport";
	}
	@RequestMapping(value="/hit", method=RequestMethod.POST)
	public void HitkObcc(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("application/json");		
		
		String date=request.getParameter("date");
		String position=request.getParameter("position");
		Map<String,String> map=new HashMap<String,String>();	
		
		if (position.equals("OP1")) 
		{
			List<OpRoute_1> data = oproute_1service.getData(date,date);
			if(data.size()>0)
			{
				for(OpRoute_1 dt:data) {
					map.put("ok1",dt.getOk());
					map.put("ok2",dt.getButton1pm());
					map.put("ok3",dt.getButton5pm());
					map.put("ok4",dt.getButton9pm());
					map.put("ok5",dt.getButton1am());
					map.put("ok6",dt.getButton5am());
				}
				
			}
			
		}
		else if (position.equals("OP2"))
		{
			List<OpRoute_2> data = oproute_2service.getData(date,date);
			if(data.size()>0)
			{
				for(OpRoute_2 dt:data) {
					map.put("ok1",dt.getOk());
					map.put("ok2",dt.getButton1pm());
					map.put("ok3",dt.getButton5pm());
					map.put("ok4",dt.getButton9pm());
					map.put("ok5",dt.getButton1am());
					map.put("ok6",dt.getButton5am());
				}
			}	
		}
		else if (position.equals("OP3"))
		{
			List<OpRoute_3> data = oproute_3service.getData(date,date);
			if(data.size()>0)
			{
				for(OpRoute_3 dt:data) {
					map.put("ok1",dt.getOk());
					map.put("ok2",dt.getButton1pm());
					map.put("ok3",dt.getButton5pm());
					map.put("ok4",dt.getButton9pm());
					map.put("ok5",dt.getButton1am());
					map.put("ok6",dt.getButton5am());
				}
			}	
		}
		else if (position.equals("OP4"))
		{
			List<OpRoute_4> data = oproute_4service.getData(date,date);
			if(data.size()>0)
			{
				for(OpRoute_4 dt:data) {
					map.put("ok1",dt.getOk());
					map.put("ok2",dt.getButton1pm());
					map.put("ok3",dt.getButton5pm());
					map.put("ok4",dt.getButton9pm());
					map.put("ok5",dt.getButton1am());
					map.put("ok6",dt.getButton5am());
				}
			}
		}
		else if (position.equals("OP5"))
		{
			List<OpRoute_5> data = oproute_5service.getData(date,date);
			if(data.size()>0)
			{
				for(OpRoute_5 dt:data) {
					map.put("ok1",dt.getOk());
					map.put("ok2",dt.getButton1pm());
					map.put("ok3",dt.getButton5pm());
					map.put("ok4",dt.getButton9pm());
					map.put("ok5",dt.getButton1am());
					map.put("ok6",dt.getButton5am());
				}
			}
		}
		else if (position.equals("OP6"))
		{
			List<OpRoute_6> data = oproute_6service.getData(date,date);
			if(data.size()>0)
			{
				for(OpRoute_6 dt:data) {
					map.put("ok1",dt.getOk());
					map.put("ok2",dt.getButton1pm());
					map.put("ok3",dt.getButton5pm());
					map.put("ok4",dt.getButton9pm());
					map.put("ok5",dt.getButton1am());
					map.put("ok6",dt.getButton5am());
				}
			}
		}
		else if (position.equals("OP7"))
		{
			List<OpRoute_7> data = oproute_7service.getData(date,date);
			if(data.size()>0)
			{
				for(OpRoute_7 dt:data) {
					map.put("ok1",dt.getOk());
					map.put("ok2",dt.getButton1pm());
					map.put("ok3",dt.getButton5pm());
					map.put("ok4",dt.getButton9pm());
					map.put("ok5",dt.getButton1am());
					map.put("ok6",dt.getButton5am());
				}
			}	
		}
		else if (position.equals("OP8"))
		{
			List<OpRoute_8> data = oproute_8service.getData(date,date);
			if(data.size()>0)
			{
				for(OpRoute_8 dt:data) {
					map.put("ok1",dt.getOk());
					map.put("ok2",dt.getButton1pm());
					map.put("ok3",dt.getButton5pm());
					map.put("ok4",dt.getButton9pm());
					map.put("ok5",dt.getButton1am());
					map.put("ok6",dt.getButton5am());
				}
			}	
		}
		else if (position.equals("OP9"))
		{
			List<OpRoute_9> data = oproute_9service.getData(date,date);
			if(data.size()>0)
			{
				for(OpRoute_9 dt:data) {
					map.put("ok1",dt.getOk());
					map.put("ok2",dt.getButton1pm());
					map.put("ok3",dt.getButton5pm());
					map.put("ok4",dt.getButton9pm());
					map.put("ok5",dt.getButton1am());
					map.put("ok6",dt.getButton5am());
				}
			}	
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	@RequestMapping(value="/checkdata", method=RequestMethod.POST)
	public void CheckObcc(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		response.setContentType("application/json");		
		
		String date=request.getParameter("date");
		String position=request.getParameter("position");
		Map<String,Boolean> map=new HashMap<String,Boolean>();				
		boolean check=false; 
		if (position.equals("OP1")) 
		{
			List<OpRoute_1> data = oproute_1service.getData(date,date);
			if(data.size()==0)
				check=false; 
			else
				check=true; 
		}
		else if (position.equals("OP2"))
		{
			List<OpRoute_2> data = oproute_2service.getData(date,date);
			if(data.size()==0)
				check=false; 
			else
				check=true;
		}
		else if (position.equals("OP3"))
		{
			List<OpRoute_3> data = oproute_3service.getData(date,date);
			if(data.size()==0)
				check=false; 
			else
				check=true;
		}
		else if (position.equals("OP4"))
		{
			List<OpRoute_4> data = oproute_4service.getData(date,date);
			if(data.size()==0)
				check=false; 
			else
				check=true;
		}
		else if (position.equals("OP5"))
		{
			List<OpRoute_5> data = oproute_5service.getData(date,date);
			if(data.size()==0)
				check=false; 
			else
				check=true;
		}
		else if (position.equals("OP6"))
		{
			List<OpRoute_6> data = oproute_6service.getData(date,date);
			if(data.size()==0)
				check=false; 
			else
				check=true;
		}
		else if (position.equals("OP7"))
		{
			List<OpRoute_7> data = oproute_7service.getData(date,date);
			if(data.size()==0)
				check=false; 
			else
				check=true;
		}
		else if (position.equals("OP8"))
		{
			List<OpRoute_8> data = oproute_8service.getData(date,date);
			if(data.size()==0)
				check=false; 
			else
				check=true;
		}
		else if (position.equals("OP9"))
		{
			List<OpRoute_9> data = oproute_9service.getData(date,date);
			if(data.size()==0)
				check=false; 
			else
				check=true;
		}
		map.put("check", check);
		response.getWriter().write(new Gson().toJson(map));
		
		System.out.println(new Gson().toJson(map));		
	}
	@RequestMapping(value = "/view/report/data/detailedreport/export", method = RequestMethod.POST)
	public String export(@RequestParam("date") String date,
			@RequestParam("position") String position,HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		if (position.equals("OP1")) {
			List<OpRoute_1> data = oproute_1service.getData(date,date);
			long percentage=oproute_1service.getCountDatePercentage(date,date);
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=Op route 1 process floor.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/opRpoute_1.xlsx");
				excelreporthandler.getExcelReportOpRoute_1(data, percentage, file,response.getOutputStream());				
		}
		else if (position.equals("OP2")) {
			
			List<OpRoute_2> data = oproute_2service.getData(date,date);
			long percentage=oproute_2service.getCountDatePercentage(date,date);
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=Op route 2 process floor.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/opRpoute_2.xlsx");
				excelreporthandler.getExcelReportOpRoute_2(data, percentage,file,response.getOutputStream());
			
		}
		else if (position.equals("OP3")) {
			
			List<OpRoute_3> data = oproute_3service.getData(date,date);
			long percentage=oproute_3service.getCountDatePercentage(date,date);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=Op route 3 process floor.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/opRpoute_3.xlsx");
				excelreporthandler.getExcelReportOpRoute_3(data,percentage, file,response.getOutputStream());
		}
		else if (position.equals("OP4")) {
			
			List<OpRoute_4> data = oproute_4service.getData(date,date);
			long percentage=oproute_4service.getCountDatePercentage(date,date);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=Op route 4 Basement.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/opRpoute_4.xlsx");
				excelreporthandler.getExcelReportOpRoute_4(data,percentage, file,response.getOutputStream());
		}
		else if (position.equals("OP5")) {
			
			List<OpRoute_5> data = oproute_5service.getData(date,date);
			long percentage=oproute_5service.getCountDatePercentage(date,date);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=Op route 5 Basement.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/opRpoute_5.xlsx");
				excelreporthandler.getExcelReportOpRoute_5(data,percentage, file,response.getOutputStream());
		}
		else if (position.equals("OP6")) {
			
			List<OpRoute_6> data = oproute_6service.getData(date,date);
			long percentage=oproute_6service.getCountDatePercentage(date,date);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=Op route 6 Basement.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/opRpoute_6.xlsx");
				excelreporthandler.getExcelReportOpRoute_6(data,percentage, file,response.getOutputStream());
		}	
		else if (position.equals("OP7")) {
			
			List<OpRoute_7> data = oproute_7service.getData(date,date);
			long percentage=oproute_7service.getCountDatePercentage(date,date);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=Op route 7 OutSide.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/opRpoute_7.xlsx");
				excelreporthandler.getExcelReportOpRoute_7(data,percentage, file,response.getOutputStream());
		}
		else if (position.equals("OP8")) {
			
			List<OpRoute_8> data = oproute_8service.getData(date,date);
			long percentage=oproute_8service.getCountDatePercentage(date,date);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=Op route 8 OutSide.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/opRpoute_8.xlsx");
				excelreporthandler.getExcelReportOpRoute_8(data,percentage, file,response.getOutputStream());
		}
		else if (position.equals("OP9")) {
			
			List<OpRoute_9> data = oproute_9service.getData(date,date);
			long percentage=oproute_9service.getCountDatePercentage(date,date);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition",
						"attachment; filename=Op route 9B Line Basement.xlsx");
				File file = new File(context.getRealPath("/")
						+ "WEB-INF/opRpoute_9.xlsx");
				excelreporthandler.getExcelReportOpRoute_9(data,percentage, file,response.getOutputStream());
		}
		return "redirect:/frpobccReport/view";
	}
	@RequestMapping(value = "/view/report/data/detailedreport/export/PDF", method = RequestMethod.GET)
	public String exportPDF(@RequestParam(value = "date") String date,
			@RequestParam(value = "position") String position,
			HttpServletResponse response, HttpServletRequest request,
			RedirectAttributes redirectAttributes) throws Exception {
		if (position.equals("OP1")) {
			List<OpRoute_1> datas = oproute_1service.getData(date,date);
			long percentage=oproute_1service.getCountDatePercentage(date,date);
			if (datas.size() != 0) {
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition",
						"attachment; filename=R2 Operator.pdf");
				pdfreporthandler.OpRoute_1Pdf(datas,response.getOutputStream(), percentage);
			} else {
				redirectAttributes.addFlashAttribute("message",
						"Data Not Found For Selected Createrria.");
				return "redirect:/frpobccReport/view";
			}			
		}
		return "redirect:/frpobccReport/view";
	}
	
	@RequestMapping(value = "/view/report/data/detailedreport/exportPercentage", method = RequestMethod.POST)
	public void exportPecenatgeData(@RequestParam("endDate") String endDate,HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		        Date edate=format.parse(endDate);
				String startDate=format.format(CommonUtil.getFirstDate(edate));
			
				long t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0,t8=0,t9=0;
				
				   List<Integer> count_1=oproute_1service.getCount(endDate,endDate);
				   List<Integer> count_2=oproute_2service.getCount(endDate,endDate);
				   List<Integer> count_3=oproute_3service.getCount(endDate,endDate);
				   List<Integer> count_4=oproute_4service.getCount(endDate,endDate);
				   List<Integer> count_5=oproute_5service.getCount(endDate,endDate);
				   List<Integer> count_6=oproute_6service.getCount(endDate,endDate);
				   List<Integer> count_7=oproute_7service.getCount(endDate,endDate);
				   List<Integer> count_8=oproute_8service.getCount(endDate,endDate);
				   List<Integer> count_9=oproute_9service.getCount(endDate,endDate);
				   
				   List<Integer> frpeMtd_1=oproute_1service.getCount(startDate,endDate);
				   List<Integer> frpeMtd_2=oproute_2service.getCount(startDate,endDate);
				   List<Integer> frpeMtd_3=oproute_3service.getCount(startDate,endDate);
				   List<Integer> frpeMtd_4=oproute_4service.getCount(startDate,endDate);
				   List<Integer> frpeMtd_5=oproute_5service.getCount(startDate,endDate);
				   List<Integer> frpeMtd_6=oproute_6service.getCount(startDate,endDate);
				   List<Integer> frpeMtd_7=oproute_7service.getCount(startDate,endDate);
				   List<Integer> frpeMtd_8=oproute_8service.getCount(startDate,endDate);
				   List<Integer> frpeMtd_9=oproute_9service.getCount(startDate,endDate);
		    
				   for(Integer op:frpeMtd_1){ t1=t1+op; }
				   for(Integer op:frpeMtd_2){ t2=t2+op; }
				   for(Integer op:frpeMtd_3){ t3=t3+op; }
				   for(Integer op:frpeMtd_4){ t4=t4+op; }
				   for(Integer op:frpeMtd_5){ t5=t5+op; }
				   for(Integer op:frpeMtd_6){ t6=t6+op; }
				   for(Integer op:frpeMtd_7){ t7=t7+op; }
				   for(Integer op:frpeMtd_8){ t8=t8+op; }
				   for(Integer op:frpeMtd_9){ t9=t9+op; }
				   
				   int days=CommonUtil.getDaysDiffernce(format.parse(startDate),format.parse(endDate))+1;
				   long totalcount=0,actualcount=0,completfrpMtd=0;
				   totalcount= t1+t2+t3+t4+t5+t6+t7+t8+t9;
				   actualcount=days*54;
				   completfrpMtd=(totalcount*100)/actualcount;
				  
			/*****----------------All are Working fine---------------**********/
		
	response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	response.setHeader("Content-Disposition","attachment; filename=frpObccDownload.xlsx");
		File file = new File(context.getRealPath("/")+ "WEB-INF/opcommonReort.xlsx");

		excelreporthandler.getExcelReportbyPercentage(count_1,count_2,count_3,count_4,count_5,count_6,count_7,
				count_8,count_9,completfrpMtd,endDate,file,response.getOutputStream());
}
}
