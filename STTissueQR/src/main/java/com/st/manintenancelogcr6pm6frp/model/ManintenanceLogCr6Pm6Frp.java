/**
 *Oct 12, 2017
 *ManintenanceLogCr6Pm6Frp.java
 * TODO
 *com.st.manintenancelogcr6pm6frp.model
 *ManintenanceLogCr6Pm6Frp.java
 *Roshan Lal Tailor
 */
package com.st.manintenancelogcr6pm6frp.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author roshan
 *
 */
public class ManintenanceLogCr6Pm6Frp {

	private String areaname;
	private int id;
	private Date date;
	private String prodtypeorgradecode;
	private String area;
	private String error;
	private String comments;
	private String usertype;
	private String team;
	private String shift;
	private String time;
	
	
	public static Map<String,String> getProductionType(){
		Map<String, String> map=new LinkedHashMap<>();
		map.put("kraft", "kraft");
		map.put("White", "White");
		return map;
	}
	
	public static Map<String,String> getProductionTeam(){
		Map<String, String> map=new LinkedHashMap<>();
		map.put("A", "A");
		map.put("B", "B");
		map.put("C", "C");
		map.put("D", "D");
		return map;
	}

	public static Map<String,String> getProductionShift(){
		Map<String, String> map=new LinkedHashMap<>();
		map.put("Day", "Day");
		map.put("Night", "Night");
		return map;
	}

	public String getAreaname() {
		return areaname;
	}


	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getProdtypeorgradecode() {
		return prodtypeorgradecode;
	}


	public void setProdtypeorgradecode(String prodtypeorgradecode) {
		this.prodtypeorgradecode = prodtypeorgradecode;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getUsertype() {
		return usertype;
	}


	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public String getShift() {
		return shift;
	}


	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
