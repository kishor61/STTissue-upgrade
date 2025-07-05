/**
 *Apr 3, 2018
 *IncidentalReportHandler.java
 * TODO
 *com.st.incidental.report
 *IncidentalReportHandler.java
 *Roshan Lal Tailor
 */
package com.st.incidental.report;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfReportUtil.Section;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.common.pdfutil.PdfStyle;
import com.st.incidental.model.Incidental;

/**
 * @author roshan
 *
 */
@Component
public class IncidentalReportHandler {


	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat weekFormat=new SimpleDateFormat("EEE");
	
	/**
	 * @param details
	 * @param details1
	 * @param outputStream
	 * @throws Exception 
	 */
	public void reviewedActionsPDFReport(List<Incidental> details,
			List<Incidental> details1, ServletOutputStream outputStream) throws Exception {PdfReportUtil pdfUtil=new PdfReportUtil();
			pdfUtil.setOuputStream(outputStream);
			pdfUtil.setDocumentTitle("INCIDENTAL DOCUMENT REVIEWED ACTION(S)");
			pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
			pdfUtil.open();
			
			Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
			header.addText("INCIDENTAL DOCUMENT REVIEWED ACTION(S) REPORT", PdfStyle.FONT_BOLD_UNDERLINE_16);
			header.addText("\n\n", PdfStyle.FONT_NORMAL_12);
			header.finish();
			
			
			
			
			for (Incidental data : details) {
					Table table=pdfUtil.new Table(7, new float[]{2,2,5,4,2.5f,2.5f,1.5f});
					table.setCommonHeader(true);
					
					table.addCell("Description", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 7, 1, new Color(240,248,255));
					
					table.addCell(data.getDescription(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 7, 1);
					//table.addCell(data.getType(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 2, 1);
					
					table.addCell("Upload Date", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
					table.addCell("Subject", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 2, 1);
					table.addCell("Reviewed By", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
					table.addCell("Review Date", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
					table.addCell("Comment", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 2, 1);
					
					
					for (Incidental data1 : details1) {
						
						if(data1.getId()==data.getId()){
							table.addCell(dateFormat.format(data.getDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
							table.addCell(data.getSubject(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 2, 1);
							
							table.addCell(data1.getName(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
							table.addCell(dateFormat.format(data1.getReviewdate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
							table.addCell(data1.getComment(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 2, 1);
						}
					}
					
					table.addCell("Document No Reviewed By:"+data.getNotrevieduser(), PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 7, 1, new Color(240,248,255));
					table.addCell("", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 7, 1, new Color(240,248,255));
					table.addCell("\n\n", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 7, 1,0);
					table.finish();
			}
			pdfUtil.close();}

}
