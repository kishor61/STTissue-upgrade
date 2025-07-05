/**
 *19-Dec-2019
 *PdfReportHandler.java
 * TODO
 *com.st.frpobcc.handler
 *PdfReportHandler.java
 *Roshan Lal Tailor
 */
package com.st.frpobcc.handler;

import java.awt.Color;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfStyle;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.frpobcc.model.OpRoute_1;

/**
 * @author sohan
 *
 */
@Component
public class PdfReportHandler {

	/**
	 * @param data
	 * @param outputStream
	 * @param percentage
	 * @throws Exception 
	 */
	public void OpRoute_1Pdf(List<OpRoute_1> datas, ServletOutputStream outputStream, long percentage) throws Exception {
		PdfReportUtil pdfUtil = new PdfReportUtil(15f, 15f, 10f, 10f);

		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("OpRoute_1 With "+percentage+"% Data");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
		pdfUtil.open();

		if (datas.size() != 0) {
		Table table = pdfUtil.new Table(6, new float[] { 1, 1, 1, 1, 1, 1 });
		table.addCell("OBCC Completed = "+percentage+"%", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
		for(OpRoute_1 data:datas)
		{
			table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			table.addCell("frp pdf report",PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 6, 1, 1,
					5, 5, 5, 5, new Color(203, 132, 46, 96));
			table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 1, 1, 0);
			table.addCellRightBorder(data.getPosition()+ ":-"+ CommonUtil.capitalizeFirstLetter("Some Value"),
					PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT, 5, 1, 0);
			table.addCellLeftBorder("", PdfStyle.FONT_BOLD_12,PdfStyle.ALIGN_RIGHT, 3, 1, 0);
			table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
			table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_RIGHT,6, 1, 0);
		}
			table.finish();
		} else {
			System.out.println("size is zero");
		}

		pdfUtil.close();
	}

}
