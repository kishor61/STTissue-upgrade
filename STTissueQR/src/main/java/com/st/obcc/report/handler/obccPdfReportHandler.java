/**
 *Sep 6, 2016
 *obccPdfReportHandler.java
 * TODO
 *com.st.obcc.report.handler
 *obccPdfReportHandler.java
 *Roshan Lal Tailor
 */
package com.st.obcc.report.handler;

import java.awt.Color;
import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.common.pdfutil.PdfStyle;
import com.st.obcc.model.BackTender;
import com.st.obcc.model.MachineTender;
import com.st.obcc.model.OperatorData;
import com.st.obcc.model.R1Operator;
import com.st.obcc.model.StockOperator;
import com.st.obcc.model.UtilityOperator;

/**
 * @author roshan
 *
 */
@Component
public class obccPdfReportHandler {

	public void createR2Pdf(List<OperatorData> datas, OutputStream outputStream,long l)
			throws Exception {

		PdfReportUtil pdfUtil = new PdfReportUtil(15f, 15f, 10f, 10f);

		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("R2 Operator With "+l+"% Data");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
		pdfUtil.open();

		if (datas.size() != 0) {
			Table table = pdfUtil.new Table(6, new float[] { 1, 1, 1, 1, 1, 1 });

			// int i = 1;
			// pdfUtil.setPage(i);
			table.addCell("OBCC Completed = "+l+"%", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,
					6, 1, 0);
			for (OperatorData data : datas) {
				// pdfUtil.addCheckBox(data.isMovementcol1());

				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,
						6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,
						6, 1, 0);
				table.addCell("Operator Basic Care CheckList",
						PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 6, 1, 1,
						5, 5, 5, 5, new Color(203, 132, 46, 96));

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,
						PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder(
						data.getPosition()
								+ ":-"
								+ CommonUtil.capitalizeFirstLetter(data
										.getOperatorname()),
						PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,
						PdfStyle.ALIGN_RIGHT, 3, 1, 0);
				table.addCell("Date:-" + data.getEdate(),
						PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 2, 1, 0);
				table.addCellRightBorder(
						"Shift:-"
								+ CommonUtil.capitalizeFirstLetter(data
										.getShift()), PdfStyle.FONT_BOLD_12,
						PdfStyle.ALIGN_RIGHT, 1, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,
						PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder("Crew:-" + data.getCrew(),
						PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,
						PdfStyle.ALIGN_RIGHT, 5, 1, 0);
				table.addCellRightBorder("", PdfStyle.FONT_BOLD_12,
						PdfStyle.ALIGN_RIGHT, 1, 1, 0);

				table.addCell("Description", PdfStyle.FONT_BOLD_12,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Check Point", PdfStyle.FONT_BOLD_12,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Remarks", PdfStyle.FONT_BOLD_12,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("WINDER DECK STOPS", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(
								169, 169, 169, 0));

				table.addCell("Movement", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isMovementcol1() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getMovementcol1desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("CONVEYOR", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(
								169, 169, 169, 0));

				table.addCell("Chain Link/Pins", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isConveyorcol1() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getConveyorcol1desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("Conveyor Sections", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isConveyorcol2() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getConveyorcol2desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("Motor - Overheating", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isConveyorcol3() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getConveyorcol3desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("Motor - Abnormal Sound	", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isConveyorcol4() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getConveyorcol4desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("PLC Control Panel", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isConveyorcol5() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getConveyorcol5desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("CORE SAW", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(
								169, 169, 169, 0));

				table.addCell("Power", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isPowercol1() == true) {
					table.addCell("On", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Off", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getPowercol1desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("Blade", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isPowercol2() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getPowercol2desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("Vacuum", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isPowercol3() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getPowercol3desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("Size Adjustment Movement",
						PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isPowercol4() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getPowercol4desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("CORES", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(
								169, 169, 169, 0));

				table.addCell("Correct Size For Order", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isOrdercol1() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getOrdercol1desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				/* This is for page Break */

				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,
						6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,
						6, 1, 0);

			}

			table.finish();
		} else {
			System.out.println("size is zero");
		}

		pdfUtil.close();
	}

	public void createUtilityOperatorPdf(List<UtilityOperator> datas,
			OutputStream outputStream,long l) throws Exception {

		PdfReportUtil pdfUtil = new PdfReportUtil(15f, 15f, 10f, 10f);

		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Utility Operator");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
		pdfUtil.open();

		if (datas.size() != 0) {
			Table table = pdfUtil.new Table(6, new float[] { 1, 1, 1, 1, 1, 1 });

			int i = 0;
			// pdfUtil.setPage(i);
			table.addCell("OBCC Completed = "+l+"%", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			for (UtilityOperator data : datas) {
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);

				table.addCell("Operator Basic Care CheckList",PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 6, 1, 1,5, 5, 5, 5, new Color(203, 132, 46, 96));

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder(CommonUtil.capitalizeFirstandSecondFirstLetter(data.getPosition())+ ":-"+ CommonUtil.capitalizeFirstLetter(data.getOperatorName()),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 3, 1, 0);
				table.addCell("Date:-" + data.getEdate(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 2, 1, 0);
				table.addCellRightBorder("Shift:-"+ CommonUtil.capitalizeFirstLetter(data.getShift()), PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder("Crew:-" + data.getCrew(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCell("Description", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Check Point", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Remarks", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("WRAPPER - WULFTEC NORTH", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));

				table.addCell("TOWER", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isWrapperFoxCol1() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWrapperFoxCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("STRETCH WRAP DRIVE ASSEMBLY",PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isWrapperFoxCol2() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWrapperFoxCol2Desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("CONTROL PANEL", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isWrapperFoxCol3() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWrapperFoxCol3Desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
/**
				table.addCell("Motor - Overheating", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isWrapperFoxCol4() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWrapperFoxCol4Desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
***/
				table.addCell("Motor - Abnormal Sound", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isWrapperFoxCol5() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWrapperFoxCol5Desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("WRAPPER - WULFTEC SOUTH", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(
								169, 169, 169, 0));

				table.addCell("TOWER", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isWrapperWuftechCol1() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWrapperWuftechCol1Desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("STRETCH WRAP DRIVE ASSEMBLY",
						PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isWrapperWuftechCol2() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWrapperWuftechCol2Desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("CONTROL PANEL", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isWrapperWuftechCol3() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWrapperWuftechCol3Desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
/****
				table.addCell("Motor - Overheating", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isWrapperWuftechCol4() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWrapperWuftechCol4Desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
***/
				table.addCell("Motor - Abnormal Sound", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isWrapperWuftechCol5() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWrapperWuftechCol5Desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("TURN TABLE", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isWrapperWuftechCol6() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWrapperWuftechCol6Desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("SCALE", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(
								169, 169, 169, 0));

				table.addCell("CONTROL PANEL", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isScaleCol1() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getScaleCol1Desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("SCALE PLATFORM", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isScaleCol2() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getScaleCol2Desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("AUTOMATIC WEIGHT INPUT", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isScaleCol3() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getScaleCol3Desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("WEIGHT VERIFIED", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isScaleCol4() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getScaleCol4Desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				/* This is for page Break */

				if (i == 0) {
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);

					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
					table.addCell("", PdfStyle.FONT_BOLD_12,
							PdfStyle.ALIGN_RIGHT, 6, 1, 0);
				}
				i++;

			}

			table.finish();
		} else {
			System.out.println("size is zero");
		}

		pdfUtil.close();

	}

	public void createR1OperatorPdf(List<R1Operator> datas,OutputStream outputStream,long l) throws Exception {

		PdfReportUtil pdfUtil = new PdfReportUtil(15f, 15f, 10f, 10f);

		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("R1 Operator");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
		pdfUtil.open();
		
		
		if (datas.size() != 0) {
			Table table = pdfUtil.new Table(6, new float[] { 1, 1, 1, 1, 1, 1 });

			int i = 0;
			// pdfUtil.setPage(i);
			table.addCell("OBCC Completed = "+l+"%", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			for (R1Operator data : datas) {
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				
				
				table.addCell("Operator Basic Care CheckList",PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 6, 1, 1,5, 5, 5, 5, new Color(203, 132, 46, 96));

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder(CommonUtil.capitalizeFirstLetter(data.getPosition())+ ":-"+ CommonUtil.capitalizeFirstLetter(data.getOperatorName()),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 3, 1, 0);
				table.addCell("Date:-" + data.getEdate(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 2, 1, 0);
				table.addCellRightBorder("Shift:-"+ CommonUtil.capitalizeFirstLetter(data.getShift()), PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder("Crew:-" + data.getCrew(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCell("Description", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Check Point", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Remarks", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("LEAD-IN ROLL", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				 
				
				table.addCell("BEARINGS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.getLeadInRollCol1() != null) {
					table.addCell("Over Heating :"+data.getLeadInRollCol1(), PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getLeadInRollCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isLeadInRollCol2() == true) {table.addCell("Oil Leakage : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Oil Leakage : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getLeadInRollCol2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isLeadInRollCol3() == true) {table.addCell("Abnormal Sound : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getLeadInRollCol3Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("MOTOR FOR LEAD-IN ROLL", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.getLeadInRollCol4() != null) {
					table.addCell("Over Heating :"+data.getLeadInRollCol4(), PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getLeadInRollCol4Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				 table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isLeadInRollCol5() == true) {table.addCell("Abnormal Sound : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getLeadInRollCol5Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("SECTIONAL ROLL", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				table.addCell("BEARINGS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSectionRollCol1() == true) {table.addCell("Free Turning : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Free Turning : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
				table.addCell(data.getSectionRollCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("BREAK ASSEMBLY", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				table.addCell("AIR LINES", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isBreakAssemblyCol1() == true) {table.addCell("Leakage : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Leakage : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getBreakAssemblyCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				/*****
				table.addCell("BRAKE SHOES", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isBreakAssemblyCol2() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getBreakAssemblyCol2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				***/
				table.addCell("SLITTERS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				table.addCell("MOTORS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSlittersCol1() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getSlittersCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("ANVILS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSlittersCol2() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getSlittersCol2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("SLITTER BLADES", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSlittersCol3() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getSlittersCol3Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("TRIM ASSEMBLY", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				
				table.addCell("CHUTE", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isTrimAssemblyCol1() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getTrimAssemblyCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				/***
				
				table.addCell("BLOWER MOTOR", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isTrimAssemblyCol2() == true) {table.addCell("Over Heating : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getTrimAssemblyCol2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isTrimAssemblyCol3() == true) {table.addCell("Abnormal Sound : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getTrimAssemblyCol3Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("BLOWER BELTS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isTrimAssemblyCol4() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getTrimAssemblyCol4Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				***/
				table.addCell("TENSION ROLL", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				table.addCell("BEARINGS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isTensiionRollCol1() == true) {table.addCell("Free Truning :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Free Truning:No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getTensiionRollCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("SECTIONS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isTensiionRollCol2() == true) {table.addCell("Build-Up :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Build-Up:No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getTensiionRollCol2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("PLC PANEL READOUT", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isTensiionRollCol3() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getTensiionRollCol3Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("WINDER DRUM #1", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				
				table.addCell("BEARINGS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.getWinderDrum1Col1() != null) {table.addCell("Over Heating :"+data.getWinderDrum1Col1(), PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum1Col1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWinderDrum1Col2() == true) {table.addCell("Oil Leakage :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Oil Leakage :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum1Col2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWinderDrum1Col3() == true) {table.addCell("Abnormal Sound :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum1Col3Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("MOTOR", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.getWinderDrum1Col4() != null) {table.addCell("Over Heating :"+data.getWinderDrum1Col4(), PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum1Col4Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWinderDrum1Col5() == true) {table.addCell("Abnormal Sound :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum1Col5Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
			/*	table.addCell("GEAR REDUCER", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWinderDrum1Col6() == true) {table.addCell("Over Heating :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum1Col6Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWinderDrum1Col7() == true) {table.addCell("Abnormal Sound :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum1Col7Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);*/
				 	
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				
				/*table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);*/
				 
				table.addCell("WINDER DRUM #2", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				
				table.addCell("BEARINGS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.getWinderDrum2Col1() != null) {table.addCell("Over Heating :"+data.getWinderDrum2Col1(), PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum2Col1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWinderDrum2Col2() == true) {table.addCell("Oil Leakage :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Oil Leakage :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum2Col2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWinderDrum2Col3() == true) {table.addCell("Abnormal Sound :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum2Col3Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("MOTOR", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.getWinderDrum2Col4() != null) {table.addCell("Over Heating :"+data.getWinderDrum2Col4(), PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum2Col4Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWinderDrum2Col5() == true) {table.addCell("Abnormal Sound :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum2Col5Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				/*table.addCell("GEAR REDUCER", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWinderDrum2Col6() == true) {table.addCell("Over Heating :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum2Col6Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWinderDrum2Col7() == true) {table.addCell("Abnormal Sound :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWinderDrum2Col7Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);*/
				
				
				
				table.addCell("ROLL EJECTOR", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));	
				
				
				table.addCell("AIR LINES", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRollEjectorCol1() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getRollEjectorCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("SWITCHES", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRollEjectorCol2() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getRollEjectorCol2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				/***
				table.addCell("MECHANICAL", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRollEjectorCol3() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getRollEjectorCol3Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				***/
				
				table.addCell("RIDER ROLL", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));	
				 
				/****
				table.addCell("BEARINGS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRiderRollCol1() == true) {table.addCell("Over Heating :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getRiderRollCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRiderRollCol2() == true) {table.addCell("Oil Leakage :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Oil Leakage :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getRiderRollCol2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRiderRollCol3() == true) {table.addCell("Abnormal Sound :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getRiderRollCol3Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				***/
				
				
				table.addCell("MOTOR", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.getRiderRollCol4() != null) {table.addCell("Over Heating :"+data.getRiderRollCol4(), PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getRiderRollCol4Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRiderRollCol5() == true) {table.addCell("Abnormal Sound :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getRiderRollCol5Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("BELTS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRiderRollCol6() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getRiderRollCol6Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				/****
				table.addCell("MOVEMENT", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRiderRollCol7() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getRiderRollCol7Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				****/
				table.addCell("LOCKING DEVICE", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRiderRollCol8() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getRiderRollCol8Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("BOWED ROLL", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				
				table.addCell("MOTOR", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.getBowedRollCol1() != null) {table.addCell("Over Heating :"+data.getBowedRollCol1(), PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Over Heating :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getBowedRollCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isBowedRollCol2() == true) {table.addCell("Abnormal Sound :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getBowedRollCol2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("BELTS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isBowedRollCol3() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getBowedRollCol3Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("CORE CHUCKS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				
				table.addCell("BEARINGS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCoreChucksCol1() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getCoreChucksCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				/***
				table.addCell("MOVEMENT", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCoreChucksCol2() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getCoreChucksCol2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				table.addCell("HYDRAULIC CONTROLS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCoreChucksCol3() == true) {table.addCell("Leakage :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Leakage :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getCoreChucksCol3Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCoreChucksCol4() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getCoreChucksCol4Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				***/
				
				table.addCell("NIP GUARD", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				table.addCell("MOVEMENT", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isNipGuardCol1() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getNipGuardCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				/***
				table.addCell("HYDRAULIC CONTROLS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isNipGuardCol2() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getNipGuardCol2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isNipGuardCol3() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getNipGuardCol3Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				***/
				table.addCell("TABLE LIFT GATE", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				 
				
				table.addCell("AIR LINES", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isTableLeftGateCol1() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getTableLeftGateCol1Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("MOVEMENT", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isTableLeftGateCol2() == true) {table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getTableLeftGateCol2Desc(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				
				}
			table.finish();
		}
		/*else{
			Table table = pdfUtil.new Table(6, new float[] { 1, 1, 1, 1, 1, 1 });
			table.addCell("We Are Unable To Generate The Report.Either Data Not Found Or Application in Under Maintenance.",PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 6, 1, 1,5, 5, 5, 5, new Color(203, 132, 46, 96));
			table.finish();
		}*/
		
		pdfUtil.close();
	}

public void createBackTernerOperatorPdf(List<BackTender> daydatas,List<BackTender> nightdatas,OutputStream outputStream, long l) throws Exception {
		

		PdfReportUtil pdfUtil = new PdfReportUtil(15f, 15f, 10f, 10f);

		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Back Tender Operator");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
		pdfUtil.open();
		
		Table table = pdfUtil.new Table(6, new float[] { 1, 1, 1, 1, 1, 1 });
		
		if (daydatas!=null && daydatas.size() != 0) {
			table.addCell("OBCC Completed = "+l+"%", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
		for (BackTender data : daydatas) {
			table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			 
			table.addCell("Operator Basic Care CheckList",PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 6, 1, 1,5, 5, 5, 5, new Color(203, 132, 46, 96));

			table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
			table.addCellRightBorder(CommonUtil.capitalizeFirstandSecondFirstLetter(data.getPosition())+ ":-"+ CommonUtil.capitalizeFirstLetter(data.getOperatorName()),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

			table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 3, 1, 0);
			table.addCell("Date:-" + data.getEdate(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 2, 1, 0);
			table.addCellRightBorder("Shift:-"+ CommonUtil.capitalizeFirstLetter(data.getShift()), PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);

			table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
			table.addCellRightBorder("Crew:-" + data.getCrew(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

			table.addCell("Description", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Check Point", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Remarks", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("Reel Hydraulic System", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
			 
			
			table.addCell("Tank Level", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);

			table.addCell(CommonUtil.replaceNull(data.getReelCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getReelCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			 
			table.addCell("Record Tank Oil Temperature", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getReelCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getReelCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Hydraulic Pump Abnormal sound", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Inbound :"+CommonUtil.replaceNull(data.getReelCol3Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell("Outbound : "+CommonUtil.replaceNull(data.getReelCol3Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getReelCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Hydraulic Moter Temparature C", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Temp:  "+CommonUtil.replaceNull(data.getShowerWaterCol7Inbound()), PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getReelCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
		    table.addCell("Guage Pressure", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Pressure:  "+CommonUtil.replaceNull(data.getReelCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getReelCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("Machine Lubrication System", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
			
			table.addCell("Record Lubrication tank Oil Leve", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Tank Oil Level:   "+CommonUtil.replaceNull(data.getMachineLubricationCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getMachineLubricationCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Record Tank Oil Temperature", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Tank Oil Temperature:    "+CommonUtil.replaceNull(data.getMachineLubricationCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getMachineLubricationCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			/**
			table.addCell("Record Tank Electrical Heaters Status", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);

		 	if (data.getMachineLubricationCol3() !=null) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getMachineLubricationCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			**/ 
	        table.addCell("Record Oil Filter inlet Temperature", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Tank Oil Temperature:     "+CommonUtil.replaceNull(data.getMachineLubricationCol4()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getMachineLubricationCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
			table.addCell("Verify Oil Filter Differential Pressure", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Pressure:      "+CommonUtil.replaceNull(data.getMachineLubricationCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getMachineLubricationCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
			table.addCell("Condensate system", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));	
			
			table.addCell("Low dryer condensate pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);

		 	if (data.isCondensateCol1() == true) {
		 		table.addCell("Abnormal Sound : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Abnormal Sound : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getCondensateCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	        
	        table.addCell("Low dryer condensate pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Temperature          Inbound :"+CommonUtil.replaceNull(data.getCondensateCol2Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCondensateCol2Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCondensateCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
			
			table.addCell("Condensate vacuum pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isCondensateCol3() == true) {
		 		table.addCell("Abnormal Sound : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Abnormal Sound : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getCondensateCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	        
	        table.addCell("Condensate vacuum pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Temperature          Inbound :"+CommonUtil.replaceNull(data.getCondensateCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCondensateCol4Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCondensateCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
			
			
			table.addCell("Roll bay air compressor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isCondensateCol5() == true) {
		 		table.addCell("Abnormal Sound : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Abnormal Sound : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getCondensateCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	        
	        table.addCell("Yankee separator drain", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isCondensateCol6() == true) {
		 		table.addCell("Open", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Close", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getCondensateCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        
	        
	        table.addCell("Yankee separator motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Temperature          Inbound :"+CommonUtil.replaceNull(data.getCondensateCol7Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCondensateCol7Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCondensateCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
			
			table.addCell("After dryer separator drain", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isCondensateCol8() == true) {
		 		table.addCell("Open", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Close", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getCondensateCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
	        table.addCell("After dryer separator motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Temperature          Inbound :"+CommonUtil.replaceNull(data.getCondensateCol9Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCondensateCol9Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCondensateCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        
			table.addCell("Ross Fulton Tank pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isCondensateCol10() == true) {
		 		table.addCell("Abnormal Sound : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Abnormal Sound : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getCondensateCol10Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
	        table.addCell("Ross Fulton Tank pump motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Temperature          Inbound :"+CommonUtil.replaceNull(data.getCondensateCol11Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCondensateCol11Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCondensateCol11Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
			 
			table.addCell("Condensate drain in IP line", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isCondensateCol12() == true) {
		 		table.addCell("Open", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Close", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getCondensateCol12Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	        
	        table.addCell("Atmospheric condensate tank pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isCondensateCol13() == true) {
		 		table.addCell("Abnormal Sound : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Abnormal Sound : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getCondensateCol13Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        

	        table.addCell("Atmospheric condensate tank pump motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Temperature          Inbound :"+CommonUtil.replaceNull(data.getCondensateCol14Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCondensateCol14Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCondensateCol14Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        /**
	        
			table.addCell("Sending Condensate to IP", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.getCondensateCol15() !=null) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getCondensateCol15Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	        table.addCell("Shower water system", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
	        
	        **/
	        
	        table.addCell("Warm water tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isShowerWaterCol1() == true) {
		 		table.addCell("Overflow :Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Overflow :No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        
	        
	        table.addCell("Wam water pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isShowerWaterCol2() == true) {
		 		table.addCell("Abnormal Sound : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Abnormal Sound : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        table.addCell("Wam water pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Temperature          Inbound :"+CommonUtil.replaceNull(data.getShowerWaterCol3Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell("Outbound : "+CommonUtil.replaceNull(data.getShowerWaterCol3Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
		 	table.addCell("Tepid water return Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isShowerWaterCol4() == true) {
		 		table.addCell("Abnormal Sound : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Abnormal Sound : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		
	        table.addCell("Tepid water return Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Temperature          Inbound :"+CommonUtil.replaceNull(data.getShowerWaterCol5Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell("Outbound : "+CommonUtil.replaceNull(data.getShowerWaterCol5Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			/***
			table.addCell("Flatbox sealpit Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isShowerWaterCol6() == true) {
		 		table.addCell("Abnormal Sound : Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Abnormal Sound : No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	        
	        table.addCell("Flatbox sealpit Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Temperature          Inbound :"+CommonUtil.replaceNull(data.getShowerWaterCol7Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell("Outbound : "+CommonUtil.replaceNull(data.getShowerWaterCol7Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        ***/
			table.addCell("River Water Filter inlet pressure", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Inlet Pressure  :"+CommonUtil.replaceNull(data.getShowerWaterCol8()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
			table.addCell("River Water Filter outlet pressure", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Outlet Pressure   :"+CommonUtil.replaceNull(data.getShowerWaterCol9()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Lubrication", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
			
			
			table.addCell("Tending-side SPR Bearing Oil Flow", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Sight-glass Setting    :"+CommonUtil.replaceNull(data.getLubricationCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getLubricationCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 
			
			table.addCell("Tending-side Yankee BRG Oil Flow", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Sight-glass Setting    :"+CommonUtil.replaceNull(data.getLubricationCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getLubricationCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("Tending-side SPR Internal BRG Oil Flow", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Sight-glass Setting    :"+CommonUtil.replaceNull(data.getLubricationCol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getLubricationCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("Drive-side Yankee Gear Box Oil Flow", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Sight-glass Setting    :"+CommonUtil.replaceNull(data.getLubricationCol4()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getLubricationCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("Drive-side Yankee GB Oil Flow", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Sight-glass Setting    :"+CommonUtil.replaceNull(data.getLubricationCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getLubricationCo5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("Drive-side Yankee Bearing Oil Flow", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Sight-glass Setting    :"+CommonUtil.replaceNull(data.getLubricationCol6()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getLubricationCo6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("Drive-side SPR Bearing Oil Flow", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Sight-glass Setting    :"+CommonUtil.replaceNull(data.getLubricationCol7()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getLubricationCo7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
		  
			table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
			
			table.addCell("Blow down Yankee catwalks, top of hood and hood duct work", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 
			table.addCell("Wash and clean floors from the  after dryers to refiners (T/S and D/S)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Clean basement from Loose paper when needed", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("Check Chemical totes and change if needed", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("At least 3 blades should be on top of blade platform and all used blades cut up by end of shift", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol6()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("Area around reel should be free from loose paper", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol7()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			 
			table.addCell("Skinning Doctor Loading Pressure(PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCondensateCol15()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCondensateCol15Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
			table.addCell("Creeping Doctor Loading Pressure(PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getMachineLubricationCol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getMachineLubricationCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
					
			
	        
			table.addCell("Verify Creeping Doctor Oscillation", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isAfterDryerCol4() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	       
	        table.addCell("Empty All wet end trash cans", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        if (data.isShowerWaterCol6() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	       
	        table.addCell("Blow off all machine drive motors ", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isShowerWaterCol11() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	       
	        
	        table.addCell("Felt Passivator Supply Tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Defoamer Supply Tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol6()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Adhesive Supply Tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getEqptScannerCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getEqptScannerCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Coating Supply Tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCheckbladechange()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCheckbladechangeremark()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Release Supply Tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCelovesforholes()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCelovesforholesremark()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			/**			
			//Code Starts From Here Done By Roshan Tailor
			table.addCell("Check Blade Change", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.getCheckbladechange()!=null) {
				table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
			table.addCell(CommonUtil.replaceNull(data.getCheckbladechangeremark()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			//
			table.addCell("Celoves For Holes", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.getCelovesforholes()!=null) {
				table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
			table.addCell(CommonUtil.replaceNull(data.getCelovesforholesremark()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			//Code Ends Here Done By Roshan TAilor
			**/
			 
		}
		}
		if (nightdatas!=null && nightdatas.size() != 0) {
			table.addCell("OBCC Completed = "+l+"%", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
		for (BackTender data : nightdatas) {
			table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			 
			table.addCell("Operator Basic Care CheckList",PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 6, 1, 1,5, 5, 5, 5, new Color(203, 132, 46, 96));

			table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
			table.addCellRightBorder(CommonUtil.capitalizeFirstandSecondFirstLetter(data.getPosition())+ ":-"+ CommonUtil.capitalizeFirstLetter(data.getOperatorName()),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

			table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 3, 1, 0);
			table.addCell("Date:-" + data.getEdate(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 2, 1, 0);
			table.addCellRightBorder("Shift:-"+ CommonUtil.capitalizeFirstLetter(data.getShift()), PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);

			table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
			table.addCellRightBorder("Crew:-" + data.getCrew(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

			table.addCell("Description", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Check Point", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Remarks", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("After - dryer & Benchboard Area", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
			
			table.addCell("Verify Dryer felt edges are smooth", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isAfterDryerCol1() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
	        table.addCell("Top Stretch Felt Tension (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Loading Pressure  :"+CommonUtil.replaceNull(data.getAfterDryerCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
			table.addCell("Bottom Stretch Felt Tension (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Loading Pressure  :"+CommonUtil.replaceNull(data.getAfterDryerCol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			/***
			
			table.addCell("Top Felt Guide Paddle Position Correctness & Cleanliness", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isAfterDryerCol4() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	        
	        table.addCell("Bott. Felt Guide Paddle Position Correctness & Cleanliness", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.getAfterDryerCol5() !=null) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	        
	        table.addCell("Felt health", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.getAfterDryerCol6()!=null) {
		 		table.addCell("Good", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("Bed", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			**/
	        table.addCell("Eqpt Name: Scanner", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
			
	        table.addCell("Verify Scanner Air Filter is Clean", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isEqptScannerCol1() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getEqptScannerCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	        /***
	        table.addCell("Verify Scanner Chiller Water Level is Present", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.getEqptScannerCol2()!=null) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getEqptScannerCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			***/
	        table.addCell("Clean the scanner heads", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isEqptScannerCol3() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getEqptScannerCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        
	        table.addCell("Cleanliness of the opearting floor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isEqptScannerCol4() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getEqptScannerCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	        
	        table.addCell("Spool starter Tire condition", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isEqptScannerCol5() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getEqptScannerCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	        
			table.addCell("Eqpt Name: Reel Section & Benchboard", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
	        
			table.addCell("Verify brakes pads condition is acceptable", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isEqptReelSectionCol1() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getEqptReelSectionCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	         
	        
	        table.addCell("Mill Supply Air Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Air Pressure   :"+CommonUtil.replaceNull(data.getEqptReelSectionCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getEqptReelSectionCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        table.addCell("Reel Doctor Loading Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("Loading Pressure    :"+CommonUtil.replaceNull(data.getEqptReelSectionCol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getEqptReelSectionCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
			
	        
			 table.addCell("Reel Brake Loading Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 table.addCell("Loading Pressure    :"+CommonUtil.replaceNull(data.getEqptReelSectionCol4()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 table.addCell(CommonUtil.replaceNull(data.getEqptReelSectionCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
		     table.addCell("After-dryer Doctor Loading Pressure", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
             table.addCell("Loading Pressure    :"+CommonUtil.replaceNull(data.getEqptReelSectionCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 table.addCell(CommonUtil.replaceNull(data.getEqptReelSectionCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);	
			
	        
	        
			table.addCell("Oil Flows", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
			 
			table.addCell("DS2 (F)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isOilFlowCol1() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getOilFlowCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 
	        
	        
	        table.addCell("DS3 (H)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isOilFlowCol2() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getOilFlowCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        
	        
	        table.addCell("DS4 (I)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isOilFlowCol3() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getOilFlowCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        
	        table.addCell("DS5 (N)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isOilFlowCol4() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getOilFlowCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        
	        
	        table.addCell("RGBXT", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
            table.addCell("Oil Flow Setting    :"+CommonUtil.replaceNull(data.getOilFlowCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getOilFlowCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);	
	        
			
			table.addCell("RBRG", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
            table.addCell("Oil Flow Setting    :"+CommonUtil.replaceNull(data.getOilFlowCol6()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getOilFlowCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);	
			
			table.addCell("RGBXS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
            table.addCell("Oil Flow Setting    :"+CommonUtil.replaceNull(data.getOilFlowCol7()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getOilFlowCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);	
	        
			table.addCell("Mezzanine", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
	        
			
			
			table.addCell("Verify DE Combustion External Filters are clean and not plugged/dirty", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isMezzanineCol1() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getMezzanineCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 
	        
	        
	        table.addCell("Verify WE Combustion Ext Filters are clean", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isMezzanineCol2() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getMezzanineCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        
	        
	        table.addCell("Verify DE Yankee Hood Supply Fan Bearing Oil levels (2)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isMezzanineCol3() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getMezzanineCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        
	        table.addCell("Inspect Drive Side Clearance between Hood and Yankee Dryer for pluggage/build-up.", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isMezzanineCol4() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getMezzanineCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        table.addCell("Verify WE Yankee Hood Supply Fan Bearing Oil levels (2)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isMezzanineCol1() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getMezzanineCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        
	        
	        table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
	        
	        
	        table.addCell("Blow down Yankee catwalks, top of hood and hood duct work", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 
			table.addCell("Wash and clean M/c floors from the of after dryers to refiners (T/S and D/S)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Clean basement from Loose paper when needed", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Blow down After Dryers and frame work", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol4()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("Check Chemical totes and change if needed", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("At least 3 blades should be on top of blade platform and all used blades cut up by end of shift", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol6()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			
			table.addCell("Area around reel should be free from loose paper", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol7()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getFillupcol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
	        
			table.addCell("Skinning Doctor Loading Pressure(PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCondensateCol15()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCondensateCol15Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
			table.addCell("Creeping Doctor Loading Pressure(PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getMachineLubricationCol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getMachineLubricationCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
					
			
	        
			table.addCell("Verify Creeping Doctor Oscillation", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isAfterDryerCol4() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	       
	        table.addCell("Empty All wet end trash cans", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
	        if (data.isShowerWaterCol6() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	       
	        table.addCell("Blow off all machine drive motors ", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			if (data.isShowerWaterCol11() == true) {
		 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			} else {
				table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
	        table.addCell(CommonUtil.replaceNull(data.getShowerWaterCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
	       
	        
	        table.addCell("Felt Passivator Supply Tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Defoamer Supply Tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol6()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getAfterDryerCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Adhesive Supply Tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getEqptScannerCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getEqptScannerCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Coating Supply Tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCheckbladechange()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCheckbladechangeremark()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
			table.addCell("Release Supply Tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCelovesforholes()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			table.addCell(CommonUtil.replaceNull(data.getCelovesforholesremark()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			
	         
		}
	}
		table.finish();
		
		pdfUtil.close();
	}
	
	public void createMachineTernerOperatorPdf(List<MachineTender> daydatas,List<MachineTender> nightdatas,OutputStream outputStream,long l) throws Exception {
		
		
		PdfReportUtil pdfUtil = new PdfReportUtil(15f, 15f, 10f, 10f);

		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Machine Tender Operator");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
		pdfUtil.open();
		
		Table table = pdfUtil.new Table(6, new float[] { 1, 1, 1, 1, 1, 1 });
	
		
		if (daydatas!=null && daydatas.size() != 0) {
			table.addCell("OBCC Completed = "+l+"%", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			for (MachineTender data : daydatas) {
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				 
				table.addCell("Operator Basic Care CheckList",PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 6, 1, 1,5, 5, 5, 5, new Color(203, 132, 46, 96));

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder(CommonUtil.capitalizeFirstandSecondFirstLetter(data.getPosition())+ ":-"+ CommonUtil.capitalizeFirstLetter(data.getOperatorName()),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 3, 1, 0);
				table.addCell("Date:-" + data.getEdate(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 2, 1, 0);
				table.addCellRightBorder("Shift:-"+ CommonUtil.capitalizeFirstLetter(data.getShift()), PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder("Crew:-" + data.getCrew(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCell("Description", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Check Point", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Remarks", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				 
				table.addCell("Forming Section", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				table.addCell("Verify Fabric Tension with Tensometer", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Tensometer Reading: "+CommonUtil.replaceNull(data.getFormingSectionCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				table.addCell("Throat - Front (GPM)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Seal Water Flow:  "+CommonUtil.replaceNull(data.getFormingSectionCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vat - Front", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Seal Water Flow:  "+CommonUtil.replaceNull(data.getFormingSectionCol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Slice - Front", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Seal Water Flow:  "+CommonUtil.replaceNull(data.getFormingSectionCol4()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Slice - Back", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Seal Water Flow:  "+CommonUtil.replaceNull(data.getFormingSectionCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Throat - Back", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Seal Water Flow:  "+CommonUtil.replaceNull(data.getFormingSectionCol6()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vat - Back", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Seal Water Flow:  "+CommonUtil.replaceNull(data.getFormingSectionCol7()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Supply Air Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gauge Pressure:  "+CommonUtil.replaceNull(data.getFormingSectionCol8()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Wire Guide Diaphragm Air Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gauge Pressure:  "+CommonUtil.replaceNull(data.getFormingSectionCol9()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Counter Balance Air Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gauge Pressure:  "+CommonUtil.replaceNull(data.getFormingSectionCol10()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol10Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Tension Air Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gauge Pressure:  "+CommonUtil.replaceNull(data.getFormingSectionCol11()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol11Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Tension Roll Counter Weight Air Pressure", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gauge Pressure:  "+CommonUtil.replaceNull(data.getFormingSectionCol12()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol12Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Verify Wire edges are smooth", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFormingSectionCol13() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol13Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        table.addCell("Wire Guide Position Correct & Cleanliness", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFormingSectionCol14() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFormingSectionCol14Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        table.addCell("Check Headbox Air Compressor Inlet Filter Cleanliness", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCheckheadboxaircompressorintelfiltercleanliness() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getCheckheadboxaircompressorintelfiltercleanlinessdesc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        table.addCell("Suction Pressure Roll", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
		        table.addCell("Lubrication Shower Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Shower Pressure:  "+CommonUtil.replaceNull(data.getSuctionPressureRollCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSuctionPressureRollCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Cleaning Shower Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Shower Pressure:  "+CommonUtil.replaceNull(data.getSuctionPressureRollCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSuctionPressureRollCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				
				table.addCell("SPR Loading Pressure", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Loading Pressure:  "+CommonUtil.replaceNull(data.getSuctionPressureRollCol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSuctionPressureRollCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Suction Box Position", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Position:  "+CommonUtil.replaceNull(data.getSuctionPressureRollCol4()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSuctionPressureRollCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum Level (Hg)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Vacuum:  "+CommonUtil.replaceNull(data.getSuctionPressureRollCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSuctionPressureRollCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Air to Packing Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Air Pressure:  "+CommonUtil.replaceNull(data.getSuctionPressureRollCol6()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSuctionPressureRollCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("SPR Doctor Cleanliness", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSuctionPressureRollCol7() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getSuctionPressureRollCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Yankee Dryer & doctors", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				/**
		        table.addCell("Skinning Doctor Loading Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Loading Pressure:  "+CommonUtil.replaceNull(data.getYankeeDryerCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getYankeeDryerCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Creping Doctor Loading Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Loading Pressure:  "+CommonUtil.replaceNull(data.getYankeeDryerCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getYankeeDryerCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Verify Creping Doctor Oscillation", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeeDryerCol3() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeeDryerCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				**/
		        
		        table.addCell("Felt Roll No. 2 Doctor Loading Pressure", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Loading Pressure:  "+CommonUtil.replaceNull(data.getYankeeDryerCol4()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getYankeeDryerCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         
		        
				table.addCell("Sprayboom shower Position", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeeDryerCol5() == true) {
			 		table.addCell("North", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("South", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeeDryerCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        table.addCell("Drive Roll Gearbox Temperatures", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
		        
		        table.addCell("Couch Roll Drive Motor Gearbox Temp.", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getDriveRollCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getDriveRollCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				//
				table.addCell("Pick-up Roll Gearbox Temp.", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getDriveRollCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getDriveRollCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Wire Turning Roll Gearbox Temp.", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getDriveRollCol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getDriveRollCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Suction Pressure Roll Gearbox Temp.", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getDriveRollCol4()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getDriveRollCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Yankee Gearbox Temp.", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getDriveRollCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getDriveRollCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);


				table.addCell("After-dryer Gearbox Temp.", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getDriveRollCol6()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getDriveRollCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Reel Drum Gearbox Temp.", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getDriveRollCol7()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getDriveRollCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				table.addCell("Check Yankee Wet and Dry end temp on In board and Out Board of Motor:", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getDriveRollCol8()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getDriveRollCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        
				table.addCell("Press Section Benchboard Area", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
		        
		        
		        
				table.addCell("Couch Roll Doctor Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getPressSectionCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getPressSectionCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				
				table.addCell("Automatic Felt Guide Supply Pressure", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getPressSectionCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getPressSectionCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Manual Felt Guide Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getPressSectionCol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getPressSectionCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Press Felt Stretch Roll Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getPressSectionCol4()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getPressSectionCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
				
				table.addCell("Inside Wire HP Shower Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getPressSectionCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getPressSectionCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				
				table.addCell("Verify Inside Wire HP Shower Oscillation", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isPressSectionCol6() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getPressSectionCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        table.addCell("Outside Wire HP Shower Pressure (PSI)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gearbox Temp:  "+CommonUtil.replaceNull(data.getPressSectionCol7()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getPressSectionCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				
				
				table.addCell("Verify Outside Wire HP Shower Oscillation", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isPressSectionCol8() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getPressSectionCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Upper Press Felt Area", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				/** 
		        table.addCell("South Uhle Box Vacuum (Hg)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Vacuum Level:  "+CommonUtil.replaceNull(data.getUpperPressCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getUpperPressCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				**/
				table.addCell("Uhle Box Vacuum (Hg)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Vacuum Level:  "+CommonUtil.replaceNull(data.getUpperPressCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getUpperPressCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				
				table.addCell("Verify HP Press Felt Shower Oscillation", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isUpperPressCol3() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getUpperPressCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        /**
		        table.addCell("Verify Felt Guide Paddle Position", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isUpperPressCol4() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getUpperPressCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				**/
		        
		        table.addCell("Uhlebox cleanliness ", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isUpperPressCol5() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getUpperPressCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        table.addCell("Felt passivator shower", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isUpperPressCol6() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getUpperPressCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        table.addCell("Verify Felt edges are smooth", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isUpperPressCol7() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getUpperPressCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        table.addCell("Uhlebox Lubrication Shower", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isUpperPressCol8() == true) {
			 		table.addCell("On", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Off", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getUpperPressCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        table.addCell("Press Felt HP Cleaning Shower", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getUpperPressCol9(), PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getUpperPressCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				/**
		        table.addCell("Chemical totes", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				
		        table.addCell("Felt Passivator Supply tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Level >:  "+CommonUtil.replaceNull(data.getChemicalTotesCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getChemicalTotesCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				
				table.addCell("Defoamer Supply tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Level >:  "+CommonUtil.replaceNull(data.getChemicalTotesCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getChemicalTotesCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Adhesive supply tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Level >:  "+CommonUtil.replaceNull(data.getChemicalTotesCol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getChemicalTotesCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Coating supply tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Level >:  "+CommonUtil.replaceNull(data.getChemicalTotesCol4()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getChemicalTotesCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				
				table.addCell("Release supply tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Level >:  "+CommonUtil.replaceNull(data.getChemicalTotesCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getChemicalTotesCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				**/
				
				 table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				 
				table.addCell("Fill Centerline sheets Out", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFillupcentcol1() == true) {
			 		table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift:NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFillupcentcol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        
		        /**
		        table.addCell("Logbook update with M/c adjustments and process changes during the shift", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFillupcentcol2() == true) {
			 		table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift:NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFillupcentcol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        table.addCell("Wash M/c floors from the of after dryers to refiners", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFillupcentcol3() == true) {
			 		table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift:NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFillupcentcol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        **/
		        
		        table.addCell("Clean control room", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFillupcentcol4() == true) {
			 		table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift:NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFillupcentcol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        
		        table.addCell("Sprayboom changing", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        if (data.isFillupcentcol3() == true) {
			 		table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift:NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
				table.addCell(CommonUtil.replaceNull(data.getFillupcentcol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				/**
				table.addCell("Emergency Alarm Test", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFillupcentcol6()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFillupcentcol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
					
					
					
				table.addCell("Combustion air filters cleaning", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFillupcentcol7()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFillupcentcol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);	
				
				//Code Starts From Here Done By Roshan Tailor
				table.addCell("Check Air Filter For Head Box", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCheckairfilterforheadbox() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.checkNull(data.getCheckairfilterforheadboxremark()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        
		        table.addCell("Blow Wet end and Dry End Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isBlowwetendanddryendmotor() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.checkNull(data.getBlowwetendanddryendmotorremark()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        table.addCell("Headbox Air Filters Cleaning:", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHeadboxairfilterscleaning() == true) {
			 		table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift:NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHeadboxairfilterscleaningdesc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				***/
				 
			}
		}
		
		if (nightdatas!=null && nightdatas.size() != 0) {
			table.addCell("OBCC Completed = "+l+"%", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			for (MachineTender data : nightdatas) {
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				 
				table.addCell("Operator Basic Care CheckList",PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 6, 1, 1,5, 5, 5, 5, new Color(203, 132, 46, 96));

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder(CommonUtil.capitalizeFirstandSecondFirstLetter(data.getPosition())+ ":-"+ CommonUtil.capitalizeFirstLetter(data.getOperatorName()),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 3, 1, 0);
				table.addCell("Date:-" + data.getEdate(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 2, 1, 0);
				table.addCellRightBorder("Shift:-"+ CommonUtil.capitalizeFirstLetter(data.getShift()), PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder("Crew:-" + data.getCrew(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCell("Description", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Check Point", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Remarks", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Fan Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				 
				
				table.addCell("Fan Pump sealing water", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFanPumpCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFanPumpCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Fan pump Gearbox", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFanPumpCol2() == true) {
			 		table.addCell("Abnormal Sound: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFanPumpCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Fan pump Gearbox", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  West :"+CommonUtil.replaceNull(data.getFanPumpCol3Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("East : "+CommonUtil.replaceNull(data.getFanPumpCol3Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFanPumpCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Fan Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getFanPumpCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getFanPumpCol4Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getFanPumpCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Selectifier screen", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				
				table.addCell("Inlet pressure", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Outlet pressure:"+CommonUtil.replaceNull(data.getSelectifierScreenCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Outlet pressure", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				/***
				table.addCell("#1 Selectifier screen North", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gear seal "+CommonUtil.replaceNull(data.getSelectifierScreenCol3()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				**/
				table.addCell("#1 Selectifier screen North Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  West :"+CommonUtil.replaceNull(data.getSelectifierScreenCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("East : "+CommonUtil.replaceNull(data.getSelectifierScreenCol4Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 /**
				table.addCell("#2 Selectifier screen South", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Gear seal "+CommonUtil.replaceNull(data.getSelectifierScreenCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				**/
				table.addCell("#2 Selectifier screen South Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  West :"+CommonUtil.replaceNull(data.getSelectifierScreenCol6Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("East : "+CommonUtil.replaceNull(data.getSelectifierScreenCol6Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				 
				
				table.addCell("Selectifier Lube System", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				
				table.addCell("Lube oil area", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Leakage  "+CommonUtil.replaceNull(data.getSelectifierScreenCol7()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				/**
				
				table.addCell("#1 Lube pump North", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSelectifierScreenCol8() == true) {
			 		table.addCell("Abnormal Sound: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("#1 Lube pump North Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  North :"+CommonUtil.replaceNull(data.getSelectifierScreenCol9Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("South : "+CommonUtil.replaceNull(data.getSelectifierScreenCol9Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("#1 Lube pump South", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSelectifierScreenCol10() == true) {
			 		table.addCell("Abnormal Sound: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol10Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("#2 Lube pump South Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  North :"+CommonUtil.replaceNull(data.getSelectifierScreenCol11Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("South : "+CommonUtil.replaceNull(data.getSelectifierScreenCol11Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSelectifierScreenCol11Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				***/
				
				table.addCell("Vacuum pumps", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				/**
				table.addCell("Vacuum pump motor 100 Hp", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Vacuum pump motor 100 Hp", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol2() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				**/
		        
		        table.addCell("Vacuum pump#8", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol3() == true) {
			 		table.addCell("Seal water flooding: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Seal water flooding: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				
		        table.addCell("Vacuum pump#8 bearing (North)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getVacumePumpCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getVacumePumpCol4Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#8 bearing (South)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getVacumePumpCol5Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getVacumePumpCol5Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				/**
				table.addCell("Vacuum pump motor 1500 Hp", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol6() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 **/
				
		        table.addCell("Vacuum pump motor 1500 Hp", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  North :"+CommonUtil.replaceNull(data.getVacumePumpCol7Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("South : "+CommonUtil.replaceNull(data.getVacumePumpCol7Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("Vacuum pump#2", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol8() == true) {
			 		table.addCell("Seal water flooding: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Seal water flooding: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Vacuum pump#02 bearing (North)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol9()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#02 bearing (South)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol10()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol10Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#3", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol11() == true) {
			 		table.addCell("Seal water flooding: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Seal water flooding: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol11Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        
		        table.addCell("Vacuum pump#03 bearing (North)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol12()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol12Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#03 bearing (South)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol13()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol13Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				/**
				table.addCell("Vacuum pump motor 1750 Hp", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol14() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol14Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        **/
		        table.addCell("Vacuum pump motor 1750 Hp", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getVacumePumpCol15Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getVacumePumpCol15Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol15Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
				table.addCell("Vacuum pump#11", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol16() == true) {
			 		table.addCell("Seal water flooding: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Seal water flooding: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol16Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        table.addCell("Vacuum pump#011 bearing (North)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol17()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol17Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#011 bearing (South)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol18()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol18Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				
				
				table.addCell("Vacuum pump#12", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol19() == true) {
			 		table.addCell("Seal water flooding: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Seal water flooding: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol19Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Vacuum pump#012 bearing (North)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol20()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol20Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#012 bearing (South)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol21()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol21Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				
				table.addCell("Vacuum pump#13", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol22() == true) {
			 		table.addCell("Seal water flooding: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Seal water flooding: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol22Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Vacuum pump#013 bearing (North)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol23()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol23Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#013 bearing (South)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol24()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol24Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#14", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol25() == true) {
			 		table.addCell("Seal water flooding: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Seal water flooding: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol25Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Vacuum pump#014 bearing (North)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol26()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol26Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#014 bearing (South)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol27()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol27Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("Vacuum pump#15", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol28() == true) {
			 		table.addCell("Seal water flooding: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Seal water flooding: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol28Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Vacuum pump#015 bearing (North)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol29()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol29Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#015 bearing (South)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol30()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol30Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("Vacuum pump#16", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol31() == true) {
			 		table.addCell("Seal water flooding: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Seal water flooding: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol31Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Vacuum pump#016 bearing (North)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol32()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol32Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#016 bearing (South)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol33()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol33Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        
				
				table.addCell("Vacuum pump#17", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isVacumePumpCol34() == true) {
			 		table.addCell("Seal water flooding: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Seal water flooding: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol34Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Vacuum pump#017 bearing (North)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol35()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol35Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Vacuum pump#017 bearing (South)", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature   "+CommonUtil.replaceNull(data.getVacumePumpCol36()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getVacumePumpCol36Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
				table.addCell("River Water Seal System", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
		        
				
				table.addCell("River water strainer", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Diff pressure:  "+CommonUtil.replaceNull(data.getRiverWaterCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRiverWaterCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				
				table.addCell("River water filter", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Diff pressure:  "+CommonUtil.replaceNull(data.getRiverWaterCol2()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRiverWaterCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Shower Water System", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				/**
				table.addCell("#2 Fresh Water booster pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isShowercol1() == true) {
			 		table.addCell("Abnormal Sound: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound: NO", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getShowercol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				**/
		        
		        
		        table.addCell("#2 Fresh Water booster pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  North :"+CommonUtil.replaceNull(data.getShowercol2North()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("South : "+CommonUtil.replaceNull(data.getShowercol2South()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getShowercol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         
				/**
				table.addCell("#3 Fresh Water booster pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isShowercol3() == true) {
					table.addCell("Abnormal Sound: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound: No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getShowercol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				*/
				
		        table.addCell("#3 Fresh Water booster pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  North :"+CommonUtil.replaceNull(data.getShowercol4North()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("South : "+CommonUtil.replaceNull(data.getShowercol4South()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getShowercol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
			/**	
				
				table.addCell("HP Shower Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isShowercol5() == true) {
					table.addCell("Abnormal Sound: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Abnormal Sound: No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getShowercol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				***/
		        table.addCell("HP Shower Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  West :"+CommonUtil.replaceNull(data.getShowercol6North()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("East : "+CommonUtil.replaceNull(data.getShowercol6South()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getShowercol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("HP Shower pump filter", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getShowercol7()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getShowercol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				table.addCell("Fill up Centerline sheets", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFillupcentcol1() == true) {
					table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift: No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFillupcentcol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				/*** 
		        table.addCell("Logbook update with M/c adjustments and process changes during the shift", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFillupcentcol2() == true) {
					table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift: No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFillupcentcol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         
		        table.addCell("Wash M/c floors from the of after dryers to refiners", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFillupcentcol3() == true) {
					table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift: No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFillupcentcol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        table.addCell("Clean control room", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFillupcentcol4() == true) {
					table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift: No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFillupcentcol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        table.addCell("Empty all wet end trash cans", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFillupcentcol8() == true) {
					table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift: No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFillupcentcol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         
		        table.addCell("Blow off all machine drive motors", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isFillupcentcol9() == true) {
					table.addCell("Every Shift: Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Every Shift: No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getFillupcentcol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        **/ 
		
			}
		}
		
		table.finish();
		
		pdfUtil.close();
}

	/**
	 * @param daylst
	 * @param nightlst
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createStokeOperatorPdf(List<StockOperator> daydatas,List<StockOperator> nightdatas, OutputStream outputStream,long l) throws Exception {
		
		
		PdfReportUtil pdfUtil = new PdfReportUtil(15f, 15f, 10f, 10f);

		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Stock Operator");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
		pdfUtil.open();
		
		Table table = pdfUtil.new Table(6, new float[] { 1, 1, 1, 1, 1, 1 });
	
		
		if (daydatas != null && daydatas.size() != 0) {
			table.addCell("OBCC Completed = "+l+"%", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			for (StockOperator data : daydatas) {
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				 
				table.addCell("Operator Basic Care CheckList",PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 6, 1, 1,5, 5, 5, 5, new Color(203, 132, 46, 96));

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder(CommonUtil.capitalizeFirstandSecondFirstLetter(data.getPosition())+ ":-"+ CommonUtil.capitalizeFirstLetter(CommonUtil.replaceNull(data.getOperatorName())),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 3, 1, 0);
				table.addCell("Date:-" + data.getEdate(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 2, 1, 0);
				table.addCellRightBorder("Shift:-"+ CommonUtil.capitalizeFirstLetter(data.getShift()), PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder("Crew:-" + data.getCrew(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCell("Description", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Check Point", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Remarks", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
		
				
				table.addCell("Shower Water System", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				
				table.addCell("HD Storage chest", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHdStorageChestCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHdStorageChestCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("HD Storage chest Agitator Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getHdStorageChestCol2Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getHdStorageChestCol2Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getHdStorageChestCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				
				table.addCell("De-ink stock supply pump #1", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHdStorageChestCol3() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHdStorageChestCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("De-ink stock supply pump #1 Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getHdStorageChestCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getHdStorageChestCol4Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getHdStorageChestCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("De-ink stock supply pump #2", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHdStorageChestCol5() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHdStorageChestCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("De-ink stock supply pump #2 Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getHdStorageChestCol6Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getHdStorageChestCol6Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getHdStorageChestCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				
				table.addCell("De-ink pulp dilution pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHdStorageChestCol7() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHdStorageChestCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("De-ink pulp dilution pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getHdStorageChestCol8Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getHdStorageChestCol8Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getHdStorageChestCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Blend Chest", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				
				
				table.addCell("Blend chest Agitator", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isBlendChestCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getBlendChestCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
		        table.addCell("Blend chest Agitator Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getBlendChestCol2Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getBlendChestCol2Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBlendChestCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("Sweetner pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isBlendChestCol3() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getBlendChestCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
		        table.addCell("Sweetner pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getBlendChestCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getBlendChestCol4Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBlendChestCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Sec Screen Feed tank", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				 
				table.addCell("Secondary screen feed tank Agitator", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSeeScreenFeedTandCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getSeeScreenFeedTandCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
		        table.addCell("Agitator Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getSeeScreenFeedTandCol2Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getSeeScreenFeedTandcol2Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSeeScreenFeedTandCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				table.addCell("Secondary screen feed Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSeeScreenFeedTandCol3() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getSeeScreenFeedTandCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
		        table.addCell("Secondary screen feed Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getSeeScreenFeedTandCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getSeeScreenFeedTandcol4Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSeeScreenFeedTandCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Machine chest", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				 
				
				table.addCell("Machine chest pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isMachineChestCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getMachineChestCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
		        table.addCell("Machine chest pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getMachineChestCol2Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getMachineChestCol2Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getMachineChestCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("Blend chest Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isMachineChestCol3() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getMachineChestCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
		        table.addCell("Blend chest Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getMachineChestCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getMachineChestCol4Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getMachineChestCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				table.addCell("Machine chest Agitator", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isMachineChestCol5() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getMachineChestCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
		        table.addCell("Machine chest Agitator Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getMachineChestCol6Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getMachineChestCol6Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getMachineChestCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Cleaners", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				
				
				table.addCell("Low density cleaner", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCleannersCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getCleannersCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        
		        table.addCell("Secondary selectifier screen", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCleannersCol2() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getCleannersCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
		        table.addCell("Secondary selectifier screen Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getCleannersCol3Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCleannersCol3Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getCleannersCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("De-ink stock chest", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				 
				/**
				 table.addCell("De-ink stock Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isDeLinkStockCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getDeLinkStockCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 **/	
					
		        table.addCell("De-ink stock Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getDeLinkStockCol2Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getDeLinkStockCol2Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getDeLinkStockCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("White water pumps", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				 
				
				 table.addCell("White water Transfer Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWhiteWaterCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getWhiteWaterCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 	
					
		        table.addCell("White water Transfer Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getWhiteWaterCol2Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getWhiteWaterCol2Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getWhiteWaterCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				 table.addCell("Save all Shower Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWhiteWaterCol3() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getWhiteWaterCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 	
					
		        table.addCell("Save all Shower Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getWhiteWaterCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getWhiteWaterCol4Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getWhiteWaterCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				
				table.addCell("Consistency Dilution pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWhiteWaterCol5() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getWhiteWaterCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 	
					
		        table.addCell("Consistency Dilution pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getWhiteWaterCol6Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getWhiteWaterCol6Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getWhiteWaterCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				table.addCell("River Water Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWhiteWaterCol7() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getWhiteWaterCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 	
					
		        table.addCell("River Water pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getWhiteWaterCol8Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getWhiteWaterCol8Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getWhiteWaterCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("Couch Pit", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				/**
				table.addCell("Couch pit Drain", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCouchPitCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getCouchPitCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        **/
		        table.addCell("Couch pit Agitator West", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCouchPitCol2() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getCouchPitCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Couch pit Agitator West Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getCouchPitCol3Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCouchPitCol3Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getCouchPitCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				
				 table.addCell("Couch pit Agitator East", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCouchPitCol4() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getCouchPitCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Couch pit Agitator East Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getCouchPitCol5Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCouchPitCol5Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getCouchPitCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				/**
				
				table.addCell("Couch pit trim Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCouchPitCol6() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getCouchPitCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Couch pit trim Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getCouchPitCol7Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCouchPitCol7Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getCouchPitCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Couch pit trim Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getCouchPitCol8Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCouchPitCol8Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getCouchPitCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				 
				table.addCell("Couch Pit Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isCouchPitCol9() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getCouchPitCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				**/
		        table.addCell("Couch Pit Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getCouchPitCol10Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCouchPitCol10Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getCouchPitCol10Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Couch Pit Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getCouchPitCol11Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getCouchPitCol11Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getCouchPitCol11Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Yankee Pulper", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				/**
				
				table.addCell("Yankee Pulper Overflow", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePulperCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePulperCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        
		        
		        table.addCell("Yankee Pulper Drain", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePulperCol1Drain() == true) {
			 		table.addCell("Open", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Close", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePulperCol1DrainDesc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
		        table.addCell("Yankee Pulper East Agitator", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePulperCol2() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePulperCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         
		        **/
		        table.addCell("Yankee Pulper East Agitator Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getYankeePulperCol3Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getYankeePulperCol3Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getYankeePulperCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        /** 
				table.addCell("Yankee Pulper West Agitator", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePulperCol4() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePulperCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         
		        **/
		        table.addCell("Yankee Pulper West Agitator Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getYankeePulperCol5Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getYankeePulperCol5Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getYankeePulperCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				/*** 
				table.addCell("Yankee pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePulperCol6() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePulperCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         **/
		        
		        table.addCell("Yankee pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getYankeePulperCol7Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getYankeePulperCol7Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getYankeePulperCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        /**
				table.addCell("Yankee trim pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePulperCol8() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePulperCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         
		        
		        table.addCell("Yankee trim pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getYankeePulperCol9Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getYankeePulperCol9Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getYankeePulperCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        **/
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));  
		        
		        /**
				table.addCell("Wash M/c floors from the of after dryers to refiners", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Every Shift :"+CommonUtil.replaceNull(data.getDesccol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getDesccol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				**/
				table.addCell("Effluent Sampler working condition:", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isEffluentsamplerworkingcondition() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getEffluentsamplerworkingconditionDesc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
			}
		}
		
		if (nightdatas != null && nightdatas.size() != 0) {
			table.addCell("OBCC Completed = "+l+"%", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			for (StockOperator data : nightdatas) {
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
				 
				table.addCell("Operator Basic Care CheckList",PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 6, 1, 1,5, 5, 5, 5, new Color(203, 132, 46, 96));

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder(CommonUtil.capitalizeFirstandSecondFirstLetter(data.getPosition())+ ":-"+ CommonUtil.capitalizeFirstLetter(CommonUtil.replaceNull(data.getOperatorName())),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 3, 1, 0);
				table.addCell("Date:-" + data.getEdate(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 2, 1, 0);
				table.addCellRightBorder("Shift:-"+ CommonUtil.capitalizeFirstLetter(data.getShift()), PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);

				table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
				table.addCellRightBorder("Crew:-" + data.getCrew(),PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);

				table.addCell("Description", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Check Point", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Remarks", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_LEFT, 2, 1, 1);
		
				table.addCell("Broke Deflaker", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));

				table.addCell("Broke Deflaker", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isBrokeDeflakerCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getBrokeDeflakerCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
		        table.addCell("Deflaker Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getBrokeDeflakerCol2Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getBrokeDeflakerCol2Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeDeflakerCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				table.addCell("Sealing water", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isBrokeDeflakerCol3() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getBrokeDeflakerCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Refining system", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				 
		        table.addCell("Refiner #", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol1()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
				/***
				table.addCell("Refiner # Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRefiningSystemCol2() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        table.addCell("Refiner # Load/unload Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getRefiningSystemCol3Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getRefiningSystemCol3Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        ***/
		        
				table.addCell("Oil Level", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol4()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Sealing water", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol5()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				/****
				table.addCell("Refiner #", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol6()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				
				table.addCell("Refiner # Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isRefiningSystemCol7() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Refiner # Load/unload Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getRefiningSystemCol8Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getRefiningSystemCol8Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Oil Level", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(String.valueOf(data.getRefiningSystemCol9()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				  
				
				table.addCell("Sealing water", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(String.valueOf(data.getRefiningSystemCol10()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getRefiningSystemCol10Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				***/
				table.addCell("White water pumps", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				/***
				table.addCell("White water Transfer Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWhiteWaterPumpCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getWhiteWaterPumpCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				***/
		        table.addCell("White water Transfer Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getWhiteWaterPumpCol2Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getWhiteWaterPumpCol2Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getWhiteWaterPumpCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				/**
				table.addCell("Save all Shower Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWhiteWaterPumpCol3() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getWhiteWaterPumpCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				***/
		        table.addCell("Save all Shower Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getWhiteWaterPumpCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getWhiteWaterPumpCol4Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getWhiteWaterPumpCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				/**
				table.addCell("Consistency Dilution pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isWhiteWaterPumpCol5() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getWhiteWaterPumpCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				***/  
		        table.addCell("Consistency Dilution pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getWhiteWaterPumpCol6Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getWhiteWaterPumpCol6Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getWhiteWaterPumpCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				/****
				table.addCell("Silo", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
		         
				table.addCell("Silo level", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getSilloCol1(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSilloCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				table.addCell("Drain", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSilloCol2() == true) {
			 		table.addCell("Open", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Close", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getSilloCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        table.addCell("Basis weight valve position in DCS", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getSilloCol3(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSilloCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 ***/
				table.addCell("Yankee Pulper", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				/**** 
				table.addCell("Yankee Pulper Overflow", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePumplerCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePumplerCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        table.addCell("Yankee Pulper Drain", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePumplerCol1Drain() == true) {
			 		table.addCell("Open", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Close", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePumplerCol1DrainDesc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         
		        
		        table.addCell("Yankee Pulper East Agitator", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePumplerCol2() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePumplerCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				***/
		        table.addCell("Yankee Pulper East Agitator Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getYankeePumplerCol3Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getYankeePumplerCol3Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getYankeePumplerCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				/*** 
				table.addCell("Yankee Pulper West Agitator", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePumplerCol4() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePumplerCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				***/
				
		        table.addCell("Yankee Pulper West Agitator Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getYankeePumplerCol5Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getYankeePumplerCol5Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getYankeePumplerCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				/**
				table.addCell("Yankee pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePumplerCol6() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePumplerCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				**/
		        table.addCell("Yankee pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getYankeePumplerCol7Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getYankeePumplerCol7Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getYankeePumplerCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				/***
				table.addCell("Yankee trim pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isYankeePumplerCol8() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getYankeePumplerCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Yankee trim pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getYankeePumplerCol9Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getYankeePumplerCol9Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getYankeePumplerCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				**/
				
				table.addCell("Broke System", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				
				/**
				table.addCell("Broke Chest level", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getBrokeSystemCol1(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeSystemCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
				table.addCell("Central broke chest agitator Double", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getBrokeSystemCol2(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeSystemCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 **/
				table.addCell("Agitator Motor C", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getBrokeSystemCol3()+"  Temp",PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeSystemCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 	
				table.addCell("Broke chest agitator South east single", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getBrokeSystemCol4(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeSystemCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 	
				table.addCell("Agitator Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getBrokeSystemCol5()+"  Temp",PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeSystemCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 	
				table.addCell("Broke chest agitator South west single", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getBrokeSystemCol6(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeSystemCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 	
				table.addCell("Agitator Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getBrokeSystemCol7()+"  Temp",PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeSystemCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 	/**
				table.addCell("Broke chest pump East", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getBrokeSystemCol8(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeSystemCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				**/
				table.addCell("Broke chest pump East Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getBrokeSystemCol9()+"  Temp",PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeSystemCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			 	/**
				table.addCell("Broke chest pump West", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getBrokeSystemCol10(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeSystemCol10Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				**/
				table.addCell("Broke chest pump West Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getBrokeSystemCol11(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getBrokeSystemCol11Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Save All", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				 
				/**
				table.addCell("Save all Vat", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(data.getSaveAllCol1(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSaveAllCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 **/
				table.addCell("Segments", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSaveAllCol2() == true) {
			 		table.addCell("Work", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Plug", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getSaveAllCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				 
		        table.addCell("Nozzles", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSaveAllCol3() == true) {
			 		table.addCell("Work", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Plug", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getSaveAllCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
		        table.addCell("Save all Cylinder Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getSaveAllCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getSaveAllCol4Outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getSaveAllCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
				
				table.addCell("Segement cleaning shower", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSaveAllCol5() == true) {
			 		table.addCell("On", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Off", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getSaveAllCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				   
		        table.addCell("Peel off shower", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isSaveAllCol6() == true) {
			 		table.addCell("On", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Off", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getSaveAllCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				
		        table.addCell("Hydrapulper", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
				 
		        /**
		        table.addCell("Hydrapulper East", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHydrapulperCol1() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         **/
		        table.addCell("Hydrapulper East Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getHydrapulperCol2Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getHydrapulperCol2outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol2Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        /***
				table.addCell("Lube system pump East", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHydrapulperCol3() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol3Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        table.addCell("Lube system pump East Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getHydrapulperCol4Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getHydrapulperCol4outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol4Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
				table.addCell("Cooling Coil", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHydrapulperCol5() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol5Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        table.addCell("Lube oil system East Filter", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHydrapulperCol6() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol6Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        table.addCell("Hydrapulper West", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHydrapulperCol7() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol7Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         
		        **/
		        table.addCell("Hydrapulper West Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getHydrapulperCol8Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getHydrapulperCol8outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol8Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		         /***
				table.addCell("Lube system pump West", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHydrapulperCol9() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol9Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        table.addCell("Lube system pump West Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getHydrapulperCol10Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getHydrapulperCol10outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol10Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         
		        
				table.addCell("Cooling Coil", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHydrapulperCol11() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol11Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        
		        table.addCell("Lube oil system West Filter", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHydrapulperCol12() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol12Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        table.addCell("Hydrapulper stock Pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHydrapulperCol13() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol13Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        **/
		        table.addCell("Hydrapulper stock Pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getHydrapulperCol14Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getHydrapulperCol14outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol14Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        /**
				 table.addCell("Hydrapulper trim pump", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isHydrapulperCol15() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol15Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        
		        table.addCell("Hydrapulper trim pump Motor", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Temperature  Inbound :"+CommonUtil.replaceNull(data.getHydrapulperCol16Inbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell("Outbound : "+CommonUtil.replaceNull(data.getHydrapulperCol16outbound()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getHydrapulperCol16Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		         
				table.addCell("", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(169, 169, 169, 0));
		        
				table.addCell("Wash M/c floors from the of after dryers to refiners", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell("Every ShiftL:"+data.getDesccol1(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
				table.addCell(CommonUtil.replaceNull(data.getDesccol1Desc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
		        **/ 
				table.addCell("Effluent Sampler working condition:", PdfStyle.FONT_BOLD_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				if (data.isEffluentsamplerworkingcondition() == true) {
			 		table.addCell("Yes", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}
		        table.addCell(CommonUtil.replaceNull(data.getEffluentsamplerworkingconditionDesc()),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);
			}
		}
		
		table.finish();
		
		pdfUtil.close();
	}

	
	
		
	
}
