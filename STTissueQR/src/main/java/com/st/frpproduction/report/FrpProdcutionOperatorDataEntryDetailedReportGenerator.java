/**
 *Apr 11, 2016
 *FrpProdcutionOperatorDataEntryDetailedReportGenerator.java
 * TODO
 *com.st.frpproduction.report
 *FrpProdcutionOperatorDataEntryDetailedReportGenerator.java
 *Sunil Singh Bora
 */
package com.st.frpproduction.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;

/**
 * @author sbora
 *
 */
@Component
public class FrpProdcutionOperatorDataEntryDetailedReportGenerator {

	/**
	 * @param details
	 * @param aavg
	 * @param bavg
	 * @param cavg
	 * @param davg
	 * @param outputStream
	 * @throws IOException 
	 */
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	public void createEfficiencyShiftReport(
			List<FrpProdcutionOperatorDataEntry> details,
			List<FrpProdcutionOperatorDataEntry> aavg,
			List<FrpProdcutionOperatorDataEntry> bavg,
			List<FrpProdcutionOperatorDataEntry> cavg,
			List<FrpProdcutionOperatorDataEntry> davg,
			FileOutputStream outputStream) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util();
		util.setSheetName("ST Tissue FRP-MTD Daily Production Report", 0);

		short rowHeight = 280;
		short rowHeight1 = 1800;
		int row=0;
		int col=0;
		int lastcol=0;
		util.addValue(row, col++,"Date", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Shift", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Crew", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Production Type", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"DEINK W.W. PUMP 4 3 1 - FT -6875", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"WATER TO FIRE/MILL WATER TANK 430-FT-6956", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"FIRE SYSTEM WATER 430-FT-6959", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"DEINKING PLANT EFFLUENT 431-FT-6083", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		
		util.addValue(row, col++,"LINE A-HD LEVEL AS OF 7 AM / 7 PM", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE A-TONS PRODUCED TO THE TUBE CONVEYOR", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE A-WETLAP TONS PRODUCED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE A-YIELD", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE A-WASTE PAPER FED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE A-# OF BATCHES FED Shift Goal 16", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		
		
		util.addValue(row, col++,"LINE B-PCC Tank LEVEL AS OF 7 AM / 7 PM", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE B-TONS PRODUCED TO� THE TUBE CONVEYOR", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE B-WETLAP TONS PRODUCED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE B-YIELD", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE B-WASTE PAPER FED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE B-# OF BATCHES FED Shift Goal 16", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		
		
		//Column For Grand Total Of The Day
		/*util.addValue(row, col++,"DEINK W.W. PUMP 4 3 1 - FT -6875", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"WATER TO FIRE/MILL WATER TANK 430-FT-6956", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"FIRE SYSTEM WATER 430-FT-6959", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"DEINKING PLANT EFFLUENT 431-FT-6083", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"HD LEVEL AS OF 7 AM / 7 PM", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"TONS PRODUCED TO� THE TUBE CONVEYOR", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"WETLAP TONS PRODUCED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"YIELD", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"WASTE PAPER FED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"# OF BATCHES FED Shift Goal 16", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);*/
		
		row=1;
		
		for(FrpProdcutionOperatorDataEntry data:details){
			col=0;
			lastcol=1;
			
			/*util.addValue(row, col++, dateFormat.format(data.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol1(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol2(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol3(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol4(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol5(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol6(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol7(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round((data.getTotalcol6()+data.getTotalcol7()/data.getTotalcol9()*100), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol9(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol10(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);*/
			
			util.addValue(row, col++, dateFormat.format(data.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, data.getShift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getProductiontype(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			//util.addValue(row, col++, CommonUtil.round(data.getCol2(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6()+data.getCol7())/data.getCol9())*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6b()+data.getCol7b())/data.getCol9b())*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			
			/*int i=col;
			for(;i>=13;i++){
				util.mergeCell(row, row++, col, col);
				if(i==22){
					break;
				}else{
					continue;
				}
			}*/
			/*util.mergeCell(row, row++, col, col);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol1(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.mergeCell(row, row++, col, col);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol2(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.mergeCell(row, row++, col, col);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol3(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.mergeCell(row, row++, col, col);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol4(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.mergeCell(row, row++, col, col);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol5(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.mergeCell(row, row++, col, col);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol6(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.mergeCell(row, row++, col, col);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol7(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.mergeCell(row, row++, col, col);
			util.addValue(row, col++, CommonUtil.round((data.getTotalcol6()+data.getTotalcol7()/data.getTotalcol9()*100), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.mergeCell(row, row++, col, col);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol9(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.mergeCell(row, row++, col, col);
			util.addValue(row, col++, CommonUtil.round(data.getTotalcol10(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);*/
			
			row++;	
		}
		col=0;
		row++;	
		util.addValue(row, col++, "Summary", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		//util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		row++;
		for(FrpProdcutionOperatorDataEntry data:aavg){
			col=0;
			lastcol=1;
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "A", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			//util.addValue(row, col++, CommonUtil.round(data.getCol2(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6()+data.getCol7())/data.getCol9())*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			
			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6b()+data.getCol7b())/data.getCol9b())*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			
			row++;
		}
		
		for(FrpProdcutionOperatorDataEntry data:bavg){
			col=0;
			lastcol=1;
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "B", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			//util.addValue(row, col++, CommonUtil.round(data.getCol2(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6()+data.getCol7())/data.getCol9())*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			
			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6b()+data.getCol7b())/data.getCol9b())*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			row++;
		}
		
		for(FrpProdcutionOperatorDataEntry data:cavg){
			col=0;
			lastcol=1;
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "C", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			//util.addValue(row, col++, CommonUtil.round(data.getCol2(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6()+data.getCol7())/data.getCol9())*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6b()+data.getCol7b())/data.getCol9b())*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			row++;
		}
		
		for(FrpProdcutionOperatorDataEntry data:davg){
			col=0;
			lastcol=1;
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "D", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			//util.addValue(row, col++, CommonUtil.round(data.getCol2(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6()+data.getCol7())/data.getCol9())*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6b()+data.getCol7b())/data.getCol9b())*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			row++;
		}
		
		util.write(outputStream);
	}
	public void getExcelReportForDataEntry(List<FrpProdcutionOperatorDataEntry> details,FileOutputStream outputStream) throws IOException {

		Workbook2007Util util = new Workbook2007Util();
		util.setSheetName("Frp Prodcution Operator Data Entry Report", 0);
		float totaldeinkwwpump431_ft_6875=0;
		float totalwatertofiremillwatertank430_ft_6956=0;
		float totalfiresystemwater430_ft_6959=0;
		float totaldeinkingplanteffluent431_ft_6083=0;
		float totalsewerflow_430_fi_7020=0;
		float totallinea_tonsproducedtothetubeconveyor=0;
		float totallinea_wetlaptonsproduced=0;
		float totallinea_yield=0;
		float totallinea_wastepaperfed=0;
		float totallinea_ofbatchesfedshiftgoal16=0;
		float totallineb_tonsproducedtothetubeconveyor=0;
		float totallineb_wetlaptonsproduced=0;
		float totallineb_yield=0;
		float totallineb_wastepaperfed=0;
		float totallineb_ofbatchesfedshiftgoal16=0;
		short rowHeight = 280;
		short rowHeight1 = 1800;
		int row=0;
		int col=0;
		util.addValue(row, col++,"Date", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Shift", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Crew", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Production Type", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"DEINK W.W. PUMP 4 3 1 - FT -6875", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"WATER TO FIRE/MILL WATER TANK 430-FT-6956", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"FIRE SYSTEM WATER 430-FT-6959", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"DEINKING PLANT EFFLUENT 431-FT-6083", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"SEWER FLOW	430-FI-7020", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE A-HD LEVEL AS OF 7 AM / 7 PM", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE A-TONS PRODUCED TO� THE TUBE CONVEYOR", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE A-WETLAP TONS PRODUCED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE A-YIELD", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE A-WASTE PAPER FED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE A-# OF BATCHES FED Shift Goal 16", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Line-A Current Run Rate", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		
		util.addValue(row, col++,"LINE B-PCC Tank LEVEL AS OF 7 AM / 7 PM", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE B-TONS PRODUCED TO� THE TUBE CONVEYOR", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE B-WETLAP TONS PRODUCED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE B-YIELD", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE B-WASTE PAPER FED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"LINE B-# OF BATCHES FED Shift Goal 16", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Line-B Current Run Rate", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		row=1;
		
		for (FrpProdcutionOperatorDataEntry data : details) {
			col = 0;
			util.addValue(row, col++, dateFormat.format(data.getDate()),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, data.getShift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getProductiontype(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow,
					rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6() + data.getCol7()) / data.getCol9()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10a(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);

			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++,
					CommonUtil.round(((data.getCol6b() + data.getCol7b()) / data.getCol9b()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		
			totaldeinkwwpump431_ft_6875+=	CommonUtil.round(data.getCol1(), 2);
			totalwatertofiremillwatertank430_ft_6956+=	CommonUtil.round(data.getCol3(), 2);
			totalfiresystemwater430_ft_6959+=	CommonUtil.round(data.getCol4(), 2);
			totaldeinkingplanteffluent431_ft_6083+=	CommonUtil.round(data.getCol5(), 2);
			totalsewerflow_430_fi_7020+=	CommonUtil.round(data.getCol12(), 2);
			totallinea_tonsproducedtothetubeconveyor+=	CommonUtil.round(data.getCol6(), 2);
			totallinea_wetlaptonsproduced+=	CommonUtil.round(data.getCol7(), 2);
			totallinea_yield+=	CommonUtil.round(((data.getCol6() + data.getCol7()) / data.getCol9()) * 100, 2);
			totallinea_wastepaperfed+=	CommonUtil.round(data.getCol9(), 2);
			totallinea_ofbatchesfedshiftgoal16+=	CommonUtil.round(data.getCol10(), 2);
			totallineb_tonsproducedtothetubeconveyor+=	CommonUtil.round(data.getCol6b(), 2);
			totallineb_wetlaptonsproduced+=	CommonUtil.round(data.getCol7b(), 2);
			totallineb_yield+=	CommonUtil.round(((data.getCol6b() + data.getCol7b()) / data.getCol9b()) * 100, 2);
			totallineb_wastepaperfed+=	CommonUtil.round(data.getCol9b(), 2);
			totallineb_ofbatchesfedshiftgoal16+=	CommonUtil.round(data.getCol10b(), 2);
			row++;				
		}
		col=0;
		util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row, col++,CommonUtil.round(totaldeinkwwpump431_ft_6875/1440,2),Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,CommonUtil.round(totalwatertofiremillwatertank430_ft_6956/1440,2),Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,CommonUtil.round(totalfiresystemwater430_ft_6959/1440,2),Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,CommonUtil.round(totaldeinkingplanteffluent431_ft_6083/1440,2),Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,CommonUtil.round(totalsewerflow_430_fi_7020/1440,2),Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row, col++,totallinea_tonsproducedtothetubeconveyor,Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,totallinea_wetlaptonsproduced,Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row, col++,totallinea_wastepaperfed,Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,totallinea_ofbatchesfedshiftgoal16,Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row, col++,totallineb_tonsproducedtothetubeconveyor,Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,totallineb_wetlaptonsproduced,Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row, col++,totallineb_wastepaperfed,Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,totallineb_ofbatchesfedshiftgoal16,Workbook2007Util.Style.STYLE_NORMAL_CENTER_GrayColor, rowHeight);
		util.addValue(row, col++,"",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		
		int h=row+3;
		row=h;
		col=1;
		util.addValue(row, col,"WATER", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 12);
		util.addValue(row, col,"DEINK W.W. PUMP 4 3 1 - FT -6875", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"WATER TO FIRE/MILL WATER TANK 430-FT-6956", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"FIRE SYSTEM WATER 430-FT-6959", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"DEINKING PLANT EFFLUENT 431-FT-6083", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"SEWER FLOW	430-FI-7020", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 12);
		util.addValue(row, col,"LINE A", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 12);
		util.addValue(row, col,"LINE A-TONS PRODUCED TO� THE TUBE CONVEYOR", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"LINE A-WETLAP TONS PRODUCED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);		
		util.addValue(row, col,"LINE A-WASTE PAPER FED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"LINE A-# OF BATCHES FED Shift Goal 16", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"LINE A-YIELD", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 12);
		util.addValue(row, col,"LINE B", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 12);
		util.addValue(row, col,"LINE B-TONS PRODUCED TO� THE TUBE CONVEYOR", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);		
		util.addValue(row, col,"LINE B-WASTE PAPER FED", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"LINE B-# OF BATCHES FED Shift Goal 16", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"LINE B-YIELD", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 12);
		util.addValue(row, col,"Total waste Paper Fed", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"Total tons produced", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		util.addValue(row, col,"Total yield", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 1, 5);
		col=6;
		row=h;
		util.addValue(row++, col,"", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row,col,CommonUtil.round(totaldeinkwwpump431_ft_6875/1440,2)+" GPM",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 10);
		util.addValue(row,col,CommonUtil.round(totalwatertofiremillwatertank430_ft_6956/1440,2)+" GPM",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 10);
		util.addValue(row,col,CommonUtil.round(totalfiresystemwater430_ft_6959/1440,2)+" GPM",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 10);
		util.addValue(row,col,CommonUtil.round(totaldeinkingplanteffluent431_ft_6083/1440,2)+" GPM",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 10);
		util.addValue(row,col,CommonUtil.round(totalsewerflow_430_fi_7020/1440,2)+" GPM",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 10);
		util.addValue(row++, col,"", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);		
		util.addValue(row++, col,"", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row,col,totallinea_tonsproducedtothetubeconveyor+"  TPD",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);
		util.addValue(row,col,totallinea_wetlaptonsproduced+"  TPD",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);
		util.addValue(row,col,totallinea_wastepaperfed+"  TPD",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);
		util.addValue(row,col,totallinea_ofbatchesfedshiftgoal16+"  Batches",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);
		util.addValue(row,col,Math.round(totallinea_yield/2)+" %",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);
		util.addValue(row++, col,"", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);		
		util.addValue(row++, col,"", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row,col,totallineb_tonsproducedtothetubeconveyor+"  TPD",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);		
		util.addValue(row,col,CommonUtil.round(totallineb_wastepaperfed,2)+"  TPD",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);
		util.addValue(row,col,CommonUtil.round(totallineb_ofbatchesfedshiftgoal16,0)+"  Batches",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);
		util.addValue(row,col,Math.round(totallineb_yield/2)+" %",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);
		util.addValue(row++, col,"", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.addValue(row,col,CommonUtil.round(totallinea_tonsproducedtothetubeconveyor+totallineb_tonsproducedtothetubeconveyor,2),Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);
		util.addValue(row,col,CommonUtil.round(totallinea_wastepaperfed+totallineb_wastepaperfed,2),Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);
		float yield=(totallinea_yield/2+totallineb_yield/2)/2;
		util.addValue(row,col,Math.round(yield)+" %",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 6, 12);
		
		col=11;
		row=h;
		util.addValue(row++, col,"", Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		
		util.addValue(row,col,CommonUtil.round(totaldeinkwwpump431_ft_6875/1000000,2)+" MGD",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 11, 12);
		util.addValue(row,col,CommonUtil.round(totalwatertofiremillwatertank430_ft_6956/1000000,2)+" MGD",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 11, 12);
		util.addValue(row,col,CommonUtil.round(totalfiresystemwater430_ft_6959/1000000,2)+" MGD",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 11, 12);
		util.addValue(row,col,CommonUtil.round(totaldeinkingplanteffluent431_ft_6083/1000000,2)+" MGD",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 11, 12);
		util.addValue(row,col,CommonUtil.round(totalsewerflow_430_fi_7020/1000000,2)+" MGD",Workbook2007Util.Style.STYLE_NORMAL_CENTER_ORANGE, rowHeight);
		util.mergeCellwithoutBorder(row,row++, 11, 12);
		util.write(outputStream);
	}

}
