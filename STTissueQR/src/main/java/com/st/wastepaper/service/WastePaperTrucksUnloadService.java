package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.WastePaperTruckUnload;

public interface WastePaperTrucksUnloadService {

	List<WastePaperTruckUnload> getUnloadTrucks(Date startdate, Date enddate);

}
