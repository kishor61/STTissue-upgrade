/**
 *Mar 25, 2017
 *ConvertingLine.java
 * TODO
 *com.st.convertingline.model
 *ConvertingLine.java
 *Roshan Lal Tailor
 */
package com.st.convertingline.model;

import java.util.Date;

/**
 * @author roshan
 *
 */
public class ConvertingLine2 {
	
	
	
	private String customer;
	private String skucode;
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getSkucode() {
		return skucode;
	}
	public void setSkucode(String skucode) {
		this.skucode = skucode;
	} 
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		ConvertingLine2 cl2=(ConvertingLine2)obj;
		if(cl2.getCustomer().equals(this.customer) && cl2.getSkucode().equals(this.skucode)){
			return true;
		}else{
			return false;
		}
	}
}
