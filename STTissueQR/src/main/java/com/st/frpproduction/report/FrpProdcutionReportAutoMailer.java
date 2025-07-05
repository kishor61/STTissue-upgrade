/**
 *May 3, 2016
 *FrpProdcutionReportAutoMailer.java
 * TODO
 *com.st.frpproduction.report
 *FrpProdcutionReportAutoMailer.java
 *Sunil Singh Bora
 */
package com.st.frpproduction.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletContext;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
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

import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.common.Rows;
import com.st.frpproduction.model.FrpProdcution;
import com.st.frpproduction.service.FrpProdcutionService;
import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.service.WastePaperUnloadBaleInventoryService;

/**
 * @author roshan
 *
 */
@Component
public class FrpProdcutionReportAutoMailer {


	private static final Logger logger = LoggerFactory.getLogger(ProductionReportAutoMailer.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
	private SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyy-MM-dd");
	
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat2=new SimpleDateFormat("EEE");

	@Autowired
	private ServletContext context;
	
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private FrpProdcutionService frpProdcutionService;
	
	@Autowired
	private WastePaperUnloadBaleInventoryService  wastePaperUnloadBaleInventoryService;
	
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
	 * @param sdate
	 * @param edate
	 * @param prodType
	 * @param grade
	 * @throws Exception 
	 */
	public void sendMailAt8am(String sdate, String edate, String prodType,String grade) throws Exception {
		String folder=System.getProperty("catalina.base")+"/FRP Production_Roshan";
		File folderFile=new File(folder);
		if(!folderFile.exists()){
			folderFile.mkdirs();
		}
		final File xlsfile=new File(folder,"FRP Production-Report"+".xls");
		prepareFRPReportExcelReport(xlsfile,sdate,edate,prodType,grade);
		mailSender.send(new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(emailTofrpoperatorentry.split(";"));
				messageHelper.setFrom(emailFrom,emailFromName);
				messageHelper.setBcc(emailBcc.split(";"));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				
				messageHelper.setSubject(dateTimeFormat4.format(cal.getTime())+"-FRP Production-Report");
				
				messageHelper.setText(getMessage(), true);
				if(xlsfile.exists()){
					messageHelper.addAttachment(dateTimeFormat4.format(cal.getTime())+"-FRP Production-Report.xls", new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(xlsfile))));
				}
				logger.info("ST Tissue FRP-MTD Daily Production Report mail is sent");
			}

			private String getMessage() {
				StringBuilder builder=new StringBuilder();
				builder.append("Hello Sir,<br/><br/>");
				builder.append("Please find the attached <b>\"ST Tissue FRP Production-Report \"</b> for your review.<br/>");
				builder.append("<br/>Thank you,<br/>");
				builder.append("Jaipur<br/><p style='font-size: 12px;'>*** This is an automatically system generated email at:"+dateTimeFormat.format(new Date())+" ***</p>");
				
				return builder.toString();
			}});
		
		// TODO Auto-generated method stub
		
	}
	/**
	 * @param xlsfile
	 * @param sdate
	 * @param edate
	 * @param prodType
	 * @param grade
	 * @throws Exception 
	 */
	private void prepareFRPReportExcelReport(File xlsfile, String sdate,
			String edate, String prodType, String grade) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> datas=new HashMap<>();
		
		List<FrpProdcution> frpProdcutions=frpProdcutionService.getFrpProdcutions(dateFormat1.parse(sdate), dateFormat1.parse(edate), prodType,grade);
		List<WastePaperBaleInventory> consumedBalesData=wastePaperUnloadBaleInventoryService.getConsumedData(dateFormat1.parse(sdate), dateFormat1.parse(edate));
		datas=formatData(frpProdcutions,consumedBalesData,prodType);

		
		File file=new File(context.getRealPath("/")+"WEB-INF/FrpProduction Report.xls");

		try {
			HSSFWorkbook workbook=getFormatedWorkbook(file,datas,prodType);
			
			
			FileOutputStream outputStream=new FileOutputStream(xlsfile);
			workbook.write(outputStream);
			outputStream.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param file
	 * @param datas
	 * @param prodType
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	private HSSFWorkbook getFormatedWorkbook(File file,
			Map<String, Object> datas, String prodType) throws IOException {
		
		List<Integer> ids=(List<Integer>) datas.get(Rows.ROW_01);
		List<String> dates=(List<String>) datas.get(Rows.ROW_02);
		List<String> days=(List<String>) datas.get(Rows.ROW_03);
		List<Double> hdStorages =(List<Double>) datas.get(Rows.ROW_04);
		List<Double> dcsWPFeedADSTs =(List<Double>) datas.get(Rows.ROW_05);
		List<Double> primaryPressADSTs =(List<Double>) datas.get(Rows.ROW_06);
		List<Double> wetLapProdADSTs =(List<Double>) datas.get(Rows.ROW_07);
		List<Double> totalProdADSTs =(List<Double>) datas.get(Rows.ROW_08);
		List<Double> trackerWPfeeds =(List<Double>) datas.get(Rows.ROW_09);
		
		List<Double> yieldDcss =(List<Double>) datas.get(Rows.ROW_10);
		List<Double> yieldTrackers =(List<Double>) datas.get(Rows.ROW_11);
		List<Double> freshWaters =(List<Double>) datas.get(Rows.ROW_12);
		
		List<Double> mrMwlAndSwls =(List<Double>) datas.get(Rows.ROW_13);
		List<Double> mrSowAndCbss =(List<Double>) datas.get(Rows.ROW_14);
		List<Double> mrDlks =(List<Double>) datas.get(Rows.ROW_15);
		List<Double> mrOccs =(List<Double>) datas.get(Rows.ROW_16);
		List<Double> mrWhiteGradess =(List<Double>) datas.get(Rows.ROW_17);
		List<Double> mrGroundwoods =(List<Double>) datas.get(Rows.ROW_18);
		List<Double> mrOthers =(List<Double>) datas.get(Rows.ROW_19);
		
		List<Double> wpmMwls =(List<Double>) datas.get(Rows.ROW_20);
		List<Double> wpmPrintMixs =(List<Double>) datas.get(Rows.ROW_21);
		List<Double> wpmSows =(List<Double>) datas.get(Rows.ROW_22);
		List<Double> wpmCbss =(List<Double>) datas.get(Rows.ROW_23);
		List<Double> wpmSowAndCbss =(List<Double>) datas.get(Rows.ROW_24);
		List<Double> wpmCtdGrwds =(List<Double>) datas.get(Rows.ROW_25);
		List<Double> wpmSwls =(List<Double>) datas.get(Rows.ROW_26);
		List<Double> wpmOccs =(List<Double>) datas.get(Rows.ROW_27);
		List<Double> wpmNewsNewsblanks =(List<Double>) datas.get(Rows.ROW_28);
		List<Double> wpmDlks =(List<Double>) datas.get(Rows.ROW_29);
		List<Double> wpmOthers =(List<Double>) datas.get(Rows.ROW_30);
		List<Double> wpmTotals =(List<Double>) datas.get(Rows.ROW_31);
		
		List<String> targetBrightnesss =(List<String>) datas.get(Rows.ROW_32);
		List<Double> dailyAvgs =(List<Double>) datas.get(Rows.ROW_33);
		List<String> pmTargetBrites =(List<String>) datas.get(Rows.ROW_34);
		List<String> pmAvgBrites =(List<String>) datas.get(Rows.ROW_35);
		List<String> comments =(List<String>) datas.get(Rows.ROW_36);
		
		List<Double> wpmMailUndeliverables =(List<Double>) datas.get(Rows.ROW_46);
		List<String> grades =(List<String>) datas.get(Rows.ROW_48);
		
		List<Double> freshWaters2 =(List<Double>) datas.get(Rows.ROW_49);
		
		FileInputStream inputStream=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);

		HSSFSheet sheet=workbook.getSheetAt(0);
		
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
		
		int len=ids.size();
		HSSFRow row=sheet.getRow(1);
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=row.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(dates.get(i-1));
		}
		
		HSSFRow row2=sheet.getRow(2);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row2.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(days.get(i-1));
		}
		
		
		HSSFRow row3=sheet.getRow(3);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row3.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(grades.get(i-1));
		}
		
		HSSFRow row4=sheet.getRow(4);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row4.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(hdStorages.get(i-1));
		}
		
		HSSFRow row5=sheet.getRow(5);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row5.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(dcsWPFeedADSTs.get(i-1));
		}
		
		HSSFRow row6=sheet.getRow(6);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row6.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(primaryPressADSTs.get(i-1));
		}
		
		HSSFRow row7=sheet.getRow(7);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row7.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wetLapProdADSTs.get(i-1));
		}
		
		HSSFRow row8=sheet.getRow(8);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row8.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(totalProdADSTs.get(i-1));
		}
		
		HSSFRow row9=sheet.getRow(9);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row9.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(trackerWPfeeds.get(i-1));
		}
		
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(10).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		
		HSSFRow row11=sheet.getRow(11);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row11.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(yieldDcss.get(i-1)+"%");
		}
		
		HSSFRow row12=sheet.getRow(12);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row12.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(yieldTrackers.get(i-1)+"%");
		}
		
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(13).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
		}
		
		HSSFRow row14=sheet.getRow(14);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row14.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(freshWaters.get(i-1));
		}
		
		HSSFRow row15=sheet.getRow(15);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row15.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(freshWaters2.get(i-1));
		}
		
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(16).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(17).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		
		HSSFRow row18=sheet.getRow(18);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row18.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(mrMwlAndSwls.get(i-1)+"%");
		}
		
		HSSFRow row19=sheet.getRow(19);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row19.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(mrSowAndCbss.get(i-1)+"%");
		}
		
		HSSFRow row20=sheet.getRow(20);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row20.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(mrWhiteGradess.get(i-1)+"%");
		}
		
		HSSFRow row21=sheet.getRow(21);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row21.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(mrGroundwoods.get(i-1)+"%");
		}
		
		HSSFRow row22=sheet.getRow(22);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row22.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(mrDlks.get(i-1)+"%");
		}
		
		HSSFRow row23=sheet.getRow(23);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row23.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(mrOccs.get(i-1)+"%");
		}
		
		HSSFRow row24=sheet.getRow(24);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row24.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(mrOthers.get(i-1)+"%");
		}
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(25).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(26).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		
		
		HSSFRow row27=sheet.getRow(27);
		for(int i=1;i<=len;i++){
			if(i==1){
				HSSFCell hssfCell=row27.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue(datas.get(Rows.ROW_37)+"%");
			}else{
				HSSFCell hssfCell=row27.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue("");
			}
		}
		
		HSSFRow row28=sheet.getRow(28);
		for(int i=1;i<=len;i++){
			if(i==1){
				HSSFCell hssfCell=row28.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue(datas.get(Rows.ROW_38)+"%");
			}else{
				HSSFCell hssfCell=row28.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue("");
			}
		}
		
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(29).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(30).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		
		
		HSSFRow row31=sheet.getRow(31);
		for(int i=1;i<=len;i++){
			if(i==1){
				HSSFCell hssfCell=row31.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue(datas.get(Rows.ROW_39)+"%");
			}else{
				HSSFCell hssfCell=row31.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue("");
			}
		}
		
		HSSFRow row32=sheet.getRow(32);
		for(int i=1;i<=len;i++){
			if(i==1){
				HSSFCell hssfCell=row32.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue(datas.get(Rows.ROW_40)+"%");
			}else{
				HSSFCell hssfCell=row32.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue("");
			}
		}
		
		HSSFRow row33=sheet.getRow(33);
		for(int i=1;i<=len;i++){
			if(i==1){
				HSSFCell hssfCell=row33.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue(datas.get(Rows.ROW_41)+"%");
			}else{
				HSSFCell hssfCell=row33.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue("");
			}
		}
		
		HSSFRow row34=sheet.getRow(34);
		for(int i=1;i<=len;i++){
			if(i==1){
				HSSFCell hssfCell=row34.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue(datas.get(Rows.ROW_42)+"%");
			}else{
				HSSFCell hssfCell=row34.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue("");
			}
		}
		
		HSSFRow row35=sheet.getRow(35);
		for(int i=1;i<=len;i++){
			if(i==1){
				HSSFCell hssfCell=row35.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue(datas.get(Rows.ROW_43)+"%");
			}else{
				HSSFCell hssfCell=row35.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue("");
			}
		}
		
		HSSFRow row36=sheet.getRow(36);
		for(int i=1;i<=len;i++){
			if(i==1){
				HSSFCell hssfCell=row36.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue(datas.get(Rows.ROW_44)+"%");
			}else{
				HSSFCell hssfCell=row36.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue("");
			}
		}
		
		
		HSSFRow row37=sheet.getRow(37);
		for(int i=1;i<=len;i++){
			if(i==1){
				HSSFCell hssfCell=row37.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue(datas.get(Rows.ROW_47)+"%");
			}else{
				HSSFCell hssfCell=row37.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue("");
			}
		}
		
		
		
		HSSFRow row38=sheet.getRow(38);
		for(int i=1;i<=len;i++){
			if(i==1){
				HSSFCell hssfCell=row38.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue(datas.get(Rows.ROW_45)+"%");
			}else{
				HSSFCell hssfCell=row38.createCell(i);
				hssfCell.setCellStyle(rowCellStyle);
				hssfCell.setCellValue("");
			}
		}
		
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(39).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(40).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		
		HSSFRow row41=sheet.getRow(41);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row41.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmMwls.get(i-1));
		}
		
		HSSFRow row42=sheet.getRow(42);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row42.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmPrintMixs.get(i-1));
		}
		
		HSSFRow row43=sheet.getRow(43);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row43.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmCbss.get(i-1));
		}
		
		HSSFRow row44=sheet.getRow(44);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row44.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmSows.get(i-1));
		}

		HSSFRow row45=sheet.getRow(45);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row45.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmSowAndCbss.get(i-1));
		}
		
		HSSFRow row46=sheet.getRow(46);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row46.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmSwls.get(i-1));
		}
		
		HSSFRow row47=sheet.getRow(47);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row47.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmCtdGrwds.get(i-1));
		}
		
		HSSFRow row48=sheet.getRow(48);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row48.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmOccs.get(i-1));
		}
		
		HSSFRow row49=sheet.getRow(49);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row49.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmNewsNewsblanks.get(i-1));
		}

		HSSFRow row50=sheet.getRow(50);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row50.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmDlks.get(i-1));
		}
		
		HSSFRow row51=sheet.getRow(51);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row51.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmMailUndeliverables.get(i-1));
		}
		
		
		
		HSSFRow row52=sheet.getRow(52);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row52.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmOthers.get(i-1));
		}
		
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(53).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		
		HSSFRow row54=sheet.getRow(54);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row54.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(wpmTotals.get(i-1));
		}
		
		
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(55).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		
		HSSFRow row56=sheet.getRow(56);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row56.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(targetBrightnesss.get(i-1));
		}
		
		HSSFRow row57=sheet.getRow(57);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row57.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(dailyAvgs.get(i-1));
		}
		
		HSSFRow row58=sheet.getRow(58);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row58.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(pmTargetBrites.get(i-1));
		}
		
		HSSFRow row59=sheet.getRow(59);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row59.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(pmAvgBrites.get(i-1));
		}
		
		for(int i=1;i<=len;i++){
			HSSFCell hssfCell=sheet.getRow(60).createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue("");
			
		}
		
		HSSFRow row61=sheet.getRow(61);
		for(int i=1;i<=len;i++){
			
			HSSFCell hssfCell=row61.createCell(i+1);
			hssfCell.setCellStyle(rowCellStyle);
			hssfCell.setCellValue(comments.get(i-1));
		}
		
		
		return workbook;
	}
	/**
	 * @param frpProdcutions
	 * @param consumedBalesData
	 * @param prodType
	 * @return
	 */
	private Map<String, Object> formatData(List<FrpProdcution> frpProdcutions,
			List<WastePaperBaleInventory> consumedBalesData, String prodType) {
		
		List<Integer> ids=new ArrayList<>();
		List<String> dates=new ArrayList<>();
		List<String> days=new ArrayList<>();
		List<Double> hdStorages =new ArrayList<>();
		List<Double> dcsWPFeedADSTs =new ArrayList<>();
		List<Double> primaryPressADSTs =new ArrayList<>();
		List<Double> wetLapProdADSTs =new ArrayList<>();
		List<Double> totalProdADSTs =new ArrayList<>();
		List<Double> trackerWPfeeds =new ArrayList<>();
		List<Double> yieldDcss =new ArrayList<>();
		List<Double> yieldTrackers =new ArrayList<>();
		List<Double> freshWaters =new ArrayList<>();
		List<Double> mrMwlAndSwls =new ArrayList<>();
		List<Double> mrSowAndCbss =new ArrayList<>();
		List<Double> mrDlks =new ArrayList<>();
		List<Double> mrOccs =new ArrayList<>();
		List<Double> mrWhiteGradess =new ArrayList<>();
		List<Double> mrGroundwoods =new ArrayList<>();
		List<Double> mrOthers =new ArrayList<>();
		List<Double> wpmMwls =new ArrayList<>();
		List<Double> wpmPrintMixs =new ArrayList<>();
		List<Double> wpmSows =new ArrayList<>();
		List<Double> wpmCbss =new ArrayList<>();
		List<Double> wpmSowAndCbss =new ArrayList<>();
		List<Double> wpmCtdGrwds =new ArrayList<>();
		List<Double> wpmSwls =new ArrayList<>();
		List<Double> wpmOccs =new ArrayList<>();
		List<Double> wpmNewsNewsblanks =new ArrayList<>();
		List<Double> wpmDlks =new ArrayList<>();
		List<Double> wpmOthers =new ArrayList<>();
		
		List<Double> wpmMailUndeliverable =new ArrayList<>();
		List<Double> freshWaters2 =new ArrayList<>();
		
		List<Double> wpmTotals =new ArrayList<>();
		List<String> targetBrightnesss =new ArrayList<>();
		List<Double> dailyAvgs =new ArrayList<>();
		List<String> pmTargetBrites =new ArrayList<>();
		List<String> pmAvgBrites =new ArrayList<>();
		List<String> comments =new ArrayList<>();
		List<String> grades =new ArrayList<>();
	

		//Code Starts From Here Done By Roshan
		
		//Code Ends Here Done By Roshan Tailor
		
		
		
		
		for (FrpProdcution frpProdcution : frpProdcutions) {
			
			ids.add(frpProdcution.getId());
			dates.add(dateFormat1.format(frpProdcution.getDate()));
			days.add(dateFormat2.format(frpProdcution.getDate()));
			
			//hdStorages.add(frpProdcution.getHdStorage());
			hdStorages.add(frpProdcution.getCol11());
			//dcsWPFeedADSTs.add(frpProdcution.getDcsWPFeedADST());
			dcsWPFeedADSTs.add(CommonUtil.round(frpProdcution.getCol9(), 2));
			//primaryPressADSTs.add(frpProdcution.getPrimaryPressADST());
			primaryPressADSTs.add(CommonUtil.round(frpProdcution.getCol6(), 2));
			//wetLapProdADSTs.add(frpProdcution.getWetLapProdADST());
			wetLapProdADSTs.add(CommonUtil.round(frpProdcution.getCol7(), 2));
			//totalProdADSTs.add(frpProdcution.getTotalProdADST());
			totalProdADSTs.add(CommonUtil.round(frpProdcution.getCol6(), 2)+CommonUtil.round(frpProdcution.getCol7(), 2));
			
			//trackerWPfeeds.add(frpProdcution.getTrackerWPfeed()); // Commented By Roshan These Values Now Are Coming From Tracker So Use Them In  Below Loop
			
			//yieldDcss.add(frpProdcution.getYieldDcs());
			yieldDcss.add(CommonUtil.round(((CommonUtil.round(frpProdcution.getCol6(), 2)+CommonUtil.round(frpProdcution.getCol7(), 2))/(CommonUtil.round(frpProdcution.getCol9(), 2)))*100, 2));
			
			//yieldTrackers.add(frpProdcution.getYieldTracker());
			
			//freshWaters.add(frpProdcution.getFreshWater());`
			freshWaters.add(CommonUtil.round(frpProdcution.getCol3(), 2));
			
			/*
			 Commented By Roshan These Values Now Are Coming From Tracker So Use Them In  Below Loop
			 * mrMwlAndSwls.add(frpProdcution.getMrMwlAndSwl());
			mrSowAndCbss.add(frpProdcution.getMrSowAndCbs());
			mrDlks.add(frpProdcution.getMrDlk());
			mrOccs.add(frpProdcution.getMrOcc());
			mrWhiteGradess.add(frpProdcution.getMrWhiteGrades());
			mrGroundwoods.add(frpProdcution.getMrGroundwood());
			mrOthers.add(frpProdcution.getMrOther());*/
			//wpmMwls.add(frpProdcution.getWpmMwl());
			//wpmPrintMixs.add(frpProdcution.getWpmPrintMix());
			//wpmSows.add(frpProdcution.getWpmSow());
			//wpmCbss.add(frpProdcution.getWpmCbs());
			//wpmSowAndCbss.add(frpProdcution.getWpmSowAndCbs());
			//wpmCtdGrwds.add(frpProdcution.getWpmCtdGrwd());
			//wpmSwls.add(frpProdcution.getWpmSwl());
			//wpmOccs.add(frpProdcution.getWpmOcc());
			//wpmNewsNewsblanks.add(frpProdcution.getWpmNewsNewsblank());
			//wpmDlks.add(frpProdcution.getWpmDlk());
			//wpmOthers.add(frpProdcution.getWpmOther());
			//wpmTotals.add(frpProdcution.getWpmTotal());
			targetBrightnesss.add(frpProdcution.getTargetBrightness());
			dailyAvgs.add(frpProdcution.getDailyAvg());
			pmTargetBrites.add(frpProdcution.getPmTargetBrite());
			pmAvgBrites.add(frpProdcution.getPmAvgBrite());
			comments.add(frpProdcution.getComments());
			
			//wpmMailUndeliverable.add(frpProdcution.getWpMailUndeliverable());
			//freshWaters2.add(frpProdcution.getFreshWater2());
			freshWaters2.add(CommonUtil.round(frpProdcution.getCol4(), 2));
			
			grades.add(CommonUtil.checkNull(FrpCommon.getProductionGradeType().get(frpProdcution.getGrade())));
		}
		
		for(WastePaperBaleInventory consumedBales:consumedBalesData){
			
			wpmMwls.add(CommonUtil.round(consumedBales.getTotalbalesweightForMWL(), 2));
			wpmPrintMixs.add(CommonUtil.round(consumedBales.getTotalbalesweightForPrtmix(), 2));
			wpmCbss.add(CommonUtil.round(consumedBales.getTotalbalesweightForCBS(), 2));
			wpmSows.add(CommonUtil.round(consumedBales.getTotalbalesweightForSOW(), 2));
			wpmSowAndCbss.add(CommonUtil.round(consumedBales.getTotalbalesweightForSOW()+consumedBales.getTotalbalesweightForCBS(), 2));
			wpmSwls.add(CommonUtil.round(consumedBales.getTotalbalesweightForSWL(), 2));
			wpmCtdGrwds.add(CommonUtil.round(consumedBales.getTotalbalesweightForCtdGdwd(), 2));
			wpmOccs.add(CommonUtil.round(consumedBales.getTotalbalesweightForOCC(), 2));
			wpmNewsNewsblanks.add(CommonUtil.round(consumedBales.getTotalbalesweightForNewsblank()+consumedBales.getTotalbalesweightForONPOldNewsPrint(), 2));
			wpmDlks.add(CommonUtil.round(consumedBales.getTotalbalesweightForDLK(), 2));
			wpmMailUndeliverable.add(CommonUtil.round(consumedBales.getTotalbalesweightForMailUndeliverable(), 2));
			
			wpmOthers.add(CommonUtil.round(consumedBales.getTotalbalesweightForOtherRolls()+consumedBales.getTotalbalesweightForMixedPaper()+
					consumedBales.getTotalbalesweightForHoggedBooks()+consumedBales.getTotalbalesweightForBrownNapkinBroke(), 2));
			
			
			wpmTotals.add(CommonUtil.round(consumedBales.getTotalbalesweightForMWL()+consumedBales.getTotalbalesweightForPrtmix()+consumedBales.getTotalbalesweightForCBS()+
					consumedBales.getTotalbalesweightForSOW()+consumedBales.getTotalbalesweightForSWL()+consumedBales.getTotalbalesweightForCtdGdwd()+
					consumedBales.getTotalbalesweightForOCC()+consumedBales.getTotalbalesweightForNewsblank()+consumedBales.getTotalbalesweightForONPOldNewsPrint()+
					consumedBales.getTotalbalesweightForDLK()+consumedBales.getTotalbalesweightForMailUndeliverable()+consumedBales.getTotalbalesweightForOtherRolls()+
					consumedBales.getTotalbalesweightForMixedPaper()+consumedBales.getTotalbalesweightForHoggedBooks()+consumedBales.getTotalbalesweightForBrownNapkinBroke(), 2));
			//mrMwlAndSwls.add(frpProdcution.getMrMwlAndSwl());
				mrMwlAndSwls.add(CommonUtil.round((CommonUtil.round(consumedBales.getTotalbalesweightForMWL(), 2)+
						CommonUtil.round(consumedBales.getTotalbalesweightForSWL(), 2))/
						CommonUtil.round(consumedBales.getTotalbalesweightForMWL()+consumedBales.getTotalbalesweightForPrtmix()+consumedBales.getTotalbalesweightForCBS()+
								consumedBales.getTotalbalesweightForSOW()+consumedBales.getTotalbalesweightForSWL()+consumedBales.getTotalbalesweightForCtdGdwd()+
								consumedBales.getTotalbalesweightForOCC()+consumedBales.getTotalbalesweightForNewsblank()+consumedBales.getTotalbalesweightForONPOldNewsPrint()+
								consumedBales.getTotalbalesweightForDLK()+consumedBales.getTotalbalesweightForMailUndeliverable()+consumedBales.getTotalbalesweightForOtherRolls()+
								consumedBales.getTotalbalesweightForMixedPaper()+consumedBales.getTotalbalesweightForHoggedBooks()+consumedBales.getTotalbalesweightForBrownNapkinBroke(), 2)*100, 2));
			//mrSowAndCbss.add(frpProdcution.getMrSowAndCbs());
				mrSowAndCbss.add(CommonUtil.round((CommonUtil.round(consumedBales.getTotalbalesweightForPrtmix(), 2)+
								 CommonUtil.round(consumedBales.getTotalbalesweightForCBS(), 2)+
								 CommonUtil.round(consumedBales.getTotalbalesweightForCtdGdwd(), 2)+
								 CommonUtil.round(consumedBales.getTotalbalesweightForSOW(), 2))/
								 CommonUtil.round(consumedBales.getTotalbalesweightForMWL()+consumedBales.getTotalbalesweightForPrtmix()+consumedBales.getTotalbalesweightForCBS()+
											consumedBales.getTotalbalesweightForSOW()+consumedBales.getTotalbalesweightForSWL()+consumedBales.getTotalbalesweightForCtdGdwd()+
											consumedBales.getTotalbalesweightForOCC()+consumedBales.getTotalbalesweightForNewsblank()+consumedBales.getTotalbalesweightForONPOldNewsPrint()+
											consumedBales.getTotalbalesweightForDLK()+consumedBales.getTotalbalesweightForMailUndeliverable()+consumedBales.getTotalbalesweightForOtherRolls()+
											consumedBales.getTotalbalesweightForMixedPaper()+consumedBales.getTotalbalesweightForHoggedBooks()+consumedBales.getTotalbalesweightForBrownNapkinBroke(), 2)*100, 2));	
			//mrDlks.add(frpProdcution.getMrDlk());
				mrDlks.add(CommonUtil.round(CommonUtil.round(consumedBales.getTotalbalesweightForDLK(), 2)/CommonUtil.round(consumedBales.getTotalbalesweightForMWL()+consumedBales.getTotalbalesweightForPrtmix()+consumedBales.getTotalbalesweightForCBS()+
						consumedBales.getTotalbalesweightForSOW()+consumedBales.getTotalbalesweightForSWL()+consumedBales.getTotalbalesweightForCtdGdwd()+
						consumedBales.getTotalbalesweightForOCC()+consumedBales.getTotalbalesweightForNewsblank()+consumedBales.getTotalbalesweightForONPOldNewsPrint()+
						consumedBales.getTotalbalesweightForDLK()+consumedBales.getTotalbalesweightForMailUndeliverable()+consumedBales.getTotalbalesweightForOtherRolls()+
						consumedBales.getTotalbalesweightForMixedPaper()+consumedBales.getTotalbalesweightForHoggedBooks()+consumedBales.getTotalbalesweightForBrownNapkinBroke(), 2)*100, 2));
			//mrOccs.add(frpProdcution.getMrOcc());
				mrOccs.add(CommonUtil.round(CommonUtil.round(consumedBales.getTotalbalesweightForOCC(), 2)/CommonUtil.round(consumedBales.getTotalbalesweightForMWL()+consumedBales.getTotalbalesweightForPrtmix()+consumedBales.getTotalbalesweightForCBS()+
						consumedBales.getTotalbalesweightForSOW()+consumedBales.getTotalbalesweightForSWL()+consumedBales.getTotalbalesweightForCtdGdwd()+
						consumedBales.getTotalbalesweightForOCC()+consumedBales.getTotalbalesweightForNewsblank()+consumedBales.getTotalbalesweightForONPOldNewsPrint()+
						consumedBales.getTotalbalesweightForDLK()+consumedBales.getTotalbalesweightForMailUndeliverable()+consumedBales.getTotalbalesweightForOtherRolls()+
						consumedBales.getTotalbalesweightForMixedPaper()+consumedBales.getTotalbalesweightForHoggedBooks()+consumedBales.getTotalbalesweightForBrownNapkinBroke(), 2)*100, 2));
			//mrWhiteGradess.add(frpProdcution.getMrWhiteGrades());
				//var mrWhiteGradesNum=((wpmMwlNum+wpmPrintMixNum+wpmSwlNum+wpmSowAndCbsNum)/wpmTotalNum)*100;
				mrWhiteGradess.add(CommonUtil.round((CommonUtil.round(consumedBales.getTotalbalesweightForMWL(), 2)+
								  CommonUtil.round(consumedBales.getTotalbalesweightForPrtmix(), 2)+
								  CommonUtil.round(consumedBales.getTotalbalesweightForSWL(), 2)+
								  CommonUtil.round(consumedBales.getTotalbalesweightForSOW()+consumedBales.getTotalbalesweightForCBS(), 2))/
								  CommonUtil.round(consumedBales.getTotalbalesweightForMWL()+consumedBales.getTotalbalesweightForPrtmix()+consumedBales.getTotalbalesweightForCBS()+
											consumedBales.getTotalbalesweightForSOW()+consumedBales.getTotalbalesweightForSWL()+consumedBales.getTotalbalesweightForCtdGdwd()+
											consumedBales.getTotalbalesweightForOCC()+consumedBales.getTotalbalesweightForNewsblank()+consumedBales.getTotalbalesweightForONPOldNewsPrint()+
											consumedBales.getTotalbalesweightForDLK()+consumedBales.getTotalbalesweightForMailUndeliverable()+consumedBales.getTotalbalesweightForOtherRolls()+
											consumedBales.getTotalbalesweightForMixedPaper()+consumedBales.getTotalbalesweightForHoggedBooks()+consumedBales.getTotalbalesweightForBrownNapkinBroke(), 2), 2));
			//mrGroundwoods.add(frpProdcution.getMrGroundwood());
				mrGroundwoods.add(CommonUtil.round((CommonUtil.round(consumedBales.getTotalbalesweightForNewsblank()+consumedBales.getTotalbalesweightForONPOldNewsPrint(), 2)+
								  CommonUtil.round(consumedBales.getTotalbalesweightForCtdGdwd(), 2))/
								  CommonUtil.round(consumedBales.getTotalbalesweightForMWL()+consumedBales.getTotalbalesweightForPrtmix()+consumedBales.getTotalbalesweightForCBS()+
											consumedBales.getTotalbalesweightForSOW()+consumedBales.getTotalbalesweightForSWL()+consumedBales.getTotalbalesweightForCtdGdwd()+
											consumedBales.getTotalbalesweightForOCC()+consumedBales.getTotalbalesweightForNewsblank()+consumedBales.getTotalbalesweightForONPOldNewsPrint()+
											consumedBales.getTotalbalesweightForDLK()+consumedBales.getTotalbalesweightForMailUndeliverable()+consumedBales.getTotalbalesweightForOtherRolls()+
											consumedBales.getTotalbalesweightForMixedPaper()+consumedBales.getTotalbalesweightForHoggedBooks()+consumedBales.getTotalbalesweightForBrownNapkinBroke(), 2)*100, 2));
			//mrOthers.add(frpProdcution.getMrOther());
				//var mrOtherNum=(wpmOtherNum/wpmTotalNum)*100;
				mrOthers.add(CommonUtil.round(CommonUtil.round(consumedBales.getTotalbalesweightForOtherRolls()+consumedBales.getTotalbalesweightForMixedPaper()+
								consumedBales.getTotalbalesweightForHoggedBooks()+consumedBales.getTotalbalesweightForBrownNapkinBroke(), 2)/
								CommonUtil.round(consumedBales.getTotalbalesweightForMWL()+consumedBales.getTotalbalesweightForPrtmix()+consumedBales.getTotalbalesweightForCBS()+
										consumedBales.getTotalbalesweightForSOW()+consumedBales.getTotalbalesweightForSWL()+consumedBales.getTotalbalesweightForCtdGdwd()+
										consumedBales.getTotalbalesweightForOCC()+consumedBales.getTotalbalesweightForNewsblank()+consumedBales.getTotalbalesweightForONPOldNewsPrint()+
										consumedBales.getTotalbalesweightForDLK()+consumedBales.getTotalbalesweightForMailUndeliverable()+consumedBales.getTotalbalesweightForOtherRolls()+
										consumedBales.getTotalbalesweightForMixedPaper()+consumedBales.getTotalbalesweightForHoggedBooks()+consumedBales.getTotalbalesweightForBrownNapkinBroke(), 2)*100, 2));
			
			//trackerWPfeeds.add(frpProdcution.getTrackerWPfeed());
				int i=consumedBales.getTotalbales();
				double takerWPFeedAs_ToatlBalesConsumedInADay = (double) i; 
				trackerWPfeeds.add(takerWPFeedAs_ToatlBalesConsumedInADay);	
		}
		for (int i = 0; i < frpProdcutions.size(); i++) {
			FrpProdcution frpProdcution=frpProdcutions.get(i);
			WastePaperBaleInventory consumedBales=consumedBalesData.get(i);
		
			double totalProdADST=CommonUtil.round(frpProdcution.getCol6(), 2)+CommonUtil.round(frpProdcution.getCol7(), 2);
			int trackerWPFeed=consumedBales.getTotalbales();
			
			
			double value=0;
			if(trackerWPFeed!=0){
				value=(totalProdADST/trackerWPFeed)*100;
			}
					
			
			yieldTrackers.add(CommonUtil.round(value, 2));
			
			//(Total Producation ADST/Tracker WastePaper Feed)*100
			//totalProdADSTs/trackerWPfeeds*100
		}
		Map<String, Object> datas=new HashMap<>();
		
		if(ids.size()>0){
			datas.put(Rows.ROW_01, ids);
			datas.put(Rows.ROW_02, dates);
			datas.put(Rows.ROW_03, days);
			datas.put(Rows.ROW_04, hdStorages);
			datas.put(Rows.ROW_05, dcsWPFeedADSTs);
			datas.put(Rows.ROW_06, primaryPressADSTs);
			datas.put(Rows.ROW_07, wetLapProdADSTs);
			datas.put(Rows.ROW_08, totalProdADSTs);
			datas.put(Rows.ROW_09, trackerWPfeeds);
			
			datas.put(Rows.ROW_10, yieldDcss);
			
			double rlt1=getTotal(totalProdADSTs);
			double rlt2=getTotal(trackerWPfeeds);
			double rlt3=CommonUtil.round(((rlt1)/(rlt2))*100, 2);
			System.out.println("rlt3::"+rlt3);
			
			datas.put(Rows.ROW_11, yieldTrackers);
			datas.put(Rows.ROW_12, freshWaters);
			
			datas.put(Rows.ROW_13, mrMwlAndSwls);
			datas.put(Rows.ROW_14, mrSowAndCbss);
			datas.put(Rows.ROW_15, mrDlks);
			datas.put(Rows.ROW_16, mrOccs);
			datas.put(Rows.ROW_17, mrWhiteGradess);
			datas.put(Rows.ROW_18, mrGroundwoods);
			datas.put(Rows.ROW_19, mrOthers);
			
			datas.put(Rows.ROW_20, wpmMwls);
			datas.put(Rows.ROW_21, wpmPrintMixs);
			datas.put(Rows.ROW_22, wpmSows);
			datas.put(Rows.ROW_23, wpmCbss);
			datas.put(Rows.ROW_24, wpmSowAndCbss);
			datas.put(Rows.ROW_25, wpmCtdGrwds);
			datas.put(Rows.ROW_26, wpmSwls);
			datas.put(Rows.ROW_27, wpmOccs);
			datas.put(Rows.ROW_28, wpmNewsNewsblanks);
			datas.put(Rows.ROW_29, wpmDlks);
			datas.put(Rows.ROW_30, wpmOthers);
			datas.put(Rows.ROW_31, wpmTotals);
			
			datas.put(Rows.ROW_32, targetBrightnesss);
			datas.put(Rows.ROW_33, dailyAvgs);
			datas.put(Rows.ROW_34, pmTargetBrites);
			datas.put(Rows.ROW_35, pmAvgBrites);
			datas.put(Rows.ROW_36, comments);
			
			
			datas.put(Rows.ROW_46, wpmMailUndeliverable);
			datas.put(Rows.ROW_48, grades);

			datas.put(Rows.ROW_49, freshWaters2);
			
			
			//Part1
			double sumDcsWPFeedADSTs=getTotal(dcsWPFeedADSTs);
			double sumTotalProdADSTs=getTotal(totalProdADSTs);
			double sumTrackerWPfeeds=getTotal(trackerWPfeeds);
			
			
			double mtdDcsYield=(sumTotalProdADSTs/sumDcsWPFeedADSTs)*100;
			datas.put(Rows.ROW_37, CommonUtil.round(mtdDcsYield, 2));
			
			double mtdTrackerYield=(sumTotalProdADSTs/sumTrackerWPfeeds)*100; //MTD Tracker yield
			datas.put(Rows.ROW_38, CommonUtil.round(mtdTrackerYield, 2));

			//Part2
			double sumWpmMwls=getTotal(wpmMwls);
			double sumWpmPrintMixs=getTotal(wpmPrintMixs);
			double sumWpmSwls=getTotal(wpmSwls);
			double sumWpmSowAndCbss=getTotal(wpmSowAndCbss);
			double sumWpmNewsNewsblanks=getTotal(wpmNewsNewsblanks);
			double sumWpmCtdGrwds=getTotal(wpmCtdGrwds);
			double sumWpmDlks=getTotal(wpmDlks);
			double sumWpmOccs=getTotal(wpmOccs);
			
			double sumWpmSows=getTotal(wpmSows);
			double sumWpmCbss=getTotal(wpmCbss);
			double sumWpmOthers=getTotal(wpmOthers);
			
			double sumWpmMailUndeliverable=getTotal(wpmMailUndeliverable);
			
			
			double sumWpmTotals=getTotal(wpmTotals);
			
			double sumMTDMwlAndSwl=getTotal(mrMwlAndSwls)/mrMwlAndSwls.size();
			double sumMTDSow=getTotal(mrSowAndCbss)/mrSowAndCbss.size();
			double sumMTDOther=getTotal(mrOthers)/mrOthers.size();
			double sumMTDWhiteGrades=getTotal(mrWhiteGradess)/mrWhiteGradess.size();
			double sumMTDGroundwood=getTotal(mrGroundwoods)/mrGroundwoods.size();
			double sumMTDDlk=getTotal(mrDlks)/mrDlks.size();
			double sumMTDOcc=getTotal(mrOccs)/mrOccs.size();
			datas.put(Rows.ROW_39, CommonUtil.round(sumMTDMwlAndSwl, 2));
			datas.put(Rows.ROW_40, CommonUtil.round(sumMTDSow, 2));
			datas.put(Rows.ROW_45, CommonUtil.round(sumMTDOther, 2));
			datas.put(Rows.ROW_41, CommonUtil.round(sumMTDWhiteGrades, 2));
			datas.put(Rows.ROW_42, CommonUtil.round(sumMTDGroundwood, 2));
			datas.put(Rows.ROW_43, CommonUtil.round(sumMTDDlk, 2));
			datas.put(Rows.ROW_44, CommonUtil.round(sumMTDOcc, 2));
			
			/*
			 * double sumMTDMwlAndSwl=((sumWpmMwls+sumWpmSwls)/sumWpmTotals)*100;
			 * if(prodType.equalsIgnoreCase("BW")){ datas.put(Rows.ROW_39,
			 * CommonUtil.round(sumMTDMwlAndSwl, 2)); }else{ datas.put(Rows.ROW_39, 0); }
			 * 
			 * 
			 * double sumMTDSow=((sumWpmPrintMixs+sumWpmCbss+sumWpmCtdGrwds+sumWpmSows)/
			 * sumWpmTotals)*100; if(prodType.equalsIgnoreCase("BW")){
			 * datas.put(Rows.ROW_40, CommonUtil.round(sumMTDSow, 2)); }else{
			 * datas.put(Rows.ROW_40, 0); }
			 * 
			 * 
			 * double sumMTDOther=((sumWpmOthers)/sumWpmTotals)*100;
			 * if(prodType.equalsIgnoreCase("BW") || prodType.equalsIgnoreCase("KF")){
			 * datas.put(Rows.ROW_45, CommonUtil.round(sumMTDOther, 2)); }else{
			 * datas.put(Rows.ROW_45, 0); }
			 * 
			 * 
			 * double
			 * sumMTDWhiteGrades=((sumWpmMwls+sumWpmPrintMixs+sumWpmSwls+sumWpmSowAndCbss)/
			 * sumWpmTotals)*100; if(prodType.equalsIgnoreCase("KF")){
			 * datas.put(Rows.ROW_41, CommonUtil.round(sumMTDWhiteGrades, 2)); }else{
			 * datas.put(Rows.ROW_41, 0); }
			 * 
			 * 
			 * double
			 * sumMTDGroundwood=((sumWpmNewsNewsblanks+sumWpmCtdGrwds)/sumWpmTotals)*100;
			 * if(prodType.equalsIgnoreCase("KF")){ datas.put(Rows.ROW_42,
			 * CommonUtil.round(sumMTDGroundwood, 2)); }else{ datas.put(Rows.ROW_42, 0); }
			 * 
			 * 
			 * double sumMTDDlk=((sumWpmDlks)/sumWpmTotals)*100;
			 * if(prodType.equalsIgnoreCase("KF")){ datas.put(Rows.ROW_43,
			 * CommonUtil.round(sumMTDDlk, 2)); }else{ datas.put(Rows.ROW_43, 0); }
			 * 
			 * 
			 * double sumMTDOcc=((sumWpmOccs)/sumWpmTotals)*100;
			 * if(prodType.equalsIgnoreCase("KF")){ datas.put(Rows.ROW_44,
			 * CommonUtil.round(sumMTDOcc, 2)); }else{ datas.put(Rows.ROW_44, 0); }
			 */
			double sumWPMailUndeliverable=((sumWpmMailUndeliverable)/sumWpmTotals)*100;
			if(prodType.equalsIgnoreCase("KF")){
				datas.put(Rows.ROW_47, CommonUtil.round(sumWPMailUndeliverable, 2));
			}else{
				datas.put(Rows.ROW_47, 0);
			}
			
			
			
		}
		
		
		
		return datas;
	}
	private double getTotal(List<Double> numbers) {
		double total=0;
		for (Double d : numbers) {
			total+=d;
		}
		return total;
	}

}
