/**
 *Dec 2, 2014
 *SummaryDataReportHanlder.java
 * TODO
 *com.st.pmothers.report
 *SummaryDataReportHanlder.java
 *Sunil Singh Bora
 */
package com.st.pmothers.report;

import java.awt.Color;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfReportUtil.Section;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.common.pdfutil.PdfStyle;
import com.st.pmothers.model.SummaryData;

/**
 * @author sbora
 *
 */
@Component
public class SummaryDataReportHanlder {

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	/**
	 * @param summaryData
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createPdfDailySummaryReport(SummaryData summaryData,
			OutputStream outputStream) throws Exception {
		
		
		PdfReportUtil pdfUtil=new PdfReportUtil(10,10,4,10);
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("ST Tissue - Daily Summary Report");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
		pdfUtil.setWaterMark(false);
		pdfUtil.open();
		
		
		Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addText("ST Tissue - Daily Summary Report".toUpperCase(), PdfStyle.FONT_BOLD_UNDERLINE_12);
		header.addText("\n", PdfStyle.FONT_BOLD_10);
		header.finish();
		
		
		Table tableHeader=pdfUtil.new Table(5, new float[]{1.5f,2.5f,2.5f,1.2f,1.2f});
		if(summaryData.getDate()!=null){
			tableHeader.addCell("Date: "+dateFormat.format(summaryData.getDate()), PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1, 1,0);
		}else{
			tableHeader.addCell("Date: ", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1, 1,0);
		}
		
		tableHeader.addCell("\n\n", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,0);
		if(summaryData.getProductionDate()!=null){
			tableHeader.addCell("Production Date :  "+dateFormat.format(summaryData.getProductionDate()), PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_RIGHT, 3, 1,0);	
		}else{
			tableHeader.addCell("Production Date : ", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_RIGHT, 3, 1,0);
		}
		
		
		tableHeader.finish();
		
		
		float cmL=1;
		float cmR=1;
		float cmT=4;
		float cmB=4;
		
		
		Table table=pdfUtil.new Table(5, new float[]{1.5f,3f,2.5f,1.2f,1.2f});
		table.setCommonHeader(true);
		
		
		table.addCell("", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(240,248,255));
		table.addCell("", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(240,248,255));
		table.addCell("Yesterday", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(240,248,255));
		table.addCell("Month To Date", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(240,248,255));
		table.addCell("Goal", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(240,248,255));
		
		
		
		//Safety
		
		table.addCell("Safety", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 5,cmL,cmR,cmT,cmB);
		table.addCell("Days Without Recordable Injury", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getSafety_Y01()==0?"":summaryData.getSafety_Y01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,new Color(220,220,220));
		table.addCell(summaryData.getSafety_G01()==0?"":summaryData.getSafety_G01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Days Without Lost Time Injury", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getSafety_Y02()==0?"":summaryData.getSafety_Y02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		table.addCell(summaryData.getSafety_G02()==0?"":summaryData.getSafety_G02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("First Aid Cases", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getSafety_Y03()==0?"":summaryData.getSafety_Y03()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getSafety_MTD03()==0?"":summaryData.getSafety_MTD03()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Incident/Near Miss Reports", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getSafety_Y04()==0?"":summaryData.getSafety_Y04()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getSafety_MTD04()==0?"":summaryData.getSafety_MTD04()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Safety Meeting Topic", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getSafetyMeetingTopic()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 2, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Comments:", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getSafetyComment()), PdfStyle.FONT_NORMAL_7, PdfStyle.ALIGN_LEFT, 4, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("\n", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 5, 1,0,cmL,cmR,cmT,cmB);
		
		
		
		
		//Housekeeping
		table.addCell("Housekeeping", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("Fire Incidents", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getHousekeeping_Y01()==0?"":summaryData.getHousekeeping_Y01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getHousekeeping_MTD01()==0?"":summaryData.getHousekeeping_MTD01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getHousekeeping_G01()==0?"":summaryData.getHousekeeping_G01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Comments:", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getHousekeepingCommnet()), PdfStyle.FONT_NORMAL_7, PdfStyle.ALIGN_LEFT, 4, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("\n", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 5, 1,0,cmL,cmR,cmT,cmB);
		
		
		//Quality
		table.addCell("Quality", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 4,cmL,cmR,cmT,cmB);
		table.addCell("First Quality Percentage", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getQuality_Y01()==0?"":summaryData.getQuality_Y01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getQuality_MTD01()==0?"":summaryData.getQuality_MTD01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getQuality_G01()==0?"":summaryData.getQuality_G01()+" %", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Red Tons", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getQuality_Y02()==0?"":summaryData.getQuality_Y02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getQuality_MTD02()==0?"":summaryData.getQuality_MTD02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Cull Tons (Slaboff)", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getQuality_Y03()==0?"":summaryData.getQuality_Y03()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getQuality_MTD03()==0?"":summaryData.getQuality_MTD03()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Reject", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getQuality_Y04()==0?"":summaryData.getQuality_Y04()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getQuality_MTD04()==0?"":summaryData.getQuality_MTD04()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Comments:", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getQualityComment()), PdfStyle.FONT_NORMAL_7, PdfStyle.ALIGN_LEFT, 4, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("\n", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 5, 1,0,cmL,cmR,cmT,cmB);
		
		
		//Fiber Production
		table.addCell("Fiber Production", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 9,cmL,cmR,cmT,cmB);
		table.addCell("Input Tons", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_Y01()==0?"":summaryData.getFiberProd_Y01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_MTD01()==0?"":summaryData.getFiberProd_MTD01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Output Tons", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_Y02()==0?"":summaryData.getFiberProd_Y02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_MTD02()==0?"":summaryData.getFiberProd_MTD02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));

		table.addCell("White Yield", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_Y03()==0?"":summaryData.getFiberProd_Y03()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_MTD03()==0?"":summaryData.getFiberProd_MTD03()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_G03()==0?"":summaryData.getFiberProd_G03()+" %", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Last 24 hrs. Brightness", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_Y04()==0?"":summaryData.getFiberProd_Y04()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_MTD04()==0?"":summaryData.getFiberProd_MTD04()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_G04()==0?"":summaryData.getFiberProd_G04()+" %", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Current Brightness", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_Y05()==0?"":summaryData.getFiberProd_Y05()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_MTD05()==0?"":summaryData.getFiberProd_MTD05()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_G05()==0?"":summaryData.getFiberProd_G05()+" %", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("White % SOW & CBS", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_Y06()==0?"":summaryData.getFiberProd_Y06()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_MTD06()==0?"":summaryData.getFiberProd_MTD06()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_G06()==0?"":summaryData.getFiberProd_G06()+" %", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Kraft Yield", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_Y07()==0?"":summaryData.getFiberProd_Y07()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_MTD07()==0?"":summaryData.getFiberProd_MTD07()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_G07()==0?"":summaryData.getFiberProd_G07()+" %", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Kraft % Gwd/Mixed Paper", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_Y08()==0?"":summaryData.getFiberProd_Y08()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_MTD08()==0?"":summaryData.getFiberProd_MTD08()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_G08()==0?"":summaryData.getFiberProd_G08()+" %", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Sludge % Solids", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_Y09()==0?"":summaryData.getFiberProd_Y09()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_MTD09()==0?"":summaryData.getFiberProd_MTD09()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getFiberProd_G09()==0?"":summaryData.getFiberProd_G09()+" %", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		
		table.addCell("Comments:", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getFiberProdComment()), PdfStyle.FONT_NORMAL_7, PdfStyle.ALIGN_LEFT, 4, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("\n", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 5, 1,0,cmL,cmR,cmT,cmB);
		
		
		//Paper Production
		table.addCell("Paper Production", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 7,cmL,cmR,cmT,cmB);
		table.addCell("Reel Tons (Machine Production Actual)", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_Y01()==0?"":summaryData.getPaperProd_Y01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_MTD01()==0?"":summaryData.getPaperProd_MTD01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("White Tons", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_Y02()==0?"":summaryData.getPaperProd_Y02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_MTD02()==0?"":summaryData.getPaperProd_MTD02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Machine Efficiency", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_Y03()==0?"":summaryData.getPaperProd_Y03()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_MTD03()==0?"":summaryData.getPaperProd_MTD03()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_G03()==0?"":summaryData.getPaperProd_G03()+" %", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Rewinder Sets (D/N)", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getPaperProd_Y04()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Rewinder Speed", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_Y05()==0?"":summaryData.getPaperProd_Y05()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Paper Yield", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_Y06()==0?"":summaryData.getPaperProd_Y06()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_MTD06()==0?"":summaryData.getPaperProd_MTD06()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_G06()==0?"":summaryData.getPaperProd_G06()+" %", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Machine Sets", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1);
		table.addCell(summaryData.getPaperProd_Y07()==0?"":summaryData.getPaperProd_Y07()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_MTD07()==0?"":summaryData.getPaperProd_MTD07()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getPaperProd_G07()==0?"":summaryData.getPaperProd_G07()+" %", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Comments:", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getPaperProdComment()), PdfStyle.FONT_NORMAL_7, PdfStyle.ALIGN_LEFT, 4, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("\n", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 5, 1,0,cmL,cmR,cmT,cmB);
		
		
		//Shipping
		table.addCell("Shipping", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 4,cmL,cmR,cmT,cmB);
		table.addCell("Trucks Loaded", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getShipping_Y01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Warehouse White Inventory", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getShipping_Y02()==0?"":summaryData.getShipping_Y02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Warehouse Red Inventory", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getShipping_Y03()==0?"":summaryData.getShipping_Y03()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Warehouse Cull / Broke Inventory", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getShipping_Y04()==0?"":summaryData.getShipping_Y04()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(220,220,220));
		
		table.addCell("Comments:", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getShippingComment()), PdfStyle.FONT_NORMAL_7, PdfStyle.ALIGN_LEFT, 4, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("\n", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 5, 1,0,cmL,cmR,cmT,cmB);
		
		//Costs
		table.addCell("Costs", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 2,cmL,cmR,cmT,cmB);
		table.addCell("Fresh water flow (gal/ton)", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getCosts_Y01()==0?"":summaryData.getCosts_Y01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getCosts_MTD01()==0?"":summaryData.getCosts_MTD01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getCosts_G01()==0?"":summaryData.getCosts_G01()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);

		table.addCell("KW Hrs/Ton", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getCosts_Y02()==0?"":summaryData.getCosts_Y02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getCosts_MTD02()==0?"":summaryData.getCosts_MTD02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(summaryData.getCosts_G02()==0?"":summaryData.getCosts_G02()+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("Comments:", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getCostsComment()), PdfStyle.FONT_NORMAL_7, PdfStyle.ALIGN_LEFT, 4, 1,cmL,cmR,cmT,cmB);
		table.addCell("\n", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 5, 1,0,cmL,cmR,cmT,cmB);
		
		
		//Added new Column
		table.addCell("Meeting Today", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 2, 1,cmL,cmR,cmT,cmB);
		table.addCell("Attendee", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell("Visitor Scheduled Today", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 2, 1,cmL,cmR,cmT,cmB);
		
		table.addCell(CommonUtil.checkNull(summaryData.getMeetingToday()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 2, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getAttendee()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getVisitor()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 2, 1,cmL,cmR,cmT,cmB);
		
		table.addCell("\n", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 5, 1,0,cmL,cmR,cmT,cmB);
		
		table.addCell("Special Notes", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_LEFT, 5, 1,cmL,cmR,cmT,cmB);
		table.addCell(CommonUtil.checkNull(summaryData.getNotes()), PdfStyle.FONT_NORMAL_7, PdfStyle.ALIGN_LEFT, 5, 1,cmL,cmR,cmT,cmB);
		
		
		table.finish();
		
		pdfUtil.close();
	}

}
