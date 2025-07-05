package com.st.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.NumberUtils;

import com.st.qualitypm5.model.GradeTargetPM5;
import com.st.qualitypm6.model.GradeTarget;



public class CommonUtil {

	public static final String REEL_TEST_ENTRY_PAGE = "reelentryurl";
	public static final String REEL_TEST_ENTRY_PAGE_PM5 = "reelentryurlpm5";
	
	public static final String REWIND_TEST_ENTRY_PAGE = "rewindentryurl";
	public static final String REWIND_TEST_ENTRY_PAGE_PM5 = "rewindentryurlpm5";

	public static final String HOUSE_KEEP_SCHEDULE_PAGE = "housekeepingscheduleurl";
	public static final String HOUSE_KEEP_SCHEDULE_PAGE2 = "housekeepingscheduleurl2";

	//
	public static final String FRP_PROJECTION_PAGE = "fprprojectionurl";
	public static final String FRP_PROJECTION_JON_PAGE = "fprprojectionjonurl";
	public static final String FIBER_PURCHASING_PAGE = "fiberpurchasingurl";
	public static final String FIBER_PURCHASING_PAGE_WHITE = "fiberpurchasingurl_white";

	public static final String EMERGENCY_ALARM_FLAG = "emergencyAlramFlag";

	/*
	 * public static final String REEL_TD_INDEX = "reeltdindex"; public static
	 * final String REEL_TR_INDEX = "reeltrindex"; public static final String
	 * REWIND_TD_INDEX = "rewindtdindex"; public static final String
	 * REWIND_TR_INDEX = "rewindtrindex";
	 */

	public static final String MAIL_DATE = "mail.send.qulity.date";

	public static final String OLD_SHIFT_DATE = "lastshiftdate";

	private static Properties properties = new Properties();
	private static String fileName = "common.prop";

	public static Date getYesterday() {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -1);
	    return cal.getTime();
	}
	public static void save(String key, String value) {
		File file = new File(fileName);
		System.out.println(file.getAbsolutePath());
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			FileReader reader = new FileReader(file);
			properties.load(reader);
			properties.setProperty(key, value);
			reader.close();

			FileWriter writer = new FileWriter(file);
			properties.store(writer, null);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String load(String key) {

		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			FileReader reader = new FileReader(file);
			properties.load(reader);
			reader.close();
			return properties.getProperty(key);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public static double getValue(List<GradeTarget> gradeTargets, String prop) {
		double val = 0;

		for (GradeTarget gradeTarget : gradeTargets) {
			if (gradeTarget.getPhysicalProperty().equals(prop)) {
				val = gradeTarget.getTarget();
				break;
			}
		}
		return val;
	}

	public static String checkNull(String string) {
		return string == null ? "" : string.trim();
	}

	public static double checkDouble(String string) {
		if(string==null||string.isBlank())
			return 0;
		return NumberUtils.parseNumber(string, Double.class);
	}

	public static int checkInt(String string) {
		if(string==null||string.isBlank())
			return 0;
		return NumberUtils.parseNumber(string,Integer.class);
	}

	public static boolean checkBoolean(String string) {
		return BooleanUtils.toBoolean(string, "true", "false");
	}

	public static Date checkDate(String string, SimpleDateFormat dateFormat) {
		Date date = null;
		try {
			if (string != null && !string.trim().equals("")) {
				date = dateFormat.parse(string);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public static int checkDiffForFindMatch(String s, double value) {

		String d = new Double(round(value, 1)).toString().replaceAll("\\.", "");

		int diff = (NumberUtils.parseNumber(s, Integer.class) - NumberUtils.parseNumber(d, Integer.class));

		return diff;
	}

	public static String timeDiff(String dateStart, String dateHH, String dateMM) {

		final DateTimeFormatter format = DateTimeFormat.forPattern("HH:mm");
		final DateTime dt1 = format.parseDateTime(dateStart);

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(dt1.getMillis());
		calendar.add(Calendar.HOUR_OF_DAY, NumberUtils.parseNumber(dateHH, Integer.class));
		calendar.add(Calendar.MINUTE, NumberUtils.parseNumber(dateMM, Integer.class));

		final DateTime dt2 = new DateTime(calendar.getTime().getTime());

		return format.print(dt2);

	}

	public static Date getDateTime(Date date, Date time) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalTime localTime = time.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
		LocalDateTime dateTime = localDate.atTime(localTime);
		Date out = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(out);
		return out;
	}

	public static Date getShiftDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM-dd-yyyy");

		Date rdate = new Date();

		String ctime = dateFormat.format(new Date());
		String ftime = "06:00";

		Date ctimeDate = null;
		try {
			ctimeDate = dateFormat.parse(ctime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date ftimeDate = null;
		try {
			ftimeDate = dateFormat.parse(ftime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (ctimeDate.before(ftimeDate)) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.DATE, -1);

			try {
				rdate = dateFormat2
						.parse(dateFormat2.format(calendar.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			try {
				rdate = dateFormat2.parse(dateFormat2.format(new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return rdate;
	}

	
	public static boolean isEqual(Date date1, Date date2) { 
	   LocalTime localTime1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
		LocalTime localTime2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
		return localTime1.equals(localTime2);
	}

	public static int getHoursDuration(Date date1, Date date2) {
		// System.out.println(date1);
		// System.out.println(date2);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		calendar2
				.add(Calendar.HOUR_OF_DAY, -calendar.get(Calendar.HOUR_OF_DAY));
		calendar2.add(Calendar.MINUTE, -calendar.get(Calendar.MINUTE));

		return calendar2.get(Calendar.HOUR_OF_DAY);

	}

	public static int getMinutesDuration(Date date1, Date date2) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		calendar2
				.add(Calendar.HOUR_OF_DAY, -calendar.get(Calendar.HOUR_OF_DAY));
		calendar2.add(Calendar.MINUTE, -calendar.get(Calendar.MINUTE));
		return calendar2.get(Calendar.MINUTE);

	}

	public static int getMinutesDiff(Date date1, Date date2) {		
		LocalTime localTime1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
		LocalTime localTime2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
		return (int) Duration.between(localTime1, localTime2).toMinutes();
	}

	public static int getDaysDiffernce(Date sdate, Date edate) {		
		LocalTime localTime1 = sdate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
		LocalTime localTime2 = edate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
		return (int)Duration.between(localTime1, localTime2).toDays();
	}
	

	public static Date getFirstDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);

		return calendar.getTime();
	}

	public static Date getFirstDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);

		return calendar.getTime();
	}

	public static boolean isValidEmail(final String hex) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(hex);

		return !matcher.matches();
	}

	public static String getUniqueID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * @param shiftDate
	 * @param date
	 * @return
	 */
//	public static int getHoursDifference(Date date1, Date date2) {
//		int hours = Hours.hoursBetween(new DateTime(date1.getTime()),
//				new DateTime(date2.getTime())).getHours();
//		return hours % 24;
//	}

	public static Date getMonthFirstDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		return calendar.getTime();
	}

	public static Date getMonthLastDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

	public static String getFileContentType(File file) throws Exception {
		Path path = Paths.get(file.toURI());

		return Files.probeContentType(path);
	}

	public static String capitalizeFirstLetter(String original) {
		if (original == null || original.length() == 0) {
			return original;
		}
		return original.substring(0, 1).toUpperCase() + original.substring(1);
	}

	public static String KRAFT_NAPKIN = "Kraft Napkin";
	public static String KRAFT_TISSUE = "Kraft Bath Tissue";
	public static String KRAFT_TOWEL = "Kraft Towel";
	public static String WHITE_NAPKIN = "White Napkin";
	public static String WHITE_TISSUE = "White Bath Tissue";
	public static String WHITE_TOWEL = "White Towel";

	public static String getGradeFromGradeCode(String gradeCode) {
		String grade = "";
		if (StringUtils.isNotEmpty(gradeCode)) {
			if (gradeCode.contains("-98-")) {
				if (gradeCode.contains("-1-")) {
					grade = KRAFT_NAPKIN;
				} else if (gradeCode.contains("-2-")) {
					grade = KRAFT_TISSUE;
				}
				if (gradeCode.contains("-3-")) {
					grade = KRAFT_TOWEL;
				}

			} else {
				if (gradeCode.contains("-1-")) {
					grade = WHITE_NAPKIN;
				} else if (gradeCode.contains("-2-")) {
					grade = WHITE_TISSUE;
				}
				if (gradeCode.contains("-3-")) {
					grade = WHITE_TOWEL;
				}
			}
		}

		return grade;
	}

	// Returning Null As Blank
	public static String replaceNull(String input) {
		return input == null ? "" : input;
	}

	//

	public static String capitalizeFirstandSecondFirstLetter(String original) {
		String str = null;
		if (original.equals("backtender")) {
			str = original.substring(0, 1).toUpperCase()
					+ original.substring(1, 4) + " "
					+ original.substring(4, 5).toUpperCase()
					+ original.substring(5);
		} else if (original.equals("machinetender")) {
			str = original.substring(0, 1).toUpperCase()
					+ original.substring(1, 7) + " "
					+ original.substring(7, 8).toUpperCase()
					+ original.substring(8);
		} else if (original.equals("stockoperator")) {
			str = original.substring(0, 1).toUpperCase()
					+ original.substring(1, 5) + " "
					+ original.substring(5, 6).toUpperCase()
					+ original.substring(6);
		} else if (original.equals("utilityoperator")) {
			str = original.substring(0, 1).toUpperCase()
					+ original.substring(1, 7) + " "
					+ original.substring(7, 8).toUpperCase()
					+ original.substring(8);
		}
		return str;
	}

	public static String dateParseOrFormat(Date dt) {

		SimpleDateFormat parser = new SimpleDateFormat(
				"EEE MMM d HH:mm:ss zzz yyyy");
		String formattedDate;
		SimpleDateFormat formatter = new SimpleDateFormat("MMM-YYYY");
		formattedDate = formatter.format(dt);
		// System.out.println(formattedDate);
		return formattedDate;

	}
	
	
    public static String parseTwoDecimal(double d)
    {
    	//double d = 1.234567;            
        DecimalFormat df = new DecimalFormat("#.##");
        //System.out.print(df.format(d));
        return df.format(d);
    }

	public static void main(String[] args) {
		// dateParseOrFormat();
		System.out.println(parseTwoDecimal(1.255874));
	}
	//Method By Roshan
	public static int[] getsplitToComponentTimes(BigDecimal biggy)
	{
	    long longVal = biggy.longValue();
	    int hours = (int) longVal / 3600;
	    int remainder = (int) longVal - hours * 3600;
	    int mins = remainder / 60;
	    remainder = remainder - mins * 60;
	    int secs = remainder;

	    int[] ints = {hours , mins , secs};
	    return ints;
	}

//	/**
//	 * @param gradeTargets
//	 * @param prop
//	 * @return
//	 */
	public static double getValues(List<GradeTargetPM5> gradeTargets, String prop) {
		double val = 0;

		for (GradeTargetPM5 gradeTarget : gradeTargets) {
			if (gradeTarget.getPhysicalProperty().equals(prop)) {
				val = gradeTarget.getTarget();
				break;
			}
		}
		return val;
	}
	
	public static Calendar getStartDate(Date sdate) {
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		return scal;
	}

	public static Calendar getEndDate(Date edate) {
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 5);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		return ecal;
	}

}
