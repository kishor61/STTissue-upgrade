/**
 * 
 */
package com.st.productionpm5.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sbora
 * 
 */
public class WrapProductionRedCodePM5 {
	private String redCode;
	private String redCodeDesc;
	
	private double totalRedWhite;
	private double totalRedBrown;
	private double totalRejectWhite;
	private double totalRejectBrown;

	private double totalRed;
	private double totalReject;
	
	private List<WrapperData> wrapperData=new ArrayList<>();
	
	
	

	public String getRedCode() {
		return redCode;
	}

	public void setRedCode(String redCode) {
		this.redCode = redCode;
	}

	public String getRedCodeDesc() {
		return redCodeDesc;
	}

	public void setRedCodeDesc(String redCodeDesc) {
		this.redCodeDesc = redCodeDesc;
	}


	public List<WrapperData> getWrapperData() {
		return wrapperData;
	}

	public void setWrapperData(List<WrapperData> wrapperData) {
		this.wrapperData = wrapperData;
	}









	public double getTotalRedWhite() {
		return totalRedWhite;
	}

	public void setTotalRedWhite(double totalRedWhite) {
		this.totalRedWhite = totalRedWhite;
	}









	public double getTotalRedBrown() {
		return totalRedBrown;
	}

	public void setTotalRedBrown(double totalRedBrown) {
		this.totalRedBrown = totalRedBrown;
	}









	public double getTotalRejectWhite() {
		return totalRejectWhite;
	}

	public void setTotalRejectWhite(double totalRejectWhite) {
		this.totalRejectWhite = totalRejectWhite;
	}









	public double getTotalRejectBrown() {
		return totalRejectBrown;
	}

	public void setTotalRejectBrown(double totalRejectBrown) {
		this.totalRejectBrown = totalRejectBrown;
	}









	public double getTotalRed() {
		return totalRed;
	}

	public void setTotalRed(double totalRed) {
		this.totalRed = totalRed;
	}









	public double getTotalReject() {
		return totalReject;
	}

	public void setTotalReject(double totalReject) {
		this.totalReject = totalReject;
	}









	public class WrapperData{
		private double redWeightWhite;
		private double redWeightBrown;
		private double rejectedWeightWhite;
		private double rejectedWeightBrown;
		public double getRedWeightWhite() {
			return redWeightWhite;
		}
		public void setRedWeightWhite(double redWeightWhite) {
			this.redWeightWhite = redWeightWhite;
		}
		public double getRedWeightBrown() {
			return redWeightBrown;
		}
		public void setRedWeightBrown(double redWeightBrown) {
			this.redWeightBrown = redWeightBrown;
		}
		public double getRejectedWeightBrown() {
			return rejectedWeightBrown;
		}
		public void setRejectedWeightBrown(double rejectedWeightBrown) {
			this.rejectedWeightBrown = rejectedWeightBrown;
		}
		public double getRejectedWeightWhite() {
			return rejectedWeightWhite;
		}
		public void setRejectedWeightWhite(double rejectedWeightWhite) {
			this.rejectedWeightWhite = rejectedWeightWhite;
		}
		
		
	}
}
