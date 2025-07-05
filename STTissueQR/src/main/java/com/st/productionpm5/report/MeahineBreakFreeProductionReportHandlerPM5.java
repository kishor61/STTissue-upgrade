/**
 *Aug 30, 2016
 *MeahineBreakFreeProductionReport.java
 * TODO
 *com.st.production.report
 *MeahineBreakFreeProductionReport.java
 *Roshan Lal Tailor
 */
package com.st.productionpm5.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;
import com.st.production.model.MachineProduction;
import com.st.productionpm5.model.MachineProductionPM5;


/**
 * @author roshan
 *
 */
@Component
public class MeahineBreakFreeProductionReportHandlerPM5 {

	/**
	 * @param data
	 * @param outputStream
	 */
	SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	public void createReport(List<MachineProductionPM5> data,File file, ServletOutputStream outputStream) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Frp Prodcution Operator Data Entry Report", 0);

		short rowHeight = 280;
		int row=3;
		int col=0;
		for(MachineProductionPM5 datas:data){
			col=0;
			
			
			util.addValue(row, col++, dateFormat.format(datas.getDateEntered()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, datas.getShift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, datas.getRollID(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, datas.getGradeCode(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, datas.getTotalrollsproduce(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, datas.getNumberofrollswithbreaks(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, datas.getPercentageofrollswithbreaks(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			row++;	
		}
	
		util.write(outputStream);
	}

	/**
	 * @param data
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createReportAuto(List<MachineProductionPM5> data,FileOutputStream outputStream) throws IOException {
		
		Workbook2007Util util = new Workbook2007Util();
		util.setSheetName("ST Tissue FRP-MTD Daily Production Report", 0);

		short rowHeight = 280;
		short rowHeight1 = 900;
		int row=0;
		int col=0;
		util.addValue(row, col++,"Date", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Shift", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Roll Id", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Grade Code", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Total Rolls Produce", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Breaks", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		util.addValue(row, col++,"Breaks Free %", Workbook2007Util.Style.STYLE_NORMAL_CENTER_SkyColor, rowHeight1);
		
		row=1;
		for(MachineProductionPM5 datas:data){
			col=0;
			
			
			util.addValue(row, col++, dateFormat.format(datas.getDateEntered()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, datas.getShift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, datas.getRollID(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, datas.getGradeCode(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, datas.getTotalrollsproduce(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, datas.getNumberofrollswithbreaks(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, datas.getPercentageofrollswithbreaks(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			row++;	
		}
		
		util.write(outputStream);
	}

}
