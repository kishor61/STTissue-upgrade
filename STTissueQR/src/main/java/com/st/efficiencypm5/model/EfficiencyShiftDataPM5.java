/**
 *Aug 28, 2015
 *EfficByShitData.java
 * TODO
 *com.st.efficiency.model
 *EfficByShitData.java
 *Sunil Singh Bora
 */
package com.st.efficiencypm5.model;

import java.util.Date;
import java.util.List;

import com.st.common.CommonUtil;

/**
 * @author sbora
 *
 */
public class EfficiencyShiftDataPM5 {
	private Date date;
	private String shift="";
	private String crew;
	private double actualWt;
	private double slabOff;
	private double wrapWhite;
	private double wrapRed;
	private double wrapRej;
	private double wrapTotal;
	
	private double variance;
	private double variancePer;
	
	
	private int downtime;
	private double uptime;
	private double quality;
	private double yield;
	private double effTotal;
	
	private int days=0;
	
	private String rollid;
	private int reelnumber;
	private String team;
	private String gradecode;
	private String lastroll;
	//Code Starts From Here Done By Roshan Tailor Date:-12/01/2015
	private int id;
	//Code Ends Here Done By Roshan Tailor Date:-12/01/2015
	
	/**
	 * 
	 */
	public EfficiencyShiftDataPM5() {}
	
	public EfficiencyShiftDataPM5(Date date,String shift) {this.date=date;this.shift=shift;}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getCrew() {
		return crew;
	}
	public void setCrew(String crew) {
		this.crew = crew;
	}
	public double getActualWt() {
		return actualWt;
	}
	public void setActualWt(double actualWt) {
		this.actualWt = actualWt;
	}
	public double getSlabOff() {
		return slabOff;
	}
	public void setSlabOff(double slabOff) {
		this.slabOff = slabOff;
	}
	public double getWrapWhite() {
		return wrapWhite;
	}
	public void setWrapWhite(double wrapWhite) {
		this.wrapWhite = wrapWhite;
	}
	public double getWrapRed() {
		return wrapRed;
	}
	public void setWrapRed(double wrapRed) {
		this.wrapRed = wrapRed;
	}
	public double getWrapRej() {
		return wrapRej;
	}
	public void setWrapRej(double wrapRej) {
		this.wrapRej = wrapRej;
	}
	
	//Code Starts From Here Done By Roshan Tailor 
	private double totalEff=0;
	//Code Ends Here Done By Roshan Tailor
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		EfficiencyShiftDataPM5 data=(EfficiencyShiftDataPM5)obj;
		if(this.date.compareTo(data.getDate())==0 && data.getShift().equalsIgnoreCase(shift)){
			return true;
		}else{
			return false;
		}
	}
	public double getWrapTotal() {
		return wrapTotal;
	}
	public void setWrapTotal(double wrapTotal) {
		this.wrapTotal = wrapTotal;
	}
	public int getDowntime() {
		return downtime;
	}
	public void setDowntime(int downtime) {
		this.downtime = downtime;
	}

	public double getUptime() {
		//System.out.println("Date:"+this.date);
		//System.out.println("Day:"+this.days);
		//System.out.println("DownTime::"+this.downtime);
		//System.out.println("Shift::"+this.shift);
		//System.out.println("------------------------");
		uptime=(((720*days)-getDowntime())/(720f*days));
		//if(days==0){
		if(days==0 ||days==1){
			//Code Starts From Here Done By Roshan Tailor Date:- 08/13/2016
			if(this.downtime==0){
				//uptime=0;
			}else{
				//uptime=((720-getDowntime())/720f);
			}
			uptime=((720-getDowntime())/720f);
			
			char c =  Double.toString(uptime).charAt(0);
			if(c == '-')
			{
				 	String b = Double.toString(uptime).substring(1);
					//System.out.println("hh"+b);
					uptime = Double.parseDouble(b);
			}
			
			
			//Code Ends Here Done By Roshan Tailor Date :- 08/13/2016 
			//uptime=((720-getDowntime())/720f);
		}else{
			
		}
		return CommonUtil.round(uptime*100, 2);
	}

	

	public double getQuality() {
		if(getWrapTotal()!=0){
			quality=getWrapWhite()/getWrapTotal();
		}
		
		return CommonUtil.round(quality*100, 2);
		
	}

	
	public double getYield() {
		if(getActualWt()!=0){
			yield=getWrapTotal()/getActualWt();
		}
		return CommonUtil.round(yield*100, 2);
	}

	public double getEffTotal() {
		
		if(getQuality()==0.0){
			effTotal=100;
		}else{
			effTotal=getUptime()*getYield()*getQuality();
		}
		//effTotal=getUptime()*getYield()*getQuality();
		/*System.out.println("*******");
		System.out.println("getUptime()::"+getUptime());
		System.out.println("getYield()::"+getYield());
		System.out.println("getQuality()::"+getQuality());
		System.out.println("Efficiency::"+CommonUtil.round((effTotal/100)/100, 2));
		System.out.println("********************");*/
		
		/*if(getQuality()==0.0){
			return 100;
		}else{*/
			return CommonUtil.round((effTotal/100)/100, 2);
		/*}*/
		//return CommonUtil.round((effTotal/100)/100, 2);
	}

	public double getVariance() {
		variance=CommonUtil.round(getActualWt()-(getWrapWhite()+getWrapRed()+getWrapRej()), 2);
		return variance;
	}

	

	public double getVariancePer() {
		
		if(getActualWt()!=0){
			variancePer=CommonUtil.round((getVariance()/getActualWt())*100, 2);
		}
		
		return variancePer;
	}

//Code Starts From Here Done By Roshan Tailor
	public EfficiencyShiftDataPM5 totalA(List<EfficiencyShiftDataPM5> data){
		EfficiencyShiftDataPM5 shiftData=new EfficiencyShiftDataPM5();
		double toatlEff=0;
		for (EfficiencyShiftDataPM5 efficiencyShiftData : data) {
			if(efficiencyShiftData.getCrew().equalsIgnoreCase("A")){
				shiftData.setActualWt(CommonUtil.round(shiftData.getActualWt()+efficiencyShiftData.getActualWt(), 2));
				shiftData.setSlabOff(CommonUtil.round(shiftData.getSlabOff()+efficiencyShiftData.getSlabOff(), 2));
				shiftData.setWrapWhite(CommonUtil.round(shiftData.getWrapWhite()+efficiencyShiftData.getWrapWhite(), 2));
				shiftData.setWrapRed(CommonUtil.round(shiftData.getWrapRed()+efficiencyShiftData.getWrapRed(), 2));
				shiftData.setWrapRej(CommonUtil.round(shiftData.getWrapRej()+efficiencyShiftData.getWrapRej(), 2));
				shiftData.setWrapTotal(CommonUtil.round(shiftData.getWrapTotal()+efficiencyShiftData.getWrapTotal(), 2));
				shiftData.setDowntime(shiftData.getDowntime()+efficiencyShiftData.getDowntime());
				System.out.println(shiftData.getUptime());
				shiftData.setDays(shiftData.getDays()+1);
			}
		}
		//Final Efficiency Avg. Grant For A Shift
		int sizeA=0;
		for (EfficiencyShiftDataPM5 efficiencyShiftDataA : data) {
			if(efficiencyShiftDataA.getCrew().equalsIgnoreCase("A")){
			toatlEff=toatlEff+efficiencyShiftDataA.getEffTotal();
			sizeA++;
			}
		}
		shiftData.setTotalEff(CommonUtil.round(toatlEff/sizeA, 2));
		return shiftData;
	}
	public EfficiencyShiftDataPM5 totalB(List<EfficiencyShiftDataPM5> data){
		EfficiencyShiftDataPM5 shiftData=new EfficiencyShiftDataPM5();
		double toatlEff=0;
		for (EfficiencyShiftDataPM5 efficiencyShiftData : data) {
			if(efficiencyShiftData.getCrew().equalsIgnoreCase("B")){
				shiftData.setActualWt(CommonUtil.round(shiftData.getActualWt()+efficiencyShiftData.getActualWt(), 2));
				shiftData.setSlabOff(CommonUtil.round(shiftData.getSlabOff()+efficiencyShiftData.getSlabOff(), 2));
				shiftData.setWrapWhite(CommonUtil.round(shiftData.getWrapWhite()+efficiencyShiftData.getWrapWhite(), 2));
				shiftData.setWrapRed(CommonUtil.round(shiftData.getWrapRed()+efficiencyShiftData.getWrapRed(), 2));
				shiftData.setWrapRej(CommonUtil.round(shiftData.getWrapRej()+efficiencyShiftData.getWrapRej(), 2));
				shiftData.setWrapTotal(CommonUtil.round(shiftData.getWrapTotal()+efficiencyShiftData.getWrapTotal(), 2));
				shiftData.setDowntime(shiftData.getDowntime()+efficiencyShiftData.getDowntime());
				shiftData.setDays(shiftData.getDays()+1);
			}
		}
				//Final Efficiency Avg. Grant For B Shift
				int sizeB=0;
				for (EfficiencyShiftDataPM5 efficiencyShiftDataB : data) {
					if(efficiencyShiftDataB.getCrew().equalsIgnoreCase("B")){
					toatlEff=toatlEff+efficiencyShiftDataB.getEffTotal();
					sizeB++;
					}
				}
				shiftData.setTotalEff(CommonUtil.round(toatlEff/sizeB, 2));
		return shiftData;
	}	
	public EfficiencyShiftDataPM5 totalC(List<EfficiencyShiftDataPM5> data){
		EfficiencyShiftDataPM5 shiftData=new EfficiencyShiftDataPM5();
		double toatlEff=0;
		for (EfficiencyShiftDataPM5 efficiencyShiftData : data) {
			if(efficiencyShiftData.getCrew().equalsIgnoreCase("C")){
				shiftData.setActualWt(CommonUtil.round(shiftData.getActualWt()+efficiencyShiftData.getActualWt(), 2));
				shiftData.setSlabOff(CommonUtil.round(shiftData.getSlabOff()+efficiencyShiftData.getSlabOff(), 2));
				shiftData.setWrapWhite(CommonUtil.round(shiftData.getWrapWhite()+efficiencyShiftData.getWrapWhite(), 2));
				shiftData.setWrapRed(CommonUtil.round(shiftData.getWrapRed()+efficiencyShiftData.getWrapRed(), 2));
				shiftData.setWrapRej(CommonUtil.round(shiftData.getWrapRej()+efficiencyShiftData.getWrapRej(), 2));
				shiftData.setWrapTotal(CommonUtil.round(shiftData.getWrapTotal()+efficiencyShiftData.getWrapTotal(), 2));
				shiftData.setDowntime(shiftData.getDowntime()+efficiencyShiftData.getDowntime());
				shiftData.setDays(shiftData.getDays()+1);
			}
		}
		//Final Efficiency Avg. Grant For C Shift
		int sizeC=0;
		for (EfficiencyShiftDataPM5 efficiencyShiftDataC : data) {
			if(efficiencyShiftDataC.getCrew().equalsIgnoreCase("C")){
			toatlEff=toatlEff+efficiencyShiftDataC.getEffTotal();
			sizeC++;
			}
		}
		shiftData.setTotalEff(CommonUtil.round(toatlEff/sizeC, 2));
		return shiftData;
	}
	public EfficiencyShiftDataPM5 totalD(List<EfficiencyShiftDataPM5> data){
		EfficiencyShiftDataPM5 shiftData=new EfficiencyShiftDataPM5();
		double toatlEff=0;
		for (EfficiencyShiftDataPM5 efficiencyShiftData : data) {
			if(efficiencyShiftData.getCrew().equalsIgnoreCase("D")){
				shiftData.setActualWt(CommonUtil.round(shiftData.getActualWt()+efficiencyShiftData.getActualWt(), 2));
				shiftData.setSlabOff(CommonUtil.round(shiftData.getSlabOff()+efficiencyShiftData.getSlabOff(), 2));
				shiftData.setWrapWhite(CommonUtil.round(shiftData.getWrapWhite()+efficiencyShiftData.getWrapWhite(), 2));
				shiftData.setWrapRed(CommonUtil.round(shiftData.getWrapRed()+efficiencyShiftData.getWrapRed(), 2));
				shiftData.setWrapRej(CommonUtil.round(shiftData.getWrapRej()+efficiencyShiftData.getWrapRej(), 2));
				shiftData.setWrapTotal(CommonUtil.round(shiftData.getWrapTotal()+efficiencyShiftData.getWrapTotal(), 2));
				shiftData.setDowntime(shiftData.getDowntime()+efficiencyShiftData.getDowntime());
				shiftData.setDays(shiftData.getDays()+1);
			}
		}
			//Final Efficiency Avg. Grant For D Shift
				int sizeD=0;
				for (EfficiencyShiftDataPM5 efficiencyShiftDataD : data) {
					if(efficiencyShiftDataD.getCrew().equalsIgnoreCase("D")){
					toatlEff=toatlEff+efficiencyShiftDataD.getEffTotal();
					sizeD++;
					}
				}
				shiftData.setTotalEff(CommonUtil.round(toatlEff/sizeD, 2));
		return shiftData;
	}
//Code Ends Here Done By Roshan Tailor
	
	/*public EfficiencyShiftData totalNight(List<EfficiencyShiftData> data){
		EfficiencyShiftData shiftData=new EfficiencyShiftData();
		for (EfficiencyShiftData efficiencyShiftData : data) {
			if(efficiencyShiftData.getShift().equalsIgnoreCase("NIGHT")){
				shiftData.setActualWt(CommonUtil.round(shiftData.getActualWt()+efficiencyShiftData.getActualWt(), 2));
				shiftData.setSlabOff(CommonUtil.round(shiftData.getSlabOff()+efficiencyShiftData.getSlabOff(), 2));
				shiftData.setWrapWhite(CommonUtil.round(shiftData.getWrapWhite()+efficiencyShiftData.getWrapWhite(), 2));
				shiftData.setWrapRed(CommonUtil.round(shiftData.getWrapRed()+efficiencyShiftData.getWrapRed(), 2));
				shiftData.setWrapRej(CommonUtil.round(shiftData.getWrapRej()+efficiencyShiftData.getWrapRej(), 2));
				shiftData.setWrapTotal(CommonUtil.round(shiftData.getWrapTotal()+efficiencyShiftData.getWrapTotal(), 2));
				shiftData.setDowntime(shiftData.getDowntime()+efficiencyShiftData.getDowntime());
				shiftData.setDays(shiftData.getDays()+1);
			}
			
		}
		return shiftData;
	}*/

	public EfficiencyShiftDataPM5 total(List<EfficiencyShiftDataPM5> data){
		EfficiencyShiftDataPM5 shiftData=new EfficiencyShiftDataPM5();
		double toatlEff=0;
		for (EfficiencyShiftDataPM5 efficiencyShiftData : data) {
			shiftData.setActualWt(CommonUtil.round(shiftData.getActualWt()+efficiencyShiftData.getActualWt(), 2));
			shiftData.setSlabOff(CommonUtil.round(shiftData.getSlabOff()+efficiencyShiftData.getSlabOff(), 2));
			shiftData.setWrapWhite(CommonUtil.round(shiftData.getWrapWhite()+efficiencyShiftData.getWrapWhite(), 2));
			shiftData.setWrapRed(CommonUtil.round(shiftData.getWrapRed()+efficiencyShiftData.getWrapRed(), 2));
			shiftData.setWrapRej(CommonUtil.round(shiftData.getWrapRej()+efficiencyShiftData.getWrapRej(), 2));
			shiftData.setWrapTotal(CommonUtil.round(shiftData.getWrapTotal()+efficiencyShiftData.getWrapTotal(), 2));
			shiftData.setDowntime(shiftData.getDowntime()+efficiencyShiftData.getDowntime());
			shiftData.setDays(shiftData.getDays()+1);
			
			//shiftData.setDays(shiftData.getDays()+1);
			/*This line is return due to if we got 0(Zero) uptime  and 0 up time will come if no data is avaliable in the database. and when 
			 * data is not avaliable in database then we are adding  record manually. 
			 */
		}
		//Final Efficiency Avg. Grant
		for (EfficiencyShiftDataPM5 efficiencyShiftData : data) {
			toatlEff=toatlEff+efficiencyShiftData.getEffTotal();
		}
		shiftData.setTotalEff(CommonUtil.round(toatlEff/data.size(), 2));
		
		return shiftData;
	}
	
	
	public int getDays() {
	
		System.out.println("Days::"+days);
		return days;
	
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getRollid() {
		return rollid;
	}

	public void setRollid(String rollid) {
		this.rollid = rollid;
	}

	public int getReelnumber() {
		return reelnumber;
	}

	public void setReelnumber(int reelnumber) {
		this.reelnumber = reelnumber;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getGradecode() {
		return gradecode;
	}

	public void setGradecode(String gradecode) {
		this.gradecode = gradecode;
	}

	public String getLastroll() {
		return lastroll;
	}

	public void setLastroll(String lastroll) {
		this.lastroll = lastroll;
	}

	public void setVariance(double variance) {
		this.variance = variance;
	}

	public void setVariancePer(double variancePer) {
		this.variancePer = variancePer;
	}

	public void setUptime(double uptime) {
		this.uptime = uptime;
	}

	public void setQuality(double quality) {
		this.quality = quality;
	}

	public void setYield(double yield) {
		this.yield = yield;
	}

	public void setEffTotal(double effTotal) {
		this.effTotal = effTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalEff() {
		return totalEff;
	}

	public void setTotalEff(double totalEff) {
		this.totalEff = totalEff;
	}

	
}
