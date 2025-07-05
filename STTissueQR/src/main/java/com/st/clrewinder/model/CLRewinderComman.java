/**
 *May 1, 2017
 *CLRewinderComman.java
 * TODO
 *com.st.clrewinder.model
 *CLRewinderComman.java
 *Roshan Lal Tailor
 */
package com.st.clrewinder.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author roshan
 *
 */
public class CLRewinderComman {

	public static Map<String,String> getCreaw(){
		Map<String, String> map=new LinkedHashMap<>();
		map.put("A", "A");
		map.put("B", "B");
		map.put("C", "C");
		map.put("D", "D");
		return map;
	}
	
	
	//Methods for Production 
	
	public static Map<String,String> getShift(){
		Map<String, String> map=new LinkedHashMap<>();
		map.put("Night", "Night");
		map.put("Day", "Day");
		return map;
	}

}
