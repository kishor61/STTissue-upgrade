/**
 * 
 */
package com.st.oimnotes.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.common.OimCommon;
import com.st.oimnotes.model.Category;
import com.st.oimnotes.model.FollowUp;
import com.st.oimnotes.model.FollowUpHistory;
import com.st.oimnotes.model.Summary;
import com.st.oimnotes.service.OimNotesService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/oimnotes")
public class OimNotesController {
	
	@Value("${followups.file.folder}")
	private String documentFileBackupLocation;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private OimNotesService oimNotesService;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String main(HttpServletRequest request,Model model) {
		
		String categoryId=request.getParameter("categoryId");
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		
		
		if(StringUtils.isNotEmpty(categoryId) && StringUtils.isNotEmpty(sdate) && StringUtils.isNotEmpty(edate)){
			model.addAttribute("categoryId", categoryId);
			model.addAttribute("sdate", sdate);
			model.addAttribute("edate", edate);
		}else if(StringUtils.isNotEmpty(sdate) && StringUtils.isNotEmpty(edate)){
			model.addAttribute("sdate", sdate);
			model.addAttribute("edate", edate);
		}
			
			
		return "oimnotes/oimNotesMain";
	}
	
	@RequestMapping(value="/category",method=RequestMethod.GET)
	public String category(Model model) {
		model.addAttribute("category", new Category());
		
		List<Category> categories=oimNotesService.getCategory();
		model.addAttribute("categories", categories);
		
		return "oimnotes/oimNotesCategory";
	}
	
	@RequestMapping(value="/category/edit/{id}",method=RequestMethod.GET)
	public String categoryEdit(@PathVariable("id")int id,Model model) {
		
		Category category=oimNotesService.getCategory(id);
		
		model.addAttribute("category", category);
		
		List<Category> categories=oimNotesService.getCategory();
		model.addAttribute("categories", categories);
		
		return "oimnotes/oimNotesCategory";
	}
	
	
	@RequestMapping(value="/category/save",method=RequestMethod.POST)
	public String categorySave(@ModelAttribute("category")Category category,RedirectAttributes redirectAttributes,Model model) {
		
		model.addAttribute("category", category);
		
		if(StringUtils.isEmpty(category.getCategory())){
			
			model.addAttribute("error", "Please enter category name!");
			return "oimnotes/oimNotesCategory";
		}
		try {
			oimNotesService.saveOrUpdate(category);
		} catch (Exception e) {
			
			List<Category> categories=oimNotesService.getCategory();
			model.addAttribute("categories", categories);
			
			model.addAttribute("error", "Invalid category.");
			return "oimnotes/oimNotesCategory";
		}
		if(category.getId()==0){
			redirectAttributes.addFlashAttribute("message", "Category saved successfully.");
		}else{
			redirectAttributes.addFlashAttribute("message", "Category updated successfully.");
		}
		
		return "redirect:/oimnotes/category";
	}
	
	
	@RequestMapping(value="/summary",method=RequestMethod.GET)
	public String summary(Model model) {
		
		model.addAttribute("show", true);
		
		Date sdate=CommonUtil.checkDate(dateFormat.format(CommonUtil.getFirstDate()), dateFormat);
		Date edate=CommonUtil.checkDate(dateFormat.format(new Date()), dateFormat);
		
		List<Summary> summaries=oimNotesService.getSummariesAll(sdate,edate);
		model.addAttribute("summaries", summaries);
		
		
		List<Category> categories=oimNotesService.getCategory();
		model.addAttribute("categories", categories);
		model.addAttribute("date", dateFormat.format(sdate));
		model.addAttribute("edate", dateFormat.format(edate));
		return "oimnotes/oimNotesSummary";
	}
	
	@RequestMapping(value="/summary/{sdate}/{edate}",method=RequestMethod.GET)
	public String summary(@PathVariable("sdate")String sdate,@PathVariable("edate")String edate,Model model) {
		
		model.addAttribute("show", true);
		
		Date sDate=CommonUtil.checkDate(sdate, dateFormat);
		Date eDate=CommonUtil.checkDate(edate, dateFormat);
		
		List<Summary> summaries=oimNotesService.getSummariesAll(sDate,eDate);
		model.addAttribute("summaries", summaries);
		
		
		List<Category> categories=oimNotesService.getCategory();
		model.addAttribute("categories", categories);
		model.addAttribute("date",sdate);
		model.addAttribute("edate",edate);
		return "oimnotes/oimNotesSummary";
	}
	
	@RequestMapping(value="/summary/view/{categoryId}/{date}/{edate}",method=RequestMethod.GET)
	public String summaryView(@PathVariable("categoryId")int categoryId,
			@PathVariable("date")String date,
			@PathVariable("edate")String edate,
			Model model) {
		
		List<Category> categories=oimNotesService.getCategory();
		model.addAttribute("categories", categories);
		model.addAttribute("date", date);
		model.addAttribute("edate", edate);
		model.addAttribute("categoryId", categoryId);
		
		Category category=new Category(categoryId);
		category=categories.get(categories.indexOf(category));
		
		model.addAttribute("categoryName", category.getCategory());
		
		model.addAttribute("show", true);
		Date d=CommonUtil.checkDate(date, dateFormat);
		Date ed=CommonUtil.checkDate(edate, dateFormat);
		
		List<Summary> summaries=oimNotesService.getSummaries(categoryId,d,ed);
		model.addAttribute("summaries", summaries);
		
		return "oimnotes/oimNotesSummary";
	}
	
	@RequestMapping(value="/summary/add",method=RequestMethod.GET)
	public String summaryAdd(Model model) {
		
		List<Category> categories=oimNotesService.getCategory();
		model.addAttribute("categories", categories);
		model.addAttribute("summaryObj",new Summary());
		return "oimnotes/oimNotesSummaryAdd";
	}
	
	@RequestMapping(value="/summary/edit/{id}",method=RequestMethod.GET)
	public String summaryEdit(@PathVariable("id")int id,Model model) {
		
		List<Category> categories=oimNotesService.getCategory();
		model.addAttribute("categories", categories);
		
		Summary summary=oimNotesService.getSummary(id);
		
		model.addAttribute("summaryObj",summary);
		
		
		return "oimnotes/oimNotesSummaryEdit";
	}
	
	@RequestMapping(value="/summary/save",method=RequestMethod.POST)
	public String summarySave(HttpServletRequest request,RedirectAttributes redirectAttributes,Model model) {
		
		int id=CommonUtil.checkInt(request.getParameter("id"));
		String summary=CommonUtil.checkNull(request.getParameter("summary"));
		Date date=CommonUtil.checkDate(request.getParameter("entryDate"), dateFormat);
		int categoryId=CommonUtil.checkInt(request.getParameter("categoryId"));
		
		
		Summary summaryObj=new Summary();
		summaryObj.setId(id);
		summaryObj.setSummary(summary);
		summaryObj.setEntryDate(date);
		summaryObj.setCategoryId(categoryId);
		
		
		try {
			oimNotesService.saveOrUpdate(summaryObj);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Server error:-"+e.getMessage());
			return "oimnotes/oimNotesSummaryAdd";
		}
		
		if(id>0){
			redirectAttributes.addFlashAttribute("message", "Summary updated successfully.");
			return "redirect:/oimnotes/summary/edit/"+id;
		}else{
			redirectAttributes.addFlashAttribute("message", "New Summary created successfully.");
			return "redirect:/oimnotes/summary/add";
		}
		
		
	}
	@RequestMapping(value="/summary/delete",method=RequestMethod.POST)
	public void summaryDelete(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		Map<String, Boolean> map=new HashMap<>();
		
		
		if(id>0){
			try {
				oimNotesService.deleteSummary(id);
				map.put("status", true);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("status", false);
			}
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
		
	}
	
	
	
	
	@RequestMapping(value="/followup",method=RequestMethod.GET)
	public String followUp() {
		
			
		return "oimnotes/oimNotesFollowUp";
	}
	
	@RequestMapping(value="/followup/view/{sid}",method=RequestMethod.GET)
	public String followUpView(@PathVariable("sid")int sid,Model model) {
		
		model.addAttribute("colors", OimCommon.getColorList());
		model.addAttribute("sid", sid);
		model.addAttribute("color", "white");
		
		Summary summary=oimNotesService.getSummary(sid);
		model.addAttribute("summary", summary);
		
		List<FollowUp> followUps=oimNotesService.getFollowUps(sid);
		model.addAttribute("followUps",followUps);
		model.addAttribute("recurrences", OimCommon.getRecurrenceList());
		return "oimnotes/oimNotesFollowUp";
	}
	@RequestMapping(value="/followup/view/{sid}/{tag}",method=RequestMethod.GET)
	public String followUpView(@PathVariable("sid")int sid,@PathVariable("tag")String tag,Model model) {
		
		model.addAttribute("colors", OimCommon.getColorList());
		model.addAttribute("color", tag);
		model.addAttribute("sid", sid);
		
		Summary summary=oimNotesService.getSummary(sid);
		model.addAttribute("summary", summary);
		
		List<FollowUp> followUps=oimNotesService.getFollowUps(sid,tag);
		model.addAttribute("followUps",followUps);
		model.addAttribute("recurrences", OimCommon.getRecurrenceList());
		return "oimnotes/oimNotesFollowUp";
	}
	
	
	@RequestMapping(value="/followup/add/{sid}",method=RequestMethod.GET)
	public String followUpAdd(@PathVariable("sid")int sid,Model model) {
		model.addAttribute("colors", OimCommon.getColorList());
		FollowUp followUp=new FollowUp();
		followUp.setSummaryId(sid);
		model.addAttribute("folloupObj", followUp);
		model.addAttribute("recurrences", OimCommon.getRecurrenceList());
		
		return "oimnotes/oimNotesFollowUpAdd";
	}
	
	@RequestMapping(value="/followup/edit/{id}",method=RequestMethod.GET)
	public String followupEdit(@PathVariable("id")int id,Model model) {
		model.addAttribute("colors", OimCommon.getColorList());
		
		List<Category> categories=oimNotesService.getCategory();
		model.addAttribute("categories", categories);
		
		FollowUp followUp=oimNotesService.getFollowUp(id);
		
		model.addAttribute("folloupObj", followUp);
		model.addAttribute("recurrences", OimCommon.getRecurrenceList());
		
		return "oimnotes/oimNotesFollowUpEdit";
	}
	
	@RequestMapping(value="/followup/save",method=RequestMethod.POST)
	public String followSave(@RequestParam("file")MultipartFile file,HttpServletRequest request,RedirectAttributes redirectAttributes,Model model) {
		
		String folder=System.getProperty("catalina.base")+"/UploadedDocuments";
		File uploadedFile=new File(folder);
		if(!uploadedFile.exists()){
			uploadedFile.mkdirs();
		}
		File fileBackup=new File(documentFileBackupLocation);
		
		FollowUp followUpOb=new FollowUp();
		
		
		if(!file.isEmpty()){
			
			String fileName=UUID.randomUUID()+"."+FilenameUtils.getExtension(file.getOriginalFilename());
			
			followUpOb.setFile(fileName);
			
			
			
			
			try {
				File fileLocal=new File(uploadedFile, fileName);
				FileOutputStream inputStream1=new FileOutputStream(fileLocal);
				IOUtils.copy(file.getInputStream(), inputStream1);
				inputStream1.close();
				
				File fileRemote=new File(fileBackup, fileName);
				FileOutputStream inputStream2=new FileOutputStream(fileRemote);
				IOUtils.copy(file.getInputStream(), inputStream2);
				inputStream2.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			followUpOb.setFile("");
		}
		
		
		int id=CommonUtil.checkInt(request.getParameter("id"));
		String followUp=CommonUtil.checkNull(request.getParameter("followUp"));
		String responsibility=CommonUtil.checkNull(request.getParameter("responsibility"));
		Date entryDate=CommonUtil.checkDate(request.getParameter("entryDate"), dateFormat);
		Date timeline=CommonUtil.checkDate(request.getParameter("timeline"), dateFormat);
		int summaryId=CommonUtil.checkInt(request.getParameter("summaryId"));
		String recurrence=CommonUtil.checkNull(request.getParameter("recurrence"));
		String tagColor=CommonUtil.checkNull(request.getParameter("tagColor"));
		
		String noteHistory=CommonUtil.checkNull(request.getParameter("noteHistory"));
		
		
		
		followUpOb.setId(id);
		followUpOb.setFollowUp(followUp);
		followUpOb.setEntryDate(entryDate);
		followUpOb.setTimeline(timeline);
		followUpOb.setResponsibility(responsibility);
		followUpOb.setSummaryId(summaryId);
		followUpOb.setRecurrence(recurrence);
		followUpOb.setNoteHistory(noteHistory);
		followUpOb.setTagColor(tagColor);
		
		try {
			oimNotesService.saveOrUpdate(followUpOb);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Server error:-"+e.getMessage());
			return "oimnotes/oimNotesFollowUpAdd";
		}
		
		if(id>0){
			redirectAttributes.addFlashAttribute("message", "Follow up updated successfully.");
			return "redirect:/oimnotes/followup/edit/"+id;
		}else{
			redirectAttributes.addFlashAttribute("message", "New Follow up created successfully.");
			return "redirect:/oimnotes/followup/add/"+summaryId;
		}
		
		
	}
	
	@RequestMapping(value="/followup/delete",method=RequestMethod.POST)
	public void followUpDelete(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		Map<String, Boolean> map=new HashMap<>();
		
		
		if(id>0){
			try {
				oimNotesService.deleteFollowUp(id);
				map.put("status", true);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("status", false);
			}
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
		
	}
	
	@RequestMapping(value="/followup/history/{fid}",method=RequestMethod.GET)
	public String followUpChangeHistory(@PathVariable("fid")int fid,Model model) throws IOException {
		FollowUp followUp=oimNotesService.getFollowUp(fid);
		model.addAttribute("followUp", followUp);
		
		List<FollowUpHistory> histories=oimNotesService.getFollowUpHistory(fid);
		model.addAttribute("histories", histories);
		return "oimnotes/oimNotesFollowUpHistory";
	}
	
	
	@RequestMapping(value="/followup/close/{id}",method=RequestMethod.GET)
	public String followUpClose(@PathVariable("id")int id,Model model) throws IOException {
		
		FollowUp followUp=new FollowUp();
		followUp.setClosed(new Date());
		followUp.setId(id);
		model.addAttribute("followUp", followUp);
		
		return "oimnotes/oimNotesFollowUpClose";
	}
	
	@RequestMapping(value="/followup/close",method=RequestMethod.POST)
	public String followUpClose(@RequestParam("closed")String closed,
			@RequestParam("closedBy")String closedBy,
			@RequestParam("id")int id,
			@RequestParam("notes")String notes,
			Model model) throws IOException {
		
		
		
		//System.out.println(notes);
		
		FollowUp followUp=new FollowUp();
		followUp.setClosed(new Date());
		followUp.setId(id);
		followUp.setClosedBy(closedBy);
		model.addAttribute("followUp", followUp);
		
		if(id>0){
			try {
				oimNotesService.closeFollowUp(CommonUtil.checkDate(closed, dateFormat),closedBy,id);
				
				oimNotesService.addFollowUpChangeHistory(id,"Follow Up Closed",notes);
				
				model.addAttribute("message", "Follow up closed.");
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("error", "Server error."+e.getMessage());
			}
		}
		
		return "oimnotes/oimNotesFollowUpClose";
	}
	
	
	@RequestMapping(value="/followup/addhistory",method=RequestMethod.POST)
	public String followUpAddHistory(
			@RequestParam("notes")String notes,
			@RequestParam("id")int id,
			RedirectAttributes redirectAttributes,
			Model model) throws IOException {
		
		
		if(id>0){
			try {

				oimNotesService.addFollowUpChangeHistory(id,"Comment",notes);
				
				redirectAttributes.addFlashAttribute("message", "New comment added..");
			} catch (Exception e) {
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("error", "Server error."+e.getMessage());
			}
		}
		
		return "redirect:/oimnotes/followup/history/"+id;
	}
	
	
}
