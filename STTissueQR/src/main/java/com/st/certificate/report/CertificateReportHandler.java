/**
 *Nov 13, 2014
 *CertificateReport.java
 * TODO
 *com.st.certificate.report
 *CertificateReport.java
 *Sunil Singh Bora
 */
package com.st.certificate.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.certificate.model.Rewdinder;
import com.st.certificate.service.CertificateAnalysisService;
import com.st.common.CommonUtil;
import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfReportUtil.Section;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.common.pdfutil.PdfStyle;
import com.st.common.Workbook2007Util;
import com.st.qualitypm6.model.Reel;
import com.st.qualitypm6.service.ReelService;

/**
 * @author sbora
 *
 */
@Component
public class CertificateReportHandler {

	@Autowired
	private CertificateAnalysisService certificateAnalysisService;

	@Autowired
	private ReelService reelService;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
	/*	
		*//**
			 * @param reel
			 * @param custCode
			 * @param customer
			 * @param outputStream
			 * @throws Exception
			 *//*
				 * public void createPdfReport(String reel, String custCode, String
				 * customer,String grade, OutputStream outputStream) throws Exception {
				 * 
				 * 
				 * List<Reel> reels=reelService.getReelByReelNo(reel);
				 * 
				 * 
				 * 
				 * PdfReportUtil pdfUtil=new PdfReportUtil(false);
				 * pdfUtil.setOuputStream(outputStream);
				 * pdfUtil.setDocumentTitle("Certificate of Analysis");
				 * 
				 * pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT); pdfUtil.open();
				 * 
				 * Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
				 * header.addImage(this.getClass().getClassLoader().getResource(
				 * "/images/STTissue.JPG"), 250f, 60f);
				 * header.addText("\n34050  Union Camp Drive, Franklin, VA 23851",
				 * PdfStyle.FONT_NORMAL_10); header.addText("\n\nCertificate of Analysis\n\n\n",
				 * PdfStyle.FONT_BOLD_16); header.finish();
				 * 
				 * 
				 * Table tableHeader=pdfUtil.new Table(4, new float[]{1.2f,3,1,1.5f});
				 * 
				 * if(reels.size()>0){
				 * 
				 * Reel reel2=reels.get(0);
				 * 
				 * //Row tableHeader.addCell("Date: ", PdfStyle.FONT_BOLD_10,
				 * PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * tableHeader.addCell(dateFormat.format(reel2.getDate()),
				 * PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3, 1, 0); //Row
				 * tableHeader.addCell("Time", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1, 1,
				 * 0); tableHeader.addCell(timeFormat.format(reel2.getDate())+"\n\n",
				 * PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3, 1, 0);
				 * 
				 * //Row tableHeader.addCell("Customer Name: ", PdfStyle.FONT_BOLD_10,
				 * PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * tableHeader.addCell(CommonUtil.checkNull(customer), PdfStyle.FONT_NORMAL_10,
				 * PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * 
				 * tableHeader.addCell("Grade Code: ", PdfStyle.FONT_BOLD_10,
				 * PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * tableHeader.addCell(CommonUtil.checkNull(reel2.getGradeCode()),
				 * PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * 
				 * 
				 * //Row tableHeader.addCell("Customer Code: ", PdfStyle.FONT_BOLD_10,
				 * PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * tableHeader.addCell(CommonUtil.checkNull(custCode), PdfStyle.FONT_NORMAL_10,
				 * PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * 
				 * tableHeader.addCell("Reel: ", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1,
				 * 1, 0); tableHeader.addCell(reel2.getReel()+"\n\n\n\n",
				 * PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * 
				 * tableHeader.finish();
				 * 
				 * 
				 * List<GradeTarget>
				 * gradeTargets=gradeTargetService.getGradeTarget(reel2.getGradeCode());
				 * 
				 * if(gradeTargets.size()>0){ GradeTarget
				 * gradeTargetBaseWt=GradeTargetUtil.getGradeTarget(gradeTargets,
				 * GradeTargetUtil.GP01); GradeTarget
				 * gradeTargetBrightness=GradeTargetUtil.getGradeTarget(gradeTargets,
				 * GradeTargetUtil.GP02); GradeTarget
				 * gradeTargetBulk=GradeTargetUtil.getGradeTarget(gradeTargets,
				 * GradeTargetUtil.GP03); GradeTarget
				 * gradeTargetMDTensile=GradeTargetUtil.getGradeTarget(gradeTargets,
				 * GradeTargetUtil.GP04); GradeTarget
				 * gradeTargetMDWet=GradeTargetUtil.getGradeTarget(gradeTargets,
				 * GradeTargetUtil.GP05); GradeTarget
				 * gradeTargetCDTensile=GradeTargetUtil.getGradeTarget(gradeTargets,
				 * GradeTargetUtil.GP06); GradeTarget
				 * gradeTargetCDWet=GradeTargetUtil.getGradeTarget(gradeTargets,
				 * GradeTargetUtil.GP07); GradeTarget
				 * gradeTargetMDStretch=GradeTargetUtil.getGradeTarget(gradeTargets,
				 * GradeTargetUtil.GP08); GradeTarget
				 * gradeTargetTensileRatio=GradeTargetUtil.getGradeTarget(gradeTargets,
				 * GradeTargetUtil.GP09); GradeTarget
				 * gradeTargetWDRatio=GradeTargetUtil.getGradeTarget(gradeTargets,
				 * GradeTargetUtil.GP10); GradeTarget
				 * gradeTargetDirt=GradeTargetUtil.getGradeTarget(gradeTargets,
				 * GradeTargetUtil.GP11);
				 * 
				 * 
				 * Table table=pdfUtil.new Table(8, new float[]{3,3,2,2,2,2,2,4});
				 * 
				 * table.addCell("", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1, 0);
				 * table.addCell("\nUnits", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1,
				 * 0); table.addCell("Reject\nMin", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1, 0); table.addCell("Control\nMin",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1, 0);
				 * table.addCell("TARGET", PdfStyle.FONT_BOLD_9, PdfStyle.ALIGN_CENTER, 1, 1,
				 * 0); table.addCell("Control\nMax", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1, 0); table.addCell("Reject\nMax",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1, 0);
				 * table.addCell("Testing\nResult", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1, 0);
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * table.addCell("Basis Weigh", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1,
				 * 1, 0); table.addCell("lbs/3000ft", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * table.addCell(gradeTargetBaseWt.getRejectMin()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetBaseWt.getControlMin()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(gradeTargetBaseWt.getTarget()+"",
				 * PdfStyle.FONT_BOLD_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetBaseWt.getControlMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetBaseWt.getRejectMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(reel2.getActualBasisWt()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * 
				 * 
				 * table.addCell("Brightness", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1,
				 * 1, 0); table.addCell("%", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1, 1,
				 * 0); table.addCell(gradeTargetBrightness.getRejectMin()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetBrightness.getControlMin()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetBrightness.getTarget()+"", PdfStyle.FONT_BOLD_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetBrightness.getControlMax()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetBrightness.getRejectMax()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(reel2.getBrightness()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * 
				 * 
				 * table.addCell("Bulk", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * table.addCell("mils/8ply", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1, 1,
				 * 0); table.addCell(gradeTargetBulk.getRejectMin()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetBulk.getControlMin()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(gradeTargetBulk.getTarget()+"",
				 * PdfStyle.FONT_BOLD_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetBulk.getControlMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetBulk.getRejectMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(reel2.getBulk()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * 
				 * 
				 * table.addCell("MD Tensile", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1,
				 * 1, 0); table.addCell("g/inch 1ply", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * table.addCell(gradeTargetMDTensile.getRejectMin()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetMDTensile.getControlMin()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetMDTensile.getTarget()+"", PdfStyle.FONT_BOLD_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetMDTensile.getControlMax()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetMDTensile.getRejectMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(reel2.getMdTensile()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * 
				 * 
				 * table.addCell("MD WET", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1, 1,
				 * 0); table.addCell("g/inch 1ply", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT,
				 * 1, 1, 0); table.addCell(gradeTargetMDWet.getRejectMin()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetMDWet.getControlMin()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(gradeTargetMDWet.getTarget()+"",
				 * PdfStyle.FONT_BOLD_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetMDWet.getControlMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetMDWet.getRejectMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(reel2.getMdWetTensile()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * 
				 * 
				 * table.addCell("CD Tensile", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1,
				 * 1, 0); table.addCell("g/inch 1ply", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_LEFT, 1, 1, 0);
				 * table.addCell(gradeTargetCDTensile.getRejectMin()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetCDTensile.getControlMin()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetCDTensile.getTarget()+"", PdfStyle.FONT_BOLD_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetCDTensile.getControlMax()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetCDTensile.getRejectMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(reel2.getCdTensile()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * 
				 * 
				 * table.addCell("CD WET", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1, 1,
				 * 0); table.addCell("g/inch 1ply", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT,
				 * 1, 1, 0); table.addCell(gradeTargetCDWet.getRejectMin()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetCDWet.getControlMin()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(gradeTargetCDWet.getTarget()+"",
				 * PdfStyle.FONT_BOLD_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetCDWet.getControlMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetCDWet.getRejectMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(reel2.getCdWetTensile()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * 
				 * 
				 * table.addCell("MD Stretch", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1,
				 * 1, 0); table.addCell("%", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1, 1,
				 * 0); table.addCell(gradeTargetMDStretch.getRejectMin()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetMDStretch.getControlMin()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetMDStretch.getTarget()+"", PdfStyle.FONT_BOLD_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetMDStretch.getControlMax()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetMDStretch.getRejectMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(reel2.getMdStretch()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * 
				 * 
				 * table.addCell("Tensile Ratio", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT,
				 * 1, 1, 0); table.addCell("MD/CD", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT,
				 * 1, 1, 0); table.addCell(gradeTargetTensileRatio.getRejectMin()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetTensileRatio.getControlMin()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetTensileRatio.getTarget()+"", PdfStyle.FONT_BOLD_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetTensileRatio.getControlMax()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetTensileRatio.getRejectMax()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(reel2.getMdcdTensileRatio()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * 
				 * 
				 * table.addCell("W/D Ratio", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1, 1,
				 * 0); table.addCell("CD Wet/Dry", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT,
				 * 1, 1, 0); table.addCell(gradeTargetWDRatio.getRejectMin()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetWDRatio.getControlMin()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetWDRatio.getTarget()+"", PdfStyle.FONT_BOLD_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetWDRatio.getControlMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetWDRatio.getRejectMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(reel2.getWetDryRatio()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * 
				 * 
				 * table.addCell("Dirt**", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1, 1,
				 * 0); table.addCell("PPM", PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_LEFT, 1, 1,
				 * 0); table.addCell(gradeTargetDirt.getRejectMin()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetDirt.getControlMin()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(gradeTargetDirt.getTarget()+"",
				 * PdfStyle.FONT_BOLD_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetDirt.getControlMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1);
				 * table.addCell(gradeTargetDirt.getRejectMax()+"", PdfStyle.FONT_NORMAL_9,
				 * PdfStyle.ALIGN_CENTER, 1, 1); table.addCell(reel2.getDirtCount()+"",
				 * PdfStyle.FONT_NORMAL_9, PdfStyle.ALIGN_CENTER, 1, 1);
				 * 
				 * 
				 * 
				 * table.finish(); }
				 * 
				 * 
				 * 
				 * 
				 * 
				 * }
				 * 
				 * 
				 * 
				 * Table tableSign=pdfUtil.new Table(2, new float[]{5,1.5f});
				 * 
				 * tableSign.addCell("", PdfStyle.FONT_NORMAL_12, PdfStyle.ALIGN_CENTER, 1,
				 * 1,0);
				 * 
				 * 
				 * Section signSection=pdfUtil.new Section(5, 5, PdfStyle.ALIGN_LEFT);
				 * signSection.addText("\n\n\nThank You,", PdfStyle.FONT_NORMAL_10);
				 * signSection.addText("\n", PdfStyle.FONT_NORMAL_12);
				 * signSection.addText("\nQuality Manager", PdfStyle.FONT_NORMAL_10);
				 * signSection.addText("\nquality@sttissuellc.com", PdfStyle.FONT_NORMAL_9);
				 * signSection.addText("\n757-304-5041", PdfStyle.FONT_NORMAL_9);
				 * tableSign.addCell(signSection, 1, 1,0);
				 * 
				 * 
				 * tableSign.finish();
				 * 
				 * pdfUtil.close();
				 * 
				 * }
				 */

	/**
	 * @param reel
	 * @param custCode
	 * @param customer
	 * @param outputStream
	 * @throws Exception
	 */
	public void createPdfReport(String reel, String custCode, String customer, String grade, OutputStream outputStream)
			throws Exception {
		PdfReportUtil pdfUtil = new PdfReportUtil(false);
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Certificate of Analysis");

		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_LANDSCAPE);
		pdfUtil.open();

		Section header = pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addImage(this.getClass().getClassLoader().getResource("/images/STTissue.JPG"), 250f, 60f);
		header.addText("\n34050  Union Camp Drive, Franklin, VA 23851", PdfStyle.FONT_NORMAL_10);
		header.addText("\n\nCertificate of Analysis\n\n\n", PdfStyle.FONT_BOLD_16);
		header.finish();

		Table tableHeader = pdfUtil.new Table(4, new float[] { 1, 5, 1, 1.5f });

		// Row
		tableHeader.addCell("Date: ", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1, 1, 0);
		tableHeader.addCell(dateFormat.format(new Date()) + "\n\n", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 3, 1,
				0);

		// Row
		tableHeader.addCell("Customer Name: ", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1, 1, 0);
		tableHeader.addCell(CommonUtil.checkNull(customer), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 0);

		tableHeader.addCell("Grade Code: ", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1, 1, 0);
		tableHeader.addCell(CommonUtil.checkNull(grade), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 0);

		// Row
		tableHeader.addCell("Reel #  ", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1, 1, 0);
		tableHeader.addCell(reel + "", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 0);

		tableHeader.addCell("", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 1, 1, 0);
		tableHeader.addCell("\n\n", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 0);

		tableHeader.finish();

		List<Reel> reels = reelService.getReelByReelNo(reel);

		boolean basisWeightCol = false;
		boolean birghtnessCol = false;
		boolean bulkCol = false;
		boolean mdTensileCol = false;
		boolean mdWetCol = false;
		boolean cdTensileCol = false;
		boolean cdWetCol = false;
		boolean mdStretchCol = false;
		boolean mdCdTensileRatioCol = false;
		boolean wdRationCol = false;

		int countCol = 0;
		if (reels.size() > 0) {
			for (Reel reel2 : reels) {
				if (reel2.getActualBasisWt() > 0) {
					if (!basisWeightCol) {
						basisWeightCol = true;
						countCol++;
					}
				}

				if (reel2.getBrightness() > 0) {
					if (!birghtnessCol) {
						birghtnessCol = true;
						countCol++;
					}
				}

				if (reel2.getBulk() > 0) {
					if (!bulkCol) {
						bulkCol = true;
						countCol++;
					}
				}

				if (reel2.getMdTensile() > 0) {
					if (!mdTensileCol) {
						mdTensileCol = true;
						countCol++;
					}
				}

				if (reel2.getMdWetTensile() > 0) {
					if (!mdWetCol) {
						mdWetCol = true;
						countCol++;
					}
				}

				if (reel2.getCdTensile() > 0) {
					if (!cdTensileCol) {
						cdTensileCol = true;
						countCol++;
					}
				}

				if (reel2.getCdWetTensile() > 0) {
					if (!cdWetCol) {
						cdWetCol = true;
						countCol++;
					}
				}

				if (reel2.getMdcdTensileRatio() > 0) {
					if (!mdCdTensileRatioCol) {
						mdCdTensileRatioCol = true;
						countCol++;
					}
				}

				if (reel2.getWetDryRatio() > 0) {
					if (!wdRationCol) {
						wdRationCol = true;
						countCol++;
					}
				}
				if (reel2.getMdStretch() > 0) {
					if (!mdStretchCol) {
						mdStretchCol = true;
						countCol++;
					}
				}
			}
		}
		float[] colwiths = new float[countCol + 3];
		for (int i = 0; i < colwiths.length; i++) {
			if (i == 0 | i == 1 | i == 3) {
				colwiths[i] = 1.5f;
			} else {
				colwiths[i] = 1;
			}
		}
		Table table = pdfUtil.new Table(countCol + 3, colwiths);

		table.addCell("Date", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		table.addCell("Time", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		table.addCell("Reel #", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);

		if (basisWeightCol) {
			table.addCell("Basis Weight", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (birghtnessCol) {
			table.addCell("Brightness", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (bulkCol) {
			table.addCell("Bulk", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (mdTensileCol) {
			table.addCell("MD Tensile", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (mdWetCol) {
			table.addCell("MD WET", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (cdTensileCol) {
			table.addCell("CD Tensile", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (cdWetCol) {
			table.addCell("CD WET", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (mdStretchCol) {
			table.addCell("MD Stretch", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (mdCdTensileRatioCol) {
			table.addCell("Tensile Ratio", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (wdRationCol) {
			table.addCell("W/D Ratio", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);

		if (basisWeightCol) {
			table.addCell("lbs/3000ft", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (birghtnessCol) {
			table.addCell("%", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (bulkCol) {
			table.addCell("mils/8ply", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (mdTensileCol) {
			table.addCell("g/inch 1ply", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (mdWetCol) {
			table.addCell("g/inch 1ply", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (cdTensileCol) {
			table.addCell("g/inch 1ply", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (cdWetCol) {
			table.addCell("g/inch 1ply", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (mdStretchCol) {
			table.addCell("%", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (mdCdTensileRatioCol) {
			table.addCell("MD/CD", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (wdRationCol) {
			table.addCell("CD Wet/Dry", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
		}

		if (reels.size() > 0) {

			double basisWeightAvg = 0;
			double birghtnessAvg = 0;
			double bulkAvg = 0;
			double mdTensileAvg = 0;
			double mdWetAvg = 0;
			double cdTensileAvg = 0;
			double cdWetAvg = 0;
			double mdStretchAvg = 0;
			double mdCdTensileRatioAvg = 0;
			double wdRationAvg = 0;

			for (Reel reel2 : reels) {
				table.addCell(dateFormat.format(reel2.getDate()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(timeFormat.format(reel2.getDate()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(reel2.getReel(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);

				if (basisWeightCol) {
					table.addCell(reel2.getActualBasisWt() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
					basisWeightAvg += reel2.getActualBasisWt();
				}

				if (birghtnessCol) {
					table.addCell(reel2.getBrightness() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
					birghtnessAvg += reel2.getBrightness();
				}

				if (bulkCol) {
					table.addCell(reel2.getBulk() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
					bulkAvg += reel2.getBulk();
				}

				if (mdTensileCol) {
					table.addCell(reel2.getMdTensile() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
					mdTensileAvg += reel2.getMdTensile();
				}

				if (mdWetCol) {
					table.addCell(reel2.getMdWetTensile() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
					mdWetAvg += reel2.getMdWetTensile();
				}

				if (cdTensileCol) {
					table.addCell(reel2.getCdTensile() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
					cdTensileAvg += reel2.getCdTensile();
				}

				if (cdWetCol) {
					table.addCell(reel2.getCdWetTensile() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
					cdWetAvg += reel2.getCdWetTensile();
				}

				if (mdStretchCol) {
					table.addCell(reel2.getMdStretch() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
					mdStretchAvg += reel2.getMdStretch();
				}

				if (mdCdTensileRatioCol) {
					table.addCell(reel2.getMdcdTensileRatio() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1,
							1);
					mdCdTensileRatioAvg += reel2.getMdcdTensileRatio();
				}

				if (wdRationCol) {
					table.addCell(reel2.getWetDryRatio() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
					wdRationAvg += reel2.getWetDryRatio();
				}
			}

			table.addCell("Average", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 3, 1);

			int len = reels.size();

			if (basisWeightCol) {
				table.addCell(CommonUtil.round(basisWeightAvg / len, 2) + "", PdfStyle.FONT_NORMAL_8,
						PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (birghtnessCol) {
				table.addCell(CommonUtil.round(birghtnessAvg / len, 2) + "", PdfStyle.FONT_NORMAL_8,
						PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (bulkCol) {
				table.addCell(CommonUtil.round(bulkAvg / len, 2) + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1,
						1);
			}

			if (mdTensileCol) {
				table.addCell(CommonUtil.round(mdTensileAvg / len, 2) + "", PdfStyle.FONT_NORMAL_8,
						PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (mdWetCol) {
				table.addCell(CommonUtil.round(mdWetAvg / len, 2) + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER,
						1, 1);
			}

			if (cdTensileCol) {
				table.addCell(CommonUtil.round(cdTensileAvg / len, 2) + "", PdfStyle.FONT_NORMAL_8,
						PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (cdWetCol) {
				table.addCell(CommonUtil.round(cdWetAvg / len, 2) + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER,
						1, 1);
			}

			if (mdStretchCol) {
				table.addCell(CommonUtil.round(mdStretchAvg / len, 2) + "", PdfStyle.FONT_NORMAL_8,
						PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (mdCdTensileRatioCol) {
				table.addCell(CommonUtil.round(mdCdTensileRatioAvg / len, 2) + "", PdfStyle.FONT_NORMAL_8,
						PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (wdRationCol) {
				table.addCell(CommonUtil.round(wdRationAvg / len, 2) + "", PdfStyle.FONT_NORMAL_8,
						PdfStyle.ALIGN_CENTER, 1, 1);
			}

		} else {
			table.addCell("Test data not available", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 13, 1);
		}

		table.finish();

		Table tableSign = pdfUtil.new Table(2, new float[] { 5, 1 });

		tableSign.addCell("", PdfStyle.FONT_NORMAL_12, PdfStyle.ALIGN_CENTER, 1, 1, 0);

		Section signSection = pdfUtil.new Section(5, 5, PdfStyle.ALIGN_LEFT);
		signSection.addText("\n\n\nThank You,", PdfStyle.FONT_NORMAL_10);
		signSection.addText("\nXYZ,", PdfStyle.FONT_NORMAL_12);
		signSection.addText("\nQuality Manager", PdfStyle.FONT_NORMAL_10);
		signSection.addText("\nquality@sttissuellc.com", PdfStyle.FONT_NORMAL_9);
		signSection.addText("\n757-304-5041", PdfStyle.FONT_NORMAL_9);
		tableSign.addCell(signSection, 1, 1, 0);

		tableSign.finish();

		pdfUtil.close();

	}

	public void createPdfReportMulti(String reelList, String customer, OutputStream outputStream) throws Exception {

		PdfReportUtil pdfUtil = new PdfReportUtil(false);
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Certificate of Analysis");

		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_LANDSCAPE);
		pdfUtil.open();

		Section header = pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addImage(this.getClass().getClassLoader().getResource("/images/STTissue.JPG"), 250f, 60f);
		header.addText("\n34050  Union Camp Drive, Franklin, VA 23851", PdfStyle.FONT_NORMAL_10);
		header.addText("\n\nCertificate of Analysis\n\n\n", PdfStyle.FONT_BOLD_16);
		header.finish();

		Section sectionNotes = pdfUtil.new Section(10, 10, PdfStyle.ALIGN_LEFT);
		sectionNotes.addText("Date: ", PdfStyle.FONT_BOLD_10);
		sectionNotes.addText(dateFormat.format(new Date()), PdfStyle.FONT_NORMAL_10);
		sectionNotes.addText("\nCustomer: ", PdfStyle.FONT_BOLD_10);
		sectionNotes.addText(CommonUtil.checkNull(customer) + "\n\n", PdfStyle.FONT_NORMAL_10);

		sectionNotes.finish();

		String[] reelString = reelList.split(",");
		if (reelString != null) {

			List<Reel> reels = new ArrayList<Reel>();

			for (String reel : reelString) {
				for (Reel reeldata : reelService.getReelByReelNo(reel)) {
					reels.add(reeldata);
				}
			}

			boolean basisWeightCol = false;
			boolean birghtnessCol = false;
			boolean bulkCol = false;
			boolean mdTensileCol = false;
			boolean mdWetCol = false;
			boolean cdTensileCol = false;
			boolean cdWetCol = false;
			boolean mdStretchCol = false;
			boolean mdCdTensileRatioCol = false;
			boolean wdRationCol = false;

			int countCol = 0;
			if (reels.size() > 0) {
				for (Reel reel2 : reels) {
					if (reel2.getActualBasisWt() > 0) {
						if (!basisWeightCol) {
							basisWeightCol = true;
							countCol++;
						}
					}

					if (reel2.getBrightness() > 0) {
						if (!birghtnessCol) {
							birghtnessCol = true;
							countCol++;
						}
					}

					if (reel2.getBulk() > 0) {
						if (!bulkCol) {
							bulkCol = true;
							countCol++;
						}
					}

					if (reel2.getMdTensile() > 0) {
						if (!mdTensileCol) {
							mdTensileCol = true;
							countCol++;
						}
					}

					if (reel2.getMdWetTensile() > 0) {
						if (!mdWetCol) {
							mdWetCol = true;
							countCol++;
						}
					}

					if (reel2.getCdTensile() > 0) {
						if (!cdTensileCol) {
							cdTensileCol = true;
							countCol++;
						}
					}

					if (reel2.getCdWetTensile() > 0) {
						if (!cdWetCol) {
							cdWetCol = true;
							countCol++;
						}
					}

					if (reel2.getMdcdTensileRatio() > 0) {
						if (!mdCdTensileRatioCol) {
							mdCdTensileRatioCol = true;
							countCol++;
						}
					}

					if (reel2.getWetDryRatio() > 0) {
						if (!wdRationCol) {
							wdRationCol = true;
							countCol++;
						}
					}

					if (reel2.getMdStretch() > 0) {
						if (!mdStretchCol) {
							mdStretchCol = true;
							countCol++;
						}
					}
				}
			}
			float[] colwiths = new float[countCol + 4];
			for (int i = 0; i < colwiths.length; i++) {
				if (i == 0 | i == 2 | i == 3) {
					colwiths[i] = 1.5f;
				} else {
					colwiths[i] = 1;
				}
			}
			Table table = pdfUtil.new Table(countCol + 4, colwiths);

			table.setCommonHeader(true, 2);

			table.addCell("Date", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			table.addCell("Time", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			table.addCell("Grade ", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			table.addCell("Reel #", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);

			if (basisWeightCol) {
				table.addCell("Basis Weight", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (birghtnessCol) {
				table.addCell("Brightness", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (bulkCol) {
				table.addCell("Bulk", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (mdTensileCol) {
				table.addCell("MD Tensile", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (mdWetCol) {
				table.addCell("MD WET", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (cdTensileCol) {
				table.addCell("CD Tensile", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (cdWetCol) {
				table.addCell("CD WET", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (mdStretchCol) {
				table.addCell("MD Stretch", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (mdCdTensileRatioCol) {
				table.addCell("Tensile Ratio", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (wdRationCol) {
				table.addCell("W/D Ratio", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			table.addCell("", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			table.addCell("", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			table.addCell("", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			table.addCell("", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);

			if (basisWeightCol) {
				table.addCell("lbs/3000ft", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (birghtnessCol) {
				table.addCell("%", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (bulkCol) {
				table.addCell("mils/8ply", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (mdTensileCol) {
				table.addCell("g/inch 1ply", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (mdWetCol) {
				table.addCell("g/inch 1ply", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (cdTensileCol) {
				table.addCell("g/inch 1ply", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (cdWetCol) {
				table.addCell("g/inch 1ply", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (mdStretchCol) {
				table.addCell("%", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (mdCdTensileRatioCol) {
				table.addCell("MD/CD", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (wdRationCol) {
				table.addCell("CD Wet/Dry", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
			}

			if (reels.size() > 0) {

				double basisWeightAvg = 0;
				double birghtnessAvg = 0;
				double bulkAvg = 0;
				double mdTensileAvg = 0;
				double mdWetAvg = 0;
				double cdTensileAvg = 0;
				double cdWetAvg = 0;
				double mdStretchAvg = 0;
				double mdCdTensileRatioAvg = 0;
				double wdRationAvg = 0;

				for (Reel reel2 : reels) {
					table.addCell(dateFormat.format(reel2.getDate()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1,
							1);
					table.addCell(timeFormat.format(reel2.getDate()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1,
							1);
					table.addCell(CommonUtil.checkNull(reel2.getGradeCode()), PdfStyle.FONT_NORMAL_8,
							PdfStyle.ALIGN_CENTER, 1, 1);
					table.addCell(reel2.getReel(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);

					if (basisWeightCol) {
						table.addCell(reel2.getActualBasisWt() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1,
								1);
						basisWeightAvg += reel2.getActualBasisWt();
					}

					if (birghtnessCol) {
						table.addCell(reel2.getBrightness() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
						birghtnessAvg += reel2.getBrightness();
					}

					if (bulkCol) {
						table.addCell(reel2.getBulk() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
						bulkAvg += reel2.getBulk();
					}

					if (mdTensileCol) {
						table.addCell(reel2.getMdTensile() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
						mdTensileAvg += reel2.getMdTensile();
					}

					if (mdWetCol) {
						table.addCell(reel2.getMdWetTensile() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1,
								1);
						mdWetAvg += reel2.getMdWetTensile();
					}

					if (cdTensileCol) {
						table.addCell(reel2.getCdTensile() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
						cdTensileAvg += reel2.getCdTensile();
					}

					if (cdWetCol) {
						table.addCell(reel2.getCdWetTensile() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1,
								1);
						cdWetAvg += reel2.getCdWetTensile();
					}

					if (mdStretchCol) {
						table.addCell(reel2.getMdStretch() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
						mdStretchAvg += reel2.getMdStretch();
					}

					if (mdCdTensileRatioCol) {
						table.addCell(reel2.getMdcdTensileRatio() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER,
								1, 1);
						mdCdTensileRatioAvg += reel2.getMdcdTensileRatio();
					}

					if (wdRationCol) {
						table.addCell(reel2.getWetDryRatio() + "", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
						wdRationAvg += reel2.getWetDryRatio();
					}
				}

				table.addCell("Average", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_RIGHT, 4, 1);

				int len = reels.size();

				if (basisWeightCol) {
					table.addCell(CommonUtil.round(basisWeightAvg / len, 2) + "", PdfStyle.FONT_BOLD_10,
							PdfStyle.ALIGN_CENTER, 1, 1);
				}

				if (birghtnessCol) {
					table.addCell(CommonUtil.round(birghtnessAvg / len, 2) + "", PdfStyle.FONT_BOLD_10,
							PdfStyle.ALIGN_CENTER, 1, 1);
				}

				if (bulkCol) {
					table.addCell(CommonUtil.round(bulkAvg / len, 2) + "", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER,
							1, 1);
				}

				if (mdTensileCol) {
					table.addCell(CommonUtil.round(mdTensileAvg / len, 2) + "", PdfStyle.FONT_BOLD_10,
							PdfStyle.ALIGN_CENTER, 1, 1);
				}

				if (mdWetCol) {
					table.addCell(CommonUtil.round(mdWetAvg / len, 2) + "", PdfStyle.FONT_BOLD_10,
							PdfStyle.ALIGN_CENTER, 1, 1);
				}

				if (cdTensileCol) {
					table.addCell(CommonUtil.round(cdTensileAvg / len, 2) + "", PdfStyle.FONT_BOLD_10,
							PdfStyle.ALIGN_CENTER, 1, 1);
				}

				if (cdWetCol) {
					table.addCell(CommonUtil.round(cdWetAvg / len, 2) + "", PdfStyle.FONT_BOLD_10,
							PdfStyle.ALIGN_CENTER, 1, 1);
				}

				if (mdStretchCol) {
					table.addCell(CommonUtil.round(mdStretchAvg / len, 2) + "", PdfStyle.FONT_BOLD_10,
							PdfStyle.ALIGN_CENTER, 1, 1);
				}

				if (mdCdTensileRatioCol) {
					table.addCell(CommonUtil.round(mdCdTensileRatioAvg / len, 2) + "", PdfStyle.FONT_BOLD_10,
							PdfStyle.ALIGN_CENTER, 1, 1);
				}

				if (wdRationCol) {
					table.addCell(CommonUtil.round(wdRationAvg / len, 2) + "", PdfStyle.FONT_BOLD_10,
							PdfStyle.ALIGN_CENTER, 1, 1);
				}

			}

			table.finish();

			Table tableSign = pdfUtil.new Table(2, new float[] { 5, 1 });

			tableSign.addCell("", PdfStyle.FONT_NORMAL_12, PdfStyle.ALIGN_CENTER, 1, 1, 0);

			Section signSection = pdfUtil.new Section(5, 5, PdfStyle.ALIGN_LEFT);
			signSection.addText("\n\n\nThank You,", PdfStyle.FONT_NORMAL_10);
			signSection.addText("\n", PdfStyle.FONT_NORMAL_12);
			signSection.addText("\nQuality Manager", PdfStyle.FONT_NORMAL_10);
			signSection.addText("\nquality@sttissuellc.com", PdfStyle.FONT_NORMAL_9);
			signSection.addText("\n757-304-5041", PdfStyle.FONT_NORMAL_9);
			tableSign.addCell(signSection, 1, 1, 0);

			tableSign.finish();

			pdfUtil.close();
		}
	}

	/**
	 * @param reels
	 * @param customer
	 * @param file
	 * @param outputStream
	 * @throws Exception
	 */
	public void createReportExcel(String reelList, String customer, File file, OutputStream outputStream)
			throws Exception {

		Workbook2007Util util = new Workbook2007Util(file, 0);

		short rowHeight = 280;

		util.addValue(10, 1, dateFormat.format(new Date()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER,
				rowHeight);
		util.addValue(12, 2, CommonUtil.checkNull(customer), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER,
				rowHeight);

		String[] reelsString = reelList.split(",");

		List<Reel> reels = new ArrayList<Reel>();

		if (reelsString != null && reelsString.length > 0) {
			for (String string : reelsString) {
				List<Reel> reelList2 = reelService.getReelByReelNo(string);
				for (Reel reel : reelList2) {
					reels.add(reel);
				}

				/*
				 * if(reelList2.size()>0){ Reel reel=reelList2.get(0);
				 * 
				 * 
				 * }
				 */
			}
		}

		boolean basisWeightCol = false;
		boolean birghtnessCol = false;
		boolean bulkCol = false;
		boolean mdTensileCol = false;
		boolean mdWetCol = false;
		boolean cdTensileCol = false;
		boolean cdWetCol = false;
		boolean mdStretchCol = false;
		boolean mdCdTensileRatioCol = false;
		boolean wdRationCol = false;

		if (reels.size() > 0) {
			for (Reel reel2 : reels) {
				if (reel2.getActualBasisWt() > 0) {
					if (!basisWeightCol) {
						basisWeightCol = true;
					}
				}

				if (reel2.getBrightness() > 0) {
					if (!birghtnessCol) {
						birghtnessCol = true;
					}
				}

				if (reel2.getBulk() > 0) {
					if (!bulkCol) {
						bulkCol = true;
					}
				}

				if (reel2.getMdTensile() > 0) {
					if (!mdTensileCol) {
						mdTensileCol = true;
					}
				}

				if (reel2.getMdWetTensile() > 0) {
					if (!mdWetCol) {
						mdWetCol = true;
					}
				}

				if (reel2.getCdTensile() > 0) {
					if (!cdTensileCol) {
						cdTensileCol = true;
					}
				}

				if (reel2.getCdWetTensile() > 0) {
					if (!cdWetCol) {
						cdWetCol = true;
					}
				}

				if (reel2.getMdcdTensileRatio() > 0) {
					if (!mdCdTensileRatioCol) {
						mdCdTensileRatioCol = true;
					}
				}

				if (reel2.getWetDryRatio() > 0) {
					if (!wdRationCol) {
						wdRationCol = true;
					}
				}

				if (reel2.getMdStretch() > 0) {
					if (!mdStretchCol) {
						mdStretchCol = true;
					}
				}
			}
		}

		int col = 0;
		short headerRowHeight = (short) (rowHeight + 400);
		util.addValue(17, col, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Time", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Reel#", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		if (basisWeightCol) {
			util.addValue(17, col, "Basis Weight", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "lbs/3000ft", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (birghtnessCol) {
			util.addValue(17, col, "Brightness", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (bulkCol) {
			util.addValue(17, col, "Bulk", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "mils/8ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdTensileCol) {
			util.addValue(17, col, "MD Tensile", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdWetCol) {
			util.addValue(17, col, "MD WET", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (cdTensileCol) {
			util.addValue(17, col, "CD Tensile", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (cdWetCol) {
			util.addValue(17, col, "CD WET", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdStretchCol) {
			util.addValue(17, col, "MD Stretch", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdCdTensileRatioCol) {
			util.addValue(17, col, "Tensile Ratio", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "MD/CD", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (wdRationCol) {
			util.addValue(17, col, "W/D Ratio", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "CD Wet/Dry", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		col = 0;
		int row = 19;

		// Data

		double basisWeightAvg = 0;
		double birghtnessAvg = 0;
		double bulkAvg = 0;
		double mdTensileAvg = 0;
		double mdWetAvg = 0;
		double cdTensileAvg = 0;
		double cdWetAvg = 0;
		double mdStretchAvg = 0;
		double mdCdTensileRatioAvg = 0;
		double wdRationAvg = 0;

		for (Reel reel : reels) {
			util.addValue(row, col++, dateFormat.format(reel.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
			util.addValue(row, col++, timeFormat.format(reel.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(reel.getGradeCode()),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, reel.getReel(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			if (basisWeightCol) {
				util.addValue(row, col++, reel.getActualBasisWt(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowHeight);
				basisWeightAvg += reel.getActualBasisWt();
			}

			if (birghtnessCol) {
				util.addValue(row, col++, reel.getBrightness(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				birghtnessAvg += reel.getBrightness();
			}

			if (bulkCol) {
				util.addValue(row, col++, reel.getBulk(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				bulkAvg += reel.getBulk();
			}

			if (mdTensileCol) {
				util.addValue(row, col++, reel.getMdTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				mdTensileAvg += reel.getMdTensile();
			}

			if (mdWetCol) {
				util.addValue(row, col++, reel.getMdWetTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowHeight);
				mdWetAvg += reel.getMdWetTensile();
			}

			if (cdTensileCol) {
				util.addValue(row, col++, reel.getCdTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				cdTensileAvg += reel.getCdTensile();
			}

			if (cdWetCol) {
				util.addValue(row, col++, reel.getCdWetTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowHeight);
				cdWetAvg += reel.getCdWetTensile();
			}

			if (mdStretchCol) {
				util.addValue(row, col++, reel.getMdStretch(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				mdStretchAvg += reel.getMdStretch();
			}

			if (mdCdTensileRatioCol) {
				util.addValue(row, col++, reel.getMdcdTensileRatio(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowHeight);
				mdCdTensileRatioAvg += reel.getMdcdTensileRatio();
			}

			if (wdRationCol) {
				util.addValue(row, col++, reel.getWetDryRatio(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				wdRationAvg += reel.getWetDryRatio();
			}

			col = 0;
			row++;
		}

		col = 0;

		util.mergeCell(row, row, 0, 3);
		util.addValue(row, col++, "Average", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		col++;
		col++;
		col++;

		int len = reels.size();

		if (basisWeightCol) {
			util.addValue(row, col++, CommonUtil.round(basisWeightAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (birghtnessCol) {
			util.addValue(row, col++, CommonUtil.round(birghtnessAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (bulkCol) {
			util.addValue(row, col++, CommonUtil.round(bulkAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (mdTensileCol) {
			util.addValue(row, col++, CommonUtil.round(mdTensileAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (mdWetCol) {
			util.addValue(row, col++, CommonUtil.round(mdWetAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (cdTensileCol) {
			util.addValue(row, col++, CommonUtil.round(cdTensileAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (cdWetCol) {
			util.addValue(row, col++, CommonUtil.round(cdWetAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (mdStretchCol) {
			util.addValue(row, col++, CommonUtil.round(mdStretchAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (mdCdTensileRatioCol) {
			util.addValue(row, col++, CommonUtil.round(mdCdTensileRatioAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (wdRationCol) {
			util.addValue(row, col++, CommonUtil.round(wdRationAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		row = row + 4;

		util.addValue(row++, 10, "Thank You,", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "Quality Manager", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "quality@sttissuellc.com", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER,
				rowHeight);
		util.addValue(row++, 10, "757-304-5041", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);

		util.write(outputStream);
	}

	/**
	 * @param reels
	 * @param customer
	 * @param dateTo
	 * @param dateFrom
	 * @param file
	 * @param outputStream
	 * @throws IOException
	 */
	public void createReportExcelNew(String reelList, String customer, Date dateFrom, Date dateTo, File file,
			ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub

		Workbook2007Util util = new Workbook2007Util(file, 0);

		short rowHeight = 280;

		util.addValue(10, 1, dateFormat.format(new Date()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER,
				rowHeight);
		util.addValue(12, 2, CommonUtil.checkNull(customer), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER,
				rowHeight);

		String[] reelsString = reelList.split(",");

		List<Reel> reels = new ArrayList<Reel>();
		List<Rewdinder> rewdinders = new ArrayList<Rewdinder>();

		if (reelsString != null && reelsString.length > 0) {
			for (String string : reelsString) {
				List<Reel> reelList2 = reelService.getReelByReelNo(string, dateFrom, dateTo);
				// List<Rewdinder>
				// rewdinders1=certificateAnalysisService.getRewindersByReel(string,dateFrom,dateTo);
				for (Reel reel : reelList2) {
					reels.add(reel);
					// rewdinders.addAll(rewdinders1);
				}

				// rewdinders.add(rewdinders1);

				/*
				 * for (Rewdinder reel1 : rewdinders1) { rewdinders.add(reel1); }
				 */

				/*
				 * for (int i = 0; i < reelList2.size(); i++) {
				 * 
				 * //reels.get(i).setRollId(rewdinders.get(i).getRollId());
				 * 
				 * }
				 */

				/*
				 * if(reelList2.size()>0){ Reel reel=reelList2.get(0);
				 * 
				 * 
				 * }
				 */
			}
		}

		boolean basisWeightCol = false;
		boolean birghtnessCol = false;
		boolean bulkCol = false;
		boolean mdTensileCol = false;
		boolean mdWetCol = false;
		boolean cdTensileCol = false;
		boolean cdWetCol = false;
		boolean mdStretchCol = false;
		boolean mdCdTensileRatioCol = false;
		boolean wdRationCol = false;

		if (reels.size() > 0) {
			for (Reel reel2 : reels) {
				if (reel2.getActualBasisWt() > 0) {
					if (!basisWeightCol) {
						basisWeightCol = true;
					}
				}

				if (reel2.getBrightness() > 0) {
					if (!birghtnessCol) {
						birghtnessCol = true;
					}
				}

				if (reel2.getBulk() > 0) {
					if (!bulkCol) {
						bulkCol = true;
					}
				}

				if (reel2.getMdTensile() > 0) {
					if (!mdTensileCol) {
						mdTensileCol = true;
					}
				}

				if (reel2.getMdWetTensile() > 0) {
					if (!mdWetCol) {
						mdWetCol = true;
					}
				}

				if (reel2.getCdTensile() > 0) {
					if (!cdTensileCol) {
						cdTensileCol = true;
					}
				}

				if (reel2.getCdWetTensile() > 0) {
					if (!cdWetCol) {
						cdWetCol = true;
					}
				}

				if (reel2.getMdcdTensileRatio() > 0) {
					if (!mdCdTensileRatioCol) {
						mdCdTensileRatioCol = true;
					}
				}

				if (reel2.getWetDryRatio() > 0) {
					if (!wdRationCol) {
						wdRationCol = true;
					}
				}

				if (reel2.getMdStretch() > 0) {
					if (!mdStretchCol) {
						mdStretchCol = true;
					}
				}
			}
		}

		int col = 0;
		short headerRowHeight = (short) (rowHeight + 400);
		util.addValue(17, col, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Time", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Reel#", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(17, col, "Roll#", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		if (basisWeightCol) {
			util.addValue(17, col, "Basis Weight", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "lbs/3000ft", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (birghtnessCol) {
			util.addValue(17, col, "Brightness", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (bulkCol) {
			util.addValue(17, col, "Bulk", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "mils/8ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdTensileCol) {
			util.addValue(17, col, "MD Tensile", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdWetCol) {
			util.addValue(17, col, "MD WET", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (cdTensileCol) {
			util.addValue(17, col, "CD Tensile", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (cdWetCol) {
			util.addValue(17, col, "CD WET", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdStretchCol) {
			util.addValue(17, col, "MD Stretch", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdCdTensileRatioCol) {
			util.addValue(17, col, "Tensile Ratio", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "MD/CD", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (wdRationCol) {
			util.addValue(17, col, "W/D Ratio", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "CD Wet/Dry", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		col = 0;
		int row = 19;
		short rowheight2 = 3000;

		// Data

		double basisWeightAvg = 0;
		double birghtnessAvg = 0;
		double bulkAvg = 0;
		double mdTensileAvg = 0;
		double mdWetAvg = 0;
		double cdTensileAvg = 0;
		double cdWetAvg = 0;
		double mdStretchAvg = 0;
		double mdCdTensileRatioAvg = 0;
		double wdRationAvg = 0;

		for (Reel reel : reels) {
			util.addValue(row, col++, dateFormat.format(reel.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowheight2);
			util.addValue(row, col++, timeFormat.format(reel.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowheight2);
			util.addValue(row, col++, CommonUtil.checkNull(reel.getGradeCode()),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
			util.addValue(row, col++, reel.getReel(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

			if (col == 4) {
				List<Rewdinder> rewdinders1 = certificateAnalysisService.getRewindersByReel(reel.getReel(), dateFrom,
						dateTo, customer);

				StringBuffer sb = new StringBuffer();
				for (Rewdinder reel2 : rewdinders1) {
					sb.append(reel2.getRollId() + "\n");
				}
				util.addValue(row, 4, sb.toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
			}

			// util.addValue(row, col++, reel.getRollId(),
			// Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
			col++;
			if (basisWeightCol) {
				util.addValue(row, col++, reel.getActualBasisWt(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowheight2);
				basisWeightAvg += reel.getActualBasisWt();
			}

			if (birghtnessCol) {
				util.addValue(row, col++, reel.getBrightness(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
				birghtnessAvg += reel.getBrightness();
			}

			if (bulkCol) {
				util.addValue(row, col++, reel.getBulk(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
				bulkAvg += reel.getBulk();
			}

			if (mdTensileCol) {
				util.addValue(row, col++, reel.getMdTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
				mdTensileAvg += reel.getMdTensile();
			}

			if (mdWetCol) {
				util.addValue(row, col++, reel.getMdWetTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowheight2);
				mdWetAvg += reel.getMdWetTensile();
			}

			if (cdTensileCol) {
				util.addValue(row, col++, reel.getCdTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
				cdTensileAvg += reel.getCdTensile();
			}

			if (cdWetCol) {
				util.addValue(row, col++, reel.getCdWetTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowheight2);
				cdWetAvg += reel.getCdWetTensile();
			}

			if (mdStretchCol) {
				util.addValue(row, col++, reel.getMdStretch(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
				mdStretchAvg += reel.getMdStretch();
			}

			if (mdCdTensileRatioCol) {
				util.addValue(row, col++, reel.getMdcdTensileRatio(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowheight2);
				mdCdTensileRatioAvg += reel.getMdcdTensileRatio();
			}

			if (wdRationCol) {
				util.addValue(row, col++, reel.getWetDryRatio(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowheight2);
				wdRationAvg += reel.getWetDryRatio();
			}

			col = 0;
			row++;
		}

		col = 0;

		util.mergeCell(row, row, 0, 3);
		util.addValue(row, col++, "Average", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
		col++;
		col++;
		col++;

		int len = reels.size();

		if (basisWeightCol) {
			util.addValue(row, col++, CommonUtil.round(basisWeightAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
		}

		if (birghtnessCol) {
			util.addValue(row, col++, CommonUtil.round(birghtnessAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
		}

		if (bulkCol) {
			util.addValue(row, col++, CommonUtil.round(bulkAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowheight2);
		}

		if (mdTensileCol) {
			util.addValue(row, col++, CommonUtil.round(mdTensileAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
		}

		if (mdWetCol) {
			util.addValue(row, col++, CommonUtil.round(mdWetAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowheight2);
		}

		if (cdTensileCol) {
			util.addValue(row, col++, CommonUtil.round(cdTensileAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
		}

		if (cdWetCol) {
			util.addValue(row, col++, CommonUtil.round(cdWetAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowheight2);
		}

		if (mdStretchCol) {
			util.addValue(row, col++, CommonUtil.round(mdStretchAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
		}

		if (mdCdTensileRatioCol) {
			util.addValue(row, col++, CommonUtil.round(mdCdTensileRatioAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
		}

		if (wdRationCol) {
			util.addValue(row, col++, CommonUtil.round(wdRationAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowheight2);
		}

		row = row + 4;

		util.addValue(row++, 10, "Thank You,", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "Quality Manager", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "quality@sttissuellc.com", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER,
				rowHeight);
		util.addValue(row++, 10, "757-304-5041", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);

		util.write(outputStream);

	}

	/**
	 * @param reels
	 * @param customer
	 * @param dateFrom
	 * @param dateTo
	 * @param file
	 * @param outputStream
	 * @throws IOException
	 */
	public void createReportExcelNewPm5(String reels, String customer, Date dateFrom, Date dateTo, File file,
			ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		Workbook2007Util util = new Workbook2007Util(file, 0);

		short rowHeight = 280;

		util.addValue(10, 1, dateFormat.format(new Date()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER,
				rowHeight);
		util.addValue(12, 2, CommonUtil.checkNull(customer), Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER,
				rowHeight);

		String[] reelsString = reels.split(",");

		List<Reel> reels1 = new ArrayList<Reel>();

		if (reelsString != null && reelsString.length > 0) {
			for (String string : reelsString) {
				List<Reel> reelList2 = reelService.getReelByReelNopm5(string, dateFrom, dateTo);
				// List<Rewdinder>
				// rewdinders1=certificateAnalysisService.getRewindersByReel(string,dateFrom,dateTo);
				for (Reel reel : reelList2) {
					reels1.add(reel);
					// rewdinders.addAll(rewdinders1);
				}

			}
		}

		boolean basisWeightCol = false;
		boolean birghtnessCol = false;
		boolean bulkCol = false;
		boolean mdTensileCol = false;
		boolean mdWetCol = false;
		boolean cdTensileCol = false;
		boolean cdWetCol = false;
		boolean mdStretchCol = false;
		boolean mdCdTensileRatioCol = false;
		boolean wdRationCol = false;

		if (reels1.size() > 0) {
			for (Reel reel2 : reels1) {
				if (reel2.getActualBasisWt() > 0) {
					if (!basisWeightCol) {
						basisWeightCol = true;
					}
				}

				if (reel2.getBrightness() > 0) {
					if (!birghtnessCol) {
						birghtnessCol = true;
					}
				}

				if (reel2.getBulk() > 0) {
					if (!bulkCol) {
						bulkCol = true;
					}
				}

				if (reel2.getMdTensile() > 0) {
					if (!mdTensileCol) {
						mdTensileCol = true;
					}
				}

				if (reel2.getMdWetTensile() > 0) {
					if (!mdWetCol) {
						mdWetCol = true;
					}
				}

				if (reel2.getCdTensile() > 0) {
					if (!cdTensileCol) {
						cdTensileCol = true;
					}
				}

				if (reel2.getCdWetTensile() > 0) {
					if (!cdWetCol) {
						cdWetCol = true;
					}
				}

				if (reel2.getMdcdTensileRatio() > 0) {
					if (!mdCdTensileRatioCol) {
						mdCdTensileRatioCol = true;
					}
				}

				if (reel2.getWetDryRatio() > 0) {
					if (!wdRationCol) {
						wdRationCol = true;
					}
				}

				if (reel2.getMdStretch() > 0) {
					if (!mdStretchCol) {
						mdStretchCol = true;
					}
				}
			}
		}

		int col = 0;
		short headerRowHeight = (short) (rowHeight + 400);
		util.addValue(17, col, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Time", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Reel#", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(17, col, "Roll#", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		if (basisWeightCol) {
			util.addValue(17, col, "Basis Weight", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "lbs/3000ft", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (birghtnessCol) {
			util.addValue(17, col, "Brightness", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (bulkCol) {
			util.addValue(17, col, "Bulk", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "mils/8ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdTensileCol) {
			util.addValue(17, col, "MD Tensile", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdWetCol) {
			util.addValue(17, col, "MD WET", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (cdTensileCol) {
			util.addValue(17, col, "CD Tensile", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (cdWetCol) {
			util.addValue(17, col, "CD WET", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdStretchCol) {
			util.addValue(17, col, "MD Stretch", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdCdTensileRatioCol) {
			util.addValue(17, col, "Tensile Ratio", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "MD/CD", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (wdRationCol) {
			util.addValue(17, col, "W/D Ratio", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "CD Wet/Dry", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		col = 0;
		int row = 19;
		short rowhieght2 = 3000;

		// Data

		double basisWeightAvg = 0;
		double birghtnessAvg = 0;
		double bulkAvg = 0;
		double mdTensileAvg = 0;
		double mdWetAvg = 0;
		double cdTensileAvg = 0;
		double cdWetAvg = 0;
		double mdStretchAvg = 0;
		double mdCdTensileRatioAvg = 0;
		double wdRationAvg = 0;

		for (Reel reel : reels1) {
			util.addValue(row, col++, dateFormat.format(reel.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowhieght2);
			util.addValue(row, col++, timeFormat.format(reel.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowhieght2);
			util.addValue(row, col++, CommonUtil.checkNull(reel.getGradeCode()),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowhieght2);
			util.addValue(row, col++, reel.getReel(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowhieght2);

			if (col == 4) {
				List<Rewdinder> rewdinders1 = certificateAnalysisService.getRewindersByReel(reel.getReel(), dateFrom,
						dateTo, customer);

				StringBuffer sb = new StringBuffer();
				for (Rewdinder reel2 : rewdinders1) {
					sb.append(reel2.getRollId() + "\n");
				}
				util.addValue(row, 4, sb.toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowhieght2);
			}

			// util.addValue(row, col++, reel.getRollId(),
			// Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowhieght2);
			col++;
			if (basisWeightCol) {
				util.addValue(row, col++, reel.getActualBasisWt(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowhieght2);
				basisWeightAvg += reel.getActualBasisWt();
			}

			if (birghtnessCol) {
				util.addValue(row, col++, reel.getBrightness(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowhieght2);
				birghtnessAvg += reel.getBrightness();
			}

			if (bulkCol) {
				util.addValue(row, col++, reel.getBulk(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowhieght2);
				bulkAvg += reel.getBulk();
			}

			if (mdTensileCol) {
				util.addValue(row, col++, reel.getMdTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowhieght2);
				mdTensileAvg += reel.getMdTensile();
			}

			if (mdWetCol) {
				util.addValue(row, col++, reel.getMdWetTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowhieght2);
				mdWetAvg += reel.getMdWetTensile();
			}

			if (cdTensileCol) {
				util.addValue(row, col++, reel.getCdTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowhieght2);
				cdTensileAvg += reel.getCdTensile();
			}

			if (cdWetCol) {
				util.addValue(row, col++, reel.getCdWetTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowhieght2);
				cdWetAvg += reel.getCdWetTensile();
			}

			if (mdStretchCol) {
				util.addValue(row, col++, reel.getMdStretch(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowhieght2);
				mdStretchAvg += reel.getMdStretch();
			}

			if (mdCdTensileRatioCol) {
				util.addValue(row, col++, reel.getMdcdTensileRatio(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowhieght2);
				mdCdTensileRatioAvg += reel.getMdcdTensileRatio();
			}

			if (wdRationCol) {
				util.addValue(row, col++, reel.getWetDryRatio(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						rowhieght2);
				wdRationAvg += reel.getWetDryRatio();
			}

			col = 0;
			row++;
		}

		col = 0;

		util.mergeCell(row, row, 0, 3);
		util.addValue(row, col++, "Average", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		col++;
		col++;
		col++;

		int len = reels1.size();

		if (basisWeightCol) {
			util.addValue(row, col++, CommonUtil.round(basisWeightAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (birghtnessCol) {
			util.addValue(row, col++, CommonUtil.round(birghtnessAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (bulkCol) {
			util.addValue(row, col++, CommonUtil.round(bulkAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (mdTensileCol) {
			util.addValue(row, col++, CommonUtil.round(mdTensileAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (mdWetCol) {
			util.addValue(row, col++, CommonUtil.round(mdWetAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (cdTensileCol) {
			util.addValue(row, col++, CommonUtil.round(cdTensileAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (cdWetCol) {
			util.addValue(row, col++, CommonUtil.round(cdWetAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (mdStretchCol) {
			util.addValue(row, col++, CommonUtil.round(mdStretchAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (mdCdTensileRatioCol) {
			util.addValue(row, col++, CommonUtil.round(mdCdTensileRatioAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (wdRationCol) {
			util.addValue(row, col++, CommonUtil.round(wdRationAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		row = row + 4;

		util.addValue(row++, 10, "Thank You,", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "Quality Manager", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "quality@sttissuellc.com", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER,
				rowHeight);
		util.addValue(row++, 10, "757-304-5041", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);

		util.write(outputStream);

	}

	/**
	 * @param customer
	 * @param fi
	 * @param reels
	 * @param xlsfile
	 * @param sDate
	 * @param eDate
	 * @param outputStream
	 * @throws IOException
	 */
	public void createReportExcelWeekly(String customer, InputStream fi, Date dateFrom, Date dateTo,
			List<Rewdinder> reels, File xlsfile, FileOutputStream outputStream) throws IOException {
		Workbook2007Util util = new Workbook2007Util();
		List<Rewdinder> rewdinders1 = null;	
		short rowHeight = 320;
		util.createlogo(fi, 6, 1);
		util.addValue(9, 2, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(10, 2, "Customer", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(9, 3, dateFormat.format(new Date()), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.setAutoSizeColumn(3);
		util.addValue(10, 3, CommonUtil.checkNull(customer), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.setAutoSizeColumn(3);
		List<Reel> reels1 = new ArrayList<Reel>();
		if (reels != null && reels.size() > 0) {
			for (Rewdinder reelNew : reels) {
				List<Reel> reelList2 = reelService.getReelByReelNo(String.valueOf(reelNew.getReel()), dateFrom, dateTo);
				for (Reel reel : reelList2) {
					rewdinders1 = certificateAnalysisService.getRewindersByReel(reel.getReel(), dateFrom, dateTo, customer);
					if(!rewdinders1.isEmpty())
					{
						for (Rewdinder rewdinder : rewdinders1) {
							if(!rewdinder.getRollId().isEmpty()) {
								reel.setRewdinders(rewdinders1);
							}
						}
						reels1.add(reel);
					}
					
				}
			}
		}
		boolean basisWeightCol = false;
		boolean birghtnessCol = false;
		boolean bulkCol = false;
		boolean mdTensileCol = false;
		boolean mdWetCol = false;
		boolean cdTensileCol = false;
		boolean cdWetCol = false;
		boolean mdStretchCol = false;
		boolean mdCdTensileRatioCol = false;
		boolean wdRationCol = false;
		if (reels1.size() > 0) {
			for (Reel reel2 : reels1) {
				if (reel2.getActualBasisWt() > 0) {
					if (!basisWeightCol) {
						basisWeightCol = true;
					}
				}

				if (reel2.getBrightness() > 0) {
					if (!birghtnessCol) {
						birghtnessCol = true;
					}
				}

				if (reel2.getBulk() > 0) {
					if (!bulkCol) {
						bulkCol = true;
					}
				}

				if (reel2.getMdTensile() > 0) {
					if (!mdTensileCol) {
						mdTensileCol = true;
					}
				}

				if (reel2.getMdWetTensile() > 0) {
					if (!mdWetCol) {
						mdWetCol = true;
					}
				}

				if (reel2.getCdTensile() > 0) {
					if (!cdTensileCol) {
						cdTensileCol = true;
					}
				}

				if (reel2.getCdWetTensile() > 0) {
					if (!cdWetCol) {
						cdWetCol = true;
					}
				}

				if (reel2.getMdcdTensileRatio() > 0) {
					if (!mdCdTensileRatioCol) {
						mdCdTensileRatioCol = true;
					}
				}

				if (reel2.getWetDryRatio() > 0) {
					if (!wdRationCol) {
						wdRationCol = true;
					}
				}

				if (reel2.getMdStretch() > 0) {
					if (!mdStretchCol) {
						mdStretchCol = true;
					}
				}
			}
		}

		int col = 0;
		short headerRowHeight = (short) (rowHeight + 400);
		util.addValue(17, col, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(17, col, "Time", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(17, col, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(17, col, "Reel#", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(17, col, "Roll#", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		if (basisWeightCol) {
			util.addValue(17, col, "Basis Weight", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "lbs/3000ft", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}
		if (birghtnessCol) {
			util.addValue(17, col, "Brightness", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}
		if (bulkCol) {
			util.addValue(17, col, "Bulk", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "mils/8ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}
		if (mdTensileCol) {
			util.addValue(17, col, "MD Tensile", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdWetCol) {
			util.addValue(17, col, "MD WET", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (cdTensileCol) {
			util.addValue(17, col, "CD Tensile", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (cdWetCol) {
			util.addValue(17, col, "CD WET", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdStretchCol) {
			util.addValue(17, col, "MD Stretch", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdCdTensileRatioCol) {
			util.addValue(17, col, "Tensile Ratio", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "MD/CD", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (wdRationCol) {
			util.addValue(17, col, "W/D Ratio", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "CD Wet/Dry", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		col = 0;
		int row = 19;
		double basisWeightAvg = 0;
		double birghtnessAvg = 0;
		double bulkAvg = 0;
		double mdTensileAvg = 0;
		double mdWetAvg = 0;
		double cdTensileAvg = 0;
		double cdWetAvg = 0;
		double mdStretchAvg = 0;
		double mdCdTensileRatioAvg = 0;
		double wdRationAvg = 0;
		short hight = 285;
		short roehight2 = 3000;
		for (Reel reel : reels1) {
			util.addValue(row, col++, dateFormat.format(reel.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					hight);
			util.setAutoSizeColumn(col);
			util.addValue(row, col++, timeFormat.format(reel.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(reel.getGradeCode()),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.setAutoSizeColumn(col);
			util.addValue(row, col++, reel.getReel(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);		
			if (col == 4) {
				StringBuffer sb = new StringBuffer();
				for (Rewdinder reel2 : reel.getRewdinders()) {
					sb.append(reel2.getRollId() + "\n");
				}
				util.addValue(row, 4, sb.toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);

			}
			util.setAutoSizeColumn(4);
			col++;
			if (basisWeightCol) {
				util.addValue(row, col++, reel.getActualBasisWt(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						roehight2);
				basisWeightAvg += reel.getActualBasisWt();
			}

			if (birghtnessCol) {
				util.addValue(row, col++, reel.getBrightness(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				birghtnessAvg += reel.getBrightness();
			}

			if (bulkCol) {
				util.addValue(row, col++, reel.getBulk(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				bulkAvg += reel.getBulk();
			}

			if (mdTensileCol) {
				util.addValue(row, col++, reel.getMdTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				mdTensileAvg += reel.getMdTensile();
			}

			if (mdWetCol) {
				util.addValue(row, col++, reel.getMdWetTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						roehight2);
				mdWetAvg += reel.getMdWetTensile();
			}

			if (cdTensileCol) {
				util.addValue(row, col++, reel.getCdTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				cdTensileAvg += reel.getCdTensile();
			}

			if (cdWetCol) {
				util.addValue(row, col++, reel.getCdWetTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						roehight2);
				cdWetAvg += reel.getCdWetTensile();
			}

			if (mdStretchCol) {
				util.addValue(row, col++, reel.getMdStretch(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				mdStretchAvg += reel.getMdStretch();
			}

			if (mdCdTensileRatioCol) {
				util.addValue(row, col++, reel.getMdcdTensileRatio(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						roehight2);
				mdCdTensileRatioAvg += reel.getMdcdTensileRatio();
			}

			if (wdRationCol) {
				util.addValue(row, col++, reel.getWetDryRatio(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				wdRationAvg += reel.getWetDryRatio();
			}

			col = 0;
			row++;
		}

		col = 0;

		util.mergeCell(row, row, 0, 4);
		util.addValue(row, col++, "Average", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		col++;
		col++;
		col++;
		col++;
		int len = reels1.size();

		if (basisWeightCol) {
			util.addValue(row, col++, CommonUtil.round(basisWeightAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (birghtnessCol) {
			util.addValue(row, col++, CommonUtil.round(birghtnessAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (bulkCol) {
			util.addValue(row, col++, CommonUtil.round(bulkAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (mdTensileCol) {
			util.addValue(row, col++, CommonUtil.round(mdTensileAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (mdWetCol) {
			util.addValue(row, col++, CommonUtil.round(mdWetAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (cdTensileCol) {
			util.addValue(row, col++, CommonUtil.round(cdTensileAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (cdWetCol) {
			util.addValue(row, col++, CommonUtil.round(cdWetAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (mdStretchCol) {
			util.addValue(row, col++, CommonUtil.round(mdStretchAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (mdCdTensileRatioCol) {
			util.addValue(row, col++, CommonUtil.round(mdCdTensileRatioAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (wdRationCol) {
			util.addValue(row, col++, CommonUtil.round(wdRationAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		row = row + 4;

		util.addValue(row++, 10, "Thank You,", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "Quality Manager", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "quality@sttissuellc.com", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER,
				rowHeight);
		util.addValue(row++, 10, "757-304-5041", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);

		// util.write(outputStream);
		util.write(outputStream);

	}

	/**
	 * @param customer
	 * @param fi
	 * @param sDate
	 * @param eDate
	 * @param reels
	 * @param xlsfile
	 * @param outputStream
	 * @throws IOException
	 */
	public void createReportExcelWeekly_Pm5(String customer, InputStream fi, Date dateFrom, Date dateTo,
			List<Rewdinder> reels, File xlsfile, FileOutputStream outputStream) throws IOException {

		// Workbook2007Util util=new Workbook2007Util(file, 0);
		Workbook2007Util util = new Workbook2007Util();

		// short rowHeight=280;
		short rowHeight = 320;
		util.createlogo(fi, 6, 1);
		// util.addValue(4, 8, "STTissue", Workbook2007Util.Style.STYLE_BOLD_CENTER,
		// rowHeight);
		// util.setpicture();
		// util.setpicture();
		util.addValue(9, 2, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(10, 2, "Customer", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(9, 3, dateFormat.format(new Date()), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.setAutoSizeColumn(3);
		util.addValue(10, 3, CommonUtil.checkNull(customer), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.setAutoSizeColumn(3);
		List<Reel> reels1 = new ArrayList<Reel>();
		List<Rewdinder> rewdinders1 = null;
		if (reels != null && reels.size() > 0) {
			for (Rewdinder reelNew : reels) {
				List<Reel> reelList2 = reelService.getReelByReelNopm5(String.valueOf(reelNew.getReel()), dateFrom, dateTo);
				for (Reel reel : reelList2) {
					rewdinders1 = certificateAnalysisService.getRewindersByReel_Pm5(reel.getReel(), dateFrom, dateTo, customer);
					if(!rewdinders1.isEmpty())
					{
						for (Rewdinder rewdinder : rewdinders1) {
							if(!rewdinder.getRollId().isEmpty()) {
								reel.setRewdinders(rewdinders1);
							}
						}
						reels1.add(reel);
					}
					
				}
			}
		}
		boolean basisWeightCol = false;
		boolean birghtnessCol = false;
		boolean bulkCol = false;
		boolean mdTensileCol = false;
		boolean mdWetCol = false;
		boolean cdTensileCol = false;
		boolean cdWetCol = false;
		boolean mdStretchCol = false;
		boolean mdCdTensileRatioCol = false;
		boolean wdRationCol = false;

		if (reels1.size() > 0) {
			for (Reel reel2 : reels1) {
				if (reel2.getActualBasisWt() > 0) {
					if (!basisWeightCol) {
						basisWeightCol = true;
					}
				}

				if (reel2.getBrightness() > 0) {
					if (!birghtnessCol) {
						birghtnessCol = true;
					}
				}

				if (reel2.getBulk() > 0) {
					if (!bulkCol) {
						bulkCol = true;
					}
				}

				if (reel2.getMdTensile() > 0) {
					if (!mdTensileCol) {
						mdTensileCol = true;
					}
				}

				if (reel2.getMdWetTensile() > 0) {
					if (!mdWetCol) {
						mdWetCol = true;
					}
				}

				if (reel2.getCdTensile() > 0) {
					if (!cdTensileCol) {
						cdTensileCol = true;
					}
				}

				if (reel2.getCdWetTensile() > 0) {
					if (!cdWetCol) {
						cdWetCol = true;
					}
				}

				if (reel2.getMdcdTensileRatio() > 0) {
					if (!mdCdTensileRatioCol) {
						mdCdTensileRatioCol = true;
					}
				}

				if (reel2.getWetDryRatio() > 0) {
					if (!wdRationCol) {
						wdRationCol = true;
					}
				}

				if (reel2.getMdStretch() > 0) {
					if (!mdStretchCol) {
						mdStretchCol = true;
					}
				}
			}
		}

		int col = 0;
		short headerRowHeight = (short) (rowHeight + 400);
		util.addValue(17, col, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Time", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		util.addValue(17, col, "Reel#", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(17, col, "Roll#", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		util.addValue(18, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);

		if (basisWeightCol) {
			util.addValue(17, col, "Basis Weight", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "lbs/3000ft", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (birghtnessCol) {
			util.addValue(17, col, "Brightness", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (bulkCol) {
			util.addValue(17, col, "Bulk", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "mils/8ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdTensileCol) {
			util.addValue(17, col, "MD Tensile", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdWetCol) {
			util.addValue(17, col, "MD WET", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (cdTensileCol) {
			util.addValue(17, col, "CD Tensile", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (cdWetCol) {
			util.addValue(17, col, "CD WET", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "g/inch 1ply", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdStretchCol) {
			util.addValue(17, col, "MD Stretch", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (mdCdTensileRatioCol) {
			util.addValue(17, col, "Tensile Ratio", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "MD/CD", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		if (wdRationCol) {
			util.addValue(17, col, "W/D Ratio", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
			util.addValue(18, col++, "CD Wet/Dry", Workbook2007Util.Style.STYLE_BOLD_CENTER, headerRowHeight);
		}

		col = 0;
		int row = 19;

		// Data

		double basisWeightAvg = 0;
		double birghtnessAvg = 0;
		double bulkAvg = 0;
		double mdTensileAvg = 0;
		double mdWetAvg = 0;
		double cdTensileAvg = 0;
		double cdWetAvg = 0;
		double mdStretchAvg = 0;
		double mdCdTensileRatioAvg = 0;
		double wdRationAvg = 0;
		short hight = 285;
		short roehight2 = 3000;
		for (Reel reel : reels1) {
			util.addValue(row, col++, dateFormat.format(reel.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					hight);
			util.setAutoSizeColumn(col);
			util.addValue(row, col++, timeFormat.format(reel.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(reel.getGradeCode()),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.setAutoSizeColumn(col);
			util.addValue(row, col++, reel.getReel(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if (col == 4) {
				StringBuffer sb = new StringBuffer();
				for (Rewdinder reel2 : reel.getRewdinders()) {
					sb.append(reel2.getRollId() + "\n");
				}
				util.addValue(row, 4, sb.toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
			}
			util.setAutoSizeColumn(4);
			col++;
			if (basisWeightCol) {
				util.addValue(row, col++, reel.getActualBasisWt(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						roehight2);
				basisWeightAvg += reel.getActualBasisWt();
			}

			if (birghtnessCol) {
				util.addValue(row, col++, reel.getBrightness(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				birghtnessAvg += reel.getBrightness();
			}

			if (bulkCol) {
				util.addValue(row, col++, reel.getBulk(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				bulkAvg += reel.getBulk();
			}

			if (mdTensileCol) {
				util.addValue(row, col++, reel.getMdTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				mdTensileAvg += reel.getMdTensile();
			}

			if (mdWetCol) {
				util.addValue(row, col++, reel.getMdWetTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						roehight2);
				mdWetAvg += reel.getMdWetTensile();
			}

			if (cdTensileCol) {
				util.addValue(row, col++, reel.getCdTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				cdTensileAvg += reel.getCdTensile();
			}

			if (cdWetCol) {
				util.addValue(row, col++, reel.getCdWetTensile(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						roehight2);
				cdWetAvg += reel.getCdWetTensile();
			}

			if (mdStretchCol) {
				util.addValue(row, col++, reel.getMdStretch(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				mdStretchAvg += reel.getMdStretch();
			}

			if (mdCdTensileRatioCol) {
				util.addValue(row, col++, reel.getMdcdTensileRatio(), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
						roehight2);
				mdCdTensileRatioAvg += reel.getMdcdTensileRatio();
			}

			if (wdRationCol) {
				util.addValue(row, col++, reel.getWetDryRatio(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, roehight2);
				wdRationAvg += reel.getWetDryRatio();
			}

			col = 0;
			row++;
		}

		col = 0;

		util.mergeCell(row, row, 0, 4);
		util.addValue(row, col++, "Average", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		col++;
		col++;
		col++;
		col++;
		col++;
		int len = reels1.size();

		if (basisWeightCol) {
			util.addValue(row, col++, CommonUtil.round(basisWeightAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (birghtnessCol) {
			util.addValue(row, col++, CommonUtil.round(birghtnessAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (bulkCol) {
			util.addValue(row, col++, CommonUtil.round(bulkAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (mdTensileCol) {
			util.addValue(row, col++, CommonUtil.round(mdTensileAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (mdWetCol) {
			util.addValue(row, col++, CommonUtil.round(mdWetAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (cdTensileCol) {
			util.addValue(row, col++, CommonUtil.round(cdTensileAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (cdWetCol) {
			util.addValue(row, col++, CommonUtil.round(cdWetAvg / len, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER,
					rowHeight);
		}

		if (mdStretchCol) {
			util.addValue(row, col++, CommonUtil.round(mdStretchAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (mdCdTensileRatioCol) {
			util.addValue(row, col++, CommonUtil.round(mdCdTensileRatioAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		if (wdRationCol) {
			util.addValue(row, col++, CommonUtil.round(wdRationAvg / len, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}

		row = row + 4;

		util.addValue(row++, 10, "Thank You,", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "Quality Manager", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);
		util.addValue(row++, 10, "quality@sttissuellc.com", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER,
				rowHeight);
		util.addValue(row++, 10, "757-304-5041", Workbook2007Util.Style.STYLE_NORMAL_LEFT_NOBORDER, rowHeight);

		// util.write(outputStream);
		util.write(outputStream);

	}

}
