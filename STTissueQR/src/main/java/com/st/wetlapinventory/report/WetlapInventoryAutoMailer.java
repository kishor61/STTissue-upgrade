/**
 *May 6, 2016
 *WetlapInventoryAutoMailer.java
 * TODO
 *com.st.wetlapinventory.report
 *WetlapInventoryAutoMailer.java
 *Sunil Singh Bora
 */
package com.st.wetlapinventory.report;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;
import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.wetlapinventory.model.WetlapInventory;
import com.st.wetlapinventory.service.WetlapInventoryService;

/**
 * @author roshan
 *
 */
@Component
public class WetlapInventoryAutoMailer {

	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private WetlapInventoryService wetlapInventoryService;
	
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.to.wetlatinventory}")
	private String emailTowetlatinventory;
	
	@Value("${mail.bcc}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;

	@Value("${mail.fromname}")
	private String emailFromName;
	
	@Value("${mail.to.error}")
	private String emailToError;
	public void sendMailAt8am() {

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				try {

					List<WetlapInventory> frpDetails=wetlapInventoryService.getReportData();
					List<WetlapInventory> millDetails=wetlapInventoryService.getReportMillData();

					
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(emailTowetlatinventory.split(";"));
					messageHelper.setBcc(emailBcc.split(";"));
					messageHelper.setFrom(emailFrom, emailFromName);

					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, -1);

					messageHelper.setSubject(dateTimeFormat4.format(cal.getTime()) + "-STT-Wetlap Inventory Summary Report");
					//mimeMessage.setContent(getMessageBody(details, sDate),"text/html");
					mimeMessage.setContent(getMessageBody(frpDetails, millDetails),"text/html");

				} catch (Exception e) {
					logger.error("Error message in Wetlap Inventory Summary Report..."+ e.getMessage(), e);

					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(emailToError.split(";"));
					messageHelper.setFrom(emailFrom);
					messageHelper.setSubject("Fail to send Wetlap Inventory Summary.");
					mimeMessage.setContent("Unable to read Wetlap Inventory Summary data<br>"+ e.getMessage(), "text/html");
				}

				logger.info("Wet Lap Inventory Report Mail Sent....");
			}
		});
	}
	/**
	 * @param frpDetails
	 * @param millDetails
	 * @return
	 */
	protected String getMessageBody(List<WetlapInventory> frpDetails,
			List<WetlapInventory> millDetails) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		
		builder.append("<style>"
				+ ".demo {"
				+ "border:1px solid #C0C0C0;"
				+ "border-collapse:collapse;"
				+ "padding:5px;"
				+ "}"
				+ ".demo th {"
				+ "border:1px solid #C0C0C0;"
				+ "padding:5px;"
				+ "background:#F0F0F0;"
				+ "}"
				+ ".demo td {"
				+ "border:1px solid #C0C0C0;"
				+ "padding:5px;"
				+ "}"
				+ "</style>");
		builder.append("Hello Sir,"
				+ "<br/><br/>Please Find The Below ST Tissue Wetlap Inventory Summary Report  "
				+ dateFormat.format(new Date()) + " For Your Review.<br/><br/>");
		builder.append("");
		
		if(frpDetails.size()>0 || millDetails.size()>0){
			builder.append("<table class='demo'>"
					+ "<caption><b style='font-size: 19px;color: #0064FF;'>Total Wet Lap Inventory Available - Summary</b></caption>"
					+ "<thead>"
					+ "<tr>"
						+ "<th>Location</th>"
						+ "<th>Bale Count</th>"
						/*+ "<th>Gross Wt.(LBS)</th>"
						+ "<th>Net Wt.(LBS)</th>"*/
						+ "<th>Gross Wt.(TONS)</th>"
						+ "<th>Net Wt.(TONS)</th>"
					+ "</tr>"
					+ "</thead>"
					+ "<tbody>");
					for(WetlapInventory wd:frpDetails){
						builder.append("<tr>"
								+ "<td>FRP:</td>"
								+ "<td><center>"+wd.getTotalbalesfrp()+"</center></td>"
								/*+ "<td><center>"+CommonUtil.round(wd.getFrpgrosswtlbs(), 2)+"</center></td>"
								+ "<td><center>"+CommonUtil.round(wd.getFrpnetwtlbs(), 2)+"</center></td>"*/
								+ "<td><center>"+CommonUtil.round(wd.getFrpgrosswtton(), 2)+"</center></td>"
								+ "<td><center>"+CommonUtil.round(wd.getFrpnetwtton(), 2)+"</center></td>"
							+ "</tr>");
					}
					for(WetlapInventory wd:frpDetails){
						builder.append("<tr>"
								+ "<td>YARD:</td>"
								+ "<td><center>"+wd.getTotalbalesyard()+"</center></td>"
								/*+ "<td><center>"+CommonUtil.round(wd.getYardgrosswtlbs(), 2)+"</center></td>"
								+ "<td><center>"+CommonUtil.round(wd.getYardnetwtlbs(), 2)+"</center></td>"*/
								+ "<td><center>"+CommonUtil.round(wd.getYardgrosswtton(), 2)+"</center></td>"
								+ "<td><center>"+CommonUtil.round(wd.getYardnetwtton(), 2)+"</center></td>"
								+ "</tr>");
					}
					
					double totalfrpgrosswtlbs=0;
					double totalyardgrosswtlbs=0;
					double totalfrpnetwtlbs=0;
					double totalyardnetwtlbs=0;
					double totalfrpgrosswtton=0;
					double totalyardgrosswtton=0;
					double totalfrpnetwtton=0;
					double totalyardnetwtton=0;
					double totalbalesinfrp=0;
					double totalbalesinyard=0;
					
					for(WetlapInventory wd:frpDetails){
						 totalfrpgrosswtlbs=totalfrpgrosswtlbs+wd.getFrpgrosswtlbs();
						 totalyardgrosswtlbs=totalyardgrosswtlbs+wd.getYardgrosswtlbs();
						 totalfrpnetwtlbs=totalfrpnetwtlbs+wd.getFrpnetwtlbs();
						 totalyardnetwtlbs=totalyardnetwtlbs+wd.getYardnetwtlbs();
						 totalfrpgrosswtton=totalfrpgrosswtton+wd.getFrpgrosswtton();
						 totalyardgrosswtton=totalyardgrosswtton+wd.getYardgrosswtton();
						 totalfrpnetwtton=totalfrpnetwtton+wd.getFrpnetwtton();
						 totalyardnetwtton=totalyardnetwtton+wd.getYardnetwtton();
						 totalbalesinfrp=totalbalesinfrp+wd.getTotalbalesfrp();
						 totalbalesinyard=totalbalesinyard+wd.getTotalbalesyard();
					}
					for(WetlapInventory mill:millDetails){
					builder.append("<tr>"
						+ "<td>MILL:</td>"
						+ "<td><center>"+mill.getTotalbalesmill()+"</center></td>"
						/*+ "<td><center>"+CommonUtil.round(mill.getGrosslbsmill(), 2)+"</center></td>"
						+ "<td><center>"+CommonUtil.round(mill.getNetlbsmill(), 2)+"</center></td>"*/
						+ "<td><center>"+CommonUtil.round(mill.getGrosstonmill(), 2)+"</center></td>"
						+ "<td><center>"+CommonUtil.round(mill.getNettonmill(), 2)+"</center></td>"
					+ "</tr>");
					}
					
					double totalgrosslbsmill=0;
					double totalnetlbsmill=0;
					double totalgrosstonmill=0;
					double totalnettonmill=0;
					double totalbalesinmill=0;
					
					for(WetlapInventory mill:millDetails){
						 totalgrosslbsmill=totalgrosslbsmill+mill.getGrosslbsmill();
						 totalnetlbsmill=totalnetlbsmill+mill.getNetlbsmill();
						 totalgrosstonmill=totalgrosstonmill+mill.getGrosstonmill();
						 totalnettonmill=totalnettonmill+mill.getNettonmill();
						 totalbalesinmill=totalbalesinmill+mill.getTotalbalesmill();
					}
					builder.append("<tr>"
					+ "<td>WetLap Total:</td>"
					+ "<td><center><b>"+CommonUtil.round(totalbalesinfrp+totalbalesinyard+totalbalesinmill, 2)+"</b></center></td>"
						/*+ "<td><center><b>"+CommonUtil.round(totalfrpgrosswtlbs+totalyardgrosswtlbs+totalgrosslbsmill, 2)+"</b></center></td>"
						+ "<td><center><b>"+CommonUtil.round(totalfrpnetwtlbs+totalyardnetwtlbs+totalnetlbsmill, 2)+"</b></center></td>"*/
						+ "<td><center><b>"+CommonUtil.round(totalfrpgrosswtton+totalyardgrosswtton+totalgrosstonmill, 2)+"</b></center></td>"
						+ "<td><center><b>"+CommonUtil.round(totalfrpnetwtton+totalyardnetwtton+totalnettonmill, 2)+"</b></center></td>"
					+ "</tr>"
					+ "</tbody>"
					+ "</table>");
		}else{
			builder.append("<b style='color: red;'>We Are Unable To Generate The Report.<br>Either Data Not Found Or Application in Under Maintenance</b><br/><br/>");
		}
		
	builder.append("<br/>--<br/>Thank You,<br/>Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email:Time"
				+ dateTimeFormat.format(new Date()) + " ***</p>");

		return builder.toString();
	}
	

}
