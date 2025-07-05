/**
 *Feb 15, 2017
 *OBCCCommanMehod.java
 * TODO
 *com.st.obcc.model
 *OBCCCommanMehod.java
 *Roshan Lal Tailor
 */
package com.st.obcc.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author roshan
 *
 */
public class OBCCCommanMehod {

	public static String getLastDateOfMonth(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date convertedDate;
		try {
			convertedDate = dateFormat.parse(date);
			Calendar c = Calendar.getInstance();
			c.setTime(convertedDate);
			c.set(Calendar.DAY_OF_MONTH,
					c.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date lastDayOfMonth = c.getTime();
			DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			return sdf.format(lastDayOfMonth);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public static String addOneMonth(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date convertedDate;
		try {
			convertedDate = dateFormat.parse(date);
			Calendar c = Calendar.getInstance();
			c.setTime(convertedDate);
			c.add(Calendar.MONTH, 1);
			Date lastDayOfMonth = c.getTime();
			DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			return sdf.format(lastDayOfMonth);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public static int getYear(String date)
	{
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Date convertedDate;
			try {
				convertedDate = dateFormat.parse(date);
				Calendar cal = Calendar.getInstance();
			    cal.setTime(convertedDate);
			    return cal.get(Calendar.YEAR);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
		 	
	}
	public static int getMonth(String date)
	{
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			Date convertedDate;
			try {
				convertedDate = dateFormat.parse(date);
				Calendar cal = Calendar.getInstance();
			    cal.setTime(convertedDate);
			    return cal.get(Calendar.MONTH);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
		 	
	}
	
	public static boolean checksameMonth(String sdate,String edate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date convertedDate1;
		Date convertedDate2;
		try {
			convertedDate1 = dateFormat.parse(sdate);
			convertedDate2 = dateFormat.parse(edate);
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal1.setTime(convertedDate1);
			cal2.setTime(convertedDate2);
			boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
			                  cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
			
			return sameDay;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static int differenceInMonths(final Date s1, final Date s2) {
		    final Calendar d1 = Calendar.getInstance();
		    d1.setTime(s1);
		    final Calendar d2 = Calendar.getInstance();
		    d2.setTime(s2);
		    int diff = (d2.get(Calendar.YEAR) - d1.get(Calendar.YEAR)) * 12 + d2.get(Calendar.MONTH) - d1.get(Calendar.MONTH);
		    return diff;
	}
	
	
	
	public static void main(String[] args) {
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	    Date d1;
		try {
			 d1 = f.parse("2012-01-01");
			 Date d2 = f.parse("2013-02-02");
			int n = differenceInMonths(d1, d2);
			System.out.println(n);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		
	}
}
