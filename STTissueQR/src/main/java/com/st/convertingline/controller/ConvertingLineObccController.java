/**
 *Nov 30, 2019
 *ConvertingLineObccController.java
 * TODO
 *com.st.convertingline.controller
 *ConvertingLineObccController.java
 *Roshan Lal Tailor
 */
package com.st.convertingline.controller;

/**
 * @author kishore
 *
 */

import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.convertingline.model.ConvertingLine;
import com.st.convertingline.model.ConvertingPackagerObcc;
import com.st.convertingline.model.RewinderAndUnwindStand;
import com.st.convertingline.service.ConvertingLineService;
import com.st.obcc.model.OperatorData;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({ "/convertinglineOBCC" })
public class ConvertingLineObccController {

	private static Logger logger = Logger.getLogger(ConvertingLineController.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
	@Autowired
	private ServletContext context;
	@Autowired
	private ConvertingLineService convertinglineservice;

	@RequestMapping(value = { "/convertingObccView" }, method = { RequestMethod.GET })
	public String obccreportView(Model model) throws ParseException {
		OperatorData data = new OperatorData();
		data.setEdate(format.format(new Date()));
		model.addAttribute("data", data);
		return "convertingline/ConvertinLineObccMain";
	}

	@RequestMapping(value = { "/convertingObccBackView" }, method = { RequestMethod.GET })
	public String obccreportBackView(Model model) throws ParseException {
		OperatorData data = new OperatorData();
		data.setEdate(format.format(new Date()));
		model.addAttribute("data", data);
		return "convertingline/convertingLineObccMainBack";
	}

	@RequestMapping(value = { "casePacker/view" }, method = { RequestMethod.GET })
	public String wastepaperDetailView(@RequestParam("position") String position, @RequestParam("shift") String shift,
			@RequestParam("date") String date, @RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, @RequestParam("back") boolean back, Model model) throws ParseException {

		List<ConvertingLine> skucode = convertinglineservice.getAllSkuCode();
		ConvertingPackagerObcc data = new ConvertingPackagerObcc();

		List<ConvertingPackagerObcc> lst = convertinglineservice.getCasepackOperatorDataList(shift, date, date);

		for (ConvertingPackagerObcc datas : lst) {
			if (datas.isMachinedown()) {
				data.setMachinedown(true);
				data.setId(datas.getId());
			}

		}
		data.setDate(date);
		data.setShift(shift);
		data.setOperatorname(operatorname);
		data.setCrew(crew);
		data.setPosition(position);

		model.addAttribute("skucode", skucode);
		model.addAttribute("data", data);
		model.addAttribute("back", back);
		return "convertingline/centerlineCasepackgerObcc";
	}

	@RequestMapping(value = { "rewind/view" }, method = { RequestMethod.GET })
	public String ConvertingRewind(@RequestParam("position") String position, @RequestParam("shift") String shift,
			@RequestParam("date") String date, @RequestParam("operatorname") String operatorname,
			@RequestParam("crew") String crew, @RequestParam("back") boolean back, Model model) {
		try {
			RewinderAndUnwindStand data = new RewinderAndUnwindStand();
			List<ConvertingLine> skucode = this.convertinglineservice.getAllSkuCode();
			List<RewinderAndUnwindStand> lst = convertinglineservice.getOperatorDataListRewind(shift, date, date);

			for (RewinderAndUnwindStand datas : lst) {
				if (datas.isMachinedown()) {
					data.setMachinedown(true);
					data.setId(datas.getId());
				}

			}

			data.setDate(date);
			data.setShift(shift);
			data.setOperatorname(operatorname);
			data.setCrew(crew);
			data.setPosition(position);
			model.addAttribute("skucode", skucode);
			model.addAttribute("data", data);
			model.addAttribute("back", back);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

		return "convertingline/Rewind_unwindConverting";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String backTenderSaveData(@ModelAttribute("data") ConvertingPackagerObcc data, Model model,
			RedirectAttributes redirectAttributes) {

		model.addAttribute("data", data);

		convertinglineservice.saveorUpdate(data);

		if (data.getId() == 0) {
			redirectAttributes.addFlashAttribute("message", "Data Saved successfully.");
			return "redirect:/convertinglineOBCC/convertingObccView";
		} else {
			redirectAttributes.addFlashAttribute("message", "Data Update successfully.");
			return "redirect:/convertinglineOBCC/convertingObccView";
		}

	}

	@RequestMapping(value = "/rewind/save", method = RequestMethod.POST)
	public String RewindSave(@ModelAttribute("data") RewinderAndUnwindStand data, Model model,
			RedirectAttributes redirectAttributes) {

		model.addAttribute("data", data);
		ConvertingPackagerObcc data1 = new ConvertingPackagerObcc();
		if (data.isMachinedown()) {
			data1.setDate(data.getDate());
			data1.setOperatorname("");
			data1.setShift(data.getShift());
			data1.setSkucode("");
			data1.setKdfbox("");
			data1.setBoxesHmi("");
			data1.setBoxespallet("");
			data1.setLayerperpallet("");
			data1.setPalletlabel("");
			data1.setDatecode("");
			data1.setTapeStraight("");
			data1.setAreaClean("");
			data1.setMachinedown(true);
			convertinglineservice.saveorUpdate(data1);
		}
		List<ConvertingPackagerObcc> lst = convertinglineservice.getCasepackOperatorDataList(data.getShift(),
				data.getDate(), data.getDate());
		if (data.isMachinedown() == false) {
			for (ConvertingPackagerObcc datas : lst) {
				if (datas.isMachinedown()) {
					data1.setId(datas.getId());
					data1.setDate(data.getDate());
					data1.setOperatorname("");
					data1.setShift(data.getShift());
					data1.setSkucode("");
					data1.setKdfbox("");
					data1.setBoxesHmi("");
					data1.setBoxespallet("");
					data1.setLayerperpallet("");
					data1.setPalletlabel("");
					data1.setDatecode("");
					data1.setTapeStraight("");
					data1.setAreaClean("");
					data1.setMachinedown(false);
					convertinglineservice.saveorUpdate(data1);
				}
			}
		}

		convertinglineservice.saveorUpdateRewind(data);

		if (data.getId() == 0) {
			redirectAttributes.addFlashAttribute("message", "Data Saved successfully.");
			return "redirect:/convertinglineOBCC/convertingObccView";
		} else {
			redirectAttributes.addFlashAttribute("message", "Data Update successfully.");
			return "redirect:/convertinglineOBCC/convertingObccView";
		}

	}

	@RequestMapping(value = { "/convertingObccReportView" }, method = { RequestMethod.GET })
	public String convertingObccReportView(Model model) {
		model.addAttribute("startDate", this.dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("endDate", this.dateFormat.format(new Date()));
		return "convertinglinereport/ConvertingObccReport";
	}

	@RequestMapping(value = { "/convertingObccDownloadReportView" }, method = { RequestMethod.GET })
	public String convertingObccDownloadReportView(Model model) {
		model.addAttribute("startDate", this.dateFormat.format(CommonUtil.getFirstDate(new Date())));
		model.addAttribute("endDate", this.dateFormat.format(new Date()));
		return "convertinglinereport/ConvertingObccDownloadReport";
	}

	@RequestMapping(value = { "/view/report/data/detailedreport/export" }, method = { RequestMethod.POST })
	public void export(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("position") String position, @RequestParam("shift") String shift,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		CommonUtil.checkDate(startDate, df);
		CommonUtil.checkDate(endDate, df);
		long l;

		if (position.equals("casepacker")) {
			if (shift.equals("both")) {
				l = convertinglineservice.getDataCountDatePercentageCase(position, startDate, endDate, shift);
				List<ConvertingPackagerObcc> lst1 = convertinglineservice.getCasepackOperatorDataList("1", startDate,
						endDate);
				List<ConvertingPackagerObcc> lst2 = convertinglineservice.getCasepackOperatorDataList("2", startDate,
						endDate);
				List<ConvertingPackagerObcc> lst3 = convertinglineservice.getCasepackOperatorDataList("3", startDate,
						endDate);
				/*
				 * lst3 = convertinglineservice.getCasepackOperatorDataList("3", startDate,
				 * endDate);
				 */
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition", "attachment; filename=casepacker.xlsx");
				File file = new File(String.valueOf(context.getRealPath("/")) + "WEB-INF/casepacker.xlsx");
				getExcelReportForDayBacktenderAllReport(lst1, lst2, lst3, file, response.getOutputStream(), l);
			} else {
				l = convertinglineservice.getDataCountDatePercentageCase("casepacker", startDate, endDate, shift);
				List<ConvertingPackagerObcc> lst1 = convertinglineservice.getCasepackOperatorDataList(shift, startDate,
						endDate);
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition", "attachment; filename=casepacker.xlsx");
				File file = new File(String.valueOf(context.getRealPath("/")) + "WEB-INF/casepacker.xlsx");
				getExcelReportForDayBacktender(lst1, file, response.getOutputStream(), l);
			}
		} else if (position.equals("rewind")) {
			if (shift.equals("both")) {
				l = convertinglineservice.getDataCountDatePercentageRewind(position, startDate, endDate, shift);
				List<RewinderAndUnwindStand> lst1 = convertinglineservice.getOperatorDataListRewind("1", startDate,
						endDate);
				List<RewinderAndUnwindStand> lst2 = convertinglineservice.getOperatorDataListRewind("2", startDate,
						endDate);

				List<RewinderAndUnwindStand> lst3 = convertinglineservice.getOperatorDataListRewind("3", startDate,
						endDate);

				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition", "attachment; filename=RewinderAndUnwindStand.xlsx");
				File file = new File(
						String.valueOf(this.context.getRealPath("/")) + "WEB-INF/RewinderAndUnwindStand.xlsx");
				getExcelReportForDayBacktenderAllReportRewinder(lst1, lst2, lst3, file, response.getOutputStream(), l);
			} else {
				l = this.convertinglineservice.getDataCountDatePercentageRewind(position, startDate, endDate, shift);
				List<RewinderAndUnwindStand> lst1 = convertinglineservice.getOperatorDataListRewind(shift, startDate,
						endDate);
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition", "attachment; filename=RewinderAndUnwindStand.xlsx");
				File file = new File(
						String.valueOf(this.context.getRealPath("/")) + "WEB-INF/RewinderAndUnwindStand.xlsx");
				getExcelReportForRewindUnwind(lst1, file, response.getOutputStream(), l);
			}
		}

	}

	@RequestMapping(value = "/view/report/data/detailedreport/exportPercentage", method = RequestMethod.POST)
	public void exportPecenatgeData(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		int startMonth = getMonth(startDate);
		int endMonth = getMonth(endDate);

		int startYear = getYear(startDate);
		int endYear = getYear(endDate);
		System.out.println("startDate" + startMonth);
		System.out.println("endDate" + endMonth);

		SimpleDateFormat f = new SimpleDateFormat("mm-DD-yyyy");
		int n = 0;
		Date d1;
		try {
			d1 = format.parse(startDate);
			Date d2 = format.parse(endDate);
			n = differenceInMonths(d1, d2);
			System.out.println("diff days" + n);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (startYear != endYear) {
			endMonth = n;
		} else {

		}

		Map<Date, Double> map = new HashMap<Date, Double>();
		Map<Date, Double> r1map = new HashMap<Date, Double>();
		Map<Date, Double> Avgmap = new TreeMap<Date, Double>();

		for (int i = 0; i <= n; i++) {
			String getlastDayofMonth = null;

			if (checksameMonth(startDate, endDate) == true) {
				getlastDayofMonth = endDate;
			} else {
				getlastDayofMonth = getLastDateOfMonth(startDate);
			}

			double casepacker = convertinglineservice.getDataCountDatePercentageCase("casepacker", startDate, endDate,
					"1");
			double rewind = this.convertinglineservice.getDataCountDatePercentageRewind("rewind", startDate, endDate,
					"1");
			double avarage = (casepacker + rewind) / 2;
			startDate = addOneMonth(startDate);
			map.put(format.parse(getlastDayofMonth), casepacker);
			r1map.put(format.parse(getlastDayofMonth), rewind);
			Avgmap.put(format.parse(getlastDayofMonth), avarage);
			startMonth = startMonth + 1;

		}
		Map<Date, Double> treeMap4 = new TreeMap<Date, Double>(map);
		Map<Date, Double> treeMap2 = new TreeMap<Date, Double>(r1map);

		/***** ----------------All are Working fine--------------- **********/

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ConvetingOBCCDownload.xlsx");
		File file = new File(context.getRealPath("/") + "WEB-INF/OBCCConvetingDownload.xlsx");

		getExcelReportbyPercentage(treeMap4, treeMap2, Avgmap, file, response.getOutputStream());
	}

	/**
	 * @param treeMap4
	 * @param treeMap2
	 * @param file
	 * @param outputStream
	 * @throws IOException
	 */
	private void getExcelReportbyPercentage(Map<Date, Double> treeMap4, Map<Date, Double> treeMap2,
			Map<Date, Double> Avgmap, File file, ServletOutputStream outputStream) throws IOException {
		Workbook2007Util util = new Workbook2007Util(file, 0);

		short rowHeight = 280;
		int row = 2;
		int col = 0;

		for (Map.Entry<Date, Double> entry : treeMap4.entrySet()) {
			// String monthYear=getFormatedDateAndMonth(entry.getKey());
			util.addValue(row, col++, CommonUtil.dateParseOrFormat(entry.getKey()),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER, rowHeight);
			util.addValue(row, col++, entry.getValue() + "%", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER,
					rowHeight);
			row++;
			col = 0;

		}
		row = 2;
		for (Map.Entry<Date, Double> entry : treeMap2.entrySet()) {
			col = 2;
			util.addValue(row, col++, entry.getValue() + "%", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER,
					rowHeight);

			row++;
		}
		row = 2;
		for (Map.Entry<Date, Double> entry : Avgmap.entrySet()) {
			col = 3;
			util.addValue(row, col++, entry.getValue() + "%", Workbook2007Util.Style.STYLE_NORMAL_CENTER_NOBORDER,
					rowHeight);

			row++;
		}

		util.write(outputStream);
	}

	/**
	 * @param lst1
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException
	 */
	private void getExcelReportForRewindUnwind(List<RewinderAndUnwindStand> lst1, File file,
			ServletOutputStream outputStream, long l) throws IOException {

		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file, 0);
		util.setSheetName("RewinderUnwind Stand OBCC ", 0);
		short rowHeight = 280;
		int row = 3;
		int col = 0;

		int var15;
		for (RewinderAndUnwindStand data : lst1) {

			col = 0;
			var15 = col + 1;
			if (data.isMachinedown() == true) {
				util.addValue(row, col, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			} else {
				util.addValue(row, col, "NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			}
			util.addValue(row, var15++, data.getDate(), (short) 7, rowHeight);
			util.addValue(row, var15++, "Rewinder/Unwind Stand OBCC", (short) 11, rowHeight);
			util.addValue(row, var15++, data.getCrew(), (short) 11, rowHeight);
			if (data.getItemonrewind() != null) {
				util.addValue(row, var15++, data.getItemonrewind(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getFootagenumber() != null) {
				util.addValue(row, var15++, data.getFootagenumber(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getDiameternumber() != null) {
				util.addValue(row, var15++, data.getDiameternumber(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getActualfootage() != null) {
				util.addValue(row, var15++, data.getActualfootage(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getActualdiameter() != null) {
				util.addValue(row, var15++, data.getActualdiameter(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getPapergrade() != null) {
				util.addValue(row, var15++, data.getPapergrade(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getLogsawstone() != null) {
				util.addValue(row, var15++, data.getLogsawstone(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getUnwindstandcleaned() != null) {
				util.addValue(row, var15++, data.getUnwindstandcleaned(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getTransferglue() != null) {
				util.addValue(row, var15++, data.getTransferglue(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getTailtieglue() != null) {
				util.addValue(row, var15++, data.getTransferglue(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getNomore1stlog() != null) {
				util.addValue(row, var15++, data.getNomore1stlog(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getRolllength() != null) {
				util.addValue(row, var15++, data.getRolllength(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}
			row++;
		}

		col = 0;
		int var10001 = row + 2;
		var15 = col + 1;
		util.addValue(var10001, col, "OBCC Completed = " + l + "%", (short) 13, rowHeight);
		util.write(outputStream);

	}

	/**
	 * @param lst1
	 * @param lst2
	 * @param lst3
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException
	 */
	private void getExcelReportForDayBacktenderAllReportRewinder(List<RewinderAndUnwindStand> lst1,
			List<RewinderAndUnwindStand> lst2, List<RewinderAndUnwindStand> lst3, File file,
			ServletOutputStream outputStream, long l) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file, 0);
		util.setSheetName("RewinderUnwind Stand OBCC ", 0);
		short rowHeight = 280;
		int row = 3;
		int col = 0;

		int var15;
		for (RewinderAndUnwindStand data : lst1) {

			col = 0;
			var15 = col + 1;
			if (data.isMachinedown() == true) {
				util.addValue(row, col, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			} else {
				util.addValue(row, col, "NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			}
			util.addValue(row, var15++, data.getDate(), (short) 7, rowHeight);
			util.addValue(row, var15++, "Rewinder/Unwind Stand OBCC", (short) 11, rowHeight);
			util.addValue(row, var15++, data.getShift(), (short) 11, rowHeight);
			if (data.getItemonrewind() != null) {
				util.addValue(row, var15++, data.getItemonrewind(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getFootagenumber() != null) {
				util.addValue(row, var15++, data.getFootagenumber(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getDiameternumber() != null) {
				util.addValue(row, var15++, data.getDiameternumber(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getActualfootage() != null) {
				util.addValue(row, var15++, data.getActualfootage(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getActualdiameter() != null) {
				util.addValue(row, var15++, data.getActualdiameter(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getPapergrade() != null) {
				util.addValue(row, var15++, data.getPapergrade(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getLogsawstone() != null) {
				util.addValue(row, var15++, data.getLogsawstone(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getUnwindstandcleaned() != null) {
				util.addValue(row, var15++, data.getUnwindstandcleaned(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getTransferglue() != null) {
				util.addValue(row, var15++, data.getTransferglue(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getTailtieglue() != null) {
				util.addValue(row, var15++, data.getTransferglue(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getNomore1stlog() != null) {
				util.addValue(row, var15++, data.getNomore1stlog(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getRolllength() != null) {
				util.addValue(row, var15++, data.getRolllength(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}
			row++;
		}

		row += 2;
		col = 0;

		for (RewinderAndUnwindStand data : lst2) {

			col = 0;
			var15 = col + 1;
			if (data.isMachinedown() == true) {
				util.addValue(row, col, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			} else {
				util.addValue(row, col, "NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			}
			util.addValue(row, var15++, data.getDate(), (short) 7, rowHeight);
			util.addValue(row, var15++, "RewinderUnwind Stand OBCC", (short) 11, rowHeight);
			util.addValue(row, var15++, data.getShift(), (short) 11, rowHeight);
			if (data.getItemonrewind() != null) {
				util.addValue(row, var15++, data.getItemonrewind(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getFootagenumber() != null) {
				util.addValue(row, var15++, data.getFootagenumber(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getDiameternumber() != null) {
				util.addValue(row, var15++, data.getDiameternumber(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getActualfootage() != null) {
				util.addValue(row, var15++, data.getActualfootage(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getActualdiameter() != null) {
				util.addValue(row, var15++, data.getActualdiameter(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getPapergrade() != null) {
				util.addValue(row, var15++, data.getPapergrade(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getLogsawstone() != null) {
				util.addValue(row, var15++, data.getLogsawstone(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getUnwindstandcleaned() != null) {
				util.addValue(row, var15++, data.getUnwindstandcleaned(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getTransferglue() != null) {
				util.addValue(row, var15++, data.getTransferglue(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getTailtieglue() != null) {
				util.addValue(row, var15++, data.getTransferglue(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getNomore1stlog() != null) {
				util.addValue(row, var15++, data.getNomore1stlog(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getRolllength() != null) {
				util.addValue(row, var15++, data.getRolllength(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			row++;
		}
		
		
		row += 2;
		col = 0;
		for (RewinderAndUnwindStand data : lst3) {

			col = 0;
			var15 = col + 1;
			if (data.isMachinedown() == true) {
				util.addValue(row, col, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			} else {
				util.addValue(row, col, "NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			}
			util.addValue(row, var15++, data.getDate(), (short) 7, rowHeight);
			util.addValue(row, var15++, "RewinderUnwind Stand OBCC", (short) 11, rowHeight);
			util.addValue(row, var15++, data.getShift(), (short) 11, rowHeight);
			if (data.getItemonrewind() != null) {
				util.addValue(row, var15++, data.getItemonrewind(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getFootagenumber() != null) {
				util.addValue(row, var15++, data.getFootagenumber(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getDiameternumber() != null) {
				util.addValue(row, var15++, data.getDiameternumber(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getActualfootage() != null) {
				util.addValue(row, var15++, data.getActualfootage(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getActualdiameter() != null) {
				util.addValue(row, var15++, data.getActualdiameter(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getPapergrade() != null) {
				util.addValue(row, var15++, data.getPapergrade(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getLogsawstone() != null) {
				util.addValue(row, var15++, data.getLogsawstone(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getUnwindstandcleaned() != null) {
				util.addValue(row, var15++, data.getUnwindstandcleaned(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getTransferglue() != null) {
				util.addValue(row, var15++, data.getTransferglue(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getTailtieglue() != null) {
				util.addValue(row, var15++, data.getTransferglue(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getNomore1stlog() != null) {
				util.addValue(row, var15++, data.getNomore1stlog(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			if (data.getRolllength() != null) {
				util.addValue(row, var15++, data.getRolllength(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var15++, "", (short) 8, rowHeight);
			}

			row++;
		}
		col = 0;
		int var10001 = row + 2;
		var15 = col + 1;
		util.addValue(var10001, col, "OBCC Completed = " + l + "%", (short) 13, rowHeight);
		util.write(outputStream);

	}

	/**
	 * @param lst1
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException
	 */
	private void getExcelReportForDayBacktender(List<ConvertingPackagerObcc> lst1, File file,
			ServletOutputStream outputStream, long l) throws IOException {
		// TODO Auto-generated method stub
		Workbook2007Util util = new Workbook2007Util(file, 0);
		util.setSheetName("Case Packer Obcc ", 0);
		short rowHeight = 280;
		short rowHeightHeader = 900;
		int row = 3;
		int col = 0;

		Iterator var14;
		// byte col;
		int var16;
		/*
		 * for(var14 = lst1.iterator(); var14.hasNext(); ++row) { data =
		 * (ConvertingPackagerObcc)var14.next();
		 */
		for (ConvertingPackagerObcc data : lst1) {

			col = 0;
			var16 = col + 1;
			if (data.isMachinedown() == true) {
				util.addValue(row, col, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			} else {
				util.addValue(row, col, "NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
			}
			util.addValue(row, var16++, data.getDate(), (short) 7, rowHeight);
			util.addValue(row, var16++, "CasePacker Obcc", (short) 11, rowHeight);
			util.addValue(row, var16++, data.getShift(), (short) 11, rowHeight);
			if (data.getSkucode() != null) {
				util.addValue(row, var16++, data.getSkucode(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var16++, "", (short) 8, rowHeight);
			}

			if (data.getKdfbox() != null) {
				util.addValue(row, var16++, data.getKdfbox(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var16++, "", (short) 8, rowHeight);
			}

			if (data.getBoxesHmi() != null) {
				util.addValue(row, var16++, data.getBoxesHmi(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var16++, "", (short) 8, rowHeight);
			}

			if (data.getBoxespallet() != null) {
				util.addValue(row, var16++, data.getBoxespallet(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var16++, "", (short) 8, rowHeight);
			}

			if (data.getLayerperpallet() != null) {
				util.addValue(row, var16++, data.getLayerperpallet(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var16++, "", (short) 8, rowHeight);
			}

			if (data.getPalletlabel() != null) {
				util.addValue(row, var16++, data.getPalletlabel(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var16++, "", (short) 8, rowHeight);
			}

			if (data.getDatecode() != null) {
				util.addValue(row, var16++, data.getDatecode(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var16++, "", (short) 8, rowHeight);
			}

			if (data.getTapeStraight() != null) {
				util.addValue(row, var16++, data.getTapeStraight(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var16++, "", (short) 8, rowHeight);
			}

			if (data.getAreaClean() != null) {
				util.addValue(row, var16++, data.getAreaClean(), (short) 8, rowHeight);
			} else {
				util.addValue(row, var16++, "", (short) 8, rowHeight);
			}
			row++;
		}
		col = 0;
		int var10001 = row + 2;
		var16 = col + 1;
		util.addValue(var10001, col, "OBCC Completed = " + l + "%", (short) 13, rowHeight);
		util.write(outputStream);

	}

	/**
	 * @param lst1
	 * @param lst2
	 * @param lst3
	 * @param file
	 * @param outputStream
	 * @param l
	 * @throws IOException
	 */
	private void getExcelReportForDayBacktenderAllReport(List<ConvertingPackagerObcc> lst1,
			List<ConvertingPackagerObcc> lst2, List<ConvertingPackagerObcc> lst3, File file,
			ServletOutputStream outputStream, long l) throws IOException {
		// TODO Auto-generated method stub

		{
			Workbook2007Util util = new Workbook2007Util(file, 0);
			util.setSheetName("Case Packer Obcc ", 0);
			short rowHeight = 280;
			short rowHeightHeader = 900;
			int row = 3;
			int col = 0;

			Iterator var14;
			// byte col;
			int var16;
			/*
			 * for(var14 = lst1.iterator(); var14.hasNext(); ++row) { data =
			 * (ConvertingPackagerObcc)var14.next();
			 */
			for (ConvertingPackagerObcc data : lst1) {

				col = 0;
				var16 = col + 1;

				if (data.isMachinedown() == true) {
					util.addValue(row, col, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
				} else {
					util.addValue(row, col, "NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
				}
				util.addValue(row, var16++, data.getDate(), (short) 7, rowHeight);
				util.addValue(row, var16++, "CasePacker Obcc", (short) 11, rowHeight);
				util.addValue(row, var16++, data.getShift(), (short) 11, rowHeight);
				if (data.getSkucode() != null) {
					util.addValue(row, var16++, data.getSkucode(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getKdfbox() != null) {
					util.addValue(row, var16++, data.getKdfbox(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getBoxesHmi() != null) {
					util.addValue(row, var16++, data.getBoxesHmi(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getBoxespallet() != null) {
					util.addValue(row, var16++, data.getBoxespallet(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getLayerperpallet() != null) {
					util.addValue(row, var16++, data.getLayerperpallet(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getPalletlabel() != null) {
					util.addValue(row, var16++, data.getPalletlabel(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getDatecode() != null) {
					util.addValue(row, var16++, data.getDatecode(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getTapeStraight() != null) {
					util.addValue(row, var16++, data.getTapeStraight(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getAreaClean() != null) {
					util.addValue(row, var16++, data.getAreaClean(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}
				row++;
			}

			row += 2;
			col = 0;

			for (ConvertingPackagerObcc data : lst2) {
				col = 0;
				var16 = col + 1;
				if (data.isMachinedown() == true) {
					util.addValue(row, col, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
				} else {
					util.addValue(row, col, "NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
				}
				util.addValue(row, var16++, data.getDate(), (short) 7, rowHeight);
				util.addValue(row, var16++, "CasePacker Obcc", (short) 11, rowHeight);
				util.addValue(row, var16++, data.getShift(), (short) 11, rowHeight);
				if (data.getSkucode() != null) {
					util.addValue(row, var16++, data.getSkucode(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getKdfbox() != null) {
					util.addValue(row, var16++, data.getKdfbox(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getBoxesHmi() != null) {
					util.addValue(row, var16++, data.getBoxesHmi(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getBoxespallet() != null) {
					util.addValue(row, var16++, data.getBoxespallet(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getLayerperpallet() != null) {
					util.addValue(row, var16++, data.getLayerperpallet(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getPalletlabel() != null) {
					util.addValue(row, var16++, data.getPalletlabel(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getDatecode() != null) {
					util.addValue(row, var16++, data.getDatecode(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getTapeStraight() != null) {
					util.addValue(row, var16++, data.getTapeStraight(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getAreaClean() != null) {
					util.addValue(row, var16++, data.getAreaClean(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}
				row++;
			}

			row += 2;
			col = 0;
			for (ConvertingPackagerObcc data : lst3) {
				col = 0;
				var16 = col + 1;
				if (data.isMachinedown() == true) {
					util.addValue(row, col, "YES", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
				} else {
					util.addValue(row, col, "NO", Workbook2007Util.Style.STYLE_NORMAL_CENTER_RED, rowHeight);
				}
				util.addValue(row, var16++, data.getDate(), (short) 7, rowHeight);
				util.addValue(row, var16++, "CasePacker Obcc", (short) 11, rowHeight);
				util.addValue(row, var16++, data.getShift(), (short) 11, rowHeight);
				if (data.getSkucode() != null) {
					util.addValue(row, var16++, data.getSkucode(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getKdfbox() != null) {
					util.addValue(row, var16++, data.getKdfbox(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getBoxesHmi() != null) {
					util.addValue(row, var16++, data.getBoxesHmi(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getBoxespallet() != null) {
					util.addValue(row, var16++, data.getBoxespallet(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getLayerperpallet() != null) {
					util.addValue(row, var16++, data.getLayerperpallet(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getPalletlabel() != null) {
					util.addValue(row, var16++, data.getPalletlabel(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getDatecode() != null) {
					util.addValue(row, var16++, data.getDatecode(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getTapeStraight() != null) {
					util.addValue(row, var16++, data.getTapeStraight(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}

				if (data.getAreaClean() != null) {
					util.addValue(row, var16++, data.getAreaClean(), (short) 8, rowHeight);
				} else {
					util.addValue(row, var16++, "", (short) 8, rowHeight);
				}
				row++;
			}
			col = 0;
			int var10001 = row + 2;
			var16 = col + 1;
			util.addValue(var10001, col, "OBCC Completed = " + l + "%", (short) 13, rowHeight);
			util.write(outputStream);

		}

	}

	public static String getLastDateOfMonth(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date convertedDate;
		try {
			convertedDate = dateFormat.parse(date);
			Calendar c = Calendar.getInstance();
			c.setTime(convertedDate);
			c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date lastDayOfMonth = c.getTime();
			DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			return sdf.format(lastDayOfMonth);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static String addOneMonth(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date convertedDate;
		try {
			convertedDate = dateFormat.parse(date);
			Calendar c = Calendar.getInstance();
			c.setTime(convertedDate);
			c.add(Calendar.MONTH, 1);
			Date lastDayOfMonth = c.getTime();
			DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			return sdf.format(lastDayOfMonth);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static int getYear(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date convertedDate;
		try {
			convertedDate = dateFormat.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(convertedDate);
			return cal.get(Calendar.YEAR);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

	}

	public static int getMonth(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date convertedDate;
		try {
			convertedDate = dateFormat.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(convertedDate);
			return cal.get(Calendar.MONTH);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

	}

	public static boolean checksameMonth(String sdate, String edate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date convertedDate1;
		Date convertedDate2;
		try {
			convertedDate1 = dateFormat.parse(sdate);
			convertedDate2 = dateFormat.parse(edate);
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal1.setTime(convertedDate1);
			cal2.setTime(convertedDate2);
			boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
					&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);

			return sameDay;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	private static int differenceInMonths(final Date s1, final Date s2) {
		final Calendar d1 = Calendar.getInstance();
		d1.setTime(s1);
		final Calendar d2 = Calendar.getInstance();
		d2.setTime(s2);
		int diff = (d2.get(Calendar.YEAR) - d1.get(Calendar.YEAR)) * 12 + d2.get(Calendar.MONTH)
				- d1.get(Calendar.MONTH);
		return diff;
	}

}
