package com.st.common;

import java.math.BigInteger;
import java.security.SecureRandom;

public class CommonProperties {
	public static final int DATA_PER_PAGE=15;
	
	
	public static final int COLOR_RED=1;
	public static final int COLOR_YELLOW=2;
	public static final int COLOR_GREEN=3;
	public static final int COLOR_NONE=0;
	
	public static final String COLOR_RED_HEX="#B40404";
	public static final String COLOR_GREEN_HEX="#04B404";
	
	public static final String GP01="GP01";
	public static final String GP02="GP02";
	public static final String GP03="GP03";
	public static final String GP04="GP04";
	public static final String GP05="GP05";
	public static final String GP06="GP06";
	public static final String GP07="GP07";
	public static final String GP08="GP08";
	public static final String GP09="GP09";
	public static final String GP10="GP10";
	public static final String GP11="GP11";
	public static final String GP12="GP12";
	public static final String GP17="GP17";
	
	
	
	private static SecureRandom random = new SecureRandom();

	public static String getUniqueId() {
		return new BigInteger(130, random).toString(32);
	}
	
	public static final String REEL_NEXT="nextReel";
	public static final String REEL_PREV="prevReel";
	
}
