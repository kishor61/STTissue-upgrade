/**
 * 
 */
package com.st.safetylog.model;

import java.util.List;


/**
 * @author sbora
 * 
 */
public class SafetyHousekeeping {
	private int id;
	private String description;
	private String type;
	private boolean deleted;
	
	//Temp Field
	private int taskId;
	private boolean completed;
	private String standard;
	
	private List<SafetyHousekeepingAction> actions;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public List<SafetyHousekeepingAction> getActions() {
		return actions;
	}

	public void setActions(List<SafetyHousekeepingAction> actions) {
		this.actions = actions;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}


	
}
