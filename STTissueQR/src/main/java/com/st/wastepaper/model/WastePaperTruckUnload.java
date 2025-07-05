package com.st.wastepaper.model;

import java.util.Date;

public class WastePaperTruckUnload {

	private Date unloaddate;
	private Date unloaddatetime;
	private int release;
	private String trailer;
	private int grade;
	private int bales;
	private double weight;
	private String vandor;
	private String unloadcomment;
	private String vandornumber;
	private String shift;
	private int truckcount;
	private String dayshift;
	private String nightshift;
	private int dayshifttrucks;
	private int nightshifttrucks;
	
	public Date getUnloaddate() {
		return unloaddate;
	}
	public void setUnloaddate(Date unloaddate) {
		this.unloaddate = unloaddate;
	}
	public int getRelease() {
		return release;
	}
	public void setRelease(int release) {
		this.release = release;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getVandor() {
		return vandor;
	}
	public void setVandor(String vandor) {
		this.vandor = vandor;
	}
	public Date getUnloaddatetime() {
		return unloaddatetime;
	}
	public void setUnloaddatetime(Date unloaddatetime) {
		this.unloaddatetime = unloaddatetime;
	}
	public int getBales() {
		return bales;
	}
	public void setBales(int bales) {
		this.bales = bales;
	}
	public String getUnloadcomment() {
		return unloadcomment;
	}
	public void setUnloadcomment(String unloadcomment) {
		this.unloadcomment = unloadcomment;
	}
	public String getVandornumber() {
		return vandornumber;
	}
	public void setVandornumber(String vandornumber) {
		this.vandornumber = vandornumber;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public int getTruckcount() {
		return truckcount;
	}
	public void setTruckcount(int truckcount) {
		this.truckcount = truckcount;
	}
	public String getDayshift() {
		return dayshift;
	}
	public void setDayshift(String dayshift) {
		this.dayshift = dayshift;
	}
	public String getNightshift() {
		return nightshift;
	}
	public void setNightshift(String nightshift) {
		this.nightshift = nightshift;
	}
	public int getDayshifttrucks() {
		return dayshifttrucks;
	}
	public void setDayshifttrucks(int dayshifttrucks) {
		this.dayshifttrucks = dayshifttrucks;
	}
	public int getNightshifttrucks() {
		return nightshifttrucks;
	}
	public void setNightshifttrucks(int nightshifttrucks) {
		this.nightshifttrucks = nightshifttrucks;
	}
	
}
