/**
 *Jan 10, 2015
 *OperatingProcedureController.java
 * TODO
 *com.st.operatingprocedure.controller
 *OperatingProcedureController.java
 *Roshan Lal Tailor
 */
package com.st.operatingprocedure.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.common.CommonUtil;
import com.st.convertingline.model.ConvertingLine;
import com.st.operatingprocedure.model.OperatingProcedure;
import com.st.operatingprocedure.model.Type;
import com.st.operatingprocedure.service.OperatingProcedureService;

/**
 * @author sbora
 *
 */
@Controller
@RequestMapping("/operatingprocedure")
public class OperatingProcedureController {

	@Value("${oerating.proc.folder}")
	private String location;
	
	@Autowired
	private OperatingProcedureService operatingProcedureService;
	
	@RequestMapping("/manage")
	public String manage(Model model) {
		
		List<String> types=operatingProcedureService.getTypes();
		List<String> subTypes=operatingProcedureService.getSubTypes();
		
		List<Type> uniqueTypes=new ArrayList<Type>();
		
		List<OperatingProcedure> procedures=operatingProcedureService.getOperatingProcedure();
		for (OperatingProcedure operatingProcedure : procedures) {
			Type type=new Type(operatingProcedure.getType());
			if(uniqueTypes.contains(type)){
				type=uniqueTypes.get(uniqueTypes.indexOf(type));
				if(operatingProcedure.getSubType()!=null){
					type.getSubType().add(operatingProcedure.getSubType());
				}
				
			}else{
				if(operatingProcedure.getSubType()!=null){
					type.getSubType().add(operatingProcedure.getSubType());
				}
				
				uniqueTypes.add(type);
			}
		}
		
		model.addAttribute("uniqueTypes", uniqueTypes);
		model.addAttribute("types", types);
		model.addAttribute("subTypes", subTypes);
		model.addAttribute("procedures", procedures);
		
		return "operatingprocedure/manageFiles";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveFile(@RequestParam("file")MultipartFile file,
			@RequestParam("area")String area,
			@RequestParam("type")String type,
			@RequestParam("subType")String subType,
			RedirectAttributes redirectAttributes,Model model) {
	
		if(StringUtils.isEmpty(area)){
			model.addAttribute("error", "Please Select Area.");
			return "operatingprocedure/manageFiles";
		}
		
		if(StringUtils.isEmpty(type)){
			model.addAttribute("error", "Please Select Category.");
			return "operatingprocedure/manageFiles";
		}
		
		if(StringUtils.isEmpty(subType)){
			model.addAttribute("error", "Please Select Sub Category.");
			return "operatingprocedure/manageFiles";
		}
		
		if(!file.isEmpty()){
			
			try {
				
				String folderLocal=System.getProperty("catalina.base")+"/UploadedOperatingProcedureDocuments";
				File uploadedFile=new File(folderLocal);
				if(!uploadedFile.exists()){
					uploadedFile.mkdirs();
				}
				
				String fileName=UUID.randomUUID()+"."+FilenameUtils.getExtension(file.getOriginalFilename());
				
				File folder=new File(location);
				File fileNew=new File(folder, fileName);
				FileOutputStream outputStream=new FileOutputStream(fileNew);
				IOUtils.copy(file.getInputStream(), outputStream);
				outputStream.close();
				
				File fileLocal=new File(uploadedFile, fileName);
				FileOutputStream outputStream2=new FileOutputStream(fileLocal);
				IOUtils.copy(file.getInputStream(), outputStream2);
				outputStream2.close();
				
				
				
				OperatingProcedure operatingProcedure=new OperatingProcedure();
				operatingProcedure.setEntryDate(new Date());
				operatingProcedure.setFile(fileName);
				operatingProcedure.setName(file.getOriginalFilename());
				operatingProcedure.setArea(area.toUpperCase());
				operatingProcedure.setType(type.toUpperCase());
				operatingProcedure.setSubType(subType.toUpperCase());
				
				operatingProcedureService.save(operatingProcedure);
				
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("type", type);
				model.addAttribute("subType", subType);
				
				model.addAttribute("error", "Fail to save file. Please try later.");
				return "operatingprocedure/manageFiles";
				
			}
			
			
			
			
			
		}else{
			model.addAttribute("area", area);
			model.addAttribute("type", type);
			model.addAttribute("subType", subType);
			
			redirectAttributes.addFlashAttribute("error", "Please select valid file.");
			return "redirect:/operatingprocedure/manage";
		}
		
		
		redirectAttributes.addFlashAttribute("message", "File saved successfully.");
		
		return "redirect:/operatingprocedure/managecategorynew";
		
		//model.addAttribute("message", "File saved successfully.");
		
		//return "/managecategorynew";
		 
	}
	
	
	@RequestMapping("/delete")
	public @ResponseBody boolean deleteFile(@RequestParam("id")int id) {
		
		try {
			operatingProcedureService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@RequestMapping("/managecategory")
	public String manageCategory(Model model) {
		
		List<String> types=operatingProcedureService.getTypes();
		model.addAttribute("types", types);
		
		return "operatingprocedure/manageCategory";
	}
	
	//New Code
	@RequestMapping("/managecategorynew")
	public String manageCategoryNew(Model model) {
		
		List<String> types=operatingProcedureService.getTypes();
		model.addAttribute("types", types);
		
		//Code Starts From Here
		List<OperatingProcedure> maincategory=operatingProcedureService.getMainCategory();
		model.addAttribute("maincategory", maincategory);
		
		List<OperatingProcedure> subcategory=operatingProcedureService.getSubCategory();
		model.addAttribute("subcategory", subcategory);
		
		List<OperatingProcedure> areas=operatingProcedureService.getArea();
		model.addAttribute("areas", areas);
		
				//Code Ends Here
		return "operatingprocedure/manageCategorynew";
	}
	//New Code Ends Here
	
	@RequestMapping("/updatecategory")
	public @ResponseBody boolean updateCategory(@RequestParam("newcat")String newcat,
			@RequestParam("oldcat")String oldcat,
			Model model) {
		try {
			if(StringUtils.isNotEmpty(newcat) && StringUtils.isNotEmpty(oldcat) && !newcat.equalsIgnoreCase(oldcat)){
				operatingProcedureService.updateCategory(newcat,oldcat);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

	}
	
	@RequestMapping("/managecsubategory")
	public String manageSubCategory(Model model) {
		
		List<Type> types=operatingProcedureService.getTypesAndSubTypes();
		model.addAttribute("types", types);
		
		return "operatingprocedure/manageSubCategory";
	}
	
	@RequestMapping("/updatesubcategory")
	public @ResponseBody boolean updateCategory(@RequestParam("newcat")String newcat,
			@RequestParam("oldcat")String oldcat,@RequestParam("type")String type,
			Model model) {
		try {
			if(StringUtils.isNotEmpty(newcat) && StringUtils.isNotEmpty(oldcat) && StringUtils.isNotEmpty(type) && !newcat.equalsIgnoreCase(oldcat)){
				operatingProcedureService.updateSubCategory(newcat,oldcat,type);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

	}
	
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String serach(@RequestParam("file")String file,@RequestParam("area")String area,@RequestParam("category")String category,
			@RequestParam("subCategory")String subCategory,Model model) {
		
		List<String> types=operatingProcedureService.getTypes();
		List<String> subTypes=operatingProcedureService.getSubTypes();
		
		List<String> areasType=operatingProcedureService.getAreas();
		
		
		List<Type> uniqueTypes=new ArrayList<Type>();
		
		List<OperatingProcedure> procedures=operatingProcedureService.getOperatingProcedure(file,area,category,subCategory);
		for (OperatingProcedure operatingProcedure : procedures) {
			Type type=new Type(operatingProcedure.getType());
			if(uniqueTypes.contains(type)){
				type=uniqueTypes.get(uniqueTypes.indexOf(type));
				if(operatingProcedure.getSubType()!=null){
					type.getSubType().add(operatingProcedure.getSubType());
				}
				
			}else{
				if(operatingProcedure.getSubType()!=null){
					type.getSubType().add(operatingProcedure.getSubType());
				}
				
				uniqueTypes.add(type);
			}
		}
		
		model.addAttribute("uniqueTypes", uniqueTypes);
		
		
		
		model.addAttribute("file", file);
		
		model.addAttribute("category", category);
		model.addAttribute("subCategory", subCategory);
		model.addAttribute("areas", area);
		
		model.addAttribute("types", types);
		model.addAttribute("subTypes", subTypes);
		model.addAttribute("areasType", areasType);
		
		model.addAttribute("procedures", procedures);
		
		return "operatingprocedure/manageFiles";
	}
	
	
	@RequestMapping("/category/types")
	public @ResponseBody Map<String, List<String>> getTypes(Model model) {
		
		
		Map<String, List<String>> list=new HashMap<String, List<String>>();
		
		List<String> types=operatingProcedureService.getTypes();
		types.removeAll(Collections.singleton(null));
		list.put("types", types);
		
		List<String> subTypes=operatingProcedureService.getSubTypes();
		subTypes.removeAll(Collections.singleton(null));
		list.put("subTypes", subTypes);
		
		List<String> area=operatingProcedureService.getAreas();
		area.removeAll(Collections.singleton(null));
		list.put("allarea", area);
		
		return list;
	}
	
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")int id,Model model) {
		
		OperatingProcedure procedure=operatingProcedureService.getOperatingProcedure(id);
		model.addAttribute("procedure", procedure);
		
		List<OperatingProcedure> areas=operatingProcedureService.getArea();
		model.addAttribute("areas", areas);
		
		return "operatingprocedure/edit";
	}
	
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String update(@ModelAttribute("procedure")OperatingProcedure procedure,RedirectAttributes redirectAttributes,Model model) {
		
		model.addAttribute("procedure", procedure);
		
		if(StringUtils.isEmpty(procedure.getArea())){
			model.addAttribute("error", "Please Select Area name!");
			return "operatingprocedure/edit";
		}
		
		if(StringUtils.isEmpty(procedure.getName())){
			model.addAttribute("error", "Please enter file name!");
			return "operatingprocedure/edit";
		}
		
		if(StringUtils.isEmpty(procedure.getType())){
			model.addAttribute("error", "Please enter category name!");
			return "operatingprocedure/edit";
		}
		
		if(StringUtils.isEmpty(procedure.getSubType())){
			model.addAttribute("error", "Please enter sub category name!");
			return "operatingprocedure/edit";
		}
		
		if(procedure.getId()>0){
			operatingProcedureService.update(procedure);
		}
		
		redirectAttributes.addFlashAttribute("message", "Data updated successfully.");
		
		return "redirect:/operatingprocedure/edit/"+procedure.getId();
	}
	
	@RequestMapping(value="/showarea",method=RequestMethod.GET)
	public String customerWiseView(Model model) {
		
		List<OperatingProcedure> areas=operatingProcedureService.getArea();
		model.addAttribute("areas", areas);
		
		return "operatingprocedure/showArea";
	}
	
	@RequestMapping(value="/showMainCatogoeryByAreaWise",method=RequestMethod.GET)
	public String showMainCatogoeryByAreaWise(@RequestParam("aera")String area,Model model) {
		
		List<OperatingProcedure> maincategory=operatingProcedureService.getMainCatogoeryByAreaWise(area);
		
		model.addAttribute("area", area);
		model.addAttribute("maincategory", maincategory);
		
		return "operatingprocedure/showMainCatogoeryByAreaWise";
	}
	
	@RequestMapping(value="/showSubCatogoeryByAreaAndMainCatWise",method=RequestMethod.GET)
	public String showSubCatogoeryByAreaAndMainCatWise(@RequestParam("maincat")String maincat,@RequestParam("aera")String area,Model model) {
		
		
		List<OperatingProcedure> subcategory=operatingProcedureService.getSubCatogoeryByAreaAndMainCatWise(area,maincat);
		model.addAttribute("subcategory", subcategory);
		
		
		model.addAttribute("maincat", maincat);
		model.addAttribute("area", area);
		model.addAttribute("subcategory", subcategory);
		
		return "operatingprocedure/showSubCatogoeryByAreaAndMainCatWise";
	}
	
	@RequestMapping("/managenew")
	public String managenew(Model model) {
		
		List<String> types=operatingProcedureService.getTypes();
		List<String> subTypes=operatingProcedureService.getSubTypes();
		
		List<Type> uniqueTypes=new ArrayList<Type>();
		
		List<OperatingProcedure> procedures=operatingProcedureService.getOperatingProcedure();
		for (OperatingProcedure operatingProcedure : procedures) {
			Type type=new Type(operatingProcedure.getType());
			if(uniqueTypes.contains(type)){
				type=uniqueTypes.get(uniqueTypes.indexOf(type));
				if(operatingProcedure.getSubType()!=null){
					type.getSubType().add(operatingProcedure.getSubType());
				}
				
			}else{
				if(operatingProcedure.getSubType()!=null){
					type.getSubType().add(operatingProcedure.getSubType());
				}
				
				uniqueTypes.add(type);
			}
		}
		
		//Code Starts From Here
		List<OperatingProcedure> areas=operatingProcedureService.getArea();
		model.addAttribute("areas", areas);
		
		
		List<OperatingProcedure> maincategory=operatingProcedureService.getMainCategory();
		model.addAttribute("maincategory", maincategory);
		
		List<OperatingProcedure> subcategory=operatingProcedureService.getSubCategory();
		model.addAttribute("subcategory", subcategory);
		//Code Ends Here
		
		
		model.addAttribute("uniqueTypes", uniqueTypes);
		model.addAttribute("types", types);
		model.addAttribute("subTypes", subTypes);
		model.addAttribute("procedures", procedures);
		
		return "operatingprocedure/manageFilesnew";
	}
	//Code Starts From Here Done By Roshan Tailor To Save The MAin Category Details
	@RequestMapping(value="/savemaincatogery",method=RequestMethod.POST)
	public @ResponseBody int saveVendorBusinessDetails(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		int key=0;
		
		try{
			
			OperatingProcedure vendorSeller= new OperatingProcedure();
			String maincategoname=checkNull(request.getParameter("maincategoname"));
			
			vendorSeller.setMaincategoname(maincategoname);
			
			/*if(sellerData.size()>0){
				//update
				vendorsellerservice.updateVendorBusinessDetailsData(vendorSeller);
			}else{
				//save
			*/	key=operatingProcedureService.saveMainCatgoryNameData(vendorSeller);
			/*}
			*/
		}catch(Exception rlt){
			System.out.println("Roshan You Have An Error In VendorSellerController.java at saveVendorBusinessDetails method.");
			rlt.printStackTrace();
		}
		return key;
		
	}
	
	public static String checkNull(String string) {
		return string == null ? "" : string.trim();
	}
	public static double checkDouble(String string) {
		return NumberUtils.toDouble(string, 0);
	}
	
	//Delete Main Category
	@RequestMapping(value="/deletemaincatogery",method=RequestMethod.POST)
	public @ResponseBody int deletemaincatogery(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		int key=0;
		
		try{
			
			OperatingProcedure vendorSeller= new OperatingProcedure();
			int id=Integer.parseInt(request.getParameter("id"));
			
			vendorSeller.setId(id);
			operatingProcedureService.deleteMainCatgoryNameData(vendorSeller);
			
		}catch(Exception rlt){
			System.out.println("Roshan You Have An Error In VendorSellerController.java at saveVendorBusinessDetails method.");
			rlt.printStackTrace();
		}
		return key;
		
	}
	@RequestMapping(value="/updatemaincatogery",method=RequestMethod.POST)
	public @ResponseBody int updatemaincatogery(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		int key=0;
		
		try{
			
			OperatingProcedure vendorSeller= new OperatingProcedure();
			String value=checkNull(request.getParameter("value"));
			int id=Integer.parseInt(request.getParameter("id"));
			vendorSeller.setMaincategoname(value);
			vendorSeller.setId(id);
			
			/*if(sellerData.size()>0){
				//update
				vendorsellerservice.updateVendorBusinessDetailsData(vendorSeller);
			}else{
				//save
			*/	operatingProcedureService.updateMainCatgoryNameData(vendorSeller);
			/*}
			*/
		}catch(Exception rlt){
			System.out.println("Roshan You Have An Error In VendorSellerController.java at saveVendorBusinessDetails method.");
			rlt.printStackTrace();
		}
		return key;
		
	}
	@RequestMapping(value="/saveSubCatBusinessDetails",method=RequestMethod.POST)
	public @ResponseBody int saveSubCatBusinessDetails(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		int key=0;
		
		try{
			
			OperatingProcedure vendorSeller= new OperatingProcedure();
			String maincategoryname=checkNull(request.getParameter("maincategoryname"));
			String entersubcatname=checkNull(request.getParameter("entersubcatname"));
			
			vendorSeller.setMaincategoname(maincategoryname);
			vendorSeller.setEntersubcatname(entersubcatname);
			
			/*if(sellerData.size()>0){
				//update
				vendorsellerservice.updateVendorBusinessDetailsData(vendorSeller);
			}else{
				//save
			*/	key=operatingProcedureService.saveSubCatgoryNameData(vendorSeller);
			/*}
			*/
		}catch(Exception rlt){
			System.out.println("Roshan You Have An Error In VendorSellerController.java at saveVendorBusinessDetails method.");
			rlt.printStackTrace();
		}
		return key;
		
	}
	//Now Want To Delete Sub Category
	@RequestMapping(value="/deleteSubBusinessDetails",method=RequestMethod.POST)
	public @ResponseBody int deleteSubBusinessDetails(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		int key=0;
		
		try{
			
			OperatingProcedure vendorSeller= new OperatingProcedure();
			int id=Integer.parseInt(request.getParameter("id"));
			
			vendorSeller.setId(id);
			operatingProcedureService.deleteSubCatgoryNameData(vendorSeller);
			
		}catch(Exception rlt){
			System.out.println("Roshan You Have An Error In VendorSellerController.java at saveVendorBusinessDetails method.");
			rlt.printStackTrace();
		}
		return key;
		
	}
	
	//Code for Add New Area
	@RequestMapping(value="/areaname",method=RequestMethod.POST)
	public @ResponseBody int addArea(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		int key=0;
		
		try{
			
			OperatingProcedure vendorSeller= new OperatingProcedure();
			String areaname=checkNull(request.getParameter("areaname"));
			
			vendorSeller.setArea(areaname);
		
			key=operatingProcedureService.saveAreaName(vendorSeller);
		
		}catch(Exception rlt){
			System.out.println("Roshan You Have An Error In VendorSellerController.java at addArea method.");
			rlt.printStackTrace();
		}
		return key;
		
	}
	//Code To Update The Area Name
	@RequestMapping(value="/updateareaname",method=RequestMethod.POST)
	public @ResponseBody int updateAreaName(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		int key=0;
		
		try{
			
			OperatingProcedure vendorSeller= new OperatingProcedure();
			String value=checkNull(request.getParameter("value"));
			int id=Integer.parseInt(request.getParameter("id"));
			vendorSeller.setArea(value);
			vendorSeller.setId(id);
			
			operatingProcedureService.updateAreaName(vendorSeller);
			
		}catch(Exception rlt){
			System.out.println("Roshan You Have An Error In VendorSellerController.java at updateAreaName method.");
			rlt.printStackTrace();
		}
		return key;
		
	}
	//Code To Delete The Area
	@RequestMapping(value="/deletareaname",method=RequestMethod.POST)
	public @ResponseBody int deletareaname(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		int key=0;
		
		try{
			
			OperatingProcedure vendorSeller= new OperatingProcedure();
			int id=Integer.parseInt(request.getParameter("id"));
			
			vendorSeller.setId(id);
			operatingProcedureService.deletAreaName(vendorSeller);
			
		}catch(Exception rlt){
			System.out.println("Roshan You Have An Error In VendorSellerController.java at saveVendorBusinessDetails method.");
			rlt.printStackTrace();
		}
		return key;
		
	}
	@RequestMapping("/managearea")
	public String manageArea(Model model) {
		
		List<String> area=operatingProcedureService.getAreas();
		model.addAttribute("areas", area);
		
		return "operatingprocedure/manageArea";
	}
	@RequestMapping("/updateAreaNameEdit")
	public @ResponseBody boolean updateAreaNameEdit(@RequestParam("newcat")String newcat,
			@RequestParam("oldcat")String oldcat,
			Model model) {
		try {
			if(StringUtils.isNotEmpty(newcat) && StringUtils.isNotEmpty(oldcat) && !newcat.equalsIgnoreCase(oldcat)){
				operatingProcedureService.updateAreaNameEdit(newcat,oldcat);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

	}
}
