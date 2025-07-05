/**
* *Jun 16, 2016
 *UtilityOperator.java
 * TODO
 *com.st.obcc.model
 *UtilityOperator.java
 *Sunil Singh Bora
 */
package com.st.obcc.model;

/**
 * @author snavhaal
 *
 */
public class UtilityOperator {

	private int id;
	private String position;
	private String operatorName;
	private String edate;
	private String crew;
	private String shift;

	private boolean machinedown;
	private boolean wrapperFoxCol1;
	private String wrapperFoxCol1Desc;

	private boolean wrapperFoxCol2;
	private String wrapperFoxCol2Desc;

	private boolean wrapperFoxCol3;
	private String wrapperFoxCol3Desc;

	private boolean wrapperFoxCol4;
	private String wrapperFoxCol4Desc;

	private boolean wrapperFoxCol5;
	private String wrapperFoxCol5Desc;

	private boolean wrapperWuftechCol1;
	private String wrapperWuftechCol1Desc;

	private boolean wrapperWuftechCol2;
	private String wrapperWuftechCol2Desc;

	private boolean wrapperWuftechCol3;
	private String wrapperWuftechCol3Desc;

	private boolean wrapperWuftechCol4;
	private String wrapperWuftechCol4Desc;

	private boolean wrapperWuftechCol5;
	private String wrapperWuftechCol5Desc;

	private boolean wrapperWuftechCol6;
	private String wrapperWuftechCol6Desc;

	private boolean scaleCol1;
	private String scaleCol1Desc;

	private boolean scaleCol2;
	private String scaleCol2Desc;

	private boolean scaleCol3;
	private String scaleCol3Desc;

	private boolean scaleCol4;
	private String scaleCol4Desc;
	
	private int processbarpercentage;
	
	private double percentage;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the operatorName
	 */
	public String getOperatorName() {
		return operatorName;
	}

	/**
	 * @param operatorName
	 *            the operatorName to set
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	/**
	 * @return the edate
	 */
	public String getEdate() {
		return edate;
	}

	/**
	 * @param edate
	 *            the edate to set
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}

	/**
	 * @return the crew
	 */
	public String getCrew() {
		return crew;
	}

	/**
	 * @param crew
	 *            the crew to set
	 */
	public void setCrew(String crew) {
		this.crew = crew;
	}

	/**
	 * @return the shift
	 */
	public String getShift() {
		return shift;
	}

	/**
	 * @param shift
	 *            the shift to set
	 */
	public void setShift(String shift) {
		this.shift = shift;
	}

	/**
	 * @return the machinedown
	 */
	public boolean isMachinedown() {
		return machinedown;
	}

	/**
	 * @param machinedown the machinedown to set
	 */
	public void setMachinedown(boolean machinedown) {
		this.machinedown = machinedown;
	}

	/**
	 * @return the wrapperFoxCol1
	 */
	public boolean isWrapperFoxCol1() {
		return wrapperFoxCol1;
	}

	/**
	 * @param wrapperFoxCol1
	 *            the wrapperFoxCol1 to set
	 */
	public void setWrapperFoxCol1(boolean wrapperFoxCol1) {
		this.wrapperFoxCol1 = wrapperFoxCol1;
	}

	/**
	 * @return the wrapperFoxCol1Desc
	 */
	public String getWrapperFoxCol1Desc() {
		return wrapperFoxCol1Desc;
	}

	/**
	 * @param wrapperFoxCol1Desc
	 *            the wrapperFoxCol1Desc to set
	 */
	public void setWrapperFoxCol1Desc(String wrapperFoxCol1Desc) {
		this.wrapperFoxCol1Desc = wrapperFoxCol1Desc;
	}

	/**
	 * @return the wrapperFoxCol2
	 */
	public boolean isWrapperFoxCol2() {
		return wrapperFoxCol2;
	}

	/**
	 * @param wrapperFoxCol2
	 *            the wrapperFoxCol2 to set
	 */
	public void setWrapperFoxCol2(boolean wrapperFoxCol2) {
		this.wrapperFoxCol2 = wrapperFoxCol2;
	}

	/**
	 * @return the wrapperFoxCol2Desc
	 */
	public String getWrapperFoxCol2Desc() {
		return wrapperFoxCol2Desc;
	}

	/**
	 * @param wrapperFoxCol2Desc
	 *            the wrapperFoxCol2Desc to set
	 */
	public void setWrapperFoxCol2Desc(String wrapperFoxCol2Desc) {
		this.wrapperFoxCol2Desc = wrapperFoxCol2Desc;
	}

	/**
	 * @return the wrapperFoxCol3
	 */
	public boolean isWrapperFoxCol3() {
		return wrapperFoxCol3;
	}

	/**
	 * @param wrapperFoxCol3
	 *            the wrapperFoxCol3 to set
	 */
	public void setWrapperFoxCol3(boolean wrapperFoxCol3) {
		this.wrapperFoxCol3 = wrapperFoxCol3;
	}

	/**
	 * @return the wrapperFoxCol3Desc
	 */
	public String getWrapperFoxCol3Desc() {
		return wrapperFoxCol3Desc;
	}

	/**
	 * @param wrapperFoxCol3Desc
	 *            the wrapperFoxCol3Desc to set
	 */
	public void setWrapperFoxCol3Desc(String wrapperFoxCol3Desc) {
		this.wrapperFoxCol3Desc = wrapperFoxCol3Desc;
	}

	/**
	 * @return the wrapperFoxCol4
	 */
	public boolean isWrapperFoxCol4() {
		return wrapperFoxCol4;
	}

	/**
	 * @param wrapperFoxCol4
	 *            the wrapperFoxCol4 to set
	 */
	public void setWrapperFoxCol4(boolean wrapperFoxCol4) {
		this.wrapperFoxCol4 = wrapperFoxCol4;
	}

	/**
	 * @return the wrapperFoxCol4Desc
	 */
	public String getWrapperFoxCol4Desc() {
		return wrapperFoxCol4Desc;
	}

	/**
	 * @param wrapperFoxCol4Desc
	 *            the wrapperFoxCol4Desc to set
	 */
	public void setWrapperFoxCol4Desc(String wrapperFoxCol4Desc) {
		this.wrapperFoxCol4Desc = wrapperFoxCol4Desc;
	}

	/**
	 * @return the wrapperFoxCol5
	 */
	public boolean isWrapperFoxCol5() {
		return wrapperFoxCol5;
	}

	/**
	 * @param wrapperFoxCol5
	 *            the wrapperFoxCol5 to set
	 */
	public void setWrapperFoxCol5(boolean wrapperFoxCol5) {
		this.wrapperFoxCol5 = wrapperFoxCol5;
	}

	/**
	 * @return the wrapperFoxCol5Desc
	 */
	public String getWrapperFoxCol5Desc() {
		return wrapperFoxCol5Desc;
	}

	/**
	 * @param wrapperFoxCol5Desc
	 *            the wrapperFoxCol5Desc to set
	 */
	public void setWrapperFoxCol5Desc(String wrapperFoxCol5Desc) {
		this.wrapperFoxCol5Desc = wrapperFoxCol5Desc;
	}

	/**
	 * @return the wrapperWuftechCol1
	 */
	public boolean isWrapperWuftechCol1() {
		return wrapperWuftechCol1;
	}

	/**
	 * @param wrapperWuftechCol1
	 *            the wrapperWuftechCol1 to set
	 */
	public void setWrapperWuftechCol1(boolean wrapperWuftechCol1) {
		this.wrapperWuftechCol1 = wrapperWuftechCol1;
	}

	/**
	 * @return the wrapperWuftechCol1Desc
	 */
	public String getWrapperWuftechCol1Desc() {
		return wrapperWuftechCol1Desc;
	}

	/**
	 * @param wrapperWuftechCol1Desc
	 *            the wrapperWuftechCol1Desc to set
	 */
	public void setWrapperWuftechCol1Desc(String wrapperWuftechCol1Desc) {
		this.wrapperWuftechCol1Desc = wrapperWuftechCol1Desc;
	}

	/**
	 * @return the wrapperWuftechCol2
	 */
	public boolean isWrapperWuftechCol2() {
		return wrapperWuftechCol2;
	}

	/**
	 * @param wrapperWuftechCol2
	 *            the wrapperWuftechCol2 to set
	 */
	public void setWrapperWuftechCol2(boolean wrapperWuftechCol2) {
		this.wrapperWuftechCol2 = wrapperWuftechCol2;
	}

	/**
	 * @return the wrapperWuftechCol2Desc
	 */
	public String getWrapperWuftechCol2Desc() {
		return wrapperWuftechCol2Desc;
	}

	/**
	 * @param wrapperWuftechCol2Desc
	 *            the wrapperWuftechCol2Desc to set
	 */
	public void setWrapperWuftechCol2Desc(String wrapperWuftechCol2Desc) {
		this.wrapperWuftechCol2Desc = wrapperWuftechCol2Desc;
	}

	/**
	 * @return the wrapperWuftechCol3
	 */
	public boolean isWrapperWuftechCol3() {
		return wrapperWuftechCol3;
	}

	/**
	 * @param wrapperWuftechCol3
	 *            the wrapperWuftechCol3 to set
	 */
	public void setWrapperWuftechCol3(boolean wrapperWuftechCol3) {
		this.wrapperWuftechCol3 = wrapperWuftechCol3;
	}

	/**
	 * @return the wrapperWuftechCol3Desc
	 */
	public String getWrapperWuftechCol3Desc() {
		return wrapperWuftechCol3Desc;
	}

	/**
	 * @param wrapperWuftechCol3Desc
	 *            the wrapperWuftechCol3Desc to set
	 */
	public void setWrapperWuftechCol3Desc(String wrapperWuftechCol3Desc) {
		this.wrapperWuftechCol3Desc = wrapperWuftechCol3Desc;
	}

	/**
	 * @return the wrapperWuftechCol4
	 */
	public boolean isWrapperWuftechCol4() {
		return wrapperWuftechCol4;
	}

	/**
	 * @param wrapperWuftechCol4
	 *            the wrapperWuftechCol4 to set
	 */
	public void setWrapperWuftechCol4(boolean wrapperWuftechCol4) {
		this.wrapperWuftechCol4 = wrapperWuftechCol4;
	}

	/**
	 * @return the wrapperWuftechCol4Desc
	 */
	public String getWrapperWuftechCol4Desc() {
		return wrapperWuftechCol4Desc;
	}

	/**
	 * @param wrapperWuftechCol4Desc
	 *            the wrapperWuftechCol4Desc to set
	 */
	public void setWrapperWuftechCol4Desc(String wrapperWuftechCol4Desc) {
		this.wrapperWuftechCol4Desc = wrapperWuftechCol4Desc;
	}

	/**
	 * @return the wrapperWuftechCol5
	 */
	public boolean isWrapperWuftechCol5() {
		return wrapperWuftechCol5;
	}

	/**
	 * @param wrapperWuftechCol5
	 *            the wrapperWuftechCol5 to set
	 */
	public void setWrapperWuftechCol5(boolean wrapperWuftechCol5) {
		this.wrapperWuftechCol5 = wrapperWuftechCol5;
	}

	/**
	 * @return the wrapperWuftechCol5Desc
	 */
	public String getWrapperWuftechCol5Desc() {
		return wrapperWuftechCol5Desc;
	}

	/**
	 * @param wrapperWuftechCol5Desc
	 *            the wrapperWuftechCol5Desc to set
	 */
	public void setWrapperWuftechCol5Desc(String wrapperWuftechCol5Desc) {
		this.wrapperWuftechCol5Desc = wrapperWuftechCol5Desc;
	}

	/**
	 * @return the wrapperWuftechCol6
	 */
	public boolean isWrapperWuftechCol6() {
		return wrapperWuftechCol6;
	}

	/**
	 * @param wrapperWuftechCol6
	 *            the wrapperWuftechCol6 to set
	 */
	public void setWrapperWuftechCol6(boolean wrapperWuftechCol6) {
		this.wrapperWuftechCol6 = wrapperWuftechCol6;
	}

	/**
	 * @return the wrapperWuftechCol6Desc
	 */
	public String getWrapperWuftechCol6Desc() {
		return wrapperWuftechCol6Desc;
	}

	/**
	 * @param wrapperWuftechCol6Desc
	 *            the wrapperWuftechCol6Desc to set
	 */
	public void setWrapperWuftechCol6Desc(String wrapperWuftechCol6Desc) {
		this.wrapperWuftechCol6Desc = wrapperWuftechCol6Desc;
	}

	/**
	 * @return the scaleCol1
	 */
	public boolean isScaleCol1() {
		return scaleCol1;
	}

	/**
	 * @param scaleCol1
	 *            the scaleCol1 to set
	 */
	public void setScaleCol1(boolean scaleCol1) {
		this.scaleCol1 = scaleCol1;
	}

	/**
	 * @return the scaleCol1Desc
	 */
	public String getScaleCol1Desc() {
		return scaleCol1Desc;
	}

	/**
	 * @param scaleCol1Desc
	 *            the scaleCol1Desc to set
	 */
	public void setScaleCol1Desc(String scaleCol1Desc) {
		this.scaleCol1Desc = scaleCol1Desc;
	}

	/**
	 * @return the scaleCol2
	 */
	public boolean isScaleCol2() {
		return scaleCol2;
	}

	/**
	 * @param scaleCol2
	 *            the scaleCol2 to set
	 */
	public void setScaleCol2(boolean scaleCol2) {
		this.scaleCol2 = scaleCol2;
	}

	/**
	 * @return the scaleCol2Desc
	 */
	public String getScaleCol2Desc() {
		return scaleCol2Desc;
	}

	/**
	 * @param scaleCol2Desc
	 *            the scaleCol2Desc to set
	 */
	public void setScaleCol2Desc(String scaleCol2Desc) {
		this.scaleCol2Desc = scaleCol2Desc;
	}

	/**
	 * @return the scaleCol3
	 */
	public boolean isScaleCol3() {
		return scaleCol3;
	}

	/**
	 * @param scaleCol3
	 *            the scaleCol3 to set
	 */
	public void setScaleCol3(boolean scaleCol3) {
		this.scaleCol3 = scaleCol3;
	}

	/**
	 * @return the scaleCol3Desc
	 */
	public String getScaleCol3Desc() {
		return scaleCol3Desc;
	}

	/**
	 * @param scaleCol3Desc
	 *            the scaleCol3Desc to set
	 */
	public void setScaleCol3Desc(String scaleCol3Desc) {
		this.scaleCol3Desc = scaleCol3Desc;
	}

	/**
	 * @return the scaleCol4
	 */
	public boolean isScaleCol4() {
		return scaleCol4;
	}

	/**
	 * @param scaleCol4
	 *            the scaleCol4 to set
	 */
	public void setScaleCol4(boolean scaleCol4) {
		this.scaleCol4 = scaleCol4;
	}

	/**
	 * @return the scaleCol4Desc
	 */
	public String getScaleCol4Desc() {
		return scaleCol4Desc;
	}

	/**
	 * @param scaleCol4Desc
	 *            the scaleCol4Desc to set
	 */
	public void setScaleCol4Desc(String scaleCol4Desc) {
		this.scaleCol4Desc = scaleCol4Desc;
	}

	public int getProcessbarpercentage() {
		return processbarpercentage;
	}

	public void setProcessbarpercentage(int processbarpercentage) {
		this.processbarpercentage = processbarpercentage;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	

}
