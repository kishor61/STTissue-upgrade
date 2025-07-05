/**
 *Oct 21, 2019
 *R1OperatorPM5.java
 * TODO
 *com.st.obccPM5.model
 *R1OperatorPM5.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.model;

/**
 * @author sohan
 *
 */
public class R1OperatorPM5 {
	
	private int id;
	private String position;
	private String operatorName;
	private String edate;
	private String crew;
	private String shift;
	private boolean machinedown;
	
	
	private boolean leadInRollCol1;
	private boolean leadInRollCol2;
	private boolean leadInRollCol3;
	private boolean leadInRollCol4;
	private boolean leadInRollCol5;

	private String leadInRollCol1Desc;
	private String leadInRollCol2Desc;
	private String leadInRollCol3Desc;
	private String leadInRollCol4Desc;
	private String leadInRollCol5Desc;

	private boolean sectionRollCol1;
	private String sectionRollCol1Desc;

	private boolean breakAssemblyCol1;
	private boolean breakAssemblyCol2;

	private String breakAssemblyCol1Desc;
	private String breakAssemblyCol2Desc;

	private boolean slittersCol1;
	private boolean slittersCol2;
	private boolean slittersCol3;

	private String slittersCol1Desc;
	private String slittersCol2Desc;
	private String slittersCol3Desc;

	private boolean trimAssemblyCol1;
	private boolean trimAssemblyCol2;
	private boolean trimAssemblyCol3;
	private boolean trimAssemblyCol4;

	private String trimAssemblyCol1Desc;
	private String trimAssemblyCol2Desc;
	private String trimAssemblyCol3Desc;
	private String trimAssemblyCol4Desc;

	private boolean tensiionRollCol1;
	private boolean tensiionRollCol2;
	private boolean tensiionRollCol3;

	private String tensiionRollCol1Desc;
	private String tensiionRollCol2Desc;
	private String tensiionRollCol3Desc;

	private boolean winderDrum1Col1;
	private boolean winderDrum1Col2;
	private boolean winderDrum1Col3;
	private boolean winderDrum1Col4;
	private boolean winderDrum1Col5;
	 
 

	private String winderDrum1Col1Desc;
	private String winderDrum1Col2Desc;
	private String winderDrum1Col3Desc;
	private String winderDrum1Col4Desc;
	private String winderDrum1Col5Desc;
 
	 

	private boolean winderDrum2Col1;
	private boolean winderDrum2Col2;
	private boolean winderDrum2Col3;
	private boolean winderDrum2Col4;
	private boolean winderDrum2Col5;
	 

	private String winderDrum2Col1Desc;
	private String winderDrum2Col2Desc;
	private String winderDrum2Col3Desc;
	private String winderDrum2Col4Desc;
	private String winderDrum2Col5Desc;
	 

	private boolean rollEjectorCol1;
	private boolean rollEjectorCol2;
	private boolean rollEjectorCol3;

	private String rollEjectorCol1Desc;
	private String rollEjectorCol2Desc;
	private String rollEjectorCol3Desc;

	private boolean riderRollCol1;
	private boolean riderRollCol2;
	private boolean riderRollCol3;
	private boolean riderRollCol4;
	private boolean riderRollCol5;
	private boolean riderRollCol6;
	private boolean riderRollCol7;
	private boolean riderRollCol8;

	private String riderRollCol1Desc;
	private String riderRollCol2Desc;
	private String riderRollCol3Desc;
	private String riderRollCol4Desc;
	private String riderRollCol5Desc;
	private String riderRollCol6Desc;
	private String riderRollCol7Desc;
	private String riderRollCol8Desc;

	private boolean bowedRollCol1;
	private boolean bowedRollCol2;
	private boolean bowedRollCol3;

	private String bowedRollCol1Desc;
	private String bowedRollCol2Desc;
	private String bowedRollCol3Desc;

	private boolean coreChucksCol1;
	private boolean coreChucksCol2;
	private boolean coreChucksCol3;
	private boolean coreChucksCol4;

	private String coreChucksCol1Desc;
	private String coreChucksCol2Desc;
	private String coreChucksCol3Desc;
	private String coreChucksCol4Desc;

	private boolean nipGuardCol1;
	private boolean nipGuardCol2;
	private boolean nipGuardCol3;

	private String nipGuardCol1Desc;
	private String nipGuardCol2Desc;
	private String nipGuardCol3Desc;

	private boolean tableLeftGateCol1;
	private boolean tableLeftGateCol2;

	private String tableLeftGateCol1Desc;
	private String tableLeftGateCol2Desc;
	
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
	 * @return the leadInRollCol1
	 */
	public boolean isLeadInRollCol1() {
		return leadInRollCol1;
	}

	/**
	 * @param leadInRollCol1
	 *            the leadInRollCol1 to set
	 */
	public void setLeadInRollCol1(boolean leadInRollCol1) {
		this.leadInRollCol1 = leadInRollCol1;
	}

	/**
	 * @return the leadInRollCol2
	 */
	public boolean isLeadInRollCol2() {
		return leadInRollCol2;
	}

	/**
	 * @param leadInRollCol2
	 *            the leadInRollCol2 to set
	 */
	public void setLeadInRollCol2(boolean leadInRollCol2) {
		this.leadInRollCol2 = leadInRollCol2;
	}

	/**
	 * @return the leadInRollCol3
	 */
	public boolean isLeadInRollCol3() {
		return leadInRollCol3;
	}

	/**
	 * @param leadInRollCol3
	 *            the leadInRollCol3 to set
	 */
	public void setLeadInRollCol3(boolean leadInRollCol3) {
		this.leadInRollCol3 = leadInRollCol3;
	}

	/**
	 * @return the leadInRollCol4
	 */
	public boolean isLeadInRollCol4() {
		return leadInRollCol4;
	}

	/**
	 * @param leadInRollCol4
	 *            the leadInRollCol4 to set
	 */
	public void setLeadInRollCol4(boolean leadInRollCol4) {
		this.leadInRollCol4 = leadInRollCol4;
	}

	/**
	 * @return the leadInRollCol5
	 */
	public boolean isLeadInRollCol5() {
		return leadInRollCol5;
	}

	/**
	 * @param leadInRollCol5
	 *            the leadInRollCol5 to set
	 */
	public void setLeadInRollCol5(boolean leadInRollCol5) {
		this.leadInRollCol5 = leadInRollCol5;
	}

	/**
	 * @return the leadInRollCol1Desc
	 */
	public String getLeadInRollCol1Desc() {
		return leadInRollCol1Desc;
	}

	/**
	 * @param leadInRollCol1Desc
	 *            the leadInRollCol1Desc to set
	 */
	public void setLeadInRollCol1Desc(String leadInRollCol1Desc) {
		this.leadInRollCol1Desc = leadInRollCol1Desc;
	}

	/**
	 * @return the leadInRollCol2Desc
	 */
	public String getLeadInRollCol2Desc() {
		return leadInRollCol2Desc;
	}

	/**
	 * @param leadInRollCol2Desc
	 *            the leadInRollCol2Desc to set
	 */
	public void setLeadInRollCol2Desc(String leadInRollCol2Desc) {
		this.leadInRollCol2Desc = leadInRollCol2Desc;
	}

	/**
	 * @return the leadInRollCol3Desc
	 */
	public String getLeadInRollCol3Desc() {
		return leadInRollCol3Desc;
	}

	/**
	 * @param leadInRollCol3Desc
	 *            the leadInRollCol3Desc to set
	 */
	public void setLeadInRollCol3Desc(String leadInRollCol3Desc) {
		this.leadInRollCol3Desc = leadInRollCol3Desc;
	}

	/**
	 * @return the leadInRollCol4Desc
	 */
	public String getLeadInRollCol4Desc() {
		return leadInRollCol4Desc;
	}

	/**
	 * @param leadInRollCol4Desc
	 *            the leadInRollCol4Desc to set
	 */
	public void setLeadInRollCol4Desc(String leadInRollCol4Desc) {
		this.leadInRollCol4Desc = leadInRollCol4Desc;
	}

	/**
	 * @return the leadInRollCol5Desc
	 */
	public String getLeadInRollCol5Desc() {
		return leadInRollCol5Desc;
	}

	/**
	 * @param leadInRollCol5Desc
	 *            the leadInRollCol5Desc to set
	 */
	public void setLeadInRollCol5Desc(String leadInRollCol5Desc) {
		this.leadInRollCol5Desc = leadInRollCol5Desc;
	}

	/**
	 * @return the sectionRollCol1
	 */
	public boolean isSectionRollCol1() {
		return sectionRollCol1;
	}

	/**
	 * @param sectionRollCol1
	 *            the sectionRollCol1 to set
	 */
	public void setSectionRollCol1(boolean sectionRollCol1) {
		this.sectionRollCol1 = sectionRollCol1;
	}

	/**
	 * @return the sectionRollCol1Desc
	 */
	public String getSectionRollCol1Desc() {
		return sectionRollCol1Desc;
	}

	/**
	 * @param sectionRollCol1Desc
	 *            the sectionRollCol1Desc to set
	 */
	public void setSectionRollCol1Desc(String sectionRollCol1Desc) {
		this.sectionRollCol1Desc = sectionRollCol1Desc;
	}

	/**
	 * @return the breakAssemblyCol1
	 */
	public boolean isBreakAssemblyCol1() {
		return breakAssemblyCol1;
	}

	/**
	 * @param breakAssemblyCol1
	 *            the breakAssemblyCol1 to set
	 */
	public void setBreakAssemblyCol1(boolean breakAssemblyCol1) {
		this.breakAssemblyCol1 = breakAssemblyCol1;
	}

	/**
	 * @return the breakAssemblyCol2
	 */
	public boolean isBreakAssemblyCol2() {
		return breakAssemblyCol2;
	}

	/**
	 * @param breakAssemblyCol2
	 *            the breakAssemblyCol2 to set
	 */
	public void setBreakAssemblyCol2(boolean breakAssemblyCol2) {
		this.breakAssemblyCol2 = breakAssemblyCol2;
	}

	/**
	 * @return the breakAssemblyCol1Desc
	 */
	public String getBreakAssemblyCol1Desc() {
		return breakAssemblyCol1Desc;
	}

	/**
	 * @param breakAssemblyCol1Desc
	 *            the breakAssemblyCol1Desc to set
	 */
	public void setBreakAssemblyCol1Desc(String breakAssemblyCol1Desc) {
		this.breakAssemblyCol1Desc = breakAssemblyCol1Desc;
	}

	/**
	 * @return the breakAssemblyCol2Desc
	 */
	public String getBreakAssemblyCol2Desc() {
		return breakAssemblyCol2Desc;
	}

	/**
	 * @param breakAssemblyCol2Desc
	 *            the breakAssemblyCol2Desc to set
	 */
	public void setBreakAssemblyCol2Desc(String breakAssemblyCol2Desc) {
		this.breakAssemblyCol2Desc = breakAssemblyCol2Desc;
	}

	/**
	 * @return the slittersCol1
	 */
	public boolean isSlittersCol1() {
		return slittersCol1;
	}

	/**
	 * @param slittersCol1
	 *            the slittersCol1 to set
	 */
	public void setSlittersCol1(boolean slittersCol1) {
		this.slittersCol1 = slittersCol1;
	}

	/**
	 * @return the slittersCol2
	 */
	public boolean isSlittersCol2() {
		return slittersCol2;
	}

	/**
	 * @param slittersCol2
	 *            the slittersCol2 to set
	 */
	public void setSlittersCol2(boolean slittersCol2) {
		this.slittersCol2 = slittersCol2;
	}

	/**
	 * @return the slittersCol3
	 */
	public boolean isSlittersCol3() {
		return slittersCol3;
	}

	/**
	 * @param slittersCol3
	 *            the slittersCol3 to set
	 */
	public void setSlittersCol3(boolean slittersCol3) {
		this.slittersCol3 = slittersCol3;
	}

	/**
	 * @return the slittersCol1Desc
	 */
	public String getSlittersCol1Desc() {
		return slittersCol1Desc;
	}

	/**
	 * @param slittersCol1Desc
	 *            the slittersCol1Desc to set
	 */
	public void setSlittersCol1Desc(String slittersCol1Desc) {
		this.slittersCol1Desc = slittersCol1Desc;
	}

	/**
	 * @return the slittersCol2Desc
	 */
	public String getSlittersCol2Desc() {
		return slittersCol2Desc;
	}

	/**
	 * @param slittersCol2Desc
	 *            the slittersCol2Desc to set
	 */
	public void setSlittersCol2Desc(String slittersCol2Desc) {
		this.slittersCol2Desc = slittersCol2Desc;
	}

	/**
	 * @return the slittersCol3Desc
	 */
	public String getSlittersCol3Desc() {
		return slittersCol3Desc;
	}

	/**
	 * @param slittersCol3Desc
	 *            the slittersCol3Desc to set
	 */
	public void setSlittersCol3Desc(String slittersCol3Desc) {
		this.slittersCol3Desc = slittersCol3Desc;
	}

	/**
	 * @return the trimAssemblyCol1
	 */
	public boolean isTrimAssemblyCol1() {
		return trimAssemblyCol1;
	}

	/**
	 * @param trimAssemblyCol1
	 *            the trimAssemblyCol1 to set
	 */
	public void setTrimAssemblyCol1(boolean trimAssemblyCol1) {
		this.trimAssemblyCol1 = trimAssemblyCol1;
	}

	/**
	 * @return the trimAssemblyCol2
	 */
	public boolean isTrimAssemblyCol2() {
		return trimAssemblyCol2;
	}

	/**
	 * @param trimAssemblyCol2
	 *            the trimAssemblyCol2 to set
	 */
	public void setTrimAssemblyCol2(boolean trimAssemblyCol2) {
		this.trimAssemblyCol2 = trimAssemblyCol2;
	}

	/**
	 * @return the trimAssemblyCol3
	 */
	public boolean isTrimAssemblyCol3() {
		return trimAssemblyCol3;
	}

	/**
	 * @param trimAssemblyCol3
	 *            the trimAssemblyCol3 to set
	 */
	public void setTrimAssemblyCol3(boolean trimAssemblyCol3) {
		this.trimAssemblyCol3 = trimAssemblyCol3;
	}

	/**
	 * @return the trimAssemblyCol4
	 */
	public boolean isTrimAssemblyCol4() {
		return trimAssemblyCol4;
	}

	/**
	 * @param trimAssemblyCol4
	 *            the trimAssemblyCol4 to set
	 */
	public void setTrimAssemblyCol4(boolean trimAssemblyCol4) {
		this.trimAssemblyCol4 = trimAssemblyCol4;
	}

	/**
	 * @return the trimAssemblyCol1Desc
	 */
	public String getTrimAssemblyCol1Desc() {
		return trimAssemblyCol1Desc;
	}

	/**
	 * @param trimAssemblyCol1Desc
	 *            the trimAssemblyCol1Desc to set
	 */
	public void setTrimAssemblyCol1Desc(String trimAssemblyCol1Desc) {
		this.trimAssemblyCol1Desc = trimAssemblyCol1Desc;
	}

	/**
	 * @return the trimAssemblyCol2Desc
	 */
	public String getTrimAssemblyCol2Desc() {
		return trimAssemblyCol2Desc;
	}

	/**
	 * @param trimAssemblyCol2Desc
	 *            the trimAssemblyCol2Desc to set
	 */
	public void setTrimAssemblyCol2Desc(String trimAssemblyCol2Desc) {
		this.trimAssemblyCol2Desc = trimAssemblyCol2Desc;
	}

	/**
	 * @return the trimAssemblyCol3Desc
	 */
	public String getTrimAssemblyCol3Desc() {
		return trimAssemblyCol3Desc;
	}

	/**
	 * @param trimAssemblyCol3Desc
	 *            the trimAssemblyCol3Desc to set
	 */
	public void setTrimAssemblyCol3Desc(String trimAssemblyCol3Desc) {
		this.trimAssemblyCol3Desc = trimAssemblyCol3Desc;
	}

	/**
	 * @return the trimAssemblyCol4Desc
	 */
	public String getTrimAssemblyCol4Desc() {
		return trimAssemblyCol4Desc;
	}

	/**
	 * @param trimAssemblyCol4Desc
	 *            the trimAssemblyCol4Desc to set
	 */
	public void setTrimAssemblyCol4Desc(String trimAssemblyCol4Desc) {
		this.trimAssemblyCol4Desc = trimAssemblyCol4Desc;
	}

	/**
	 * @return the tensiionRollCol1
	 */
	public boolean isTensiionRollCol1() {
		return tensiionRollCol1;
	}

	/**
	 * @param tensiionRollCol1
	 *            the tensiionRollCol1 to set
	 */
	public void setTensiionRollCol1(boolean tensiionRollCol1) {
		this.tensiionRollCol1 = tensiionRollCol1;
	}

	/**
	 * @return the tensiionRollCol2
	 */
	public boolean isTensiionRollCol2() {
		return tensiionRollCol2;
	}

	/**
	 * @param tensiionRollCol2
	 *            the tensiionRollCol2 to set
	 */
	public void setTensiionRollCol2(boolean tensiionRollCol2) {
		this.tensiionRollCol2 = tensiionRollCol2;
	}

	/**
	 * @return the tensiionRollCol3
	 */
	public boolean isTensiionRollCol3() {
		return tensiionRollCol3;
	}

	/**
	 * @param tensiionRollCol3
	 *            the tensiionRollCol3 to set
	 */
	public void setTensiionRollCol3(boolean tensiionRollCol3) {
		this.tensiionRollCol3 = tensiionRollCol3;
	}

	/**
	 * @return the tensiionRollCol1Desc
	 */
	public String getTensiionRollCol1Desc() {
		return tensiionRollCol1Desc;
	}

	/**
	 * @param tensiionRollCol1Desc
	 *            the tensiionRollCol1Desc to set
	 */
	public void setTensiionRollCol1Desc(String tensiionRollCol1Desc) {
		this.tensiionRollCol1Desc = tensiionRollCol1Desc;
	}

	/**
	 * @return the tensiionRollCol2Desc
	 */
	public String getTensiionRollCol2Desc() {
		return tensiionRollCol2Desc;
	}

	/**
	 * @param tensiionRollCol2Desc
	 *            the tensiionRollCol2Desc to set
	 */
	public void setTensiionRollCol2Desc(String tensiionRollCol2Desc) {
		this.tensiionRollCol2Desc = tensiionRollCol2Desc;
	}

	/**
	 * @return the tensiionRollCol3Desc
	 */
	public String getTensiionRollCol3Desc() {
		return tensiionRollCol3Desc;
	}

	/**
	 * @param tensiionRollCol3Desc
	 *            the tensiionRollCol3Desc to set
	 */
	public void setTensiionRollCol3Desc(String tensiionRollCol3Desc) {
		this.tensiionRollCol3Desc = tensiionRollCol3Desc;
	}

	/**
	 * @return the winderDrum1Col1
	 */
	public boolean isWinderDrum1Col1() {
		return winderDrum1Col1;
	}

	/**
	 * @param winderDrum1Col1
	 *            the winderDrum1Col1 to set
	 */
	public void setWinderDrum1Col1(boolean winderDrum1Col1) {
		this.winderDrum1Col1 = winderDrum1Col1;
	}

	/**
	 * @return the winderDrum1Col2
	 */
	public boolean isWinderDrum1Col2() {
		return winderDrum1Col2;
	}

	/**
	 * @param winderDrum1Col2
	 *            the winderDrum1Col2 to set
	 */
	public void setWinderDrum1Col2(boolean winderDrum1Col2) {
		this.winderDrum1Col2 = winderDrum1Col2;
	}

	/**
	 * @return the winderDrum1Col3
	 */
	public boolean isWinderDrum1Col3() {
		return winderDrum1Col3;
	}

	/**
	 * @param winderDrum1Col3
	 *            the winderDrum1Col3 to set
	 */
	public void setWinderDrum1Col3(boolean winderDrum1Col3) {
		this.winderDrum1Col3 = winderDrum1Col3;
	}

	/**
	 * @return the winderDrum1Col4
	 */
	public boolean isWinderDrum1Col4() {
		return winderDrum1Col4;
	}

	/**
	 * @param winderDrum1Col4
	 *            the winderDrum1Col4 to set
	 */
	public void setWinderDrum1Col4(boolean winderDrum1Col4) {
		this.winderDrum1Col4 = winderDrum1Col4;
	}

	/**
	 * @return the winderDrum1Col5
	 */
	public boolean isWinderDrum1Col5() {
		return winderDrum1Col5;
	}

	/**
	 * @param winderDrum1Col5
	 *            the winderDrum1Col5 to set
	 */
	public void setWinderDrum1Col5(boolean winderDrum1Col5) {
		this.winderDrum1Col5 = winderDrum1Col5;
	}

	 
	/**
	 * @return the winderDrum1Col1Desc
	 */
	public String getWinderDrum1Col1Desc() {
		return winderDrum1Col1Desc;
	}

	/**
	 * @param winderDrum1Col1Desc
	 *            the winderDrum1Col1Desc to set
	 */
	public void setWinderDrum1Col1Desc(String winderDrum1Col1Desc) {
		this.winderDrum1Col1Desc = winderDrum1Col1Desc;
	}

	/**
	 * @return the winderDrum1Col2Desc
	 */
	public String getWinderDrum1Col2Desc() {
		return winderDrum1Col2Desc;
	}

	/**
	 * @param winderDrum1Col2Desc
	 *            the winderDrum1Col2Desc to set
	 */
	public void setWinderDrum1Col2Desc(String winderDrum1Col2Desc) {
		this.winderDrum1Col2Desc = winderDrum1Col2Desc;
	}

	/**
	 * @return the winderDrum1Col3Desc
	 */
	public String getWinderDrum1Col3Desc() {
		return winderDrum1Col3Desc;
	}

	/**
	 * @param winderDrum1Col3Desc
	 *            the winderDrum1Col3Desc to set
	 */
	public void setWinderDrum1Col3Desc(String winderDrum1Col3Desc) {
		this.winderDrum1Col3Desc = winderDrum1Col3Desc;
	}

	/**
	 * @return the winderDrum1Col4Desc
	 */
	public String getWinderDrum1Col4Desc() {
		return winderDrum1Col4Desc;
	}

	/**
	 * @param winderDrum1Col4Desc
	 *            the winderDrum1Col4Desc to set
	 */
	public void setWinderDrum1Col4Desc(String winderDrum1Col4Desc) {
		this.winderDrum1Col4Desc = winderDrum1Col4Desc;
	}

	/**
	 * @return the winderDrum1Col5Desc
	 */
	public String getWinderDrum1Col5Desc() {
		return winderDrum1Col5Desc;
	}

	/**
	 * @param winderDrum1Col5Desc
	 *            the winderDrum1Col5Desc to set
	 */
	public void setWinderDrum1Col5Desc(String winderDrum1Col5Desc) {
		this.winderDrum1Col5Desc = winderDrum1Col5Desc;
	}

	 

	/**
	 * @return the winderDrum2Col1
	 */
	public boolean isWinderDrum2Col1() {
		return winderDrum2Col1;
	}

	/**
	 * @param winderDrum2Col1
	 *            the winderDrum2Col1 to set
	 */
	public void setWinderDrum2Col1(boolean winderDrum2Col1) {
		this.winderDrum2Col1 = winderDrum2Col1;
	}

	/**
	 * @return the winderDrum2Col2
	 */
	public boolean isWinderDrum2Col2() {
		return winderDrum2Col2;
	}

	/**
	 * @param winderDrum2Col2
	 *            the winderDrum2Col2 to set
	 */
	public void setWinderDrum2Col2(boolean winderDrum2Col2) {
		this.winderDrum2Col2 = winderDrum2Col2;
	}

	/**
	 * @return the winderDrum2Col3
	 */
	public boolean isWinderDrum2Col3() {
		return winderDrum2Col3;
	}

	/**
	 * @param winderDrum2Col3
	 *            the winderDrum2Col3 to set
	 */
	public void setWinderDrum2Col3(boolean winderDrum2Col3) {
		this.winderDrum2Col3 = winderDrum2Col3;
	}

	/**
	 * @return the winderDrum2Col4
	 */
	public boolean isWinderDrum2Col4() {
		return winderDrum2Col4;
	}

	/**
	 * @param winderDrum2Col4
	 *            the winderDrum2Col4 to set
	 */
	public void setWinderDrum2Col4(boolean winderDrum2Col4) {
		this.winderDrum2Col4 = winderDrum2Col4;
	}

	/**
	 * @return the winderDrum2Col5
	 */
	public boolean isWinderDrum2Col5() {
		return winderDrum2Col5;
	}

	/**
	 * @param winderDrum2Col5
	 *            the winderDrum2Col5 to set
	 */
	public void setWinderDrum2Col5(boolean winderDrum2Col5) {
		this.winderDrum2Col5 = winderDrum2Col5;
	}

	 

	/**
	 * @return the winderDrum2Col1Desc
	 */
	public String getWinderDrum2Col1Desc() {
		return winderDrum2Col1Desc;
	}

	/**
	 * @param winderDrum2Col1Desc
	 *            the winderDrum2Col1Desc to set
	 */
	public void setWinderDrum2Col1Desc(String winderDrum2Col1Desc) {
		this.winderDrum2Col1Desc = winderDrum2Col1Desc;
	}

	/**
	 * @return the winderDrum2Col2Desc
	 */
	public String getWinderDrum2Col2Desc() {
		return winderDrum2Col2Desc;
	}

	/**
	 * @param winderDrum2Col2Desc
	 *            the winderDrum2Col2Desc to set
	 */
	public void setWinderDrum2Col2Desc(String winderDrum2Col2Desc) {
		this.winderDrum2Col2Desc = winderDrum2Col2Desc;
	}

	/**
	 * @return the winderDrum2Col3Desc
	 */
	public String getWinderDrum2Col3Desc() {
		return winderDrum2Col3Desc;
	}

	/**
	 * @param winderDrum2Col3Desc
	 *            the winderDrum2Col3Desc to set
	 */
	public void setWinderDrum2Col3Desc(String winderDrum2Col3Desc) {
		this.winderDrum2Col3Desc = winderDrum2Col3Desc;
	}

	/**
	 * @return the winderDrum2Col4Desc
	 */
	public String getWinderDrum2Col4Desc() {
		return winderDrum2Col4Desc;
	}

	/**
	 * @param winderDrum2Col4Desc
	 *            the winderDrum2Col4Desc to set
	 */
	public void setWinderDrum2Col4Desc(String winderDrum2Col4Desc) {
		this.winderDrum2Col4Desc = winderDrum2Col4Desc;
	}

	/**
	 * @return the winderDrum2Col5Desc
	 */
	public String getWinderDrum2Col5Desc() {
		return winderDrum2Col5Desc;
	}

	/**
	 * @param winderDrum2Col5Desc
	 *            the winderDrum2Col5Desc to set
	 */
	public void setWinderDrum2Col5Desc(String winderDrum2Col5Desc) {
		this.winderDrum2Col5Desc = winderDrum2Col5Desc;
	}
	/**
	 * @return the rollEjectorCol1
	 */
	public boolean isRollEjectorCol1() {
		return rollEjectorCol1;
	}

	/**
	 * @param rollEjectorCol1
	 *            the rollEjectorCol1 to set
	 */
	public void setRollEjectorCol1(boolean rollEjectorCol1) {
		this.rollEjectorCol1 = rollEjectorCol1;
	}

	/**
	 * @return the rollEjectorCol2
	 */
	public boolean isRollEjectorCol2() {
		return rollEjectorCol2;
	}

	/**
	 * @param rollEjectorCol2
	 *            the rollEjectorCol2 to set
	 */
	public void setRollEjectorCol2(boolean rollEjectorCol2) {
		this.rollEjectorCol2 = rollEjectorCol2;
	}

	/**
	 * @return the rollEjectorCol3
	 */
	public boolean isRollEjectorCol3() {
		return rollEjectorCol3;
	}

	/**
	 * @param rollEjectorCol3
	 *            the rollEjectorCol3 to set
	 */
	public void setRollEjectorCol3(boolean rollEjectorCol3) {
		this.rollEjectorCol3 = rollEjectorCol3;
	}

	/**
	 * @return the rollEjectorCol1Desc
	 */
	public String getRollEjectorCol1Desc() {
		return rollEjectorCol1Desc;
	}

	/**
	 * @param rollEjectorCol1Desc
	 *            the rollEjectorCol1Desc to set
	 */
	public void setRollEjectorCol1Desc(String rollEjectorCol1Desc) {
		this.rollEjectorCol1Desc = rollEjectorCol1Desc;
	}

	/**
	 * @return the rollEjectorCol2Desc
	 */
	public String getRollEjectorCol2Desc() {
		return rollEjectorCol2Desc;
	}

	/**
	 * @param rollEjectorCol2Desc
	 *            the rollEjectorCol2Desc to set
	 */
	public void setRollEjectorCol2Desc(String rollEjectorCol2Desc) {
		this.rollEjectorCol2Desc = rollEjectorCol2Desc;
	}

	/**
	 * @return the rollEjectorCol3Desc
	 */
	public String getRollEjectorCol3Desc() {
		return rollEjectorCol3Desc;
	}

	/**
	 * @param rollEjectorCol3Desc
	 *            the rollEjectorCol3Desc to set
	 */
	public void setRollEjectorCol3Desc(String rollEjectorCol3Desc) {
		this.rollEjectorCol3Desc = rollEjectorCol3Desc;
	}

	/**
	 * @return the riderRollCol1
	 */
	public boolean isRiderRollCol1() {
		return riderRollCol1;
	}

	/**
	 * @param riderRollCol1
	 *            the riderRollCol1 to set
	 */
	public void setRiderRollCol1(boolean riderRollCol1) {
		this.riderRollCol1 = riderRollCol1;
	}

	/**
	 * @return the riderRollCol2
	 */
	public boolean isRiderRollCol2() {
		return riderRollCol2;
	}

	/**
	 * @param riderRollCol2
	 *            the riderRollCol2 to set
	 */
	public void setRiderRollCol2(boolean riderRollCol2) {
		this.riderRollCol2 = riderRollCol2;
	}

	/**
	 * @return the riderRollCol3
	 */
	public boolean isRiderRollCol3() {
		return riderRollCol3;
	}

	/**
	 * @param riderRollCol3
	 *            the riderRollCol3 to set
	 */
	public void setRiderRollCol3(boolean riderRollCol3) {
		this.riderRollCol3 = riderRollCol3;
	}

	/**
	 * @return the riderRollCol4
	 */
	public boolean isRiderRollCol4() {
		return riderRollCol4;
	}

	/**
	 * @param riderRollCol4
	 *            the riderRollCol4 to set
	 */
	public void setRiderRollCol4(boolean riderRollCol4) {
		this.riderRollCol4 = riderRollCol4;
	}

	/**
	 * @return the riderRollCol5
	 */
	public boolean isRiderRollCol5() {
		return riderRollCol5;
	}

	/**
	 * @param riderRollCol5
	 *            the riderRollCol5 to set
	 */
	public void setRiderRollCol5(boolean riderRollCol5) {
		this.riderRollCol5 = riderRollCol5;
	}

	/**
	 * @return the riderRollCol6
	 */
	public boolean isRiderRollCol6() {
		return riderRollCol6;
	}

	/**
	 * @param riderRollCol6
	 *            the riderRollCol6 to set
	 */
	public void setRiderRollCol6(boolean riderRollCol6) {
		this.riderRollCol6 = riderRollCol6;
	}

	/**
	 * @return the riderRollCol7
	 */
	public boolean isRiderRollCol7() {
		return riderRollCol7;
	}

	/**
	 * @param riderRollCol7
	 *            the riderRollCol7 to set
	 */
	public void setRiderRollCol7(boolean riderRollCol7) {
		this.riderRollCol7 = riderRollCol7;
	}

	/**
	 * @return the riderRollCol8
	 */
	public boolean isRiderRollCol8() {
		return riderRollCol8;
	}

	/**
	 * @param riderRollCol8
	 *            the riderRollCol8 to set
	 */
	public void setRiderRollCol8(boolean riderRollCol8) {
		this.riderRollCol8 = riderRollCol8;
	}

	/**
	 * @return the riderRollCol1Desc
	 */
	public String getRiderRollCol1Desc() {
		return riderRollCol1Desc;
	}

	/**
	 * @param riderRollCol1Desc
	 *            the riderRollCol1Desc to set
	 */
	public void setRiderRollCol1Desc(String riderRollCol1Desc) {
		this.riderRollCol1Desc = riderRollCol1Desc;
	}

	/**
	 * @return the riderRollCol2Desc
	 */
	public String getRiderRollCol2Desc() {
		return riderRollCol2Desc;
	}

	/**
	 * @param riderRollCol2Desc
	 *            the riderRollCol2Desc to set
	 */
	public void setRiderRollCol2Desc(String riderRollCol2Desc) {
		this.riderRollCol2Desc = riderRollCol2Desc;
	}

	/**
	 * @return the riderRollCol3Desc
	 */
	public String getRiderRollCol3Desc() {
		return riderRollCol3Desc;
	}

	/**
	 * @param riderRollCol3Desc
	 *            the riderRollCol3Desc to set
	 */
	public void setRiderRollCol3Desc(String riderRollCol3Desc) {
		this.riderRollCol3Desc = riderRollCol3Desc;
	}

	/**
	 * @return the riderRollCol4Desc
	 */
	public String getRiderRollCol4Desc() {
		return riderRollCol4Desc;
	}

	/**
	 * @param riderRollCol4Desc
	 *            the riderRollCol4Desc to set
	 */
	public void setRiderRollCol4Desc(String riderRollCol4Desc) {
		this.riderRollCol4Desc = riderRollCol4Desc;
	}

	/**
	 * @return the riderRollCol5Desc
	 */
	public String getRiderRollCol5Desc() {
		return riderRollCol5Desc;
	}

	/**
	 * @param riderRollCol5Desc
	 *            the riderRollCol5Desc to set
	 */
	public void setRiderRollCol5Desc(String riderRollCol5Desc) {
		this.riderRollCol5Desc = riderRollCol5Desc;
	}

	/**
	 * @return the riderRollCol6Desc
	 */
	public String getRiderRollCol6Desc() {
		return riderRollCol6Desc;
	}

	/**
	 * @param riderRollCol6Desc
	 *            the riderRollCol6Desc to set
	 */
	public void setRiderRollCol6Desc(String riderRollCol6Desc) {
		this.riderRollCol6Desc = riderRollCol6Desc;
	}

	/**
	 * @return the riderRollCol7Desc
	 */
	public String getRiderRollCol7Desc() {
		return riderRollCol7Desc;
	}

	/**
	 * @param riderRollCol7Desc
	 *            the riderRollCol7Desc to set
	 */
	public void setRiderRollCol7Desc(String riderRollCol7Desc) {
		this.riderRollCol7Desc = riderRollCol7Desc;
	}

	/**
	 * @return the riderRollCol8Desc
	 */
	public String getRiderRollCol8Desc() {
		return riderRollCol8Desc;
	}

	/**
	 * @param riderRollCol8Desc
	 *            the riderRollCol8Desc to set
	 */
	public void setRiderRollCol8Desc(String riderRollCol8Desc) {
		this.riderRollCol8Desc = riderRollCol8Desc;
	}

	/**
	 * @return the bowedRollCol1
	 */
	public boolean isBowedRollCol1() {
		return bowedRollCol1;
	}

	/**
	 * @param bowedRollCol1
	 *            the bowedRollCol1 to set
	 */
	public void setBowedRollCol1(boolean bowedRollCol1) {
		this.bowedRollCol1 = bowedRollCol1;
	}

	/**
	 * @return the bowedRollCol2
	 */
	public boolean isBowedRollCol2() {
		return bowedRollCol2;
	}

	/**
	 * @param bowedRollCol2
	 *            the bowedRollCol2 to set
	 */
	public void setBowedRollCol2(boolean bowedRollCol2) {
		this.bowedRollCol2 = bowedRollCol2;
	}

	/**
	 * @return the bowedRollCol3
	 */
	public boolean isBowedRollCol3() {
		return bowedRollCol3;
	}

	/**
	 * @param bowedRollCol3
	 *            the bowedRollCol3 to set
	 */
	public void setBowedRollCol3(boolean bowedRollCol3) {
		this.bowedRollCol3 = bowedRollCol3;
	}

	/**
	 * @return the bowedRollCol1Desc
	 */
	public String getBowedRollCol1Desc() {
		return bowedRollCol1Desc;
	}

	/**
	 * @param bowedRollCol1Desc
	 *            the bowedRollCol1Desc to set
	 */
	public void setBowedRollCol1Desc(String bowedRollCol1Desc) {
		this.bowedRollCol1Desc = bowedRollCol1Desc;
	}

	/**
	 * @return the bowedRollCol2Desc
	 */
	public String getBowedRollCol2Desc() {
		return bowedRollCol2Desc;
	}

	/**
	 * @param bowedRollCol2Desc
	 *            the bowedRollCol2Desc to set
	 */
	public void setBowedRollCol2Desc(String bowedRollCol2Desc) {
		this.bowedRollCol2Desc = bowedRollCol2Desc;
	}

	/**
	 * @return the bowedRollCol3Desc
	 */
	public String getBowedRollCol3Desc() {
		return bowedRollCol3Desc;
	}

	/**
	 * @param bowedRollCol3Desc
	 *            the bowedRollCol3Desc to set
	 */
	public void setBowedRollCol3Desc(String bowedRollCol3Desc) {
		this.bowedRollCol3Desc = bowedRollCol3Desc;
	}

	/**
	 * @return the coreChucksCol1
	 */
	public boolean isCoreChucksCol1() {
		return coreChucksCol1;
	}

	/**
	 * @param coreChucksCol1
	 *            the coreChucksCol1 to set
	 */
	public void setCoreChucksCol1(boolean coreChucksCol1) {
		this.coreChucksCol1 = coreChucksCol1;
	}

	/**
	 * @return the coreChucksCol2
	 */
	public boolean isCoreChucksCol2() {
		return coreChucksCol2;
	}

	/**
	 * @param coreChucksCol2
	 *            the coreChucksCol2 to set
	 */
	public void setCoreChucksCol2(boolean coreChucksCol2) {
		this.coreChucksCol2 = coreChucksCol2;
	}

	/**
	 * @return the coreChucksCol3
	 */
	public boolean isCoreChucksCol3() {
		return coreChucksCol3;
	}

	/**
	 * @param coreChucksCol3
	 *            the coreChucksCol3 to set
	 */
	public void setCoreChucksCol3(boolean coreChucksCol3) {
		this.coreChucksCol3 = coreChucksCol3;
	}

	/**
	 * @return the coreChucksCol4
	 */
	public boolean isCoreChucksCol4() {
		return coreChucksCol4;
	}

	/**
	 * @param coreChucksCol4
	 *            the coreChucksCol4 to set
	 */
	public void setCoreChucksCol4(boolean coreChucksCol4) {
		this.coreChucksCol4 = coreChucksCol4;
	}

	/**
	 * @return the coreChucksCol1Desc
	 */
	public String getCoreChucksCol1Desc() {
		return coreChucksCol1Desc;
	}

	/**
	 * @param coreChucksCol1Desc
	 *            the coreChucksCol1Desc to set
	 */
	public void setCoreChucksCol1Desc(String coreChucksCol1Desc) {
		this.coreChucksCol1Desc = coreChucksCol1Desc;
	}

	/**
	 * @return the coreChucksCol2Desc
	 */
	public String getCoreChucksCol2Desc() {
		return coreChucksCol2Desc;
	}

	/**
	 * @param coreChucksCol2Desc
	 *            the coreChucksCol2Desc to set
	 */
	public void setCoreChucksCol2Desc(String coreChucksCol2Desc) {
		this.coreChucksCol2Desc = coreChucksCol2Desc;
	}

	/**
	 * @return the coreChucksCol3Desc
	 */
	public String getCoreChucksCol3Desc() {
		return coreChucksCol3Desc;
	}

	/**
	 * @param coreChucksCol3Desc
	 *            the coreChucksCol3Desc to set
	 */
	public void setCoreChucksCol3Desc(String coreChucksCol3Desc) {
		this.coreChucksCol3Desc = coreChucksCol3Desc;
	}

	/**
	 * @return the coreChucksCol4Desc
	 */
	public String getCoreChucksCol4Desc() {
		return coreChucksCol4Desc;
	}

	/**
	 * @param coreChucksCol4Desc
	 *            the coreChucksCol4Desc to set
	 */
	public void setCoreChucksCol4Desc(String coreChucksCol4Desc) {
		this.coreChucksCol4Desc = coreChucksCol4Desc;
	}

	/**
	 * @return the nipGuardCol1
	 */
	public boolean isNipGuardCol1() {
		return nipGuardCol1;
	}

	/**
	 * @param nipGuardCol1
	 *            the nipGuardCol1 to set
	 */
	public void setNipGuardCol1(boolean nipGuardCol1) {
		this.nipGuardCol1 = nipGuardCol1;
	}

	/**
	 * @return the nipGuardCol2
	 */
	public boolean isNipGuardCol2() {
		return nipGuardCol2;
	}

	/**
	 * @param nipGuardCol2
	 *            the nipGuardCol2 to set
	 */
	public void setNipGuardCol2(boolean nipGuardCol2) {
		this.nipGuardCol2 = nipGuardCol2;
	}

	/**
	 * @return the nipGuardCol3
	 */
	public boolean isNipGuardCol3() {
		return nipGuardCol3;
	}

	/**
	 * @param nipGuardCol3
	 *            the nipGuardCol3 to set
	 */
	public void setNipGuardCol3(boolean nipGuardCol3) {
		this.nipGuardCol3 = nipGuardCol3;
	}

	/**
	 * @return the nipGuardCol1Desc
	 */
	public String getNipGuardCol1Desc() {
		return nipGuardCol1Desc;
	}

	/**
	 * @param nipGuardCol1Desc
	 *            the nipGuardCol1Desc to set
	 */
	public void setNipGuardCol1Desc(String nipGuardCol1Desc) {
		this.nipGuardCol1Desc = nipGuardCol1Desc;
	}

	/**
	 * @return the nipGuardCol2Desc
	 */
	public String getNipGuardCol2Desc() {
		return nipGuardCol2Desc;
	}

	/**
	 * @param nipGuardCol2Desc
	 *            the nipGuardCol2Desc to set
	 */
	public void setNipGuardCol2Desc(String nipGuardCol2Desc) {
		this.nipGuardCol2Desc = nipGuardCol2Desc;
	}

	/**
	 * @return the nipGuardCol3Desc
	 */
	public String getNipGuardCol3Desc() {
		return nipGuardCol3Desc;
	}

	/**
	 * @param nipGuardCol3Desc
	 *            the nipGuardCol3Desc to set
	 */
	public void setNipGuardCol3Desc(String nipGuardCol3Desc) {
		this.nipGuardCol3Desc = nipGuardCol3Desc;
	}

	/**
	 * @return the tableLeftGateCol1
	 */
	public boolean isTableLeftGateCol1() {
		return tableLeftGateCol1;
	}

	/**
	 * @param tableLeftGateCol1
	 *            the tableLeftGateCol1 to set
	 */
	public void setTableLeftGateCol1(boolean tableLeftGateCol1) {
		this.tableLeftGateCol1 = tableLeftGateCol1;
	}

	/**
	 * @return the tableLeftGateCol2
	 */
	public boolean isTableLeftGateCol2() {
		return tableLeftGateCol2;
	}

	/**
	 * @param tableLeftGateCol2
	 *            the tableLeftGateCol2 to set
	 */
	public void setTableLeftGateCol2(boolean tableLeftGateCol2) {
		this.tableLeftGateCol2 = tableLeftGateCol2;
	}

	/**
	 * @return the tableLeftGateCol1Desc
	 */
	public String getTableLeftGateCol1Desc() {
		return tableLeftGateCol1Desc;
	}

	/**
	 * @param tableLeftGateCol1Desc
	 *            the tableLeftGateCol1Desc to set
	 */
	public void setTableLeftGateCol1Desc(String tableLeftGateCol1Desc) {
		this.tableLeftGateCol1Desc = tableLeftGateCol1Desc;
	}

	/**
	 * @return the tableLeftGateCol2Desc
	 */
	public String getTableLeftGateCol2Desc() {
		return tableLeftGateCol2Desc;
	}

	/**
	 * @param tableLeftGateCol2Desc
	 *            the tableLeftGateCol2Desc to set
	 */
	public void setTableLeftGateCol2Desc(String tableLeftGateCol2Desc) {
		this.tableLeftGateCol2Desc = tableLeftGateCol2Desc;
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
	}}
