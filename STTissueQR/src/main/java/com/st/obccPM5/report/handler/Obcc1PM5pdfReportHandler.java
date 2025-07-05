/**
 *Oct 30, 2019
 *ObccPM5pdfReportHandler.java
 * TODO
 *com.st.obccPM5.report.handler
 *ObccPM5pdfReportHandler.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.report.handler;

import java.awt.Color;
import java.io.OutputStream;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfStyle;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.obccPM5.model.LeadOperatorPM5;
import com.st.obccPM5.model.R1OperatorPM5;
import com.st.obccPM5.model.R2OperatorPM5;
import com.st.obccPM5.model.StockOperatorPM5;

/**
 * @author roshan
 *
 */
@Component
public class Obcc1PM5pdfReportHandler {
	
	public void createR2Pdf(List<R2OperatorPM5> datas, OutputStream outputStream,long l)
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
			for (R2OperatorPM5 data : datas) {
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
										.getOperatorName()),
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

				if (data.isWindedeckstopscol1() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getWindedeckstopscol1Desc(),
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

				table.addCell(data.getConveyorcol1Desc(),
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

				table.addCell(data.getConveyorcol2Desc(),
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

				table.addCell(data.getConveyorcol3Desc(),
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

				table.addCell(data.getConveyorcol4Desc(),
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

				table.addCell(data.getConveyorcol5Desc(),
						PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("CORE SAW", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(
								169, 169, 169, 0));

				table.addCell("Power", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isCoresawcol1() == true) {
					table.addCell("On", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("Off", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getCoresawcol1Desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("Blade", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isCoresawcol2() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getCoresawcol2Desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("Vacuum", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isCoresawcol3() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getCoresawcol3Desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("Size Adjustment Movement",
						PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isCoresawcol4() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getCoresawcol4Desc(), PdfStyle.FONT_NORMAL_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				table.addCell("CORES", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 6, 1, 1, 5, 5, 5, 5, new Color(
								169, 169, 169, 0));

				table.addCell("Correct Size For Order", PdfStyle.FONT_BOLD_10,
						PdfStyle.ALIGN_LEFT, 2, 1, 1);

				if (data.isCorescol1() == true) {
					table.addCell("Yes", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				} else {
					table.addCell("No", PdfStyle.FONT_NORMAL_10,
							PdfStyle.ALIGN_LEFT, 2, 1, 1);
				}

				table.addCell(data.getCorescol1Desc(), PdfStyle.FONT_NORMAL_10,
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

	/**
	 * @param lst
	 * @param outputStream
	 * @param l
	 */
	public void createR1OperatorPdf(List<R1OperatorPM5> lst,
			ServletOutputStream outputStream, long l) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param daylst
	 * @param nightlst
	 * @param outputStream
	 * @param l
	 */
	public void createStockOperatorPM5Pdf(List<StockOperatorPM5> daylst,
			List<StockOperatorPM5> nightlst, ServletOutputStream outputStream,
			long l) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @param daylst
	 * @param nightlst
	 * @param outputStream
	 * @param l
	 */
	public void createLeadOperatorPM5Pdf(List<LeadOperatorPM5> daylst,
			List<LeadOperatorPM5> nightlst, ServletOutputStream outputStream,
			long l) {
		// TODO Auto-generated method stub
		
	}

}
