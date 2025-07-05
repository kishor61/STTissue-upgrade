/**
 * 
 */
package com.st.safetylog.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.common.CommonUtil;
import com.st.common.SafetyCommonUtil;
import com.st.common.model.Area;
import com.st.common.model.UserAuditor;
import com.st.common.service.AreaService;
import com.st.common.service.UserAuditorService;
import com.st.safetylog.model.PositiveObservation;
import com.st.safetylog.model.PositiveObservationP;
import com.st.safetylog.model.SafetyHousekeeping;
import com.st.safetylog.model.SafetyHousekeepingAction;
import com.st.safetylog.model.SafetyHousekeepingSchedule;
import com.st.safetylog.model.SafetyHousekeepingStdType;
import com.st.safetylog.model.SafetyHousekeepingTask;
import com.st.safetylog.service.SafetyHousekeepingService;
import com.st.user.model.User;
import com.st.user.service.UserService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping(value="/safetyhousekeeping")
public class SafetyHousekeepingController {
	private static final Logger logger=LoggerFactory.getLogger(SafetyHousekeepingController.class);
	
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	
	@Value("${housekeeping.file.folder}")
	private String housekeepingFileBackupLocation;
	
	@Autowired
	private UserAuditorService userAuditorService;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private SafetyHousekeepingService safetyHousekeepingService;
	
	
	@Autowired
	private UserService userService;
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String main(Model model) {
		return "safetylog/safetyHouseKeepingMain";
	}
	
	@RequestMapping(value="/view/standard",method=RequestMethod.GET)
	public String viewStandard(Model model) {
		model.addAttribute("showFlag", false);
		model.addAttribute("types", safetyHousekeepingService.getSafetyHouseStandard());
		
		return "safetylog/safetyHouseKeepingViewStand";
	}
	
	@RequestMapping(value="/view/standard/{type}",method=RequestMethod.GET)
	public String viewStandard(@PathVariable("type")String type,Model model) {
		
		model.addAttribute("types", safetyHousekeepingService.getSafetyHouseStandard());
		model.addAttribute("type",type);
		model.addAttribute("showFlag", true);
		List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeeping(type);
		model.addAttribute("housekeepings", housekeepings);
		
		return "safetylog/safetyHouseKeepingViewStand";
	}
	
	
	
	@RequestMapping(value="/add/standard",method=RequestMethod.GET)
	public String addStandard(Model model) {
		
		List<UserAuditor> autiors=userAuditorService.getUserAutiors();
		model.addAttribute("autiors", autiors);
		
		
		List<Area> areas=areaService.getAreas();
		model.addAttribute("areas", areas);
		
		SafetyHousekeeping housekeeping=new SafetyHousekeeping();
		
		model.addAttribute("housekeeping", housekeeping);
		model.addAttribute("types", safetyHousekeepingService.getSafetyHouseStandard());
		
		
		
		
		return "safetylog/safetyHousekeepingNewStand";
	}
	
	@RequestMapping(value="/save/standard",method=RequestMethod.POST)
	public String saveStandard(@ModelAttribute("housekeeping")SafetyHousekeeping housekeeping,RedirectAttributes redirectAttributes,Model model) {
		
		
		List<UserAuditor> autiors=userAuditorService.getUserAutiors();
		model.addAttribute("autiors", autiors);
		List<Area> areas=areaService.getAreas();
		model.addAttribute("areas", areas);
		
		model.addAttribute("housekeeping", housekeeping);
		model.addAttribute("types", safetyHousekeepingService.getSafetyHouseStandard());
		
		if(StringUtils.isEmpty(housekeeping.getDescription())){
			model.addAttribute("error","Please enter Description!");
			return "safetylog/safetyHousekeepingNewStand";
		}
		
		try {
			safetyHousekeepingService.saveOrUpdate(housekeeping);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Failed to save data in database. Error Message:-"+e.getMessage());
			return "safetylog/safetyHousekeepingNewStand";
		}
		
		if(housekeeping.getId()==0){
			redirectAttributes.addFlashAttribute("message", "Data saved in database successfully.");
			return "redirect:/safetyhousekeeping/add/standard";
		}else{
			model.addAttribute("message", "Data updated in database successfully.");
			return "safetylog/safetyHousekeepingEditStand";
		}
		
		
	}
	
	
	@RequestMapping(value="/delete/standard",method=RequestMethod.GET)
	public void deleteStandard(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			safetyHousekeepingService.deleteStandard(id);
			map.put("flag", true);
		} catch (Exception e) {
			map.put("flag", false);
			map.put("error","Can't delete! Error:-"+e.getMessage());
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
	}
	
	
	@RequestMapping(value="/edit/standard/{id}",method=RequestMethod.GET)
	public String editStandard(@PathVariable("id")int id,Model model) {
		
		List<UserAuditor> autiors=userAuditorService.getUserAutiors();
		model.addAttribute("autiors", autiors);
		
		
		List<Area> areas=areaService.getAreas();
		model.addAttribute("areas", areas);
		
		
		SafetyHousekeeping housekeeping=safetyHousekeepingService.getSafetyHousekeeping(id);

		model.addAttribute("housekeeping", housekeeping);
		model.addAttribute("types", safetyHousekeepingService.getSafetyHouseStandard());
		
		
		return "safetylog/safetyHousekeepingEditStand";
	}
	
	
	
	
	@RequestMapping(value="/manage/stdtype",method=RequestMethod.GET)
	public String manageStdType(Model model) {
		SafetyHousekeepingStdType housekeepingStdType=new SafetyHousekeepingStdType();
		model.addAttribute("housekeepingStdType", housekeepingStdType);
		
		List<SafetyHousekeepingStdType> types=safetyHousekeepingService.getSafetyHouseStandard();
		model.addAttribute("types", types);
		
		return "safetylog/safetyHousekeepingStandManage";
	}
	
	@RequestMapping(value="/edit/stdtype/{id}",method=RequestMethod.GET)
	public String editStdType(@PathVariable("id")String id,Model model) {
		SafetyHousekeepingStdType housekeepingStdType=safetyHousekeepingService.getSafetyHousekeepingStdType(id);
		model.addAttribute("housekeepingStdType", housekeepingStdType);
		
		List<SafetyHousekeepingStdType> types=safetyHousekeepingService.getSafetyHouseStandard();
		model.addAttribute("types", types);
		
		return "safetylog/safetyHousekeepingStandManage";
	}
	
	@RequestMapping(value="/delete/stdtype/{id}",method=RequestMethod.GET)
	public String deleteStdType(@PathVariable("id")String id,RedirectAttributes redirectAttributes,Model model) {
		
		
		
		try {
			safetyHousekeepingService.deleteStdType(id);
		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("error", "Can't delete! Error:-"+e.getMessage());
			return "redirect:/safetyhousekeeping/manage/stdtype";
		}
		
		redirectAttributes.addFlashAttribute("message", "Data removed from database successfully.");
		return "redirect:/safetyhousekeeping/manage/stdtype";
	}
	
	@RequestMapping(value="/save/stdtype",method=RequestMethod.POST)
	public String saveStdType(@ModelAttribute("housekeepingStdType")SafetyHousekeepingStdType housekeepingStdType,
			RedirectAttributes redirectAttributes,Model model) {
		
		if(StringUtils.isEmpty(housekeepingStdType.getName())){
			
			List<SafetyHousekeepingStdType> types=safetyHousekeepingService.getSafetyHouseStandard();
			model.addAttribute("types", types);
			model.addAttribute("housekeepingStdType", housekeepingStdType);
			
			model.addAttribute("error", "Please enter standard name");
			return "safetylog/safetyHousekeepingStandManage";
		}
		
		try {
			safetyHousekeepingService.saveOrUpdate(housekeepingStdType);
			
		} catch (Exception e) {
			
			List<SafetyHousekeepingStdType> types=safetyHousekeepingService.getSafetyHouseStandard();
			model.addAttribute("types", types);
			
			model.addAttribute("housekeepingStdType", housekeepingStdType);
			model.addAttribute("error", "Error"+e.getMessage());
			return "safetylog/safetyHousekeepingStandManage";
		}
		
		if(StringUtils.isEmpty(housekeepingStdType.getId())){
			redirectAttributes.addFlashAttribute("message", "Data saved in database successfully.");
		}else{
			redirectAttributes.addFlashAttribute("message", "Data updated successfully.");
		}
		
		return "redirect:/safetyhousekeeping/manage/stdtype";
	}
	
	
	
	@RequestMapping(value="/view/task",method=RequestMethod.GET)
	public String viewTask(Model model) {
		model.addAttribute("showFlag", false);
		model.addAttribute("types", safetyHousekeepingService.getSafetyHouseStandard());
		
		List<UserAuditor> auditors=userAuditorService.getUserAutiors();
		model.addAttribute("auditors", auditors);
		model.addAttribute("date", dateFormat.format(new Date()));
		
		model.addAttribute("area", 0);
		model.addAttribute("auditor", 0);
		
		List<Area> areas=areaService.getAreas();
		model.addAttribute("areas", areas);

		
		return "safetylog/safetyHouseKeepingViewTask";
	}
	
	/**
	 * With type
	 * */
	@RequestMapping(value="/view/task/{type}/{auditor}/{area}/{date}",method=RequestMethod.GET)
	public String viewTask(@PathVariable("type")String type,
			@PathVariable("auditor")int auditor,
			@PathVariable("area")int area,
			@PathVariable("date")String date,
			
			Model model) {
		
		model.addAttribute("types", safetyHousekeepingService.getSafetyHouseStandard());
		model.addAttribute("type",type);
		model.addAttribute("showFlag", true);
		
		
		List<UserAuditor> auditors=userAuditorService.getUserAutiors();
		
		List<Area> areas=areaService.getAreas();
		for (Area ar : areas) {
			if(ar.getName().replaceAll("\\s","") .equalsIgnoreCase(type))
				area=ar.getId();
		}
		model.addAttribute("areas", areas);
		model.addAttribute("auditors", auditors);
		model.addAttribute("date", date);
		
		String genKeyId=SafetyCommonUtil.getHousekeepingId(auditor, area, date);
		SafetyHousekeepingTask housekeepingTask=new SafetyHousekeepingTask();
		housekeepingTask.setArea(area);
		housekeepingTask.setAuditor(auditor);
		housekeepingTask.setDate(CommonUtil.checkDate(date, dateFormat));
		housekeepingTask.setGenKeyId(genKeyId);
		
		try {
			SafetyHousekeepingTask task=safetyHousekeepingService.isHousekeepingTaskExist(genKeyId);
			int taskId=0;
			List<Integer> completedIds=null;
			if(task!=null){
				taskId=task.getId();
				completedIds=task.getCompletedIds();
				logger.info("House keeping task already exist for ID ="+taskId);
				
			}else{
				//Save
				int id= safetyHousekeepingService.saveOrUpdate(housekeepingTask);
				taskId=id;
				completedIds=housekeepingTask.getCompletedIds();
				logger.info("House keeping task created with ID ="+taskId);
			}
			
			model.addAttribute("taskId", taskId);
			
			List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeeping(type);
			for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
				safetyHousekeeping.setTaskId(taskId);
				if(completedIds.contains(safetyHousekeeping.getId())){
					safetyHousekeeping.setCompleted(true);
				}
			}
			
			model.addAttribute("housekeepings", housekeepings);
			
		} catch (Exception e) {
			logger.error("Error in housekeeping task",e);
		}
		return "safetylog/safetyHouseKeepingViewTask";
	}
	
	/**
	 * With type
	 * */
	@RequestMapping(value="/view/task/{auditor}/{area}/{date}",method=RequestMethod.GET)
	public String viewTask(
			@PathVariable("auditor")int auditor,
			@PathVariable("area")int area,
			@PathVariable("date")String date,
			
			Model model) {
		
		model.addAttribute("types", safetyHousekeepingService.getSafetyHouseStandard());
		//model.addAttribute("type",type);
		model.addAttribute("showFlag", true);
		
		
		List<UserAuditor> auditors=userAuditorService.getUserAutiors();
		List<Area> areas=areaService.getAreas();
		
		
		model.addAttribute("areas", areas);
		model.addAttribute("auditors", auditors);
		model.addAttribute("date", date);
		
		String genKeyId=SafetyCommonUtil.getHousekeepingId(auditor, area, date);
		SafetyHousekeepingTask housekeepingTask=new SafetyHousekeepingTask();
		housekeepingTask.setArea(area);
		housekeepingTask.setAuditor(auditor);
	//	housekeepingTask.setType(type);
		
		housekeepingTask.setDate(CommonUtil.checkDate(date, dateFormat));
		housekeepingTask.setGenKeyId(genKeyId);
		
		try {
			SafetyHousekeepingTask task=safetyHousekeepingService.isHousekeepingTaskExist(genKeyId);
			int taskId=0;
			List<Integer> completedIds=null;
			if(task!=null){
				taskId=task.getId();
				completedIds=task.getCompletedIds();
				logger.info("House keeping task already exist for ID ="+taskId);
				
			}else{
				//Save
				int id= safetyHousekeepingService.saveOrUpdate(housekeepingTask);
				taskId=id;
				completedIds=housekeepingTask.getCompletedIds();
				logger.info("House keeping task created with ID ="+taskId);
			}
			
			model.addAttribute("taskId", taskId);
			
			List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeeping();
			for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
				safetyHousekeeping.setTaskId(taskId);
				if(completedIds.contains(safetyHousekeeping.getId())){
					safetyHousekeeping.setCompleted(true);
				}
			}
			
			model.addAttribute("housekeepings", housekeepings);
			
		} catch (Exception e) {
			logger.error("Error in housekeeping task",e);
		}
		return "safetylog/safetyHouseKeepingViewTask";
	}
	
	
	@RequestMapping(value="/edit/task/{taskId}",method=RequestMethod.GET)
	public String editTask(@PathVariable("taskId")int taskId,Model model) {
		
		SafetyHousekeepingTask housekeepingTask=safetyHousekeepingService.getSafetyHousekeepingTask(taskId);
		model.addAttribute("housekeepingTask", housekeepingTask);
		
		return "safetylog/safetyHouseKeepingMain";
	}
	
	
	@RequestMapping(value="/view/task/score",method=RequestMethod.POST)
	public void viewTaskScore(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int taskId=CommonUtil.checkInt(request.getParameter("id"));
		List<SafetyHousekeepingStdType> types=new ArrayList<>();
		
		try {
			SafetyHousekeepingTask housekeepingTask=safetyHousekeepingService.getSafetyHousekeepingTask(taskId);
			types= safetyHousekeepingService.getSafetyHouseStandard();
			List<SafetyHousekeeping> housekeepings=safetyHousekeepingService.getSafetyHousekeepingAndActions(taskId);
			SafetyCommonUtil.getTaskScore(types, housekeepings, housekeepingTask);
		} catch (Exception e) {
	
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(types));
	}
	
	
	@RequestMapping(value="/delete/task/{taskId}",method=RequestMethod.POST)
	public void deleteTask(@PathVariable("taskId")int taskId,
			@RequestParam("password")String password,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map=new HashMap<>();
		
		try {
			
			User user=userService.getUser("admin");
			if(user.getPassword().equals(password)){
				safetyHousekeepingService.deleteTask(taskId);
				map.put("flag", true);
			}else{
				map.put("flag", false);
				map.put("error", "Invalid password.");
			}
			//safetyHousekeepingService.deleteTask()
			
			
		} catch (Exception e) {
			logger.error("Error in delete data from database", e);
			map.put("flag", false);
			map.put("error", "Fail to remove data from database.");
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
	}
	
	
	
	
	
	
	@RequestMapping(value="/view/action",method=RequestMethod.GET)
	public String viewAction(Model model) {
		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("showFlag", false);
		return "safetylog/safetyHouseKeepingViewAction";
	}
	
	@RequestMapping(value="/view/action/{sid}/{taskId}",method=RequestMethod.GET)
	public String viewAction(@PathVariable("sid")int sid,
			@PathVariable("taskId")int taskId,
			Model model) {
		
		
		
		SafetyHousekeeping housekeeping=safetyHousekeepingService.getSafetyHousekeeping(sid);
		model.addAttribute("housekeeping", housekeeping);
		List<SafetyHousekeepingStdType> types=safetyHousekeepingService.getSafetyHouseStandard();
		SafetyHousekeepingStdType stdType=new SafetyHousekeepingStdType();
		stdType.setId(housekeeping.getType());
		stdType=types.get(types.indexOf(stdType));
		model.addAttribute("type",stdType.getName());
		
		SafetyHousekeepingTask housekeepingTask=safetyHousekeepingService.getSafetyHousekeepingTask(taskId);
		
		model.addAttribute("housekeepingTask", housekeepingTask);
		
		
		
		List<SafetyHousekeepingAction> housekeepingActions=safetyHousekeepingService.getSafetyHousekeepingAction(sid,taskId);
		
		model.addAttribute("housekeepingActions", housekeepingActions);

		model.addAttribute("showFlag", true);
		model.addAttribute("sid", sid);
		model.addAttribute("taskId", taskId);
		
		return "safetylog/safetyHouseKeepingViewAction";
	}
	
	@RequestMapping(value="/add/action/{sid}/{taskId}",method=RequestMethod.GET)
	public String addAction(@PathVariable("sid")int sid,@PathVariable("taskId")int taskId,Model model) {
		
		List<UserAuditor> autiors=userAuditorService.getUserAutiors();
		model.addAttribute("autiors", autiors);
		
		SafetyHousekeepingAction housekeepingAction=new SafetyHousekeepingAction();
		housekeepingAction.setSid(sid);
		housekeepingAction.setTid(taskId);
		model.addAttribute("housekeepingAction", housekeepingAction);
		return "safetylog/safetyHousekeepingNewAction";
	}
	
	@RequestMapping(value="/edit/action/{id}",method=RequestMethod.GET)
	public String editAction(@PathVariable("id")int id,Model model) {
		
		List<UserAuditor> autiors=userAuditorService.getUserAutiors();
		model.addAttribute("autiors", autiors);
		
		SafetyHousekeepingAction housekeepingAction=safetyHousekeepingService.getSafetyHousekeepingAction(id);
		model.addAttribute("housekeepingAction", housekeepingAction);
		return "safetylog/safetyHousekeepingEditAction";
	}
	
	
	@RequestMapping(value="/save/action",method=RequestMethod.POST)
	public String saveAction(@RequestParam("file")MultipartFile file,@ModelAttribute("housekeepingAction")SafetyHousekeepingAction housekeepingAction,
			RedirectAttributes redirectAttributes,Model model) {
		
		
		if(!file.isEmpty()){
			
			String fileName=UUID.randomUUID()+"."+FilenameUtils.getExtension(file.getOriginalFilename());
			
			File backupFile=new File(housekeepingFileBackupLocation);
			if(!backupFile.exists()){
				backupFile.mkdirs();
			}
			
			String folder=System.getProperty("catalina.base")+"/HousekeepingActionDocuments";
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
				
				housekeepingAction.setDocument(fileName);
				
			} catch (IOException e) {
				e.printStackTrace();
				model.addAttribute("error", "Fail to upload file. Please try again. Error:-"+e.getMessage());
				return "safetylog/safetyHousekeepingNewAction";
			}
			
			
			
		}
		
		List<UserAuditor> autiors=userAuditorService.getUserAutiors();
		model.addAttribute("autiors", autiors);
		
		model.addAttribute("housekeepingAction", housekeepingAction);
		
		
		try {
			safetyHousekeepingService.saveOrUpdate(housekeepingAction);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Fail to save data in database. Error:-"+e.getMessage());
			return "safetylog/safetyHousekeepingNewAction";
		}
		
		if(housekeepingAction.getId()==0){
			redirectAttributes.addFlashAttribute("message", "Data saved in database.");
			return "redirect:/safetyhousekeeping/add/action/"+housekeepingAction.getSid()+"/"+housekeepingAction.getTid();
		}else{
			model.addAttribute("message", "Data updated successfully.");
			return "safetylog/safetyHousekeepingEditAction";
		}
		
		
	}
	
	@RequestMapping(value="/delete/action",method=RequestMethod.GET)
	public void deleteAction(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		int id=CommonUtil.checkInt(request.getParameter("id"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			safetyHousekeepingService.deleteAction(id);
			map.put("flag", true);
		} catch (Exception e) {
			map.put("flag", false);
			map.put("error","Can't delete! Error:-"+e.getMessage());
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping(value="/close/action/{id}",method=RequestMethod.GET)
	public String closeAction(@PathVariable("id")int id,Model model) throws IOException {
		
		SafetyHousekeepingAction housekeepingAction=safetyHousekeepingService.getSafetyHousekeepingAction(id);
		housekeepingAction.setClosed(new Date());
		model.addAttribute("housekeepingAction", housekeepingAction);
		return "safetylog/safetyHousekeepingClose";
		
	}
	
	@RequestMapping(value="/close/action/save",method=RequestMethod.POST)
	public String closeActionSave(@ModelAttribute("housekeepingAction")SafetyHousekeepingAction housekeepingAction,Model model) throws IOException {
		
		model.addAttribute("housekeepingAction", housekeepingAction);
		
		try {
			safetyHousekeepingService.closeAction(housekeepingAction);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error","Can't close! Error:-"+e.getMessage());
			return "safetylog/safetyHousekeepingClose";
		}
		model.addAttribute("message", "Action closed.");
		model.addAttribute("flag", 1);
		return "safetylog/safetyHousekeepingClose";
		
	}
	
	@RequestMapping(value="/check/task",method=RequestMethod.POST)
	public void checkTask(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		int sid=CommonUtil.checkInt(request.getParameter("id"));
		int taskId=CommonUtil.checkInt(request.getParameter("taskId"));
		boolean checked=BooleanUtils.toBoolean(request.getParameter("checked"),"true","false");
		
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			
			if(taskId>0){
				
				boolean closedStatus=safetyHousekeepingService.actionsColosed(sid,taskId);
				if(closedStatus){
					SafetyHousekeepingTask housekeepingTask=safetyHousekeepingService.getSafetyHousekeepingTask(taskId);
					safetyHousekeepingService.checkTaskStandard(sid,housekeepingTask,checked);
					map.put("closed", true);
				}else{
					map.put("closed", false);
				}
					
			}
			
			
			map.put("flag", true);
		} catch (Exception e) {
			map.put("flag", false);
			map.put("error","Can't close! Error:-"+e.getMessage());
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/schedule_old")
	public String schedule_old(Model model) {
		
		model.addAttribute("recurrences", SafetyCommonUtil.getRecurrence());
		model.addAttribute("autiors", userAuditorService.getUserAutiors());
		model.addAttribute("areas",areaService.getAreas());
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		model.addAttribute("showFlag", false);
		
		return "safetylog/safetyHouseKeepingSchedule_old";
	}
	@RequestMapping(value="/schedule_old/{sdate}/{edate}/{recurrence}")
	public String schedule_Old(@PathVariable("sdate")String sdate,
			@PathVariable("edate")String edate,
			@PathVariable("recurrence")String recurrence,
			HttpServletRequest request,
			Model model) {
		
		
		CommonUtil.save(CommonUtil.HOUSE_KEEP_SCHEDULE_PAGE, request.getRequestURI());
		
		
		model.addAttribute("recurrences", SafetyCommonUtil.getRecurrence());
		model.addAttribute("autiors", userAuditorService.getUserAutiors());
		model.addAttribute("areas",areaService.getAreas());
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("recurrence", recurrence);
		
		
		Date dateFrom=CommonUtil.checkDate(sdate, dateFormat);
		Date dateTo=CommonUtil.checkDate(edate, dateFormat);
		
		List<Date> dates=SafetyCommonUtil.getScheduleRange(dateFrom, dateTo, recurrence);
		
		model.addAttribute("dates", dates);
		model.addAttribute("showFlag", true);
		
		return "safetylog/safetyHouseKeepingSchedule_old";
	}
	
	@RequestMapping(value="/schedule/save",method=RequestMethod.POST)
	public void saveNewSchedule(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		Map<String, Object>	 map=new HashMap<>();
		int id=CommonUtil.checkInt(request.getParameter("id"));
		int auditor=CommonUtil.checkInt(request.getParameter("auditor"));
		int area=CommonUtil.checkInt(request.getParameter("area"));
		String recurrence=CommonUtil.checkNull(request.getParameter("recurrence"));
		Date date=CommonUtil.checkDate(request.getParameter("date"), dateFormat);
		boolean deleted=CommonUtil.checkBoolean(request.getParameter("deleted"));
		
		
		SafetyHousekeepingSchedule housekeepingSchedule=new SafetyHousekeepingSchedule();
		housekeepingSchedule.setId(id);
		housekeepingSchedule.setArea(area);
		housekeepingSchedule.setAuditor(auditor);
		housekeepingSchedule.setDate(date);
		housekeepingSchedule.setRecurrence(recurrence);
		housekeepingSchedule.setDeleted(deleted);

		try {
			
			if(deleted){
				
				int idKey =safetyHousekeepingService.saveOrUpdate(housekeepingSchedule);
				map.put("id", idKey);
				map.put("flag", true);
				
				/*if(housekeepingSchedule.getRecurrence().equalsIgnoreCase("W")){
					String weekId=SafetyCommonUtil.getScheduleWeekId(auditor, area, date);
					housekeepingSchedule.setWeekId(weekId);
					
					SafetyHousekeepingSchedule scheduleOld=safetyHousekeepingService.getScheduleByWeekId(weekId);
					if(housekeepingSchedule.getId()==0){
						if(scheduleOld!=null){
							throw new Exception("This event is already scheduled for this day.");
						}else{
							//Save
							int idKey =safetyHousekeepingService.saveOrUpdate(housekeepingSchedule);
							map.put("id", idKey);
						}
					}else{
						if(scheduleOld!=null){
							if(scheduleOld.getId()==id){
								//Update
								int idKey =safetyHousekeepingService.saveOrUpdate(housekeepingSchedule);
								map.put("id", idKey);
							}else{
								throw new Exception("This event is already scheduled for this day.");
							}
						}else{
							//Update
							int idKey =safetyHousekeepingService.saveOrUpdate(housekeepingSchedule);
							map.put("id", idKey);
						}
					}
					
					
				}else if(housekeepingSchedule.getRecurrence().equalsIgnoreCase("M")){
					String monthId=SafetyCommonUtil.getScheduleMonthId(auditor, area, date);
					housekeepingSchedule.setMonthId(monthId);
					SafetyHousekeepingSchedule scheduleOld=safetyHousekeepingService.getScheduleByMonthId(monthId);
					if(housekeepingSchedule.getId()==0){
						if(scheduleOld!=null){
							throw new Exception("This event is already scheduled for this day.");
						}else{
							//Save
							int idKey =safetyHousekeepingService.saveOrUpdate(housekeepingSchedule);
							map.put("id", idKey);
						}
					}else{
						if(scheduleOld!=null){
							if(scheduleOld.getId()==id){
								//Update
								int idKey =safetyHousekeepingService.saveOrUpdate(housekeepingSchedule);
								map.put("id", idKey);
							}else{
								throw new Exception("An event is already scheduled for this day.");
							}
						}else{
							//Update
							int idKey =safetyHousekeepingService.saveOrUpdate(housekeepingSchedule);
							map.put("id", idKey);
						}
					}
					
				}else{
					String dayId=SafetyCommonUtil.getScheduleDayId(auditor, area);
					SafetyHousekeepingSchedule scheduleOld=safetyHousekeepingService.getScheduleByDayId(dayId);
					housekeepingSchedule.setDayId(dayId);
					if(housekeepingSchedule.getId()==0){
						if(scheduleOld!=null){
							throw new Exception("An event is already scheduled for this day.");
						}else{
							//Save
							int idKey =safetyHousekeepingService.saveOrUpdate(housekeepingSchedule);
							map.put("id", idKey);
						}
					}else{
						if(scheduleOld!=null){
							if(scheduleOld.getId()==id){
								//Update
								int idKey =safetyHousekeepingService.saveOrUpdate(housekeepingSchedule);
								map.put("id", idKey);
							}else{
								throw new Exception("This event is already scheduled for this day.");
							}
						}else{
							//Update
							int idKey =safetyHousekeepingService.saveOrUpdate(housekeepingSchedule);
							map.put("id", idKey);
						}
					}
				}
				map.put("message", "Data saved in database successfully.");
				map.put("flag", true);*/
			}else{
				safetyHousekeepingService.deleteSechedule(id);
				
				map.put("message", "Data removed from database successfully.");
				map.put("flag", true);
				map.put("id", 0);
			}
			
			
			
			
		} catch (Exception e) {
			map.put("flag", false);
			map.put("error", e.getMessage());
		}
		
		response.setContentType("application/json");	
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping(value="/schedule/load",method=RequestMethod.POST)
	public void loadScheduledEvent(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
	//	String recurrence=CommonUtil.checkNull(request.getParameter("recurrence"));
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		
		List<SafetyHousekeepingSchedule> schedules=safetyHousekeepingService.getSafetyHousekeepingSchedules(sdate,edate);
				
		response.setContentType("application/json");	
		response.getWriter().write(new Gson().toJson(schedules));
	}
	
	@RequestMapping(value="/schedule")
	public String schedule(Model model) {
		
		model.addAttribute("recurrences", SafetyCommonUtil.getRecurrence());
		model.addAttribute("autiors", userAuditorService.getUserAutiors());
		model.addAttribute("areas",areaService.getAreas());
		
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		model.addAttribute("showFlag", false);
		
		return "safetylog/safetyHouseKeepingSchedule";
	}
	
	@RequestMapping(value="/schedule/{sdate}/{edate}/{recurrence}")
	public String schedule(@PathVariable("sdate")String sdate,
			@PathVariable("edate")String edate,
			@PathVariable("recurrence")String recurrence,
			HttpServletRequest request,
			Model model) {
		
		
		CommonUtil.save(CommonUtil.HOUSE_KEEP_SCHEDULE_PAGE, request.getRequestURI());
		
		
		model.addAttribute("recurrences", SafetyCommonUtil.getRecurrence());
		//model.addAttribute("autiors", userAuditorService.getUserAutiors());
		model.addAttribute("autiors", userAuditorService.getUserAutiorsActive());
		model.addAttribute("areas",areaService.getAreas());
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);
		model.addAttribute("recurrence", recurrence);
		
		
		Date dateFrom=CommonUtil.checkDate(sdate, dateFormat);
		Date dateTo=CommonUtil.checkDate(edate, dateFormat);
		
		List<Date> dates=SafetyCommonUtil.getScheduleRange(dateFrom, dateTo, recurrence);
		
		model.addAttribute("dates", dates);
		model.addAttribute("showFlag", true);
		
		return "safetylog/safetyHouseKeepingSchedule";
	}

	@RequestMapping(value="/schedule/status",method=RequestMethod.POST)
	public void scheduledStatus(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id =CommonUtil.checkInt(request.getParameter("id"));
		boolean auditStatus=CommonUtil.checkBoolean(request.getParameter("auditStatus"));
		Map<String, Object> map=new HashMap<>();
		
		try {
			safetyHousekeepingService.scheduleStatus(id,auditStatus);
			
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);
			map.put("error", "Fail to updated data. Error:-"+e.getMessage());
		}
		
		response.setContentType("application/json");	
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping(value="/positiveObservations/load",method=RequestMethod.POST)
	public void loadpositiveEvent(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
	//	String recurrence=CommonUtil.checkNull(request.getParameter("recurrence"));
		Date sdate=CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate=CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		
		List<PositiveObservation> schedules=safetyHousekeepingService.getpositiveStatus(sdate,edate) ;
				
		response.setContentType("application/json");	
		response.getWriter().write(new Gson().toJson(schedules));
	}
	
	@RequestMapping(value="/positiveObservations")
	public String positiveObservations(Model model) {
		
		model.addAttribute("autiors", userAuditorService.getUserAutiors());
		model.addAttribute("sdate", dateFormat.format(CommonUtil.getFirstDate()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		
		model.addAttribute("showFlag", false);
		
		return "safetylog/positive_observations";
	}
	@RequestMapping(value="/positiveObservations/{sdate}/{edate}/{recurrence}")
	public String positiveObservations(@PathVariable("sdate")String sdate,
			@PathVariable("edate")String edate,
			HttpServletRequest request,
			Model model) {
		
		model.addAttribute("sdate", sdate);
		model.addAttribute("edate", edate);

		
		Date dateFrom=CommonUtil.checkDate(sdate, dateFormat);
		Date dateTo=CommonUtil.checkDate(edate, dateFormat);
		
		long difference = dateTo.getTime() - dateFrom.getTime();
		long daysBetween = (difference / (1000*60*60*24));
		//List<Date> dates=SafetyCommonUtil.getScheduleRange(dateFrom, dateTo, recurrence);
		//Date sdate=CommonUtil.getFirstDate();
		//Date edate=new Date();
		List<Date> dates=new ArrayList<>();
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(dateFrom);		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(dateTo);
		
		 
		dates.add(scal.getTime());
		
		for(int i=0;i<daysBetween;i++)
		{
			
				scal.add(Calendar.DATE, 1);
				dates.add(scal.getTime());	
		}
		List<UserAuditor> autiors=userAuditorService.getUserAutiorsActive();
		
		model.addAttribute("dates", dates);
		model.addAttribute("showFlag", true);
		model.addAttribute("autiors",autiors );
	
		return "safetylog/positive_observations";
	}
	@RequestMapping(value="/positiveObservations/status",method=RequestMethod.POST)
	public void positiveObservationsStatus(HttpServletRequest request,HttpServletResponse response) throws IOException {
		boolean auditStatus=CommonUtil.checkBoolean(request.getParameter("auditStatus"));
		Date date=CommonUtil.checkDate(CommonUtil.checkNull(request.getParameter("date")),dateFormat);
		String auditorId=CommonUtil.checkNull(request.getParameter("autiors"));
		Map<String, Object> map=new HashMap<>();
		
		
		try {
			safetyHousekeepingService.positiveStatus(date,auditStatus,auditorId);
			
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);
			map.put("error", "Fail to updated data. Error:-"+e.getMessage());
		}
		
		response.setContentType("application/json");	
		response.getWriter().write(new Gson().toJson(map));
	}
	

 
}
