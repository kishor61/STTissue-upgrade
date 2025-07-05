/**
 *Apr 28, 2015
 *FrpYieldReportHandler.java
 * TODO
 *com.st.frpyieldreport.controller
 *FrpYieldReportHandler.java
 *Sunil Singh Bora
 */
package com.st.frpyieldreport.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.Workbook2007Util;
import com.st.frpyield.model.FrpYield;

/**
 * @author roshan
 *
 */
@Component
public class FrpYieldSummaryReportHandler {

	/**
	 * @param dailyreportdata
	 * @param file 
	 * @param outputStream
	 */
	public void createFrpDailyReport(List<FrpYield> dailyreportdata,
			File file, ServletOutputStream outputStream) throws Exception{
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file,0);
		
		short rowHeight = 280;
		int row=4;
		int col=0;
		for (FrpYield frpYield : dailyreportdata) {
			col=0;
			//-----1
			util.addValue(row, col++, new SimpleDateFormat("MM/dd/yyyy").format(frpYield.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//-----2
			util.addValue(row, col++, frpYield.getYlswdcswastepaperfed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//-----3
			if(frpYield.getYlswdcsfrpproduction()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getYlswdcsfrpproduction(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----4
			if(frpYield.getYlswdcsfrpyield()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				double frpyieldvalue=frpYield.getYlswdcsfrpproduction()/frpYield.getYlswdcswastepaperfed()*100;
				util.addValue(row, col++, frpyieldvalue, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----5
			if(frpYield.getRfdetrasherrejcts()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRfdetrasherrejcts(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----6
			if(frpYield.getYielddetrasherreectsper()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRfdetrasherrejcts()/(frpYield.getYlswdcswastepaperfed()*0.9)*100, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----7
			if(frpYield.getRfhdcleaner()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRcfrwdcleaner()*frpYield.getRfhdcleaner()*60*24/240/100, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----8
			if(frpYield.getYlswhdcleaners()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
			//frpYield.getYlswhdcleaners()/(frpYield.getYlswdcswastepaperfed()*0.9)*100
				util.addValue(row, col++,frpYield.getYieldhdcleanersper() , Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----9
			if(frpYield.getRftertiarycoarse()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++,  frpYield.getRftertiarycoarse()*frpYield.getRftertiarycoarse()*60*24/240/100, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----10
			if(frpYield.getYlswtertiarycoarse()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
			//frpYield.getYlswtertiarycoarse()/(frpYield.getYlswdcswastepaperfed()*0.9)*100
				util.addValue(row, col++,frpYield.getYlswtertiarycoarseper() , Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----11
			if(frpYield.getRftertiaryfine()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRftertiaryfine()*frpYield.getRctertiaryfine()*60*24/240/100, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----12
			if(frpYield.getYlswtertiaryfine()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
			//frpYield.getYlswtertiaryfine()/(frpYield.getYlswdcswastepaperfed()*0.9)*100
				
				util.addValue(row, col++,frpYield.getYlswtertiaryfineper(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----13
			if(frpYield.getRffrwdcleaner()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRffrwdcleaner()*frpYield.getRcfrwdcleaner()*60*24/240/100, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----14
			if(frpYield.getYlswforwardcleaner()==0){
				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				//frpYield.getYlswforwardcleaner()/(frpYield.getYlswdcswastepaperfed()*0.9)*100
				util.addValue(row, col++,frpYield.getYlswforwardcleanerper() , Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----15
			if(frpYield.getRfprimcell()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRfprimcell()*frpYield.getRfprimcell()*60*24/240/100, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----16
			if(frpYield.getYlswprimflotcell()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				//frpYield.getYlswprimflotcell()/(frpYield.getYlswdcswastepaperfed()*0.9)*100
				util.addValue(row, col++,frpYield.getYlswprimflotcellper() , Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----17
			if(frpYield.getRfseccell()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRfseccell()*frpYield.getRcseccell()*60*24/240/100, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----18
			if(frpYield.getYlswrfseccell()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
			//frpYield.getYlswrfseccell()/(frpYield.getYlswdcswastepaperfed()*0.9)*100
				util.addValue(row, col++,frpYield.getYlswrfseccellper(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----19
			if(frpYield.getRffsdclarifier()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRffsdclarifier()*frpYield.getRcfsdclarifier()*60*24/240/100, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----20
			if(frpYield.getYlswrffsdclarifier()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				//frpYield.getYlswrffsdclarifier()/(frpYield.getYlswdcswastepaperfed()*0.9)*100 
				util.addValue(row, col++,frpYield.getYlswrffsdclarifierper(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----21
//			if(frpYield.getYlswunaccounted()==0){
//				util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
////			}else{
			//util.addValue(row, col++, (frpYield.getYlswrffsdclarifier()/(frpYield.getRfdetrasherrejcts()*0.9)*100), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//(S5/($B5*0.9)*100)
//			}
			//----22
			if(frpYield.getYlswunaccounted()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++,(frpYield.getYlswdcswastepaperfed()+200*frpYield.getCyofdww()/240/100)-(frpYield.getYlswdcsfrpproduction()+frpYield.getRfdetrasherrejcts()+frpYield.getYlswhdcleaners()+frpYield.getYlswtertiarycoarse()+frpYield.getYlswtertiaryfine()+frpYield.getYlswforwardcleaner()+frpYield.getYlswprimflotcell()+frpYield.getYlswrfseccell()+frpYield.getYlswrffsdclarifier()) , Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//Mistake Code Corrected By Roshan Tailor Starts From Here
			if(frpYield.getYlswunaccountedper()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				//frpYield.getYlswunaccounted()/(frpYield.getYlswdcswastepaperfed()*0.9)*100
				util.addValue(row, col++,frpYield.getYlswunaccountedper(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
//Mistake Code Corrected By Roshan Tailor Ends Here
			//----23
			if(frpYield.getAshpupler()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getYlswdcswastepaperfed()*frpYield.getAshpupler()/100,Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----24
			if(frpYield.getAshdww()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getYlswdcsfrpyield()*1000000*frpYield.getCyofdww()*frpYield.getAshdww()/240/100/100, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----25
			if(frpYield.getAshpupler()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getYlswdcsfrpproduction()*frpYield.getAshtertiarypress()/100, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----26
		if(frpYield.getYlswashoutrejects()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
					util.addValue(row, col++,frpYield.getYlswashoutrejects(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//----
			//----
			
			
			row++;
		}
		
		
		
		
		util.write(outputStream);
		
	}

}
