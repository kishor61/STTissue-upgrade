/**
 *Sep 14, 2017
 *DownTimeAndLostTimeReportHandler.java
 * TODO
 *com.st.downtimeandlosttimereport.handler
 *DownTimeAndLostTimeReportHandler.java
 *Roshan Lal Tailor
 */
package com.st.downtimeandlosttimereport.handler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.downtimeandlosttimereport.model.DownTimeAndLostTimeReport;

/**
 * @author roshan
 *
 */
@Component
public class DownTimeAndLostTimeReportHandler {

	/**
	 * @param data
	 * @param file
	 * @param outputStream
	 * @throws IOException 
	 */
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	public void exportExcelReport(List<DownTimeAndLostTimeReport> dataS,
			File file, ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("DOWNTIME & LOST TIME REPORT", 0);
		short rowHeight = 280;
		int row=2;
		int col=0;
		
		double totalannualoutage=0;
		double totalbladechange=0;
		double totalboilout=0;
		double totalbreakbackedge=0;
		double totalbreakfrontedge=0;
		double totalbreakmiddle=0;
		double totalbreakatreel=0;
		double totalbreakatyankee=0;
		double totalcleanupwashup=0;
		double totalelectrical=0;
		double totalfeltwash=0;
		double totalfieldday=0;
		double totalfireatreel=0;
		double totalgradechange=0;
		double totalheadboxflushing=0;
		double totalheadboxsealfixing=0;
		double totalhoodfire=0;
		double totalinstrumentation=0;
		double totaljetslittertrimsadjustment=0;
		double totallackofair=0;
		double totallackofsteam=0;
		double totallackofstock=0;
		double totalmechanical=0;
		double totalmissedturnup=0;
		double totalnoemptyspool=0;
		double totalnowater=0;
		double totalpoweroutage=0;
		double totalscheduleclothingchange=0;
		double totalsmoldering=0;
		double totalsprayboomchange=0;
		double totalstartup=0;
		double totalstriptheYankee=0;
		double totalturnup=0;
		double totalunscheduledclothingchange=0;
		double grandTotalMins=0;
		double grandTotalReelTon=0;
		
		int loopcount=0;
		for(DownTimeAndLostTimeReport data : dataS)
		{
			
			col=0;
			util.addValue(row, col++, dateFormat.format(data.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getGradeCode(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalannualoutage(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalbladechange(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalboilout(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalbreakbackedge(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalbreakfrontedge(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalbreakmiddle(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalbreakatreel(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalbreakatyankee(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalcleanupwashup(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalelectrical(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalfeltwash(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalfieldday(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalfireatreel(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalgradechange(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalheadboxflushing(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalheadboxsealfixing(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalhoodfire(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalinstrumentation(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotaljetslittertrimsadjustment(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotallackofair(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotallackofsteam(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotallackofstock(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalmechanical(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalmissedturnup(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalnoemptyspool(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalnowater(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalpoweroutage(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalscheduleclothingchange(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalsmoldering(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalsprayboomchange(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalstartup(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalstriptheYankee(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalturnup(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalunscheduledclothingchange(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getTotalmin()+(data.getTotalhr()*60), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getReelton(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, data.getComments(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
					totalbladechange=totalbladechange+data.getTotalbladechange();
					totalboilout=totalboilout+data.getTotalboilout();
					totalbreakbackedge=totalbreakbackedge+data.getTotalbreakbackedge();
					totalbreakfrontedge=totalbreakfrontedge+data.getTotalbreakfrontedge();
					totalbreakmiddle=totalbreakmiddle+data.getTotalbreakmiddle();
					totalbreakatreel=totalbreakatreel+data.getTotalbreakatreel();
					totalbreakatyankee=totalbreakatyankee+data.getTotalbreakatyankee();
					totalcleanupwashup=totalcleanupwashup+data.getTotalcleanupwashup();
					totalelectrical=totalelectrical+data.getTotalelectrical();
					totalfeltwash=totalfeltwash+data.getTotalfeltwash();
					totalfieldday=totalfieldday+data.getTotalfieldday();
					totalfireatreel=totalfireatreel+data.getTotalfireatreel();
					totalgradechange=totalgradechange+data.getTotalgradechange();
					totalheadboxflushing=totalheadboxflushing+data.getTotalheadboxflushing();
					totalheadboxsealfixing=totalheadboxsealfixing+data.getTotalheadboxsealfixing();
					totalhoodfire=totalhoodfire+data.getTotalhoodfire();
					totalinstrumentation=totalinstrumentation+data.getTotalinstrumentation();
					totaljetslittertrimsadjustment=totaljetslittertrimsadjustment+data.getTotaljetslittertrimsadjustment();
					totallackofair=totallackofair+data.getTotallackofair();
					totallackofsteam=totallackofsteam+data.getTotallackofsteam();
					totallackofstock=totallackofstock+data.getTotallackofstock();
					totalmechanical=totalmechanical+data.getTotalmechanical();
					totalmissedturnup=totalmissedturnup+data.getTotalmissedturnup();
					totalnoemptyspool=totalnoemptyspool+data.getTotalnoemptyspool();
					totalnowater=totalnowater+data.getTotalnowater();
					totalpoweroutage=totalpoweroutage+data.getTotalpoweroutage();
					totalscheduleclothingchange=totalscheduleclothingchange+data.getTotalscheduleclothingchange();
					totalsmoldering=totalsmoldering+data.getTotalsmoldering();
					totalsprayboomchange=totalsprayboomchange+data.getTotalsprayboomchange();
					totalstartup=totalstartup+data.getTotalstartup();
					totalstriptheYankee=totalstriptheYankee+data.getTotalstriptheYankee();
					totalturnup=totalturnup+data.getTotalturnup();
					totalunscheduledclothingchange=totalunscheduledclothingchange+data.getTotalunscheduledclothingchange();
					grandTotalMins=grandTotalMins+data.getTotalmin()+data.getTotalhr()*60;
					grandTotalReelTon=grandTotalReelTon+data.getReelton();
					
					
							
			row++;
			loopcount++;
		}
		row++;
		col=0;
		util.addValue(row, col++, "Days In Years "+loopcount, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Total Minutes", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalannualoutage, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalbladechange, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalboilout, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalbreakbackedge, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalbreakfrontedge, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalbreakmiddle, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalbreakatreel, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalbreakatyankee, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalcleanupwashup, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalelectrical, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalfeltwash, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalfieldday, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalfireatreel, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalgradechange, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalheadboxflushing, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalheadboxsealfixing, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalhoodfire, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalinstrumentation, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totaljetslittertrimsadjustment, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totallackofair, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totallackofsteam, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totallackofstock, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalmechanical, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalmissedturnup, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalnoemptyspool, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalnowater, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalpoweroutage, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalscheduleclothingchange, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalsmoldering, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalsprayboomchange, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalstartup, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalstriptheYankee, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalturnup, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, totalunscheduledclothingchange, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, grandTotalMins, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, grandTotalReelTon, Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		row++;
		col=0;
		
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "Percentage", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalannualoutage/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalbladechange/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalboilout/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalbreakbackedge/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalbreakfrontedge/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalbreakmiddle/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalbreakatreel/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalbreakatyankee/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalcleanupwashup/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalelectrical/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalfeltwash/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalfieldday/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalfireatreel/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalgradechange/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalheadboxflushing/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalheadboxsealfixing/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalhoodfire/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalinstrumentation/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totaljetslittertrimsadjustment/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totallackofair/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totallackofsteam/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totallackofstock/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalmechanical/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalmissedturnup/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalnoemptyspool/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalnowater/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalpoweroutage/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalscheduleclothingchange/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalsmoldering/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalsprayboomchange/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalstartup/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalstriptheYankee/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalturnup/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(totalunscheduledclothingchange/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, CommonUtil.round(grandTotalMins/(loopcount*1440)*100, 2)+"%", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		row++;
		col=5;
		util.addValue(row, 0, "Year to Date Percentage: "+CommonUtil.round(grandTotalMins/(loopcount*1440)*100, 2)+" %", Workbook2007Util.Style.STYLE_BOLD_CENTER, (short)400);
		util.mergeCell(row, row, 0, 21);
		row++;
		
		util.write(outputStream);
	}

}
