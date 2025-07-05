/**
 * 
 */
package com.st.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sbora
 *
 */
public class FrpCommon {
	
	public static Map<String,String> getGrade(){
		Map<String, String> map=new HashMap<String, String>();
		map.put("WH", "White");
		map.put("KF", "Kraft");
		return map;
	}
	public static Map<String,String> getBatchNo(){
		Map<String, String> map=new HashMap<String, String>();
		map.put("LineA", "Line A");
		map.put("LineB", "Line B");
		return map;
	}
	
	public static Map<String,String> getGradeType(){
		Map<String, String> map=new HashMap<String, String>();
		map.put("N", "Napkin");
		map.put("T", "Towel");
		return map;
	}
	
	public static Map<String,String> getPressQualityType(){
		Map<String, String> map=new LinkedHashMap<>();
		//map.put("TPQ", "Tertiary Press Quality");
		//		Code Starts From Here Done By Roshan Tailor Date :- 03/21/2015 MM/DD/YYYY
		map.put("TPQ", "TP1 quality");
		map.put("TPQ2", "TP2 quality (operator entry)");
		//		Code Ends Here Done By Roshan Tailor
		//Code Modified By Roshan Tailor On 03/24/2015
		map.put("SECPRESSQ", "Secondary Press Quality");
		map.put("SPC", "ST Sludge Press Consistency");
		map.put("WL", "Wet Lap");
		map.put("SH", "Sludge Hauling");
		map.put("IPSC", "IP Sludge Consistency");
		map.put("ST", "stickies data ");
		
		return map;
	}
	
	public static Map<String,String> getYN(){
		Map<String, String> map=new LinkedHashMap<>();
		map.put("Y", "Yes");
		map.put("N", "No");
		return map;
	}
	
	public static Map<String,String> getPressQualityGrade(){
		Map<String, String> map=new LinkedHashMap<>();
		map.put("B", "Brown");
		map.put("W", "White");
		return map;
	}
	
	
	//Methods for Production 
	
	public static Map<String,String> getProductionType(){
		Map<String, String> map=new LinkedHashMap<>();
		map.put("KF", "kraft");
		map.put("BW", "White Bleched");
		return map;
	}
	
	public static Map<String,String> getProductionGradeType(){
		Map<String, String> map=new LinkedHashMap<>();
		map.put("1", "Kraft Napkin");
		map.put("2", "Kraft Towel");
		map.put("3", "White Napkin");
		map.put("4", "White Towel / High Brite Napkin");
		map.put("5", "High Brite Towel");
		map.put("6", "Natural Towel");
		
		return map;
	}
//	Code Starts From Here Done By Roshan Tailor Date :- 03/18/2015
	public static Map<String, String> getClarifierunderflowpumpruning() {
		Map<String, String> map=new LinkedHashMap<>();
		map.put("YES", "Yes");
		return map;
	}
//	Code Ends Here Done By Roshan Tailor
//	Code Starts From Here Done By Roshan TAilor Date:-03/21/2015
	public static Map<String, String> getProductionAStarValue() {
		Map<String, String> map=new LinkedHashMap<>();
		map.put("Red", "Red");
		map.put("Green", "Green");
		return map;
	}
	public static Map<String, String> getProductionBStarValue() {
		Map<String, String> map=new LinkedHashMap<>();
		map.put("Yellow", "Yellow");
		map.put("Blue", "Blue");
		return map;
	}
//	Code Ends Here Done By Roshan Tailor
}
