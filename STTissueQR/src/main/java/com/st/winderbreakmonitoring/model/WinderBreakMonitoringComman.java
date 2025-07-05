/**
 *Nov 3, 2015
 *WinderBreakMonitoringComman.java
 * TODO
 *com.st.winderbreakmonitoring.model
 *WinderBreakMonitoringComman.java
 *Sunil Singh Bora
 */
package com.st.winderbreakmonitoring.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author roshan
 *
 */
public class WinderBreakMonitoringComman {

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
