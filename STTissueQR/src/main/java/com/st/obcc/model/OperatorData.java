/**
 *Jun 1, 2016
 *Operator.java
 * TODO
 *com.st.operator.model
 *Operator.java
 *Sarthak Navhaal
 */
package com.st.obcc.model;

import java.util.Date;

/**
 * @author snavhaal
 *
 */
public class OperatorData {

	private int id;
	private String position;
	private String crew;
	private String operatorname;
	private String edate;
	private String shift;
	private boolean machinedown;
	private boolean movementcol1;
	private String movementcol1desc;
	private boolean conveyorcol1;
	private String conveyorcol1desc;
	private boolean conveyorcol2;
	private String conveyorcol2desc;
	private boolean conveyorcol3;
	private String conveyorcol3desc;
	private boolean conveyorcol4;
	private String conveyorcol4desc;
	private boolean conveyorcol5;
	private String conveyorcol5desc;
	private boolean powercol1;
	private String powercol1desc;
	private boolean powercol2;
	private String powercol2desc;
	private boolean powercol3;
	private String powercol3desc;
	private boolean powercol4;
	private String powercol4desc;
	private boolean ordercol1;
	private String ordercol1desc;
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
	 * @return the operatorname
	 */
	public String getOperatorname() {
		return operatorname;
	}

	/**
	 * @param operatorname
	 *            the operatorname to set
	 */
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
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
	 * @return the movementcol1
	 */
	public boolean isMovementcol1() {
		return movementcol1;
	}

	/**
	 * @param movementcol1
	 *            the movementcol1 to set
	 */
	public void setMovementcol1(boolean movementcol1) {
		this.movementcol1 = movementcol1;
	}

	/**
	 * @return the movementcol1desc
	 */
	public String getMovementcol1desc() {
		return movementcol1desc;
	}

	/**
	 * @param movementcol1desc
	 *            the movementcol1desc to set
	 */
	public void setMovementcol1desc(String movementcol1desc) {
		this.movementcol1desc = movementcol1desc;
	}

	/**
	 * @return the conveyorcol1
	 */
	public boolean isConveyorcol1() {
		return conveyorcol1;
	}

	/**
	 * @param conveyorcol1
	 *            the conveyorcol1 to set
	 */
	public void setConveyorcol1(boolean conveyorcol1) {
		this.conveyorcol1 = conveyorcol1;
	}

	/**
	 * @return the conveyorcol1desc
	 */
	public String getConveyorcol1desc() {
		return conveyorcol1desc;
	}

	/**
	 * @param conveyorcol1desc
	 *            the conveyorcol1desc to set
	 */
	public void setConveyorcol1desc(String conveyorcol1desc) {
		this.conveyorcol1desc = conveyorcol1desc;
	}

	/**
	 * @return the conveyorcol2
	 */
	public boolean isConveyorcol2() {
		return conveyorcol2;
	}

	/**
	 * @param conveyorcol2
	 *            the conveyorcol2 to set
	 */
	public void setConveyorcol2(boolean conveyorcol2) {
		this.conveyorcol2 = conveyorcol2;
	}

	/**
	 * @return the conveyorcol2desc
	 */
	public String getConveyorcol2desc() {
		return conveyorcol2desc;
	}

	/**
	 * @param conveyorcol2desc
	 *            the conveyorcol2desc to set
	 */
	public void setConveyorcol2desc(String conveyorcol2desc) {
		this.conveyorcol2desc = conveyorcol2desc;
	}

	/**
	 * @return the conveyorcol3
	 */
	public boolean isConveyorcol3() {
		return conveyorcol3;
	}

	/**
	 * @param conveyorcol3
	 *            the conveyorcol3 to set
	 */
	public void setConveyorcol3(boolean conveyorcol3) {
		this.conveyorcol3 = conveyorcol3;
	}

	/**
	 * @return the conveyorcol3desc
	 */
	public String getConveyorcol3desc() {
		return conveyorcol3desc;
	}

	/**
	 * @param conveyorcol3desc
	 *            the conveyorcol3desc to set
	 */
	public void setConveyorcol3desc(String conveyorcol3desc) {
		this.conveyorcol3desc = conveyorcol3desc;
	}

	/**
	 * @return the conveyorcol4
	 */
	public boolean isConveyorcol4() {
		return conveyorcol4;
	}

	/**
	 * @param conveyorcol4
	 *            the conveyorcol4 to set
	 */
	public void setConveyorcol4(boolean conveyorcol4) {
		this.conveyorcol4 = conveyorcol4;
	}

	/**
	 * @return the conveyorcol4desc
	 */
	public String getConveyorcol4desc() {
		return conveyorcol4desc;
	}

	/**
	 * @param conveyorcol4desc
	 *            the conveyorcol4desc to set
	 */
	public void setConveyorcol4desc(String conveyorcol4desc) {
		this.conveyorcol4desc = conveyorcol4desc;
	}

	/**
	 * @return the conveyorcol5
	 */
	public boolean isConveyorcol5() {
		return conveyorcol5;
	}

	/**
	 * @param conveyorcol5
	 *            the conveyorcol5 to set
	 */
	public void setConveyorcol5(boolean conveyorcol5) {
		this.conveyorcol5 = conveyorcol5;
	}

	/**
	 * @return the conveyorcol5desc
	 */
	public String getConveyorcol5desc() {
		return conveyorcol5desc;
	}

	/**
	 * @param conveyorcol5desc
	 *            the conveyorcol5desc to set
	 */
	public void setConveyorcol5desc(String conveyorcol5desc) {
		this.conveyorcol5desc = conveyorcol5desc;
	}

	/**
	 * @return the powercol1
	 */
	public boolean isPowercol1() {
		return powercol1;
	}

	/**
	 * @param powercol1
	 *            the powercol1 to set
	 */
	public void setPowercol1(boolean powercol1) {
		this.powercol1 = powercol1;
	}

	/**
	 * @return the powercol1desc
	 */
	public String getPowercol1desc() {
		return powercol1desc;
	}

	/**
	 * @param powercol1desc
	 *            the powercol1desc to set
	 */
	public void setPowercol1desc(String powercol1desc) {
		this.powercol1desc = powercol1desc;
	}

	/**
	 * @return the powercol2
	 */
	public boolean isPowercol2() {
		return powercol2;
	}

	/**
	 * @param powercol2
	 *            the powercol2 to set
	 */
	public void setPowercol2(boolean powercol2) {
		this.powercol2 = powercol2;
	}

	/**
	 * @return the powercol2desc
	 */
	public String getPowercol2desc() {
		return powercol2desc;
	}

	/**
	 * @param powercol2desc
	 *            the powercol2desc to set
	 */
	public void setPowercol2desc(String powercol2desc) {
		this.powercol2desc = powercol2desc;
	}

	/**
	 * @return the powercol3
	 */
	public boolean isPowercol3() {
		return powercol3;
	}

	/**
	 * @param powercol3
	 *            the powercol3 to set
	 */
	public void setPowercol3(boolean powercol3) {
		this.powercol3 = powercol3;
	}

	/**
	 * @return the powercol3desc
	 */
	public String getPowercol3desc() {
		return powercol3desc;
	}

	/**
	 * @param powercol3desc
	 *            the powercol3desc to set
	 */
	public void setPowercol3desc(String powercol3desc) {
		this.powercol3desc = powercol3desc;
	}

	/**
	 * @return the powercol4
	 */
	public boolean isPowercol4() {
		return powercol4;
	}

	/**
	 * @param powercol4
	 *            the powercol4 to set
	 */
	public void setPowercol4(boolean powercol4) {
		this.powercol4 = powercol4;
	}

	/**
	 * @return the powercol4desc
	 */
	public String getPowercol4desc() {
		return powercol4desc;
	}

	/**
	 * @param powercol4desc
	 *            the powercol4desc to set
	 */
	public void setPowercol4desc(String powercol4desc) {
		this.powercol4desc = powercol4desc;
	}

	/**
	 * @return the ordercol1
	 */
	public boolean isOrdercol1() {
		return ordercol1;
	}

	/**
	 * @param ordercol1
	 *            the ordercol1 to set
	 */
	public void setOrdercol1(boolean ordercol1) {
		this.ordercol1 = ordercol1;
	}

	/**
	 * @return the ordercol1desc
	 */
	public String getOrdercol1desc() {
		return ordercol1desc;
	}

	/**
	 * @param ordercol1desc
	 *            the ordercol1desc to set
	 */
	public void setOrdercol1desc(String ordercol1desc) {
		this.ordercol1desc = ordercol1desc;
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
