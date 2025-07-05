/**
 *Jun 21, 2016
 *MachineTender.java
 * TODO
 *com.st.obcc.model
 *MachineTender.java
 *Sunil Singh Bora
 */
package com.st.obcc.model;

/**
 * @author snavhaal
 *
 */
public class MachineTender {

	private int id;
	private String position;
	private String operatorName;
	private String edate;
	private String crew;
	private String shift;

	private boolean machinedown;
	private String formingSectionCol1;
	private String formingSectionCol2;
	private String formingSectionCol3;
	private String formingSectionCol4;
	private String formingSectionCol5;
	private String formingSectionCol6;
	private String formingSectionCol7;
	private String formingSectionCol8;
	private String formingSectionCol9;
	private String formingSectionCol10;
	private String formingSectionCol11;
	private String formingSectionCol12;
	private boolean formingSectionCol13;
	private boolean formingSectionCol14;

	private String formingSectionCol1Desc;
	private String formingSectionCol2Desc;
	private String formingSectionCol3Desc;
	private String formingSectionCol4Desc;
	private String formingSectionCol5Desc;
	private String formingSectionCol6Desc;
	private String formingSectionCol7Desc;
	private String formingSectionCol8Desc;
	private String formingSectionCol9Desc;
	private String formingSectionCol10Desc;
	private String formingSectionCol11Desc;
	private String formingSectionCol12Desc;
	private String formingSectionCol13Desc;
	private String formingSectionCol14Desc;

	private String suctionPressureRollCol1;
	private String suctionPressureRollCol2;
	private String suctionPressureRollCol3;
	private String suctionPressureRollCol4;
	private String suctionPressureRollCol5;
	private String suctionPressureRollCol6;
	private boolean suctionPressureRollCol7;

	private String suctionPressureRollCol1Desc;
	private String suctionPressureRollCol2Desc;
	private String suctionPressureRollCol3Desc;
	private String suctionPressureRollCol4Desc;
	private String suctionPressureRollCol5Desc;
	private String suctionPressureRollCol6Desc;
	private String suctionPressureRollCol7Desc;

	private String yankeeDryerCol1;
	private String yankeeDryerCol2;
	private boolean yankeeDryerCol3;
	private String yankeeDryerCol4;
	private boolean yankeeDryerCol5;

	private String yankeeDryerCol1Desc;
	private String yankeeDryerCol2Desc;
	private String yankeeDryerCol3Desc;
	private String yankeeDryerCol4Desc;
	private String yankeeDryerCol5Desc;

	private String driveRollCol1;
	private String driveRollCol2;
	private String driveRollCol3;
	private String driveRollCol4;
	private String driveRollCol5;
	private String driveRollCol6;
	private String driveRollCol7;
	private String driveRollCol8;

	private String driveRollCol1Desc;
	private String driveRollCol2Desc;
	private String driveRollCol3Desc;
	private String driveRollCol4Desc;
	private String driveRollCol5Desc;
	private String driveRollCol6Desc;
	private String driveRollCol7Desc;
	private String driveRollCol8Desc;

	private String pressSectionCol1;
	private String pressSectionCol2;
	private String pressSectionCol3;
	private String pressSectionCol4;
	private String pressSectionCol5;
	private boolean pressSectionCol6;
	private String pressSectionCol7;
	private boolean pressSectionCol8;

	private String pressSectionCol1Desc;
	private String pressSectionCol2Desc;
	private String pressSectionCol3Desc;
	private String pressSectionCol4Desc;
	private String pressSectionCol5Desc;
	private String pressSectionCol6Desc;
	private String pressSectionCol7Desc;
	private String pressSectionCol8Desc;

	private String upperPressCol1;
	private String upperPressCol2;
	private boolean upperPressCol3;
	private boolean upperPressCol4;
	private boolean upperPressCol5;
	private boolean upperPressCol6;
	private boolean upperPressCol7;
	private boolean upperPressCol8;
	private String upperPressCol9;

	private String upperPressCol1Desc;
	private String upperPressCol2Desc;
	private String upperPressCol3Desc;
	private String upperPressCol4Desc;
	private String upperPressCol5Desc;
	private String upperPressCol6Desc;
	private String upperPressCol7Desc;
	private String upperPressCol8Desc;
	private String upperPressCol9Desc;

	private String chemicalTotesCol1;
	private String chemicalTotesCol2;
	private String chemicalTotesCol3;
	private String chemicalTotesCol4;
	private String chemicalTotesCol5;

	private String chemicalTotesCol1Desc;
	private String chemicalTotesCol2Desc;
	private String chemicalTotesCol3Desc;
	private String chemicalTotesCol4Desc;
	private String chemicalTotesCol5Desc;

	private String fanPumpCol1;
	private boolean fanPumpCol2;
	
	private String fanPumpCol3Inbound;
	private String fanPumpCol3Outbound;
	
	//private boolean fanPumpCol3;
	private String fanPumpCol4Inbound;
	private String fanPumpCol4Outbound;

	private String fanPumpCol1Desc;
	private String fanPumpCol2Desc;
	private String fanPumpCol3Desc;
	private String fanPumpCol4Desc;

	private String selectifierScreenCol1;
	private String selectifierScreenCol2;
	private String selectifierScreenCol3;
	
	private String selectifierScreenCol4Inbound;
	private String selectifierScreenCol4Outbound;
	
	private String selectifierScreenCol5;
	
	private String selectifierScreenCol6Inbound;
	private String selectifierScreenCol6Outbound;
	
	private String selectifierScreenCol7;
	private boolean selectifierScreenCol8;
	
	private String selectifierScreenCol9Inbound;
	private String selectifierScreenCol9Outbound;
	
	private boolean selectifierScreenCol10;
	
	private String selectifierScreenCol11Inbound;
	private String selectifierScreenCol11Outbound;

	private String selectifierScreenCol1Desc;
	private String selectifierScreenCol2Desc;
	private String selectifierScreenCol3Desc;
	private String selectifierScreenCol4Desc;
	private String selectifierScreenCol5Desc;
	private String selectifierScreenCol6Desc;
	private String selectifierScreenCol7Desc;
	private String selectifierScreenCol8Desc;
	private String selectifierScreenCol9Desc;
	private String selectifierScreenCol10Desc;
	private String selectifierScreenCol11Desc;

	private boolean vacumePumpCol1;
	private boolean vacumePumpCol2;
	
	private boolean vacumePumpCol3;
	
	private String vacumePumpCol4Inbound;
	private String vacumePumpCol4Outbound;
	
	private String vacumePumpCol5Inbound;
	private String vacumePumpCol5Outbound;
	
	 
	private boolean vacumePumpCol6;
	
	private String vacumePumpCol7Inbound;
	private String vacumePumpCol7Outbound;
	
	private boolean vacumePumpCol8;
	
	private String vacumePumpCol9;
	private String vacumePumpCol10;
	
	private boolean vacumePumpCol11;
	
	
	private String vacumePumpCol12;
	private String vacumePumpCol13;
	
	private boolean vacumePumpCol14;
	
	private String vacumePumpCol15Inbound;
	private String vacumePumpCol15Outbound;
	
	
	private boolean vacumePumpCol16;
	
	private String vacumePumpCol17;
	
	private String vacumePumpCol18;
	
	private boolean vacumePumpCol19;
	
	private String vacumePumpCol20;
	
	private String vacumePumpCol21;
	
	private boolean vacumePumpCol22;
	
	private String vacumePumpCol23;
	private String vacumePumpCol24;
	
	private boolean vacumePumpCol25;
	
	
	private String vacumePumpCol26;
	private String vacumePumpCol27;
	
	private boolean vacumePumpCol28;
	
	private String vacumePumpCol29;
	private String vacumePumpCol30;
	
	private boolean vacumePumpCol31;
	
	private String vacumePumpCol32;
	private String vacumePumpCol33;
	
	private boolean vacumePumpCol34;
	
	private String vacumePumpCol35;
	private String vacumePumpCol36;

	private String vacumePumpCol1Desc;
	private String vacumePumpCol2Desc;
	private String vacumePumpCol3Desc;
	private String vacumePumpCol4Desc;
	private String vacumePumpCol5Desc;
	private String vacumePumpCol6Desc;
	private String vacumePumpCol7Desc;
	private String vacumePumpCol8Desc;
	private String vacumePumpCol9Desc;
	private String vacumePumpCol10Desc;
	private String vacumePumpCol11Desc;
	private String vacumePumpCol12Desc;
	private String vacumePumpCol13Desc;
	private String vacumePumpCol14Desc;
	private String vacumePumpCol15Desc;
	private String vacumePumpCol16Desc;
	private String vacumePumpCol17Desc;
	private String vacumePumpCol18Desc;
	private String vacumePumpCol19Desc;
	private String vacumePumpCol20Desc;
	private String vacumePumpCol21Desc;
	private String vacumePumpCol22Desc;
	private String vacumePumpCol23Desc;
	private String vacumePumpCol24Desc;
	private String vacumePumpCol25Desc;
	private String vacumePumpCol26Desc;
	private String vacumePumpCol27Desc;
	private String vacumePumpCol28Desc;
	private String vacumePumpCol29Desc;
	private String vacumePumpCol30Desc;
	private String vacumePumpCol31Desc;
	private String vacumePumpCol32Desc;
	private String vacumePumpCol33Desc;
	private String vacumePumpCol34Desc;
	private String vacumePumpCol35Desc;
	private String vacumePumpCol36Desc;

	private String riverWaterCol1;
	private String riverWaterCol2;
	private String riverWaterCol1Out;
	private String riverWaterCol2Out;
	private String riverWaterCol1Desc;
	private String riverWaterCol2Desc;
	
	private boolean showercol1;
	private String  showercol2North;
	private String  showercol2South;
	private boolean showercol3;
	private String  showercol4North;
	private String  showercol4South;
	private boolean showercol5;
	private String  showercol6North;
	private String  showercol6South;
	private String  showercol7;
	private String showercol7Out;
	private String  showercol1Desc;
	private String  showercol2Desc;
	private String  showercol3Desc;
	private String  showercol4Desc;
	private String  showercol5Desc;
	private String  showercol6Desc;
	private String  showercol7Desc;
	
	private boolean fillupcentcol1;
	private boolean fillupcentcol2;
	private boolean fillupcentcol3;
	private boolean fillupcentcol4;
	private boolean fillupcentcol5;
	private String fillupcentcol6;
	private String fillupcentcol7;
	private boolean fillupcentcol8;
	private boolean fillupcentcol9;
	
	
	
	
	private String fillupcentcol1Desc;
	private String fillupcentcol2Desc;
	private String fillupcentcol3Desc;
	private String fillupcentcol4Desc;
	private String fillupcentcol5Desc;
	private String fillupcentcol6Desc;
	private String fillupcentcol7Desc;
	private String fillupcentcol8Desc;
	private String fillupcentcol9Desc;
	
	private int processbarpercentage;
	
	private double percentage;
	
	private boolean checkheadboxaircompressorintelfiltercleanliness;
	private String checkheadboxaircompressorintelfiltercleanlinessdesc;
	
	private boolean headboxairfilterscleaning;
	private String headboxairfilterscleaningdesc;
	
	
	private boolean checkairfilterforheadbox;
	private String checkairfilterforheadboxremark;
	
	
	private boolean blowwetendanddryendmotor;
	private String blowwetendanddryendmotorremark;
	
	private boolean rotatingShowers;
	private String  rotatingShowersremark;
	private boolean rotationShowersValve;
	private String  rotationShowersValveremark;
	
	
	
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
	 * @return the formingSectionCol1
	 */
	public String getFormingSectionCol1() {
		return formingSectionCol1;
	}
	/**
	 * @param formingSectionCol1 the formingSectionCol1 to set
	 */
	public void setFormingSectionCol1(String formingSectionCol1) {
		this.formingSectionCol1 = formingSectionCol1;
	}
	/**
	 * @return the formingSectionCol2
	 */
	public String getFormingSectionCol2() {
		return formingSectionCol2;
	}
	/**
	 * @param formingSectionCol2 the formingSectionCol2 to set
	 */
	public void setFormingSectionCol2(String formingSectionCol2) {
		this.formingSectionCol2 = formingSectionCol2;
	}
	/**
	 * @return the formingSectionCol3
	 */
	public String getFormingSectionCol3() {
		return formingSectionCol3;
	}
	/**
	 * @param formingSectionCol3 the formingSectionCol3 to set
	 */
	public void setFormingSectionCol3(String formingSectionCol3) {
		this.formingSectionCol3 = formingSectionCol3;
	}
	/**
	 * @return the formingSectionCol4
	 */
	public String getFormingSectionCol4() {
		return formingSectionCol4;
	}
	/**
	 * @param formingSectionCol4 the formingSectionCol4 to set
	 */
	public void setFormingSectionCol4(String formingSectionCol4) {
		this.formingSectionCol4 = formingSectionCol4;
	}
	/**
	 * @return the formingSectionCol5
	 */
	public String getFormingSectionCol5() {
		return formingSectionCol5;
	}
	/**
	 * @param formingSectionCol5 the formingSectionCol5 to set
	 */
	public void setFormingSectionCol5(String formingSectionCol5) {
		this.formingSectionCol5 = formingSectionCol5;
	}
	/**
	 * @return the formingSectionCol6
	 */
	public String getFormingSectionCol6() {
		return formingSectionCol6;
	}
	/**
	 * @param formingSectionCol6 the formingSectionCol6 to set
	 */
	public void setFormingSectionCol6(String formingSectionCol6) {
		this.formingSectionCol6 = formingSectionCol6;
	}
	/**
	 * @return the formingSectionCol7
	 */
	public String getFormingSectionCol7() {
		return formingSectionCol7;
	}
	/**
	 * @param formingSectionCol7 the formingSectionCol7 to set
	 */
	public void setFormingSectionCol7(String formingSectionCol7) {
		this.formingSectionCol7 = formingSectionCol7;
	}
	/**
	 * @return the formingSectionCol8
	 */
	public String getFormingSectionCol8() {
		return formingSectionCol8;
	}
	/**
	 * @param formingSectionCol8 the formingSectionCol8 to set
	 */
	public void setFormingSectionCol8(String formingSectionCol8) {
		this.formingSectionCol8 = formingSectionCol8;
	}
	/**
	 * @return the formingSectionCol9
	 */
	public String getFormingSectionCol9() {
		return formingSectionCol9;
	}
	/**
	 * @param formingSectionCol9 the formingSectionCol9 to set
	 */
	public void setFormingSectionCol9(String formingSectionCol9) {
		this.formingSectionCol9 = formingSectionCol9;
	}
	/**
	 * @return the formingSectionCol10
	 */
	public String getFormingSectionCol10() {
		return formingSectionCol10;
	}
	/**
	 * @param formingSectionCol10 the formingSectionCol10 to set
	 */
	public void setFormingSectionCol10(String formingSectionCol10) {
		this.formingSectionCol10 = formingSectionCol10;
	}
	/**
	 * @return the formingSectionCol11
	 */
	public String getFormingSectionCol11() {
		return formingSectionCol11;
	}
	/**
	 * @param formingSectionCol11 the formingSectionCol11 to set
	 */
	public void setFormingSectionCol11(String formingSectionCol11) {
		this.formingSectionCol11 = formingSectionCol11;
	}
	/**
	 * @return the formingSectionCol12
	 */
	public String getFormingSectionCol12() {
		return formingSectionCol12;
	}
	/**
	 * @param formingSectionCol12 the formingSectionCol12 to set
	 */
	public void setFormingSectionCol12(String formingSectionCol12) {
		this.formingSectionCol12 = formingSectionCol12;
	}
	/**
	 * @return the formingSectionCol13
	 */
	public boolean isFormingSectionCol13() {
		return formingSectionCol13;
	}
	/**
	 * @param formingSectionCol13 the formingSectionCol13 to set
	 */
	public void setFormingSectionCol13(boolean formingSectionCol13) {
		this.formingSectionCol13 = formingSectionCol13;
	}
	/**
	 * @return the formingSectionCol14
	 */
	public boolean isFormingSectionCol14() {
		return formingSectionCol14;
	}
	/**
	 * @param formingSectionCol14 the formingSectionCol14 to set
	 */
	public void setFormingSectionCol14(boolean formingSectionCol14) {
		this.formingSectionCol14 = formingSectionCol14;
	}
	/**
	 * @return the formingSectionCol1Desc
	 */
	public String getFormingSectionCol1Desc() {
		return formingSectionCol1Desc;
	}
	/**
	 * @param formingSectionCol1Desc the formingSectionCol1Desc to set
	 */
	public void setFormingSectionCol1Desc(String formingSectionCol1Desc) {
		this.formingSectionCol1Desc = formingSectionCol1Desc;
	}
	/**
	 * @return the formingSectionCol2Desc
	 */
	public String getFormingSectionCol2Desc() {
		return formingSectionCol2Desc;
	}
	/**
	 * @param formingSectionCol2Desc the formingSectionCol2Desc to set
	 */
	public void setFormingSectionCol2Desc(String formingSectionCol2Desc) {
		this.formingSectionCol2Desc = formingSectionCol2Desc;
	}
	/**
	 * @return the formingSectionCol3Desc
	 */
	public String getFormingSectionCol3Desc() {
		return formingSectionCol3Desc;
	}
	/**
	 * @param formingSectionCol3Desc the formingSectionCol3Desc to set
	 */
	public void setFormingSectionCol3Desc(String formingSectionCol3Desc) {
		this.formingSectionCol3Desc = formingSectionCol3Desc;
	}
	/**
	 * @return the formingSectionCol4Desc
	 */
	public String getFormingSectionCol4Desc() {
		return formingSectionCol4Desc;
	}
	/**
	 * @param formingSectionCol4Desc the formingSectionCol4Desc to set
	 */
	public void setFormingSectionCol4Desc(String formingSectionCol4Desc) {
		this.formingSectionCol4Desc = formingSectionCol4Desc;
	}
	/**
	 * @return the formingSectionCol5Desc
	 */
	public String getFormingSectionCol5Desc() {
		return formingSectionCol5Desc;
	}
	/**
	 * @param formingSectionCol5Desc the formingSectionCol5Desc to set
	 */
	public void setFormingSectionCol5Desc(String formingSectionCol5Desc) {
		this.formingSectionCol5Desc = formingSectionCol5Desc;
	}
	/**
	 * @return the formingSectionCol6Desc
	 */
	public String getFormingSectionCol6Desc() {
		return formingSectionCol6Desc;
	}
	/**
	 * @param formingSectionCol6Desc the formingSectionCol6Desc to set
	 */
	public void setFormingSectionCol6Desc(String formingSectionCol6Desc) {
		this.formingSectionCol6Desc = formingSectionCol6Desc;
	}
	/**
	 * @return the formingSectionCol7Desc
	 */
	public String getFormingSectionCol7Desc() {
		return formingSectionCol7Desc;
	}
	/**
	 * @param formingSectionCol7Desc the formingSectionCol7Desc to set
	 */
	public void setFormingSectionCol7Desc(String formingSectionCol7Desc) {
		this.formingSectionCol7Desc = formingSectionCol7Desc;
	}
	/**
	 * @return the formingSectionCol8Desc
	 */
	public String getFormingSectionCol8Desc() {
		return formingSectionCol8Desc;
	}
	/**
	 * @param formingSectionCol8Desc the formingSectionCol8Desc to set
	 */
	public void setFormingSectionCol8Desc(String formingSectionCol8Desc) {
		this.formingSectionCol8Desc = formingSectionCol8Desc;
	}
	/**
	 * @return the formingSectionCol9Desc
	 */
	public String getFormingSectionCol9Desc() {
		return formingSectionCol9Desc;
	}
	/**
	 * @param formingSectionCol9Desc the formingSectionCol9Desc to set
	 */
	public void setFormingSectionCol9Desc(String formingSectionCol9Desc) {
		this.formingSectionCol9Desc = formingSectionCol9Desc;
	}
	/**
	 * @return the formingSectionCol10Desc
	 */
	public String getFormingSectionCol10Desc() {
		return formingSectionCol10Desc;
	}
	/**
	 * @param formingSectionCol10Desc the formingSectionCol10Desc to set
	 */
	public void setFormingSectionCol10Desc(String formingSectionCol10Desc) {
		this.formingSectionCol10Desc = formingSectionCol10Desc;
	}
	/**
	 * @return the formingSectionCol11Desc
	 */
	public String getFormingSectionCol11Desc() {
		return formingSectionCol11Desc;
	}
	/**
	 * @param formingSectionCol11Desc the formingSectionCol11Desc to set
	 */
	public void setFormingSectionCol11Desc(String formingSectionCol11Desc) {
		this.formingSectionCol11Desc = formingSectionCol11Desc;
	}
	/**
	 * @return the formingSectionCol12Desc
	 */
	public String getFormingSectionCol12Desc() {
		return formingSectionCol12Desc;
	}
	/**
	 * @param formingSectionCol12Desc the formingSectionCol12Desc to set
	 */
	public void setFormingSectionCol12Desc(String formingSectionCol12Desc) {
		this.formingSectionCol12Desc = formingSectionCol12Desc;
	}
	/**
	 * @return the formingSectionCol13Desc
	 */
	public String getFormingSectionCol13Desc() {
		return formingSectionCol13Desc;
	}
	/**
	 * @param formingSectionCol13Desc the formingSectionCol13Desc to set
	 */
	public void setFormingSectionCol13Desc(String formingSectionCol13Desc) {
		this.formingSectionCol13Desc = formingSectionCol13Desc;
	}
	/**
	 * @return the formingSectionCol14Desc
	 */
	public String getFormingSectionCol14Desc() {
		return formingSectionCol14Desc;
	}
	/**
	 * @param formingSectionCol14Desc the formingSectionCol14Desc to set
	 */
	public void setFormingSectionCol14Desc(String formingSectionCol14Desc) {
		this.formingSectionCol14Desc = formingSectionCol14Desc;
	}
	/**
	 * @return the suctionPressureRollCol1
	 */
	public String getSuctionPressureRollCol1() {
		return suctionPressureRollCol1;
	}
	/**
	 * @param suctionPressureRollCol1 the suctionPressureRollCol1 to set
	 */
	public void setSuctionPressureRollCol1(String suctionPressureRollCol1) {
		this.suctionPressureRollCol1 = suctionPressureRollCol1;
	}
	/**
	 * @return the suctionPressureRollCol2
	 */
	public String getSuctionPressureRollCol2() {
		return suctionPressureRollCol2;
	}
	/**
	 * @param suctionPressureRollCol2 the suctionPressureRollCol2 to set
	 */
	public void setSuctionPressureRollCol2(String suctionPressureRollCol2) {
		this.suctionPressureRollCol2 = suctionPressureRollCol2;
	}
	/**
	 * @return the suctionPressureRollCol3
	 */
	public String getSuctionPressureRollCol3() {
		return suctionPressureRollCol3;
	}
	/**
	 * @param suctionPressureRollCol3 the suctionPressureRollCol3 to set
	 */
	public void setSuctionPressureRollCol3(String suctionPressureRollCol3) {
		this.suctionPressureRollCol3 = suctionPressureRollCol3;
	}
	/**
	 * @return the suctionPressureRollCol4
	 */
	public String getSuctionPressureRollCol4() {
		return suctionPressureRollCol4;
	}
	/**
	 * @param suctionPressureRollCol4 the suctionPressureRollCol4 to set
	 */
	public void setSuctionPressureRollCol4(String suctionPressureRollCol4) {
		this.suctionPressureRollCol4 = suctionPressureRollCol4;
	}
	/**
	 * @return the suctionPressureRollCol5
	 */
	public String getSuctionPressureRollCol5() {
		return suctionPressureRollCol5;
	}
	/**
	 * @param suctionPressureRollCol5 the suctionPressureRollCol5 to set
	 */
	public void setSuctionPressureRollCol5(String suctionPressureRollCol5) {
		this.suctionPressureRollCol5 = suctionPressureRollCol5;
	}
	/**
	 * @return the suctionPressureRollCol6
	 */
	public String getSuctionPressureRollCol6() {
		return suctionPressureRollCol6;
	}
	/**
	 * @param suctionPressureRollCol6 the suctionPressureRollCol6 to set
	 */
	public void setSuctionPressureRollCol6(String suctionPressureRollCol6) {
		this.suctionPressureRollCol6 = suctionPressureRollCol6;
	}
	/**
	 * @return the suctionPressureRollCol7
	 */
	public boolean isSuctionPressureRollCol7() {
		return suctionPressureRollCol7;
	}
	/**
	 * @param suctionPressureRollCol7 the suctionPressureRollCol7 to set
	 */
	public void setSuctionPressureRollCol7(boolean suctionPressureRollCol7) {
		this.suctionPressureRollCol7 = suctionPressureRollCol7;
	}
	/**
	 * @return the suctionPressureRollCol1Desc
	 */
	public String getSuctionPressureRollCol1Desc() {
		return suctionPressureRollCol1Desc;
	}
	/**
	 * @param suctionPressureRollCol1Desc the suctionPressureRollCol1Desc to set
	 */
	public void setSuctionPressureRollCol1Desc(String suctionPressureRollCol1Desc) {
		this.suctionPressureRollCol1Desc = suctionPressureRollCol1Desc;
	}
	/**
	 * @return the suctionPressureRollCol2Desc
	 */
	public String getSuctionPressureRollCol2Desc() {
		return suctionPressureRollCol2Desc;
	}
	/**
	 * @param suctionPressureRollCol2Desc the suctionPressureRollCol2Desc to set
	 */
	public void setSuctionPressureRollCol2Desc(String suctionPressureRollCol2Desc) {
		this.suctionPressureRollCol2Desc = suctionPressureRollCol2Desc;
	}
	/**
	 * @return the suctionPressureRollCol3Desc
	 */
	public String getSuctionPressureRollCol3Desc() {
		return suctionPressureRollCol3Desc;
	}
	/**
	 * @param suctionPressureRollCol3Desc the suctionPressureRollCol3Desc to set
	 */
	public void setSuctionPressureRollCol3Desc(String suctionPressureRollCol3Desc) {
		this.suctionPressureRollCol3Desc = suctionPressureRollCol3Desc;
	}
	/**
	 * @return the suctionPressureRollCol4Desc
	 */
	public String getSuctionPressureRollCol4Desc() {
		return suctionPressureRollCol4Desc;
	}
	/**
	 * @param suctionPressureRollCol4Desc the suctionPressureRollCol4Desc to set
	 */
	public void setSuctionPressureRollCol4Desc(String suctionPressureRollCol4Desc) {
		this.suctionPressureRollCol4Desc = suctionPressureRollCol4Desc;
	}
	/**
	 * @return the suctionPressureRollCol5Desc
	 */
	public String getSuctionPressureRollCol5Desc() {
		return suctionPressureRollCol5Desc;
	}
	/**
	 * @param suctionPressureRollCol5Desc the suctionPressureRollCol5Desc to set
	 */
	public void setSuctionPressureRollCol5Desc(String suctionPressureRollCol5Desc) {
		this.suctionPressureRollCol5Desc = suctionPressureRollCol5Desc;
	}
	/**
	 * @return the suctionPressureRollCol6Desc
	 */
	public String getSuctionPressureRollCol6Desc() {
		return suctionPressureRollCol6Desc;
	}
	/**
	 * @param suctionPressureRollCol6Desc the suctionPressureRollCol6Desc to set
	 */
	public void setSuctionPressureRollCol6Desc(String suctionPressureRollCol6Desc) {
		this.suctionPressureRollCol6Desc = suctionPressureRollCol6Desc;
	}
	/**
	 * @return the suctionPressureRollCol7Desc
	 */
	public String getSuctionPressureRollCol7Desc() {
		return suctionPressureRollCol7Desc;
	}
	/**
	 * @param suctionPressureRollCol7Desc the suctionPressureRollCol7Desc to set
	 */
	public void setSuctionPressureRollCol7Desc(String suctionPressureRollCol7Desc) {
		this.suctionPressureRollCol7Desc = suctionPressureRollCol7Desc;
	}
	/**
	 * @return the yankeeDryerCol1
	 */
	public String getYankeeDryerCol1() {
		return yankeeDryerCol1;
	}
	/**
	 * @param yankeeDryerCol1 the yankeeDryerCol1 to set
	 */
	public void setYankeeDryerCol1(String yankeeDryerCol1) {
		this.yankeeDryerCol1 = yankeeDryerCol1;
	}
	/**
	 * @return the yankeeDryerCol2
	 */
	public String getYankeeDryerCol2() {
		return yankeeDryerCol2;
	}
	/**
	 * @param yankeeDryerCol2 the yankeeDryerCol2 to set
	 */
	public void setYankeeDryerCol2(String yankeeDryerCol2) {
		this.yankeeDryerCol2 = yankeeDryerCol2;
	}
	/**
	 * @return the yankeeDryerCol3
	 */
	public boolean isYankeeDryerCol3() {
		return yankeeDryerCol3;
	}
	/**
	 * @param yankeeDryerCol3 the yankeeDryerCol3 to set
	 */
	public void setYankeeDryerCol3(boolean yankeeDryerCol3) {
		this.yankeeDryerCol3 = yankeeDryerCol3;
	}
	/**
	 * @return the yankeeDryerCol4
	 */
	public String getYankeeDryerCol4() {
		return yankeeDryerCol4;
	}
	/**
	 * @param yankeeDryerCol4 the yankeeDryerCol4 to set
	 */
	public void setYankeeDryerCol4(String yankeeDryerCol4) {
		this.yankeeDryerCol4 = yankeeDryerCol4;
	}
	/**
	 * @return the yankeeDryerCol5
	 */
	public boolean isYankeeDryerCol5() {
		return yankeeDryerCol5;
	}
	/**
	 * @param yankeeDryerCol5 the yankeeDryerCol5 to set
	 */
	public void setYankeeDryerCol5(boolean yankeeDryerCol5) {
		this.yankeeDryerCol5 = yankeeDryerCol5;
	}
	/**
	 * @return the yankeeDryerCol1Desc
	 */
	public String getYankeeDryerCol1Desc() {
		return yankeeDryerCol1Desc;
	}
	/**
	 * @param yankeeDryerCol1Desc the yankeeDryerCol1Desc to set
	 */
	public void setYankeeDryerCol1Desc(String yankeeDryerCol1Desc) {
		this.yankeeDryerCol1Desc = yankeeDryerCol1Desc;
	}
	/**
	 * @return the yankeeDryerCol2Desc
	 */
	public String getYankeeDryerCol2Desc() {
		return yankeeDryerCol2Desc;
	}
	/**
	 * @param yankeeDryerCol2Desc the yankeeDryerCol2Desc to set
	 */
	public void setYankeeDryerCol2Desc(String yankeeDryerCol2Desc) {
		this.yankeeDryerCol2Desc = yankeeDryerCol2Desc;
	}
	/**
	 * @return the yankeeDryerCol3Desc
	 */
	public String getYankeeDryerCol3Desc() {
		return yankeeDryerCol3Desc;
	}
	/**
	 * @param yankeeDryerCol3Desc the yankeeDryerCol3Desc to set
	 */
	public void setYankeeDryerCol3Desc(String yankeeDryerCol3Desc) {
		this.yankeeDryerCol3Desc = yankeeDryerCol3Desc;
	}
	/**
	 * @return the yankeeDryerCol4Desc
	 */
	public String getYankeeDryerCol4Desc() {
		return yankeeDryerCol4Desc;
	}
	/**
	 * @param yankeeDryerCol4Desc the yankeeDryerCol4Desc to set
	 */
	public void setYankeeDryerCol4Desc(String yankeeDryerCol4Desc) {
		this.yankeeDryerCol4Desc = yankeeDryerCol4Desc;
	}
	/**
	 * @return the yankeeDryerCol5Desc
	 */
	public String getYankeeDryerCol5Desc() {
		return yankeeDryerCol5Desc;
	}
	/**
	 * @param yankeeDryerCol5Desc the yankeeDryerCol5Desc to set
	 */
	public void setYankeeDryerCol5Desc(String yankeeDryerCol5Desc) {
		this.yankeeDryerCol5Desc = yankeeDryerCol5Desc;
	}
	/**
	 * @return the driveRollCol1
	 */
	public String getDriveRollCol1() {
		return driveRollCol1;
	}
	/**
	 * @param driveRollCol1 the driveRollCol1 to set
	 */
	public void setDriveRollCol1(String driveRollCol1) {
		this.driveRollCol1 = driveRollCol1;
	}
	/**
	 * @return the driveRollCol2
	 */
	public String getDriveRollCol2() {
		return driveRollCol2;
	}
	/**
	 * @param driveRollCol2 the driveRollCol2 to set
	 */
	public void setDriveRollCol2(String driveRollCol2) {
		this.driveRollCol2 = driveRollCol2;
	}
	/**
	 * @return the driveRollCol3
	 */
	public String getDriveRollCol3() {
		return driveRollCol3;
	}
	/**
	 * @param driveRollCol3 the driveRollCol3 to set
	 */
	public void setDriveRollCol3(String driveRollCol3) {
		this.driveRollCol3 = driveRollCol3;
	}
	/**
	 * @return the driveRollCol4
	 */
	public String getDriveRollCol4() {
		return driveRollCol4;
	}
	/**
	 * @param driveRollCol4 the driveRollCol4 to set
	 */
	public void setDriveRollCol4(String driveRollCol4) {
		this.driveRollCol4 = driveRollCol4;
	}
	/**
	 * @return the driveRollCol5
	 */
	public String getDriveRollCol5() {
		return driveRollCol5;
	}
	/**
	 * @param driveRollCol5 the driveRollCol5 to set
	 */
	public void setDriveRollCol5(String driveRollCol5) {
		this.driveRollCol5 = driveRollCol5;
	}
	/**
	 * @return the driveRollCol6
	 */
	public String getDriveRollCol6() {
		return driveRollCol6;
	}
	/**
	 * @param driveRollCol6 the driveRollCol6 to set
	 */
	public void setDriveRollCol6(String driveRollCol6) {
		this.driveRollCol6 = driveRollCol6;
	}
	/**
	 * @return the driveRollCol7
	 */
	public String getDriveRollCol7() {
		return driveRollCol7;
	}
	/**
	 * @param driveRollCol7 the driveRollCol7 to set
	 */
	public void setDriveRollCol7(String driveRollCol7) {
		this.driveRollCol7 = driveRollCol7;
	}
	/**
	 * @return the driveRollCol1Desc
	 */
	public String getDriveRollCol1Desc() {
		return driveRollCol1Desc;
	}
	/**
	 * @param driveRollCol1Desc the driveRollCol1Desc to set
	 */
	public void setDriveRollCol1Desc(String driveRollCol1Desc) {
		this.driveRollCol1Desc = driveRollCol1Desc;
	}
	/**
	 * @return the driveRollCol2Desc
	 */
	public String getDriveRollCol2Desc() {
		return driveRollCol2Desc;
	}
	/**
	 * @param driveRollCol2Desc the driveRollCol2Desc to set
	 */
	public void setDriveRollCol2Desc(String driveRollCol2Desc) {
		this.driveRollCol2Desc = driveRollCol2Desc;
	}
	/**
	 * @return the driveRollCol3Desc
	 */
	public String getDriveRollCol3Desc() {
		return driveRollCol3Desc;
	}
	/**
	 * @param driveRollCol3Desc the driveRollCol3Desc to set
	 */
	public void setDriveRollCol3Desc(String driveRollCol3Desc) {
		this.driveRollCol3Desc = driveRollCol3Desc;
	}
	/**
	 * @return the driveRollCol4Desc
	 */
	public String getDriveRollCol4Desc() {
		return driveRollCol4Desc;
	}
	/**
	 * @param driveRollCol4Desc the driveRollCol4Desc to set
	 */
	public void setDriveRollCol4Desc(String driveRollCol4Desc) {
		this.driveRollCol4Desc = driveRollCol4Desc;
	}
	/**
	 * @return the driveRollCol5Desc
	 */
	public String getDriveRollCol5Desc() {
		return driveRollCol5Desc;
	}
	/**
	 * @param driveRollCol5Desc the driveRollCol5Desc to set
	 */
	public void setDriveRollCol5Desc(String driveRollCol5Desc) {
		this.driveRollCol5Desc = driveRollCol5Desc;
	}
	/**
	 * @return the driveRollCol6Desc
	 */
	public String getDriveRollCol6Desc() {
		return driveRollCol6Desc;
	}
	/**
	 * @param driveRollCol6Desc the driveRollCol6Desc to set
	 */
	public void setDriveRollCol6Desc(String driveRollCol6Desc) {
		this.driveRollCol6Desc = driveRollCol6Desc;
	}
	/**
	 * @return the driveRollCol7Desc
	 */
	public String getDriveRollCol7Desc() {
		return driveRollCol7Desc;
	}
	/**
	 * @param driveRollCol7Desc the driveRollCol7Desc to set
	 */
	public void setDriveRollCol7Desc(String driveRollCol7Desc) {
		this.driveRollCol7Desc = driveRollCol7Desc;
	}
	/**
	 * @return the pressSectionCol1
	 */
	public String getPressSectionCol1() {
		return pressSectionCol1;
	}
	/**
	 * @param pressSectionCol1 the pressSectionCol1 to set
	 */
	public void setPressSectionCol1(String pressSectionCol1) {
		this.pressSectionCol1 = pressSectionCol1;
	}
	/**
	 * @return the pressSectionCol2
	 */
	public String getPressSectionCol2() {
		return pressSectionCol2;
	}
	/**
	 * @param pressSectionCol2 the pressSectionCol2 to set
	 */
	public void setPressSectionCol2(String pressSectionCol2) {
		this.pressSectionCol2 = pressSectionCol2;
	}
	/**
	 * @return the pressSectionCol3
	 */
	public String getPressSectionCol3() {
		return pressSectionCol3;
	}
	/**
	 * @param pressSectionCol3 the pressSectionCol3 to set
	 */
	public void setPressSectionCol3(String pressSectionCol3) {
		this.pressSectionCol3 = pressSectionCol3;
	}
	/**
	 * @return the pressSectionCol4
	 */
	public String getPressSectionCol4() {
		return pressSectionCol4;
	}
	/**
	 * @param pressSectionCol4 the pressSectionCol4 to set
	 */
	public void setPressSectionCol4(String pressSectionCol4) {
		this.pressSectionCol4 = pressSectionCol4;
	}
	/**
	 * @return the pressSectionCol5
	 */
	public String getPressSectionCol5() {
		return pressSectionCol5;
	}
	/**
	 * @param pressSectionCol5 the pressSectionCol5 to set
	 */
	public void setPressSectionCol5(String pressSectionCol5) {
		this.pressSectionCol5 = pressSectionCol5;
	}
	/**
	 * @return the pressSectionCol6
	 */
	public boolean isPressSectionCol6() {
		return pressSectionCol6;
	}
	/**
	 * @param pressSectionCol6 the pressSectionCol6 to set
	 */
	public void setPressSectionCol6(boolean pressSectionCol6) {
		this.pressSectionCol6 = pressSectionCol6;
	}
	/**
	 * @return the pressSectionCol7
	 */
	public String getPressSectionCol7() {
		return pressSectionCol7;
	}
	/**
	 * @param pressSectionCol7 the pressSectionCol7 to set
	 */
	public void setPressSectionCol7(String pressSectionCol7) {
		this.pressSectionCol7 = pressSectionCol7;
	}
	/**
	 * @return the pressSectionCol8
	 */
	public boolean isPressSectionCol8() {
		return pressSectionCol8;
	}
	/**
	 * @param pressSectionCol8 the pressSectionCol8 to set
	 */
	public void setPressSectionCol8(boolean pressSectionCol8) {
		this.pressSectionCol8 = pressSectionCol8;
	}
	/**
	 * @return the pressSectionCol1Desc
	 */
	public String getPressSectionCol1Desc() {
		return pressSectionCol1Desc;
	}
	/**
	 * @param pressSectionCol1Desc the pressSectionCol1Desc to set
	 */
	public void setPressSectionCol1Desc(String pressSectionCol1Desc) {
		this.pressSectionCol1Desc = pressSectionCol1Desc;
	}
	/**
	 * @return the pressSectionCol2Desc
	 */
	public String getPressSectionCol2Desc() {
		return pressSectionCol2Desc;
	}
	/**
	 * @param pressSectionCol2Desc the pressSectionCol2Desc to set
	 */
	public void setPressSectionCol2Desc(String pressSectionCol2Desc) {
		this.pressSectionCol2Desc = pressSectionCol2Desc;
	}
	/**
	 * @return the pressSectionCol3Desc
	 */
	public String getPressSectionCol3Desc() {
		return pressSectionCol3Desc;
	}
	/**
	 * @param pressSectionCol3Desc the pressSectionCol3Desc to set
	 */
	public void setPressSectionCol3Desc(String pressSectionCol3Desc) {
		this.pressSectionCol3Desc = pressSectionCol3Desc;
	}
	/**
	 * @return the pressSectionCol4Desc
	 */
	public String getPressSectionCol4Desc() {
		return pressSectionCol4Desc;
	}
	/**
	 * @param pressSectionCol4Desc the pressSectionCol4Desc to set
	 */
	public void setPressSectionCol4Desc(String pressSectionCol4Desc) {
		this.pressSectionCol4Desc = pressSectionCol4Desc;
	}
	/**
	 * @return the pressSectionCol5Desc
	 */
	public String getPressSectionCol5Desc() {
		return pressSectionCol5Desc;
	}
	/**
	 * @param pressSectionCol5Desc the pressSectionCol5Desc to set
	 */
	public void setPressSectionCol5Desc(String pressSectionCol5Desc) {
		this.pressSectionCol5Desc = pressSectionCol5Desc;
	}
	/**
	 * @return the pressSectionCol6Desc
	 */
	public String getPressSectionCol6Desc() {
		return pressSectionCol6Desc;
	}
	/**
	 * @param pressSectionCol6Desc the pressSectionCol6Desc to set
	 */
	public void setPressSectionCol6Desc(String pressSectionCol6Desc) {
		this.pressSectionCol6Desc = pressSectionCol6Desc;
	}
	/**
	 * @return the pressSectionCol7Desc
	 */
	public String getPressSectionCol7Desc() {
		return pressSectionCol7Desc;
	}
	/**
	 * @param pressSectionCol7Desc the pressSectionCol7Desc to set
	 */
	public void setPressSectionCol7Desc(String pressSectionCol7Desc) {
		this.pressSectionCol7Desc = pressSectionCol7Desc;
	}
	/**
	 * @return the pressSectionCol8Desc
	 */
	public String getPressSectionCol8Desc() {
		return pressSectionCol8Desc;
	}
	/**
	 * @param pressSectionCol8Desc the pressSectionCol8Desc to set
	 */
	public void setPressSectionCol8Desc(String pressSectionCol8Desc) {
		this.pressSectionCol8Desc = pressSectionCol8Desc;
	}
	/**
	 * @return the upperPressCol1
	 */
	public String getUpperPressCol1() {
		return upperPressCol1;
	}
	/**
	 * @param upperPressCol1 the upperPressCol1 to set
	 */
	public void setUpperPressCol1(String upperPressCol1) {
		this.upperPressCol1 = upperPressCol1;
	}
	/**
	 * @return the upperPressCol2
	 */
	public String getUpperPressCol2() {
		return upperPressCol2;
	}
	/**
	 * @param upperPressCol2 the upperPressCol2 to set
	 */
	public void setUpperPressCol2(String upperPressCol2) {
		this.upperPressCol2 = upperPressCol2;
	}
	/**
	 * @return the upperPressCol3
	 */
	public boolean isUpperPressCol3() {
		return upperPressCol3;
	}
	/**
	 * @param upperPressCol3 the upperPressCol3 to set
	 */
	public void setUpperPressCol3(boolean upperPressCol3) {
		this.upperPressCol3 = upperPressCol3;
	}
	/**
	 * @return the upperPressCol4
	 */
	public boolean isUpperPressCol4() {
		return upperPressCol4;
	}
	/**
	 * @param upperPressCol4 the upperPressCol4 to set
	 */
	public void setUpperPressCol4(boolean upperPressCol4) {
		this.upperPressCol4 = upperPressCol4;
	}
	/**
	 * @return the upperPressCol5
	 */
	public boolean isUpperPressCol5() {
		return upperPressCol5;
	}
	/**
	 * @param upperPressCol5 the upperPressCol5 to set
	 */
	public void setUpperPressCol5(boolean upperPressCol5) {
		this.upperPressCol5 = upperPressCol5;
	}
	/**
	 * @return the upperPressCol6
	 */
	public boolean isUpperPressCol6() {
		return upperPressCol6;
	}
	/**
	 * @param upperPressCol6 the upperPressCol6 to set
	 */
	public void setUpperPressCol6(boolean upperPressCol6) {
		this.upperPressCol6 = upperPressCol6;
	}
	/**
	 * @return the upperPressCol7
	 */
	public boolean isUpperPressCol7() {
		return upperPressCol7;
	}
	/**
	 * @param upperPressCol7 the upperPressCol7 to set
	 */
	public void setUpperPressCol7(boolean upperPressCol7) {
		this.upperPressCol7 = upperPressCol7;
	}
	/**
	 * @return the upperPressCol8
	 */
	public boolean isUpperPressCol8() {
		return upperPressCol8;
	}
	/**
	 * @param upperPressCol8 the upperPressCol8 to set
	 */
	public void setUpperPressCol8(boolean upperPressCol8) {
		this.upperPressCol8 = upperPressCol8;
	}
	
	/**
	 * @return the upperPressCol1Desc
	 */
	public String getUpperPressCol1Desc() {
		return upperPressCol1Desc;
	}
	/**
	 * @param upperPressCol1Desc the upperPressCol1Desc to set
	 */
	public void setUpperPressCol1Desc(String upperPressCol1Desc) {
		this.upperPressCol1Desc = upperPressCol1Desc;
	}
	/**
	 * @return the upperPressCol2Desc
	 */
	public String getUpperPressCol2Desc() {
		return upperPressCol2Desc;
	}
	/**
	 * @param upperPressCol2Desc the upperPressCol2Desc to set
	 */
	public void setUpperPressCol2Desc(String upperPressCol2Desc) {
		this.upperPressCol2Desc = upperPressCol2Desc;
	}
	/**
	 * @return the upperPressCol3Desc
	 */
	public String getUpperPressCol3Desc() {
		return upperPressCol3Desc;
	}
	/**
	 * @param upperPressCol3Desc the upperPressCol3Desc to set
	 */
	public void setUpperPressCol3Desc(String upperPressCol3Desc) {
		this.upperPressCol3Desc = upperPressCol3Desc;
	}
	/**
	 * @return the upperPressCol4Desc
	 */
	public String getUpperPressCol4Desc() {
		return upperPressCol4Desc;
	}
	/**
	 * @param upperPressCol4Desc the upperPressCol4Desc to set
	 */
	public void setUpperPressCol4Desc(String upperPressCol4Desc) {
		this.upperPressCol4Desc = upperPressCol4Desc;
	}
	/**
	 * @return the upperPressCol5Desc
	 */
	public String getUpperPressCol5Desc() {
		return upperPressCol5Desc;
	}
	/**
	 * @param upperPressCol5Desc the upperPressCol5Desc to set
	 */
	public void setUpperPressCol5Desc(String upperPressCol5Desc) {
		this.upperPressCol5Desc = upperPressCol5Desc;
	}
	/**
	 * @return the upperPressCol6Desc
	 */
	public String getUpperPressCol6Desc() {
		return upperPressCol6Desc;
	}
	/**
	 * @param upperPressCol6Desc the upperPressCol6Desc to set
	 */
	public void setUpperPressCol6Desc(String upperPressCol6Desc) {
		this.upperPressCol6Desc = upperPressCol6Desc;
	}
	/**
	 * @return the upperPressCol7Desc
	 */
	public String getUpperPressCol7Desc() {
		return upperPressCol7Desc;
	}
	/**
	 * @param upperPressCol7Desc the upperPressCol7Desc to set
	 */
	public void setUpperPressCol7Desc(String upperPressCol7Desc) {
		this.upperPressCol7Desc = upperPressCol7Desc;
	}
	/**
	 * @return the upperPressCol8Desc
	 */
	public String getUpperPressCol8Desc() {
		return upperPressCol8Desc;
	}
	/**
	 * @param upperPressCol8Desc the upperPressCol8Desc to set
	 */
	public void setUpperPressCol8Desc(String upperPressCol8Desc) {
		this.upperPressCol8Desc = upperPressCol8Desc;
	}
	/**
	 * @return the upperPressCol9Desc
	 */
	public String getUpperPressCol9Desc() {
		return upperPressCol9Desc;
	}
	/**
	 * @param upperPressCol9Desc the upperPressCol9Desc to set
	 */
	public void setUpperPressCol9Desc(String upperPressCol9Desc) {
		this.upperPressCol9Desc = upperPressCol9Desc;
	}
	/**
	 * @return the chemicalTotesCol1
	 */
	public String getChemicalTotesCol1() {
		return chemicalTotesCol1;
	}
	/**
	 * @param chemicalTotesCol1 the chemicalTotesCol1 to set
	 */
	public void setChemicalTotesCol1(String chemicalTotesCol1) {
		this.chemicalTotesCol1 = chemicalTotesCol1;
	}
	/**
	 * @return the chemicalTotesCol2
	 */
	public String getChemicalTotesCol2() {
		return chemicalTotesCol2;
	}
	/**
	 * @param chemicalTotesCol2 the chemicalTotesCol2 to set
	 */
	public void setChemicalTotesCol2(String chemicalTotesCol2) {
		this.chemicalTotesCol2 = chemicalTotesCol2;
	}
	/**
	 * @return the chemicalTotesCol3
	 */
	public String getChemicalTotesCol3() {
		return chemicalTotesCol3;
	}
	/**
	 * @param chemicalTotesCol3 the chemicalTotesCol3 to set
	 */
	public void setChemicalTotesCol3(String chemicalTotesCol3) {
		this.chemicalTotesCol3 = chemicalTotesCol3;
	}
	/**
	 * @return the chemicalTotesCol4
	 */
	public String getChemicalTotesCol4() {
		return chemicalTotesCol4;
	}
	/**
	 * @param chemicalTotesCol4 the chemicalTotesCol4 to set
	 */
	public void setChemicalTotesCol4(String chemicalTotesCol4) {
		this.chemicalTotesCol4 = chemicalTotesCol4;
	}
	/**
	 * @return the chemicalTotesCol5
	 */
	public String getChemicalTotesCol5() {
		return chemicalTotesCol5;
	}
	/**
	 * @param chemicalTotesCol5 the chemicalTotesCol5 to set
	 */
	public void setChemicalTotesCol5(String chemicalTotesCol5) {
		this.chemicalTotesCol5 = chemicalTotesCol5;
	}
	/**
	 * @return the chemicalTotesCol1Desc
	 */
	public String getChemicalTotesCol1Desc() {
		return chemicalTotesCol1Desc;
	}
	/**
	 * @param chemicalTotesCol1Desc the chemicalTotesCol1Desc to set
	 */
	public void setChemicalTotesCol1Desc(String chemicalTotesCol1Desc) {
		this.chemicalTotesCol1Desc = chemicalTotesCol1Desc;
	}
	/**
	 * @return the chemicalTotesCol2Desc
	 */
	public String getChemicalTotesCol2Desc() {
		return chemicalTotesCol2Desc;
	}
	/**
	 * @param chemicalTotesCol2Desc the chemicalTotesCol2Desc to set
	 */
	public void setChemicalTotesCol2Desc(String chemicalTotesCol2Desc) {
		this.chemicalTotesCol2Desc = chemicalTotesCol2Desc;
	}
	/**
	 * @return the chemicalTotesCol3Desc
	 */
	public String getChemicalTotesCol3Desc() {
		return chemicalTotesCol3Desc;
	}
	/**
	 * @param chemicalTotesCol3Desc the chemicalTotesCol3Desc to set
	 */
	public void setChemicalTotesCol3Desc(String chemicalTotesCol3Desc) {
		this.chemicalTotesCol3Desc = chemicalTotesCol3Desc;
	}
	/**
	 * @return the chemicalTotesCol4Desc
	 */
	public String getChemicalTotesCol4Desc() {
		return chemicalTotesCol4Desc;
	}
	/**
	 * @param chemicalTotesCol4Desc the chemicalTotesCol4Desc to set
	 */
	public void setChemicalTotesCol4Desc(String chemicalTotesCol4Desc) {
		this.chemicalTotesCol4Desc = chemicalTotesCol4Desc;
	}
	/**
	 * @return the chemicalTotesCol5Desc
	 */
	public String getChemicalTotesCol5Desc() {
		return chemicalTotesCol5Desc;
	}
	/**
	 * @param chemicalTotesCol5Desc the chemicalTotesCol5Desc to set
	 */
	public void setChemicalTotesCol5Desc(String chemicalTotesCol5Desc) {
		this.chemicalTotesCol5Desc = chemicalTotesCol5Desc;
	}
	/**
	 * @return the fanPumpCol1
	 */
	public String getFanPumpCol1() {
		return fanPumpCol1;
	}
	/**
	 * @param fanPumpCol1 the fanPumpCol1 to set
	 */
	public void setFanPumpCol1(String fanPumpCol1) {
		this.fanPumpCol1 = fanPumpCol1;
	}
	/**
	 * @return the fanPumpCol2
	 */
	public boolean isFanPumpCol2() {
		return fanPumpCol2;
	}
	/**
	 * @param fanPumpCol2 the fanPumpCol2 to set
	 */
	public void setFanPumpCol2(boolean fanPumpCol2) {
		this.fanPumpCol2 = fanPumpCol2;
	}
	/**
	 * @return the fanPumpCol3Inbound
	 */
	public String getFanPumpCol3Inbound() {
		return fanPumpCol3Inbound;
	}
	/**
	 * @param fanPumpCol3Inbound the fanPumpCol3Inbound to set
	 */
	public void setFanPumpCol3Inbound(String fanPumpCol3Inbound) {
		this.fanPumpCol3Inbound = fanPumpCol3Inbound;
	}
	/**
	 * @return the fanPumpCol3Outbound
	 */
	public String getFanPumpCol3Outbound() {
		return fanPumpCol3Outbound;
	}
	/**
	 * @param fanPumpCol3Outbound the fanPumpCol3Outbound to set
	 */
	public void setFanPumpCol3Outbound(String fanPumpCol3Outbound) {
		this.fanPumpCol3Outbound = fanPumpCol3Outbound;
	}
	/**
	 * @return the fanPumpCol4Inbound
	 */
	public String getFanPumpCol4Inbound() {
		return fanPumpCol4Inbound;
	}
	/**
	 * @param fanPumpCol4Inbound the fanPumpCol4Inbound to set
	 */
	public void setFanPumpCol4Inbound(String fanPumpCol4Inbound) {
		this.fanPumpCol4Inbound = fanPumpCol4Inbound;
	}
	/**
	 * @return the fanPumpCol4Outbound
	 */
	public String getFanPumpCol4Outbound() {
		return fanPumpCol4Outbound;
	}
	/**
	 * @param fanPumpCol4Outbound the fanPumpCol4Outbound to set
	 */
	public void setFanPumpCol4Outbound(String fanPumpCol4Outbound) {
		this.fanPumpCol4Outbound = fanPumpCol4Outbound;
	}
	/**
	 * @return the fanPumpCol1Desc
	 */
	public String getFanPumpCol1Desc() {
		return fanPumpCol1Desc;
	}
	/**
	 * @param fanPumpCol1Desc the fanPumpCol1Desc to set
	 */
	public void setFanPumpCol1Desc(String fanPumpCol1Desc) {
		this.fanPumpCol1Desc = fanPumpCol1Desc;
	}
	/**
	 * @return the fanPumpCol2Desc
	 */
	public String getFanPumpCol2Desc() {
		return fanPumpCol2Desc;
	}
	/**
	 * @param fanPumpCol2Desc the fanPumpCol2Desc to set
	 */
	public void setFanPumpCol2Desc(String fanPumpCol2Desc) {
		this.fanPumpCol2Desc = fanPumpCol2Desc;
	}
	/**
	 * @return the fanPumpCol3Desc
	 */
	public String getFanPumpCol3Desc() {
		return fanPumpCol3Desc;
	}
	/**
	 * @param fanPumpCol3Desc the fanPumpCol3Desc to set
	 */
	public void setFanPumpCol3Desc(String fanPumpCol3Desc) {
		this.fanPumpCol3Desc = fanPumpCol3Desc;
	}
	/**
	 * @return the fanPumpCol4Desc
	 */
	public String getFanPumpCol4Desc() {
		return fanPumpCol4Desc;
	}
	/**
	 * @param fanPumpCol4Desc the fanPumpCol4Desc to set
	 */
	public void setFanPumpCol4Desc(String fanPumpCol4Desc) {
		this.fanPumpCol4Desc = fanPumpCol4Desc;
	}
	/**
	 * @return the selectifierScreenCol1
	 */
	public String getSelectifierScreenCol1() {
		return selectifierScreenCol1;
	}
	/**
	 * @param selectifierScreenCol1 the selectifierScreenCol1 to set
	 */
	public void setSelectifierScreenCol1(String selectifierScreenCol1) {
		this.selectifierScreenCol1 = selectifierScreenCol1;
	}
	/**
	 * @return the selectifierScreenCol2
	 */
	public String getSelectifierScreenCol2() {
		return selectifierScreenCol2;
	}
	/**
	 * @param selectifierScreenCol2 the selectifierScreenCol2 to set
	 */
	public void setSelectifierScreenCol2(String selectifierScreenCol2) {
		this.selectifierScreenCol2 = selectifierScreenCol2;
	}
	/**
	 * @return the selectifierScreenCol3
	 */
	public String getSelectifierScreenCol3() {
		return selectifierScreenCol3;
	}
	/**
	 * @param selectifierScreenCol3 the selectifierScreenCol3 to set
	 */
	public void setSelectifierScreenCol3(String selectifierScreenCol3) {
		this.selectifierScreenCol3 = selectifierScreenCol3;
	}
	/**
	 * @return the selectifierScreenCol4Inbound
	 */
	public String getSelectifierScreenCol4Inbound() {
		return selectifierScreenCol4Inbound;
	}
	/**
	 * @param selectifierScreenCol4Inbound the selectifierScreenCol4Inbound to set
	 */
	public void setSelectifierScreenCol4Inbound(String selectifierScreenCol4Inbound) {
		this.selectifierScreenCol4Inbound = selectifierScreenCol4Inbound;
	}
	/**
	 * @return the selectifierScreenCol4Outbound
	 */
	public String getSelectifierScreenCol4Outbound() {
		return selectifierScreenCol4Outbound;
	}
	/**
	 * @param selectifierScreenCol4Outbound the selectifierScreenCol4Outbound to set
	 */
	public void setSelectifierScreenCol4Outbound(
			String selectifierScreenCol4Outbound) {
		this.selectifierScreenCol4Outbound = selectifierScreenCol4Outbound;
	}
	/**
	 * @return the selectifierScreenCol5
	 */
	public String getSelectifierScreenCol5() {
		return selectifierScreenCol5;
	}
	/**
	 * @param selectifierScreenCol5 the selectifierScreenCol5 to set
	 */
	public void setSelectifierScreenCol5(String selectifierScreenCol5) {
		this.selectifierScreenCol5 = selectifierScreenCol5;
	}
	/**
	 * @return the selectifierScreenCol6Inbound
	 */
	public String getSelectifierScreenCol6Inbound() {
		return selectifierScreenCol6Inbound;
	}
	/**
	 * @param selectifierScreenCol6Inbound the selectifierScreenCol6Inbound to set
	 */
	public void setSelectifierScreenCol6Inbound(String selectifierScreenCol6Inbound) {
		this.selectifierScreenCol6Inbound = selectifierScreenCol6Inbound;
	}
	/**
	 * @return the selectifierScreenCol6Outbound
	 */
	public String getSelectifierScreenCol6Outbound() {
		return selectifierScreenCol6Outbound;
	}
	/**
	 * @param selectifierScreenCol6Outbound the selectifierScreenCol6Outbound to set
	 */
	public void setSelectifierScreenCol6Outbound(
			String selectifierScreenCol6Outbound) {
		this.selectifierScreenCol6Outbound = selectifierScreenCol6Outbound;
	}
	/**
	 * @return the selectifierScreenCol7
	 */
	public String getSelectifierScreenCol7() {
		return selectifierScreenCol7;
	}
	/**
	 * @param selectifierScreenCol7 the selectifierScreenCol7 to set
	 */
	public void setSelectifierScreenCol7(String selectifierScreenCol7) {
		this.selectifierScreenCol7 = selectifierScreenCol7;
	}
	/**
	 * @return the selectifierScreenCol8
	 */
	public boolean isSelectifierScreenCol8() {
		return selectifierScreenCol8;
	}
	/**
	 * @param selectifierScreenCol8 the selectifierScreenCol8 to set
	 */
	public void setSelectifierScreenCol8(boolean selectifierScreenCol8) {
		this.selectifierScreenCol8 = selectifierScreenCol8;
	}
	/**
	 * @return the selectifierScreenCol9Inbound
	 */
	public String getSelectifierScreenCol9Inbound() {
		return selectifierScreenCol9Inbound;
	}
	/**
	 * @param selectifierScreenCol9Inbound the selectifierScreenCol9Inbound to set
	 */
	public void setSelectifierScreenCol9Inbound(String selectifierScreenCol9Inbound) {
		this.selectifierScreenCol9Inbound = selectifierScreenCol9Inbound;
	}
	/**
	 * @return the selectifierScreenCol9Outbound
	 */
	public String getSelectifierScreenCol9Outbound() {
		return selectifierScreenCol9Outbound;
	}
	/**
	 * @param selectifierScreenCol9Outbound the selectifierScreenCol9Outbound to set
	 */
	public void setSelectifierScreenCol9Outbound(
			String selectifierScreenCol9Outbound) {
		this.selectifierScreenCol9Outbound = selectifierScreenCol9Outbound;
	}
	/**
	 * @return the selectifierScreenCol10
	 */
	public boolean isSelectifierScreenCol10() {
		return selectifierScreenCol10;
	}
	/**
	 * @param selectifierScreenCol10 the selectifierScreenCol10 to set
	 */
	public void setSelectifierScreenCol10(boolean selectifierScreenCol10) {
		this.selectifierScreenCol10 = selectifierScreenCol10;
	}
	/**
	 * @return the selectifierScreenCol11Inbound
	 */
	public String getSelectifierScreenCol11Inbound() {
		return selectifierScreenCol11Inbound;
	}
	/**
	 * @param selectifierScreenCol11Inbound the selectifierScreenCol11Inbound to set
	 */
	public void setSelectifierScreenCol11Inbound(
			String selectifierScreenCol11Inbound) {
		this.selectifierScreenCol11Inbound = selectifierScreenCol11Inbound;
	}
	/**
	 * @return the selectifierScreenCol11Outbound
	 */
	public String getSelectifierScreenCol11Outbound() {
		return selectifierScreenCol11Outbound;
	}
	/**
	 * @param selectifierScreenCol11Outbound the selectifierScreenCol11Outbound to set
	 */
	public void setSelectifierScreenCol11Outbound(
			String selectifierScreenCol11Outbound) {
		this.selectifierScreenCol11Outbound = selectifierScreenCol11Outbound;
	}
	/**
	 * @return the selectifierScreenCol1Desc
	 */
	public String getSelectifierScreenCol1Desc() {
		return selectifierScreenCol1Desc;
	}
	/**
	 * @param selectifierScreenCol1Desc the selectifierScreenCol1Desc to set
	 */
	public void setSelectifierScreenCol1Desc(String selectifierScreenCol1Desc) {
		this.selectifierScreenCol1Desc = selectifierScreenCol1Desc;
	}
	/**
	 * @return the selectifierScreenCol2Desc
	 */
	public String getSelectifierScreenCol2Desc() {
		return selectifierScreenCol2Desc;
	}
	/**
	 * @param selectifierScreenCol2Desc the selectifierScreenCol2Desc to set
	 */
	public void setSelectifierScreenCol2Desc(String selectifierScreenCol2Desc) {
		this.selectifierScreenCol2Desc = selectifierScreenCol2Desc;
	}
	/**
	 * @return the selectifierScreenCol3Desc
	 */
	public String getSelectifierScreenCol3Desc() {
		return selectifierScreenCol3Desc;
	}
	/**
	 * @param selectifierScreenCol3Desc the selectifierScreenCol3Desc to set
	 */
	public void setSelectifierScreenCol3Desc(String selectifierScreenCol3Desc) {
		this.selectifierScreenCol3Desc = selectifierScreenCol3Desc;
	}
	/**
	 * @return the selectifierScreenCol4Desc
	 */
	public String getSelectifierScreenCol4Desc() {
		return selectifierScreenCol4Desc;
	}
	/**
	 * @param selectifierScreenCol4Desc the selectifierScreenCol4Desc to set
	 */
	public void setSelectifierScreenCol4Desc(String selectifierScreenCol4Desc) {
		this.selectifierScreenCol4Desc = selectifierScreenCol4Desc;
	}
	/**
	 * @return the selectifierScreenCol5Desc
	 */
	public String getSelectifierScreenCol5Desc() {
		return selectifierScreenCol5Desc;
	}
	/**
	 * @param selectifierScreenCol5Desc the selectifierScreenCol5Desc to set
	 */
	public void setSelectifierScreenCol5Desc(String selectifierScreenCol5Desc) {
		this.selectifierScreenCol5Desc = selectifierScreenCol5Desc;
	}
	/**
	 * @return the selectifierScreenCol6Desc
	 */
	public String getSelectifierScreenCol6Desc() {
		return selectifierScreenCol6Desc;
	}
	/**
	 * @param selectifierScreenCol6Desc the selectifierScreenCol6Desc to set
	 */
	public void setSelectifierScreenCol6Desc(String selectifierScreenCol6Desc) {
		this.selectifierScreenCol6Desc = selectifierScreenCol6Desc;
	}
	/**
	 * @return the selectifierScreenCol7Desc
	 */
	public String getSelectifierScreenCol7Desc() {
		return selectifierScreenCol7Desc;
	}
	/**
	 * @param selectifierScreenCol7Desc the selectifierScreenCol7Desc to set
	 */
	public void setSelectifierScreenCol7Desc(String selectifierScreenCol7Desc) {
		this.selectifierScreenCol7Desc = selectifierScreenCol7Desc;
	}
	/**
	 * @return the selectifierScreenCol8Desc
	 */
	public String getSelectifierScreenCol8Desc() {
		return selectifierScreenCol8Desc;
	}
	/**
	 * @param selectifierScreenCol8Desc the selectifierScreenCol8Desc to set
	 */
	public void setSelectifierScreenCol8Desc(String selectifierScreenCol8Desc) {
		this.selectifierScreenCol8Desc = selectifierScreenCol8Desc;
	}
	/**
	 * @return the selectifierScreenCol9Desc
	 */
	public String getSelectifierScreenCol9Desc() {
		return selectifierScreenCol9Desc;
	}
	/**
	 * @param selectifierScreenCol9Desc the selectifierScreenCol9Desc to set
	 */
	public void setSelectifierScreenCol9Desc(String selectifierScreenCol9Desc) {
		this.selectifierScreenCol9Desc = selectifierScreenCol9Desc;
	}
	/**
	 * @return the selectifierScreenCol10Desc
	 */
	public String getSelectifierScreenCol10Desc() {
		return selectifierScreenCol10Desc;
	}
	/**
	 * @param selectifierScreenCol10Desc the selectifierScreenCol10Desc to set
	 */
	public void setSelectifierScreenCol10Desc(String selectifierScreenCol10Desc) {
		this.selectifierScreenCol10Desc = selectifierScreenCol10Desc;
	}
	/**
	 * @return the selectifierScreenCol11Desc
	 */
	public String getSelectifierScreenCol11Desc() {
		return selectifierScreenCol11Desc;
	}
	/**
	 * @param selectifierScreenCol11Desc the selectifierScreenCol11Desc to set
	 */
	public void setSelectifierScreenCol11Desc(String selectifierScreenCol11Desc) {
		this.selectifierScreenCol11Desc = selectifierScreenCol11Desc;
	}
	/**
	 * @return the vacumePumpCol1
	 */
	public boolean isVacumePumpCol1() {
		return vacumePumpCol1;
	}
	/**
	 * @param vacumePumpCol1 the vacumePumpCol1 to set
	 */
	public void setVacumePumpCol1(boolean vacumePumpCol1) {
		this.vacumePumpCol1 = vacumePumpCol1;
	}
	/**
	 * @return the vacumePumpCol2
	 */
	public boolean isVacumePumpCol2() {
		return vacumePumpCol2;
	}
	/**
	 * @param vacumePumpCol2 the vacumePumpCol2 to set
	 */
	public void setVacumePumpCol2(boolean vacumePumpCol2) {
		this.vacumePumpCol2 = vacumePumpCol2;
	}
	/**
	 * @return the vacumePumpCol3
	 */
	public boolean isVacumePumpCol3() {
		return vacumePumpCol3;
	}
	/**
	 * @param vacumePumpCol3 the vacumePumpCol3 to set
	 */
	public void setVacumePumpCol3(boolean vacumePumpCol3) {
		this.vacumePumpCol3 = vacumePumpCol3;
	}
	/**
	 * @return the vacumePumpCol4Inbound
	 */
	public String getVacumePumpCol4Inbound() {
		return vacumePumpCol4Inbound;
	}
	/**
	 * @param vacumePumpCol4Inbound the vacumePumpCol4Inbound to set
	 */
	public void setVacumePumpCol4Inbound(String vacumePumpCol4Inbound) {
		this.vacumePumpCol4Inbound = vacumePumpCol4Inbound;
	}
	/**
	 * @return the vacumePumpCol4Outbound
	 */
	public String getVacumePumpCol4Outbound() {
		return vacumePumpCol4Outbound;
	}
	/**
	 * @param vacumePumpCol4Outbound the vacumePumpCol4Outbound to set
	 */
	public void setVacumePumpCol4Outbound(String vacumePumpCol4Outbound) {
		this.vacumePumpCol4Outbound = vacumePumpCol4Outbound;
	}
	/**
	 * @return the vacumePumpCol5Inbound
	 */
	public String getVacumePumpCol5Inbound() {
		return vacumePumpCol5Inbound;
	}
	/**
	 * @param vacumePumpCol5Inbound the vacumePumpCol5Inbound to set
	 */
	public void setVacumePumpCol5Inbound(String vacumePumpCol5Inbound) {
		this.vacumePumpCol5Inbound = vacumePumpCol5Inbound;
	}
	/**
	 * @return the vacumePumpCol5Outbound
	 */
	public String getVacumePumpCol5Outbound() {
		return vacumePumpCol5Outbound;
	}
	/**
	 * @param vacumePumpCol5Outbound the vacumePumpCol5Outbound to set
	 */
	public void setVacumePumpCol5Outbound(String vacumePumpCol5Outbound) {
		this.vacumePumpCol5Outbound = vacumePumpCol5Outbound;
	}
	/**
	 * @return the vacumePumpCol6
	 */
	public boolean isVacumePumpCol6() {
		return vacumePumpCol6;
	}
	/**
	 * @param vacumePumpCol6 the vacumePumpCol6 to set
	 */
	public void setVacumePumpCol6(boolean vacumePumpCol6) {
		this.vacumePumpCol6 = vacumePumpCol6;
	}
	/**
	 * @return the vacumePumpCol7Inbound
	 */
	public String getVacumePumpCol7Inbound() {
		return vacumePumpCol7Inbound;
	}
	/**
	 * @param vacumePumpCol7Inbound the vacumePumpCol7Inbound to set
	 */
	public void setVacumePumpCol7Inbound(String vacumePumpCol7Inbound) {
		this.vacumePumpCol7Inbound = vacumePumpCol7Inbound;
	}
	/**
	 * @return the vacumePumpCol7Outbound
	 */
	public String getVacumePumpCol7Outbound() {
		return vacumePumpCol7Outbound;
	}
	/**
	 * @param vacumePumpCol7Outbound the vacumePumpCol7Outbound to set
	 */
	public void setVacumePumpCol7Outbound(String vacumePumpCol7Outbound) {
		this.vacumePumpCol7Outbound = vacumePumpCol7Outbound;
	}
	/**
	 * @return the vacumePumpCol8
	 */
	public boolean isVacumePumpCol8() {
		return vacumePumpCol8;
	}
	/**
	 * @param vacumePumpCol8 the vacumePumpCol8 to set
	 */
	public void setVacumePumpCol8(boolean vacumePumpCol8) {
		this.vacumePumpCol8 = vacumePumpCol8;
	}
	/**
	 * @return the vacumePumpCol9
	 */
	public String getVacumePumpCol9() {
		return vacumePumpCol9;
	}
	/**
	 * @param vacumePumpCol9 the vacumePumpCol9 to set
	 */
	public void setVacumePumpCol9(String vacumePumpCol9) {
		this.vacumePumpCol9 = vacumePumpCol9;
	}
	/**
	 * @return the vacumePumpCol10
	 */
	public String getVacumePumpCol10() {
		return vacumePumpCol10;
	}
	/**
	 * @param vacumePumpCol10 the vacumePumpCol10 to set
	 */
	public void setVacumePumpCol10(String vacumePumpCol10) {
		this.vacumePumpCol10 = vacumePumpCol10;
	}
	/**
	 * @return the vacumePumpCol11
	 */
	public boolean isVacumePumpCol11() {
		return vacumePumpCol11;
	}
	/**
	 * @param vacumePumpCol11 the vacumePumpCol11 to set
	 */
	public void setVacumePumpCol11(boolean vacumePumpCol11) {
		this.vacumePumpCol11 = vacumePumpCol11;
	}
	/**
	 * @return the vacumePumpCol12
	 */
	public String getVacumePumpCol12() {
		return vacumePumpCol12;
	}
	/**
	 * @param vacumePumpCol12 the vacumePumpCol12 to set
	 */
	public void setVacumePumpCol12(String vacumePumpCol12) {
		this.vacumePumpCol12 = vacumePumpCol12;
	}
	/**
	 * @return the vacumePumpCol13
	 */
	public String getVacumePumpCol13() {
		return vacumePumpCol13;
	}
	/**
	 * @param vacumePumpCol13 the vacumePumpCol13 to set
	 */
	public void setVacumePumpCol13(String vacumePumpCol13) {
		this.vacumePumpCol13 = vacumePumpCol13;
	}
	/**
	 * @return the vacumePumpCol14
	 */
	public boolean isVacumePumpCol14() {
		return vacumePumpCol14;
	}
	/**
	 * @param vacumePumpCol14 the vacumePumpCol14 to set
	 */
	public void setVacumePumpCol14(boolean vacumePumpCol14) {
		this.vacumePumpCol14 = vacumePumpCol14;
	}
	/**
	 * @return the vacumePumpCol15Inbound
	 */
	public String getVacumePumpCol15Inbound() {
		return vacumePumpCol15Inbound;
	}
	/**
	 * @param vacumePumpCol15Inbound the vacumePumpCol15Inbound to set
	 */
	public void setVacumePumpCol15Inbound(String vacumePumpCol15Inbound) {
		this.vacumePumpCol15Inbound = vacumePumpCol15Inbound;
	}
	/**
	 * @return the vacumePumpCol15Outbound
	 */
	public String getVacumePumpCol15Outbound() {
		return vacumePumpCol15Outbound;
	}
	/**
	 * @param vacumePumpCol15Outbound the vacumePumpCol15Outbound to set
	 */
	public void setVacumePumpCol15Outbound(String vacumePumpCol15Outbound) {
		this.vacumePumpCol15Outbound = vacumePumpCol15Outbound;
	}
	/**
	 * @return the vacumePumpCol16
	 */
	public boolean isVacumePumpCol16() {
		return vacumePumpCol16;
	}
	/**
	 * @param vacumePumpCol16 the vacumePumpCol16 to set
	 */
	public void setVacumePumpCol16(boolean vacumePumpCol16) {
		this.vacumePumpCol16 = vacumePumpCol16;
	}
	/**
	 * @return the vacumePumpCol17
	 */
	public String getVacumePumpCol17() {
		return vacumePumpCol17;
	}
	/**
	 * @param vacumePumpCol17 the vacumePumpCol17 to set
	 */
	public void setVacumePumpCol17(String vacumePumpCol17) {
		this.vacumePumpCol17 = vacumePumpCol17;
	}
	/**
	 * @return the vacumePumpCol18
	 */
	public String getVacumePumpCol18() {
		return vacumePumpCol18;
	}
	/**
	 * @param vacumePumpCol18 the vacumePumpCol18 to set
	 */
	public void setVacumePumpCol18(String vacumePumpCol18) {
		this.vacumePumpCol18 = vacumePumpCol18;
	}
	/**
	 * @return the vacumePumpCol19
	 */
	public boolean isVacumePumpCol19() {
		return vacumePumpCol19;
	}
	/**
	 * @param vacumePumpCol19 the vacumePumpCol19 to set
	 */
	public void setVacumePumpCol19(boolean vacumePumpCol19) {
		this.vacumePumpCol19 = vacumePumpCol19;
	}
	/**
	 * @return the vacumePumpCol20
	 */
	public String getVacumePumpCol20() {
		return vacumePumpCol20;
	}
	/**
	 * @param vacumePumpCol20 the vacumePumpCol20 to set
	 */
	public void setVacumePumpCol20(String vacumePumpCol20) {
		this.vacumePumpCol20 = vacumePumpCol20;
	}
	/**
	 * @return the vacumePumpCol21
	 */
	public String getVacumePumpCol21() {
		return vacumePumpCol21;
	}
	/**
	 * @param vacumePumpCol21 the vacumePumpCol21 to set
	 */
	public void setVacumePumpCol21(String vacumePumpCol21) {
		this.vacumePumpCol21 = vacumePumpCol21;
	}
	/**
	 * @return the vacumePumpCol22
	 */
	public boolean isVacumePumpCol22() {
		return vacumePumpCol22;
	}
	/**
	 * @param vacumePumpCol22 the vacumePumpCol22 to set
	 */
	public void setVacumePumpCol22(boolean vacumePumpCol22) {
		this.vacumePumpCol22 = vacumePumpCol22;
	}
	/**
	 * @return the vacumePumpCol23
	 */
	public String getVacumePumpCol23() {
		return vacumePumpCol23;
	}
	/**
	 * @param vacumePumpCol23 the vacumePumpCol23 to set
	 */
	public void setVacumePumpCol23(String vacumePumpCol23) {
		this.vacumePumpCol23 = vacumePumpCol23;
	}
	/**
	 * @return the vacumePumpCol24
	 */
	public String getVacumePumpCol24() {
		return vacumePumpCol24;
	}
	/**
	 * @param vacumePumpCol24 the vacumePumpCol24 to set
	 */
	public void setVacumePumpCol24(String vacumePumpCol24) {
		this.vacumePumpCol24 = vacumePumpCol24;
	}
	/**
	 * @return the vacumePumpCol25
	 */
	public boolean isVacumePumpCol25() {
		return vacumePumpCol25;
	}
	/**
	 * @param vacumePumpCol25 the vacumePumpCol25 to set
	 */
	public void setVacumePumpCol25(boolean vacumePumpCol25) {
		this.vacumePumpCol25 = vacumePumpCol25;
	}
	/**
	 * @return the vacumePumpCol26
	 */
	public String getVacumePumpCol26() {
		return vacumePumpCol26;
	}
	/**
	 * @param vacumePumpCol26 the vacumePumpCol26 to set
	 */
	public void setVacumePumpCol26(String vacumePumpCol26) {
		this.vacumePumpCol26 = vacumePumpCol26;
	}
	/**
	 * @return the vacumePumpCol27
	 */
	public String getVacumePumpCol27() {
		return vacumePumpCol27;
	}
	/**
	 * @param vacumePumpCol27 the vacumePumpCol27 to set
	 */
	public void setVacumePumpCol27(String vacumePumpCol27) {
		this.vacumePumpCol27 = vacumePumpCol27;
	}
	/**
	 * @return the vacumePumpCol28
	 */
	public boolean isVacumePumpCol28() {
		return vacumePumpCol28;
	}
	/**
	 * @param vacumePumpCol28 the vacumePumpCol28 to set
	 */
	public void setVacumePumpCol28(boolean vacumePumpCol28) {
		this.vacumePumpCol28 = vacumePumpCol28;
	}
	/**
	 * @return the vacumePumpCol29
	 */
	public String getVacumePumpCol29() {
		return vacumePumpCol29;
	}
	/**
	 * @param vacumePumpCol29 the vacumePumpCol29 to set
	 */
	public void setVacumePumpCol29(String vacumePumpCol29) {
		this.vacumePumpCol29 = vacumePumpCol29;
	}
	/**
	 * @return the vacumePumpCol30
	 */
	public String getVacumePumpCol30() {
		return vacumePumpCol30;
	}
	/**
	 * @param vacumePumpCol30 the vacumePumpCol30 to set
	 */
	public void setVacumePumpCol30(String vacumePumpCol30) {
		this.vacumePumpCol30 = vacumePumpCol30;
	}
	/**
	 * @return the vacumePumpCol31
	 */
	public boolean isVacumePumpCol31() {
		return vacumePumpCol31;
	}
	/**
	 * @param vacumePumpCol31 the vacumePumpCol31 to set
	 */
	public void setVacumePumpCol31(boolean vacumePumpCol31) {
		this.vacumePumpCol31 = vacumePumpCol31;
	}
	/**
	 * @return the vacumePumpCol32
	 */
	public String getVacumePumpCol32() {
		return vacumePumpCol32;
	}
	/**
	 * @param vacumePumpCol32 the vacumePumpCol32 to set
	 */
	public void setVacumePumpCol32(String vacumePumpCol32) {
		this.vacumePumpCol32 = vacumePumpCol32;
	}
	/**
	 * @return the vacumePumpCol33
	 */
	public String getVacumePumpCol33() {
		return vacumePumpCol33;
	}
	/**
	 * @param vacumePumpCol33 the vacumePumpCol33 to set
	 */
	public void setVacumePumpCol33(String vacumePumpCol33) {
		this.vacumePumpCol33 = vacumePumpCol33;
	}
	/**
	 * @return the vacumePumpCol34
	 */
	public boolean isVacumePumpCol34() {
		return vacumePumpCol34;
	}
	/**
	 * @param vacumePumpCol34 the vacumePumpCol34 to set
	 */
	public void setVacumePumpCol34(boolean vacumePumpCol34) {
		this.vacumePumpCol34 = vacumePumpCol34;
	}
	/**
	 * @return the vacumePumpCol35
	 */
	public String getVacumePumpCol35() {
		return vacumePumpCol35;
	}
	/**
	 * @param vacumePumpCol35 the vacumePumpCol35 to set
	 */
	public void setVacumePumpCol35(String vacumePumpCol35) {
		this.vacumePumpCol35 = vacumePumpCol35;
	}
	/**
	 * @return the vacumePumpCol36
	 */
	public String getVacumePumpCol36() {
		return vacumePumpCol36;
	}
	/**
	 * @param vacumePumpCol36 the vacumePumpCol36 to set
	 */
	public void setVacumePumpCol36(String vacumePumpCol36) {
		this.vacumePumpCol36 = vacumePumpCol36;
	}
	/**
	 * @return the vacumePumpCol1Desc
	 */
	public String getVacumePumpCol1Desc() {
		return vacumePumpCol1Desc;
	}
	/**
	 * @param vacumePumpCol1Desc the vacumePumpCol1Desc to set
	 */
	public void setVacumePumpCol1Desc(String vacumePumpCol1Desc) {
		this.vacumePumpCol1Desc = vacumePumpCol1Desc;
	}
	/**
	 * @return the vacumePumpCol2Desc
	 */
	public String getVacumePumpCol2Desc() {
		return vacumePumpCol2Desc;
	}
	/**
	 * @param vacumePumpCol2Desc the vacumePumpCol2Desc to set
	 */
	public void setVacumePumpCol2Desc(String vacumePumpCol2Desc) {
		this.vacumePumpCol2Desc = vacumePumpCol2Desc;
	}
	/**
	 * @return the vacumePumpCol3Desc
	 */
	public String getVacumePumpCol3Desc() {
		return vacumePumpCol3Desc;
	}
	/**
	 * @param vacumePumpCol3Desc the vacumePumpCol3Desc to set
	 */
	public void setVacumePumpCol3Desc(String vacumePumpCol3Desc) {
		this.vacumePumpCol3Desc = vacumePumpCol3Desc;
	}
	/**
	 * @return the vacumePumpCol4Desc
	 */
	public String getVacumePumpCol4Desc() {
		return vacumePumpCol4Desc;
	}
	/**
	 * @param vacumePumpCol4Desc the vacumePumpCol4Desc to set
	 */
	public void setVacumePumpCol4Desc(String vacumePumpCol4Desc) {
		this.vacumePumpCol4Desc = vacumePumpCol4Desc;
	}
	/**
	 * @return the vacumePumpCol5Desc
	 */
	public String getVacumePumpCol5Desc() {
		return vacumePumpCol5Desc;
	}
	/**
	 * @param vacumePumpCol5Desc the vacumePumpCol5Desc to set
	 */
	public void setVacumePumpCol5Desc(String vacumePumpCol5Desc) {
		this.vacumePumpCol5Desc = vacumePumpCol5Desc;
	}
	/**
	 * @return the vacumePumpCol6Desc
	 */
	public String getVacumePumpCol6Desc() {
		return vacumePumpCol6Desc;
	}
	/**
	 * @param vacumePumpCol6Desc the vacumePumpCol6Desc to set
	 */
	public void setVacumePumpCol6Desc(String vacumePumpCol6Desc) {
		this.vacumePumpCol6Desc = vacumePumpCol6Desc;
	}
	/**
	 * @return the vacumePumpCol7Desc
	 */
	public String getVacumePumpCol7Desc() {
		return vacumePumpCol7Desc;
	}
	/**
	 * @param vacumePumpCol7Desc the vacumePumpCol7Desc to set
	 */
	public void setVacumePumpCol7Desc(String vacumePumpCol7Desc) {
		this.vacumePumpCol7Desc = vacumePumpCol7Desc;
	}
	/**
	 * @return the vacumePumpCol8Desc
	 */
	public String getVacumePumpCol8Desc() {
		return vacumePumpCol8Desc;
	}
	/**
	 * @param vacumePumpCol8Desc the vacumePumpCol8Desc to set
	 */
	public void setVacumePumpCol8Desc(String vacumePumpCol8Desc) {
		this.vacumePumpCol8Desc = vacumePumpCol8Desc;
	}
	/**
	 * @return the vacumePumpCol9Desc
	 */
	public String getVacumePumpCol9Desc() {
		return vacumePumpCol9Desc;
	}
	/**
	 * @param vacumePumpCol9Desc the vacumePumpCol9Desc to set
	 */
	public void setVacumePumpCol9Desc(String vacumePumpCol9Desc) {
		this.vacumePumpCol9Desc = vacumePumpCol9Desc;
	}
	/**
	 * @return the vacumePumpCol10Desc
	 */
	public String getVacumePumpCol10Desc() {
		return vacumePumpCol10Desc;
	}
	/**
	 * @param vacumePumpCol10Desc the vacumePumpCol10Desc to set
	 */
	public void setVacumePumpCol10Desc(String vacumePumpCol10Desc) {
		this.vacumePumpCol10Desc = vacumePumpCol10Desc;
	}
	/**
	 * @return the vacumePumpCol11Desc
	 */
	public String getVacumePumpCol11Desc() {
		return vacumePumpCol11Desc;
	}
	/**
	 * @param vacumePumpCol11Desc the vacumePumpCol11Desc to set
	 */
	public void setVacumePumpCol11Desc(String vacumePumpCol11Desc) {
		this.vacumePumpCol11Desc = vacumePumpCol11Desc;
	}
	/**
	 * @return the vacumePumpCol12Desc
	 */
	public String getVacumePumpCol12Desc() {
		return vacumePumpCol12Desc;
	}
	/**
	 * @param vacumePumpCol12Desc the vacumePumpCol12Desc to set
	 */
	public void setVacumePumpCol12Desc(String vacumePumpCol12Desc) {
		this.vacumePumpCol12Desc = vacumePumpCol12Desc;
	}
	/**
	 * @return the vacumePumpCol13Desc
	 */
	public String getVacumePumpCol13Desc() {
		return vacumePumpCol13Desc;
	}
	/**
	 * @param vacumePumpCol13Desc the vacumePumpCol13Desc to set
	 */
	public void setVacumePumpCol13Desc(String vacumePumpCol13Desc) {
		this.vacumePumpCol13Desc = vacumePumpCol13Desc;
	}
	/**
	 * @return the vacumePumpCol14Desc
	 */
	public String getVacumePumpCol14Desc() {
		return vacumePumpCol14Desc;
	}
	/**
	 * @param vacumePumpCol14Desc the vacumePumpCol14Desc to set
	 */
	public void setVacumePumpCol14Desc(String vacumePumpCol14Desc) {
		this.vacumePumpCol14Desc = vacumePumpCol14Desc;
	}
	/**
	 * @return the vacumePumpCol15Desc
	 */
	public String getVacumePumpCol15Desc() {
		return vacumePumpCol15Desc;
	}
	/**
	 * @param vacumePumpCol15Desc the vacumePumpCol15Desc to set
	 */
	public void setVacumePumpCol15Desc(String vacumePumpCol15Desc) {
		this.vacumePumpCol15Desc = vacumePumpCol15Desc;
	}
	/**
	 * @return the vacumePumpCol16Desc
	 */
	public String getVacumePumpCol16Desc() {
		return vacumePumpCol16Desc;
	}
	/**
	 * @param vacumePumpCol16Desc the vacumePumpCol16Desc to set
	 */
	public void setVacumePumpCol16Desc(String vacumePumpCol16Desc) {
		this.vacumePumpCol16Desc = vacumePumpCol16Desc;
	}
	/**
	 * @return the vacumePumpCol17Desc
	 */
	public String getVacumePumpCol17Desc() {
		return vacumePumpCol17Desc;
	}
	/**
	 * @param vacumePumpCol17Desc the vacumePumpCol17Desc to set
	 */
	public void setVacumePumpCol17Desc(String vacumePumpCol17Desc) {
		this.vacumePumpCol17Desc = vacumePumpCol17Desc;
	}
	/**
	 * @return the vacumePumpCol18Desc
	 */
	public String getVacumePumpCol18Desc() {
		return vacumePumpCol18Desc;
	}
	/**
	 * @param vacumePumpCol18Desc the vacumePumpCol18Desc to set
	 */
	public void setVacumePumpCol18Desc(String vacumePumpCol18Desc) {
		this.vacumePumpCol18Desc = vacumePumpCol18Desc;
	}
	/**
	 * @return the vacumePumpCol19Desc
	 */
	public String getVacumePumpCol19Desc() {
		return vacumePumpCol19Desc;
	}
	/**
	 * @param vacumePumpCol19Desc the vacumePumpCol19Desc to set
	 */
	public void setVacumePumpCol19Desc(String vacumePumpCol19Desc) {
		this.vacumePumpCol19Desc = vacumePumpCol19Desc;
	}
	/**
	 * @return the vacumePumpCol20Desc
	 */
	public String getVacumePumpCol20Desc() {
		return vacumePumpCol20Desc;
	}
	/**
	 * @param vacumePumpCol20Desc the vacumePumpCol20Desc to set
	 */
	public void setVacumePumpCol20Desc(String vacumePumpCol20Desc) {
		this.vacumePumpCol20Desc = vacumePumpCol20Desc;
	}
	/**
	 * @return the vacumePumpCol21Desc
	 */
	public String getVacumePumpCol21Desc() {
		return vacumePumpCol21Desc;
	}
	/**
	 * @param vacumePumpCol21Desc the vacumePumpCol21Desc to set
	 */
	public void setVacumePumpCol21Desc(String vacumePumpCol21Desc) {
		this.vacumePumpCol21Desc = vacumePumpCol21Desc;
	}
	/**
	 * @return the vacumePumpCol22Desc
	 */
	public String getVacumePumpCol22Desc() {
		return vacumePumpCol22Desc;
	}
	/**
	 * @param vacumePumpCol22Desc the vacumePumpCol22Desc to set
	 */
	public void setVacumePumpCol22Desc(String vacumePumpCol22Desc) {
		this.vacumePumpCol22Desc = vacumePumpCol22Desc;
	}
	/**
	 * @return the vacumePumpCol23Desc
	 */
	public String getVacumePumpCol23Desc() {
		return vacumePumpCol23Desc;
	}
	/**
	 * @param vacumePumpCol23Desc the vacumePumpCol23Desc to set
	 */
	public void setVacumePumpCol23Desc(String vacumePumpCol23Desc) {
		this.vacumePumpCol23Desc = vacumePumpCol23Desc;
	}
	/**
	 * @return the vacumePumpCol24Desc
	 */
	public String getVacumePumpCol24Desc() {
		return vacumePumpCol24Desc;
	}
	/**
	 * @param vacumePumpCol24Desc the vacumePumpCol24Desc to set
	 */
	public void setVacumePumpCol24Desc(String vacumePumpCol24Desc) {
		this.vacumePumpCol24Desc = vacumePumpCol24Desc;
	}
	/**
	 * @return the vacumePumpCol25Desc
	 */
	public String getVacumePumpCol25Desc() {
		return vacumePumpCol25Desc;
	}
	/**
	 * @param vacumePumpCol25Desc the vacumePumpCol25Desc to set
	 */
	public void setVacumePumpCol25Desc(String vacumePumpCol25Desc) {
		this.vacumePumpCol25Desc = vacumePumpCol25Desc;
	}
	/**
	 * @return the vacumePumpCol26Desc
	 */
	public String getVacumePumpCol26Desc() {
		return vacumePumpCol26Desc;
	}
	/**
	 * @param vacumePumpCol26Desc the vacumePumpCol26Desc to set
	 */
	public void setVacumePumpCol26Desc(String vacumePumpCol26Desc) {
		this.vacumePumpCol26Desc = vacumePumpCol26Desc;
	}
	/**
	 * @return the vacumePumpCol27Desc
	 */
	public String getVacumePumpCol27Desc() {
		return vacumePumpCol27Desc;
	}
	/**
	 * @param vacumePumpCol27Desc the vacumePumpCol27Desc to set
	 */
	public void setVacumePumpCol27Desc(String vacumePumpCol27Desc) {
		this.vacumePumpCol27Desc = vacumePumpCol27Desc;
	}
	/**
	 * @return the vacumePumpCol28Desc
	 */
	public String getVacumePumpCol28Desc() {
		return vacumePumpCol28Desc;
	}
	/**
	 * @param vacumePumpCol28Desc the vacumePumpCol28Desc to set
	 */
	public void setVacumePumpCol28Desc(String vacumePumpCol28Desc) {
		this.vacumePumpCol28Desc = vacumePumpCol28Desc;
	}
	/**
	 * @return the vacumePumpCol29Desc
	 */
	public String getVacumePumpCol29Desc() {
		return vacumePumpCol29Desc;
	}
	/**
	 * @param vacumePumpCol29Desc the vacumePumpCol29Desc to set
	 */
	public void setVacumePumpCol29Desc(String vacumePumpCol29Desc) {
		this.vacumePumpCol29Desc = vacumePumpCol29Desc;
	}
	/**
	 * @return the vacumePumpCol30Desc
	 */
	public String getVacumePumpCol30Desc() {
		return vacumePumpCol30Desc;
	}
	/**
	 * @param vacumePumpCol30Desc the vacumePumpCol30Desc to set
	 */
	public void setVacumePumpCol30Desc(String vacumePumpCol30Desc) {
		this.vacumePumpCol30Desc = vacumePumpCol30Desc;
	}
	/**
	 * @return the vacumePumpCol31Desc
	 */
	public String getVacumePumpCol31Desc() {
		return vacumePumpCol31Desc;
	}
	/**
	 * @param vacumePumpCol31Desc the vacumePumpCol31Desc to set
	 */
	public void setVacumePumpCol31Desc(String vacumePumpCol31Desc) {
		this.vacumePumpCol31Desc = vacumePumpCol31Desc;
	}
	/**
	 * @return the vacumePumpCol32Desc
	 */
	public String getVacumePumpCol32Desc() {
		return vacumePumpCol32Desc;
	}
	/**
	 * @param vacumePumpCol32Desc the vacumePumpCol32Desc to set
	 */
	public void setVacumePumpCol32Desc(String vacumePumpCol32Desc) {
		this.vacumePumpCol32Desc = vacumePumpCol32Desc;
	}
	/**
	 * @return the vacumePumpCol33Desc
	 */
	public String getVacumePumpCol33Desc() {
		return vacumePumpCol33Desc;
	}
	/**
	 * @param vacumePumpCol33Desc the vacumePumpCol33Desc to set
	 */
	public void setVacumePumpCol33Desc(String vacumePumpCol33Desc) {
		this.vacumePumpCol33Desc = vacumePumpCol33Desc;
	}
	/**
	 * @return the vacumePumpCol34Desc
	 */
	public String getVacumePumpCol34Desc() {
		return vacumePumpCol34Desc;
	}
	/**
	 * @param vacumePumpCol34Desc the vacumePumpCol34Desc to set
	 */
	public void setVacumePumpCol34Desc(String vacumePumpCol34Desc) {
		this.vacumePumpCol34Desc = vacumePumpCol34Desc;
	}
	/**
	 * @return the vacumePumpCol35Desc
	 */
	public String getVacumePumpCol35Desc() {
		return vacumePumpCol35Desc;
	}
	/**
	 * @param vacumePumpCol35Desc the vacumePumpCol35Desc to set
	 */
	public void setVacumePumpCol35Desc(String vacumePumpCol35Desc) {
		this.vacumePumpCol35Desc = vacumePumpCol35Desc;
	}
	/**
	 * @return the vacumePumpCol36Desc
	 */
	public String getVacumePumpCol36Desc() {
		return vacumePumpCol36Desc;
	}
	/**
	 * @param vacumePumpCol36Desc the vacumePumpCol36Desc to set
	 */
	public void setVacumePumpCol36Desc(String vacumePumpCol36Desc) {
		this.vacumePumpCol36Desc = vacumePumpCol36Desc;
	}
	/**
	 * @return the riverWaterCol1
	 */
	public String getRiverWaterCol1() {
		return riverWaterCol1;
	}
	/**
	 * @param riverWaterCol1 the riverWaterCol1 to set
	 */
	public void setRiverWaterCol1(String riverWaterCol1) {
		this.riverWaterCol1 = riverWaterCol1;
	}
	/**
	 * @return the riverWaterCol2
	 */
	public String getRiverWaterCol2() {
		return riverWaterCol2;
	}
	/**
	 * @param riverWaterCol2 the riverWaterCol2 to set
	 */
	public void setRiverWaterCol2(String riverWaterCol2) {
		this.riverWaterCol2 = riverWaterCol2;
	}
	/**
	 * @return the riverWaterCol1Out
	 */
	public String getRiverWaterCol1Out() {
		return riverWaterCol1Out;
	}
	/**
	 * @param riverWaterCol1Out the riverWaterCol1Out to set
	 */
	public void setRiverWaterCol1Out(String riverWaterCol1Out) {
		this.riverWaterCol1Out = riverWaterCol1Out;
	}
	/**
	 * @return the riverWaterCol2Out
	 */
	public String getRiverWaterCol2Out() {
		return riverWaterCol2Out;
	}
	/**
	 * @param riverWaterCol2Out the riverWaterCol2Out to set
	 */
	public void setRiverWaterCol2Out(String riverWaterCol2Out) {
		this.riverWaterCol2Out = riverWaterCol2Out;
	}
	/**
	 * @return the riverWaterCol1Desc
	 */
	public String getRiverWaterCol1Desc() {
		return riverWaterCol1Desc;
	}
	/**
	 * @param riverWaterCol1Desc the riverWaterCol1Desc to set
	 */
	public void setRiverWaterCol1Desc(String riverWaterCol1Desc) {
		this.riverWaterCol1Desc = riverWaterCol1Desc;
	}
	/**
	 * @return the riverWaterCol2Desc
	 */
	public String getRiverWaterCol2Desc() {
		return riverWaterCol2Desc;
	}
	/**
	 * @param riverWaterCol2Desc the riverWaterCol2Desc to set
	 */
	public void setRiverWaterCol2Desc(String riverWaterCol2Desc) {
		this.riverWaterCol2Desc = riverWaterCol2Desc;
	}
	/**
	 * @return the showercol1
	 */
	public boolean isShowercol1() {
		return showercol1;
	}
	/**
	 * @param showercol1 the showercol1 to set
	 */
	public void setShowercol1(boolean showercol1) {
		this.showercol1 = showercol1;
	}
	/**
	 * @return the showercol2North
	 */
	public String getShowercol2North() {
		return showercol2North;
	}
	/**
	 * @param showercol2North the showercol2North to set
	 */
	public void setShowercol2North(String showercol2North) {
		this.showercol2North = showercol2North;
	}
	/**
	 * @return the showercol2South
	 */
	public String getShowercol2South() {
		return showercol2South;
	}
	/**
	 * @param showercol2South the showercol2South to set
	 */
	public void setShowercol2South(String showercol2South) {
		this.showercol2South = showercol2South;
	}
	/**
	 * @return the showercol3
	 */
	public boolean isShowercol3() {
		return showercol3;
	}
	/**
	 * @param showercol3 the showercol3 to set
	 */
	public void setShowercol3(boolean showercol3) {
		this.showercol3 = showercol3;
	}
	/**
	 * @return the showercol4North
	 */
	public String getShowercol4North() {
		return showercol4North;
	}
	/**
	 * @param showercol4North the showercol4North to set
	 */
	public void setShowercol4North(String showercol4North) {
		this.showercol4North = showercol4North;
	}
	/**
	 * @return the showercol4South
	 */
	public String getShowercol4South() {
		return showercol4South;
	}
	/**
	 * @param showercol4South the showercol4South to set
	 */
	public void setShowercol4South(String showercol4South) {
		this.showercol4South = showercol4South;
	}
	/**
	 * @return the showercol5
	 */
	public boolean isShowercol5() {
		return showercol5;
	}
	/**
	 * @param showercol5 the showercol5 to set
	 */
	public void setShowercol5(boolean showercol5) {
		this.showercol5 = showercol5;
	}
	/**
	 * @return the showercol6North
	 */
	public String getShowercol6North() {
		return showercol6North;
	}
	/**
	 * @param showercol6North the showercol6North to set
	 */
	public void setShowercol6North(String showercol6North) {
		this.showercol6North = showercol6North;
	}
	/**
	 * @return the showercol6South
	 */
	public String getShowercol6South() {
		return showercol6South;
	}
	/**
	 * @param showercol6South the showercol6South to set
	 */
	public void setShowercol6South(String showercol6South) {
		this.showercol6South = showercol6South;
	}
	/**
	 * @return the showercol7
	 */
	public String getShowercol7() {
		return showercol7;
	}
	/**
	 * @return the showercol7Out
	 */
	public String getShowercol7Out() {
		return showercol7Out;
	}
	/**
	 * @param showercol7Out the showercol7Out to set
	 */
	public void setShowercol7Out(String showercol7Out) {
		this.showercol7Out = showercol7Out;
	}
	/**
	 * @param showercol7 the showercol7 to set
	 */
	public void setShowercol7(String showercol7) {
		this.showercol7 = showercol7;
	}
	/**
	 * @return the showercol1Desc
	 */
	public String getShowercol1Desc() {
		return showercol1Desc;
	}
	/**
	 * @param showercol1Desc the showercol1Desc to set
	 */
	public void setShowercol1Desc(String showercol1Desc) {
		this.showercol1Desc = showercol1Desc;
	}
	/**
	 * @return the showercol2Desc
	 */
	public String getShowercol2Desc() {
		return showercol2Desc;
	}
	/**
	 * @param showercol2Desc the showercol2Desc to set
	 */
	public void setShowercol2Desc(String showercol2Desc) {
		this.showercol2Desc = showercol2Desc;
	}
	/**
	 * @return the showercol3Desc
	 */
	public String getShowercol3Desc() {
		return showercol3Desc;
	}
	/**
	 * @param showercol3Desc the showercol3Desc to set
	 */
	public void setShowercol3Desc(String showercol3Desc) {
		this.showercol3Desc = showercol3Desc;
	}
	/**
	 * @return the showercol4Desc
	 */
	public String getShowercol4Desc() {
		return showercol4Desc;
	}
	/**
	 * @param showercol4Desc the showercol4Desc to set
	 */
	public void setShowercol4Desc(String showercol4Desc) {
		this.showercol4Desc = showercol4Desc;
	}
	/**
	 * @return the showercol5Desc
	 */
	public String getShowercol5Desc() {
		return showercol5Desc;
	}
	/**
	 * @param showercol5Desc the showercol5Desc to set
	 */
	public void setShowercol5Desc(String showercol5Desc) {
		this.showercol5Desc = showercol5Desc;
	}
	/**
	 * @return the showercol6Desc
	 */
	public String getShowercol6Desc() {
		return showercol6Desc;
	}
	/**
	 * @param showercol6Desc the showercol6Desc to set
	 */
	public void setShowercol6Desc(String showercol6Desc) {
		this.showercol6Desc = showercol6Desc;
	}
	/**
	 * @return the showercol7Desc
	 */
	public String getShowercol7Desc() {
		return showercol7Desc;
	}
	/**
	 * @param showercol7Desc the showercol7Desc to set
	 */
	public void setShowercol7Desc(String showercol7Desc) {
		this.showercol7Desc = showercol7Desc;
	}
	/**
	 * @return the fillupcentcol1
	 */
	public boolean isFillupcentcol1() {
		return fillupcentcol1;
	}
	/**
	 * @param fillupcentcol1 the fillupcentcol1 to set
	 */
	public void setFillupcentcol1(boolean fillupcentcol1) {
		this.fillupcentcol1 = fillupcentcol1;
	}
	/**
	 * @return the fillupcentcol2
	 */
	public boolean isFillupcentcol2() {
		return fillupcentcol2;
	}
	/**
	 * @param fillupcentcol2 the fillupcentcol2 to set
	 */
	public void setFillupcentcol2(boolean fillupcentcol2) {
		this.fillupcentcol2 = fillupcentcol2;
	}
	/**
	 * @return the fillupcentcol3
	 */
	public boolean isFillupcentcol3() {
		return fillupcentcol3;
	}
	/**
	 * @param fillupcentcol3 the fillupcentcol3 to set
	 */
	public void setFillupcentcol3(boolean fillupcentcol3) {
		this.fillupcentcol3 = fillupcentcol3;
	}
	/**
	 * @return the fillupcentcol4
	 */
	public boolean isFillupcentcol4() {
		return fillupcentcol4;
	}
	/**
	 * @param fillupcentcol4 the fillupcentcol4 to set
	 */
	public void setFillupcentcol4(boolean fillupcentcol4) {
		this.fillupcentcol4 = fillupcentcol4;
	}
	/**
	 * @return the fillupcentcol6
	 */
	public String getFillupcentcol6() {
		return fillupcentcol6;
	}
	/**
	 * @param fillupcentcol6 the fillupcentcol6 to set
	 */
	public void setFillupcentcol6(String fillupcentcol6) {
		this.fillupcentcol6 = fillupcentcol6;
	}
	/**
	 * @return the fillupcentcol7
	 */
	public String getFillupcentcol7() {
		return fillupcentcol7;
	}
	/**
	 * @param fillupcentcol7 the fillupcentcol7 to set
	 */
	public void setFillupcentcol7(String fillupcentcol7) {
		this.fillupcentcol7 = fillupcentcol7;
	}
	/**
	 * @return the fillupcentcol8
	 */
	public boolean isFillupcentcol8() {
		return fillupcentcol8;
	}
	/**
	 * @param fillupcentcol8 the fillupcentcol8 to set
	 */
	public void setFillupcentcol8(boolean fillupcentcol8) {
		this.fillupcentcol8 = fillupcentcol8;
	}
	/**
	 * @return the fillupcentcol1Desc
	 */
	public String getFillupcentcol1Desc() {
		return fillupcentcol1Desc;
	}
	/**
	 * @param fillupcentcol1Desc the fillupcentcol1Desc to set
	 */
	public void setFillupcentcol1Desc(String fillupcentcol1Desc) {
		this.fillupcentcol1Desc = fillupcentcol1Desc;
	}
	/**
	 * @return the fillupcentcol2Desc
	 */
	public String getFillupcentcol2Desc() {
		return fillupcentcol2Desc;
	}
	/**
	 * @param fillupcentcol2Desc the fillupcentcol2Desc to set
	 */
	public void setFillupcentcol2Desc(String fillupcentcol2Desc) {
		this.fillupcentcol2Desc = fillupcentcol2Desc;
	}
	/**
	 * @return the fillupcentcol3Desc
	 */
	public String getFillupcentcol3Desc() {
		return fillupcentcol3Desc;
	}
	/**
	 * @param fillupcentcol3Desc the fillupcentcol3Desc to set
	 */
	public void setFillupcentcol3Desc(String fillupcentcol3Desc) {
		this.fillupcentcol3Desc = fillupcentcol3Desc;
	}
	/**
	 * @return the fillupcentcol4Desc
	 */
	public String getFillupcentcol4Desc() {
		return fillupcentcol4Desc;
	}
	/**
	 * @param fillupcentcol4Desc the fillupcentcol4Desc to set
	 */
	public void setFillupcentcol4Desc(String fillupcentcol4Desc) {
		this.fillupcentcol4Desc = fillupcentcol4Desc;
	}
	/**
	 * @return the fillupcentcol5Desc
	 */
	public String getFillupcentcol5Desc() {
		return fillupcentcol5Desc;
	}
	/**
	 * @param fillupcentcol5Desc the fillupcentcol5Desc to set
	 */
	public void setFillupcentcol5Desc(String fillupcentcol5Desc) {
		this.fillupcentcol5Desc = fillupcentcol5Desc;
	}
	/**
	 * @return the fillupcentcol6Desc
	 */
	public String getFillupcentcol6Desc() {
		return fillupcentcol6Desc;
	}
	/**
	 * @param fillupcentcol6Desc the fillupcentcol6Desc to set
	 */
	public void setFillupcentcol6Desc(String fillupcentcol6Desc) {
		this.fillupcentcol6Desc = fillupcentcol6Desc;
	}
	/**
	 * @return the fillupcentcol7Desc
	 */
	public String getFillupcentcol7Desc() {
		return fillupcentcol7Desc;
	}
	/**
	 * @param fillupcentcol7Desc the fillupcentcol7Desc to set
	 */
	public void setFillupcentcol7Desc(String fillupcentcol7Desc) {
		this.fillupcentcol7Desc = fillupcentcol7Desc;
	}
	/**
	 * @return the fillupcentcol8Desc
	 */
	public String getFillupcentcol8Desc() {
		return fillupcentcol8Desc;
	}
	/**
	 * @param fillupcentcol8Desc the fillupcentcol8Desc to set
	 */
	public void setFillupcentcol8Desc(String fillupcentcol8Desc) {
		this.fillupcentcol8Desc = fillupcentcol8Desc;
	}
	/**
	 * @return the fillupcentcol9
	 */
	public boolean isFillupcentcol9() {
		return fillupcentcol9;
	}
	/**
	 * @param fillupcentcol9 the fillupcentcol9 to set
	 */
	public void setFillupcentcol9(boolean fillupcentcol9) {
		this.fillupcentcol9 = fillupcentcol9;
	}
	/**
	 * @return the fillupcentcol9Desc
	 */
	public String getFillupcentcol9Desc() {
		return fillupcentcol9Desc;
	}
	/**
	 * @param fillupcentcol9Desc the fillupcentcol9Desc to set
	 */
	public void setFillupcentcol9Desc(String fillupcentcol9Desc) {
		this.fillupcentcol9Desc = fillupcentcol9Desc;
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
	public boolean isCheckairfilterforheadbox() {
		return checkairfilterforheadbox;
	}
	public void setCheckairfilterforheadbox(boolean checkairfilterforheadbox) {
		this.checkairfilterforheadbox = checkairfilterforheadbox;
	}
	public String getCheckairfilterforheadboxremark() {
		return checkairfilterforheadboxremark;
	}
	public void setCheckairfilterforheadboxremark(
			String checkairfilterforheadboxremark) {
		this.checkairfilterforheadboxremark = checkairfilterforheadboxremark;
	}
	public String getDriveRollCol8() {
		return driveRollCol8;
	}
	public void setDriveRollCol8(String driveRollCol8) {
		this.driveRollCol8 = driveRollCol8;
	}
	public String getDriveRollCol8Desc() {
		return driveRollCol8Desc;
	}
	public void setDriveRollCol8Desc(String driveRollCol8Desc) {
		this.driveRollCol8Desc = driveRollCol8Desc;
	}
	public boolean isBlowwetendanddryendmotor() {
		return blowwetendanddryendmotor;
	}
	public void setBlowwetendanddryendmotor(boolean blowwetendanddryendmotor) {
		this.blowwetendanddryendmotor = blowwetendanddryendmotor;
	}
	public String getBlowwetendanddryendmotorremark() {
		return blowwetendanddryendmotorremark;
	}
	public void setBlowwetendanddryendmotorremark(
			String blowwetendanddryendmotorremark) {
		this.blowwetendanddryendmotorremark = blowwetendanddryendmotorremark;
	}
	public boolean isCheckheadboxaircompressorintelfiltercleanliness() {
		return checkheadboxaircompressorintelfiltercleanliness;
	}
	public void setCheckheadboxaircompressorintelfiltercleanliness(
			boolean checkheadboxaircompressorintelfiltercleanliness) {
		this.checkheadboxaircompressorintelfiltercleanliness = checkheadboxaircompressorintelfiltercleanliness;
	}
	public String getCheckheadboxaircompressorintelfiltercleanlinessdesc() {
		return checkheadboxaircompressorintelfiltercleanlinessdesc;
	}
	public void setCheckheadboxaircompressorintelfiltercleanlinessdesc(
			String checkheadboxaircompressorintelfiltercleanlinessdesc) {
		this.checkheadboxaircompressorintelfiltercleanlinessdesc = checkheadboxaircompressorintelfiltercleanlinessdesc;
	}
	public boolean isHeadboxairfilterscleaning() {
		return headboxairfilterscleaning;
	}
	public void setHeadboxairfilterscleaning(boolean headboxairfilterscleaning) {
		this.headboxairfilterscleaning = headboxairfilterscleaning;
	}
	public String getHeadboxairfilterscleaningdesc() {
		return headboxairfilterscleaningdesc;
	}
	public void setHeadboxairfilterscleaningdesc(
			String headboxairfilterscleaningdesc) {
		this.headboxairfilterscleaningdesc = headboxairfilterscleaningdesc;
	}
	/**
	 * @return the rotatingShowers
	 */
	public boolean isRotatingShowers() {
		return rotatingShowers;
	}
	/**
	 * @param rotatingShowers the rotatingShowers to set
	 */
	public void setRotatingShowers(boolean rotatingShowers) {
		this.rotatingShowers = rotatingShowers;
	}
	/**
	 * @return the rotatingShowersremark
	 */
	public String getRotatingShowersremark() {
		return rotatingShowersremark;
	}
	/**
	 * @param rotatingShowersremark the rotatingShowersremark to set
	 */
	public void setRotatingShowersremark(String rotatingShowersremark) {
		this.rotatingShowersremark = rotatingShowersremark;
	}
	/**
	 * @return the rotationShowersValve
	 */
	public boolean isRotationShowersValve() {
		return rotationShowersValve;
	}
	/**
	 * @param rotationShowersValve the rotationShowersValve to set
	 */
	public void setRotationShowersValve(boolean rotationShowersValve) {
		this.rotationShowersValve = rotationShowersValve;
	}
	/**
	 * @return the rotationShowersValveremark
	 */
	public String getRotationShowersValveremark() {
		return rotationShowersValveremark;
	}
	/**
	 * @param rotationShowersValveremark the rotationShowersValveremark to set
	 */
	public void setRotationShowersValveremark(String rotationShowersValveremark) {
		this.rotationShowersValveremark = rotationShowersValveremark;
	}
	/**
	 * @return the upperPressCol9
	 */
	public String getUpperPressCol9() {
		return upperPressCol9;
	}
	/**
	 * @param upperPressCol9 the upperPressCol9 to set
	 */
	public void setUpperPressCol9(String upperPressCol9) {
		this.upperPressCol9 = upperPressCol9;
	}
	/**
	 * @return the fillupcentcol5
	 */
	public boolean isFillupcentcol5() {
		return fillupcentcol5;
	}
	/**
	 * @param fillupcentcol5 the fillupcentcol5 to set
	 */
	public void setFillupcentcol5(boolean fillupcentcol5) {
		this.fillupcentcol5 = fillupcentcol5;
	}   

}
