/**
 *Apr 22, 2015
 *FrpYieldQuality.java
 * TODO
 *com.st.frpyield.model
 *FrpYieldQuality.java
 *Sunil Singh Bora
 */
package com.st.frpyield.model;

import java.util.Date;

/**
 * @author Roshan Tailor JEE Developer
 */
public class FrpYield {

	private int id;
	private Date date;
	private double sampleno;

	private double rfdetrasherrejcts;
	private double rfhdcleaner;
	private double rftertiarycoarse;
	private double rftertiaryfine;
	private double rffrwdcleaner;
	private double rfprimcell;
	private double rfseccell;
	private double rffsdclarifier;
	private double cyofdww;
	private double rchdcleaner;
	private double rctertiarycoarse;
	private double rctertiaryfine;
	private double rcfrwdcleaner;
	private double rcprimcell;
	private double rcseccell;
	private double rcfsdclarifier;
	private double ashdww;
	private double ashpupler;
	private double ashtertiarypress;

	private double dwwflowrommill;
	// More Addition For Frp Yield Summary Report Calculation by formulas
	private double dcsfrpyieldpercentage;
	private double ylswdcsfrpproduction;
	private double ylswdcsfrpyield;
	@SuppressWarnings("unused")
	private double ylswhdcleaners;
	@SuppressWarnings("unused")
	private double ylswtertiarycoarse;
	@SuppressWarnings("unused")
	private double ylswtertiaryfine;
	@SuppressWarnings("unused")
	private double ylswforwardcleaner;
	@SuppressWarnings("unused")
	private double ylswprimflotcell;
	@SuppressWarnings("unused")
	private double ylswrfseccell;
	@SuppressWarnings("unused")
	private double ylswrffsdclarifier;
	@SuppressWarnings("unused")
	private double ylswunaccounted;
	@SuppressWarnings("unused")
	private double ylswashinpulper;
	@SuppressWarnings("unused")
	private double ylswashindww;
	@SuppressWarnings("unused")
	private double ylswashouttertiarypress;

	@SuppressWarnings("unused")
	private double yieldhdcleanersper;

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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the dwwflowrommill
	 */
	public double getDwwflowrommill() {
		return dwwflowrommill;
	}

	/**
	 * @param dwwflowrommill
	 *            the dwwflowrommill to set
	 */
	public void setDwwflowrommill(double dwwflowrommill) {
		this.dwwflowrommill = dwwflowrommill;
	}

	/**
	 * @return the sampleno
	 */
	public double getSampleno() {
		return sampleno;
	}

	/**
	 * @param sampleno
	 *            the sampleno to set
	 */
	public void setSampleno(double sampleno) {
		this.sampleno = sampleno;
	}

	/**
	 * @return the rfdetrasherrejcts
	 */
	public double getRfdetrasherrejcts() {
		return rfdetrasherrejcts;
	}

	/**
	 * @param rfdetrasherrejcts
	 *            the rfdetrasherrejcts to set
	 */
	public void setRfdetrasherrejcts(double rfdetrasherrejcts) {
		this.rfdetrasherrejcts = rfdetrasherrejcts;
	}

	/**
	 * @return the rfhdcleaner
	 */
	public double getRfhdcleaner() {
		return rfhdcleaner;
	}

	/**
	 * @param rfhdcleaner
	 *            the rfhdcleaner to set
	 */
	public void setRfhdcleaner(double rfhdcleaner) {
		this.rfhdcleaner = rfhdcleaner;
	}

	/**
	 * @return the rftertiarycoarse
	 */
	public double getRftertiarycoarse() {
		return rftertiarycoarse;
	}

	/**
	 * @param rftertiarycoarse
	 *            the rftertiarycoarse to set
	 */
	public void setRftertiarycoarse(double rftertiarycoarse) {
		this.rftertiarycoarse = rftertiarycoarse;
	}

	/**
	 * @return the rftertiaryfine
	 */
	public double getRftertiaryfine() {
		return rftertiaryfine;
	}

	/**
	 * @param rftertiaryfine
	 *            the rftertiaryfine to set
	 */
	public void setRftertiaryfine(double rftertiaryfine) {
		this.rftertiaryfine = rftertiaryfine;
	}

	/**
	 * @return the rffrwdcleaner
	 */
	public double getRffrwdcleaner() {
		return rffrwdcleaner;
	}

	/**
	 * @param rffrwdcleaner
	 *            the rffrwdcleaner to set
	 */
	public void setRffrwdcleaner(double rffrwdcleaner) {
		this.rffrwdcleaner = rffrwdcleaner;
	}

	/**
	 * @return the rfprimcell
	 */
	public double getRfprimcell() {
		return rfprimcell;
	}

	/**
	 * @param rfprimcell
	 *            the rfprimcell to set
	 */
	public void setRfprimcell(double rfprimcell) {
		this.rfprimcell = rfprimcell;
	}

	/**
	 * @return the rfseccell
	 */
	public double getRfseccell() {
		return rfseccell;
	}

	/**
	 * @param rfseccell
	 *            the rfseccell to set
	 */
	public void setRfseccell(double rfseccell) {
		this.rfseccell = rfseccell;
	}

	/**
	 * @return the rffsdclarifier
	 */
	public double getRffsdclarifier() {
		return rffsdclarifier;
	}

	/**
	 * @param rffsdclarifier
	 *            the rffsdclarifier to set
	 */
	public void setRffsdclarifier(double rffsdclarifier) {
		this.rffsdclarifier = rffsdclarifier;
	}

	/**
	 * @return the cyofdww
	 */
	public double getCyofdww() {
		return cyofdww;
	}

	/**
	 * @param cyofdww
	 *            the cyofdww to set
	 */
	public void setCyofdww(double cyofdww) {
		this.cyofdww = cyofdww;
	}

	/**
	 * @return the rchdcleaner
	 */
	public double getRchdcleaner() {
		return rchdcleaner;
	}

	/**
	 * @param rchdcleaner
	 *            the rchdcleaner to set
	 */
	public void setRchdcleaner(double rchdcleaner) {
		this.rchdcleaner = rchdcleaner;
	}

	/**
	 * @return the rctertiarycoarse
	 */
	public double getRctertiarycoarse() {
		return rctertiarycoarse;
	}

	/**
	 * @param rctertiarycoarse
	 *            the rctertiarycoarse to set
	 */
	public void setRctertiarycoarse(double rctertiarycoarse) {
		this.rctertiarycoarse = rctertiarycoarse;
	}

	/**
	 * @return the rctertiaryfine
	 */
	public double getRctertiaryfine() {
		return rctertiaryfine;
	}

	/**
	 * @param rctertiaryfine
	 *            the rctertiaryfine to set
	 */
	public void setRctertiaryfine(double rctertiaryfine) {
		this.rctertiaryfine = rctertiaryfine;
	}

	/**
	 * @return the rcfrwdcleaner
	 */
	public double getRcfrwdcleaner() {
		return rcfrwdcleaner;
	}

	/**
	 * @param rcfrwdcleaner
	 *            the rcfrwdcleaner to set
	 */
	public void setRcfrwdcleaner(double rcfrwdcleaner) {
		this.rcfrwdcleaner = rcfrwdcleaner;
	}

	/**
	 * @return the rcprimcell
	 */
	public double getRcprimcell() {
		return rcprimcell;
	}

	/**
	 * @param rcprimcell
	 *            the rcprimcell to set
	 */
	public void setRcprimcell(double rcprimcell) {
		this.rcprimcell = rcprimcell;
	}

	/**
	 * @return the rcseccell
	 */
	public double getRcseccell() {
		return rcseccell;
	}

	/**
	 * @param rcseccell
	 *            the rcseccell to set
	 */
	public void setRcseccell(double rcseccell) {
		this.rcseccell = rcseccell;
	}

	/**
	 * @return the rcfsdclarifier
	 */
	public double getRcfsdclarifier() {
		return rcfsdclarifier;
	}

	/**
	 * @param rcfsdclarifier
	 *            the rcfsdclarifier to set
	 */
	public void setRcfsdclarifier(double rcfsdclarifier) {
		this.rcfsdclarifier = rcfsdclarifier;
	}

	/**
	 * @return the ashdww
	 */
	public double getAshdww() {
		return ashdww;
	}

	/**
	 * @param ashdww
	 *            the ashdww to set
	 */
	public void setAshdww(double ashdww) {
		this.ashdww = ashdww;
	}

	/**
	 * @return the ashpupler
	 */
	public double getAshpupler() {
		return ashpupler;
	}

	/**
	 * @param ashpupler
	 *            the ashpupler to set
	 */
	public void setAshpupler(double ashpupler) {
		this.ashpupler = ashpupler;
	}

	/**
	 * @return the ashtertiarypress
	 */
	public double getAshtertiarypress() {
		return ashtertiarypress;
	}

	/**
	 * @param ashtertiarypress
	 *            the ashtertiarypress to set
	 */
	public void setAshtertiarypress(double ashtertiarypress) {
		this.ashtertiarypress = ashtertiarypress;
	}

	// More Columns Added For Frp Summary Data Report

	/**
	 * @return the dcsfrpyieldpercentage
	 */
	public double getDcsfrpyieldpercentage() {
		return dcsfrpyieldpercentage;
	}

	/**
	 * @param dcsfrpyieldpercentage
	 *            the dcsfrpyieldpercentage to set
	 */
	public void setDcsfrpyieldpercentage(double dcsfrpyieldpercentage) {
		this.dcsfrpyieldpercentage = dcsfrpyieldpercentage;
	}

	/**
	 * @param checkDouble
	 */
	public void setDcswastepaperfed(double dcswastepaperfed) {
		// TODO Auto-generated method stub
		this.dcsfrpyieldpercentage = dcswastepaperfed;
	}

	private double ylswdcswastepaperfed;

	/**
	 * @return the ylswdcswastepaperfed
	 */
	public double getYlswdcswastepaperfed() {
		return ylswdcswastepaperfed;
	}

	/**
	 * @param ylswdcswastepaperfed
	 *            the ylswdcswastepaperfed to set
	 */
	public void setYlswdcswastepaperfed(double ylswdcswastepaperfed) {
		this.ylswdcswastepaperfed = ylswdcswastepaperfed;
	}

	/**
	 * @return the ylswdcsfrpproduction
	 */
	public double getYlswdcsfrpproduction() {
		return ylswdcsfrpproduction;
	}

	/**
	 * @param ylswdcsfrpproduction
	 *            the ylswdcsfrpproduction to set
	 */
	public void setYlswdcsfrpproduction(double ylswdcsfrpproduction) {
		this.ylswdcsfrpproduction = ylswdcsfrpproduction;
	}

	/**
	 * @return the ylswdcsfrpyield
	 */
	public double getYlswdcsfrpyield() {
		return ylswdcsfrpyield;
	}

	/**
	 * @param ylswdcsfrpyield
	 *            the ylswdcsfrpyield to set
	 */
	public void setYlswdcsfrpyield(double ylswdcsfrpyield) {
		this.ylswdcsfrpyield = ylswdcsfrpyield;
	}

	/**
	 * @return the dcsfrpyield
	 */
	public double getDcsfrpyield() {

		if (this.ylswdcswastepaperfed != 0) {
			return (this.ylswdcsfrpproduction / ylswdcswastepaperfed) * 100;
		}

		return 0;
	}

	public double getYielddetrasherreectsper() {
		if (this.ylswdcswastepaperfed != 0) {
			return (this.rfdetrasherrejcts / (ylswdcswastepaperfed * 0.9) * 100);
		}
		return 0;
	}

	public double getYlswhdcleaners() {
		if (rfhdcleaner != 0) {
			return (this.rfhdcleaner * rfhdcleaner * 60 * 24 / 240 / 100);
		}
		return 0;
	}

	public double getYieldhdcleanersper() {
		if (this.ylswdcswastepaperfed != 0) {

			double val = (this.getYlswhdcleaners() / (ylswdcswastepaperfed * 0.9)) * 100;
			return (val);
		}
		return 0;
	}

	public double getYlswtertiarycoarse() {
		if (rftertiarycoarse != 0) {
			return (this.getRftertiarycoarse() * this.getRftertiarycoarse()
					* 60 * 24 / 240 / 100);
		}
		return 0;
	}

	public double getYlswtertiarycoarseper() {
		if (this.getYlswdcswastepaperfed() != 0) {
			return (this.getYlswtertiarycoarse()
					/ (getYlswdcswastepaperfed() * 0.9) * 100);
		}
		return 0;
	}

	public double getYlswtertiaryfine() {
		if (getRftertiaryfine() != 0) {
			return (this.getRftertiaryfine() * getRctertiaryfine() * 60 * 24
					/ 240 / 100);
		}
		return 0;
	}

	public double getYlswtertiaryfineper() {
		if (this.getYlswdcswastepaperfed() != 0) {
			return (this.getYlswtertiaryfine()
					/ (getYlswdcswastepaperfed() * 0.9) * 100);
		}
		return 0;
	}

	/*
	*//**
	 * @return the ylswforwardcleaner
	 */
	public double getYlswforwardcleaner() {
		// return ylswforwardcleaner;
		if (this.getRffrwdcleaner() != 0) {
			return (this.getRffrwdcleaner() * getRcfrwdcleaner() * 60 * 24
					/ 240 / 100);
		}
		return 0;
	}

	public double getYlswforwardcleanerper() {
		if (this.getYlswdcswastepaperfed() != 0) {
			return (this.getYlswforwardcleaner()
					/ (getYlswdcswastepaperfed() * 0.9) * 100);
		}
		return 0;
	}

	// -------------------------------------------------------------------
	/**
	 * @return the ylswprimflotcell
	 */
	public double getYlswprimflotcell() {
		if (this.getRfprimcell() != 0) {
			return (this.getRfprimcell() * getRfprimcell() * 60 * 24 / 240 / 100);
		}
		return 0;
	}

	// -------------------------------------------------------------------
	/**
	 * @return the ylswprimflotcellper
	 */
	public double getYlswprimflotcellper() {
		// return ylswprimflotcellper;
		if (this.getYlswdcswastepaperfed() != 0) {
			return ((this.getYlswprimflotcell()
					/ (this.getYlswdcswastepaperfed() * 0.9) * 100));
		}
		return 0;
	}

	/*
	*//**
	 * @return the ylswrfseccell
	 */
	public double getYlswrfseccell() {
		// return ylswrfseccell;
		if (this.getRfseccell() != 0) {
			return ((this.getRfseccell() * this.getRcseccell() * 60 * 24 / 240 / 100));
		}
		return 0;
	}

	/**
	 * @return the ylswrfseccellper
	 */
	public double getYlswrfseccellper() {
		// return ylswrfseccellper;
		if (this.getYlswdcswastepaperfed() != 0) {
			return ((this.getYlswrfseccell()
					/ (this.getYlswdcswastepaperfed() * 0.9) * 100));
		}
		return 0;
	}

	/**
	 * @return the ylswrffsdclarifier
	 */
	public double getYlswrffsdclarifier() {
		// return ylswrffsdclarifier;
		if (this.getRffsdclarifier() != 0) {
			return ((this.getRffsdclarifier() * this.getRcfsdclarifier() * 60
					* 24 / 240 / 100));
		}
		return 0;
	}

	/**
	 * @return the ylswrffsdclarifierper
	 */
	public double getYlswrffsdclarifierper() {
		// return ylswrffsdclarifierper;
		if (this.getYlswdcswastepaperfed() != 0) {
			return ((this.getYlswrffsdclarifier()
					/ (this.getYlswdcswastepaperfed() * 0.9) * 100));
		}
		return 0;
	}

	/**
	 * @return the ylswunaccounted
	 */
	public double getYlswunaccounted() {
		// return ylswunaccounted;
		return ((this.getYlswdcswastepaperfed() + 200 * this.getCyofdww() / 240 / 100) - (this
				.getYlswdcsfrpproduction()
				+ this.getRfdetrasherrejcts()
				+ this.getYlswhdcleaners()
				+ this.getYlswtertiarycoarse()
				+ this.getYlswtertiaryfine()
				+ this.getYlswforwardcleaner()
				+ this.getYlswprimflotcell() + this.getYlswrfseccell() + this
					.getYlswrffsdclarifier()));
	}

	/**
	 * @return the ylswunaccountedper
	 */
	public double getYlswunaccountedper() {
		// return ylswunaccountedper;
		// if(this.getYlswunaccounted() !=0){
		if (this.getYlswdcswastepaperfed() != 0) {
			return ((this.getYlswunaccounted()
					/ (this.getYlswdcswastepaperfed() * 0.9) * 100));
		}
		return 0;
	}

	/**
	 * @return the ylswashinpulper
	 */
	public double getYlswashinpulper() {
		// return ylswashinpulper;
		if (this.getAshpupler() != 0) {
			return (this.getYlswdcswastepaperfed() * getAshpupler() / 100);
		}
		return 0;
	}

	/**
	 * @param ylswashinpulper
	 *            the ylswashinpulper to set
	 */

	public void setYlswashinpulper(double ylswashinpulper) {
		this.ylswashinpulper = ylswashinpulper;
	}

	/**
	 * @return the ylswashindww
	 */

	public double getYlswashindww() {
		// return ylswashindww;
		if (this.getAshdww() != 0) {
			return (this.getYlswdcsfrpyield() * 1000000 * this.getCyofdww()
					* this.getAshdww() / 240 / 100 / 100);
		}
		return 0;
	}

	/**
	 * @param ylswashindww
	 *            the ylswashindww to set
	 */
	public void setYlswashindww(double ylswashindww) {
		this.ylswashindww = ylswashindww;
	}

	/**
	 * @return the ylswashouttertiarypress
	 */
	public double getYlswashouttertiarypress() {
		if (this.getAshpupler() != 0) {
			return (this.getYlswdcsfrpproduction() * getAshtertiarypress() / 100);
		}
		return 0;
	}

	/**
	 * @param ylswashouttertiarypress
	 *            the ylswashouttertiarypress to set
	 */
	public void setYlswashouttertiarypress(double ylswashouttertiarypress) {
		this.ylswashouttertiarypress = ylswashouttertiarypress;
	}

	/**
	 * @return the ylswashoutrejects
	 */
	public double getYlswashoutrejects() {
		double cal1 = (this.getYlswashinpulper()) + (this.getYlswashindww());
		double cal2 = this.getYlswashouttertiarypress();
		double cal3 = cal1 - cal2;
		if (this.getYlswashouttertiarypress() == 0) {
			return 0;
		} else {
			return cal3;
		}
	}

}
