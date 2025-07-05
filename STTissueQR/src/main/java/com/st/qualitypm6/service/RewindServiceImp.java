package com.st.qualitypm6.service;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
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
import com.st.qualitypm6.dao.RewindDao;
import com.st.qualitypm6.model.GradeTarget;
import com.st.qualitypm6.model.Rewind;

@Service
public class RewindServiceImp implements RewindService {

	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat2=new SimpleDateFormat("MM/dd/yyyy");
	private SimpleDateFormat dateFormat3=new SimpleDateFormat("HH:mm");
	
	@Autowired
	private RewindDao rewindDao;
	
	@Autowired
	private GradeTargetDao gradeTargetDao;
	
	@Transactional
	@Override
	public List<Rewind> getRewinds(String gradeCode, String reel, Date date) {
		
		return rewindDao.getRewinds(gradeCode, reel, date);
	}



	/*@Transactional
	@Override
	public List<Rewind> getRewinds(String gradeCode, Date date, String reel,
			String entryAutoFlag) {
		return rewindDao.getRewinds(gradeCode, date, reel, entryAutoFlag);
	}
*/
	@Transactional
	@Override
	public boolean isSetNumberExist(String setNo) {
		
		return rewindDao.isSetNumberExist(setNo);
	}

	@Transactional
	@Override
	public void delete(List<String> idsList) {
		rewindDao.delete(idsList);
		
	}


	@Transactional
	@Override
	public int save(Rewind rewind) throws Exception {
		return rewindDao.save(rewind);
		
	}


	/*@Transactional
	@Override
	public void update(Rewind rewind, String entryAutoFlag) throws Exception {
		rewindDao.update(rewind, entryAutoFlag);
		
	}*/





	@Transactional
	@Override
	public void update(Rewind rewind) {
		rewindDao.update(rewind);
		
	}








	@Transactional
	@Override
	public List<Rewind> getRewinds(String gradeCode, Date jdate, String reelNo) {
		
		return rewindDao.getRewinds(gradeCode, jdate, reelNo);
	}


	@Transactional
	@Override
	public Rewind getRewindById(int id) {
		
		return rewindDao.getRewindById(id);
	}


	@Transactional
	@Override
	public List<Rewind> getRewinds(String gradeCode, Date jdate) {
		
		return rewindDao.getRewinds(gradeCode, jdate);
	}


	/*@Transactional
	@Override
	public void updateEntryById(List<Integer> ids, String entryFlag) {
		rewindDao.updateEntryById(ids, entryFlag);
	}
*/


	
	@Transactional
	@Override
	public List<Rewind> getRewindInfo(String reel, String set) {

		return rewindDao.getRewindInfo(reel,set);
	}



	@Transactional
	@Override
	public List<Map<String, Object>> getFormatedData(List<Rewind> rewinds)
			throws Exception {
		List<Map<String, Object>> datas=new ArrayList<>();
		
		if(rewinds==null){
			return datas;
		}
		
		String gradeCode="";
		Date date=null;
		Map<String, Object> mapObjOld=null;
		
		List<GradeTarget> gradeTargets=null;
		for (Rewind rewind : rewinds) {
			if(rewind.getGradeCode().equals(gradeCode)){
				
				if(date.compareTo(dateFormat1.parse(dateFormat1.format(rewind.getDate())))!=0){
					date=dateFormat1.parse(dateFormat1.format(rewind.getDate()));
					datas.add(mapObjOld);
					
				}
				
				Map<String, Object> map=new HashMap<>();
				
				
				if(gradeTargets==null){
					gradeTargets=gradeTargetDao.getGradeTarget(rewind.getGradeCode());
				}
				
				
				map.put(ColumnsOfTable.COL_01, dateFormat2.format(rewind.getDate())); //DATE
				map.put(ColumnsOfTable.COL_02, rewind.getGradeCode());
				map.put(ColumnsOfTable.COL_03,  rewind.getReel()); 
				map.put(ColumnsOfTable.COL_04,  rewind.getSetNo().toUpperCase());
				map.put(ColumnsOfTable.COL_05,  rewind.getActualBasisWt());
				map.put(ColumnsOfTable.COL_05_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getActualBasisWt(),"GP01"));
				map.put(ColumnsOfTable.COL_06,  rewind.getBulk());
				map.put(ColumnsOfTable.COL_06_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getBulk(),"GP03"));
				map.put(ColumnsOfTable.COL_07,  rewind.getMdTensile());
				map.put(ColumnsOfTable.COL_07_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getMdTensile(),"GP04"));
				map.put(ColumnsOfTable.COL_08,  rewind.getCdTensile());
				map.put(ColumnsOfTable.COL_08_C, GradeTargetUtil.getColorClass(gradeTargets, rewind.getCdTensile(),"GP06"));
				map.put(ColumnsOfTable.COL_09,  rewind.getMdStretch());
				map.put(ColumnsOfTable.COL_09_C,  GradeTargetUtil.getColorClass(gradeTargets,rewind.getMdStretch(),"GP08"));
				map.put(ColumnsOfTable.COL_10,  rewind.getMdcdTensileRatio());
				map.put(ColumnsOfTable.COL_10_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getMdcdTensileRatio(),"GP09"));
				map.put(ColumnsOfTable.COL_11,  rewind.getMdWetTensile());
				map.put(ColumnsOfTable.COL_11_C,GradeTargetUtil.getColorClass(gradeTargets,rewind.getMdWetTensile(),"GP05"));
				map.put(ColumnsOfTable.COL_12,  rewind.getCdWetTensile());
				map.put(ColumnsOfTable.COL_12_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getCdWetTensile(),"GP07") );
				map.put(ColumnsOfTable.COL_13,  rewind.getCdTensileRatio());
				map.put(ColumnsOfTable.COL_13_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getCdTensileRatio(),"GP10") );
				map.put(ColumnsOfTable.COL_14,  rewind.getBrightness());
				map.put(ColumnsOfTable.COL_14_C, GradeTargetUtil.getColorClass(gradeTargets, rewind.getBrightness(),"GP02"));
				map.put(ColumnsOfTable.COL_15,  rewind.getDirtCount());
				map.put(ColumnsOfTable.COL_15_C, GradeTargetUtil.getColorClass(gradeTargets, rewind.getDirtCount(),"GP11"));
				map.put(ColumnsOfTable.COL_16,  rewind.getAbsorbencySeconds());
				map.put(ColumnsOfTable.COL_16_C, GradeTargetUtil.getColorClass(gradeTargets, rewind.getAbsorbencySeconds(),"GP12"));
//				Code Starts From Here Done By Roshan Tailor Date:- 03/07/2015
				map.put(ColumnsOfTable.COL_23,  rewind.getLvalue());//These Are Not Database Columns But Are The Table Columns Of Report Table See http://localhost:8080/STTISSUE/rewindreport/view/01-01-2014/03-09-2015
				map.put(ColumnsOfTable.COL_24,  rewind.getAvalue());//These Are Not Database Columns But Are The Table Columns Of Report Table See http://localhost:8080/STTISSUE/rewindreport/view/01-01-2014/03-09-2015
				map.put(ColumnsOfTable.COL_25,  rewind.getBvalue());//These Are Not Database Columns But Are The Table Columns Of Report Table See http://localhost:8080/STTISSUE/rewindreport/view/01-01-2014/03-09-2015
//				Code Ends Here Done By Roshan Tailor 
				map.put(ColumnsOfTable.COL_26,  rewind.getCustomer());
				map.put(ColumnsOfTable.COL_27,  rewind.getRemarks());
				map.put(ColumnsOfTable.COL_19, dateFormat3.format(rewind.getDate())); //Time
				
				map.put("id", rewind.getId());
				
				
				datas.add(map);
				
				
			}else{
				gradeCode=rewind.getGradeCode();
				date=dateFormat1.parse(dateFormat1.format(rewind.getDate()));
				
				Map<String, Object> mapObj=new HashMap<>();
				
				gradeTargets=gradeTargetDao.getGradeTarget(rewind.getGradeCode());
				
				mapObj.put(ColumnsOfTable.COL_01, "OBJECTIVES"); //DATE
				mapObj.put(ColumnsOfTable.COL_02, rewind.getGradeCode());
				mapObj.put(ColumnsOfTable.COL_03,  "N/A"); 
				mapObj.put(ColumnsOfTable.COL_04,  "N/A");
				mapObj.put(ColumnsOfTable.COL_05,  CommonUtil.getValue(gradeTargets, "GP01"));
				mapObj.put(ColumnsOfTable.COL_06,  CommonUtil.getValue(gradeTargets, "GP03"));
				mapObj.put(ColumnsOfTable.COL_07,  CommonUtil.getValue(gradeTargets, "GP04"));
				mapObj.put(ColumnsOfTable.COL_08,  CommonUtil.getValue(gradeTargets, "GP06"));
				mapObj.put(ColumnsOfTable.COL_09,  CommonUtil.getValue(gradeTargets, "GP08"));
				mapObj.put(ColumnsOfTable.COL_10,  CommonUtil.getValue(gradeTargets, "GP09"));
				mapObj.put(ColumnsOfTable.COL_11,  CommonUtil.getValue(gradeTargets, "GP05"));
				mapObj.put(ColumnsOfTable.COL_12,  CommonUtil.getValue(gradeTargets, "GP07"));
				mapObj.put(ColumnsOfTable.COL_13,  CommonUtil.getValue(gradeTargets, "GP10"));
				mapObj.put(ColumnsOfTable.COL_14,  CommonUtil.getValue(gradeTargets, "GP02"));
				mapObj.put(ColumnsOfTable.COL_15,  CommonUtil.getValue(gradeTargets, "GP11"));
				mapObj.put(ColumnsOfTable.COL_16,  CommonUtil.getValue(gradeTargets, "GP12"));
//				Code Starts From Here Done By Roshan Tailor Date :- 03/12/2015
				mapObj.put(ColumnsOfTable.COL_17,  CommonUtil.getValue(gradeTargets, "GP13")); //This Code Is Related To The rewinderReportDatewise.jap
				mapObj.put(ColumnsOfTable.COL_18,  CommonUtil.getValue(gradeTargets, "GP14"));//This Code Is Related To The rewinderReportDatewise.jap
				mapObj.put(ColumnsOfTable.COL_19,  CommonUtil.getValue(gradeTargets, "GP15"));//This Code Is Related To The rewinderReportDatewise.jap
//				Code Ends Here Done By Roshan Tailor 
				
				mapObj.put(ColumnsOfTable.COL_20,  "");
				mapObj.put(ColumnsOfTable.COL_21,  "");
				
				datas.add(mapObj);
				mapObjOld=mapObj;
				
				
				Map<String, Object> map=new HashMap<>();
				
				map.put(ColumnsOfTable.COL_01, dateFormat2.format(rewind.getDate())); //DATE
				map.put(ColumnsOfTable.COL_02, rewind.getGradeCode());
				map.put(ColumnsOfTable.COL_03,  rewind.getReel()); 
				map.put(ColumnsOfTable.COL_04,  rewind.getSetNo().toUpperCase());
				map.put(ColumnsOfTable.COL_05,  rewind.getActualBasisWt());
				map.put(ColumnsOfTable.COL_05_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getActualBasisWt(),"GP01"));
				map.put(ColumnsOfTable.COL_06,  rewind.getBulk());
				map.put(ColumnsOfTable.COL_06_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getBulk(),"GP03"));
				map.put(ColumnsOfTable.COL_07,  rewind.getMdTensile());
				map.put(ColumnsOfTable.COL_07_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getMdTensile(),"GP04"));
				map.put(ColumnsOfTable.COL_08,  rewind.getCdTensile());
				map.put(ColumnsOfTable.COL_08_C, GradeTargetUtil.getColorClass(gradeTargets, rewind.getCdTensile(),"GP06"));
				map.put(ColumnsOfTable.COL_09,  rewind.getMdStretch());
				map.put(ColumnsOfTable.COL_09_C,  GradeTargetUtil.getColorClass(gradeTargets,rewind.getMdStretch(),"GP08"));
				map.put(ColumnsOfTable.COL_10,  rewind.getMdcdTensileRatio());
				map.put(ColumnsOfTable.COL_10_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getMdcdTensileRatio(),"GP09"));
				map.put(ColumnsOfTable.COL_11,  rewind.getMdWetTensile());
				map.put(ColumnsOfTable.COL_11_C,GradeTargetUtil.getColorClass(gradeTargets,rewind.getMdWetTensile(),"GP05"));
				map.put(ColumnsOfTable.COL_12,  rewind.getCdWetTensile());
				map.put(ColumnsOfTable.COL_12_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getCdWetTensile(),"GP07") );
				map.put(ColumnsOfTable.COL_13,  rewind.getCdTensileRatio());
				map.put(ColumnsOfTable.COL_13_C, GradeTargetUtil.getColorClass(gradeTargets,rewind.getCdTensileRatio(),"GP10") );
				map.put(ColumnsOfTable.COL_14,  rewind.getBrightness());
				map.put(ColumnsOfTable.COL_14_C, GradeTargetUtil.getColorClass(gradeTargets, rewind.getBrightness(),"GP02"));
				map.put(ColumnsOfTable.COL_15,  rewind.getDirtCount());
				map.put(ColumnsOfTable.COL_15_C, GradeTargetUtil.getColorClass(gradeTargets, rewind.getDirtCount(),"GP11"));
				map.put(ColumnsOfTable.COL_16,  rewind.getDirtCount());
				map.put(ColumnsOfTable.COL_16_C, GradeTargetUtil.getColorClass(gradeTargets, rewind.getDirtCount(),"GP11"));
//				Code Starts From Here Done By Roshan Tailor Date :- 03/07/2015
				map.put(ColumnsOfTable.COL_23,  rewind.getLvalue());
				map.put(ColumnsOfTable.COL_24,  rewind.getAvalue());
				map.put(ColumnsOfTable.COL_25,  rewind.getBvalue());
//				System.out.println("Map"+map);
//				Code Ends Here Done By Roshan Tailor
				map.put(ColumnsOfTable.COL_26,  rewind.getCustomer());
				map.put(ColumnsOfTable.COL_27,  rewind.getRemarks());
				map.put(ColumnsOfTable.COL_19, dateFormat3.format(rewind.getDate())); //Time
				map.put("id", rewind.getId());
				datas.add(map);
			}
		}
		
		return datas;
	}



	@Transactional
	@Override
	public void createPdfReelReport(File fileRwinderPdf, Date date) throws Exception {
		List<Rewind> rewinds=rewindDao.getRewindData(date, date,"","","","");
		
		int red1 = 0,red2= 0,red3= 0,red4= 0,red5= 0,red6= 0,red7= 0,red8= 0,red9= 0,red10= 0,red11= 0;
		int green1= 0,green2= 0,green3= 0,green4= 0,green5= 0,green6= 0,green7= 0,green8= 0,green9= 0,green10 = 0 ,green11 = 0 ;
		int yellow1= 0,yellow2= 0,yellow3= 0,yellow4= 0,yellow5= 0,yellow6= 0,yellow7= 0,yellow8= 0,yellow9= 0,yellow10 = 0,yellow11 = 0 ;
		
		int loopi = 0;
		
		if(rewinds!=null && rewinds.size()>0){
			Font fontHeader=FontFactory.getFont("Times-Roman", 6, Font.BOLD);
			Font fontTitle=FontFactory.getFont("Times-Roman", 8, Font.BOLD);
			Font fontNormal=FontFactory.getFont("Times-Roman", 6, Font.BOLD);
			Font fontNormalRed=FontFactory.getFont("Times-Roman", 6, Font.BOLD,Color.RED);
			Font fontNormalBlue=FontFactory.getFont("Times-Roman", 6, Font.BOLD,Color.BLUE);
			
			Rectangle rectangle=new Rectangle(3*355.6f, 4*215.9f);

			Document document=new Document(rectangle,-100f,-100f,30f,10f);
			
			FileOutputStream outStream=new FileOutputStream(fileRwinderPdf);
			PdfWriter.getInstance(document, outStream);
			
			document.open();
			
			PdfPTable	table=new PdfPTable(22);
			
			table.setWidths(new int[]{2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3});	
			
			
			table.addCell(getPdfCell("ST Tissue PM6 Tissue Machine Quality Report-REWINDTesting", 22,fontTitle,Color.PINK,18f));
			
			//Col header
			table.addCell(getPdfCell("Date", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Time", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Grade Code", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Reel #", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Set #", 1,fontHeader,Color.WHITE,30f));
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
			table.addCell(getPdfCell("Dirt Count ppm", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Absorbency seconds", 1,fontHeader,Color.WHITE,30f));
//			Code Starts From Here Done By Roshan Tailor Date ;-03/07/2015
			table.addCell(getPdfCell("L Value", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("A Value", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("B Value", 1,fontHeader,Color.WHITE,30f));
//			Code Ends Here Done By Roshan Tailor 
			table.addCell(getPdfCell("Customer", 1,fontHeader,Color.WHITE,30f));
			table.addCell(getPdfCell("Remarks", 1,fontHeader,Color.WHITE,30f));
			
			
			//data
			for (Map<String, Object> map : getFormatedData(rewinds)) {
				if(map.get(ColumnsOfTable.COL_01).toString().equalsIgnoreCase("OBJECTIVES")){
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_01).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell("N/A", 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_02).toString(), 1,fontNormalRed,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_03).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_04).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormalBlue,Color.WHITE,15f));
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

//					Code Starts From Here Done By Roshan Tailor Date :- 03/07/2015
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_17).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_18).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_19).toString(), 1,fontNormalBlue,Color.WHITE,15f));
//					Code Ends Here Done By Roshan Tailor 
					
					
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_20).toString(), 1,fontNormalBlue,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_21).toString(), 1,fontNormalBlue,Color.WHITE,15f));

					
				}else{
					
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_01).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_19).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_02).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_03).toString(), 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_04).toString(), 1,fontNormal,Color.WHITE,15f));
					
					

					if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("redcolor")){
						red1 = red1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("greencolor")){
						green1 = green1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow1 = yellow1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green1 = green1+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.WHITE,15f));
					}		
					
					
					
					
					if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.RED,15f));
						red2 = red2+1;
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.GREEN,15f));
						green2 = green2+1;
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.YELLOW,15f));
						yellow2 = yellow2+1;
					}else{
						green2 = green2+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("redcolor")){
						red3 = red1+3;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("greencolor")){
						green3 = green3+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow3 = yellow3+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green3 = green3+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("redcolor")){
						red4 = red4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("greencolor")){
						green4 = green4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow4 = yellow4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green4 = green4+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("redcolor")){
						red5 = red5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("greencolor")){
						green5 = green5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow5 = yellow5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green5 = green5+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("redcolor")){
						red6 = red6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("greencolor")){
						green6 = green6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow6 = yellow6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green6 = green6+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.WHITE,15f));
					}
				
					
					
					if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_11_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_11).toString(), 1,fontNormal,Color.WHITE,15f));
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
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.WHITE,15f));
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
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_14_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_14).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("redcolor")){
						red9 = red9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("greencolor")){
						green9 = green9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow9 = yellow9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green9 = green9+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("redcolor")){
						red10 = red10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("greencolor")){
						green10 = green10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("yellowcolor")){
						yellow10 = yellow10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						green10 = green10+1;
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
//					Code Starts From Here Done By Roshan TAilor Date ;-03/07/2015
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_23)!=null?map.get(ColumnsOfTable.COL_23).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_24)!=null?map.get(ColumnsOfTable.COL_24).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_25)!=null?map.get(ColumnsOfTable.COL_25).toString():"", 1,fontNormal,Color.WHITE,15f));
//					Code Ends Here Done By Roshan Tailor				
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_26)!=null?map.get(ColumnsOfTable.COL_26).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_27)!=null?map.get(ColumnsOfTable.COL_27).toString():"", 1,fontNormal,Color.WHITE,15f));
					
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
			
			table.addCell(getPdfCell("Percentage", 22,fontTitle,Color.YELLOW,18f));
			

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
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			
			table.addCell(getPdfCell(""+CommonUtil.round(rPre11, 2), 1,fontNormal,Color.cyan,15f));
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
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			
			table.addCell(getPdfCell(""+CommonUtil.round(gPre11, 2), 1,fontNormal,Color.cyan,15f));
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
			table.addCell(getPdfCell("", 1,fontNormal,Color.cyan,15f));
			
			
			table.addCell(getPdfCell(""+CommonUtil.round(yPre11, 2), 1,fontNormal,Color.cyan,15f));
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
	 * @see com.st.qualitypm6.service.RewindService#getRewindByGradeCustomerGraph(java.util.Date, java.util.Date, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<Rewind> getRewindByGradeCustomerGraph(List<String> reels,
			String gradeCode, String customer) {
		return rewindDao.getRewindByGradeCustomerGraph(reels,gradeCode,customer);
	}



	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.RewindService#getRewindData(java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<Rewind> getRewindData(Date sdate, Date edate, String grade,
			String customer, String reel, String type) {
		return rewindDao.getRewindData(sdate,edate,grade,customer,reel,type);
	}
}
