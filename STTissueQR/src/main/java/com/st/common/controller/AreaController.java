/**
 * 
 */
package com.st.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping("/area")
public class AreaController {
//	
//	@Autowired
//	private AreaService areaService;
//	
//	@Autowired
//	private SafetyHousekeepingService safetyHousekeepingService;
//	
//	@Autowired
//	private UserAuditorService userAuditorService;
//	
//	@Autowired
//	private AuditDoneOrNotAutoMailer auditdoneornotautoMailer;
//	
//	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
//	
//	@RequestMapping("/manage")
//	public String manage(Model model) {
//		
//		Area  area=new Area();
//		model.addAttribute("area", area);
//		
//		model.addAttribute("types", AreaType.getAreaType());
//		
//		List<Area> areas=areaService.getAreas();
//		model.addAttribute("areas", areas);
//		
//		return "common/manageArea";
//	}
//	
//	@RequestMapping("/edit/{id}")
//	public String edit(@PathVariable("id")int id,Model model) {
//		
//		Area area=areaService.getArea(id);
//		model.addAttribute("area", area);
//		model.addAttribute("types", AreaType.getAreaType());
//		
//		List<Area> areas=areaService.getAreas();
//		model.addAttribute("areas", areas);
//		
//		return "common/manageArea";
//	}
//	
//	@RequestMapping(value="/save",method=RequestMethod.POST)
//	public String save(@ModelAttribute("area")Area  area,
//			RedirectAttributes redirectAttributes,
//			Model model) {
//		
//		List<Area> areas=areaService.getAreas();
//		model.addAttribute("areas", areas);
//		
//		model.addAttribute("types", AreaType.getAreaType());
//		
//		model.addAttribute("area", area);
//		
//		if(StringUtils.isEmpty(area.getName())){
//			model.addAttribute("error", "Please enter area!");
//			return "common/manageArea";
//		}
//		
//		try {
//			areaService.saveOrUpdate(area);
//		} catch (Exception e) {
//			model.addAttribute("error", "Failed to save data. Error:-"+e.getMessage());
//			return "common/manageArea";
//		}
//		
//		
//		if(area.getId()==0){
//			redirectAttributes.addFlashAttribute("message", "Data saved in database successfully.");
//			return "redirect:/area/manage";
//		}else{
//			redirectAttributes.addFlashAttribute("message", "Data updated in database successfully.");
//			return "redirect:/area/edit/"+area.getId();
//		}
//		
//		
//	}
//@RequestMapping("/auditdoneornot")	
//	public String auditdoneornot(Model model) {
//		
//		return "common/auditdoneornot";
//	}
//@RequestMapping("/auditdoneornot/report")
//public String main(HttpServletRequest request,HttpServletResponse response,Model model){
//			
//			Calendar cal = Calendar.getInstance();
//			cal.add(Calendar.DATE, -5);
//			System.out.println("Date1 = "+ cal.getTime());
//
//			Calendar cal1 = Calendar.getInstance();
//			cal1.add(Calendar.DATE, 0);
//			System.out.println("Date2 = "+ cal1.getTime());
//		
//			Date sdate=cal.getTime();
//			Date edate=cal1.getTime();
//			
//			List<SafetyHousekeepingSchedule> auditStatus=safetyHousekeepingService.getSafetyHousekeepingAuditSchedulesStatus(sdate,edate);
//			System.out.println(auditStatus.size());
//			
//			for(SafetyHousekeepingSchedule data:auditStatus){
//				boolean status =data.isAuditStatus();
//				int auditorId=data.getAuditor();
//				System.out.println(status);
//				if(status==true){
//					System.out.println("Audit Is Done");
//				}else if(status==false){
//					
//					List<SafetyHousekeepingSchedule> auditerDetails=safetyHousekeepingService.getauditerDetails(auditorId);
//					for(SafetyHousekeepingSchedule data2 :auditerDetails  ){
//						
//						String auditorEmail=data2.getAuditorEamil();
//						String auditorName=data2.getAuditorName();
//						System.out.println(auditorEmail);
//						System.out.println(auditorName);
//						auditdoneornotautoMailer.sendMailOnFriday7am(auditStatus,auditerDetails);	
//					}
//					
//				}else{
//					System.out.println("None");
//				}
//			}
//			
//	return "common/auditdoneornot";
//}
//
}
