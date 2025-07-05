/**
 *Oct 11, 2020
 *Test.java
 * TODO
 *com.st.centerlinePM5.report
 *Test.java
 *Sohan Lal 
 */
package com.st.centerlinePM5.report;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sohanlal
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


	
			Map<String, Double> data = new HashMap<String, Double>();

			String[] myarray = getVraiableName();

			String[] pulps = new String[] { "A", "B" };
			for (String string : pulps) {
				for (String vraible : myarray) {
					data.put(vraible.concat(string).concat("Day"), null);
					data.put(vraible.concat(string).concat("Night"), null);
				}

			}
			for (Map.Entry<String, Double> entry : data.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
			System.out.println("**************"+ data.size());
		}

		/**
		 * @return
		 */
		private static String[] getVraiableName() {
			String[] str = new String[10];
			str[0] = "totalBaleWightLine";
			str[1] = "occWightLine";
			str[2] = "dlkwieghtLine";
			str[3] = "newswieghtLine";
			str[4] = "oldnewswieghLine";
			str[5] = "mailwieghtLine";
			str[6] = "brownwieghtLine";
			str[7] = "sowwieghtLine";
			str[8] = "occGroceryLine";
			str[9] = "boxboardclippingsLine";
			return str;
		}


	

}
