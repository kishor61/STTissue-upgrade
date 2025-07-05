/**
 * 
 */
package com.st.production.util;

import java.util.Comparator;

import com.st.production.model.WrapProductionRedCode;

/**
 * @author sbora
 *
 */
public class WrapperRedCodeComparator implements Comparator<WrapProductionRedCode> {

	public enum Field{RED,REJECT}
	
	private Field field=Field.RED;
	
	@Override
	public int compare(WrapProductionRedCode o1, WrapProductionRedCode o2) {
		switch (field) {
		case RED:
			return new Double(o2.getTotalRed()).compareTo(new Double(o1.getTotalRed()));

		case REJECT:
			return new Double(o2.getTotalReject()).compareTo(new Double(o1.getTotalReject()));
		}
		
		return 0;
	}


	public void setField(Field field) {
		this.field = field;
	}

}
