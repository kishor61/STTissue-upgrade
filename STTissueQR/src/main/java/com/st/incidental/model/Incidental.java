/**
 *Mar 27, 2018
 *Incidental.java
 * TODO
 *com.st.incidental.model
 *Incidental.java
 *Roshan Lal Tailor
 */
package com.st.incidental.model;

import java.util.Date;


/**
 * @author roshan
 *
 */
public class Incidental {

	private int  id;
	private String name;
	private String email;
	private String status;
	private String file;
	private String comment;
	private String subject;
	private Date date;
	private String docid;
	private String description;
	private Date reviewdate;
	private String notrevieduser;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getReviewdate() {
		return reviewdate;
	}
	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getNotrevieduser() {
		return notrevieduser;
	}
	public void setNotrevieduser(String notrevieduser) {
		this.notrevieduser = notrevieduser;
	}
	

	
	
	
}
