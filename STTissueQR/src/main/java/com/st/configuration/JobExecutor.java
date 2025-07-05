/**
 * 
 */
package com.st.configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.automailer.MainAutoMailer;
import com.st.emailutility.qrt.ProductionSummaryeport;

/**
 * kishor vaishnav
 */

@Component
public class JobExecutor {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

	private static final Logger logger = LoggerFactory.getLogger(JobExecutor.class);

//	@Autowired
//	private MainAutoMailer mainAutoMailer;

	public void testEmail() {
		logger.info("Executing test email job");
		// Implement test email logic here
	}

	public void testEmail(String recipientEmails) {
		logger.info("Executing test email job with recipients: {}", recipientEmails);
		// Implement test email logic here
	}

	public void sendTestMailSatSun(String recipientEmails) {
		logger.info("Executing Saturday/Sunday test mail job");
		//mainAutoMailer.sendTestMailSatSun(recipientEmails);
	}

	public void scheduledMailAt7_20am(String recipientEmails) {
		logger.info("Executing 7:20 AM mail job");
		//mainAutoMailer.scheduledMailAt7_20am(recipientEmails);
		
		// Also call the existing production summary method if needed
		String shiftText = "";
		Date date = CommonUtil.checkDate(CommonUtil.load(CommonUtil.MAIL_DATE), dateFormat);
		if (date == null) {
			date = CommonUtil.getShiftDate();
		}
		new ProductionSummaryeport().sendMorningProduction(shiftText, date, recipientEmails);
	}

	public void scheduledMailAt7_20pm(String recipientEmails) {
		logger.info("Executing 7:20 PM mail job");
	//	mainAutoMailer.scheduledMailAt7_20pm(recipientEmails);
		
		// Also call the existing production summary method if needed
		String shiftText = " Day Shift";
		Date date = CommonUtil.getShiftDate();
		CommonUtil.save(CommonUtil.MAIL_DATE, dateFormat.format(date));
		new ProductionSummaryeport().sendEveningProduction(shiftText, date, recipientEmails);
	}

	public void scheduledMailAt8am() {
		logger.info("Executing 8:00 AM mail job");
		// Implement 8 AM mail logic here
	}

	public void scheduledMailAt8am(String recipientEmails) {
		logger.info("Executing 8:00 AM mail job with recipients: {}", recipientEmails);
		// Implement 8 AM mail logic here
	}

	public void scheduledMailWeeklyMon() {
		logger.info("Executing weekly Monday mail job");
		// Implement weekly Monday mail logic here
	}

	public void scheduledMailWeeklyMon(String recipientEmails) {
		logger.info("Executing weekly Monday mail job with recipients: {}", recipientEmails);
		// Implement weekly Monday mail logic here
	}

	public void scheduledMailAt10_30am() {
		logger.info("Executing 10:30 AM mail job");
		// Implement 10:30 AM mail logic here
	}

	public void scheduledMailAt10_30am(String recipientEmails) {
		logger.info("Executing 10:30 AM mail job with recipients: {}", recipientEmails);
		// Implement 10:30 AM mail logic here
	}

	public void getDailyInventeryReportReelAt11_30am() {
		logger.info("Executing daily inventory report reel at 11:30 AM");
		// Implement daily inventory report logic here
	}

	public void getDailyInventeryReportReelAt11_30am(String recipientEmails) {
		logger.info("Executing daily inventory report reel at 11:30 AM with recipients: {}", recipientEmails);
		// Implement daily inventory report logic here
	}

	public void scheduledMailAt08_00am() {
		logger.info("Executing 08:00 AM mail job");
		// Implement 08:00 AM mail logic here
	}

	public void scheduledMailAt08_00am(String recipientEmails) {
		logger.info("Executing 08:00 AM mail job with recipients: {}", recipientEmails);
		// Implement 08:00 AM mail logic here
	}

	public void scheduledMailAt11am() {
		logger.info("Executing 11:00 AM mail job");
		// Implement 11 AM mail logic here
	}

	public void scheduledMailAt11am(String recipientEmails) {
		logger.info("Executing 11:00 AM mail job with recipients: {}", recipientEmails);
		// Implement 11 AM mail logic here
	}

	public void scheduledMailMonthly2nd() {
		logger.info("Executing monthly 2nd mail job");
		// Implement monthly 2nd mail logic here
	}

	public void scheduledMailMonthly2nd(String recipientEmails) {
		logger.info("Executing monthly 2nd mail job with recipients: {}", recipientEmails);
		// Implement monthly 2nd mail logic here
	}

	public void qualityTestMailPM() {
		logger.info("Executing quality test mail PM job");
		// Implement quality test mail PM logic here
	}

	public void qualityTestMailPM(String recipientEmails) {
		logger.info("Executing quality test mail PM job with recipients: {}", recipientEmails);
		// Implement quality test mail PM logic here
	}

	public void qualityTestMailAM() {
		logger.info("Executing quality test mail AM job");
		// Implement quality test mail AM logic here
	}

	public void qualityTestMailAM(String recipientEmails) {
		logger.info("Executing quality test mail AM job with recipients: {}", recipientEmails);
		// Implement quality test mail AM logic here
	}

	public void sendKpiTestMail() {
		logger.info("Executing KPI test mail job");
		// Implement KPI test mail logic here
	}

	public void sendKpiTestMail(String recipientEmails) {
		logger.info("Executing KPI test mail job with recipients: {}", recipientEmails);
		// Implement KPI test mail logic here
	}

	public void frpproductionopdataentryAM() {
		logger.info("Executing FRP production OP data entry AM job");
		// Implement FRP production data entry logic here
	}

	public void frpproductionopdataentryAM(String recipientEmails) {
		logger.info("Executing FRP production OP data entry AM job with recipients: {}", recipientEmails);
		// Implement FRP production data entry logic here
	}

	public void frpopdataentrydetailedreportAM() {
		logger.info("Executing FRP OP data entry detailed report AM job");
		// Implement FRP OP data entry detailed report logic here
	}

	public void frpopdataentrydetailedreportAM(String recipientEmails) {
		logger.info("Executing FRP OP data entry detailed report AM job with recipients: {}", recipientEmails);
		// Implement FRP OP data entry detailed report logic here
	}

	public void frpdailyopdataentrydetailedreportAM() {
		logger.info("Executing FRP daily OP data entry detailed report AM job");
		// Implement FRP daily OP data entry detailed report logic here
	}

	public void frpdailyopdataentrydetailedreportAM(String recipientEmails) {
		logger.info("Executing FRP daily OP data entry detailed report AM job with recipients: {}", recipientEmails);
		// Implement FRP daily OP data entry detailed report logic here
	}

	public void frpproductionopdataentrydetailedreportAM() {
		logger.info("Executing FRP production OP data entry detailed report AM job");
		// Implement FRP production OP data entry detailed report logic here
	}

	public void frpproductionopdataentrydetailedreportAM(String recipientEmails) {
		logger.info("Executing FRP production OP data entry detailed report AM job with recipients: {}", recipientEmails);
		// Implement FRP production OP data entry detailed report logic here
	}

	public void wetlapInventorySummaryReport() {
		logger.info("Executing wet lap inventory summary report job");
		// Implement wet lap inventory summary report logic here
	}

	public void wetlapInventorySummaryReport(String recipientEmails) {
		logger.info("Executing wet lap inventory summary report job with recipients: {}", recipientEmails);
		// Implement wet lap inventory summary report logic here
	}

	public void auditisdoneornot() {
		logger.info("Executing audit done or not job");
		// Implement audit done or not logic here
	}

	public void auditisdoneornot(String recipientEmails) {
		logger.info("Executing audit done or not job with recipients: {}", recipientEmails);
		// Implement audit done or not logic here
	}

	public void docforyoder() {
		logger.info("Executing doc for yoder job");
		// Implement doc for yoder logic here
	}

	public void docforyoder(String recipientEmails) {
		logger.info("Executing doc for yoder job with recipients: {}", recipientEmails);
		// Implement doc for yoder logic here
	}

	public void gradeandhoursummarymailinamonth() {
		logger.info("Executing grade and hour summary mail in a month job");
		// Implement grade and hour summary mail logic here
	}

	public void gradeandhoursummarymailinamonth(String recipientEmails) {
		logger.info("Executing grade and hour summary mail in a month job with recipients: {}", recipientEmails);
		// Implement grade and hour summary mail logic here
	}

	public void coaWeeklyEmailPM5() {
		logger.info("Executing COA weekly email PM5 job");
		// Implement COA weekly email PM5 logic here
	}

	public void coaWeeklyEmailPM5(String recipientEmails) {
		logger.info("Executing COA weekly email PM5 job with recipients: {}", recipientEmails);
		// Implement COA weekly email PM5 logic here
	}

	public void coaWeeklyEmailPM6() {
		logger.info("Executing COA weekly email PM6 job");
		// Implement COA weekly email PM6 logic here
	}

	public void coaWeeklyEmailPM6(String recipientEmails) {
		logger.info("Executing COA weekly email PM6 job with recipients: {}", recipientEmails);
		// Implement COA weekly email PM6 logic here
	}

	public void BlueLineLogstcsDespatchReport1() {
		logger.info("Executing Blue Line Logistics Despatch Report 1 job");
		// Implement Blue Line Logistics Despatch Report 1 logic here
	}

	public void BlueLineLogstcsDespatchReport1(String recipientEmails) {
		logger.info("Executing Blue Line Logistics Despatch Report 1 job with recipients: {}", recipientEmails);
		// Implement Blue Line Logistics Despatch Report 1 logic here
	}

	public void BlueLineLogstcsDespatchReport2() {
		logger.info("Executing Blue Line Logistics Despatch Report 2 job");
		// Implement Blue Line Logistics Despatch Report 2 logic here
	}

	public void BlueLineLogstcsDespatchReport2(String recipientEmails) {
		logger.info("Executing Blue Line Logistics Despatch Report 2 job with recipients: {}", recipientEmails);
		// Implement Blue Line Logistics Despatch Report 2 logic here
	}

	public void BlueLineLogstcsDespatchReport3() {
		logger.info("Executing Blue Line Logistics Despatch Report 3 job");
		// Implement Blue Line Logistics Despatch Report 3 logic here
	}

	public void BlueLineLogstcsDespatchReport3(String recipientEmails) {
		logger.info("Executing Blue Line Logistics Despatch Report 3 job with recipients: {}", recipientEmails);
		// Implement Blue Line Logistics Despatch Report 3 logic here
	}

	public void BlueLineLogstcsDespatchReport4() {
		logger.info("Executing Blue Line Logistics Despatch Report 4 job");
		// Implement Blue Line Logistics Despatch Report 4 logic here
	}

	public void BlueLineLogstcsDespatchReport4(String recipientEmails) {
		logger.info("Executing Blue Line Logistics Despatch Report 4 job with recipients: {}", recipientEmails);
		// Implement Blue Line Logistics Despatch Report 4 logic here
	}

	public void DespatchReportLA1() {
		logger.info("Executing Despatch Report LA1 job");
		// Implement Despatch Report LA1 logic here
	}

	public void DespatchReportLA1(String recipientEmails) {
		logger.info("Executing Despatch Report LA1 job with recipients: {}", recipientEmails);
		// Implement Despatch Report LA1 logic here
	}

	public void DespatchReportLA2() {
		logger.info("Executing Despatch Report LA2 job");
		// Implement Despatch Report LA2 logic here
	}

	public void DespatchReportLA2(String recipientEmails) {
		logger.info("Executing Despatch Report LA2 job with recipients: {}", recipientEmails);
		// Implement Despatch Report LA2 logic here
	}

	public void DespatchReportLA3() {
		logger.info("Executing Despatch Report LA3 job");
		// Implement Despatch Report LA3 logic here
	}

	public void DespatchReportLA3(String recipientEmails) {
		logger.info("Executing Despatch Report LA3 job with recipients: {}", recipientEmails);
		// Implement Despatch Report LA3 logic here
	}

	public void DespatchReportLA24() {
		logger.info("Executing Despatch Report LA24 job");
		// Implement Despatch Report LA24 logic here
	}

	public void DespatchReportLA24(String recipientEmails) {
		logger.info("Executing Despatch Report LA24 job with recipients: {}", recipientEmails);
		// Implement Despatch Report LA24 logic here
	}
}
