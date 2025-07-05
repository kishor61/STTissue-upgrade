/**
 *Jan 17, 2015
 *FrpPressQualityReportHandler.java
 * TODO
 *com.st.frppressquality.report
 *FrpPressQualityReportHandler.java
 *Sunil Singh Bora
 */
package com.st.frppressquality.report;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.FrpCommon;
import com.st.common.Workbook2007Util;
import com.st.frppressquality.model.FrpDailyData;
import com.st.frppressquality.model.SludgeHauling;
import com.st.frppressquality.model.StickiesData;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;

/**
 * @author sbora
 *
 */
@Component
public class FrpPressQualityReportHandler {

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	/**
	 * @param sludgeHaulings
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createSludgeHaulingReport(List<SludgeHauling> sludgeHaulings,
			OutputStream outputStream) throws Exception {

		Workbook2007Util util = new Workbook2007Util();

		short rowHeight = 280;
		int row=0;
		int col=0;
		
		util.addValue(row, col++, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Sludge Hauled (lbs)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Sludge Consistency", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		//Code Starts From Here Done By Roshan Tailor Date :- 03/21/2016
		util.addValue(row, col++, "Effluent Consistency", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		//Code Ends Here Done By Roshan Tailor Date :- 03/21/2016
		util.addValue(row, col++, "Rejects Bunker Waste Hauled (Lbs)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Rejects Bunker Waste Consistency", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "FRP Sludge Press Running", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "FRP Screw Press Running", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "COD Discharge", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		for (SludgeHauling sludgeHauling : sludgeHaulings) {
			row++;
			col=0;
			util.addValue(row, col++, dateFormat.format(sludgeHauling.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.checkNull(FrpCommon.getPressQualityGrade().get(sludgeHauling.getGrade())), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, sludgeHauling.getSludgeHauled(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, sludgeHauling.getSludgeConsistency(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//Code Starts From Here Done BY Roshan Tailor Date :- 03/21/2016
			util.addValue(row, col++, sludgeHauling.getEffluentConsistency(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//Code Ends Here Done By Roshan Tailor Date ;- 03/21/2016
			util.addValue(row, col++, sludgeHauling.getRejectsBwHauled(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, sludgeHauling.getRejectsBwConsistency(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, FrpCommon.getYN().get(sludgeHauling.getFrpSludgePressRunning()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, FrpCommon.getYN().get(sludgeHauling.getFrpScrewPressRunning()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, sludgeHauling.getCoddischarge(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		
		
		for (int i = 0; i < 9; i++) {
			util.setAutoSizeColumn(i);
		}
		util.write(outputStream);

	}
	/**
	 * @param dailyDatas
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createFrpDailyReport(List<FrpProdcutionOperatorDataEntry> details,
			List<FrpProdcutionOperatorDataEntry> aavg,
			List<FrpProdcutionOperatorDataEntry> bavg,
			List<FrpProdcutionOperatorDataEntry> cavg,
			List<FrpProdcutionOperatorDataEntry> davg,
			OutputStream outputStream) throws Exception {
		
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
		util.addValue(row, col++,"LINE A-TONS PRODUCED TO� THE TUBE CONVEYOR", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
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
		
		
		
		row=1;
		
		for(FrpProdcutionOperatorDataEntry data:details){
			col=0;
			lastcol=1;
			
				
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
	/**
	 * @param dailyDatas
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createFrpMonthlyReport(List<FrpDailyData> dailyDatas,
			ServletOutputStream outputStream) throws Exception {
		Workbook2007Util util = new Workbook2007Util();

		short rowHeight = 280;
		int row=0;
		int col=0;
		double total=0;
		
		/*util.addValue(row, col++, "Grade", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, CommonUtil.checkNull(frpDailyData.getGrade()), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		}
		row++;col=0;*/
		
		
		util.addValue(row, col++, "Date", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, CommonUtil.checkNull(frpDailyData.getDate()), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		}
		
		row++;
		util.addValue(row, 0, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(row, row, 0, dailyDatas.size()+1);
		
		row++;col=0;
		total=0;
		util.addValue(row, col++, "Wastepaper Fed (ADT, Off DCS)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getWastepaperFed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getWastepaperFed();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
	
		
		row++;col=0;total=0;
		util.addValue(row, col++, "Wastepaper Fed (BDST)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getWastepaperFedBDST(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getWastepaperFedBDST();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		row++;col=0;
		total=0;
		util.addValue(row, col++, "Total Production (ADT, off DCS)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getTotalProduction(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getTotalProduction();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		row++;col=0;
		total=0;
		util.addValue(row, col++, "Total Production (BDST)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getTotalProductionBDST(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getTotalProductionBDST();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		row++;col=0;
		total=0;
		util.addValue(row, col++, "Sludge Hauled (lbs)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getSludgeHauled(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getSludgeHauled();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		row++;col=0;
		total=0;
		util.addValue(row, col++, "Sludge Consistency", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getSludgeConsistency(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getSludgeConsistency();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		row++;col=0;
		total=0;
		util.addValue(row, col++, "Sludge Hauled (Lbs Solids)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getSludgeHauledLBS(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getSludgeHauledLBS();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		row++;col=0;
		total=0;
		util.addValue(row, col++, "Sludge Hauled (BDST)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getSludgeHauledBDST(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getSludgeHauledBDST();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		row++;col=0;
		total=0;
		util.addValue(row, col++, "Rejects Bunker Waste Hauled (Lbs)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getRejectsBwHauled(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getRejectsBwHauled();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		
		row++;col=0;total=0;
		util.addValue(row, col++, "Rejects Bunker Waste Consistency", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getRejectsBwConsistency(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getRejectsBwConsistency();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		row++;col=0;total=0;
		util.addValue(row, col++, "Rejects Bunker Waste Hauled (Lbs Solids)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getRejectsBwHauledLBS(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getRejectsBwHauledLBS();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		
		row++;col=0;total=0;
		util.addValue(row, col++, "Rejects Bunker Waste Hauled (BDST)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getRejectsBwHauledBDST(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getRejectsBwHauledBDST();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		row++;
		util.addValue(row, 0, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(row, row, 0, dailyDatas.size()+1);
		
		
		row++;col=0;total=0;
		util.addValue(row, col++, "Total Solids Sent to IP Clarifier (BDST)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getTotalSolidsSentToIP(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getTotalSolidsSentToIP();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		row++;
		util.addValue(row, 0, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.mergeCell(row, row, 0, dailyDatas.size()+1);
		
		
		
		
		row++;col=0;total=0;
		util.addValue(row, col++, "IP Sludge Consistency Results (%)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getStIpSludgeConsistency(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getStIpSludgeConsistency();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		
		row++;col=0;total=0;
		util.addValue(row, col++, "ST Consistency Results (%)", Workbook2007Util.Style.STYLE_BOLD_LEFT, rowHeight);
		for (FrpDailyData frpDailyData : dailyDatas) {
			util.addValue(row, col++, frpDailyData.getStSludgeConsistency(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			total+=frpDailyData.getStSludgeConsistency();
		}
		util.addValue(row, col++, CommonUtil.round(total, 2), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
	
		
		
		for (int i = 0; i < dailyDatas.size()+2; i++) {
			util.setAutoSizeColumn(i);
		}
		
		util.write(outputStream);
		
	}
	/**
	 * @param dailyDatas
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createFiberBalanceReport(List<FrpDailyData> dailyDatas,
			OutputStream outputStream) throws Exception {
		
		Workbook2007Util util = new Workbook2007Util();

		short rowHeight = 280;
		int row=0;
		int col=0;
		
		util.addValue(row, col++, "Date", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "FRP Waste Paper Feed", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		col++;
		col++;
		util.addValue(row, col++, "Machine Production", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		col++;
		col++;
		util.addValue(row, col++, "Reel Slab/ wetlap", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Wet Lap Produced", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "M/c Sewer Loss", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "M/c Fiber To FRP", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "FRP Drain solids to IP", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Total drain solids", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Reject Bunker Sludge", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Sludge Hauled", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Total Sludge", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		util.mergeCell(0, 1, 0, 0);
		
		util.mergeCell(0, 0, 1, 3);
		
		util.mergeCell(0, 0, 4, 6);
		
		col=1;
		row++;
		
		util.addValue(row, col++, "ADST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "BDST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "ADST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "BDST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "BDST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "BDST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "BDST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "BDST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "BDST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "BDST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "BDST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "BDST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "BDST", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);

		
		for (FrpDailyData frpDailyData : dailyDatas) {
			col=0;
			row++;
			util.addValue(row, col++, frpDailyData.getDate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, frpDailyData.getWastepaperFed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, 90, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, frpDailyData.getWastepaperFedBDST(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, frpDailyData.getWrapperTon(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, 96, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, frpDailyData.getWrapperTonBDST(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, frpDailyData.getProdSlabOff(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, frpDailyData.getWetLapProd(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++,frpDailyData.getSewerLoss() , Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, frpDailyData.getFiberToFrp(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, frpDailyData.getTotalSolidsSentToIP(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(frpDailyData.getTotalSolidsSentToIP()+frpDailyData.getFiberToFrp()+frpDailyData.getSewerLoss(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, frpDailyData.getRejectsBwHauledBDST(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, frpDailyData.getSludgeHauledBDST(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(frpDailyData.getRejectsBwHauledBDST()+frpDailyData.getSludgeHauledBDST(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
		}
		
		
		for (int i = 0; i < 16; i++) {
			util.setAutoSizeColumn(i);
		}
		util.write(outputStream);
	}
	/**
	 * @param stickiesData
	 * @param outputStream
	 */
	public void createStickiesDataReport(List<StickiesData> stickiesData, ServletOutputStream outputStream) {
		// TODO Auto-generated method stub
		
	}
	
	

}
