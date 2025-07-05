package com.st.wastepaper.dao;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.WastePaperTruckUnload;

public interface WastePaperTrucksUnloadDao {

	List<WastePaperTruckUnload> getUnloadTrucks(Date startdate, Date enddate);

}
