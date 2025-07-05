/**
 *Oct 17, 2019
 *QulityCheck_Pm6ServiceImp.java
 * TODO
 *com.st.qualitypm6.service
 *QulityCheck_Pm6ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.qualitypm5.dao.QulityCheckPm5Dao;
import com.st.qualitypm6.dao.QulityCheckPm6Dao;
import com.st.qualitypm6.model.QulityCheck_Pm6;

import productspecificationsignoffsheet.ProductSpecificationSignOffSheet;

/**
 * @author roshan
 *
 */
@Service
public class QulityCheckPm5ServiceImp implements QulityCheckPm5Service {

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.QulityCheck_Pm6Service#getDataOfQulityCheck_Pm6(java.util.Date)
	 */
	@Autowired
	private QulityCheckPm5Dao qulitycheckpm6dao;
	
	@Override
	public List<QulityCheck_Pm6> getDataOfQulityCheck_Pm6(Date date) {
		// TODO Auto-generated method stub
		
		
		
		return qulitycheckpm6dao.getDataOfQulityCheck_Pm6(date);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.QulityCheckPm6Service#savequalitychecklist(com.st.qualitypm6.model.QulityCheck_Pm6)
	 */
	@Override
	public int savequalitychecklist(QulityCheck_Pm6 wm) {
		// TODO Auto-generated method stub
		return qulitycheckpm6dao.savequalitychecklist(wm);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.QulityCheckPm6Service#updatequalitychecklist(com.st.qualitypm6.model.QulityCheck_Pm6)
	 */
	@Override
	public void updatequalitychecklist(QulityCheck_Pm6 wm) {
		// TODO Auto-generated method stub
		qulitycheckpm6dao.updatequalitychecklist(wm);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.QulityCheckPm6Service#qualitychecklistdelete(int)
	 */
	@Override
	public void qualitychecklistdelete(int id) {
		// TODO Auto-generated method stub
		qulitycheckpm6dao.qualitychecklistdelete(id);
	}
		
	

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.QulityCheckPm6Service#getDataOfQulityCheck_Pm6(java.util.Date, java.util.Date)
	 */
	@Override
	public List<QulityCheck_Pm6> getDataOfQulityCheck_Pm6(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return qulitycheckpm6dao.getDataOfQulityCheck_Pm6(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.QulityCheckPm6Service#getDataOfProductSpecificationSignOffSheetByDate(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ProductSpecificationSignOffSheet> getDataOfProductSpecificationSignOffSheetByDate(String sdate,
			String edate) {
		// TODO Auto-generated method stub
		return qulitycheckpm6dao.getDataOfQulityCheck_Pm6(sdate,edate);
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.service.QulityCheckPm6Service#getDataOfQulityCheck_Pm6(int)
	 */
	@Override
	public List<QulityCheck_Pm6> getDataOfQulityCheck_Pm6(int id) {
		// TODO Auto-generated method stub
		return qulitycheckpm6dao.getDataOfQulityCheck_Pm6(id);
	}

}
