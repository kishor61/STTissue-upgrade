package com.st.qualitypm6.service;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.st.common.ColumnsOfTable;
import com.st.common.CommonUtil;
import com.st.common.GradeTargetUtil;
import com.st.qualitypm6.dao.GradeTargetDao;
import com.st.qualitypm6.dao.ReelDao;
import com.st.qualitypm6.model.GradeTarget;
import com.st.qualitypm6.model.Reel;

@Service
public class ReelServiceImp implements ReelService {

	@Autowired
	private ReelDao reelDao;
	
	@Autowired
	private GradeTargetDao gradeTargetDao;
	
	
	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat2=new SimpleDateFormat("MM/dd/yyyy");
	private SimpleDateFormat dateFormat3=new SimpleDateFormat("HH:mm");

	@Transactional
	@Override
	public List<Reel> getReels(String gradeCode, Date date) {
		return reelDao.getReels(gradeCode, date);
	}

	@Transactional
	@Override
	public boolean isReelNumberExist(String reelNo,String year) {
		
		return reelDao.isReelNumberExist(reelNo,year);
	}
	@Transactional
	@Override
	public boolean isReelNumberExist(String reelNo) {
		
		return reelDao.isReelNumberExist(reelNo);
	}

	/*@Transactional
	@Override
	public List<Reel> getReels(String gradeCode, Date date, String entryAutoFlag) {
		
		return reelDao.getReels(gradeCode, date, entryAutoFlag);
	}*/

	@Transactional
	@Override
	public List<String> getReels() {
		return reelDao.getReels();
	}

	@Transactional
	@Override
	public List<String> getReelByGradeCode(String gradeCode) {
		return reelDao.getReelByGradeCode(gradeCode);
	}

	@Transactional
	@Override
	public void delete(List<String> idsList) {
		reelDao.delete(idsList);

	}

	@Transactional
	@Override
	public Object getCustomerName(String gradeCode, String reelNo) {
		
		return reelDao.getCustomerName(gradeCode, reelNo);
	}

	@Transactional
	@Override
	public int save(Reel reel) throws Exception {
		return reelDao.save(reel);

	}

	/*@Transactional
	@Override
	public void update(Reel reel, String entryAutoFlag) throws Exception {
		reelDao.update(reel, entryAutoFlag);
	}*/

	/*@Transactional
	@Override
	public List<Reel> getReels(Date sdate, Date edate) {
		return reelDao.getReels(sdate, edate);
	}

	@Transactional
	@Override
	public List<Reel> getReelsByGrade(Date sdate, Date edate, String gradeCode) {
		
		return reelDao.getReelsByGrade(sdate, edate, gradeCode);
	}

	@Transactional
	@Override
	public List<Reel> getReelsByCustomer(Date sdate, Date edate, String customer) {
		return reelDao.getReelsByCustomer(sdate, edate, customer);
	}
*/
	@Transactional
	@Override
	public void update(Reel reel) throws Exception {
		
		System.out.println("Reel Call in Dao ::"+reel.getId());
		System.out.println("Reel Call in Dao ::"+reel);
		reelDao.update(reel);

	}

	/*@Transactional
	@Override
	public List<Reel> getReelsByGrade(String gradeCode) {
		return reelDao.getReelsByGrade(gradeCode);
	}

	@Transactional
	@Override
	public List<Reel> getReelsByCustomer(String customer) {
		return reelDao.getReelsByCustomer(customer);
	}

	@Transactional
	@Override
	public List<Reel> getReelsByReel(Date sdate, Date edate, String reel) {
		return reelDao.getReelsByReel(sdate, edate, reel);
	}

	@Transactional
	@Override
	public List<Reel> getReelsByGradeCustomer(Date sdate, Date edate,
			String gradeCode, String customer) {
		
		return reelDao.getReelsByGradeCustomer(sdate, edate, gradeCode,
				customer);
	}

	@Transactional
	@Override
	public List<Reel> getReelsByGradeReel(Date sdate, Date edate,
			String gradeCode, String reel) {
		
		return reelDao.getReelsByGradeReel(sdate, edate, gradeCode, reel);
	}

	@Transactional
	@Override
	public List<Reel> getReelsByGradeCustomerReel(Date sdate, Date edate,
			String gradeCode, String customer, String reel) {
		
		return reelDao.getReelsByGradeCustomerReel(sdate, edate, gradeCode, customer, reel);
	}

	@Transactional
	@Override
	public List<Reel> getReelsByCustomerReel(Date sdate, Date edate,
			String customer, String reel) {
		
		return reelDao.getReelsByCustomerReel(sdate, edate, customer, reel);

	}

*/	@Transactional
	@Override
	public Reel getReelById(int id) {
		
		return reelDao.getReelById(id);
	}

/*@Transactional
	@Override
	public void updateEntryById(List<Integer> ids, String entryFlag) {
		reelDao.updateEntryById(ids, entryFlag);
		
	}*/

	@Transactional
	@Override
	public List<Reel> getReelByReelNo(String reelNo) {
		return reelDao.getReelByReelNo(reelNo);
	}

	@Transactional
	@Override
	public List<Map<String, Object>> findMatch(Reel reel) {
		return reelDao.findMatch(reel);
	}

	@Transactional
	@Override
	public String getMaxReel() {
		return reelDao.getMaxReel();
	}

	@Transactional
	@Override
	public Map<String, Date> getPrevNextReelDate(String reel) {
		return reelDao.getPrevNextReelDate(reel);
	}
	
	
	
	//Reporting
	@Transactional
	@Override
	public List<Map<String, Object>> getFormatedData(List<Reel> reels) throws ParseException {
		List<Map<String, Object>> datas=new ArrayList<>();
		
		if(reels==null){
			return datas;
		}
		
		String gradeCode="";
		Date date=null;
		Map<String, Object> mapObjOld=null;
		
		List<GradeTarget> gradeTargets=null;
		for (Reel reel : reels) {
			if(reel.getGradeCode().equals(gradeCode)){
				
				if(date.compareTo(dateFormat1.parse(dateFormat1.format(reel.getDate())))!=0){
					date=dateFormat1.parse(dateFormat1.format(reel.getDate()));
					datas.add(mapObjOld);
					
				}
				
				Map<String, Object> map=new HashMap<>();
				
				
				if(gradeTargets==null){
					gradeTargets=gradeTargetDao.getGradeTarget(reel.getGradeCode());
				}
				
				
				
				
				
				map.put(ColumnsOfTable.COL_01, dateFormat2.format(reel.getDate())); //DATE
				if(reel.getTime()!=null){
					map.put(ColumnsOfTable.COL_02, dateFormat3.format(reel.getTime())); //TIME
				}else{
					map.put(ColumnsOfTable.COL_02, ""); //TIME
				}
				map.put(ColumnsOfTable.COL_03, reel.getGradeCode());
				map.put(ColumnsOfTable.COL_04,  reel.getReel()); 
				map.put(ColumnsOfTable.COL_05,  reel.getScannerBasisWt());
				map.put(ColumnsOfTable.COL_06,  reel.getActualBasisWt());
				map.put(ColumnsOfTable.COL_06_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getActualBasisWt(),"GP01"));
				map.put(ColumnsOfTable.COL_07,  reel.getBulk());
				map.put(ColumnsOfTable.COL_07_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getBulk(),"GP17"));
				map.put(ColumnsOfTable.COL_08,  reel.getMdTensile());
				map.put(ColumnsOfTable.COL_08_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getMdTensile(),"GP04"));
				map.put(ColumnsOfTable.COL_09,  reel.getCdTensile());
				map.put(ColumnsOfTable.COL_09_C, GradeTargetUtil.getColorClass(gradeTargets, reel.getCdTensile(),"GP06"));
				map.put(ColumnsOfTable.COL_10,  reel.getMdStretch());
				map.put(ColumnsOfTable.COL_10_C,  GradeTargetUtil.getColorClass(gradeTargets,reel.getMdStretch(),"GP08"));
				map.put(ColumnsOfTable.COL_11,  reel.getMdcdTensileRatio());
				map.put(ColumnsOfTable.COL_11_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getMdcdTensileRatio(),"GP09"));
				map.put(ColumnsOfTable.COL_12,  reel.getMdWetTensile());
				map.put(ColumnsOfTable.COL_12_C,GradeTargetUtil.getColorClass(gradeTargets,reel.getMdWetTensile(),"GP05"));
				map.put(ColumnsOfTable.COL_13,  reel.getCdWetTensile());
				map.put(ColumnsOfTable.COL_13_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getCdWetTensile(),"GP07") );
				map.put(ColumnsOfTable.COL_14,  reel.getWetDryRatio());
				map.put(ColumnsOfTable.COL_14_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getWetDryRatio(),"GP10") );
				map.put(ColumnsOfTable.COL_15,  reel.getBrightness());
				map.put(ColumnsOfTable.COL_15_C, GradeTargetUtil.getColorClass(gradeTargets, reel.getBrightness(),"GP02"));
				map.put(ColumnsOfTable.COL_16,  reel.getFwaFlow());
				map.put(ColumnsOfTable.COL_17,  reel.getDirtCount());
				map.put(ColumnsOfTable.COL_17_C, GradeTargetUtil.getColorClass(gradeTargets, reel.getDirtCount(),"GP19"));
				map.put(ColumnsOfTable.COL_18,  reel.getFwaDosage());
				map.put(ColumnsOfTable.COL_19,  reel.getTph());
				map.put(ColumnsOfTable.COL_20,  reel.getTrim());
				map.put(ColumnsOfTable.COL_21,  reel.getCrepeRatio());
//				Code Starts From Here Done By Roshan Tailor Date :-03/07/2015  MM/DD/YYYY
				map.put(ColumnsOfTable.COL_22, reel.getLvalue());
				map.put(ColumnsOfTable.COL_23, reel.getAvalue());
				map.put(ColumnsOfTable.COL_24, reel.getBvalue());
//				Code Ends Here Done By Roshan Tailor 
				map.put(ColumnsOfTable.COL_25,  reel.getCustomer());
				map.put(ColumnsOfTable.COL_26,  reel.getRemarks());
				
				
				double gmtbw= Math.sqrt(reel.getMdTensile()*reel.getCdTensile())/reel.getActualBasisWt();
				
				map.put(ColumnsOfTable.COL_27, CommonUtil.round(gmtbw, 2));
				
				map.put(ColumnsOfTable.COL_28, reel.getDeltae());
				
				map.put(ColumnsOfTable.COL_29, reel.getAkd());
				map.put(ColumnsOfTable.COL_30, reel.getWetstrength());
				map.put(ColumnsOfTable.COL_31, reel.getDrystrengthflow());
				map.put(ColumnsOfTable.COL_31_C, GradeTargetUtil.getColorClass(gradeTargets, reel.getDrystrengthflow(),"GP18"));
				map.put(ColumnsOfTable.COL_32, reel.getCustomer1());
				map.put(ColumnsOfTable.COL_33 ,reel.getCustomer2());
				//gmtbw
				map.put("id", reel.getId());
				
				
				datas.add(map);
				
				
				
			}else{
				gradeCode=reel.getGradeCode();
				date=dateFormat1.parse(dateFormat1.format(reel.getDate()));
				
				Map<String, Object> mapObj=new HashMap<>();
				
				gradeTargets=gradeTargetDao.getGradeTarget(reel.getGradeCode());
				
				mapObj.put(ColumnsOfTable.COL_01, "OBJECTIVES"); //DATE
				mapObj.put(ColumnsOfTable.COL_02, ""); //TIME
				mapObj.put(ColumnsOfTable.COL_03, reel.getGradeCode());
				mapObj.put(ColumnsOfTable.COL_04,  "N/A"); 
				mapObj.put(ColumnsOfTable.COL_05,  "N/A");
				mapObj.put(ColumnsOfTable.COL_06,  CommonUtil.getValue(gradeTargets, "GP01"));
				/* This below code is Commented beacuse of need to show GP17 Values Here From Now Which is Related to Reel and GP17 Values Will be Come At Winder/Rewinder Page */
				/*mapObj.put(ColumnsOfTable.COL_07,  CommonUtil.getValue(gradeTargets, "GP17"));*/
				mapObj.put(ColumnsOfTable.COL_07,  CommonUtil.getValue(gradeTargets, "GP17"));
				mapObj.put(ColumnsOfTable.COL_08,  CommonUtil.getValue(gradeTargets, "GP04"));
				mapObj.put(ColumnsOfTable.COL_09,  CommonUtil.getValue(gradeTargets, "GP06"));
				mapObj.put(ColumnsOfTable.COL_10,  CommonUtil.getValue(gradeTargets, "GP08"));
				mapObj.put(ColumnsOfTable.COL_11,  CommonUtil.getValue(gradeTargets, "GP09"));
				mapObj.put(ColumnsOfTable.COL_12,  CommonUtil.getValue(gradeTargets, "GP05"));
				mapObj.put(ColumnsOfTable.COL_13,  CommonUtil.getValue(gradeTargets, "GP07"));
				mapObj.put(ColumnsOfTable.COL_14,  CommonUtil.getValue(gradeTargets, "GP10"));
				mapObj.put(ColumnsOfTable.COL_15,  CommonUtil.getValue(gradeTargets, "GP02"));
				mapObj.put(ColumnsOfTable.COL_16,  "N/A");
				mapObj.put(ColumnsOfTable.COL_17,  CommonUtil.getValue(gradeTargets, "GP19"));
				mapObj.put(ColumnsOfTable.COL_18,  "");
				mapObj.put(ColumnsOfTable.COL_19,  "");
				mapObj.put(ColumnsOfTable.COL_20,  "");
				mapObj.put(ColumnsOfTable.COL_21,  "");
//				Code Starts From Here Done By Roshan Tailor Date :- 03/07/2015 MM/DD/YYYY
//				Code Updated By Roshan Tailor Date :- 03/12/2015 MM.DD/YYYY
				mapObj.put(ColumnsOfTable.COL_22,  CommonUtil.getValue(gradeTargets, "GP13"));
				mapObj.put(ColumnsOfTable.COL_23,  CommonUtil.getValue(gradeTargets, "GP14"));
				mapObj.put(ColumnsOfTable.COL_24,  CommonUtil.getValue(gradeTargets, "GP15"));
					
//				Code Ends Here Done By Roshan Tailor
				mapObj.put(ColumnsOfTable.COL_25,  "");
				mapObj.put(ColumnsOfTable.COL_31,  CommonUtil.getValue(gradeTargets, "GP18"));
				mapObj.put(ColumnsOfTable.COL_32,  "");
				mapObj.put(ColumnsOfTable.COL_33,  "");
				mapObj.put(ColumnsOfTable.COL_26,  "");
				
				datas.add(mapObj);
				
				mapObjOld=mapObj;
				
				Map<String, Object> map=new HashMap<>();
				
				map.put(ColumnsOfTable.COL_01, dateFormat2.format(reel.getDate())); //DATE
				if(reel.getTime()!=null){
					map.put(ColumnsOfTable.COL_02, dateFormat3.format(reel.getTime())); //TIME
				}else{
					map.put(ColumnsOfTable.COL_02, ""); //TIME
				}
				map.put(ColumnsOfTable.COL_03, reel.getGradeCode());
				map.put(ColumnsOfTable.COL_04,  reel.getReel()); 
				map.put(ColumnsOfTable.COL_05,  reel.getScannerBasisWt());
				map.put(ColumnsOfTable.COL_06,  reel.getActualBasisWt());
				map.put(ColumnsOfTable.COL_06_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getActualBasisWt(),"GP01"));
				map.put(ColumnsOfTable.COL_07,  reel.getBulk());
				map.put(ColumnsOfTable.COL_07_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getBulk(),"GP17"));
				map.put(ColumnsOfTable.COL_08,  reel.getMdTensile());
				map.put(ColumnsOfTable.COL_08_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getMdTensile(),"GP04"));
				map.put(ColumnsOfTable.COL_09,  reel.getCdTensile());
				map.put(ColumnsOfTable.COL_09_C, GradeTargetUtil.getColorClass(gradeTargets, reel.getCdTensile(),"GP06"));
				map.put(ColumnsOfTable.COL_10,  reel.getMdStretch());
				map.put(ColumnsOfTable.COL_10_C,  GradeTargetUtil.getColorClass(gradeTargets,reel.getMdStretch(),"GP08"));
				map.put(ColumnsOfTable.COL_11,  reel.getMdcdTensileRatio());
				map.put(ColumnsOfTable.COL_11_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getMdcdTensileRatio(),"GP09"));
				map.put(ColumnsOfTable.COL_12,  reel.getMdWetTensile());
				map.put(ColumnsOfTable.COL_12_C,GradeTargetUtil.getColorClass(gradeTargets,reel.getMdWetTensile(),"GP05"));
				map.put(ColumnsOfTable.COL_13,  reel.getCdWetTensile());
				map.put(ColumnsOfTable.COL_13_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getCdWetTensile(),"GP07") );
				map.put(ColumnsOfTable.COL_14,  reel.getWetDryRatio());
				map.put(ColumnsOfTable.COL_14_C, GradeTargetUtil.getColorClass(gradeTargets,reel.getWetDryRatio(),"GP10") );
				map.put(ColumnsOfTable.COL_15,  reel.getBrightness());
				map.put(ColumnsOfTable.COL_15_C, GradeTargetUtil.getColorClass(gradeTargets, reel.getBrightness(),"GP02"));
				map.put(ColumnsOfTable.COL_16,  reel.getFwaFlow());
				map.put(ColumnsOfTable.COL_17,  reel.getDirtCount());
				map.put(ColumnsOfTable.COL_17_C, GradeTargetUtil.getColorClass(gradeTargets, reel.getDirtCount(),"GP19"));
				map.put(ColumnsOfTable.COL_18,  reel.getFwaDosage());
				map.put(ColumnsOfTable.COL_19,  reel.getTph());
				map.put(ColumnsOfTable.COL_20,  reel.getTrim());
				map.put(ColumnsOfTable.COL_21,  reel.getCrepeRatio());
//				Code Starts From Here Done By Roshan Tailor Date :- 03/07/2015 MM/DD/YYYY
				map.put(ColumnsOfTable.COL_22,  reel.getLvalue());
				map.put(ColumnsOfTable.COL_23,  reel.getAvalue());
				map.put(ColumnsOfTable.COL_24,  reel.getBvalue());
//				System.out.println("Map"+map);
//				Code Ends Here Done By Roshan Tailor
				map.put(ColumnsOfTable.COL_25,  reel.getCustomer());
				map.put(ColumnsOfTable.COL_26,  reel.getRemarks());
				
				double gmtbw= Math.sqrt(reel.getMdTensile()*reel.getCdTensile())/reel.getActualBasisWt();
				
				map.put(ColumnsOfTable.COL_27, CommonUtil.round(gmtbw, 2));
				
				map.put(ColumnsOfTable.COL_28,  reel.getDeltae());
				
				map.put(ColumnsOfTable.COL_29, reel.getAkd());
				map.put(ColumnsOfTable.COL_30, reel.getWetstrength());
				map.put(ColumnsOfTable.COL_31, reel.getDrystrengthflow());
				map.put(ColumnsOfTable.COL_31_C, GradeTargetUtil.getColorClass(gradeTargets, reel.getDrystrengthflow(),"GP18"));
				map.put(ColumnsOfTable.COL_32,  reel.getCustomer1());
				map.put(ColumnsOfTable.COL_33,  reel.getCustomer2());
				
				map.put("id", reel.getId());
				datas.add(map);
			}
		}
		
		return datas;
	}

	/* (non-Javadoc)
	 * @see com.st.qualityreport.service.ReelService#createPdfReelReport(java.io.File)
	 */
	@Transactional
	@Override
	public void createPdfReelReport(File file,Date date) throws Exception {
		

		int red1 = 0,red2= 0,red3= 0,red4= 0,red5= 0,red6= 0,red7= 0,red8= 0,red9= 0,red10= 0,red11= 0,red12= 0;
		int green1= 0,green2= 0,green3= 0,green4= 0,green5= 0,green6= 0,green7= 0,green8= 0,green9= 0,green10 = 0 ,green11 = 0,green12 = 0 ;
		int yellow1= 0,yellow2= 0,yellow3= 0,yellow4= 0,yellow5= 0,yellow6= 0,yellow7= 0,yellow8= 0,yellow9= 0,yellow10 = 0,yellow11 = 0,yellow12 = 0 ;
		
		
		int loopi = 0;
		
		List<Reel> reels=reelDao.getReelData(date, date,"","","","");
		
		if(reels!=null && reels.size()>0){
			
			Font fontHeader=FontFactory.getFont("Times-Roman", 6, Font.BOLD);
			Font fontTitle=FontFactory.getFont("Times-Roman", 8, Font.BOLD);
			Font fontNormal=FontFactory.getFont("Times-Roman", 6, Font.BOLD);
			Font fontNormalRed=FontFactory.getFont("Times-Roman", 6, Font.BOLD,Color.RED);
			Font fontNormalBlue=FontFactory.getFont("Times-Roman", 6, Font.BOLD,Color.BLUE);
			
			Rectangle rectangle=new Rectangle(3*355.6f, 4*215.9f);

			Document document=new Document(rectangle,-100f,-100f,30f,10f);
			
			FileOutputStream outStream=new FileOutputStream(file);
			PdfWriter.getInstance(document, outStream);
			
			document.open();
			
			PdfPTable	table=new PdfPTable(30);
			
			table.setWidths(new int[]{2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,3,3});	
			
			
			
			table.addCell(getPdfCell("ST Tissue PM 6 Tissue Machine Quality Report-REEL Testing", 30,fontTitle,Color.YELLOW,18f));
			
			//Col header
			table.addCell(getPdfCell("Date", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Time", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Grade Code", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Reel #", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Scanner Basis wt lbs/3000", 1,fontHeader,Color.LIGHT_GRAY,30f));
			table.addCell(getPdfCell("Actual Basis wt lbs/3000ft", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Bulk mils/8 ply", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD Tensile g/inch	", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("CD Tensile g/inch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD % Stretch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD/CD Tensile Ratio", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("MD Wet Tensile g/inch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("CD Wet Tensile g/inch", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("CD Tensile Ratio Wet/Dry", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Bright ness %", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("FWA Flow (ml/min)", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("2 Sigma BW CD ", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("2 Sigma Moisture CD ", 1,fontHeader,Color.WHITE,30f));
			/*table.addCell(getPdfCell("FWA Dosage lb/Ton", 1,fontHeader,Color.WHITE,30f));
			 * <!-- Firstly it was FWA Dosage After Then Changed It To  Moisture %-->
			 * */
			table.addCell(getPdfCell("Moisture %", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("TPH", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Trim", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Crepe Ratio", 1,fontHeader,Color.WHITE,30f));
//			Code Starts From Here Done By Roshan Tailor Date :-03/07/2015 MM/DD/YYYY
			table.addCell(getPdfCell("L Value", 1, fontHeader, Color.WHITE, 30f));
			table.addCell(getPdfCell("A Value", 1, fontHeader, Color.WHITE, 30f));
			table.addCell(getPdfCell("B Value", 1, fontHeader, Color.WHITE, 30f));
			table.addCell(getPdfCell("Delta E", 1, fontHeader, Color.WHITE, 30f));
//			Code Ends Here Done By Roshan Tailor
			table.addCell(getPdfCell("Customer1", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Customer2", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Customer3", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Remarks", 1,fontHeader,Color.WHITE,30f));
			
			
			//data
			for (Map<String, Object> map : getFormatedData(reels)) {
				if(map.get(ColumnsOfTable.COL_01).toString().equalsIgnoreCase("OBJECTIVES")){
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_01).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_02).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_03).toString(), 1,fontNormalRed,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_04).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.LIGHT_GRAY,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					
					table.addCell(getPdfCell("N/A", 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell("N/A", 1,fontNormalBlue,Color.WHITE,15f));
					//table.addCell(getPdfCell("N/A", 1,fontNormalBlue,Color.WHITE,15f));
					
					
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_31).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_18).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_19).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_20).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_21).toString(), 1,fontNormalBlue,Color.WHITE,15f));
//					Code Starts From Here Done By Roshan Tailor Date:- 03/07/2015
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_22).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_23).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_24).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell("0.0", 1,fontNormalBlue,Color.WHITE,15f));
//					Code Ends Here Done By Roshan Tailor
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_25).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_26).toString(), 1,fontNormalBlue,Color.WHITE,15f));
				}else{
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_01).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_02).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_03).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_04).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.LIGHT_GRAY,15f));
					
					
					if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("redcolor")){
						red1 = red1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("greencolor")){
						green1 = green1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow1 = yellow1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green1 = green1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("redcolor")){
						red2 = red2+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("greencolor")){
						green2 = green2+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow2 = yellow2+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green2 = green2+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("redcolor")){
						red3 = red1+3;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.GREEN,15f));
						green3 = green3+1;
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow3 = yellow3+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green3 = green3+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("redcolor")){
						red4 = red4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("greencolor")){
						green4 = green4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow4 = yellow4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green4 = green4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("redcolor")){
						red5 = red5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("greencolor")){
						green5 = green5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow5 = yellow5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green5 = green5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("redcolor")){
						red6 = red6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("greencolor")){
						green6 = green6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow6 = yellow6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green6 = green6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("redcolor")){
						red7 = red7+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("greencolor")){
						green7 = green7+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow7 = yellow7+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green7 = green7+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("redcolor")){
						red8 = red8+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("greencolor")){
						green8 = green8+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow8 = yellow8+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green8 = green8+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("redcolor")){
						red9 = red9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("greencolor")){
						green9 = green9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow9 = yellow9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green9 = green9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					
					if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("redcolor")){
						red10 = red10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("greencolor")){
						green10 = green10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow10 = yellow10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green10 = green10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.WHITE,15f));
					
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_29).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_30).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					//table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_31).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					if(map.get(ColumnsOfTable.COL_31_C).toString().equalsIgnoreCase("redcolor")){
						red12 = red12+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_31).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_31_C).toString().equalsIgnoreCase("greencolor")){
						green12 = green12+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_31).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_31_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_31).toString(), 1,fontNormal,Color.YELLOW,15f));
						yellow12 = yellow12+1;
					}else{
						green12 = green12+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_31).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					if(map.get(ColumnsOfTable.COL_17_C).toString().equalsIgnoreCase("redcolor")){
						red11 = red11+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_17_C).toString().equalsIgnoreCase("greencolor")){
						green11 = green11+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_17_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormal,Color.YELLOW,15f));
						yellow11 = yellow11+1;
					}else{
						green11 = green11+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormal,Color.GREEN,15f));
					}
					
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_18).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_19).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_20).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_21).toString(), 1,fontNormal,Color.WHITE,15f));
//					Code Starts From Here Done By Roshan Tailor Date :- 03/07/2015 MM/DD/YYYY
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_22).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_23).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_24).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_28).toString(), 1,fontNormal,Color.WHITE,15f));					
//					Code Ends Here Done By Roshan Tailor
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_25)!=null?map.get(ColumnsOfTable.COL_25).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_26)!=null?map.get(ColumnsOfTable.COL_26).toString():"", 1,fontNormal,Color.WHITE,15f));
					
					loopi = loopi+1;
				}
			}
			
			double rPre1=CommonUtil.round((red1*100)/loopi, 2);
			double yPre1=CommonUtil.round((yellow1*100)/loopi, 2);
			double gPre1=CommonUtil.round((green1*100)/loopi, 2);


			double rPre2=CommonUtil.round((red2*100)/loopi, 2);
			double yPre2=CommonUtil.round((yellow2*100)/loopi, 2);
			double gPre2=CommonUtil.round((green2*100)/loopi, 2);

			double rPre3=CommonUtil.round((red3*100)/loopi, 2);
			double yPre3=CommonUtil.round((yellow3*100)/loopi, 2);
			double gPre3=CommonUtil.round((green3*100)/loopi, 2);

			double rPre4=CommonUtil.round((red4*100)/loopi, 2);
			double yPre4=CommonUtil.round((yellow4*100)/loopi, 2);
			double gPre4=CommonUtil.round((green4*100)/loopi, 2);

			double rPre5=CommonUtil.round((red5*100)/loopi, 2);
			double yPre5=CommonUtil.round((yellow5*100)/loopi, 2);
			double gPre5=CommonUtil.round((green5*100)/loopi, 2);

			double rPre6=CommonUtil.round((red6*100)/loopi, 2);
			double yPre6=CommonUtil.round((yellow6*100)/loopi, 2);
			double gPre6=CommonUtil.round((green6*100)/loopi, 2);

			double rPre7=CommonUtil.round((red7*100)/loopi, 2);
			double yPre7=CommonUtil.round((yellow7*100)/loopi, 2);
			double gPre7=CommonUtil.round((green7*100)/loopi, 2);

			double rPre8=CommonUtil.round((red8*100)/loopi, 2);
			double yPre8=CommonUtil.round((yellow8*100)/loopi, 2);
			double gPre8=CommonUtil.round((green8*100)/loopi, 2);

			double rPre9=CommonUtil.round((red9*100)/loopi, 2);
			double yPre9=CommonUtil.round((yellow9*100)/loopi, 2);
			double gPre9=CommonUtil.round((green9*100)/loopi, 2);

			double rPre10=CommonUtil.round((red10*100)/loopi, 2);
			double yPre10=CommonUtil.round((yellow10*100)/loopi, 2);
			double gPre10=CommonUtil.round((green10*100)/loopi, 2);

			double rPre11=CommonUtil.round((red11*100)/loopi, 2);
			double yPre11=CommonUtil.round((yellow11*100)/loopi, 2);
			double gPre11=CommonUtil.round((green11*100)/loopi, 2);
			
			double rPre12=CommonUtil.round((red12*100)/loopi, 2);
			double yPre12=CommonUtil.round((yellow12*100)/loopi, 2);
			double gPre12=CommonUtil.round((green12*100)/loopi, 2);
			

			
			
			table.addCell(getPdfCell("Percentage", 30,fontTitle,Color.YELLOW,18f));
					

			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("Red", 1,fontNormal,Color.RED,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre1, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre2, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre3, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre4, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre5, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre6, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre7, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre8, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre9, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre10, 2), 1,fontNormal,Color.cyan,15f));			
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			//table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			table.addCell(getPdfCell(""+CommonUtil.round(rPre12, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(rPre11, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));






			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("Green", 1,fontNormal,Color.GREEN,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre1, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre2, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre3, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre4, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre5, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre6, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre7, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre8, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre9, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre10, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			//table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			table.addCell(getPdfCell(""+CommonUtil.round(gPre12, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(gPre11, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));





			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("Yellow", 1,fontNormal,Color.YELLOW,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre1, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre2, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre3, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre4, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre5, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre6, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre7, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre8, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre9, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre10, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			//table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			table.addCell(getPdfCell(""+CommonUtil.round(yPre12, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell(""+CommonUtil.round(yPre11, 2), 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			
			document.add(table);
			
			document.close();
			
			outStream.close();
		}
		
		
	}

	private PdfPCell getPdfCell(String text,int colspan,Font font,Color color,float cellHeight){
		
		PdfPCell cell=new PdfPCell(new Phrase(text,font));
		cell.setColspan(colspan);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPaddingBottom(4.5f);
		cell.setPaddingLeft(5f);
		cell.setPaddingRight(5f);
		cell.setPaddingTop(3f);
		cell.setBorderColor(Color.BLACK);
		cell.setBorderWidth(0.2f);
		cell.setBackgroundColor(color);
		cell.setFixedHeight(cellHeight);
		return cell;
	}

	/* (non-Javadoc)
	 * @see com.st.qualityreport.service.ReelService#getBirghtnessAvgOfDay()
	 */
	@Transactional
	@Override
	public double getBirghtnessAvgOfDay() {
		return reelDao.getBirghtnessAvgOfDay();
	}

	/* (non-Javadoc)
	 * @see com.st.qualityreport.service.ReelService#getBirghtnessAvgOfLastDay()
	 */
	@Transactional
	@Override
	public double getBirghtnessAvgOfLastDay() {
		return reelDao.getBirghtnessAvgOfLastDay();
	}

	/* (non-Javadoc)
	 * @see com.st.qualityreport.service.ReelService#getBirghtnessAvgOfLastDay(java.lang.String)
	 */
	@Transactional
	@Override
	public double getBirghtnessAvgOfLastDay(String grade) {
		return  reelDao.getBirghtnessAvgOfLastDay(grade);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.ReelService#getGrades(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public List<String> getGrades(Date sdate, Date edate,
			String customer) {
		return reelDao.getGrades(sdate,edate,customer);
	}

	
//	Code Starts From Here Done By Roshan Tailor Date:- 04/07/2015
	
	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.ReelService#getcurrentreel(java.lang.String)
	 */
	@Transactional
	@Override
	public String getcurrentreel(String currentReelNumber , String CurrentGradeCodeByAjax) {
		// TODO Auto-generated method stub
		return reelDao.getcurrentreel(currentReelNumber, CurrentGradeCodeByAjax);
	}
// 	Code Ends Here Done By Roshan Tailor

//	Code Starts From Here Done By Roshan TAilor Date:- 04/16/2015	
	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.ReelService#getlastgradecode()
	 */
	@Transactional
	@Override
	public String getlastgradecode() {
		return reelDao.getlastgradecode();
	}

	/* (non-Javadoc) 
	 * @see com.st.qualitypm6.service.ReelService#getReelData(java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<Reel> getReelData(Date sdate, Date edate, String grade,
			String customer, String reel, String type) {
		return reelDao.getReelData(sdate,edate,grade,customer,reel,type);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.ReelService#getReelByReelNo(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Reel> getReelByReelNo(String string, Date dateFrom, Date dateTo) {
		// TODO Auto-generated method stub
		return reelDao.getReelByReelNo(string,dateFrom,dateTo);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.ReelService#getReelByReelNopm5(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Reel> getReelByReelNopm5(String string, Date dateFrom, Date dateTo) {
		// TODO Auto-generated method stub
		return reelDao.getReelByReelNopm5(string,dateFrom,dateTo);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.ReelService#getReelByReelNo_Pm5(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Reel> getReelByReelNo_Pm5(String valueOf, Date dateTo, Date dateFrom) {
		// TODO Auto-generated method stub
		return reelDao.getReelByReelNo_Pm5(valueOf,dateFrom,dateTo);
	}

//	Code Starts From Here Done By Roshan Taiilor
}
