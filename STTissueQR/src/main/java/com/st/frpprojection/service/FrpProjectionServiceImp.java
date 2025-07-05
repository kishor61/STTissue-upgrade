/**
 * 
 */
package com.st.frpprojection.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.common.CommonProperties;
import com.st.common.CommonUtil;
import com.st.frpprojection.dao.FrpProjectionDao;
import com.st.frpprojection.model.FrpProjection;
import com.st.frpprojection.model.FrpProjectionData;
import com.st.frpprojection.model.ProjectionReminder;
import com.st.tracker.dao.ProjectionDataDao;
import com.st.tracker.model.BaleInventory;
import com.st.tracker.model.ProjectionData;

/**
 * @author sbora
 *
 */
@Service
public class FrpProjectionServiceImp implements FrpProjectionService {

	@Autowired
	private FrpProjectionDao frpProjectionDao;
	
	@Autowired
	private ProjectionDataDao projectionDataDao;
	
	
	@Transactional
	@Override
	public int saveFormula(FrpProjection frpProjection) {
		return frpProjectionDao.saveFormula(frpProjection);
	}

	@Transactional
	@Override
	public void updateFormula(FrpProjection frpProjection) {
		frpProjectionDao.updateFormula(frpProjection);
	}

	@Transactional
	@Override
	public List<FrpProjection> getProjectionFormulae() {
		return frpProjectionDao.getProjectionFormulae();
	}

	@Transactional
	@Override
	public FrpProjection getProjectionFormula(int id) {
		return frpProjectionDao.getProjectionFormula(id);
	}

	@Transactional
	@Override
	public FrpProjectionData getFrpProjectionData(Date sdate, Date edate,
			List<String> productIds,String temp) {
		
		Calendar shiftCal=Calendar.getInstance();
		shiftCal.set(Calendar.HOUR_OF_DAY, 7);
		shiftCal.set(Calendar.MINUTE, 0);
		shiftCal.set(Calendar.SECOND, 0);
		shiftCal.set(Calendar.MILLISECOND, 0);
		
			
		List<Integer> gradeIds=frpProjectionDao.getGradeIds();
		// remove CBS and CutBook grade
		int j=0;
		for (Integer id : gradeIds) {
			if(id==5) {
				gradeIds.remove(j);
			}
			if(id==21) {
				gradeIds.remove(j);
			}
			j++;
		}

		List<ProjectionData> projectionDatas=null;
		
		if(temp.equalsIgnoreCase("N")){
			projectionDatas=projectionDataDao.getProjectionData(sdate,edate,gradeIds);
			projectionDataDao.saveProjectionDataTemp(projectionDatas);
			//System.out.println("Getting new Data");
		}else{
			//System.out.println("Get Old Data");
			projectionDatas=projectionDataDao.getProjectionDataTemp(sdate,edate,gradeIds);
		}
		
		
		
		
		
		FrpProjectionData frpProjectionData=new FrpProjectionData();
		frpProjectionData.setProjectionDatas(projectionDatas);
		
		Calendar sCal=Calendar.getInstance();
		sCal.setTime(sdate);
		sCal.set(Calendar.HOUR_OF_DAY,0);
		sCal.set(Calendar.MINUTE,0);
		sCal.set(Calendar.SECOND,0);
		sCal.set(Calendar.MILLISECOND,0);
		
		SimpleDateFormat monthFormat=new SimpleDateFormat("dd-MMM");
		SimpleDateFormat dayFormat=new SimpleDateFormat("EEE");
		
		int  days=(int)CommonUtil.getDaysDiffernce(sdate, edate);
		frpProjectionData.setLength(days);
		
		//Date and Days
		for(int i=0;i<=days;i++){
			frpProjectionData.getDates().add(monthFormat.format(sCal.getTime()));
			frpProjectionData.getDays().add(dayFormat.format(sCal.getTime()));
			sCal.add(Calendar.DATE, 1);
		}
		
		
		List<FrpProjection> projections=new ArrayList<>();
		if(productIds.size()>0){
			projections=frpProjectionDao.getProjectionFormula(productIds);
		}
		
		
		
		
		//System.out.println(productIds+"===="+productIds.size()+"===="+days);
		int length=productIds.size();
		if(productIds.size()<(days+1)){
			for (int i=length;i<days+1;i++) {
				productIds.add("0");
			}
		}
		
		
	
		
		
		frpProjectionData.setProductionIds(productIds);
		
		//System.out.println(productIds.size()+"===="+productIds);
		double occ=0;
		double dlk=0;
		double mail=0;
		double growndwood=0;
		double others=0;
		double mwlAndSwl=0;
		double cutBook=0;
		//double sow=0;
		double sowAndcbs=0;
		double mixedPaper=0;
		
		//Code By Roshan Tailor
		double hw=0;
		double unprtsbs=0;
		double hwAndunprtSBS=0;
		//Code Ends Here By Roshan Tailor
		List<ProjectionReminder> reminders=new ArrayList<ProjectionReminder>();
		
		if(productIds.size()>0){
			Calendar cal=Calendar.getInstance();
			cal.setTime(sdate);
			for (int i=0;i<days+1;i++) {
				
				
				
				
				FrpProjection frpProjection =getFrpProjection(projections, NumberUtils.toInt(productIds.get(i), 0));
				
				if(frpProjection!=null){
					if(cal.getTime().after(new Date())){
						if(reminders.size()==0){
							ProjectionReminder reminder=new ProjectionReminder();
							reminder.setDate(cal.getTime());
							reminder.setFormulaId(frpProjection.getId());
							reminder.setFcode(frpProjection.getType());
							reminders.add(reminder);
						}else if(reminders.size()>0){
							ProjectionReminder projectionReminderTemp=reminders.get(reminders.size()-1);
							if(!(projectionReminderTemp.getFcode().equalsIgnoreCase(frpProjection.getType()))){
								ProjectionReminder reminder=new ProjectionReminder();
								reminder.setDate(cal.getTime());
								reminder.setFormulaId(frpProjection.getId());
								reminder.setFcode(frpProjection.getType());
								reminders.add(reminder);
							}
						}
					}
				}
				
				
				
				cal.add(Calendar.DATE, 1);
				
				
				//DLK Calculation
				ProjectionData projectionDataDlk=getProjectionData(projectionDatas, 24);
				if(projectionDataDlk!=null){
					if(i==0){
						dlk+=projectionDataDlk.getInbounds().get(i)+projectionDataDlk.getWeight();
					}else{
						dlk+=projectionDataDlk.getInbounds().get(i);
					}
				}
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getDlk())/100;
					//System.out.println("dlk=="+value);
					dlk=dlk-value;
					frpProjectionData.getDlk().add(dlk);
				}else{
					frpProjectionData.getDlk().add(dlk);
				}
				
				//Occ Calculation
				ProjectionData projectionDataOcc=getProjectionData(projectionDatas, 23);
				if(projectionDataOcc!=null){
					if(i==0){
						occ+=projectionDataOcc.getInbounds().get(i)+projectionDataOcc.getWeight();
					}else{
						occ+=projectionDataOcc.getInbounds().get(i);
					}
				}
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getOcc())/100;
					//System.out.println("occ=="+value);
					occ=occ-value;
					frpProjectionData.getOcc().add(occ);
				}else{
					frpProjectionData.getOcc().add(occ);
				}
				
				//Sow cbs
				ProjectionData projectionDataSow=getProjectionData(projectionDatas, 13);
				if(projectionDataSow!=null){
					if(i==0){
						//sowAndMail+=projectionDataSow.getInbounds().get(i)+projectionDataSow.getWeight();
						sowAndcbs+=projectionDataSow.getInbounds().get(i)+projectionDataSow.getWeight();
					}else{
						//sowAndMail+=projectionDataSow.getInbounds().get(i);
						sowAndcbs+=projectionDataSow.getInbounds().get(i);
					}
				}
				
				ProjectionData projectionDataMail=getProjectionData(projectionDatas, 20);
				if(projectionDataMail!=null){
					if(i==0){
						mail+=projectionDataMail.getInbounds().get(i)+projectionDataMail.getWeight();
					}else{
						mail+=projectionDataMail.getInbounds().get(i);
					}
				}
				if(frpProjection!=null){
					double value=0;
					value=(frpProjection.getInput()*frpProjection.getSowAndMail())/100;
					mail=mail-value;
					frpProjectionData.getMail().add(mail);
				}else{
					frpProjectionData.getMail().add(mail);
				}
				
				// Ground wood
				ProjectionData projectionDataCtd=getProjectionData(projectionDatas, 6);
				if(projectionDataCtd!=null){
					if(i==0){
						growndwood+=projectionDataCtd.getInbounds().get(i)+projectionDataCtd.getWeight();
					}else{
						growndwood+=projectionDataCtd.getInbounds().get(i);
					}
				}
				ProjectionData projectionDataOnp=getProjectionData(projectionDatas, 8);
				if(projectionDataOnp!=null){
					if(i==0){
						growndwood+=projectionDataOnp.getInbounds().get(i)+projectionDataOnp.getWeight();
					}else{
						growndwood+=projectionDataOnp.getInbounds().get(i);
					}
				}
				ProjectionData projectionDataOi=getProjectionData(projectionDatas, 9);
				if(projectionDataOi!=null){
					if(i==0){
						growndwood+=projectionDataOi.getInbounds().get(i)+projectionDataOi.getWeight();
					}else{
						growndwood+=projectionDataOi.getInbounds().get(i);
					}
				}
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getGrowndwood())/100;
					//System.out.println("growndwood=="+value);
					growndwood=growndwood-value;
					frpProjectionData.getGrowndwood().add(growndwood);
				}else{
					frpProjectionData.getGrowndwood().add(growndwood);
				}
				
				//Other Kraft
				ProjectionData projectionDataWhiteBrok=getProjectionData(projectionDatas, 60);
				if(projectionDataWhiteBrok!=null){
					if(i==0){
						others+=projectionDataWhiteBrok.getInbounds().get(i)+projectionDataWhiteBrok.getWeight();
						
					}else{
						others+=projectionDataWhiteBrok.getInbounds().get(i);
					}
				}
				
				ProjectionData projectionDataBrownNapkin=getProjectionData(projectionDatas, 65);
				if(projectionDataBrownNapkin!=null){
					if(i==0){
						others+=projectionDataBrownNapkin.getInbounds().get(i)+projectionDataBrownNapkin.getWeight();
					}else{
						others+=projectionDataBrownNapkin.getInbounds().get(i);
					}
				}
				
			
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getOthers())/100;
					
					others=others-value;
					frpProjectionData.getOthers().add(others);
					
					
				}else{
					frpProjectionData.getOthers().add(others);
				}
				
				
				
				ProjectionData projectionDataCutBook=getProjectionData(projectionDatas, 21);
				if(projectionDataCutBook!=null){
					if(i==0){
						cutBook+=projectionDataCutBook.getInbounds().get(i)+projectionDataCutBook.getWeight();
					}else{
						cutBook+=projectionDataCutBook.getInbounds().get(i);
					}
				}
				
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getCutBook())/100;
					
					cutBook=cutBook-value;
					frpProjectionData.getCutBook().add(cutBook);
					
					
				}else{
					frpProjectionData.getCutBook().add(cutBook);
				}
				
				
				
				ProjectionData projectionDataMixedPaper=getProjectionData(projectionDatas, 30);
				if(projectionDataMixedPaper!=null){
					if(i==0){
						mixedPaper+=projectionDataMixedPaper.getInbounds().get(i)+projectionDataMixedPaper.getWeight();
					}else{
						mixedPaper+=projectionDataMixedPaper.getInbounds().get(i);
					}
				}
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getMixedPaper())/100;
					
					mixedPaper=mixedPaper-value;
					frpProjectionData.getMixedPaper().add(mixedPaper);
					
					
				}else{
					frpProjectionData.getMixedPaper().add(mixedPaper);
				}
				
				
				
				
				//MWL - SWL
				ProjectionData projectionDataMwl=getProjectionData(projectionDatas, 1);
				if(projectionDataMwl!=null){
					if(i==0){
						mwlAndSwl+=projectionDataMwl.getInbounds().get(i)+projectionDataMwl.getWeight();
					}else{
						mwlAndSwl+=projectionDataMwl.getInbounds().get(i);
					}
				}
				
				
				ProjectionData projectionDataSwl=getProjectionData(projectionDatas, 7);
				
//Code Starts From Here Done By Roshan Tailor
				
				ProjectionData projectionDataHW=getProjectionData(projectionDatas, 11);
				if(projectionDataHW!=null){
					if(i==0){
						hw+=projectionDataHW.getInbounds().get(i)+projectionDataHW.getWeight();
					}else{
						hw+=projectionDataHW.getInbounds().get(i);
					}
				}
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getHw())/100;
					hw=hw-value;
					frpProjectionData.getHw().add(hw);
				}else{
					frpProjectionData.getHw().add(hw);
				}
				//
				ProjectionData projectionDataUnprtSBS=getProjectionData(projectionDatas, 14);
				if(projectionDataUnprtSBS!=null){
					if(i==0){
						unprtsbs+=projectionDataUnprtSBS.getInbounds().get(i)+projectionDataUnprtSBS.getWeight();
					}else{
						unprtsbs+=projectionDataUnprtSBS.getInbounds().get(i);
					}
				}
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getUnprtsbs())/100;
					unprtsbs=unprtsbs-value;
					frpProjectionData.getUnprtsbs().add(unprtsbs);
				}else{
					frpProjectionData.getUnprtsbs().add(unprtsbs);
				}
				
				
				//To Show The Added Data For HW and Unprt SBS
				
				ProjectionData projectionDataHW1=getProjectionData(projectionDatas, 11);
				if(projectionDataHW1!=null){
					if(i==0){
						hwAndunprtSBS+=projectionDataHW1.getInbounds().get(i)+projectionDataHW1.getWeight();
					}else{
						hwAndunprtSBS+=projectionDataHW1.getInbounds().get(i);
					}
				}
				
				
				ProjectionData projectionDataUnprtSBS1=getProjectionData(projectionDatas, 14);
				
				
				
				if(projectionDataUnprtSBS1!=null){
				//	System.out.println(projectionDataSwl.getInbounds().get(i));
					if(i==0){
						hwAndunprtSBS+=projectionDataUnprtSBS1.getInbounds().get(i)+projectionDataUnprtSBS1.getWeight();
					}else{
						hwAndunprtSBS+=projectionDataUnprtSBS1.getInbounds().get(i);
					}
				}
				
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getHwAndUnprtSBS())/100;
					//System.out.println("hwAndunprtSBS=="+value);
					hwAndunprtSBS=hwAndunprtSBS-value;
					frpProjectionData.getHwAndUnprtSBS().add(hwAndunprtSBS);
				}else{
					frpProjectionData.getHwAndUnprtSBS().add(hwAndunprtSBS);
				}
				//Code Ends Here For HW And UnprtSBS Both Addtion
				
				//Code Ends Here Done By Roshan Tailor
				
				if(projectionDataSwl!=null){
				//	System.out.println(projectionDataSwl.getInbounds().get(i));
					if(i==0){
						mwlAndSwl+=projectionDataSwl.getInbounds().get(i)+projectionDataSwl.getWeight();
					}else{
						mwlAndSwl+=projectionDataSwl.getInbounds().get(i);
					}
				}
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getMwlAndSwl())/100;
					//System.out.println("mwlAndSwl=="+value);
					mwlAndSwl=mwlAndSwl-value;
					frpProjectionData.getMwlAndSwl().add(mwlAndSwl);
				}else{
					frpProjectionData.getMwlAndSwl().add(mwlAndSwl);
				}
				
				
				/*//Sow
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getSow())/100;
					//System.out.println("sow=="+value);
					sowAndcbs=sowAndcbs-value;
					frpProjectionData.getSowAndCbs().add(sowAndcbs);
				}else{
					frpProjectionData.getSowAndCbs().add(sowAndcbs);
				}*/
				
				
				//Cbs
				ProjectionData projectionDataCbs=getProjectionData(projectionDatas, 5);
				if(projectionDataCbs!=null){
					if(i==0){
						sowAndcbs+=projectionDataCbs.getInbounds().get(i)+projectionDataCbs.getWeight();
					}else{
						sowAndcbs+=projectionDataCbs.getInbounds().get(i);
					}
				}
				if(frpProjection!=null){
					double value=0;
					if(frpProjection.getType().equalsIgnoreCase("WH")){
						value+=(frpProjection.getInput()*frpProjection.getSow())/100;
						value+=(frpProjection.getInput()*frpProjection.getCbs())/100;
						
					}else if(frpProjection.getType().equalsIgnoreCase("KF")){
						value=(frpProjection.getInput()*frpProjection.getSow())/100;
					}
					sowAndcbs=sowAndcbs-value;
					frpProjectionData.getSowAndCbs().add(sowAndcbs);
				}else{
					frpProjectionData.getSowAndCbs().add(sowAndcbs);
				}
			}
			

		}
				
		
		//Save Reminder
		if(reminders.size()>0){
			frpProjectionDao.saveReminders(reminders);
		}
		
		
		return frpProjectionData;
	}

	/**
	 * @param projections
	 * @param pid
	 * @return
	 */
	private FrpProjection getFrpProjection(List<FrpProjection> projections,
			int pid) {
		FrpProjection frpProjection = null;
		for (FrpProjection fprProd : projections) {
			if(fprProd.getId()==pid){
				frpProjection=fprProd;
				break;
			}
		}
		return frpProjection;
	}

	/**
	 * @param projectionDatas
	 * @param i
	 * @return
	 */
	private ProjectionData getProjectionData(
			List<ProjectionData> projectionDatas, int gradeCode) {
		ProjectionData projectionData=null;
		for (ProjectionData prodData : projectionDatas) {
			if(prodData.getGradeCode()==gradeCode){
				projectionData=prodData;
				break;
			}
		}
		return projectionData;
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.service.FrpProjectionService#getProjectionFormulae(java.lang.String)
	 */
	@Transactional
	@Override
	public List<FrpProjection> getProjectionFormulae(String type) {
		return frpProjectionDao.getProjectionFormulae(type);
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.service.FrpProjectionService#getProjectionMixData(java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public Map<String, Object> getProjectionMixData(String grade, int id) {
		FrpProjection frpProjection=frpProjectionDao.getProjectionFormula(id);
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		
		List<Double> targets=new ArrayList<>();
		List<Double> consumptions=new ArrayList<>();
		List<String> gradeCodes=new ArrayList<>();
		List<String> colors=new ArrayList<>();
		
		Calendar sCal=Calendar.getInstance();
		sCal.setTime(CommonUtil.getShiftDate());
		sCal.set(Calendar.HOUR_OF_DAY, 7);
		sCal.set(Calendar.MINUTE, 0);
		sCal.set(Calendar.SECOND, 0);
		sCal.set(Calendar.MILLISECOND, 0);
		//sCal.add(Calendar.DATE, -1);
		
		Calendar eCal=Calendar.getInstance();
		eCal.setTime(new Date());
		//eCal.add(Calendar.DATE, -1);
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyy h:mm a");
		map.put("sdate", dateFormat.format(sCal.getTime()));
		map.put("edate", dateFormat.format(eCal.getTime()));
		
		List<BaleInventory> baleInventories=projectionDataDao.getConsumedData(sCal.getTime(),eCal.getTime());
		
	
		if(frpProjection!=null){
			if(frpProjection.getType().equalsIgnoreCase("WH")){
				
				targets.add(frpProjection.getMwlAndSwlTarget());
				targets.add(frpProjection.getSowTarget());
				targets.add(frpProjection.getCbsTarget());
				targets.add(frpProjection.getGrowndwoodTarget());
				targets.add(frpProjection.getOthersTarget());
				
				gradeCodes.add("MWL & SWL");
				gradeCodes.add("SOW");
				gradeCodes.add("CBS");
				gradeCodes.add("Groundwood");
				gradeCodes.add("Others");
				
				double mwlAndSwl=0;
				double sow=0;
				double cbs=0;
				double growndwood=0;
				double others=0;
				
				
				
				
				BaleInventory mwlInventory=getBaleInventory(baleInventories,1);
				if(mwlInventory!=null){
					mwlAndSwl+=mwlInventory.getBaleWeight();
				}
				
				BaleInventory swlInventory=getBaleInventory(baleInventories,7);
				if(swlInventory!=null){
					mwlAndSwl+=swlInventory.getBaleWeight();
				}
				
				BaleInventory sowInventory=getBaleInventory(baleInventories,13);
				if(sowInventory!=null){
					sow+=sowInventory.getBaleWeight();
				}
				
				BaleInventory cbsInventory=getBaleInventory(baleInventories,5);
				if(cbsInventory!=null){
					cbs+=cbsInventory.getBaleWeight();
				}
				
				BaleInventory gdONPInventory=getBaleInventory(baleInventories,8);
				if(gdONPInventory!=null){
					growndwood+=gdONPInventory.getBaleWeight();
				}
				BaleInventory gdONInventory=getBaleInventory(baleInventories,9);
				if(gdONInventory!=null){
					growndwood+=gdONInventory.getBaleWeight();
				}
				BaleInventory gdCtdInventory=getBaleInventory(baleInventories,6);
				if(gdCtdInventory!=null){
					growndwood+=gdCtdInventory.getBaleWeight();
				}
				BaleInventory otherMailInventory=getBaleInventory(baleInventories,20);
				if(otherMailInventory!=null){
					others+=otherMailInventory.getBaleWeight();
				}
				BaleInventory otherWBInventory=getBaleInventory(baleInventories,60);
				if(otherWBInventory!=null){
					others+=otherWBInventory.getBaleWeight();
				}
				
				double totalTons=mwlAndSwl+sow+cbs+growndwood+others;
				
//				System.out.println("Before=mwlAndSwl"+mwlAndSwl);
//				System.out.println("Before=sow"+sow);
//				System.out.println("Before=cbs"+cbs);
//				System.out.println("Before=growndwood"+growndwood);
//				System.out.println("Before=others"+others);
				
				if(totalTons!=0){
					mwlAndSwl=(mwlAndSwl/totalTons)*100;
					sow=(sow/totalTons)*100;
					cbs=(cbs/totalTons)*100;
					growndwood=(growndwood/totalTons)*100;
					others=(others/totalTons)*100;
				}
				
//				System.out.println("After=mwlAndSwl"+mwlAndSwl);
//				System.out.println("After=sow"+sow);
//				System.out.println("After=cbs"+cbs);
//				System.out.println("After=growndwood"+growndwood);
//				System.out.println("After=others"+others);
				
				consumptions.add(CommonUtil.round(mwlAndSwl,2));
				consumptions.add(CommonUtil.round(sow,2));
				consumptions.add(CommonUtil.round(cbs,2));
				consumptions.add(CommonUtil.round(growndwood,2));
				consumptions.add(CommonUtil.round(others,2));
				
				if(frpProjection.getMwlAndSwlMinC()<mwlAndSwl && mwlAndSwl<frpProjection.getMwlAndSwlMaxC()){
					colors.add(CommonProperties.COLOR_GREEN_HEX);
				}else{
					colors.add(CommonProperties.COLOR_RED_HEX);
				}
				if(frpProjection.getSowMinC()<sow && sow<frpProjection.getSowMaxC()){
					colors.add(CommonProperties.COLOR_GREEN_HEX);
				}else{
					colors.add(CommonProperties.COLOR_RED_HEX);
				}
				if(frpProjection.getCbsMinC()<cbs && cbs<frpProjection.getCbsMaxC()){
					colors.add(CommonProperties.COLOR_GREEN_HEX);
				}else{
					colors.add(CommonProperties.COLOR_RED_HEX);
				}
				if(frpProjection.getGrowndwoodMinC()<growndwood && growndwood<frpProjection.getGrowndwoodMaxC()){
					colors.add(CommonProperties.COLOR_GREEN_HEX);
				}else{
					colors.add(CommonProperties.COLOR_RED_HEX);
				}
				if(frpProjection.getOthersMinC()> others && others<frpProjection.getOthersMaxC()){
					colors.add(CommonProperties.COLOR_GREEN_HEX);
				}else{
					colors.add(CommonProperties.COLOR_RED_HEX);
				}
				
			}else if(frpProjection.getType().equalsIgnoreCase("KF")){
				targets.add(frpProjection.getDlkTarget());
				targets.add(frpProjection.getOccTarget());
				targets.add(frpProjection.getSowAndMailTarget());
				targets.add(frpProjection.getGrowndwoodTarget());
				targets.add(frpProjection.getOthersTarget());
				
				gradeCodes.add("DLK");
				gradeCodes.add("OCC");
				gradeCodes.add("Sow & Mail");
				gradeCodes.add("Groundwood");
				gradeCodes.add("Others");
				
				double dlk=0;
				double occ=0;
				double sowAndMail=0;
				double growndwood=0;
				double others=0;
				
				
				
				
				BaleInventory dlkInventory=getBaleInventory(baleInventories,1);
				if(dlkInventory!=null){
					dlk+=dlkInventory.getBaleWeight();
				}
				BaleInventory occInventory=getBaleInventory(baleInventories,7);
				if(occInventory!=null){
					occ+=occInventory.getBaleWeight();
				}
				BaleInventory sowInventory=getBaleInventory(baleInventories,13);
				if(sowInventory!=null){
					sowAndMail+=sowInventory.getBaleWeight();
				}
				BaleInventory mailInventory=getBaleInventory(baleInventories,20);
				if(mailInventory!=null){
					sowAndMail+=mailInventory.getBaleWeight();
				}
				BaleInventory gdONPInventory=getBaleInventory(baleInventories,8);
				if(gdONPInventory!=null){
					growndwood+=gdONPInventory.getBaleWeight();
				}
				BaleInventory gdONInventory=getBaleInventory(baleInventories,9);
				if(gdONInventory!=null){
					growndwood+=gdONInventory.getBaleWeight();
				}
				BaleInventory gdCtdInventory=getBaleInventory(baleInventories,6);
				if(gdCtdInventory!=null){
					growndwood+=gdCtdInventory.getBaleWeight();
				}
				BaleInventory otherWBInventory=getBaleInventory(baleInventories,60);
				if(otherWBInventory!=null){
					others+=otherWBInventory.getBaleWeight();
				}
				BaleInventory otherBNBInventory=getBaleInventory(baleInventories,65);
				if(otherBNBInventory!=null){
					others+=otherBNBInventory.getBaleWeight();
				}
				
				BaleInventory otherMPInventory=getBaleInventory(baleInventories,30);
				if(otherMPInventory!=null){
					others+=otherMPInventory.getBaleWeight();
				}
				
//				System.out.println("Before=dlk"+dlk);
//				System.out.println("Before=occ"+occ);
//				System.out.println("Before=sowAndMail"+sowAndMail);
//				System.out.println("Before=growndwood"+growndwood);
//				System.out.println("Before=others"+others);
				
				double totalTons=dlk+occ+sowAndMail+growndwood+others;
				
				if(totalTons!=0){
					dlk=(dlk/totalTons)*100;
					occ=(occ/totalTons)*100;
					sowAndMail=(sowAndMail/totalTons)*100;
					growndwood=(growndwood/totalTons)*100;
					others=(others/totalTons)*100;
				}
//				System.out.println("After=dlk"+dlk);
//				System.out.println("After=occ"+occ);
//				System.out.println("After=sowAndMail"+sowAndMail);
//				System.out.println("After=growndwood"+growndwood);
//				System.out.println("After=others"+others);
				
				consumptions.add(CommonUtil.round(dlk,2));
				consumptions.add(CommonUtil.round(occ,2));
				consumptions.add(CommonUtil.round(sowAndMail,2));
				consumptions.add(CommonUtil.round(growndwood,2));
				consumptions.add(CommonUtil.round(others,2));
				
				
				if(frpProjection.getDlkMinC()<dlk && dlk<frpProjection.getDlkMaxC()){
					colors.add(CommonProperties.COLOR_GREEN_HEX);
				}else{
					colors.add(CommonProperties.COLOR_RED_HEX);
				}
				if(frpProjection.getOccMinC()<occ && occ<frpProjection.getOccMaxC()){
					colors.add(CommonProperties.COLOR_GREEN_HEX);
				}else{
					colors.add(CommonProperties.COLOR_RED_HEX);
				}
				if(frpProjection.getSowAndMailMinC()<sowAndMail && sowAndMail<frpProjection.getSowAndMailMaxC()){
					colors.add(CommonProperties.COLOR_GREEN_HEX);
				}else{
					colors.add(CommonProperties.COLOR_RED_HEX);
				}
				if(frpProjection.getGrowndwoodMinC()<growndwood && growndwood<frpProjection.getGrowndwoodMaxC()){
					colors.add(CommonProperties.COLOR_GREEN_HEX);
				}else{
					colors.add(CommonProperties.COLOR_RED_HEX);
				}
				if(frpProjection.getOthersMinC()> others && others<frpProjection.getOthersMaxC()){
					colors.add(CommonProperties.COLOR_GREEN_HEX);
				}else{
					colors.add(CommonProperties.COLOR_RED_HEX);
				}
				
			}
		}
		
		map.put("targets", targets);
		map.put("consumptions", consumptions);
		map.put("gradeCodes", gradeCodes);
		map.put("colors", colors);
		
		return map;
		
		
	}

	/**
	 * @param baleInventories
	 * @param i
	 * @return
	 */
	private BaleInventory getBaleInventory(List<BaleInventory> baleInventories,
			int code) {
		
		BaleInventory bale=null;
		
		for (BaleInventory baleInventory : baleInventories) {
			if(baleInventory.getGradeCode()==code){
				bale=baleInventory;
				break;
			}
		}
		return bale;
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.service.FrpProjectionService#delete(int)
	 */
	@Transactional
	@Override
	public void delete(int id) {
		frpProjectionDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.service.FrpProjectionService#getFiberPurchasingData(java.util.Date, java.util.Date, java.util.List, java.lang.String)
	 */
	@Override
	public FrpProjectionData getFiberPurchasingData(Date sdate, Date edate,
			List<String> productIds, String temp) {
		Calendar shiftCal=Calendar.getInstance();
		shiftCal.set(Calendar.HOUR_OF_DAY, 7);
		shiftCal.set(Calendar.MINUTE, 0);
		shiftCal.set(Calendar.SECOND, 0);
		shiftCal.set(Calendar.MILLISECOND, 0);
		
			
		List<Integer> gradeIds=frpProjectionDao.getGradeIds();

		List<ProjectionData> projectionDatas=null;
		
		if(temp.equalsIgnoreCase("N")){
			projectionDatas=projectionDataDao.getProjectionData(sdate,edate,gradeIds);
			projectionDataDao.saveFiberPurchasingDataTemp(projectionDatas);
			//System.out.println("Getting new Data");
		}else{
			//System.out.println("Get Old Data");
			projectionDatas=projectionDataDao.getFiberPurchasingDataTemp(sdate,edate,gradeIds);
		}
		
		
		
		
		
		FrpProjectionData frpProjectionData=new FrpProjectionData();
		frpProjectionData.setProjectionDatas(projectionDatas);
		
		Calendar sCal=Calendar.getInstance();
		sCal.setTime(sdate);
		sCal.set(Calendar.HOUR_OF_DAY,0);
		sCal.set(Calendar.MINUTE,0);
		sCal.set(Calendar.SECOND,0);
		sCal.set(Calendar.MILLISECOND,0);
		
		SimpleDateFormat monthFormat=new SimpleDateFormat("dd-MMM");
		SimpleDateFormat dayFormat=new SimpleDateFormat("EEE");
		
		int days=(int)CommonUtil.getDaysDiffernce(sdate, edate);
		frpProjectionData.setLength(days);
		
		//Date and Days
		for(int i=0;i<=days;i++){
			frpProjectionData.getDates().add(monthFormat.format(sCal.getTime()));
			frpProjectionData.getDays().add(dayFormat.format(sCal.getTime()));
			sCal.add(Calendar.DATE, 1);
		}
		
		
		List<FrpProjection> projections=new ArrayList<>();
		if(productIds.size()>0){
			projections=frpProjectionDao.getProjectionFormula(productIds);
		}
		
		//System.out.println(productIds+"===="+productIds.size()+"===="+days);
		int length=productIds.size();
		if(productIds.size()<(days+1)){
			for (int i=length;i<days+1;i++) {
				productIds.add("0");
			}
		}
		
		frpProjectionData.setProductionIds(productIds);
		
		//System.out.println(productIds.size()+"===="+productIds);
		double occ=0;
		double dlk=0;
		double mail=0;
		double growndwood=0;
		double others=0;
		double mwlAndSwl=0;
		double hwAndunprtSBS=0;
		double cutBook=0;
		//double sow=0;
		double sowAndcbs=0;
		double mixedPaper=0;
		double hw=0;
		double unprtsbs=0;
		
		if(productIds.size()>0){
			for (int i=0;i<days+1;i++) {
				
				FrpProjection frpProjection =getFrpProjection(projections, NumberUtils.toInt(productIds.get(i), 0));
				
				
				
				//DLK Calculation
				ProjectionData projectionDataDlk=getProjectionData(projectionDatas, 24);
				if(projectionDataDlk!=null){
					if(i==0){
						dlk+=projectionDataDlk.getInbounds().get(i)+projectionDataDlk.getWeight();
					}else{
						dlk+=projectionDataDlk.getInbounds().get(i);
					}
				}
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getDlk())/100;
					//System.out.println("dlk=="+value);
					dlk=dlk-value;
					frpProjectionData.getDlk().add(dlk);
				}else{
					frpProjectionData.getDlk().add(dlk);
				}
				
				//Occ Calculation
				ProjectionData projectionDataOcc=getProjectionData(projectionDatas, 23);
				if(projectionDataOcc!=null){
					if(i==0){
						occ+=projectionDataOcc.getInbounds().get(i)+projectionDataOcc.getWeight();
					}else{
						occ+=projectionDataOcc.getInbounds().get(i);
					}
				}
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getOcc())/100;
					//System.out.println("occ=="+value);
					occ=occ-value;
					frpProjectionData.getOcc().add(occ);
				}else{
					frpProjectionData.getOcc().add(occ);
				}
				
				//Sow cbs
				ProjectionData projectionDataSow=getProjectionData(projectionDatas, 13);
				if(projectionDataSow!=null){
					if(i==0){
						//sowAndMail+=projectionDataSow.getInbounds().get(i)+projectionDataSow.getWeight();
						sowAndcbs+=projectionDataSow.getInbounds().get(i)+projectionDataSow.getWeight();
					}else{
						//sowAndMail+=projectionDataSow.getInbounds().get(i);
						sowAndcbs+=projectionDataSow.getInbounds().get(i);
					}
				}
				
				ProjectionData projectionDataMail=getProjectionData(projectionDatas, 20);
				if(projectionDataMail!=null){
					if(i==0){
						mail+=projectionDataMail.getInbounds().get(i)+projectionDataMail.getWeight();
					}else{
						mail+=projectionDataMail.getInbounds().get(i);
					}
				}
				if(frpProjection!=null){
					double value=0;
					value=(frpProjection.getInput()*frpProjection.getSowAndMail())/100;
					mail=mail-value;
					frpProjectionData.getMail().add(mail);
				}else{
					frpProjectionData.getMail().add(mail);
				}
				
				// Ground wood
				ProjectionData projectionDataCtd=getProjectionData(projectionDatas, 6);
				if(projectionDataCtd!=null){
					if(i==0){
						growndwood+=projectionDataCtd.getInbounds().get(i)+projectionDataCtd.getWeight();
					}else{
						growndwood+=projectionDataCtd.getInbounds().get(i);
					}
				}
				ProjectionData projectionDataOnp=getProjectionData(projectionDatas, 8);
				if(projectionDataOnp!=null){
					if(i==0){
						growndwood+=projectionDataOnp.getInbounds().get(i)+projectionDataOnp.getWeight();
					}else{
						growndwood+=projectionDataOnp.getInbounds().get(i);
					}
				}
				ProjectionData projectionDataOi=getProjectionData(projectionDatas, 9);
				if(projectionDataOi!=null){
					if(i==0){
						growndwood+=projectionDataOi.getInbounds().get(i)+projectionDataOi.getWeight();
					}else{
						growndwood+=projectionDataOi.getInbounds().get(i);
					}
				}
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getGrowndwood())/100;
					//System.out.println("growndwood=="+value);
					growndwood=growndwood-value;
					frpProjectionData.getGrowndwood().add(growndwood);
				}else{
					frpProjectionData.getGrowndwood().add(growndwood);
				}
				
				//Other Kraft
				ProjectionData projectionDataWhiteBrok=getProjectionData(projectionDatas, 60);
				if(projectionDataWhiteBrok!=null){
					if(i==0){
						others+=projectionDataWhiteBrok.getInbounds().get(i)+projectionDataWhiteBrok.getWeight();
						
					}else{
						others+=projectionDataWhiteBrok.getInbounds().get(i);
					}
				}
				
				ProjectionData projectionDataBrownNapkin=getProjectionData(projectionDatas, 65);
				if(projectionDataBrownNapkin!=null){
					if(i==0){
						others+=projectionDataBrownNapkin.getInbounds().get(i)+projectionDataBrownNapkin.getWeight();
					}else{
						others+=projectionDataBrownNapkin.getInbounds().get(i);
					}
				}
				
			
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getOthers())/100;
					
					others=others-value;
					frpProjectionData.getOthers().add(others);
					
					
				}else{
					frpProjectionData.getOthers().add(others);
				}
				
				
				
				ProjectionData projectionDataCutBook=getProjectionData(projectionDatas, 21);
				if(projectionDataCutBook!=null){
					if(i==0){
						cutBook+=projectionDataCutBook.getInbounds().get(i)+projectionDataCutBook.getWeight();
					}else{
						cutBook+=projectionDataCutBook.getInbounds().get(i);
					}
				}
				
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getCutBook())/100;
					
					cutBook=cutBook-value;
					frpProjectionData.getCutBook().add(cutBook);
					
					
				}else{
					frpProjectionData.getCutBook().add(cutBook);
				}
				
				
				
				ProjectionData projectionDataMixedPaper=getProjectionData(projectionDatas, 30);
				if(projectionDataMixedPaper!=null){
					if(i==0){
						mixedPaper+=projectionDataMixedPaper.getInbounds().get(i)+projectionDataMixedPaper.getWeight();
					}else{
						mixedPaper+=projectionDataMixedPaper.getInbounds().get(i);
					}
				}
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getMixedPaper())/100;
					
					mixedPaper=mixedPaper-value;
					frpProjectionData.getMixedPaper().add(mixedPaper);
					
					
				}else{
					frpProjectionData.getMixedPaper().add(mixedPaper);
				}
				
				
				
				
				//MWL - SWL
				ProjectionData projectionDataMwl=getProjectionData(projectionDatas, 1);
				if(projectionDataMwl!=null){
					if(i==0){
						mwlAndSwl+=projectionDataMwl.getInbounds().get(i)+projectionDataMwl.getWeight();
					}else{
						mwlAndSwl+=projectionDataMwl.getInbounds().get(i);
					}
				}
				
				
				ProjectionData projectionDataSwl=getProjectionData(projectionDatas, 7);
				
				
				
				if(projectionDataSwl!=null){
				//	System.out.println(projectionDataSwl.getInbounds().get(i));
					if(i==0){
						mwlAndSwl+=projectionDataSwl.getInbounds().get(i)+projectionDataSwl.getWeight();
					}else{
						mwlAndSwl+=projectionDataSwl.getInbounds().get(i);
					}
				}
				
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getMwlAndSwl())/100;
					//System.out.println("mwlAndSwl=="+value);
					mwlAndSwl=mwlAndSwl-value;
					frpProjectionData.getMwlAndSwl().add(mwlAndSwl);
				}else{
					frpProjectionData.getMwlAndSwl().add(mwlAndSwl);
				}
				
				

				//Code Starts From Here Done By Roshan Tailor
				
				ProjectionData projectionDataHW=getProjectionData(projectionDatas, 11);
				if(projectionDataHW!=null){
					if(i==0){
						hw+=projectionDataHW.getInbounds().get(i)+projectionDataHW.getWeight();
					}else{
						hw+=projectionDataHW.getInbounds().get(i);
					}
				}
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getHw())/100;
					hw=hw-value;
					frpProjectionData.getHw().add(hw);
				}else{
					frpProjectionData.getHw().add(hw);
				}
				//
				ProjectionData projectionDataUnprtSBS=getProjectionData(projectionDatas, 14);
				if(projectionDataUnprtSBS!=null){
					if(i==0){
						unprtsbs+=projectionDataUnprtSBS.getInbounds().get(i)+projectionDataUnprtSBS.getWeight();
					}else{
						unprtsbs+=projectionDataUnprtSBS.getInbounds().get(i);
					}
				}
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getUnprtsbs())/100;
					unprtsbs=unprtsbs-value;
					frpProjectionData.getUnprtsbs().add(unprtsbs);
				}else{
					frpProjectionData.getUnprtsbs().add(unprtsbs);
				}
				
				
				//To Show The Added Data For HW and Unprt SBS
				
				ProjectionData projectionDataHW1=getProjectionData(projectionDatas, 11);
				if(projectionDataHW1!=null){
					if(i==0){
						hwAndunprtSBS+=projectionDataHW1.getInbounds().get(i)+projectionDataHW1.getWeight();
					}else{
						hwAndunprtSBS+=projectionDataHW1.getInbounds().get(i);
					}
				}
				
				
				ProjectionData projectionDataUnprtSBS1=getProjectionData(projectionDatas, 14);
				
				
				
				if(projectionDataUnprtSBS1!=null){
				//	System.out.println(projectionDataSwl.getInbounds().get(i));
					if(i==0){
						hwAndunprtSBS+=projectionDataUnprtSBS1.getInbounds().get(i)+projectionDataUnprtSBS1.getWeight();
					}else{
						hwAndunprtSBS+=projectionDataUnprtSBS1.getInbounds().get(i);
					}
				}
				
				
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getHwAndUnprtSBS())/100;
					//System.out.println("hwAndunprtSBS=="+value);
					hwAndunprtSBS=hwAndunprtSBS-value;
					frpProjectionData.getHwAndUnprtSBS().add(hwAndunprtSBS);
				}else{
					frpProjectionData.getHwAndUnprtSBS().add(hwAndunprtSBS);
				}
				//Code Ends Here For HW And UnprtSBS Both Addtion
				
				//Code Ends Here Done By Roshan Tailor
				
				/*//Sow
				if(frpProjection!=null){
					double value=(frpProjection.getInput()*frpProjection.getSow())/100;
					//System.out.println("sow=="+value);
					sowAndcbs=sowAndcbs-value;
					frpProjectionData.getSowAndCbs().add(sowAndcbs);
				}else{
					frpProjectionData.getSowAndCbs().add(sowAndcbs);
				}*/
				
				
				//Cbs
				ProjectionData projectionDataCbs=getProjectionData(projectionDatas, 5);
				if(projectionDataCbs!=null){
					if(i==0){
						sowAndcbs+=projectionDataCbs.getInbounds().get(i)+projectionDataCbs.getWeight();
					}else{
						sowAndcbs+=projectionDataCbs.getInbounds().get(i);
					}
				}
				if(frpProjection!=null){
					double value=0;
					if(frpProjection.getType().equalsIgnoreCase("WH")){
						value+=(frpProjection.getInput()*frpProjection.getSow())/100;
						value+=(frpProjection.getInput()*frpProjection.getCbs())/100;
						
					}else if(frpProjection.getType().equalsIgnoreCase("KF")){
						value=(frpProjection.getInput()*frpProjection.getSow())/100;
					}
					sowAndcbs=sowAndcbs-value;
					frpProjectionData.getSowAndCbs().add(sowAndcbs);
				}else{
					frpProjectionData.getSowAndCbs().add(sowAndcbs);
				}
			}
			

		}
				
		
		return frpProjectionData;
	}

	/* (non-Javadoc)
	 * @see com.st.frpprojection.service.FrpProjectionService#getProjectionReminder()
	 */
	@Transactional
	@Override
	public List<Map<String, Object>> getProjectionReminder(Date date) {
		return frpProjectionDao.getProjectionReminder(date);
	}

	

}
