/**
 *Mar 3, 2016
 *FrpProdcutionOperatorDataEntry.java
 * TODO
 *com.st.frpproduction.model
 *FrpProdcutionOperatorDataEntry.java
 *Sunil Singh Bora
 */
package com.st.frpproduction.model;

import java.util.Date;
import java.util.List;

import com.st.common.CommonUtil;
import com.st.efficiency.model.EfficiencyShiftData;

/**
 * @author sbora
 *
 */
public class FrpProdcutionOperatorDataEntry {

	private int id;
	private Date date;
	private String shift;
	private String crew;
	private String dayshift;
	private String nightshift;
	private double dailytotal;
	private double col1;
	private double col2;
	private double col3;
	private double col4;
	private double col5;
	private double col6;
	private double col7;
	private double col8;
	private double col9;
	private double col10;
	private double col11;
	private double col12;
	
	private double col11b;
	private double col6b;
	private double col7b;
	private double col8b;
	private double col9b;
	private double col10b;
	
	
	
	private double totalcol1;
	private double totalcol2;
	private double totalcol3;
	private double totalcol4;
	private double totalcol5;
	private double totalcol6;
	private double totalcol7;
	private double totalcol8;
	private double totalcol9;
	private double totalcol10;
	private double totalcol11;
	private double totalcol12;
	
	private double col1forday;
	private double col1fornight;
	private double col2forday;
	private double col2fornight;
	private double col3forday;
	private double col3fornight;
	private double col4forday;
	private double col4fornight;
	private double col5forday;
	private double col5fornight;
	private double col6forday;
	private double col6fornight;
	private double col7forday;
	private double col7fornight;
	private double col8forday;
	private double col8fornight;
	private double col9forday;
	private double col9fornight;
	private double col10forday;
	private double col10fornight;
	private double col11forday;
	private double col11fornight;
	private double col12forday;
	private double col12fornight;
	
	
	private double col11bforday;
	private double col6bforday;
	private double col7bforday;
	private double col8bforday;
	private double col9bforday;
	private double col10bforday;

	private double col11bfornight;
	private double col6bfornight;
	private double col7bfornight;
	private double col8bfornight;
	private double col9bfornight;
	private double col10bfornight;

	private double totalcol11b;
	private double totalcol6b;
	private double totalcol7b;
	private double totalcol8b;
	private double totalcol9b;
	private double totalcol10b;
	
	private double col10a;
	private double col12b;
	
	private double col10aforday;
	private double col10afornight;
	private double col12bfornight;
	private double col12bforday;
	private double totalcol12b;
	private double totalcol10a;
	
	private String productiontype;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getDayshift() {
		return dayshift;
	}
	public void setDayshift(String dayshift) {
		this.dayshift = dayshift;
	}
	public String getNightshift() {
		return nightshift;
	}
	public void setNightshift(String nightshift) {
		this.nightshift = nightshift;
	}
	public double getDailytotal() {
		return dailytotal;
	}
	public void setDailytotal(double dailytotal) {
		this.dailytotal = dailytotal;
	}
	public double getCol1() {
		return col1;
	}
	public void setCol1(double col1) {
		this.col1 = col1;
	}
	public double getCol2() {
		return col2;
	}
	public void setCol2(double col2) {
		this.col2 = col2;
	}
	public double getCol3() {
		return col3;
	}
	public void setCol3(double col3) {
		this.col3 = col3;
	}
	public double getCol4() {
		return col4;
	}
	public void setCol4(double col4) {
		this.col4 = col4;
	}
	public double getCol5() {
		return col5;
	}
	public void setCol5(double col5) {
		this.col5 = col5;
	}
	public double getCol6() {
		return col6;
	}
	public void setCol6(double col6) {
		this.col6 = col6;
	}
	public double getCol7() {
		return col7;
	}
	public void setCol7(double col7) {
		this.col7 = col7;
	}
	public double getCol8() {
		return col8;
	}
	public void setCol8(double col8) {
		this.col8 = col8;
	}
	public double getCol9() {
		return col9;
	}
	public void setCol9(double col9) {
		this.col9 = col9;
	}
	public double getCol10() {
		return col10;
	}
	public void setCol10(double col10) {
		this.col10 = col10;
	}
	public double getTotalcol1() {
		return totalcol1;
	}
	public void setTotalcol1(double totalcol1) {
		this.totalcol1 = totalcol1;
	}
	public double getTotalcol2() {
		return totalcol2;
	}
	public void setTotalcol2(double totalcol2) {
		this.totalcol2 = totalcol2;
	}
	public double getTotalcol3() {
		return totalcol3;
	}
	public void setTotalcol3(double totalcol3) {
		this.totalcol3 = totalcol3;
	}
	public double getTotalcol4() {
		return totalcol4;
	}
	public void setTotalcol4(double totalcol4) {
		this.totalcol4 = totalcol4;
	}
	public double getTotalcol5() {
		return totalcol5;
	}
	public void setTotalcol5(double totalcol5) {
		this.totalcol5 = totalcol5;
	}
	public double getTotalcol6() {
		return totalcol6;
	}
	public void setTotalcol6(double totalcol6) {
		this.totalcol6 = totalcol6;
	}
	public double getTotalcol7() {
		return totalcol7;
	}
	public void setTotalcol7(double totalcol7) {
		this.totalcol7 = totalcol7;
	}
	public double getTotalcol8() {
		return totalcol8;
	}
	public void setTotalcol8(double totalcol8) {
		this.totalcol8 = totalcol8;
	}
	public double getTotalcol9() {
		return totalcol9;
	}
	public void setTotalcol9(double totalcol9) {
		this.totalcol9 = totalcol9;
	}
	public double getTotalcol10() {
		return totalcol10;
	}
	public void setTotalcol10(double totalcol10) {
		this.totalcol10 = totalcol10;
	}
	public double getCol1forday() {
		return col1forday;
	}
	public void setCol1forday(double col1forday) {
		this.col1forday = col1forday;
	}
	public double getCol1fornight() {
		return col1fornight;
	}
	public void setCol1fornight(double col1fornight) {
		this.col1fornight = col1fornight;
	}
	public double getCol2forday() {
		return col2forday;
	}
	public void setCol2forday(double col2forday) {
		this.col2forday = col2forday;
	}
	public double getCol2fornight() {
		return col2fornight;
	}
	public void setCol2fornight(double col2fornight) {
		this.col2fornight = col2fornight;
	}
	public double getCol3forday() {
		return col3forday;
	}
	public void setCol3forday(double col3forday) {
		this.col3forday = col3forday;
	}
	public double getCol3fornight() {
		return col3fornight;
	}
	public void setCol3fornight(double col3fornight) {
		this.col3fornight = col3fornight;
	}
	public double getCol4forday() {
		return col4forday;
	}
	public void setCol4forday(double col4forday) {
		this.col4forday = col4forday;
	}
	public double getCol4fornight() {
		return col4fornight;
	}
	public void setCol4fornight(double col4fornight) {
		this.col4fornight = col4fornight;
	}
	public double getCol5forday() {
		return col5forday;
	}
	public void setCol5forday(double col5forday) {
		this.col5forday = col5forday;
	}
	public double getCol5fornight() {
		return col5fornight;
	}
	public void setCol5fornight(double col5fornight) {
		this.col5fornight = col5fornight;
	}
	public double getCol6forday() {
		return col6forday;
	}
	public void setCol6forday(double col6forday) {
		this.col6forday = col6forday;
	}
	public double getCol6fornight() {
		return col6fornight;
	}
	public void setCol6fornight(double col6fornight) {
		this.col6fornight = col6fornight;
	}
	public double getCol7forday() {
		return col7forday;
	}
	public void setCol7forday(double col7forday) {
		this.col7forday = col7forday;
	}
	public double getCol7fornight() {
		return col7fornight;
	}
	public void setCol7fornight(double col7fornight) {
		this.col7fornight = col7fornight;
	}
	public double getCol8forday() {
		return col8forday;
	}
	public void setCol8forday(double col8forday) {
		this.col8forday = col8forday;
	}
	public double getCol8fornight() {
		return col8fornight;
	}
	public void setCol8fornight(double col8fornight) {
		this.col8fornight = col8fornight;
	}
	public double getCol9forday() {
		return col9forday;
	}
	public void setCol9forday(double col9forday) {
		this.col9forday = col9forday;
	}
	public double getCol9fornight() {
		return col9fornight;
	}
	public void setCol9fornight(double col9fornight) {
		this.col9fornight = col9fornight;
	}
	public double getCol10forday() {
		return col10forday;
	}
	public void setCol10forday(double col10forday) {
		this.col10forday = col10forday;
	}
	public double getCol10fornight() {
		return col10fornight;
	}
	public void setCol10fornight(double col10fornight) {
		this.col10fornight = col10fornight;
	}
	public String getCrew() {
		return crew;
	}
	public void setCrew(String crew) {
		this.crew = crew;
	}
	
	/**
	 * @param details
	 * @return
	 */
	public Object totalA(List<FrpProdcutionOperatorDataEntry> details) {
		FrpProdcutionOperatorDataEntry shiftData=new FrpProdcutionOperatorDataEntry();
		double totalcol1=0;
		double totalcol2=0;
		double totalcol3=0;
		double totalcol4=0;
		double totalcol5=0;
		double totalcol6=0;
		double totalcol7=0;
		double totalcol8=0;
		double totalcol9=0;
		double totalcol10=0;
		double totalcol12=0;
	
		for (FrpProdcutionOperatorDataEntry efficiencyShiftData : details) {
			if(efficiencyShiftData.getCrew()==null){
				
			}else{
				if(efficiencyShiftData.getCrew().equalsIgnoreCase("A")){
					double col1=efficiencyShiftData.getCol1();
					double col2=efficiencyShiftData.getCol2();
					double col3=efficiencyShiftData.getCol3();
					double col4=efficiencyShiftData.getCol4();
					double col5=efficiencyShiftData.getCol5();
					double col6=efficiencyShiftData.getCol6();
					double col7=efficiencyShiftData.getCol7();
					double col8=efficiencyShiftData.getCol8();
					double col9=efficiencyShiftData.getCol9();
					double col10=efficiencyShiftData.getCol10();
					double col12=efficiencyShiftData.getCol12();
					
					totalcol1 = totalcol1 + col1;
					totalcol2 = totalcol2 + col2;
					totalcol3 = totalcol3 + col3;
					totalcol4 = totalcol4 + col4;
					totalcol5 = totalcol5 + col5;
					totalcol6 = totalcol6 + col6;
					totalcol7 = totalcol7 + col7;
					totalcol8 = totalcol8 + col8;
					totalcol9 = totalcol9 + col9;
					totalcol10 = totalcol10 + col10;
					totalcol12 = totalcol12 + col12;
					
					shiftData.setCol1(CommonUtil.round(totalcol1, 2)/details.size());
					shiftData.setCol2(CommonUtil.round(totalcol2, 2)/details.size());
					shiftData.setCol3(CommonUtil.round(totalcol3, 2)/details.size());
					shiftData.setCol4(CommonUtil.round(totalcol4, 2)/details.size());
					shiftData.setCol5(CommonUtil.round(totalcol5, 2)/details.size());
					shiftData.setCol6(CommonUtil.round(totalcol6, 2)/details.size());
					shiftData.setCol7(CommonUtil.round(totalcol7, 2)/details.size());
					shiftData.setCol8(CommonUtil.round(totalcol8, 2)/details.size());
					shiftData.setCol9(CommonUtil.round(totalcol9, 2)/details.size());
					shiftData.setCol10(CommonUtil.round(totalcol10, 2)/details.size());
					shiftData.setCol12(CommonUtil.round(totalcol12, 2)/details.size());
					
				}
			}
			
			
		}
		return shiftData;
	}
	public double getCol11() {
		return col11;
	}
	public void setCol11(double col11) {
		this.col11 = col11;
	}
	public double getTotalcol11() {
		return totalcol11;
	}
	public void setTotalcol11(double totalcol11) {
		this.totalcol11 = totalcol11;
	}
	public double getCol11forday() {
		return col11forday;
	}
	public void setCol11forday(double col11forday) {
		this.col11forday = col11forday;
	}
	public double getCol11fornight() {
		return col11fornight;
	}
	public void setCol11fornight(double col11fornight) {
		this.col11fornight = col11fornight;
	}
	public String getProductiontype() {
		return productiontype;
	}
	public void setProductiontype(String productiontype) {
		this.productiontype = productiontype;
	}
	public double getCol11b() {
		return col11b;
	}
	public void setCol11b(double col11b) {
		this.col11b = col11b;
	}
	public double getCol6b() {
		return col6b;
	}
	public void setCol6b(double col6b) {
		this.col6b = col6b;
	}
	public double getCol7b() {
		return col7b;
	}
	public void setCol7b(double col7b) {
		this.col7b = col7b;
	}
	public double getCol8b() {
		return col8b;
	}
	public void setCol8b(double col8b) {
		this.col8b = col8b;
	}
	public double getCol9b() {
		return col9b;
	}
	public void setCol9b(double col9b) {
		this.col9b = col9b;
	}
	public double getCol10b() {
		return col10b;
	}
	public void setCol10b(double col10b) {
		this.col10b = col10b;
	}
	public double getCol11bforday() {
		return col11bforday;
	}
	public void setCol11bforday(double col11bforday) {
		this.col11bforday = col11bforday;
	}
	public double getCol6bforday() {
		return col6bforday;
	}
	public void setCol6bforday(double col6bforday) {
		this.col6bforday = col6bforday;
	}
	public double getCol7bforday() {
		return col7bforday;
	}
	public void setCol7bforday(double col7bforday) {
		this.col7bforday = col7bforday;
	}
	public double getCol8bforday() {
		return col8bforday;
	}
	public void setCol8bforday(double col8bforday) {
		this.col8bforday = col8bforday;
	}
	public double getCol9bforday() {
		return col9bforday;
	}
	public void setCol9bforday(double col9bforday) {
		this.col9bforday = col9bforday;
	}
	public double getCol10bforday() {
		return col10bforday;
	}
	public void setCol10bforday(double col10bforday) {
		this.col10bforday = col10bforday;
	}
	public double getCol11bfornight() {
		return col11bfornight;
	}
	public void setCol11bfornight(double col11bfornight) {
		this.col11bfornight = col11bfornight;
	}
	public double getCol6bfornight() {
		return col6bfornight;
	}
	public void setCol6bfornight(double col6bfornight) {
		this.col6bfornight = col6bfornight;
	}
	public double getCol7bfornight() {
		return col7bfornight;
	}
	public void setCol7bfornight(double col7bfornight) {
		this.col7bfornight = col7bfornight;
	}
	public double getCol8bfornight() {
		return col8bfornight;
	}
	public void setCol8bfornight(double col8bfornight) {
		this.col8bfornight = col8bfornight;
	}
	public double getCol9bfornight() {
		return col9bfornight;
	}
	public void setCol9bfornight(double col9bfornight) {
		this.col9bfornight = col9bfornight;
	}
	public double getCol10bfornight() {
		return col10bfornight;
	}
	public void setCol10bfornight(double col10bfornight) {
		this.col10bfornight = col10bfornight;
	}
	public double getTotalcol11b() {
		return totalcol11b;
	}
	public void setTotalcol11b(double totalcol11b) {
		this.totalcol11b = totalcol11b;
	}
	public double getTotalcol6b() {
		return totalcol6b;
	}
	public void setTotalcol6b(double totalcol6b) {
		this.totalcol6b = totalcol6b;
	}
	public double getTotalcol7b() {
		return totalcol7b;
	}
	public void setTotalcol7b(double totalcol7b) {
		this.totalcol7b = totalcol7b;
	}
	public double getTotalcol8b() {
		return totalcol8b;
	}
	public void setTotalcol8b(double totalcol8b) {
		this.totalcol8b = totalcol8b;
	}
	public double getTotalcol9b() {
		return totalcol9b;
	}
	public void setTotalcol9b(double totalcol9b) {
		this.totalcol9b = totalcol9b;
	}
	public double getTotalcol10b() {
		return totalcol10b;
	}
	public void setTotalcol10b(double totalcol10b) {
		this.totalcol10b = totalcol10b;
	}
	public double getCol10a() {
		return col10a;
	}
	public void setCol10a(double col10a) {
		this.col10a = col10a;
	}
	public double getCol12b() {
		return col12b;
	}
	public void setCol12b(double col12b) {
		this.col12b = col12b;
	}
	public double getCol10aforday() {
		return col10aforday;
	}
	public void setCol10aforday(double col10aforday) {
		this.col10aforday = col10aforday;
	}
	public double getCol10afornight() {
		return col10afornight;
	}
	public void setCol10afornight(double col10afornight) {
		this.col10afornight = col10afornight;
	}
	public double getCol12bfornight() {
		return col12bfornight;
	}
	public void setCol12bfornight(double col12bfornight) {
		this.col12bfornight = col12bfornight;
	}
	public double getCol12bforday() {
		return col12bforday;
	}
	public void setCol12bforday(double col12bforday) {
		this.col12bforday = col12bforday;
	}
	public double getTotalcol12b() {
		return totalcol12b;
	}
	public void setTotalcol12b(double totalcol12b) {
		this.totalcol12b = totalcol12b;
	}
	public double getTotalcol10a() {
		return totalcol10a;
	}
	public void setTotalcol10a(double totalcol10a) {
		this.totalcol10a = totalcol10a;
	}
	/**
	 * @return the col12
	 */
	public double getCol12() {
		return col12;
	}
	/**
	 * @param col12 the col12 to set
	 */
	public void setCol12(double col12) {
		this.col12 = col12;
	}
	/**
	 * @return the totalcol12
	 */
	public double getTotalcol12() {
		return totalcol12;
	}
	/**
	 * @param totalcol12 the totalcol12 to set
	 */
	public void setTotalcol12(double totalcol12) {
		this.totalcol12 = totalcol12;
	}
	/**
	 * @return the col12forday
	 */
	public double getCol12forday() {
		return col12forday;
	}
	/**
	 * @param col12forday the col12forday to set
	 */
	public void setCol12forday(double col12forday) {
		this.col12forday = col12forday;
	}
	/**
	 * @return the col12fornight
	 */
	public double getCol12fornight() {
		return col12fornight;
	}
	/**
	 * @param col12fornight the col12fornight to set
	 */
	public void setCol12fornight(double col12fornight) {
		this.col12fornight = col12fornight;
	}
	
}
