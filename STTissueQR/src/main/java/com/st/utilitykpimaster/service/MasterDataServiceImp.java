/**
 * 
 */
package com.st.utilitykpimaster.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.common.exception.TrackerException;
import com.st.efficiency.dao.EfficiencyDao;
import com.st.efficiency.model.Efficiency;
import com.st.frppressquality.dao.FrpPressQualityDao;
import com.st.frppressquality.model.SludgeHauling;
import com.st.frpproduction.dao.FrpProdcutionDao;
import com.st.frpproduction.model.FrpProdcution;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;
import com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao;
import com.st.production.dao.MachineProductionDao;
import com.st.production.dao.WrapperProductionDao;
import com.st.production.model.MachineProduction;
import com.st.production.model.WrapperProduction;
import com.st.tracker.dao.BaleInventoryDao;
import com.st.utilitykpimaster.dao.MasterDataDao;
import com.st.utilitykpimaster.dao.UtilityDataDao;
import com.st.utilitykpimaster.model.MasterData;
import com.st.utilitykpimaster.model.UtilityData;

/**
 * @author sbora
 *
 */
@Service
public class MasterDataServiceImp implements MasterDataService {

	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
	
	@Autowired
	private UtilityDataDao utilityDataDao;
	
	@Autowired
	private WrapperProductionDao wrapperProductionDao;
	
	@Autowired
	private MachineProductionDao machineProductionDao;
	
	@Autowired
	private BaleInventoryDao baleInventoryDao;
	
	@Autowired
	private FrpProdcutionDao frpProdcutionDao;
	
	@Autowired
	private EfficiencyDao efficiencyDao;
	
	@Autowired
	private MasterDataDao masterDataDao;
	
	@Autowired
	private FrpProdcutionOperatorDataEntryDao prodcutionOperatorDataEntryDao;
	@Autowired
	private FrpPressQualityDao frpPressQualityDao;
	
	@Transactional
	@Override
	public int save(MasterData masterData) {
		return masterDataDao.save(masterData);
	}

	@Transactional
	@Override
	public void update(MasterData masterData) {
		masterDataDao.update(masterData);
	}

	@Transactional
	@Override
	public void delete(int id) {
		masterDataDao.delete(id);
	}

	@Transactional
	@Override
	public List<MasterData> getMasterDatasL31() {
		return masterDataDao.getMasterDatasL31();
	}

	@Transactional
	@Override
	public MasterData getMasterData(int id) {
		return masterDataDao.getMasterData(id);
	}

	@Transactional
	@Override
	public List<MasterData> getMasterDatas(Date sdate, Date edate) {
		return masterDataDao.getMasterDatas(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimaster.service.MasterDataService#getReportData(java.lang.Object, java.lang.String)
	 */
	
	@Transactional
	@Override
	public List<Map<String, String>> getReportData(Object data, String type)
			throws TrackerException, ProductionException {
		List<Map<String, String>> datas=new ArrayList<>();
		
		if(type.equalsIgnoreCase("U")){
			@SuppressWarnings("unchecked")
			List<UtilityData> utilityDatas=(List<UtilityData>) data;
			for (UtilityData utilityData : utilityDatas) {
				Map<String, String> map=new HashMap<String, String>();
				map.put(ColumnsOfTable.COL_01,utilityData.getId()+"");
				map.put(ColumnsOfTable.COL_02,dateFormat.format(utilityData.getDate()));
				map.put(ColumnsOfTable.COL_03,timeFormat.format(utilityData.getDate()));
				map.put(ColumnsOfTable.COL_04,utilityData.getLb60()+"");
				map.put(ColumnsOfTable.COL_05,utilityData.getConsumption1()+"");
				map.put(ColumnsOfTable.COL_06,utilityData.getLb150()+"");
				map.put(ColumnsOfTable.COL_07,utilityData.getConsumption2()+"");
				map.put(ColumnsOfTable.COL_08,utilityData.getMillWater()+"");
				map.put(ColumnsOfTable.COL_09,utilityData.getConsumption3()+"");
				map.put(ColumnsOfTable.COL_10,utilityData.getCondensate()+"");
				map.put(ColumnsOfTable.COL_11,utilityData.getConsumption4()+"");
				map.put(ColumnsOfTable.COL_12,utilityData.getRiverWater()+"");
				map.put(ColumnsOfTable.COL_13,utilityData.getRiverWaterData()+"");
				datas.add(map);
			}
		}else if(type.equalsIgnoreCase("M")){
			@SuppressWarnings("unchecked")
			List<MasterData> masterDatas=(List<MasterData>) data;
			
			
			
			for (MasterData masterData : masterDatas) {
				
				Calendar scal=Calendar.getInstance();
				scal.setTime(masterData.getDate());
				scal.set(Calendar.HOUR_OF_DAY, 7);
				scal.set(Calendar.MINUTE, 0);
				scal.set(Calendar.SECOND, 0);
				scal.set(Calendar.MILLISECOND, 0);
				
				Calendar ecal=Calendar.getInstance();
				ecal.setTime(masterData.getDate());
				ecal.set(Calendar.HOUR_OF_DAY, 6);
				ecal.set(Calendar.MINUTE, 59);
				ecal.set(Calendar.SECOND, 59);
				ecal.set(Calendar.MILLISECOND, 0);
				ecal.add(Calendar.DATE, 1);
				
				//Code Starts From Here Done By Roshan Tailor Date :- 03/21/2016
				
				
				System.out.println("masterData.getDate()::"+masterData.getDate());
				List<FrpProdcutionOperatorDataEntry> details=prodcutionOperatorDataEntryDao.getFrpProducationDataEntryDetailedReport(masterData.getDate(), masterData.getDate());
				double d=0;
				FrpProdcutionOperatorDataEntry operatorDataEntry=new FrpProdcutionOperatorDataEntry();
				if(details.size()>0){
					for(FrpProdcutionOperatorDataEntry s1 : details)
					{
						d = d+(s1.getCol5forday()+s1.getCol5fornight());
					}
					operatorDataEntry=details.get(0);
				}
				
				
				List<SludgeHauling> sludgeHaulings=frpPressQualityDao.getSludgeHauling(masterData.getDate(), masterData.getDate());
			
				SludgeHauling hauling=new SludgeHauling();
				if(sludgeHaulings.size()>0){
					hauling=sludgeHaulings.get(0);
				}
				//Code Ends Here Done By Roshan Tailor Date :- 03/21/2016
			//	System.out.println("Date"+masterData.getDate());
				
				UtilityData utilityData=null;
				
				List<UtilityData> utilityDatas=utilityDataDao.getPrevUtilityData(masterData.getDate(), masterData.getDate());
				if(utilityDatas.size()>0){
					if(utilityDatas.size()==1){
						utilityData=utilityDatas.get(0);
					}else{
						utilityData=utilityDatas.get(utilityDatas.size()-1);
					}
				}
						
		
				Map<String, String> map=new HashMap<String, String>();
				map.put(ColumnsOfTable.COL_01,masterData.getId()+"");
				map.put(ColumnsOfTable.COL_02,dateFormat.format(masterData.getDate()));
				
				double avgThp=masterData.getAvgThp();
				
				
				
				double prodBlead=0;
				double prodKraft=0;
				double prodSlabOff=0;
				
				
				List<MachineProduction> machineProductions=machineProductionDao.getMachineProductions(scal.getTime(),ecal.getTime());
				for (MachineProduction machineProduction : machineProductions) {
					String gradeCode=machineProduction.getGradeCode();
					if(StringUtils.isEmpty(gradeCode)){
						continue;
					}
					if(gradeCode!=null && gradeCode.length()>7){
						gradeCode=gradeCode.substring(gradeCode.indexOf("-")+1, gradeCode.length());
						gradeCode=gradeCode.substring(0,gradeCode.indexOf("-"));
						
						if(gradeCode.equalsIgnoreCase("98")){
							prodKraft+=machineProduction.getGoodWeight();
						}else{
							prodBlead+=machineProduction.getGoodWeight();
						}
					}
					
					prodSlabOff+=machineProduction.getRejectedWeight();
					
				}
				
				prodBlead=CommonUtil.round(prodBlead, 2);
				prodKraft=CommonUtil.round(prodKraft, 2);
				
				
				double prodWrapBlead=0;
				double prodWrapKraft=0;
				
				double prodProdWhite=0;
				double prodProdRed=0;
				double prodProdReject=0;
				
				
				List<WrapperProduction> wrapperProductions=wrapperProductionDao.getWrapperProductions(scal.getTime(),ecal.getTime());
				for (WrapperProduction wrapperProduction : wrapperProductions) {
					String gradeCode=wrapperProduction.getGradeCode();
					if(StringUtils.isEmpty(gradeCode)){
						continue;
					}
					if(gradeCode!=null && gradeCode.length()>7){
						gradeCode=gradeCode.substring(gradeCode.indexOf("-")+1, gradeCode.length());
						gradeCode=gradeCode.substring(0,gradeCode.indexOf("-"));
						
						if(gradeCode.equalsIgnoreCase("98")){
							prodWrapKraft+=wrapperProduction.getWhiteWeight()+wrapperProduction.getRedWeight();
						}else{
							prodWrapBlead+=wrapperProduction.getWhiteWeight()+wrapperProduction.getRedWeight();
						}
					}
					prodProdWhite+=wrapperProduction.getWhiteWeight();
					prodProdRed+=wrapperProduction.getRedWeight();
					prodProdReject+=wrapperProduction.getRejectWeight();
					
				}
				
				
				

				prodWrapKraft=CommonUtil.round(prodWrapKraft/2000, 2);
				prodWrapBlead=CommonUtil.round(prodWrapBlead/2000, 2);
				
				prodProdWhite=CommonUtil.round(prodProdWhite/2000, 2);
				prodProdRed=CommonUtil.round(prodProdRed/2000, 2);
				prodProdReject=CommonUtil.round(prodProdReject/2000, 2);
				
				
				
				//Calculated
			
				double prodWrapTotal=prodWrapKraft+prodWrapBlead;
				
				
				double naturalGasFlow=masterData.getNaturalGasFlow();
				double fiberLossSewerFlow=masterData.getFiberLossSewerFlow();
				double fiberLossSfConsy=masterData.getFiberLossSfConsy();
				double fiberLossWwToFrp=masterData.getFiberLossWwToFrp();
				double fiberLossWfFlow=masterData.getFiberLossWfFlow();
				
				// Wet lap from bale inventory
				double pulpWlap=baleInventoryDao.getConsumedWetLap(scal.getTime(), ecal.getTime());
				
				pulpWlap=CommonUtil.round(pulpWlap/2000, 2);
				
				//
				double energyElectrical=masterData.getEnergyElectrical();
				double pulpDataFromFrp=masterData.getPulpDataFromFrp();
				double pulpConsumedFromHd=masterData.getPulpConsumedFromHd();
				double pulpDataProdDcs=masterData.getPulpDataProdDcs();
				double pulpDataHdLevel=masterData.getPulpDataHdLevel();
				double pulpInHd=masterData.getPulpInHd();
		
				String tissueGrade=masterData.getTissueGrade();
				
				double naturalGasFlowDryend=masterData.getNaturalGasFlowDryend();
				
				
				
				
				
				map.put(ColumnsOfTable.COL_03,avgThp+"");
				map.put(ColumnsOfTable.COL_04,prodBlead+"");
				map.put(ColumnsOfTable.COL_05,prodKraft+"");
				map.put(ColumnsOfTable.COL_06,CommonUtil.round(prodSlabOff, 2)+"");
				map.put(ColumnsOfTable.COL_07,prodWrapBlead+"");
				map.put(ColumnsOfTable.COL_08,CommonUtil.round(prodWrapKraft, 2)+"");
				map.put(ColumnsOfTable.COL_09,CommonUtil.round(prodWrapTotal, 2)+"");
				map.put(ColumnsOfTable.COL_10,prodProdWhite+"");
				map.put(ColumnsOfTable.COL_11,prodProdRed+"");
				map.put(ColumnsOfTable.COL_12,prodProdReject+"");
				
				
				Efficiency efficiency=new Efficiency();
				Calendar sdate=Calendar.getInstance();
				sdate.setTime(masterData.getDate());
				sdate.set(Calendar.HOUR_OF_DAY, 7);
				sdate.set(Calendar.MINUTE, 0);
				sdate.set(Calendar.SECOND, 0);
				sdate.set(Calendar.MILLISECOND, 0);
				efficiency.setStartDate(sdate.getTime());
				
			
				Calendar edate=Calendar.getInstance();
				edate.setTime(masterData.getDate());
				edate.set(Calendar.HOUR_OF_DAY, 6);
				edate.set(Calendar.MINUTE, 59);
				edate.set(Calendar.SECOND, 59);
				edate.set(Calendar.MILLISECOND, 0);
				edate.add(Calendar.DATE,1);
				efficiency.setEndDate(edate.getTime());
				
				
			//	System.out.println("Start Date="+efficiency.getStartDate());
			//	System.out.println("End Date="+efficiency.getEndDate());
				
				List<Efficiency> efficiencies=efficiencyDao.getEfficiencies(efficiency);
				
				
				
				//Down time min Percent
				
				int downtimeMin=masterData.getDowntimeMin();
				if(downtimeMin==0){
					int mm=0;
					int hh=0;
					for (Efficiency efficiency2 : efficiencies) {
						
						if(efficiency2.getSecondaryCode().getPrimaryCode().getType()==3){
							//System.out.println("Skip ");
							continue; //For Out age
						}
						
						mm+=CommonUtil.getMinutesDuration(efficiency2.getStartTime(), efficiency2.getEndTime());
						hh+=CommonUtil.getHoursDuration(efficiency2.getStartTime(), efficiency2.getEndTime());
					}
				
					
					downtimeMin=mm+hh*60;
				}
			
				
				double dountimeMinPerc=((downtimeMin/24f/60)*100);
				map.put(ColumnsOfTable.COL_13,downtimeMin+"");
				map.put(ColumnsOfTable.COL_14,CommonUtil.round(dountimeMinPerc, 2)+"");
				

				//60lb
				int lb60Cons=0;
				int lb60Avg=0;
				long lb60Total=0;
				if(utilityData!=null){
					lb60Cons=utilityData.getConsumption1();
					lb60Avg=Math.round(lb60Cons/24f);
					if(prodWrapTotal!=0){
						lb60Total=Math.round(lb60Cons/prodWrapTotal);
					}
					
					
					map.put(ColumnsOfTable.COL_15,lb60Cons+"");
					map.put(ColumnsOfTable.COL_16,lb60Avg+"");
					map.put(ColumnsOfTable.COL_17,lb60Total+"");
				}else{
					map.put(ColumnsOfTable.COL_15,lb60Cons+"");
					map.put(ColumnsOfTable.COL_16,lb60Avg+"");
					map.put(ColumnsOfTable.COL_17,lb60Total+"");
				}
				
				
				//150lb
				int lb150Cons=0;
				int lb150Avg=0;
				long lb150Total=0;
				if(utilityData!=null){
					lb150Cons=utilityData.getConsumption2();
					lb150Avg=Math.round(lb150Cons/24f);
					if(prodWrapTotal!=0){
						lb150Total=Math.round(lb150Cons/prodWrapTotal);
					}
					
					
					map.put(ColumnsOfTable.COL_18,lb150Cons+"");
					map.put(ColumnsOfTable.COL_19,lb150Avg+"");
					map.put(ColumnsOfTable.COL_20,lb150Total+"");
				}else{
					map.put(ColumnsOfTable.COL_18,lb150Cons+"");
					map.put(ColumnsOfTable.COL_19,lb150Avg+"");
					map.put(ColumnsOfTable.COL_20,lb150Total+"");
				}
				
				//Cond Flow
				int cons=0;
				double consFlow=0;
				if(utilityData!=null){
					cons=utilityData.getConsumption4();
					consFlow=(cons/(Math.pow(10, 6)));
					map.put(ColumnsOfTable.COL_21,CommonUtil.round(consFlow, 2)+"");
				}else{
					map.put(ColumnsOfTable.COL_21,CommonUtil.round(consFlow, 2)+"");
				}
				
				
				double naturalGasT=0;
				if(prodWrapTotal!=0){
					naturalGasT=((naturalGasFlow+naturalGasFlowDryend)/prodWrapTotal);
				}
				
				map.put(ColumnsOfTable.COL_22,naturalGasFlow+"");
				map.put(ColumnsOfTable.COL_23,CommonUtil.round(naturalGasT, 2)+"");
				
				int consMillWater=0;
				double totalCons=0;
				double gallonsT=0;
				if(utilityData!=null){
					consMillWater=utilityData.getConsumption3();
					totalCons=(consMillWater/(Math.pow(10, 6)));
					if(prodWrapTotal!=0){
						gallonsT=((totalCons/prodWrapTotal)*(Math.pow(10, 6)));
					}
					
					map.put(ColumnsOfTable.COL_24,CommonUtil.round(totalCons, 2)+"");
					map.put(ColumnsOfTable.COL_25,Math.round(gallonsT)+"");
				}else{
					map.put(ColumnsOfTable.COL_24,"0");
					map.put(ColumnsOfTable.COL_25,"0");
				}
				
				//Fiber Lose
				
				double fiberLossServerFlowT=(((fiberLossSewerFlow*Math.pow(10, 6)*3.785)*(fiberLossSfConsy/100))*1.12)/1000;

				map.put(ColumnsOfTable.COL_26,fiberLossSewerFlow+"");
				map.put(ColumnsOfTable.COL_27,fiberLossSfConsy+"");
				map.put(ColumnsOfTable.COL_28,CommonUtil.round(fiberLossServerFlowT, 2)+"");
				
				
				double fiberLossWwToFrpT=(((fiberLossWwToFrp*1000000*3.785)*(fiberLossWfFlow/100))*1.102)/1000;
				
				
				map.put(ColumnsOfTable.COL_29,fiberLossWwToFrp+"");
				/*map.put(ColumnsOfTable.COL_29,CommonUtil.round(fiberLossWwToFrpT, 2)+"");*/
				map.put(ColumnsOfTable.COL_30,fiberLossWfFlow+"");
				map.put(ColumnsOfTable.COL_31,CommonUtil.round(fiberLossWwToFrpT, 2)+"");
				
				double fiberlossTotal=fiberLossWwToFrpT+fiberLossServerFlowT;
				map.put(ColumnsOfTable.COL_32,CommonUtil.round((fiberlossTotal), 2)+"");
				
				
				
				//Consumed Stock
				map.put(ColumnsOfTable.COL_35,masterData.getConsumedStock()+"");
				
				
				
				double pulpWlapT=(((fiberLossWwToFrpT+fiberLossServerFlowT)/0.9)+(prodWrapTotal/0.95));
				map.put(ColumnsOfTable.COL_33,pulpWlap+"");
				map.put(ColumnsOfTable.COL_34,CommonUtil.round(pulpWlapT, 2)+"");
				
				FrpProdcution kraftFrpProdcution=null;
				List<FrpProdcution> kraftFrpProdcutions=frpProdcutionDao.getFrpProdcutions(masterData.getDate(), masterData.getDate(), "KF","");
				if(kraftFrpProdcutions!=null && kraftFrpProdcutions.size()>0){
					kraftFrpProdcution=kraftFrpProdcutions.get(kraftFrpProdcutions.size()-1);
				}
				
				FrpProdcution whiteFrpProdcution=null;
				List<FrpProdcution> whiteFrpProdcutions=frpProdcutionDao.getFrpProdcutions(masterData.getDate(), masterData.getDate(), "BW","");
				if(whiteFrpProdcutions!=null && whiteFrpProdcutions.size()>0){
					whiteFrpProdcution=whiteFrpProdcutions.get(whiteFrpProdcutions.size()-1);
				}
				
				
				double freshWater=0;
				double dcsFRPProduction=0;
				double dcsWastePaperFeed=0;
				double wetLapProductionADST=0;
				
				//Total Production ADST White
				if(whiteFrpProdcution!=null){
					map.put(ColumnsOfTable.COL_36,whiteFrpProdcution.getTotalProdADST()+"");
					freshWater=whiteFrpProdcution.getFreshWater();
					
					dcsFRPProduction+=whiteFrpProdcution.getTotalProdADST();
					wetLapProductionADST+=whiteFrpProdcution.getWetLapProdADST();
					
				}else{
					map.put(ColumnsOfTable.COL_36,"0");
				}
				
				//Total Production ADST Kraft
				if(kraftFrpProdcution!=null){
					map.put(ColumnsOfTable.COL_37,kraftFrpProdcution.getTotalProdADST()+"");
					if(freshWater==0){
						freshWater=kraftFrpProdcution.getFreshWater();
					}
					
					wetLapProductionADST+=kraftFrpProdcution.getWetLapProdADST();
					dcsFRPProduction+=kraftFrpProdcution.getTotalProdADST();
				}else{
					map.put(ColumnsOfTable.COL_37,"0");
				}
				
				
				//FRP Production ADT --  	Wet lap			
				map.put(ColumnsOfTable.COL_38,""+CommonUtil.round(wetLapProductionADST, 2));
				
				
				
				
				//DCS Wastepaper feed ADST -- white
				if(whiteFrpProdcution!=null){
					map.put(ColumnsOfTable.COL_39,whiteFrpProdcution.getDcsWPFeedADST()+"");
					dcsWastePaperFeed+=whiteFrpProdcution.getDcsWPFeedADST();
				}else{
					map.put(ColumnsOfTable.COL_39,"0");
				}
				
				//DCS Wastepaper feed ADST -- Kraft
				if(kraftFrpProdcution!=null){
					map.put(ColumnsOfTable.COL_40,kraftFrpProdcution.getDcsWPFeedADST()+"");
					dcsWastePaperFeed+=kraftFrpProdcution.getDcsWPFeedADST();
				}else{
					map.put(ColumnsOfTable.COL_40,"0");
				}
				
				
				//FRP Water usage
				map.put(ColumnsOfTable.COL_41,CommonUtil.round((freshWater/1000000), 3)+"");
				
				
				
				//Tissue grade
				map.put(ColumnsOfTable.COL_42,tissueGrade==null?"":tissueGrade);
				
				//DCS FRP Production
				map.put(ColumnsOfTable.COL_43,CommonUtil.round(dcsFRPProduction, 2)+"");
				
				//DCS Waste paper feed
				map.put(ColumnsOfTable.COL_44,CommonUtil.round(dcsWastePaperFeed, 2)+"");
				
				double yieldPrec=0;
				if(dcsWastePaperFeed!=0){
					yieldPrec=(dcsFRPProduction/dcsWastePaperFeed)*100;
				}
				map.put(ColumnsOfTable.COL_45,CommonUtil.round(yieldPrec, 2)+"");
				
				
				//FRP MIX DATA
				
				double mwl=0;
				double pmix=0;
				double cbs=0;
				double ctdGdwd=0;
				double swl=0;
				double newsNewsBank=0;
				double sow=0;
				double sow_cbs=0;
				double sbs=0;
				double whitegrade=0;
				double occ=0;
				double dlk=0;
				double mixedpaper=0;
				double other=0;
				
				if(whiteFrpProdcution!=null){
					mwl+=whiteFrpProdcution.getWpmMwl();
					pmix+=whiteFrpProdcution.getWpmPrintMix();
					cbs+=whiteFrpProdcution.getWpmCbs();
					ctdGdwd+=whiteFrpProdcution.getWpmCtdGrwd();
					swl+=whiteFrpProdcution.getWpmSwl();
					sow+=whiteFrpProdcution.getWpmSow();
					occ+=whiteFrpProdcution.getWpmOcc();
					other+=whiteFrpProdcution.getWpmOther();
					
				}
				
				if(kraftFrpProdcution!=null){
					mwl+=kraftFrpProdcution.getWpmMwl();
					pmix+=kraftFrpProdcution.getWpmPrintMix();
					swl+=kraftFrpProdcution.getWpmSwl();
					sow_cbs+=kraftFrpProdcution.getWpmSowAndCbs();
					newsNewsBank+=kraftFrpProdcution.getWpmNewsNewsblank();
					ctdGdwd+=kraftFrpProdcution.getWpmCtdGrwd();
					occ+=kraftFrpProdcution.getWpmOcc();
					dlk+=kraftFrpProdcution.getWpmDlk();
					other+=kraftFrpProdcution.getWpmOther();
				}
				
				
				map.put(ColumnsOfTable.COL_46,CommonUtil.round(mwl, 2)+"");
				map.put(ColumnsOfTable.COL_47,CommonUtil.round(pmix, 2)+"");
				map.put(ColumnsOfTable.COL_48,CommonUtil.round(cbs, 2)+"");
				map.put(ColumnsOfTable.COL_49,CommonUtil.round(ctdGdwd, 2)+"");
				map.put(ColumnsOfTable.COL_50,CommonUtil.round(swl, 2)+"");
				map.put(ColumnsOfTable.COL_51,CommonUtil.round(newsNewsBank, 2)+"");
				map.put(ColumnsOfTable.COL_52,CommonUtil.round(sow, 2)+"");
				map.put(ColumnsOfTable.COL_53,CommonUtil.round(sow_cbs, 2)+"");
				map.put(ColumnsOfTable.COL_54,CommonUtil.round(sbs, 2)+"");
				map.put(ColumnsOfTable.COL_55,CommonUtil.round(whitegrade, 2)+"");
				map.put(ColumnsOfTable.COL_56,CommonUtil.round(occ, 2)+"");
				map.put(ColumnsOfTable.COL_57,CommonUtil.round(dlk, 2)+"");
				map.put(ColumnsOfTable.COL_58,CommonUtil.round(mixedpaper, 2)+"");
				map.put(ColumnsOfTable.COL_59,CommonUtil.round(other, 2)+"");
				
				double totalWhite=mwl+pmix+cbs+swl+sbs+whitegrade+sow;

				double totalKraft=ctdGdwd+newsNewsBank+occ+dlk+other+sow_cbs;
				
				map.put(ColumnsOfTable.COL_60,CommonUtil.round(totalWhite, 2)+"");
				map.put(ColumnsOfTable.COL_61,CommonUtil.round(totalKraft, 2)+"");
				
				
				double totalWhiteKraft=(totalKraft+totalWhite);
				
				double yieldPercMixData=0;
				if(totalWhiteKraft!=0){
					yieldPercMixData=(dcsFRPProduction/totalWhiteKraft)*100;
				}
				
				
				map.put(ColumnsOfTable.COL_62,CommonUtil.round(yieldPercMixData, 2)+"");
				
				//60lb Steam
				double lb60Steam=0;
				if(prodBlead>0 || prodKraft>0){
					lb60Steam=(((lb60Avg*1183)*0.00029307107)/((prodBlead+prodKraft)/24));
				}
				map.put(ColumnsOfTable.COL_63,Math.round(lb60Steam)+"");
				
				//150lb Steam
				double lb150Steam=0;
				if(prodBlead>0 || prodKraft>0){
					lb150Steam=(((lb150Avg*1196)*0.00029307107)/((prodBlead+prodKraft)/24));
				}
				map.put(ColumnsOfTable.COL_64,Math.round(lb150Steam)+"");
				
				//Natural Gas
				double naturalGas=0;
				if(prodBlead>0 || prodKraft>0){
					naturalGas=((consFlow+naturalGasFlow)*293.07107)/(prodBlead+prodKraft);
				}
				map.put(ColumnsOfTable.COL_65,Math.round(naturalGas)+"");
				
				
				//Electrical
				map.put(ColumnsOfTable.COL_66,Math.round(energyElectrical)+"");
				
				//Electrical T
				double electricalT=0;
				if(prodBlead>0 || prodKraft>0){
					electricalT=(energyElectrical/(prodBlead+prodKraft));
				}
				map.put(ColumnsOfTable.COL_67,Math.round(electricalT)+"");
				
				//Electrical Total
				double electricalTotal=lb60Steam+lb150Steam+naturalGas+electricalT;
				map.put(ColumnsOfTable.COL_68,Math.round(electricalTotal)+"");
				
				
				
				//Total Steam
				double totalSteam=(lb60Cons+lb150Cons)/1000;
				map.put(ColumnsOfTable.COL_69,Math.round(totalSteam)+"");
				
				double condensateEfficiency=0;
				if(utilityData!=null){
					condensateEfficiency=utilityData.getConsumption4();
				}
				map.put(ColumnsOfTable.COL_70,Math.round(condensateEfficiency)+"");
				
				//Avg Daily Power Cost
				double dailyAvgPowerCost=0.461/30/24+0.0468;
				map.put(ColumnsOfTable.COL_71,CommonUtil.round(dailyAvgPowerCost, 4)+"");
				
				//Efficiency
				double efficienyPerc=0;
				if(totalSteam!=0){
					efficienyPerc=(condensateEfficiency*8.33/totalSteam/1000)*100;
				}
				if(Double.isInfinite(efficienyPerc) || Double.isNaN(efficienyPerc)){
					efficienyPerc=0;
				}
				
				map.put(ColumnsOfTable.COL_72,CommonUtil.round(efficienyPerc, 2)+"");
				
				
				
				//Pulp from FRP
				map.put(ColumnsOfTable.COL_73,CommonUtil.round(pulpDataFromFrp, 2)+"");
				
				//M/c consumed from HD Chest
				map.put(ColumnsOfTable.COL_74,CommonUtil.round(pulpConsumedFromHd, 2)+"");
				
				//M/c prod DCS
				map.put(ColumnsOfTable.COL_75,CommonUtil.round(pulpDataProdDcs, 2)+"");
				
				//M/c consumed from HD Chest
				map.put(ColumnsOfTable.COL_76,CommonUtil.round(pulpDataHdLevel, 2)+"");
				
				//HD Level @ 8:00 AM
				map.put(ColumnsOfTable.COL_77,pulpInHd+"");
				
				double pulpdataLast=((pulpDataFromFrp-((prodKraft/0.95)+(fiberlossTotal/0.9)-pulpWlap)));
				map.put(ColumnsOfTable.COL_78,CommonUtil.round(pulpdataLast, 2)+"");
				
				
				
				//New Columns Chemical
				
				map.put(ColumnsOfTable.COL_79,CommonUtil.round(masterData.getChemWetStrength(), 2)+"");
				map.put(ColumnsOfTable.COL_80,CommonUtil.round(masterData.getChemRelease(), 2)+"");
				map.put(ColumnsOfTable.COL_81,CommonUtil.round(masterData.getChemAdhesive(), 2)+"");
				map.put(ColumnsOfTable.COL_82,CommonUtil.round(masterData.getChemMap(), 2)+"");
				map.put(ColumnsOfTable.COL_83,CommonUtil.round(masterData.getChemDefoamer(), 2)+"");
				map.put(ColumnsOfTable.COL_84,CommonUtil.round(masterData.getChemPassivator(), 2)+"");
				
				//Code Starts From Here Done By Roshan Tailor Date:- 03/21/2016
				//map.put(ColumnsOfTable.COL_85,operatorDataEntry.getTotalcol5()+"");
				map.put(ColumnsOfTable.COL_85,d+"");
					//System.out.println("operatorDataEntry.getCol5()::"+operatorDataEntry.getTotalcol5());
				map.put(ColumnsOfTable.COL_86,CommonUtil.round(hauling.getEffluentConsistency(), 2)+"");
					//System.out.println("CommonUtil.round(hauling.getEffluentConsistency()::"+CommonUtil.round(hauling.getEffluentConsistency(), 2));
				
				//Old Formula For FRP Fiber loss
				/*double fiberLossForEffluentNConsistency=(((operatorDataEntry.getTotalcol5()*3.785)*(CommonUtil.round(hauling.getEffluentConsistency(), 2)/100))*1.102)/1000;
				System.out.println("fiberLossForEffluentNConsistency::"+fiberLossForEffluentNConsistency);*/
				
				//New Formula For FRP Fiber loss
				d=(d/(Math.pow(10, 6)));
				double fiberLossForEffluentNConsistency=(((d*1000000*3.785)*(hauling.getEffluentConsistency()/100))*1.102)/1000;
				map.put(ColumnsOfTable.COL_87,CommonUtil.round(fiberLossForEffluentNConsistency, 2)+"");
				//Code Ends Here Done By Roshan Tailor Date :- 03/21/2016
				datas.add(map);
			}
		}else if(type.equalsIgnoreCase("K")){
			@SuppressWarnings("unchecked")
			List<MasterData> masterDatas=(List<MasterData>) data;
			
			for (MasterData masterData : masterDatas) {
				
				
				Calendar scal=Calendar.getInstance();
				scal.setTime(masterData.getDate());
				scal.set(Calendar.HOUR_OF_DAY, 7);
				scal.set(Calendar.MINUTE, 0);
				scal.set(Calendar.SECOND, 0);
				scal.set(Calendar.MILLISECOND, 0);
				
				Calendar ecal=Calendar.getInstance();
				ecal.setTime(masterData.getDate());
				ecal.set(Calendar.HOUR_OF_DAY, 6);
				ecal.set(Calendar.MINUTE, 59);
				ecal.set(Calendar.SECOND, 59);
				ecal.set(Calendar.MILLISECOND, 0);
				ecal.add(Calendar.DATE, 1);
				
				UtilityData utilityData=null;
				
				List<UtilityData> utilityDatas=utilityDataDao.getPrevUtilityData(masterData.getDate(), masterData.getDate());
				if(utilityDatas.size()>0){
					if(utilityDatas.size()==1){
						utilityData=utilityDatas.get(0);
					}else{
						utilityData=utilityDatas.get(utilityDatas.size()-1);
					}
				}
						
				
				
				
			//	double avgThp=masterData.getAvgThp();
				double prodBlead=0;
				double prodKraft=0;
				double prodSlabOff=0;
				
				
				List<MachineProduction> machineProductions=machineProductionDao.getMachineProductions(scal.getTime(),ecal.getTime());
				for (MachineProduction machineProduction : machineProductions) {
					String gradeCode=machineProduction.getGradeCode();
					if(StringUtils.isEmpty(gradeCode)){
						continue;
					}
					if(gradeCode!=null && gradeCode.length()>7){
						gradeCode=gradeCode.substring(gradeCode.indexOf("-")+1, gradeCode.length());
						gradeCode=gradeCode.substring(0,gradeCode.indexOf("-"));
						
						if(gradeCode.equalsIgnoreCase("98")){
							prodKraft+=machineProduction.getGoodWeight();
						}else{
							prodBlead+=machineProduction.getGoodWeight();
						}
						
					}
					prodSlabOff+=machineProduction.getRejectedWeight();
				}
				
				prodBlead=CommonUtil.round(prodBlead, 2);
				prodKraft=CommonUtil.round(prodKraft, 2);
				
				double prodProdWhite=0;
				double prodProdRed=0;
				double prodProdReject=0;
				
				double prodWrapKraft=0;
				double prodWrapBlead=0;
				
				List<WrapperProduction> wrapperProductions=wrapperProductionDao.getWrapperProductions(scal.getTime(),ecal.getTime());
				for (WrapperProduction wrapperProduction : wrapperProductions) {
					String gradeCode=wrapperProduction.getGradeCode();
					if(StringUtils.isEmpty(gradeCode)){
						continue;
					}
					if(gradeCode!=null && gradeCode.length()>7){
						gradeCode=gradeCode.substring(gradeCode.indexOf("-")+1, gradeCode.length());
						gradeCode=gradeCode.substring(0,gradeCode.indexOf("-"));
						
						if(gradeCode.equalsIgnoreCase("98")){
							prodWrapKraft+=wrapperProduction.getWhiteWeight()+wrapperProduction.getRedWeight();
						}else{
							prodWrapBlead+=wrapperProduction.getWhiteWeight()+wrapperProduction.getRedWeight();
						}
					}
					prodProdWhite+=wrapperProduction.getWhiteWeight();
					prodProdRed+=wrapperProduction.getRedWeight();
					prodProdReject+=wrapperProduction.getRejectWeight();
					
				}
				

				prodWrapKraft=CommonUtil.round(prodWrapKraft/2000, 2);
				prodWrapBlead=CommonUtil.round(prodWrapBlead/2000, 2);
				
				
				//System.out.println(scal.getTime()+"\t"+ecal.getTime()+"\t Kraft="+prodWrapKraft+"\tWhite="+prodWrapBlead);
				
				prodProdWhite=CommonUtil.round(prodProdWhite/2000, 2);
				prodProdRed=CommonUtil.round(prodProdRed/2000, 2);
				prodProdReject=CommonUtil.round(prodProdReject/2000, 2);

				//Calculated
				
				double prodWrapTotal=prodWrapKraft+prodWrapBlead;
				
				
				double naturalGasFlow=masterData.getNaturalGasFlow();
				double fiberLossSewerFlow=masterData.getFiberLossSewerFlow();
				double fiberLossSfConsy=masterData.getFiberLossSfConsy();
				double fiberLossWwToFrp=masterData.getFiberLossWwToFrp();
				double fiberLossWfFlow=masterData.getFiberLossWfFlow();
			
				double energyElectrical=masterData.getEnergyElectrical();
			
				double naturalGasFlowDryend=masterData.getNaturalGasFlowDryend();
				
				double COD=masterData.getCoddischarge();
				

				Efficiency efficiency=new Efficiency();
				Calendar sdate=Calendar.getInstance();
				sdate.setTime(masterData.getDate());
				sdate.set(Calendar.HOUR_OF_DAY, 7);
				sdate.set(Calendar.MINUTE, 0);
				sdate.set(Calendar.SECOND, 0);
				sdate.set(Calendar.MILLISECOND, 0);
				efficiency.setStartDate(sdate.getTime());
				
			
				Calendar edate=Calendar.getInstance();
				edate.setTime(masterData.getDate());
				edate.set(Calendar.HOUR_OF_DAY, 6);
				edate.set(Calendar.MINUTE, 59);
				edate.set(Calendar.SECOND, 59);
				edate.set(Calendar.MILLISECOND, 0);
				edate.add(Calendar.DATE,1);
				efficiency.setEndDate(edate.getTime());
				
				List<Efficiency> efficiencies=efficiencyDao.getEfficiencies(efficiency);
				
				
				
				//Down time min Percent
				int downtimeMin=masterData.getDowntimeMin();
				if(downtimeMin==0){
					int mm=0;
					int hh=0;
					for (Efficiency efficiency2 : efficiencies) {
						if(efficiency2.getSecondaryCode().getPrimaryCode().getType()==3){
							
							continue; //For Out age
						}
						mm+=CommonUtil.getMinutesDuration(efficiency2.getStartTime(), efficiency2.getEndTime());
						hh+=CommonUtil.getHoursDuration(efficiency2.getStartTime(), efficiency2.getEndTime());
					}
				//	System.out.println(hh+"\t"+mm);
					
					downtimeMin=mm+hh*60;
				}
				
				
			//	double dountimeMinPerc=((downtimeMin/24f/60)*100);
				

				//60lb
				int lb60Cons=0;
				int lb60Avg=0;
				long lb60Total=0;
				if(utilityData!=null){
					lb60Cons=utilityData.getConsumption1();
					lb60Avg=Math.round(lb60Cons/24f);
					if(prodWrapTotal!=0){
						lb60Total=Math.round(lb60Cons/prodWrapTotal);	
					}
						
				}
				
				
				//150lb
				int lb150Cons=0;
				int lb150Avg=0;
				long lb150Total=0;
				if(utilityData!=null){
					lb150Cons=utilityData.getConsumption2();
					lb150Avg=Math.round(lb150Cons/22f);
					if(prodWrapTotal!=0){
						lb150Total=Math.round(lb150Cons/prodWrapTotal);
					}
					
				}
				
				//Cond Flow
				int cons=0;
				double consFlow=0;
				if(utilityData!=null){
					cons=utilityData.getConsumption4();
					consFlow=(cons/(Math.pow(10, 6)));
				}
				
				
				double naturalGasT=0;
				if(prodWrapTotal!=0){
					naturalGasT=((naturalGasFlow+naturalGasFlowDryend)/prodWrapTotal);
				}
				
				
				int consMillWater=0;
				double totalCons=0;
				double gallonsT=0;
				if(utilityData!=null){
					consMillWater=utilityData.getConsumption3();
					totalCons=(consMillWater/(Math.pow(10, 6)));
					if(prodWrapTotal!=0){
						gallonsT=((totalCons/prodWrapTotal)*(Math.pow(10, 6)));
					}
					
				}
				
				//Fiber Lose
				
				double fiberLossServerFlowT=(((fiberLossSewerFlow*Math.pow(10, 6)*3.785)*(fiberLossSfConsy/100))*1.12)/1000;

				
				double fiberLossWwToFrpT=(((fiberLossWwToFrp*1000000*3.785)*(fiberLossWfFlow/100))*1.12)/1000;
				
				//double fiberlossTotal=fiberLossWwToFrpT+fiberLossServerFlowT;
				
				
			
				
				
				//60lb Steam
				double lb60Steam=0;
				if(prodBlead>0 || prodKraft>0){
					lb60Steam=(((lb60Avg*1183)*0.00029307107)/((prodBlead+prodKraft)/24));
				}
				
				//150lb Steam
				double lb150Steam=0;
				if(prodBlead>0 || prodKraft>0){
					lb150Steam=(((lb150Avg*1196)*0.00029307107)/((prodBlead+prodKraft)/24));
				}
				
				//Natural Gas
				double naturalGas=0;
				if(prodBlead>0 || prodKraft>0){
					 naturalGas=((consFlow+naturalGasFlow)*293.07107)/(prodBlead+prodKraft);
				}
				
				//Electrical
				
				//Electrical T
				double electricalT=0;
				if(prodBlead>0 || prodKraft>0){
					electricalT=(energyElectrical/(prodBlead+prodKraft));
				}
				
				//Electrical Total
				double electricalTotal=lb60Steam+lb150Steam+naturalGas+electricalT;
				
				
				
				//Total Steam
				double totalSteam=(lb60Cons+lb150Cons)/1000;
				
				double condensateEfficiency=0;
				if(utilityData!=null){
					condensateEfficiency=utilityData.getConsumption4();
				}
				
				//Avg Daily Power Cost
			//	double dailyAvgPowerCost=0.461/30/24+0.0468;
				
				//Efficiency
				double efficienyPerc=0;
				if(totalSteam!=0){
					efficienyPerc=(condensateEfficiency*8.33/totalSteam/1000)*100;
				}
				if(Double.isInfinite(efficienyPerc) || Double.isNaN(efficienyPerc)){
					efficienyPerc=0;
				}
				
			//	double pulpdataLast=((pulpDataFromFrp-((prodKraft/0.95)+(fiberlossTotal/0.9)-pulpWlap)));
				
				
				
				///KPI Report
				double machineProdActual=(prodBlead+prodKraft);
				double effUptime=((1440-downtimeMin)/1440f);
				double effQuality=0;
				if(prodWrapTotal!=0){
					effQuality=(prodProdWhite/prodWrapTotal);
				}
				double effYield=0;
				if(machineProdActual!=0){
					 effYield=(prodWrapTotal/machineProdActual);
				}
				double effTotal=effUptime*effQuality*effYield;
				
				Map<String, String> map=new HashMap<String, String>();
				map.put(ColumnsOfTable.COL_01,dateFormat.format(masterData.getDate()));
				
				map.put(ColumnsOfTable.COL_02,CommonUtil.round(machineProdActual, 2)+"");
				map.put(ColumnsOfTable.COL_03,CommonUtil.round(prodSlabOff, 2)+"");
				map.put(ColumnsOfTable.COL_04,CommonUtil.round(prodProdWhite, 2)+"");
				map.put(ColumnsOfTable.COL_05,CommonUtil.round(prodProdRed, 2)+"");
				map.put(ColumnsOfTable.COL_06,CommonUtil.round(prodProdReject, 2)+"");
				map.put(ColumnsOfTable.COL_07,CommonUtil.round(prodWrapTotal, 2)+"");
				
				map.put(ColumnsOfTable.COL_08,CommonUtil.round(effUptime*100, 2)+"");
				map.put(ColumnsOfTable.COL_09,CommonUtil.round(effQuality*100, 2)+"");
				map.put(ColumnsOfTable.COL_10,CommonUtil.round(effYield*100, 2)+"");
				map.put(ColumnsOfTable.COL_11,CommonUtil.round(effTotal*100, 2)+"");
				
				
				map.put(ColumnsOfTable.COL_12,Math.round(gallonsT)+"");
				map.put(ColumnsOfTable.COL_13,CommonUtil.round(fiberLossServerFlowT,2)+"");
				map.put(ColumnsOfTable.COL_14,CommonUtil.round(fiberLossWwToFrpT,2)+"");
				
				map.put(ColumnsOfTable.COL_15,Math.round(lb60Total)+"");
				map.put(ColumnsOfTable.COL_16,Math.round(lb150Total)+"");
				map.put(ColumnsOfTable.COL_17,CommonUtil.round(naturalGasT,2)+"");
				
				map.put(ColumnsOfTable.COL_18,CommonUtil.round(efficienyPerc,2)+"");
				
				map.put(ColumnsOfTable.COL_19,Math.round(lb60Steam)+"");
				map.put(ColumnsOfTable.COL_20,Math.round(lb150Steam)+"");
				map.put(ColumnsOfTable.COL_21,Math.round(naturalGas)+"");
				map.put(ColumnsOfTable.COL_22,Math.round(electricalT)+"");
				map.put(ColumnsOfTable.COL_23,Math.round(electricalTotal)+"");
				
				
				//TempField
				map.put(ColumnsOfTable.COL_24,downtimeMin+"");
				
				map.put(ColumnsOfTable.COL_25,prodWrapKraft+"");
				
				map.put(ColumnsOfTable.COL_26,prodWrapBlead+"");
				
				
				
				//Mill Water new
				map.put(ColumnsOfTable.COL_27,CommonUtil.round(totalCons, 2)+"");
								
				
				
				//Code Starts From Here Done By Roshan Tailor Date:- 03/21/2016
				List<FrpProdcutionOperatorDataEntry> details=prodcutionOperatorDataEntryDao.getFrpProducationDataEntryDetailedReport(masterData.getDate(), masterData.getDate());
				
				FrpProdcutionOperatorDataEntry operatorDataEntry=new FrpProdcutionOperatorDataEntry();
				double d=0;
				if(details.size()>0){
					for(FrpProdcutionOperatorDataEntry s1 : details)
					{
						d = d+(s1.getCol5forday()+s1.getCol5fornight());
					}
					operatorDataEntry=details.get(0);
				}
				
				List<SludgeHauling> sludgeHaulings=frpPressQualityDao.getSludgeHauling(masterData.getDate(), masterData.getDate());
				
				SludgeHauling hauling=new SludgeHauling();
				if(sludgeHaulings.size()>0){
					hauling=sludgeHaulings.get(0);
				}
				
				map.put(ColumnsOfTable.COL_28,operatorDataEntry.getTotalcol5()+"");
					//System.out.println("operatorDataEntry.getCol5()::"+operatorDataEntry.getTotalcol5());
				map.put(ColumnsOfTable.COL_29,CommonUtil.round(hauling.getEffluentConsistency(), 2)+"");
					//System.out.println("CommonUtil.round(hauling.getEffluentConsistency()::"+CommonUtil.round(hauling.getEffluentConsistency(), 2));
				//double fiberLossForEffluentNConsistency=(((operatorDataEntry.getTotalcol5()*3.785)*(CommonUtil.round(hauling.getEffluentConsistency(), 2)/100))*1.102)/1000;
				double fiberLossForEffluentNConsistency=(((d*3.785)*(CommonUtil.round(hauling.getEffluentConsistency(), 2)/100))*1.102)/1000;
					//System.out.println("fiberLossForEffluentNConsistency::"+fiberLossForEffluentNConsistency);
				map.put(ColumnsOfTable.COL_30,CommonUtil.round(fiberLossForEffluentNConsistency, 2)+"");
				//Code Ends Here Done By Roshan Tailor Date :- 03/21/2016
				
				
				//Showing River Data From Here
				double rwmg=0;
				for (UtilityData utilityDataRiver : utilityDatas) {
					
					rwmg=utilityDataRiver.getRiverWaterData()/(Math.pow(10, 6));
					//System.out.println("River::"+utilityDataRiver.getRiverWaterData()+"And rwmg::"+rwmg);
					double finalrwmg=CommonUtil.round(rwmg, 3);
					map.put(ColumnsOfTable.COL_31,finalrwmg+"");
					//double RiverwaterGalT=CommonUtil.round((((operatorDataEntry.getTotalcol5()*3.785)*(CommonUtil.round(utilityDataRiver.getRiverWaterData(), 2)/100))*1.102)/1000, 2);
					
					//Old Formula
					/*double RiverwaterGalT=CommonUtil.round(((((operatorDataEntry.getTotalcol5()*3.785)*(CommonUtil.round(utilityDataRiver.getRiverWaterData(), 2)/100))*1.102)/1000)/1000000, 2);
					map.put(ColumnsOfTable.COL_32,CommonUtil.round(RiverwaterGalT, 3)+"");*/
				
					//New Formula
					double totalCons1=utilityDataRiver.getRiverWaterData()/(Math.pow(10, 6));
					double RiverwaterGalT=((totalCons1/prodWrapTotal)*(Math.pow(10, 6)));
					map.put(ColumnsOfTable.COL_32,CommonUtil.round(RiverwaterGalT, 0)+"");
			}
				
				
				//map.put(ColumnsOfTable.COL_33,CommonUtil.round(fiberLossServerFlowT/fiberLossForEffluentNConsistency*COD*1000000*0.0000022046*3.78541, 2)+"");
				map.put(ColumnsOfTable.COL_33,CommonUtil.round(CommonUtil.round(fiberLossServerFlowT, 2)*COD*1000000*0.0000022046*3.78541, 2)+"");
				
				
				datas.add(map);
				
				
				
			}
		}
		return datas;
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimaster.service.MasterDataService#getMasterDatasBetweenDate(java.util.Date, java.util.Date)
	 */
	@Override
	@Transactional
	public List<MasterData> getMasterDatasBetweenDate(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return masterDataDao.getMasterDatasBetweenDate(sdate,edate);
	}

}
