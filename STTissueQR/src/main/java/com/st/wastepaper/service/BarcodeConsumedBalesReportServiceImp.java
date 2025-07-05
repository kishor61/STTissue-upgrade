package com.st.wastepaper.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.wastepaper.dao.BarcodeConsumedBalesReportDao;
import com.st.wastepaper.model.WastePaperBaleInventory;

@Service
public class BarcodeConsumedBalesReportServiceImp implements BarcodeConsumedBalesReportService {

	@Autowired
	private BarcodeConsumedBalesReportDao barcodeconsumedbalesreportdao;
	
	@Override
	@Transactional
	public List<WastePaperBaleInventory> getCounsumedBales(Date startdate,Date enddate) {
		// TODO Auto-generated method stub
		 return barcodeconsumedbalesreportdao.getCounsumedBales(startdate,enddate);	
	}

	@Override
	@Transactional
	public List<WastePaperBaleInventory> getCounsumedBalesFromTempData(
			Date startdate, Date enddate) {
		// TODO Auto-generated method stub
		 return barcodeconsumedbalesreportdao.getCounsumedBalesFromTempData(startdate,enddate);	
	}

	@Override
	@Transactional
	public List<WastePaperBaleInventory> getselectconsumedbalesdataforTransfer(
			Date startdate, Date enddate) {
		// TODO Auto-generated method stub
		 return barcodeconsumedbalesreportdao.getselectconsumedbalesdataforTransfer(startdate,enddate);	
	}

	@Override
	@Transactional
	public int saveDataInTempTable(WastePaperBaleInventory wpcd1) {
		// TODO Auto-generated method stub
		return barcodeconsumedbalesreportdao.saveDataInTempTable(wpcd1);
	}
	@Transactional
	@Override
	public List<WastePaperBaleInventory> getCounsumedBalesForMillYieldReort(Date startdate, Date enddate) {
		 return barcodeconsumedbalesreportdao.getCounsumedBalesForMillYieldReort(startdate,enddate);
	}
	@Transactional
	@Override
	public int saveYieldData(WastePaperBaleInventory yielddata) {
		// TODO Auto-generated method stub
		return barcodeconsumedbalesreportdao.saveYieldData(yielddata);
	}
	@Transactional
	@Override
	public List<WastePaperBaleInventory> getMillYieldDataEntry(Date startdate,
			Date enddate) {
		// TODO Auto-generated method stub
		 return barcodeconsumedbalesreportdao.getMillYieldDataEntry(startdate,enddate);
	}
	@Transactional
	@Override
	public void updateYieldData(WastePaperBaleInventory yielddata) {
		// TODO Auto-generated method stub
		barcodeconsumedbalesreportdao.updateYieldData(yielddata);
	}

}
