/**
 *Mar 24, 2017
 *SkuDao.java
 * TODO
 *com.st.frp.sku.dao
 *SkuDao.java
 *Roshan Lal Tailor
 */
package com.st.frp.sku.dao;

import java.util.List;

import com.st.frp.sku.model.SkuModel;
import com.st.frp.sku.model.SkuProductCodeModel;

/**
 * @author roshan
 *
 */
public interface SkuDao {
	
	void save(String name,String address1,String address2,String city,String state,String zip);
	
	void update(String name,String address1,String address2,String city,String state,String zip,int id);
	
	void deleteCust(int id);
	
	void saveProductCode(String productCode);
	
	void updateProductCode(String productCode,int id);
	
	List<SkuModel> getCustomerNameList();
	
	List<SkuProductCodeModel> getProductCodeList();
	
	void deleteProdCode(int id);

}
