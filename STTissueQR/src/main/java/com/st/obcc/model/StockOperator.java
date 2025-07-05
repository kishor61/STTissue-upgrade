/**
 *Jul 4, 2016
 *StockOperator.java
 * TODO
 *com.st.obcc.model
 *StockOperator.java
 *Sunil Singh Bora
 */
package com.st.obcc.model;

/**
 * @author snavhaal
 *
 */
public class StockOperator {

	private int id;
	private String position;
	private String operatorName;
	private String edate;
	private String crew;
	private String shift;

	private boolean machinedown;
	private boolean hdStorageChestCol1;

	private String hdStorageChestCol2Inbound;
	private String hdStorageChestCol2Outbound;

	private boolean hdStorageChestCol3;

	private String hdStorageChestCol4Inbound;
	private String hdStorageChestCol4Outbound;

	private boolean hdStorageChestCol5;

	private String hdStorageChestCol6Inbound;
	private String hdStorageChestCol6Outbound;

	private boolean hdStorageChestCol7;

	private String hdStorageChestCol8Inbound;
	private String hdStorageChestCol8Outbound;

	private String hdStorageChestCol1Desc;
	private String hdStorageChestCol2Desc;
	private String hdStorageChestCol3Desc;
	private String hdStorageChestCol4Desc;
	private String hdStorageChestCol5Desc;
	private String hdStorageChestCol6Desc;
	private String hdStorageChestCol7Desc;
	private String hdStorageChestCol8Desc;

	private boolean blendChestCol1;

	private String blendChestCol2Inbound;
	private String blendChestCol2Outbound;

	private boolean blendChestCol3;

	private String blendChestCol4Inbound;
	private String blendChestCol4Outbound;

	private String blendChestCol1Desc;
	private String blendChestCol2Desc;
	private String blendChestCol3Desc;
	private String blendChestCol4Desc;

	private boolean seeScreenFeedTandCol1;

	private String seeScreenFeedTandCol2Inbound;
	private String seeScreenFeedTandcol2Outbound;

	private boolean seeScreenFeedTandCol3;

	private String seeScreenFeedTandCol4Inbound;
	private String seeScreenFeedTandcol4Outbound;

	private String seeScreenFeedTandCol1Desc;
	private String seeScreenFeedTandCol2Desc;
	private String seeScreenFeedTandCol3Desc;
	private String seeScreenFeedTandCol4Desc;

	private boolean machineChestCol1;

	private String machineChestCol2Inbound;
	private String machineChestCol2Outbound;

	private boolean machineChestCol3;

	private String machineChestCol4Inbound;
	private String machineChestCol4Outbound;

	private boolean machineChestCol5;

	private String machineChestCol6Inbound;
	private String machineChestCol6Outbound;

	private String machineChestCol1Desc;
	private String machineChestCol2Desc;
	private String machineChestCol3Desc;
	private String machineChestCol4Desc;
	private String machineChestCol5Desc;
	private String machineChestCol6Desc;

	private boolean cleannersCol1;
	private boolean cleannersCol2;

	private String cleannersCol3Inbound;
	private String cleannersCol3Outbound;

	private String cleannersCol1Desc;
	private String cleannersCol2Desc;
	private String cleannersCol3Desc;

	private boolean deLinkStockCol1;

	private String deLinkStockCol2Inbound;
	private String deLinkStockCol2Outbound;

	private String deLinkStockCol1Desc;
	private String deLinkStockCol2Desc;

	private boolean whiteWaterCol1;

	private String whiteWaterCol2Inbound;
	private String whiteWaterCol2Outbound;

	private boolean whiteWaterCol3;

	private String whiteWaterCol4Inbound;
	private String whiteWaterCol4Outbound;

	private boolean whiteWaterCol5;

	private String whiteWaterCol6Inbound;
	private String whiteWaterCol6Outbound;

	private boolean whiteWaterCol7;

	private String whiteWaterCol8Inbound;
	private String whiteWaterCol8Outbound;

	private String whiteWaterCol1Desc;
	private String whiteWaterCol2Desc;
	private String whiteWaterCol3Desc;
	private String whiteWaterCol4Desc;
	private String whiteWaterCol5Desc;
	private String whiteWaterCol6Desc;
	private String whiteWaterCol7Desc;
	private String whiteWaterCol8Desc;

	private boolean couchPitCol1;
	private boolean couchPitCol2;

	private String couchPitCol3Inbound;
	private String couchPitCol3Outbound;

	private boolean couchPitCol4;

	private String couchPitCol5Inbound;
	private String couchPitCol5Outbound;

	private boolean couchPitCol6;

	private String couchPitCol7Inbound;
	private String couchPitCol7Outbound;

	private String couchPitCol8Inbound;
	private String couchPitCol8Outbound;

	private boolean couchPitCol9;

	private String couchPitCol10Inbound;
	private String couchPitCol10Outbound;

	private String couchPitCol11Inbound;
	private String couchPitCol11Outbound;

	private String couchPitCol1Desc;
	private String couchPitCol2Desc;
	private String couchPitCol3Desc;
	private String couchPitCol4Desc;
	private String couchPitCol5Desc;
	private String couchPitCol6Desc;
	private String couchPitCol7Desc;
	private String couchPitCol8Desc;
	private String couchPitCol9Desc;
	private String couchPitCol10Desc;
	private String couchPitCol11Desc;

	private boolean yankeePulperCol1;
	private boolean yankeePulperCol1Drain;
	private boolean yankeePulperCol2;

	private String yankeePulperCol3Inbound;
	private String yankeePulperCol3Outbound;

	private boolean yankeePulperCol4;

	private String yankeePulperCol5Inbound;
	private String yankeePulperCol5Outbound;

	private boolean yankeePulperCol6;

	private String yankeePulperCol7Inbound;
	private String yankeePulperCol7Outbound;

	private boolean yankeePulperCol8;

	private String yankeePulperCol9Inbound;
	private String yankeePulperCol9Outbound;

	private String yankeePulperCol1Desc;
	private String yankeePulperCol1DrainDesc;
	private String yankeePulperCol2Desc;
	private String yankeePulperCol3Desc;
	private String yankeePulperCol4Desc;
	private String yankeePulperCol5Desc;
	private String yankeePulperCol6Desc;
	private String yankeePulperCol7Desc;
	private String yankeePulperCol8Desc;
	private String yankeePulperCol9Desc;

	private boolean brokeDeflakerCol1;

	private String brokeDeflakerCol2Inbound;
	private String brokeDeflakerCol2Outbound;

	private boolean brokeDeflakerCol3;

	private String brokeDeflakerCol1Desc;
	private String brokeDeflakerCol2Desc;
	private String brokeDeflakerCol3Desc;

	private String refiningSystemCol1;

	private boolean refiningSystemCol2;

	private String refiningSystemCol3Inbound;
	private String refiningSystemCol3Outbound;

	private String refiningSystemCol4;
	private String refiningSystemCol5;

	private String refiningSystemCol6;

	private boolean refiningSystemCol7;

	private String refiningSystemCol8Inbound;
	private String refiningSystemCol8Outbound;

	private String refiningSystemCol9;
	private String refiningSystemCol10;

	private String refiningSystemCol1Desc;
	private String refiningSystemCol2Desc;
	private String refiningSystemCol3Desc;
	private String refiningSystemCol4Desc;
	private String refiningSystemCol5Desc;
	private String refiningSystemCol6Desc;
	private String refiningSystemCol7Desc;
	private String refiningSystemCol8Desc;
	private String refiningSystemCol9Desc;
	private String refiningSystemCol10Desc;

	private boolean whiteWaterPumpCol1;

	private String whiteWaterPumpCol2Inbound;
	private String whiteWaterPumpCol2Outbound;

	private boolean whiteWaterPumpCol3;

	private String whiteWaterPumpCol4Inbound;
	private String whiteWaterPumpCol4Outbound;

	private boolean whiteWaterPumpCol5;

	private String whiteWaterPumpCol6Inbound;
	private String whiteWaterPumpCol6Outbound;

	private String whiteWaterPumpCol1Desc;
	private String whiteWaterPumpCol2Desc;
	private String whiteWaterPumpCol3Desc;
	private String whiteWaterPumpCol4Desc;
	private String whiteWaterPumpCol5Desc;
	private String whiteWaterPumpCol6Desc;

	private String silloCol1;

	private boolean silloCol2;

	private String silloCol3;

	private String silloCol1Desc;
	private String silloCol2Desc;
	private String silloCol3Desc;

	private boolean yankeePumplerCol1;
	private boolean yankeePumplerCol1Drain;
	private boolean yankeePumplerCol2;

	private String yankeePumplerCol3Inbound;
	private String yankeePumplerCol3Outbound;

	private boolean yankeePumplerCol4;

	private String yankeePumplerCol5Inbound;
	private String yankeePumplerCol5Outbound;

	private boolean yankeePumplerCol6;

	private String yankeePumplerCol7Inbound;
	private String yankeePumplerCol7Outbound;

	private boolean yankeePumplerCol8;

	private String yankeePumplerCol9Inbound;
	private String yankeePumplerCol9Outbound;

	private String yankeePumplerCol1Desc;
	
	private String yankeePumplerCol1DrainDesc;
	
	private String yankeePumplerCol2Desc;
	private String yankeePumplerCol3Desc;
	private String yankeePumplerCol4Desc;
	private String yankeePumplerCol5Desc;
	private String yankeePumplerCol6Desc;
	private String yankeePumplerCol7Desc;
	private String yankeePumplerCol8Desc;
	private String yankeePumplerCol9Desc;

	private String brokeSystemCol1;
	private String brokeSystemCol2;
	private String brokeSystemCol3;
	private String brokeSystemCol4;
	private String brokeSystemCol5;
	private String brokeSystemCol6;
	private String brokeSystemCol7;
	private String brokeSystemCol8;
	private String brokeSystemCol9;
	private String brokeSystemCol10;
	private String brokeSystemCol11;

	private String brokeSystemCol1Desc;
	private String brokeSystemCol2Desc;
	private String brokeSystemCol3Desc;
	private String brokeSystemCol4Desc;
	private String brokeSystemCol5Desc;
	private String brokeSystemCol6Desc;
	private String brokeSystemCol7Desc;
	private String brokeSystemCol8Desc;
	private String brokeSystemCol9Desc;
	private String brokeSystemCol10Desc;
	private String brokeSystemCol11Desc;

	private String saveAllCol1;
	private boolean saveAllCol2;
	private boolean saveAllCol3;

	private String saveAllCol4Inbound;
	private String saveAllCol4Outbound;

	private boolean saveAllCol5;
	private boolean saveAllCol6;

	private String saveAllCol1Desc;
	private String saveAllCol2Desc;
	private String saveAllCol3Desc;
	private String saveAllCol4Desc;
	private String saveAllCol5Desc;
	private String saveAllCol6Desc;

	private boolean hydrapulperCol1;

	private String hydrapulperCol2Inbound;
	private String hydrapulperCol2outbound;

	private boolean hydrapulperCol3;

	private String hydrapulperCol4Inbound;
	private String hydrapulperCol4outbound;

	private boolean hydrapulperCol5;
	private boolean hydrapulperCol6;
	private boolean hydrapulperCol7;

	private String hydrapulperCol8Inbound;
	private String hydrapulperCol8outbound;

	private boolean hydrapulperCol9;

	private String hydrapulperCol10Inbound;
	private String hydrapulperCol10outbound;

	private boolean hydrapulperCol11;
	private boolean hydrapulperCol12;
	private boolean hydrapulperCol13;

	private String hydrapulperCol14Inbound;
	private String hydrapulperCol14outbound;

	private boolean hydrapulperCol15;

	private String hydrapulperCol16Inbound;
	private String hydrapulperCol16outbound;

	private String hydrapulperCol1Desc;
	private String hydrapulperCol2Desc;
	private String hydrapulperCol3Desc;
	private String hydrapulperCol4Desc;
	private String hydrapulperCol5Desc;
	private String hydrapulperCol6Desc;
	private String hydrapulperCol7Desc;
	private String hydrapulperCol8Desc;
	private String hydrapulperCol9Desc;
	private String hydrapulperCol10Desc;
	private String hydrapulperCol11Desc;
	private String hydrapulperCol12Desc;
	private String hydrapulperCol13Desc;
	private String hydrapulperCol14Desc;
	private String hydrapulperCol15Desc;
	private String hydrapulperCol16Desc;

	private String desccol1;
	private String desccol1Desc;
	
	private int processbarpercentage;
	
	private double percentage;
	
	
	private boolean effluentsamplerworkingcondition;
	private String effluentsamplerworkingconditionDesc;
	
	

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
	 * @return the hdStorageChestCol1
	 */
	public boolean isHdStorageChestCol1() {
		return hdStorageChestCol1;
	}

	/**
	 * @param hdStorageChestCol1
	 *            the hdStorageChestCol1 to set
	 */
	public void setHdStorageChestCol1(boolean hdStorageChestCol1) {
		this.hdStorageChestCol1 = hdStorageChestCol1;
	}

	/**
	 * @return the hdStorageChestCol2Inbound
	 */
	public String getHdStorageChestCol2Inbound() {
		return hdStorageChestCol2Inbound;
	}

	/**
	 * @param hdStorageChestCol2Inbound
	 *            the hdStorageChestCol2Inbound to set
	 */
	public void setHdStorageChestCol2Inbound(String hdStorageChestCol2Inbound) {
		this.hdStorageChestCol2Inbound = hdStorageChestCol2Inbound;
	}

	/**
	 * @return the hdStorageChestCol2Outbound
	 */
	public String getHdStorageChestCol2Outbound() {
		return hdStorageChestCol2Outbound;
	}

	/**
	 * @param hdStorageChestCol2Outbound
	 *            the hdStorageChestCol2Outbound to set
	 */
	public void setHdStorageChestCol2Outbound(String hdStorageChestCol2Outbound) {
		this.hdStorageChestCol2Outbound = hdStorageChestCol2Outbound;
	}

	/**
	 * @return the hdStorageChestCol3
	 */
	public boolean isHdStorageChestCol3() {
		return hdStorageChestCol3;
	}

	/**
	 * @param hdStorageChestCol3
	 *            the hdStorageChestCol3 to set
	 */
	public void setHdStorageChestCol3(boolean hdStorageChestCol3) {
		this.hdStorageChestCol3 = hdStorageChestCol3;
	}

	/**
	 * @return the hdStorageChestCol4Inbound
	 */
	public String getHdStorageChestCol4Inbound() {
		return hdStorageChestCol4Inbound;
	}

	/**
	 * @param hdStorageChestCol4Inbound
	 *            the hdStorageChestCol4Inbound to set
	 */
	public void setHdStorageChestCol4Inbound(String hdStorageChestCol4Inbound) {
		this.hdStorageChestCol4Inbound = hdStorageChestCol4Inbound;
	}

	/**
	 * @return the hdStorageChestCol4Outbound
	 */
	public String getHdStorageChestCol4Outbound() {
		return hdStorageChestCol4Outbound;
	}

	/**
	 * @param hdStorageChestCol4Outbound
	 *            the hdStorageChestCol4Outbound to set
	 */
	public void setHdStorageChestCol4Outbound(String hdStorageChestCol4Outbound) {
		this.hdStorageChestCol4Outbound = hdStorageChestCol4Outbound;
	}

	/**
	 * @return the hdStorageChestCol5
	 */
	public boolean isHdStorageChestCol5() {
		return hdStorageChestCol5;
	}

	/**
	 * @param hdStorageChestCol5
	 *            the hdStorageChestCol5 to set
	 */
	public void setHdStorageChestCol5(boolean hdStorageChestCol5) {
		this.hdStorageChestCol5 = hdStorageChestCol5;
	}

	/**
	 * @return the hdStorageChestCol6Inbound
	 */
	public String getHdStorageChestCol6Inbound() {
		return hdStorageChestCol6Inbound;
	}

	/**
	 * @param hdStorageChestCol6Inbound
	 *            the hdStorageChestCol6Inbound to set
	 */
	public void setHdStorageChestCol6Inbound(String hdStorageChestCol6Inbound) {
		this.hdStorageChestCol6Inbound = hdStorageChestCol6Inbound;
	}

	/**
	 * @return the hdStorageChestCol6Outbound
	 */
	public String getHdStorageChestCol6Outbound() {
		return hdStorageChestCol6Outbound;
	}

	/**
	 * @param hdStorageChestCol6Outbound
	 *            the hdStorageChestCol6Outbound to set
	 */
	public void setHdStorageChestCol6Outbound(String hdStorageChestCol6Outbound) {
		this.hdStorageChestCol6Outbound = hdStorageChestCol6Outbound;
	}

	/**
	 * @return the hdStorageChestCol7
	 */
	public boolean isHdStorageChestCol7() {
		return hdStorageChestCol7;
	}

	/**
	 * @param hdStorageChestCol7
	 *            the hdStorageChestCol7 to set
	 */
	public void setHdStorageChestCol7(boolean hdStorageChestCol7) {
		this.hdStorageChestCol7 = hdStorageChestCol7;
	}

	/**
	 * @return the hdStorageChestCol8Inbound
	 */
	public String getHdStorageChestCol8Inbound() {
		return hdStorageChestCol8Inbound;
	}

	/**
	 * @param hdStorageChestCol8Inbound
	 *            the hdStorageChestCol8Inbound to set
	 */
	public void setHdStorageChestCol8Inbound(String hdStorageChestCol8Inbound) {
		this.hdStorageChestCol8Inbound = hdStorageChestCol8Inbound;
	}

	/**
	 * @return the hdStorageChestCol8Outbound
	 */
	public String getHdStorageChestCol8Outbound() {
		return hdStorageChestCol8Outbound;
	}

	/**
	 * @param hdStorageChestCol8Outbound
	 *            the hdStorageChestCol8Outbound to set
	 */
	public void setHdStorageChestCol8Outbound(String hdStorageChestCol8Outbound) {
		this.hdStorageChestCol8Outbound = hdStorageChestCol8Outbound;
	}

	/**
	 * @return the hdStorageChestCol1Desc
	 */
	public String getHdStorageChestCol1Desc() {
		return hdStorageChestCol1Desc;
	}

	/**
	 * @param hdStorageChestCol1Desc
	 *            the hdStorageChestCol1Desc to set
	 */
	public void setHdStorageChestCol1Desc(String hdStorageChestCol1Desc) {
		this.hdStorageChestCol1Desc = hdStorageChestCol1Desc;
	}

	/**
	 * @return the hdStorageChestCol2Desc
	 */
	public String getHdStorageChestCol2Desc() {
		return hdStorageChestCol2Desc;
	}

	/**
	 * @param hdStorageChestCol2Desc
	 *            the hdStorageChestCol2Desc to set
	 */
	public void setHdStorageChestCol2Desc(String hdStorageChestCol2Desc) {
		this.hdStorageChestCol2Desc = hdStorageChestCol2Desc;
	}

	/**
	 * @return the hdStorageChestCol3Desc
	 */
	public String getHdStorageChestCol3Desc() {
		return hdStorageChestCol3Desc;
	}

	/**
	 * @param hdStorageChestCol3Desc
	 *            the hdStorageChestCol3Desc to set
	 */
	public void setHdStorageChestCol3Desc(String hdStorageChestCol3Desc) {
		this.hdStorageChestCol3Desc = hdStorageChestCol3Desc;
	}

	/**
	 * @return the hdStorageChestCol4Desc
	 */
	public String getHdStorageChestCol4Desc() {
		return hdStorageChestCol4Desc;
	}

	/**
	 * @param hdStorageChestCol4Desc
	 *            the hdStorageChestCol4Desc to set
	 */
	public void setHdStorageChestCol4Desc(String hdStorageChestCol4Desc) {
		this.hdStorageChestCol4Desc = hdStorageChestCol4Desc;
	}

	/**
	 * @return the hdStorageChestCol5Desc
	 */
	public String getHdStorageChestCol5Desc() {
		return hdStorageChestCol5Desc;
	}

	/**
	 * @param hdStorageChestCol5Desc
	 *            the hdStorageChestCol5Desc to set
	 */
	public void setHdStorageChestCol5Desc(String hdStorageChestCol5Desc) {
		this.hdStorageChestCol5Desc = hdStorageChestCol5Desc;
	}

	/**
	 * @return the hdStorageChestCol6Desc
	 */
	public String getHdStorageChestCol6Desc() {
		return hdStorageChestCol6Desc;
	}

	/**
	 * @param hdStorageChestCol6Desc
	 *            the hdStorageChestCol6Desc to set
	 */
	public void setHdStorageChestCol6Desc(String hdStorageChestCol6Desc) {
		this.hdStorageChestCol6Desc = hdStorageChestCol6Desc;
	}

	/**
	 * @return the hdStorageChestCol7Desc
	 */
	public String getHdStorageChestCol7Desc() {
		return hdStorageChestCol7Desc;
	}

	/**
	 * @param hdStorageChestCol7Desc
	 *            the hdStorageChestCol7Desc to set
	 */
	public void setHdStorageChestCol7Desc(String hdStorageChestCol7Desc) {
		this.hdStorageChestCol7Desc = hdStorageChestCol7Desc;
	}

	/**
	 * @return the hdStorageChestCol8Desc
	 */
	public String getHdStorageChestCol8Desc() {
		return hdStorageChestCol8Desc;
	}

	/**
	 * @param hdStorageChestCol8Desc
	 *            the hdStorageChestCol8Desc to set
	 */
	public void setHdStorageChestCol8Desc(String hdStorageChestCol8Desc) {
		this.hdStorageChestCol8Desc = hdStorageChestCol8Desc;
	}

	/**
	 * @return the blendChestCol1
	 */
	public boolean isBlendChestCol1() {
		return blendChestCol1;
	}

	/**
	 * @param blendChestCol1
	 *            the blendChestCol1 to set
	 */
	public void setBlendChestCol1(boolean blendChestCol1) {
		this.blendChestCol1 = blendChestCol1;
	}

	/**
	 * @return the blendChestCol2Inbound
	 */
	public String getBlendChestCol2Inbound() {
		return blendChestCol2Inbound;
	}

	/**
	 * @param blendChestCol2Inbound
	 *            the blendChestCol2Inbound to set
	 */
	public void setBlendChestCol2Inbound(String blendChestCol2Inbound) {
		this.blendChestCol2Inbound = blendChestCol2Inbound;
	}

	/**
	 * @return the blendChestCol2Outbound
	 */
	public String getBlendChestCol2Outbound() {
		return blendChestCol2Outbound;
	}

	/**
	 * @param blendChestCol2Outbound
	 *            the blendChestCol2Outbound to set
	 */
	public void setBlendChestCol2Outbound(String blendChestCol2Outbound) {
		this.blendChestCol2Outbound = blendChestCol2Outbound;
	}

	/**
	 * @return the blendChestCol3
	 */
	public boolean isBlendChestCol3() {
		return blendChestCol3;
	}

	/**
	 * @param blendChestCol3
	 *            the blendChestCol3 to set
	 */
	public void setBlendChestCol3(boolean blendChestCol3) {
		this.blendChestCol3 = blendChestCol3;
	}

	/**
	 * @return the blendChestCol4Inbound
	 */
	public String getBlendChestCol4Inbound() {
		return blendChestCol4Inbound;
	}

	/**
	 * @param blendChestCol4Inbound
	 *            the blendChestCol4Inbound to set
	 */
	public void setBlendChestCol4Inbound(String blendChestCol4Inbound) {
		this.blendChestCol4Inbound = blendChestCol4Inbound;
	}

	/**
	 * @return the blendChestCol4Outbound
	 */
	public String getBlendChestCol4Outbound() {
		return blendChestCol4Outbound;
	}

	/**
	 * @param blendChestCol4Outbound
	 *            the blendChestCol4Outbound to set
	 */
	public void setBlendChestCol4Outbound(String blendChestCol4Outbound) {
		this.blendChestCol4Outbound = blendChestCol4Outbound;
	}

	/**
	 * @return the blendChestCol1Desc
	 */
	public String getBlendChestCol1Desc() {
		return blendChestCol1Desc;
	}

	/**
	 * @param blendChestCol1Desc
	 *            the blendChestCol1Desc to set
	 */
	public void setBlendChestCol1Desc(String blendChestCol1Desc) {
		this.blendChestCol1Desc = blendChestCol1Desc;
	}

	/**
	 * @return the blendChestCol2Desc
	 */
	public String getBlendChestCol2Desc() {
		return blendChestCol2Desc;
	}

	/**
	 * @param blendChestCol2Desc
	 *            the blendChestCol2Desc to set
	 */
	public void setBlendChestCol2Desc(String blendChestCol2Desc) {
		this.blendChestCol2Desc = blendChestCol2Desc;
	}

	/**
	 * @return the blendChestCol3Desc
	 */
	public String getBlendChestCol3Desc() {
		return blendChestCol3Desc;
	}

	/**
	 * @param blendChestCol3Desc
	 *            the blendChestCol3Desc to set
	 */
	public void setBlendChestCol3Desc(String blendChestCol3Desc) {
		this.blendChestCol3Desc = blendChestCol3Desc;
	}

	/**
	 * @return the blendChestCol4Desc
	 */
	public String getBlendChestCol4Desc() {
		return blendChestCol4Desc;
	}

	/**
	 * @param blendChestCol4Desc
	 *            the blendChestCol4Desc to set
	 */
	public void setBlendChestCol4Desc(String blendChestCol4Desc) {
		this.blendChestCol4Desc = blendChestCol4Desc;
	}

	/**
	 * @return the seeScreenFeedTandCol1
	 */
	public boolean isSeeScreenFeedTandCol1() {
		return seeScreenFeedTandCol1;
	}

	/**
	 * @param seeScreenFeedTandCol1
	 *            the seeScreenFeedTandCol1 to set
	 */
	public void setSeeScreenFeedTandCol1(boolean seeScreenFeedTandCol1) {
		this.seeScreenFeedTandCol1 = seeScreenFeedTandCol1;
	}

	/**
	 * @return the seeScreenFeedTandCol2Inbound
	 */
	public String getSeeScreenFeedTandCol2Inbound() {
		return seeScreenFeedTandCol2Inbound;
	}

	/**
	 * @param seeScreenFeedTandCol2Inbound
	 *            the seeScreenFeedTandCol2Inbound to set
	 */
	public void setSeeScreenFeedTandCol2Inbound(
			String seeScreenFeedTandCol2Inbound) {
		this.seeScreenFeedTandCol2Inbound = seeScreenFeedTandCol2Inbound;
	}

	/**
	 * @return the seeScreenFeedTandcol2Outbound
	 */
	public String getSeeScreenFeedTandcol2Outbound() {
		return seeScreenFeedTandcol2Outbound;
	}

	/**
	 * @param seeScreenFeedTandcol2Outbound
	 *            the seeScreenFeedTandcol2Outbound to set
	 */
	public void setSeeScreenFeedTandcol2Outbound(
			String seeScreenFeedTandcol2Outbound) {
		this.seeScreenFeedTandcol2Outbound = seeScreenFeedTandcol2Outbound;
	}

	/**
	 * @return the seeScreenFeedTandCol3
	 */
	public boolean isSeeScreenFeedTandCol3() {
		return seeScreenFeedTandCol3;
	}

	/**
	 * @param seeScreenFeedTandCol3
	 *            the seeScreenFeedTandCol3 to set
	 */
	public void setSeeScreenFeedTandCol3(boolean seeScreenFeedTandCol3) {
		this.seeScreenFeedTandCol3 = seeScreenFeedTandCol3;
	}

	/**
	 * @return the seeScreenFeedTandCol4Inbound
	 */
	public String getSeeScreenFeedTandCol4Inbound() {
		return seeScreenFeedTandCol4Inbound;
	}

	/**
	 * @param seeScreenFeedTandCol4Inbound
	 *            the seeScreenFeedTandCol4Inbound to set
	 */
	public void setSeeScreenFeedTandCol4Inbound(
			String seeScreenFeedTandCol4Inbound) {
		this.seeScreenFeedTandCol4Inbound = seeScreenFeedTandCol4Inbound;
	}

	/**
	 * @return the seeScreenFeedTandcol4Outbound
	 */
	public String getSeeScreenFeedTandcol4Outbound() {
		return seeScreenFeedTandcol4Outbound;
	}

	/**
	 * @param seeScreenFeedTandcol4Outbound
	 *            the seeScreenFeedTandcol4Outbound to set
	 */
	public void setSeeScreenFeedTandcol4Outbound(
			String seeScreenFeedTandcol4Outbound) {
		this.seeScreenFeedTandcol4Outbound = seeScreenFeedTandcol4Outbound;
	}

	/**
	 * @return the seeScreenFeedTandCol1Desc
	 */
	public String getSeeScreenFeedTandCol1Desc() {
		return seeScreenFeedTandCol1Desc;
	}

	/**
	 * @param seeScreenFeedTandCol1Desc
	 *            the seeScreenFeedTandCol1Desc to set
	 */
	public void setSeeScreenFeedTandCol1Desc(String seeScreenFeedTandCol1Desc) {
		this.seeScreenFeedTandCol1Desc = seeScreenFeedTandCol1Desc;
	}

	/**
	 * @return the seeScreenFeedTandCol2Desc
	 */
	public String getSeeScreenFeedTandCol2Desc() {
		return seeScreenFeedTandCol2Desc;
	}

	/**
	 * @param seeScreenFeedTandCol2Desc
	 *            the seeScreenFeedTandCol2Desc to set
	 */
	public void setSeeScreenFeedTandCol2Desc(String seeScreenFeedTandCol2Desc) {
		this.seeScreenFeedTandCol2Desc = seeScreenFeedTandCol2Desc;
	}

	/**
	 * @return the seeScreenFeedTandCol3Desc
	 */
	public String getSeeScreenFeedTandCol3Desc() {
		return seeScreenFeedTandCol3Desc;
	}

	/**
	 * @param seeScreenFeedTandCol3Desc
	 *            the seeScreenFeedTandCol3Desc to set
	 */
	public void setSeeScreenFeedTandCol3Desc(String seeScreenFeedTandCol3Desc) {
		this.seeScreenFeedTandCol3Desc = seeScreenFeedTandCol3Desc;
	}

	/**
	 * @return the seeScreenFeedTandCol4Desc
	 */
	public String getSeeScreenFeedTandCol4Desc() {
		return seeScreenFeedTandCol4Desc;
	}

	/**
	 * @param seeScreenFeedTandCol4Desc
	 *            the seeScreenFeedTandCol4Desc to set
	 */
	public void setSeeScreenFeedTandCol4Desc(String seeScreenFeedTandCol4Desc) {
		this.seeScreenFeedTandCol4Desc = seeScreenFeedTandCol4Desc;
	}

	/**
	 * @return the machineChestCol1
	 */
	public boolean isMachineChestCol1() {
		return machineChestCol1;
	}

	/**
	 * @param machineChestCol1
	 *            the machineChestCol1 to set
	 */
	public void setMachineChestCol1(boolean machineChestCol1) {
		this.machineChestCol1 = machineChestCol1;
	}

	/**
	 * @return the machineChestCol2Inbound
	 */
	public String getMachineChestCol2Inbound() {
		return machineChestCol2Inbound;
	}

	/**
	 * @param machineChestCol2Inbound
	 *            the machineChestCol2Inbound to set
	 */
	public void setMachineChestCol2Inbound(String machineChestCol2Inbound) {
		this.machineChestCol2Inbound = machineChestCol2Inbound;
	}

	/**
	 * @return the machineChestCol2Outbound
	 */
	public String getMachineChestCol2Outbound() {
		return machineChestCol2Outbound;
	}

	/**
	 * @param machineChestCol2Outbound
	 *            the machineChestCol2Outbound to set
	 */
	public void setMachineChestCol2Outbound(String machineChestCol2Outbound) {
		this.machineChestCol2Outbound = machineChestCol2Outbound;
	}

	/**
	 * @return the machineChestCol3
	 */
	public boolean isMachineChestCol3() {
		return machineChestCol3;
	}

	/**
	 * @param machineChestCol3
	 *            the machineChestCol3 to set
	 */
	public void setMachineChestCol3(boolean machineChestCol3) {
		this.machineChestCol3 = machineChestCol3;
	}

	/**
	 * @return the machineChestCol4Inbound
	 */
	public String getMachineChestCol4Inbound() {
		return machineChestCol4Inbound;
	}

	/**
	 * @param machineChestCol4Inbound
	 *            the machineChestCol4Inbound to set
	 */
	public void setMachineChestCol4Inbound(String machineChestCol4Inbound) {
		this.machineChestCol4Inbound = machineChestCol4Inbound;
	}

	/**
	 * @return the machineChestCol4Outbound
	 */
	public String getMachineChestCol4Outbound() {
		return machineChestCol4Outbound;
	}

	/**
	 * @param machineChestCol4Outbound
	 *            the machineChestCol4Outbound to set
	 */
	public void setMachineChestCol4Outbound(String machineChestCol4Outbound) {
		this.machineChestCol4Outbound = machineChestCol4Outbound;
	}

	/**
	 * @return the machineChestCol5
	 */
	public boolean isMachineChestCol5() {
		return machineChestCol5;
	}

	/**
	 * @param machineChestCol5
	 *            the machineChestCol5 to set
	 */
	public void setMachineChestCol5(boolean machineChestCol5) {
		this.machineChestCol5 = machineChestCol5;
	}

	/**
	 * @return the machineChestCol6Inbound
	 */
	public String getMachineChestCol6Inbound() {
		return machineChestCol6Inbound;
	}

	/**
	 * @param machineChestCol6Inbound
	 *            the machineChestCol6Inbound to set
	 */
	public void setMachineChestCol6Inbound(String machineChestCol6Inbound) {
		this.machineChestCol6Inbound = machineChestCol6Inbound;
	}

	/**
	 * @return the machineChestCol6Outbound
	 */
	public String getMachineChestCol6Outbound() {
		return machineChestCol6Outbound;
	}

	/**
	 * @param machineChestCol6Outbound
	 *            the machineChestCol6Outbound to set
	 */
	public void setMachineChestCol6Outbound(String machineChestCol6Outbound) {
		this.machineChestCol6Outbound = machineChestCol6Outbound;
	}

	/**
	 * @return the machineChestCol1Desc
	 */
	public String getMachineChestCol1Desc() {
		return machineChestCol1Desc;
	}

	/**
	 * @param machineChestCol1Desc
	 *            the machineChestCol1Desc to set
	 */
	public void setMachineChestCol1Desc(String machineChestCol1Desc) {
		this.machineChestCol1Desc = machineChestCol1Desc;
	}

	/**
	 * @return the machineChestCol2Desc
	 */
	public String getMachineChestCol2Desc() {
		return machineChestCol2Desc;
	}

	/**
	 * @param machineChestCol2Desc
	 *            the machineChestCol2Desc to set
	 */
	public void setMachineChestCol2Desc(String machineChestCol2Desc) {
		this.machineChestCol2Desc = machineChestCol2Desc;
	}

	/**
	 * @return the machineChestCol3Desc
	 */
	public String getMachineChestCol3Desc() {
		return machineChestCol3Desc;
	}

	/**
	 * @param machineChestCol3Desc
	 *            the machineChestCol3Desc to set
	 */
	public void setMachineChestCol3Desc(String machineChestCol3Desc) {
		this.machineChestCol3Desc = machineChestCol3Desc;
	}

	/**
	 * @return the machineChestCol4Desc
	 */
	public String getMachineChestCol4Desc() {
		return machineChestCol4Desc;
	}

	/**
	 * @param machineChestCol4Desc
	 *            the machineChestCol4Desc to set
	 */
	public void setMachineChestCol4Desc(String machineChestCol4Desc) {
		this.machineChestCol4Desc = machineChestCol4Desc;
	}

	/**
	 * @return the machineChestCol5Desc
	 */
	public String getMachineChestCol5Desc() {
		return machineChestCol5Desc;
	}

	/**
	 * @param machineChestCol5Desc
	 *            the machineChestCol5Desc to set
	 */
	public void setMachineChestCol5Desc(String machineChestCol5Desc) {
		this.machineChestCol5Desc = machineChestCol5Desc;
	}

	/**
	 * @return the machineChestCol6Desc
	 */
	public String getMachineChestCol6Desc() {
		return machineChestCol6Desc;
	}

	/**
	 * @param machineChestCol6Desc
	 *            the machineChestCol6Desc to set
	 */
	public void setMachineChestCol6Desc(String machineChestCol6Desc) {
		this.machineChestCol6Desc = machineChestCol6Desc;
	}

	/**
	 * @return the cleannersCol1
	 */
	public boolean isCleannersCol1() {
		return cleannersCol1;
	}

	/**
	 * @param cleannersCol1
	 *            the cleannersCol1 to set
	 */
	public void setCleannersCol1(boolean cleannersCol1) {
		this.cleannersCol1 = cleannersCol1;
	}

	/**
	 * @return the cleannersCol2
	 */
	public boolean isCleannersCol2() {
		return cleannersCol2;
	}

	/**
	 * @param cleannersCol2
	 *            the cleannersCol2 to set
	 */
	public void setCleannersCol2(boolean cleannersCol2) {
		this.cleannersCol2 = cleannersCol2;
	}

	/**
	 * @return the cleannersCol3Inbound
	 */
	public String getCleannersCol3Inbound() {
		return cleannersCol3Inbound;
	}

	/**
	 * @param cleannersCol3Inbound
	 *            the cleannersCol3Inbound to set
	 */
	public void setCleannersCol3Inbound(String cleannersCol3Inbound) {
		this.cleannersCol3Inbound = cleannersCol3Inbound;
	}

	/**
	 * @return the cleannersCol3Outbound
	 */
	public String getCleannersCol3Outbound() {
		return cleannersCol3Outbound;
	}

	/**
	 * @param cleannersCol3Outbound
	 *            the cleannersCol3Outbound to set
	 */
	public void setCleannersCol3Outbound(String cleannersCol3Outbound) {
		this.cleannersCol3Outbound = cleannersCol3Outbound;
	}

	/**
	 * @return the cleannersCol1Desc
	 */
	public String getCleannersCol1Desc() {
		return cleannersCol1Desc;
	}

	/**
	 * @param cleannersCol1Desc
	 *            the cleannersCol1Desc to set
	 */
	public void setCleannersCol1Desc(String cleannersCol1Desc) {
		this.cleannersCol1Desc = cleannersCol1Desc;
	}

	/**
	 * @return the cleannersCol2Desc
	 */
	public String getCleannersCol2Desc() {
		return cleannersCol2Desc;
	}

	/**
	 * @param cleannersCol2Desc
	 *            the cleannersCol2Desc to set
	 */
	public void setCleannersCol2Desc(String cleannersCol2Desc) {
		this.cleannersCol2Desc = cleannersCol2Desc;
	}

	/**
	 * @return the cleannersCol3Desc
	 */
	public String getCleannersCol3Desc() {
		return cleannersCol3Desc;
	}

	/**
	 * @param cleannersCol3Desc
	 *            the cleannersCol3Desc to set
	 */
	public void setCleannersCol3Desc(String cleannersCol3Desc) {
		this.cleannersCol3Desc = cleannersCol3Desc;
	}

	/**
	 * @return the deLinkStockCol1
	 */
	public boolean isDeLinkStockCol1() {
		return deLinkStockCol1;
	}

	/**
	 * @param deLinkStockCol1
	 *            the deLinkStockCol1 to set
	 */
	public void setDeLinkStockCol1(boolean deLinkStockCol1) {
		this.deLinkStockCol1 = deLinkStockCol1;
	}

	/**
	 * @return the deLinkStockCol2Inbound
	 */
	public String getDeLinkStockCol2Inbound() {
		return deLinkStockCol2Inbound;
	}

	/**
	 * @param deLinkStockCol2Inbound
	 *            the deLinkStockCol2Inbound to set
	 */
	public void setDeLinkStockCol2Inbound(String deLinkStockCol2Inbound) {
		this.deLinkStockCol2Inbound = deLinkStockCol2Inbound;
	}

	/**
	 * @return the deLinkStockCol2Outbound
	 */
	public String getDeLinkStockCol2Outbound() {
		return deLinkStockCol2Outbound;
	}

	/**
	 * @param deLinkStockCol2Outbound
	 *            the deLinkStockCol2Outbound to set
	 */
	public void setDeLinkStockCol2Outbound(String deLinkStockCol2Outbound) {
		this.deLinkStockCol2Outbound = deLinkStockCol2Outbound;
	}

	/**
	 * @return the deLinkStockCol1Desc
	 */
	public String getDeLinkStockCol1Desc() {
		return deLinkStockCol1Desc;
	}

	/**
	 * @param deLinkStockCol1Desc
	 *            the deLinkStockCol1Desc to set
	 */
	public void setDeLinkStockCol1Desc(String deLinkStockCol1Desc) {
		this.deLinkStockCol1Desc = deLinkStockCol1Desc;
	}

	/**
	 * @return the deLinkStockCol2Desc
	 */
	public String getDeLinkStockCol2Desc() {
		return deLinkStockCol2Desc;
	}

	/**
	 * @param deLinkStockCol2Desc
	 *            the deLinkStockCol2Desc to set
	 */
	public void setDeLinkStockCol2Desc(String deLinkStockCol2Desc) {
		this.deLinkStockCol2Desc = deLinkStockCol2Desc;
	}

	/**
	 * @return the whiteWaterCol1
	 */
	public boolean isWhiteWaterCol1() {
		return whiteWaterCol1;
	}

	/**
	 * @param whiteWaterCol1
	 *            the whiteWaterCol1 to set
	 */
	public void setWhiteWaterCol1(boolean whiteWaterCol1) {
		this.whiteWaterCol1 = whiteWaterCol1;
	}

	/**
	 * @return the whiteWaterCol2Inbound
	 */
	public String getWhiteWaterCol2Inbound() {
		return whiteWaterCol2Inbound;
	}

	/**
	 * @param whiteWaterCol2Inbound
	 *            the whiteWaterCol2Inbound to set
	 */
	public void setWhiteWaterCol2Inbound(String whiteWaterCol2Inbound) {
		this.whiteWaterCol2Inbound = whiteWaterCol2Inbound;
	}

	/**
	 * @return the whiteWaterCol2Outbound
	 */
	public String getWhiteWaterCol2Outbound() {
		return whiteWaterCol2Outbound;
	}

	/**
	 * @param whiteWaterCol2Outbound
	 *            the whiteWaterCol2Outbound to set
	 */
	public void setWhiteWaterCol2Outbound(String whiteWaterCol2Outbound) {
		this.whiteWaterCol2Outbound = whiteWaterCol2Outbound;
	}

	/**
	 * @return the whiteWaterCol3
	 */
	public boolean isWhiteWaterCol3() {
		return whiteWaterCol3;
	}

	/**
	 * @param whiteWaterCol3
	 *            the whiteWaterCol3 to set
	 */
	public void setWhiteWaterCol3(boolean whiteWaterCol3) {
		this.whiteWaterCol3 = whiteWaterCol3;
	}

	/**
	 * @return the whiteWaterCol4Inbound
	 */
	public String getWhiteWaterCol4Inbound() {
		return whiteWaterCol4Inbound;
	}

	/**
	 * @param whiteWaterCol4Inbound
	 *            the whiteWaterCol4Inbound to set
	 */
	public void setWhiteWaterCol4Inbound(String whiteWaterCol4Inbound) {
		this.whiteWaterCol4Inbound = whiteWaterCol4Inbound;
	}

	/**
	 * @return the whiteWaterCol4Outbound
	 */
	public String getWhiteWaterCol4Outbound() {
		return whiteWaterCol4Outbound;
	}

	/**
	 * @param whiteWaterCol4Outbound
	 *            the whiteWaterCol4Outbound to set
	 */
	public void setWhiteWaterCol4Outbound(String whiteWaterCol4Outbound) {
		this.whiteWaterCol4Outbound = whiteWaterCol4Outbound;
	}

	/**
	 * @return the whiteWaterCol5
	 */
	public boolean isWhiteWaterCol5() {
		return whiteWaterCol5;
	}

	/**
	 * @param whiteWaterCol5
	 *            the whiteWaterCol5 to set
	 */
	public void setWhiteWaterCol5(boolean whiteWaterCol5) {
		this.whiteWaterCol5 = whiteWaterCol5;
	}

	/**
	 * @return the whiteWaterCol6Inbound
	 */
	public String getWhiteWaterCol6Inbound() {
		return whiteWaterCol6Inbound;
	}

	/**
	 * @param whiteWaterCol6Inbound
	 *            the whiteWaterCol6Inbound to set
	 */
	public void setWhiteWaterCol6Inbound(String whiteWaterCol6Inbound) {
		this.whiteWaterCol6Inbound = whiteWaterCol6Inbound;
	}

	/**
	 * @return the whiteWaterCol6Outbound
	 */
	public String getWhiteWaterCol6Outbound() {
		return whiteWaterCol6Outbound;
	}

	/**
	 * @param whiteWaterCol6Outbound
	 *            the whiteWaterCol6Outbound to set
	 */
	public void setWhiteWaterCol6Outbound(String whiteWaterCol6Outbound) {
		this.whiteWaterCol6Outbound = whiteWaterCol6Outbound;
	}

	/**
	 * @return the whiteWaterCol7
	 */
	public boolean isWhiteWaterCol7() {
		return whiteWaterCol7;
	}

	/**
	 * @param whiteWaterCol7
	 *            the whiteWaterCol7 to set
	 */
	public void setWhiteWaterCol7(boolean whiteWaterCol7) {
		this.whiteWaterCol7 = whiteWaterCol7;
	}

	/**
	 * @return the whiteWaterCol8Inbound
	 */
	public String getWhiteWaterCol8Inbound() {
		return whiteWaterCol8Inbound;
	}

	/**
	 * @param whiteWaterCol8Inbound
	 *            the whiteWaterCol8Inbound to set
	 */
	public void setWhiteWaterCol8Inbound(String whiteWaterCol8Inbound) {
		this.whiteWaterCol8Inbound = whiteWaterCol8Inbound;
	}

	/**
	 * @return the whiteWaterCol8Outbound
	 */
	public String getWhiteWaterCol8Outbound() {
		return whiteWaterCol8Outbound;
	}

	/**
	 * @param whiteWaterCol8Outbound
	 *            the whiteWaterCol8Outbound to set
	 */
	public void setWhiteWaterCol8Outbound(String whiteWaterCol8Outbound) {
		this.whiteWaterCol8Outbound = whiteWaterCol8Outbound;
	}

	/**
	 * @return the whiteWaterCol1Desc
	 */
	public String getWhiteWaterCol1Desc() {
		return whiteWaterCol1Desc;
	}

	/**
	 * @param whiteWaterCol1Desc
	 *            the whiteWaterCol1Desc to set
	 */
	public void setWhiteWaterCol1Desc(String whiteWaterCol1Desc) {
		this.whiteWaterCol1Desc = whiteWaterCol1Desc;
	}

	/**
	 * @return the whiteWaterCol2Desc
	 */
	public String getWhiteWaterCol2Desc() {
		return whiteWaterCol2Desc;
	}

	/**
	 * @param whiteWaterCol2Desc
	 *            the whiteWaterCol2Desc to set
	 */
	public void setWhiteWaterCol2Desc(String whiteWaterCol2Desc) {
		this.whiteWaterCol2Desc = whiteWaterCol2Desc;
	}

	/**
	 * @return the whiteWaterCol3Desc
	 */
	public String getWhiteWaterCol3Desc() {
		return whiteWaterCol3Desc;
	}

	/**
	 * @param whiteWaterCol3Desc
	 *            the whiteWaterCol3Desc to set
	 */
	public void setWhiteWaterCol3Desc(String whiteWaterCol3Desc) {
		this.whiteWaterCol3Desc = whiteWaterCol3Desc;
	}

	/**
	 * @return the whiteWaterCol4Desc
	 */
	public String getWhiteWaterCol4Desc() {
		return whiteWaterCol4Desc;
	}

	/**
	 * @param whiteWaterCol4Desc
	 *            the whiteWaterCol4Desc to set
	 */
	public void setWhiteWaterCol4Desc(String whiteWaterCol4Desc) {
		this.whiteWaterCol4Desc = whiteWaterCol4Desc;
	}

	/**
	 * @return the whiteWaterCol5Desc
	 */
	public String getWhiteWaterCol5Desc() {
		return whiteWaterCol5Desc;
	}

	/**
	 * @param whiteWaterCol5Desc
	 *            the whiteWaterCol5Desc to set
	 */
	public void setWhiteWaterCol5Desc(String whiteWaterCol5Desc) {
		this.whiteWaterCol5Desc = whiteWaterCol5Desc;
	}

	/**
	 * @return the whiteWaterCol6Desc
	 */
	public String getWhiteWaterCol6Desc() {
		return whiteWaterCol6Desc;
	}

	/**
	 * @param whiteWaterCol6Desc
	 *            the whiteWaterCol6Desc to set
	 */
	public void setWhiteWaterCol6Desc(String whiteWaterCol6Desc) {
		this.whiteWaterCol6Desc = whiteWaterCol6Desc;
	}

	/**
	 * @return the whiteWaterCol7Desc
	 */
	public String getWhiteWaterCol7Desc() {
		return whiteWaterCol7Desc;
	}

	/**
	 * @param whiteWaterCol7Desc
	 *            the whiteWaterCol7Desc to set
	 */
	public void setWhiteWaterCol7Desc(String whiteWaterCol7Desc) {
		this.whiteWaterCol7Desc = whiteWaterCol7Desc;
	}

	/**
	 * @return the whiteWaterCol8Desc
	 */
	public String getWhiteWaterCol8Desc() {
		return whiteWaterCol8Desc;
	}

	/**
	 * @param whiteWaterCol8Desc
	 *            the whiteWaterCol8Desc to set
	 */
	public void setWhiteWaterCol8Desc(String whiteWaterCol8Desc) {
		this.whiteWaterCol8Desc = whiteWaterCol8Desc;
	}

	/**
	 * @return the couchPitCol1
	 */
	public boolean isCouchPitCol1() {
		return couchPitCol1;
	}

	/**
	 * @param couchPitCol1
	 *            the couchPitCol1 to set
	 */
	public void setCouchPitCol1(boolean couchPitCol1) {
		this.couchPitCol1 = couchPitCol1;
	}

	/**
	 * @return the couchPitCol2
	 */
	public boolean isCouchPitCol2() {
		return couchPitCol2;
	}

	/**
	 * @param couchPitCol2
	 *            the couchPitCol2 to set
	 */
	public void setCouchPitCol2(boolean couchPitCol2) {
		this.couchPitCol2 = couchPitCol2;
	}

	/**
	 * @return the couchPitCol3Inbound
	 */
	public String getCouchPitCol3Inbound() {
		return couchPitCol3Inbound;
	}

	/**
	 * @param couchPitCol3Inbound
	 *            the couchPitCol3Inbound to set
	 */
	public void setCouchPitCol3Inbound(String couchPitCol3Inbound) {
		this.couchPitCol3Inbound = couchPitCol3Inbound;
	}

	/**
	 * @return the couchPitCol3Outbound
	 */
	public String getCouchPitCol3Outbound() {
		return couchPitCol3Outbound;
	}

	/**
	 * @param couchPitCol3Outbound
	 *            the couchPitCol3Outbound to set
	 */
	public void setCouchPitCol3Outbound(String couchPitCol3Outbound) {
		this.couchPitCol3Outbound = couchPitCol3Outbound;
	}

	/**
	 * @return the couchPitCol4
	 */
	public boolean isCouchPitCol4() {
		return couchPitCol4;
	}

	/**
	 * @param couchPitCol4
	 *            the couchPitCol4 to set
	 */
	public void setCouchPitCol4(boolean couchPitCol4) {
		this.couchPitCol4 = couchPitCol4;
	}

	/**
	 * @return the couchPitCol5Inbound
	 */
	public String getCouchPitCol5Inbound() {
		return couchPitCol5Inbound;
	}

	/**
	 * @param couchPitCol5Inbound
	 *            the couchPitCol5Inbound to set
	 */
	public void setCouchPitCol5Inbound(String couchPitCol5Inbound) {
		this.couchPitCol5Inbound = couchPitCol5Inbound;
	}

	/**
	 * @return the couchPitCol5Outbound
	 */
	public String getCouchPitCol5Outbound() {
		return couchPitCol5Outbound;
	}

	/**
	 * @param couchPitCol5Outbound
	 *            the couchPitCol5Outbound to set
	 */
	public void setCouchPitCol5Outbound(String couchPitCol5Outbound) {
		this.couchPitCol5Outbound = couchPitCol5Outbound;
	}

	/**
	 * @return the couchPitCol6
	 */
	public boolean isCouchPitCol6() {
		return couchPitCol6;
	}

	/**
	 * @param couchPitCol6
	 *            the couchPitCol6 to set
	 */
	public void setCouchPitCol6(boolean couchPitCol6) {
		this.couchPitCol6 = couchPitCol6;
	}

	/**
	 * @return the couchPitCol7Inbound
	 */
	public String getCouchPitCol7Inbound() {
		return couchPitCol7Inbound;
	}

	/**
	 * @param couchPitCol7Inbound
	 *            the couchPitCol7Inbound to set
	 */
	public void setCouchPitCol7Inbound(String couchPitCol7Inbound) {
		this.couchPitCol7Inbound = couchPitCol7Inbound;
	}

	/**
	 * @return the couchPitCol7Outbound
	 */
	public String getCouchPitCol7Outbound() {
		return couchPitCol7Outbound;
	}

	/**
	 * @param couchPitCol7Outbound
	 *            the couchPitCol7Outbound to set
	 */
	public void setCouchPitCol7Outbound(String couchPitCol7Outbound) {
		this.couchPitCol7Outbound = couchPitCol7Outbound;
	}

	/**
	 * @return the couchPitCol8Inbound
	 */
	public String getCouchPitCol8Inbound() {
		return couchPitCol8Inbound;
	}

	/**
	 * @param couchPitCol8Inbound
	 *            the couchPitCol8Inbound to set
	 */
	public void setCouchPitCol8Inbound(String couchPitCol8Inbound) {
		this.couchPitCol8Inbound = couchPitCol8Inbound;
	}

	/**
	 * @return the couchPitCol8Outbound
	 */
	public String getCouchPitCol8Outbound() {
		return couchPitCol8Outbound;
	}

	/**
	 * @param couchPitCol8Outbound
	 *            the couchPitCol8Outbound to set
	 */
	public void setCouchPitCol8Outbound(String couchPitCol8Outbound) {
		this.couchPitCol8Outbound = couchPitCol8Outbound;
	}

	/**
	 * @return the couchPitCol9
	 */
	public boolean isCouchPitCol9() {
		return couchPitCol9;
	}

	/**
	 * @param couchPitCol9
	 *            the couchPitCol9 to set
	 */
	public void setCouchPitCol9(boolean couchPitCol9) {
		this.couchPitCol9 = couchPitCol9;
	}

	/**
	 * @return the couchPitCol10Inbound
	 */
	public String getCouchPitCol10Inbound() {
		return couchPitCol10Inbound;
	}

	/**
	 * @param couchPitCol10Inbound
	 *            the couchPitCol10Inbound to set
	 */
	public void setCouchPitCol10Inbound(String couchPitCol10Inbound) {
		this.couchPitCol10Inbound = couchPitCol10Inbound;
	}

	/**
	 * @return the couchPitCol10Outbound
	 */
	public String getCouchPitCol10Outbound() {
		return couchPitCol10Outbound;
	}

	/**
	 * @param couchPitCol10Outbound
	 *            the couchPitCol10Outbound to set
	 */
	public void setCouchPitCol10Outbound(String couchPitCol10Outbound) {
		this.couchPitCol10Outbound = couchPitCol10Outbound;
	}

	/**
	 * @return the couchPitCol1Desc
	 */
	public String getCouchPitCol1Desc() {
		return couchPitCol1Desc;
	}

	/**
	 * @param couchPitCol1Desc
	 *            the couchPitCol1Desc to set
	 */
	public void setCouchPitCol1Desc(String couchPitCol1Desc) {
		this.couchPitCol1Desc = couchPitCol1Desc;
	}

	/**
	 * @return the couchPitCol2Desc
	 */
	public String getCouchPitCol2Desc() {
		return couchPitCol2Desc;
	}

	/**
	 * @param couchPitCol2Desc
	 *            the couchPitCol2Desc to set
	 */
	public void setCouchPitCol2Desc(String couchPitCol2Desc) {
		this.couchPitCol2Desc = couchPitCol2Desc;
	}

	/**
	 * @return the couchPitCol3Desc
	 */
	public String getCouchPitCol3Desc() {
		return couchPitCol3Desc;
	}

	/**
	 * @param couchPitCol3Desc
	 *            the couchPitCol3Desc to set
	 */
	public void setCouchPitCol3Desc(String couchPitCol3Desc) {
		this.couchPitCol3Desc = couchPitCol3Desc;
	}

	/**
	 * @return the couchPitCol4Desc
	 */
	public String getCouchPitCol4Desc() {
		return couchPitCol4Desc;
	}

	/**
	 * @param couchPitCol4Desc
	 *            the couchPitCol4Desc to set
	 */
	public void setCouchPitCol4Desc(String couchPitCol4Desc) {
		this.couchPitCol4Desc = couchPitCol4Desc;
	}

	/**
	 * @return the couchPitCol5Desc
	 */
	public String getCouchPitCol5Desc() {
		return couchPitCol5Desc;
	}

	/**
	 * @param couchPitCol5Desc
	 *            the couchPitCol5Desc to set
	 */
	public void setCouchPitCol5Desc(String couchPitCol5Desc) {
		this.couchPitCol5Desc = couchPitCol5Desc;
	}

	/**
	 * @return the couchPitCol6Desc
	 */
	public String getCouchPitCol6Desc() {
		return couchPitCol6Desc;
	}

	/**
	 * @param couchPitCol6Desc
	 *            the couchPitCol6Desc to set
	 */
	public void setCouchPitCol6Desc(String couchPitCol6Desc) {
		this.couchPitCol6Desc = couchPitCol6Desc;
	}

	/**
	 * @return the couchPitCol7Desc
	 */
	public String getCouchPitCol7Desc() {
		return couchPitCol7Desc;
	}

	/**
	 * @param couchPitCol7Desc
	 *            the couchPitCol7Desc to set
	 */
	public void setCouchPitCol7Desc(String couchPitCol7Desc) {
		this.couchPitCol7Desc = couchPitCol7Desc;
	}

	/**
	 * @return the couchPitCol8Desc
	 */
	public String getCouchPitCol8Desc() {
		return couchPitCol8Desc;
	}

	/**
	 * @param couchPitCol8Desc
	 *            the couchPitCol8Desc to set
	 */
	public void setCouchPitCol8Desc(String couchPitCol8Desc) {
		this.couchPitCol8Desc = couchPitCol8Desc;
	}

	/**
	 * @return the couchPitCol9Desc
	 */
	public String getCouchPitCol9Desc() {
		return couchPitCol9Desc;
	}

	/**
	 * @param couchPitCol9Desc
	 *            the couchPitCol9Desc to set
	 */
	public void setCouchPitCol9Desc(String couchPitCol9Desc) {
		this.couchPitCol9Desc = couchPitCol9Desc;
	}

	/**
	 * @return the couchPitCol10Desc
	 */
	public String getCouchPitCol10Desc() {
		return couchPitCol10Desc;
	}

	/**
	 * @param couchPitCol10Desc
	 *            the couchPitCol10Desc to set
	 */
	public void setCouchPitCol10Desc(String couchPitCol10Desc) {
		this.couchPitCol10Desc = couchPitCol10Desc;
	}

	/**
	 * @return the yankeePulperCol1
	 */
	public boolean isYankeePulperCol1() {
		return yankeePulperCol1;
	}

	/**
	 * @param yankeePulperCol1
	 *            the yankeePulperCol1 to set
	 */
	public void setYankeePulperCol1(boolean yankeePulperCol1) {
		this.yankeePulperCol1 = yankeePulperCol1;
	}

	/**
	 * @return the yankeePulperCol2
	 */
	public boolean isYankeePulperCol2() {
		return yankeePulperCol2;
	}

	/**
	 * @param yankeePulperCol2
	 *            the yankeePulperCol2 to set
	 */
	public void setYankeePulperCol2(boolean yankeePulperCol2) {
		this.yankeePulperCol2 = yankeePulperCol2;
	}

	/**
	 * @return the yankeePulperCol3Inbound
	 */
	public String getYankeePulperCol3Inbound() {
		return yankeePulperCol3Inbound;
	}

	/**
	 * @param yankeePulperCol3Inbound
	 *            the yankeePulperCol3Inbound to set
	 */
	public void setYankeePulperCol3Inbound(String yankeePulperCol3Inbound) {
		this.yankeePulperCol3Inbound = yankeePulperCol3Inbound;
	}

	/**
	 * @return the yankeePulperCol3Outbound
	 */
	public String getYankeePulperCol3Outbound() {
		return yankeePulperCol3Outbound;
	}

	/**
	 * @param yankeePulperCol3Outbound
	 *            the yankeePulperCol3Outbound to set
	 */
	public void setYankeePulperCol3Outbound(String yankeePulperCol3Outbound) {
		this.yankeePulperCol3Outbound = yankeePulperCol3Outbound;
	}

	/**
	 * @return the yankeePulperCol4
	 */
	public boolean isYankeePulperCol4() {
		return yankeePulperCol4;
	}

	/**
	 * @param yankeePulperCol4
	 *            the yankeePulperCol4 to set
	 */
	public void setYankeePulperCol4(boolean yankeePulperCol4) {
		this.yankeePulperCol4 = yankeePulperCol4;
	}

	/**
	 * @return the yankeePulperCol5Inbound
	 */
	public String getYankeePulperCol5Inbound() {
		return yankeePulperCol5Inbound;
	}

	/**
	 * @param yankeePulperCol5Inbound
	 *            the yankeePulperCol5Inbound to set
	 */
	public void setYankeePulperCol5Inbound(String yankeePulperCol5Inbound) {
		this.yankeePulperCol5Inbound = yankeePulperCol5Inbound;
	}

	/**
	 * @return the yankeePulperCol5Outbound
	 */
	public String getYankeePulperCol5Outbound() {
		return yankeePulperCol5Outbound;
	}

	/**
	 * @param yankeePulperCol5Outbound
	 *            the yankeePulperCol5Outbound to set
	 */
	public void setYankeePulperCol5Outbound(String yankeePulperCol5Outbound) {
		this.yankeePulperCol5Outbound = yankeePulperCol5Outbound;
	}

	/**
	 * @return the yankeePulperCol6
	 */
	public boolean isYankeePulperCol6() {
		return yankeePulperCol6;
	}

	/**
	 * @param yankeePulperCol6
	 *            the yankeePulperCol6 to set
	 */
	public void setYankeePulperCol6(boolean yankeePulperCol6) {
		this.yankeePulperCol6 = yankeePulperCol6;
	}

	/**
	 * @return the yankeePulperCol7Inbound
	 */
	public String getYankeePulperCol7Inbound() {
		return yankeePulperCol7Inbound;
	}

	/**
	 * @param yankeePulperCol7Inbound
	 *            the yankeePulperCol7Inbound to set
	 */
	public void setYankeePulperCol7Inbound(String yankeePulperCol7Inbound) {
		this.yankeePulperCol7Inbound = yankeePulperCol7Inbound;
	}

	/**
	 * @return the yankeePulperCol7Outbound
	 */
	public String getYankeePulperCol7Outbound() {
		return yankeePulperCol7Outbound;
	}

	/**
	 * @param yankeePulperCol7Outbound
	 *            the yankeePulperCol7Outbound to set
	 */
	public void setYankeePulperCol7Outbound(String yankeePulperCol7Outbound) {
		this.yankeePulperCol7Outbound = yankeePulperCol7Outbound;
	}

	/**
	 * @return the yankeePulperCol8
	 */
	public boolean isYankeePulperCol8() {
		return yankeePulperCol8;
	}

	/**
	 * @param yankeePulperCol8
	 *            the yankeePulperCol8 to set
	 */
	public void setYankeePulperCol8(boolean yankeePulperCol8) {
		this.yankeePulperCol8 = yankeePulperCol8;
	}

	/**
	 * @return the yankeePulperCol9Inbound
	 */
	public String getYankeePulperCol9Inbound() {
		return yankeePulperCol9Inbound;
	}

	/**
	 * @param yankeePulperCol9Inbound
	 *            the yankeePulperCol9Inbound to set
	 */
	public void setYankeePulperCol9Inbound(String yankeePulperCol9Inbound) {
		this.yankeePulperCol9Inbound = yankeePulperCol9Inbound;
	}

	/**
	 * @return the yankeePulperCol9Outbound
	 */
	public String getYankeePulperCol9Outbound() {
		return yankeePulperCol9Outbound;
	}

	/**
	 * @param yankeePulperCol9Outbound
	 *            the yankeePulperCol9Outbound to set
	 */
	public void setYankeePulperCol9Outbound(String yankeePulperCol9Outbound) {
		this.yankeePulperCol9Outbound = yankeePulperCol9Outbound;
	}

	/**
	 * @return the yankeePulperCol1Desc
	 */
	public String getYankeePulperCol1Desc() {
		return yankeePulperCol1Desc;
	}

	/**
	 * @param yankeePulperCol1Desc
	 *            the yankeePulperCol1Desc to set
	 */
	public void setYankeePulperCol1Desc(String yankeePulperCol1Desc) {
		this.yankeePulperCol1Desc = yankeePulperCol1Desc;
	}

	/**
	 * @return the yankeePulperCol2Desc
	 */
	public String getYankeePulperCol2Desc() {
		return yankeePulperCol2Desc;
	}

	/**
	 * @param yankeePulperCol2Desc
	 *            the yankeePulperCol2Desc to set
	 */
	public void setYankeePulperCol2Desc(String yankeePulperCol2Desc) {
		this.yankeePulperCol2Desc = yankeePulperCol2Desc;
	}

	/**
	 * @return the yankeePulperCol3Desc
	 */
	public String getYankeePulperCol3Desc() {
		return yankeePulperCol3Desc;
	}

	/**
	 * @param yankeePulperCol3Desc
	 *            the yankeePulperCol3Desc to set
	 */
	public void setYankeePulperCol3Desc(String yankeePulperCol3Desc) {
		this.yankeePulperCol3Desc = yankeePulperCol3Desc;
	}

	/**
	 * @return the yankeePulperCol4Desc
	 */
	public String getYankeePulperCol4Desc() {
		return yankeePulperCol4Desc;
	}

	/**
	 * @param yankeePulperCol4Desc
	 *            the yankeePulperCol4Desc to set
	 */
	public void setYankeePulperCol4Desc(String yankeePulperCol4Desc) {
		this.yankeePulperCol4Desc = yankeePulperCol4Desc;
	}

	/**
	 * @return the yankeePulperCol5Desc
	 */
	public String getYankeePulperCol5Desc() {
		return yankeePulperCol5Desc;
	}

	/**
	 * @param yankeePulperCol5Desc
	 *            the yankeePulperCol5Desc to set
	 */
	public void setYankeePulperCol5Desc(String yankeePulperCol5Desc) {
		this.yankeePulperCol5Desc = yankeePulperCol5Desc;
	}

	/**
	 * @return the yankeePulperCol6Desc
	 */
	public String getYankeePulperCol6Desc() {
		return yankeePulperCol6Desc;
	}

	/**
	 * @param yankeePulperCol6Desc
	 *            the yankeePulperCol6Desc to set
	 */
	public void setYankeePulperCol6Desc(String yankeePulperCol6Desc) {
		this.yankeePulperCol6Desc = yankeePulperCol6Desc;
	}

	/**
	 * @return the yankeePulperCol7Desc
	 */
	public String getYankeePulperCol7Desc() {
		return yankeePulperCol7Desc;
	}

	/**
	 * @param yankeePulperCol7Desc
	 *            the yankeePulperCol7Desc to set
	 */
	public void setYankeePulperCol7Desc(String yankeePulperCol7Desc) {
		this.yankeePulperCol7Desc = yankeePulperCol7Desc;
	}

	/**
	 * @return the yankeePulperCol8Desc
	 */
	public String getYankeePulperCol8Desc() {
		return yankeePulperCol8Desc;
	}

	/**
	 * @param yankeePulperCol8Desc
	 *            the yankeePulperCol8Desc to set
	 */
	public void setYankeePulperCol8Desc(String yankeePulperCol8Desc) {
		this.yankeePulperCol8Desc = yankeePulperCol8Desc;
	}

	/**
	 * @return the yankeePulperCol9Desc
	 */
	public String getYankeePulperCol9Desc() {
		return yankeePulperCol9Desc;
	}

	/**
	 * @param yankeePulperCol9Desc
	 *            the yankeePulperCol9Desc to set
	 */
	public void setYankeePulperCol9Desc(String yankeePulperCol9Desc) {
		this.yankeePulperCol9Desc = yankeePulperCol9Desc;
	}

	/**
	 * @return the brokeDeflakerCol1
	 */
	public boolean isBrokeDeflakerCol1() {
		return brokeDeflakerCol1;
	}

	/**
	 * @param brokeDeflakerCol1
	 *            the brokeDeflakerCol1 to set
	 */
	public void setBrokeDeflakerCol1(boolean brokeDeflakerCol1) {
		this.brokeDeflakerCol1 = brokeDeflakerCol1;
	}

	/**
	 * @return the brokeDeflakerCol2Inbound
	 */
	public String getBrokeDeflakerCol2Inbound() {
		return brokeDeflakerCol2Inbound;
	}

	/**
	 * @param brokeDeflakerCol2Inbound
	 *            the brokeDeflakerCol2Inbound to set
	 */
	public void setBrokeDeflakerCol2Inbound(String brokeDeflakerCol2Inbound) {
		this.brokeDeflakerCol2Inbound = brokeDeflakerCol2Inbound;
	}

	/**
	 * @return the brokeDeflakerCol2Outbound
	 */
	public String getBrokeDeflakerCol2Outbound() {
		return brokeDeflakerCol2Outbound;
	}

	/**
	 * @param brokeDeflakerCol2Outbound
	 *            the brokeDeflakerCol2Outbound to set
	 */
	public void setBrokeDeflakerCol2Outbound(String brokeDeflakerCol2Outbound) {
		this.brokeDeflakerCol2Outbound = brokeDeflakerCol2Outbound;
	}

	/**
	 * @return the brokeDeflakerCol3
	 */
	public boolean isBrokeDeflakerCol3() {
		return brokeDeflakerCol3;
	}

	/**
	 * @param brokeDeflakerCol3
	 *            the brokeDeflakerCol3 to set
	 */
	public void setBrokeDeflakerCol3(boolean brokeDeflakerCol3) {
		this.brokeDeflakerCol3 = brokeDeflakerCol3;
	}

	/**
	 * @return the brokeDeflakerCol1Desc
	 */
	public String getBrokeDeflakerCol1Desc() {
		return brokeDeflakerCol1Desc;
	}

	/**
	 * @param brokeDeflakerCol1Desc
	 *            the brokeDeflakerCol1Desc to set
	 */
	public void setBrokeDeflakerCol1Desc(String brokeDeflakerCol1Desc) {
		this.brokeDeflakerCol1Desc = brokeDeflakerCol1Desc;
	}

	/**
	 * @return the brokeDeflakerCol2Desc
	 */
	public String getBrokeDeflakerCol2Desc() {
		return brokeDeflakerCol2Desc;
	}

	/**
	 * @param brokeDeflakerCol2Desc
	 *            the brokeDeflakerCol2Desc to set
	 */
	public void setBrokeDeflakerCol2Desc(String brokeDeflakerCol2Desc) {
		this.brokeDeflakerCol2Desc = brokeDeflakerCol2Desc;
	}

	/**
	 * @return the brokeDeflakerCol3Desc
	 */
	public String getBrokeDeflakerCol3Desc() {
		return brokeDeflakerCol3Desc;
	}

	/**
	 * @param brokeDeflakerCol3Desc
	 *            the brokeDeflakerCol3Desc to set
	 */
	public void setBrokeDeflakerCol3Desc(String brokeDeflakerCol3Desc) {
		this.brokeDeflakerCol3Desc = brokeDeflakerCol3Desc;
	}

	/**
	 * @return the refiningSystemCol1
	 */
	public String getRefiningSystemCol1() {
		return refiningSystemCol1;
	}

	/**
	 * @param refiningSystemCol1
	 *            the refiningSystemCol1 to set
	 */
	public void setRefiningSystemCol1(String refiningSystemCol1) {
		this.refiningSystemCol1 = refiningSystemCol1;
	}

	/**
	 * @return the refiningSystemCol2
	 */
	public boolean isRefiningSystemCol2() {
		return refiningSystemCol2;
	}

	/**
	 * @param refiningSystemCol2
	 *            the refiningSystemCol2 to set
	 */
	public void setRefiningSystemCol2(boolean refiningSystemCol2) {
		this.refiningSystemCol2 = refiningSystemCol2;
	}

	/**
	 * @return the refiningSystemCol3Inbound
	 */
	public String getRefiningSystemCol3Inbound() {
		return refiningSystemCol3Inbound;
	}

	/**
	 * @param refiningSystemCol3Inbound
	 *            the refiningSystemCol3Inbound to set
	 */
	public void setRefiningSystemCol3Inbound(String refiningSystemCol3Inbound) {
		this.refiningSystemCol3Inbound = refiningSystemCol3Inbound;
	}

	/**
	 * @return the refiningSystemCol3Outbound
	 */
	public String getRefiningSystemCol3Outbound() {
		return refiningSystemCol3Outbound;
	}

	/**
	 * @param refiningSystemCol3Outbound
	 *            the refiningSystemCol3Outbound to set
	 */
	public void setRefiningSystemCol3Outbound(String refiningSystemCol3Outbound) {
		this.refiningSystemCol3Outbound = refiningSystemCol3Outbound;
	}

	/**
	 * @return the refiningSystemCol4
	 */
	public String getRefiningSystemCol4() {
		return refiningSystemCol4;
	}

	/**
	 * @param refiningSystemCol4
	 *            the refiningSystemCol4 to set
	 */
	public void setRefiningSystemCol4(String refiningSystemCol4) {
		this.refiningSystemCol4 = refiningSystemCol4;
	}

	/**
	 * @return the refiningSystemCol5
	 */
	public String getRefiningSystemCol5() {
		return refiningSystemCol5;
	}

	/**
	 * @param refiningSystemCol5
	 *            the refiningSystemCol5 to set
	 */
	public void setRefiningSystemCol5(String refiningSystemCol5) {
		this.refiningSystemCol5 = refiningSystemCol5;
	}

	/**
	 * @return the refiningSystemCol6
	 */
	public String getRefiningSystemCol6() {
		return refiningSystemCol6;
	}

	/**
	 * @param refiningSystemCol6
	 *            the refiningSystemCol6 to set
	 */
	public void setRefiningSystemCol6(String refiningSystemCol6) {
		this.refiningSystemCol6 = refiningSystemCol6;
	}

	/**
	 * @return the refiningSystemCol7
	 */
	public boolean isRefiningSystemCol7() {
		return refiningSystemCol7;
	}

	/**
	 * @param refiningSystemCol7
	 *            the refiningSystemCol7 to set
	 */
	public void setRefiningSystemCol7(boolean refiningSystemCol7) {
		this.refiningSystemCol7 = refiningSystemCol7;
	}

	/**
	 * @return the refiningSystemCol8Inbound
	 */
	public String getRefiningSystemCol8Inbound() {
		return refiningSystemCol8Inbound;
	}

	/**
	 * @param refiningSystemCol8Inbound
	 *            the refiningSystemCol8Inbound to set
	 */
	public void setRefiningSystemCol8Inbound(String refiningSystemCol8Inbound) {
		this.refiningSystemCol8Inbound = refiningSystemCol8Inbound;
	}

	/**
	 * @return the refiningSystemCol8Outbound
	 */
	public String getRefiningSystemCol8Outbound() {
		return refiningSystemCol8Outbound;
	}

	/**
	 * @param refiningSystemCol8Outbound
	 *            the refiningSystemCol8Outbound to set
	 */
	public void setRefiningSystemCol8Outbound(String refiningSystemCol8Outbound) {
		this.refiningSystemCol8Outbound = refiningSystemCol8Outbound;
	}

	/**
	 * @return the refiningSystemCol9
	 */
 

	/**
	 * @return the refiningSystemCol1Desc
	 */
	public String getRefiningSystemCol1Desc() {
		return refiningSystemCol1Desc;
	}

	public String getRefiningSystemCol9() {
		return refiningSystemCol9;
	}

	public void setRefiningSystemCol9(String refiningSystemCol9) {
		this.refiningSystemCol9 = refiningSystemCol9;
	}

	public String getRefiningSystemCol10() {
		return refiningSystemCol10;
	}

	public void setRefiningSystemCol10(String refiningSystemCol10) {
		this.refiningSystemCol10 = refiningSystemCol10;
	}

	/**
	 * @param refiningSystemCol1Desc
	 *            the refiningSystemCol1Desc to set
	 */
	public void setRefiningSystemCol1Desc(String refiningSystemCol1Desc) {
		this.refiningSystemCol1Desc = refiningSystemCol1Desc;
	}

	/**
	 * @return the refiningSystemCol2Desc
	 */
	public String getRefiningSystemCol2Desc() {
		return refiningSystemCol2Desc;
	}

	/**
	 * @param refiningSystemCol2Desc
	 *            the refiningSystemCol2Desc to set
	 */
	public void setRefiningSystemCol2Desc(String refiningSystemCol2Desc) {
		this.refiningSystemCol2Desc = refiningSystemCol2Desc;
	}

	/**
	 * @return the refiningSystemCol3Desc
	 */
	public String getRefiningSystemCol3Desc() {
		return refiningSystemCol3Desc;
	}

	/**
	 * @param refiningSystemCol3Desc
	 *            the refiningSystemCol3Desc to set
	 */
	public void setRefiningSystemCol3Desc(String refiningSystemCol3Desc) {
		this.refiningSystemCol3Desc = refiningSystemCol3Desc;
	}

	/**
	 * @return the refiningSystemCol4Desc
	 */
	public String getRefiningSystemCol4Desc() {
		return refiningSystemCol4Desc;
	}

	/**
	 * @param refiningSystemCol4Desc
	 *            the refiningSystemCol4Desc to set
	 */
	public void setRefiningSystemCol4Desc(String refiningSystemCol4Desc) {
		this.refiningSystemCol4Desc = refiningSystemCol4Desc;
	}

	/**
	 * @return the refiningSystemCol5Desc
	 */
	public String getRefiningSystemCol5Desc() {
		return refiningSystemCol5Desc;
	}

	/**
	 * @param refiningSystemCol5Desc
	 *            the refiningSystemCol5Desc to set
	 */
	public void setRefiningSystemCol5Desc(String refiningSystemCol5Desc) {
		this.refiningSystemCol5Desc = refiningSystemCol5Desc;
	}

	/**
	 * @return the refiningSystemCol6Desc
	 */
	public String getRefiningSystemCol6Desc() {
		return refiningSystemCol6Desc;
	}

	/**
	 * @param refiningSystemCol6Desc
	 *            the refiningSystemCol6Desc to set
	 */
	public void setRefiningSystemCol6Desc(String refiningSystemCol6Desc) {
		this.refiningSystemCol6Desc = refiningSystemCol6Desc;
	}

	/**
	 * @return the refiningSystemCol7Desc
	 */
	public String getRefiningSystemCol7Desc() {
		return refiningSystemCol7Desc;
	}

	/**
	 * @param refiningSystemCol7Desc
	 *            the refiningSystemCol7Desc to set
	 */
	public void setRefiningSystemCol7Desc(String refiningSystemCol7Desc) {
		this.refiningSystemCol7Desc = refiningSystemCol7Desc;
	}

	/**
	 * @return the refiningSystemCol8Desc
	 */
	public String getRefiningSystemCol8Desc() {
		return refiningSystemCol8Desc;
	}

	/**
	 * @param refiningSystemCol8Desc
	 *            the refiningSystemCol8Desc to set
	 */
	public void setRefiningSystemCol8Desc(String refiningSystemCol8Desc) {
		this.refiningSystemCol8Desc = refiningSystemCol8Desc;
	}

	/**
	 * @return the refiningSystemCol9Desc
	 */
	public String getRefiningSystemCol9Desc() {
		return refiningSystemCol9Desc;
	}

	/**
	 * @param refiningSystemCol9Desc
	 *            the refiningSystemCol9Desc to set
	 */
	public void setRefiningSystemCol9Desc(String refiningSystemCol9Desc) {
		this.refiningSystemCol9Desc = refiningSystemCol9Desc;
	}

	/**
	 * @return the refiningSystemCol10Desc
	 */
	public String getRefiningSystemCol10Desc() {
		return refiningSystemCol10Desc;
	}

	/**
	 * @param refiningSystemCol10Desc
	 *            the refiningSystemCol10Desc to set
	 */
	public void setRefiningSystemCol10Desc(String refiningSystemCol10Desc) {
		this.refiningSystemCol10Desc = refiningSystemCol10Desc;
	}

	/**
	 * @return the whiteWaterPumpCol1
	 */
	public boolean isWhiteWaterPumpCol1() {
		return whiteWaterPumpCol1;
	}

	/**
	 * @param whiteWaterPumpCol1
	 *            the whiteWaterPumpCol1 to set
	 */
	public void setWhiteWaterPumpCol1(boolean whiteWaterPumpCol1) {
		this.whiteWaterPumpCol1 = whiteWaterPumpCol1;
	}

	/**
	 * @return the whiteWaterPumpCol2Inbound
	 */
	public String getWhiteWaterPumpCol2Inbound() {
		return whiteWaterPumpCol2Inbound;
	}

	/**
	 * @param whiteWaterPumpCol2Inbound
	 *            the whiteWaterPumpCol2Inbound to set
	 */
	public void setWhiteWaterPumpCol2Inbound(String whiteWaterPumpCol2Inbound) {
		this.whiteWaterPumpCol2Inbound = whiteWaterPumpCol2Inbound;
	}

	/**
	 * @return the whiteWaterPumpCol2Outbound
	 */
	public String getWhiteWaterPumpCol2Outbound() {
		return whiteWaterPumpCol2Outbound;
	}

	/**
	 * @param whiteWaterPumpCol2Outbound
	 *            the whiteWaterPumpCol2Outbound to set
	 */
	public void setWhiteWaterPumpCol2Outbound(String whiteWaterPumpCol2Outbound) {
		this.whiteWaterPumpCol2Outbound = whiteWaterPumpCol2Outbound;
	}

	/**
	 * @return the whiteWaterPumpCol3
	 */
	public boolean isWhiteWaterPumpCol3() {
		return whiteWaterPumpCol3;
	}

	/**
	 * @param whiteWaterPumpCol3
	 *            the whiteWaterPumpCol3 to set
	 */
	public void setWhiteWaterPumpCol3(boolean whiteWaterPumpCol3) {
		this.whiteWaterPumpCol3 = whiteWaterPumpCol3;
	}

	/**
	 * @return the whiteWaterPumpCol4Inbound
	 */
	public String getWhiteWaterPumpCol4Inbound() {
		return whiteWaterPumpCol4Inbound;
	}

	/**
	 * @param whiteWaterPumpCol4Inbound
	 *            the whiteWaterPumpCol4Inbound to set
	 */
	public void setWhiteWaterPumpCol4Inbound(String whiteWaterPumpCol4Inbound) {
		this.whiteWaterPumpCol4Inbound = whiteWaterPumpCol4Inbound;
	}

	/**
	 * @return the whiteWaterPumpCol4Outbound
	 */
	public String getWhiteWaterPumpCol4Outbound() {
		return whiteWaterPumpCol4Outbound;
	}

	/**
	 * @param whiteWaterPumpCol4Outbound
	 *            the whiteWaterPumpCol4Outbound to set
	 */
	public void setWhiteWaterPumpCol4Outbound(String whiteWaterPumpCol4Outbound) {
		this.whiteWaterPumpCol4Outbound = whiteWaterPumpCol4Outbound;
	}

	/**
	 * @return the whiteWaterPumpCol5
	 */
	public boolean isWhiteWaterPumpCol5() {
		return whiteWaterPumpCol5;
	}

	/**
	 * @param whiteWaterPumpCol5
	 *            the whiteWaterPumpCol5 to set
	 */
	public void setWhiteWaterPumpCol5(boolean whiteWaterPumpCol5) {
		this.whiteWaterPumpCol5 = whiteWaterPumpCol5;
	}

	/**
	 * @return the whiteWaterPumpCol6Inbound
	 */
	public String getWhiteWaterPumpCol6Inbound() {
		return whiteWaterPumpCol6Inbound;
	}

	/**
	 * @param whiteWaterPumpCol6Inbound
	 *            the whiteWaterPumpCol6Inbound to set
	 */
	public void setWhiteWaterPumpCol6Inbound(String whiteWaterPumpCol6Inbound) {
		this.whiteWaterPumpCol6Inbound = whiteWaterPumpCol6Inbound;
	}

	/**
	 * @return the whiteWaterPumpCol6Outbound
	 */
	public String getWhiteWaterPumpCol6Outbound() {
		return whiteWaterPumpCol6Outbound;
	}

	/**
	 * @param whiteWaterPumpCol6Outbound
	 *            the whiteWaterPumpCol6Outbound to set
	 */
	public void setWhiteWaterPumpCol6Outbound(String whiteWaterPumpCol6Outbound) {
		this.whiteWaterPumpCol6Outbound = whiteWaterPumpCol6Outbound;
	}

	/**
	 * @return the whiteWaterPumpCol1Desc
	 */
	public String getWhiteWaterPumpCol1Desc() {
		return whiteWaterPumpCol1Desc;
	}

	/**
	 * @param whiteWaterPumpCol1Desc
	 *            the whiteWaterPumpCol1Desc to set
	 */
	public void setWhiteWaterPumpCol1Desc(String whiteWaterPumpCol1Desc) {
		this.whiteWaterPumpCol1Desc = whiteWaterPumpCol1Desc;
	}

	/**
	 * @return the whiteWaterPumpCol2Desc
	 */
	public String getWhiteWaterPumpCol2Desc() {
		return whiteWaterPumpCol2Desc;
	}

	/**
	 * @param whiteWaterPumpCol2Desc
	 *            the whiteWaterPumpCol2Desc to set
	 */
	public void setWhiteWaterPumpCol2Desc(String whiteWaterPumpCol2Desc) {
		this.whiteWaterPumpCol2Desc = whiteWaterPumpCol2Desc;
	}

	/**
	 * @return the whiteWaterPumpCol3Desc
	 */
	public String getWhiteWaterPumpCol3Desc() {
		return whiteWaterPumpCol3Desc;
	}

	/**
	 * @param whiteWaterPumpCol3Desc
	 *            the whiteWaterPumpCol3Desc to set
	 */
	public void setWhiteWaterPumpCol3Desc(String whiteWaterPumpCol3Desc) {
		this.whiteWaterPumpCol3Desc = whiteWaterPumpCol3Desc;
	}

	/**
	 * @return the whiteWaterPumpCol4Desc
	 */
	public String getWhiteWaterPumpCol4Desc() {
		return whiteWaterPumpCol4Desc;
	}

	/**
	 * @param whiteWaterPumpCol4Desc
	 *            the whiteWaterPumpCol4Desc to set
	 */
	public void setWhiteWaterPumpCol4Desc(String whiteWaterPumpCol4Desc) {
		this.whiteWaterPumpCol4Desc = whiteWaterPumpCol4Desc;
	}

	/**
	 * @return the whiteWaterPumpCol5Desc
	 */
	public String getWhiteWaterPumpCol5Desc() {
		return whiteWaterPumpCol5Desc;
	}

	/**
	 * @param whiteWaterPumpCol5Desc
	 *            the whiteWaterPumpCol5Desc to set
	 */
	public void setWhiteWaterPumpCol5Desc(String whiteWaterPumpCol5Desc) {
		this.whiteWaterPumpCol5Desc = whiteWaterPumpCol5Desc;
	}

	/**
	 * @return the whiteWaterPumpCol6Desc
	 */
	public String getWhiteWaterPumpCol6Desc() {
		return whiteWaterPumpCol6Desc;
	}

	/**
	 * @param whiteWaterPumpCol6Desc
	 *            the whiteWaterPumpCol6Desc to set
	 */
	public void setWhiteWaterPumpCol6Desc(String whiteWaterPumpCol6Desc) {
		this.whiteWaterPumpCol6Desc = whiteWaterPumpCol6Desc;
	}

	/**
	 * @return the silloCol1
	 */
	public String getSilloCol1() {
		return silloCol1;
	}

	/**
	 * @param silloCol1
	 *            the silloCol1 to set
	 */
	public void setSilloCol1(String silloCol1) {
		this.silloCol1 = silloCol1;
	}

	/**
	 * @return the silloCol2
	 */
	public boolean isSilloCol2() {
		return silloCol2;
	}

	/**
	 * @param silloCol2
	 *            the silloCol2 to set
	 */
	public void setSilloCol2(boolean silloCol2) {
		this.silloCol2 = silloCol2;
	}

	/**
	 * @return the silloCol3
	 */
	public String getSilloCol3() {
		return silloCol3;
	}

	/**
	 * @param silloCol3
	 *            the silloCol3 to set
	 */
	public void setSilloCol3(String silloCol3) {
		this.silloCol3 = silloCol3;
	}

	/**
	 * @return the silloCol1Desc
	 */
	public String getSilloCol1Desc() {
		return silloCol1Desc;
	}

	/**
	 * @param silloCol1Desc
	 *            the silloCol1Desc to set
	 */
	public void setSilloCol1Desc(String silloCol1Desc) {
		this.silloCol1Desc = silloCol1Desc;
	}

	/**
	 * @return the silloCol2Desc
	 */
	public String getSilloCol2Desc() {
		return silloCol2Desc;
	}

	/**
	 * @param silloCol2Desc
	 *            the silloCol2Desc to set
	 */
	public void setSilloCol2Desc(String silloCol2Desc) {
		this.silloCol2Desc = silloCol2Desc;
	}

	/**
	 * @return the silloCol3Desc
	 */
	public String getSilloCol3Desc() {
		return silloCol3Desc;
	}

	/**
	 * @param silloCol3Desc
	 *            the silloCol3Desc to set
	 */
	public void setSilloCol3Desc(String silloCol3Desc) {
		this.silloCol3Desc = silloCol3Desc;
	}

	/**
	 * @return the yankeePumplerCol1
	 */
	public boolean isYankeePumplerCol1() {
		return yankeePumplerCol1;
	}

	/**
	 * @param yankeePumplerCol1
	 *            the yankeePumplerCol1 to set
	 */
	public void setYankeePumplerCol1(boolean yankeePumplerCol1) {
		this.yankeePumplerCol1 = yankeePumplerCol1;
	}

	/**
	 * @return the yankeePumplerCol2
	 */
	public boolean isYankeePumplerCol2() {
		return yankeePumplerCol2;
	}

	/**
	 * @param yankeePumplerCol2
	 *            the yankeePumplerCol2 to set
	 */
	public void setYankeePumplerCol2(boolean yankeePumplerCol2) {
		this.yankeePumplerCol2 = yankeePumplerCol2;
	}

	/**
	 * @return the yankeePumplerCol3Inbound
	 */
	public String getYankeePumplerCol3Inbound() {
		return yankeePumplerCol3Inbound;
	}

	/**
	 * @param yankeePumplerCol3Inbound
	 *            the yankeePumplerCol3Inbound to set
	 */
	public void setYankeePumplerCol3Inbound(String yankeePumplerCol3Inbound) {
		this.yankeePumplerCol3Inbound = yankeePumplerCol3Inbound;
	}

	/**
	 * @return the yankeePumplerCol3Outbound
	 */
	public String getYankeePumplerCol3Outbound() {
		return yankeePumplerCol3Outbound;
	}

	/**
	 * @param yankeePumplerCol3Outbound
	 *            the yankeePumplerCol3Outbound to set
	 */
	public void setYankeePumplerCol3Outbound(String yankeePumplerCol3Outbound) {
		this.yankeePumplerCol3Outbound = yankeePumplerCol3Outbound;
	}

	/**
	 * @return the yankeePumplerCol4
	 */
	public boolean isYankeePumplerCol4() {
		return yankeePumplerCol4;
	}

	/**
	 * @param yankeePumplerCol4
	 *            the yankeePumplerCol4 to set
	 */
	public void setYankeePumplerCol4(boolean yankeePumplerCol4) {
		this.yankeePumplerCol4 = yankeePumplerCol4;
	}

	/**
	 * @return the yankeePumplerCol5Inbound
	 */
	public String getYankeePumplerCol5Inbound() {
		return yankeePumplerCol5Inbound;
	}

	/**
	 * @param yankeePumplerCol5Inbound
	 *            the yankeePumplerCol5Inbound to set
	 */
	public void setYankeePumplerCol5Inbound(String yankeePumplerCol5Inbound) {
		this.yankeePumplerCol5Inbound = yankeePumplerCol5Inbound;
	}

	/**
	 * @return the yankeePumplerCol5Outbound
	 */
	public String getYankeePumplerCol5Outbound() {
		return yankeePumplerCol5Outbound;
	}

	/**
	 * @param yankeePumplerCol5Outbound
	 *            the yankeePumplerCol5Outbound to set
	 */
	public void setYankeePumplerCol5Outbound(String yankeePumplerCol5Outbound) {
		this.yankeePumplerCol5Outbound = yankeePumplerCol5Outbound;
	}

	/**
	 * @return the yankeePumplerCol6
	 */
	public boolean isYankeePumplerCol6() {
		return yankeePumplerCol6;
	}

	/**
	 * @param yankeePumplerCol6
	 *            the yankeePumplerCol6 to set
	 */
	public void setYankeePumplerCol6(boolean yankeePumplerCol6) {
		this.yankeePumplerCol6 = yankeePumplerCol6;
	}

	/**
	 * @return the yankeePumplerCol7Inbound
	 */
	public String getYankeePumplerCol7Inbound() {
		return yankeePumplerCol7Inbound;
	}

	/**
	 * @param yankeePumplerCol7Inbound
	 *            the yankeePumplerCol7Inbound to set
	 */
	public void setYankeePumplerCol7Inbound(String yankeePumplerCol7Inbound) {
		this.yankeePumplerCol7Inbound = yankeePumplerCol7Inbound;
	}

	/**
	 * @return the yankeePumplerCol7Outbound
	 */
	public String getYankeePumplerCol7Outbound() {
		return yankeePumplerCol7Outbound;
	}

	/**
	 * @param yankeePumplerCol7Outbound
	 *            the yankeePumplerCol7Outbound to set
	 */
	public void setYankeePumplerCol7Outbound(String yankeePumplerCol7Outbound) {
		this.yankeePumplerCol7Outbound = yankeePumplerCol7Outbound;
	}

	/**
	 * @return the yankeePumplerCol8
	 */
	public boolean isYankeePumplerCol8() {
		return yankeePumplerCol8;
	}

	/**
	 * @param yankeePumplerCol8
	 *            the yankeePumplerCol8 to set
	 */
	public void setYankeePumplerCol8(boolean yankeePumplerCol8) {
		this.yankeePumplerCol8 = yankeePumplerCol8;
	}

	/**
	 * @return the yankeePumplerCol9Inbound
	 */
	public String getYankeePumplerCol9Inbound() {
		return yankeePumplerCol9Inbound;
	}

	/**
	 * @param yankeePumplerCol9Inbound
	 *            the yankeePumplerCol9Inbound to set
	 */
	public void setYankeePumplerCol9Inbound(String yankeePumplerCol9Inbound) {
		this.yankeePumplerCol9Inbound = yankeePumplerCol9Inbound;
	}

	/**
	 * @return the yankeePumplerCol9Outbound
	 */
	public String getYankeePumplerCol9Outbound() {
		return yankeePumplerCol9Outbound;
	}

	/**
	 * @param yankeePumplerCol9Outbound
	 *            the yankeePumplerCol9Outbound to set
	 */
	public void setYankeePumplerCol9Outbound(String yankeePumplerCol9Outbound) {
		this.yankeePumplerCol9Outbound = yankeePumplerCol9Outbound;
	}

	/**
	 * @return the yankeePumplerCol1Desc
	 */
	public String getYankeePumplerCol1Desc() {
		return yankeePumplerCol1Desc;
	}

	/**
	 * @param yankeePumplerCol1Desc
	 *            the yankeePumplerCol1Desc to set
	 */
	public void setYankeePumplerCol1Desc(String yankeePumplerCol1Desc) {
		this.yankeePumplerCol1Desc = yankeePumplerCol1Desc;
	}

	/**
	 * @return the yankeePumplerCol2Desc
	 */
	public String getYankeePumplerCol2Desc() {
		return yankeePumplerCol2Desc;
	}

	/**
	 * @param yankeePumplerCol2Desc
	 *            the yankeePumplerCol2Desc to set
	 */
	public void setYankeePumplerCol2Desc(String yankeePumplerCol2Desc) {
		this.yankeePumplerCol2Desc = yankeePumplerCol2Desc;
	}

	/**
	 * @return the yankeePumplerCol3Desc
	 */
	public String getYankeePumplerCol3Desc() {
		return yankeePumplerCol3Desc;
	}

	/**
	 * @param yankeePumplerCol3Desc
	 *            the yankeePumplerCol3Desc to set
	 */
	public void setYankeePumplerCol3Desc(String yankeePumplerCol3Desc) {
		this.yankeePumplerCol3Desc = yankeePumplerCol3Desc;
	}

	/**
	 * @return the yankeePumplerCol4Desc
	 */
	public String getYankeePumplerCol4Desc() {
		return yankeePumplerCol4Desc;
	}

	/**
	 * @param yankeePumplerCol4Desc
	 *            the yankeePumplerCol4Desc to set
	 */
	public void setYankeePumplerCol4Desc(String yankeePumplerCol4Desc) {
		this.yankeePumplerCol4Desc = yankeePumplerCol4Desc;
	}

	/**
	 * @return the yankeePumplerCol5Desc
	 */
	public String getYankeePumplerCol5Desc() {
		return yankeePumplerCol5Desc;
	}

	/**
	 * @param yankeePumplerCol5Desc
	 *            the yankeePumplerCol5Desc to set
	 */
	public void setYankeePumplerCol5Desc(String yankeePumplerCol5Desc) {
		this.yankeePumplerCol5Desc = yankeePumplerCol5Desc;
	}

	/**
	 * @return the yankeePumplerCol6Desc
	 */
	public String getYankeePumplerCol6Desc() {
		return yankeePumplerCol6Desc;
	}

	/**
	 * @param yankeePumplerCol6Desc
	 *            the yankeePumplerCol6Desc to set
	 */
	public void setYankeePumplerCol6Desc(String yankeePumplerCol6Desc) {
		this.yankeePumplerCol6Desc = yankeePumplerCol6Desc;
	}

	/**
	 * @return the yankeePumplerCol7Desc
	 */
	public String getYankeePumplerCol7Desc() {
		return yankeePumplerCol7Desc;
	}

	/**
	 * @param yankeePumplerCol7Desc
	 *            the yankeePumplerCol7Desc to set
	 */
	public void setYankeePumplerCol7Desc(String yankeePumplerCol7Desc) {
		this.yankeePumplerCol7Desc = yankeePumplerCol7Desc;
	}

	/**
	 * @return the yankeePumplerCol8Desc
	 */
	public String getYankeePumplerCol8Desc() {
		return yankeePumplerCol8Desc;
	}

	/**
	 * @param yankeePumplerCol8Desc
	 *            the yankeePumplerCol8Desc to set
	 */
	public void setYankeePumplerCol8Desc(String yankeePumplerCol8Desc) {
		this.yankeePumplerCol8Desc = yankeePumplerCol8Desc;
	}

	/**
	 * @return the yankeePumplerCol9Desc
	 */
	public String getYankeePumplerCol9Desc() {
		return yankeePumplerCol9Desc;
	}

	/**
	 * @param yankeePumplerCol9Desc
	 *            the yankeePumplerCol9Desc to set
	 */
	public void setYankeePumplerCol9Desc(String yankeePumplerCol9Desc) {
		this.yankeePumplerCol9Desc = yankeePumplerCol9Desc;
	}

	/**
	 * @return the brokeSystemCol1
	 */
	public String getBrokeSystemCol1() {
		return brokeSystemCol1;
	}

	/**
	 * @param brokeSystemCol1
	 *            the brokeSystemCol1 to set
	 */
	public void setBrokeSystemCol1(String brokeSystemCol1) {
		this.brokeSystemCol1 = brokeSystemCol1;
	}

	/**
	 * @return the brokeSystemCol2
	 */
	public String getBrokeSystemCol2() {
		return brokeSystemCol2;
	}

	/**
	 * @param brokeSystemCol2
	 *            the brokeSystemCol2 to set
	 */
	public void setBrokeSystemCol2(String brokeSystemCol2) {
		this.brokeSystemCol2 = brokeSystemCol2;
	}

	/**
	 * @return the brokeSystemCol3
	 */
	public String getBrokeSystemCol3() {
		return brokeSystemCol3;
	}

	/**
	 * @param brokeSystemCol3
	 *            the brokeSystemCol3 to set
	 */
	public void setBrokeSystemCol3(String brokeSystemCol3) {
		this.brokeSystemCol3 = brokeSystemCol3;
	}

	/**
	 * @return the brokeSystemCol4
	 */
	public String getBrokeSystemCol4() {
		return brokeSystemCol4;
	}

	/**
	 * @param brokeSystemCol4
	 *            the brokeSystemCol4 to set
	 */
	public void setBrokeSystemCol4(String brokeSystemCol4) {
		this.brokeSystemCol4 = brokeSystemCol4;
	}

	/**
	 * @return the brokeSystemCol5
	 */
	public String getBrokeSystemCol5() {
		return brokeSystemCol5;
	}

	/**
	 * @param brokeSystemCol5
	 *            the brokeSystemCol5 to set
	 */
	public void setBrokeSystemCol5(String brokeSystemCol5) {
		this.brokeSystemCol5 = brokeSystemCol5;
	}

	/**
	 * @return the brokeSystemCol6
	 */
	public String getBrokeSystemCol6() {
		return brokeSystemCol6;
	}

	/**
	 * @param brokeSystemCol6
	 *            the brokeSystemCol6 to set
	 */
	public void setBrokeSystemCol6(String brokeSystemCol6) {
		this.brokeSystemCol6 = brokeSystemCol6;
	}

	/**
	 * @return the brokeSystemCol7
	 */
	public String getBrokeSystemCol7() {
		return brokeSystemCol7;
	}

	/**
	 * @param brokeSystemCol7
	 *            the brokeSystemCol7 to set
	 */
	public void setBrokeSystemCol7(String brokeSystemCol7) {
		this.brokeSystemCol7 = brokeSystemCol7;
	}

	/**
	 * @return the brokeSystemCol8
	 */
	public String getBrokeSystemCol8() {
		return brokeSystemCol8;
	}

	/**
	 * @param brokeSystemCol8
	 *            the brokeSystemCol8 to set
	 */
	public void setBrokeSystemCol8(String brokeSystemCol8) {
		this.brokeSystemCol8 = brokeSystemCol8;
	}

	/**
	 * @return the brokeSystemCol9
	 */
	public String getBrokeSystemCol9() {
		return brokeSystemCol9;
	}

	/**
	 * @param brokeSystemCol9
	 *            the brokeSystemCol9 to set
	 */
	public void setBrokeSystemCol9(String brokeSystemCol9) {
		this.brokeSystemCol9 = brokeSystemCol9;
	}

	/**
	 * @return the brokeSystemCol10
	 */
	public String getBrokeSystemCol10() {
		return brokeSystemCol10;
	}

	/**
	 * @param brokeSystemCol10
	 *            the brokeSystemCol10 to set
	 */
	public void setBrokeSystemCol10(String brokeSystemCol10) {
		this.brokeSystemCol10 = brokeSystemCol10;
	}

	/**
	 * @return the brokeSystemCol11
	 */
	public String getBrokeSystemCol11() {
		return brokeSystemCol11;
	}

	/**
	 * @param brokeSystemCol11
	 *            the brokeSystemCol11 to set
	 */
	public void setBrokeSystemCol11(String brokeSystemCol11) {
		this.brokeSystemCol11 = brokeSystemCol11;
	}

	/**
	 * @return the brokeSystemCol1Desc
	 */
	public String getBrokeSystemCol1Desc() {
		return brokeSystemCol1Desc;
	}

	/**
	 * @param brokeSystemCol1Desc
	 *            the brokeSystemCol1Desc to set
	 */
	public void setBrokeSystemCol1Desc(String brokeSystemCol1Desc) {
		this.brokeSystemCol1Desc = brokeSystemCol1Desc;
	}

	/**
	 * @return the brokeSystemCol2Desc
	 */
	public String getBrokeSystemCol2Desc() {
		return brokeSystemCol2Desc;
	}

	/**
	 * @param brokeSystemCol2Desc
	 *            the brokeSystemCol2Desc to set
	 */
	public void setBrokeSystemCol2Desc(String brokeSystemCol2Desc) {
		this.brokeSystemCol2Desc = brokeSystemCol2Desc;
	}

	/**
	 * @return the brokeSystemCol3Desc
	 */
	public String getBrokeSystemCol3Desc() {
		return brokeSystemCol3Desc;
	}

	/**
	 * @param brokeSystemCol3Desc
	 *            the brokeSystemCol3Desc to set
	 */
	public void setBrokeSystemCol3Desc(String brokeSystemCol3Desc) {
		this.brokeSystemCol3Desc = brokeSystemCol3Desc;
	}

	/**
	 * @return the brokeSystemCol4Desc
	 */
	public String getBrokeSystemCol4Desc() {
		return brokeSystemCol4Desc;
	}

	/**
	 * @param brokeSystemCol4Desc
	 *            the brokeSystemCol4Desc to set
	 */
	public void setBrokeSystemCol4Desc(String brokeSystemCol4Desc) {
		this.brokeSystemCol4Desc = brokeSystemCol4Desc;
	}

	/**
	 * @return the brokeSystemCol5Desc
	 */
	public String getBrokeSystemCol5Desc() {
		return brokeSystemCol5Desc;
	}

	/**
	 * @param brokeSystemCol5Desc
	 *            the brokeSystemCol5Desc to set
	 */
	public void setBrokeSystemCol5Desc(String brokeSystemCol5Desc) {
		this.brokeSystemCol5Desc = brokeSystemCol5Desc;
	}

	/**
	 * @return the brokeSystemCol6Desc
	 */
	public String getBrokeSystemCol6Desc() {
		return brokeSystemCol6Desc;
	}

	/**
	 * @param brokeSystemCol6Desc
	 *            the brokeSystemCol6Desc to set
	 */
	public void setBrokeSystemCol6Desc(String brokeSystemCol6Desc) {
		this.brokeSystemCol6Desc = brokeSystemCol6Desc;
	}

	/**
	 * @return the brokeSystemCol7Desc
	 */
	public String getBrokeSystemCol7Desc() {
		return brokeSystemCol7Desc;
	}

	/**
	 * @param brokeSystemCol7Desc
	 *            the brokeSystemCol7Desc to set
	 */
	public void setBrokeSystemCol7Desc(String brokeSystemCol7Desc) {
		this.brokeSystemCol7Desc = brokeSystemCol7Desc;
	}

	/**
	 * @return the brokeSystemCol8Desc
	 */
	public String getBrokeSystemCol8Desc() {
		return brokeSystemCol8Desc;
	}

	/**
	 * @param brokeSystemCol8Desc
	 *            the brokeSystemCol8Desc to set
	 */
	public void setBrokeSystemCol8Desc(String brokeSystemCol8Desc) {
		this.brokeSystemCol8Desc = brokeSystemCol8Desc;
	}

	/**
	 * @return the brokeSystemCol9Desc
	 */
	public String getBrokeSystemCol9Desc() {
		return brokeSystemCol9Desc;
	}

	/**
	 * @param brokeSystemCol9Desc
	 *            the brokeSystemCol9Desc to set
	 */
	public void setBrokeSystemCol9Desc(String brokeSystemCol9Desc) {
		this.brokeSystemCol9Desc = brokeSystemCol9Desc;
	}

	/**
	 * @return the brokeSystemCol10Desc
	 */
	public String getBrokeSystemCol10Desc() {
		return brokeSystemCol10Desc;
	}

	/**
	 * @param brokeSystemCol10Desc
	 *            the brokeSystemCol10Desc to set
	 */
	public void setBrokeSystemCol10Desc(String brokeSystemCol10Desc) {
		this.brokeSystemCol10Desc = brokeSystemCol10Desc;
	}

	/**
	 * @return the brokeSystemCol11Desc
	 */
	public String getBrokeSystemCol11Desc() {
		return brokeSystemCol11Desc;
	}

	/**
	 * @param brokeSystemCol11Desc
	 *            the brokeSystemCol11Desc to set
	 */
	public void setBrokeSystemCol11Desc(String brokeSystemCol11Desc) {
		this.brokeSystemCol11Desc = brokeSystemCol11Desc;
	}

	/**
	 * @return the saveAllCol1
	 */
	public String getSaveAllCol1() {
		return saveAllCol1;
	}

	/**
	 * @param saveAllCol1
	 *            the saveAllCol1 to set
	 */
	public void setSaveAllCol1(String saveAllCol1) {
		this.saveAllCol1 = saveAllCol1;
	}

	/**
	 * @return the saveAllCol2
	 */
	public boolean isSaveAllCol2() {
		return saveAllCol2;
	}

	/**
	 * @param saveAllCol2
	 *            the saveAllCol2 to set
	 */
	public void setSaveAllCol2(boolean saveAllCol2) {
		this.saveAllCol2 = saveAllCol2;
	}

	/**
	 * @return the saveAllCol3
	 */
	public boolean isSaveAllCol3() {
		return saveAllCol3;
	}

	/**
	 * @param saveAllCol3
	 *            the saveAllCol3 to set
	 */
	public void setSaveAllCol3(boolean saveAllCol3) {
		this.saveAllCol3 = saveAllCol3;
	}

	/**
	 * @return the saveAllCol4Inbound
	 */
	public String getSaveAllCol4Inbound() {
		return saveAllCol4Inbound;
	}

	/**
	 * @param saveAllCol4Inbound
	 *            the saveAllCol4Inbound to set
	 */
	public void setSaveAllCol4Inbound(String saveAllCol4Inbound) {
		this.saveAllCol4Inbound = saveAllCol4Inbound;
	}

	/**
	 * @return the saveAllCol4Outbound
	 */
	public String getSaveAllCol4Outbound() {
		return saveAllCol4Outbound;
	}

	/**
	 * @param saveAllCol4Outbound
	 *            the saveAllCol4Outbound to set
	 */
	public void setSaveAllCol4Outbound(String saveAllCol4Outbound) {
		this.saveAllCol4Outbound = saveAllCol4Outbound;
	}

	/**
	 * @return the saveAllCol5
	 */
	public boolean isSaveAllCol5() {
		return saveAllCol5;
	}

	/**
	 * @param saveAllCol5
	 *            the saveAllCol5 to set
	 */
	public void setSaveAllCol5(boolean saveAllCol5) {
		this.saveAllCol5 = saveAllCol5;
	}

	/**
	 * @return the saveAllCol6
	 */
	public boolean isSaveAllCol6() {
		return saveAllCol6;
	}

	/**
	 * @param saveAllCol6
	 *            the saveAllCol6 to set
	 */
	public void setSaveAllCol6(boolean saveAllCol6) {
		this.saveAllCol6 = saveAllCol6;
	}

	/**
	 * @return the saveAllCol1Desc
	 */
	public String getSaveAllCol1Desc() {
		return saveAllCol1Desc;
	}

	/**
	 * @param saveAllCol1Desc
	 *            the saveAllCol1Desc to set
	 */
	public void setSaveAllCol1Desc(String saveAllCol1Desc) {
		this.saveAllCol1Desc = saveAllCol1Desc;
	}

	/**
	 * @return the saveAllCol2Desc
	 */
	public String getSaveAllCol2Desc() {
		return saveAllCol2Desc;
	}

	/**
	 * @param saveAllCol2Desc
	 *            the saveAllCol2Desc to set
	 */
	public void setSaveAllCol2Desc(String saveAllCol2Desc) {
		this.saveAllCol2Desc = saveAllCol2Desc;
	}

	/**
	 * @return the saveAllCol3Desc
	 */
	public String getSaveAllCol3Desc() {
		return saveAllCol3Desc;
	}

	/**
	 * @param saveAllCol3Desc
	 *            the saveAllCol3Desc to set
	 */
	public void setSaveAllCol3Desc(String saveAllCol3Desc) {
		this.saveAllCol3Desc = saveAllCol3Desc;
	}

	/**
	 * @return the saveAllCol4Desc
	 */
	public String getSaveAllCol4Desc() {
		return saveAllCol4Desc;
	}

	/**
	 * @param saveAllCol4Desc
	 *            the saveAllCol4Desc to set
	 */
	public void setSaveAllCol4Desc(String saveAllCol4Desc) {
		this.saveAllCol4Desc = saveAllCol4Desc;
	}

	/**
	 * @return the saveAllCol5Desc
	 */
	public String getSaveAllCol5Desc() {
		return saveAllCol5Desc;
	}

	/**
	 * @param saveAllCol5Desc
	 *            the saveAllCol5Desc to set
	 */
	public void setSaveAllCol5Desc(String saveAllCol5Desc) {
		this.saveAllCol5Desc = saveAllCol5Desc;
	}

	/**
	 * @return the saveAllCol6Desc
	 */
	public String getSaveAllCol6Desc() {
		return saveAllCol6Desc;
	}

	/**
	 * @param saveAllCol6Desc
	 *            the saveAllCol6Desc to set
	 */
	public void setSaveAllCol6Desc(String saveAllCol6Desc) {
		this.saveAllCol6Desc = saveAllCol6Desc;
	}

	/**
	 * @return the hydrapulperCol1
	 */
	public boolean isHydrapulperCol1() {
		return hydrapulperCol1;
	}

	/**
	 * @param hydrapulperCol1
	 *            the hydrapulperCol1 to set
	 */
	public void setHydrapulperCol1(boolean hydrapulperCol1) {
		this.hydrapulperCol1 = hydrapulperCol1;
	}

	/**
	 * @return the hydrapulperCol2Inbound
	 */
	public String getHydrapulperCol2Inbound() {
		return hydrapulperCol2Inbound;
	}

	/**
	 * @param hydrapulperCol2Inbound
	 *            the hydrapulperCol2Inbound to set
	 */
	public void setHydrapulperCol2Inbound(String hydrapulperCol2Inbound) {
		this.hydrapulperCol2Inbound = hydrapulperCol2Inbound;
	}

	/**
	 * @return the hydrapulperCol2outbound
	 */
	public String getHydrapulperCol2outbound() {
		return hydrapulperCol2outbound;
	}

	/**
	 * @param hydrapulperCol2outbound
	 *            the hydrapulperCol2outbound to set
	 */
	public void setHydrapulperCol2outbound(String hydrapulperCol2outbound) {
		this.hydrapulperCol2outbound = hydrapulperCol2outbound;
	}

	/**
	 * @return the hydrapulperCol3
	 */
	public boolean isHydrapulperCol3() {
		return hydrapulperCol3;
	}

	/**
	 * @param hydrapulperCol3
	 *            the hydrapulperCol3 to set
	 */
	public void setHydrapulperCol3(boolean hydrapulperCol3) {
		this.hydrapulperCol3 = hydrapulperCol3;
	}

	/**
	 * @return the hydrapulperCol4Inbound
	 */
	public String getHydrapulperCol4Inbound() {
		return hydrapulperCol4Inbound;
	}

	/**
	 * @param hydrapulperCol4Inbound
	 *            the hydrapulperCol4Inbound to set
	 */
	public void setHydrapulperCol4Inbound(String hydrapulperCol4Inbound) {
		this.hydrapulperCol4Inbound = hydrapulperCol4Inbound;
	}

	/**
	 * @return the hydrapulperCol4outbound
	 */
	public String getHydrapulperCol4outbound() {
		return hydrapulperCol4outbound;
	}

	/**
	 * @param hydrapulperCol4outbound
	 *            the hydrapulperCol4outbound to set
	 */
	public void setHydrapulperCol4outbound(String hydrapulperCol4outbound) {
		this.hydrapulperCol4outbound = hydrapulperCol4outbound;
	}

	/**
	 * @return the hydrapulperCol5
	 */
	public boolean isHydrapulperCol5() {
		return hydrapulperCol5;
	}

	/**
	 * @param hydrapulperCol5
	 *            the hydrapulperCol5 to set
	 */
	public void setHydrapulperCol5(boolean hydrapulperCol5) {
		this.hydrapulperCol5 = hydrapulperCol5;
	}

	/**
	 * @return the hydrapulperCol6
	 */
	public boolean isHydrapulperCol6() {
		return hydrapulperCol6;
	}

	/**
	 * @param hydrapulperCol6
	 *            the hydrapulperCol6 to set
	 */
	public void setHydrapulperCol6(boolean hydrapulperCol6) {
		this.hydrapulperCol6 = hydrapulperCol6;
	}

	/**
	 * @return the hydrapulperCol7
	 */
	public boolean isHydrapulperCol7() {
		return hydrapulperCol7;
	}

	/**
	 * @param hydrapulperCol7
	 *            the hydrapulperCol7 to set
	 */
	public void setHydrapulperCol7(boolean hydrapulperCol7) {
		this.hydrapulperCol7 = hydrapulperCol7;
	}

	/**
	 * @return the hydrapulperCol8Inbound
	 */
	public String getHydrapulperCol8Inbound() {
		return hydrapulperCol8Inbound;
	}

	/**
	 * @param hydrapulperCol8Inbound
	 *            the hydrapulperCol8Inbound to set
	 */
	public void setHydrapulperCol8Inbound(String hydrapulperCol8Inbound) {
		this.hydrapulperCol8Inbound = hydrapulperCol8Inbound;
	}

	/**
	 * @return the hydrapulperCol8outbound
	 */
	public String getHydrapulperCol8outbound() {
		return hydrapulperCol8outbound;
	}

	/**
	 * @param hydrapulperCol8outbound
	 *            the hydrapulperCol8outbound to set
	 */
	public void setHydrapulperCol8outbound(String hydrapulperCol8outbound) {
		this.hydrapulperCol8outbound = hydrapulperCol8outbound;
	}

	/**
	 * @return the hydrapulperCol9
	 */
	public boolean isHydrapulperCol9() {
		return hydrapulperCol9;
	}

	/**
	 * @param hydrapulperCol9
	 *            the hydrapulperCol9 to set
	 */
	public void setHydrapulperCol9(boolean hydrapulperCol9) {
		this.hydrapulperCol9 = hydrapulperCol9;
	}

	/**
	 * @return the hydrapulperCol10Inbound
	 */
	public String getHydrapulperCol10Inbound() {
		return hydrapulperCol10Inbound;
	}

	/**
	 * @param hydrapulperCol10Inbound
	 *            the hydrapulperCol10Inbound to set
	 */
	public void setHydrapulperCol10Inbound(String hydrapulperCol10Inbound) {
		this.hydrapulperCol10Inbound = hydrapulperCol10Inbound;
	}

	/**
	 * @return the hydrapulperCol10outbound
	 */
	public String getHydrapulperCol10outbound() {
		return hydrapulperCol10outbound;
	}

	/**
	 * @param hydrapulperCol10outbound
	 *            the hydrapulperCol10outbound to set
	 */
	public void setHydrapulperCol10outbound(String hydrapulperCol10outbound) {
		this.hydrapulperCol10outbound = hydrapulperCol10outbound;
	}

	/**
	 * @return the hydrapulperCol11
	 */
	public boolean isHydrapulperCol11() {
		return hydrapulperCol11;
	}

	/**
	 * @param hydrapulperCol11
	 *            the hydrapulperCol11 to set
	 */
	public void setHydrapulperCol11(boolean hydrapulperCol11) {
		this.hydrapulperCol11 = hydrapulperCol11;
	}

	/**
	 * @return the hydrapulperCol12
	 */
	public boolean isHydrapulperCol12() {
		return hydrapulperCol12;
	}

	/**
	 * @param hydrapulperCol12
	 *            the hydrapulperCol12 to set
	 */
	public void setHydrapulperCol12(boolean hydrapulperCol12) {
		this.hydrapulperCol12 = hydrapulperCol12;
	}

	/**
	 * @return the hydrapulperCol13
	 */
	public boolean isHydrapulperCol13() {
		return hydrapulperCol13;
	}

	/**
	 * @param hydrapulperCol13
	 *            the hydrapulperCol13 to set
	 */
	public void setHydrapulperCol13(boolean hydrapulperCol13) {
		this.hydrapulperCol13 = hydrapulperCol13;
	}

	/**
	 * @return the hydrapulperCol14Inbound
	 */
	public String getHydrapulperCol14Inbound() {
		return hydrapulperCol14Inbound;
	}

	/**
	 * @param hydrapulperCol14Inbound
	 *            the hydrapulperCol14Inbound to set
	 */
	public void setHydrapulperCol14Inbound(String hydrapulperCol14Inbound) {
		this.hydrapulperCol14Inbound = hydrapulperCol14Inbound;
	}

	/**
	 * @return the hydrapulperCol14outbound
	 */
	public String getHydrapulperCol14outbound() {
		return hydrapulperCol14outbound;
	}

	/**
	 * @param hydrapulperCol14outbound
	 *            the hydrapulperCol14outbound to set
	 */
	public void setHydrapulperCol14outbound(String hydrapulperCol14outbound) {
		this.hydrapulperCol14outbound = hydrapulperCol14outbound;
	}

	/**
	 * @return the hydrapulperCol15
	 */
	public boolean isHydrapulperCol15() {
		return hydrapulperCol15;
	}

	/**
	 * @param hydrapulperCol15
	 *            the hydrapulperCol15 to set
	 */
	public void setHydrapulperCol15(boolean hydrapulperCol15) {
		this.hydrapulperCol15 = hydrapulperCol15;
	}

	/**
	 * @return the hydrapulperCol16Inbound
	 */
	public String getHydrapulperCol16Inbound() {
		return hydrapulperCol16Inbound;
	}

	/**
	 * @param hydrapulperCol16Inbound
	 *            the hydrapulperCol16Inbound to set
	 */
	public void setHydrapulperCol16Inbound(String hydrapulperCol16Inbound) {
		this.hydrapulperCol16Inbound = hydrapulperCol16Inbound;
	}

	/**
	 * @return the hydrapulperCol16outbound
	 */
	public String getHydrapulperCol16outbound() {
		return hydrapulperCol16outbound;
	}

	/**
	 * @param hydrapulperCol16outbound
	 *            the hydrapulperCol16outbound to set
	 */
	public void setHydrapulperCol16outbound(String hydrapulperCol16outbound) {
		this.hydrapulperCol16outbound = hydrapulperCol16outbound;
	}

	/**
	 * @return the hydrapulperCol1Desc
	 */
	public String getHydrapulperCol1Desc() {
		return hydrapulperCol1Desc;
	}

	/**
	 * @param hydrapulperCol1Desc
	 *            the hydrapulperCol1Desc to set
	 */
	public void setHydrapulperCol1Desc(String hydrapulperCol1Desc) {
		this.hydrapulperCol1Desc = hydrapulperCol1Desc;
	}

	/**
	 * @return the hydrapulperCol2Desc
	 */
	public String getHydrapulperCol2Desc() {
		return hydrapulperCol2Desc;
	}

	/**
	 * @param hydrapulperCol2Desc
	 *            the hydrapulperCol2Desc to set
	 */
	public void setHydrapulperCol2Desc(String hydrapulperCol2Desc) {
		this.hydrapulperCol2Desc = hydrapulperCol2Desc;
	}

	/**
	 * @return the hydrapulperCol3Desc
	 */
	public String getHydrapulperCol3Desc() {
		return hydrapulperCol3Desc;
	}

	/**
	 * @param hydrapulperCol3Desc
	 *            the hydrapulperCol3Desc to set
	 */
	public void setHydrapulperCol3Desc(String hydrapulperCol3Desc) {
		this.hydrapulperCol3Desc = hydrapulperCol3Desc;
	}

	/**
	 * @return the hydrapulperCol4Desc
	 */
	public String getHydrapulperCol4Desc() {
		return hydrapulperCol4Desc;
	}

	/**
	 * @param hydrapulperCol4Desc
	 *            the hydrapulperCol4Desc to set
	 */
	public void setHydrapulperCol4Desc(String hydrapulperCol4Desc) {
		this.hydrapulperCol4Desc = hydrapulperCol4Desc;
	}

	/**
	 * @return the hydrapulperCol5Desc
	 */
	public String getHydrapulperCol5Desc() {
		return hydrapulperCol5Desc;
	}

	/**
	 * @param hydrapulperCol5Desc
	 *            the hydrapulperCol5Desc to set
	 */
	public void setHydrapulperCol5Desc(String hydrapulperCol5Desc) {
		this.hydrapulperCol5Desc = hydrapulperCol5Desc;
	}

	/**
	 * @return the hydrapulperCol6Desc
	 */
	public String getHydrapulperCol6Desc() {
		return hydrapulperCol6Desc;
	}

	/**
	 * @param hydrapulperCol6Desc
	 *            the hydrapulperCol6Desc to set
	 */
	public void setHydrapulperCol6Desc(String hydrapulperCol6Desc) {
		this.hydrapulperCol6Desc = hydrapulperCol6Desc;
	}

	/**
	 * @return the hydrapulperCol7Desc
	 */
	public String getHydrapulperCol7Desc() {
		return hydrapulperCol7Desc;
	}

	/**
	 * @param hydrapulperCol7Desc
	 *            the hydrapulperCol7Desc to set
	 */
	public void setHydrapulperCol7Desc(String hydrapulperCol7Desc) {
		this.hydrapulperCol7Desc = hydrapulperCol7Desc;
	}

	/**
	 * @return the hydrapulperCol8Desc
	 */
	public String getHydrapulperCol8Desc() {
		return hydrapulperCol8Desc;
	}

	/**
	 * @param hydrapulperCol8Desc
	 *            the hydrapulperCol8Desc to set
	 */
	public void setHydrapulperCol8Desc(String hydrapulperCol8Desc) {
		this.hydrapulperCol8Desc = hydrapulperCol8Desc;
	}

	/**
	 * @return the hydrapulperCol9Desc
	 */
	public String getHydrapulperCol9Desc() {
		return hydrapulperCol9Desc;
	}

	/**
	 * @param hydrapulperCol9Desc
	 *            the hydrapulperCol9Desc to set
	 */
	public void setHydrapulperCol9Desc(String hydrapulperCol9Desc) {
		this.hydrapulperCol9Desc = hydrapulperCol9Desc;
	}

	/**
	 * @return the hydrapulperCol10Desc
	 */
	public String getHydrapulperCol10Desc() {
		return hydrapulperCol10Desc;
	}

	/**
	 * @param hydrapulperCol10Desc
	 *            the hydrapulperCol10Desc to set
	 */
	public void setHydrapulperCol10Desc(String hydrapulperCol10Desc) {
		this.hydrapulperCol10Desc = hydrapulperCol10Desc;
	}

	/**
	 * @return the hydrapulperCol11Desc
	 */
	public String getHydrapulperCol11Desc() {
		return hydrapulperCol11Desc;
	}

	/**
	 * @param hydrapulperCol11Desc
	 *            the hydrapulperCol11Desc to set
	 */
	public void setHydrapulperCol11Desc(String hydrapulperCol11Desc) {
		this.hydrapulperCol11Desc = hydrapulperCol11Desc;
	}

	/**
	 * @return the hydrapulperCol12Desc
	 */
	public String getHydrapulperCol12Desc() {
		return hydrapulperCol12Desc;
	}

	/**
	 * @param hydrapulperCol12Desc
	 *            the hydrapulperCol12Desc to set
	 */
	public void setHydrapulperCol12Desc(String hydrapulperCol12Desc) {
		this.hydrapulperCol12Desc = hydrapulperCol12Desc;
	}

	/**
	 * @return the hydrapulperCol13Desc
	 */
	public String getHydrapulperCol13Desc() {
		return hydrapulperCol13Desc;
	}

	/**
	 * @param hydrapulperCol13Desc
	 *            the hydrapulperCol13Desc to set
	 */
	public void setHydrapulperCol13Desc(String hydrapulperCol13Desc) {
		this.hydrapulperCol13Desc = hydrapulperCol13Desc;
	}

	/**
	 * @return the hydrapulperCol14Desc
	 */
	public String getHydrapulperCol14Desc() {
		return hydrapulperCol14Desc;
	}

	/**
	 * @param hydrapulperCol14Desc
	 *            the hydrapulperCol14Desc to set
	 */
	public void setHydrapulperCol14Desc(String hydrapulperCol14Desc) {
		this.hydrapulperCol14Desc = hydrapulperCol14Desc;
	}

	/**
	 * @return the hydrapulperCol15Desc
	 */
	public String getHydrapulperCol15Desc() {
		return hydrapulperCol15Desc;
	}

	/**
	 * @param hydrapulperCol15Desc
	 *            the hydrapulperCol15Desc to set
	 */
	public void setHydrapulperCol15Desc(String hydrapulperCol15Desc) {
		this.hydrapulperCol15Desc = hydrapulperCol15Desc;
	}

	/**
	 * @return the hydrapulperCol16Desc
	 */
	public String getHydrapulperCol16Desc() {
		return hydrapulperCol16Desc;
	}

	/**
	 * @param hydrapulperCol16Desc
	 *            the hydrapulperCol16Desc to set
	 */
	public void setHydrapulperCol16Desc(String hydrapulperCol16Desc) {
		this.hydrapulperCol16Desc = hydrapulperCol16Desc;
	}

	/**
	 * @return the couchPitCol11Inbound
	 */
	public String getCouchPitCol11Inbound() {
		return couchPitCol11Inbound;
	}

	/**
	 * @param couchPitCol11Inbound
	 *            the couchPitCol11Inbound to set
	 */
	public void setCouchPitCol11Inbound(String couchPitCol11Inbound) {
		this.couchPitCol11Inbound = couchPitCol11Inbound;
	}

	/**
	 * @return the couchPitCol11Outbound
	 */
	public String getCouchPitCol11Outbound() {
		return couchPitCol11Outbound;
	}

	/**
	 * @param couchPitCol11Outbound
	 *            the couchPitCol11Outbound to set
	 */
	public void setCouchPitCol11Outbound(String couchPitCol11Outbound) {
		this.couchPitCol11Outbound = couchPitCol11Outbound;
	}

	/**
	 * @return the couchPitCol11Desc
	 */
	public String getCouchPitCol11Desc() {
		return couchPitCol11Desc;
	}

	/**
	 * @param couchPitCol11Desc
	 *            the couchPitCol11Desc to set
	 */
	public void setCouchPitCol11Desc(String couchPitCol11Desc) {
		this.couchPitCol11Desc = couchPitCol11Desc;
	}

	/**
	 * @return the desccol1
	 */
	public String getDesccol1() {
		return desccol1;
	}

	/**
	 * @param desccol1 the desccol1 to set
	 */
	public void setDesccol1(String desccol1) {
		this.desccol1 = desccol1;
	}

	/**
	 * @return the desccol1Desc
	 */
	public String getDesccol1Desc() {
		return desccol1Desc;
	}

	/**
	 * @param desccol1Desc the desccol1Desc to set
	 */
	public void setDesccol1Desc(String desccol1Desc) {
		this.desccol1Desc = desccol1Desc;
	}

	/**
	 * @return the yankeePulperCol1Drain
	 */
	public boolean isYankeePulperCol1Drain() {
		return yankeePulperCol1Drain;
	}

	/**
	 * @param yankeePulperCol1Drain the yankeePulperCol1Drain to set
	 */
	public void setYankeePulperCol1Drain(boolean yankeePulperCol1Drain) {
		this.yankeePulperCol1Drain = yankeePulperCol1Drain;
	}

	/**
	 * @return the yankeePulperCol1DrainDesc
	 */
	public String getYankeePulperCol1DrainDesc() {
		return yankeePulperCol1DrainDesc;
	}

	/**
	 * @param yankeePulperCol1DrainDesc the yankeePulperCol1DrainDesc to set
	 */
	public void setYankeePulperCol1DrainDesc(String yankeePulperCol1DrainDesc) {
		this.yankeePulperCol1DrainDesc = yankeePulperCol1DrainDesc;
	}

	/**
	 * @return the yankeePumplerCol1Drain
	 */
	public boolean isYankeePumplerCol1Drain() {
		return yankeePumplerCol1Drain;
	}

	/**
	 * @param yankeePumplerCol1Drain the yankeePumplerCol1Drain to set
	 */
	public void setYankeePumplerCol1Drain(boolean yankeePumplerCol1Drain) {
		this.yankeePumplerCol1Drain = yankeePumplerCol1Drain;
	}

	/**
	 * @return the yankeePumplerCol1DrainDesc
	 */
	public String getYankeePumplerCol1DrainDesc() {
		return yankeePumplerCol1DrainDesc;
	}

	/**
	 * @param yankeePumplerCol1DrainDesc the yankeePumplerCol1DrainDesc to set
	 */
	public void setYankeePumplerCol1DrainDesc(String yankeePumplerCol1DrainDesc) {
		this.yankeePumplerCol1DrainDesc = yankeePumplerCol1DrainDesc;
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

	public boolean isEffluentsamplerworkingcondition() {
		return effluentsamplerworkingcondition;
	}

	public void setEffluentsamplerworkingcondition(
			boolean effluentsamplerworkingcondition) {
		this.effluentsamplerworkingcondition = effluentsamplerworkingcondition;
	}

	public String getEffluentsamplerworkingconditionDesc() {
		return effluentsamplerworkingconditionDesc;
	}

	public void setEffluentsamplerworkingconditionDesc(
			String effluentsamplerworkingconditionDesc) {
		this.effluentsamplerworkingconditionDesc = effluentsamplerworkingconditionDesc;
	}

	 

}
