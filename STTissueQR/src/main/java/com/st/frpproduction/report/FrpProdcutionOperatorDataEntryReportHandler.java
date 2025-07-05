/**
 *Mar 19, 2016
 *FrpProdcutionOperatorDataEntryReportHandler.java
 * TODO
 *com.st.frpproduction.report
 *FrpProdcutionOperatorDataEntryReportHandler.java
 *Roshan Lal Tailor
 */
package com.st.frpproduction.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import jakarta.servlet.ServletOutputStream;
import org.springframework.stereotype.Component;
import com.st.common.CommonUtil;
import com.st.common.Workbook2007Util;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;

/**
 * @author roshan
 *
 */
@Component
public class FrpProdcutionOperatorDataEntryReportHandler {

	/**
	 * @param details
	 * @param file
	 * @param outputStream
	 */
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

	public void getExcelReport(List<FrpProdcutionOperatorDataEntry> details, List<FrpProdcutionOperatorDataEntry> aavg,
			List<FrpProdcutionOperatorDataEntry> bavg, List<FrpProdcutionOperatorDataEntry> cavg,
			List<FrpProdcutionOperatorDataEntry> davg, File file, ServletOutputStream outputStream) throws IOException {

		Workbook2007Util util = new Workbook2007Util(file, 0);
		util.setSheetName("Frp Prodcution Operator Data Entry Report", 0);

		short rowHeight = 280;
		int row = 4;
		int col = 0;
		int lastcol = 0;
		for (FrpProdcutionOperatorDataEntry data : details) {
			col = 0;
			lastcol = 1;

			
			util.addValue(row, col++, dateFormat.format(data.getDate()),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, data.getShift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getProductiontype(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow,
					rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6() + data.getCol7()) / data.getCol9()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10a(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);

			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++,
					CommonUtil.round(((data.getCol6b() + data.getCol7b()) / data.getCol9b()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);

			row++;
		}
		col = 0;
		row++;
		util.addValue(row, col++, "Summary", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

		row++;
		for (FrpProdcutionOperatorDataEntry data : aavg) {
			col = 0;
			lastcol = 1;

			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "A", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6() + data.getCol7()) / data.getCol9()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10a(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++,
					CommonUtil.round(((data.getCol6b() + data.getCol7b()) / data.getCol9b()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);

			row++;
		}

		for (FrpProdcutionOperatorDataEntry data : bavg) {
			col = 0;
			lastcol = 1;

			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "B", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6() + data.getCol7()) / data.getCol9()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10a(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++,
					CommonUtil.round(((data.getCol6b() + data.getCol7b()) / data.getCol9b()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);

			row++;
		}

		for (FrpProdcutionOperatorDataEntry data : cavg) {
			col = 0;
			lastcol = 1;

			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "C", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6() + data.getCol7()) / data.getCol9()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10a(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++,
					CommonUtil.round(((data.getCol6b() + data.getCol7b()) / data.getCol9b()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);

			row++;
		}

		for (FrpProdcutionOperatorDataEntry data : davg) {
			col = 0;
			lastcol = 1;

			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			util.addValue(row, col++, "D", Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6() + data.getCol7()) / data.getCol9()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10a(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++,
					CommonUtil.round(((data.getCol6b() + data.getCol7b()) / data.getCol9b()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);

			row++;
		}
		util.write(outputStream);
	}
	public void getExcelReportForDataEntry(List<FrpProdcutionOperatorDataEntry> details,FileOutputStream outputStream) throws IOException {

		Workbook2007Util util = new Workbook2007Util();
		util.setSheetName("Frp Prodcution Operator Data Entry Report", 0);

		short rowHeight = 280;
		int row = 4;
		int col = 0;
		int lastcol = 0;
		for (FrpProdcutionOperatorDataEntry data : details) {
			col = 0;
			lastcol = 1;

			
			util.addValue(row, col++, dateFormat.format(data.getDate()),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_GREEN, rowHeight);
			util.addValue(row, col++, data.getShift(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getCrew(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, data.getProductiontype(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow,
					rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol1(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol3(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol4(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol5(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol11(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(((data.getCol6() + data.getCol7()) / data.getCol9()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10a(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);

			util.addValue(row, col++, CommonUtil.round(data.getCol11b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol6b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol7b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++,
					CommonUtil.round(((data.getCol6b() + data.getCol7b()) / data.getCol9b()) * 100, 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol9b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol10b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			util.addValue(row, col++, CommonUtil.round(data.getCol12b(), 2),
					Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);

			row++;
		}
		col = 0;
		row++;
		util.addValue(row, col++, "Summary", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
		util.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);

		row++;
		
		util.write(outputStream);
	}
}
