/**
 *Apr 3, 2015
 *StaticDataController.java
 * TODO
 *com.st.operatingprocedure.controller
 *StaticDataController.java
 *Sunil Singh Bora
 */
package com.st.operatingprocedure.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.common.CommonUtil;
import com.st.common.FileLastModifiedComparator;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.report.WastePaperUnloadBalesReportHandler;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping("/staticdata")
public class StaticDataController {

	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private StaticShiftScheduleDataHandler StaticShiftScheduleDataHandler;
	
	@RequestMapping("/view")
	public String viewShiftScheduleUploadPage(Model model){
		
		
		return "scheduleUpload";
	}
	
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String saveShiftSchedule(@RequestParam("file")MultipartFile file,RedirectAttributes redirectAttributes,Model model) {
		

		if(!file.isEmpty()){
			
			File folder=new File(System.getProperty("catalina.base")+"/Mill Calander");
			if(!folder.exists()){
				folder.mkdirs();
			}else{
				try {
					FileUtils.cleanDirectory(folder);
					
				} catch (IOException e) {
					e.printStackTrace();
					model.addAttribute("error", "Unable to upload file. Please try later.");
					return "scheduleUpload";
				}
				
				
			}
			
			File fileNew=new File(folder,file.getOriginalFilename());
			
			try {
				FileOutputStream output=new FileOutputStream(fileNew);
				IOUtils.copyLarge(file.getInputStream(), output);
				output.close();
				
				redirectAttributes.addFlashAttribute("message", "File uploaded successfully.");
				
				return "redirect:/staticdata/view";
				
			} catch (IOException e) {
				model.addAttribute("error", "Fail to upload your file . Error:-"+e.getMessage());
			}
			
			
			
			/*if(FilenameUtils.getExtension(file.getOriginalFilename()).equalsIgnoreCase("xlsx"))
			{
				File fileNew=new File(System.getProperty("catalina.base"),"ShiftSchedule.xlsx");
//				Code Starts From Here Done By Roshan Tailor Date :- 05/22/2015
				File fileNew1=new File(System.getProperty("catalina.base"),"ShiftSchedule.pdf");

				if(fileNew.exists())
				{
					fileNew.delete();
				}
				if(fileNew1.exists())
				{
					fileNew1.delete();
				}
//				Code Ends Here Done By Roshan Tailor Date :- 05/22/2015				
				
				try {
					FileOutputStream output=new FileOutputStream(fileNew);
					IOUtils.copyLarge(file.getInputStream(), output);
					output.close();
					
					redirectAttributes.addFlashAttribute("message", "File uploaded successfully.");
					
					return "redirect:/staticdata/view";
					
				} catch (IOException e) {
					model.addAttribute("error", "Fail to upload your file . Error:-"+e.getMessage());
				}
				
				
			}
//			Code Starts From Here Done By Roshan Tailor Date :- 05/22/2015
			else if(FilenameUtils.getExtension(file.getOriginalFilename()).equalsIgnoreCase("pdf"))
			{
				System.out.println("We Are Uploading The Pdf File");
				File fileNewpdf=new File(System.getProperty("catalina.base"),"ShiftSchedule.pdf");
				
				if(fileNewpdf.exists())
				{
					
					fileNewpdf.delete();
				}
				
				try {
					FileOutputStream output=new FileOutputStream(fileNewpdf);
					IOUtils.copyLarge(file.getInputStream(), output);
					output.close();
					
					redirectAttributes.addFlashAttribute("message", "File uploaded successfully.");
					
					return "redirect:/staticdata/view";
					
				} catch (IOException e) {
					model.addAttribute("error", "Fail to upload your file . Error:-"+e.getMessage());
				}
			}
//			Code Ends Here Done By Roshan Tailor Date :- 05/22/2015
			else{
				model.addAttribute("error", "Plesase select valid file excel file");
			}
			*/
			
		}else{
			model.addAttribute("error", "Plesase select valid file");
			
		}
		
	
		
		return "scheduleUpload";
		
	}
	
	@RequestMapping(value="/shiftscheduledownload")
	public void downloadShiftSchedule(HttpServletResponse response) throws Exception 
	{
		
		File folder=new File(System.getProperty("catalina.base")+"/Mill Calander");
		if(folder.exists()){
			
			File[] files=folder.listFiles();
			
			if(files!=null && files.length>0){
				
				Arrays.sort(files, new FileLastModifiedComparator());
				
				File file=files[0];
				
				response.setContentType(CommonUtil.getFileContentType(file));
				response.setHeader("Content-Disposition", "inline; filename=Mill_Calendar."+FilenameUtils.getExtension(file.getName()));
				 try {
						FileInputStream inputStream=new FileInputStream(file);
						IOUtils.copy(inputStream, response.getOutputStream());
						inputStream.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
			}else{
				response.setContentType("text/plain");
				response.getWriter().write("File not found!");
			}
			
			
		}else{
			response.setContentType("text/plain");
			response.getWriter().write("File not found!");
		}
		
		
	/*	File file=new File(System.getProperty("catalina.base"),"ShiftSchedule.xlsx");
//		Code Starts From Here Done By Roshan Tailor Date:- 05/22/2015 Night Shift
		File filepdf=new File(System.getProperty("catalina.base"),"ShiftSchedule.pdf");
//		Code Ends Here Done By Roshan Tailor Date :- 05/22/2015 Night Shift
//		Code Starts From Here Done By Roshan Tailor Date :- 05/22/2015		
		if(filepdf.exists()){
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=Shift_Schedule.pdf");
			
			 try {
				FileInputStream inputStream=new FileInputStream(filepdf);
				IOUtils.copy(inputStream, response.getOutputStream());
				inputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		Code Ends Here Done By Roshan Tailor Date :- 05/22/2015
		if(file.exists()){
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=Shift_Schedule.xlsx");
			
			 try {
				FileInputStream inputStream=new FileInputStream(file);
				IOUtils.copy(inputStream, response.getOutputStream());
				inputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			response.setContentType("text/plain");
		}*/
	}
	@RequestMapping(value="/shiftscheduledownload1",method=RequestMethod.GET)
	public void export(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=2016ShiftSchedule.xlsx");
		File file=new File(context.getRealPath("/")+"WEB-INF/2016ShiftSchedule.xlsx");
		
		StaticShiftScheduleDataHandler.shiftscheduledownload1(file,response.getOutputStream());
		
		}
}
