package com.st.wastepaper.dao;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.BarcodeComman;
import com.st.wastepaper.model.WastePaperBaleInventory;

public interface BarcodeUnloadBalesReportDao {

	List<WastePaperBaleInventory> getUnloadBales(Date startdate, Date enddate);

	List<BarcodeComman> getOpenMonth(int month, int year);

	List<BarcodeComman> getClosedMonth(int month, int year);

	List<BarcodeComman> getOpenMonthAvailable(int month, int year);

	int save(BarcodeComman barcodeComman);

	void update(BarcodeComman barcodeComman);

	List<WastePaperBaleInventory> getFRPLocationData();

	List<WastePaperBaleInventory> getYardData();

}
