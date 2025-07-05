/**
 *May 23, 2016
 *WrapperVsMachineSummaryReportHandler.java
 * TODO
 *com.st.production.report
 *WrapperVsMachineSummaryReportHandler.java
 *Sunil Singh Bora
 */
package com.st.productionpm5.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.production.model.MachineAndWrapper;
import com.st.productionpm5.model.MachineAndWrapperPM5;

/**
 * @author roshan
 *
 */
@Repository
public class WrapperVsMachineSummaryReportHandlerPM5 {

	/**
	 * @param machineAndWrappersSummary
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createMachineAndWrapperSummaryReport(
			List<MachineAndWrapper> machineAndWrappersSummary,
			ServletOutputStream outputStream) throws IOException {
		Workbook2007Util workbookUtil=new Workbook2007Util();

		int row=0;
		int col=0;
		
		workbookUtil.addValue(row, 0, "Machine Vs Wrapper Summary Reports", Workbook2007Util.Style.STYLE_HEADER_01, (short)400);
		workbookUtil.mergeCell(row, row, 0, 17);
		short rowHeight=280;
		col=0;
		row++;
		
		
	//	workbookUtil.addValue(row, col++, "RollID", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "DateEntered", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "GradeCode", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Team", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelNumber", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelWhiteWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelRedWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelRejectWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelSumTons", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedCount", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedWhite", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedRed", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedReject", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedSumLbs", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedSumTons", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Variance", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "VariancePercent", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrapperWidth", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "MachReelWidth", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WidthVariance", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		
		double ReelWhiteWeightA=0;	
		double ReelRedWeightA=0;	
		double ReelRejectWeightA=0;
		double ReelSumTonsA=0;	
		double WrappedCountA=0;	
		double WrappedWhiteA=0;	
		double WrappedRedA=0;	
		double WrappedRejectA=0;	
		double WrappedSumLbsA=0;	
		double WrappedSumTonsA=0;	
		double VarianceA=0;	
		double VariancePercentA=0;	
		double WrapperWidthA=0;	
		double MachReelWidthA=0;	
		double WidthVarianceA=0;
		int aSize=0;
		
		double ReelWhiteWeightB=0;	
		double ReelRedWeightB=0;	
		double ReelRejectWeightB=0;
		double ReelSumTonsB=0;	
		double WrappedCountB=0;	
		double WrappedWhiteB=0;	
		double WrappedRedB=0;	
		double WrappedRejectB=0;	
		double WrappedSumLbsB=0;	
		double WrappedSumTonsB=0;	
		double VarianceB=0;	
		double VariancePercentB=0;	
		double WrapperWidthB=0;	
		double MachReelWidthB=0;	
		double WidthVarianceB=0;
		int bSize=0;
		
		double ReelWhiteWeightC=0;	
		double ReelRedWeightC=0;	
		double ReelRejectWeightC=0;
		double ReelSumTonsC=0;	
		double WrappedCountC=0;	
		double WrappedWhiteC=0;	
		double WrappedRedC=0;	
		double WrappedRejectC=0;	
		double WrappedSumLbsC=0;	
		double WrappedSumTonsC=0;	
		double VarianceC=0;	
		double VariancePercentC=0;	
		double WrapperWidthC=0;	
		double MachReelWidthC=0;	
		double WidthVarianceC=0;
		int cSize=0;
		
		double ReelWhiteWeightD=0;	
		double ReelRedWeightD=0;	
		double ReelRejectWeightD=0;
		double ReelSumTonsD=0;	
		double WrappedCountD=0;	
		double WrappedWhiteD=0;	
		double WrappedRedD=0;	
		double WrappedRejectD=0;	
		double WrappedSumLbsD=0;	
		double WrappedSumTonsD=0;	
		double VarianceD=0;	
		double VariancePercentD=0;	
		double WrapperWidthD=0;	
		double MachReelWidthD=0;	
		double WidthVarianceD=0;
		int dSize=0;
		
		
		for (MachineAndWrapper machineAndWrapper : machineAndWrappersSummary) {
			col=0;
			row++;
			//workbookUtil.addValue(row, col++, CommonUtil.checkNull(machineAndWrapper.getRollID()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, dateFormat.format(machineAndWrapper.getDateEntered()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(machineAndWrapper.getGradeCode()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			workbookUtil.addValue(row, col++, machineAndWrapper.getTeam(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelNumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelWhiteWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelRedWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelRejectWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelSumTons(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedCount(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedWhite(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedRed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedReject(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedSumLbs(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedSumTons(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getVariance(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(machineAndWrapper.getVariancePercent()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrapperWidth(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getMachReelWidth(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWidthVariance(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			
					if(machineAndWrapper.getTeam().equalsIgnoreCase("A")){
								 ReelWhiteWeightA=ReelWhiteWeightA+machineAndWrapper.getReelWhiteWeight();	
								 ReelRedWeightA=ReelRedWeightA+machineAndWrapper.getReelRedWeight();
								 ReelRejectWeightA=ReelRejectWeightA+machineAndWrapper.getReelRejectWeight();
								 ReelSumTonsA=ReelSumTonsA+machineAndWrapper.getReelSumTons();
								 WrappedCountA=WrappedCountA+machineAndWrapper.getWrappedCount();
								 WrappedWhiteA=WrappedWhiteA+machineAndWrapper.getWrappedWhite();
								 WrappedRedA=WrappedRedA+machineAndWrapper.getWrappedRed();
								 WrappedRejectA=WrappedRejectA+machineAndWrapper.getWrappedReject();
								 WrappedSumLbsA=WrappedSumLbsA+machineAndWrapper.getWrappedSumLbs();
								 WrappedSumTonsA=WrappedSumTonsA+machineAndWrapper.getWrappedSumTons();
								 VarianceA=VarianceA+machineAndWrapper.getVariance();
								 if(machineAndWrapper.getVariancePercent()==null){
									 VariancePercentA=VariancePercentA+0;
								 }else{
									 VariancePercentA=VariancePercentA+Double.parseDouble(CommonUtil.checkNull(machineAndWrapper.getVariancePercent().replace("%", "")));
								 }
								 WrapperWidthA=WrapperWidthA+machineAndWrapper.getWrapperWidth();
								 MachReelWidthA=MachReelWidthA+machineAndWrapper.getMachReelWidth();
								 WidthVarianceA=WidthVarianceA+machineAndWrapper.getWidthVariance();
								 aSize++;
							}
					if(machineAndWrapper.getTeam().equalsIgnoreCase("B")){
						 ReelWhiteWeightB=ReelWhiteWeightB+machineAndWrapper.getReelWhiteWeight();	
						 ReelRedWeightB=ReelRedWeightB+machineAndWrapper.getReelRedWeight();
						 ReelRejectWeightB=ReelRejectWeightB+machineAndWrapper.getReelRejectWeight();
						 ReelSumTonsB=ReelSumTonsB+machineAndWrapper.getReelSumTons();
						 WrappedCountB=WrappedCountB+machineAndWrapper.getWrappedCount();
						 WrappedWhiteB=WrappedWhiteB+machineAndWrapper.getWrappedWhite();
						 WrappedRedB=WrappedRedB+machineAndWrapper.getWrappedRed();
						 WrappedRejectB=WrappedRejectB+machineAndWrapper.getWrappedReject();
						 WrappedSumLbsB=WrappedSumLbsB+machineAndWrapper.getWrappedSumLbs();
						 WrappedSumTonsB=WrappedSumTonsB+machineAndWrapper.getWrappedSumTons();
						 VarianceB=VarianceB+machineAndWrapper.getVariance();
						 if(machineAndWrapper.getVariancePercent()!=null){
							 VariancePercentB=VariancePercentB+Double.parseDouble(CommonUtil.checkNull(machineAndWrapper.getVariancePercent().replace("%", "")));
						 }
						 WrapperWidthB=WrapperWidthB+machineAndWrapper.getWrapperWidth();
						 MachReelWidthB=MachReelWidthB+machineAndWrapper.getMachReelWidth();
						 WidthVarianceB=WidthVarianceB+machineAndWrapper.getWidthVariance();
						 bSize++;
						}
					if(machineAndWrapper.getTeam().equalsIgnoreCase("C")){
						 ReelWhiteWeightC=ReelWhiteWeightC+machineAndWrapper.getReelWhiteWeight();	
						 ReelRedWeightC=ReelRedWeightC+machineAndWrapper.getReelRedWeight();
						 ReelRejectWeightC=ReelRejectWeightC+machineAndWrapper.getReelRejectWeight();
						 ReelSumTonsC=ReelSumTonsC+machineAndWrapper.getReelSumTons();
						 WrappedCountC=WrappedCountC+machineAndWrapper.getWrappedCount();
						 WrappedWhiteC=WrappedWhiteC+machineAndWrapper.getWrappedWhite();
						 WrappedRedC=WrappedRedC+machineAndWrapper.getWrappedRed();
						 WrappedRejectC=WrappedRejectC+machineAndWrapper.getWrappedReject();
						 WrappedSumLbsC=WrappedSumLbsC+machineAndWrapper.getWrappedSumLbs();
						 WrappedSumTonsC=WrappedSumTonsC+machineAndWrapper.getWrappedSumTons();
						 VarianceC=VarianceC+machineAndWrapper.getVariance();
						 if(machineAndWrapper.getVariancePercent()!=null){
							 VariancePercentC=VariancePercentC+Double.parseDouble(CommonUtil.checkNull(machineAndWrapper.getVariancePercent().replace("%", "")));
						 }
						 WrapperWidthC=WrapperWidthC+machineAndWrapper.getWrapperWidth();
						 MachReelWidthC=MachReelWidthC+machineAndWrapper.getMachReelWidth();
						 WidthVarianceC=WidthVarianceC+machineAndWrapper.getWidthVariance();
						 cSize++;
						}
					if(machineAndWrapper.getTeam().equalsIgnoreCase("D")){
						 ReelWhiteWeightD=ReelWhiteWeightD+machineAndWrapper.getReelWhiteWeight();	
						 ReelRedWeightD=ReelRedWeightD+machineAndWrapper.getReelRedWeight();
						 ReelRejectWeightD=ReelRejectWeightD+machineAndWrapper.getReelRejectWeight();
						 ReelSumTonsD=ReelSumTonsD+machineAndWrapper.getReelSumTons();
						 WrappedCountD=WrappedCountD+machineAndWrapper.getWrappedCount();
						 WrappedWhiteD=WrappedWhiteD+machineAndWrapper.getWrappedWhite();
						 WrappedRedD=WrappedRedD+machineAndWrapper.getWrappedRed();
						 WrappedRejectD=WrappedRejectD+machineAndWrapper.getWrappedReject();
						 WrappedSumLbsD=WrappedSumLbsD+machineAndWrapper.getWrappedSumLbs();
						 WrappedSumTonsD=WrappedSumTonsD+machineAndWrapper.getWrappedSumTons();
						 VarianceD=VarianceD+machineAndWrapper.getVariance();
						 if(machineAndWrapper.getVariancePercent()!=null){
							 VariancePercentD=VariancePercentD+Double.parseDouble(CommonUtil.checkNull(machineAndWrapper.getVariancePercent().replace("%", "")));
						 }
						 WrapperWidthD=WrapperWidthD+machineAndWrapper.getWrapperWidth();
						 MachReelWidthD=MachReelWidthD+machineAndWrapper.getMachReelWidth();
						 WidthVarianceD=WidthVarianceD+machineAndWrapper.getWidthVariance();
						 dSize++;
						}
		}
		row++;
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Summary", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "A", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelWhiteWeightA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRedWeightA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRejectWeightA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelSumTonsA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedCountA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedWhiteA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRedA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRejectA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumLbsA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumTonsA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++,CommonUtil.round(VariancePercentA/aSize, 2)+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, VariancePercentA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrapperWidthA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, MachReelWidthA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WidthVarianceA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "B", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelWhiteWeightB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRedWeightB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRejectWeightB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelSumTonsB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedCountB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedWhiteB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRedB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRejectB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumLbsB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumTonsB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.round(VariancePercentB/bSize, 2)+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, VariancePercentB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrapperWidthB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, MachReelWidthB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WidthVarianceB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "C", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelWhiteWeightC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRedWeightC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRejectWeightC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelSumTonsC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedCountC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedWhiteC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRedC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRejectC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumLbsC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumTonsC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.round(VariancePercentC/cSize, 2)+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, VariancePercentC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrapperWidthC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, MachReelWidthC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WidthVarianceC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "D", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelWhiteWeightD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRedWeightD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRejectWeightD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelSumTonsD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedCountD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedWhiteD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRedD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRejectD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumLbsD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumTonsD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, VarianceD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.round(VariancePercentD/dSize, 2)+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrapperWidthD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, MachReelWidthD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WidthVarianceD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		for (int i = 0; i <19; i++) {
			workbookUtil.setAutoSizeColumn(i);
		}
		
		workbookUtil.write(outputStream);
	}

	/**
	 * @param machineAndWrappersSummary
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createMachineAndWrapperSummaryReport(
			List<MachineAndWrapperPM5> machineAndWrappersSummary,
			FileOutputStream outputStream) throws IOException {
		Workbook2007Util workbookUtil=new Workbook2007Util();

		int row=0;
		int col=0;
		
		workbookUtil.addValue(row, 0, "Machine Vs Wrapper Summary Reports", Workbook2007Util.Style.STYLE_HEADER_01, (short)400);
		workbookUtil.mergeCell(row, row, 0, 17);
		short rowHeight=280;
		col=0;
		row++;
		
		
	//	workbookUtil.addValue(row, col++, "RollID", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "DateEntered", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "GradeCode", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Team", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelNumber", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelWhiteWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelRedWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelRejectWeight", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "ReelSumTons", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedCount", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedWhite", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedRed", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedReject", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedSumLbs", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrappedSumTons", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Variance", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "VariancePercent", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WrapperWidth", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "MachReelWidth", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "WidthVariance", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		
		double ReelWhiteWeightA=0;	
		double ReelRedWeightA=0;	
		double ReelRejectWeightA=0;
		double ReelSumTonsA=0;	
		double WrappedCountA=0;	
		double WrappedWhiteA=0;	
		double WrappedRedA=0;	
		double WrappedRejectA=0;	
		double WrappedSumLbsA=0;	
		double WrappedSumTonsA=0;	
		double VarianceA=0;	
		double VariancePercentA=0;	
		double WrapperWidthA=0;	
		double MachReelWidthA=0;	
		double WidthVarianceA=0;
		int aSize=0;
		
		double ReelWhiteWeightB=0;	
		double ReelRedWeightB=0;	
		double ReelRejectWeightB=0;
		double ReelSumTonsB=0;	
		double WrappedCountB=0;	
		double WrappedWhiteB=0;	
		double WrappedRedB=0;	
		double WrappedRejectB=0;	
		double WrappedSumLbsB=0;	
		double WrappedSumTonsB=0;	
		double VarianceB=0;	
		double VariancePercentB=0;	
		double WrapperWidthB=0;	
		double MachReelWidthB=0;	
		double WidthVarianceB=0;
		int bSize=0;
		
		double ReelWhiteWeightC=0;	
		double ReelRedWeightC=0;	
		double ReelRejectWeightC=0;
		double ReelSumTonsC=0;	
		double WrappedCountC=0;	
		double WrappedWhiteC=0;	
		double WrappedRedC=0;	
		double WrappedRejectC=0;	
		double WrappedSumLbsC=0;	
		double WrappedSumTonsC=0;	
		double VarianceC=0;	
		double VariancePercentC=0;	
		double WrapperWidthC=0;	
		double MachReelWidthC=0;	
		double WidthVarianceC=0;
		int cSize=0;
		
		double ReelWhiteWeightD=0;	
		double ReelRedWeightD=0;	
		double ReelRejectWeightD=0;
		double ReelSumTonsD=0;	
		double WrappedCountD=0;	
		double WrappedWhiteD=0;	
		double WrappedRedD=0;	
		double WrappedRejectD=0;	
		double WrappedSumLbsD=0;	
		double WrappedSumTonsD=0;	
		double VarianceD=0;	
		double VariancePercentD=0;	
		double WrapperWidthD=0;	
		double MachReelWidthD=0;	
		double WidthVarianceD=0;
		int dSize=0;
		
		
		for (MachineAndWrapperPM5 machineAndWrapper : machineAndWrappersSummary) {
			col=0;
			row++;
			//workbookUtil.addValue(row, col++, CommonUtil.checkNull(machineAndWrapper.getRollID()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, dateFormat.format(machineAndWrapper.getDateEntered()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(machineAndWrapper.getGradeCode()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			workbookUtil.addValue(row, col++, machineAndWrapper.getTeam(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelNumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelWhiteWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelRedWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelRejectWeight(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getReelSumTons(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedCount(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedWhite(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedRed(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedReject(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedSumLbs(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrappedSumTons(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getVariance(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, CommonUtil.checkNull(machineAndWrapper.getVariancePercent()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWrapperWidth(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getMachReelWidth(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			workbookUtil.addValue(row, col++, machineAndWrapper.getWidthVariance(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			
					if(machineAndWrapper.getTeam().equalsIgnoreCase("A")){
								 ReelWhiteWeightA=ReelWhiteWeightA+machineAndWrapper.getReelWhiteWeight();	
								 ReelRedWeightA=ReelRedWeightA+machineAndWrapper.getReelRedWeight();
								 ReelRejectWeightA=ReelRejectWeightA+machineAndWrapper.getReelRejectWeight();
								 ReelSumTonsA=ReelSumTonsA+machineAndWrapper.getReelSumTons();
								 WrappedCountA=WrappedCountA+machineAndWrapper.getWrappedCount();
								 WrappedWhiteA=WrappedWhiteA+machineAndWrapper.getWrappedWhite();
								 WrappedRedA=WrappedRedA+machineAndWrapper.getWrappedRed();
								 WrappedRejectA=WrappedRejectA+machineAndWrapper.getWrappedReject();
								 WrappedSumLbsA=WrappedSumLbsA+machineAndWrapper.getWrappedSumLbs();
								 WrappedSumTonsA=WrappedSumTonsA+machineAndWrapper.getWrappedSumTons();
								 VarianceA=VarianceA+machineAndWrapper.getVariance();
								 if(machineAndWrapper.getVariancePercent()==null){
									 VariancePercentA=VariancePercentA+0;
								 }else{
									 VariancePercentA=VariancePercentA+Double.parseDouble(CommonUtil.checkNull(machineAndWrapper.getVariancePercent().replace("%", "")));
								 }
								 WrapperWidthA=WrapperWidthA+machineAndWrapper.getWrapperWidth();
								 MachReelWidthA=MachReelWidthA+machineAndWrapper.getMachReelWidth();
								 WidthVarianceA=WidthVarianceA+machineAndWrapper.getWidthVariance();
								 aSize++;
							}
					if(machineAndWrapper.getTeam().equalsIgnoreCase("B")){
						 ReelWhiteWeightB=ReelWhiteWeightB+machineAndWrapper.getReelWhiteWeight();	
						 ReelRedWeightB=ReelRedWeightB+machineAndWrapper.getReelRedWeight();
						 ReelRejectWeightB=ReelRejectWeightB+machineAndWrapper.getReelRejectWeight();
						 ReelSumTonsB=ReelSumTonsB+machineAndWrapper.getReelSumTons();
						 WrappedCountB=WrappedCountB+machineAndWrapper.getWrappedCount();
						 WrappedWhiteB=WrappedWhiteB+machineAndWrapper.getWrappedWhite();
						 WrappedRedB=WrappedRedB+machineAndWrapper.getWrappedRed();
						 WrappedRejectB=WrappedRejectB+machineAndWrapper.getWrappedReject();
						 WrappedSumLbsB=WrappedSumLbsB+machineAndWrapper.getWrappedSumLbs();
						 WrappedSumTonsB=WrappedSumTonsB+machineAndWrapper.getWrappedSumTons();
						 VarianceB=VarianceB+machineAndWrapper.getVariance();
						 if(machineAndWrapper.getVariancePercent()==null){
							 VariancePercentB=VariancePercentB+0;
						 }else{
							 VariancePercentB=VariancePercentB+Double.parseDouble(CommonUtil.checkNull(machineAndWrapper.getVariancePercent().replace("%", "")));
						 }
						 WrapperWidthB=WrapperWidthB+machineAndWrapper.getWrapperWidth();
						 MachReelWidthB=MachReelWidthB+machineAndWrapper.getMachReelWidth();
						 WidthVarianceB=WidthVarianceB+machineAndWrapper.getWidthVariance();
						 bSize++;
						}
					if(machineAndWrapper.getTeam().equalsIgnoreCase("C")){
						 ReelWhiteWeightC=ReelWhiteWeightC+machineAndWrapper.getReelWhiteWeight();	
						 ReelRedWeightC=ReelRedWeightC+machineAndWrapper.getReelRedWeight();
						 ReelRejectWeightC=ReelRejectWeightC+machineAndWrapper.getReelRejectWeight();
						 ReelSumTonsC=ReelSumTonsC+machineAndWrapper.getReelSumTons();
						 WrappedCountC=WrappedCountC+machineAndWrapper.getWrappedCount();
						 WrappedWhiteC=WrappedWhiteC+machineAndWrapper.getWrappedWhite();
						 WrappedRedC=WrappedRedC+machineAndWrapper.getWrappedRed();
						 WrappedRejectC=WrappedRejectC+machineAndWrapper.getWrappedReject();
						 WrappedSumLbsC=WrappedSumLbsC+machineAndWrapper.getWrappedSumLbs();
						 WrappedSumTonsC=WrappedSumTonsC+machineAndWrapper.getWrappedSumTons();
						 VarianceC=VarianceC+machineAndWrapper.getVariance();
						 if(machineAndWrapper.getVariancePercent()==null){
							 VariancePercentC=VariancePercentC+0;
						 }else{
							 VariancePercentC=VariancePercentC+Double.parseDouble(CommonUtil.checkNull(machineAndWrapper.getVariancePercent().replace("%", "")));
						 }
						 WrapperWidthC=WrapperWidthC+machineAndWrapper.getWrapperWidth();
						 MachReelWidthC=MachReelWidthC+machineAndWrapper.getMachReelWidth();
						 WidthVarianceC=WidthVarianceC+machineAndWrapper.getWidthVariance();
						 cSize++;
						}
					if(machineAndWrapper.getTeam().equalsIgnoreCase("D")){
						 ReelWhiteWeightD=ReelWhiteWeightD+machineAndWrapper.getReelWhiteWeight();	
						 ReelRedWeightD=ReelRedWeightD+machineAndWrapper.getReelRedWeight();
						 ReelRejectWeightD=ReelRejectWeightD+machineAndWrapper.getReelRejectWeight();
						 ReelSumTonsD=ReelSumTonsD+machineAndWrapper.getReelSumTons();
						 WrappedCountD=WrappedCountD+machineAndWrapper.getWrappedCount();
						 WrappedWhiteD=WrappedWhiteD+machineAndWrapper.getWrappedWhite();
						 WrappedRedD=WrappedRedD+machineAndWrapper.getWrappedRed();
						 WrappedRejectD=WrappedRejectD+machineAndWrapper.getWrappedReject();
						 WrappedSumLbsD=WrappedSumLbsD+machineAndWrapper.getWrappedSumLbs();
						 WrappedSumTonsD=WrappedSumTonsD+machineAndWrapper.getWrappedSumTons();
						 VarianceD=VarianceD+machineAndWrapper.getVariance();
						 if(machineAndWrapper.getVariancePercent()==null){
							 VariancePercentD=VariancePercentD+0;
						 }else{
							 VariancePercentD=VariancePercentD+Double.parseDouble(CommonUtil.checkNull(machineAndWrapper.getVariancePercent().replace("%", "")));
						 }
						 WrapperWidthD=WrapperWidthD+machineAndWrapper.getWrapperWidth();
						 MachReelWidthD=MachReelWidthD+machineAndWrapper.getMachReelWidth();
						 WidthVarianceD=WidthVarianceD+machineAndWrapper.getWidthVariance();
						 dSize++;
						}
		}
		row++;
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "Summary", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "A", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelWhiteWeightA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRedWeightA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRejectWeightA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelSumTonsA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedCountA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedWhiteA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRedA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRejectA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumLbsA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumTonsA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++,CommonUtil.round(VariancePercentA/aSize, 2)+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, VariancePercentA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrapperWidthA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, MachReelWidthA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WidthVarianceA/aSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "B", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelWhiteWeightB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRedWeightB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRejectWeightB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelSumTonsB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedCountB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedWhiteB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRedB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRejectB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumLbsB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumTonsB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.round(VariancePercentB/bSize, 2)+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, VariancePercentB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrapperWidthB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, MachReelWidthB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WidthVarianceB/bSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "C", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelWhiteWeightC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRedWeightC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRejectWeightC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelSumTonsC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedCountC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedWhiteC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRedC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRejectC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumLbsC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumTonsC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.round(VariancePercentC/cSize, 2)+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, VariancePercentC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrapperWidthC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, MachReelWidthC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WidthVarianceC/cSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		row++;
		col=0;
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "D", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelWhiteWeightD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRedWeightD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelRejectWeightD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, ReelSumTonsD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedCountD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedWhiteD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRedD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedRejectD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumLbsD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrappedSumTonsD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, VarianceD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, CommonUtil.round(VariancePercentD/dSize, 2)+"%", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WrapperWidthD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, MachReelWidthD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, WidthVarianceD/dSize, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		
		
		for (int i = 0; i <19; i++) {
			workbookUtil.setAutoSizeColumn(i);
		}
		
		workbookUtil.write(outputStream);
	}

}
