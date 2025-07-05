/**
 *Mar 24, 2017
 *SKCController.java
 * TODO
 *com.st.frp.skc.controller
 *SKCController.java
 *Roshan Lal Tailor
 */
package com.st.frp.sku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.frp.sku.model.SkuModel;
import com.st.frp.sku.model.SkuProductCodeModel;
import com.st.frp.sku.service.SkuService;

/**
 * @author snavhaal
 *
 */
@Controller
@RequestMapping("/skuspecification")
public class SKUController {
	
	@Autowired
	private SkuService skuService;
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String skuview(Model model) {
	 List<SkuModel> details = skuService.getCustomerNameList();
	 List<SkuProductCodeModel> productCodeList = skuService.getProductCodeList();
	 
	 model.addAttribute("data",details);
	 model.addAttribute("productCode",productCodeList);
	 return "skuspecification/skuView";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@RequestParam("customername") String name,@RequestParam("customeraddress1") String custaddress1,@RequestParam("customeraddress2") String custaddress2,@RequestParam("customercity") String customerCity,@RequestParam("customerstate") String customerState,@RequestParam("customerzip") String customerZip,RedirectAttributes redirectAttributes) {
		 	
		skuService.save(name,custaddress1,custaddress2,customerCity,customerState,customerZip);
		  
		 
		return "redirect:/skuspecification/view";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateData(@RequestParam("custname") String name,@RequestParam("custaddress1") String custaddress1,@RequestParam("custaddress2") String custaddress2,@RequestParam("custcity") String customerCity,@RequestParam("custstate") String customerState,@RequestParam("custzip") String customerZip,@RequestParam("custid") int id,RedirectAttributes redirectAttributes) {
		 	
		skuService.update(name,custaddress1,custaddress2,customerCity,customerState,customerZip,id); 
		  
		return "redirect:/skuspecification/view";
	}
	@RequestMapping(value="/deleteCust/{id}",method=RequestMethod.GET)
	public String deleteData(@PathVariable int id,RedirectAttributes redirectAttributes) {
		 	
		skuService.deleteCust(id); 
		  
		return "redirect:/skuspecification/view";
	}
	
	@RequestMapping(value="/saveproductcode",method=RequestMethod.POST)
	public String saveProductCode(@RequestParam("productcode") String productCode,RedirectAttributes redirectAttributes) {
		 	
		skuService.saveProductCode(productCode);
		  
		 
		return "redirect:/skuspecification/view";
	}
	
	@RequestMapping(value="/updateCode",method=RequestMethod.POST)
	public String updateProductCode(@RequestParam("prodcode") String productCode,@RequestParam("prodid") int id,RedirectAttributes redirectAttributes) {
		 	
		skuService.updateProductCode(productCode, id);
		   
		return "redirect:/skuspecification/view";
	}
	@RequestMapping(value="/deleteProd/{id}",method=RequestMethod.GET)
	public String deleteProductCodeData(@PathVariable int id,RedirectAttributes redirectAttributes) {
		 	
		skuService.deleteProdCode(id); 
		  
		return "redirect:/skuspecification/view";
	}
	
	
	
	

}
