package com.st.user.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

//	
//	@Autowired
//	private MachineProductionService productionPM6Service;
//	
//	@Autowired
//	private FrpProdcutionOperatorDataEntryService frpprodcutionoperatordataentryservice;
//	@Autowired
//	private WrapperProductionDao wrapperProductionDao;
//	@Autowired
//	private WrapperProductionDaoPM5 wrapperProductionPM5Dao;
//	/*@RequestMapping(value="/home",method=RequestMethod.GET)
//	public String home(HttpServletRequest request,Model model) {
//		
//		model.addAttribute("reelentryurl", CommonUtil.load(CommonUtil.REEL_TEST_ENTRY_PAGE));
//		model.addAttribute("rewindentryurl", CommonUtil.load(CommonUtil.REWIND_TEST_ENTRY_PAGE));
//		model.addAttribute(CommonUtil.FRP_PROJECTION_PAGE, CommonUtil.load(CommonUtil.FRP_PROJECTION_PAGE));
//		model.addAttribute(CommonUtil.HOUSE_KEEP_SCHEDULE_PAGE, CommonUtil.load(CommonUtil.HOUSE_KEEP_SCHEDULE_PAGE));
//		return "home";
//	}*/

	@GetMapping("/home")
	public String homeNew(HttpServletRequest request, Model model) throws ProductionException {

		model.addAttribute("reelentryurl", CommonUtil.load(CommonUtil.REEL_TEST_ENTRY_PAGE));
		model.addAttribute("reelentryurlpm5", CommonUtil.load(CommonUtil.REEL_TEST_ENTRY_PAGE_PM5));

		model.addAttribute("rewindentryurl", CommonUtil.load(CommonUtil.REWIND_TEST_ENTRY_PAGE));
		model.addAttribute("rewindentryurlpm5", CommonUtil.load(CommonUtil.REWIND_TEST_ENTRY_PAGE_PM5));

		model.addAttribute(CommonUtil.FRP_PROJECTION_PAGE, CommonUtil.load(CommonUtil.FRP_PROJECTION_PAGE));
		model.addAttribute(CommonUtil.FRP_PROJECTION_JON_PAGE, CommonUtil.load(CommonUtil.FRP_PROJECTION_JON_PAGE));
		model.addAttribute(CommonUtil.HOUSE_KEEP_SCHEDULE_PAGE, CommonUtil.load(CommonUtil.HOUSE_KEEP_SCHEDULE_PAGE));
		model.addAttribute(CommonUtil.FIBER_PURCHASING_PAGE, CommonUtil.load(CommonUtil.FIBER_PURCHASING_PAGE));
		model.addAttribute(CommonUtil.FIBER_PURCHASING_PAGE_WHITE,
				CommonUtil.load(CommonUtil.FIBER_PURCHASING_PAGE_WHITE));

		try {
			InetAddress ipAddr = InetAddress.getLocalHost();
			System.out.println(ipAddr.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Calendar scal = Calendar.getInstance();
		scal.setTime(CommonUtil.getShiftDate());
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		Calendar ecal = Calendar.getInstance();
		ecal.setTime(new Date());
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);

		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);

		Date firstDate = CommonUtil.getFirstDate(scal.getTime());
		Date cruntDate = scal.getTime();
		double total6 = 0, whiteWeight6 = 0, redWeight6 = 0, totalTons6, total5 = 0, whiteWeight5 = 0, redWeight5 = 0,
				totalTons5, lineA = 0, lineB = 0, percentage = 0;

		total5 = CommonUtil.round(total5, 2);
		total6 = CommonUtil.round(total6, 2);
		lineA = CommonUtil.round(lineA, 2);
		lineB = CommonUtil.round(lineB, 2);
		System.out.println("total5= " + total5 + " total6 =" + total6);
		System.out.println("lineA= " + lineA + " lineB =" + lineB);

		percentage = ((total5 + total6) / (lineA + lineB)) * 100;
		percentage = CommonUtil.round(percentage, 2);
		System.out.println("percentage= " + percentage);
		model.addAttribute("yield", percentage);
		return "homeNew";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String allReport(HttpServletRequest request, Model model) {

		return "allReport";
	}

	@RequestMapping(value = "/prodmain", method = RequestMethod.GET)
	public String main(Model model) {
		return "productionWastepaper/main";
	}
}
