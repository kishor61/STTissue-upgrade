/**
 * 
 */
package com.st.oimnotes.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class FollowUp {
	private int id;
	private String followUp;
	private String responsibility;
	private boolean deleted;
	private Date entryDate=new Date();
	private Date timeline;
	private int summaryId;
	private Date closed;
	private String closedBy;
	private String file;
	
	private String recurrence;
	private String tagColor;
	
	
	private String noteHistory;
	private int historyCount;
	private int days;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFollowUp() {
		return followUp;
	}
	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getTimeline() {
		return timeline;
	}
	public void setTimeline(Date timeline) {
		this.timeline = timeline;
	}
	public int getSummaryId() {
		return summaryId;
	}
	public void setSummaryId(int summaryId) {
		this.summaryId = summaryId;
	}
	public String getRecurrence() {
		return recurrence;
	}
	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}
	public String getNoteHistory() {
		return noteHistory;
	}
	public void setNoteHistory(String noteHistory) {
		this.noteHistory = noteHistory;
	}
	public Date getClosed() {
		return closed;
	}
	public void setClosed(Date closed) {
		this.closed = closed;
	}
	public String getTagColor() {
		return tagColor;
	}
	public void setTagColor(String tagColor) {
		this.tagColor = tagColor;
	}
	public int getHistoryCount() {
		return historyCount;
	}
	public void setHistoryCount(int historyCount) {
		this.historyCount = historyCount;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	
	
}
