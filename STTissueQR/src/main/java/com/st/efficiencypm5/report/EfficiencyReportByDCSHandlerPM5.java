/**
 *Nov 25, 2015
 *EfficiencyReportByDCSHandler.java
 * TODO
 *com.st.efficiency.report
 *EfficiencyReportByDCSHandler.java
 *Sunil Singh Bora
 */
package com.st.efficiencypm5.report;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.Workbook2007Util;
import com.st.efficiencypm5.model.EfficiencyShiftDataPM5;

/**
 * @author sbora
 *
 */
@Component
public class EfficiencyReportByDCSHandlerPM5 {

	/**
	 * @param datas
	 * @param datas1
	 * @param file
	 * @param outputStream
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public void getByEfficiencyDCSReportExport(List<EfficiencyShiftDataPM5> datas,
			List<EfficiencyShiftDataPM5> datas1, File file,
			ServletOutputStream outputStream) throws IOException, ParseException {
		
		Workbook2007Util util=new Workbook2007Util();
		util.setSheetName("Efficiency Summary By Shift DCS", 0);
		
		
		short rowHeight=280;
		int col=0;
		int row=1;
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		// TODO Auto-generated method stub
		
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
		util.addValue(row, 2, "Actual T/day By DCS", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 3, "Shift", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 4, "White T/day ", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 5, "Red T/day", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 6, "Reject T/day", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 7, "Total T/day", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 10, "Uptime   %", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 11, "Quality   %", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 12, "Yield       %", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, 13, "Eff. Total   %", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		rowHeight=280;

		for (EfficiencyShiftDataPM5 data : datas) {
			row++;
			col=0;
			/*<c:forEach items="${datas}" var="data">
			<tr>
				<td><fmt:formatDate value="${data.date}" pattern="MM/dd/yyyy" var="date1"/>${date1}</td>
				<%-- <td>${data.shift}</td> --%>
				<td>${data.crew}</td>
				<c:forEach items="${datas1}" var="data1" varStatus="status">
					<fmt:formatDate value="${data1.date}" pattern="MM/dd/yyyy" var="date2"/></td>
					<c:if test="${not (date1 eq date2)}">
						
						<c:if test="${data.shift ne data1.shift}">
										
						</c:if>		
					</c:if>
					<c:if test="${date1 eq date2}">
						<c:if test="${data.shift eq data1.shift}">
									<td>${data1.actualWt}</td>
									<td>${data1.shift}</td>
						</c:if>
					</c:if>
					
				</c:forEach>
				*/
				util.addValue(row, col++, dateFormat.format(data.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				for(EfficiencyShiftDataPM5 data1:datas1){
					if(data.getDate().compareTo(data1.getDate())!=0){
						
					}
					else if(data.getDate().compareTo(data1.getDate())==0){

		        		if(data.getShift().equalsIgnoreCase(data1.getShift())){
							util.addValue(row, col++, data1.getActualWt(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
							util.addValue(row, col++, data1.getShift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
						}else{
							
						}
		        	
					}
				
		}
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
			
			EfficiencyShiftDataPM5 data=new EfficiencyShiftDataPM5().total(datas);
			
			util.addValue(row, col++, "TOTAL", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		//	util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapWhite(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapRed(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapRej(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getWrapTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getVariance(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getVariancePer(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getUptime(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getQuality(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getYield(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, data.getEffTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
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
			
			EfficiencyShiftDataPM5 adata=new EfficiencyShiftDataPM5().totalA(datas);
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "A", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getWrapWhite(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getWrapRed(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getWrapRej(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getWrapTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getVariance(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getVariancePer(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getUptime(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getQuality(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getYield(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, adata.getEffTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
		{
			row++;
			col=0;
			
			EfficiencyShiftDataPM5 bdata=new EfficiencyShiftDataPM5().totalB(datas);
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "B", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getWrapWhite(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getWrapRed(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getWrapRej(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getWrapTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getVariance(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getVariancePer(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getUptime(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getQuality(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getYield(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, bdata.getEffTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
		{
			row++;
			col=0;
			
			EfficiencyShiftDataPM5 cdata=new EfficiencyShiftDataPM5().totalC(datas);
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "C", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getWrapWhite(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getWrapRed(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getWrapRej(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getWrapTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getVariance(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getVariancePer(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getUptime(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getQuality(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getYield(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, cdata.getEffTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
		{
			row++;
			col=0;
			
			EfficiencyShiftDataPM5 ddata=new EfficiencyShiftDataPM5().totalD(datas);
			
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "D", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getWrapWhite(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getWrapRed(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getWrapRej(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getWrapTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getVariance(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getVariancePer(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getUptime(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getQuality(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getYield(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, col++, ddata.getEffTotal(), Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		}
		util.write(outputStream);
}
	}
