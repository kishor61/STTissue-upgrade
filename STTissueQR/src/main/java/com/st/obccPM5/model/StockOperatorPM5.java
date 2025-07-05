/**
 *Oct 21, 2019
 *StockOperatorPM5.java
 * TODO
 *com.st.obccPM5.model
 *StockOperatorPM5.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.model;

/**
 * @author sohan
 *
 */
public class StockOperatorPM5 {
	
	private int id;
	private String position;
	private String operatorName;
	private String edate;
	private String crew;
	private String shift;
	private boolean machinedown;
	
	
	
	private String fibersupplytankcol1;
	private String fibersupplytankcol2;
	private boolean fibersupplytankcol3;
	private String fibersupplytankcol4Inbound;
	private String fibersupplytankcol4Outbound;
	private String fibersupplytankcol5Inbound;
	private String fibersupplytankcol5Outbound;
	private boolean fibersupplytankcol6;


	private String mixchestcol1;
	private String mixchestcol2Inbound;
	private String mixchestcol2Outbound;
	private boolean mixchestcol3;
	private boolean mixchestcol4;
	private String mixchestcol5Inbound;
	private String mixchestcol5Outbound;

	private String blendchestcol1;
	private boolean blendchestcol2;
	private String blendchestcol3Inbound;
	private String blendchestcol3Outbound;



	private String machinechestcol1;
	private boolean machinechestcol2;
	private String machinechestcol3Inbound;
	private String machinechestcol3Outbound;
	private boolean machinechestcol4;
	private String machinechestcol5Inbound;
	private String machinechestcol5Outbound;
	


	private boolean couchpitcol1;
	private String couchpitcol2Inbound;
	private String couchpitcol2Outbound;
	private boolean couchpitcol3;
	private String couchpitcol4Inbound;
	private String couchpitcol4Outbound;
	private String couchpitcol5Inbound;
	private String couchpitcol5Outbound;
	private boolean couchpitcol6;
	
	
	private boolean cleanscannerheadcol1;
	private String cleanscannerheadcol1Desc;
	private boolean spoolstarterworkingproperlycol1;
	private String spoolstarterworkingproperlycol1Desc;
	private boolean beakpassacceptablecol1;
	private String beakpassacceptablecol1Desc;



	private String fibersupplytankcol1Desc;
	private String fibersupplytankcol2Desc;
	private String fibersupplytankcol3Desc;
	private String fibersupplytankcol4Desc;
	private String fibersupplytankcol5Desc;
	private String fibersupplytankcol6Desc;
	
	private String mixchestcol1Desc;
	private String mixchestcol2Desc;
	private String mixchestcol3Desc;
	private String mixchestcol4Desc;
	private String mixchestcol5Desc;

	private String blendchestcol1Desc;
	private String blendchestcol2Desc;
	private String blendchestcol3Desc;

	private String machinechestcol1Desc;
	private String machinechestcol2Desc;
	private String machinechestcol3Desc;
	private String machinechestcol4Desc;
	private String machinechestcol5Desc;
	


	private String couchpitcol1Desc;
	private String couchpitcol2Desc;
	private String couchpitcol3Desc;
	private String couchpitcol4Desc;
	private String couchpitcol5Desc;
	private String couchpitcol6Desc;

	
	
	private boolean   refiner1col1;
	private String   refiner1col1Desc;
	private String   refiner1col2Inbound;
	private String   refiner1col2Outbound;
	private String   refiner1col2Desc;
	private String   refiner1col3;
	private String   refiner1col3Desc;
	private String   refiner1col4;
	private String   refiner1col4Desc;
	private boolean  refiner2col1;
	private String   refiner2col1Desc;
	private String   refiner2col2Inbound;
	private String   refiner2col2Outbound;
	private String   refiner2col2Desc;
	private String   refiner2col3;
	private String   refiner2col3Desc;
	private String   refiner2col4;
	private String   refiner2col4Desc;
	private boolean  whitewaterpumpscol1;
	private String  whitewaterpumpscol1Desc;
	private String  whitewaterpumpscol2Inbound;
	private String  whitewaterpumpscol2Outbound;
	private String  whitewaterpumpscol2Desc;
	private boolean  whitewaterpumpscol3;
	private String  whitewaterpumpscol3Desc;
	private String  whitewaterpumpscol4Inbound;
	private String  whitewaterpumpscol4Outbound;
	private String  whitewaterpumpscol4Desc;
	private String  whitewaterpumpscol5;
	private String  whitewaterpumpscol5Desc;
	private String  whitewaterpumpscol6;
	private String  whitewaterpumpscol6Desc;
	private String  whitewaterpumpscol7;
	private String  whitewaterpumpscol7Desc;
	private boolean  yankeepulpercol1;
	private String  yankeepulpercol1Desc;
	private String  yankeepulpercol2Inbound;
	private String  yankeepulpercol2Outbound;
	private String  yankeepulpercol2Desc;
	private boolean  yankeepulpercol3;
	private String  yankeepulpercol3Desc;
	private String  yankeepulpercol4Inbound;
	private String  yankeepulpercol4Outbound;
	private String  yankeepulpercol4Desc;
	private boolean  yankeepulpercol5;
	private String  yankeepulpercol5Desc;
	private String  yankeepulpercol6Inbound;
	private String  yankeepulpercol6Outbound;
	private String  yankeepulpercol6Desc;
	private boolean  borkechestcol1;
	private String  borkechestcol1Desc;
	private String  borkechestcol2Inbound;
	private String  borkechestcol2Outbound;
	private String  borkechestcol2Desc;
	private boolean borkechestcol3;
	private String  borkechestcol3Desc;
	private String  borkechestcol4Inbound;
	private String  borkechestcol4Outbound;
	private String  borkechestcol4Desc;
	private String  saveallcol1;
	private String  saveallcol1Desc;
	private String  saveallcol2;
	private String  saveallcol2Desc;
	private boolean  saveallcol3;
	private String  saveallcol3Desc;
	private String  saveallcol4Inbound;
	private String  saveallcol4Outbound;
	private String  saveallcol4Desc;
	private String  sydrapulpercol1Inbound;
	private String  sydrapulpercol1Outbound;
	private String  sydrapulpercol1Desc;
	private String  sydrapulpercol2;
	private String  sydrapulpercol2Desc;
	private boolean  sydrapulpercol3;
	private String  sydrapulpercol3Desc;
	private String  sydrapulpercol4Inbound;
	private String  sydrapulpercol4Outbound;
	private String  sydrapulpercol4Desc;
	private String  sydrapulpercol5;
	private String  sydrapulpercol5Desc;


	
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
	 * @return the fibersupplytankcol1
	 */
	public String getFibersupplytankcol1() {
		return fibersupplytankcol1;
	}

	/**
	 * @param fibersupplytankcol1 the fibersupplytankcol1 to set
	 */
	public void setFibersupplytankcol1(String fibersupplytankcol1) {
		this.fibersupplytankcol1 = fibersupplytankcol1;
	}

	/**
	 * @return the fibersupplytankcol2
	 */
	public String getFibersupplytankcol2() {
		return fibersupplytankcol2;
	}

	/**
	 * @param fibersupplytankcol2 the fibersupplytankcol2 to set
	 */
	public void setFibersupplytankcol2(String fibersupplytankcol2) {
		this.fibersupplytankcol2 = fibersupplytankcol2;
	}

	/**
	 * @return the fibersupplytankcol3
	 */
	public boolean isFibersupplytankcol3() {
		return fibersupplytankcol3;
	}

	/**
	 * @param fibersupplytankcol3 the fibersupplytankcol3 to set
	 */
	public void setFibersupplytankcol3(boolean fibersupplytankcol3) {
		this.fibersupplytankcol3 = fibersupplytankcol3;
	}

	/**
	 * @return the fibersupplytankcol4Inbound
	 */
	public String getFibersupplytankcol4Inbound() {
		return fibersupplytankcol4Inbound;
	}

	/**
	 * @param fibersupplytankcol4Inbound the fibersupplytankcol4Inbound to set
	 */
	public void setFibersupplytankcol4Inbound(String fibersupplytankcol4Inbound) {
		this.fibersupplytankcol4Inbound = fibersupplytankcol4Inbound;
	}

	/**
	 * @return the fibersupplytankcol4Outbound
	 */
	public String getFibersupplytankcol4Outbound() {
		return fibersupplytankcol4Outbound;
	}

	/**
	 * @param fibersupplytankcol4Outbound the fibersupplytankcol4Outbound to set
	 */
	public void setFibersupplytankcol4Outbound(String fibersupplytankcol4Outbound) {
		this.fibersupplytankcol4Outbound = fibersupplytankcol4Outbound;
	}

	/**
	 * @return the fibersupplytankcol5Inbound
	 */
	public String getFibersupplytankcol5Inbound() {
		return fibersupplytankcol5Inbound;
	}

	/**
	 * @param fibersupplytankcol5Inbound the fibersupplytankcol5Inbound to set
	 */
	public void setFibersupplytankcol5Inbound(String fibersupplytankcol5Inbound) {
		this.fibersupplytankcol5Inbound = fibersupplytankcol5Inbound;
	}

	/**
	 * @return the fibersupplytankcol5Outbound
	 */
	public String getFibersupplytankcol5Outbound() {
		return fibersupplytankcol5Outbound;
	}

	/**
	 * @param fibersupplytankcol5Outbound the fibersupplytankcol5Outbound to set
	 */
	public void setFibersupplytankcol5Outbound(String fibersupplytankcol5Outbound) {
		this.fibersupplytankcol5Outbound = fibersupplytankcol5Outbound;
	}

	/**
	 * @return the fibersupplytankcol6
	 */
	public boolean isFibersupplytankcol6() {
		return fibersupplytankcol6;
	}

	/**
	 * @param fibersupplytankcol6 the fibersupplytankcol6 to set
	 */
	public void setFibersupplytankcol6(boolean fibersupplytankcol6) {
		this.fibersupplytankcol6 = fibersupplytankcol6;
	}

	/**
	 * @return the mixchestcol1
	 */
	public String getMixchestcol1() {
		return mixchestcol1;
	}

	/**
	 * @param mixchestcol1 the mixchestcol1 to set
	 */
	public void setMixchestcol1(String mixchestcol1) {
		this.mixchestcol1 = mixchestcol1;
	}

	/**
	 * @return the mixchestcol2Inbound
	 */
	public String getMixchestcol2Inbound() {
		return mixchestcol2Inbound;
	}

	/**
	 * @param mixchestcol2Inbound the mixchestcol2Inbound to set
	 */
	public void setMixchestcol2Inbound(String mixchestcol2Inbound) {
		this.mixchestcol2Inbound = mixchestcol2Inbound;
	}

	/**
	 * @return the mixchestcol2Outbound
	 */
	public String getMixchestcol2Outbound() {
		return mixchestcol2Outbound;
	}

	/**
	 * @param mixchestcol2Outbound the mixchestcol2Outbound to set
	 */
	public void setMixchestcol2Outbound(String mixchestcol2Outbound) {
		this.mixchestcol2Outbound = mixchestcol2Outbound;
	}

	/**
	 * @return the mixchestcol3
	 */
	public boolean isMixchestcol3() {
		return mixchestcol3;
	}

	/**
	 * @param mixchestcol3 the mixchestcol3 to set
	 */
	public void setMixchestcol3(boolean mixchestcol3) {
		this.mixchestcol3 = mixchestcol3;
	}

	/**
	 * @return the mixchestcol4
	 */
	public boolean isMixchestcol4() {
		return mixchestcol4;
	}

	/**
	 * @param mixchestcol4 the mixchestcol4 to set
	 */
	public void setMixchestcol4(boolean mixchestcol4) {
		this.mixchestcol4 = mixchestcol4;
	}

	/**
	 * @return the mixchestcol5Inbound
	 */
	public String getMixchestcol5Inbound() {
		return mixchestcol5Inbound;
	}

	/**
	 * @param mixchestcol5Inbound the mixchestcol5Inbound to set
	 */
	public void setMixchestcol5Inbound(String mixchestcol5Inbound) {
		this.mixchestcol5Inbound = mixchestcol5Inbound;
	}

	/**
	 * @return the mixchestcol5Outbound
	 */
	public String getMixchestcol5Outbound() {
		return mixchestcol5Outbound;
	}

	/**
	 * @param mixchestcol5Outbound the mixchestcol5Outbound to set
	 */
	public void setMixchestcol5Outbound(String mixchestcol5Outbound) {
		this.mixchestcol5Outbound = mixchestcol5Outbound;
	}

	/**
	 * @return the blendchestcol1
	 */
	public String getBlendchestcol1() {
		return blendchestcol1;
	}

	/**
	 * @param blendchestcol1 the blendchestcol1 to set
	 */
	public void setBlendchestcol1(String blendchestcol1) {
		this.blendchestcol1 = blendchestcol1;
	}

	/**
	 * @return the blendchestcol2
	 */
	public boolean isBlendchestcol2() {
		return blendchestcol2;
	}

	/**
	 * @param blendchestcol2 the blendchestcol2 to set
	 */
	public void setBlendchestcol2(boolean blendchestcol2) {
		this.blendchestcol2 = blendchestcol2;
	}

	/**
	 * @return the blendchestcol3Inbound
	 */
	public String getBlendchestcol3Inbound() {
		return blendchestcol3Inbound;
	}

	/**
	 * @param blendchestcol3Inbound the blendchestcol3Inbound to set
	 */
	public void setBlendchestcol3Inbound(String blendchestcol3Inbound) {
		this.blendchestcol3Inbound = blendchestcol3Inbound;
	}

	/**
	 * @return the blendchestcol3Outbound
	 */
	public String getBlendchestcol3Outbound() {
		return blendchestcol3Outbound;
	}

	/**
	 * @param blendchestcol3Outbound the blendchestcol3Outbound to set
	 */
	public void setBlendchestcol3Outbound(String blendchestcol3Outbound) {
		this.blendchestcol3Outbound = blendchestcol3Outbound;
	}

	/**
	 * @return the machinechestcol1
	 */
	public String getMachinechestcol1() {
		return machinechestcol1;
	}

	/**
	 * @param machinechestcol1 the machinechestcol1 to set
	 */
	public void setMachinechestcol1(String machinechestcol1) {
		this.machinechestcol1 = machinechestcol1;
	}

	/**
	 * @return the machinechestcol2
	 */
	public boolean isMachinechestcol2() {
		return machinechestcol2;
	}

	/**
	 * @param machinechestcol2 the machinechestcol2 to set
	 */
	public void setMachinechestcol2(boolean machinechestcol2) {
		this.machinechestcol2 = machinechestcol2;
	}

	/**
	 * @return the machinechestcol3Inbound
	 */
	public String getMachinechestcol3Inbound() {
		return machinechestcol3Inbound;
	}

	/**
	 * @param machinechestcol3Inbound the machinechestcol3Inbound to set
	 */
	public void setMachinechestcol3Inbound(String machinechestcol3Inbound) {
		this.machinechestcol3Inbound = machinechestcol3Inbound;
	}

	/**
	 * @return the machinechestcol3Outbound
	 */
	public String getMachinechestcol3Outbound() {
		return machinechestcol3Outbound;
	}

	/**
	 * @param machinechestcol3Outbound the machinechestcol3Outbound to set
	 */
	public void setMachinechestcol3Outbound(String machinechestcol3Outbound) {
		this.machinechestcol3Outbound = machinechestcol3Outbound;
	}

	/**
	 * @return the machinechestcol4
	 */
	public boolean isMachinechestcol4() {
		return machinechestcol4;
	}

	/**
	 * @param machinechestcol4 the machinechestcol4 to set
	 */
	public void setMachinechestcol4(boolean machinechestcol4) {
		this.machinechestcol4 = machinechestcol4;
	}

	/**
	 * @return the machinechestcol5Inbound
	 */
	public String getMachinechestcol5Inbound() {
		return machinechestcol5Inbound;
	}

	/**
	 * @param machinechestcol5Inbound the machinechestcol5Inbound to set
	 */
	public void setMachinechestcol5Inbound(String machinechestcol5Inbound) {
		this.machinechestcol5Inbound = machinechestcol5Inbound;
	}

	/**
	 * @return the machinechestcol5Outbound
	 */
	public String getMachinechestcol5Outbound() {
		return machinechestcol5Outbound;
	}

	/**
	 * @param machinechestcol5Outbound the machinechestcol5Outbound to set
	 */
	public void setMachinechestcol5Outbound(String machinechestcol5Outbound) {
		this.machinechestcol5Outbound = machinechestcol5Outbound;
	}

	/**
	 * @return the couchpitcol1
	 */
	public boolean isCouchpitcol1() {
		return couchpitcol1;
	}

	/**
	 * @param couchpitcol1 the couchpitcol1 to set
	 */
	public void setCouchpitcol1(boolean couchpitcol1) {
		this.couchpitcol1 = couchpitcol1;
	}

	/**
	 * @return the couchpitcol2Inbound
	 */
	public String getCouchpitcol2Inbound() {
		return couchpitcol2Inbound;
	}

	/**
	 * @param couchpitcol2Inbound the couchpitcol2Inbound to set
	 */
	public void setCouchpitcol2Inbound(String couchpitcol2Inbound) {
		this.couchpitcol2Inbound = couchpitcol2Inbound;
	}

	/**
	 * @return the couchpitcol2Outbound
	 */
	public String getCouchpitcol2Outbound() {
		return couchpitcol2Outbound;
	}

	/**
	 * @param couchpitcol2Outbound the couchpitcol2Outbound to set
	 */
	public void setCouchpitcol2Outbound(String couchpitcol2Outbound) {
		this.couchpitcol2Outbound = couchpitcol2Outbound;
	}

	/**
	 * @return the couchpitcol3
	 */
	public boolean isCouchpitcol3() {
		return couchpitcol3;
	}

	/**
	 * @param couchpitcol3 the couchpitcol3 to set
	 */
	public void setCouchpitcol3(boolean couchpitcol3) {
		this.couchpitcol3 = couchpitcol3;
	}

	/**
	 * @return the couchpitcol4Inbound
	 */
	public String getCouchpitcol4Inbound() {
		return couchpitcol4Inbound;
	}

	/**
	 * @param couchpitcol4Inbound the couchpitcol4Inbound to set
	 */
	public void setCouchpitcol4Inbound(String couchpitcol4Inbound) {
		this.couchpitcol4Inbound = couchpitcol4Inbound;
	}

	/**
	 * @return the couchpitcol4Outbound
	 */
	public String getCouchpitcol4Outbound() {
		return couchpitcol4Outbound;
	}

	/**
	 * @param couchpitcol4Outbound the couchpitcol4Outbound to set
	 */
	public void setCouchpitcol4Outbound(String couchpitcol4Outbound) {
		this.couchpitcol4Outbound = couchpitcol4Outbound;
	}

	/**
	 * @return the couchpitcol5Inbound
	 */
	public String getCouchpitcol5Inbound() {
		return couchpitcol5Inbound;
	}

	/**
	 * @param couchpitcol5Inbound the couchpitcol5Inbound to set
	 */
	public void setCouchpitcol5Inbound(String couchpitcol5Inbound) {
		this.couchpitcol5Inbound = couchpitcol5Inbound;
	}

	/**
	 * @return the couchpitcol5Outbound
	 */
	public String getCouchpitcol5Outbound() {
		return couchpitcol5Outbound;
	}

	/**
	 * @param couchpitcol5Outbound the couchpitcol5Outbound to set
	 */
	public void setCouchpitcol5Outbound(String couchpitcol5Outbound) {
		this.couchpitcol5Outbound = couchpitcol5Outbound;
	}

	/**
	 * @return the couchpitcol6
	 */
	public boolean isCouchpitcol6() {
		return couchpitcol6;
	}

	/**
	 * @param couchpitcol6 the couchpitcol6 to set
	 */
	public void setCouchpitcol6(boolean couchpitcol6) {
		this.couchpitcol6 = couchpitcol6;
	}

	/**
	 * @return the cleanscannerheadcol1
	 */
	public boolean isCleanscannerheadcol1() {
		return cleanscannerheadcol1;
	}

	/**
	 * @param cleanscannerheadcol1 the cleanscannerheadcol1 to set
	 */
	public void setCleanscannerheadcol1(boolean cleanscannerheadcol1) {
		this.cleanscannerheadcol1 = cleanscannerheadcol1;
	}

	/**
	 * @return the cleanscannerheadcol1Desc
	 */
	public String getCleanscannerheadcol1Desc() {
		return cleanscannerheadcol1Desc;
	}

	/**
	 * @param cleanscannerheadcol1Desc the cleanscannerheadcol1Desc to set
	 */
	public void setCleanscannerheadcol1Desc(String cleanscannerheadcol1Desc) {
		this.cleanscannerheadcol1Desc = cleanscannerheadcol1Desc;
	}

	/**
	 * @return the spoolstarterworkingproperlycol1
	 */
	public boolean isSpoolstarterworkingproperlycol1() {
		return spoolstarterworkingproperlycol1;
	}

	/**
	 * @param spoolstarterworkingproperlycol1 the spoolstarterworkingproperlycol1 to set
	 */
	public void setSpoolstarterworkingproperlycol1(
			boolean spoolstarterworkingproperlycol1) {
		this.spoolstarterworkingproperlycol1 = spoolstarterworkingproperlycol1;
	}

	/**
	 * @return the spoolstarterworkingproperlycol1Desc
	 */
	public String getSpoolstarterworkingproperlycol1Desc() {
		return spoolstarterworkingproperlycol1Desc;
	}

	/**
	 * @param spoolstarterworkingproperlycol1Desc the spoolstarterworkingproperlycol1Desc to set
	 */
	public void setSpoolstarterworkingproperlycol1Desc(
			String spoolstarterworkingproperlycol1Desc) {
		this.spoolstarterworkingproperlycol1Desc = spoolstarterworkingproperlycol1Desc;
	}

	/**
	 * @return the beakpassacceptablecol1
	 */
	public boolean isBeakpassacceptablecol1() {
		return beakpassacceptablecol1;
	}

	/**
	 * @param beakpassacceptablecol1 the beakpassacceptablecol1 to set
	 */
	public void setBeakpassacceptablecol1(boolean beakpassacceptablecol1) {
		this.beakpassacceptablecol1 = beakpassacceptablecol1;
	}

	/**
	 * @return the beakpassacceptablecol1Desc
	 */
	public String getBeakpassacceptablecol1Desc() {
		return beakpassacceptablecol1Desc;
	}

	/**
	 * @param beakpassacceptablecol1Desc the beakpassacceptablecol1Desc to set
	 */
	public void setBeakpassacceptablecol1Desc(String beakpassacceptablecol1Desc) {
		this.beakpassacceptablecol1Desc = beakpassacceptablecol1Desc;
	}

	/**
	 * @return the fibersupplytankcol1Desc
	 */
	public String getFibersupplytankcol1Desc() {
		return fibersupplytankcol1Desc;
	}

	/**
	 * @param fibersupplytankcol1Desc the fibersupplytankcol1Desc to set
	 */
	public void setFibersupplytankcol1Desc(String fibersupplytankcol1Desc) {
		this.fibersupplytankcol1Desc = fibersupplytankcol1Desc;
	}

	/**
	 * @return the fibersupplytankcol2Desc
	 */
	public String getFibersupplytankcol2Desc() {
		return fibersupplytankcol2Desc;
	}

	/**
	 * @param fibersupplytankcol2Desc the fibersupplytankcol2Desc to set
	 */
	public void setFibersupplytankcol2Desc(String fibersupplytankcol2Desc) {
		this.fibersupplytankcol2Desc = fibersupplytankcol2Desc;
	}

	/**
	 * @return the fibersupplytankcol3Desc
	 */
	public String getFibersupplytankcol3Desc() {
		return fibersupplytankcol3Desc;
	}

	/**
	 * @param fibersupplytankcol3Desc the fibersupplytankcol3Desc to set
	 */
	public void setFibersupplytankcol3Desc(String fibersupplytankcol3Desc) {
		this.fibersupplytankcol3Desc = fibersupplytankcol3Desc;
	}

	/**
	 * @return the fibersupplytankcol4Desc
	 */
	public String getFibersupplytankcol4Desc() {
		return fibersupplytankcol4Desc;
	}

	/**
	 * @param fibersupplytankcol4Desc the fibersupplytankcol4Desc to set
	 */
	public void setFibersupplytankcol4Desc(String fibersupplytankcol4Desc) {
		this.fibersupplytankcol4Desc = fibersupplytankcol4Desc;
	}

	/**
	 * @return the fibersupplytankcol5Desc
	 */
	public String getFibersupplytankcol5Desc() {
		return fibersupplytankcol5Desc;
	}

	/**
	 * @param fibersupplytankcol5Desc the fibersupplytankcol5Desc to set
	 */
	public void setFibersupplytankcol5Desc(String fibersupplytankcol5Desc) {
		this.fibersupplytankcol5Desc = fibersupplytankcol5Desc;
	}

	/**
	 * @return the fibersupplytankcol6Desc
	 */
	public String getFibersupplytankcol6Desc() {
		return fibersupplytankcol6Desc;
	}

	/**
	 * @param fibersupplytankcol6Desc the fibersupplytankcol6Desc to set
	 */
	public void setFibersupplytankcol6Desc(String fibersupplytankcol6Desc) {
		this.fibersupplytankcol6Desc = fibersupplytankcol6Desc;
	}

	/**
	 * @return the mixchestcol1Desc
	 */
	public String getMixchestcol1Desc() {
		return mixchestcol1Desc;
	}

	/**
	 * @param mixchestcol1Desc the mixchestcol1Desc to set
	 */
	public void setMixchestcol1Desc(String mixchestcol1Desc) {
		this.mixchestcol1Desc = mixchestcol1Desc;
	}

	/**
	 * @return the mixchestcol2Desc
	 */
	public String getMixchestcol2Desc() {
		return mixchestcol2Desc;
	}

	/**
	 * @param mixchestcol2Desc the mixchestcol2Desc to set
	 */
	public void setMixchestcol2Desc(String mixchestcol2Desc) {
		this.mixchestcol2Desc = mixchestcol2Desc;
	}

	/**
	 * @return the mixchestcol3Desc
	 */
	public String getMixchestcol3Desc() {
		return mixchestcol3Desc;
	}

	/**
	 * @param mixchestcol3Desc the mixchestcol3Desc to set
	 */
	public void setMixchestcol3Desc(String mixchestcol3Desc) {
		this.mixchestcol3Desc = mixchestcol3Desc;
	}

	/**
	 * @return the mixchestcol4Desc
	 */
	public String getMixchestcol4Desc() {
		return mixchestcol4Desc;
	}

	/**
	 * @param mixchestcol4Desc the mixchestcol4Desc to set
	 */
	public void setMixchestcol4Desc(String mixchestcol4Desc) {
		this.mixchestcol4Desc = mixchestcol4Desc;
	}

	/**
	 * @return the mixchestcol5Desc
	 */
	public String getMixchestcol5Desc() {
		return mixchestcol5Desc;
	}

	/**
	 * @param mixchestcol5Desc the mixchestcol5Desc to set
	 */
	public void setMixchestcol5Desc(String mixchestcol5Desc) {
		this.mixchestcol5Desc = mixchestcol5Desc;
	}

	/**
	 * @return the blendchestcol1Desc
	 */
	public String getBlendchestcol1Desc() {
		return blendchestcol1Desc;
	}

	/**
	 * @param blendchestcol1Desc the blendchestcol1Desc to set
	 */
	public void setBlendchestcol1Desc(String blendchestcol1Desc) {
		this.blendchestcol1Desc = blendchestcol1Desc;
	}

	/**
	 * @return the blendchestcol2Desc
	 */
	public String getBlendchestcol2Desc() {
		return blendchestcol2Desc;
	}

	/**
	 * @param blendchestcol2Desc the blendchestcol2Desc to set
	 */
	public void setBlendchestcol2Desc(String blendchestcol2Desc) {
		this.blendchestcol2Desc = blendchestcol2Desc;
	}

	/**
	 * @return the blendchestcol3Desc
	 */
	public String getBlendchestcol3Desc() {
		return blendchestcol3Desc;
	}

	/**
	 * @param blendchestcol3Desc the blendchestcol3Desc to set
	 */
	public void setBlendchestcol3Desc(String blendchestcol3Desc) {
		this.blendchestcol3Desc = blendchestcol3Desc;
	}

	/**
	 * @return the machinechestcol1Desc
	 */
	public String getMachinechestcol1Desc() {
		return machinechestcol1Desc;
	}

	/**
	 * @param machinechestcol1Desc the machinechestcol1Desc to set
	 */
	public void setMachinechestcol1Desc(String machinechestcol1Desc) {
		this.machinechestcol1Desc = machinechestcol1Desc;
	}

	/**
	 * @return the machinechestcol2Desc
	 */
	public String getMachinechestcol2Desc() {
		return machinechestcol2Desc;
	}

	/**
	 * @param machinechestcol2Desc the machinechestcol2Desc to set
	 */
	public void setMachinechestcol2Desc(String machinechestcol2Desc) {
		this.machinechestcol2Desc = machinechestcol2Desc;
	}

	/**
	 * @return the machinechestcol3Desc
	 */
	public String getMachinechestcol3Desc() {
		return machinechestcol3Desc;
	}

	/**
	 * @param machinechestcol3Desc the machinechestcol3Desc to set
	 */
	public void setMachinechestcol3Desc(String machinechestcol3Desc) {
		this.machinechestcol3Desc = machinechestcol3Desc;
	}

	/**
	 * @return the machinechestcol4Desc
	 */
	public String getMachinechestcol4Desc() {
		return machinechestcol4Desc;
	}

	/**
	 * @param machinechestcol4Desc the machinechestcol4Desc to set
	 */
	public void setMachinechestcol4Desc(String machinechestcol4Desc) {
		this.machinechestcol4Desc = machinechestcol4Desc;
	}

	/**
	 * @return the machinechestcol5Desc
	 */
	public String getMachinechestcol5Desc() {
		return machinechestcol5Desc;
	}

	/**
	 * @param machinechestcol5Desc the machinechestcol5Desc to set
	 */
	public void setMachinechestcol5Desc(String machinechestcol5Desc) {
		this.machinechestcol5Desc = machinechestcol5Desc;
	}

	/**
	 * @return the couchpitcol1Desc
	 */
	public String getCouchpitcol1Desc() {
		return couchpitcol1Desc;
	}

	/**
	 * @param couchpitcol1Desc the couchpitcol1Desc to set
	 */
	public void setCouchpitcol1Desc(String couchpitcol1Desc) {
		this.couchpitcol1Desc = couchpitcol1Desc;
	}

	/**
	 * @return the couchpitcol2Desc
	 */
	public String getCouchpitcol2Desc() {
		return couchpitcol2Desc;
	}

	/**
	 * @param couchpitcol2Desc the couchpitcol2Desc to set
	 */
	public void setCouchpitcol2Desc(String couchpitcol2Desc) {
		this.couchpitcol2Desc = couchpitcol2Desc;
	}

	/**
	 * @return the couchpitcol3Desc
	 */
	public String getCouchpitcol3Desc() {
		return couchpitcol3Desc;
	}

	/**
	 * @param couchpitcol3Desc the couchpitcol3Desc to set
	 */
	public void setCouchpitcol3Desc(String couchpitcol3Desc) {
		this.couchpitcol3Desc = couchpitcol3Desc;
	}

	/**
	 * @return the couchpitcol4Desc
	 */
	public String getCouchpitcol4Desc() {
		return couchpitcol4Desc;
	}

	/**
	 * @param couchpitcol4Desc the couchpitcol4Desc to set
	 */
	public void setCouchpitcol4Desc(String couchpitcol4Desc) {
		this.couchpitcol4Desc = couchpitcol4Desc;
	}

	/**
	 * @return the couchpitcol5Desc
	 */
	public String getCouchpitcol5Desc() {
		return couchpitcol5Desc;
	}

	/**
	 * @param couchpitcol5Desc the couchpitcol5Desc to set
	 */
	public void setCouchpitcol5Desc(String couchpitcol5Desc) {
		this.couchpitcol5Desc = couchpitcol5Desc;
	}

	/**
	 * @return the couchpitcol6Desc
	 */
	public String getCouchpitcol6Desc() {
		return couchpitcol6Desc;
	}

	/**
	 * @param couchpitcol6Desc the couchpitcol6Desc to set
	 */
	public void setCouchpitcol6Desc(String couchpitcol6Desc) {
		this.couchpitcol6Desc = couchpitcol6Desc;
	}

	/**
	 * @return the refiner1col1
	 */
	public boolean isRefiner1col1() {
		return refiner1col1;
	}

	/**
	 * @param refiner1col1 the refiner1col1 to set
	 */
	public void setRefiner1col1(boolean refiner1col1) {
		this.refiner1col1 = refiner1col1;
	}

	/**
	 * @return the refiner1col1Desc
	 */
	public String getRefiner1col1Desc() {
		return refiner1col1Desc;
	}

	/**
	 * @param refiner1col1Desc the refiner1col1Desc to set
	 */
	public void setRefiner1col1Desc(String refiner1col1Desc) {
		this.refiner1col1Desc = refiner1col1Desc;
	}

	/**
	 * @return the refiner1col2Inbound
	 */
	public String getRefiner1col2Inbound() {
		return refiner1col2Inbound;
	}

	/**
	 * @param refiner1col2Inbound the refiner1col2Inbound to set
	 */
	public void setRefiner1col2Inbound(String refiner1col2Inbound) {
		this.refiner1col2Inbound = refiner1col2Inbound;
	}

	/**
	 * @return the refiner1col2Outbound
	 */
	public String getRefiner1col2Outbound() {
		return refiner1col2Outbound;
	}

	/**
	 * @param refiner1col2Outbound the refiner1col2Outbound to set
	 */
	public void setRefiner1col2Outbound(String refiner1col2Outbound) {
		this.refiner1col2Outbound = refiner1col2Outbound;
	}

	/**
	 * @return the refiner1col2Desc
	 */
	public String getRefiner1col2Desc() {
		return refiner1col2Desc;
	}

	/**
	 * @param refiner1col2Desc the refiner1col2Desc to set
	 */
	public void setRefiner1col2Desc(String refiner1col2Desc) {
		this.refiner1col2Desc = refiner1col2Desc;
	}

	/**
	 * @return the refiner1col3
	 */
	public String getRefiner1col3() {
		return refiner1col3;
	}

	/**
	 * @param refiner1col3 the refiner1col3 to set
	 */
	public void setRefiner1col3(String refiner1col3) {
		this.refiner1col3 = refiner1col3;
	}

	/**
	 * @return the refiner1col3Desc
	 */
	public String getRefiner1col3Desc() {
		return refiner1col3Desc;
	}

	/**
	 * @param refiner1col3Desc the refiner1col3Desc to set
	 */
	public void setRefiner1col3Desc(String refiner1col3Desc) {
		this.refiner1col3Desc = refiner1col3Desc;
	}

	/**
	 * @return the refiner1col4
	 */
	public String getRefiner1col4() {
		return refiner1col4;
	}

	/**
	 * @param refiner1col4 the refiner1col4 to set
	 */
	public void setRefiner1col4(String refiner1col4) {
		this.refiner1col4 = refiner1col4;
	}

	/**
	 * @return the refiner1col4Desc
	 */
	public String getRefiner1col4Desc() {
		return refiner1col4Desc;
	}

	/**
	 * @param refiner1col4Desc the refiner1col4Desc to set
	 */
	public void setRefiner1col4Desc(String refiner1col4Desc) {
		this.refiner1col4Desc = refiner1col4Desc;
	}

	/**
	 * @return the refiner2col1
	 */
	public boolean isRefiner2col1() {
		return refiner2col1;
	}

	/**
	 * @param refiner2col1 the refiner2col1 to set
	 */
	public void setRefiner2col1(boolean refiner2col1) {
		this.refiner2col1 = refiner2col1;
	}

	/**
	 * @return the refiner2col1Desc
	 */
	public String getRefiner2col1Desc() {
		return refiner2col1Desc;
	}

	/**
	 * @param refiner2col1Desc the refiner2col1Desc to set
	 */
	public void setRefiner2col1Desc(String refiner2col1Desc) {
		this.refiner2col1Desc = refiner2col1Desc;
	}

	/**
	 * @return the refiner2col2Inbound
	 */
	public String getRefiner2col2Inbound() {
		return refiner2col2Inbound;
	}

	/**
	 * @param refiner2col2Inbound the refiner2col2Inbound to set
	 */
	public void setRefiner2col2Inbound(String refiner2col2Inbound) {
		this.refiner2col2Inbound = refiner2col2Inbound;
	}

	/**
	 * @return the refiner2col2Outbound
	 */
	public String getRefiner2col2Outbound() {
		return refiner2col2Outbound;
	}

	/**
	 * @param refiner2col2Outbound the refiner2col2Outbound to set
	 */
	public void setRefiner2col2Outbound(String refiner2col2Outbound) {
		this.refiner2col2Outbound = refiner2col2Outbound;
	}

	/**
	 * @return the refiner2col2Desc
	 */
	public String getRefiner2col2Desc() {
		return refiner2col2Desc;
	}

	/**
	 * @param refiner2col2Desc the refiner2col2Desc to set
	 */
	public void setRefiner2col2Desc(String refiner2col2Desc) {
		this.refiner2col2Desc = refiner2col2Desc;
	}

	/**
	 * @return the refiner2col3
	 */
	public String getRefiner2col3() {
		return refiner2col3;
	}

	/**
	 * @param refiner2col3 the refiner2col3 to set
	 */
	public void setRefiner2col3(String refiner2col3) {
		this.refiner2col3 = refiner2col3;
	}

	/**
	 * @return the refiner2col3Desc
	 */
	public String getRefiner2col3Desc() {
		return refiner2col3Desc;
	}

	/**
	 * @param refiner2col3Desc the refiner2col3Desc to set
	 */
	public void setRefiner2col3Desc(String refiner2col3Desc) {
		this.refiner2col3Desc = refiner2col3Desc;
	}

	/**
	 * @return the refiner2col4
	 */
	public String getRefiner2col4() {
		return refiner2col4;
	}

	/**
	 * @param refiner2col4 the refiner2col4 to set
	 */
	public void setRefiner2col4(String refiner2col4) {
		this.refiner2col4 = refiner2col4;
	}

	/**
	 * @return the refiner2col4Desc
	 */
	public String getRefiner2col4Desc() {
		return refiner2col4Desc;
	}

	/**
	 * @param refiner2col4Desc the refiner2col4Desc to set
	 */
	public void setRefiner2col4Desc(String refiner2col4Desc) {
		this.refiner2col4Desc = refiner2col4Desc;
	}

	/**
	 * @return the whitewaterpumpscol1
	 */
	public boolean isWhitewaterpumpscol1() {
		return whitewaterpumpscol1;
	}

	/**
	 * @param whitewaterpumpscol1 the whitewaterpumpscol1 to set
	 */
	public void setWhitewaterpumpscol1(boolean whitewaterpumpscol1) {
		this.whitewaterpumpscol1 = whitewaterpumpscol1;
	}

	/**
	 * @return the whitewaterpumpscol1Desc
	 */
	public String getWhitewaterpumpscol1Desc() {
		return whitewaterpumpscol1Desc;
	}

	/**
	 * @param whitewaterpumpscol1Desc the whitewaterpumpscol1Desc to set
	 */
	public void setWhitewaterpumpscol1Desc(String whitewaterpumpscol1Desc) {
		this.whitewaterpumpscol1Desc = whitewaterpumpscol1Desc;
	}

	/**
	 * @return the whitewaterpumpscol2Inbound
	 */
	public String getWhitewaterpumpscol2Inbound() {
		return whitewaterpumpscol2Inbound;
	}

	/**
	 * @param whitewaterpumpscol2Inbound the whitewaterpumpscol2Inbound to set
	 */
	public void setWhitewaterpumpscol2Inbound(String whitewaterpumpscol2Inbound) {
		this.whitewaterpumpscol2Inbound = whitewaterpumpscol2Inbound;
	}

	/**
	 * @return the whitewaterpumpscol2Outbound
	 */
	public String getWhitewaterpumpscol2Outbound() {
		return whitewaterpumpscol2Outbound;
	}

	/**
	 * @param whitewaterpumpscol2Outbound the whitewaterpumpscol2Outbound to set
	 */
	public void setWhitewaterpumpscol2Outbound(String whitewaterpumpscol2Outbound) {
		this.whitewaterpumpscol2Outbound = whitewaterpumpscol2Outbound;
	}

	/**
	 * @return the whitewaterpumpscol2Desc
	 */
	public String getWhitewaterpumpscol2Desc() {
		return whitewaterpumpscol2Desc;
	}

	/**
	 * @param whitewaterpumpscol2Desc the whitewaterpumpscol2Desc to set
	 */
	public void setWhitewaterpumpscol2Desc(String whitewaterpumpscol2Desc) {
		this.whitewaterpumpscol2Desc = whitewaterpumpscol2Desc;
	}

	/**
	 * @return the whitewaterpumpscol3
	 */
	public boolean isWhitewaterpumpscol3() {
		return whitewaterpumpscol3;
	}

	/**
	 * @param whitewaterpumpscol3 the whitewaterpumpscol3 to set
	 */
	public void setWhitewaterpumpscol3(boolean whitewaterpumpscol3) {
		this.whitewaterpumpscol3 = whitewaterpumpscol3;
	}

	/**
	 * @return the whitewaterpumpscol3Desc
	 */
	public String getWhitewaterpumpscol3Desc() {
		return whitewaterpumpscol3Desc;
	}

	/**
	 * @param whitewaterpumpscol3Desc the whitewaterpumpscol3Desc to set
	 */
	public void setWhitewaterpumpscol3Desc(String whitewaterpumpscol3Desc) {
		this.whitewaterpumpscol3Desc = whitewaterpumpscol3Desc;
	}

	/**
	 * @return the whitewaterpumpscol4Inbound
	 */
	public String getWhitewaterpumpscol4Inbound() {
		return whitewaterpumpscol4Inbound;
	}

	/**
	 * @param whitewaterpumpscol4Inbound the whitewaterpumpscol4Inbound to set
	 */
	public void setWhitewaterpumpscol4Inbound(String whitewaterpumpscol4Inbound) {
		this.whitewaterpumpscol4Inbound = whitewaterpumpscol4Inbound;
	}

	/**
	 * @return the whitewaterpumpscol4Outbound
	 */
	public String getWhitewaterpumpscol4Outbound() {
		return whitewaterpumpscol4Outbound;
	}

	/**
	 * @param whitewaterpumpscol4Outbound the whitewaterpumpscol4Outbound to set
	 */
	public void setWhitewaterpumpscol4Outbound(String whitewaterpumpscol4Outbound) {
		this.whitewaterpumpscol4Outbound = whitewaterpumpscol4Outbound;
	}

	/**
	 * @return the whitewaterpumpscol4Desc
	 */
	public String getWhitewaterpumpscol4Desc() {
		return whitewaterpumpscol4Desc;
	}

	/**
	 * @param whitewaterpumpscol4Desc the whitewaterpumpscol4Desc to set
	 */
	public void setWhitewaterpumpscol4Desc(String whitewaterpumpscol4Desc) {
		this.whitewaterpumpscol4Desc = whitewaterpumpscol4Desc;
	}

	/**
	 * @return the whitewaterpumpscol5
	 */
	public String getWhitewaterpumpscol5() {
		return whitewaterpumpscol5;
	}

	/**
	 * @param whitewaterpumpscol5 the whitewaterpumpscol5 to set
	 */
	public void setWhitewaterpumpscol5(String whitewaterpumpscol5) {
		this.whitewaterpumpscol5 = whitewaterpumpscol5;
	}

	/**
	 * @return the whitewaterpumpscol5Desc
	 */
	public String getWhitewaterpumpscol5Desc() {
		return whitewaterpumpscol5Desc;
	}

	/**
	 * @param whitewaterpumpscol5Desc the whitewaterpumpscol5Desc to set
	 */
	public void setWhitewaterpumpscol5Desc(String whitewaterpumpscol5Desc) {
		this.whitewaterpumpscol5Desc = whitewaterpumpscol5Desc;
	}

	/**
	 * @return the whitewaterpumpscol6
	 */
	public String getWhitewaterpumpscol6() {
		return whitewaterpumpscol6;
	}

	/**
	 * @param whitewaterpumpscol6 the whitewaterpumpscol6 to set
	 */
	public void setWhitewaterpumpscol6(String whitewaterpumpscol6) {
		this.whitewaterpumpscol6 = whitewaterpumpscol6;
	}

	/**
	 * @return the whitewaterpumpscol6Desc
	 */
	public String getWhitewaterpumpscol6Desc() {
		return whitewaterpumpscol6Desc;
	}

	/**
	 * @param whitewaterpumpscol6Desc the whitewaterpumpscol6Desc to set
	 */
	public void setWhitewaterpumpscol6Desc(String whitewaterpumpscol6Desc) {
		this.whitewaterpumpscol6Desc = whitewaterpumpscol6Desc;
	}

	/**
	 * @return the whitewaterpumpscol7
	 */
	public String getWhitewaterpumpscol7() {
		return whitewaterpumpscol7;
	}

	/**
	 * @param whitewaterpumpscol7 the whitewaterpumpscol7 to set
	 */
	public void setWhitewaterpumpscol7(String whitewaterpumpscol7) {
		this.whitewaterpumpscol7 = whitewaterpumpscol7;
	}

	/**
	 * @return the whitewaterpumpscol7Desc
	 */
	public String getWhitewaterpumpscol7Desc() {
		return whitewaterpumpscol7Desc;
	}

	/**
	 * @param whitewaterpumpscol7Desc the whitewaterpumpscol7Desc to set
	 */
	public void setWhitewaterpumpscol7Desc(String whitewaterpumpscol7Desc) {
		this.whitewaterpumpscol7Desc = whitewaterpumpscol7Desc;
	}

	/**
	 * @return the yankeepulpercol1
	 */
	public boolean isYankeepulpercol1() {
		return yankeepulpercol1;
	}

	/**
	 * @param yankeepulpercol1 the yankeepulpercol1 to set
	 */
	public void setYankeepulpercol1(boolean yankeepulpercol1) {
		this.yankeepulpercol1 = yankeepulpercol1;
	}

	/**
	 * @return the yankeepulpercol1Desc
	 */
	public String getYankeepulpercol1Desc() {
		return yankeepulpercol1Desc;
	}

	/**
	 * @param yankeepulpercol1Desc the yankeepulpercol1Desc to set
	 */
	public void setYankeepulpercol1Desc(String yankeepulpercol1Desc) {
		this.yankeepulpercol1Desc = yankeepulpercol1Desc;
	}

	/**
	 * @return the yankeepulpercol2Inbound
	 */
	public String getYankeepulpercol2Inbound() {
		return yankeepulpercol2Inbound;
	}

	/**
	 * @param yankeepulpercol2Inbound the yankeepulpercol2Inbound to set
	 */
	public void setYankeepulpercol2Inbound(String yankeepulpercol2Inbound) {
		this.yankeepulpercol2Inbound = yankeepulpercol2Inbound;
	}

	/**
	 * @return the yankeepulpercol2Outbound
	 */
	public String getYankeepulpercol2Outbound() {
		return yankeepulpercol2Outbound;
	}

	/**
	 * @param yankeepulpercol2Outbound the yankeepulpercol2Outbound to set
	 */
	public void setYankeepulpercol2Outbound(String yankeepulpercol2Outbound) {
		this.yankeepulpercol2Outbound = yankeepulpercol2Outbound;
	}

	/**
	 * @return the yankeepulpercol2Desc
	 */
	public String getYankeepulpercol2Desc() {
		return yankeepulpercol2Desc;
	}

	/**
	 * @param yankeepulpercol2Desc the yankeepulpercol2Desc to set
	 */
	public void setYankeepulpercol2Desc(String yankeepulpercol2Desc) {
		this.yankeepulpercol2Desc = yankeepulpercol2Desc;
	}

	/**
	 * @return the yankeepulpercol3
	 */
	public boolean isYankeepulpercol3() {
		return yankeepulpercol3;
	}

	/**
	 * @param yankeepulpercol3 the yankeepulpercol3 to set
	 */
	public void setYankeepulpercol3(boolean yankeepulpercol3) {
		this.yankeepulpercol3 = yankeepulpercol3;
	}

	/**
	 * @return the yankeepulpercol3Desc
	 */
	public String getYankeepulpercol3Desc() {
		return yankeepulpercol3Desc;
	}

	/**
	 * @param yankeepulpercol3Desc the yankeepulpercol3Desc to set
	 */
	public void setYankeepulpercol3Desc(String yankeepulpercol3Desc) {
		this.yankeepulpercol3Desc = yankeepulpercol3Desc;
	}

	/**
	 * @return the yankeepulpercol4Inbound
	 */
	public String getYankeepulpercol4Inbound() {
		return yankeepulpercol4Inbound;
	}

	/**
	 * @param yankeepulpercol4Inbound the yankeepulpercol4Inbound to set
	 */
	public void setYankeepulpercol4Inbound(String yankeepulpercol4Inbound) {
		this.yankeepulpercol4Inbound = yankeepulpercol4Inbound;
	}

	/**
	 * @return the yankeepulpercol4Outbound
	 */
	public String getYankeepulpercol4Outbound() {
		return yankeepulpercol4Outbound;
	}

	/**
	 * @param yankeepulpercol4Outbound the yankeepulpercol4Outbound to set
	 */
	public void setYankeepulpercol4Outbound(String yankeepulpercol4Outbound) {
		this.yankeepulpercol4Outbound = yankeepulpercol4Outbound;
	}

	/**
	 * @return the yankeepulpercol4Desc
	 */
	public String getYankeepulpercol4Desc() {
		return yankeepulpercol4Desc;
	}

	/**
	 * @param yankeepulpercol4Desc the yankeepulpercol4Desc to set
	 */
	public void setYankeepulpercol4Desc(String yankeepulpercol4Desc) {
		this.yankeepulpercol4Desc = yankeepulpercol4Desc;
	}

	/**
	 * @return the yankeepulpercol5
	 */
	public boolean isYankeepulpercol5() {
		return yankeepulpercol5;
	}

	/**
	 * @param yankeepulpercol5 the yankeepulpercol5 to set
	 */
	public void setYankeepulpercol5(boolean yankeepulpercol5) {
		this.yankeepulpercol5 = yankeepulpercol5;
	}

	/**
	 * @return the yankeepulpercol5Desc
	 */
	public String getYankeepulpercol5Desc() {
		return yankeepulpercol5Desc;
	}

	/**
	 * @param yankeepulpercol5Desc the yankeepulpercol5Desc to set
	 */
	public void setYankeepulpercol5Desc(String yankeepulpercol5Desc) {
		this.yankeepulpercol5Desc = yankeepulpercol5Desc;
	}

	/**
	 * @return the yankeepulpercol6Inbound
	 */
	public String getYankeepulpercol6Inbound() {
		return yankeepulpercol6Inbound;
	}

	/**
	 * @param yankeepulpercol6Inbound the yankeepulpercol6Inbound to set
	 */
	public void setYankeepulpercol6Inbound(String yankeepulpercol6Inbound) {
		this.yankeepulpercol6Inbound = yankeepulpercol6Inbound;
	}

	/**
	 * @return the yankeepulpercol6Outbound
	 */
	public String getYankeepulpercol6Outbound() {
		return yankeepulpercol6Outbound;
	}

	/**
	 * @param yankeepulpercol6Outbound the yankeepulpercol6Outbound to set
	 */
	public void setYankeepulpercol6Outbound(String yankeepulpercol6Outbound) {
		this.yankeepulpercol6Outbound = yankeepulpercol6Outbound;
	}

	/**
	 * @return the yankeepulpercol6Desc
	 */
	public String getYankeepulpercol6Desc() {
		return yankeepulpercol6Desc;
	}

	/**
	 * @param yankeepulpercol6Desc the yankeepulpercol6Desc to set
	 */
	public void setYankeepulpercol6Desc(String yankeepulpercol6Desc) {
		this.yankeepulpercol6Desc = yankeepulpercol6Desc;
	}

	
	
	/**
	 * @return the borkechestcol1
	 */
	public boolean isBorkechestcol1() {
		return borkechestcol1;
	}

	/**
	 * @param borkechestcol1 the borkechestcol1 to set
	 */
	public void setBorkechestcol1(boolean borkechestcol1) {
		this.borkechestcol1 = borkechestcol1;
	}

	/**
	 * @return the borkechestcol1Desc
	 */
	public String getBorkechestcol1Desc() {
		return borkechestcol1Desc;
	}

	/**
	 * @param borkechestcol1Desc the borkechestcol1Desc to set
	 */
	public void setBorkechestcol1Desc(String borkechestcol1Desc) {
		this.borkechestcol1Desc = borkechestcol1Desc;
	}

	/**
	 * @return the borkechestcol2Inbound
	 */
	public String getBorkechestcol2Inbound() {
		return borkechestcol2Inbound;
	}

	/**
	 * @param borkechestcol2Inbound the borkechestcol2Inbound to set
	 */
	public void setBorkechestcol2Inbound(String borkechestcol2Inbound) {
		this.borkechestcol2Inbound = borkechestcol2Inbound;
	}

	/**
	 * @return the borkechestcol2Outbound
	 */
	public String getBorkechestcol2Outbound() {
		return borkechestcol2Outbound;
	}

	/**
	 * @param borkechestcol2Outbound the borkechestcol2Outbound to set
	 */
	public void setBorkechestcol2Outbound(String borkechestcol2Outbound) {
		this.borkechestcol2Outbound = borkechestcol2Outbound;
	}

	/**
	 * @return the borkechestcol2Desc
	 */
	public String getBorkechestcol2Desc() {
		return borkechestcol2Desc;
	}

	/**
	 * @param borkechestcol2Desc the borkechestcol2Desc to set
	 */
	public void setBorkechestcol2Desc(String borkechestcol2Desc) {
		this.borkechestcol2Desc = borkechestcol2Desc;
	}

	/**
	 * @return the borkechestcol3
	 */
	public boolean isBorkechestcol3() {
		return borkechestcol3;
	}

	/**
	 * @param borkechestcol3 the borkechestcol3 to set
	 */
	public void setBorkechestcol3(boolean borkechestcol3) {
		this.borkechestcol3 = borkechestcol3;
	}

	/**
	 * @return the borkechestcol3Desc
	 */
	public String getBorkechestcol3Desc() {
		return borkechestcol3Desc;
	}

	/**
	 * @param borkechestcol3Desc the borkechestcol3Desc to set
	 */
	public void setBorkechestcol3Desc(String borkechestcol3Desc) {
		this.borkechestcol3Desc = borkechestcol3Desc;
	}

	/**
	 * @return the borkechestcol4Inbound
	 */
	public String getBorkechestcol4Inbound() {
		return borkechestcol4Inbound;
	}

	/**
	 * @param borkechestcol4Inbound the borkechestcol4Inbound to set
	 */
	public void setBorkechestcol4Inbound(String borkechestcol4Inbound) {
		this.borkechestcol4Inbound = borkechestcol4Inbound;
	}

	/**
	 * @return the borkechestcol4Outbound
	 */
	public String getBorkechestcol4Outbound() {
		return borkechestcol4Outbound;
	}

	/**
	 * @param borkechestcol4Outbound the borkechestcol4Outbound to set
	 */
	public void setBorkechestcol4Outbound(String borkechestcol4Outbound) {
		this.borkechestcol4Outbound = borkechestcol4Outbound;
	}

	/**
	 * @return the borkechestcol4Desc
	 */
	public String getBorkechestcol4Desc() {
		return borkechestcol4Desc;
	}

	/**
	 * @param borkechestcol4Desc the borkechestcol4Desc to set
	 */
	public void setBorkechestcol4Desc(String borkechestcol4Desc) {
		this.borkechestcol4Desc = borkechestcol4Desc;
	}

	/**
	 * @return the saveallcol1
	 */
	public String getSaveallcol1() {
		return saveallcol1;
	}

	/**
	 * @param saveallcol1 the saveallcol1 to set
	 */
	public void setSaveallcol1(String saveallcol1) {
		this.saveallcol1 = saveallcol1;
	}

	/**
	 * @return the saveallcol1Desc
	 */
	public String getSaveallcol1Desc() {
		return saveallcol1Desc;
	}

	/**
	 * @param saveallcol1Desc the saveallcol1Desc to set
	 */
	public void setSaveallcol1Desc(String saveallcol1Desc) {
		this.saveallcol1Desc = saveallcol1Desc;
	}

	/**
	 * @return the saveallcol2
	 */
	public String getSaveallcol2() {
		return saveallcol2;
	}

	/**
	 * @param saveallcol2 the saveallcol2 to set
	 */
	public void setSaveallcol2(String saveallcol2) {
		this.saveallcol2 = saveallcol2;
	}

	/**
	 * @return the saveallcol2Desc
	 */
	public String getSaveallcol2Desc() {
		return saveallcol2Desc;
	}

	/**
	 * @param saveallcol2Desc the saveallcol2Desc to set
	 */
	public void setSaveallcol2Desc(String saveallcol2Desc) {
		this.saveallcol2Desc = saveallcol2Desc;
	}

	/**
	 * @return the saveallcol3
	 */
	public boolean isSaveallcol3() {
		return saveallcol3;
	}

	/**
	 * @param saveallcol3 the saveallcol3 to set
	 */
	public void setSaveallcol3(boolean saveallcol3) {
		this.saveallcol3 = saveallcol3;
	}

	/**
	 * @return the saveallcol3Desc
	 */
	public String getSaveallcol3Desc() {
		return saveallcol3Desc;
	}

	/**
	 * @param saveallcol3Desc the saveallcol3Desc to set
	 */
	public void setSaveallcol3Desc(String saveallcol3Desc) {
		this.saveallcol3Desc = saveallcol3Desc;
	}

	/**
	 * @return the saveallcol4Inbound
	 */
	public String getSaveallcol4Inbound() {
		return saveallcol4Inbound;
	}

	/**
	 * @param saveallcol4Inbound the saveallcol4Inbound to set
	 */
	public void setSaveallcol4Inbound(String saveallcol4Inbound) {
		this.saveallcol4Inbound = saveallcol4Inbound;
	}

	/**
	 * @return the saveallcol4Outbound
	 */
	public String getSaveallcol4Outbound() {
		return saveallcol4Outbound;
	}

	/**
	 * @param saveallcol4Outbound the saveallcol4Outbound to set
	 */
	public void setSaveallcol4Outbound(String saveallcol4Outbound) {
		this.saveallcol4Outbound = saveallcol4Outbound;
	}

	/**
	 * @return the saveallcol4Desc
	 */
	public String getSaveallcol4Desc() {
		return saveallcol4Desc;
	}

	/**
	 * @param saveallcol4Desc the saveallcol4Desc to set
	 */
	public void setSaveallcol4Desc(String saveallcol4Desc) {
		this.saveallcol4Desc = saveallcol4Desc;
	}

	/**
	 * @return the sydrapulpercol1Inbound
	 */
	public String getSydrapulpercol1Inbound() {
		return sydrapulpercol1Inbound;
	}

	/**
	 * @param sydrapulpercol1Inbound the sydrapulpercol1Inbound to set
	 */
	public void setSydrapulpercol1Inbound(String sydrapulpercol1Inbound) {
		this.sydrapulpercol1Inbound = sydrapulpercol1Inbound;
	}

	/**
	 * @return the sydrapulpercol1Outbound
	 */
	public String getSydrapulpercol1Outbound() {
		return sydrapulpercol1Outbound;
	}

	/**
	 * @param sydrapulpercol1Outbound the sydrapulpercol1Outbound to set
	 */
	public void setSydrapulpercol1Outbound(String sydrapulpercol1Outbound) {
		this.sydrapulpercol1Outbound = sydrapulpercol1Outbound;
	}

	/**
	 * @return the sydrapulpercol1Desc
	 */
	public String getSydrapulpercol1Desc() {
		return sydrapulpercol1Desc;
	}

	/**
	 * @param sydrapulpercol1Desc the sydrapulpercol1Desc to set
	 */
	public void setSydrapulpercol1Desc(String sydrapulpercol1Desc) {
		this.sydrapulpercol1Desc = sydrapulpercol1Desc;
	}

	/**
	 * @return the sydrapulpercol2
	 */
	public String getSydrapulpercol2() {
		return sydrapulpercol2;
	}

	/**
	 * @param sydrapulpercol2 the sydrapulpercol2 to set
	 */
	public void setSydrapulpercol2(String sydrapulpercol2) {
		this.sydrapulpercol2 = sydrapulpercol2;
	}

	/**
	 * @return the sydrapulpercol2Desc
	 */
	public String getSydrapulpercol2Desc() {
		return sydrapulpercol2Desc;
	}

	/**
	 * @param sydrapulpercol2Desc the sydrapulpercol2Desc to set
	 */
	public void setSydrapulpercol2Desc(String sydrapulpercol2Desc) {
		this.sydrapulpercol2Desc = sydrapulpercol2Desc;
	}

	/**
	 * @return the sydrapulpercol3
	 */
	public boolean isSydrapulpercol3() {
		return sydrapulpercol3;
	}

	/**
	 * @param sydrapulpercol3 the sydrapulpercol3 to set
	 */
	public void setSydrapulpercol3(boolean sydrapulpercol3) {
		this.sydrapulpercol3 = sydrapulpercol3;
	}

	/**
	 * @return the sydrapulpercol3Desc
	 */
	public String getSydrapulpercol3Desc() {
		return sydrapulpercol3Desc;
	}

	/**
	 * @param sydrapulpercol3Desc the sydrapulpercol3Desc to set
	 */
	public void setSydrapulpercol3Desc(String sydrapulpercol3Desc) {
		this.sydrapulpercol3Desc = sydrapulpercol3Desc;
	}

	/**
	 * @return the sydrapulpercol4Inbound
	 */
	public String getSydrapulpercol4Inbound() {
		return sydrapulpercol4Inbound;
	}

	/**
	 * @param sydrapulpercol4Inbound the sydrapulpercol4Inbound to set
	 */
	public void setSydrapulpercol4Inbound(String sydrapulpercol4Inbound) {
		this.sydrapulpercol4Inbound = sydrapulpercol4Inbound;
	}

	/**
	 * @return the sydrapulpercol4Outbound
	 */
	public String getSydrapulpercol4Outbound() {
		return sydrapulpercol4Outbound;
	}

	/**
	 * @param sydrapulpercol4Outbound the sydrapulpercol4Outbound to set
	 */
	public void setSydrapulpercol4Outbound(String sydrapulpercol4Outbound) {
		this.sydrapulpercol4Outbound = sydrapulpercol4Outbound;
	}

	/**
	 * @return the sydrapulpercol4Desc
	 */
	public String getSydrapulpercol4Desc() {
		return sydrapulpercol4Desc;
	}

	/**
	 * @param sydrapulpercol4Desc the sydrapulpercol4Desc to set
	 */
	public void setSydrapulpercol4Desc(String sydrapulpercol4Desc) {
		this.sydrapulpercol4Desc = sydrapulpercol4Desc;
	}

	/**
	 * @return the sydrapulpercol5
	 */
	public String getSydrapulpercol5() {
		return sydrapulpercol5;
	}

	/**
	 * @param sydrapulpercol5 the sydrapulpercol5 to set
	 */
	public void setSydrapulpercol5(String sydrapulpercol5) {
		this.sydrapulpercol5 = sydrapulpercol5;
	}

	/**
	 * @return the sydrapulpercol5Desc
	 */
	public String getSydrapulpercol5Desc() {
		return sydrapulpercol5Desc;
	}

	/**
	 * @param sydrapulpercol5Desc the sydrapulpercol5Desc to set
	 */
	public void setSydrapulpercol5Desc(String sydrapulpercol5Desc) {
		this.sydrapulpercol5Desc = sydrapulpercol5Desc;
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
	}
