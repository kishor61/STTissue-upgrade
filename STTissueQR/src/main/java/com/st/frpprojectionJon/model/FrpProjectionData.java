/**
 * 
 */
package com.st.frpprojectionJon.model;

import java.util.ArrayList;
import java.util.List;

import com.st.tracker.model.ProjectionData;

/**
 * @author sbora
 *
 */
public class FrpProjectionData {
	private List<String> dates=new ArrayList<>();
	private List<String> days=new ArrayList<>();
	
	private List<Double>  occ=new ArrayList<>();
	private List<Double>  dlk=new ArrayList<>();
	private List<Double>  mail=new ArrayList<>();
	private List<Double>  growndwood=new ArrayList<>();
	private List<Double>  others=new ArrayList<>();
	private List<Double>  mwlAndSwl=new ArrayList<>();
	
	
	
	
	
	//Code Starts From Here Done By Roshan Tailor
	private List<Double>  hw=new ArrayList<>();
	private List<Double>  unprtsbs=new ArrayList<>();
	private List<Double>  hwAndUnprtSBS=new ArrayList<>();
	//Code Ends Here Done By Roshan Tailor
	private List<Double>  sowAndCbs=new ArrayList<>();
	
	private List<Double>  cutBook=new ArrayList<>();
	
	
	//New Field
	private List<Double>  mixedPaper=new ArrayList<>();
	
	
	
		
	private List<String> productionIds=new ArrayList<>(); 
	
	private int length;
	
	private List<ProjectionData> projectionDatas;
	



	public List<String> getDays() {
		return days;
	}

	public void setDays(List<String> days) {
		this.days = days;
	}

	public List<ProjectionData> getProjectionDatas() {
		return projectionDatas;
	}

	public void setProjectionDatas(List<ProjectionData> projectionDatas) {
		this.projectionDatas = projectionDatas;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<String> getDates() {
		return dates;
	}

	public void setDates(List<String> dates) {
		this.dates = dates;
	}

	public List<Double> getOcc() {
		return occ;
	}

	public void setOcc(List<Double> occ) {
		this.occ = occ;
	}

	public List<Double> getDlk() {
		return dlk;
	}

	public void setDlk(List<Double> dlk) {
		this.dlk = dlk;
	}

	public List<Double> getGrowndwood() {
		return growndwood;
	}

	public void setGrowndwood(List<Double> growndwood) {
		this.growndwood = growndwood;
	}



	public List<Double> getMwlAndSwl() {
		return mwlAndSwl;
	}

	public void setMwlAndSwl(List<Double> mwlAndSwl) {
		this.mwlAndSwl = mwlAndSwl;
	}





	public List<String> getProductionIds() {
		return productionIds;
	}

	public void setProductionIds(List<String> productionIds) {
		this.productionIds = productionIds;
	}



	public List<Double> getOthers() {
		return others;
	}

	public void setOthers(List<Double> others) {
		this.others = others;
	}

	public List<Double> getMail() {
		return mail;
	}

	public void setMail(List<Double> mail) {
		this.mail = mail;
	}

	public List<Double> getSowAndCbs() {
		return sowAndCbs;
	}

	public void setSowAndCbs(List<Double> sowAndCbs) {
		this.sowAndCbs = sowAndCbs;
	}

	public List<Double> getMixedPaper() {
		return mixedPaper;
	}

	public void setMixedPaper(List<Double> mixedPaper) {
		this.mixedPaper = mixedPaper;
	}

	public List<Double> getCutBook() {
		return cutBook;
	}

	public void setCutBook(List<Double> cutBook) {
		this.cutBook = cutBook;
	}

	public List<Double> getHw() {
		return hw;
	}

	public void setHw(List<Double> hw) {
		this.hw = hw;
	}

	public List<Double> getUnprtsbs() {
		return unprtsbs;
	}

	public void setUnprtsbs(List<Double> unprtsbs) {
		this.unprtsbs = unprtsbs;
	}

	public List<Double> getHwAndUnprtSBS() {
		return hwAndUnprtSBS;
	}

	public void setHwAndUnprtSBS(List<Double> hwAndUnprtSBS) {
		this.hwAndUnprtSBS = hwAndUnprtSBS;
	}


}
