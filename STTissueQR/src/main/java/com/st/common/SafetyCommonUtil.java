/**
 * 
 */
package com.st.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.st.safetylog.model.SafetyHousekeeping;
import com.st.safetylog.model.SafetyHousekeepingStdType;
import com.st.safetylog.model.SafetyHousekeepingTask;

/**
 * @author sbora
 *
 */
public class SafetyCommonUtil {
	
	
	public static String getHousekeepingId(int auditor,int area,String date){
		StringBuilder builder=new StringBuilder();
		builder.append(auditor);
		builder.append("-");
		builder.append(area);
		builder.append("-");
		builder.append(date);
		return builder.toString();
	}
	
	public static String getScheduleWeekId(int auditor,int area,Date date){
		StringBuilder builder=new StringBuilder();
		builder.append(auditor);
		builder.append("-");
		builder.append(area);
		builder.append("-");
		builder.append(new SimpleDateFormat("EEE").format(date));
		return builder.toString();
	}
	
	public static String getScheduleMonthId(int auditor,int area,Date date){
		StringBuilder builder=new StringBuilder();
		builder.append(auditor);
		builder.append("-");
		builder.append(area);
		builder.append("-");
		builder.append(new SimpleDateFormat("dd").format(date));
		return builder.toString();
	}
	public static String getScheduleDayId(int auditor,int area){
		StringBuilder builder=new StringBuilder();
		builder.append(auditor);
		builder.append("-");
		builder.append(area);
		builder.append("-");
		builder.append("D");
		return builder.toString();
	}
	
	
	
	
	public static Map<String, String> getRecurrence() {
		Map<String, String> map=new LinkedHashMap<String, String>();
		map.put("D", "Daily");
		map.put("W", "Weekly ");
		map.put("M", "Monthly");
		return map;
		
	}
	
	public static List<Date> getScheduleRange(Date sdate,Date edate,String recurrence) {
		List<Date> dates=new ArrayList<>();
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		
		dates.add(scal.getTime());
		
		while(scal.before(ecal)){
			/*
			if(recurrence.equalsIgnoreCase("D")){
				scal.add(Calendar.DATE, 1);
			}else if(recurrence.equalsIgnoreCase("W")){
				scal.add(Calendar.DATE, 7);
			}else if(recurrence.equalsIgnoreCase("M")){
				scal.add(Calendar.MONTH, 1);
			}
			//Code Done By Roshan Tailor Date :- 12/20/2016
			
			 * This Code Written To See Only Monday Report If Want To See Whole Days Comment The Below Code.
			 * 
			if (scal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				dates.add(scal.getTime());
				System.out.println("This Is Monday...");
			}
			//Code Ends Here Done By Roshan Tailor Date :- 12/20/2016
			
		*/
			if(recurrence.equalsIgnoreCase("D")){
				scal.add(Calendar.DATE, 1);
			}else if(recurrence.equalsIgnoreCase("W")){
				scal.add(Calendar.DATE, 1);
			}else if(recurrence.equalsIgnoreCase("M")){
				//scal.add(Calendar.MONTH, 1);
				scal.add(Calendar.DATE, 1);
			}
			if (scal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				dates.add(scal.getTime());
				System.out.println("This Is Monday...");
			}
		
		}
		
		
		return dates;
		
		
	}
	
	
	public static void getTaskScore(List<SafetyHousekeepingStdType> types,
			List<SafetyHousekeeping> housekeepings,SafetyHousekeepingTask housekeepingTask) {
		
		List<Integer> integers=housekeepingTask.getCompletedIds();
		
		for (SafetyHousekeepingStdType type : types) {
			float noOfTask=0;
			float completed=0;
			for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
				if(type.getId().equals(safetyHousekeeping.getType())){
					noOfTask+=1;
					if(integers.contains(safetyHousekeeping.getId())){
						completed+=1;
					}
				}
			}
			double perc=(completed/noOfTask)*100;
			type.setScore(CommonUtil.round(perc, 2));
			
		}

	}
}
