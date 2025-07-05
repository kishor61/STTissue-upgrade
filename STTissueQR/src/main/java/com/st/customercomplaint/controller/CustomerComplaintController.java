/**
 *Oct 27, 2015
 *CustomerComplaintController.java
 * TODO
 *com.st.customercomplaint
 *CustomerComplaintController.java
 *Sunil Singh Bora
 */
package com.st.customercomplaint.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.st.centerline.service.CenterlineService;
import com.st.common.CommonUtil;
import com.st.common.exception.ProductionException;
import com.st.customercomplaint.model.CustomerComplaint;
import com.st.customercomplaint.report.CustomerComplaintReportHandller;
import com.st.customercomplaint.service.CoustomerComplaintService;
import com.st.qualitypm6.service.CustomerService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author roshan
 *
 */
@Controller
@RequestMapping("/customercomplaintreport")
public class CustomerComplaintController {

	private static final String EDIT_PAGE = "editpage";
	private static final String VIEW_PAGE = "viewpage";

	@Value("${customercomplaintreport.file.folder}")
	private String customercomplaintreportfilefolder;

	@Autowired
	private CoustomerComplaintService coustomercomplaintservice;

	@Autowired
	private CenterlineService centerlineService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ServletContext context;

	@Autowired
	private CustomerComplaintReportHandller customercomplaintreporthandller;

	@Autowired
	private com.st.customercomplaint.mailer.CustomerComplaintReportMailer CoustomerComplaintReportMailer;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat timeFormet = new SimpleDateFormat("HH:mm");
	private SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpServletResponse response, Model model) {

		Date sdate = CommonUtil.checkDate(dateFormat.format(new Date()), dateFormat);
		Date edate = sdate;
		List<CustomerComplaint> datas = coustomercomplaintservice.getCustomerComplaint(sdate, edate);

		model.addAttribute("customers", customerService.getCustomers());
		model.addAttribute("cgrades", centerlineService.getCenterlineGradeIds());
		model.addAttribute("date", dateFormat.format(new Date()));
		model.addAttribute("proddateShow", dateFormat.format(new Date()));
		model.addAttribute("targetdateShow", dateFormat.format(new Date()));
		model.addAttribute("customerdatas", datas);
		model.addAttribute(EDIT_PAGE, false);
		model.addAttribute(VIEW_PAGE, true);
		return "customerComplaint";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
			HttpServletRequest request, HttpServletResponse response, Model model,
			RedirectAttributes redirectAttributes) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		CustomerComplaint complaint = new CustomerComplaint();
		try {
			int id = CommonUtil.checkInt(request.getParameter("id"));
			Date date = CommonUtil.checkDate(request.getParameter("Date"), dateFormat);
			String Description = CommonUtil.checkNull(request.getParameter("Description"));
			String Grade = CommonUtil.checkNull(request.getParameter("Grade"));
			String Customer = CommonUtil.checkNull(request.getParameter("Customer"));
			String Type = CommonUtil.checkNull(request.getParameter("Type"));
			Date ProdDate = CommonUtil.checkDate(request.getParameter("Proddate"), dateFormat);
			String Remarks = CommonUtil.checkNull(request.getParameter("Remarks"));
			String Resp = CommonUtil.checkNull(request.getParameter("Resp"));
			Date Targetdate = CommonUtil.checkDate(request.getParameter("Targetdate"), dateFormat);
			String Status = CommonUtil.checkNull(request.getParameter("Status"));

			String complaintissue = CommonUtil.checkNull(request.getParameter("complaintissue"));
			String correctiveaction = CommonUtil.checkNull(request.getParameter("correctiveaction"));

			if (!file1.isEmpty()) {

				String fileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(file1.getOriginalFilename());

				File backupFile = new File(customercomplaintreportfilefolder);
				if (!backupFile.exists()) {
					backupFile.mkdirs();
				}

				String folder = System.getProperty("catalina.base") + "/Customer_Complaint_Report_Documents";
				File uploadedFile = new File(folder);
				if (!uploadedFile.exists()) {
					uploadedFile.mkdirs();
				}

				try {
					File fileLocal = new File(uploadedFile, fileName);
					FileOutputStream inputStream1 = new FileOutputStream(fileLocal);
					IOUtils.copy(file1.getInputStream(), inputStream1);
					inputStream1.close();

					File fileRemote = new File(backupFile, fileName);
					FileOutputStream inputStream2 = new FileOutputStream(fileRemote);
					IOUtils.copy(file1.getInputStream(), inputStream2);
					inputStream2.close();

					complaint.setAttachment(fileName);

					System.out.println("fileName::" + fileName);

				} catch (IOException e) {
					e.printStackTrace();
					model.addAttribute("error", "Fail to upload file. Please try again. Error:-" + e.getMessage());
					return "redirect:/customercomplaintreport/view";
				}

			}

			if (!file2.isEmpty()) {

				String fileName2 = UUID.randomUUID() + "." + FilenameUtils.getExtension(file2.getOriginalFilename());

				File backupFile = new File(customercomplaintreportfilefolder);
				if (!backupFile.exists()) {
					backupFile.mkdirs();
				}

				String folder = System.getProperty("catalina.base") + "/Customer_Complaint_Report_Documents";
				File uploadedFile = new File(folder);
				if (!uploadedFile.exists()) {
					uploadedFile.mkdirs();
				}

				try {
					File fileLocal = new File(uploadedFile, fileName2);
					FileOutputStream inputStream1 = new FileOutputStream(fileLocal);
					IOUtils.copy(file2.getInputStream(), inputStream1);
					inputStream1.close();

					File fileRemote = new File(backupFile, fileName2);
					FileOutputStream inputStream2 = new FileOutputStream(fileRemote);
					IOUtils.copy(file2.getInputStream(), inputStream2);
					inputStream2.close();

					complaint.setKaizen(fileName2);

					System.out.println("fileName::" + fileName2);

				} catch (IOException e) {
					e.printStackTrace();
					model.addAttribute("error", "Fail to upload file. Please try again. Error:-" + e.getMessage());
					return "redirect:/customercomplaintreport/view";
				}

			}
			complaint.setId(id);
			complaint.setDate(date);
			complaint.setDescription(Description);
			complaint.setGrade(Grade);
			complaint.setCustomer(Customer);
			complaint.setType(Type);
			complaint.setProddate(ProdDate);
			complaint.setRemarks(Remarks);
			complaint.setResp(Resp);
			complaint.setTargetdate(Targetdate);
			complaint.setStatus(Status);

			complaint.setComplaintissue(complaintissue);
			complaint.setCorrectiveaction(correctiveaction);

			try {
				if (complaint.getId() == 0) {
					// Insert
					int key = coustomercomplaintservice.save(complaint);
					map.put("status", true);
					map.put("id", key);
					map.put("GradeSelected", Grade);
					map.put("message", "Data saved successfully.");

				} else {
					// Update
					coustomercomplaintservice.update(complaint);
					map.put("status", true);
					map.put("id", complaint.getId());
					map.put("GradeSelected", Grade);
					map.put("message", "Data updated successfully.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error in saving data", e);

			}
		} catch (Exception e) {
			System.out.println("Roshan Says, You Have An Error In FrpRfTestingController.java");
			map.put("status", false);
			map.put("error", e.getMessage());
			e.printStackTrace();
		}
		// response.setContentType("application/json");
		// response.getWriter().write(new Gson().toJson(map));
		model.addAttribute(EDIT_PAGE, false);
		model.addAttribute(VIEW_PAGE, true);
		model.addAttribute("customers", customerService.getCustomers());
		model.addAttribute("cgrades", centerlineService.getCenterlineGradeIds());
		model.addAttribute("proddateShow", dateFormat.format(new Date()));
		model.addAttribute("targetdateShow", dateFormat.format(new Date()));
		model.addAttribute("date", dateFormat.format(new Date()));
		if (complaint.getId() == 0) {
			// model.addAttribute("message", "Data Saved Successfully.");
			redirectAttributes.addFlashAttribute("message", "Data saved successfully.");
			return "redirect:/customercomplaintreport/view";
		} else {
			redirectAttributes.addFlashAttribute("message", "Data Updated Successfully.");
			return "redirect:/customercomplaintreport/reportview/edit/" + complaint.getId();
		}

		// return "customerComplaint";
		// return "redirect:/customerComplaint/view";

	}

	@RequestMapping(value = "/reportview", method = RequestMethod.GET)
	public String viewReport(HttpServletRequest request, HttpServletResponse response, Model model) {

		model.addAttribute("sdate", dateFormat.format(new Date()));
		model.addAttribute("edate", dateFormat.format(new Date()));
		model.addAttribute("viewpage", false);
		return "customerComplaintReport";
	}

	@RequestMapping(value = "/reportview/load", method = RequestMethod.GET)
	public String load(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Date sdate = CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate = CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		List<CustomerComplaint> reportData = coustomercomplaintservice.getComplaintCustomerReport(sdate, edate);
		System.out.println(reportData);
		model.addAttribute("view", true);
		model.addAttribute("reportData", reportData);
		model.addAttribute("sdate", dateFormat.format(sdate));
		model.addAttribute("edate", dateFormat.format(edate));
		return "customerComplaintReport";
	}

	@RequestMapping(value = "/reportview/export", method = RequestMethod.POST)
	public void export(@RequestParam("sdate") String sdate, @RequestParam("edate") String edate,
			HttpServletResponse response) throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date startdate = CommonUtil.checkDate(sdate, df);
		Date enddate = CommonUtil.checkDate(edate, df);

		List<CustomerComplaint> reportData = coustomercomplaintservice.getComplaintCustomerReport(startdate, enddate);

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=Customer_Complaint_Report.xlsx");
		File file = new File(context.getRealPath("/") + "WEB-INF/Customer_Complaint_Report.xlsx");

		customercomplaintreporthandller.customercomplaintreportExport(reportData, file, response.getOutputStream());

	}

	@RequestMapping(value = "/reportview/delete", method = RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = CommonUtil.checkInt(request.getParameter("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			coustomercomplaintservice.delete(id);
			map.put("status", true);
		} catch (Exception e) {
			System.out.println(
					"Roshan Says That You Have A Problem In CustomerComplaintController.java At Delete Method");
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(map));
	}

	@RequestMapping(value = "/reportview/edit/{id}", method = RequestMethod.GET)
	public String Edit(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		List<CustomerComplaint> reportDataEdit = coustomercomplaintservice.editComplaintCustomerReport(id);
		model.addAttribute("customers", customerService.getCustomers());
		model.addAttribute("cgrades", centerlineService.getCenterlineGradeIds());
		model.addAttribute(EDIT_PAGE, true);
		model.addAttribute(VIEW_PAGE, false);
		model.addAttribute("reportDataEdit", reportDataEdit);
		return "customerComplaint";
	}

	@RequestMapping(value = "/reportview/load/email", method = RequestMethod.POST)
	public @ResponseBody boolean emailSummaryData(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException, ProductionException {

		Date sdate = CommonUtil.checkDate(request.getParameter("sdate"), dateFormat);
		Date edate = CommonUtil.checkDate(request.getParameter("edate"), dateFormat);
		// List<CustomerComplaint>
		// reportData=coustomercomplaintservice.getComplaintCustomerReport(sdate,edate);

		try {
			CoustomerComplaintReportMailer.sendComplaintCustomerReportEmail(sdate, edate);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
}
