/**
 *Mar 24, 2017
 *SkuServiceImpl.java
 * TODO
 *com.st.frp.sku.service
 *SkuServiceImpl.java
 *Roshan Lal Tailor
 */
package com.st.frp.sku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.frp.sku.dao.SkuDao;
import com.st.frp.sku.model.SkuModel;
import com.st.frp.sku.model.SkuProductCodeModel;

/**
 * @author roshan
 *
 */
@Service
public class SkuServiceImpl implements SkuService {

	@Autowired
	private SkuDao skuDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.frp.sku.service.SkuService#save(java.lang.String)
	 */
	 
	@Override
	@Transactional
	public void save(String name, String address1, String address2, String city, String state, String zip) {
		// TODO Auto-generated method stub
		skuDao.save(name, address1, address2, city, state, zip);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.frp.sku.service.SkuService#getCustomerNameList()
	 */
	@Override
	@Transactional
	public List<SkuModel> getCustomerNameList() {
		// TODO Auto-generated method stub
		return skuDao.getCustomerNameList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.frp.sku.service.SkuService#update(java.lang.String, int)
	 */
	@Override
	@Transactional
	public void update(String name,String address1,String address2,String city,String state,String zip, int id) {
		// TODO Auto-generated method stub

		skuDao.update(name, address1, address2, city, state, zip,id);
	}
	
	/* (non-Javadoc)
	 * @see com.st.frp.sku.service.SkuService#deleteCust(int)
	 */
	@Override
	@Transactional
	public void deleteCust(int id) {
		// TODO Auto-generated method stub
		skuDao.deleteCust(id);
	}
	
	/* (non-Javadoc)
	 * @see com.st.frp.sku.service.SkuService#saveProductCode(java.lang.String)
	 */
	@Override
	@Transactional
	public void saveProductCode(String productCode) {
		// TODO Auto-generated method stub
		skuDao.saveProductCode(productCode);
	 
	}
	
	/* (non-Javadoc)
	 * @see com.st.frp.sku.service.SkuService#updateProductCode(java.lang.String, int)
	 */
	@Override
	@Transactional
	public void updateProductCode(String productCode, int id) {
		// TODO Auto-generated method stub
	
		skuDao.updateProductCode(productCode, id);
	}
	
	/* (non-Javadoc)
	 * @see com.st.frp.sku.service.SkuService#getProductCodeList()
	 */
	@Override
	public List<SkuProductCodeModel> getProductCodeList() {
		// TODO Auto-generated method stub
		return skuDao.getProductCodeList();
	}
	
	/* (non-Javadoc)
	 * @see com.st.frp.sku.service.SkuService#deleteProdCode(int)
	 */
	@Override
	@Transactional
	public void deleteProdCode(int id) {
		// TODO Auto-generated method stub
		skuDao.deleteProdCode(id);
	}
	
	
	
	
	

}
