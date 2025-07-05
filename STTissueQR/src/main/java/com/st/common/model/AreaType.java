/**
 *Jan 9, 2015
 *AreaType.java
 * TODO
 *com.st.common.model
 *AreaType.java
 *Sunil Singh Bora
 */
package com.st.common.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sbora
 *
 */
public class AreaType {
	public static Map<Integer, String> getAreaType(){
		Map<Integer, String> map=new LinkedHashMap<Integer, String>();
		map.put(1, "PM");
		map.put(2, "FRP");
		map.put(3, "Office");
		map.put(4, "Shipping");
		map.put(5, "Other");
		return map;
	}
}
