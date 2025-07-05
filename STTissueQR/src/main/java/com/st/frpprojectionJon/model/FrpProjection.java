/**
 * 
 */
package com.st.frpprojectionJon.model;

/**
 * @author sbora
 *
 */
public class FrpProjection {
	private int id;
	private String type;
	private String type2;
	private double input;
	private double occ;
	private double dlk;
	private double sowAndMail; // mail
	private double growndwood;
	private double others;
	private double mwlAndSwl;
	
	
	//Code Strats From Here Done By Roshan  Tailor
	private double hw;
	private double unprtsbs;
	//Code Ends Here Done By Roshan Tailor
	private double sow;
	private double cbs;
	
	
	private String remarks;
	
	
	//New Fields
	private double occMinR;
	private double occMinC;
	private double occTarget;
	private double occMaxC;
	private double occMaxR;
	
	private double dlkMinR;
	private double dlkMinC;
	private double dlkTarget;
	private double dlkMaxC;
	private double dlkMaxR;
	
	private double sowAndMailMinR;
	private double sowAndMailMinC;
	private double sowAndMailTarget;
	private double sowAndMailMaxC;
	private double sowAndMailMaxR;
	
	private double growndwoodMinR;
	private double growndwoodMinC;
	private double growndwoodTarget;
	private double growndwoodMaxC;
	private double growndwoodMaxR;
	
	private double mwlAndSwlMinR;
	private double mwlAndSwlMinC;
	private double mwlAndSwlTarget;
	private double mwlAndSwlMaxC;
	private double mwlAndSwlMaxR;
	
	private double sowMinR;
	private double sowMinC;
	private double sowTarget;
	private double sowMaxC;
	private double sowMaxR;
	
	private double cbsMinR;
	private double cbsMinC;
	private double cbsTarget;
	private double cbsMaxC;
	private double cbsMaxR;
	
	private double othersMinR;
	private double othersMinC;
	private double othersTarget;
	private double othersMaxC;
	private double othersMaxR;

	
	//New Field
	
	private double mixedPaper;
	private double mixedPaperMinR;
	private double mixedPaperMinC;
	private double mixedPaperTarget;
	private double mixedPaperMaxC;
	private double mixedPaperMaxR;
	
	
	//New Field
	
	private double cutBook;
	private double cutBookMinR;
	private double cutBookMinC;
	private double cutBookTarget;
	private double cutBookMaxC;
	private double cutBookMaxR;
	
	
	//Code Starts From Here Done By Roshan Tailor
	private double hwMinR;
	private double hwMinC;
	private double hwTarget;
	private double hwMaxC;
	private double hwMaxR;
	
	private double unprtsbsMinR;
	private double unprtsbsMinC;
	private double unprtsbsTarget;
	private double unprtsbsMaxC;
	private double unprtsbsMaxR;
	
	private double hwAndUnprtSBS;
	//Code Ends Here Done By Roshan TAilor
	public double getSow() {
		return sow;
	}
	public void setSow(double sow) {
		this.sow = sow;
	}
	public double getCbs() {
		return cbs;
	}
	public void setCbs(double cbs) {
		this.cbs = cbs;
	}
	public double getSowAndMail() {
		return sowAndMail;
	}
	public void setSowAndMail(double sowAndMail) {
		this.sowAndMail = sowAndMail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getInput() {
		return input;
	}
	public void setInput(double input) {
		this.input = input;
	}
	public double getMwlAndSwl() {
		return mwlAndSwl;
	}
	public void setMwlAndSwl(double mwlAndSwl) {
		this.mwlAndSwl = mwlAndSwl;
	}
	public double getGrowndwood() {
		return growndwood;
	}
	public void setGrowndwood(double growndwood) {
		this.growndwood = growndwood;
	}
	public double getDlk() {
		return dlk;
	}
	public void setDlk(double dlk) {
		this.dlk = dlk;
	}
	public double getOcc() {
		return occ;
	}
	public void setOcc(double occ) {
		this.occ = occ;
	}
	public double getOthers() {
		return others;
	}
	public void setOthers(double others) {
		this.others = others;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public double getOccMinR() {
		return occMinR;
	}
	public void setOccMinR(double occMinR) {
		this.occMinR = occMinR;
	}
	public double getOccMinC() {
		return occMinC;
	}
	public void setOccMinC(double occMinC) {
		this.occMinC = occMinC;
	}
	public double getOccTarget() {
		return occTarget;
	}
	public void setOccTarget(double occTarget) {
		this.occTarget = occTarget;
	}
	public double getOccMaxC() {
		return occMaxC;
	}
	public void setOccMaxC(double occMaxC) {
		this.occMaxC = occMaxC;
	}
	public double getOccMaxR() {
		return occMaxR;
	}
	public void setOccMaxR(double occMaxR) {
		this.occMaxR = occMaxR;
	}
	public double getDlkMinR() {
		return dlkMinR;
	}
	public void setDlkMinR(double dlkMinR) {
		this.dlkMinR = dlkMinR;
	}
	public double getDlkMinC() {
		return dlkMinC;
	}
	public void setDlkMinC(double dlkMinC) {
		this.dlkMinC = dlkMinC;
	}
	public double getDlkTarget() {
		return dlkTarget;
	}
	public void setDlkTarget(double dlkTarget) {
		this.dlkTarget = dlkTarget;
	}
	public double getDlkMaxC() {
		return dlkMaxC;
	}
	public void setDlkMaxC(double dlkMaxC) {
		this.dlkMaxC = dlkMaxC;
	}
	public double getDlkMaxR() {
		return dlkMaxR;
	}
	public void setDlkMaxR(double dlkMaxR) {
		this.dlkMaxR = dlkMaxR;
	}
	public double getSowAndMailMinR() {
		return sowAndMailMinR;
	}
	public void setSowAndMailMinR(double sowAndMailMinR) {
		this.sowAndMailMinR = sowAndMailMinR;
	}
	public double getSowAndMailMinC() {
		return sowAndMailMinC;
	}
	public void setSowAndMailMinC(double sowAndMailMinC) {
		this.sowAndMailMinC = sowAndMailMinC;
	}
	public double getSowAndMailTarget() {
		return sowAndMailTarget;
	}
	public void setSowAndMailTarget(double sowAndMailTarget) {
		this.sowAndMailTarget = sowAndMailTarget;
	}
	public double getSowAndMailMaxC() {
		return sowAndMailMaxC;
	}
	public void setSowAndMailMaxC(double sowAndMailMaxC) {
		this.sowAndMailMaxC = sowAndMailMaxC;
	}
	public double getSowAndMailMaxR() {
		return sowAndMailMaxR;
	}
	public void setSowAndMailMaxR(double sowAndMailMaxR) {
		this.sowAndMailMaxR = sowAndMailMaxR;
	}
	public double getGrowndwoodMinR() {
		return growndwoodMinR;
	}
	public void setGrowndwoodMinR(double growndwoodMinR) {
		this.growndwoodMinR = growndwoodMinR;
	}
	public double getGrowndwoodMinC() {
		return growndwoodMinC;
	}
	public void setGrowndwoodMinC(double growndwoodMinC) {
		this.growndwoodMinC = growndwoodMinC;
	}
	public double getGrowndwoodTarget() {
		return growndwoodTarget;
	}
	public void setGrowndwoodTarget(double growndwoodTarget) {
		this.growndwoodTarget = growndwoodTarget;
	}
	public double getGrowndwoodMaxC() {
		return growndwoodMaxC;
	}
	public void setGrowndwoodMaxC(double growndwoodMaxC) {
		this.growndwoodMaxC = growndwoodMaxC;
	}
	public double getGrowndwoodMaxR() {
		return growndwoodMaxR;
	}
	public void setGrowndwoodMaxR(double growndwoodMaxR) {
		this.growndwoodMaxR = growndwoodMaxR;
	}
	public double getMwlAndSwlMinR() {
		return mwlAndSwlMinR;
	}
	public void setMwlAndSwlMinR(double mwlAndSwlMinR) {
		this.mwlAndSwlMinR = mwlAndSwlMinR;
	}
	public double getMwlAndSwlMinC() {
		return mwlAndSwlMinC;
	}
	public void setMwlAndSwlMinC(double mwlAndSwlMinC) {
		this.mwlAndSwlMinC = mwlAndSwlMinC;
	}
	public double getMwlAndSwlTarget() {
		return mwlAndSwlTarget;
	}
	public void setMwlAndSwlTarget(double mwlAndSwlTarget) {
		this.mwlAndSwlTarget = mwlAndSwlTarget;
	}
	public double getMwlAndSwlMaxC() {
		return mwlAndSwlMaxC;
	}
	public void setMwlAndSwlMaxC(double mwlAndSwlMaxC) {
		this.mwlAndSwlMaxC = mwlAndSwlMaxC;
	}
	public double getMwlAndSwlMaxR() {
		return mwlAndSwlMaxR;
	}
	public void setMwlAndSwlMaxR(double mwlAndSwlMaxR) {
		this.mwlAndSwlMaxR = mwlAndSwlMaxR;
	}
	public double getSowMinR() {
		return sowMinR;
	}
	public void setSowMinR(double sowMinR) {
		this.sowMinR = sowMinR;
	}
	public double getSowMinC() {
		return sowMinC;
	}
	public void setSowMinC(double sowMinC) {
		this.sowMinC = sowMinC;
	}
	public double getSowTarget() {
		return sowTarget;
	}
	public void setSowTarget(double sowTarget) {
		this.sowTarget = sowTarget;
	}
	public double getSowMaxC() {
		return sowMaxC;
	}
	public void setSowMaxC(double sowMaxC) {
		this.sowMaxC = sowMaxC;
	}
	public double getSowMaxR() {
		return sowMaxR;
	}
	public void setSowMaxR(double sowMaxR) {
		this.sowMaxR = sowMaxR;
	}
	public double getCbsMinR() {
		return cbsMinR;
	}
	public void setCbsMinR(double cbsMinR) {
		this.cbsMinR = cbsMinR;
	}
	public double getCbsMinC() {
		return cbsMinC;
	}
	public void setCbsMinC(double cbsMinC) {
		this.cbsMinC = cbsMinC;
	}
	public double getCbsTarget() {
		return cbsTarget;
	}
	public void setCbsTarget(double cbsTarget) {
		this.cbsTarget = cbsTarget;
	}
	public double getCbsMaxC() {
		return cbsMaxC;
	}
	public void setCbsMaxC(double cbsMaxC) {
		this.cbsMaxC = cbsMaxC;
	}
	public double getCbsMaxR() {
		return cbsMaxR;
	}
	public void setCbsMaxR(double cbsMaxR) {
		this.cbsMaxR = cbsMaxR;
	}
	public double getOthersMinR() {
		return othersMinR;
	}
	public void setOthersMinR(double othersMinR) {
		this.othersMinR = othersMinR;
	}
	public double getOthersMinC() {
		return othersMinC;
	}
	public void setOthersMinC(double othersMinC) {
		this.othersMinC = othersMinC;
	}
	public double getOthersTarget() {
		return othersTarget;
	}
	public void setOthersTarget(double othersTarget) {
		this.othersTarget = othersTarget;
	}
	public double getOthersMaxC() {
		return othersMaxC;
	}
	public void setOthersMaxC(double othersMaxC) {
		this.othersMaxC = othersMaxC;
	}
	public double getOthersMaxR() {
		return othersMaxR;
	}
	public void setOthersMaxR(double othersMaxR) {
		this.othersMaxR = othersMaxR;
	}
	public double getMixedPaper() {
		return mixedPaper;
	}
	public void setMixedPaper(double mixedPaper) {
		this.mixedPaper = mixedPaper;
	}
	public double getMixedPaperMinR() {
		return mixedPaperMinR;
	}
	public void setMixedPaperMinR(double mixedPaperMinR) {
		this.mixedPaperMinR = mixedPaperMinR;
	}
	public double getMixedPaperMinC() {
		return mixedPaperMinC;
	}
	public void setMixedPaperMinC(double mixedPaperMinC) {
		this.mixedPaperMinC = mixedPaperMinC;
	}
	public double getMixedPaperTarget() {
		return mixedPaperTarget;
	}
	public void setMixedPaperTarget(double mixedPaperTarget) {
		this.mixedPaperTarget = mixedPaperTarget;
	}
	public double getMixedPaperMaxC() {
		return mixedPaperMaxC;
	}
	public void setMixedPaperMaxC(double mixedPaperMaxC) {
		this.mixedPaperMaxC = mixedPaperMaxC;
	}
	public double getMixedPaperMaxR() {
		return mixedPaperMaxR;
	}
	public void setMixedPaperMaxR(double mixedPaperMaxR) {
		this.mixedPaperMaxR = mixedPaperMaxR;
	}
	public double getCutBook() {
		return cutBook;
	}
	public void setCutBook(double cutBook) {
		this.cutBook = cutBook;
	}
	public double getCutBookMinR() {
		return cutBookMinR;
	}
	public void setCutBookMinR(double cutBookMinR) {
		this.cutBookMinR = cutBookMinR;
	}
	public double getCutBookMinC() {
		return cutBookMinC;
	}
	public void setCutBookMinC(double cutBookMinC) {
		this.cutBookMinC = cutBookMinC;
	}
	public double getCutBookTarget() {
		return cutBookTarget;
	}
	public void setCutBookTarget(double cutBookTarget) {
		this.cutBookTarget = cutBookTarget;
	}
	public double getCutBookMaxC() {
		return cutBookMaxC;
	}
	public void setCutBookMaxC(double cutBookMaxC) {
		this.cutBookMaxC = cutBookMaxC;
	}
	public double getCutBookMaxR() {
		return cutBookMaxR;
	}
	public void setCutBookMaxR(double cutBookMaxR) {
		this.cutBookMaxR = cutBookMaxR;
	}
	public double getHw() {
		return hw;
	}
	public void setHw(double hw) {
		this.hw = hw;
	}
	public double getUnprtsbs() {
		return unprtsbs;
	}
	public void setUnprtsbs(double unprtsbs) {
		this.unprtsbs = unprtsbs;
	}
	public double getHwMinR() {
		return hwMinR;
	}
	public void setHwMinR(double hwMinR) {
		this.hwMinR = hwMinR;
	}
	public double getHwMinC() {
		return hwMinC;
	}
	public void setHwMinC(double hwMinC) {
		this.hwMinC = hwMinC;
	}
	public double getHwTarget() {
		return hwTarget;
	}
	public void setHwTarget(double hwTarget) {
		this.hwTarget = hwTarget;
	}
	public double getHwMaxC() {
		return hwMaxC;
	}
	public void setHwMaxC(double hwMaxC) {
		this.hwMaxC = hwMaxC;
	}
	public double getHwMaxR() {
		return hwMaxR;
	}
	public void setHwMaxR(double hwMaxR) {
		this.hwMaxR = hwMaxR;
	}
	public double getUnprtsbsMinR() {
		return unprtsbsMinR;
	}
	public void setUnprtsbsMinR(double unprtsbsMinR) {
		this.unprtsbsMinR = unprtsbsMinR;
	}
	public double getUnprtsbsMinC() {
		return unprtsbsMinC;
	}
	public void setUnprtsbsMinC(double unprtsbsMinC) {
		this.unprtsbsMinC = unprtsbsMinC;
	}
	public double getUnprtsbsTarget() {
		return unprtsbsTarget;
	}
	public void setUnprtsbsTarget(double unprtsbsTarget) {
		this.unprtsbsTarget = unprtsbsTarget;
	}
	public double getUnprtsbsMaxC() {
		return unprtsbsMaxC;
	}
	public void setUnprtsbsMaxC(double unprtsbsMaxC) {
		this.unprtsbsMaxC = unprtsbsMaxC;
	}
	public double getUnprtsbsMaxR() {
		return unprtsbsMaxR;
	}
	public void setUnprtsbsMaxR(double unprtsbsMaxR) {
		this.unprtsbsMaxR = unprtsbsMaxR;
	}
	public double getHwAndUnprtSBS() {
		return hwAndUnprtSBS;
	}
	public void setHwAndUnprtSBS(double hwAndUnprtSBS) {
		this.hwAndUnprtSBS = hwAndUnprtSBS;
	}
	
}
