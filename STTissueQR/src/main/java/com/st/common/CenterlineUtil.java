/**
 * 
 */
package com.st.common;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.springframework.util.NumberUtils;

/**
 * @author sbora
 * 
 */
public class CenterlineUtil {
	public static String rangeCheck(double value, double target, double min, double max) {
		String color = "";

		if (value != 0 && target != 0) {
			if (min == 0 && max == 0) {
				if (value == target) {
					return "greencolor";
				} else {
					return "redcolor";
				}
			} else if (min != 0 && max == 0) {
				if (value > min & value <= target) {
					return "greencolor";
				} else {
					return "redcolor";
				}
			} else if (min == 0 & max != 0) {
				if (value >= target & value < max) {
					return "greencolor";
				} else {
					return "redcolor";
				}
			} else if (min != 0 & max != 0) {
				if (value > min & value < max) {
					return "greencolor";
				} else {
					return "redcolor";
				}
			}
		}

		return color;
	}

	public static String rangeString1(String value, String target, String min, String max) {

		if (value == null || value.trim().equals("")) {
			return "";
		}

		double valF = 0;
		double valB = 0;
		if (value != null) {
			if (value.contains("/")) {
				valF = NumberUtils.parseNumber(value.split("/")[0],Double.class);
				valB = NumberUtils.parseNumber(value.split("/")[1],Double.class);
			}
		}

		double tarF = 0;
		double tarB = 0;
		if (target != null) {
			if (target.contains("/")) {
				tarF = NumberUtils.parseNumber(target.split("/")[0], Double.class);
				tarB = NumberUtils.parseNumber(target.split("/")[1], Double.class);
			}
		}

		double minF = 0;
		double minB = 0;
		if (min != null) {
			if (min.contains("/")) {
				minF = NumberUtils.parseNumber(min.split("/")[0],Double.class);
				minB = NumberUtils.parseNumber(min.split("/")[1], Double.class);
			}
		}

		double maxF = 0;
		double maxB = 0;
		if (max != null) {
			if (max.contains("/")) {
				maxF = NumberUtils.parseNumber(max.split("/")[0], Double.class);
				maxB = NumberUtils.parseNumber(max.split("/")[1], Double.class);
			}
		}

		String color = rangeCheck(valF, tarF, minF, maxF);
		if (!color.equals("redcolor")) {
			color = rangeCheck(valB, tarB, minB, maxB);
		}
		return color;
	}

	public static String rangeString2(String value, String target, String min, String max) {
		double val = 0;
		double targ = 0;
		double mi = 0;
		double mx = 0;

		// System.out.println("Value="+value);
		// System.out.println("target="+target);
		// System.out.println("Min="+min);
		// System.out.println("Max="+max);

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByExtension("js");

		if (value == null) {
			return "";
		} else {
			value = value.trim();
		}

		if (!value.trim().equals("")) {

			if (value.contains(" ")) {
				value = value.replaceAll(" +", " ");
				try {
					value = value.replace(" ", "+");
					val = ((Number) engine.eval(value)).doubleValue();
				} catch (Exception e) {

					e.printStackTrace();
				}
			} else if (value.contains("/")) {
				try {
					val = ((Number) engine.eval(value)).doubleValue();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				val = NumberUtils.parseNumber(value, Double.class);
			}
		}

		if (target == null) {
			target = "";
		} else {
			target = target.trim();
		}

		if (!target.trim().equals("")) {

			if (target.contains(" ")) {
				target = target.replaceAll(" +", " ");
				try {
					target = target.replace(" ", "+");
					targ = ((Number) engine.eval(target)).doubleValue();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (target.contains("/")) {
				try {
					targ = ((Number) engine.eval(target)).doubleValue();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				targ = NumberUtils.parseNumber(target, Double.class);
			}
		}

		if (min == null) {
			min = "";
		} else {
			min = min.trim();
		}
		if (!min.trim().equals("")) {

			if (min.contains(" ")) {
				min = min.replaceAll(" +", " ");
				try {
					min = min.replace(" ", "+");
					mi = ((Number) engine.eval(min)).doubleValue();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (min.contains("/")) {
				try {
					mi = ((Number) engine.eval(min)).doubleValue();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				mi = NumberUtils.parseNumber(min, Double.class);
			}
		}

		if (max == null) {
			max = "";
		} else {
			max = max.trim();
		}

		if (!max.trim().equals("")) {

			if (max.contains(" ")) {
				max = max.replaceAll(" +", " ");
				try {
					max = max.replace(" ", "+");
					mx = ((Number) engine.eval(max)).doubleValue();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (max.contains("/")) {
				try {
					mx = ((Number) engine.eval(max)).doubleValue();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				mx = NumberUtils.parseNumber(max, Double.class);
			}
		}

		return rangeCheck(val, targ, mi, mx);

	}
}
