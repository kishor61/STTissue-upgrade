/**
* *Jun 16, 2016
 *UtilityOperator.java
 * TODO
 *com.st.obcc.model
 *UtilityOperator.java
 *Sunil Singh Bora
 */
package com.st.obccPM5.model;

/**
 * @author snavhaal
 *
 */
public class UtilityOperatorPM5 {

	private int id;
	private String position;
	private String operatorName;
	private String edate;
	private String crew;
	private String shift;	
	private boolean machinedown;
	private boolean checklistcompleted;
	private boolean clampscleanofburrs;
	private boolean anyvisibleissue;
	private boolean motorizedhandtruck;
	private boolean batterychangesandcableintact;
	private boolean cautionlightoperational;
	private boolean controlarmoperatingproperly;
	private boolean anymovementissue;
	private boolean handtruckblowdown;
	private boolean liftingproperly;
	private boolean bothfoldoutwingsopenorclosed;
	private boolean botharetobeopenedandclosedatthesametime;
	private boolean alllocksoperational;
	private boolean alllightintactandworking;
	private boolean gladhandlocksbeingused;
	
	private String checklistcompletedDesc;
	private String clampscleanofburrsDesc;
	private String anyvisibleissueDesc;
	private String motorizedhandtruckDesc;
	private String batterychangesandcableintactDesc;
	private String cautionlightoperationalDesc;
	private String controlarmoperatingproperlyDesc;
	private String anymovementissueDesc;
	private String handtruckblowdownDesc;
	private String liftingproperlyDesc;
	private String bothfoldoutwingsopenorclosedDesc;
	private String botharetobeopenedandclosedatthesametimeDesc;
	private String alllocksoperationalDesc;
	private String alllightintactandworkingDesc;
	private String gladhandlocksbeingusedDesc;
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
	 * @return the checklistcompleted
	 */
	public boolean isChecklistcompleted() {
		return checklistcompleted;
	}
	/**
	 * @param checklistcompleted the checklistcompleted to set
	 */
	public void setChecklistcompleted(boolean checklistcompleted) {
		this.checklistcompleted = checklistcompleted;
	}
	/**
	 * @return the clampscleanofburrs
	 */
	public boolean isClampscleanofburrs() {
		return clampscleanofburrs;
	}
	/**
	 * @param clampscleanofburrs the clampscleanofburrs to set
	 */
	public void setClampscleanofburrs(boolean clampscleanofburrs) {
		this.clampscleanofburrs = clampscleanofburrs;
	}
	/**
	 * @return the anyvisibleissue
	 */
	public boolean isAnyvisibleissue() {
		return anyvisibleissue;
	}
	/**
	 * @param anyvisibleissue the anyvisibleissue to set
	 */
	public void setAnyvisibleissue(boolean anyvisibleissue) {
		this.anyvisibleissue = anyvisibleissue;
	}
	/**
	 * @return the motorizedhandtruck
	 */
	public boolean isMotorizedhandtruck() {
		return motorizedhandtruck;
	}
	/**
	 * @param motorizedhandtruck the motorizedhandtruck to set
	 */
	public void setMotorizedhandtruck(boolean motorizedhandtruck) {
		this.motorizedhandtruck = motorizedhandtruck;
	}
	/**
	 * @return the batterychangesandcableintact
	 */
	public boolean isBatterychangesandcableintact() {
		return batterychangesandcableintact;
	}
	/**
	 * @param batterychangesandcableintact the batterychangesandcableintact to set
	 */
	public void setBatterychangesandcableintact(boolean batterychangesandcableintact) {
		this.batterychangesandcableintact = batterychangesandcableintact;
	}
	/**
	 * @return the cautionlightoperational
	 */
	public boolean isCautionlightoperational() {
		return cautionlightoperational;
	}
	/**
	 * @param cautionlightoperational the cautionlightoperational to set
	 */
	public void setCautionlightoperational(boolean cautionlightoperational) {
		this.cautionlightoperational = cautionlightoperational;
	}
	/**
	 * @return the controlarmoperatingproperly
	 */
	public boolean isControlarmoperatingproperly() {
		return controlarmoperatingproperly;
	}
	/**
	 * @param controlarmoperatingproperly the controlarmoperatingproperly to set
	 */
	public void setControlarmoperatingproperly(boolean controlarmoperatingproperly) {
		this.controlarmoperatingproperly = controlarmoperatingproperly;
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
	 * @return the handtruckblowdown
	 */
	public boolean isHandtruckblowdown() {
		return handtruckblowdown;
	}
	/**
	 * @param handtruckblowdown the handtruckblowdown to set
	 */
	public void setHandtruckblowdown(boolean handtruckblowdown) {
		this.handtruckblowdown = handtruckblowdown;
	}
	/**
	 * @return the liftingproperly
	 */
	public boolean isLiftingproperly() {
		return liftingproperly;
	}
	/**
	 * @param liftingproperly the liftingproperly to set
	 */
	public void setLiftingproperly(boolean liftingproperly) {
		this.liftingproperly = liftingproperly;
	}
	/**
	 * @return the bothfoldoutwingsopenorclosed
	 */
	public boolean isBothfoldoutwingsopenorclosed() {
		return bothfoldoutwingsopenorclosed;
	}
	/**
	 * @param bothfoldoutwingsopenorclosed the bothfoldoutwingsopenorclosed to set
	 */
	public void setBothfoldoutwingsopenorclosed(boolean bothfoldoutwingsopenorclosed) {
		this.bothfoldoutwingsopenorclosed = bothfoldoutwingsopenorclosed;
	}
	/**
	 * @return the botharetobeopenedandclosedatthesametime
	 */
	public boolean isBotharetobeopenedandclosedatthesametime() {
		return botharetobeopenedandclosedatthesametime;
	}
	/**
	 * @param botharetobeopenedandclosedatthesametime the botharetobeopenedandclosedatthesametime to set
	 */
	public void setBotharetobeopenedandclosedatthesametime(boolean botharetobeopenedandclosedatthesametime) {
		this.botharetobeopenedandclosedatthesametime = botharetobeopenedandclosedatthesametime;
	}
	/**
	 * @return the alllocksoperational
	 */
	public boolean isAlllocksoperational() {
		return alllocksoperational;
	}
	/**
	 * @param alllocksoperational the alllocksoperational to set
	 */
	public void setAlllocksoperational(boolean alllocksoperational) {
		this.alllocksoperational = alllocksoperational;
	}
	/**
	 * @return the alllightintactandworking
	 */
	public boolean isAlllightintactandworking() {
		return alllightintactandworking;
	}
	/**
	 * @param alllightintactandworking the alllightintactandworking to set
	 */
	public void setAlllightintactandworking(boolean alllightintactandworking) {
		this.alllightintactandworking = alllightintactandworking;
	}
	/**
	 * @return the gladhandlocksbeingused
	 */
	public boolean isGladhandlocksbeingused() {
		return gladhandlocksbeingused;
	}
	/**
	 * @param gladhandlocksbeingused the gladhandlocksbeingused to set
	 */
	public void setGladhandlocksbeingused(boolean gladhandlocksbeingused) {
		this.gladhandlocksbeingused = gladhandlocksbeingused;
	}
	/**
	 * @return the checklistcompletedDesc
	 */
	public String getChecklistcompletedDesc() {
		return checklistcompletedDesc;
	}
	/**
	 * @param checklistcompletedDesc the checklistcompletedDesc to set
	 */
	public void setChecklistcompletedDesc(String checklistcompletedDesc) {
		this.checklistcompletedDesc = checklistcompletedDesc;
	}
	/**
	 * @return the clampscleanofburrsDesc
	 */
	public String getClampscleanofburrsDesc() {
		return clampscleanofburrsDesc;
	}
	/**
	 * @param clampscleanofburrsDesc the clampscleanofburrsDesc to set
	 */
	public void setClampscleanofburrsDesc(String clampscleanofburrsDesc) {
		this.clampscleanofburrsDesc = clampscleanofburrsDesc;
	}
	/**
	 * @return the anyvisibleissueDesc
	 */
	public String getAnyvisibleissueDesc() {
		return anyvisibleissueDesc;
	}
	/**
	 * @param anyvisibleissueDesc the anyvisibleissueDesc to set
	 */
	public void setAnyvisibleissueDesc(String anyvisibleissueDesc) {
		this.anyvisibleissueDesc = anyvisibleissueDesc;
	}
	/**
	 * @return the motorizedhandtruckDesc
	 */
	public String getMotorizedhandtruckDesc() {
		return motorizedhandtruckDesc;
	}
	/**
	 * @param motorizedhandtruckDesc the motorizedhandtruckDesc to set
	 */
	public void setMotorizedhandtruckDesc(String motorizedhandtruckDesc) {
		this.motorizedhandtruckDesc = motorizedhandtruckDesc;
	}
	/**
	 * @return the batterychangesandcableintactDesc
	 */
	public String getBatterychangesandcableintactDesc() {
		return batterychangesandcableintactDesc;
	}
	/**
	 * @param batterychangesandcableintactDesc the batterychangesandcableintactDesc to set
	 */
	public void setBatterychangesandcableintactDesc(String batterychangesandcableintactDesc) {
		this.batterychangesandcableintactDesc = batterychangesandcableintactDesc;
	}
	/**
	 * @return the cautionlightoperationalDesc
	 */
	public String getCautionlightoperationalDesc() {
		return cautionlightoperationalDesc;
	}
	/**
	 * @param cautionlightoperationalDesc the cautionlightoperationalDesc to set
	 */
	public void setCautionlightoperationalDesc(String cautionlightoperationalDesc) {
		this.cautionlightoperationalDesc = cautionlightoperationalDesc;
	}
	/**
	 * @return the controlarmoperatingproperlyDesc
	 */
	public String getControlarmoperatingproperlyDesc() {
		return controlarmoperatingproperlyDesc;
	}
	/**
	 * @param controlarmoperatingproperlyDesc the controlarmoperatingproperlyDesc to set
	 */
	public void setControlarmoperatingproperlyDesc(String controlarmoperatingproperlyDesc) {
		this.controlarmoperatingproperlyDesc = controlarmoperatingproperlyDesc;
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
	 * @return the handtruckblowdownDesc
	 */
	public String getHandtruckblowdownDesc() {
		return handtruckblowdownDesc;
	}
	/**
	 * @param handtruckblowdownDesc the handtruckblowdownDesc to set
	 */
	public void setHandtruckblowdownDesc(String handtruckblowdownDesc) {
		this.handtruckblowdownDesc = handtruckblowdownDesc;
	}
	/**
	 * @return the liftingproperlyDesc
	 */
	public String getLiftingproperlyDesc() {
		return liftingproperlyDesc;
	}
	/**
	 * @param liftingproperlyDesc the liftingproperlyDesc to set
	 */
	public void setLiftingproperlyDesc(String liftingproperlyDesc) {
		this.liftingproperlyDesc = liftingproperlyDesc;
	}
	/**
	 * @return the bothfoldoutwingsopenorclosedDesc
	 */
	public String getBothfoldoutwingsopenorclosedDesc() {
		return bothfoldoutwingsopenorclosedDesc;
	}
	/**
	 * @param bothfoldoutwingsopenorclosedDesc the bothfoldoutwingsopenorclosedDesc to set
	 */
	public void setBothfoldoutwingsopenorclosedDesc(String bothfoldoutwingsopenorclosedDesc) {
		this.bothfoldoutwingsopenorclosedDesc = bothfoldoutwingsopenorclosedDesc;
	}
	/**
	 * @return the botharetobeopenedandclosedatthesametimeDesc
	 */
	public String getBotharetobeopenedandclosedatthesametimeDesc() {
		return botharetobeopenedandclosedatthesametimeDesc;
	}
	/**
	 * @param botharetobeopenedandclosedatthesametimeDesc the botharetobeopenedandclosedatthesametimeDesc to set
	 */
	public void setBotharetobeopenedandclosedatthesametimeDesc(String botharetobeopenedandclosedatthesametimeDesc) {
		this.botharetobeopenedandclosedatthesametimeDesc = botharetobeopenedandclosedatthesametimeDesc;
	}
	/**
	 * @return the alllocksoperationalDesc
	 */
	public String getAlllocksoperationalDesc() {
		return alllocksoperationalDesc;
	}
	/**
	 * @param alllocksoperationalDesc the alllocksoperationalDesc to set
	 */
	public void setAlllocksoperationalDesc(String alllocksoperationalDesc) {
		this.alllocksoperationalDesc = alllocksoperationalDesc;
	}
	/**
	 * @return the alllightintactandworkingDesc
	 */
	public String getAlllightintactandworkingDesc() {
		return alllightintactandworkingDesc;
	}
	/**
	 * @param alllightintactandworkingDesc the alllightintactandworkingDesc to set
	 */
	public void setAlllightintactandworkingDesc(String alllightintactandworkingDesc) {
		this.alllightintactandworkingDesc = alllightintactandworkingDesc;
	}
	/**
	 * @return the gladhandlocksbeingusedDesc
	 */
	public String getGladhandlocksbeingusedDesc() {
		return gladhandlocksbeingusedDesc;
	}
	/**
	 * @param gladhandlocksbeingusedDesc the gladhandlocksbeingusedDesc to set
	 */
	public void setGladhandlocksbeingusedDesc(String gladhandlocksbeingusedDesc) {
		this.gladhandlocksbeingusedDesc = gladhandlocksbeingusedDesc;
	}
}
