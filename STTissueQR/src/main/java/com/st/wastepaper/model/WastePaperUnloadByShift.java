/**
 *Oct 9, 2015
 *WastePaperUnloadByShift.java
 * TODO
 *com.st.wastepaper.model
 *WastePaperUnloadByShift.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.model;

import java.util.Date;

/**
 * @author roshan
 *
 */
public class WastePaperUnloadByShift {
	
	private Date unloaddate;
	private String day;
	private int dayshift;
	private int nightshift;
	private int grandtotal;
	private int dayshifttotal;
	private int nightshifttotal;
	private int finalgrandtotal;

	/**
	 * @return the unloaddate
	 */
	public Date getUnloaddate() {
		return unloaddate;
	}
	/**
	 * @param unloaddate the unloaddate to set
	 */
	public void setUnloaddate(Date unloaddate) {
		this.unloaddate = unloaddate;
	}
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @return the dayshift
	 */
	public int getDayshift() {
		return dayshift;
	}
	/**
	 * @param dayshift the dayshift to set
	 */
	public void setDayshift(int dayshift) {
		this.dayshift = dayshift;
	}
	/**
	 * @return the nightshift
	 */
	public int getNightshift() {
		return nightshift;
	}
	/**
	 * @param nightshift the nightshift to set
	 */
	public void setNightshift(int nightshift) {
		this.nightshift = nightshift;
	}
	/**
	 * @return the grandtotal
	 */
	public int getGrandtotal() {
		return grandtotal;
	}
	/**
	 * @param grandtotal the grandtotal to set
	 */
	public void setGrandtotal(int grandtotal) {
		this.grandtotal = grandtotal;
	}
	/**
	 * @return the dayshifttotal
	 */
	public int getDayshifttotal() {
		return dayshifttotal;
	}
	/**
	 * @param dayshifttotal the dayshifttotal to set
	 */
	public void setDayshifttotal(int dayshifttotal) {
		this.dayshifttotal = dayshifttotal;
	}
	/**
	 * @return the nightshifttotal
	 */
	public int getNightshifttotal() {
		return nightshifttotal;
	}
	/**
	 * @param nightshifttotal the nightshifttotal to set
	 */
	public void setNightshifttotal(int nightshifttotal) {
		this.nightshifttotal = nightshifttotal;
	}
	/**
	 * @return the finalgrandtotal
	 */
	public int getFinalgrandtotal() {
		return finalgrandtotal;
	}
	/**
	 * @param finalgrandtotal the finalgrandtotal to set
	 */
	public void setFinalgrandtotal(int finalgrandtotal) {
		this.finalgrandtotal = finalgrandtotal;
	}

}
