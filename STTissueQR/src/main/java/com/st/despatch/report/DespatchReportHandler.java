/**
 *Jan 12, 2018
 *DespatchReportHandler.java
 * TODO
 *com.st.despatch.report
 *DespatchReportHandler.java
 *Roshan Lal Tailor
 */
package com.st.despatch.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.st.common.Workbook2007Util;
import com.st.despatch.model.Despatch;
import com.st.despatch.service.DespatchService;

/**
 * @author roshan
 *
 */
@Component
public class DespatchReportHandler {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private DespatchService despatchService;
	
	@Autowired
	private DataSource dataSource;
	
	/**
	 * @param datas
	 * @param tblName 
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createExcelDespatchReport(List<Despatch> datas,String tblName, FileOutputStream outputStream) throws IOException {
		
		Workbook2007Util workbookUtil=new Workbook2007Util();

		int row=0;
		int col=0;
		short rowHeight=280;
		
		workbookUtil.addValue(row, col++, "Pick Up Date	", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Pick Up Point", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Pick Up City	", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Pick Up State", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Pick Up Phone", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Release Number", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Carrier ID", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Unload Comment(s)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		
		for (Despatch data : datas) {
			row++;
			col=0;
			
			int checkDate=0;
			if(data.getPickupdate()==null){
				checkDate=0;
			}else{
				checkDate=(int) despatchService.getCheckDateTempTable(tblName,data.getReleasenumber(),data.getPickupdate());
			}
			
			if(checkDate==0){
				if(data.getPickupdate()==null){
					workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);	
				}else{
					workbookUtil.addValue(row, col++, dateFormat.format(data.getPickupdate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				}
				
			}else{
				workbookUtil.addValue(row, col++, dateFormat.format(data.getPickupdate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkPickUpPoint=(int) despatchService.getCheckPickUpPointTempTable(tblName,data.getReleasenumber(),data.getPickuppoint());
			if(checkPickUpPoint==0){
				workbookUtil.addValue(row, col++, data.getPickuppoint(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getPickuppoint(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkPickUpCity=(int) despatchService.getCheckPickUpCityTempTable(tblName,data.getReleasenumber(),data.getPickupcity());
			if(checkPickUpCity==0){
				workbookUtil.addValue(row, col++, data.getPickupcity(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getPickupcity(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkPickUpState=(int) despatchService.getCheckPickUpStateTempTable(tblName,data.getReleasenumber(),data.getPickupstate());
			if(checkPickUpState==0){
				workbookUtil.addValue(row, col++, data.getPickupstate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getPickupstate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkCellNumner=(int) despatchService.getCheckPickUpCellNumberTempTable(tblName,data.getReleasenumber(),data.getCellnumber());
			if(checkCellNumner==0){
				workbookUtil.addValue(row, col++, data.getCellnumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getCellnumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkGrade=(int) despatchService.getCheckGradeTempTable(tblName,data.getReleasenumber(),data.getGrade());
			if(checkGrade==0){
				workbookUtil.addValue(row, col++, data.getGrade(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getGrade(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkRelease=(int) despatchService.getCheckReleaseTempTable(tblName,data.getReleasenumber(),data.getReleasenumber());
			if(checkRelease==0){
				workbookUtil.addValue(row, col++, data.getReleasenumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getReleasenumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			
			int checkCareerirId=(int) despatchService.getCheckCareerirIdTempTable(tblName,data.getReleasenumber(),data.getCareeririd());
			if(checkCareerirId==0){
				workbookUtil.addValue(row, col++, data.getCareeririd(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getCareeririd(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkUnloadCommants=(int) despatchService.getCheckUnloadCommantsTempTable(tblName,data.getReleasenumber(),data.getUnloadcomments());
			if(checkUnloadCommants==0){
				workbookUtil.addValue(row, col++, data.getUnloadcomments(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getUnloadcomments(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			
		}
	
		row++;
		col=0;
		
		
		for (int i = 0; i < 17; i++) {
			workbookUtil.setAutoSizeColumn(i);
		}
		
		truncateTable();
		insertDataInTempTable(datas);
		
		workbookUtil.freez(1, 1);
		
		workbookUtil.write(outputStream);
	}

	/**
	 * @param datas
	 */
	private void insertDataInTempTable(List<Despatch> datas) {
		// TODO Auto-generated method stub
		for (final Despatch data : datas) {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			final String sql = "insert into [tbldispatch_temp]"
					+ "("
					+ "[PickUpDate],"
					+ "[PickUpPoint],"
					+ "[PickUpCity],"
					+ "[PickUpState],"
					+ "[PickUpPhone],"
					+ "[Grade],"
					+ "[Release],"
					+ "[CarrierId],"
					+ "[Comments])"
					+ " values(?,?,?,?,?,?,?,?,?)";

			KeyHolder keyHolder = new GeneratedKeyHolder();

			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement = arg0.prepareStatement(sql,
							new String[] { "ID" });

					if(data.getPickupdate()==null){
						statement.setTimestamp(1,  new Timestamp(new Date().getTime()));
					}else{
						statement.setTimestamp(1, new Timestamp(data.getPickupdate().getTime()));
					}
					if(data.getPickuppoint()==null){
						statement.setString(2, "");
					}else{
						statement.setString(2, data.getPickuppoint());
					}
					if(data.getPickupcity()==null){
						statement.setString(3, "");
					}else{
						statement.setString(3, data.getPickupcity());
					}
					if(data.getPickupstate()==null){
						statement.setString(4, "");
					}else{
						statement.setString(4, data.getPickupstate());	
					}
					if(data.getCellnumber()==null){
						statement.setString(5, "");
					}else{
						statement.setString(5, data.getCellnumber());
					}
					if(data.getGrade()==null){
						statement.setString(6, "");
					}else{
						statement.setString(6, data.getGrade());
					}
					
					statement.setInt(7, data.getReleasenumber());
					
					if( data.getCareeririd()==null){
						statement.setString(8, "");
					}else{
						statement.setString(8, data.getCareeririd());
					}
					if(data.getUnloadcomments()==null){
						statement.setString(9,"");
					}else{
						statement.setString(9, data.getUnloadcomments());
					}

					
					
					return statement;
				}
			}, keyHolder);
		}
		
	}

	/**
	 * 
	 */
	private void truncateTable() {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sql = "Truncate table [tbldispatch_temp]";
			jdbcTemplate.update(sql, new Object[] {});
		} catch (Exception turn) {
			turn.printStackTrace();
	}
	}

	/**
	 * @param datas
	 * @param tblName 
	 * @param outputStream
	 * @throws IOException 
	 */
	public void createExcelDespatchReportForWH(List<Despatch> datas,
			String tblName, FileOutputStream outputStream) throws IOException {
		
		Workbook2007Util workbookUtil=new Workbook2007Util();

		int row=0;
		int col=0;
		short rowHeight=280;
		
		workbookUtil.addValue(row, col++, "Pick Up Date	", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Pick Up Point", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Pick Up City	", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Pick Up State", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Pick Up Phone", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Grade", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Release Number", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Carrier ID", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "Unload Comment(s)", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
		workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_BOLD_CENTER, rowHeight);
			
		
		for (Despatch data : datas) {
			row++;
			col=0;
			
			int checkDate=0;
			if(data.getPickupdate()==null){
				checkDate=0;
			}else{
				checkDate=(int) despatchService.getCheckDateTempTable(tblName,data.getReleasenumber(),data.getPickupdate());
			}
			
			if(checkDate==0){
				if(data.getPickupdate()==null){
					workbookUtil.addValue(row, col++, "", Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);	
				}else{
					workbookUtil.addValue(row, col++, dateFormat.format(data.getPickupdate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
				}
			}else{
				workbookUtil.addValue(row, col++, dateFormat.format(data.getPickupdate()), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkPickUpPoint=(int) despatchService.getCheckPickUpPointTempTable(tblName,data.getReleasenumber(),data.getPickuppoint());
			if(checkPickUpPoint==0){
				workbookUtil.addValue(row, col++, data.getPickuppoint(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getPickuppoint(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkPickUpCity=(int) despatchService.getCheckPickUpCityTempTable(tblName,data.getReleasenumber(),data.getPickupcity());
			if(checkPickUpCity==0){
				workbookUtil.addValue(row, col++, data.getPickupcity(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getPickupcity(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkPickUpState=(int) despatchService.getCheckPickUpStateTempTable(tblName,data.getReleasenumber(),data.getPickupstate());
			if(checkPickUpState==0){
				workbookUtil.addValue(row, col++, data.getPickupstate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getPickupstate(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkCellNumner=(int) despatchService.getCheckPickUpCellNumberTempTable(tblName,data.getReleasenumber(),data.getCellnumber());
			if(checkCellNumner==0){
				workbookUtil.addValue(row, col++, data.getCellnumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getCellnumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkGrade=(int) despatchService.getCheckGradeTempTable(tblName,data.getReleasenumber(),data.getGrade());
			if(checkGrade==0){
				workbookUtil.addValue(row, col++, data.getGrade(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getGrade(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkRelease=(int) despatchService.getCheckReleaseTempTable(tblName,data.getReleasenumber(),data.getReleasenumber());
			if(checkRelease==0){
				workbookUtil.addValue(row, col++, data.getReleasenumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getReleasenumber(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			
			int checkCareerirId=(int) despatchService.getCheckCareerirIdTempTable(tblName,data.getReleasenumber(),data.getCareeririd());
			if(checkCareerirId==0){
				workbookUtil.addValue(row, col++, data.getCareeririd(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getCareeririd(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			int checkUnloadCommants=(int) despatchService.getCheckUnloadCommantsTempTable(tblName,data.getReleasenumber(),data.getUnloadcomments());
			if(checkUnloadCommants==0){
				workbookUtil.addValue(row, col++, data.getUnloadcomments(), Workbook2007Util.Style.STYLE_NORMAL_CENTER_Yellow, rowHeight);
			}else{
				workbookUtil.addValue(row, col++, data.getUnloadcomments(), Workbook2007Util.Style.STYLE_NORMAL_CENTER, rowHeight);
			}
			
			
		}
	
		row++;
		col=0;
		
		
		for (int i = 0; i < 17; i++) {
			workbookUtil.setAutoSizeColumn(i);
		}
		
		truncateTableWH(tblName);
		insertDataInTempTableWH(datas,tblName);
		
		workbookUtil.freez(1, 1);
		
		workbookUtil.write(outputStream);
	}

	/**
	 * @param datas
	 * @param tblName 
	 */
	private void insertDataInTempTableWH(List<Despatch> datas, String tblName) {
		// TODO Auto-generated method stub
		for (final Despatch data : datas) {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			final String sql = "insert into"+ "["+tblName+"]"
					+ "("
					+ "[PickUpDate],"
					+ "[PickUpPoint],"
					+ "[PickUpCity],"
					+ "[PickUpState],"
					+ "[PickUpPhone],"
					+ "[Grade],"
					+ "[Release],"
					+ "[CarrierId],"
					+ "[Comments])"
					+ " values(?,?,?,?,?,?,?,?,?)";

			KeyHolder keyHolder = new GeneratedKeyHolder();

			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement = arg0.prepareStatement(sql,
							new String[] { "ID" });

					if(data.getPickupdate()==null){
						statement.setTimestamp(1,  new Timestamp(new Date().getTime()));
					}else{
						statement.setTimestamp(1, new Timestamp(data.getPickupdate().getTime()));
					}
					if(data.getPickuppoint()==null){
						statement.setString(2, "");
					}else{
						statement.setString(2, data.getPickuppoint());
					}
					if(data.getPickupcity()==null){
						statement.setString(3, "");
					}else{
						statement.setString(3, data.getPickupcity());
					}
					if(data.getPickupstate()==null){
						statement.setString(4, "");
					}else{
						statement.setString(4, data.getPickupstate());	
					}
					if(data.getCellnumber()==null){
						statement.setString(5, "");
					}else{
						statement.setString(5, data.getCellnumber());
					}
					if(data.getGrade()==null){
						statement.setString(6, "");
					}else{
						statement.setString(6, data.getGrade());
					}
					
					statement.setInt(7, data.getReleasenumber());
					
					if( data.getCareeririd()==null){
						statement.setString(8, "");
					}else{
						statement.setString(8, data.getCareeririd());
					}
					if(data.getUnloadcomments()==null){
						statement.setString(9,"");
					}else{
						statement.setString(9, data.getUnloadcomments());
					}
					
					return statement;
				}
			}, keyHolder);
		}
		
	}

	/**
	 * @param tblName 
	 * 
	 */
	private void truncateTableWH(String tblName) {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sql = "Truncate table ["+tblName+"]";
			jdbcTemplate.update(sql, new Object[] {});
		} catch (Exception turn) {
			turn.printStackTrace();
	}
	}
	
}








