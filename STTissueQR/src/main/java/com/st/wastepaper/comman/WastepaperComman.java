/**
 *Jun 25, 2015
 *WastepaperComman.java
 * TODO
 *com.st.wastepaper.comman
 *WastepaperComman.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.comman;

import java.util.HashMap;
import java.util.Map;

/**
 * @author roshan
 *
 */
public class WastepaperComman {

	/**
	 * @return
	 */
	public static Map<String, String> getDestination() {
		Map<String, String> mapForDestination=new HashMap<String, String>();
		mapForDestination.put("Delivered", "Delivered");
		mapForDestination.put("None", "None");
		return mapForDestination;
	}
	public static Map<String, String> getStatus() {
		Map<String, String> mapForDestination=new HashMap<String, String>();
		mapForDestination.put("Active", "Active");
		mapForDestination.put("In-Active", "In-Active");
		return mapForDestination;
	}
}
