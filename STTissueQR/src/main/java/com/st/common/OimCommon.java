/**
 * 
 */
package com.st.common;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sbora
 *
 */
public class OimCommon {
	public static Map<String, String> getRecurrenceList(){
		Map<String, String>  map=new LinkedHashMap<>();
		map.put("D", "Daily");
		map.put("W", "Weekly");
		map.put("M", "Monthly");
		map.put("Y", "Yearly");
		
		return map;
	}
	
	public static List<String> getColorList(){
		List<String> list=new ArrayList<>();
		list.add("Red");
		list.add("Green");
		list.add("Blue");
		list.add("Orange");
		list.add("Pink");
		list.add("Yellow");
		list.add("Gray");
		return list;
	}
	
	public static Color getColor(String color){
		if(color.equals(RED)){
			return Color.RED;
		}else if(color.equals(BLUE)){
			return Color.BLUE;
		}else if(color.equals(GREEN)){
			return Color.GREEN;
		}else if(color.equals(ORANGE)){
			return Color.ORANGE;
		}else if(color.equals(PINK)){
			return Color.PINK;
		}else if(color.equals(YELLOW)){
			return Color.YELLOW;
		}else if(color.equals(GRAY)){
			return Color.GRAY;
		}else{
			return Color.WHITE;
		}
	}
	
	public static final String RED="Red";
	public static final String GREEN="Green";
	public static final String BLUE="Blue";
	public static final String ORANGE="Orange";
	public static final String PINK="Pink";
	public static final String YELLOW="Yellow";
	public static final String GRAY="Gray";
}
