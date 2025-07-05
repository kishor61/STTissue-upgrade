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
public class FrpYieldReportHandler {

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
			util.addValue(row, col++, new SimpleDateFormat("MM/dd/yyyy").format(frpYield.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, frpYield.getDwwflowrommill(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRfdetrasherrejcts()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRfdetrasherrejcts(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRfdetrasherrejcts(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRfhdcleaner()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRfhdcleaner(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRfhdcleaner(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRftertiarycoarse()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRftertiarycoarse(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRftertiarycoarse(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRftertiaryfine()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRftertiaryfine(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRftertiaryfine(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRffrwdcleaner()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRffrwdcleaner(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRffrwdcleaner(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRfprimcell()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRfprimcell(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRfprimcell(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRfseccell()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRfseccell(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRfseccell(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRffsdclarifier()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRffsdclarifier(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRffsdclarifier(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			if(frpYield.getCyofdww()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getCyofdww(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getCyofdww(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			
			if(frpYield.getRchdcleaner()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRchdcleaner(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRchdcleaner(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRctertiarycoarse()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRctertiarycoarse(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRctertiarycoarse(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRctertiaryfine()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRctertiaryfine(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRctertiaryfine(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRcfrwdcleaner()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRcfrwdcleaner(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRcfrwdcleaner(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRcprimcell()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRcprimcell(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRcprimcell(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRcseccell()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRcseccell(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRcseccell(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getRcfsdclarifier()==0){
				util.addValue(row, col++, "0",Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getRcfsdclarifier(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getRcfsdclarifier(),Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getAshdww()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getAshdww(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getAshdww(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getAshpupler()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getAshpupler(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getAshpupler(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if(frpYield.getAshtertiarypress()==0){
				util.addValue(row, col++, "0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}else{
				util.addValue(row, col++, frpYield.getAshtertiarypress(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			//util.addValue(row, col++, frpYield.getAshtertiarypress(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			row++;
		}
		
		
		
		
		util.write(outputStream);
		
	}

}
