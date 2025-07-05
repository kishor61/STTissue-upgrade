/**
 *Jan 7, 2015
 *TestingMail.java
 * TODO
 *com.st.common.automailer
 *TestingMail.java
 *Sunil Singh Bora
 */
package com.st.common.automailer;

import org.springframework.stereotype.Component;

/**
 * @author sbora
 *
 */
@Component
public class TestingMail {
//	private static final Logger logger = LoggerFactory
//			.getLogger(TestingMail.class);
//
//	@Autowired
//	private JavaMailSender mailSender;
//
//	@Autowired
//	private WrapperProductionService wrapperProductionService;
//
//	@Autowired
//	private ReelService reelService;
//
//	@Value("${mail.to.test}")
//	private String emailTo;
//
//	@Value("${mail.bcc}")
//	private String emailBcc;
//
//	@Value("${mail.from}")
//	private String emailFrom;
//
//	@Value("${mail.fromname}")
//	private String emailFromName;
//
//	@Value("${mail.to.error}")
//	private String emailToError;
//
//	
//	@Value("${mail.test.sat.sun}")
//	private String emailFromSatSun;
//
//	SimpleDateFormat dateTimeFormat=new SimpleDateFormat("MM-dd-yyyy h:mm a");
//	
//	//Code Done By Roshan TAilor
//	SimpleDateFormat dateTimeFormat1=new SimpleDateFormat("yyyy-MM-dd");
//	//Code Ends Here Done By Roshan Tailor
//	
//	private void sendTestMail(final String message) {
//		mailSender.send(new MimeMessagePreparator() {
//
//			@Override
//			public void prepare(MimeMessage mimeMessage) throws Exception {
//
//				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
//				messageHelper.setTo(emailTo.split(";"));
//				messageHelper.setBcc(emailBcc.split(";"));
//				messageHelper.setFrom(emailFrom, emailFromName);
//
//				//messageHelper.setSubject("ST Tissue Report - Testing mail "+dateTimeFormat.format(new Date()));
//				
//				messageHelper.setSubject(dateTimeFormat1.format(new Date())+"-STT-Report - Testing mail");//This Code Done By Roshan Tailor
//				StringBuilder builder = new StringBuilder();
//				builder.append("Testing mail for " + message);
//				
//
//				mimeMessage.setContent(builder.toString(), "text/html");
//
//				logger.info("Sent testing mail successfully....");
//			}
//		});
//	}
//
//	public void sendTestKPI() throws Exception {
//		Calendar scal = Calendar.getInstance();
//		scal.setTime(new Date());
//
//		Calendar ecal = Calendar.getInstance();
//		ecal.setTime(new Date());
//		ecal.add(Calendar.DATE, -1);
//		// Test Ping
//		
//		wrapperProductionService.getWrapperProductions(scal.getTime(),ecal.getTime());
//
//		logger.info("Production Test Ok");
//		
//		reelService.getReelData(scal.getTime(), ecal.getTime(),"","","","");
//
//		logger.info("Quatliy Test Ok");
//		
//		sendTestMail("KPI Report");
//	}
//
//	public void sendQualityAndSummary() throws Exception {
//		Calendar scal = Calendar.getInstance();
//		scal.setTime(new Date());
//
//		Calendar ecal = Calendar.getInstance();
//		ecal.setTime(new Date());
//		ecal.add(Calendar.DATE, -1);
//
//		wrapperProductionService.getWrapperProductions(scal.getTime(),ecal.getTime());
//
//		logger.info("Production Test Ok");
//		
//		reelService.getReelData(scal.getTime(), ecal.getTime(),"","","","");
//
//		logger.info("Quatliy Test Ok");
//		
//		sendTestMail("New Email Server Testing "+dateTimeFormat.format(new Date()));
//	}
//	
//	
//	public void sendTestMailSatSun() throws Exception {
//		
//		logger.info("Before sending - Test Mail For Sat Sun - Ok");
//		
//		mailSender.send(new MimeMessagePreparator() {
//
//			@Override
//			public void prepare(MimeMessage mimeMessage) throws Exception {
//
//				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
//				messageHelper.setTo(emailFromSatSun.split(";"));
//				//messageHelper.setBcc("");
//				messageHelper.setFrom(emailFrom, emailFromName);
//
//				//messageHelper.setSubject("ST Tissue - Testing mail "+dateFormat.format(new Date()));
//				//Code Done By Roshan Tailor 
//				messageHelper.setSubject(dateTimeFormat1.format(new Date())+"-STT-Testing mail");
//				StringBuilder builder = new StringBuilder();
//				builder.append("Hello Team,"
//						+ "<br/><br/>Please find the below ST Tissue Test Mail For  "+ new Date()+" Your Review.<br/><br/>");
//				
//				builder.append("<br/>Thank you,<br/>");
//				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
//						+ dateTimeFormat.format(new Date()) + " ***</p>");
//				mimeMessage.setContent(builder.toString(), "text/html");
//
//				logger.info("Sent testing mail successfully....");
//			}
//		});
//		
//
//		logger.info("After sending - Test Mail For Sat Sun - Ok");
//		
//		
//	}
}
