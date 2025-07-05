/**
 * 
 */
package com.st.productionpm5.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.production.service.WrapperProductionService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/wrapperredcodereportpm5")
public class WrapperRedCodeReportControllerPM5 {

	@Autowired
	private ServletContext context;
	
	
	@Autowired
	private WrapperProductionService wrapperProductionService;
	
	
	
	
	private SimpleDateFormat dateFormat3=new SimpleDateFormat("MMMM yyyy");
	
	

	
	
	//Report by Red Code
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(Model model) {
		
		model.addAttribute("sdate", dateFormat3.format(new Date()));
		model.addAttribute("edate", dateFormat3.format(new Date()));
		model.addAttribute("viewFlag", false);
		return "productionWastepaper/productionWrapRedCodeReport";
	}
	
	
	//Report by Red Code
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String view(HttpServletRequest request,Model model) throws ProductionException {
		
		//
		//refreshResource.refresh();
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat3);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat3);
		
		model.addAttribute("sdate", dateFormat3.format(sdate));
		model.addAttribute("edate", dateFormat3.format(edate));

		Map<String, Object> data=new HashMap<String, Object>();
		
		data=wrapperProductionService.getWrapperDataByRedCode(sdate,edate);
		
		
		model.addAttribute("viewFlag", true);
		model.addAttribute("data", data);
		
		
		return "productionWastepaper/productionWrapRedCodeReport";
	}
	
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public void exportData(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException, ProductionException {
		
		//
	//	refreshResource.refresh();
		
		
		
		
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat3);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat3);
		
		
	//	System.out.println("Equal Date="+CommonUtil.isEqual(sdate, edate));
		
		
		model.addAttribute("sdate", dateFormat3.format(sdate));
		model.addAttribute("edate", dateFormat3.format(edate));

		Map<String, Object> data=new HashMap<String, Object>();
		
		data=wrapperProductionService.getWrapperDataByRedCode(sdate,edate);
		
		
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=ST Tissue Wrapper Red Reject Tons Reject.xls");
		
		File file=new File(context.getRealPath("/")+"WEB-INF/excel template/productionWrapper/Wrapper Red Reject Tons.xls");

		HSSFWorkbook workbook=wrapperProductionService.getFormatedWorkbookForWrapperRedCode(file,data,sdate,edate);
		workbook.write(response.getOutputStream());

	}
	
}
