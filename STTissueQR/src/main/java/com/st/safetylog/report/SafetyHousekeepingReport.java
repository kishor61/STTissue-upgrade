/**
 * 
 */
package com.st.safetylog.report;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.common.model.Area;
import com.st.common.model.UserAuditor;
import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfReportUtil.Section;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.common.pdfutil.PdfStyle;
import com.st.safetylog.model.SafetyHousekeeping;
import com.st.safetylog.model.SafetyHousekeepingAction;
import com.st.safetylog.model.SafetyHousekeepingSchedule;
import com.st.safetylog.model.SafetyHousekeepingStdType;
import com.st.safetylog.model.SafetyHousekeepingTask;

/**
 * @author sbora
 *
 */
@Component
public class SafetyHousekeepingReport {
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat weekFormat=new SimpleDateFormat("EEE");
	/**
	 * @param schedules
	 * @param areas
	 * @param auditors
	 * @param dates
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createScheduleReport(
			List<SafetyHousekeepingSchedule> schedules, List<Area> areas,
			List<UserAuditor> auditors, List<Date> dates,
			ServletOutputStream outputStream) throws IOException {
		
		Workbook2007Util workbookUtil=new Workbook2007Util();

		int row=0;
		int col=0;
		short rowHeight=280;
		
		//Header
		workbookUtil.addValue(row++, col++, "Safety Housekeeping - Schedule", Workbook2007Util.Style.STYLE_HEADER_01	,rowHeight);
		workbookUtil.mergeCell(row-1, row-1, 0, dates.size()+1);
		col=0;
		
		workbookUtil.addValue(row++, col++, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.mergeCell(row-1, row-1, 0, 1);
		col++;
		for (Date date : dates) {
			workbookUtil.addValue(row-1, col++, dateFormat.format(date), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		}
		col=0;
		
		
		workbookUtil.addValue(row++, col++, "Area", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.mergeCell(row-1, row-1, 0, 1);
		col++;
		for (Date date : dates) {
			workbookUtil.addValue(row-1, col++, weekFormat.format(date), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		}
		col=0;
		
		
		
		
		
		//Set col size
		for(int i=0;i<dates.size()+2;i++){
			workbookUtil.setAutoSizeColumn(i);
		}
		
		
		
		for (Area area : areas) {
			workbookUtil.addValue(row++, col++, area.getName(), Workbook2007Util.Style.STYLE_NORMAL_LEFT, rowHeight);
			workbookUtil.mergeCell(row-1, row-1, 0, 1);
			col++;
			for (Date date : dates) {
				SafetyHousekeepingSchedule schedule=getSafetyHousekeepingSchedule(area.getId(),date,schedules);
				
				
				if(schedule!=null){
					if(schedule.isAuditStatus()){
						workbookUtil.addValue(row-1, col, schedule.getAuditorName(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
					}else{
						workbookUtil.addValue(row-1, col, schedule.getAuditorName(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
					}
				}else{
					workbookUtil.addValue(row-1, col, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				}
				col++;
			}
			
			col=0;
		}
		
		row++;
		workbookUtil.mergeCell(row, row, 0, 1);
		workbookUtil.addValue(row++, 0, "Color Codes", Workbook2007Util.Style.STYLE_NORMAL_LEFT, rowHeight);
		
		workbookUtil.mergeCell(row, row, 0, 1);
		workbookUtil.addValue(row++, 0, "Audit Complete", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
		
		
		workbookUtil.mergeCell(row, row, 0, 1);
		workbookUtil.addValue(row++, 0, "Audit Incomplete", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
		
		
		workbookUtil.write(outputStream);
	}
	/**
	 * @param id
	 * @param date
	 * @param schedules
	 * @return
	 */
	private SafetyHousekeepingSchedule getSafetyHousekeepingSchedule(int id,
			Date date, List<SafetyHousekeepingSchedule> schedules) {
		SafetyHousekeepingSchedule schedule=null;
		for (SafetyHousekeepingSchedule safetyHousekeepingSchedule : schedules) {
			if(date.compareTo(safetyHousekeepingSchedule.getDate())==0 && safetyHousekeepingSchedule.getArea()==id){
				schedule=safetyHousekeepingSchedule;
				break;
			}
		}
		return schedule;
	}
	/**
	 * @param housekeepingTask
	 * @param types
	 * @param housekeepings
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createHousekeepingStandardReport(
			SafetyHousekeepingTask housekeepingTask,
			List<SafetyHousekeepingStdType> types,
			List<SafetyHousekeeping> housekeepings,
			ServletOutputStream outputStream) throws Exception {
		// TODO Auto-generated method stub
		
		PdfReportUtil pdfUtil=new PdfReportUtil();
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Housekeeping Standard Report");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
		pdfUtil.open();
		
		
		
		Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addText("SAFETY HOUSEKEEPING", PdfStyle.FONT_BOLD_UNDERLINE_16);
		header.finish();
		
		
		Section section=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		section.addText("Audit Date:-", PdfStyle.FONT_BOLD_10);
		section.addText(new SimpleDateFormat("MM-dd-yyyy").format(housekeepingTask.getDate())+""
				+ "        ", PdfStyle.FONT_NORMAL_10);
		
		section.addText("Auditor:-", PdfStyle.FONT_BOLD_10);
		section.addText(housekeepingTask.getAuditorName()+"   "
				+ "     ", PdfStyle.FONT_NORMAL_10);
		
		section.addText("Area:-", PdfStyle.FONT_BOLD_10);
		section.addText(housekeepingTask.getAreaName()+"   "
				+ "     ", PdfStyle.FONT_NORMAL_10);
		
		section.finish();
		
		
		
		for (SafetyHousekeepingStdType type : types) {
			
			Table table=pdfUtil.new Table(8, new float[]{1.5f,2f,5,5,3,3,3,3});
			table.setCommonHeader(true);
			
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,new Color(240,248,255));
			table.addCell("S.No", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 1, 1,new Color(240,248,255));
			table.addCell(""+type.getName(), PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 4, 1,new Color(240,248,255));
			table.addCell("Score: "+type.getScore()+"%", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 2, 1,new Color(240,248,255));
			
			int count=0;
			for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
				
				
				
				
				if(safetyHousekeeping.getType().equals(type.getId())){
					
					if(safetyHousekeeping.isCompleted()){
						table.addImage(this.getClass().getClassLoader().getResource("/images/Checkmark-icon.png"), 2, -2, PdfStyle.ALIGN_CENTER, 1, 1);
					}else{
						table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
					}
					
					table.addCell((++count)+"", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
					table.addCell(safetyHousekeeping.getDescription()+"", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 6, 1);
					
					
					
					if(safetyHousekeeping.getActions().size()>0){
						table.addCell("Actions", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 2, safetyHousekeeping.getActions().size()+1);
						table.addCell("Description Of Finding", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("Corrective Action", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("By Whom", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("Status", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("Closed By", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						table.addCell("Closed On", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
						
						for (SafetyHousekeepingAction housekeepingAction : safetyHousekeeping.getActions()) {
							table.addCell(CommonUtil.checkNull(housekeepingAction.getDescOfFinding()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							table.addCell(CommonUtil.checkNull(housekeepingAction.getCorrectiveAction()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							table.addCell(CommonUtil.checkNull(housekeepingAction.getByWhom()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							Date date=housekeepingAction.getClosed();
							if(date==null){
								table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);	
							}else{
								table.addCell("Closed", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							}
							
							
							table.addCell(CommonUtil.checkNull(housekeepingAction.getClosedBy()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							
							if(date==null){
								table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);	
							}else{
								table.addCell(dateFormat.format(date), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
							}
						
							
						}
						
					}
					
				}
			}
			table.finish();
		}
		
		
	
		
		pdfUtil.close();
		
	}
	/**
	 * @param types
	 * @param housekeepings
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createHousekeepingStandardReport(
			List<SafetyHousekeepingStdType> types,
			List<SafetyHousekeeping> housekeepings,
			OutputStream outputStream) throws Exception {
		
		PdfReportUtil pdfUtil=new PdfReportUtil();
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Housekeeping Standard Report");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_LANDSCAPE);
		pdfUtil.open();
		
		
		
		Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addText("ST Tissue Safety, Environmental and Housekeeping Inspection", PdfStyle.FONT_BOLD_UNDERLINE_16);
		header.addText("\n\n", PdfStyle.FONT_NORMAL_12);
		header.addText("Date of Inspection ________Auditor ________ Audit Area _________.", PdfStyle.FONT_NORMAL_12);
		header.addText("\n", PdfStyle.FONT_NORMAL_12);
		header.addText("Safety/Environmental Score - ______%_ Housekeeping Score - _____ %_  (passing score =�s 80% or better)", PdfStyle.FONT_NORMAL_12);
		header.addText("\n\n", PdfStyle.FONT_NORMAL_ITALIC_8);
		header.addText("Note � housekeeping & safety standards preceded by a checkmark are the standards that were not met.", PdfStyle.FONT_NORMAL_ITALIC_8);
		header.addText("\n", PdfStyle.FONT_NORMAL_12);
		header.finish();
		
		
		for (SafetyHousekeepingStdType safetyHousekeepingStdType : types) {
			
			Table table=pdfUtil.new Table(3, new float[]{0.5f,2,5});
			table.setCommonHeader(true,2);
			table.addCell(safetyHousekeepingStdType.getName(), PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_LEFT, 3, 1);
			
			table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1	, 1);
			table.addCell("Standard", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1);
			table.addCell("Findings & comments", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1);
			
			int count=1;
			for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
				
				if(safetyHousekeeping.getType().equals(safetyHousekeepingStdType.getId())){
					table.addCell((count++)+"", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1	, 1);
					table.addCell(safetyHousekeeping.getDescription(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1	, 1);
					table.addCell("\n\n\n", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1	, 1);
					
				}
			}
			
			table.addCell("Action \n\n\n\n\n\n", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_LEFT, 3, 1);
			table.finish();
			
			
			Section section=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
			section.addText("\n", PdfStyle.FONT_NORMAL_12);
			section.finish();
			
		}
		
		pdfUtil.close();
	}
	/**
	 * @param housekeepings
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createHousekeepingOpenReport(
			List<SafetyHousekeeping> housekeepings,
			OutputStream outputStream) throws Exception {
		
		PdfReportUtil pdfUtil=new PdfReportUtil();
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Housekeeping Standard Report");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_PORTRAIT);
		pdfUtil.open();
		
		Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addText("SAFETY HOUSEKEEPING - OPEN ACTIONS REPORT", PdfStyle.FONT_BOLD_UNDERLINE_16);
		header.addText("\n\n", PdfStyle.FONT_NORMAL_12);
		header.finish();
		
		
		
		
		for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
			
			
			if(safetyHousekeeping.getActions().size()>0){
				Table table=pdfUtil.new Table(7, new float[]{2,2,5,4,2.5f,2.5f,1.5f});
				table.setCommonHeader(true);
				
				table.addCell("Description", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 5, 1, new Color(240,248,255));
				table.addCell("Standard Type", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 2, 1,new Color(240,248,255));
				
				table.addCell(safetyHousekeeping.getDescription(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 5, 1);
				table.addCell(safetyHousekeeping.getType(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 2, 1);
				
				table.addCell("Auditor", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Area", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Description Of Finding", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Corrective Action", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("By Whom", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Date", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Days", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
				
				for (SafetyHousekeepingAction action : safetyHousekeeping.getActions()) {
					table.addCell(action.getAuditorName(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
					table.addCell(action.getAreaName(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
					table.addCell(action.getDescOfFinding(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
					table.addCell(action.getCorrectiveAction(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_LEFT, 1, 1);
					table.addCell(action.getByWhom(), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
					table.addCell(dateFormat.format(action.getDate()), PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
					table.addCell(""+action.getDays(),PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
				}

				table.addCell("\n\n", PdfStyle.FONT_BOLD_12, PdfStyle.ALIGN_CENTER, 7, 1,0);
				
				table.finish();
				
			}
			
			
		}
		
		
		pdfUtil.close();
	}
	/**
	 * @param housekeepings
	 * @param areas
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createHousekeepingClosedReport(
			List<SafetyHousekeeping> housekeepings, List<Area> areas,
			OutputStream outputStream) throws Exception {
		PdfReportUtil pdfUtil=new PdfReportUtil();
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("Housekeeping Standard Report");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_LANDSCAPE);
		pdfUtil.open();
		
		Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addText("SAFETY HOUSEKEEPING - CLOSED ACTIONS REPORT", PdfStyle.FONT_BOLD_UNDERLINE_16);
		header.addText("\n\n", PdfStyle.FONT_NORMAL_12);
		header.finish();
		
		
		double pmType=0;
		double frpType=0;
		double officeType=0;
		double shippingType=0;
		double otherType=0;
		
		int pmTypeCount=0;
		int frpTypeCount=0;
		int officeTypeCount=0;
		int shippingTypeCount=0;
		int otherTypeCount=0;
		
		
		for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
			
			
			if(safetyHousekeeping.getActions().size()>0){
				Table table=pdfUtil.new Table(8, new float[]{2,2,5,4,2.5f,2.5f,2.5f,1.5f});
				table.setCommonHeader(true,3);
				
				table.addCell("Description", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 6, 1, new Color(240,248,255));
				table.addCell("Standard Type", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 2, 1,new Color(240,248,255));
				
				table.addCell(safetyHousekeeping.getDescription(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 6, 1);
				table.addCell(safetyHousekeeping.getType(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 2, 1);
				
				table.addCell("Auditor", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Area", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Description Of Finding", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Corrective Action", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("By Whom", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Date", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Closed On", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				table.addCell("Days", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1);
				
				for (Area area : areas) {
					double avg=0;
					int count=0;
					for (SafetyHousekeepingAction action : safetyHousekeeping.getActions()) {
						if(area.getId()==action.getArea()){
							table.addCell(action.getAuditorName(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
							table.addCell(action.getAreaName(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
							table.addCell(action.getDescOfFinding(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1);
							table.addCell(action.getCorrectiveAction(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_LEFT, 1, 1);
							table.addCell(action.getByWhom(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
							table.addCell(dateFormat.format(action.getDate()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
							table.addCell(dateFormat.format(action.getClosed()), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
							table.addCell(""+action.getDays(),PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1);
							avg+=action.getDays();
							count++;
							
							
							if(action.getAreaType()==1){
								pmType+=action.getDays();
								pmTypeCount++;
							}else if(action.getAreaType()==2){
								frpType+=action.getDays();
								frpTypeCount++;
							}else if(action.getAreaType()==3){
								officeType+=action.getDays();
								officeTypeCount++;
							}else if(action.getAreaType()==4){
								shippingType+=action.getDays();
								shippingTypeCount++;
							}else if(action.getAreaType()==5){
								otherType+=action.getDays();
								otherTypeCount++;
							}
							
						}
					}
					
					if(count>0){
						table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 6, 1,new Color(253,245,230));
						table.addCell("AVG", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,new Color(253,245,230));
						table.addCell(CommonUtil.round(avg/count, 2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,new Color(253,245,230));
					}
				}

				table.addCell("\n", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 8, 1,0);
				
				table.finish();
				
			}
			
			
		}
		
		//pdfUtil.newPage();
		
		Table table=pdfUtil.new Table(3, new float[]{2,3,7});
		
		

		table.addCell("Area", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
		table.addCell("Average Days To Close", PdfStyle.FONT_BOLD_10, PdfStyle.ALIGN_CENTER, 1, 1);
		table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1,0);
		
		
		table.addCell("PM", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		if(pmType>0){
			table.addCell(CommonUtil.round(pmType/pmTypeCount, 2)+"", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		}else{
			table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		}
		table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1, 0);
		
		table.addCell("FRP", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		if(frpType>0){
			table.addCell(CommonUtil.round(frpType/frpTypeCount, 2)+"", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		}else{
			table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		}
		table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER,1, 1, 0);
		
		table.addCell("Office", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		if(officeType>0){
			table.addCell(CommonUtil.round(officeType/officeTypeCount, 2)+"", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		}else{
			table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		}
		table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1, 0);
		
		table.addCell("Shipping", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		if(shippingType>0){
			table.addCell(CommonUtil.round(shippingType/shippingTypeCount, 2)+"", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		}else{
			table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		}
		table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1, 0);
		
		table.addCell("Other", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		if(otherType>0){
			table.addCell(CommonUtil.round(otherType/otherTypeCount, 2)+"", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		}else{
			table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1);
		}
		table.addCell("", PdfStyle.FONT_NORMAL_10, PdfStyle.ALIGN_CENTER, 1, 1, 0);
		
		table.finish();
		
		
		pdfUtil.close();
	}

	
	
}
