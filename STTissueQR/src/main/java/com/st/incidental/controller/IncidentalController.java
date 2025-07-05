/**
 *Mar 27, 2018
 *IncidentalController.java
 * TODO
 *com.st.incidental.controller
 *IncidentalController.java
 *Roshan Lal Tailor
 */
package com.st.incidental.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.common.FileLastModifiedComparator;
import com.st.common.model.UserAuditor;
import com.st.incidental.mailer.IncidentalMailer;
import com.st.incidental.model.Incidental;
import com.st.incidental.report.IncidentalReportHandler;
import com.st.incidental.service.IncidentalService;
import com.st.safetylog.model.SafetyHousekeepingAction;
import com.st.wastepaper.comman.WastepaperComman;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/incidentaluser")
public class IncidentalController {
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@Value("${incidental.file.folder}")
	private String housekeepingFileBackupLocation;
	
	@Autowired
	private IncidentalService incidentalService;
	
	@Autowired
	private IncidentalMailer incidentalMailer;
	
	@Autowired
	private IncidentalReportHandler incidentalReportHandler;
	
	@RequestMapping("/manage")
	public String manage(Model model) {
		
		Incidental auditor=new Incidental();
		model.addAttribute("auditor", auditor);
		
		List<Incidental> auditors=incidentalService.getUserAutiors();
		model.addAttribute("status",WastepaperComman.getStatus());
		model.addAttribute("auditors", auditors);
		
		return "incidental/manageIncidentalAuditor";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("auditor")Incidental auditor,
			RedirectAttributes redirectAttributes,
			Model model) {
		
		List<Incidental> auditors=incidentalService.getUserAutiors();
		model.addAttribute("auditors", auditors);
		
		model.addAttribute("auditor", auditor);
		
		if(StringUtils.isEmpty(auditor.getName())){
			model.addAttribute("error", "Please enter auditor name!");
			return "incidental/manageIncidentalAuditor";
		}
		
		if(StringUtils.isEmpty(auditor.getEmail())){
			model.addAttribute("error", "Please enter email!");
			return "incidental/manageIncidentalAuditor";
		}
		
	//	System.out.println(CommonUtil.isValidEmail(auditor.getEmail()));
	
		if(CommonUtil.isValidEmail(auditor.getEmail())){
			model.addAttribute("error", "Please enter valid email!");
			return "incidental/manageIncidentalAuditor";
		}
		
		try {
			incidentalService.saveOrUpdate(auditor);
		} catch (Exception e) {
			model.addAttribute("error", "Failed to save data. Error:-"+e.getMessage());
			return "incidental/manageIncidentalAuditor";
		}
		
		if(auditor.getId()==0){
			redirectAttributes.addFlashAttribute("message", "Data saved in database successfully.");
			return "redirect:/incidentaluser/manage";
		}else{
			redirectAttributes.addFlashAttribute("message", "Data updated in database successfully.");
			return "redirect:/incidentaluser/edit/"+auditor.getId();
		}
		
		
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")int id,Model model) {
		
		Incidental auditor=incidentalService.getUserAuditor(id);
		model.addAttribute("auditor", auditor);
		
		List<Incidental> auditors=incidentalService.getUserAutiors();
		model.addAttribute("status",WastepaperComman.getStatus());
		model.addAttribute("auditors", auditors);
		
		return "incidental/manageIncidentalAuditor";
	}
	@RequestMapping(value="/edit/status", method=RequestMethod.POST)
	public @ResponseBody Map<String , Object> save(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map<String , Object> map=new HashMap<String,Object>();
		try{
			String _email=CommonUtil.checkNull(request.getParameter("email"));
			String _status=CommonUtil.checkNull(request.getParameter("status"));
			
			Incidental data=new Incidental();
			data.setEmail(_email);
			data.setStatus(_status);
			
			incidentalService.editAuditorStatus(data);
			map.put("status", true);
			map.put("message", "Data Saved Successfully.");
			
		}catch(Exception rlt){
			System.out.println("Roshan Says, You Have Problem In /edit/status Method in IncidentalController.java");
			rlt.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/upload/documents")
	public String uploadDocuments(Model model) {
		
		Incidental auditor=new Incidental();
		model.addAttribute("auditor", auditor);
		
		return "incidental/uploadIncidentalDocuments";
	}
	/*@RequestMapping(value="/save/action",method=RequestMethod.POST)
	public String saveAction(@RequestParam("file")MultipartFile file,@ModelAttribute("auditor")Incidental auditor,RedirectAttributes redirectAttributes,Model model) {*/
	
		@RequestMapping(value="/save/action", method=RequestMethod.POST)
		public String saveShiftSchedule(@RequestParam("file")MultipartFile file,RedirectAttributes redirectAttributes,Model model,HttpServletRequest request) {
			
			Incidental auditor= new Incidental();
		
			String comment=CommonUtil.checkNull(request.getParameter("comment"));
			String description=CommonUtil.checkNull(request.getParameter("description"));
			auditor.setComment(comment);
			auditor.setDate(new Date());
			auditor.setDescription(description);
			
			auditor.setDocid(UUID.randomUUID()+"."+FilenameUtils.getExtension(file.getOriginalFilename()));
			
			if(!file.isEmpty()){
				
				//String fileName=UUID.randomUUID()+"."+FilenameUtils.getExtension(file.getOriginalFilename());
				String fileName=file.getOriginalFilename();
				
				File backupFile=new File(housekeepingFileBackupLocation);
				if(!backupFile.exists()){
					backupFile.mkdirs();
				}
				
				String folder=System.getProperty("catalina.base")+"/Incidental_Uploaded_Documents_Roshan";
				File uploadedFile=new File(folder);
				if(!uploadedFile.exists()){
					uploadedFile.mkdirs();
				}
				
				
				
				
				try {
					File fileLocal=new File(uploadedFile, fileName);
					FileOutputStream inputStream1=new FileOutputStream(fileLocal);
					IOUtils.copy(file.getInputStream(), inputStream1);
					inputStream1.close();
					
					File fileRemote=new File(backupFile, fileName);
					FileOutputStream inputStream2=new FileOutputStream(fileRemote);
					IOUtils.copy(file.getInputStream(), inputStream2);
					inputStream2.close();
					
					auditor.setFile(fileName);
					model.addAttribute("message", "File Upload Successfully.");
				} catch (IOException e) {
					e.printStackTrace();
					model.addAttribute("error", "Fail to upload file. Please try again. Error:-"+e.getMessage());
					return "incidental/uploadIncidentalDocuments";
				}
				
				
				
			}
			
		try {
			
			incidentalService.uploadDocuments(auditor);
			
			int id=(int) incidentalService.getLastUplodedDocId(auditor.getDocid());
			
			List<Incidental> userAuditors=incidentalService.getUserAutiors_Active();
			
			List<String> emailList=new ArrayList<>();
			for (Incidental userAuditor : userAuditors) {
				if(StringUtils.isNotEmpty(userAuditor.getEmail())){
					emailList.add(userAuditor.getEmail());
				}
			}
			
			String[] emails=new String[emailList.size()];
			for (int i=0;i<emailList.size();i++) {
				emails[i]=emailList.get(i);
			}
			final String[] finalEmail=emails;
			
			
			incidentalMailer.sendMailToAuditores(auditor,finalEmail,id,auditor.getDescription(),auditor.getComment());
			
			redirectAttributes.addAttribute("message", "File Upload Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Fail to save data in database. Error:-"+e.getMessage());
			return "safetylog/safetyHousekeepingNewAction";
		}
		return "redirect:/incidentaluser/upload/documents/";
	}
	@RequestMapping("/report/show")
	public String incidentalReport(Model model) {
		
		Incidental auditor=new Incidental();
		model.addAttribute("auditor", auditor);
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		return "incidental/uploadIncidentalReport";
	}
	@RequestMapping(value="/view/data",method=RequestMethod.GET)
	public String incidentalReportShow(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,Model model) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<Incidental> details=incidentalService.getIncidentalReportData(sDate,eDate);
		
		model.addAttribute("details", details);
		model.addAttribute("path", System.getProperty("catalina.base"));
		
		return "incidental/uploadIncidentalReport";
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void delete(HttpServletRequest request,
			HttpServletResponse response
			) throws IOException {
		response.setContentType("application/json");
		Map<String, Boolean> map=new HashMap<String, Boolean>();
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		try{
			incidentalService.delete(id);
			map.put("status", true);
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", false);
		}
		
		response.getWriter().write(new Gson().toJson(map));
	}

	@RequestMapping(value="/view/data/downloadfile/{id}")
	public void downloadShiftSchedule(@PathVariable("id")int id,HttpServletResponse response) throws Exception 
	{
		String filename="";
		List<Incidental> details=incidentalService.getUploadedFileById(id);
		
		for(Incidental data:details){
			filename=data.getFile();
		}
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String gurupath = System.getProperty("catalina.base");
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""+ filename + "\"");

		FileInputStream fileInputStream = new FileInputStream(gurupath.concat("\\Incidental_Uploaded_Documents_Roshan\\")+filename);

		int i;
		while ((i = fileInputStream.read()) != -1) {
		out.write(i);
		}
		fileInputStream.close();
		out.close();*/
		/*try {
			
			File folder=new File(System.getProperty("catalina.base")+"/Incidental_Uploaded_Documents_Roshan"+filename);
			
			File[] files=folder.listFiles();
			
			Arrays.sort(files, new FileLastModifiedComparator());
			
			File file=files[0];
			
			response.setContentType(CommonUtil.getFileContentType(file));
			
			response.setHeader("Content-Disposition", "inline; filename="+folder);
			
			response.setHeader("Content-Disposition", "inline; filename=Mill_Calendar."+FilenameUtils.getExtension(file.getName()));
			
			FileInputStream inputStream=new FileInputStream(file);
			IOUtils.copy(inputStream, response.getOutputStream());
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		 response.setContentType("text/plain");
		 
	        
         response.setHeader("Content-disposition","attachment; filename="+filename); // Used to name the download file and its format
 
         File my_file = new File(System.getProperty("catalina.base")+"/Incidental_Uploaded_Documents_Roshan/"+filename); // We are downloading .txt file, in the format of doc with name check - check.doc
 
         
         OutputStream out = response.getOutputStream();
         FileInputStream in = new FileInputStream(my_file);
         byte[] buffer = new byte[4096];
         int length;
         while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
         }
         in.close();
         out.flush();
         
	}
	@RequestMapping(value="/review/action/{id}",method=RequestMethod.GET)
	public String closeAction(@PathVariable("id")int id,Model model) throws IOException {
		
		List<Incidental> details=incidentalService.getUploadedFileById(id);
		List<Incidental> auditors=incidentalService.getUserAutiors();
		
		//housekeepingAction.setClosed(new Date());
		model.addAttribute("housekeepingAction", details);
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("auditors", auditors);
		model.addAttribute("id", id);
		
		return "incidental/uploadIncidentalReportReview";
		
	}
	@RequestMapping(value="/review/action/save",method=RequestMethod.POST)
	public String closeActionSave(HttpServletRequest request,Model model) throws IOException {
		
		Incidental incidental=new Incidental();
		
		int id=CommonUtil.checkInt(request.getParameter("id"));
		Date date=CommonUtil.checkDate(request.getParameter("date"), dateFormat);
		String name=CommonUtil.checkNull(request.getParameter("name"));
		String comment=CommonUtil.checkNull(request.getParameter("comment"));
		
		incidental.setId(id);
		incidental.setDate(date);
		incidental.setName(name);
		incidental.setComment(comment);
		
		try {
			incidentalService.reviewAction(incidental);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error","Can't close! Error:-"+e.getMessage());
			return "incidental/uploadIncidentalReport";
		}
		model.addAttribute("message", "Incidental Document Review Successfully.");
		model.addAttribute("flag", 1);
		return "incidental/uploadIncidentalReportReview";
		
	}
	@RequestMapping(value="/check/reviedotnot",method=RequestMethod.POST)
	public void checkVacationHours(HttpServletRequest request,HttpServletResponse response){
		
		response.setContentType("application/json");

		String name= CommonUtil.checkNull(request.getParameter("name"));
		int id= CommonUtil.checkInt(request.getParameter("id"));

		int reviewdornot=(int) incidentalService.checkDocumentIsReviewdOrNot(name,id);
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("reviewdornot",reviewdornot);
		
		try {
			response.getWriter().write(new Gson().toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/report/reviewedactions")
	public String reportReviewedActions(Model model) {
		
		Incidental auditor=new Incidental();
		model.addAttribute("auditor", auditor);
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("show", false);
		model.addAttribute("pdf", false);
		
		return "incidental/uploadIncidentalReviewedActionsReport";
	}
	
	@RequestMapping(value="/report/reviewedactions/show",method=RequestMethod.GET)
	public String reportReviewedActionsShow(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,Model model) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("show", true);
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<Incidental> details=incidentalService.getReportReviewedActionsShow(sDate,eDate);
		List<Incidental> details1=incidentalService.getReportReviewedActionsShow_Comment();
		List<Incidental> userAuditors=incidentalService.getUserAutiors_Active();
		
		model.addAttribute("details", details);
		model.addAttribute("details1", details1);
		model.addAttribute("details2", userAuditors);
		model.addAttribute("pdf", true);
		
		return "incidental/uploadIncidentalReviewedActionsReport";
	}
	@RequestMapping(value="/report/reviewedactions/show/pdf",method=RequestMethod.GET)
	public void exportOpenReportPdf(@RequestParam("sdate")String sdate,@RequestParam("edate")String edate,HttpServletResponse response) throws Exception {
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<Incidental> details=incidentalService.getReportReviewedActionsShow(sDate,eDate);
		List<Incidental> details1=incidentalService.getReportReviewedActionsShow_Comment();
		List<Incidental> userAuditors=incidentalService.getUserAutiors_Active();
		
		
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=\"INCIDENTAL DOCUMENT ACTION(S).pdf\"");
		
		incidentalReportHandler.reviewedActionsPDFReport(details,details1,response.getOutputStream());
		 
	}
}
