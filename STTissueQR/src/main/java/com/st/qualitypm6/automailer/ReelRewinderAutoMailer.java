/**
 * 
 */
package com.st.qualitypm6.automailer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.st.common.Columns;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.qualitypm5.model.ReelPM5;
import com.st.qualitypm5.service.ReelServicePM5;
import com.st.qualitypm6.model.Reel;
import com.st.qualitypm6.service.ReelService;
import com.st.qualitypm6.service.RewindService;

/**
 * @author sbora
 *
 */
@Component
public class ReelRewinderAutoMailer {
	private static final Logger logger=LoggerFactory.getLogger(ReelRewinderAutoMailer.class);
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat3=new SimpleDateFormat("yyyyMMddHHmm");
	
	private SimpleDateFormat dateTimeFormat=new SimpleDateFormat("MM-dd-yyyy h:mm a");
	
	private SimpleDateFormat dateFormat5=new SimpleDateFormat("yyyy-MM-dd");
	//Code Ends Here Done By Roshan Tailor Date :- 06/26/2015
		
		
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Autowired
	private ReelService reelService;
	
	@Autowired
	private ReelServicePM5 reelServicepm5;
	
	@Autowired
	private RewindService rewindService;
	
	
	@Value("${mail.to}")
	private String emailTo;
	
	@Value("${mail.dailyinvreporeel}")
	private String emailToreel;
	@Value("${mail.bcc}")
	private String emailBcc;
	
	@Value("${mail.from}")
	private String emailFrom;
	
	@Value("${mail.fromname}")
	private String emailFromName;
	
	@Value("${mail.to.error}")
	private String emailToError;
	
	@Autowired
	private ServletContext context;
	
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy");
	
	public void sendMail(final Date date,final String shift, String repientEmails) {
		
		mailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				try {
					
					String folder=System.getProperty("catalina.base")+"/Quality reports";
					File folderFile=new File(folder);
					if(!folderFile.exists()){
						folderFile.mkdirs();
					}
					Calendar cal=Calendar.getInstance();
					cal.setTime(date);
					
					cal.add(Calendar.DATE, -1);
					System.out.println(cal.getTime());
					
					File fileReelPdf=new File(folder,"ST Tissue PM 6 Tissue Machine Quality Report-REEL Testing "+dateFormat3.format(new Date())+".pdf");
					reelService.createPdfReelReport(fileReelPdf, cal.getTime());
					
					File fileRwinderPdf=new File(folder,"ST Tissue PM 6 Tissue Machine Quality Report-REWINDER Testing "+dateFormat3.format(new Date())+".pdf");
					rewindService.createPdfReelReport(fileRwinderPdf, cal.getTime());
					
					MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true);
					messageHelper.setTo(emailTo.split(";"));
					messageHelper.setFrom(emailFrom,emailFromName);
					messageHelper.setBcc(emailBcc.split(";"));
					messageHelper.setSubject(dateFormat5.format(date)+"-STT-PM6 Quality Reports"+""+shift);							
					messageHelper.setText(getMessageBody(fileReelPdf,fileRwinderPdf,cal.getTime()), true);
					
					if(fileReelPdf.exists()){
						logger.info("Sending reel file as attachment="+fileReelPdf.getName());
						messageHelper.addAttachment(dateFormat5.format(cal.getTime())+"-STT-PM 6 Tissue Machine Quality Report-REEL Testing.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(fileReelPdf))));
					}
					
					if(fileRwinderPdf.exists()){
						logger.info("Sending rwinder file as attachment="+fileReelPdf.getName());
						messageHelper.addAttachment(dateFormat5.format(cal.getTime())+"-STT-PM 6 Tissue Machine Quality Report-REWINDER Testing.pdf", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(fileRwinderPdf))));
					}
					
						
				} catch (Exception e) {
					System.out.println("Error message in PM6 quality report..."+e);
					logger.error("Error message in PM6 quality report..."+e.getMessage(),e);
					MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage, "UTF-8");
					messageHelper.setTo(emailToError.split(";"));
					messageHelper.setFrom(emailFrom);
					messageHelper.setSubject("Fail to send PM6 quality report.");
					mimeMessage.setContent("Unable to read production data<br>"+e.getMessage(), "text/html");
				}
				

				logger.info("Production Summary Report message sent....");
			}

			
		});
		
	}
	
	private String getMessageBody(File fileReelPdf,File fileRwinderPdf,Date date) {
		
		StringBuilder builder=new StringBuilder();
		builder.append("Hello Sir, <br/>");
		
		if(fileReelPdf.exists() && fileRwinderPdf.exists()){
			builder.append("Please find the attached ST Tissue PM6 Quality Reports of "+dateFormat.format(date)+" for your review.<br/><br/>");	
		}else if(fileReelPdf.exists() && !fileRwinderPdf.exists()){
			builder.append("Please find the attached ST Tissue PM6 Quality Reports of "+dateFormat.format(date)+" for your review.<br/><br/>");
			builder.append("<p style=\"color: red;\">Note: There is no data for PM6 Tissue Machine Quality Report-Rewinder.</p><br/><br/>");
		}else if(!fileReelPdf.exists() && fileRwinderPdf.exists()){
			builder.append("Please find the attached ST Tissue PM6 Quality Reports of "+dateFormat.format(date)+" for your review.<br/><br/>");
			builder.append("<p style=\"color: red;\">Note: There is no data for PM6 Tissue Machine Quality Report-Reel.</p><br/><br/>");
		}else{
			builder.append(
					"<p>We are unable to generate ST Tissue  PM6 Quality Reports at this time because<br><br>"
					+ "<span style=\"color: red;font-size: 18px;\"> \"Either data not available in database or Machine is under maintenance.\"</span></p>");
		}
		
		builder.append("Thank you,<br/>");
		builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
		
		return builder.toString();
	}




public void sendMailReelTesting() {
	
			final	File  file=new File(context.getRealPath("/")+"WEB-INF/ReelReport.xls");
			final	File file1=new File(context.getRealPath("/")+"WEB-INF/ReelReportPM5.xls");
			
					try {
						
						//String toDate=dateFormat1.format(new Date());
						
						Calendar ecal=Calendar.getInstance();
						ecal.setTime(new Date());
						ecal.add(Calendar.DATE, -1);
						
						String fromDate=dateFormat1.format(ecal.getTime());
						List<Reel> reels = reelService.getReelData(
								dateFormat1.parse(fromDate), 
								dateFormat1.parse(fromDate),"","","","");
						
						List<Map<String, Object>> datas =reelService.getFormatedData(reels);
						
						List<ReelPM5> pm5reels = reelServicepm5.getReelData(
								dateFormat1.parse(fromDate), 
								dateFormat1.parse(fromDate),"","","","");
						
						List<Map<String, Object>> pm5datas =reelServicepm5.getFormatedData(pm5reels);
												
						try {
							
							if(datas.isEmpty())
							{
								logger.info("ST Tissue Quality Reports Reel Testing PM6 Data Not Found For Last Date");
								System.out.println("ST Tissue Quality Reports Reel Testing PM6 Data Not Found For Last Date");
							}
							else {
								HSSFWorkbook workbook=getFormatedWorkbook(file,datas);
								FileOutputStream outputStream = new FileOutputStream(file);
								workbook.write(outputStream);
							}
							if(pm5datas.isEmpty())
							{
								logger.info("ST Tissue Quality Reports Reel Testing PM5 Data Not Found For Last Date");
								System.out.println("ST Tissue Quality Reports Reel Testing PM5 Data Not Found For Last Date");
							}
							else
							{
								HSSFWorkbook workbook1=getFormatedWorkbook(file1,pm5datas);
								FileOutputStream outputStream1 = new FileOutputStream(file1);
								workbook1.write(outputStream1);
							}							
						
							
						} catch (IOException e) {
							e.printStackTrace();
						}
				
						
					} catch (ParseException e) {
						e.printStackTrace();
					}			
	
					mailSender.send(new MimeMessagePreparator() {
						@Override
						public void prepare(MimeMessage mimeMessage) throws Exception {
							MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
							messageHelper.setTo(emailToreel.split(";"));
							messageHelper.setFrom(emailFrom, emailFromName);
						//	messageHelper.setBcc(emailBcc.split(";"));
							
							messageHelper.setSubject(dateFormat.format(new Date())
									+ " -ST Tissue Quality Reports Reel Testing ");
							messageHelper.setText(getMessage(), true);
							if (file.exists()) {
								messageHelper.addAttachment(dateFormat.format(new Date())
												+ "ST Tissue PM6 Quality Reports Reel Testing.xls",
										new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(file))));
							}
							if (file1.exists()) {
								messageHelper.addAttachment(dateFormat.format(new Date())
												+ "ST Tissue PM5 Quality Reports Reel Testing.xls",
										new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(file1))));
							}
							logger.info("ST Tissue Quality Reports Reel Testing mail is sent");
							
							System.out.println("ST Tissue Quality Reports Reel Testing mail is sent");
						}
						private String getMessage() {
							StringBuilder builder = new StringBuilder();
							builder.append("Hello Sir,<br/><br/>");
							builder.append("Please find the attached <b>\"ST Tissue Qulity Report \"</b> for your review.<br/>");
							builder.append("<br/>Thank you,<br/>");
							builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"
									+ dateTimeFormat.format(new Date()) + " ***</p>");

							return builder.toString();
						}
					});
	}
private HSSFWorkbook getFormatedWorkbook(File file, List<Map<String, Object>> datas) throws IOException {
	
	int red1 = 0,red2= 0,red3= 0,red4= 0,red5= 0,red6= 0,red7= 0,red8= 0,red9= 0,red10= 0,red11= 0;
	int green1= 0,green2= 0,green3= 0,green4= 0,green5= 0,green6= 0,green7= 0,green8= 0,green9= 0,green10 = 0 ,green11 = 0 ;
	int yellow1= 0,yellow2= 0,yellow3= 0,yellow4= 0,yellow5= 0,yellow6= 0,yellow7= 0,yellow8= 0,yellow9= 0,yellow10 = 0,yellow11 = 0 ;
	
	
	int loopi = 0;
	
	FileInputStream inputStream=new FileInputStream(file);
	HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
	HSSFCellStyle headerCellStyle=workbook.createCellStyle();
	headerCellStyle.setWrapText(true);
	headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
	headerCellStyle.setBorderBottom(BorderStyle.THIN);
	headerCellStyle.setBorderLeft(BorderStyle.THIN);
	headerCellStyle.setBorderRight(BorderStyle.THIN);
	headerCellStyle.setBorderTop(BorderStyle.THIN);
	
	Font headerFont=workbook.createFont();
	headerFont.setBold(true);
	headerCellStyle.setFont(headerFont);
	
	
	
	HSSFSheet sheet=workbook.getSheetAt(0);

	
	
	Font objectFont=workbook.createFont();
	objectFont.setBold(true);
	objectFont.setColor(IndexedColors.BLUE.getIndex());
	HSSFCellStyle objectCellStyle=workbook.createCellStyle();
	objectCellStyle.setBorderBottom(BorderStyle.THIN);
	objectCellStyle.setBorderLeft(BorderStyle.THIN);
	objectCellStyle.setBorderRight(BorderStyle.THIN);
	objectCellStyle.setBorderTop(BorderStyle.THIN);
	objectCellStyle.setAlignment(HorizontalAlignment.CENTER);
	objectCellStyle.setFont(objectFont);
	objectCellStyle.setWrapText(true);
	
	Font objectFontRed=workbook.createFont();
	objectFontRed.setBold(true);
	objectFontRed.setColor(IndexedColors.RED.getIndex());
	HSSFCellStyle objectCellStyleRED=workbook.createCellStyle();
	objectCellStyleRED.setBorderBottom(BorderStyle.THIN);
	objectCellStyleRED.setBorderLeft(BorderStyle.THIN);
	objectCellStyleRED.setBorderRight(BorderStyle.THIN);
	objectCellStyleRED.setBorderTop(BorderStyle.THIN);
	objectCellStyleRED.setAlignment(HorizontalAlignment.CENTER);
	objectCellStyleRED.setFont(objectFontRed);
	objectCellStyleRED.setWrapText(true);
	
	Font objectFontCol=workbook.createFont();
	objectFontCol.setBold(true);
	objectFontCol.setColor(IndexedColors.BLACK.getIndex());
	HSSFCellStyle objectCellStyleCol=workbook.createCellStyle();
	objectCellStyleCol.setBorderBottom(BorderStyle.THIN);
	objectCellStyleCol.setBorderLeft(BorderStyle.THIN);
	objectCellStyleCol.setBorderRight(BorderStyle.THIN);
	objectCellStyleCol.setBorderTop(BorderStyle.THIN);
	objectCellStyleCol.setAlignment(HorizontalAlignment.CENTER);
	objectCellStyleCol.setFont(objectFontCol);
	objectCellStyleCol.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	objectCellStyleCol.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	objectCellStyleCol.setWrapText(true);

	Font fontRow=workbook.createFont();
	fontRow.setBold(true);
	fontRow.setColor(IndexedColors.BLACK.getIndex());
	HSSFCellStyle rowCellStyle=workbook.createCellStyle();
	rowCellStyle.setBorderBottom(BorderStyle.THIN);
	rowCellStyle.setBorderLeft(BorderStyle.THIN);
	rowCellStyle.setBorderRight(BorderStyle.THIN);
	rowCellStyle.setBorderTop(BorderStyle.THIN);
	rowCellStyle.setFont(fontRow);
	rowCellStyle.setAlignment(HorizontalAlignment.CENTER);
	rowCellStyle.setWrapText(true);
	rowCellStyle.setVerticalAlignment(VerticalAlignment.TOP);
	
	HSSFCellStyle rowCellStyleRed=workbook.createCellStyle();
	rowCellStyleRed.setBorderBottom(BorderStyle.THIN);
	rowCellStyleRed.setBorderLeft(BorderStyle.THIN);
	rowCellStyleRed.setBorderRight(BorderStyle.THIN);
	rowCellStyleRed.setBorderTop(BorderStyle.THIN);
	rowCellStyleRed.setFont(fontRow);
	rowCellStyleRed.setAlignment(HorizontalAlignment.CENTER);
	rowCellStyleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
	rowCellStyleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	rowCellStyleRed.setWrapText(true);
	
	HSSFCellStyle rowCellStyleYellow=workbook.createCellStyle();
	rowCellStyleYellow.setBorderBottom(BorderStyle.THIN);
	rowCellStyleYellow.setBorderLeft(BorderStyle.THIN);
	rowCellStyleYellow.setBorderRight(BorderStyle.THIN);
	rowCellStyleYellow.setBorderTop(BorderStyle.THIN);
	rowCellStyleYellow.setFont(fontRow);
	rowCellStyleYellow.setAlignment(HorizontalAlignment.CENTER);
	rowCellStyleYellow.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	rowCellStyleYellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	rowCellStyleYellow.setWrapText(true);
	
	HSSFCellStyle rowCellStyleGreen=workbook.createCellStyle();
	rowCellStyleGreen.setBorderBottom(BorderStyle.THIN);
	rowCellStyleGreen.setBorderLeft(BorderStyle.THIN);
	rowCellStyleGreen.setBorderRight(BorderStyle.THIN);
	rowCellStyleGreen.setBorderTop(BorderStyle.THIN);
	rowCellStyleGreen.setFont(fontRow);
	rowCellStyleGreen.setAlignment(HorizontalAlignment.CENTER);
	rowCellStyleGreen.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
	rowCellStyleGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	rowCellStyleGreen.setWrapText(true);
	
	int rowCount=2;
	
	//System.out.println(datas);
	
	for (Map<String, Object> map : datas) {
	//	System.out.println(map);
		HSSFRow row=sheet.createRow(rowCount);
		row.setHeight((short)280);
		if(map.get(ColumnsOfTable.COL_01).toString().equalsIgnoreCase("OBJECTIVES")){
			HSSFCell COL_01=row.createCell(Columns.COL_00);
			COL_01.setCellStyle(objectCellStyle);
			COL_01.setCellValue(map.get(ColumnsOfTable.COL_01).toString());
			
			HSSFCell COL_02=row.createCell(Columns.COL_01);
			COL_02.setCellStyle(objectCellStyle);
			COL_02.setCellValue(map.get(ColumnsOfTable.COL_02).toString());
			
			HSSFCell COL_03=row.createCell(Columns.COL_02);
			COL_03.setCellStyle(objectCellStyleRED);
			COL_03.setCellValue(map.get(ColumnsOfTable.COL_03).toString());
			
			HSSFCell COL_04=row.createCell(Columns.COL_03);
			COL_04.setCellStyle(objectCellStyle);
			COL_04.setCellValue(map.get(ColumnsOfTable.COL_04).toString());
			
			HSSFCell COL_05=row.createCell(Columns.COL_04);
			COL_05.setCellStyle(objectCellStyleCol);
			COL_05.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()));
			
			HSSFCell COL_06=row.createCell(Columns.COL_05);
			COL_06.setCellStyle(objectCellStyle);
			COL_06.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()));
			
			HSSFCell COL_07=row.createCell(Columns.COL_06);
			COL_07.setCellStyle(objectCellStyle);
			COL_07.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()));
			
			HSSFCell COL_08=row.createCell(Columns.COL_07);
			COL_08.setCellStyle(objectCellStyle);
			COL_08.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()));
			
			HSSFCell COL_09=row.createCell(Columns.COL_08);
			COL_09.setCellStyle(objectCellStyle);
			COL_09.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()));
			
			HSSFCell COL_10=row.createCell(Columns.COL_09);
			COL_10.setCellStyle(objectCellStyle);
			COL_10.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()));
			
			HSSFCell COL_11=row.createCell(Columns.COL_10);
			COL_11.setCellStyle(objectCellStyle);
			COL_11.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()));
			
			HSSFCell COL_12=row.createCell(Columns.COL_11);
			COL_12.setCellStyle(objectCellStyle);
			COL_12.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_12).toString()));
			
			HSSFCell COL_13=row.createCell(Columns.COL_12);
			COL_13.setCellStyle(objectCellStyle);
			COL_13.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString()));
			
			HSSFCell COL_14=row.createCell(Columns.COL_13);
			COL_14.setCellStyle(objectCellStyle);
			COL_14.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_14).toString()));
			
			HSSFCell COL_15=row.createCell(Columns.COL_14);
			COL_15.setCellStyle(objectCellStyle);
			COL_15.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_15).toString()));
			
			HSSFCell COL_16=row.createCell(Columns.COL_15);
			COL_16.setCellStyle(objectCellStyle);
			COL_16.setCellValue(map.get(ColumnsOfTable.COL_16).toString());
			
			HSSFCell COL_17=row.createCell(Columns.COL_16);
			COL_17.setCellStyle(objectCellStyle);
			COL_17.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_17).toString()));
			
			HSSFCell COL_18=row.createCell(Columns.COL_17);
			COL_18.setCellStyle(objectCellStyle);
			COL_18.setCellValue(map.get(ColumnsOfTable.COL_18).toString());
			
			HSSFCell COL_19=row.createCell(Columns.COL_18);
			COL_19.setCellStyle(objectCellStyle);
			COL_19.setCellValue(map.get(ColumnsOfTable.COL_19).toString());
			
			HSSFCell COL_20=row.createCell(Columns.COL_19);
			COL_20.setCellStyle(objectCellStyle);
			COL_20.setCellValue(map.get(ColumnsOfTable.COL_20).toString());
			
			HSSFCell COL_21=row.createCell(Columns.COL_20);
			COL_21.setCellStyle(objectCellStyle);
			COL_21.setCellValue(map.get(ColumnsOfTable.COL_21).toString());
			
			HSSFCell COL_22=row.createCell(Columns.COL_21);
			COL_22.setCellStyle(objectCellStyle);
			COL_22.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_22).toString()));
			
			HSSFCell COL_23=row.createCell(Columns.COL_22);
			COL_23.setCellStyle(objectCellStyle);
			COL_23.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_23).toString()));
			
//			Code Starts From Here Done By Roshan Tailor Date ;- 03/12/2015 MM/DD/YYYY
			
			HSSFCell COL_24=row.createCell(Columns.COL_23);
			COL_24.setCellStyle(objectCellStyle);
			COL_24.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_24).toString()));
			
			
			
			HSSFCell COL_25=row.createCell(Columns.COL_24);
			COL_25.setCellStyle(objectCellStyle);
			COL_25.setCellValue("");
			
			
			HSSFCell COL_26=row.createCell(Columns.COL_25);
			COL_26.setCellStyle(objectCellStyle);
			COL_26.setCellValue("");
			

			HSSFCell COL_27=row.createCell(Columns.COL_26);
			COL_27.setCellStyle(objectCellStyle);
			COL_27.setCellValue("");
//			 Code Ends Here Done By Roshan Tailor
		}else{
			HSSFCell COL_01=row.createCell(Columns.COL_00);
			COL_01.setCellStyle(rowCellStyle);
			COL_01.setCellValue(map.get(ColumnsOfTable.COL_01).toString());
			
			HSSFCell COL_02=row.createCell(Columns.COL_01);
			COL_02.setCellStyle(rowCellStyle);
			COL_02.setCellValue(map.get(ColumnsOfTable.COL_02).toString());
			
			HSSFCell COL_03=row.createCell(Columns.COL_02);
			COL_03.setCellStyle(rowCellStyle);
			COL_03.setCellValue(map.get(ColumnsOfTable.COL_03).toString());
			
			
			
			HSSFCell COL_04=row.createCell(Columns.COL_03);
			COL_04.setCellStyle(rowCellStyle);
			
			if(StringUtils.isNumeric(map.get(ColumnsOfTable.COL_04).toString())){
				COL_04.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_04).toString()));
			}else{
				COL_04.setCellValue(map.get(ColumnsOfTable.COL_04).toString());
			}
			
			
			HSSFCell COL_05=row.createCell(Columns.COL_04);
			COL_05.setCellStyle(objectCellStyleCol);
			COL_05.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()));
			
			HSSFCell COL_06=row.createCell(Columns.COL_05);
			if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("redcolor")){
				red1 = red1+1;
				COL_06.setCellStyle(rowCellStyleRed);
			}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("greencolor")){
				green1 = green1+1;
				COL_06.setCellStyle(rowCellStyleGreen);
			}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("yellowcolor")){
				yellow1 = yellow1+1;
				COL_06.setCellStyle(rowCellStyleYellow);
			}else{
				//COL_06.setCellStyle(rowCellStyle);
				green1 = green1+1;
				COL_06.setCellStyle(rowCellStyleGreen);
			}
			COL_06.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()));
			
			HSSFCell COL_07=row.createCell(Columns.COL_06);
			if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("redcolor")){
				red2 = red2+1;
				COL_07.setCellStyle(rowCellStyleRed);
			}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("greencolor")){
				green2 = green2+1;
				COL_07.setCellStyle(rowCellStyleGreen);
			}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("yellowcolor")){
				yellow2 = yellow2+1;
				COL_07.setCellStyle(rowCellStyleYellow);
			}else{
				//COL_07.setCellStyle(rowCellStyle);
				green2 = green2+1;
				COL_07.setCellStyle(rowCellStyleGreen);
			}
			COL_07.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()));
			
			HSSFCell COL_08=row.createCell(Columns.COL_07);
			if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("redcolor")){
				red3 = red3+1;
				COL_08.setCellStyle(rowCellStyleRed);
			}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("greencolor")){
				green3 = green3+1;
				COL_08.setCellStyle(rowCellStyleGreen);
			}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("yellowcolor")){
				yellow3 = yellow3+1;
				COL_08.setCellStyle(rowCellStyleYellow);
			}else{
				//COL_08.setCellStyle(rowCellStyle);
				green3 = green3+1;
				COL_08.setCellStyle(rowCellStyleGreen);
			}
			COL_08.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()));
			
			HSSFCell COL_09=row.createCell(Columns.COL_08);
			if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("redcolor")){
				COL_09.setCellStyle(rowCellStyleRed);
				red4 = red4+1;
			}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("greencolor")){
				COL_09.setCellStyle(rowCellStyleGreen);
				green4 = green4+1;
			}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("yellowcolor")){
				yellow4 = yellow4+1;
				COL_09.setCellStyle(rowCellStyleYellow);
			}else{
				//COL_09.setCellStyle(rowCellStyle);
				COL_09.setCellStyle(rowCellStyleGreen);
				green4 = green4+1;
			}
			COL_09.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()));
			
			HSSFCell COL_10=row.createCell(Columns.COL_09);
			if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("redcolor")){
				COL_10.setCellStyle(rowCellStyleRed);
				red5 = red5+1;
			}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("greencolor")){
				green5 = green5+1;
				COL_10.setCellStyle(rowCellStyleGreen);
			}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("yellowcolor")){
				COL_10.setCellStyle(rowCellStyleYellow);
				yellow5 = yellow5+1;
			}else{
				//COL_10.setCellStyle(rowCellStyle); 
				green5 = green5+1;
				COL_10.setCellStyle(rowCellStyleGreen);
			}
			COL_10.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()));
			
			HSSFCell COL_11=row.createCell(Columns.COL_10);
			if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("redcolor")){
				COL_11.setCellStyle(rowCellStyleRed);
				red6 = red6+1;
			}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("greencolor")){
				COL_11.setCellStyle(rowCellStyleGreen);
				green6 = green6+1;
			}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("yellowcolor")){
				yellow6 = yellow6+1;
				COL_11.setCellStyle(rowCellStyleYellow);
			}else{
				//COL_11.setCellStyle(rowCellStyle);
				COL_11.setCellStyle(rowCellStyleGreen);
				green6 = green6+1;
			}
			COL_11.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()));
			
			HSSFCell COL_12=row.createCell(Columns.COL_11);
			if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("redcolor")){
				COL_12.setCellStyle(rowCellStyleRed);
				red7 = red7+1;
			}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("greencolor")){
				COL_12.setCellStyle(rowCellStyleGreen);
				green7 = green7+1;
			}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("yellowcolor")){
				yellow7 = yellow7+1;
				COL_12.setCellStyle(rowCellStyleYellow);
			}else{
				//COL_12.setCellStyle(rowCellStyle);
				COL_12.setCellStyle(rowCellStyleGreen);
				green7 = green7+1;
			}
			COL_12.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_12).toString()));
			
			HSSFCell COL_13=row.createCell(Columns.COL_12);
			if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("redcolor")){
				red8 = red8+1;
				COL_13.setCellStyle(rowCellStyleRed);
			}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("greencolor")){
				COL_13.setCellStyle(rowCellStyleGreen);
				green8 = green8+1;
			}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("yellowcolor")){
				COL_13.setCellStyle(rowCellStyleYellow);
				yellow8 = yellow8+1;
			}else{
				//COL_13.setCellStyle(rowCellStyle);
				COL_13.setCellStyle(rowCellStyleGreen);
				green8 = green8+1;
			}
			COL_13.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_13).toString()));
			
			HSSFCell COL_14=row.createCell(Columns.COL_13);
			if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("redcolor")){
				red9 = red9+1;
				COL_14.setCellStyle(rowCellStyleRed);
			}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("greencolor")){
				green9 = green9+1;
				COL_14.setCellStyle(rowCellStyleGreen);
			}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("yellowcolor")){
				yellow9 = yellow9+1;
				COL_14.setCellStyle(rowCellStyleYellow);
			}else{
				//COL_14.setCellStyle(rowCellStyle);
				green9 = green9+1;
				COL_14.setCellStyle(rowCellStyleGreen);
			}
			COL_14.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_14).toString()));
			
			HSSFCell COL_15=row.createCell(Columns.COL_14);
			if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("redcolor")){
				COL_15.setCellStyle(rowCellStyleRed);
				red10 = red10+1;
			}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("greencolor")){
				green10 = green10+1;
				COL_15.setCellStyle(rowCellStyleGreen);
			}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("yellowcolor")){
				COL_15.setCellStyle(rowCellStyleYellow);
				yellow10 = yellow10+1;
			}else{
				//COL_15.setCellStyle(rowCellStyle);
				green10 = green10+1;
				COL_15.setCellStyle(rowCellStyleGreen);
			}
			COL_15.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_15).toString()));
			
			HSSFCell COL_16=row.createCell(Columns.COL_15);
			COL_16.setCellStyle(rowCellStyle);
			COL_16.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_16).toString()));
			
			HSSFCell COL_17=row.createCell(Columns.COL_16);
			if(map.get(ColumnsOfTable.COL_17_C).toString().equalsIgnoreCase("redcolor")){
				red11 = red11+1;
				COL_17.setCellStyle(rowCellStyleRed);
			}else if(map.get(ColumnsOfTable.COL_17_C).toString().equalsIgnoreCase("greencolor")){
				green11 = green11+1;
				COL_17.setCellStyle(rowCellStyleGreen);
			}else if(map.get(ColumnsOfTable.COL_17_C).toString().equalsIgnoreCase("yellowcolor")){
				yellow11 = yellow11+1;
				COL_17.setCellStyle(rowCellStyleYellow);
			}else{
				//COL_17.setCellStyle(rowCellStyle);
				green11 = green11+1;
				COL_17.setCellStyle(rowCellStyleGreen);
			}
			COL_17.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_17).toString()));
			
			HSSFCell COL_18=row.createCell(Columns.COL_17);
			COL_18.setCellStyle(rowCellStyle);
			COL_18.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_18).toString()));
			
			HSSFCell COL_19=row.createCell(Columns.COL_18);
			COL_19.setCellStyle(rowCellStyle);
			COL_19.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_19).toString()));
			
			HSSFCell COL_20=row.createCell(Columns.COL_19);
			COL_20.setCellStyle(rowCellStyle);
			COL_20.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_20).toString()));
			
			HSSFCell COL_21=row.createCell(Columns.COL_20);
			COL_21.setCellStyle(rowCellStyle);
			COL_21.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_21).toString()));
			
			
//			Code Starts From Here Done By Roshan Lal Tailor Date :- 03/11/2015
//			The Below Code Is Related To The ReelReport.xls Which Maps The Columns And Sets The Data Which In Coming To The Database.
			HSSFCell COL_22=row.createCell(Columns.COL_21);
			COL_22.setCellStyle(rowCellStyle);
			COL_22.setCellValue(CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_22)!=null?map.get(ColumnsOfTable.COL_22).toString():""));
			
			
			HSSFCell COL_23=row.createCell(Columns.COL_22);
			COL_23.setCellStyle(rowCellStyle);
			COL_23.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_23)!=null?map.get(ColumnsOfTable.COL_23).toString():"") );
			
			HSSFCell COL_24=row.createCell(Columns.COL_23);
			COL_24.setCellStyle(rowCellStyle);
			COL_24.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_24)!=null?map.get(ColumnsOfTable.COL_24).toString():"") );
			
			HSSFCell COL_27=row.createCell(Columns.COL_24);
			COL_27.setCellStyle(rowCellStyle);
			COL_27.setCellValue(CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_28)!=null?map.get(ColumnsOfTable.COL_28).toString():"") );
			
			
//			Code Ends Here Done By Roshan Lal Tailor
			HSSFCell COL_25=row.createCell(Columns.COL_25);
			COL_25.setCellStyle(rowCellStyle);
			COL_25.setCellValue(map.get(ColumnsOfTable.COL_25)!=null?map.get(ColumnsOfTable.COL_25).toString():"");
			
			HSSFCell COL_26=row.createCell(Columns.COL_26);
			COL_26.setCellStyle(rowCellStyle);
			COL_26.setCellValue(map.get(ColumnsOfTable.COL_26)!=null?map.get(ColumnsOfTable.COL_26).toString():"");
			
			loopi  = loopi+1;
		}
		
		 
		
		rowCount++;
	}
	
	rowCount++;
	
	
	
	double rPre1=CommonUtil.round((red1*100)/loopi, 2);
	double yPre1=CommonUtil.round((yellow1*100)/loopi, 2);
	double gPre1=CommonUtil.round((green1*100)/loopi, 2);


	double rPre2=CommonUtil.round((red2*100)/loopi, 2);
	double yPre2=CommonUtil.round((yellow2*100)/loopi, 2);
	double gPre2=CommonUtil.round((green2*100)/loopi, 2);

	double rPre3=CommonUtil.round((red3*100)/loopi, 2);
	double yPre3=CommonUtil.round((yellow3*100)/loopi, 2);
	double gPre3=CommonUtil.round((green3*100)/loopi, 2);

	double rPre4=CommonUtil.round((red4*100)/loopi, 2);
	double yPre4=CommonUtil.round((yellow4*100)/loopi, 2);
	double gPre4=CommonUtil.round((green4*100)/loopi, 2);

	double rPre5=CommonUtil.round((red5*100)/loopi, 2);
	double yPre5=CommonUtil.round((yellow5*100)/loopi, 2);
	double gPre5=CommonUtil.round((green5*100)/loopi, 2);

	double rPre6=CommonUtil.round((red6*100)/loopi, 2);
	double yPre6=CommonUtil.round((yellow6*100)/loopi, 2);
	double gPre6=CommonUtil.round((green6*100)/loopi, 2);

	double rPre7=CommonUtil.round((red7*100)/loopi, 2);
	double yPre7=CommonUtil.round((yellow7*100)/loopi, 2);
	double gPre7=CommonUtil.round((green7*100)/loopi, 2);

	double rPre8=CommonUtil.round((red8*100)/loopi, 2);
	double yPre8=CommonUtil.round((yellow8*100)/loopi, 2);
	double gPre8=CommonUtil.round((green8*100)/loopi, 2);

	double rPre9=CommonUtil.round((red9*100)/loopi, 2);
	double yPre9=CommonUtil.round((yellow9*100)/loopi, 2);
	double gPre9=CommonUtil.round((green9*100)/loopi, 2);

	double rPre10=CommonUtil.round((red10*100)/loopi, 2);
	double yPre10=CommonUtil.round((yellow10*100)/loopi, 2);
	double gPre10=CommonUtil.round((green10*100)/loopi, 2);

	double rPre11=CommonUtil.round((red11*100)/loopi, 2);
	double yPre11=CommonUtil.round((yellow11*100)/loopi, 2);
	double gPre11=CommonUtil.round((green11*100)/loopi, 2);
	
	
	HSSFRow row=sheet.createRow(rowCount);
	
	HSSFCell COL_new04=row.createCell(Columns.COL_04);
	COL_new04.setCellStyle(rowCellStyle);
	COL_new04.setCellValue("Red");
	
	HSSFCell COL_new05=row.createCell(Columns.COL_05);
	COL_new05.setCellStyle(rowCellStyle);
	COL_new05.setCellValue(CommonUtil.round(rPre1, 2));
	
	HSSFCell COL_new06=row.createCell(Columns.COL_06);
	COL_new06.setCellStyle(rowCellStyle);
	COL_new06.setCellValue(CommonUtil.round(rPre2, 2));
	
	HSSFCell COL_new07=row.createCell(Columns.COL_07);
	COL_new07.setCellStyle(rowCellStyle);
	COL_new07.setCellValue(CommonUtil.round(rPre3, 2));
	
	HSSFCell COL_new08=row.createCell(Columns.COL_08);
	COL_new08.setCellStyle(rowCellStyle);
	COL_new08.setCellValue(CommonUtil.round(rPre4, 2));
	
	HSSFCell COL_new09=row.createCell(Columns.COL_09);
	COL_new09.setCellStyle(rowCellStyle);
	COL_new09.setCellValue(CommonUtil.round(rPre5, 2));
	
	HSSFCell COL_new10=row.createCell(Columns.COL_10);
	COL_new10.setCellStyle(rowCellStyle);
	COL_new10.setCellValue(CommonUtil.round(rPre6, 2));
	
	HSSFCell COL_new11=row.createCell(Columns.COL_11);
	COL_new11.setCellStyle(rowCellStyle);
	COL_new11.setCellValue(CommonUtil.round(rPre7, 2));
	
	HSSFCell COL_new12=row.createCell(Columns.COL_12);
	COL_new12.setCellStyle(rowCellStyle);
	COL_new12.setCellValue(CommonUtil.round(rPre8, 2));
	
	HSSFCell COL_new13=row.createCell(Columns.COL_13);
	COL_new13.setCellStyle(rowCellStyle);
	COL_new13.setCellValue(CommonUtil.round(rPre9, 2));
	
	HSSFCell COL_new14=row.createCell(Columns.COL_14);
	COL_new14.setCellStyle(rowCellStyle);
	COL_new14.setCellValue(CommonUtil.round(rPre10, 2));
	
	
	HSSFCell COL_new15=row.createCell(Columns.COL_15);
	COL_new15.setCellStyle(rowCellStyle);
	COL_new15.setCellValue(CommonUtil.round(0, 2));
	
	
	HSSFCell COL_new16=row.createCell(Columns.COL_16);
	COL_new16.setCellStyle(rowCellStyle);
	COL_new16.setCellValue(CommonUtil.round(rPre11, 2));
	
	
	
	
	rowCount++;
	
	HSSFRow row1=sheet.createRow(rowCount);
	
	  
	HSSFCell COL_ynew04=row1.createCell(Columns.COL_04);
	COL_ynew04.setCellStyle(rowCellStyle);
	COL_ynew04.setCellValue("Yellow");
	
	HSSFCell COL_ynew05=row1.createCell(Columns.COL_05);
	COL_ynew05.setCellStyle(rowCellStyle);
	COL_ynew05.setCellValue(CommonUtil.round(yPre1, 2));
	
	HSSFCell COL_ynew06=row1.createCell(Columns.COL_06);
	COL_ynew06.setCellStyle(rowCellStyle);
	COL_ynew06.setCellValue(CommonUtil.round(yPre2, 2));
	
	HSSFCell COL_ynew07=row1.createCell(Columns.COL_07);
	COL_ynew07.setCellStyle(rowCellStyle);
	COL_ynew07.setCellValue(CommonUtil.round(yPre3, 2));
	
	HSSFCell COL_ynew08=row1.createCell(Columns.COL_08);
	COL_ynew08.setCellStyle(rowCellStyle);
	COL_ynew08.setCellValue(CommonUtil.round(yPre4, 2));
	
	HSSFCell COL_ynew09=row1.createCell(Columns.COL_09);
	COL_ynew09.setCellStyle(rowCellStyle);
	COL_ynew09.setCellValue(CommonUtil.round(yPre5, 2));
	
	HSSFCell COL_ynew10=row1.createCell(Columns.COL_10);
	COL_ynew10.setCellStyle(rowCellStyle);
	COL_ynew10.setCellValue(CommonUtil.round(yPre6, 2));
	
	HSSFCell COL_ynew11=row1.createCell(Columns.COL_11);
	COL_ynew11.setCellStyle(rowCellStyle);
	COL_ynew11.setCellValue(CommonUtil.round(yPre7, 2));
	
	HSSFCell COL_ynew12=row1.createCell(Columns.COL_12);
	COL_ynew12.setCellStyle(rowCellStyle);
	COL_ynew12.setCellValue(CommonUtil.round(yPre8, 2));
	
	HSSFCell COL_ynew13=row1.createCell(Columns.COL_13);
	COL_ynew13.setCellStyle(rowCellStyle);
	COL_ynew13.setCellValue(CommonUtil.round(yPre9, 2));
	
	HSSFCell COL_ynew14=row1.createCell(Columns.COL_14);
	COL_ynew14.setCellStyle(rowCellStyle);
	COL_ynew14.setCellValue(CommonUtil.round(yPre10, 2));
	
	
	HSSFCell COL_ynew15=row.createCell(Columns.COL_15);
	COL_ynew15.setCellStyle(rowCellStyle);
	COL_ynew15.setCellValue(CommonUtil.round(0, 2));
	
	HSSFCell COL_ynew16=row1.createCell(Columns.COL_16);
	COL_ynew16.setCellStyle(rowCellStyle);
	COL_ynew16.setCellValue(CommonUtil.round(yPre11, 2));
	
	
	
	
	rowCount++;
	
	HSSFRow row2=sheet.createRow(rowCount);
	
	  
	HSSFCell COL_gnew04=row2.createCell(Columns.COL_04);
	COL_gnew04.setCellStyle(rowCellStyle);
	COL_gnew04.setCellValue("Green");
	
	HSSFCell COL_gnew05=row2.createCell(Columns.COL_05);
	COL_gnew05.setCellStyle(rowCellStyle);
	COL_gnew05.setCellValue(CommonUtil.round(gPre1, 2));
	
	HSSFCell COL_gnew06=row2.createCell(Columns.COL_06);
	COL_gnew06.setCellStyle(rowCellStyle);
	COL_gnew06.setCellValue(CommonUtil.round(gPre2, 2));
	
	HSSFCell COL_gnew07=row2.createCell(Columns.COL_07);
	COL_gnew07.setCellStyle(rowCellStyle);
	COL_gnew07.setCellValue(CommonUtil.round(gPre3, 2));
	
	HSSFCell COL_gnew08=row2.createCell(Columns.COL_08);
	COL_gnew08.setCellStyle(rowCellStyle);
	COL_gnew08.setCellValue(CommonUtil.round(gPre4, 2));
	
	HSSFCell COL_gnew09=row2.createCell(Columns.COL_09);
	COL_gnew09.setCellStyle(rowCellStyle);
	COL_gnew09.setCellValue(CommonUtil.round(gPre5, 2));
	
	HSSFCell COL_gnew10=row2.createCell(Columns.COL_10);
	COL_gnew10.setCellStyle(rowCellStyle);
	COL_gnew10.setCellValue(CommonUtil.round(gPre6, 2));
	
	HSSFCell COL_gnew11=row2.createCell(Columns.COL_11);
	COL_gnew11.setCellStyle(rowCellStyle);
	COL_gnew11.setCellValue(CommonUtil.round(gPre7, 2));
	
	HSSFCell COL_gnew12=row2.createCell(Columns.COL_12);
	COL_gnew12.setCellStyle(rowCellStyle);
	COL_gnew12.setCellValue(CommonUtil.round(gPre8, 2));
	
	HSSFCell COL_gnew13=row2.createCell(Columns.COL_13);
	COL_gnew13.setCellStyle(rowCellStyle);
	COL_gnew13.setCellValue(CommonUtil.round(gPre9, 2));
	
	HSSFCell COL_gnew14=row2.createCell(Columns.COL_14);
	COL_gnew14.setCellStyle(rowCellStyle);
	COL_gnew14.setCellValue(CommonUtil.round(gPre10, 2));
	
	HSSFCell COL_gnew15=row.createCell(Columns.COL_15);
	COL_gnew15.setCellStyle(rowCellStyle);
	COL_gnew15.setCellValue(CommonUtil.round(0, 2));
	
	
	HSSFCell COL_gnew16=row2.createCell(Columns.COL_16);
	COL_gnew16.setCellStyle(rowCellStyle);
	COL_gnew16.setCellValue(CommonUtil.round(gPre11, 2));
	
	
	 
	
	
	
	return workbook;
}

}
