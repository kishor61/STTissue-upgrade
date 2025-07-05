/**
 * 
 */
package com.st.production.automailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.efficiency.model.EffSummaryPrimary;
import com.st.efficiency.model.EffSummarySecondary;
import com.st.production.model.MachineAndWrapper;
import com.st.production.model.MachineProduction;
import com.st.production.model.MachineProductionSummary;
import com.st.production.model.WrapperProduction;
import com.st.production.model.WrapperProductionSummary;
import com.st.production.report.ProductionReportHandler;
import com.st.production.service.MachineProductionService;
import com.st.production.service.WrapperProductionService;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletContext;

/**
 * @author kishor vaishnav 
 * 2025
 */
@Component
public class ProductionReportAutoMailer {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");

	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ServletContext context;

	@Autowired
	private MachineProductionService machineProductionService;

	@Autowired
	private WrapperProductionService wrapperProductionService;

	@Autowired
	private ProductionReportHandler productionPM6ReportHandler;

	@Value("${mail.to}")
	private String emailTo;


	@Value("${mail.to.sttreport.cr6}")
	private String emailToSttreportAndCR6;

	@Value("${mail.to.gradeandhours}")
	private String emailToGradeAndHours;

	@Value("${mail.bcc}")
	private String emailBcc;

	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;

	@Value("${mail.to.error}")
	private String emailToError;

	public void sendMailAt7am(final Date date, final Map<String, Object> datas1, String repientEmails) {
		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				try {

					Map<String, Object> datas = new HashMap<>();
					datas = machineProductionService.formatDataForSumaryReport(date, date, "");
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(repientEmails.split(";"));
					messageHelper.setBcc(emailBcc.split(";"));
					messageHelper.setFrom(emailFrom, emailFromName);
					Calendar cal = Calendar.getInstance();
					messageHelper
							.setSubject(dateTimeFormat4.format(cal.getTime()) + "-STT-PM6-Production Summary Report");
					cal.add(Calendar.DATE, -1);
					mimeMessage.setContent(getMessageBody(datas, datas1, cal.getTime()), "text/html");
				} catch (Exception e) {
					logger.error("Error message in Production Summary report..." + e.getMessage(), e);

					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(emailToError.split(";"));
					messageHelper.setFrom(emailFrom);
					messageHelper.setSubject("Fail to send production summary report.");
					mimeMessage.setContent("Unable to read production data<br>" + e.getMessage(), "text/html");
				}

				logger.info("Production Summary Report message sent....");
			}
		});
	}

	public void sendMailAt7pm(final Date date, final Map<String, Object> datas1 , String repientEmails) {

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				try {

					Map<String, Object> datas = new HashMap<>();

					datas = machineProductionService.formatDataForSumaryReport(date, date, "Day");

					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(repientEmails.split(";"));
					messageHelper.setFrom(emailFrom, emailFromName);
					messageHelper.setBcc(emailBcc.split(";"));
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, -1);
					messageHelper
							.setSubject(dateTimeFormat4.format(cal.getTime()) + "-STT-PM6-Production Summary Report");
					mimeMessage.setContent(getMessageBody(datas, datas1, date), "text/html");

				} catch (Exception e) {
					logger.error("Error message in Production Summary report..." + e.getMessage(), e);
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(emailToError.split(";"));
					messageHelper.setFrom(emailFrom);
					messageHelper.setSubject("Fail to send production summary report.");
					mimeMessage.setContent("Unable to read production data<br>" + e.getMessage(), "text/html");
				}

				logger.info("Production Summary Report message sent....");
			}
		});
	}

	@SuppressWarnings("unchecked")
	private String getMessageBody(Map<String, Object> datas, Map<String, Object> datas1, Date date) throws Exception {

		boolean flag = (Boolean) datas.get("dataFlag");
		StringBuilder builder = new StringBuilder();

		if (flag) {
			builder.append("Hello Sir,"
					+ "<br/><br/><p>We are unable to generate ST Tissue Production Summary Report at this time because<br><br>"
					+ "<span style=\"color: red;font-size: 18px;\"> \"Either data not available in database or Machine is under maintenance.\"</span></p>");
		} else {
			builder.append("");
			builder.append("<style type=\"text/css\">");
			builder.append(
					"body{font-family: sans-serif;}table {border-collapse: collapse;}table tr td,table tr th{border: 1px solid;font-size: 12px;text-align: center;}");
			builder.append("</style>");

			builder.append("Hello Sir," + "<br/><br/>Please find the below ST Tissue PM6 Production Summary Report for "
					+ dateFormat.format(date) + " for your review.<br/><br/>");

			builder.append("<table style=\"width: 800px;\">");
			builder.append("<tr><th colspan=\"7\" style=\"font-size: 14px;\">PM6 Machine Production - "
					+ dateFormat.format(date) + "</th></tr>");
			builder.append("<tr>");
			builder.append("<th style=\"width: 100px;\">Date</th>");
			builder.append("<th style=\"width: 100px;\">Grade</th>");
			builder.append("<th style=\"width: 60px;\">Day</th>");
			builder.append("<th style=\"width: 60px;\">Night</th>");
			builder.append("<th style=\"width: 60px;\">Total</th>");
			builder.append("<th style=\"width: 60px;\">Reject</th>");
			builder.append("<th >Remarks for Reject</th>");
			builder.append("</tr>");

			List<MachineProductionSummary> productionSummaries = (List<MachineProductionSummary>) datas
					.get("production");

			int count = 0;

			double totalDay = 0;
			double totalNight = 0;
			double totalDayNight = 0;
			double totalRejected = 0;

			for (MachineProductionSummary machineProductionSummary : productionSummaries) {
				builder.append("<tr>");
				if (count == 0) {
					builder.append("<td>" + dateFormat.format(date) + "</td>");
				} else {
					builder.append("<td></td>");
				}

				builder.append("<td>" + machineProductionSummary.getGradeCode() + "</td>");
				builder.append("<td>" + CommonUtil.round(machineProductionSummary.getDayWeight(), 2) + "</td>");
				builder.append("<td>" + CommonUtil.round(machineProductionSummary.getNightWeight(), 2) + "</td>");
				builder.append("<td>"
						+ CommonUtil.round(
								machineProductionSummary.getDayWeight() + machineProductionSummary.getNightWeight(), 2)
						+ "</td>");
				builder.append("<td>" + CommonUtil.round(machineProductionSummary.getRejected(), 2) + "</td>");
				builder.append("<td>" + machineProductionSummary.getComments() + "</td>");

				builder.append("</tr>");

				totalDay += machineProductionSummary.getDayWeight();
				totalNight += machineProductionSummary.getNightWeight();
				totalDayNight += machineProductionSummary.getDayWeight() + machineProductionSummary.getNightWeight();
				totalRejected += machineProductionSummary.getRejected();

				count++;

			}

			builder.append("<tr>");
			builder.append("<td></td>");
			builder.append("<td><b>Total</b></td>");
			builder.append("<td>" + CommonUtil.round(totalDay, 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(totalNight, 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(totalDayNight, 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(totalRejected, 2) + "</td>");
			builder.append("<td></td>");
			builder.append("</tr>");

			MachineProductionSummary mpMTD = (MachineProductionSummary) datas.get("mpMTD");
			builder.append("<tr>");
			builder.append("<td></td>");
			builder.append("<td><b>MTD</b></td>");
			builder.append("<td>" + CommonUtil.round(mpMTD.getDayWeight(), 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(mpMTD.getNightWeight(), 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(mpMTD.getDayWeight() + mpMTD.getNightWeight(), 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(mpMTD.getRejected(), 2) + "</td>");
			builder.append("<td></td>");
			builder.append("</tr>");

			builder.append("<tr><th colspan=\"7\">&nbsp;</th></tr>");
			// Code Starts From Here Done By Roshan Tailor For Machine
			// Production Break Info Date :- 23/11/2015
			List<MachineProduction> machineProductionsForRollBreak = (List<MachineProduction>) datas
					.get("machinerollbreakinfo");
			builder.append("<thead>" + "<tr class='trobjrow'>" + "<th colspan='7'>PM6 Machine Sheet Break Summary - "
					+ dateFormat.format(date) + "</th>" + "</tr>" + "<tr>" + "<th></th>" + "<th>Shift</th>"
					+ "<th colspan='2'>Number of Rolls With Breaks</th>"
					+ "<th colspan='2'>Number of Rolls Produse</th>" + "<th>Break Free %</th>" + "</tr>" + "</thead>");
			builder.append("<tbody>");
			int totalRoll1 = 0;
			int totalRoll1Produse = 0;
			double percentageofrollswithbreaks1 = 0;
			double totalper1 = 0;
			if (machineProductionsForRollBreak.size() == 2) {
				for (MachineProduction breakinfo1 : machineProductionsForRollBreak) {
					builder.append("<tr>");
					builder.append("<td><center><div></div></center></td>");
					builder.append("<td><center><div><b>" + breakinfo1.getShift() + "</b></div></center></td>");
					builder.append("<th colspan='2'>" + breakinfo1.getNumberofrollswithbreaks() + "</th>");
					builder.append("<th colspan='2'>" + breakinfo1.getTotalrollsproduce() + "</th>");
					builder.append(
							"<td><center><div>" + CommonUtil.round(breakinfo1.getPercentageofrollswithbreaks(), 2)
									+ "</div></center></td>");
					builder.append("</tr>");
					totalRoll1 = totalRoll1 + breakinfo1.getNumberofrollswithbreaks();
					totalRoll1Produse = totalRoll1Produse + breakinfo1.getTotalrollsproduce();
					percentageofrollswithbreaks1 = percentageofrollswithbreaks1
							+ breakinfo1.getPercentageofrollswithbreaks();
					totalper1 = totalper1 + breakinfo1.getPercentageofrollswithbreaks();
				}
				builder.append("<tr class='trrowgray'>" + "<td style='width: 35px;'><center></center></td>"
						+ "<td style='width: 45px;'><center><b>Total</b></center></td>"
						+ "<th colspan='2'><center><div><b>" + totalRoll1 + "</b></div></center></th>"
						+ "<th colspan='2'><center><div><b>" + totalRoll1Produse + "</b></div></center></th>"
						+ "<td><div><center><b>" + CommonUtil.round(100 - (totalRoll1 / totalRoll1Produse) * 100, 2)
						+ "</b></center></div></td>" + "</tr>" + "<tr>" + "<td colspan='7'><div>&nbsp;<br></div></td>"
						+ "</tr>");
				builder.append("</tbody>");
			} else if (machineProductionsForRollBreak.size() == 1) {
				for (MachineProduction breakinfo1 : machineProductionsForRollBreak) {
					String comingShift = breakinfo1.getShift();
					if (comingShift.equalsIgnoreCase("Day")) {
						builder.append("<tr>");
						builder.append("<td><center><div></div></center></td>");
						builder.append("<td><center><div><b>" + breakinfo1.getShift() + "</b></div></center></td>");
						builder.append("<th colspan='2'>" + breakinfo1.getNumberofrollswithbreaks() + "</th>");
						builder.append("<th colspan='2'>" + breakinfo1.getTotalrollsproduce() + "</th>");
						builder.append(
								"<td><center><div>" + CommonUtil.round(breakinfo1.getPercentageofrollswithbreaks(), 2)
										+ "</div></center></td>");
						builder.append("</tr>");

						totalRoll1 = totalRoll1 + breakinfo1.getNumberofrollswithbreaks();
						totalRoll1Produse = totalRoll1Produse + breakinfo1.getTotalrollsproduce();
						percentageofrollswithbreaks1 = percentageofrollswithbreaks1
								+ breakinfo1.getPercentageofrollswithbreaks();
						totalper1 = totalper1 + breakinfo1.getPercentageofrollswithbreaks();

						builder.append("<tr>");
						builder.append("<td><center><div></div></center></td>");
						builder.append("<td><center><div><b>Night</b></div></center></td>");
						builder.append("<th colspan='2'>0</th>");
						builder.append("<th colspan='2'>0</th>");
						builder.append("<td><center><div>100</div></center></td>");
						builder.append("</tr>");

						builder.append("<tr class='trrowgray'>" + "<td style='width: 35px;'><center></center></td>"
								+ "<td style='width: 45px;'><center><b>Total</b></center></td>"
								+ "<th colspan='2'><center><div><b>" + totalRoll1 + "</b></div></center></th>"
								+ "<th colspan='2'><center><div><b>" + totalRoll1Produse + "</b></div></center></th>"
								+ "<td><div><center><b>"
								+ CommonUtil.round(breakinfo1.getPercentageofrollswithbreaks(), 2)
								+ "</b></center></div></td>" + "</tr>" + "<tr>"
								+ "<td colspan='7'><div>&nbsp;<br></div></td>" + "</tr>");
					} else if (comingShift.equalsIgnoreCase("Night")) {
						builder.append("<tr>");
						builder.append("<td><center><div></div></center></td>");
						builder.append("<td><center><div><b>" + breakinfo1.getShift() + "</b></div></center></td>");
						builder.append("<th colspan='2'>" + breakinfo1.getNumberofrollswithbreaks() + "</th>");
						builder.append("<th colspan='2'>" + breakinfo1.getTotalrollsproduce() + "</th>");
						builder.append(
								"<td><center><div>" + CommonUtil.round(breakinfo1.getPercentageofrollswithbreaks(), 2)
										+ "</div></center></td>");
						builder.append("</tr>");

						totalRoll1 = totalRoll1 + breakinfo1.getNumberofrollswithbreaks();
						totalRoll1Produse = totalRoll1Produse + breakinfo1.getTotalrollsproduce();
						percentageofrollswithbreaks1 = percentageofrollswithbreaks1
								+ breakinfo1.getPercentageofrollswithbreaks();
						totalper1 = totalper1 + breakinfo1.getPercentageofrollswithbreaks();

						builder.append("<tr>");
						builder.append("<td><center><div></div></center></td>");
						builder.append("<td><center><div><b>Day</b></div></center></td>");
						builder.append("<th colspan='2'>0</th>");
						builder.append("<th colspan='2'>0</th>");
						builder.append("<td><center><div>100</div></center></td>");
						builder.append("</tr>");

						builder.append("<tr class='trrowgray'>" + "<td style='width: 35px;'><center></center></td>"
								+ "<td style='width: 45px;'><center><b>Total</b></center></td>"
								+ "<th colspan='2'><center><div><b>" + totalRoll1 + "</b></div></center></th>"
								+ "<th colspan='2'><center><div><b>" + totalRoll1Produse + "</b></div></center></th>"
								+ "<td><div><center><b>"
								+ CommonUtil.round(breakinfo1.getPercentageofrollswithbreaks(), 2)
								+ "</b></center></div></td>" + "</tr>" + "<tr>"
								+ "<td colspan='7'><div>&nbsp;<br></div></td>" + "</tr>");
					} else {

					}
				}
			} else {

				builder.append("<tr>");
				builder.append("<td><center><div></div></center></td>");
				builder.append("<td><center><div><b>Day</b></div></center></td>");
				builder.append("<th colspan='2'>0</th>");
				builder.append("<th colspan='2'>0</th>");
				builder.append("<td><center><div>100</div></center></td>");
				builder.append("</tr>");

				builder.append("<tr>");
				builder.append("<td><center><div></div></center></td>");
				builder.append("<td><center><div><b>Night</b></div></center></td>");
				builder.append("<th colspan='2'>0</th>");
				builder.append("<th colspan='2'>0</th>");
				builder.append("<td><center><div>100</div></center></td>");
				builder.append("</tr>");

				builder.append("<tr class='trrowgray'>" + "<td style='width: 35px;'><center></center></td>"
						+ "<td style='width: 45px;'><center><b>Total</b></center></td>"
						+ "<th colspan='2'><center><div><b>0</b></div></center></th>"
						+ "<th colspan='2'><center><div><b>0</b></div></center></th>"
						+ "<td><div><center><b>100</b></center></div></td>" + "</tr>" + "<tr>"
						+ "<td colspan='7'><div>&nbsp;<br></div></td>" + "</tr>");
			}

			builder.append("</tbody>");
			builder.append("<tr><th colspan=\"7\" style=\"font-size: 14px;\">PM6 Wrapped Production - "
					+ dateFormat.format(date) + "</th></tr>");
			builder.append("<tr>");
			builder.append("<th style=\"width: 100px;\">Date</th>");
			builder.append("<th style=\"width: 100px;\">Shift</th>");
			builder.append("<th style=\"width: 60px;\">White</th>");
			builder.append("<th style=\"width: 60px;\">Red</th>");
			builder.append("<th style=\"width: 60px;\">Total</th>");
			builder.append("<th style=\"width: 60px;\">Reject</th>");
			builder.append("<th >Remarks for Red/Reject</th>");
			builder.append("</tr>");

			WrapperProductionSummary dayWrapperProductionSummary = (WrapperProductionSummary) datas.get("wrapDay");
			WrapperProductionSummary nightWrapperProductionSummary = (WrapperProductionSummary) datas.get("wrapNigh");

			builder.append("<tr>");
			builder.append("<td>" + dateFormat.format(date) + "</td>");
			builder.append("<td><b>Day</b></td>");
			builder.append("<td>" + CommonUtil.round(dayWrapperProductionSummary.getWhiteWeight(), 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(dayWrapperProductionSummary.getRedWeight(), 2) + "</td>");
			builder.append("<td>" + CommonUtil
					.round(dayWrapperProductionSummary.getWhiteWeight() + dayWrapperProductionSummary.getRedWeight(), 2)
					+ "</td>");
			builder.append("<td>" + CommonUtil.round(dayWrapperProductionSummary.getRejectWeight(), 2) + "</td>");
			builder.append("<td>" + dayWrapperProductionSummary.getComment() + "</td>");
			builder.append("</tr>");

			builder.append("<tr>");
			builder.append("<td></td>");
			builder.append("<td><b>Night</b></td>");
			builder.append("<td>" + CommonUtil.round(nightWrapperProductionSummary.getWhiteWeight(), 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(nightWrapperProductionSummary.getRedWeight(), 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(
					nightWrapperProductionSummary.getWhiteWeight() + nightWrapperProductionSummary.getRedWeight(), 2)
					+ "</td>");
			builder.append("<td>" + CommonUtil.round(nightWrapperProductionSummary.getRejectWeight(), 2) + "</td>");
			builder.append("<td>" + nightWrapperProductionSummary.getComment() + "</td>");
			builder.append("</tr>");

			builder.append("<tr>");
			builder.append("<td></td>");
			builder.append("<td><b>Total</b></td>");
			builder.append("<td>" + CommonUtil.round(
					nightWrapperProductionSummary.getWhiteWeight() + dayWrapperProductionSummary.getWhiteWeight(), 2)
					+ "</td>");
			builder.append("<td>" + CommonUtil
					.round(nightWrapperProductionSummary.getRedWeight() + dayWrapperProductionSummary.getRedWeight(), 2)
					+ "</td>");
			builder.append("<td>" + CommonUtil.round(
					nightWrapperProductionSummary.getWhiteWeight() + nightWrapperProductionSummary.getRedWeight()
							+ dayWrapperProductionSummary.getWhiteWeight() + dayWrapperProductionSummary.getRedWeight(),
					2) + "</td>");
			builder.append("<td>" + CommonUtil.round(
					nightWrapperProductionSummary.getRejectWeight() + dayWrapperProductionSummary.getRejectWeight(), 2)
					+ "</td>");
			builder.append("<td></td>");
			builder.append("</tr>");

			WrapperProductionSummary wpMTD = (WrapperProductionSummary) datas.get("wpMTD");

			builder.append("<tr>");
			builder.append("<td></td>");
			builder.append("<td><b>MTD</b></td>");
			builder.append("<td>" + CommonUtil.round(wpMTD.getWhiteWeight(), 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(wpMTD.getRedWeight(), 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(wpMTD.getWhiteWeight() + wpMTD.getRedWeight(), 2) + "</td>");
			builder.append("<td>" + CommonUtil.round(wpMTD.getRejectWeight(), 2) + "</td>");
			builder.append("<td></td>");
			builder.append("</tr>");

			builder.append("</table>");
			// Code Starts From Here Done By Roshan Tailor Date:- 2015-11-17
			builder.append("</br>");

			builder.append(
					"<table border='0' style='width: 800px;background-color:#FFFFFF;border-collapse:collapse;color:#000000;' cellpadding='3' cellspacing='3'><tr><td>&nbsp;</td></tr></table>");

			builder.append(
					"<table border='1' style='width: 800px;background-color:#FFFFFF;border-collapse:collapse;border:2px solid #000000;color:#000000;' cellpadding='3' cellspacing='3'>"
							+ "<tr>" + "<center><td><b style='font-size: 13px;'>PM6 Wrapped Sheet Break Summary - "
							+ dateFormat.format(date) + "</b></center></td>" + "</tr>" + "</table>");
			builder.append(
					"<table border='2' style='width: 800px;background-color:#FFFFFF;border-collapse:collapse;border:2px solid #000000;color:#000000;' cellpadding='3' cellspacing='3'>"
							+ "<tr>" + "<td style='width: 100px;'></td>" + "<td style='width: 100px;'><b>Shift</b></td>"
							+ "<td style='width: 170px;'><b>Number of Rolls With Breaks</b></td>"
							+ "<td style='width: 144px;'><b>Number of Rolls Produse</b></td>"
							+ "<td><b>Break Free %</b></td>" + "</tr>");
			List<WrapperProduction> rollbreakinfo = (List<WrapperProduction>) datas.get("rollbreakinfo");
			System.out.println("rollbreakinfo::" + rollbreakinfo.size());

			if (rollbreakinfo.size() == 2) {

				int TotalRollBreak = 0;
				int TotalRollsProduce = 0;
				/*
				 * double Percentageofrollswithbreaks11 = 0; double Totalper = 0;
				 */
				for (WrapperProduction breakinfo : rollbreakinfo) {
					builder.append("<tr>" + "<td style='width: 100px;'></td>" + "<td  style='width: 100px;'><b>"
							+ breakinfo.getShift() + "</b></td>" + "<td style='width: 100px;'>"
							+ breakinfo.getNumberofrollswithbreaks() + "</td>" + "<td style='width: 100px;'>"
							+ breakinfo.getTotalrollsproduce() + "</td>" + "<td>"
							+ CommonUtil.round(breakinfo.getPercentageofrollswithbreaks(), 2) + "</td>" + "</tr>");
					TotalRollBreak = TotalRollBreak + breakinfo.getNumberofrollswithbreaks();

					TotalRollsProduce = TotalRollsProduce + breakinfo.getTotalrollsproduce();

					/*
					 * percentageofrollswithbreaks1 = percentageofrollswithbreaks1+
					 * breakinfo.getPercentageofrollswithbreaks();
					 * 
					 * totalper1 = totalper1+ breakinfo.getPercentageofrollswithbreaks();
					 */

				}
				Integer obj1 = Integer.valueOf(TotalRollBreak);
				double d1 = obj1.doubleValue();

				Integer obj2 = Integer.valueOf(TotalRollsProduce);
				double d2 = obj2.doubleValue();

				// System.out.println("Value of d = " + d);

				System.out.println(d1 / d2);
				System.out.println((d1 / d2) * 100);
				System.out.println(CommonUtil.round(100 - (d1 / d2) * 100, 2));
				builder.append("<tr>" + "<td style='width: 100px;'></td>"
						+ "<td  style='width: 100px;'><b>Total</b></td>" + "<td style='width: 100px;'>" + TotalRollBreak
						+ "</td>" + "<td style='width: 100px;'>" + TotalRollsProduce + "</td>" // 100-(totalRoll/totalrollsproduce)*100
						+ "<td>" + CommonUtil.round(100 - (d1 / d2) * 100, 2) + "</td>" + "</tr>");
				builder.append("</table>");

			} else if (rollbreakinfo.size() == 1) {
				int totalRoll = 0;
				int totalRollProduse = 0;
				double percentageofrollswithbreaks = 0;
				double totalper = 0;
				for (WrapperProduction breakinfo : rollbreakinfo) {
					String comingShift = breakinfo.getShift();

					if (comingShift.equalsIgnoreCase("Day")) {
						builder.append("<tr>" + "<td style='width: 100px;'></td>" + "<td  style='width: 100px;'><b>"
								+ breakinfo.getShift() + "</b></td>" + "<td style='width: 200px;'>"
								+ breakinfo.getNumberofrollswithbreaks() + "</td>" + "<td style='width: 200px;'>"
								+ breakinfo.getTotalrollsproduce() + "</td>" + "<td>"
								+ CommonUtil.round(breakinfo.getPercentageofrollswithbreaks(), 2) + "</td>" + "</tr>");
						totalRoll = totalRoll + breakinfo.getNumberofrollswithbreaks();
						percentageofrollswithbreaks = percentageofrollswithbreaks
								+ breakinfo.getPercentageofrollswithbreaks();
						totalper = totalper + breakinfo.getPercentageofrollswithbreaks();
						totalRollProduse = totalRollProduse + breakinfo.getTotalrollsproduce();

						builder.append("<tr>" + "<td style='width: 100px;'></td>"
								+ "<td  style='width: 100px;'><b>Night</b></td>" + "<td style='width: 200px;'>0</td>"
								+ "<td style='width: 200px;'>0</td>" + "<td>100</td>" + "</tr>");
						builder.append("<tr>" + "<td style='width: 100px;'></td>"
								+ "<td  style='width: 100px;'><b>Total</b></td>" + "<td style='width: 200px;'>"
								+ totalRoll + "</td>" + "<td style='width: 200px;'>" + totalRollProduse + "</td>"
								+ "<td>" + CommonUtil.round(breakinfo.getPercentageofrollswithbreaks(), 2) + "</td>"
								+ "</tr>");

						builder.append("</table>");
					} else if (comingShift.equalsIgnoreCase("Night")) {

						builder.append("<tr>" + "<td style='width: 100px;'></td>" + "<td  style='width: 100px;'><b>"
								+ breakinfo.getShift() + "</b></td>" + "<td style='width: 200px;'>"
								+ breakinfo.getNumberofrollswithbreaks() + "</td>" + "<td style='width: 200px;'>"
								+ breakinfo.getTotalrollsproduce() + "</td>" + "<td>"
								+ CommonUtil.round(breakinfo.getPercentageofrollswithbreaks(), 2) + "</td>" + "</tr>");
						totalRoll = totalRoll + breakinfo.getNumberofrollswithbreaks();
						percentageofrollswithbreaks = percentageofrollswithbreaks
								+ breakinfo.getPercentageofrollswithbreaks();
						totalper = totalper + breakinfo.getPercentageofrollswithbreaks();
						totalRollProduse = totalRollProduse + breakinfo.getTotalrollsproduce();
						builder.append("<tr>" + "<td style='width: 100px;'></td>"
								+ "<td  style='width: 100px;'><b>Day</b></td>" + "<td style='width: 200px;'>0</td>"
								+ "<td style='width: 200px;'>0</td>" + "<td>100</td>" + "</tr>");
						builder.append("<tr>" + "<td style='width: 100px;'></td>"
								+ "<td  style='width: 100px;'><b>Total</b></td>" + "<td style='width: 200px;'>"
								+ totalRoll + "</td>" + "<td style='width: 200px;'>" + totalRollProduse + "</td>"
								+ "<td>" + CommonUtil.round(breakinfo.getPercentageofrollswithbreaks(), 2) + "</td>"
								+ "</tr>");

						builder.append("</table>");
					}
				}
			} else {
				builder.append("<tr>" + "<td style='width: 100px;'></td>" + "<td  style='width: 100px;'><b>Day</b></td>"
						+ "<td style='width: 200px;'>0</td>" + "<td style='width: 200px;'>0</td>" + "<td>100</td>"
						+ "</tr>");
				builder.append("<tr>" + "<td style='width: 100px;'></td>"
						+ "<td  style='width: 100px;'><b>Night</b></td>" + "<td style='width: 200px;'>0</td>"
						+ "<td style='width: 200px;'>0</td>" + "<td>100</td>" + "</tr>");
				builder.append("<tr>" + "<td style='width: 100px;'></td>"
						+ "<td  style='width: 100px;'><b>Total</b></td>" + "<td style='width: 200px;'>0</td>"
						+ "<td style='width: 200px;'>0</td>" + "<td>100</td>" + "</tr>");
				builder.append("</table>");

			}
			
			List<EffSummaryPrimary> effSummaryPrimaries = (List<EffSummaryPrimary>) datas1.get("summaryPrimaries");

			builder.append("<table style='width: 800px;'>" + "<thead>" + "<tr class='trobjrow' style='width: 800px;'>"
					+ "<th colspan='7'>Efficiency Down Time Summary Report</th>" + "</tr>");

			builder.append(
					"<tr style='width: 800px;'>" + "<td colspan='5' ></td>" + "<td style='text-align: center;'>HH</td>"
							+ "<td style='text-align: center;'>MM</td>" + "</tr>" + "</thead>" + "<tbody>");

			for (EffSummaryPrimary effSummaryPrimary : effSummaryPrimaries) {

				builder.append("<tr style=\"width: 800px;\">" + "<td  colspan='5' style='text-align: left;'>" + "<b>"
						+ effSummaryPrimary.getCode() + "</b>" + "</td>" + "<td></td>" + "<td></td>" + "</tr>");
				List<EffSummarySecondary> effSummarySecondaries = effSummaryPrimary.getSummarySecondaries();
				for (EffSummarySecondary effSummarySecondary : effSummarySecondaries) {

					builder.append("<tr style=\"width: 800px;\">" + "<td  colspan='5'  style='text-align: left;'>"
							+ effSummarySecondary.getCode() + "</td>" + "<td><center>" + effSummarySecondary.getHh()
							+ "</center></td>" + "<td><center>" + effSummarySecondary.getMm() + "</center></td>"
							+ "</tr>");
				}

				builder.append("<tr style=\"width: 800px;\">"
						+ "<td colspan='5'  class='trrowgray' style='text-align: right;'><b>TOTAL</b></td>"
						+ "<td class='trrowgray'><center>" + effSummaryPrimary.getHh() + "</center></td>"
						+ "<td class='trrowgray'><center>" + effSummaryPrimary.getMm() + "</center></td>" + "</tr>");
			}

			builder.append("<tr style=\"width: 800px;\">"
					+ "<td  colspan='5'  class='trrowgray2' style='text-align: right;'><b>GRAND TOTAL</b></td>"
					+ "<td class='trrowgray2'><center><b>"
					+ NumberUtils.toInt(datas1.get("hh") == null ? "" : datas1.get("hh").toString(), 0)
					+ "</b></center></td>" + "<td class='trrowgray2'><center><b>"
					+ NumberUtils.toInt(datas1.get("mm") == null ? "" : datas1.get("mm").toString(), 0)
					+ "</b></center></td>" + "</tr>");

			builder.append("</tbody></table>");

		}

		builder.append(
				"<br/>--<br/>Thank You,<br/>Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email:Time"
						+ dateTimeFormat.format(new Date()) + " ***</p>");

		return builder.toString();
	}

	public void sendGradeAndHoureMail(Date sdate, final Date edate) throws Exception {
		String folder = System.getProperty("catalina.base") + "/Grade And Hours";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File xlsfile = new File(folder, "Grade and Houres" + ".xlsx");

		prepareGAHDocument(xlsfile, sdate, edate);

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				messageHelper.setTo(emailToGradeAndHours.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				// messageHelper.setSubject("ST Tissue Grade and Hours reports
				// "+dateTimeFormat.format(new
				// Date()));
				// Code Starts From Here Done By Roshan Tailor Date :-
				// 06/26/2015 MM/DD/YYYY Night Shift

				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				// System.out.println("Yesterday's date = "+ cal.getTime());

				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime()) + "-STT-PM6-Grade and Hours Reports");
				// Code Ends Here Done By Roshan Tailor Date:- 06/26/2015
				messageHelper.setText(getMessage(), true);
				if (xlsfile.exists()) {
					messageHelper.addAttachment(
							dateTimeFormat4.format(cal.getTime()) + "-STT-PM6-Grade and Hours reports.xlsx",
							new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue Grade and Hours reports mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append(
						"Please find the attached <b>\"ST Tissue Grade And Hours Report Of PM6\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append(
						"Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
								+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});

	}

	/**
	 * @param xlsfile
	 * @param edate
	 * @param sdate
	 * @throws ProductionException
	 * @throws IOException
	 * @throws Exception
	 */
	private void prepareGAHDocument(File xlsfile, Date sdate, Date edate) throws ProductionException, Exception {
		/*
		 * Calendar calendar=Calendar.getInstance(); calendar.setTime(new Date());
		 * calendar.add(Calendar.DATE, -1);
		 * 
		 * Date edate=dateFormat.parse(dateFormat.format(calendar.getTime())); Date
		 * sdate=CommonUtil.getFirstDate(edate);
		 */
		List<Map<String, Object>> datas = wrapperProductionService.getGradeAndHourData(sdate, edate);

		FileOutputStream outputStream = new FileOutputStream(xlsfile);

		productionPM6ReportHandler.createExcelGradeAndHoursReport(datas, outputStream);

		outputStream.close();

	}

	/**
	 * @throws Exception
	 * 
	 */
	public void sendInventoryDailySummary() throws Exception {
		String folder = System.getProperty("catalina.base") + "/Grade And Hours";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File pdfFile = new File(folder, "Invenotry Daily Summary" + ".pdf");

		prepareInventorySummaryDocument(pdfFile);

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				messageHelper.setTo(emailToGradeAndHours.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				// messageHelper.setSubject("ST Tissue- Inventory Daily Summary
				// "+dateTimeFormat.format(new
				// Date()));
				// Code Starts From Here Done By Roshan Tailor Date:- 06/26/2015
				// MM/DD/YYYY Night Shift
				messageHelper.setSubject(dateTimeFormat4.format(new Date()) + "-STT-Inventory Daily Summary");
				// Code Ends Here Done By Roshan Tailor Date :- 06/26/2015
				messageHelper.setText(getMessage(), true);
				if (pdfFile.exists()) {
					messageHelper.addAttachment(dateTimeFormat4.format(new Date()) + "-STT-Inventory Daily Summary.pdf",
							new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(pdfFile))));
				}
				logger.info("ST Tissue Inventory Daily Summary reports mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append(
						"Please find the attached <b>\"ST Tissue Inventory Daily Summary reports\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append(
						"Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
								+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});

	}

	/**
	 * @param pdfFile
	 * @throws Exception
	 */
	private void prepareInventorySummaryDocument(File pdfFile) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -1);

		Date edate = dateFormat.parse(dateFormat.format(calendar.getTime()));
		Date sdate = dateFormat.parse(dateFormat.format(calendar.getTime()));

		List<WrapperProduction> productions = wrapperProductionService.getWrapperForDailyInventory(sdate, edate);

		FileOutputStream outputStream = new FileOutputStream(pdfFile);

		productionPM6ReportHandler.createPdfInventoryDailySummary(productions, outputStream);

		outputStream.close();

	}

	public void sendGradeAndHoureMachineMail(Date sdate, Date edate) throws Exception {
		String folder = System.getProperty("catalina.base") + "/Grade And Hours";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File xlsfile = new File(folder, "Grade and Houres Machine" + ".xlsx");

		prepareGAHMDocument(xlsfile, sdate, edate);

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				messageHelper.setTo(emailToGradeAndHours.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				// messageHelper.setSubject("ST Tissue Grade and Hours Machine reports
				// "+dateTimeFormat.format(new
				// Date()));

				// Code Starts From Here Done By Roshan Tailor Date :-
				// 06/26/2015 MM/DD/YYYY

				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				// System.out.println("Yesterday's date = "+ cal.getTime());

				messageHelper
						.setSubject(dateTimeFormat4.format(cal.getTime()) + "-STT-Grade and Hours Machine Reports");
				// Code Ends Here Done by\\BY Roshan Tailor

				messageHelper.setText(getMessage(), true);
				if (xlsfile.exists()) {
					messageHelper.addAttachment(
							dateTimeFormat4.format(cal.getTime()) + "-STT-Grade and Hours Machine reports.xlsx",
							new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue Grade and Hours machine reports mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append(
						"Please find the attached <b>\"ST Tissue Grade and Hours Machine reports\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append(
						"Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
								+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});

	}

	/**
	 * @param xlsfile
	 * @param edate
	 * @param sdate
	 * @throws ProductionException
	 * @throws IOException
	 * @throws Exception
	 */
	private void prepareGAHMDocument(File xlsfile, Date sdate, Date edate) throws ProductionException, Exception {

		/*
		 * Calendar calendar=Calendar.getInstance(); calendar.setTime(new Date());
		 * calendar.add(Calendar.DATE, -1);
		 * 
		 * Date edate=dateFormat.parse(dateFormat.format(calendar.getTime())); Date
		 * sdate=CommonUtil.getFirstDate(edate);
		 */
		List<Map<String, Object>> datas = machineProductionService.getGradeAndHourData(sdate, edate);

		FileOutputStream outputStream = new FileOutputStream(xlsfile);

		productionPM6ReportHandler.createExcelGradeAndHoursMachineReport(datas, outputStream);

		outputStream.close();

	}

	/**
	 * @throws IOException
	 * @throws ProductionException
	 * 
	 */
	public void sendMailMachineVsWrapper() throws IOException, ProductionException {
		String folder = System.getProperty("catalina.base") + "/MachineVsWrapper";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File xlsfile = new File(folder, "Machine Vs Wrapper" + ".xlsx");

		prepareMachineVsWrapperDocument(xlsfile);

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				messageHelper.setTo(emailToSttreportAndCR6.split(";"));
				// messageHelper.setTo("cr6@sttissuellc.com"); //Code Hard Code By Roshan Tailor
				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));

				Date shiftDate = CommonUtil.getShiftDate();

				Calendar sCal = Calendar.getInstance();
				sCal.setTime(shiftDate);
				sCal.set(Calendar.HOUR_OF_DAY, 0);
				sCal.set(Calendar.MINUTE, 0);
				sCal.set(Calendar.SECOND, 0);
				sCal.set(Calendar.MILLISECOND, 0);
				sCal.add(Calendar.DATE, -1);

				// messageHelper.setSubject("ST Tissue - Machine Vs Wrapper Reports
				// "+dateTimeFormat.format(new
				// Date()));

				// Code Starts From Here Done By Roshan Tailor Date :-
				// 06/26/2015 MM/DD/YYYY Night Shift
				messageHelper.setSubject(dateTimeFormat4.format(new Date()) + "-PM6-STT-Machine Vs Wrapper Reports");
				// Code Ends Here Done By Roshan Tailor Date :- 06/26/2015
				// MM/DD/YYYY

				messageHelper.setText(getMessage(), true);
				if (xlsfile.exists()) {
					messageHelper.addAttachment(
							dateTimeFormat4.format(sCal.getTime()) + "-STT-Machine Vs Wrapper Reports.xlsx",
							new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue Machine Vs Wrapper reports mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append(
						"Please find the attached <b>\"ST Tissue - Machine Vs Wrapper Report\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append(
						"Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
								+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});
	}

	/**
	 * @param xlsfile
	 * @throws IOException
	 * @throws ProductionException
	 */
	private void prepareMachineVsWrapperDocument(File xlsfile) throws IOException, ProductionException {
		Date shiftDate = CommonUtil.getShiftDate();

		// Date shiftDate=CommonUtil.checkDate("01-05-2015", dateFormat);
		Calendar sCal = Calendar.getInstance();
		sCal.setTime(shiftDate);
		sCal.set(Calendar.HOUR_OF_DAY, 0);
		sCal.set(Calendar.MINUTE, 0);
		sCal.set(Calendar.SECOND, 0);
		sCal.set(Calendar.MILLISECOND, 0);
		// sCal.add(Calendar.DATE, -1);
		sCal.add(Calendar.DATE, 0);

		Calendar eCal = Calendar.getInstance();
		eCal.setTime(shiftDate);
		eCal.set(Calendar.HOUR_OF_DAY, 0);
		eCal.set(Calendar.MINUTE, 0);
		eCal.set(Calendar.SECOND, 0);
		eCal.set(Calendar.MILLISECOND, 0);
		// eCal.add(Calendar.DATE, -2);
		eCal.add(Calendar.DATE, -1);

		// System.out.println(sCal.getTime());
		// System.out.println(eCal.getTime());

		FileOutputStream outputStream = new FileOutputStream(xlsfile);
		// Code Tested By Roshan Starts
		System.out.println("Starts Date:::" + sCal.getTime());
		System.out.println("Ends Date:::" + eCal.getTime());
		// Code Tested By Roshan Ends
		List<MachineAndWrapper> machineAndWrappers = machineProductionService.getMachineAndWrapper(eCal.getTime(),
				sCal.getTime());
		productionPM6ReportHandler.createMachineAndWrapperReport(machineAndWrappers, outputStream);
		outputStream.close();
	}

	/**
	 * @param edate
	 * @param sdate
	 * @throws Exception
	 * 
	 */
	public void sendGradeAndHoureWithSummaryMail(final Date sdate, final Date edate) throws Exception {
		String folder = System.getProperty("catalina.base") + "/Grade And Hours With Summary";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File xlsfile = new File(folder, "Grade and Houres With Summary" + ".xlsx");

		prepareGradeAndHourWithSummaryDocument(xlsfile, sdate, edate);

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				messageHelper.setTo(emailToGradeAndHours.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				// messageHelper.setSubject("ST Tissue Grade and Hours With Summary reports
				// "+dateTimeFormat.format(new
				// Date()));

				// Code Starts From Here Done By Roshan Tailor Date:- 06/26/2015
				// MM/DD/YYYY Night Shift
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				// System.out.println("Yesterday's date = "+ cal.getTime());

				messageHelper.setSubject(
						dateTimeFormat4.format(cal.getTime()) + "-STT-PM6-Grade and Hours With Summary Reports");
				// Code Ends Here Done By Roshan Tailor Date :- 06/26/2015
				// MM/DD/YYYY

				messageHelper.setText(getMessage(), true);
				if (xlsfile.exists()) {
					messageHelper.addAttachment(
							dateTimeFormat4.format(cal.getTime()) + "-STT-Grade and Hours With Summary reports.xlsx",
							new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue Grade and Hours With Summary reports mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append(
						"Please find the attached <b>\"ST Tissue Grade And Hours Report Of PM6\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append(
						"Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
								+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});

	}

	/**
	 * @param xlsfile
	 * @param edate
	 * @param sdate
	 * @throws Exception
	 */
	private void prepareGradeAndHourWithSummaryDocument(File xlsfile, Date sdate, Date edate) throws Exception {
		/*
		 * Calendar calendar=Calendar.getInstance(); calendar.setTime(new Date());
		 * calendar.add(Calendar.DATE, -1);
		 * 
		 * Date edate=dateFormat.parse(dateFormat.format(calendar.getTime())); Date
		 * sdate=CommonUtil.getFirstDate(edate);
		 */

		List<Map<String, Object>> datas = wrapperProductionService.getGradeAndHourData(sdate, edate);

		FileOutputStream outputStream = new FileOutputStream(xlsfile);

		productionPM6ReportHandler.createExcelGradeAndHoursWithSummaryReport(datas, outputStream);

		outputStream.close();
	}

	/**
	 * @param sdate
	 * @param edate
	 * @throws ProductionException
	 * @throws IOException
	 */
	public void getMailPM6ProducationReport(Date sdate, Date edate) throws IOException, ProductionException {
		String folder = System.getProperty("catalina.base") + "/PM6 PRODUCTION - REPORT";
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}

		final File xlsfile = new File(folder, "STT-PM6-Daily Production Report" + ".xls");

		preparePM6PRODUCTIONREPORTDocument(xlsfile, sdate, edate);

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
				messageHelper.setTo(emailTo.split(";"));
				messageHelper.setFrom(emailFrom, emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));

				messageHelper.setSubject(dateFormat.format(new Date()) + "-STT-PM6-Daily Production Report");

				messageHelper.setText(getMessage(), true);
				if (xlsfile.exists()) {
					messageHelper.addAttachment(dateFormat.format(new Date()) + "STT-PM6-Daily Production Report.xls",
							new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue PM6 PRODUCTION - REPORT mail is sent");
			}

			private String getMessage() {
				StringBuilder builder = new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append(
						"Please find the attached <b>\"ST Tissue PM6-Daily Production Report\"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append(
						"Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
								+ dateTimeFormat.format(new Date()) + " ***</p>");

				return builder.toString();
			}
		});

	}

	/**
	 * @param xlsfile
	 * @param sdate
	 * @param edate
	 * @throws IOException
	 * @throws ProductionException
	 */
	private void preparePM6PRODUCTIONREPORTDocument(File xlsfile, Date sdate, Date edate)
			throws IOException, ProductionException {

		List<Map<String, String>> datas = new ArrayList<>();

		datas = machineProductionService.formatDataForDailyReport(sdate, edate);

		FileOutputStream outputStream = new FileOutputStream(xlsfile);

		// productionPM6ReportHandler.createExcelPM6PRODUCTIONREPORT(datas,
		// outputStream);

		File file = new File(
				context.getRealPath("/") + "WEB-INF/excel template/productionWrapper/PM6 Production Report.xls");

		HSSFWorkbook workbook = productionPM6ReportHandler.createExcelPM6PRODUCTIONREPORT(datas, file, sdate, edate,
				outputStream);
		workbook.write(outputStream);

		// outputStream.close();
	}

}
