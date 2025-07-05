/**
 *Dec 25, 2017
 *RewindServicePM5Imp.java
 * TODO
 *com.st.qualitypm5.service
 *RewindServicePM5Imp.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.service;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.lowagie.text.DocumentException;
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
import com.st.common.GradeTargetPM5Util;
import com.st.common.GradeTargetUtil;
import com.st.qualitypm5.dao.GradeTargetPM5Dao;
import com.st.qualitypm5.dao.RewindDaoPM5;
import com.st.qualitypm5.model.GradeTargetPM5;
import com.st.qualitypm5.model.RewindPM5;
import com.st.qualitypm6.model.GradeTarget;
import com.st.qualitypm6.model.Rewind;


/**
 * @author roshan
 *
 */
@Service
public class RewindServicePM5Imp implements RewindServicePM5 {

	private SimpleDateFormat dateFormat1=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat dateFormat2=new SimpleDateFormat("MM/dd/yyyy");
	private SimpleDateFormat dateFormat3=new SimpleDateFormat("HH:mm");
	
	@Autowired
	private RewindDaoPM5 rewindDaoPM5;
	
	@Autowired
	private GradeTargetPM5Dao gradeTargetPM5Dao;
	
	
	
	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.RewindServicePM5#getRewinds(java.lang.String, java.util.Date)
	 */
	@Override
	@Transactional
	public List<RewindPM5> getRewinds(String gradeCode, Date jdate) {
		// TODO Auto-generated method stub
		return rewindDaoPM5.getRewinds(gradeCode, jdate);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.RewindServicePM5#getRewindById(int)
	 */
	@Override
	@Transactional
	public RewindPM5 getRewindById(int id) {
		// TODO Auto-generated method stub
		return rewindDaoPM5.getRewindById(id);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.RewindServicePM5#update(com.st.qualitypm5.model.RewindPM5)
	 */
	@Override
	@Transactional
	public void update(RewindPM5 rewind) {
		// TODO Auto-generated method stub
		rewindDaoPM5.update(rewind);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.RewindServicePM5#isSetNumberExist(java.lang.String)
	 */
	@Override
	@Transactional
	public boolean isSetNumberExist(String setNo) {
		// TODO Auto-generated method stub
		return rewindDaoPM5.isSetNumberExist(setNo);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.RewindServicePM5#save(com.st.qualitypm5.model.RewindPM5)
	 */
	@Override
	@Transactional
	public int save(RewindPM5 rewind) {
		// TODO Auto-generated method stub
		return rewindDaoPM5.save(rewind);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.RewindServicePM5#delete(java.util.List)
	 */
	@Override
	@Transactional
	public void delete(List<String> idsList) {
		// TODO Auto-generated method stub
		rewindDaoPM5.delete(idsList);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.RewindServicePM5#getRewindInfo(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public List<RewindPM5> getRewindInfo(String reel, String set) {
		// TODO Auto-generated method stub
		return rewindDaoPM5.getRewindInfo(reel,set);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.RewindServicePM5#getRewindData(java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public List<RewindPM5> getRewindData(Date sdate, Date edate, String grade, String customer, String reel, String type) {
		// TODO Auto-generated method stub
		return rewindDaoPM5.getRewindData(sdate,edate,grade,customer,reel,type);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.RewindServicePM5#getFormatedData(java.util.List)
	 */
	@Transactional
	@Override
	public List<Map<String, Object>> getFormatedData(List<RewindPM5> rewinds){
		List<Map<String, Object>> datas=new ArrayList<>();
		
		if(rewinds==null){
			return datas;
		}
		
		String gradeCode="";
		Date date=null;
		Map<String, Object> mapObjOld=null;
		
		List<GradeTargetPM5> gradeTargets=null;
		for (RewindPM5 rewind : rewinds) {
			if(rewind.getGradeCode().equals(gradeCode)){
				
				try {
					if(date.compareTo(dateFormat1.parse(dateFormat1.format(rewind.getDate())))!=0){
						date=dateFormat1.parse(dateFormat1.format(rewind.getDate()));
						datas.add(mapObjOld);
						
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Map<String, Object> map=new HashMap<>();
				
				
				if(gradeTargets==null){
					gradeTargets=gradeTargetPM5Dao.getGradeTarget(rewind.getGradeCode());
				}
				
				
				map.put(ColumnsOfTable.COL_01, dateFormat2.format(rewind.getDate())); //DATE
				map.put(ColumnsOfTable.COL_02, rewind.getGradeCode());
				map.put(ColumnsOfTable.COL_03,  rewind.getReel()); 
				map.put(ColumnsOfTable.COL_04,  rewind.getSetNo().toUpperCase());
				map.put(ColumnsOfTable.COL_05,  rewind.getActualBasisWt());
				map.put(ColumnsOfTable.COL_05_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getActualBasisWt(),"GP01"));
				map.put(ColumnsOfTable.COL_06,  rewind.getBulk());
				map.put(ColumnsOfTable.COL_06_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getBulk(),"GP03"));
				map.put(ColumnsOfTable.COL_07,  rewind.getMdTensile());
				map.put(ColumnsOfTable.COL_07_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getMdTensile(),"GP04"));
				map.put(ColumnsOfTable.COL_08,  rewind.getCdTensile());
				map.put(ColumnsOfTable.COL_08_C, GradeTargetPM5Util.getColorClass(gradeTargets, rewind.getCdTensile(),"GP06"));
				map.put(ColumnsOfTable.COL_09,  rewind.getMdStretch());
				map.put(ColumnsOfTable.COL_09_C,  GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getMdStretch(),"GP08"));
				map.put(ColumnsOfTable.COL_10,  rewind.getMdcdTensileRatio());
				map.put(ColumnsOfTable.COL_10_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getMdcdTensileRatio(),"GP09"));
				map.put(ColumnsOfTable.COL_11,  rewind.getMdWetTensile());
				map.put(ColumnsOfTable.COL_11_C,GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getMdWetTensile(),"GP05"));
				map.put(ColumnsOfTable.COL_12,  rewind.getCdWetTensile());
				map.put(ColumnsOfTable.COL_12_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getCdWetTensile(),"GP07") );
				map.put(ColumnsOfTable.COL_13,  rewind.getCdTensileRatio());
				map.put(ColumnsOfTable.COL_13_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getCdTensileRatio(),"GP10") );
				map.put(ColumnsOfTable.COL_14,  rewind.getBrightness());
				map.put(ColumnsOfTable.COL_14_C, GradeTargetPM5Util.getColorClass(gradeTargets, rewind.getBrightness(),"GP02"));
				map.put(ColumnsOfTable.COL_15,  rewind.getDirtCount());
				map.put(ColumnsOfTable.COL_15_C, GradeTargetPM5Util.getColorClass(gradeTargets, rewind.getDirtCount(),"GP11"));
				map.put(ColumnsOfTable.COL_16,  rewind.getAbsorbencySeconds());
				map.put(ColumnsOfTable.COL_16_C, GradeTargetPM5Util.getColorClass(gradeTargets, rewind.getAbsorbencySeconds(),"GP12"));
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
				try {
					date=dateFormat1.parse(dateFormat1.format(rewind.getDate()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Map<String, Object> mapObj=new HashMap<>();
				
				gradeTargets=gradeTargetPM5Dao.getGradeTarget(rewind.getGradeCode());
				
				mapObj.put(ColumnsOfTable.COL_01, "OBJECTIVES"); //DATE
				mapObj.put(ColumnsOfTable.COL_02, rewind.getGradeCode());
				mapObj.put(ColumnsOfTable.COL_03,  "N/A"); 
				mapObj.put(ColumnsOfTable.COL_04,  "N/A");
				mapObj.put(ColumnsOfTable.COL_05,  CommonUtil.getValues(gradeTargets, "GP01"));
				mapObj.put(ColumnsOfTable.COL_06,  CommonUtil.getValues(gradeTargets, "GP03"));
				mapObj.put(ColumnsOfTable.COL_07,  CommonUtil.getValues(gradeTargets, "GP04"));
				mapObj.put(ColumnsOfTable.COL_08,  CommonUtil.getValues(gradeTargets, "GP06"));
				mapObj.put(ColumnsOfTable.COL_09,  CommonUtil.getValues(gradeTargets, "GP08"));
				mapObj.put(ColumnsOfTable.COL_10,  CommonUtil.getValues(gradeTargets, "GP09"));
				mapObj.put(ColumnsOfTable.COL_11,  CommonUtil.getValues(gradeTargets, "GP05"));
				mapObj.put(ColumnsOfTable.COL_12,  CommonUtil.getValues(gradeTargets, "GP07"));
				mapObj.put(ColumnsOfTable.COL_13,  CommonUtil.getValues(gradeTargets, "GP10"));
				mapObj.put(ColumnsOfTable.COL_14,  CommonUtil.getValues(gradeTargets, "GP02"));
				mapObj.put(ColumnsOfTable.COL_15,  CommonUtil.getValues(gradeTargets, "GP11"));
				mapObj.put(ColumnsOfTable.COL_16,  CommonUtil.getValues(gradeTargets, "GP12"));
				mapObj.put(ColumnsOfTable.COL_17,  CommonUtil.getValues(gradeTargets, "GP13")); //This Code Is Related To The rewinderReportDatewise.jap
				mapObj.put(ColumnsOfTable.COL_18,  CommonUtil.getValues(gradeTargets, "GP14"));//This Code Is Related To The rewinderReportDatewise.jap
				mapObj.put(ColumnsOfTable.COL_19,  CommonUtil.getValues(gradeTargets, "GP15"));//This Code Is Related To The rewinderReportDatewise.jap
				
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
				map.put(ColumnsOfTable.COL_05_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getActualBasisWt(),"GP01"));
				map.put(ColumnsOfTable.COL_06,  rewind.getBulk());
				map.put(ColumnsOfTable.COL_06_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getBulk(),"GP03"));
				map.put(ColumnsOfTable.COL_07,  rewind.getMdTensile());
				map.put(ColumnsOfTable.COL_07_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getMdTensile(),"GP04"));
				map.put(ColumnsOfTable.COL_08,  rewind.getCdTensile());
				map.put(ColumnsOfTable.COL_08_C, GradeTargetPM5Util.getColorClass(gradeTargets, rewind.getCdTensile(),"GP06"));
				map.put(ColumnsOfTable.COL_09,  rewind.getMdStretch());
				map.put(ColumnsOfTable.COL_09_C,  GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getMdStretch(),"GP08"));
				map.put(ColumnsOfTable.COL_10,  rewind.getMdcdTensileRatio());
				map.put(ColumnsOfTable.COL_10_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getMdcdTensileRatio(),"GP09"));
				map.put(ColumnsOfTable.COL_11,  rewind.getMdWetTensile());
				map.put(ColumnsOfTable.COL_11_C,GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getMdWetTensile(),"GP05"));
				map.put(ColumnsOfTable.COL_12,  rewind.getCdWetTensile());
				map.put(ColumnsOfTable.COL_12_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getCdWetTensile(),"GP07") );
				map.put(ColumnsOfTable.COL_13,  rewind.getCdTensileRatio());
				map.put(ColumnsOfTable.COL_13_C, GradeTargetPM5Util.getColorClass(gradeTargets,rewind.getCdTensileRatio(),"GP10") );
				map.put(ColumnsOfTable.COL_14,  rewind.getBrightness());
				map.put(ColumnsOfTable.COL_14_C, GradeTargetPM5Util.getColorClass(gradeTargets, rewind.getBrightness(),"GP02"));
				map.put(ColumnsOfTable.COL_15,  rewind.getDirtCount());
				map.put(ColumnsOfTable.COL_15_C, GradeTargetPM5Util.getColorClass(gradeTargets, rewind.getDirtCount(),"GP11"));
				map.put(ColumnsOfTable.COL_16,  rewind.getDirtCount());
				map.put(ColumnsOfTable.COL_16_C, GradeTargetPM5Util.getColorClass(gradeTargets, rewind.getDirtCount(),"GP11"));
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

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.service.RewindServicePM5#createPdfReelReport(java.io.File, java.util.Date)
	 */
	@Override
	public void createPdfReelReport(File fileRwinderPdf, Date date) throws DocumentException, IOException {
		List<RewindPM5> rewinds=rewindDaoPM5.getRewindData(date, date,"","","","");
		
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
			
			
			table.addCell(getPdfCell("ST Tissue PM5 Tissue Machine Quality Report-REWINDTesting", 22,fontTitle,Color.PINK,18f));
			
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
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_05_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_05).toString(), 1,fontNormal,Color.WHITE,15f));
					}		
					
					
					
					if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_06_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_06).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_07_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_07).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_08_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_08).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_09_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_09).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_10_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_10).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
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
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_12_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_12).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_13_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_13).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
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
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_15_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_15).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
					
					
					if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("redcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.RED,15f));
					}else if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("greencolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.GREEN,15f));
					}else if(map.get(ColumnsOfTable.COL_16_C).toString().equalsIgnoreCase("yellowcolor")){
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.YELLOW,15f));
					}else{
						table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_16).toString(), 1,fontNormal,Color.WHITE,15f));
					}
					
//					Code Starts From Here Done By Roshan TAilor Date ;-03/07/2015
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_23)!=null?map.get(ColumnsOfTable.COL_23).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_24)!=null?map.get(ColumnsOfTable.COL_24).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_25)!=null?map.get(ColumnsOfTable.COL_25).toString():"", 1,fontNormal,Color.WHITE,15f));
//					Code Ends Here Done By Roshan Tailor				
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_26)!=null?map.get(ColumnsOfTable.COL_26).toString():"", 1,fontNormal,Color.WHITE,15f));
					table.addCell(getPdfCell(map.get(ColumnsOfTable.COL_27)!=null?map.get(ColumnsOfTable.COL_27).toString():"", 1,fontNormal,Color.WHITE,15f));
				}
			}
			
			document.add(table);
			
			document.close();
			
			outStream.close();
		}
		
		
		
	}

	/**
	 * @param string
	 * @param i
	 * @param fontNormal
	 * @param white
	 * @param f
	 * @return
	 */
	private PdfPCell getPdfCell(String text,int colspan,Font font,Color color,float cellHeight) {
		
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
	
	
	
}
