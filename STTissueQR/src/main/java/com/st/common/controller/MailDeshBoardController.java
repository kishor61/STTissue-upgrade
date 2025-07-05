/**
 *18-Jun-2020
 *MainManualMailer.java
 * TODO
 *com.st.common.automailer
 *MainManualMailer.java
 *Sohan Lal 
 */
package com.st.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.st.common.automailer.MainAutoMailer;
import com.st.common.model.MailDeshBoard;
import com.st.common.service.MailDehBoardService;


/**
 * @author sohan
 *
 */

@Controller
@RequestMapping("/deshboard")
public class MailDeshBoardController {
	@Autowired
	private MailDehBoardService mailboardService;
	@Autowired
	private MainAutoMailer mainAutoMailer;

	@RequestMapping("/maildeshboard")
	public String getMailData(Model model) {
		List<MailDeshBoard> datas = mailboardService.getMailDatas();
		model.addAttribute("datas", datas);
		return "common/maildeshboard";
	}

//	@RequestMapping("/getDailyInventeryReportReel/{senderName}")
//	public String getDailyInventeryReportReel(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) throws IOException {
//		try {
//			mainAutoMailer.getDailyInventeryReportReelAt11_30am();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/scheduledMailAt7_20am/{senderName}")
//	public String scheduledMailAt7_20am(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.scheduledMailAt7_20am();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/scheduledMailAt7_20pm/{senderName}")
//	public String scheduledMailAt7_20pm(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.scheduledMailAt7_20pm();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/scheduledMailAt10_30am/{senderName}")
//	public String scheduledMailAt10_30am(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//
//		try {
//			mainAutoMailer.scheduledMailAt10_30am();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/scheduledMailMonthly2nd/{senderName}")
//	public String scheduledMailMonthly2nd(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//
//		try {
//			mainAutoMailer.scheduledMailMonthly2nd();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/qualityTestMailPM/{senderName}")
//	public String qualityTestMailPM(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.qualityTestMailPM();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/qualityTestMailAM/{senderName}")
//	public String qualityTestMailAM(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//
//		try {
//			mainAutoMailer.qualityTestMailAM();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/frpproductionopdataentryAM/{senderName}")
//	public String frpproductionopdataentryAM(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//
//		try {
//			mainAutoMailer.frpproductionopdataentryAM();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/frpopdataentrydetailedreportAM/{senderName}")
//	public String frpopdataentrydetailedreportAM(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.frpopdataentrydetailedreportAM();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/frpdailyopdataentrydetailedreportAM/{senderName}")
//	public String frpdailyopdataentrydetailedreportAM(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.frpdailyopdataentrydetailedreportAM();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/frpproductionopdataentrydetailedreportAM/{senderName}")
//	public String frpproductionopdataentrydetailedreportAM(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.frpproductionopdataentrydetailedreportAM();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/wetlapInventorySummaryReport/{senderName}")
//	public String wetlapInventorySummaryReport(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.wetlapInventorySummaryReport();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/gradeandhoursummarymailinamonth/{senderName}")
//	public String gradeandhoursummarymailinamonth(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.gradeandhoursummarymailinamonth();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/coaWeeklyEmailPM5/{senderName}")
//	public String coaWeeklyEmailPM5(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.coaWeeklyEmailPM5();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/coaWeeklyEmailPM6/{senderName}")
//	public String coaWeeklyEmailPM6(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.coaWeeklyEmailPM6();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/despatchReport1Email/{senderName}")
//	public String despatchReport1Email(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReport1Email();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/despatchReport2Email/{senderName}")
//	public String despatchReport2Email(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.despatchReport2Email();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/despatchReport3Email/{senderName}")
//	public String despatchReport3Email(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.despatchReport3Email();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/despatchReport4Email/{senderName}")
//	public String despatchReport4Email(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.despatchReport4Email();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/CH_Robinson1/{senderName}")
//	public String DespatchReport1CH_Robinson1(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReport1CH_Robinson1();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/CH_Robinson2/{senderName}")
//	public String DespatchReport1CH_Robinson2(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReport1CH_Robinson2();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/CH_Robinson3/{senderName}")
//	public String DespatchReport1CH_Robinson3(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//
//		try {
//			mainAutoMailer.DespatchReport1CH_Robinson3();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/CH_Robinson4/{senderName}")
//	public String DespatchReport1CH_Robinson4(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReport1CH_Robinson4();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/Swift1/{senderName}")
//	public String DespatchReportSwift1(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportMT1();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/Swift2/{senderName}")
//	public String DespatchReportSwift2(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportMT2();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/Swift3/{senderName}")
//	public String DespatchReportSwift3(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportMT3();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/Swift4/{senderName}")
//	public String DespatchReportSwift4(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportMT4();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/EchoGlobalLogistics1/{senderName}")
//	public String DespatchReportEchoGlobalLogistics1(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//
//		try {
//			mainAutoMailer.DespatchReportEchoGlobalLogistics1();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/EchoGlobalLogistics2/{senderName}")
//	public String DespatchReportEchoGlobalLogistics2(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportEchoGlobalLogistics2();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/EchoGlobalLogistics3/{senderName}")
//	public String DespatchReportEchoGlobalLogistics3(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//
//		try {
//			mainAutoMailer.DespatchReportEchoGlobalLogistics3();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/EchoGlobalLogistics4/{senderName}")
//	public String DespatchReportEchoGlobalLogistics4(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportEchoGlobalLogistics4();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/AmazonFreight1/{senderName}")
//	public String DespatchReportAmazonFreight1(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//
//		try {
//			mainAutoMailer.DespatchReportAmazonFreight1();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/AmazonFreight2/{senderName}")
//	public String DespatchReportAmazonFreight2(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportAmazonFreight2();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/AmazonFreight3/{senderName}")
//	public String DespatchReportAmazonFreight3(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportAmazonFreight3();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/AmazonFreight4/{senderName}")
//	public String DespatchReportAmazonFreight4(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportAmazonFreight4();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/Schneider1/{senderName}")
//	public String DespatchReportSimsGlobalSolutions1(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportSimsGlobalSolutions1();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/Schneider2/{senderName}")
//	public String DespatchReportSimsGlobalSolutions2(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportSimsGlobalSolutions2();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/Schneider3/{senderName}")
//	public String DespatchReportSimsGlobalSolutions3(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportSimsGlobalSolutions3();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/Schneider4/{senderName}")
//	public String DespatchReportSimsGlobalSolutions4(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportSimsGlobalSolutions4();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/blueLineLogstcsDespatchReport1/{senderName}")
//	public String BlueLineLogstcsDespatchReport1(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//
//		try {
//			mainAutoMailer.BlueLineLogstcsDespatchReport1();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/blueLineLogstcsDespatchReport2/{senderName}")
//	public String BlueLineLogstcsDespatchReport2(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.BlueLineLogstcsDespatchReport2();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/blueLineLogstcsDespatchReport3/{senderName}")
//	public String BlueLineLogstcsDespatchReport3(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.BlueLineLogstcsDespatchReport3();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/blueLineLogstcsDespatchReport4/{senderName}")
//	public String BlueLineLogstcsDespatchReport4(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.BlueLineLogstcsDespatchReport4();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/dailyShiftLogReport/{senderName}")
//	public String dailyShiftLogReport(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.dailyShiftLogReport();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/wastepaperBaleinventoryReport/{senderName}")
//	public String wastepaperBaleinventoryReport(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.wastepaperBaleinventoryReport();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/mailPM6ProducationReport/{senderName}")
//	public String mailPM6ProducationReport(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.mailPM6ProducationReport();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//
//	@RequestMapping("/mailPM5ProducationReport/{senderName}")
//	public String mailPM5ProducationReport(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.mailPM5ProducationReport();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//	@RequestMapping("/AR1/{senderName}")
//	public String DespatchReportAR1(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportAR1();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//	
//	@RequestMapping("/AR2/{senderName}")
//	public String DespatchReportAR2(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportAR2();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//	
//	
//	@RequestMapping("/AR3/{senderName}")
//	public String DespatchReportAR3(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportAR3();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
//	
//	@RequestMapping("/AR4/{senderName}")
//	public String DespatchReportAR4(RedirectAttributes redirectAttributes,
//			@PathVariable("senderName") String senderName, Authentication authentication) {
//		try {
//			mainAutoMailer.DespatchReportAR4();
//			redirectAttributes.addFlashAttribute("message", "Mail Send successfully.");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", "Mail Failed !");
//		}
//		return "redirect:/deshboard/maildeshboard";
//	}
}
