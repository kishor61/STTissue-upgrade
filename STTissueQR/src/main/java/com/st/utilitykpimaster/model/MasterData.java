/**
 * 
 */
package com.st.utilitykpimaster.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class MasterData {
	private int id;
	private Date date;
	private double avgThp;
	private double prodBlead;
	private double prodKraft;
	private double prodSlabOff;
	private double prodWrapBlead;
	private double prodProdWhite;
	private double prodProdRed;
	private double prodProdReject;
	private double naturalGasFlow;
	private double fiberLossSewerFlow;
	private double fiberLossSfConsy;
	private double fiberLossWwToFrp;
	private double fiberLossWfFlow;
	private double pulpWlap;
	private double energyElectrical;
	private double pulpDataFromFrp;
	private double pulpConsumedFromHd;
	private double pulpDataProdDcs;
	private double pulpDataHdLevel;
	private String tissueGrade;
	private double pulpInHd;
	
	
	//New fields for chemical
	private double chemWetStrength;
	private double chemRelease;
	private double chemAdhesive;
	private double chemMap;
	private double chemDefoamer;
	private double chemPassivator;
		

	//Field for Historical Data
	private int downtimeMin;
	private double consumedStock;
	private double naturalGasFlowDryend;
	private int downtimeDayMin;
	private int downtimeNightMin;
	private int machineDowntimeMin;
	
	private double coddischarge;
	
	
	public int getDowntimeDayMin() {
		return downtimeDayMin;
	}

	public void setDowntimeDayMin(int downtimeDayMin) {
		this.downtimeDayMin = downtimeDayMin;
	}

	public int getDowntimeNightMin() {
		return downtimeNightMin;
	}

	public void setDowntimeNightMin(int downtimeNightMin) {
		this.downtimeNightMin = downtimeNightMin;
	}

	public int getMachineDowntimeMin() {
		return machineDowntimeMin;
	}

	public void setMachineDowntimeMin(int machineDowntimeMin) {
		this.machineDowntimeMin = machineDowntimeMin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAvgThp() {
		return avgThp;
	}

	public void setAvgThp(double avgThp) {
		this.avgThp = avgThp;
	}

	public double getProdBlead() {
		return prodBlead;
	}

	public void setProdBlead(double prodBlead) {
		this.prodBlead = prodBlead;
	}

	public double getProdKraft() {
		return prodKraft;
	}

	public void setProdKraft(double prodKraft) {
		this.prodKraft = prodKraft;
	}

	public double getProdSlabOff() {
		return prodSlabOff;
	}

	public void setProdSlabOff(double prodSlabOff) {
		this.prodSlabOff = prodSlabOff;
	}

	public double getProdWrapBlead() {
		return prodWrapBlead;
	}

	public void setProdWrapBlead(double prodWrapBlead) {
		this.prodWrapBlead = prodWrapBlead;
	}

	public double getProdProdWhite() {
		return prodProdWhite;
	}

	public void setProdProdWhite(double prodProdWhite) {
		this.prodProdWhite = prodProdWhite;
	}

	public double getProdProdRed() {
		return prodProdRed;
	}

	public void setProdProdRed(double prodProdRed) {
		this.prodProdRed = prodProdRed;
	}

	public double getProdProdReject() {
		return prodProdReject;
	}

	public void setProdProdReject(double prodProdReject) {
		this.prodProdReject = prodProdReject;
	}


	public double getNaturalGasFlow() {
		return naturalGasFlow;
	}

	public void setNaturalGasFlow(double naturalGasFlow) {
		this.naturalGasFlow = naturalGasFlow;
	}

	public double getFiberLossSewerFlow() {
		return fiberLossSewerFlow;
	}

	public void setFiberLossSewerFlow(double fiberLossSewerFlow) {
		this.fiberLossSewerFlow = fiberLossSewerFlow;
	}

	public double getFiberLossSfConsy() {
		return fiberLossSfConsy;
	}

	public void setFiberLossSfConsy(double fiberLossSfConsy) {
		this.fiberLossSfConsy = fiberLossSfConsy;
	}

	public double getFiberLossWwToFrp() {
		return fiberLossWwToFrp;
	}

	public void setFiberLossWwToFrp(double fiberLossWwToFrp) {
		this.fiberLossWwToFrp = fiberLossWwToFrp;
	}

	public double getFiberLossWfFlow() {
		return fiberLossWfFlow;
	}

	public void setFiberLossWfFlow(double fiberLossWfFlow) {
		this.fiberLossWfFlow = fiberLossWfFlow;
	}

	public double getPulpWlap() {
		return pulpWlap;
	}

	public void setPulpWlap(double pulpWlap) {
		this.pulpWlap = pulpWlap;
	}

	public double getEnergyElectrical() {
		return energyElectrical;
	}

	public void setEnergyElectrical(double energyElectrical) {
		this.energyElectrical = energyElectrical;
	}

	public double getPulpDataFromFrp() {
		return pulpDataFromFrp;
	}

	public void setPulpDataFromFrp(double pulpDataFromFrp) {
		this.pulpDataFromFrp = pulpDataFromFrp;
	}

	public double getPulpConsumedFromHd() {
		return pulpConsumedFromHd;
	}

	public void setPulpConsumedFromHd(double pulpConsumedFromHd) {
		this.pulpConsumedFromHd = pulpConsumedFromHd;
	}

	public double getPulpDataProdDcs() {
		return pulpDataProdDcs;
	}

	public void setPulpDataProdDcs(double pulpDataProdDcs) {
		this.pulpDataProdDcs = pulpDataProdDcs;
	}

	public double getPulpDataHdLevel() {
		return pulpDataHdLevel;
	}

	public void setPulpDataHdLevel(double pulpDataHdLevel) {
		this.pulpDataHdLevel = pulpDataHdLevel;
	}

	/**
	 * @return the tissueGrade
	 */
	public String getTissueGrade() {
		return tissueGrade;
	}

	/**
	 * @param tissueGrade the tissueGrade to set
	 */
	public void setTissueGrade(String tissueGrade) {
		this.tissueGrade = tissueGrade;
	}

	/**
	 * @return the pulpInHd
	 */
	public double getPulpInHd() {
		return pulpInHd;
	}

	/**
	 * @param pulpInHd the pulpInHd to set
	 */
	public void setPulpInHd(double pulpInHd) {
		this.pulpInHd = pulpInHd;
	}

	/**
	 * @return the downtimeMin
	 */
	public int getDowntimeMin() {
		return downtimeMin;
	}

	/**
	 * @param downtimeMin the downtimeMin to set
	 */
	public void setDowntimeMin(int downtimeMin) {
		this.downtimeMin = downtimeMin;
	}

	/**
	 * @return the consumedStock
	 */
	public double getConsumedStock() {
		return consumedStock;
	}

	/**
	 * @param consumedStock the consumedStock to set
	 */
	public void setConsumedStock(double consumedStock) {
		this.consumedStock = consumedStock;
	}

	/**
	 * @return the naturalGasFlowDryend
	 */
	public double getNaturalGasFlowDryend() {
		return naturalGasFlowDryend;
	}

	/**
	 * @param naturalGasFlowDryend the naturalGasFlowDryend to set
	 */
	public void setNaturalGasFlowDryend(double naturalGasFlowDryend) {
		this.naturalGasFlowDryend = naturalGasFlowDryend;
	}

	public double getChemWetStrength() {
		return chemWetStrength;
	}

	public void setChemWetStrength(double chemWetStrength) {
		this.chemWetStrength = chemWetStrength;
	}

	public double getChemRelease() {
		return chemRelease;
	}

	public void setChemRelease(double chemRelease) {
		this.chemRelease = chemRelease;
	}

	public double getChemAdhesive() {
		return chemAdhesive;
	}

	public void setChemAdhesive(double chemAdhesive) {
		this.chemAdhesive = chemAdhesive;
	}

	public double getChemMap() {
		return chemMap;
	}

	public void setChemMap(double chemMap) {
		this.chemMap = chemMap;
	}

	public double getChemDefoamer() {
		return chemDefoamer;
	}

	public void setChemDefoamer(double chemDefoamer) {
		this.chemDefoamer = chemDefoamer;
	}

	public double getChemPassivator() {
		return chemPassivator;
	}

	public void setChemPassivator(double chemPassivator) {
		this.chemPassivator = chemPassivator;
	}

	public double getCoddischarge() {
		return coddischarge;
	}

	public void setCoddischarge(double coddischarge) {
		this.coddischarge = coddischarge;
	}

}
