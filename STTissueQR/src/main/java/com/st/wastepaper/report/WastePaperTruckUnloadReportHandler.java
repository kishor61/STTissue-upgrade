package com.st.wastepaper.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastePaperTruckUnload;

@Component
public class WastePaperTruckUnloadReportHandler {

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat2=new SimpleDateFormat("hh:mm:ss a");
	public void getUnloadTrucksReport(List<WastePaperTruckUnload> unloadtrucksdata, String flag,File file, ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("Waste Paper-Trucks Unload Detail Report", 0);
		
		short rowHeight = 280;
		int row=2;
		int col=0;
		int lastcol=0;
		
		int totalUT=0;
		int totalbales=0;
		double totalweight=0;
		double totalweightton=0;
		
		int totalforday=0;
		int totalfornight=0;
		int totalinaday=0;
		
		for(WastePaperTruckUnload tudata:unloadtrucksdata){
			col=0;
			lastcol=1;
			
			/*util.addValue(row, col++, dateFormat.format(tudata.getUnloaddate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getTruckcount(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, dateFormat2.format(tudata.getUnloaddatetime()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getRelease(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getTrailer(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getGrade(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getBales(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, CommonUtil.round(tudata.getWeight()/2000, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getVandor(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getVandornumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getUnloadcomment(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				
			int ut=tudata.getTruckcount();
			int bales=tudata.getBales();
			double weight=tudata.getWeight();
			double weightTon=tudata.getWeight()/2000;
			
			totalUT=totalUT+ut;
			totalbales=totalbales+bales;
			totalweight=totalweight+weight;
			totalweightton=totalweightton+weightTon;*/
			util.addValue(row, col++, dateFormat.format(tudata.getUnloaddate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getDayshifttrucks(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getNightshifttrucks(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, tudata.getTruckcount(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			
			
			totalforday=totalforday+tudata.getDayshifttrucks();
			totalfornight=totalfornight+tudata.getNightshifttrucks();
			totalinaday=totalinaday+tudata.getTruckcount();
			
			row++;
		}
		lastcol=0;
		{
			/*util.addValue(row, lastcol++, "Total:", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, lastcol++, totalUT, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, lastcol++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, lastcol++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, lastcol++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, lastcol++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, lastcol++, totalbales, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, lastcol++, totalweight, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, lastcol++, totalweightton, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, lastcol++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, lastcol++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, lastcol++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);*/
			util.addValue(row, lastcol++, "Total:", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, lastcol++, totalforday, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			util.addValue(row, lastcol++, totalfornight, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, lastcol++, totalinaday, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		}
		util.write(outputStream);
	}

}
