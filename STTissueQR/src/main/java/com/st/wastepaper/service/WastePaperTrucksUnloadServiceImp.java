package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.wastepaper.dao.WastePaperTrucksUnloadDao;
import com.st.wastepaper.model.WastePaperTruckUnload;

@Service
public class WastePaperTrucksUnloadServiceImp implements WastePaperTrucksUnloadService{

	@Autowired
	private WastePaperTrucksUnloadDao wastepapertrucksunloadDao ;
	
	@Transactional
	@Override
	public List<WastePaperTruckUnload> getUnloadTrucks(Date startdate,Date enddate) {
		// TODO Auto-generated method stub
		return wastepapertrucksunloadDao.getUnloadTrucks(startdate,enddate);
	}

}
