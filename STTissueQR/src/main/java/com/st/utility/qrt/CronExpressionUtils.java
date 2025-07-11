/**
 * 
 */
package com.st.utility.qrt;

import java.util.regex.Pattern;

public class CronExpressionUtils {
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

	public boolean isValidEmail(String email) {
		return EMAIL_PATTERN.matcher(email).matches();
	}
}
