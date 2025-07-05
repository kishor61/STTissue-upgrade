/**
 *Oct 22, 2019
 *R2OperatorPM5ServiceImp.java
 * TODO
 *com.st.obccPM5.service
 *R2OperatorPM5ServiceImp.java
 *Roshan Lal Tailor
 */
package com.st.obccPM5.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.obccPM5.dao.R2OperatorPM5Dao;
import com.st.obccPM5.model.R2OperatorPM5;

/**
 * @author roshan
 *
 */
@Service
public class R2OperatorPM5ServiceImp implements R2OperatorPM5Service {
	@Autowired
	private R2OperatorPM5Dao r2OperatorPM5Dao;
	
		@Override
		public void saveorUpdate(R2OperatorPM5 data) {
			
			r2OperatorPM5Dao.saveorUpdate(data);
		}
			
		@Override
		public List<R2OperatorPM5> getOperatorDataList(String position,String shift,
				String startDate, String endDate) {
			
			return r2OperatorPM5Dao. getOperatorDataList(position,shift, startDate,  endDate );
		}
		
		@Override
		public List<R2OperatorPM5> getOperatorDataList(String position,
				String sdate, String edate) {
			// TODO Auto-generated method stub
			return r2OperatorPM5Dao. getOperatorDataList(position,sdate,  edate );
		}
		
		@Override
		public long getDataCountDatePercentage(String position, String sdate,String edate,String shift) throws ParseException {
			
			return r2OperatorPM5Dao.getDataCountDatePercentage(position,  sdate, edate,shift);
		}

		/* (non-Javadoc)
		 * @see com.st.obccPM5.service.R2OperatorPM5Service#getOperatorData(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
		 */
		@Override
		public R2OperatorPM5 getOperatorData(String position, String shift, String date, String crew) throws Exception {
			
			return r2OperatorPM5Dao.getOperatorData(position,shift,date,crew);
		}
}
