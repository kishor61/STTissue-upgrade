package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import com.st.wastepaper.model.WastePaperBaleInventory;

public interface BarcodeConsumedBalesReportService {

	List<WastePaperBaleInventory> getCounsumedBales(Date startdate, Date enddate);

	List<WastePaperBaleInventory> getCounsumedBalesFromTempData(Date startdate,
			Date enddate);

	List<WastePaperBaleInventory> getselectconsumedbalesdataforTransfer(
			Date startdate, Date enddate);

	int saveDataInTempTable(WastePaperBaleInventory wpcd1);

	List<WastePaperBaleInventory> getCounsumedBalesForMillYieldReort(
			Date startdate, Date enddate);

	int saveYieldData(WastePaperBaleInventory yielddata);

	List<WastePaperBaleInventory> getMillYieldDataEntry(Date startdate,
			Date enddate);

	void updateYieldData(WastePaperBaleInventory yielddata);

}
