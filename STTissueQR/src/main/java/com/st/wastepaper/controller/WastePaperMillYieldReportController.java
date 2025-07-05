/**
 *Mar 9, 2016
 *WastePaperMillYieldReportController.java
 * TODO
 *com.st.wastepaper.controller
 *WastePaperMillYieldReportController.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.common.CommonUtil;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.service.BarcodeConsumedBalesReportService;
import com.st.wastepaper.report.WastePaperMillYieldReportExportHandler;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/wastepapermillyieldreport")
public class WastePaperMillYieldReportController {		
		private static final String VIEW_PAGE="viewpage";
		
		private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		
		@Autowired
		private ServletContext context;
		
		@Autowired
		private BarcodeConsumedBalesReportService barcodeconsumedbalesreportservice ;
		
		@Autowired
		private WastePaperMillYieldReportExportHandler WastePaperMillYieldReportExportHandler ;
		
		@RequestMapping(value="/view",method=RequestMethod.GET)
		public String view(Model model,HttpServletRequest request, HttpServletResponse response){
			model.addAttribute("sdate", dateFormat.format(new Date()));
			model.addAttribute("edate", dateFormat.format(new Date()));
			return "WastePaperMillYieldReport";
		}
		@RequestMapping(value="/view/data",method=RequestMethod.GET)
		public String  viewdata(HttpServletRequest request,HttpServletResponse response,Model model) {
			
			Date startdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
			Date enddate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
			
			List<WastePaperBaleInventory> consumedbalesdata=barcodeconsumedbalesreportservice.getCounsumedBalesForMillYieldReort(startdate,enddate);
			
			model.addAttribute(VIEW_PAGE, true);
			model.addAttribute("sdate", dateFormat.format(startdate));
			model.addAttribute("edate", dateFormat.format(enddate));
			model.addAttribute("consumedbalesdata", consumedbalesdata);
			
			return "WastePaperMillYieldReportView";
		}
		@RequestMapping(value="/entermilldata",method=RequestMethod.GET)
		public String entermilldata(Model model,HttpServletRequest request, HttpServletResponse response){
			model.addAttribute("sdate", dateFormat.format(new Date()));
			model.addAttribute("edate", dateFormat.format(new Date()));
			model.addAttribute("show", false);
			return "WastePaperMillYieldReportEnterData";
		}
		@RequestMapping(value="/entermilldata/new/{date}",method=RequestMethod.GET)
		public String loaddataforshiftanddate(@PathVariable("date")String sdate,Model model) {
			
			Date sDate=CommonUtil.checkDate(sdate, dateFormat);
			
			List<WastePaperBaleInventory> data=barcodeconsumedbalesreportservice.getMillYieldDataEntry(sDate,sDate);
			
			model.addAttribute("sdate", dateFormat.format(sDate));
			model.addAttribute("data", data);
			model.addAttribute("show", true);
			return "WastePaperMillYieldReportEnterData";
		}
		@RequestMapping(value="/entermilldata/save",method=RequestMethod.POST)
		public String addnewEstimatedFreight(HttpServletRequest request,HttpServletResponse response,Model model,RedirectAttributes redirectAttributes) throws IOException{
			//Map<String, Object> map=new HashMap<String, Object>();
			try{
				Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
				int id=CommonUtil.checkInt(request.getParameter("id"));
				double broke=CommonUtil.checkDouble(request.getParameter("broke"));
				double cgwd=CommonUtil.checkDouble(request.getParameter("cgwd"));
				double cgwdSection=CommonUtil.checkDouble(request.getParameter("cgwdSection"));
				double sw=CommonUtil.checkDouble(request.getParameter("sw"));
				double whiteBland=CommonUtil.checkDouble(request.getParameter("whiteBland"));
				double whiteBlend=CommonUtil.checkDouble(request.getParameter("whiteBlend"));
				double STBalesWetLap=CommonUtil.checkDouble(request.getParameter("STBalesWetLap"));
				double ScaVirginPulp=CommonUtil.checkDouble(request.getParameter("ScaVirginPulp"));
				double TrimLoss=CommonUtil.checkDouble(request.getParameter("TrimLoss"));
				
				WastePaperBaleInventory yielddata=new WastePaperBaleInventory();
				
				  yielddata.setDate(sdate);	
				  yielddata.setId(id);
				  yielddata.setYieldbroke(broke);
				  yielddata.setYieldcgwd(cgwd);
				  yielddata.setYieldcgwdsection(cgwdSection);
				  yielddata.setYieldsw(sw);
				  yielddata.setYieldwhitebland(whiteBland);
				  yielddata.setYieldwhiteblend(whiteBlend);
				  yielddata.setYieldstbaleswetLap(STBalesWetLap);
				  yielddata.setYieldscavirginpulp(ScaVirginPulp);
				  yielddata.setYieldtrimloss(TrimLoss);
				  
				  
				  if(yielddata.getId()==0){
					  //Save The Data
					  	int key=barcodeconsumedbalesreportservice.saveYieldData(yielddata);
					  	model.addAttribute("status", true);
					  	model.addAttribute("message", "Data Saved Successfully");
						
				  }else{
					  //Update The Data
					  	barcodeconsumedbalesreportservice.updateYieldData(yielddata);
						model.addAttribute("status", true);
						model.addAttribute("message", "Data Updated Successfully");
				  }
				
			}catch(Exception rlt){
				System.out.println("Roshan Say's, You Have An Error In addnewEstimatedFreight Method Ad WastepaperReportController.java ");
				rlt.printStackTrace();
			}
			//return "redirect:/wastepapermillyieldreport/entermilldata/status";
			model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
			return "WastePaperMillYieldReportEnterData";
		}
		@RequestMapping(value="/entermilldata/status",method=RequestMethod.GET)
		public String entermilldata1(Model model,HttpServletRequest request, HttpServletResponse response){
			model.addAttribute("sdate", dateFormat.format(new Date()));
			model.addAttribute("edate", dateFormat.format(new Date()));
			model.addAttribute("message","Data Save Successfully");
			return "WastePaperMillYieldReportEnterData";
		}
		@RequestMapping(value="/entermilldata/detailedreport",method=RequestMethod.GET)
		public String yieldentereddata(Model model,HttpServletRequest request, HttpServletResponse response){
			model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
			model.addAttribute("edate", dateFormat.format(new Date()));
			return "WastePaperMillYieldEnteredvalues";
		}
		@RequestMapping(value="/entermilldata/detailedreport/view",method=RequestMethod.GET)
		public String detailedreport(HttpServletRequest request,HttpServletResponse response,Model model) {
			
			Date startdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
			Date enddate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
			
			List<WastePaperBaleInventory> data=barcodeconsumedbalesreportservice.getMillYieldDataEntry(startdate,enddate);
			
			System.out.println("data::"+data.size());
			model.addAttribute(VIEW_PAGE, true);
			model.addAttribute("sdate", dateFormat.format(startdate));
			model.addAttribute("edate", dateFormat.format(enddate));
			model.addAttribute("data", data);
			
			return "WastePaperMillYieldEnteredvalues";
		}
		
		
		@RequestMapping(value="/exportreport",method=RequestMethod.POST)
		public void exportreport(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws Exception{
			
			SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			Date startdate=CommonUtil.checkDate(sdate, df);
			Date enddate=CommonUtil.checkDate(edate, df);
			
			List<WastePaperBaleInventory> consumedbalesdata=barcodeconsumedbalesreportservice.getCounsumedBalesForMillYieldReort(startdate,enddate);
			
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=WastePaper_Mill_Yield_Report_STPAPEROne.xlsx");
			File file=new File(context.getRealPath("/")+"WEB-INF/WastePaper_Mill_Yield_Report_STPAPER.xlsx");
			
			WastePaperMillYieldReportExportHandler.getExportWastePAperMillYieldReport(consumedbalesdata,file,response.getOutputStream());
			
			}
}
