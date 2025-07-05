package com.st.wastepaper.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;

//import org.apache.poi.hssf.model.Sheet;
import org.springframework.stereotype.Component;

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.wastepaper.model.WastePaperBaleInventory;

@Component
public class WastePaperMillYieldReportExportHandler {

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	
	public void getExportWastePAperMillYieldReport(
			List<WastePaperBaleInventory> consumedbalesdata, File file,
			ServletOutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file,0);
		util.setSheetName("WastePaper Mill Yield Report - STPAPER ONE", 0);
		
		short rowHeight = 280;
		int row=2;
		int col=0;		
		

		double TtotalbalesweightOfhw=0;
		double TtotalbalesweightOfpulpwetlap=0;
		double TtotalbalesweightOfpulpdrylap=0;
		double TtotalbalesweightOfvirginpulp=0;
		double Tyieldbroke=0;
		double TtotalbalesweightOfstbaleswetlap=0;
		double TtotalbalesweightOfcbs=0;
		double Tyieldcgwd=0;
		double TtotalbalesweightOfctdgdwd=0;
		double Tyieldcgwdsection=0;
		double TtotalbalesweightOfmcl=0;
		double TtotalbalesweightOfmwl=0;
		double TtotalbalesweightOfunctdflyleafshvgs=0;
		double TtotalbalesweightOfmwlwigs=0;
		double TtotalbalesweightOfnewsblank=0;
		double TtotalbalesweightOfother=0;
		double TtotalbalesweightOfdlk=0;
		double TtotalbalesweightOfhardwoodchips=0;
		double TtotalbalesweightOfpmix=0;
		double TtotalbalesweightOfpwe=0;
		double TtotalbalesweightOfsow=0;
		double Tyieldsw=0;
		double TtotalbalesweightOfswl=0;
		double Tyieldwhiteblend=0;
		double Tyieldwhitebland=0;
		double TtotalbalesweightOfocccorrugated=0;
		double TtotalbalesweightOflightprtsbs=0;
		double TtotalbalesweightOfheavyprtsbs=0;
		
		double totalbalesweightofVirginSoftWood=0;			
		double totalbalesweightofVirginHardWood=0;
		double totalbalesweightofVirginEucalyptus=0;
		double totalbalesweightofVirginSW_Fluff=0;
		double totalbalesweightofStvirginproduction=0;
		  
		double Tyieldtotalofpulpar3=0;
		double Tyieldtotalofpulpar4=0;
		double Tyieldtotalmillproduction=0;
		double Tyieldscavirginpulp=0;
		double TyieldstbaleswetLap=0;
		double Tyieldtrimloss=0;
		double TotalAdjustedRFproduction=0;
		
		for(WastePaperBaleInventory yield:consumedbalesdata){
			col=0;
			/*util.addValue(row, col++, dateFormat.format(yield.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_LightGreen, rowHeight);*/
			util.createFreezePane(2,1);
			util.addValue(row, col++, dateFormat.format(yield.getDate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfhw(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfpulpwetlap(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfpulpdrylap(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfvirginpulp(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldbroke(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfstbaleswetlap(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfother(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightofVirginSW_Fluff(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfdlk(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfmwl(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfhardwoodchips(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfcbs(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldcgwd(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfctdgdwd(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldcgwdsection(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfmcl(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfunctdflyleafshvgs(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfmwlwigs(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfnewsblank(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfpmix(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfpwe(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfsow(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldsw(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfswl(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldwhiteblend(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldwhitebland(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfocccorrugated(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//util.addValue(row, col++, "0.0", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOflightprtsbs(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfheavyprtsbs(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldtotalofpulpar3(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldtotalofpulpar4(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldtotalmillproduction(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		/*	
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldscavirginpulp(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getStvirginproduction(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldtrimloss(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldtotalmillproduction()-yield.getStvirginproduction()-yield.getYieldscavirginpulp()+yield.getYieldtrimloss(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getStvirginproduction(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		*/
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfhw()*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfpulpwetlap()*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfpulpdrylap()*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfvirginpulp()*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getYieldbroke()*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfstbaleswetlap()*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfother()*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			double totalAlterNateFiber=yield.getTotalbalesweightOfhw()*90/100+yield.getTotalbalesweightOfpulpwetlap()*90/100+
					   yield.getTotalbalesweightOfpulpdrylap()*90/100+yield.getTotalbalesweightOfvirginpulp()*90/100+
					   yield.getYieldbroke()*90/100+yield.getTotalbalesweightOfstbaleswetlap()*90/100
					   +yield.getTotalbalesweightOfother()*90/100;
			util.addValue(row, col++, ""+CommonUtil.round(totalAlterNateFiber, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
			util.addValue(row, col++, ""+CommonUtil.round((yield.getYieldtotalmillproduction()-totalAlterNateFiber), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round((yield.getYieldtotalmillproduction()-totalAlterNateFiber)/yield.getYieldtotalofpulpar4()*100, 2)
																				, Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
				col++;
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightofVirginSoftWood()*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightofVirginHardWood()*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			//util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightofVirginSW_Fluff()*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightofVirginEucalyptus()*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round((yield.getTotalbalesweightofVirginSoftWood()*90/100+yield.getTotalbalesweightofVirginSW_Fluff()*90/100+
					yield.getTotalbalesweightofVirginHardWood()*90/100+yield.getTotalbalesweightofVirginEucalyptus()*90/100), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			if((yield.getTotalbalesweightofVirginSoftWood()+yield.getTotalbalesweightofVirginSW_Fluff()+
					yield.getTotalbalesweightofVirginHardWood()+yield.getTotalbalesweightofVirginEucalyptus())!=0)
			util.addValue(row, col++, ""+CommonUtil.round((yield.getStvirginproduction()/(yield.getTotalbalesweightofVirginSoftWood()*90/100+yield.getTotalbalesweightofVirginSW_Fluff()*90/100+
					yield.getTotalbalesweightofVirginHardWood()*90/100+yield.getTotalbalesweightofVirginEucalyptus()*90/100))*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			else
			util.addValue(row, col++, ""+CommonUtil.round(0,2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			col++;
			util.addValue(row, col++, ""+CommonUtil.round(yield.getTotalbalesweightOfsow(), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round((yield.getYieldtotalofpulpar4()-yield.getTotalbalesweightOfnewsblank()), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round((yield.getTotalbalesweightOfsow()/(yield.getYieldtotalofpulpar4()-yield.getTotalbalesweightOfnewsblank()))*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			
					TtotalbalesweightOfhw=TtotalbalesweightOfhw+yield.getTotalbalesweightOfhw();
					TtotalbalesweightOfpulpwetlap=TtotalbalesweightOfpulpwetlap+yield.getTotalbalesweightOfpulpwetlap();
					TtotalbalesweightOfpulpdrylap=TtotalbalesweightOfpulpdrylap+yield.getTotalbalesweightOfpulpdrylap();
					TtotalbalesweightOfvirginpulp=TtotalbalesweightOfvirginpulp+yield.getTotalbalesweightOfvirginpulp();
					Tyieldbroke=Tyieldbroke+yield.getYieldbroke();
					TtotalbalesweightOfstbaleswetlap=TtotalbalesweightOfstbaleswetlap+yield.getTotalbalesweightOfstbaleswetlap();
					TtotalbalesweightOfcbs=TtotalbalesweightOfcbs+yield.getTotalbalesweightOfcbs();
					Tyieldcgwd=Tyieldcgwd+yield.getYieldcgwd();
					TtotalbalesweightOfctdgdwd=TtotalbalesweightOfctdgdwd+yield.getTotalbalesweightOfctdgdwd();
					Tyieldcgwdsection=Tyieldcgwdsection+yield.getYieldcgwdsection();
					TtotalbalesweightOfmcl=TtotalbalesweightOfmcl+yield.getTotalbalesweightOfmcl();
					TtotalbalesweightOfmwl=TtotalbalesweightOfmwl+yield.getTotalbalesweightOfmwl();
					TtotalbalesweightOfunctdflyleafshvgs=TtotalbalesweightOfunctdflyleafshvgs+yield.getTotalbalesweightOfunctdflyleafshvgs();
					TtotalbalesweightOfmwlwigs=TtotalbalesweightOfmwlwigs+yield.getTotalbalesweightOfmwlwigs();
					TtotalbalesweightOfnewsblank=TtotalbalesweightOfnewsblank+yield.getTotalbalesweightOfnewsblank();
					TtotalbalesweightOfother=TtotalbalesweightOfother+yield.getTotalbalesweightOfother();
					TtotalbalesweightOfhardwoodchips=TtotalbalesweightOfhardwoodchips+yield.getTotalbalesweightOfhardwoodchips();
					TtotalbalesweightOfdlk=TtotalbalesweightOfdlk+yield.getTotalbalesweightOfdlk();
					TtotalbalesweightOfpmix=TtotalbalesweightOfpmix+yield.getTotalbalesweightOfpmix();
					TtotalbalesweightOfpwe=TtotalbalesweightOfpwe+yield.getTotalbalesweightOfpwe();
					TtotalbalesweightOfsow=TtotalbalesweightOfsow+yield.getTotalbalesweightOfsow();
					Tyieldsw=Tyieldsw+yield.getYieldsw();
					TtotalbalesweightOfswl=TtotalbalesweightOfswl+yield.getTotalbalesweightOfswl();
					Tyieldwhiteblend=Tyieldwhiteblend+yield.getYieldwhiteblend();
					Tyieldwhitebland=Tyieldwhitebland+yield.getYieldwhitebland();
					TtotalbalesweightOfocccorrugated=TtotalbalesweightOfocccorrugated+yield.getTotalbalesweightOfocccorrugated();
					
					TtotalbalesweightOflightprtsbs=TtotalbalesweightOflightprtsbs+yield.getTotalbalesweightOflightprtsbs();
					TtotalbalesweightOfheavyprtsbs=TtotalbalesweightOfheavyprtsbs+yield.getTotalbalesweightOfheavyprtsbs();
					Tyieldtotalofpulpar3=Tyieldtotalofpulpar3+yield.getYieldtotalofpulpar3();
					Tyieldtotalofpulpar4=Tyieldtotalofpulpar4+yield.getYieldtotalofpulpar4();
					Tyieldtotalmillproduction=Tyieldtotalmillproduction+yield.getYieldtotalmillproduction();
					Tyieldscavirginpulp=Tyieldscavirginpulp+yield.getYieldscavirginpulp();
					TyieldstbaleswetLap=TyieldstbaleswetLap+yield.getYieldstbaleswetLap();
					Tyieldtrimloss=Tyieldtrimloss+yield.getYieldtrimloss();
					totalbalesweightofVirginSoftWood=totalbalesweightofVirginSoftWood+CommonUtil.round(yield.getTotalbalesweightofVirginSoftWood()*90/100,2);			
					totalbalesweightofVirginHardWood=totalbalesweightofVirginHardWood+CommonUtil.round(yield.getTotalbalesweightofVirginHardWood()*90/100,2);
					totalbalesweightofVirginEucalyptus=totalbalesweightofVirginEucalyptus+CommonUtil.round(yield.getTotalbalesweightofVirginEucalyptus()*90/100,2);
					totalbalesweightofVirginSW_Fluff=totalbalesweightofVirginSW_Fluff+yield.getTotalbalesweightofVirginSW_Fluff();
					totalbalesweightofStvirginproduction=totalbalesweightofStvirginproduction+yield.getStvirginproduction();
					
					TotalAdjustedRFproduction=TotalAdjustedRFproduction+CommonUtil.round((yield.getYieldtotalmillproduction()-yield.getYieldscavirginpulp()+yield.getYieldtrimloss())
							-(yield.getTotalbalesweightOfhw()*90/100+yield.getTotalbalesweightOfpulpwetlap()*90/100+yield.getTotalbalesweightOfpulpdrylap()*90/100+yield.getTotalbalesweightOfvirginpulp()*90/100+yield.getYieldbroke()*90/100+yield.getTotalbalesweightOfstbaleswetlap()*90/100)+
							(yield.getYieldstbaleswetLap()), 2);
					
			row++;
		}
		col=0;
		{
			/*util.addValue(row, col++, "Total", Workbook2007Util.Style.STYLE_NORMAL_CENTER_LightGreen, rowHeight);*/
			util.addValue(row, col++, "Total", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfhw, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfpulpwetlap, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfpulpdrylap, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfvirginpulp, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldbroke, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfstbaleswetlap, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfother, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(totalbalesweightofVirginSW_Fluff, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfdlk, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfmwl, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfhardwoodchips, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfcbs, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldcgwd, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfctdgdwd, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldcgwdsection, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfmcl, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfunctdflyleafshvgs, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfmwlwigs, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfnewsblank, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfpmix, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfpwe, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfsow, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldsw, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfswl, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldwhiteblend, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldwhitebland, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfocccorrugated, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			//util.addValue(row, col++, ""+CommonUtil.round(0, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOflightprtsbs, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfheavyprtsbs, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldtotalofpulpar3, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldtotalofpulpar4, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldtotalmillproduction, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		/*	
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldscavirginpulp, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(totalbalesweightofStvirginproduction, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldtrimloss, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldtotalmillproduction-Tyieldscavirginpulp+Tyieldtrimloss, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(totalbalesweightofStvirginproduction, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		*/
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfhw*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfpulpwetlap*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfpulpdrylap*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfvirginpulp*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldbroke*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfstbaleswetlap*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfother*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfhw*90/100+TtotalbalesweightOfpulpwetlap*90/100+TtotalbalesweightOfpulpdrylap*90/100+TtotalbalesweightOfvirginpulp*90/100+Tyieldbroke*90/100+TtotalbalesweightOfstbaleswetlap*90/100+TtotalbalesweightOfother*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(Tyieldtotalmillproduction-(TtotalbalesweightOfhw*90/100+TtotalbalesweightOfpulpwetlap*90/100+TtotalbalesweightOfpulpdrylap*90/100+TtotalbalesweightOfvirginpulp*90/100+Tyieldbroke*90/100+TtotalbalesweightOfstbaleswetlap*90/100+TtotalbalesweightOfother*90/100), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round((((Tyieldtotalmillproduction-Tyieldscavirginpulp+Tyieldtrimloss)-(TtotalbalesweightOfhw*90/100+TtotalbalesweightOfpulpwetlap*90/100+TtotalbalesweightOfpulpdrylap*90/100+TtotalbalesweightOfvirginpulp*90/100+Tyieldbroke*90/100+TtotalbalesweightOfstbaleswetlap*90/100+TtotalbalesweightOfother*90/100)+(TyieldstbaleswetLap))/Tyieldtotalofpulpar4)*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
			
			//util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfhw*90/100+TtotalbalesweightOfpulpwetlap*90/100+TtotalbalesweightOfpulpdrylap*90/100+TtotalbalesweightOfvirginpulp*90/100+Tyieldbroke*90/100+TtotalbalesweightOfstbaleswetlap*90/100+TtotalbalesweightOfother*90/100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			//util.addValue(row, col++, ""+CommonUtil.round(TyieldstbaleswetLap, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			//System.out.println("TotalAdjustedRFproduction::"+TotalAdjustedRFproduction);
			/*util.addValue(row, col++, ""+CommonUtil.round((Tyieldtotalmillproduction-Tyieldscavirginpulp+Tyieldtrimloss)-(TtotalbalesweightOfhw*90/100+TtotalbalesweightOfpulpwetlap*90/100+TtotalbalesweightOfpulpdrylap*90/100+TtotalbalesweightOfvirginpulp*90/100+Tyieldbroke*90/100+TtotalbalesweightOfstbaleswetlap*90/100)+(TyieldstbaleswetLap), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);*/
			
			col++;
			util.addValue(row, col++, ""+CommonUtil.round(totalbalesweightofVirginSoftWood, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(totalbalesweightofVirginHardWood, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round(totalbalesweightofVirginEucalyptus, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round((totalbalesweightofVirginSoftWood+totalbalesweightofVirginHardWood+totalbalesweightofVirginEucalyptus), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round((totalbalesweightofStvirginproduction/(totalbalesweightofVirginSoftWood+totalbalesweightofVirginHardWood+totalbalesweightofVirginSW_Fluff+totalbalesweightofVirginEucalyptus))*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
		
			col++;
			util.addValue(row, col++, ""+CommonUtil.round(TtotalbalesweightOfsow, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round((Tyieldtotalofpulpar4-TtotalbalesweightOfnewsblank), 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, ""+CommonUtil.round((TtotalbalesweightOfsow/(Tyieldtotalofpulpar4-TtotalbalesweightOfnewsblank))*100, 2), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			
		}
		util.write(outputStream);
	}

}
