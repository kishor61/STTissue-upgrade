/**
 * 
 */
package com.st.oimnotes.report;

import java.awt.Color;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.OimCommon;
import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfReportUtil.Section;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.common.pdfutil.PdfStyle;
import com.st.oimnotes.model.Category;
import com.st.oimnotes.model.FollowUp;
import com.st.oimnotes.model.Summary;

/**
 * @author sbora
 *
 */
@Component
public class OimNotesReportHandler {
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	/**
	 * @param summaries
	 * @param categories
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createOimReport(List<Summary> summaries,
			List<Category> categories, ServletOutputStream outputStream) throws Exception {
		
		
		PdfReportUtil pdfUtil=new PdfReportUtil();
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Housekeeping Standard Report");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_LANDSCAPE);
		pdfUtil.open();
		
		
		Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addText("PROCESS IMPROVEMENT MEETING NOTES", PdfStyle.FONT_BOLD_UNDERLINE_16);
		header.addText("\n\n", PdfStyle.FONT_NORMAL_12);
		
		header.finish();
		
		
		for (Category category : categories) {
			Table table=pdfUtil.new Table(9, new float[]{0.2f,0.8f,5,2,2,2,2,1.5f,1.5f});
			table.setCommonHeader(true,2);
			
			table.addCell(category.getCategory(), PdfStyle.FONT_BOLD_14, PdfStyle.ALIGN_CENTER, 9, 1,new Color(240,248,255));
			
			table.addCell("S.No", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 2, 1);
			table.addCell("Summary", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_LEFT, 6, 1);
			table.addCell("Date", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 1, 1);
			
			
			int count=1;
			for (Summary summary : summaries) {
				if(summary.getCategoryId()==category.getId()){
					table.addCell((count++)+"", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 2, 1);
					table.addCell(CommonUtil.checkNull(summary.getSummary()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 6, 1);
					table.addCell(dateFormat.format(summary.getEntryDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
					
					List<FollowUp> followUps=summary.getFollowUps();
					
					if(followUps.size()>0){
						table.addCell("", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, followUps.size()+1);
						table.addCell("Tag", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("Follow Up", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("Responsibility", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("Timeline", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("Recurrence", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("Status", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("Closed By", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("Closed On", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						
						for (FollowUp followUp : followUps) {
							table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1,OimCommon.getColor(CommonUtil.checkNull(followUp.getTagColor())));
							table.addCell(CommonUtil.checkNull(followUp.getFollowUp()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							table.addCell(CommonUtil.checkNull(followUp.getResponsibility()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							
							Date timeline=followUp.getTimeline();
							if(timeline!=null){
								table.addCell(dateFormat.format(timeline), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);	
							}else{
								table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							}
							
							
							
							if(StringUtils.isNotEmpty(followUp.getRecurrence())){
								table.addCell(CommonUtil.checkNull(OimCommon.getRecurrenceList().get(followUp.getRecurrence())), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							}else{
								table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							}
							
							
							if(followUp.getClosed()!=null){
								table.addCell("Closed", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);	
							}else{
								table.addCell("Open", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
							}
							
							table.addCell(CommonUtil.checkNull(followUp.getClosedBy()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
							
							if(followUp.getClosed()!=null){
								table.addCell(dateFormat.format(followUp.getClosed()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							}else{
								table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							}
							
							
						}
					}
					
					
				}
			}
			
			
			
		
			
			
			
			
			table.finish();
			
			pdfUtil.newPage();
			
		}
		
		
		pdfUtil.close();
		
	}
	/**
	 * @param summaries
	 * @param recurrences
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createOpenFollowUpReport(List<Summary> summaries,
			Map<String, String> recurrences, OutputStream outputStream) throws Exception {
		
		PdfReportUtil pdfUtil=new PdfReportUtil();
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("PROCESS IMPROVEMENT MEETING NOTES - OPEN FOLLOW UP");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_LANDSCAPE);
		pdfUtil.open();
		
		
		Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addText("PROCESS IMPROVEMENT MEETING NOTES- OPEN FOLLOW UP", PdfStyle.FONT_BOLD_UNDERLINE_16);
		header.addText("\n\n", PdfStyle.FONT_NORMAL_12);
		header.finish();
		
		for (Summary summary : summaries) {
			if(summary.getFollowUps().size()>0){
				
				Table table=pdfUtil.new Table(8, new float[]{1,1.5f,6,2,1.5f,1.5f,1.2f,0.8f});
				//table.setCommonHeader(true);
				
				//Header
				table.addCell("Category", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1,new Color(240,248,255));
				table.addCell("Summary", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 5, 1,new Color(240,248,255));
				table.addCell("Date", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1,new Color(240,248,255));
				table.addCell("Days", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1,new Color(240,248,255));
				
				
				table.addCell(summary.getCategory(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(summary.getSummary(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 5, 1);
				table.addCell(dateFormat.format(summary.getEntryDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell(""+summary.getDays(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
				
				table.addCell("", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Follow Up", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 2, 1);
				table.addCell("Responsibility", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Timeline", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Recurrence", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				
				for (FollowUp followUp :summary.getFollowUps()) {
					if(StringUtils.isEmpty(followUp.getTagColor())){
						table.addCell("", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
					}else{
						table.addCell("", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1,OimCommon.getColor(followUp.getTagColor()));
					}
					
					
					table.addCell(followUp.getFollowUp(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 2, 1);
					table.addCell(followUp.getResponsibility(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
					table.addCell(followUp.getTimeline()==null?"":dateFormat.format(followUp.getTimeline()), PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
					if(StringUtils.isEmpty(followUp.getRecurrence())){
						table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);	
					}else{
						table.addCell(recurrences.get(followUp.getRecurrence()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
					}
					
					table.addCell(dateFormat.format(followUp.getEntryDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
					table.addCell(""+followUp.getDays(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
				}
				table.addCell("\n", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 8, 1,0);
				table.finish();
			}
			
			
		}
		
		
		
		pdfUtil.close();
	}

}
