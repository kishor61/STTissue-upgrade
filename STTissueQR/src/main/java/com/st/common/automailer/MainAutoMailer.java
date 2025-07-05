/**
 * 
 */
package com.st.common.automailer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.service.MailDehBoardService;
import com.st.efficiency.model.EffSummaryPrimary;
import com.st.efficiencypm5.model.EffSummaryPrimaryPM5;
import com.st.higherauthoritydecision.model.HigherAuthorityDecision;
import com.st.higherauthoritydecision.service.HigherAuthorityDecisionService;
import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.productionpm5.automailer.ProductionPM5ReportAutoMailer;
import com.st.qualitypm5.automailer.ReelRewinderPM5AutoMailer;
import com.st.qualitypm6.automailer.ReelRewinderAutoMailer;
import com.st.service.qrt.DynamicSchedulerService;

/**
 * @author roshan
 *
 */
@Component
public class MainAutoMailer {

	private static final Logger logger = LoggerFactory.getLogger(MainAutoMailer.class);

	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private DateTimeFormatter jodaDateFormat = DateTimeFormat.forPattern("MM-dd-yyyy");

	@Autowired
	private MailDehBoardService mailboardService;

	@Autowired
	private ProductionReportAutoMailer productionReportAutoMailer;

	@Autowired
	private ProductionPM5ReportAutoMailer productionPM5ReportAutoMailer;

	@Autowired
	private ReelRewinderAutoMailer reelRewinderAutoMailer;

	@Autowired
	private ReelRewinderPM5AutoMailer reelRewinderPM5AutoMailer;

	@Autowired
	private TestingMail testingMail;

	@Autowired
	private HigherAuthorityDecisionService higherauthoritydecisionservice;

	@Autowired
	private DynamicSchedulerService dynamicSchedulerService;

	String d = DateTimeFormat.forPattern("HH:mm:ss").print(DateTime.now());

	/**
	 * Initialize dynamic scheduler on startup
	 */
	public void initializeDynamicScheduler() {
		logger.info("Initializing dynamic scheduler...");
		dynamicSchedulerService.refreshScheduledTasks();
		logger.info("Dynamic scheduler initialized successfully");
	}

	public String getDecision() {
		List<HigherAuthorityDecision> data = null;
		String status2 = "";
		data = higherauthoritydecisionservice.getdata(1);
		for (HigherAuthorityDecision lst : data) {
			status2 = lst.getStatus();
		}
		return status2;
	}

	/**
	 * Method to be called by dynamic scheduler for Saturday/Sunday test mail
	 */
	public void sendTestMailSatSun(String recipientEmails) {
		String status = getDecision();
		if (status.equalsIgnoreCase("Allow")) {
			try {
				// testingMail.sendTestMailSatSun();
				logger.info("SAT./SUN. Testing mail:{}", DateTime.now());
				mailboardService.save(DateTime.now().toDate(), "SAT./SUN. Testing mail", "SAT./SUN.", d, true, "",
						"testsatsun", "AutoMailer");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				mailboardService.save(DateTime.now().toDate(), "SAT./SUN. Testing mail", "SAT./SUN.", d, false, "" + e,
						"testsatsun", "AutoMailer");
			}
		} else {
			logger.warn("Mails Are Blocked - Saturday/Sunday test mail not sent");
		}
	}

	/**
	 * Method to be called by dynamic scheduler for 7:20 AM mails
	 */
	public void scheduledMailAt7_20am(String recipientEmails) {
		String status = getDecision();
		if (status.equalsIgnoreCase("Allow")) {
			String shiftText = "";

			logger.info("Mail Scheduler started at " + DateTime.now());
			DateTime date = CommonUtil.checkDate(CommonUtil.load(CommonUtil.MAIL_DATE), dateFormat) != null
					? new DateTime(CommonUtil.checkDate(CommonUtil.load(CommonUtil.MAIL_DATE), dateFormat))
					: new DateTime(CommonUtil.getShiftDate());
			
			/**
			 * Summary Report
			 */
			try {
				Map<String, Object> datas1 = new HashMap<>();

				List<EffSummaryPrimary> summaryPrimaries = new ArrayList<>();
				try {
					DateTime startDateTime = date.withTime(6, 0, 0, 0);
					DateTime endDateTime = date.plusDays(1).withTime(5, 59, 0, 0);

					// summaryPrimaries = formatSummaryData(startDateTime.toDate(),
					// endDateTime.toDate(), 0, 0);

				} catch (Exception e) {
					e.printStackTrace();
				}
				int totalmin = 0;
				for (EffSummaryPrimary effSummaryPrimary : summaryPrimaries) {
					totalmin += effSummaryPrimary.getTotalMin();
				}
				datas1.put("summaryPrimaries", summaryPrimaries);
				datas1.put("hh", totalmin / 60);
				datas1.put("mm", totalmin % 60);

				// productionReportAutoMailer.sendMailAt7am(date.toDate(), datas1);
				logger.info("STT-PM6-Production Summary Report:{}", DateTime.now());
				mailboardService.save(DateTime.now().toDate(), "STT-PM6-Production Summary Report_AM", "Daily", d, true,
						"", "productionAM", "Automailer");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				mailboardService.save(DateTime.now().toDate(), "STT-PM6-Production Summary Report_AM", "Daily", d,
						false, "" + e, "productionAM", "Automailer");
			}
			
			/**
			 * Summary Report For PM5
			 */
			try {
				Map<String, Object> datas1 = new HashMap<>();

				List<EffSummaryPrimaryPM5> summaryPrimaries = new ArrayList<>();
				try {
					DateTime startDateTime = date.withTime(6, 0, 0, 0);
					DateTime endDateTime = date.plusDays(1).withTime(5, 59, 0, 0);

					// summaryPrimaries = formatSummaryData_PM5(startDateTime.toDate(),
					// endDateTime.toDate(), 0, 0);

				} catch (Exception e) {
					e.printStackTrace();
				}
				int totalmin = 0;
				for (EffSummaryPrimaryPM5 effSummaryPrimary : summaryPrimaries) {
					totalmin += effSummaryPrimary.getTotalMin();
				}
				datas1.put("summaryPrimaries", summaryPrimaries);
				datas1.put("hh", totalmin / 60);
				datas1.put("mm", totalmin % 60);

				// productionPM5ReportAutoMailer.sendMailAt7am(date.toDate(), datas1);
				logger.info("STT-PM5-Production Summary Report:{}", DateTime.now());
				mailboardService.save(DateTime.now().toDate(), "STT-PM5-Production Summary Report_AM", "Daily", d, true,
						"", "productionAM", "Automailer");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				mailboardService.save(DateTime.now().toDate(), "STT-PM5-Production Summary Report_AM", "Daily", d,
						false, "" + e, "productionAM", "Automailer");
			}
			
			/**
			 * Reel and Rewinder Report
			 */
			try {
				// reelRewinderAutoMailer.sendMail(DateTime.now().toDate(), shiftText);
				logger.info("STT-PM6-Quality Report:{}", DateTime.now());
				mailboardService.save(DateTime.now().toDate(), "STT-PM6-Quality Report_AM", "Daily", d, true, "",
						"productionAM", "Automailer");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				mailboardService.save(DateTime.now().toDate(), "STT-PM6-Quality Report_AM", "Daily", d, false, "" + e,
						"productionAM", "Automailer");
			}

			/**
			 * Reel and Rewinder Report For PM5
			 */
			try {
				// reelRewinderPM5AutoMailer.sendMail(DateTime.now().toDate(), shiftText);
				logger.info("STT-PM5-Quality Report:{}", DateTime.now());
				mailboardService.save(DateTime.now().toDate(), "STT-PM5-Quality Report_AM", "Daily", d, true, "",
						"productionAM", "Automailer");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				mailboardService.save(DateTime.now().toDate(), "STT-PM5-Quality Report_AM", "Daily", d, false, "" + e,
						"productionAM", "Automailer");
			}
			
			/**
			 * Efficiency By Shift stopped
			 */
			try {
				// efficiencyAutoMailer.sendEfficiencyByShiftMail();
				// logger.info("Efficiency By Shift Report:{}", DateTime.now());
				// mailboardService.save(DateTime.now().toDate(), "Efficiency By
				// ShiftReport_AM", "Daily", d,
				// true, "","productionAM","Automailer");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				mailboardService.save(DateTime.now().toDate(), "Efficiency By Shift Report_AM", "Daily", d, false,
						"" + e, "productionAM", "Automailer");
			}
		} else {
			logger.warn("Mails Are Blocked - 7:20 AM mails not sent");
		}
	}

	/**
	 * Method to be called by dynamic scheduler for 7:20 PM mails
	 */
	public void scheduledMailAt7_20pm(String recipientEmails) {
		String status = getDecision();
		if (status.equalsIgnoreCase("Allow")) {
			logger.info("Mail Scheduler started at " + DateTime.now());

			String shiftText = " Day Shift";

			DateTime date = new DateTime(CommonUtil.getShiftDate());
			CommonUtil.save(CommonUtil.MAIL_DATE, jodaDateFormat.print(date));

			/**
			 * Summary Report
			 */
			try {
				Map<String, Object> datas1 = new HashMap<>();

				List<EffSummaryPrimary> summaryPrimaries = new ArrayList<>();
				try {
					DateTime startDateTime = date.withTime(7, 0, 0, 0);
					DateTime endDateTime = date.plusDays(1).withTime(6, 59, 0, 0);

					// summaryPrimaries = formatSummaryData(startDateTime.toDate(),
					// endDateTime.toDate(), 0, 0);

				} catch (Exception e) {
					e.printStackTrace();
				}
				int totalmin = 0;
				for (EffSummaryPrimary effSummaryPrimary : summaryPrimaries) {
					totalmin += effSummaryPrimary.getTotalMin();
				}
				datas1.put("summaryPrimaries", summaryPrimaries);
				datas1.put("hh", totalmin / 60);
				datas1.put("mm", totalmin % 60);

				// productionReportAutoMailer.sendMailAt7pm(date.toDate(), datas1);
				logger.info("STT-PM6-Production Summary Report:{}", DateTime.now());
				mailboardService.save(DateTime.now().toDate(), "STT-PM6-Production Summary Report_PM", "Daily", d, true,
						"", "productionPM", "Automailer");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				mailboardService.save(DateTime.now().toDate(), "STT-PM6-Production Summary Report_PM", "Daily", d,
						false, "" + e, "productionPM", "Automailer");
			}

			/**
			 * Summary Report For PM5
			 */
			try {
				Map<String, Object> datas1 = new HashMap<>();

				List<EffSummaryPrimaryPM5> summaryPrimaries = new ArrayList<>();
				try {
					DateTime startDateTime = date.withTime(7, 0, 0, 0);
					DateTime endDateTime = date.plusDays(1).withTime(6, 59, 0, 0);

					// summaryPrimaries = formatSummaryData_PM5(startDateTime.toDate(),
					// endDateTime.toDate(), 0, 0);

				} catch (Exception e) {
					e.printStackTrace();
				}
				int totalmin = 0;
				for (EffSummaryPrimaryPM5 effSummaryPrimary : summaryPrimaries) {
					totalmin += effSummaryPrimary.getTotalMin();
				}
				datas1.put("summaryPrimaries", summaryPrimaries);
				datas1.put("hh", totalmin / 60);
				datas1.put("mm", totalmin % 60);
				// productionPM5ReportAutoMailer.sendMailAt7pm(date.toDate(), datas1);
				logger.info("STT-PM5-Production Summary Report:{}", DateTime.now());
				mailboardService.save(DateTime.now().toDate(), "STT-PM5-Production Summary Report_PM", "Daily", d, true,
						"", "productionPM", "Automailer");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				mailboardService.save(DateTime.now().toDate(), "STT-PM5-Production Summary Report_PM", "Daily", d,
						false, "" + e, "productionPM", "Automailer");
			}

			/**
			 * Reel and Rewinder Report
			 */
			try {
				// reelRewinderAutoMailer.sendMail(date.toDate(), shiftText);
				logger.info("STT-PM6-Quality Report:{}", DateTime.now());
				mailboardService.save(DateTime.now().toDate(), "STT-PM6-Quality Report_PM", "Daily", d, true, "",
						"productionPM", "Automailer");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				mailboardService.save(DateTime.now().toDate(), "STT-PM6-Quality Report_PM", "Daily", d, false, "" + e,
						"productionPM", "Automailer");
			}

			/**
			 * Reel and Rewinder Report For PM5
			 */
			try {
				// reelRewinderPM5AutoMailer.sendMail(date.toDate(), shiftText);
				logger.info("STT-PM5-Quality Report:{}", DateTime.now());
				mailboardService.save(DateTime.now().toDate(), "STT-PM5-Quality Report_PM", "Daily", d, true, "",
						"productionPM", "Automailer");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				mailboardService.save(DateTime.now().toDate(), "STT-PM5-Quality Report_PM", "Daily", d, false, "" + e,
						"productionPM", "Automailer");
			}

		} else {
			logger.warn("Mails Are Blocked - 7:20 PM mails not sent");
		}
	}

	/**
	 * Method to refresh dynamic scheduler tasks
	 */
	public void refreshScheduler() {
		logger.info("Refreshing dynamic scheduler tasks...");
		dynamicSchedulerService.refreshScheduledTasks();
		logger.info("Dynamic scheduler tasks refreshed successfully");
	}
}
