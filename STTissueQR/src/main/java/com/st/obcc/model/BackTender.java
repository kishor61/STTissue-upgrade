/**
 *Jun 9, 2016
 *BackTender.java
 * TODO
 *com.st.obcc.model
 *BackTender.java
 *Sunil Singh Bora
 */
package com.st.obcc.model;

/**
 * @author snavhaal
 *
 */
public class BackTender {

	private int id;
	private String position;
	private String operatorName;
	private String edate;
	private String crew;
	private String shift;
	
	private boolean machinedown;
	private String reelCol1;
	private String reelCol2;

	private String reelCol3Inbound;
	private String reelCol3Outbound;

	private boolean reelCol4;
	private String reelCol5;

	private String machineLubricationCol1;
	private String machineLubricationCol2;
	private String machineLubricationCol3;
	private String machineLubricationCol4;
	private String machineLubricationCol5;

	private boolean condensateCol1;

	private String condensateCol2Inbound;
	private String condensateCol2Outbound;

	private boolean condensateCol3;

	private String condensateCol4Inbound;
	private String condensateCol4Outbound;

	private boolean condensateCol5;
	private boolean condensateCol6;

	private String condensateCol7Inbound;
	private String condensateCol7Outbound;

	private boolean condensateCol8;

	private String condensateCol9Inbound;
	private String condensateCol9Outbound;

	private boolean condensateCol10;

	private String condensateCol11Inbound;
	private String condensateCol11Outbound;

	private boolean condensateCol12;
	private boolean condensateCol13;

	private String condensateCol14Inbound;
	private String condensateCol14Outbound;

	private String condensateCol15;

	private boolean showerWaterCol1;
	private boolean showerWaterCol2;

	private String showerWaterCol3Inbound;
	private String showerWaterCol3Outbound;

	private boolean showerWaterCol4;

	private String showerWaterCol5Inbound;
	private String showerWaterCol5Outbound;

	private boolean showerWaterCol6;

	private String showerWaterCol7Inbound;
	private String showerWaterCol7Outbound;

	private String showerWaterCol8;
	private String showerWaterCol9;
	private boolean showerWaterCol11;
	private String lubricationCol1;
	private String lubricationCol2;
	private String lubricationCol3;
	private String lubricationCol4;
	private String lubricationCol5;
	private String lubricationCol6;
	private String lubricationCol7;

	private boolean afterDryerCol1;
	private String afterDryerCol2;
	private String afterDryerCol3;
	private boolean afterDryerCol4;
	private String afterDryerCol5;
	private String afterDryerCol6;

	private boolean eqptScannerCol1;
	private String eqptScannerCol2;
	private boolean eqptScannerCol3;
	private boolean eqptScannerCol4;
	private boolean eqptScannerCol5;

	private boolean eqptReelSectionCol1;
	private String eqptReelSectionCol2;
	private String eqptReelSectionCol3;
	private String eqptReelSectionCol4;
	private String eqptReelSectionCol5;

	private boolean oilFlowCol1;
	private boolean oilFlowCol2;
	private boolean oilFlowCol3;
	private boolean oilFlowCol4;
	private String oilFlowCol5;
	private String oilFlowCol6;
	private String oilFlowCol7;

	private boolean mezzanineCol1;
	private boolean mezzanineCol2;
	private boolean mezzanineCol3;
	private boolean mezzanineCol4;
	private boolean mezzanineCol5;

	private String reelCol1Desc;
	private String reelCol2Desc;
	private String reelCol3Desc;
	private String reelCol4Desc;
	private String reelCol5Desc;

	private String machineLubricationCol1Desc;
	private String machineLubricationCol2Desc;
	private String machineLubricationCol3Desc;
	private String machineLubricationCol4Desc;
	private String machineLubricationCol5Desc;

	private String condensateCol1Desc;
	private String condensateCol2Desc;
	private String condensateCol3Desc;
	private String condensateCol4Desc;
	private String condensateCol5Desc;
	private String condensateCol6Desc;
	private String condensateCol7Desc;
	private String condensateCol8Desc;
	private String condensateCol9Desc;
	private String condensateCol10Desc;
	private String condensateCol11Desc;
	private String condensateCol12Desc;
	private String condensateCol13Desc;
	private String condensateCol14Desc;
	private String condensateCol15Desc;

	private String showerWaterCol1Desc;
	private String showerWaterCol2Desc;
	private String showerWaterCol3Desc;
	private String showerWaterCol4Desc;
	private String showerWaterCol5Desc;
	private String showerWaterCol6Desc;
	private String showerWaterCol7Desc;
	private String showerWaterCol8Desc;
	private String showerWaterCol9Desc;

	private String lubricationCol1Desc;
	private String lubricationCol2Desc;
	private String lubricationCol3Desc;
	private String lubricationCol4Desc;
	private String lubricationCo5Desc;
	private String lubricationCo6Desc;
	private String lubricationCo7Desc;

	private String afterDryerCol1Desc;
	private String afterDryerCol2Desc;
	private String afterDryerCol3Desc;
	private String afterDryerCol4Desc;
	private String afterDryerCol5Desc;
	private String afterDryerCol6Desc;

	private String eqptScannerCol1Desc;
	private String eqptScannerCol2Desc;
	private String eqptScannerCol3Desc;
	private String eqptScannerCol4Desc;
	private String eqptScannerCol5Desc;

	private String eqptReelSectionCol1Desc;
	private String eqptReelSectionCol2Desc;
	private String eqptReelSectionCol3Desc;
	private String eqptReelSectionCol4Desc;
	private String eqptReelSectionCol5Desc;

	private String oilFlowCol1Desc;
	private String oilFlowCol2Desc;
	private String oilFlowCol3Desc;
	private String oilFlowCol4Desc;
	private String oilFlowCol5Desc;
	private String oilFlowCol6Desc;
	private String oilFlowCol7Desc;

	private String mezzanineCol1Desc;
	private String mezzanineCol2Desc;
	private String mezzanineCol3Desc;
	private String mezzanineCol4Desc;
	private String mezzanineCol5Desc;

	private String fillupcol1;
	private String fillupcol2;
	private String fillupcol3;
	private String fillupcol4;
	private String fillupcol5;
	private String fillupcol6;
	private String fillupcol7;
	private String fillupcol8;

	private String fillupcol1Desc;
	private String fillupcol2Desc;
	private String fillupcol3Desc;
	private String fillupcol4Desc;
	private String fillupcol5Desc;
	private String fillupcol6Desc;
	private String fillupcol7Desc;
	private String fillupcol8Desc;
	
	private int processbarpercentage;
	
	private double percentage;
	
	
	private String checkbladechange;
	private String checkbladechangeremark;
	private String celovesforholes;
	private String celovesforholesremark;

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
	 * @return the reelCol1
	 */
	public String getReelCol1() {
		return reelCol1;
	}

	/**
	 * @param reelCol1
	 *            the reelCol1 to set
	 */
	public void setReelCol1(String reelCol1) {
		this.reelCol1 = reelCol1;
	}

	/**
	 * @return the reelCol2
	 */
	public String getReelCol2() {
		return reelCol2;
	}

	/**
	 * @param reelCol2
	 *            the reelCol2 to set
	 */
	public void setReelCol2(String reelCol2) {
		this.reelCol2 = reelCol2;
	}

	/**
	 * @return the reelCol3Inbound
	 */
	public String getReelCol3Inbound() {
		return reelCol3Inbound;
	}

	/**
	 * @param reelCol3Inbound
	 *            the reelCol3Inbound to set
	 */
	public void setReelCol3Inbound(String reelCol3Inbound) {
		this.reelCol3Inbound = reelCol3Inbound;
	}

	/**
	 * @return the reelCol3Outbound
	 */
	public String getReelCol3Outbound() {
		return reelCol3Outbound;
	}

	/**
	 * @param reelCol3Outbound
	 *            the reelCol3Outbound to set
	 */
	public void setReelCol3Outbound(String reelCol3Outbound) {
		this.reelCol3Outbound = reelCol3Outbound;
	}

	/**
	 * @return the reelCol4
	 */
	public boolean isReelCol4() {
		return reelCol4;
	}

	/**
	 * @param reelCol4
	 *            the reelCol4 to set
	 */
	public void setReelCol4(boolean reelCol4) {
		this.reelCol4 = reelCol4;
	}

	/**
	 * @return the reelCol5
	 */
	public String getReelCol5() {
		return reelCol5;
	}

	/**
	 * @param reelCol5
	 *            the reelCol5 to set
	 */
	public void setReelCol5(String reelCol5) {
		this.reelCol5 = reelCol5;
	}

	/**
	 * @return the machineLubricationCol1
	 */
	public String getMachineLubricationCol1() {
		return machineLubricationCol1;
	}

	/**
	 * @param machineLubricationCol1
	 *            the machineLubricationCol1 to set
	 */
	public void setMachineLubricationCol1(String machineLubricationCol1) {
		this.machineLubricationCol1 = machineLubricationCol1;
	}

	/**
	 * @return the machineLubricationCol2
	 */
	public String getMachineLubricationCol2() {
		return machineLubricationCol2;
	}

	/**
	 * @param machineLubricationCol2
	 *            the machineLubricationCol2 to set
	 */
	public void setMachineLubricationCol2(String machineLubricationCol2) {
		this.machineLubricationCol2 = machineLubricationCol2;
	}

	/**
	 * @return the machineLubricationCol4
	 */
	public String getMachineLubricationCol4() {
		return machineLubricationCol4;
	}

	/**
	 * @param machineLubricationCol4
	 *            the machineLubricationCol4 to set
	 */
	public void setMachineLubricationCol4(String machineLubricationCol4) {
		this.machineLubricationCol4 = machineLubricationCol4;
	}

	/**
	 * @return the machineLubricationCol5
	 */
	public String getMachineLubricationCol5() {
		return machineLubricationCol5;
	}

	/**
	 * @param machineLubricationCol5
	 *            the machineLubricationCol5 to set
	 */
	public void setMachineLubricationCol5(String machineLubricationCol5) {
		this.machineLubricationCol5 = machineLubricationCol5;
	}

	/**
	 * @return the condensateCol1
	 */
	public boolean isCondensateCol1() {
		return condensateCol1;
	}

	/**
	 * @param condensateCol1
	 *            the condensateCol1 to set
	 */
	public void setCondensateCol1(boolean condensateCol1) {
		this.condensateCol1 = condensateCol1;
	}

	/**
	 * @return the condensateCol2Inbound
	 */
	public String getCondensateCol2Inbound() {
		return condensateCol2Inbound;
	}

	/**
	 * @param condensateCol2Inbound
	 *            the condensateCol2Inbound to set
	 */
	public void setCondensateCol2Inbound(String condensateCol2Inbound) {
		this.condensateCol2Inbound = condensateCol2Inbound;
	}

	/**
	 * @return the condensateCol2Outbound
	 */
	public String getCondensateCol2Outbound() {
		return condensateCol2Outbound;
	}

	/**
	 * @param condensateCol2Outbound
	 *            the condensateCol2Outbound to set
	 */
	public void setCondensateCol2Outbound(String condensateCol2Outbound) {
		this.condensateCol2Outbound = condensateCol2Outbound;
	}

	/**
	 * @return the condensateCol3
	 */
	public boolean isCondensateCol3() {
		return condensateCol3;
	}

	/**
	 * @param condensateCol3
	 *            the condensateCol3 to set
	 */
	public void setCondensateCol3(boolean condensateCol3) {
		this.condensateCol3 = condensateCol3;
	}

	/**
	 * @return the condensateCol4Inbound
	 */
	public String getCondensateCol4Inbound() {
		return condensateCol4Inbound;
	}

	/**
	 * @param condensateCol4Inbound
	 *            the condensateCol4Inbound to set
	 */
	public void setCondensateCol4Inbound(String condensateCol4Inbound) {
		this.condensateCol4Inbound = condensateCol4Inbound;
	}

	/**
	 * @return the condensateCol4Outbound
	 */
	public String getCondensateCol4Outbound() {
		return condensateCol4Outbound;
	}

	/**
	 * @param condensateCol4Outbound
	 *            the condensateCol4Outbound to set
	 */
	public void setCondensateCol4Outbound(String condensateCol4Outbound) {
		this.condensateCol4Outbound = condensateCol4Outbound;
	}

	/**
	 * @return the condensateCol5
	 */
	public boolean isCondensateCol5() {
		return condensateCol5;
	}

	/**
	 * @param condensateCol5
	 *            the condensateCol5 to set
	 */
	public void setCondensateCol5(boolean condensateCol5) {
		this.condensateCol5 = condensateCol5;
	}

	/**
	 * @return the condensateCol6
	 */
	public boolean isCondensateCol6() {
		return condensateCol6;
	}

	/**
	 * @param condensateCol6
	 *            the condensateCol6 to set
	 */
	public void setCondensateCol6(boolean condensateCol6) {
		this.condensateCol6 = condensateCol6;
	}

	/**
	 * @return the condensateCol7Inbound
	 */
	public String getCondensateCol7Inbound() {
		return condensateCol7Inbound;
	}

	/**
	 * @param condensateCol7Inbound
	 *            the condensateCol7Inbound to set
	 */
	public void setCondensateCol7Inbound(String condensateCol7Inbound) {
		this.condensateCol7Inbound = condensateCol7Inbound;
	}

	/**
	 * @return the condensateCol7Outbound
	 */
	public String getCondensateCol7Outbound() {
		return condensateCol7Outbound;
	}

	/**
	 * @param condensateCol7Outbound
	 *            the condensateCol7Outbound to set
	 */
	public void setCondensateCol7Outbound(String condensateCol7Outbound) {
		this.condensateCol7Outbound = condensateCol7Outbound;
	}

	/**
	 * @return the condensateCol8
	 */
	public boolean isCondensateCol8() {
		return condensateCol8;
	}

	/**
	 * @param condensateCol8
	 *            the condensateCol8 to set
	 */
	public void setCondensateCol8(boolean condensateCol8) {
		this.condensateCol8 = condensateCol8;
	}

	/**
	 * @return the condensateCol9Inbound
	 */
	public String getCondensateCol9Inbound() {
		return condensateCol9Inbound;
	}

	/**
	 * @param condensateCol9Inbound
	 *            the condensateCol9Inbound to set
	 */
	public void setCondensateCol9Inbound(String condensateCol9Inbound) {
		this.condensateCol9Inbound = condensateCol9Inbound;
	}

	/**
	 * @return the condensateCol9Outbound
	 */
	public String getCondensateCol9Outbound() {
		return condensateCol9Outbound;
	}

	/**
	 * @param condensateCol9Outbound
	 *            the condensateCol9Outbound to set
	 */
	public void setCondensateCol9Outbound(String condensateCol9Outbound) {
		this.condensateCol9Outbound = condensateCol9Outbound;
	}

	/**
	 * @return the condensateCol10
	 */
	public boolean isCondensateCol10() {
		return condensateCol10;
	}

	/**
	 * @param condensateCol10
	 *            the condensateCol10 to set
	 */
	public void setCondensateCol10(boolean condensateCol10) {
		this.condensateCol10 = condensateCol10;
	}

	/**
	 * @return the condensateCol11Inbound
	 */
	public String getCondensateCol11Inbound() {
		return condensateCol11Inbound;
	}

	/**
	 * @param condensateCol11Inbound
	 *            the condensateCol11Inbound to set
	 */
	public void setCondensateCol11Inbound(String condensateCol11Inbound) {
		this.condensateCol11Inbound = condensateCol11Inbound;
	}

	/**
	 * @return the condensateCol11Outbound
	 */
	public String getCondensateCol11Outbound() {
		return condensateCol11Outbound;
	}

	/**
	 * @param condensateCol11Outbound
	 *            the condensateCol11Outbound to set
	 */
	public void setCondensateCol11Outbound(String condensateCol11Outbound) {
		this.condensateCol11Outbound = condensateCol11Outbound;
	}

	/**
	 * @return the condensateCol12
	 */
	public boolean isCondensateCol12() {
		return condensateCol12;
	}

	/**
	 * @param condensateCol12
	 *            the condensateCol12 to set
	 */
	public void setCondensateCol12(boolean condensateCol12) {
		this.condensateCol12 = condensateCol12;
	}

	/**
	 * @return the condensateCol13
	 */
	public boolean isCondensateCol13() {
		return condensateCol13;
	}

	/**
	 * @param condensateCol13
	 *            the condensateCol13 to set
	 */
	public void setCondensateCol13(boolean condensateCol13) {
		this.condensateCol13 = condensateCol13;
	}

	/**
	 * @return the condensateCol14Inbound
	 */
	public String getCondensateCol14Inbound() {
		return condensateCol14Inbound;
	}

	/**
	 * @param condensateCol14Inbound
	 *            the condensateCol14Inbound to set
	 */
	public void setCondensateCol14Inbound(String condensateCol14Inbound) {
		this.condensateCol14Inbound = condensateCol14Inbound;
	}

	/**
	 * @return the condensateCol14Outbound
	 */
	public String getCondensateCol14Outbound() {
		return condensateCol14Outbound;
	}

	/**
	 * @param condensateCol14Outbound
	 *            the condensateCol14Outbound to set
	 */
	public void setCondensateCol14Outbound(String condensateCol14Outbound) {
		this.condensateCol14Outbound = condensateCol14Outbound;
	}

	

	/**
	 * @return the showerWaterCol1
	 */
	public boolean isShowerWaterCol1() {
		return showerWaterCol1;
	}

	/**
	 * @param showerWaterCol1
	 *            the showerWaterCol1 to set
	 */
	public void setShowerWaterCol1(boolean showerWaterCol1) {
		this.showerWaterCol1 = showerWaterCol1;
	}

	/**
	 * @return the showerWaterCol2
	 */
	public boolean isShowerWaterCol2() {
		return showerWaterCol2;
	}

	/**
	 * @param showerWaterCol2
	 *            the showerWaterCol2 to set
	 */
	public void setShowerWaterCol2(boolean showerWaterCol2) {
		this.showerWaterCol2 = showerWaterCol2;
	}

	/**
	 * @return the showerWaterCol3Inbound
	 */
	public String getShowerWaterCol3Inbound() {
		return showerWaterCol3Inbound;
	}

	/**
	 * @param showerWaterCol3Inbound
	 *            the showerWaterCol3Inbound to set
	 */
	public void setShowerWaterCol3Inbound(String showerWaterCol3Inbound) {
		this.showerWaterCol3Inbound = showerWaterCol3Inbound;
	}

	/**
	 * @return the showerWaterCol3Outbound
	 */
	public String getShowerWaterCol3Outbound() {
		return showerWaterCol3Outbound;
	}

	/**
	 * @param showerWaterCol3Outbound
	 *            the showerWaterCol3Outbound to set
	 */
	public void setShowerWaterCol3Outbound(String showerWaterCol3Outbound) {
		this.showerWaterCol3Outbound = showerWaterCol3Outbound;
	}

	/**
	 * @return the showerWaterCol4
	 */
	public boolean isShowerWaterCol4() {
		return showerWaterCol4;
	}

	/**
	 * @param showerWaterCol4
	 *            the showerWaterCol4 to set
	 */
	public void setShowerWaterCol4(boolean showerWaterCol4) {
		this.showerWaterCol4 = showerWaterCol4;
	}

	/**
	 * @return the showerWaterCol5Inbound
	 */
	public String getShowerWaterCol5Inbound() {
		return showerWaterCol5Inbound;
	}

	/**
	 * @param showerWaterCol5Inbound
	 *            the showerWaterCol5Inbound to set
	 */
	public void setShowerWaterCol5Inbound(String showerWaterCol5Inbound) {
		this.showerWaterCol5Inbound = showerWaterCol5Inbound;
	}

	/**
	 * @return the showerWaterCol5Outbound
	 */
	public String getShowerWaterCol5Outbound() {
		return showerWaterCol5Outbound;
	}

	/**
	 * @param showerWaterCol5Outbound
	 *            the showerWaterCol5Outbound to set
	 */
	public void setShowerWaterCol5Outbound(String showerWaterCol5Outbound) {
		this.showerWaterCol5Outbound = showerWaterCol5Outbound;
	}

	/**
	 * @return the showerWaterCol6
	 */
	public boolean isShowerWaterCol6() {
		return showerWaterCol6;
	}

	/**
	 * @param showerWaterCol6
	 *            the showerWaterCol6 to set
	 */
	public void setShowerWaterCol6(boolean showerWaterCol6) {
		this.showerWaterCol6 = showerWaterCol6;
	}

	/**
	 * @return the showerWaterCol7Inbound
	 */
	public String getShowerWaterCol7Inbound() {
		return showerWaterCol7Inbound;
	}

	/**
	 * @param showerWaterCol7Inbound
	 *            the showerWaterCol7Inbound to set
	 */
	public void setShowerWaterCol7Inbound(String showerWaterCol7Inbound) {
		this.showerWaterCol7Inbound = showerWaterCol7Inbound;
	}

	/**
	 * @return the showerWaterCol7Outbound
	 */
	public String getShowerWaterCol7Outbound() {
		return showerWaterCol7Outbound;
	}

	/**
	 * @param showerWaterCol7Outbound
	 *            the showerWaterCol7Outbound to set
	 */
	public void setShowerWaterCol7Outbound(String showerWaterCol7Outbound) {
		this.showerWaterCol7Outbound = showerWaterCol7Outbound;
	}

	/**
	 * @return the showerWaterCol8
	 */
	public String getShowerWaterCol8() {
		return showerWaterCol8;
	}

	/**
	 * @param showerWaterCol8
	 *            the showerWaterCol8 to set
	 */
	public void setShowerWaterCol8(String showerWaterCol8) {
		this.showerWaterCol8 = showerWaterCol8;
	}

	/**
	 * @return the showerWaterCol9
	 */
	public String getShowerWaterCol9() {
		return showerWaterCol9;
	}

	/**
	 * @param showerWaterCol9
	 *            the showerWaterCol9 to set
	 */
	public void setShowerWaterCol9(String showerWaterCol9) {
		this.showerWaterCol9 = showerWaterCol9;
	}

	/**
	 * @return the lubricationCol1
	 */
	public String getLubricationCol1() {
		return lubricationCol1;
	}

	/**
	 * @param lubricationCol1
	 *            the lubricationCol1 to set
	 */
	public void setLubricationCol1(String lubricationCol1) {
		this.lubricationCol1 = lubricationCol1;
	}

	/**
	 * @return the lubricationCol2
	 */
	public String getLubricationCol2() {
		return lubricationCol2;
	}

	/**
	 * @param lubricationCol2
	 *            the lubricationCol2 to set
	 */
	public void setLubricationCol2(String lubricationCol2) {
		this.lubricationCol2 = lubricationCol2;
	}

	/**
	 * @return the lubricationCol3
	 */
	public String getLubricationCol3() {
		return lubricationCol3;
	}

	/**
	 * @param lubricationCol3
	 *            the lubricationCol3 to set
	 */
	public void setLubricationCol3(String lubricationCol3) {
		this.lubricationCol3 = lubricationCol3;
	}

	/**
	 * @return the lubricationCol4
	 */
	public String getLubricationCol4() {
		return lubricationCol4;
	}

	/**
	 * @param lubricationCol4
	 *            the lubricationCol4 to set
	 */
	public void setLubricationCol4(String lubricationCol4) {
		this.lubricationCol4 = lubricationCol4;
	}

	/**
	 * @return the lubricationCol5
	 */
	public String getLubricationCol5() {
		return lubricationCol5;
	}

	/**
	 * @param lubricationCol5
	 *            the lubricationCol5 to set
	 */
	public void setLubricationCol5(String lubricationCol5) {
		this.lubricationCol5 = lubricationCol5;
	}

	/**
	 * @return the lubricationCol6
	 */
	public String getLubricationCol6() {
		return lubricationCol6;
	}

	/**
	 * @param lubricationCol6
	 *            the lubricationCol6 to set
	 */
	public void setLubricationCol6(String lubricationCol6) {
		this.lubricationCol6 = lubricationCol6;
	}

	/**
	 * @return the lubricationCol7
	 */
	public String getLubricationCol7() {
		return lubricationCol7;
	}

	/**
	 * @param lubricationCol7
	 *            the lubricationCol7 to set
	 */
	public void setLubricationCol7(String lubricationCol7) {
		this.lubricationCol7 = lubricationCol7;
	}

	/**
	 * @return the afterDryerCol1
	 */
	public boolean isAfterDryerCol1() {
		return afterDryerCol1;
	}

	/**
	 * @param afterDryerCol1
	 *            the afterDryerCol1 to set
	 */
	public void setAfterDryerCol1(boolean afterDryerCol1) {
		this.afterDryerCol1 = afterDryerCol1;
	}

	/**
	 * @return the afterDryerCol2
	 */
	public String getAfterDryerCol2() {
		return afterDryerCol2;
	}

	/**
	 * @param afterDryerCol2
	 *            the afterDryerCol2 to set
	 */
	public void setAfterDryerCol2(String afterDryerCol2) {
		this.afterDryerCol2 = afterDryerCol2;
	}

	/**
	 * @return the afterDryerCol3
	 */
	public String getAfterDryerCol3() {
		return afterDryerCol3;
	}

	/**
	 * @param afterDryerCol3
	 *            the afterDryerCol3 to set
	 */
	public void setAfterDryerCol3(String afterDryerCol3) {
		this.afterDryerCol3 = afterDryerCol3;
	}


	/**
	 * @return the eqptScannerCol1
	 */
	public boolean isEqptScannerCol1() {
		return eqptScannerCol1;
	}

	/**
	 * @param eqptScannerCol1
	 *            the eqptScannerCol1 to set
	 */
	public void setEqptScannerCol1(boolean eqptScannerCol1) {
		this.eqptScannerCol1 = eqptScannerCol1;
	}


	/**
	 * @return the eqptScannerCol3
	 */
	public boolean isEqptScannerCol3() {
		return eqptScannerCol3;
	}

	/**
	 * @param eqptScannerCol3
	 *            the eqptScannerCol3 to set
	 */
	public void setEqptScannerCol3(boolean eqptScannerCol3) {
		this.eqptScannerCol3 = eqptScannerCol3;
	}

	/**
	 * @return the eqptScannerCol4
	 */
	public boolean isEqptScannerCol4() {
		return eqptScannerCol4;
	}

	/**
	 * @param eqptScannerCol4
	 *            the eqptScannerCol4 to set
	 */
	public void setEqptScannerCol4(boolean eqptScannerCol4) {
		this.eqptScannerCol4 = eqptScannerCol4;
	}

	/**
	 * @return the eqptScannerCol5
	 */
	public boolean isEqptScannerCol5() {
		return eqptScannerCol5;
	}

	/**
	 * @param eqptScannerCol5
	 *            the eqptScannerCol5 to set
	 */
	public void setEqptScannerCol5(boolean eqptScannerCol5) {
		this.eqptScannerCol5 = eqptScannerCol5;
	}

	/**
	 * @return the eqptReelSectionCol1
	 */
	public boolean isEqptReelSectionCol1() {
		return eqptReelSectionCol1;
	}

	/**
	 * @param eqptReelSectionCol1
	 *            the eqptReelSectionCol1 to set
	 */
	public void setEqptReelSectionCol1(boolean eqptReelSectionCol1) {
		this.eqptReelSectionCol1 = eqptReelSectionCol1;
	}

	/**
	 * @return the eqptReelSectionCol2
	 */
	public String getEqptReelSectionCol2() {
		return eqptReelSectionCol2;
	}

	/**
	 * @param eqptReelSectionCol2
	 *            the eqptReelSectionCol2 to set
	 */
	public void setEqptReelSectionCol2(String eqptReelSectionCol2) {
		this.eqptReelSectionCol2 = eqptReelSectionCol2;
	}

	/**
	 * @return the eqptReelSectionCol3
	 */
	public String getEqptReelSectionCol3() {
		return eqptReelSectionCol3;
	}

	/**
	 * @param eqptReelSectionCol3
	 *            the eqptReelSectionCol3 to set
	 */
	public void setEqptReelSectionCol3(String eqptReelSectionCol3) {
		this.eqptReelSectionCol3 = eqptReelSectionCol3;
	}

	/**
	 * @return the eqptReelSectionCol4
	 */
	public String getEqptReelSectionCol4() {
		return eqptReelSectionCol4;
	}

	/**
	 * @param eqptReelSectionCol4
	 *            the eqptReelSectionCol4 to set
	 */
	public void setEqptReelSectionCol4(String eqptReelSectionCol4) {
		this.eqptReelSectionCol4 = eqptReelSectionCol4;
	}

	/**
	 * @return the eqptReelSectionCol5
	 */
	public String getEqptReelSectionCol5() {
		return eqptReelSectionCol5;
	}

	/**
	 * @param eqptReelSectionCol5
	 *            the eqptReelSectionCol5 to set
	 */
	public void setEqptReelSectionCol5(String eqptReelSectionCol5) {
		this.eqptReelSectionCol5 = eqptReelSectionCol5;
	}

	/**
	 * @return the oilFlowCol1
	 */
	public boolean isOilFlowCol1() {
		return oilFlowCol1;
	}

	/**
	 * @param oilFlowCol1
	 *            the oilFlowCol1 to set
	 */
	public void setOilFlowCol1(boolean oilFlowCol1) {
		this.oilFlowCol1 = oilFlowCol1;
	}

	/**
	 * @return the oilFlowCol2
	 */
	public boolean isOilFlowCol2() {
		return oilFlowCol2;
	}

	/**
	 * @param oilFlowCol2
	 *            the oilFlowCol2 to set
	 */
	public void setOilFlowCol2(boolean oilFlowCol2) {
		this.oilFlowCol2 = oilFlowCol2;
	}

	/**
	 * @return the oilFlowCol3
	 */
	public boolean isOilFlowCol3() {
		return oilFlowCol3;
	}

	/**
	 * @param oilFlowCol3
	 *            the oilFlowCol3 to set
	 */
	public void setOilFlowCol3(boolean oilFlowCol3) {
		this.oilFlowCol3 = oilFlowCol3;
	}

	/**
	 * @return the oilFlowCol4
	 */
	public boolean isOilFlowCol4() {
		return oilFlowCol4;
	}

	/**
	 * @param oilFlowCol4
	 *            the oilFlowCol4 to set
	 */
	public void setOilFlowCol4(boolean oilFlowCol4) {
		this.oilFlowCol4 = oilFlowCol4;
	}

	/**
	 * @return the oilFlowCol5
	 */
	public String getOilFlowCol5() {
		return oilFlowCol5;
	}

	/**
	 * @param oilFlowCol5
	 *            the oilFlowCol5 to set
	 */
	public void setOilFlowCol5(String oilFlowCol5) {
		this.oilFlowCol5 = oilFlowCol5;
	}

	/**
	 * @return the oilFlowCol6
	 */
	public String getOilFlowCol6() {
		return oilFlowCol6;
	}

	/**
	 * @param oilFlowCol6
	 *            the oilFlowCol6 to set
	 */
	public void setOilFlowCol6(String oilFlowCol6) {
		this.oilFlowCol6 = oilFlowCol6;
	}

	/**
	 * @return the oilFlowCol7
	 */
	public String getOilFlowCol7() {
		return oilFlowCol7;
	}

	/**
	 * @param oilFlowCol7
	 *            the oilFlowCol7 to set
	 */
	public void setOilFlowCol7(String oilFlowCol7) {
		this.oilFlowCol7 = oilFlowCol7;
	}

	/**
	 * @return the mezzanineCol1
	 */
	public boolean isMezzanineCol1() {
		return mezzanineCol1;
	}

	/**
	 * @param mezzanineCol1
	 *            the mezzanineCol1 to set
	 */
	public void setMezzanineCol1(boolean mezzanineCol1) {
		this.mezzanineCol1 = mezzanineCol1;
	}

	/**
	 * @return the mezzanineCol2
	 */
	public boolean isMezzanineCol2() {
		return mezzanineCol2;
	}

	/**
	 * @param mezzanineCol2
	 *            the mezzanineCol2 to set
	 */
	public void setMezzanineCol2(boolean mezzanineCol2) {
		this.mezzanineCol2 = mezzanineCol2;
	}

	/**
	 * @return the mezzanineCol3
	 */
	public boolean isMezzanineCol3() {
		return mezzanineCol3;
	}

	/**
	 * @param mezzanineCol3
	 *            the mezzanineCol3 to set
	 */
	public void setMezzanineCol3(boolean mezzanineCol3) {
		this.mezzanineCol3 = mezzanineCol3;
	}

	/**
	 * @return the mezzanineCol4
	 */
	public boolean isMezzanineCol4() {
		return mezzanineCol4;
	}

	/**
	 * @param mezzanineCol4
	 *            the mezzanineCol4 to set
	 */
	public void setMezzanineCol4(boolean mezzanineCol4) {
		this.mezzanineCol4 = mezzanineCol4;
	}

	/**
	 * @return the mezzanineCol5
	 */
	public boolean isMezzanineCol5() {
		return mezzanineCol5;
	}

	/**
	 * @param mezzanineCol5
	 *            the mezzanineCol5 to set
	 */
	public void setMezzanineCol5(boolean mezzanineCol5) {
		this.mezzanineCol5 = mezzanineCol5;
	}

	/**
	 * @return the reelCol1Desc
	 */
	public String getReelCol1Desc() {
		return reelCol1Desc;
	}

	/**
	 * @param reelCol1Desc
	 *            the reelCol1Desc to set
	 */
	public void setReelCol1Desc(String reelCol1Desc) {
		this.reelCol1Desc = reelCol1Desc;
	}

	/**
	 * @return the reelCol2Desc
	 */
	public String getReelCol2Desc() {
		return reelCol2Desc;
	}

	/**
	 * @param reelCol2Desc
	 *            the reelCol2Desc to set
	 */
	public void setReelCol2Desc(String reelCol2Desc) {
		this.reelCol2Desc = reelCol2Desc;
	}

	/**
	 * @return the reelCol3Desc
	 */
	public String getReelCol3Desc() {
		return reelCol3Desc;
	}

	/**
	 * @param reelCol3Desc
	 *            the reelCol3Desc to set
	 */
	public void setReelCol3Desc(String reelCol3Desc) {
		this.reelCol3Desc = reelCol3Desc;
	}

	/**
	 * @return the reelCol4Desc
	 */
	public String getReelCol4Desc() {
		return reelCol4Desc;
	}

	/**
	 * @param reelCol4Desc
	 *            the reelCol4Desc to set
	 */
	public void setReelCol4Desc(String reelCol4Desc) {
		this.reelCol4Desc = reelCol4Desc;
	}

	/**
	 * @return the reelCol5Desc
	 */
	public String getReelCol5Desc() {
		return reelCol5Desc;
	}

	/**
	 * @param reelCol5Desc
	 *            the reelCol5Desc to set
	 */
	public void setReelCol5Desc(String reelCol5Desc) {
		this.reelCol5Desc = reelCol5Desc;
	}

	/**
	 * @return the machineLubricationCol1Desc
	 */
	public String getMachineLubricationCol1Desc() {
		return machineLubricationCol1Desc;
	}

	/**
	 * @param machineLubricationCol1Desc
	 *            the machineLubricationCol1Desc to set
	 */
	public void setMachineLubricationCol1Desc(String machineLubricationCol1Desc) {
		this.machineLubricationCol1Desc = machineLubricationCol1Desc;
	}

	/**
	 * @return the machineLubricationCol2Desc
	 */
	public String getMachineLubricationCol2Desc() {
		return machineLubricationCol2Desc;
	}

	/**
	 * @param machineLubricationCol2Desc
	 *            the machineLubricationCol2Desc to set
	 */
	public void setMachineLubricationCol2Desc(String machineLubricationCol2Desc) {
		this.machineLubricationCol2Desc = machineLubricationCol2Desc;
	}

	/**
	 * @return the machineLubricationCol3Desc
	 */
	public String getMachineLubricationCol3Desc() {
		return machineLubricationCol3Desc;
	}

	/**
	 * @param machineLubricationCol3Desc
	 *            the machineLubricationCol3Desc to set
	 */
	public void setMachineLubricationCol3Desc(String machineLubricationCol3Desc) {
		this.machineLubricationCol3Desc = machineLubricationCol3Desc;
	}

	/**
	 * @return the machineLubricationCol4Desc
	 */
	public String getMachineLubricationCol4Desc() {
		return machineLubricationCol4Desc;
	}

	/**
	 * @param machineLubricationCol4Desc
	 *            the machineLubricationCol4Desc to set
	 */
	public void setMachineLubricationCol4Desc(String machineLubricationCol4Desc) {
		this.machineLubricationCol4Desc = machineLubricationCol4Desc;
	}

	/**
	 * @return the machineLubricationCol5Desc
	 */
	public String getMachineLubricationCol5Desc() {
		return machineLubricationCol5Desc;
	}

	/**
	 * @param machineLubricationCol5Desc
	 *            the machineLubricationCol5Desc to set
	 */
	public void setMachineLubricationCol5Desc(String machineLubricationCol5Desc) {
		this.machineLubricationCol5Desc = machineLubricationCol5Desc;
	}

	/**
	 * @return the condensateCol1Desc
	 */
	public String getCondensateCol1Desc() {
		return condensateCol1Desc;
	}

	/**
	 * @param condensateCol1Desc
	 *            the condensateCol1Desc to set
	 */
	public void setCondensateCol1Desc(String condensateCol1Desc) {
		this.condensateCol1Desc = condensateCol1Desc;
	}

	/**
	 * @return the condensateCol2Desc
	 */
	public String getCondensateCol2Desc() {
		return condensateCol2Desc;
	}

	/**
	 * @param condensateCol2Desc
	 *            the condensateCol2Desc to set
	 */
	public void setCondensateCol2Desc(String condensateCol2Desc) {
		this.condensateCol2Desc = condensateCol2Desc;
	}

	/**
	 * @return the condensateCol3Desc
	 */
	public String getCondensateCol3Desc() {
		return condensateCol3Desc;
	}

	/**
	 * @param condensateCol3Desc
	 *            the condensateCol3Desc to set
	 */
	public void setCondensateCol3Desc(String condensateCol3Desc) {
		this.condensateCol3Desc = condensateCol3Desc;
	}

	/**
	 * @return the condensateCol4Desc
	 */
	public String getCondensateCol4Desc() {
		return condensateCol4Desc;
	}

	/**
	 * @param condensateCol4Desc
	 *            the condensateCol4Desc to set
	 */
	public void setCondensateCol4Desc(String condensateCol4Desc) {
		this.condensateCol4Desc = condensateCol4Desc;
	}

	/**
	 * @return the condensateCol5Desc
	 */
	public String getCondensateCol5Desc() {
		return condensateCol5Desc;
	}

	/**
	 * @param condensateCol5Desc
	 *            the condensateCol5Desc to set
	 */
	public void setCondensateCol5Desc(String condensateCol5Desc) {
		this.condensateCol5Desc = condensateCol5Desc;
	}

	/**
	 * @return the condensateCol6Desc
	 */
	public String getCondensateCol6Desc() {
		return condensateCol6Desc;
	}

	/**
	 * @param condensateCol6Desc
	 *            the condensateCol6Desc to set
	 */
	public void setCondensateCol6Desc(String condensateCol6Desc) {
		this.condensateCol6Desc = condensateCol6Desc;
	}

	/**
	 * @return the condensateCol7Desc
	 */
	public String getCondensateCol7Desc() {
		return condensateCol7Desc;
	}

	/**
	 * @param condensateCol7Desc
	 *            the condensateCol7Desc to set
	 */
	public void setCondensateCol7Desc(String condensateCol7Desc) {
		this.condensateCol7Desc = condensateCol7Desc;
	}

	/**
	 * @return the condensateCol8Desc
	 */
	public String getCondensateCol8Desc() {
		return condensateCol8Desc;
	}

	/**
	 * @param condensateCol8Desc
	 *            the condensateCol8Desc to set
	 */
	public void setCondensateCol8Desc(String condensateCol8Desc) {
		this.condensateCol8Desc = condensateCol8Desc;
	}

	/**
	 * @return the condensateCol9Desc
	 */
	public String getCondensateCol9Desc() {
		return condensateCol9Desc;
	}

	/**
	 * @param condensateCol9Desc
	 *            the condensateCol9Desc to set
	 */
	public void setCondensateCol9Desc(String condensateCol9Desc) {
		this.condensateCol9Desc = condensateCol9Desc;
	}

	/**
	 * @return the condensateCol10Desc
	 */
	public String getCondensateCol10Desc() {
		return condensateCol10Desc;
	}

	/**
	 * @param condensateCol10Desc
	 *            the condensateCol10Desc to set
	 */
	public void setCondensateCol10Desc(String condensateCol10Desc) {
		this.condensateCol10Desc = condensateCol10Desc;
	}

	/**
	 * @return the condensateCol11Desc
	 */
	public String getCondensateCol11Desc() {
		return condensateCol11Desc;
	}

	/**
	 * @param condensateCol11Desc
	 *            the condensateCol11Desc to set
	 */
	public void setCondensateCol11Desc(String condensateCol11Desc) {
		this.condensateCol11Desc = condensateCol11Desc;
	}

	/**
	 * @return the condensateCol12Desc
	 */
	public String getCondensateCol12Desc() {
		return condensateCol12Desc;
	}

	/**
	 * @param condensateCol12Desc
	 *            the condensateCol12Desc to set
	 */
	public void setCondensateCol12Desc(String condensateCol12Desc) {
		this.condensateCol12Desc = condensateCol12Desc;
	}

	/**
	 * @return the condensateCol13Desc
	 */
	public String getCondensateCol13Desc() {
		return condensateCol13Desc;
	}

	/**
	 * @param condensateCol13Desc
	 *            the condensateCol13Desc to set
	 */
	public void setCondensateCol13Desc(String condensateCol13Desc) {
		this.condensateCol13Desc = condensateCol13Desc;
	}

	/**
	 * @return the condensateCol14Desc
	 */
	public String getCondensateCol14Desc() {
		return condensateCol14Desc;
	}

	/**
	 * @param condensateCol14Desc
	 *            the condensateCol14Desc to set
	 */
	public void setCondensateCol14Desc(String condensateCol14Desc) {
		this.condensateCol14Desc = condensateCol14Desc;
	}

	/**
	 * @return the condensateCol15Desc
	 */
	public String getCondensateCol15Desc() {
		return condensateCol15Desc;
	}

	/**
	 * @param condensateCol15Desc
	 *            the condensateCol15Desc to set
	 */
	public void setCondensateCol15Desc(String condensateCol15Desc) {
		this.condensateCol15Desc = condensateCol15Desc;
	}

	/**
	 * @return the showerWaterCol1Desc
	 */
	public String getShowerWaterCol1Desc() {
		return showerWaterCol1Desc;
	}

	/**
	 * @param showerWaterCol1Desc
	 *            the showerWaterCol1Desc to set
	 */
	public void setShowerWaterCol1Desc(String showerWaterCol1Desc) {
		this.showerWaterCol1Desc = showerWaterCol1Desc;
	}

	/**
	 * @return the showerWaterCol2Desc
	 */
	public String getShowerWaterCol2Desc() {
		return showerWaterCol2Desc;
	}

	/**
	 * @param showerWaterCol2Desc
	 *            the showerWaterCol2Desc to set
	 */
	public void setShowerWaterCol2Desc(String showerWaterCol2Desc) {
		this.showerWaterCol2Desc = showerWaterCol2Desc;
	}

	/**
	 * @return the showerWaterCol3Desc
	 */
	public String getShowerWaterCol3Desc() {
		return showerWaterCol3Desc;
	}

	/**
	 * @param showerWaterCol3Desc
	 *            the showerWaterCol3Desc to set
	 */
	public void setShowerWaterCol3Desc(String showerWaterCol3Desc) {
		this.showerWaterCol3Desc = showerWaterCol3Desc;
	}

	/**
	 * @return the showerWaterCol4Desc
	 */
	public String getShowerWaterCol4Desc() {
		return showerWaterCol4Desc;
	}

	/**
	 * @param showerWaterCol4Desc
	 *            the showerWaterCol4Desc to set
	 */
	public void setShowerWaterCol4Desc(String showerWaterCol4Desc) {
		this.showerWaterCol4Desc = showerWaterCol4Desc;
	}

	/**
	 * @return the showerWaterCol5Desc
	 */
	public String getShowerWaterCol5Desc() {
		return showerWaterCol5Desc;
	}

	/**
	 * @param showerWaterCol5Desc
	 *            the showerWaterCol5Desc to set
	 */
	public void setShowerWaterCol5Desc(String showerWaterCol5Desc) {
		this.showerWaterCol5Desc = showerWaterCol5Desc;
	}

	/**
	 * @return the showerWaterCol6Desc
	 */
	public String getShowerWaterCol6Desc() {
		return showerWaterCol6Desc;
	}

	/**
	 * @param showerWaterCol6Desc
	 *            the showerWaterCol6Desc to set
	 */
	public void setShowerWaterCol6Desc(String showerWaterCol6Desc) {
		this.showerWaterCol6Desc = showerWaterCol6Desc;
	}

	/**
	 * @return the showerWaterCol7Desc
	 */
	public String getShowerWaterCol7Desc() {
		return showerWaterCol7Desc;
	}

	/**
	 * @param showerWaterCol7Desc
	 *            the showerWaterCol7Desc to set
	 */
	public void setShowerWaterCol7Desc(String showerWaterCol7Desc) {
		this.showerWaterCol7Desc = showerWaterCol7Desc;
	}

	/**
	 * @return the showerWaterCol8Desc
	 */
	public String getShowerWaterCol8Desc() {
		return showerWaterCol8Desc;
	}

	/**
	 * @param showerWaterCol8Desc
	 *            the showerWaterCol8Desc to set
	 */
	public void setShowerWaterCol8Desc(String showerWaterCol8Desc) {
		this.showerWaterCol8Desc = showerWaterCol8Desc;
	}

	/**
	 * @return the showerWaterCol9Desc
	 */
	public String getShowerWaterCol9Desc() {
		return showerWaterCol9Desc;
	}

	/**
	 * @param showerWaterCol9Desc
	 *            the showerWaterCol9Desc to set
	 */
	public void setShowerWaterCol9Desc(String showerWaterCol9Desc) {
		this.showerWaterCol9Desc = showerWaterCol9Desc;
	}

	/**
	 * @return the lubricationCol1Desc
	 */
	public String getLubricationCol1Desc() {
		return lubricationCol1Desc;
	}

	/**
	 * @param lubricationCol1Desc
	 *            the lubricationCol1Desc to set
	 */
	public void setLubricationCol1Desc(String lubricationCol1Desc) {
		this.lubricationCol1Desc = lubricationCol1Desc;
	}

	/**
	 * @return the lubricationCol2Desc
	 */
	public String getLubricationCol2Desc() {
		return lubricationCol2Desc;
	}

	/**
	 * @param lubricationCol2Desc
	 *            the lubricationCol2Desc to set
	 */
	public void setLubricationCol2Desc(String lubricationCol2Desc) {
		this.lubricationCol2Desc = lubricationCol2Desc;
	}

	/**
	 * @return the lubricationCol3Desc
	 */
	public String getLubricationCol3Desc() {
		return lubricationCol3Desc;
	}

	/**
	 * @param lubricationCol3Desc
	 *            the lubricationCol3Desc to set
	 */
	public void setLubricationCol3Desc(String lubricationCol3Desc) {
		this.lubricationCol3Desc = lubricationCol3Desc;
	}

	/**
	 * @return the lubricationCol4Desc
	 */
	public String getLubricationCol4Desc() {
		return lubricationCol4Desc;
	}

	/**
	 * @param lubricationCol4Desc
	 *            the lubricationCol4Desc to set
	 */
	public void setLubricationCol4Desc(String lubricationCol4Desc) {
		this.lubricationCol4Desc = lubricationCol4Desc;
	}

	/**
	 * @return the lubricationCo5Desc
	 */
	public String getLubricationCo5Desc() {
		return lubricationCo5Desc;
	}

	/**
	 * @param lubricationCo5Desc
	 *            the lubricationCo5Desc to set
	 */
	public void setLubricationCo5Desc(String lubricationCo5Desc) {
		this.lubricationCo5Desc = lubricationCo5Desc;
	}

	/**
	 * @return the lubricationCo6Desc
	 */
	public String getLubricationCo6Desc() {
		return lubricationCo6Desc;
	}

	/**
	 * @param lubricationCo6Desc
	 *            the lubricationCo6Desc to set
	 */
	public void setLubricationCo6Desc(String lubricationCo6Desc) {
		this.lubricationCo6Desc = lubricationCo6Desc;
	}

	/**
	 * @return the lubricationCo7Desc
	 */
	public String getLubricationCo7Desc() {
		return lubricationCo7Desc;
	}

	/**
	 * @param lubricationCo7Desc
	 *            the lubricationCo7Desc to set
	 */
	public void setLubricationCo7Desc(String lubricationCo7Desc) {
		this.lubricationCo7Desc = lubricationCo7Desc;
	}

	/**
	 * @return the afterDryerCol1Desc
	 */
	public String getAfterDryerCol1Desc() {
		return afterDryerCol1Desc;
	}

	/**
	 * @param afterDryerCol1Desc
	 *            the afterDryerCol1Desc to set
	 */
	public void setAfterDryerCol1Desc(String afterDryerCol1Desc) {
		this.afterDryerCol1Desc = afterDryerCol1Desc;
	}

	/**
	 * @return the afterDryerCol2Desc
	 */
	public String getAfterDryerCol2Desc() {
		return afterDryerCol2Desc;
	}

	/**
	 * @param afterDryerCol2Desc
	 *            the afterDryerCol2Desc to set
	 */
	public void setAfterDryerCol2Desc(String afterDryerCol2Desc) {
		this.afterDryerCol2Desc = afterDryerCol2Desc;
	}

	/**
	 * @return the afterDryerCol3Desc
	 */
	public String getAfterDryerCol3Desc() {
		return afterDryerCol3Desc;
	}

	/**
	 * @param afterDryerCol3Desc
	 *            the afterDryerCol3Desc to set
	 */
	public void setAfterDryerCol3Desc(String afterDryerCol3Desc) {
		this.afterDryerCol3Desc = afterDryerCol3Desc;
	}

	/**
	 * @return the afterDryerCol4Desc
	 */
	public String getAfterDryerCol4Desc() {
		return afterDryerCol4Desc;
	}

	/**
	 * @param afterDryerCol4Desc
	 *            the afterDryerCol4Desc to set
	 */
	public void setAfterDryerCol4Desc(String afterDryerCol4Desc) {
		this.afterDryerCol4Desc = afterDryerCol4Desc;
	}

	/**
	 * @return the afterDryerCol5Desc
	 */
	public String getAfterDryerCol5Desc() {
		return afterDryerCol5Desc;
	}

	/**
	 * @param afterDryerCol5Desc
	 *            the afterDryerCol5Desc to set
	 */
	public void setAfterDryerCol5Desc(String afterDryerCol5Desc) {
		this.afterDryerCol5Desc = afterDryerCol5Desc;
	}

	/**
	 * @return the afterDryerCol6Desc
	 */
	public String getAfterDryerCol6Desc() {
		return afterDryerCol6Desc;
	}

	/**
	 * @param afterDryerCol6Desc
	 *            the afterDryerCol6Desc to set
	 */
	public void setAfterDryerCol6Desc(String afterDryerCol6Desc) {
		this.afterDryerCol6Desc = afterDryerCol6Desc;
	}

	/**
	 * @return the eqptScannerCol1Desc
	 */
	public String getEqptScannerCol1Desc() {
		return eqptScannerCol1Desc;
	}

	/**
	 * @param eqptScannerCol1Desc
	 *            the eqptScannerCol1Desc to set
	 */
	public void setEqptScannerCol1Desc(String eqptScannerCol1Desc) {
		this.eqptScannerCol1Desc = eqptScannerCol1Desc;
	}

	/**
	 * @return the eqptScannerCol2Desc
	 */
	public String getEqptScannerCol2Desc() {
		return eqptScannerCol2Desc;
	}

	/**
	 * @param eqptScannerCol2Desc
	 *            the eqptScannerCol2Desc to set
	 */
	public void setEqptScannerCol2Desc(String eqptScannerCol2Desc) {
		this.eqptScannerCol2Desc = eqptScannerCol2Desc;
	}

	/**
	 * @return the eqptScannerCol3Desc
	 */
	public String getEqptScannerCol3Desc() {
		return eqptScannerCol3Desc;
	}

	/**
	 * @param eqptScannerCol3Desc
	 *            the eqptScannerCol3Desc to set
	 */
	public void setEqptScannerCol3Desc(String eqptScannerCol3Desc) {
		this.eqptScannerCol3Desc = eqptScannerCol3Desc;
	}

	/**
	 * @return the eqptScannerCol4Desc
	 */
	public String getEqptScannerCol4Desc() {
		return eqptScannerCol4Desc;
	}

	/**
	 * @param eqptScannerCol4Desc
	 *            the eqptScannerCol4Desc to set
	 */
	public void setEqptScannerCol4Desc(String eqptScannerCol4Desc) {
		this.eqptScannerCol4Desc = eqptScannerCol4Desc;
	}

	/**
	 * @return the eqptScannerCol5Desc
	 */
	public String getEqptScannerCol5Desc() {
		return eqptScannerCol5Desc;
	}

	/**
	 * @param eqptScannerCol5Desc
	 *            the eqptScannerCol5Desc to set
	 */
	public void setEqptScannerCol5Desc(String eqptScannerCol5Desc) {
		this.eqptScannerCol5Desc = eqptScannerCol5Desc;
	}

	/**
	 * @return the eqptReelSectionCol1Desc
	 */
	public String getEqptReelSectionCol1Desc() {
		return eqptReelSectionCol1Desc;
	}

	/**
	 * @param eqptReelSectionCol1Desc
	 *            the eqptReelSectionCol1Desc to set
	 */
	public void setEqptReelSectionCol1Desc(String eqptReelSectionCol1Desc) {
		this.eqptReelSectionCol1Desc = eqptReelSectionCol1Desc;
	}

	/**
	 * @return the eqptReelSectionCol2Desc
	 */
	public String getEqptReelSectionCol2Desc() {
		return eqptReelSectionCol2Desc;
	}

	/**
	 * @param eqptReelSectionCol2Desc
	 *            the eqptReelSectionCol2Desc to set
	 */
	public void setEqptReelSectionCol2Desc(String eqptReelSectionCol2Desc) {
		this.eqptReelSectionCol2Desc = eqptReelSectionCol2Desc;
	}

	/**
	 * @return the eqptReelSectionCol3Desc
	 */
	public String getEqptReelSectionCol3Desc() {
		return eqptReelSectionCol3Desc;
	}

	/**
	 * @param eqptReelSectionCol3Desc
	 *            the eqptReelSectionCol3Desc to set
	 */
	public void setEqptReelSectionCol3Desc(String eqptReelSectionCol3Desc) {
		this.eqptReelSectionCol3Desc = eqptReelSectionCol3Desc;
	}

	/**
	 * @return the eqptReelSectionCol4Desc
	 */
	public String getEqptReelSectionCol4Desc() {
		return eqptReelSectionCol4Desc;
	}

	/**
	 * @param eqptReelSectionCol4Desc
	 *            the eqptReelSectionCol4Desc to set
	 */
	public void setEqptReelSectionCol4Desc(String eqptReelSectionCol4Desc) {
		this.eqptReelSectionCol4Desc = eqptReelSectionCol4Desc;
	}

	/**
	 * @return the eqptReelSectionCol5Desc
	 */
	public String getEqptReelSectionCol5Desc() {
		return eqptReelSectionCol5Desc;
	}

	/**
	 * @param eqptReelSectionCol5Desc
	 *            the eqptReelSectionCol5Desc to set
	 */
	public void setEqptReelSectionCol5Desc(String eqptReelSectionCol5Desc) {
		this.eqptReelSectionCol5Desc = eqptReelSectionCol5Desc;
	}

	/**
	 * @return the oilFlowCol1Desc
	 */
	public String getOilFlowCol1Desc() {
		return oilFlowCol1Desc;
	}

	/**
	 * @param oilFlowCol1Desc
	 *            the oilFlowCol1Desc to set
	 */
	public void setOilFlowCol1Desc(String oilFlowCol1Desc) {
		this.oilFlowCol1Desc = oilFlowCol1Desc;
	}

	/**
	 * @return the oilFlowCol2Desc
	 */
	public String getOilFlowCol2Desc() {
		return oilFlowCol2Desc;
	}

	/**
	 * @param oilFlowCol2Desc
	 *            the oilFlowCol2Desc to set
	 */
	public void setOilFlowCol2Desc(String oilFlowCol2Desc) {
		this.oilFlowCol2Desc = oilFlowCol2Desc;
	}

	/**
	 * @return the oilFlowCol3Desc
	 */
	public String getOilFlowCol3Desc() {
		return oilFlowCol3Desc;
	}

	/**
	 * @param oilFlowCol3Desc
	 *            the oilFlowCol3Desc to set
	 */
	public void setOilFlowCol3Desc(String oilFlowCol3Desc) {
		this.oilFlowCol3Desc = oilFlowCol3Desc;
	}

	/**
	 * @return the oilFlowCol4Desc
	 */
	public String getOilFlowCol4Desc() {
		return oilFlowCol4Desc;
	}

	/**
	 * @param oilFlowCol4Desc
	 *            the oilFlowCol4Desc to set
	 */
	public void setOilFlowCol4Desc(String oilFlowCol4Desc) {
		this.oilFlowCol4Desc = oilFlowCol4Desc;
	}

	/**
	 * @return the oilFlowCol5Desc
	 */
	public String getOilFlowCol5Desc() {
		return oilFlowCol5Desc;
	}

	/**
	 * @param oilFlowCol5Desc
	 *            the oilFlowCol5Desc to set
	 */
	public void setOilFlowCol5Desc(String oilFlowCol5Desc) {
		this.oilFlowCol5Desc = oilFlowCol5Desc;
	}

	/**
	 * @return the oilFlowCol6Desc
	 */
	public String getOilFlowCol6Desc() {
		return oilFlowCol6Desc;
	}

	/**
	 * @param oilFlowCol6Desc
	 *            the oilFlowCol6Desc to set
	 */
	public void setOilFlowCol6Desc(String oilFlowCol6Desc) {
		this.oilFlowCol6Desc = oilFlowCol6Desc;
	}

	/**
	 * @return the oilFlowCol7Desc
	 */
	public String getOilFlowCol7Desc() {
		return oilFlowCol7Desc;
	}

	/**
	 * @param oilFlowCol7Desc
	 *            the oilFlowCol7Desc to set
	 */
	public void setOilFlowCol7Desc(String oilFlowCol7Desc) {
		this.oilFlowCol7Desc = oilFlowCol7Desc;
	}

	/**
	 * @return the mezzanineCol1Desc
	 */
	public String getMezzanineCol1Desc() {
		return mezzanineCol1Desc;
	}

	/**
	 * @param mezzanineCol1Desc
	 *            the mezzanineCol1Desc to set
	 */
	public void setMezzanineCol1Desc(String mezzanineCol1Desc) {
		this.mezzanineCol1Desc = mezzanineCol1Desc;
	}

	/**
	 * @return the mezzanineCol2Desc
	 */
	public String getMezzanineCol2Desc() {
		return mezzanineCol2Desc;
	}

	/**
	 * @param mezzanineCol2Desc
	 *            the mezzanineCol2Desc to set
	 */
	public void setMezzanineCol2Desc(String mezzanineCol2Desc) {
		this.mezzanineCol2Desc = mezzanineCol2Desc;
	}

	/**
	 * @return the mezzanineCol3Desc
	 */
	public String getMezzanineCol3Desc() {
		return mezzanineCol3Desc;
	}

	/**
	 * @param mezzanineCol3Desc
	 *            the mezzanineCol3Desc to set
	 */
	public void setMezzanineCol3Desc(String mezzanineCol3Desc) {
		this.mezzanineCol3Desc = mezzanineCol3Desc;
	}

	/**
	 * @return the mezzanineCol4Desc
	 */
	public String getMezzanineCol4Desc() {
		return mezzanineCol4Desc;
	}

	/**
	 * @param mezzanineCol4Desc
	 *            the mezzanineCol4Desc to set
	 */
	public void setMezzanineCol4Desc(String mezzanineCol4Desc) {
		this.mezzanineCol4Desc = mezzanineCol4Desc;
	}

	/**
	 * @return the mezzanineCol5Desc
	 */
	public String getMezzanineCol5Desc() {
		return mezzanineCol5Desc;
	}

	/**
	 * @param mezzanineCol5Desc
	 *            the mezzanineCol5Desc to set
	 */
	public void setMezzanineCol5Desc(String mezzanineCol5Desc) {
		this.mezzanineCol5Desc = mezzanineCol5Desc;
	}

	/**
	 * @return the fillupcol1
	 */
	public String getFillupcol1() {
		return fillupcol1;
	}

	/**
	 * @param fillupcol1
	 *            the fillupcol1 to set
	 */
	public void setFillupcol1(String fillupcol1) {
		this.fillupcol1 = fillupcol1;
	}

	/**
	 * @return the fillupcol2
	 */
	public String getFillupcol2() {
		return fillupcol2;
	}

	/**
	 * @param fillupcol2
	 *            the fillupcol2 to set
	 */
	public void setFillupcol2(String fillupcol2) {
		this.fillupcol2 = fillupcol2;
	}

	/**
	 * @return the fillupcol3
	 */
	public String getFillupcol3() {
		return fillupcol3;
	}

	/**
	 * @param fillupcol3
	 *            the fillupcol3 to set
	 */
	public void setFillupcol3(String fillupcol3) {
		this.fillupcol3 = fillupcol3;
	}

	/**
	 * @return the fillupcol4
	 */
	public String getFillupcol4() {
		return fillupcol4;
	}

	/**
	 * @param fillupcol4
	 *            the fillupcol4 to set
	 */
	public void setFillupcol4(String fillupcol4) {
		this.fillupcol4 = fillupcol4;
	}

	/**
	 * @return the fillupcol5
	 */
	public String getFillupcol5() {
		return fillupcol5;
	}

	/**
	 * @param fillupcol5
	 *            the fillupcol5 to set
	 */
	public void setFillupcol5(String fillupcol5) {
		this.fillupcol5 = fillupcol5;
	}

	/**
	 * @return the fillupcol6
	 */
	public String getFillupcol6() {
		return fillupcol6;
	}

	/**
	 * @param fillupcol6
	 *            the fillupcol6 to set
	 */
	public void setFillupcol6(String fillupcol6) {
		this.fillupcol6 = fillupcol6;
	}

	/**
	 * @return the fillupcol7
	 */
	public String getFillupcol7() {
		return fillupcol7;
	}

	/**
	 * @param fillupcol7
	 *            the fillupcol7 to set
	 */
	public void setFillupcol7(String fillupcol7) {
		this.fillupcol7 = fillupcol7;
	}

	/**
	 * @return the fillupcol8
	 */
	public String getFillupcol8() {
		return fillupcol8;
	}

	/**
	 * @param fillupcol8
	 *            the fillupcol8 to set
	 */
	public void setFillupcol8(String fillupcol8) {
		this.fillupcol8 = fillupcol8;
	}

	/**
	 * @return the fillupcol1Desc
	 */
	public String getFillupcol1Desc() {
		return fillupcol1Desc;
	}

	/**
	 * @param fillupcol1Desc
	 *            the fillupcol1Desc to set
	 */
	public void setFillupcol1Desc(String fillupcol1Desc) {
		this.fillupcol1Desc = fillupcol1Desc;
	}

	/**
	 * @return the fillupcol2Desc
	 */
	public String getFillupcol2Desc() {
		return fillupcol2Desc;
	}

	/**
	 * @param fillupcol2Desc
	 *            the fillupcol2Desc to set
	 */
	public void setFillupcol2Desc(String fillupcol2Desc) {
		this.fillupcol2Desc = fillupcol2Desc;
	}

	/**
	 * @return the fillupcol3Desc
	 */
	public String getFillupcol3Desc() {
		return fillupcol3Desc;
	}

	/**
	 * @param fillupcol3Desc
	 *            the fillupcol3Desc to set
	 */
	public void setFillupcol3Desc(String fillupcol3Desc) {
		this.fillupcol3Desc = fillupcol3Desc;
	}

	/**
	 * @return the fillupcol4Desc
	 */
	public String getFillupcol4Desc() {
		return fillupcol4Desc;
	}

	/**
	 * @param fillupcol4Desc
	 *            the fillupcol4Desc to set
	 */
	public void setFillupcol4Desc(String fillupcol4Desc) {
		this.fillupcol4Desc = fillupcol4Desc;
	}

	/**
	 * @return the fillupcol5Desc
	 */
	public String getFillupcol5Desc() {
		return fillupcol5Desc;
	}

	/**
	 * @param fillupcol5Desc
	 *            the fillupcol5Desc to set
	 */
	public void setFillupcol5Desc(String fillupcol5Desc) {
		this.fillupcol5Desc = fillupcol5Desc;
	}

	/**
	 * @return the fillupcol6Desc
	 */
	public String getFillupcol6Desc() {
		return fillupcol6Desc;
	}

	/**
	 * @param fillupcol6Desc
	 *            the fillupcol6Desc to set
	 */
	public void setFillupcol6Desc(String fillupcol6Desc) {
		this.fillupcol6Desc = fillupcol6Desc;
	}

	/**
	 * @return the fillupcol7Desc
	 */
	public String getFillupcol7Desc() {
		return fillupcol7Desc;
	}

	/**
	 * @param fillupcol7Desc
	 *            the fillupcol7Desc to set
	 */
	public void setFillupcol7Desc(String fillupcol7Desc) {
		this.fillupcol7Desc = fillupcol7Desc;
	}

	/**
	 * @return the fillupcol8Desc
	 */
	public String getFillupcol8Desc() {
		return fillupcol8Desc;
	}

	/**
	 * @param fillupcol8Desc
	 *            the fillupcol8Desc to set
	 */
	public void setFillupcol8Desc(String fillupcol8Desc) {
		this.fillupcol8Desc = fillupcol8Desc;
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


	public String getCheckbladechangeremark() {
		return checkbladechangeremark;
	}

	public void setCheckbladechangeremark(String checkbladechangeremark) {
		this.checkbladechangeremark = checkbladechangeremark;
	}

	public String getCelovesforholesremark() {
		return celovesforholesremark;
	}

	public void setCelovesforholesremark(String celovesforholesremark) {
		this.celovesforholesremark = celovesforholesremark;
	}

	/**
	 * @return the machineLubricationCol3
	 */
	public String getMachineLubricationCol3() {
		return machineLubricationCol3;
	}

	/**
	 * @param machineLubricationCol3 the machineLubricationCol3 to set
	 */
	public void setMachineLubricationCol3(String machineLubricationCol3) {
		this.machineLubricationCol3 = machineLubricationCol3;
	}

	/**
	 * @return the condensateCol15
	 */
	public String getCondensateCol15() {
		return condensateCol15;
	}

	/**
	 * @param condensateCol15 the condensateCol15 to set
	 */
	public void setCondensateCol15(String condensateCol15) {
		this.condensateCol15 = condensateCol15;
	}

	
	/**
	 * @return the afterDryerCol4
	 */
	public boolean isAfterDryerCol4() {
		return afterDryerCol4;
	}

	/**
	 * @param afterDryerCol4 the afterDryerCol4 to set
	 */
	public void setAfterDryerCol4(boolean afterDryerCol4) {
		this.afterDryerCol4 = afterDryerCol4;
	}

	/**
	 * @return the afterDryerCol5
	 */
	public String getAfterDryerCol5() {
		return afterDryerCol5;
	}

	/**
	 * @param afterDryerCol5 the afterDryerCol5 to set
	 */
	public void setAfterDryerCol5(String afterDryerCol5) {
		this.afterDryerCol5 = afterDryerCol5;
	}

	/**
	 * @return the afterDryerCol6
	 */
	public String getAfterDryerCol6() {
		return afterDryerCol6;
	}

	/**
	 * @param afterDryerCol6 the afterDryerCol6 to set
	 */
	public void setAfterDryerCol6(String afterDryerCol6) {
		this.afterDryerCol6 = afterDryerCol6;
	}

	/**
	 * @return the eqptScannerCol2
	 */
	public String getEqptScannerCol2() {
		return eqptScannerCol2;
	}

	/**
	 * @param eqptScannerCol2 the eqptScannerCol2 to set
	 */
	public void setEqptScannerCol2(String eqptScannerCol2) {
		this.eqptScannerCol2 = eqptScannerCol2;
	}

	/**
	 * @return the checkbladechange
	 */
	public String getCheckbladechange() {
		return checkbladechange;
	}

	/**
	 * @param checkbladechange the checkbladechange to set
	 */
	public void setCheckbladechange(String checkbladechange) {
		this.checkbladechange = checkbladechange;
	}

	/**
	 * @return the celovesforholes
	 */
	public String getCelovesforholes() {
		return celovesforholes;
	}

	/**
	 * @param celovesforholes the celovesforholes to set
	 */
	public void setCelovesforholes(String celovesforholes) {
		this.celovesforholes = celovesforholes;
	}

	/**
	 * @return the showerWaterCol11
	 */
	public boolean isShowerWaterCol11() {
		return showerWaterCol11;
	}

	/**
	 * @param showerWaterCol11 the showerWaterCol11 to set
	 */
	public void setShowerWaterCol11(boolean showerWaterCol11) {
		this.showerWaterCol11 = showerWaterCol11;
	}
	
	
	

}
