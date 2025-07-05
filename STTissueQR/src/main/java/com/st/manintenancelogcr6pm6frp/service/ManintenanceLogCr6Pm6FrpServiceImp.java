/**
 *Oct 12, 2017
 *ManintenanceLogCr6Pm6FrpServiceImp.java
 * TODO
 *com.st.manintenancelogcr6pm6frp.service
 *ManintenanceLogCr6Pm6FrpServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.manintenancelogcr6pm6frp.service;

import java.lang.annotation.Target;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.manintenancelogcr6pm6frp.dao.ManintenanceLogCr6Pm6FrpDao;
import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp;
import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6FrpArea;

/**
 * @author roshan
 *
 */
@Service
public class ManintenanceLogCr6Pm6FrpServiceImp implements ManintenanceLogCr6Pm6FrpService{

	@Autowired
	private ManintenanceLogCr6Pm6FrpDao manintenanceLogCr6Pm6FrpDao;
	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService#save(com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6FrpArea)
	 */
	@Override
	@Transactional
	public int save(ManintenanceLogCr6Pm6FrpArea ar) {
		// TODO Auto-generated method stub
		return manintenanceLogCr6Pm6FrpDao.save(ar);
	}
	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService#getArea()
	 */
	@Override
	@Transactional
	public List<ManintenanceLogCr6Pm6Frp> getArea() {
		// TODO Auto-generated method stub
		return manintenanceLogCr6Pm6FrpDao.getGrades();
	}
	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService#save(com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp)
	 */
	@Override
	@Transactional
	public int save(ManintenanceLogCr6Pm6Frp data) {
		// TODO Auto-generated method stub
		return manintenanceLogCr6Pm6FrpDao.save(data);
	}
	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService#update(com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp)
	 */
	@Override
	@Transactional
	public void update(ManintenanceLogCr6Pm6Frp data) {
		// TODO Auto-generated method stub
		manintenanceLogCr6Pm6FrpDao.update(data);
	}
	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService#getCurrentDateData(java.util.Date)
	 */
	@Override
	@Transactional
	public List<ManintenanceLogCr6Pm6Frp> getCurrentDateData(Date date,String shift) {
		// TODO Auto-generated method stub
		return manintenanceLogCr6Pm6FrpDao.getCurrentDateData(date,shift);
	}
	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService#delete(int)
	 */
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		manintenanceLogCr6Pm6FrpDao.delete(id);
	}
	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService#getArea_ForJSON()
	 */
	@Override
	@Transactional
	public List<Map<String, Object>> getArea_ForJSON() {
		// TODO Auto-generated method stub
		return manintenanceLogCr6Pm6FrpDao.getArea_ForJSON();
	}
	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService#getDateBetweenData(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public List<ManintenanceLogCr6Pm6Frp> getDateBetweenData(String sdate,String edate,String userType) {
		// TODO Auto-generated method stub
		return manintenanceLogCr6Pm6FrpDao.getDateBetweenData(sdate,edate,userType);
	}
	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService#getDateBetweenData_Email(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public List<ManintenanceLogCr6Pm6Frp> getDateBetweenData_Email(String sdate, String edate,String operator) {
		// TODO Auto-generated method stub
		return manintenanceLogCr6Pm6FrpDao.getDateBetweenData_Email(sdate,edate,operator);
	}
	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.service.ManintenanceLogCr6Pm6FrpService#getCurrentDateDataShiftWise(java.util.Date, java.lang.String)
	 */
	@Override
	@Transactional
	public List<ManintenanceLogCr6Pm6Frp> getCurrentDateDataShiftWise(Date sdate, String shift) {
		// TODO Auto-generated method stub
		return manintenanceLogCr6Pm6FrpDao.getCurrentDateDataShiftWise(sdate,shift);
	}

}
