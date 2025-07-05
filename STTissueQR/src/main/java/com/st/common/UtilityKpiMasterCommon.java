/**
 * 
 */
package com.st.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * @author sbora
 *
 */
public class UtilityKpiMasterCommon {
	public static Map<String, String> getEntryPages(){
		Map<String, String>  map=new LinkedHashMap<>();
		map.put("U", "Utility");
		map.put("M", "Master");
		map.put("K", "KPI");
		return map;
	}
	
	public static Map<String, String> getEntryPagesPM5(){
		Map<String, String>  map=new LinkedHashMap<>();
		map.put("U", "Utility");
		map.put("M", "Master");
		map.put("K", "KPI");
		return map;
	}
	
	public static String getJsonDataOfCenterlineGrade(List<Map<String, Object>>  list){
		
		List<String> datas=new ArrayList<>();
		for (Map<String, Object> map : list) {
			datas.add(map.get("Grade").toString());
		}
		return new Gson().toJson(datas);
	}
	
public static String getJsonDataOfCenterlineGradeCode(List<Map<String, Object>>  list){
		
		List<String> datas=new ArrayList<>();
		for (Map<String, Object> map : list) {
			datas.add(map.get("GradeCode").toString());
		}
		return new Gson().toJson(datas);
	}
}
