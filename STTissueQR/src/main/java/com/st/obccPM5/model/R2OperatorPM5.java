/**
 *Oct 21, 2019
 *R2OperatorPM5.java
 * TODO
 *com.st.obccPM5.model
 *R2OperatorPM5.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.model;

/**
 * @author sohan
 *
 */
public class R2OperatorPM5 {
	private int id;
	private String position;
	private String operatorName;
	private String edate;
	private String crew;
	private String shift;
	private boolean machinedown;
	
	
	
	private boolean windedeckstopscol1;
	private boolean conveyorcol1;
	private boolean conveyorcol2;
	private boolean conveyorcol3;
	private boolean conveyorcol4;
	private boolean conveyorcol5;
	private boolean coresawcol1;
	private boolean coresawcol2;
	private boolean coresawcol3;
	private boolean coresawcol4;
	private boolean corescol1;
	private boolean reelCrane;
	private boolean anymovementissue;
	private boolean pendantintactandworkingproperly;


	private String windedeckstopscol1Desc;
	private String conveyorcol1Desc;
	private String conveyorcol2Desc;
	private String conveyorcol3Desc;
	private String conveyorcol4Desc;
	private String conveyorcol5Desc;
	private String coresawcol1Desc;
	private String coresawcol2Desc;
	private String coresawcol3Desc;
	private String coresawcol4Desc;
	private String corescol1Desc;
	private String reelCraneDesc;
	private String anymovementissueDesc;
	private String pendantintactandworkingproperlyDesc;

	
	private int processbarpercentage;
	
	private double percentage;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
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
	 * @param position the position to set
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
	 * @param operatorName the operatorName to set
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
	 * @param edate the edate to set
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
	 * @param crew the crew to set
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
	 * @param shift the shift to set
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
	 * @return the windedeckstopscol1
	 */
	public boolean isWindedeckstopscol1() {
		return windedeckstopscol1;
	}
	/**
	 * @param windedeckstopscol1 the windedeckstopscol1 to set
	 */
	public void setWindedeckstopscol1(boolean windedeckstopscol1) {
		this.windedeckstopscol1 = windedeckstopscol1;
	}
	/**
	 * @return the conveyorcol1
	 */
	public boolean isConveyorcol1() {
		return conveyorcol1;
	}
	/**
	 * @param conveyorcol1 the conveyorcol1 to set
	 */
	public void setConveyorcol1(boolean conveyorcol1) {
		this.conveyorcol1 = conveyorcol1;
	}
	/**
	 * @return the conveyorcol2
	 */
	public boolean isConveyorcol2() {
		return conveyorcol2;
	}
	/**
	 * @param conveyorcol2 the conveyorcol2 to set
	 */
	public void setConveyorcol2(boolean conveyorcol2) {
		this.conveyorcol2 = conveyorcol2;
	}
	/**
	 * @return the conveyorcol3
	 */
	public boolean isConveyorcol3() {
		return conveyorcol3;
	}
	/**
	 * @param conveyorcol3 the conveyorcol3 to set
	 */
	public void setConveyorcol3(boolean conveyorcol3) {
		this.conveyorcol3 = conveyorcol3;
	}
	/**
	 * @return the conveyorcol4
	 */
	public boolean isConveyorcol4() {
		return conveyorcol4;
	}
	/**
	 * @param conveyorcol4 the conveyorcol4 to set
	 */
	public void setConveyorcol4(boolean conveyorcol4) {
		this.conveyorcol4 = conveyorcol4;
	}
	/**
	 * @return the conveyorcol5
	 */
	public boolean isConveyorcol5() {
		return conveyorcol5;
	}
	/**
	 * @param conveyorcol5 the conveyorcol5 to set
	 */
	public void setConveyorcol5(boolean conveyorcol5) {
		this.conveyorcol5 = conveyorcol5;
	}
	/**
	 * @return the coresawcol1
	 */
	public boolean isCoresawcol1() {
		return coresawcol1;
	}
	/**
	 * @param coresawcol1 the coresawcol1 to set
	 */
	public void setCoresawcol1(boolean coresawcol1) {
		this.coresawcol1 = coresawcol1;
	}
	/**
	 * @return the coresawcol2
	 */
	public boolean isCoresawcol2() {
		return coresawcol2;
	}
	/**
	 * @param coresawcol2 the coresawcol2 to set
	 */
	public void setCoresawcol2(boolean coresawcol2) {
		this.coresawcol2 = coresawcol2;
	}
	/**
	 * @return the coresawcol3
	 */
	public boolean isCoresawcol3() {
		return coresawcol3;
	}
	/**
	 * @param coresawcol3 the coresawcol3 to set
	 */
	public void setCoresawcol3(boolean coresawcol3) {
		this.coresawcol3 = coresawcol3;
	}
	/**
	 * @return the coresawcol4
	 */
	public boolean isCoresawcol4() {
		return coresawcol4;
	}
	/**
	 * @param coresawcol4 the coresawcol4 to set
	 */
	public void setCoresawcol4(boolean coresawcol4) {
		this.coresawcol4 = coresawcol4;
	}
	/**
	 * @return the corescol1
	 */
	public boolean isCorescol1() {
		return corescol1;
	}
	/**
	 * @param corescol1 the corescol1 to set
	 */
	public void setCorescol1(boolean corescol1) {
		this.corescol1 = corescol1;
	}
	/**
	 * @return the windedeckstopscol1Desc
	 */
	public String getWindedeckstopscol1Desc() {
		return windedeckstopscol1Desc;
	}
	/**
	 * @param windedeckstopscol1Desc the windedeckstopscol1Desc to set
	 */
	public void setWindedeckstopscol1Desc(String windedeckstopscol1Desc) {
		this.windedeckstopscol1Desc = windedeckstopscol1Desc;
	}
	/**
	 * @return the conveyorcol1Desc
	 */
	public String getConveyorcol1Desc() {
		return conveyorcol1Desc;
	}
	/**
	 * @param conveyorcol1Desc the conveyorcol1Desc to set
	 */
	public void setConveyorcol1Desc(String conveyorcol1Desc) {
		this.conveyorcol1Desc = conveyorcol1Desc;
	}
	/**
	 * @return the conveyorcol2Desc
	 */
	public String getConveyorcol2Desc() {
		return conveyorcol2Desc;
	}
	/**
	 * @param conveyorcol2Desc the conveyorcol2Desc to set
	 */
	public void setConveyorcol2Desc(String conveyorcol2Desc) {
		this.conveyorcol2Desc = conveyorcol2Desc;
	}
	/**
	 * @return the conveyorcol3Desc
	 */
	public String getConveyorcol3Desc() {
		return conveyorcol3Desc;
	}
	/**
	 * @param conveyorcol3Desc the conveyorcol3Desc to set
	 */
	public void setConveyorcol3Desc(String conveyorcol3Desc) {
		this.conveyorcol3Desc = conveyorcol3Desc;
	}
	/**
	 * @return the conveyorcol4Desc
	 */
	public String getConveyorcol4Desc() {
		return conveyorcol4Desc;
	}
	/**
	 * @param conveyorcol4Desc the conveyorcol4Desc to set
	 */
	public void setConveyorcol4Desc(String conveyorcol4Desc) {
		this.conveyorcol4Desc = conveyorcol4Desc;
	}
	/**
	 * @return the conveyorcol5Desc
	 */
	public String getConveyorcol5Desc() {
		return conveyorcol5Desc;
	}
	/**
	 * @param conveyorcol5Desc the conveyorcol5Desc to set
	 */
	public void setConveyorcol5Desc(String conveyorcol5Desc) {
		this.conveyorcol5Desc = conveyorcol5Desc;
	}
	/**
	 * @return the coresawcol1Desc
	 */
	public String getCoresawcol1Desc() {
		return coresawcol1Desc;
	}
	/**
	 * @param coresawcol1Desc the coresawcol1Desc to set
	 */
	public void setCoresawcol1Desc(String coresawcol1Desc) {
		this.coresawcol1Desc = coresawcol1Desc;
	}
	/**
	 * @return the coresawcol2Desc
	 */
	public String getCoresawcol2Desc() {
		return coresawcol2Desc;
	}
	/**
	 * @param coresawcol2Desc the coresawcol2Desc to set
	 */
	public void setCoresawcol2Desc(String coresawcol2Desc) {
		this.coresawcol2Desc = coresawcol2Desc;
	}
	/**
	 * @return the coresawcol3Desc
	 */
	public String getCoresawcol3Desc() {
		return coresawcol3Desc;
	}
	/**
	 * @param coresawcol3Desc the coresawcol3Desc to set
	 */
	public void setCoresawcol3Desc(String coresawcol3Desc) {
		this.coresawcol3Desc = coresawcol3Desc;
	}
	/**
	 * @return the coresawcol4Desc
	 */
	public String getCoresawcol4Desc() {
		return coresawcol4Desc;
	}
	/**
	 * @param coresawcol4Desc the coresawcol4Desc to set
	 */
	public void setCoresawcol4Desc(String coresawcol4Desc) {
		this.coresawcol4Desc = coresawcol4Desc;
	}
	/**
	 * @return the corescol1Desc
	 */
	public String getCorescol1Desc() {
		return corescol1Desc;
	}
	/**
	 * @param corescol1Desc the corescol1Desc to set
	 */
	public void setCorescol1Desc(String corescol1Desc) {
		this.corescol1Desc = corescol1Desc;
	}
	/**
	 * @return the processbarpercentage
	 */
	public int getProcessbarpercentage() {
		return processbarpercentage;
	}
	/**
	 * @param processbarpercentage the processbarpercentage to set
	 */
	public void setProcessbarpercentage(int processbarpercentage) {
		this.processbarpercentage = processbarpercentage;
	}
	/**
	 * @return the percentage
	 */
	public double getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	/**
	 * @return the reelCrane
	 */
	public boolean isReelCrane() {
		return reelCrane;
	}
	/**
	 * @param reelCrane the reelCrane to set
	 */
	public void setReelCrane(boolean reelCrane) {
		this.reelCrane = reelCrane;
	}
	/**
	 * @return the anymovementissue
	 */
	public boolean isAnymovementissue() {
		return anymovementissue;
	}
	/**
	 * @param anymovementissue the anymovementissue to set
	 */
	public void setAnymovementissue(boolean anymovementissue) {
		this.anymovementissue = anymovementissue;
	}
	/**
	 * @return the pendantintactandworkingproperly
	 */
	public boolean isPendantintactandworkingproperly() {
		return pendantintactandworkingproperly;
	}
	/**
	 * @param pendantintactandworkingproperly the pendantintactandworkingproperly to set
	 */
	public void setPendantintactandworkingproperly(boolean pendantintactandworkingproperly) {
		this.pendantintactandworkingproperly = pendantintactandworkingproperly;
	}
	/**
	 * @return the reelCraneDesc
	 */
	public String getReelCraneDesc() {
		return reelCraneDesc;
	}
	/**
	 * @param reelCraneDesc the reelCraneDesc to set
	 */
	public void setReelCraneDesc(String reelCraneDesc) {
		this.reelCraneDesc = reelCraneDesc;
	}
	/**
	 * @return the anymovementissueDesc
	 */
	public String getAnymovementissueDesc() {
		return anymovementissueDesc;
	}
	/**
	 * @param anymovementissueDesc the anymovementissueDesc to set
	 */
	public void setAnymovementissueDesc(String anymovementissueDesc) {
		this.anymovementissueDesc = anymovementissueDesc;
	}
	/**
	 * @return the pendantintactandworkingproperlyDesc
	 */
	public String getPendantintactandworkingproperlyDesc() {
		return pendantintactandworkingproperlyDesc;
	}
	/**
	 * @param pendantintactandworkingproperlyDesc the pendantintactandworkingproperlyDesc to set
	 */
	public void setPendantintactandworkingproperlyDesc(String pendantintactandworkingproperlyDesc) {
		this.pendantintactandworkingproperlyDesc = pendantintactandworkingproperlyDesc;
	}
	}