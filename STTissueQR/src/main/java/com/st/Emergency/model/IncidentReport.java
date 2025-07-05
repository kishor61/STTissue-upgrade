/**
 *Feb 16, 2023
 *IncidentReport.java
 * TODO
 *com.st.Emergency.model
 *IncidentReport.java
 *Sohan Lal 
 */
package com.st.Emergency.model;

import java.util.Date;

/**
 * @author kishore
 *
 */
public class IncidentReport {	
	private int id;
	private int emergencyIncidentID;
	private String number;
	private String owner;
	private String revision;
	private String date1;
	private String investigator;
	private String incidentType;
	private String area;
	private String date2;
	private boolean preCheck1;
	private boolean preCheck2;
	private boolean preCheck3;
	private boolean PreCheck4;
	private boolean initCheck1;
	private String  initValue1;
	private boolean initCheck2;
	private String  initValue2;
	private boolean initCheck3;
	private String  initValue3;
	private boolean initCheck4;
	private String  initValue4;
	private boolean initCheck5;
	private boolean initCheck6;
	private boolean initCheck7;
	private boolean initCheck8;
	private boolean initCheck9;
	private String descOfIncident;
	private String causeOfIncident;
	private boolean lackOfCheckBox;
	private boolean proceNotFollCheckbox;
	private boolean jsaCheckBox;
	private boolean lackOfTraningCheckbox;
	private boolean preUseInspecCheckbox;
	private boolean equipmtCheckbox;
	private boolean correctToolCheckbox;
	private boolean enviromentCondtnCheckbox;
	private boolean walkingSurfaceCheckbox;
	private boolean lightVisibilityCheckbox;
	private boolean poorHousekeepingCheckbox;
	private boolean ergonCheckbox;
	private boolean tightCheckbox;
	private boolean lineOfFireCheckbox;
	private boolean eyesOnTaskCheckbox;
	private boolean hurriedCheckbox;
	private boolean frustratedCheckbox;
	private boolean fatiguedCheckbox;
	private boolean complacentCheckbox;
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the revision
	 */
	public String getRevision() {
		return revision;
	}
	/**
	 * @param revision the revision to set
	 */
	public void setRevision(String revision) {
		this.revision = revision;
	}
	
	/**
	 * @return the investigator
	 */
	public String getInvestigator() {
		return investigator;
	}
	/**
	 * @param investigator the investigator to set
	 */
	public void setInvestigator(String investigator) {
		this.investigator = investigator;
	}
	/**
	 * @return the incidentType
	 */
	public String getIncidentType() {
		return incidentType;
	}
	/**
	 * @param incidentType the incidentType to set
	 */
	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	 * @return the preCheck1
	 */
	public boolean isPreCheck1() {
		return preCheck1;
	}
	/**
	 * @param preCheck1 the preCheck1 to set
	 */
	public void setPreCheck1(boolean preCheck1) {
		this.preCheck1 = preCheck1;
	}
	/**
	 * @return the preCheck2
	 */
	public boolean isPreCheck2() {
		return preCheck2;
	}
	/**
	 * @param preCheck2 the preCheck2 to set
	 */
	public void setPreCheck2(boolean preCheck2) {
		this.preCheck2 = preCheck2;
	}
	/**
	 * @return the preCheck3
	 */
	public boolean isPreCheck3() {
		return preCheck3;
	}
	/**
	 * @param preCheck3 the preCheck3 to set
	 */
	public void setPreCheck3(boolean preCheck3) {
		this.preCheck3 = preCheck3;
	}
	/**
	 * @return the preCheck4
	 */
	public boolean isPreCheck4() {
		return PreCheck4;
	}
	/**
	 * @param preCheck4 the preCheck4 to set
	 */
	public void setPreCheck4(boolean preCheck4) {
		PreCheck4 = preCheck4;
	}
	/**
	 * @return the initCheck1
	 */
	public boolean isInitCheck1() {
		return initCheck1;
	}
	/**
	 * @param initCheck1 the initCheck1 to set
	 */
	public void setInitCheck1(boolean initCheck1) {
		this.initCheck1 = initCheck1;
	}
	/**
	 * @return the initValue1
	 */
	public String getInitValue1() {
		return initValue1;
	}
	/**
	 * @param initValue1 the initValue1 to set
	 */
	public void setInitValue1(String initValue1) {
		this.initValue1 = initValue1;
	}
	/**
	 * @return the initCheck2
	 */
	public boolean isInitCheck2() {
		return initCheck2;
	}
	/**
	 * @param initCheck2 the initCheck2 to set
	 */
	public void setInitCheck2(boolean initCheck2) {
		this.initCheck2 = initCheck2;
	}
	/**
	 * @return the initValue2
	 */
	public String getInitValue2() {
		return initValue2;
	}
	/**
	 * @param initValue2 the initValue2 to set
	 */
	public void setInitValue2(String initValue2) {
		this.initValue2 = initValue2;
	}
	/**
	 * @return the initCheck3
	 */
	public boolean isInitCheck3() {
		return initCheck3;
	}
	/**
	 * @param initCheck3 the initCheck3 to set
	 */
	public void setInitCheck3(boolean initCheck3) {
		this.initCheck3 = initCheck3;
	}
	/**
	 * @return the initValue3
	 */
	public String getInitValue3() {
		return initValue3;
	}
	/**
	 * @param initValue3 the initValue3 to set
	 */
	public void setInitValue3(String initValue3) {
		this.initValue3 = initValue3;
	}
	/**
	 * @return the initCheck4
	 */
	public boolean isInitCheck4() {
		return initCheck4;
	}
	/**
	 * @param initCheck4 the initCheck4 to set
	 */
	public void setInitCheck4(boolean initCheck4) {
		this.initCheck4 = initCheck4;
	}
	/**
	 * @return the initValue4
	 */
	public String getInitValue4() {
		return initValue4;
	}
	/**
	 * @param initValue4 the initValue4 to set
	 */
	public void setInitValue4(String initValue4) {
		this.initValue4 = initValue4;
	}
	/**
	 * @return the initCheck5
	 */
	public boolean isInitCheck5() {
		return initCheck5;
	}
	/**
	 * @param initCheck5 the initCheck5 to set
	 */
	public void setInitCheck5(boolean initCheck5) {
		this.initCheck5 = initCheck5;
	}
	/**
	 * @return the initCheck6
	 */
	public boolean isInitCheck6() {
		return initCheck6;
	}
	/**
	 * @param initCheck6 the initCheck6 to set
	 */
	public void setInitCheck6(boolean initCheck6) {
		this.initCheck6 = initCheck6;
	}
	/**
	 * @return the initCheck7
	 */
	public boolean isInitCheck7() {
		return initCheck7;
	}
	/**
	 * @param initCheck7 the initCheck7 to set
	 */
	public void setInitCheck7(boolean initCheck7) {
		this.initCheck7 = initCheck7;
	}
	/**
	 * @return the initCheck8
	 */
	public boolean isInitCheck8() {
		return initCheck8;
	}
	/**
	 * @param initCheck8 the initCheck8 to set
	 */
	public void setInitCheck8(boolean initCheck8) {
		this.initCheck8 = initCheck8;
	}
	/**
	 * @return the initCheck9
	 */
	public boolean isInitCheck9() {
		return initCheck9;
	}
	/**
	 * @param initCheck9 the initCheck9 to set
	 */
	public void setInitCheck9(boolean initCheck9) {
		this.initCheck9 = initCheck9;
	}
	/**
	 * @return the descOfIncident
	 */
	public String getDescOfIncident() {
		return descOfIncident;
	}
	/**
	 * @param descOfIncident the descOfIncident to set
	 */
	public void setDescOfIncident(String descOfIncident) {
		this.descOfIncident = descOfIncident;
	}
	/**
	 * @return the causeOfIncident
	 */
	public String getCauseOfIncident() {
		return causeOfIncident;
	}
	/**
	 * @param causeOfIncident the causeOfIncident to set
	 */
	public void setCauseOfIncident(String causeOfIncident) {
		this.causeOfIncident = causeOfIncident;
	}
	/**
	 * @return the lackOfCheckBox
	 */
	public boolean isLackOfCheckBox() {
		return lackOfCheckBox;
	}
	/**
	 * @param lackOfCheckBox the lackOfCheckBox to set
	 */
	public void setLackOfCheckBox(boolean lackOfCheckBox) {
		this.lackOfCheckBox = lackOfCheckBox;
	}
	/**
	 * @return the proceNotFollCheckbox
	 */
	public boolean isProceNotFollCheckbox() {
		return proceNotFollCheckbox;
	}
	/**
	 * @param proceNotFollCheckbox the proceNotFollCheckbox to set
	 */
	public void setProceNotFollCheckbox(boolean proceNotFollCheckbox) {
		this.proceNotFollCheckbox = proceNotFollCheckbox;
	}
	/**
	 * @return the jsaCheckBox
	 */
	public boolean isJsaCheckBox() {
		return jsaCheckBox;
	}
	/**
	 * @param jsaCheckBox the jsaCheckBox to set
	 */
	public void setJsaCheckBox(boolean jsaCheckBox) {
		this.jsaCheckBox = jsaCheckBox;
	}
	/**
	 * @return the lackOfTraningCheckbox
	 */
	public boolean isLackOfTraningCheckbox() {
		return lackOfTraningCheckbox;
	}
	/**
	 * @param lackOfTraningCheckbox the lackOfTraningCheckbox to set
	 */
	public void setLackOfTraningCheckbox(boolean lackOfTraningCheckbox) {
		this.lackOfTraningCheckbox = lackOfTraningCheckbox;
	}
	/**
	 * @return the preUseInspecCheckbox
	 */
	public boolean isPreUseInspecCheckbox() {
		return preUseInspecCheckbox;
	}
	/**
	 * @param preUseInspecCheckbox the preUseInspecCheckbox to set
	 */
	public void setPreUseInspecCheckbox(boolean preUseInspecCheckbox) {
		this.preUseInspecCheckbox = preUseInspecCheckbox;
	}
	/**
	 * @return the equipmtCheckbox
	 */
	public boolean isEquipmtCheckbox() {
		return equipmtCheckbox;
	}
	/**
	 * @param equipmtCheckbox the equipmtCheckbox to set
	 */
	public void setEquipmtCheckbox(boolean equipmtCheckbox) {
		this.equipmtCheckbox = equipmtCheckbox;
	}
	/**
	 * @return the correctToolCheckbox
	 */
	public boolean isCorrectToolCheckbox() {
		return correctToolCheckbox;
	}
	/**
	 * @param correctToolCheckbox the correctToolCheckbox to set
	 */
	public void setCorrectToolCheckbox(boolean correctToolCheckbox) {
		this.correctToolCheckbox = correctToolCheckbox;
	}
	/**
	 * @return the enviromentCondtnCheckbox
	 */
	public boolean isEnviromentCondtnCheckbox() {
		return enviromentCondtnCheckbox;
	}
	/**
	 * @param enviromentCondtnCheckbox the enviromentCondtnCheckbox to set
	 */
	public void setEnviromentCondtnCheckbox(boolean enviromentCondtnCheckbox) {
		this.enviromentCondtnCheckbox = enviromentCondtnCheckbox;
	}
	/**
	 * @return the walkingSurfaceCheckbox
	 */
	public boolean isWalkingSurfaceCheckbox() {
		return walkingSurfaceCheckbox;
	}
	/**
	 * @param walkingSurfaceCheckbox the walkingSurfaceCheckbox to set
	 */
	public void setWalkingSurfaceCheckbox(boolean walkingSurfaceCheckbox) {
		this.walkingSurfaceCheckbox = walkingSurfaceCheckbox;
	}
	/**
	 * @return the lightVisibilityCheckbox
	 */
	public boolean isLightVisibilityCheckbox() {
		return lightVisibilityCheckbox;
	}
	/**
	 * @param lightVisibilityCheckbox the lightVisibilityCheckbox to set
	 */
	public void setLightVisibilityCheckbox(boolean lightVisibilityCheckbox) {
		this.lightVisibilityCheckbox = lightVisibilityCheckbox;
	}
	/**
	 * @return the poorHousekeepingCheckbox
	 */
	public boolean isPoorHousekeepingCheckbox() {
		return poorHousekeepingCheckbox;
	}
	/**
	 * @param poorHousekeepingCheckbox the poorHousekeepingCheckbox to set
	 */
	public void setPoorHousekeepingCheckbox(boolean poorHousekeepingCheckbox) {
		this.poorHousekeepingCheckbox = poorHousekeepingCheckbox;
	}
	/**
	 * @return the ergonCheckbox
	 */
	public boolean isErgonCheckbox() {
		return ergonCheckbox;
	}
	/**
	 * @param ergonCheckbox the ergonCheckbox to set
	 */
	public void setErgonCheckbox(boolean ergonCheckbox) {
		this.ergonCheckbox = ergonCheckbox;
	}
	/**
	 * @return the tightCheckbox
	 */
	public boolean isTightCheckbox() {
		return tightCheckbox;
	}
	/**
	 * @param tightCheckbox the tightCheckbox to set
	 */
	public void setTightCheckbox(boolean tightCheckbox) {
		this.tightCheckbox = tightCheckbox;
	}
	/**
	 * @return the lineOfFireCheckbox
	 */
	public boolean isLineOfFireCheckbox() {
		return lineOfFireCheckbox;
	}
	/**
	 * @param lineOfFireCheckbox the lineOfFireCheckbox to set
	 */
	public void setLineOfFireCheckbox(boolean lineOfFireCheckbox) {
		this.lineOfFireCheckbox = lineOfFireCheckbox;
	}
	/**
	 * @return the eyesOnTaskCheckbox
	 */
	public boolean isEyesOnTaskCheckbox() {
		return eyesOnTaskCheckbox;
	}
	/**
	 * @param eyesOnTaskCheckbox the eyesOnTaskCheckbox to set
	 */
	public void setEyesOnTaskCheckbox(boolean eyesOnTaskCheckbox) {
		this.eyesOnTaskCheckbox = eyesOnTaskCheckbox;
	}
	/**
	 * @return the hurriedCheckbox
	 */
	public boolean isHurriedCheckbox() {
		return hurriedCheckbox;
	}
	/**
	 * @param hurriedCheckbox the hurriedCheckbox to set
	 */
	public void setHurriedCheckbox(boolean hurriedCheckbox) {
		this.hurriedCheckbox = hurriedCheckbox;
	}
	/**
	 * @return the frustratedCheckbox
	 */
	public boolean isFrustratedCheckbox() {
		return frustratedCheckbox;
	}
	/**
	 * @param frustratedCheckbox the frustratedCheckbox to set
	 */
	public void setFrustratedCheckbox(boolean frustratedCheckbox) {
		this.frustratedCheckbox = frustratedCheckbox;
	}
	/**
	 * @return the fatiguedCheckbox
	 */
	public boolean isFatiguedCheckbox() {
		return fatiguedCheckbox;
	}
	/**
	 * @param fatiguedCheckbox the fatiguedCheckbox to set
	 */
	public void setFatiguedCheckbox(boolean fatiguedCheckbox) {
		this.fatiguedCheckbox = fatiguedCheckbox;
	}
	/**
	 * @return the complacentCheckbox
	 */
	public boolean isComplacentCheckbox() {
		return complacentCheckbox;
	}
	/**
	 * @param complacentCheckbox the complacentCheckbox to set
	 */
	public void setComplacentCheckbox(boolean complacentCheckbox) {
		this.complacentCheckbox = complacentCheckbox;
	}
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
	 * @return the emergencyIncidentID
	 */
	public int getEmergencyIncidentID() {
		return emergencyIncidentID;
	}
	/**
	 * @param emergencyIncidentID the emergencyIncidentID to set
	 */
	public void setEmergencyIncidentID(int emergencyIncidentID) {
		this.emergencyIncidentID = emergencyIncidentID;
	}
	/**
	 * @return the date1
	 */
	public String getDate1() {
		return date1;
	}
	/**
	 * @param date1 the date1 to set
	 */
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	/**
	 * @return the date2
	 */
	public String getDate2() {
		return date2;
	}
	/**
	 * @param date2 the date2 to set
	 */
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	
	
}
