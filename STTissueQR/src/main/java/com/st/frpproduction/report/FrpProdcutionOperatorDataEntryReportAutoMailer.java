/**
 *Apr 4, 2016
 *FrpProdcutionOperatorDataEntryReportAutoMailer.java
 * TODO
 *com.st.frpproduction.report
 *FrpProdcutionOperatorDataEntryReportAutoMailer.java
 *Roshan La Tailor
 */
package com.st.frpproduction.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;
import com.st.frpproduction.service.FrpProdcutionOperatorDataEntryService;
import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.production.dao.WrapperProductionDao;
import com.st.production.model.WrapperProduction;
import com.st.productionpm5.dao.WrapperProductionDaoPM5;
import com.st.productionpm5.model.WrapperProductionPM5;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.service.WastePaperUnloadBaleInventoryService;

/**
 * @author roshan STT-PM5-Daily Production Report
 *
 */
@Component
public class FrpProdcutionOperatorDataEntryReportAutoMailer {

	@Autowired
	private WastePaperUnloadBaleInventoryService wastePaperUnloadBaleInventoryService;
	@Autowired
	private WrapperProductionDao wrapperProductionDao;
	@Autowired
	private WrapperProductionDaoPM5 wrapperProductionPM5Dao;
	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private FrpProdcutionOperatorDataEntryService frpprodcutionoperatordataentryservice;

	@Autowired
	private JavaMailSender mailSender;

	@Value("${mail.to.frpoperatorentry}")
	private String emailTofrpoperatorentry;

	@Value("${mail.bcc}")
	private String emailBcc;

	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;

	@Value("${mail.to.error}")
	private String emailToError;

	/**
	 * @param sDate
	 * @param eDate
	 */
	public void sendMailAt8am(final Date sDate, final Date eDate) {

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				try {

					List<FrpProdcutionOperatorDataEntry> details = null;
					List<FrpProdcutionOperatorDataEntry> mtdDetails = null;

					Calendar cal1 = Calendar.getInstance();
					cal1.setTime(sDate);
					cal1.add(Calendar.DATE, -1);
					Date yesterdayDate = cal1.getTime();
					Calendar ecal = Calendar.getInstance();
					ecal.setTime(new Date());
					ecal.set(Calendar.HOUR_OF_DAY, 6);
					ecal.set(Calendar.MINUTE, 59);
					ecal.set(Calendar.SECOND, 59);
					ecal.set(Calendar.MILLISECOND, 0);
					Date endDate = ecal.getTime();
					Date firstDate = CommonUtil.getFirstDate(yesterdayDate);
					System.out.println("Previous Date::" + dateFormat.format(yesterdayDate));
					double total6 = 0, whiteWeight6 = 0, redWeight6 = 0, total5 = 0, whiteWeight5 = 0, redWeight5 = 0,
							lineA = 0, lineB = 0, percentage = 0;
					List<WrapperProductionPM5> wrapperProductionspm5 = wrapperProductionPM5Dao
							.getWrapperProductions(firstDate, endDate);

					for (WrapperProductionPM5 wrapperProduction : wrapperProductionspm5) {
						whiteWeight5 += wrapperProduction.getWhiteWeight();
						redWeight5 += wrapperProduction.getRedWeight();
					}
					whiteWeight5 = whiteWeight5 / 2000;
					redWeight5 = redWeight5 / 2000;

					total5 = whiteWeight5 + redWeight5;
					List<WrapperProduction> wrapperProductions = wrapperProductionDao.getWrapperProductions(firstDate,
							endDate);
					for (WrapperProduction wrapperProduction : wrapperProductions) {
						whiteWeight6 += wrapperProduction.getWhiteWeight();
						redWeight6 += wrapperProduction.getRedWeight();
					}
					whiteWeight6 = whiteWeight6 / 2000;
					redWeight6 = redWeight6 / 2000;

					total6 = whiteWeight6 + redWeight6;
					mtdDetails = frpprodcutionoperatordataentryservice.getFrpProducationDataEntryReport(firstDate,
							endDate);
					for (FrpProdcutionOperatorDataEntry detail : mtdDetails) {
						lineA += (detail.getCol9forday() + detail.getCol9fornight());
						lineB += (detail.getCol9bforday() + detail.getCol9bfornight());
					}
					total5 = CommonUtil.round(total5, 2);
					total6 = CommonUtil.round(total6, 2);
					lineA = CommonUtil.round(lineA, 2);
					lineB = CommonUtil.round(lineB, 2);
					percentage = ((total5 + total6) / (lineA + lineB)) * 100;
					percentage = CommonUtil.round(percentage, 1);
					List<String> lines = wastePaperUnloadBaleInventoryService.getPulpLine(yesterdayDate, yesterdayDate);

					details = frpprodcutionoperatordataentryservice.getFrpProducationDataEntryReport(yesterdayDate,
							yesterdayDate);
					Map<String, List<WastePaperBaleInventory>> mapList = new HashMap<String, List<WastePaperBaleInventory>>();

					for (String line : lines) {
						mapList.put("consumedBalesDataDayLine" + line, wastePaperUnloadBaleInventoryService
								.getConsumedDayData(yesterdayDate, yesterdayDate, "day", line));
						mapList.put("consumedBalesDataNightLine" + line, wastePaperUnloadBaleInventoryService
								.getConsumedDayData(yesterdayDate, yesterdayDate, "night", line));
						mapList.put("mtdData" + line, wastePaperUnloadBaleInventoryService.getConsumedDayData(firstDate,
								yesterdayDate, line, "mtdLine" + line));
					}

					List<WastePaperBaleInventory> totalweight = wastePaperUnloadBaleInventoryService
							.getConsumedDayData(yesterdayDate, yesterdayDate, "day", "totalweight");
					List<WastePaperBaleInventory> consumedweight = wastePaperUnloadBaleInventoryService
							.getConsumedDayData(endDate, endDate, "night", "consumedweight");
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(emailTofrpoperatorentry.split(";"));
					messageHelper.setBcc(emailBcc.split(";"));
					messageHelper.setFrom(emailFrom, emailFromName);

					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, -1);

					messageHelper.setSubject(
							dateTimeFormat4.format(cal.getTime()) + "-STT-FRP Daily Production Summary Report");
					mimeMessage.setContent(getMessageBody(mtdDetails, details, mapList, lines, yesterdayDate,
							percentage, totalweight, consumedweight), "text/html");

				} catch (Exception e) {
					logger.error("Error message in Frp Producation Operator Data Entry Report..." + e.getMessage(), e);

					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(emailToError.split(";"));
					messageHelper.setFrom(emailFrom);
					messageHelper.setSubject("Fail to send production summary report.");
					mimeMessage.setContent("Unable to read production data<br>" + e.getMessage(), "text/html");
				}

				logger.info("Frp Producation Operator Data Entry Report Mail Sent....");
			}

		});
	}

	/**
	 * @param mtdDetails
	 * @param details
	 * @param mapList
	 * @param yesterdayDate
	 * @param percentage
	 * @param inventrydayBales
	 * @param inventrynightBales
	 * @return
	 */
	public String getMessageBody(List<FrpProdcutionOperatorDataEntry> mtdDetails,
			List<FrpProdcutionOperatorDataEntry> details, Map<String, List<WastePaperBaleInventory>> mapList,
			List<String> lines, Date yesterdayDate, double percentage, List<WastePaperBaleInventory> totalweight,
			List<WastePaperBaleInventory> consumedweight) {		
			StringBuilder builder = new StringBuilder();
			
			double occTotalWeight = 0;
			double occGroceryTotalWeight = 0;
			double dlkTotalWeight = 0;
			double oldnewsTotalWeight = 0;
			double newsTotalWeight = 0;
			double mailTotalWeight = 0;
			double mixedTotalWeight = 0;
			double brownbrokeTotalWeight = 0;
			double occConsumeWeight = 0;
			double occGroceryConsumeWeight = 0;
			double dlkConsumeWeight = 0;
			double oldnewsConsumeWeight = 0;
			double newsConsumeWeight = 0;
			double mailConsumeWeight = 0;
			double mixedConsumeWeight = 0;
			double brownbrokeConsumeWeight = 0;
			double virginHardWoodTotalweight = 0;
			double virginSoftWoodTtotalweight = 0;
			double hardWhiteTotalweight = 0;
			double virginequalypuHWTotalweight = 0;
			double virginHardWoodTotalConsumed = 0;
			double virginSoftWoodTotalConsumed = 0;
			double hardWhiteTotalConsumed = 0;
			double virginequalypuHWTotalConsumed = 0;
			double totalWeight= 0;
			double totalConsumed = 0;
			double lineBdaytotal = 0;
			double lineBnighttotal = 0;
			double wastePaperFedTotalDay=0;
			double wastePaperFedTotalNight=0;
			double wastePaperFedTotalMtd=0;
			double dryLapWhiteTotalweight=0;
			double dryLapWhiteTotalConsumed=0;
			
			for (WastePaperBaleInventory wastePaperBaleInventory : totalweight) {
				occTotalWeight = wastePaperBaleInventory.getTotalbalesweightForOCC();
				dlkTotalWeight = wastePaperBaleInventory.getTotalbalesweightForDLK();
				mailTotalWeight = wastePaperBaleInventory.getTotalbalesweightForMailUndeliverable();
				newsTotalWeight = wastePaperBaleInventory.getTotalbalesweightForOINews();
				oldnewsTotalWeight = wastePaperBaleInventory.getTotalbalesweightForONPOldNewsPrint();
				brownbrokeTotalWeight = wastePaperBaleInventory.getTotalbalesweightForBrownNapkinBroke();
				mixedTotalWeight = wastePaperBaleInventory.getTotalbalesweightForMixedPaper();
				occGroceryTotalWeight = wastePaperBaleInventory.getTotalbalesOfHW();
				virginHardWoodTotalweight = wastePaperBaleInventory.getTotalbalesweightForVirginHardWood();
				virginSoftWoodTtotalweight = wastePaperBaleInventory.getTotalbalesweightForVirginSoftWood();
				hardWhiteTotalweight = wastePaperBaleInventory.getTotalbalesweightForHardWhite();
				virginequalypuHWTotalweight = wastePaperBaleInventory.getTotalbalesweightForVirginequalypuHW();
				dryLapWhiteTotalweight= wastePaperBaleInventory.getTotalbalesweightForPulpDryLap();
				totalWeight=wastePaperBaleInventory.getTotalbalesweight();
			}
			for (WastePaperBaleInventory wastePaperBaleInventory : consumedweight) {
				occConsumeWeight = wastePaperBaleInventory.getTotalbalesweightForOCC();
				dlkConsumeWeight = wastePaperBaleInventory.getTotalbalesweightForDLK();
				mailConsumeWeight = wastePaperBaleInventory.getTotalbalesweightForMailUndeliverable();
				newsConsumeWeight = wastePaperBaleInventory.getTotalbalesweightForOINews();
				oldnewsConsumeWeight = wastePaperBaleInventory.getTotalbalesweightForONPOldNewsPrint();
				brownbrokeConsumeWeight = wastePaperBaleInventory.getTotalbalesweightForBrownNapkinBroke();
				mixedConsumeWeight = wastePaperBaleInventory.getTotalbalesweightForMixedPaper();
				occGroceryConsumeWeight = wastePaperBaleInventory.getTotalbalesOfHW();
				virginHardWoodTotalConsumed = wastePaperBaleInventory.getTotalbalesweightForVirginHardWood();
				virginSoftWoodTotalConsumed = wastePaperBaleInventory.getTotalbalesweightForVirginSoftWood();
				hardWhiteTotalConsumed = wastePaperBaleInventory.getTotalbalesweightForHardWhite();
				virginequalypuHWTotalConsumed = wastePaperBaleInventory.getTotalbalesweightForVirginequalypuHW();
				dryLapWhiteTotalConsumed= wastePaperBaleInventory.getTotalbalesweightForPulpDryLap();
				totalConsumed=wastePaperBaleInventory.getTotalbalesweight();				
			}
			double mtdTubeLineA = 0;
			double mtdWetlabLineA = 0;
			double mtdDcsLineA = 0;
			double mtdTubeLineB = 0;
			double mtdWetlabLineB = 0;
			double mtdDcsLineB = 0;
			double mtdMillWater = 0;
			double mtdSeverflow = 0;
			double LineA = 0, LineB = 0, mtdLineA = 0, mtdLineB = 0;
			for (FrpProdcutionOperatorDataEntry data : mtdDetails) {
				mtdTubeLineA += data.getTotalcol6();
				mtdWetlabLineA += data.getTotalcol7();
				mtdDcsLineA += data.getTotalcol9();
				mtdTubeLineB += data.getTotalcol6b();
				mtdWetlabLineB += data.getTotalcol7b();
				mtdDcsLineB += data.getTotalcol9b();
				mtdMillWater += data.getTotalcol3();
				mtdSeverflow += data.getTotalcol12();
				mtdLineA += (data.getTotalcol6() + data.getTotalcol7());
				mtdLineB += (data.getTotalcol6b() + data.getTotalcol7b());

			}
			for (FrpProdcutionOperatorDataEntry data : details) {
				LineA += (data.getTotalcol6() + data.getTotalcol7());
				LineB += (data.getTotalcol6b() + data.getTotalcol7b());

			}
		
			builder.append("Hello Sir," + "<br/><br/>Please Find The Below ST Tissue FRP Daily Producation Summary Report  "
					+ dateFormat.format(yesterdayDate) + " For Your Review.<br/><br/>");
			
			if (details.size() > 0) {
				builder.append(
						"<table border='1' style='background-color:white;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:35%' cellpadding='2' cellspacing='3'>"
								+ "<tbody>"
								+ "<tr>" 
								+ "<td style='width:50px;text-align:right;'></td>"
								+ "<td style='width: 70px;'><b>UOM</b></td>"
								+ "<td style='width: 80px;text-align:right;'><b>Day Shift</b></td>"
								+ "<td style='width: 80px;text-align:right;'><b>Night Shift</b></td>"
								+ "<td style='width:50px;text-align:right;'><b>Daily Total / Average</b></td>"
								+ "<td style='width:50px;text-align:right;'><b>MTD</b></td>" 
								+ "</tr>");
				for (FrpProdcutionOperatorDataEntry data : details) {
					builder.append(
								"<tr>"
									+ "<td style='width:50px;text-align:right;background-color: yellow;'><b> A-Line </b></td>"
									+ "<td style='width:70px;'></td>" + "<td style='width: 80px;text-align:right;'></td>"
									+ "<td style='width: 80px;text-align:right;'></td>"
									+ "<td style='width: 80px;text-align:right;'></td>"
									+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>"

									+ "<tr style='align=right;'>" 
									+ "<td><b> BATCHES FED</b></td>"
									+ "<td style='width: 70px;'><b>NOS</b></td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol10forday()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol10fornight()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getTotalcol10()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'></td>" 
									+ "</tr>" 
									+ "<tr>"
									+ "<td><b>PRODUCTION - TUBE</b></td>" 
									+ "<td style='width: 70px;'><b>AD TONS</b></td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol6forday()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol6fornight()) + "</td>"
									+ "<td style='width: 80px;text-align:right;''>"
									+ Math.round(data.getTotalcol6()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>" 
									+ Math.round(mtdTubeLineA)
									+ "</td>" + "</tr>"

									+ "<tr>" + "<td><b>PRODUCTION - WETLAP</b></td>"
									+ "<td style='width: 70px;'><b>AD TONS</b></td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol7forday()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol7fornight()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getTotalcol7()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(mtdWetlabLineA)
									+ "</td>" + "</tr>"

									+ "<tr>" + "<td><b>HD LEVEL AS OF 7AM/7PM</b></b></td>"
									+ "<td style='width"
									+ ": 70px;'><b>%</b></td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol11forday()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol11fornight()) + "</td>"
									+ "<td style='width: 80px;text-align:right;''></td>"
									+ "<td style='width: 80px;text-align:right;'></td>" 
									+ "</tr>"

									+ "<tr>" + "<td>WASTE PAPER FED - DCS</td>"
									+ "<td style='width: 70px;'><b>AD TONS</b></td>"
									+ "<td style='width:50px;text-align:right;'> "
									+ Math.round(data.getCol9forday()) + "</td>"
									+ "<td style='width:50px;text-align:right;''>"
									+ Math.round(data.getCol9fornight()) + "</td>"
									+ "<td style='width:50px;text-align:right;''>"
									+ Math.round(data.getTotalcol9()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(mtdDcsLineA)
									+ "</td>" + "</tr>"
									+ "<tr>"
									+ "<td style='width:50px;text-align:right;background-color: yellow;'><b>B-Line </b></td>"
									+ "<td style='width: 70px;'></td>" + "<td style='width: 80px;text-align:right;'></td>"
									+ "<td style='width: 80px;text-align:right;'></td>"
									+ "<td style='width: 80px;text-align:right;'></td>"
									+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>"

									+ "<tr>" + "<td><b> BATCHES FED</b></td>" 
									+ "<td style='width: 70px;'><b>NOS</b></td>"
									+ "<td style='width: 80px;text-align:right;'>" 
									+ Math.round(data.getCol10bforday())
									+ "</td>" + "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol10bfornight()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>" 
									+ Math.round(data.getTotalcol10b())
									+ "</td>" + "<td style='width: 80px;text-align:right;'></td>" 
									+ "</tr>"

									+ "<tr>" + "<td><b>PRODUCTION -  PCC TANK </b></td>"
									+ "<td style='width: 70px;'><b>AD TONS</b></td>"

									+ "<td style='width: 80px;text-align:right;'>" 
									+ Math.round(data.getCol6bforday())
									+ "</td>" + "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol6bfornight()) + "</td>"
									+ "<td style='width: 80px;text-align:right;''>" 
									+ Math.round(data.getTotalcol6b())
									+ "</td>" + "<td style='width: 80px;text-align:right;'>" 
									+ Math.round(mtdTubeLineB)
									+ "</td>" + "</tr>"

									+ "<tr>" + "<td><b>PRODUCED B - A</b></td>" + "<td style='width: 70px;'><b>AD TONS</b></td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol7bforday())
									+ "</td>" + "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol7bfornight()) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>" 
									+ Math.round(data.getTotalcol7b())
									+ "</td>" + "<td style='width: 80px;text-align:right;'>" 
									+ Math.round(mtdWetlabLineB)
									+ "</td>" + "</tr>"

									+ "<tr>" + "<td><b>PCC LEVEL AS OF 7AM/7PM</b></td>" + "<td style='width: 70px;'><b>%</b></td>"
									+ "<td style='width: 80px;text-align:right;'>" 
									+ Math.round(data.getCol11bforday())
									+ "</td>" + "<td style='width: 80px;text-align:right;'>"
									+ Math.round(data.getCol11bfornight()) + "</td>"
									+ "<td style='width: 80px;text-align:right;''></td>" 
									+ "<td style='width: 80px;text-align:right;'></td>" 
									+ "</tr>"

									+ "<tr>" 
									+ "<td>WASTE PAPER FED - DCS</td>" 
									+ "<td style='width: 70px;'><b>AD TONS</b></td>"
									+ "<td style='width: 80px;text-align:right;'> " 
									+ Math.round(data.getCol9bforday())
									+ "</td>" + "<td style='width: 80px;text-align:right;''>"
									+ Math.round(data.getCol9bfornight()) + "</td>"
									+ "<td style='width: 80px;text-align:right;''>" 
									+ Math.round(data.getTotalcol9b())
									+ "</td>" + "<td style='width: 80px;text-align:right;'>" 
									+ Math.round(mtdDcsLineB)
									+ "</td>" 
									+ "</tr>"					
									
									+"<tr>"
									+ "<td style='width: 50px;'>WATER TO FIRE/<br>MILL WATER TANK<br>430-FT-6956<br># 1008</td>"
									+ "<td style='width: 50px;text-align:right;'><b>gal</b></td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ CommonUtil.round(data.getCol3forday() / 1000000, 2) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ CommonUtil.round(data.getCol3fornight() / 1000000, 2) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ CommonUtil.round(data.getTotalcol3() / 1000000, 2) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>" + CommonUtil.round(mtdMillWater / 1000000, 2)+ "</td>" 
									+ "</tr>" 
									+ "<tr>" 
									+ "<td style='width: 50px;'>SEWER FLOW - 430-FT-7020</td>"
									+ "<td style='width: 70px;'><b>gal</b></td>" + "<td style='width: 80px;text-align:right;'>"
									+ CommonUtil.round(data.getCol12forday() / 1000000, 2) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>"
									+ CommonUtil.round(data.getCol12fornight() / 1000000, 2) + "</td>"
									+ "<td style='width: 80px;text-align:right;''>"
									+ CommonUtil.round(data.getTotalcol12() / 1000000, 2) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>" + CommonUtil.round(mtdSeverflow / 1000000, 2)+ "</td>" 
									+ "</tr>"
									+ "<tr>"
									+ "<td style='width:50px;'><b>Total Production </b></td>"
									+ "<td style='width: 70px;'><b>AD TONS</b></td>"
									+ "<td style='width: 80px;'><b>line A + B </b></td>"
									+ "<td style='width: 80px;text-align:right;'></td>"
									+ "<td style='width: 80px;text-align:right;'>" + CommonUtil.round(LineA + LineB,2) + "</td>"
									+ "<td style='width: 80px;text-align:right;'>" + CommonUtil.round(mtdLineA + mtdLineB,2) + "</td>"
									+ "</tr>"
									+ "<tr>" 
									+ "<td>WASTE PAPER FED - DCS</td>" 
									+ "<td style='width: 70px;'><b>AD TONS</b> Line A + Line B</td>"
									+ "<td style='width: 80px;text-align:right;'> " 
									+ Math.round(data.getCol9forday()+data.getCol9bforday())
									+ "</td>" + "<td style='width: 80px;text-align:right;''>"
									+ Math.round(data.getCol9fornight()+data.getCol9bfornight()) + "</td>"
									+ "<td style='width: 80px;text-align:right;''>" 
									+ Math.round(data.getTotalcol9()+data.getTotalcol9b())
									+ "</td>" 
									+ "<td style='width: 80px;text-align:right;'>" 
									+ Math.round(mtdDcsLineA+mtdDcsLineB)
									+ "</td>" 
									+ "</tr>"
								);
				}
			
			String line="";
			for (String  pulper : lines) {
				List<List<WastePaperBaleInventory>> wbi= new ArrayList<>();
				int count=0;
				double totalday = 0;
				double occWightday = 0;
				double dlkwieghtday = 0;
				double mailwieghtday = 0;
				double newswieghtday = 0;
				double oldnewswieghtday = 0;
				double mailUndeliveredday=0;
				double brownwieghtday = 0;
				double sowwieghtday = 0;
				double mixedwieghtday = 0;
				double occGroceryday = 0;
				double boxboardclippingsday = 0;
				double swlday= 0;
				double brownWetlapday= 0;
				double dryLapWhiteday= 0;
				double dryLapBrownday= 0;
				double brownBrokeday= 0;
				double whiteBrokeday= 0;
				
				double totalnight = 0;
				double occWightnight = 0;
				double dlkwieghtnight = 0;
				double mailwieghtnight = 0;
				double newswieghtnight = 0;
				double oldnewswieghtnight = 0;
				double mailUndeliverednight=0;
				double brownwieghtnight = 0;
				double sowwieghtnight = 0;
				double mixedwieghtnight = 0;
				double occGrocerynight = 0;
				double boxboardclippingsnight = 0;
				double swlnight= 0;
				double brownWetlapnight= 0;
				double dryLapWhitenight= 0;
				double dryLapBrownnight= 0;
				double brownBrokenight= 0;
				double whiteBrokenight= 0;
				double mtdtotal=0;
				double totalOfDay= 0.0;
				double totalOfNight= 0.0;
				for (Map.Entry<String, List<WastePaperBaleInventory>> entry : mapList.entrySet()) {
					if(entry.getKey().contains(pulper)&&entry.getKey().contains("Day")&&!entry.getKey().contains("mtd")&&!entry.getKey().contains("Night")) {
						count++;
						for (WastePaperBaleInventory wastePaperBaleInventory : entry.getValue()) {						
						 totalday = wastePaperBaleInventory.getTotalbalesweight();
						 occWightday = wastePaperBaleInventory.getTotalbalesweightForOCC();
						 dlkwieghtday = wastePaperBaleInventory.getTotalbalesweightForDLK();
						 mailwieghtday = wastePaperBaleInventory.getTotalbalesweightForMailUndeliverable();
						 newswieghtday = wastePaperBaleInventory.getTotalbalesweightForOINews();
						 oldnewswieghtday = wastePaperBaleInventory.getTotalbalesweightForONPOldNewsPrint();
						 mailUndeliveredday = wastePaperBaleInventory.getTotalbalesweightForMailUndeliverable();
						 brownwieghtday = wastePaperBaleInventory.getTotalbalesweightForBrownNapkinBroke();
						 sowwieghtday = wastePaperBaleInventory.getTotalbalesweightForSOW();
						 mixedwieghtday = wastePaperBaleInventory.getTotalbalesweightForMixedPaper();
						 occGroceryday = wastePaperBaleInventory.getTotalbalesOfHW();
						 boxboardclippingsday = wastePaperBaleInventory.getTotalbalesOfBoxboardClippings();
						 swlday= wastePaperBaleInventory.getTotalbalesweightForSWL();
						 brownWetlapday= wastePaperBaleInventory.getTotalbalesweightForBrownWetLap();
						 dryLapWhiteday= wastePaperBaleInventory.getTotalbalesweightForPulpDryLap();						 
						 brownBrokeday= wastePaperBaleInventory.getTotalbalesweightForBrownNapkinBroke();
						 whiteBrokeday= wastePaperBaleInventory.getTotalbalesweightForWhiteBroke();
						}
					}
					
					if(entry.getKey().contains(pulper)&&entry.getKey().contains("Night")&&!entry.getKey().contains("mtd")&&!entry.getKey().contains("Day")) {
						count++;
						for (WastePaperBaleInventory wastePaperBaleInventory : entry.getValue()) {							
						 totalnight = wastePaperBaleInventory.getTotalbalesweight();
						 occWightnight = wastePaperBaleInventory.getTotalbalesweightForOCC();
						 dlkwieghtnight = wastePaperBaleInventory.getTotalbalesweightForDLK();
						 mailwieghtnight = wastePaperBaleInventory.getTotalbalesweightForMailUndeliverable();
						 newswieghtnight = wastePaperBaleInventory.getTotalbalesweightForOINews();
						 oldnewswieghtnight = wastePaperBaleInventory.getTotalbalesweightForONPOldNewsPrint();
						 mailUndeliverednight = wastePaperBaleInventory.getTotalbalesweightForMailUndeliverable();
						 brownwieghtnight = wastePaperBaleInventory.getTotalbalesweightForBrownNapkinBroke();
						 sowwieghtnight = wastePaperBaleInventory.getTotalbalesweightForSOW();
						 mixedwieghtnight = wastePaperBaleInventory.getTotalbalesweightForMixedPaper();
						 occGrocerynight = wastePaperBaleInventory.getTotalbalesOfHW();
						 boxboardclippingsnight = wastePaperBaleInventory.getTotalbalesOfBoxboardClippings();
						 swlnight= wastePaperBaleInventory.getTotalbalesweightForSWL();
						 brownWetlapnight= wastePaperBaleInventory.getTotalbalesweightForBrownWetLap();
						 dryLapWhitenight= wastePaperBaleInventory.getTotalbalesweightForPulpDryLap();						 
						 brownBrokenight= wastePaperBaleInventory.getTotalbalesweightForBrownNapkinBroke();
						 whiteBrokenight= wastePaperBaleInventory.getTotalbalesweightForWhiteBroke();
						}
					}
					
					if(entry.getKey().contains(pulper)&&!entry.getKey().contains("Night")&&!entry.getKey().contains("Day")&&entry.getKey().contains("mtd")) {
						
						count++;
						for (WastePaperBaleInventory wastePaperBaleInventory : entry.getValue()) {
							mtdtotal += wastePaperBaleInventory.getTotalbalesweight();
						}
						 
					}
					
					double totalBaleWight = totalday + totalnight;
					if(count==3)
					{
						count++;
						builder.append("<tr>"
							+ "<td style='width:50px;text-align:right;background-color: yellow;'><b> "+pulper+"</b></td>"
							+ "<td style='width:70px;'></td>" 
							+ "<td style='width: 80px;text-align:right;'></td>"
							+ "<td style='width: 80px;text-align:right;'></td>"
							+ "<td style='width: 80px;text-align:right;'></td>"
							+ "<td style='width: 80px;text-align:right;'></td>" 
							+ "</tr>");					
							if(occWightday>0.0||occWightnight>0.0)
							{
								builder.append( "<tr>" 
								+ "<td style='width:50px;'><b>OCC</b></td>"
								+ "<td style='width: 70px;'><b>%</b></td>"
								+ "<td style='width: 80px;text-align:right;'>"								
								+ Math.round(occWightday/totalday*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round(occWightnight/totalnight*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round((occWightday+occWightnight)/totalBaleWight*100)
								+ "</td>" 
								+ "<td style='width: 80px;text-align:right;'></td>" 
								+ "</tr>");

								totalOfDay+=occWightday;
								totalOfNight+=occWightnight;
							}
							if(dlkwieghtday>0.0||dlkwieghtnight>0.0)
							{
								builder.append("<tr>" 
								+ "<td style='width:50px;'><b>DLK</b></td>"
								+ "<td style='width: 70px;'><b>%</b></td>"
								+ "<td style='width: 80px;text-align:right;'>"								
								+ Math.round(dlkwieghtday/totalday*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round(dlkwieghtnight/totalnight*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round((dlkwieghtday+dlkwieghtnight)/totalBaleWight*100)
								+ "</td>" 
								+ "<td style='width: 80px;text-align:right;'></td>" 
								+ "</tr>");
								totalOfDay+=dlkwieghtday;
								totalOfNight+=dlkwieghtnight;
							}
//							if(mailwieghtday>0.0||mailwieghtnight>0.0)
//							{
//								builder.append("<tr>" 
//								+ "<td style='width:50px;'><b>Mail Wieght</b></td>"
//								+ "<td style='width: 70px;'><b>%</b></td>"
//								+ "<td style='width: 80px;text-align:right;'>"								
//								+ Math.round(mailwieghtday/totalday*100) + "</td>"
//								+ "<td style='width: 80px;text-align:right;'>"
//								+ Math.round(mailwieghtnight/totalnight*100) + "</td>"
//								+ "<td style='width: 80px;text-align:right;'>"
//								+ Math.round((mailwieghtday+mailwieghtnight)/totalBaleWight*100)
//								+ "</td>" 
//								+ "<td style='width: 80px;text-align:right;'></td>" 
//								+ "</tr>");
//								totalOfDay+=mailwieghtday;
//								totalOfNight+=mailwieghtnight;
//							}
							if(newswieghtday>0.0||newswieghtnight>0.0)
							{
								builder.append( "<tr>" + "<td style='width:50px;'><b>SCN News </b></td>" +
								  "<td style='width: 70px;'><b>%</b></td>" +
								  "<td style='width: 80px;text-align:right;'>" +
								  Math.round(newswieghtday/totalday*100) + "</td>" +
								  "<td style='width: 80px;text-align:right;'>" +
								  Math.round(newswieghtnight/totalnight*100) + "</td>" +
								  "<td style='width: 80px;text-align:right;'>" +
								  Math.round((newswieghtday+newswieghtnight)/totalBaleWight*100) + "</td>" +
								  "<td style='width: 80px;text-align:right;'></td>" 
								  + "</tr>");
								totalOfDay+=newswieghtday;
								totalOfNight+=newswieghtnight;
							}
							if(oldnewswieghtday>0.0||oldnewswieghtnight>0.0)
							{
								builder.append( "<tr>" 
								+ "<td style='width:50px;'><b>Old News Wieght</b></td>"
								+ "<td style='width: 70px;'><b>%</b></td>"
								+ "<td style='width: 80px;text-align:right;'>"								
								+ Math.round(oldnewswieghtday/totalday*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round(oldnewswieghtnight/totalnight*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round((oldnewswieghtday+oldnewswieghtnight)/totalBaleWight*100)
								+ "</td>" 
								+ "<td style='width: 80px;text-align:right;'></td>" 
								+ "</tr>");
								totalOfDay+=oldnewswieghtday;
								totalOfNight+=oldnewswieghtnight;
							}
//							if(brownwieghtday>0.0||brownwieghtnight>0.0)
//							{
//								builder.append( "<tr>" + "<td style='width:50px;'><b>Brown Wieght</b></td>" +
//								  "<td style='width: 70px;'><b>%</b></td>" +
//								  "<td style='width: 80px;text-align:right;'>" +
//								  Math.round(brownwieghtday/totalday*100) + "</td>" +
//								  "<td style='width: 80px;text-align:right;'>" +
//								  Math.round(brownwieghtnight/totalnight*100) + "</td>" +
//								  "<td style='width: 80px;text-align:right;'>" +
//								  Math.round((brownwieghtday+brownwieghtnight)/totalBaleWight*100) + "</td>" +
//								  "<td style='width: 80px;text-align:right;'></td>" 
//								  + "</tr>");
//								totalOfDay+=brownwieghtday;
//								totalOfNight+=brownwieghtnight;
//							} 
							if(sowwieghtday>0.0||sowwieghtnight>0.0)
							{
								builder.append( "<tr>" 
								+ "<td style='width:50px;'><b>SOW</b></td>"
								+ "<td style='width: 70px;'><b>%</b></td>"
								+ "<td style='width: 80px;text-align:right;'>"								
								+ Math.round(sowwieghtday/totalday*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round(sowwieghtnight/totalnight*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round((sowwieghtday+sowwieghtnight)/totalBaleWight*100)
								+ "</td>" 
								+ "<td style='width: 80px;text-align:right;'></td>" 
								+ "</tr>");
								totalOfDay+=sowwieghtday;
								totalOfNight+=sowwieghtnight;
							}
							if(mailUndeliveredday>0.0||mailUndeliverednight>0.0)
							{
								builder.append( "<tr>" 
								+ "<td style='width:50px;'><b>Mail-Undeliverable</b></td>"
								+ "<td style='width: 70px;'><b>%</b></td>"
								+ "<td style='width: 80px;text-align:right;'>"								
								+ Math.round(mailUndeliveredday/totalday*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round(mailUndeliverednight/totalnight*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round((mailUndeliveredday+mailUndeliverednight)/totalBaleWight*100)
								+ "</td>" 
								+ "<td style='width: 80px;text-align:right;'></td>" 
								+ "</tr>");
								totalOfDay+=mailUndeliveredday;
								totalOfNight+=mailUndeliverednight;
							}
							if(mixedwieghtday>0.0||mixedwieghtnight>0.0)
							{
								builder.append( "<tr>" 
							+ "<td style='width:50px;'><b>Mixed Paper</b></td>"
							+"<td style='width: 70px;'><b>%</b></td>" 
							+"<td style='width: 80px;text-align:right;'>" +
								Math.round(mixedwieghtday/totalday*100) + "</td>" +
								"<td style='width: 80px;text-align:right;'>" +
								Math.round(mixedwieghtnight/totalnight*100) + "</td>" +
								"<td style='width: 80px;text-align:right;'>" +
								Math.round((mixedwieghtday+mixedwieghtnight)/totalBaleWight*100) + "</td>" +
								"<td style='width: 80px;text-align:right;'></td>" 
								+ "</tr>" );
								totalOfDay+=mixedwieghtday;
								totalOfNight+=mixedwieghtnight;
							}
//							if(occGroceryday>0.0||occGrocerynight>0.0)
//							{
//								builder.append( "<tr>" +
//								"<td style='width:50px;'><b>OCC Grocery</b></td>" +
//								"<td style='width: 70px;'><b>%</b></td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(occGroceryday/totalday*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(occGrocerynight/totalnight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round((occGroceryday+occGrocerynight)/totalBaleWight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'></td>" 
//								+ "</tr>" );
//								totalOfDay+=occGroceryday;
//								totalOfNight+=occGrocerynight;
//							}
//							if(boxboardclippingsday>0.0||boxboardclippingsnight>0.0)
//							{
//								builder.append( "<tr>" +
//								"<td style='width:50px;'><b>BoxboardClippings</b></td>" +
//								"<td style='width: 70px;'><b>%</b></td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(boxboardclippingsday/totalday*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(boxboardclippingsnight/totalnight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round((boxboardclippingsday+boxboardclippingsnight)/totalBaleWight*100)
//								+ "</td>" + "<td style='width: 80px;text-align:right;'></td>" 
//								+ "</tr>");
//								totalOfDay+=boxboardclippingsday;
//								totalOfNight+=boxboardclippingsnight;
//							}
//							if(swlday>0.0||swlnight>0.0)
//							{
//								builder.append("<tr>" + "<td style='width:50px;'><b>SWL</b></td>" +
//								"<td style='width: 70px;'><b>%</b></td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(swlday/totalday*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(swlnight/totalnight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round((swlday+swlnight)/totalBaleWight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'></td>" 
//								+ "</tr>" );
//								totalOfDay+=swlday;
//								totalOfNight+=swlnight;
//							}
//							if(whiteBrokeday>0.0||whiteBrokenight>0.0)
//							{
//								builder.append("<tr>" +
//								"<td style='width:50px;'><b>White Broke</b></td>" +
//								"<td style='width: 70px;'><b>%</b></td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(whiteBrokeday/totalday*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(whiteBrokenight/totalnight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round((whiteBrokeday+whiteBrokenight)/totalBaleWight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'></td>" 
//								+ "</tr>" );
//								totalOfDay+=whiteBrokeday;
//								totalOfNight+=whiteBrokenight;
//							}
//							if(brownWetlapday>0.0||brownWetlapnight>0.0)
//							{
//								builder.append( "<tr>" +
//								"<td style='width:50px;'><b>Brown Wetlap</b></td>" +
//								"<td style='width: 70px;'><b>%</b></td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(brownWetlapday/totalday*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(brownWetlapnight/totalnight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round((brownWetlapday+brownWetlapnight)/totalBaleWight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'></td>" 
//								+ "</tr>");
//								totalOfDay+=brownWetlapday;
//								totalOfNight+=brownWetlapnight;
//							}
//							if(dryLapWhiteday>0.0||dryLapWhitenight>0.0)
//							{
//								builder.append( "<tr>" +
//								"<td style='width:50px;'><b>DryLap White</b></td>" +
//								"<td style='width: 70px;'><b>%</b></td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(dryLapWhiteday/totalday*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(dryLapWhitenight/totalnight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round((dryLapWhiteday+dryLapWhitenight)/totalBaleWight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'></td>" 
//								+ "</tr>");
//								totalOfDay+=dryLapWhiteday;
//								totalOfNight+=dryLapWhitenight;
//							}
//							if(brownBrokeday>0.0||brownBrokenight>0.0)
//							{
//								builder.append( "<tr>" +
//								"<td style='width:50px;'><b>Brown Broke</b></td>" +
//								"<td style='width: 70px;'><b>%</b></td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(brownBrokeday/totalday*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round(brownBrokenight/totalnight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'>" +
//								Math.round((brownBrokeday+brownBrokenight)/totalBaleWight*100) + "</td>" +
//								"<td style='width: 80px;text-align:right;'></td>" + "</tr>");
//								totalOfDay+=brownBrokeday;
//								totalOfNight+=brownBrokenight;
//							}																 
							
								builder.append( "<tr>" 
								+ "<td style='width:50px;'><b>Total Tracker</b></td>"
								+ "<td style='width: 70px;'><b>%</b></td>"
								+ "<td style='width: 80px;text-align:right;'>"								
								+ Math.round(totalOfDay/totalday*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round(totalOfNight/totalnight*100) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round((totalOfDay+totalOfNight)/totalBaleWight*100)
								+ "</td>" 
								+ "<td style='width: 80px;text-align:right;'></td>" 
								+ "</tr>"
								+ "<tr>"
								+ "<td style='width:50px;'><b>Waste Paper Fed - TRACKER</b></td>"
								+ "<td style='width: 70px;'><b>AD Tons</b></td>"
								+ "<td style='width: 80px;text-align:right;'>"								
								+ Math.round(totalday) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round(totalnight) + "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round(totalday+totalnight)
								+ "</td>"
								+ "<td style='width: 80px;text-align:right;'>"
								+ Math.round(mtdtotal)
								+"</td>"
								+ "</tr>"
								);
								wastePaperFedTotalDay+=totalday;
								wastePaperFedTotalNight+=totalnight;
								wastePaperFedTotalMtd+=mtdtotal;
					}
				}
			}
			builder.append( "<tr>" 
					+ "<td style='width:50px;'><b>Waste Paper Fed - TRACKER</b></td>"
					+ "<td style='width: 70px;'><b>AD Tons</b></br>line A+B</td>"
					+ "<td style='width: 80px;text-align:right;'>"								
					+ Math.round(wastePaperFedTotalDay) + "</td>"
					+ "<td style='width: 80px;text-align:right;'>"
					+ Math.round(wastePaperFedTotalNight) + "</td>"
					+ "<td style='width: 80px;text-align:right;'>"
					+ Math.round(wastePaperFedTotalDay+wastePaperFedTotalNight)
					+ "</td>" 
					+ "<td style='width: 80px;text-align:right;'>"+ Math.round(wastePaperFedTotalMtd)+"</td>" 
					+ "</tr>");
			
			builder.append("<tr>"
					+ "<td style='width:360px;background-color: yellow;'><b>Wastepaper Inventory 7 AM</b></td>"
					+ "<td style='width: 70px;'></td>" + "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>Total Inventory</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>" + "<tr>"
					+ "<td style='width:50px;'><b>OCC</b></td>" + "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>" + Math.round((occTotalWeight - occConsumeWeight))
					+ "</td>" + "<td style='width: 80px;text-align:right;'></td>" + "</tr>" + "<tr>"
					+ "<td style='width:50px;'><b>OCC-Grocery</b></td>"
					+ "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width:  80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>"
					+ Math.round((occGroceryTotalWeight - occGroceryConsumeWeight)) + "</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>" + "<tr>"
					+ "<td style='width:50px;'><b>DLK</b></td>" + "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width:  80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>" + Math.round((dlkTotalWeight - dlkConsumeWeight))
					+ "</td>" + "<td style='width: 80px;text-align:right;'></td>" + "</tr>" + "<tr>"
					+ "<td style='width:50px;'><b>ONP-Old Newsprint</b></td>"
					+ "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>"
					+ Math.round((oldnewsTotalWeight - oldnewsConsumeWeight)) + "</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>" + "<tr>"
					+ "<td style='width:50px;'><b>News</b></td>" + "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>"
					+ Math.round((newsTotalWeight - newsConsumeWeight)) + "</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>" + "<tr>"
					+ "<td style='width:50px;'><b>Mail</b></td>" + "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>"
					+ Math.round((mailTotalWeight - mailConsumeWeight)) + "</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>" + "<tr>"
					+ "<td style='width:50px;'><b>Mixed</b></td>" + "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>"
					+ Math.round((mixedTotalWeight - mixedConsumeWeight)) + "</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>" + "<tr>"
					+ "<td style='width:50px;'><b>Brown Broke</b></td>"
					+ "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width:50px;text-align:right;'></td>"
					+ "<td style='width:50px;text-align:right;'></td>" + "<td style='width:50px;text-align:right;'>"
					+ Math.round((brownbrokeTotalWeight - brownbrokeConsumeWeight)) + "</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>"
					/*
					 * + "<tr>" + "<td style='width:50px;'><b>Boxboard Clippings</b></td>" +
					 * "<td style='width: 70px;'><b>AD TONS</b></td>" +
					 * "<td style='width:50px;text-align:right;'></td>" +
					 * "<td style='width:50px;text-align:right;'></td>" +
					 * "<td style='width:50px;text-align:right;'>"+Math.round((
					 * boxclippingsTotalWeight-boxclippingsConsumeWeight))+"</td>" +
					 * "<td style='width: 80px;text-align:right;'></td>" + "</tr>" + "<tr>" +
					 * "<td style='width:50px;'><b>SOW</b></td>" +
					 * "<td style='width: 70px;'><b>AD TONS</b></td>" +
					 * "<td style='width: 80px;text-align:right;'></td>" +
					 * "<td style='width: 80px;text-align:right;'></td>" +
					 * "<td style='width: 80px;text-align:right;'>"+Math.round((sowTotalWeight-
					 * sowInventrynight))+"</td>" +
					 * "<td style='width: 80px;text-align:right;'></td>" + "</tr>"
					 */
					+ "<tr>" + "<td style='width:50px;'><b>VirginHardWood</b></td>"
					+ "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>"
					+ Math.round((virginHardWoodTotalweight - virginHardWoodTotalConsumed)) + "</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>" + "<tr>"
					+ "<td style='width:50px;'><b>VirginSoftWood</b></td>"
					+ "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>"
					+ Math.round((virginSoftWoodTtotalweight - virginSoftWoodTotalConsumed)) + "</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>" + "<tr>"
					+ "<td style='width:50px;'><b>HardWhite</b></td>"
					+ "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>"
					+ Math.round((hardWhiteTotalweight - hardWhiteTotalConsumed)) + "</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" + "</tr>" 
					
					+ "<tr>"
					+ "<td style='width:50px;'><b>DryLapWhite</b></td>"
					+ "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>"
					+ Math.round((dryLapWhiteTotalweight - dryLapWhiteTotalConsumed)) + "</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" 
					+ "</tr>" 					
					+ "<tr>"
					+ "<td style='width:50px;'><b>Total Inventory</b></td>" 
					+ "<td style='width: 70px;'><b>AD TONS</b></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>"+Math.round(totalWeight-totalConsumed) +"</td>"
					+ "<td style='width: 80px;text-align:right;'></td>" 
					+ "</tr>"
					+ "<tr>"
					+ "<td style='width:50px;'><b>OVERALL YIELD</b></td>" 
					+ "<td style='width: 70px;'><b>%</b></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'></td>"
					+ "<td style='width: 80px;text-align:right;'>" + percentage + "</td>" 
					+ "</tr>"
					
					+ "</tbody> </table>");
			}else {
				builder.append(
						"<b style='color: red;'>We Are Unable To Generate The Report.<br>Either Data Not Found Or Application in Under Maintenance</b><br/><br/>");
				builder.append("");
			}
			builder.append(
					"<br/>--<br/>Thank You,<br/>Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email:Time"
							+ dateTimeFormat.format(new Date()) + " ***</p>");
			
			
			return builder.toString();
			
	}

}
