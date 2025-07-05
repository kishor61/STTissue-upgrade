package com.st;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {  
		
		 try {
	            // Shift start and end times
	            String shiftStartDateStr = "2025-01-03 07:30 AM";
	            String shiftEndDateStr = "2025-01-04 07:30 AM";
	            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm a");

	            // Parse shift start and end times
	            Date shiftStartDate = format1.parse(shiftStartDateStr);
	            Date shiftEndDate = format1.parse(shiftEndDateStr);

	            // Set Day 1 start time (7:30 AM treated as 00:00)
	            Calendar day1StartCal = Calendar.getInstance();
	            day1StartCal.setTime(shiftStartDate);
	            day1StartCal.set(Calendar.HOUR_OF_DAY, 7);
	            day1StartCal.set(Calendar.MINUTE, 30);
	            day1StartCal.set(Calendar.SECOND, 0);
	            day1StartCal.set(Calendar.MILLISECOND, 0);
	            Date day1Start = day1StartCal.getTime();

	            // Set Day 2 end time (7:30 AM treated as 23:59)
	            Calendar day2EndCal = Calendar.getInstance();
	            day2EndCal.setTime(shiftStartDate);
	            day2EndCal.add(Calendar.DATE, 1); // Move to the next day
	            day2EndCal.set(Calendar.HOUR_OF_DAY, 7);
	            day2EndCal.set(Calendar.MINUTE, 30);
	            day2EndCal.set(Calendar.SECOND, 59);
	            day2EndCal.set(Calendar.MILLISECOND, 999);
	            Date day2End = day2EndCal.getTime();

	            // Break input
	            Date breakStart = format1.parse("2025-01-04 4:30 AM");
	            Date breakEnd = format1.parse("2025-01-04 5:30 AM");

	            // Adjust early morning times (12:00 AM to 7:30 AM) to be part of Day 2
	            Calendar breakStartCal = Calendar.getInstance();
	            breakStartCal.setTime(breakStart);
	            if (breakStart.before(day1Start)) {
	                breakStartCal.add(Calendar.DATE, 1); // Move to Day 2 within the shift range
	                breakStart = breakStartCal.getTime();
	            }

	            Calendar breakEndCal = Calendar.getInstance();
	            breakEndCal.setTime(breakEnd);
	            if (breakEnd.before(day1Start)) {
	                breakEndCal.add(Calendar.DATE, 1); // Move to Day 2 within the shift range
	                breakEnd = breakEndCal.getTime();
	            }

	            // Validate if the break is within the shift date range
	            if (breakStart.after(shiftStartDate) && breakEnd.before(shiftEndDate)) {
	                // Validate if the normalized break times are within day1Start and day2End
	                if ((breakStart.after(day1Start) || breakStart.equals(day1Start)) &&
	                        (breakEnd.before(day2End) || breakEnd.equals(day2End))) {
	                    System.out.println("Break is valid and within the shift date range.");
	                } else {
	                    System.out.println("Break is outside the shift date range.");
	                }
	            } else {
	                System.out.println("Break is completely outside the shift date range.");
	            }

	            // Print the results
	            System.out.println("Day Start Time (7:30 treated as 00:00): " + day1Start);
	            System.out.println("Day End Time (7:30 on Day 2 treated as 23:59): " + day2End);
	            System.out.println("Normalized Break Start: " + breakStart);
	            System.out.println("Normalized Break End: " + breakEnd);

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    
		
		
    }
	

}
