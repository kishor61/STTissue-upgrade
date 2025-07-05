/**
 *Dec 13, 2014
 *QualityGraph.java
 * TODO
 *com.st.qualitypm6.model
 *QualityGraph.java
 *Sunil Singh Bora
 */
package com.st.qualitypm6.model;

import java.util.List;


/**
 * @author sbora
 *
 */
public class QualityGraph {
	private double actualBasisTarget;
	private double actualBasisMinR;
	private double actualBasisMaxR;
	private List<QualityGraphDataPoint> actualBasisReels;
	private List<QualityGraphDataPoint> actualBasisRewinds;
	
	
	private double bulkTarget;
	private double bulkMinR;
	private double bulkMaxR;
	private List<QualityGraphDataPoint> bulkReels;
	private List<QualityGraphDataPoint> bulkRewinds;
		
	private double mdTensileTarget;
	private double mdTensileMinR;
	private double mdTensileMaxR;
	private List<QualityGraphDataPoint> mdTensileReels;
	private List<QualityGraphDataPoint> mdTensileRewinds;
	

	private double cdTensileTarget;
	private double cdTensileMinR;
	private double cdTensileMaxR;
	private List<QualityGraphDataPoint> cdTensileReels;
	private List<QualityGraphDataPoint> cdTensileRewinds;
	
	private double mdStretchTarget;
	private double mdStretchMinR;
	private double mdStretchMaxR;
	private List<QualityGraphDataPoint> mdStretchReels;
	private List<QualityGraphDataPoint> mdStretchRewinds;
	
	
	private double brightnessTarget;
	private double brightnessMinR;
	private double brightnessMaxR;
	private List<QualityGraphDataPoint> brightnessReels;
	private List<QualityGraphDataPoint> brightnessRewinds;
	
	
	
	public double getActualBasisTarget() {
		return actualBasisTarget;
	}

	public void setActualBasisTarget(double actualBasisTarget) {
		this.actualBasisTarget = actualBasisTarget;
	}

	public List<QualityGraphDataPoint> getActualBasisReels() {
		return actualBasisReels;
	}

	public void setActualBasisReels(List<QualityGraphDataPoint> actualBasisReels) {
		this.actualBasisReels = actualBasisReels;
	}

	public List<QualityGraphDataPoint> getActualBasisRewinds() {
		return actualBasisRewinds;
	}

	public void setActualBasisRewinds(List<QualityGraphDataPoint> actualBasisRewinds) {
		this.actualBasisRewinds = actualBasisRewinds;
	}

	public double getBulkTarget() {
		return bulkTarget;
	}

	public void setBulkTarget(double bulkTarget) {
		this.bulkTarget = bulkTarget;
	}

	public List<QualityGraphDataPoint> getBulkReels() {
		return bulkReels;
	}

	public void setBulkReels(List<QualityGraphDataPoint> bulkReels) {
		this.bulkReels = bulkReels;
	}

	public List<QualityGraphDataPoint> getBulkRewinds() {
		return bulkRewinds;
	}

	public void setBulkRewinds(List<QualityGraphDataPoint> bulkRewinds) {
		this.bulkRewinds = bulkRewinds;
	}

	public double getMdTensileTarget() {
		return mdTensileTarget;
	}

	public void setMdTensileTarget(double mdTensileTarget) {
		this.mdTensileTarget = mdTensileTarget;
	}

	public List<QualityGraphDataPoint> getMdTensileReels() {
		return mdTensileReels;
	}

	public void setMdTensileReels(List<QualityGraphDataPoint> mdTensileReels) {
		this.mdTensileReels = mdTensileReels;
	}

	public List<QualityGraphDataPoint> getMdTensileRewinds() {
		return mdTensileRewinds;
	}

	public void setMdTensileRewinds(List<QualityGraphDataPoint> mdTensileRewinds) {
		this.mdTensileRewinds = mdTensileRewinds;
	}

	public double getCdTensileTarget() {
		return cdTensileTarget;
	}

	public void setCdTensileTarget(double cdTensileTarget) {
		this.cdTensileTarget = cdTensileTarget;
	}

	public List<QualityGraphDataPoint> getCdTensileReels() {
		return cdTensileReels;
	}

	public void setCdTensileReels(List<QualityGraphDataPoint> cdTensileReels) {
		this.cdTensileReels = cdTensileReels;
	}

	public List<QualityGraphDataPoint> getCdTensileRewinds() {
		return cdTensileRewinds;
	}

	public void setCdTensileRewinds(List<QualityGraphDataPoint> cdTensileRewinds) {
		this.cdTensileRewinds = cdTensileRewinds;
	}

	public double getMdStretchTarget() {
		return mdStretchTarget;
	}

	public void setMdStretchTarget(double mdStretchTarget) {
		this.mdStretchTarget = mdStretchTarget;
	}

	public List<QualityGraphDataPoint> getMdStretchReels() {
		return mdStretchReels;
	}

	public void setMdStretchReels(List<QualityGraphDataPoint> mdStretchReels) {
		this.mdStretchReels = mdStretchReels;
	}

	public List<QualityGraphDataPoint> getMdStretchRewinds() {
		return mdStretchRewinds;
	}

	public void setMdStretchRewinds(List<QualityGraphDataPoint> mdStretchRewinds) {
		this.mdStretchRewinds = mdStretchRewinds;
	}

	public double getActualBasisMinR() {
		return actualBasisMinR;
	}

	public void setActualBasisMinR(double actualBasisMinR) {
		this.actualBasisMinR = actualBasisMinR;
	}

	public double getActualBasisMaxR() {
		return actualBasisMaxR;
	}

	public void setActualBasisMaxR(double actualBasisMaxR) {
		this.actualBasisMaxR = actualBasisMaxR;
	}

	public double getMdTensileMinR() {
		return mdTensileMinR;
	}

	public void setMdTensileMinR(double mdTensileMinR) {
		this.mdTensileMinR = mdTensileMinR;
	}

	public double getMdTensileMaxR() {
		return mdTensileMaxR;
	}

	public void setMdTensileMaxR(double mdTensileMaxR) {
		this.mdTensileMaxR = mdTensileMaxR;
	}

	public double getCdTensileMinR() {
		return cdTensileMinR;
	}

	public void setCdTensileMinR(double cdTensileMinR) {
		this.cdTensileMinR = cdTensileMinR;
	}

	public double getCdTensileMaxR() {
		return cdTensileMaxR;
	}

	public void setCdTensileMaxR(double cdTensileMaxR) {
		this.cdTensileMaxR = cdTensileMaxR;
	}

	public double getMdStretchMinR() {
		return mdStretchMinR;
	}

	public void setMdStretchMinR(double mdStretchMinR) {
		this.mdStretchMinR = mdStretchMinR;
	}

	public double getMdStretchMaxR() {
		return mdStretchMaxR;
	}

	public void setMdStretchMaxR(double mdStretchMaxR) {
		this.mdStretchMaxR = mdStretchMaxR;
	}

	public double getBulkMinR() {
		return bulkMinR;
	}

	public void setBulkMinR(double bulkMinR) {
		this.bulkMinR = bulkMinR;
	}

	public double getBulkMaxR() {
		return bulkMaxR;
	}

	public void setBulkMaxR(double bulkMaxR) {
		this.bulkMaxR = bulkMaxR;
	}


	public double getBrightnessMinR() {
		return brightnessMinR;
	}

	public void setBrightnessMinR(double brightnessMinR) {
		this.brightnessMinR = brightnessMinR;
	}

	public double getBrightnessMaxR() {
		return brightnessMaxR;
	}

	public void setBrightnessMaxR(double brightnessMaxR) {
		this.brightnessMaxR = brightnessMaxR;
	}

	public List<QualityGraphDataPoint> getBrightnessReels() {
		return brightnessReels;
	}

	public void setBrightnessReels(List<QualityGraphDataPoint> brightnessReels) {
		this.brightnessReels = brightnessReels;
	}

	public List<QualityGraphDataPoint> getBrightnessRewinds() {
		return brightnessRewinds;
	}

	public void setBrightnessRewinds(List<QualityGraphDataPoint> brightnessRewinds) {
		this.brightnessRewinds = brightnessRewinds;
	}

	public double getBrightnessTarget() {
		return brightnessTarget;
	}

	public void setBrightnessTarget(double brightnessTarget) {
		this.brightnessTarget = brightnessTarget;
	}
		
}
