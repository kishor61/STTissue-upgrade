/**
 *Dec 6, 2016
 *SCACoatingExcelExportHandler.java
 * TODO
 *com.st.qualitypm6.report
 *SCACoatingExcelExportHandler.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm6.report;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.springframework.stereotype.Component;

import com.st.common.Columns;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.qualitypm6.model.Reel;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Component
public class SCACoatingExcelExportHandler {

	/**
	 * @param datas
	 * @param file
	 * @param outputStream
	 * @throws IOException 
	 */
	public void getSCACoatingReportExcelFormat(List<Map<String, Object>> datas,
			File file, ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("ST_Tissue SCA Coating Report", 0);
		
		short rowHeight = 400;
		int row=8;
		int col=1;
		
		if(datas.size()>0){
			
			for(Map<String, Object> map:datas){
				col=0;
				if(map.get(ColumnsOfTable.COL_01).toString().equalsIgnoreCase("OBJECTIVES")){
				
					util.addValue(row, col++, map.get(ColumnsOfTable.COL_01).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, map.get(ColumnsOfTable.COL_03).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, map.get(ColumnsOfTable.COL_04).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_05).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, CommonUtil.checkDouble( map.get(ColumnsOfTable.COL_06).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, "N/A", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, "N/A", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, "N/A", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					util.addValue(row, col++, "N/A", Workbook2007Util.Style.STYLE_NORMAL_CENTER_BORDER_f5da81, rowHeight);
					
				}else{
					util.addValue(row, col++, map.get(ColumnsOfTable.COL_01).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					
					
					util.addValue(row, col++, map.get(ColumnsOfTable.COL_02).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					util.addValue(row, col++, map.get(ColumnsOfTable.COL_03).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					
					if(StringUtils.isNumeric(map.get(ColumnsOfTable.COL_04).toString())){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_04).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);	
					}else{
						util.addValue(row, col++, map.get(ColumnsOfTable.COL_04).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					}
					
					util.addValue(row, col++, map.get(ColumnsOfTable.COL_05).toString(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					
					if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("redcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("greencolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("yellowcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
					}else{
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_06).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					}
					
					if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("redcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("greencolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("yellowcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
					}else{
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_07).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					}
					
					if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("redcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("greencolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("yellowcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
					}else {
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_08).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					}
					
					if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("redcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("greencolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("yellowcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
					}else{
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_09).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					}
					
					if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("redcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("greencolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("yellowcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
					}else{
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_10).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					}
					
					if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("redcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("greencolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
					}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("yellowcolor")){
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
					}else{
						util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_11).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					}
					//
					util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_21).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					//
					double n1=(Double)map.get(ColumnsOfTable.COL_10);
					double n2=(Double)map.get(ColumnsOfTable.COL_21);
					util.addValue(row, col++, CommonUtil.round((n1/n2)*100, 2)+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					//
					double n3=(Double)map.get(ColumnsOfTable.COL_07);
					double n4=(Double)map.get(ColumnsOfTable.COL_06);
					util.addValue(row, col++, CommonUtil.round((n3/n4)*100, 2)+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
					//
					util.addValue(row, col++, CommonUtil.checkDouble(map.get(ColumnsOfTable.COL_27).toString()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
										
				}
				
				row++;
			}
		}
		util.write(outputStream);
	}

	
}
