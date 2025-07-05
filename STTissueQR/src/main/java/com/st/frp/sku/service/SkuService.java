/**
 *Mar 24, 2017
 *SkuService.java
 * TODO
 *com.st.frp.sku.service
 *SkuService.java
 *Roshan Lal Tailor
 */
package com.st.frp.sku.service;

import java.util.List;

import com.st.frp.sku.model.SkuModel;
import com.st.frp.sku.model.SkuProductCodeModel;


/**
 * @author roshan
 *
 */
public interface SkuService {
	
	
	void save(String name,String address1,String address2,String city,String state,String zip);
	 
	void update(String name,String address1,String address2,String city,String state,String zip,int id);
	
	void deleteCust(int id);
	
	
	void saveProductCode(String productCode);
	
	void updateProductCode(String productCode,int id);
	
	List<SkuModel> getCustomerNameList();
	
	List<SkuProductCodeModel> getProductCodeList();
	
	void deleteProdCode(int id);
	

}
