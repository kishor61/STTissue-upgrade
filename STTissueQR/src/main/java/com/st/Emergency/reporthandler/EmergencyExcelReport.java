/**
 *Dec 9, 2021
 *EmergencyExcelReport.java
 * TODO
 *com.st.Emergency.reporthandler
 *EmergencyExcelReport.java
 *Sohan Lal 
 */
package com.st.Emergency.reporthandler;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.st.Emergency.model.EmergencyIncident;
import com.st.common.Workbook2007Util;

import jakarta.servlet.ServletOutputStream;

/**
 * @author Sohanlal
 *
 */
@Component
public class EmergencyExcelReport {

	public void EmergencyReport(List<EmergencyIncident> datas, File file, ServletOutputStream outputStream)
			throws IOException {
		Map<String, String> map = new HashMap<>();
		map.put("checkbox11", "1.1 Struck By/Struck Against");
		map.put("checkbox12", "l.2 Pinch Point");
		map.put("checkbox13", "1.3 Eyes on Path");
		map.put("checkbox14", "1.4 Eyes on Task");
		map.put("checkbox15", "1.5 Ascending /Descending");

		map.put("checkbox21", "2.1 Lifting/Lowering");
		map.put("checkbox22", "2.2 Awkward Posture");
		map.put("checkbox23", "2.3 Repetition /Long Duration");
		map.put("checkbox24", "2.4 Forceful Excretion /Push/Pull/Grip");

		map.put("checkbox31", "3.1 Tools& Equipment");
		map.put("checkbox32", "3.2 Mobile Equipment");
		map.put("checkbox33", "3.3 Cranes");

		map.put("checkbox41", "4.1 Lockout/Tagout/Energy ISO");
		map.put("checkbox42", "4.2 Communication Hazards");
		map.put("checkbox43", "4.3 Pre/Post Job Inspection");
		map.put("checkbox44", "4.4 Communication of Location");
		map.put("checkbox45", "1.5 Ascending /Descending");

		map.put("checkbox51", "5.1 Standard PPE");
		map.put("checkbox52", "5.2 Job Specific PPE");
		map.put("checkbox53", "5.3 Fall Protection");

		map.put("checkbox61", "6.1 Walking /Working Surfaces");
		map.put("checkbox62", "6.2 Housekeeping Storage");
		map.put("checkbox63", "6.3 Lighting");
		map.put("checkbox64", "6.4 Air Quality");

		map.put("checkbox71", "7.1 Hurried");
		map.put("checkbox72", "7.2 Frustrated");
		map.put("checkbox73", "7.3 Fatigued");
		map.put("checkbox74", "7.4 Complacent");

		String[] elements = datas.get(0).getStarCategory().split(",");
		List<String> list = Arrays.asList(elements);
		Workbook2007Util util = new Workbook2007Util(file, 0);
		int row = 1;
		int col = 0;
		short rowHeight = 280;
		//char st = '\u2713';
		
		util.addValue(row, col++, datas.get(0).getDateOfIncident(), Workbook2007Util.Style.STYLE_BOLD_CENTER,
				rowHeight);
		util.addValue(row, col++, datas.get(0).getShift(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, datas.get(0).getCrew(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, datas.get(0).getSafeReport(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, datas.get(0).getStatus(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		//util.addValue(row, col++, datas.get(0).getDateReported(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, datas.get(0).getStarIncidentLocation(), Workbook2007Util.Style.STYLE_BOLD_CENTER,
				rowHeight);
		util.addValue(row, col++, datas.get(0).getLocationIncidentOccured(), Workbook2007Util.Style.STYLE_BOLD_CENTER,
				rowHeight);
		//util.addValue(row, col++, datas.get(0).getLocationIncidentOccured(), Workbook2007Util.Style.STYLE_BOLD_CENTER,rowHeight);
		
		util.addValue(row, col++, datas.get(0).getDescpOfEvent(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);	
		
		util.addValue(row, col++, datas.get(0).getIncidentType(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		if(null!=datas.get(0).getFurtherFollowUpRequested())
			util.addValue(row, col, "Yes", Workbook2007Util.Style.STYLE_BOLD_CENTER,rowHeight);
		else
			util.addValue(row, col, "No", Workbook2007Util.Style.STYLE_BOLD_CENTER,rowHeight);
		
		int newrow=row+3;
		int newcol=0;	
		String bodyPosition="";
		String ERGONOMICS="";
		String SELECTION="";
		String PROCEDURES="";
		String PPE="";
		String Environment="";
		String STATEOFMIND="";
		for (String key : list) {
			col=newcol;			
			if (key.startsWith("checkbox1")) {				
				bodyPosition+= map.get(key) + ",";
			} else if (key.startsWith("checkbox2")) {
				ERGONOMICS+= map.get(key) + ",";
			} else if (key.startsWith("checkbox3")) {
				SELECTION+= map.get(key) + ",";
			} else if (key.startsWith("checkbox4")) {
				PROCEDURES+= map.get(key) + ",";
			} else if (key.startsWith("checkbox5")) {
				PPE+= map.get(key) + ",";
			} else if (key.startsWith("checkbox6")) {
				Environment+= map.get(key) + ",";
			} else if (key.startsWith("checkbox7")) {
				STATEOFMIND+= map.get(key) + ",";
			}		
		}
		
		newrow=row+3;
		util.mergeCell(newrow,newrow, 1, 7);
		util.addValue(newrow,0, "1.0 Body Position", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(newrow++,1,bodyPosition, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);		
		util.mergeCell(newrow,newrow, 1, 7);
		util.addValue(newrow,0, "2.0 ERGONOMICS", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(newrow++,1,ERGONOMICS, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(newrow,newrow, 1, 7);
		util.addValue(newrow,0, "3.0 SELECTION/CONDITION/USE", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(newrow++,1,SELECTION , Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(newrow,newrow, 1, 7);
		util.addValue(newrow,0, " 4.0 PROCEDURES", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(newrow++,1,PROCEDURES , Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(newrow,newrow, 1, 7);
		util.addValue(newrow,0, "5.0 PPE", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(newrow++,1,PPE , Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(newrow,newrow, 1, 7);
		util.addValue(newrow,0, "6.0 Environment", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(newrow++,1,Environment, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(newrow,newrow, 1, 7);
		util.addValue(newrow,0, "7.0 STATE OF MIND", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(newrow++,1,STATEOFMIND, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		util.write(outputStream);

	}
}
