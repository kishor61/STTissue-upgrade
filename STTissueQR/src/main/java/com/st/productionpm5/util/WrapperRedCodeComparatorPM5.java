/**
 * 
 */
package com.st.productionpm5.util;

import java.util.Comparator;

import com.st.productionpm5.model.WrapProductionRedCodePM5;

/**
 * @author sbora
 *
 */
public class WrapperRedCodeComparatorPM5 implements Comparator<WrapProductionRedCodePM5> {

	public enum Field{RED,REJECT}
	
	private Field field=Field.RED;
	
	@Override
	public int compare(WrapProductionRedCodePM5 o1, WrapProductionRedCodePM5 o2) {
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
