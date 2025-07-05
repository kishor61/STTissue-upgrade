/**
 * 
 */
package com.st.user.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.st.common.CommonUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author kishor vaishnav
 * 2025
 *
 */
@Controller
public class SignInSingOutController {

	private static Logger logger = LoggerFactory.getLogger(SignInSingOutController.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
	
	
	// Login page with error handling
    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if ("bad_credentials".equals(error)) {
            model.addAttribute("errorMessage", "Invalid username or password.");
        } else if ("unknown".equals(error)) {
            model.addAttribute("errorMessage", "An unknown error occurred.");
        }
        return "login";
    }

    // Handle login success
    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        return "redirect:/";
    }

    // Handle login errors
    @GetMapping("/login-error")
    public String loginError(HttpServletRequest request, Model model) {
        jakarta.servlet.http.HttpSession session = request.getSession(false);
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                model.addAttribute("errorMessage", ex.getMessage());
            }
        }
        return "login";
    }

    // Access denied page
    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

    @GetMapping("/timeoutcheck")
	public void timeoutcheck(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,Principal principal) throws IOException {
		
		
		String reel=CommonUtil.checkNull(request.getParameter("reel"));
		String rewind=CommonUtil.checkNull(request.getParameter("rewind"));
		
		
		
		Date date=CommonUtil.getShiftDate();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		Date oldDate=CommonUtil.checkDate(CommonUtil.load(CommonUtil.OLD_SHIFT_DATE), dateFormat);
	
		Map<String, Object> map=new HashMap<String, Object>();
		
		
		
		if(oldDate!=null){
			
			if(date.equals(oldDate)){
				map.put("newDay", false);
			}else{
				
				if(!reel.equals("") && !rewind.equals("")){
					CommonUtil.save(CommonUtil.REEL_TEST_ENTRY_PAGE, reel);
					CommonUtil.save(CommonUtil.REWIND_TEST_ENTRY_PAGE, rewind);
				}
				
				map.put("newDay", true);
				logger.info("Shift changed at:-"+new Date());
				CommonUtil.save(CommonUtil.OLD_SHIFT_DATE, dateFormat.format(date));
			}
			
		}else{
			CommonUtil.save(CommonUtil.OLD_SHIFT_DATE, dateFormat.format(date));
		}
		
		
		
		
		//Code for checking Test alram - only for CR6 user
		
		if(principal.getName()!=null && principal.getName().equalsIgnoreCase("cr6")){
			
			map.put("showAlarm", true);
			
			Calendar calendar=Calendar.getInstance();
			
			int hh=calendar.get(Calendar.HOUR_OF_DAY);
			int mm=calendar.get(Calendar.MINUTE);
			
			//if((hh>=19 && hh<20) && (mm>=1 && mm<5 && calendar.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY)){		//Test Ny Roshan Tailor
			
			if((hh>=8 && hh<9) && (mm>=40 && mm<45 && calendar.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY)){
				String alarmFlag=CommonUtil.load(CommonUtil.EMERGENCY_ALARM_FLAG);
				if(alarmFlag==null){
					CommonUtil.save(CommonUtil.EMERGENCY_ALARM_FLAG, "Y");
					map.put(CommonUtil.EMERGENCY_ALARM_FLAG, "Y");
					
				}else{
					
					if(alarmFlag.equalsIgnoreCase("Y")){
						map.put(CommonUtil.EMERGENCY_ALARM_FLAG, "N");
					}else{
						map.put(CommonUtil.EMERGENCY_ALARM_FLAG, "Y");
					}
					
					CommonUtil.save(CommonUtil.EMERGENCY_ALARM_FLAG, "Y");
				}
				
				
			}else{
				map.put(CommonUtil.EMERGENCY_ALARM_FLAG, "N");
				CommonUtil.save(CommonUtil.EMERGENCY_ALARM_FLAG, "N");
			}
			
			
		}else{
			map.put("showAlarm", false);
		}
		
		
		
		
		
		
		response.setContentType("application/json");
		
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@PostMapping("/validuser")
	public void isValidUser(HttpServletRequest request,
			HttpServletResponse response,
			Principal principal) throws IOException {
	//	String username=principal.getName();
		Map<String, Object> map=new HashMap<>();
		//User user=userService.getUser(username);
		String password=request.getParameter("code");
		if(password!=null && password.equals("stt2013")){
			map.put("status", true);
		}else{
			map.put("status", false);
		}
		
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	

}
