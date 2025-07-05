/**
 *Jan 1, 2015
 *CenterlineReportHandler.java
 * TODO
 *com.st.centerline.report
 *CenterlineReportHandler.java
 *Sunil Singh Bora
 */
package com.st.centerline.report;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Component;

import com.st.centerline.model.CenterlineData;
import com.st.centerline.model.CenterlineGrade;
import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;

/**
 * @author sbora
 *
 */
@Component
public class CenterlineReportHandler {

	/**
	 * @param centerlineDatas
	 * @param centerlineGrade
	 * @param outputStream
	 * @throws Exception 
	 */
	public void createCenterlineReport(List<CenterlineData> centerlineDatas,
			CenterlineGrade centerlineGrade, OutputStream outputStream) throws Exception {
		
		Workbook2007Util workbookUtil=new Workbook2007Util();
		
		int row=0;
		int col=0;
		short rowHeight=280;
		
		
		
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "UNITS", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "TARGET", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, new SimpleDateFormat("MM-dd-yyyy").format(centerlineData.getDate()), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineGrade.getGrade()), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (int i=0;i<centerlineDatas.size();i++) {
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineGrade.getGrade()), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Shift", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (int i=0;i<centerlineDatas.size();i++) {
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineGrade.getShift()), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Crew", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (int i=0;i<centerlineDatas.size();i++) {
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineGrade.getCrew()), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "CENTRELINES", Workbook2007Util.Style.STYLE_NORMAL_LEFT	,rowHeight);
		workbookUtil.mergeCell(row, row, 0, centerlineDatas.size()+2);
		
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Yankee speed", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "fpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getYankeeSpeed(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getYankeeSpeed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "QCS Basis wt target", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "#", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getQcsBasisWtTarget(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getQcsBasisWtTarget(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Reel Moisture", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getReelMoisture(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getReelMoisture(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Crepe", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getCrepe(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getCrepe(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Yankee Steam", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "psi", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getYankeeSteam(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getYankeeSteam(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Yankee Release", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "mg/m2", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getYankeeRelease(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getYankeeRelease(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Yankee Adesive", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "mg/m2", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getYankeeAdesive(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getYankeeAdesive(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Jet Wire Ratio", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getJetWireRatio(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getJetWireRatio(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Fan Pump flow rate", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "gpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getFanPumpFlowRate(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getFanPumpFlowRate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "After Dryer Draw", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "fpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getAfterDryerDraw(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getAfterDryerDraw(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "PROCESS PARAMETERS", Workbook2007Util.Style.STYLE_NORMAL_LEFT	,rowHeight);
		workbookUtil.mergeCell(row, row, 0, centerlineDatas.size()+2);
		
		
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "After Dryer Steam", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "psi", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getAfterDryerSteam(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getAfterDryerSteam(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "SPR loading", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "psi", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineGrade.getSprLoading()), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineData.getSprLoading()), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Felt Passivator", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "ml/min", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getFeltPassivator(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getFeltPassivator(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Sprayboom Pressure", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "psi", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getSprayboomPressure(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getSprayboomPressure(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Sprayboom Temparature", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "\u00b0F", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getSprayboomTemparature(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getSprayboomTemparature(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "WE Fan Speed", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "rpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getWefanSpeed(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getWefanSpeed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "DE Fan Speed", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "rpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getDefanSpeed(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getDefanSpeed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Make-up air damper", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getMakeUpAirDamper(), Workbook2007Util.Style.STYLE_BOLD_CENTER,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getMakeUpAirDamper(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Exhaust damper", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getExhaustDamper(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getExhaustDamper(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Exhaust Fan speed", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "rpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getExhaustFanSpeed(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getExhaustFanSpeed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "WE Hood Temperature", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "\u00b0F", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getWehoodTemperature(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getWehoodTemperature(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "DE Hood Temperature", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "\u00b0F", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getDehoodTemperature(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getDehoodTemperature(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Yankee \u0394 P", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "psi", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getYankeeAP(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getYankeeAP(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "After Dryer \u0394 P", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "psi", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getAfterDryerAP(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getAfterDryerAP(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Sec Arm Loading", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "pli", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getSecArmLoading(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getSecArmLoading(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Reel offset", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "pli", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getReelOffset(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getReelOffset(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Uhle box North Valve", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getUhleBoxNorthValve(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getUhleBoxNorthValve(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Uhle box South Valve", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getUhleBoxSouthValve(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getUhleBoxSouthValve(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Falt box 1 Vacuum valve", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getFaltBox1VacuumValve(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getFaltBox1VacuumValve(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Falt box 2 Vacuum valve", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getFaltBox2VacuumValve(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getFaltBox2VacuumValve(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Falt box 4 Vacuum valve", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getFaltBox4VacuumValve(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getFaltBox4VacuumValve(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Fan Pump speed", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "rpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getFanPumpSpeed(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getFanPumpSpeed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Total head", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getTotalHead(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getTotalHead(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Headbox level", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getHeadboxLevel(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getHeadboxLevel(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Horizontal slice local", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "in", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineGrade.getHorizontalSlice()), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineData.getHorizontalSlice()), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Horizontal slice dcs", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "in", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineGrade.getHorizontalSliceDcs()), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineData.getHorizontalSliceDcs()), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Vertical Slice local", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "in", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineGrade.getVerticalSlice()), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineData.getVerticalSlice()), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Vertical Slice dcs", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "in", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineGrade.getVerticalSliceDcs()), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(centerlineData.getVerticalSliceDcs()), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Selectifier reject flow 1", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "gpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getSelectifierRejectFlow1(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getSelectifierRejectFlow1(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Selectifier reject flow 2", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "gpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getSelectifierRejectFlow2(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getSelectifierRejectFlow2(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Sec screen Cycle time", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "min", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++,  centerlineGrade.getSecScreenCycleTime(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getSecScreenCycleTime(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Low Density Cycle Time", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "min", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++,centerlineGrade.getLowDensityCycleTime(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getLowDensityCycleTime(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Refiners Energy", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "kW", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getRefinersEnergy(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getRefinersEnergy(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Number of Refiners", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "Nos.", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getNumberOfRefiners(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getNumberOfRefiners(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Refiner Inlet Consistency", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getRefinerInletConsistency(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getRefinerInletConsistency(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		

		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Machine Chest Consistency", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getMachineChestConsistency(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getMachineChestConsistency(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Stock flow", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "gpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getStockFlow(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getStockFlow(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		

		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Sweetner Flow", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "gpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getSweetnerFlow(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getSweetnerFlow(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Broke", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "%", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getBroke(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getBroke(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		

		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Wet strength", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, "gpm", Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		workbookUtil.addValue(row, col++, centerlineGrade.getWetStrength(), Workbook2007Util.Style.STYLE_BOLD_CENTER	,rowHeight);
		for (CenterlineData centerlineData : centerlineDatas) {
			workbookUtil.addValue(row, col++, centerlineData.getWetStrength(), Workbook2007Util.Style.STYLE_NORMAL_CENTER	,rowHeight);
		}
		
	
		
		
		
		for(int i=0;i<centerlineDatas.size()+2;i++){
			workbookUtil.setAutoSizeColumn(i);
		}
		
		workbookUtil.freez(3, 4);
		
		
		workbookUtil.write(outputStream);
	}

}
