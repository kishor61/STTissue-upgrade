/**
 *Sep 5, 2015
 *EfficiencyReportHandler.java
 * TODO
 *com.st.efficiency.report
 *EfficiencyReportHandler.java
 *Sunil Singh Bora
 */
package com.st.efficiency.report;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.efficiency.model.EfficiencyShiftData;

/**
 * @author sbora
 *
 */
@Component
public class EfficiencyReportHandler {

	/**
	 * @param datas
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createEfficiencyShiftReport(List<EfficiencyShiftData> datas,
			OutputStream outputStream) throws IOException {
		
		Workbook2007Util util=new Workbook2007Util();
		short rowHeight=280;
		int col=0;
		int row=0;
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		
		//Row 1
		util.addValue(row, 0, "DATE", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(row, row+1, 0, 0);
		//util.addValue(row, 1, "SHIFT", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		//util.mergeCell(row, row+1, 1, 1);
		util.addValue(row, 1, "TEAM", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(row, row+1, 1, 1);
		util.addValue(row, 2, "Machine Production", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(row, row, 2, 3);
		util.addValue(row, 4, "Wrapper Production", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(row, row, 4, 7);
		util.addValue(row, 8, "Variance", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(row, row+1, 8, 8);
		util.addValue(row, 9, "Variance %", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(row, row+1, 9, 9);
		util.addValue(row, 10, "Efficiency", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(row, row, 10, 13);
		
		 rowHeight=280*3;
		
		
		
		row++;
		util.addValue(row, 2, "Actual T/day", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 3, "Slaboff T/day", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 4, "White T/day ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 5, "Red T/day", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 6, "Reject T/day", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 7, "Total T/day", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 10, "Uptime   %", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 11, "Quality   %", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 12, "Yield       %", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 13, "Eff. Total   %", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		rowHeight=280;
		
		for (EfficiencyShiftData data : datas) {
			row++;
			col=0;
			
			util.addValue(row, col++, dateFormat.format(data.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		//	util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getActualWt(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getSlabOff(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapWhite(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapRed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapRej(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapTotal(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getVariance(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getVariancePer(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getUptime(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getQuality(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getYield(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getEffTotal(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
		}
		
		
		
		{
			row++;
			col=0;
			
			EfficiencyShiftData data=new EfficiencyShiftData().total(datas);
			
			util.addValue(row, col++, "TOTAL", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		//	util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getActualWt(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getSlabOff(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapWhite(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapRed(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapRej(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getVariance(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getVariancePer(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getUptime(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getQuality(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getYield(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			//Final Efficiency Avg. Grant For All Shift
			double toatlEff=0;	
			int sizeF=0;
				for (EfficiencyShiftData dataGrand : datas) {
					toatlEff=toatlEff+dataGrand.getEffTotal();
					sizeF++;
				}
			//util.addValue(row, col++, data.getEffTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(toatlEff/sizeF, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
	//Code Starts From Here Done By Roshan TAilor	
		{
			row++;
			col=0;
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
		{
			row++;
			col=0;
			
			util.addValue(row, col++, "Summary", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
		
		
		
		
		
		
		
		
		
		{
			row++;
			col=0;
			
			EfficiencyShiftData adata=new EfficiencyShiftData().totalA(datas);
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "A", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getActualWt(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getSlabOff(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getWrapWhite(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getWrapRed(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getWrapRej(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getWrapTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getVariance(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getVariancePer(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getUptime(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getQuality(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getYield(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			//Final Efficiency Avg. Grant For A Shift
			double toatlEff=0;	
			int sizeA=0;
				for (EfficiencyShiftData data : datas) {
					if(data.getCrew().equalsIgnoreCase("A")){
					toatlEff=toatlEff+data.getEffTotal();
					sizeA++;
					}
				}
			//util.addValue(row, col++, adata.getEffTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(toatlEff/sizeA, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
		{
			row++;
			col=0;
			
			EfficiencyShiftData bdata=new EfficiencyShiftData().totalB(datas);
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "B", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getActualWt(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getSlabOff(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getWrapWhite(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getWrapRed(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getWrapRej(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getWrapTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getVariance(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getVariancePer(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getUptime(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getQuality(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getYield(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			//Final Efficiency Avg. Grant For B Shift
			double toatlEff=0;	
			int sizeB=0;
				for (EfficiencyShiftData dataB : datas) {
					if(dataB.getCrew().equalsIgnoreCase("B")){
					toatlEff=toatlEff+dataB.getEffTotal();
					sizeB++;
					}
				}
			util.addValue(row, col++, CommonUtil.round(toatlEff/sizeB, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			//util.addValue(row, col++, bdata.getEffTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
		{
			row++;
			col=0;
			
			EfficiencyShiftData cdata=new EfficiencyShiftData().totalC(datas);
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "C", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getActualWt(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getSlabOff(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getWrapWhite(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getWrapRed(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getWrapRej(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getWrapTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getVariance(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getVariancePer(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getUptime(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getQuality(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getYield(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			//Final Efficiency Avg. Grant For C Shift
			double toatlEff=0;	
			int sizeC=0;
				for (EfficiencyShiftData dataC : datas) {
					if(dataC.getCrew().equalsIgnoreCase("C")){
					toatlEff=toatlEff+dataC.getEffTotal();
					sizeC++;
					}
				}
			util.addValue(row, col++, CommonUtil.round(toatlEff/sizeC, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			//util.addValue(row, col++, cdata.getEffTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
		{
			row++;
			col=0;
			
			EfficiencyShiftData ddata=new EfficiencyShiftData().totalD(datas);
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "D", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getActualWt(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getSlabOff(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getWrapWhite(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getWrapRed(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getWrapRej(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getWrapTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getVariance(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getVariancePer(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getUptime(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getQuality(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getYield(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			//Final Efficiency Avg. Grant For D Shift
			double toatlEff=0;	
			int sizeD=0;
				for (EfficiencyShiftData dataD : datas) {
					if(dataD.getCrew().equalsIgnoreCase("D")){
					toatlEff=toatlEff+dataD.getEffTotal();
					sizeD++;
					}
				}
			util.addValue(row, col++, CommonUtil.round(toatlEff/sizeD, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			//util.addValue(row, col++, ddata.getEffTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
		
		//Code Ends Here Done By Roshan Tailor
		
		util.write(outputStream);
	}

}
