/**
 * 
 */
package com.st.safetylog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author sbora
 * 
 */
public class SafetyHousekeepingTask {
	private int id;

	private int area;
	private int auditor;
	private Date date;
	private boolean deleted;
	private String genKeyId;
	private String completed;
	
	//Temp Field
	private String areaName;
	private String auditorName;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGenKeyId() {
		return genKeyId;
	}

	public void setGenKeyId(String genKeyId) {
		this.genKeyId = genKeyId;
	}

	public int getAuditor() {
		return auditor;
	}

	public void setAuditor(int auditor) {
		this.auditor = auditor;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}


	
	public List<Integer> getCompletedIds(){
		List<Integer> integers=new ArrayList<Integer>();
		
		if(StringUtils.isNotEmpty(getCompleted())){
			String[] ids=getCompleted().split("-");
			for (String string : ids) {
				integers.add(NumberUtils.toInt(string, 0));
			}
		}
				
		return integers;
	}

	public String getAuditorName() {
		return auditorName;
	}

	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
}
