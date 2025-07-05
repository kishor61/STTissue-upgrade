/**
 *Dec 4, 2014
 *UtilityKpiMasterReportHandler.java
 * TODO
 *com.st.utilitykpimaster.report
 *UtilityKpiMasterReportHandler.java
 *Sunil Singh Bora
 */
package com.st.utilitykpimaster.report;

import java.awt.Color;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.pdfutil.PdfReportUtil;
import com.st.common.pdfutil.PdfReportUtil.Section;
import com.st.common.pdfutil.PdfReportUtil.Table;
import com.st.common.pdfutil.PdfStyle;

/**
 * @author sbora
 *
 */
@Component
public class UtilityKpiMasterReportHandler {

	
	
	/**
	 * @param datas
	 * @param eDate 
	 * @param recordableDate 
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createKpiPdf(List<Map<String, String>> datas,
			Date recordableDate, Date eDate, OutputStream outputStream) throws Exception {
	
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd");
		
		int days=0;
		if(recordableDate!=null){
			days=CommonUtil.getDaysDiffernce(recordableDate, eDate);
		}
		
		
		PdfReportUtil pdfUtil=new PdfReportUtil(15f,15f,10f,10f);
		
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("KPI Report");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_LANDSCAPE);
		pdfUtil.open();
		
		
		
		Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addText("PULP AND UTILITY CONSUMPTION REPORT Of PM6", PdfStyle.FONT_BOLD_UNDERLINE_12);
		header.addText("\n", PdfStyle.FONT_NORMAL_10);
		header.finish();
		
		float cmL=1;
		float cmR=1;
		float cmT=4;
		float cmB=4;
		
		Table table=pdfUtil.new Table(29, new float[]{1.5f,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
		table.setCommonHeader(true, 4);
		//Table Header Row1
		
		table.addCell("DAILY KPI's", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 11, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell("Last Recordable:", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 9, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell(recordableDate!=null?dateFormat.format(recordableDate):"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell("Days since Last Recordable", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 5, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell(days+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell("Date:", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell(eDate!=null?dateFormat.format(eDate):"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		
		//Table Header Row2
		table.addCell("\nDate", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 3,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Machine Produciton", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 2, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Wrapper Production", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 4, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Efficiency", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 4, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Mill water", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 2, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		//
		table.addCell("River water", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 2, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Water Consumption", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		//
		table.addCell("Fiberloss ", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 4, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		table.addCell("Energy Consumption ", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 3, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		/*table.addCell("60# Steam", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 2,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("150 #Steam", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 2,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gas Flow", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 2,cmL,cmR,cmT,cmB,new Color(255,250,240));*/
		table.addCell("Cond Recovery", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 2,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Energy Consumption", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 5, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		//Table Header Row3				
		table.addCell("Actual", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Slaboff", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("White", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Red", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Reject", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Uptime", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Quality", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Yield", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Specific", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gal/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		
		table.addCell("TM Sewer", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		/*table.addCell("FRP", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));*/
		table.addCell("FRP Effluent", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("COD Discharge", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		table.addCell("60# Steam", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("150 #Steam", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Natural Gas", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		
		
		
		table.addCell("60#", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("150#", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gas", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Elect", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		
		
		//Table Header Row4	
		table.addCell("Tons", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 6, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("%", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 4, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("M Gal", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gal/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		//
		table.addCell("M Gal", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gal/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gal/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		//
		table.addCell("T/day", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 3, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("lbs/day", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("lbs/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("lbs/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Kscf/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("%", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("kW/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 5, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		int TOTAL=datas.size()==0?1:datas.size();
		double TOTAL_02=0;
		double TOTAL_03=0;
		double TOTAL_04=0;
		double TOTAL_05=0;
		double TOTAL_06=0;
		double TOTAL_07=0;
		/*double TOTAL_08=0;
		double TOTAL_09=0;
		double TOTAL_10=0;
		double TOTAL_11=0;*/
		double TOTAL_12=0;
		double TOTAL_13=0;
		double TOTAL_14=0;
		double TOTAL_15=0;
		double TOTAL_16=0;
		double TOTAL_17=0;
		double TOTAL_18=0;
		double TOTAL_19=0;
		double TOTAL_20=0;
		double TOTAL_21=0;
		double TOTAL_22=0;
		double TOTAL_23=0;
		double TOTAL_24=0;//Downtime
		
		double TOTAL_27=0;
		
		double TOTAL_41=0;
		double TOTAL_42=0;
		double TOTAL_COD=0;
		
		for (Map<String, String> map : datas) {
			table.addCell(map.get(ColumnsOfTable.COL_01).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_02).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_03).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_04).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_05).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_06).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_07).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_08).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_09).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_10).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_11).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_27).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_12).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			//
			
			if( map.get(ColumnsOfTable.COL_31)==null){
				table.addCell("0", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}else{
				table.addCell(map.get(ColumnsOfTable.COL_31).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}
			if( map.get(ColumnsOfTable.COL_32)==null){
				table.addCell("0", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}else{
				table.addCell(map.get(ColumnsOfTable.COL_32).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}
			
			//
			if(map.get(ColumnsOfTable.COL_12)==null || map.get(ColumnsOfTable.COL_32)==null){
				table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}else{
				double TotalWaterConsumption = CommonUtil.round(Double.parseDouble(map.get(ColumnsOfTable.COL_12))+Double.parseDouble(map.get(ColumnsOfTable.COL_32)), 0);
				table.addCell(""+TotalWaterConsumption, PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}
			//
			table.addCell(map.get(ColumnsOfTable.COL_13).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			/*table.addCell(map.get(ColumnsOfTable.COL_14).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);*/ //FRP
			//
			table.addCell(map.get(ColumnsOfTable.COL_30).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			//
			double frptotal = CommonUtil.round(Double.parseDouble(map.get(ColumnsOfTable.COL_13))+Double.parseDouble(map.get(ColumnsOfTable.COL_30)), 2);
			
			
			table.addCell(Double.toString(frptotal), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			
			table.addCell(map.get(ColumnsOfTable.COL_33).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			
			//
			
			table.addCell(map.get(ColumnsOfTable.COL_15).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_16).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_17).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_18).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_19).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_20).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_21).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_22).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_23).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			
			TOTAL_02+=Double.parseDouble(map.get(ColumnsOfTable.COL_02).toString());
			TOTAL_03+=Double.parseDouble(map.get(ColumnsOfTable.COL_03).toString());
			TOTAL_04+=Double.parseDouble(map.get(ColumnsOfTable.COL_04).toString());
			TOTAL_05+=Double.parseDouble(map.get(ColumnsOfTable.COL_05).toString());
			TOTAL_06+=Double.parseDouble(map.get(ColumnsOfTable.COL_06).toString());
			TOTAL_07+=Double.parseDouble(map.get(ColumnsOfTable.COL_07).toString());
/*			TOTAL_08+=Double.parseDouble(map.get(ColumnsOfTable.COL_08).toString());
			TOTAL_09+=Double.parseDouble(map.get(ColumnsOfTable.COL_09).toString());
			TOTAL_10+=Double.parseDouble(map.get(ColumnsOfTable.COL_10).toString());
			TOTAL_11+=Double.parseDouble(map.get(ColumnsOfTable.COL_11).toString());*/
			
			TOTAL_12+=Double.parseDouble(map.get(ColumnsOfTable.COL_12).toString());
			TOTAL_13+=Double.parseDouble(map.get(ColumnsOfTable.COL_13).toString());
			/*TOTAL_14+=Double.parseDouble(map.get(ColumnsOfTable.COL_14).toString());*/
			TOTAL_14+=Double.parseDouble(map.get(ColumnsOfTable.COL_30).toString());
			TOTAL_15+=Double.parseDouble(map.get(ColumnsOfTable.COL_15).toString());
			TOTAL_16+=Double.parseDouble(map.get(ColumnsOfTable.COL_16).toString());
			TOTAL_17+=Double.parseDouble(map.get(ColumnsOfTable.COL_17).toString());
			TOTAL_18+=Double.parseDouble(map.get(ColumnsOfTable.COL_18).toString());
			TOTAL_19+=Double.parseDouble(map.get(ColumnsOfTable.COL_19).toString());
			TOTAL_20+=Double.parseDouble(map.get(ColumnsOfTable.COL_20).toString());
			TOTAL_21+=Double.parseDouble(map.get(ColumnsOfTable.COL_21).toString());
			TOTAL_22+=Double.parseDouble(map.get(ColumnsOfTable.COL_22).toString());
			TOTAL_23+=Double.parseDouble(map.get(ColumnsOfTable.COL_23).toString());
			TOTAL_24+=Double.parseDouble(map.get(ColumnsOfTable.COL_24).toString());
			
			TOTAL_27+=Double.parseDouble(map.get(ColumnsOfTable.COL_27).toString());
			
			TOTAL_41+=Double.parseDouble(map.get(ColumnsOfTable.COL_13))+Double.parseDouble(map.get(ColumnsOfTable.COL_30));
			
			if(map.get(ColumnsOfTable.COL_12)==null || map.get(ColumnsOfTable.COL_32)==null){
				TOTAL_42+=0;
			}else{
				TOTAL_42+=Double.parseDouble(map.get(ColumnsOfTable.COL_12))+Double.parseDouble(map.get(ColumnsOfTable.COL_32));
			}
			
			
			TOTAL_COD+=Double.parseDouble(map.get(ColumnsOfTable.COL_33).toString());
		}
		
		{
			table.addCell("Avg/Day", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_02/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_03/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_04/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_05/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_06/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_07/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_27/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_12/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			//
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_42/TOTAL,0)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			//
			table.addCell(CommonUtil.round(TOTAL_13/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_14/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			
			table.addCell(CommonUtil.round(TOTAL_41/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_COD/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245)); //COD_Discharge
			//
			/*table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));*/
			//
			table.addCell(CommonUtil.round(TOTAL_15/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_16/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_17/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_18/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_19/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_20/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_21/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_22/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_23/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
		}
		{
			
			double uptime=0;
			if(TOTAL>0){
				uptime=((1440*TOTAL)-TOTAL_24)/(1440*TOTAL);
			}
			
			double yield=0;
			if(TOTAL_02!=0){
				yield=(TOTAL_07/TOTAL_02);
			}
			
			double quality=0;
			if(TOTAL_07!=0){
				quality=(TOTAL_04/TOTAL_07);
			}
			
			double efficiency=uptime*yield*quality;
			
			
			table.addCell("Total", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_02, 2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_03,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_04,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_05,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_06,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_07,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(uptime*100, 2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(quality*100, 2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(yield*100, 2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(efficiency*100, 2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_27,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_12,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			//
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_42,0)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			//
			table.addCell(CommonUtil.round(TOTAL_13,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_14,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_41,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			
			table.addCell(CommonUtil.round(TOTAL_COD,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));//COD
			//
			/*table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));*/
			//
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
		}
		
		table.finish();
		
		pdfUtil.close();
	}

	/**
	 * @param datas
	 * @param recordableDate
	 * @param eDate
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createKpiPdf_PM5(List<Map<String, String>> datas,
			Date recordableDate, Date eDate, ServletOutputStream outputStream) throws Exception {
	
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd");
		
		int days=0;
		if(recordableDate!=null){
			days=CommonUtil.getDaysDiffernce(recordableDate, eDate);
		}
		
		
		PdfReportUtil pdfUtil=new PdfReportUtil(15f,15f,10f,10f);
		
		pdfUtil.setOuputStream(outputStream);
		pdfUtil.setDocumentTitle("KPI Report-PM5");
		pdfUtil.setPage(PdfStyle.PAGE_LEGAL_LANDSCAPE);
		pdfUtil.open();
		
		
		
		Section header=pdfUtil.new Section(10, 10, PdfStyle.ALIGN_CENTER);
		header.addText("PULP AND UTILITY CONSUMPTION REPORT Of PM5", PdfStyle.FONT_BOLD_UNDERLINE_12);
		header.addText("\n", PdfStyle.FONT_NORMAL_10);
		header.finish();
		
		float cmL=1;
		float cmR=1;
		float cmT=4;
		float cmB=4;
		
		Table table=pdfUtil.new Table(29, new float[]{1.5f,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
		table.setCommonHeader(true, 4);
		//Table Header Row1
		
		table.addCell("DAILY KPI's", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 11, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell("Last Recordable:", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 9, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell(recordableDate!=null?dateFormat.format(recordableDate):"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell("Days since Last Recordable", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 5, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell(days+"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell("Date:", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		table.addCell(eDate!=null?dateFormat.format(eDate):"", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(230,230,250));
		
		//Table Header Row2
		table.addCell("\nDate", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 1, 3,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Machine Produciton", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 2, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Wrapper Production", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 4, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Efficiency", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 4, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Mill water", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 2, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		//
		table.addCell("River water", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 2, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Water Consumption", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		//
		table.addCell("Fiberloss ", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 4, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		table.addCell("Energy Consumption ", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 3, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		/*table.addCell("60# Steam", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 2,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("150 #Steam", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 2,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gas Flow", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 2,cmL,cmR,cmT,cmB,new Color(255,250,240));*/
		table.addCell("Cond Recovery", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 2,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Energy Consumption", PdfStyle.FONT_BOLD_8, PdfStyle.ALIGN_CENTER, 5, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		//Table Header Row3				
		table.addCell("Actual", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Slaboff", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("White", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Red", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Reject", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Uptime", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Quality", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Yield", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Specific", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gal/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		
		table.addCell("TM Sewer", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		/*table.addCell("FRP", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));*/
		table.addCell("FRP Effluent", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("COD Discharge", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		table.addCell("60# Steam", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("150 #Steam", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Natural Gas", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		
		
		
		table.addCell("60#", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("150#", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gas", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Elect", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Total", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		
		
		//Table Header Row4	
		table.addCell("Tons", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 6, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("%", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 4, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("M Gal", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gal/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		//
		table.addCell("M Gal", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gal/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Gal/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		//
		table.addCell("T/day", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 3, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("lbs/day", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("lbs/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("lbs/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("Kscf/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("%", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		table.addCell("kW/T", PdfStyle.FONT_BOLD_6, PdfStyle.ALIGN_CENTER, 5, 1,cmL,cmR,cmT,cmB,new Color(255,250,240));
		
		int TOTAL=datas.size()==0?1:datas.size();
		double TOTAL_02=0;
		double TOTAL_03=0;
		double TOTAL_04=0;
		double TOTAL_05=0;
		double TOTAL_06=0;
		double TOTAL_07=0;
		/*double TOTAL_08=0;
		double TOTAL_09=0;
		double TOTAL_10=0;
		double TOTAL_11=0;*/
		double TOTAL_12=0;
		double TOTAL_13=0;
		double TOTAL_14=0;
		double TOTAL_15=0;
		double TOTAL_16=0;
		double TOTAL_17=0;
		double TOTAL_18=0;
		double TOTAL_19=0;
		double TOTAL_20=0;
		double TOTAL_21=0;
		double TOTAL_22=0;
		double TOTAL_23=0;
		double TOTAL_24=0;//Downtime
		
		double TOTAL_27=0;
		
		double TOTAL_41=0;
		double TOTAL_42=0;
		double TOTAL_COD=0;
		
		for (Map<String, String> map : datas) {
			table.addCell(map.get(ColumnsOfTable.COL_01).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_02).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_03).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_04).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_05).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_06).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_07).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_08).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_09).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_10).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_11).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_27).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_12).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			//
			
			if( map.get(ColumnsOfTable.COL_31)==null){
				table.addCell("0", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}else{
				table.addCell(map.get(ColumnsOfTable.COL_31).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}
			if( map.get(ColumnsOfTable.COL_32)==null){
				table.addCell("0", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}else{
				table.addCell(map.get(ColumnsOfTable.COL_32).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}
			
			//
			if(map.get(ColumnsOfTable.COL_12)==null || map.get(ColumnsOfTable.COL_32)==null){
				table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}else{
				double TotalWaterConsumption = CommonUtil.round(Double.parseDouble(map.get(ColumnsOfTable.COL_12))+Double.parseDouble(map.get(ColumnsOfTable.COL_32)), 0);
				table.addCell(""+TotalWaterConsumption, PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			}
			//
			table.addCell(map.get(ColumnsOfTable.COL_13).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			/*table.addCell(map.get(ColumnsOfTable.COL_14).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);*/ //FRP
			//
			table.addCell(map.get(ColumnsOfTable.COL_30).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			//
			double frptotal = CommonUtil.round(Double.parseDouble(map.get(ColumnsOfTable.COL_13))+Double.parseDouble(map.get(ColumnsOfTable.COL_30)), 2);
			
			
			table.addCell(Double.toString(frptotal), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			
			table.addCell(map.get(ColumnsOfTable.COL_33).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			
			//
			
			table.addCell(map.get(ColumnsOfTable.COL_15).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_16).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_17).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_18).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_19).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_20).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_21).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_22).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			table.addCell(map.get(ColumnsOfTable.COL_23).toString(), PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB);
			
			TOTAL_02+=Double.parseDouble(map.get(ColumnsOfTable.COL_02).toString());
			TOTAL_03+=Double.parseDouble(map.get(ColumnsOfTable.COL_03).toString());
			TOTAL_04+=Double.parseDouble(map.get(ColumnsOfTable.COL_04).toString());
			TOTAL_05+=Double.parseDouble(map.get(ColumnsOfTable.COL_05).toString());
			TOTAL_06+=Double.parseDouble(map.get(ColumnsOfTable.COL_06).toString());
			TOTAL_07+=Double.parseDouble(map.get(ColumnsOfTable.COL_07).toString());
/*			TOTAL_08+=Double.parseDouble(map.get(ColumnsOfTable.COL_08).toString());
			TOTAL_09+=Double.parseDouble(map.get(ColumnsOfTable.COL_09).toString());
			TOTAL_10+=Double.parseDouble(map.get(ColumnsOfTable.COL_10).toString());
			TOTAL_11+=Double.parseDouble(map.get(ColumnsOfTable.COL_11).toString());*/
			
			TOTAL_12+=Double.parseDouble(map.get(ColumnsOfTable.COL_12).toString());
			TOTAL_13+=Double.parseDouble(map.get(ColumnsOfTable.COL_13).toString());
			/*TOTAL_14+=Double.parseDouble(map.get(ColumnsOfTable.COL_14).toString());*/
			TOTAL_14+=Double.parseDouble(map.get(ColumnsOfTable.COL_30).toString());
			TOTAL_15+=Double.parseDouble(map.get(ColumnsOfTable.COL_15).toString());
			TOTAL_16+=Double.parseDouble(map.get(ColumnsOfTable.COL_16).toString());
			TOTAL_17+=Double.parseDouble(map.get(ColumnsOfTable.COL_17).toString());
			TOTAL_18+=Double.parseDouble(map.get(ColumnsOfTable.COL_18).toString());
			TOTAL_19+=Double.parseDouble(map.get(ColumnsOfTable.COL_19).toString());
			TOTAL_20+=Double.parseDouble(map.get(ColumnsOfTable.COL_20).toString());
			TOTAL_21+=Double.parseDouble(map.get(ColumnsOfTable.COL_21).toString());
			TOTAL_22+=Double.parseDouble(map.get(ColumnsOfTable.COL_22).toString());
			TOTAL_23+=Double.parseDouble(map.get(ColumnsOfTable.COL_23).toString());
			TOTAL_24+=Double.parseDouble(map.get(ColumnsOfTable.COL_24).toString());
			
			TOTAL_27+=Double.parseDouble(map.get(ColumnsOfTable.COL_27).toString());
			
			TOTAL_41+=Double.parseDouble(map.get(ColumnsOfTable.COL_13))+Double.parseDouble(map.get(ColumnsOfTable.COL_30));
			
			if(map.get(ColumnsOfTable.COL_12)==null || map.get(ColumnsOfTable.COL_32)==null){
				TOTAL_42+=0;
			}else{
				TOTAL_42+=Double.parseDouble(map.get(ColumnsOfTable.COL_12))+Double.parseDouble(map.get(ColumnsOfTable.COL_32));
			}
			
			
			TOTAL_COD+=Double.parseDouble(map.get(ColumnsOfTable.COL_33).toString());
		}
		
		{
			table.addCell("Avg/Day", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_02/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_03/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_04/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_05/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_06/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_07/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_27/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_12/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			//
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_42/TOTAL,0)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			//
			table.addCell(CommonUtil.round(TOTAL_13/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_14/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			
			table.addCell(CommonUtil.round(TOTAL_41/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_COD/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245)); //COD_Discharge
			//
			/*table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));*/
			//
			table.addCell(CommonUtil.round(TOTAL_15/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_16/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_17/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_18/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_19/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_20/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_21/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_22/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_23/TOTAL,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
		}
		{
			
			double uptime=0;
			if(TOTAL>0){
				uptime=((1440*TOTAL)-TOTAL_24)/(1440*TOTAL);
			}
			
			double yield=0;
			if(TOTAL_02!=0){
				yield=(TOTAL_07/TOTAL_02);
			}
			
			double quality=0;
			if(TOTAL_07!=0){
				quality=(TOTAL_04/TOTAL_07);
			}
			
			double efficiency=uptime*yield*quality;
			
			
			table.addCell("Total", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_02, 2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_03,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_04,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_05,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_06,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_07,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(uptime*100, 2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(quality*100, 2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(yield*100, 2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(efficiency*100, 2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_27,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_12,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			//
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_42,0)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			//
			table.addCell(CommonUtil.round(TOTAL_13,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_14,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell(CommonUtil.round(TOTAL_41,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			
			table.addCell(CommonUtil.round(TOTAL_COD,2)+"", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));//COD
			//
			/*table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));*/
			//
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
			table.addCell("", PdfStyle.FONT_NORMAL_8, PdfStyle.ALIGN_CENTER, 1, 1,cmL,cmR,cmT,cmB,new Color(245,245,245));
		}
		
		table.finish();
		
		pdfUtil.close();
	}

}
