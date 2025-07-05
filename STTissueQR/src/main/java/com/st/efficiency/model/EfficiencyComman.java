/**
 *Nov 23, 2015
 *EfficiencyComman.java
 * TODO
 *com.st.efficiency.model
 *EfficiencyComman.java
 *Sunil Singh Bora
 */
package com.st.efficiency.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sbora
 *
 */
public class EfficiencyComman {
	public static Map<String,String> getShift(){
		Map<String, String> map=new LinkedHashMap<>();
		map.put("Night", "Night");
		map.put("Day", "Day");
		return map;
	}
}
