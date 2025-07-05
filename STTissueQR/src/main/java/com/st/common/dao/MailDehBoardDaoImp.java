/**
 *09-Jun-2020
 *MailDehBoardDaoImp.java
 * TODO
 *com.st.common.dao
 *MailDehBoardDaoImp.java
 *Sohan Lal
 */
package com.st.common.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.st.common.model.MailDeshBoard;

/**
 * @author sohan
 *
 */
@Repository
public class MailDehBoardDaoImp implements MailDehBoardDao {
	@Autowired
	private DataSource dataSource;
	@Override
	public List<MailDeshBoard> getMailDatas() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [mailDehBoard] order by EntrydateTime";
		
		List<MailDeshBoard> mailDehBoard=jdbcTemplate.query(sql, new RowMapper<MailDeshBoard>(){
			@Override
			public MailDeshBoard mapRow(ResultSet rs, int arg1) throws SQLException {
				MailDeshBoard mail=new MailDeshBoard();			
				mail.setId(rs.getInt("ID"));
				mail.setTime(rs.getTimestamp("EntrydateTime"));
				mail.setDate(rs.getTimestamp("EntrydateTime"));				
				mail.setReportName(rs.getString("reportName"));
				mail.setFrquencyOfMail(rs.getString("frquencyOfMail"));
				mail.setTimeToCheck(rs.getString("timeToCheck"));
				mail.setStatus(rs.getString("status"));
				mail.setErroCode(rs.getString("erroCode"));
				mail.setSenderName(rs.getString("senderName"));
				mail.setReportId(rs.getString("reportId"));
				return mail;
			}});
		
		return mailDehBoard;
	}
	@Override
	public void save(Date date, String reportName, String frquencyOfMail, String timeToCheck, boolean status,
			String erroCode, String reportId,String senderName) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time=sdf.format(date);
		String sqldata="select * from [mailDehBoard] where id='1'";
		Date datep=null;
		try {
			MailDeshBoard mailDehBoard=jdbcTemplate.queryForObject(sqldata, new RowMapper<MailDeshBoard>(){
				@Override
				public MailDeshBoard mapRow(ResultSet rs, int arg1) throws SQLException {
					MailDeshBoard mail=new MailDeshBoard();				
					mail.setDate(rs.getTimestamp("EntrydateTime"));				
					return mail;
				}});
				 datep=mailDehBoard.getDate();
		} catch (Exception e) {
			
		}
		if(datep!=null)
		{
			  
		    String currentDate= formatter.format(date); 
		    String previousDate= formatter.format(datep); 
		    Date d1=null,d2=null;
			try {
				d1 = formatter.parse(currentDate);
				d2 = formatter.parse(previousDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
			if(d1.compareTo(d2) > 0)
			{
				jdbcTemplate.update("update  [mailDehBoard] set status='Pending',time='"+date+"' where status = '1'");
			}
		}
		String sqlP="select * from [mailDehBoard] where reportName like '%"+reportName+"%'";
		String reportNameP=null;
		try {
			MailDeshBoard mailDehBoard=jdbcTemplate.queryForObject(sqlP, new RowMapper<MailDeshBoard>(){
				@Override
				public MailDeshBoard mapRow(ResultSet rs, int arg1) throws SQLException {
					MailDeshBoard mail=new MailDeshBoard();				
					mail.setReportName(rs.getString("reportName"));				
					return mail;
				}});
			reportNameP=mailDehBoard.getReportName();
		} catch (Exception e) {
			
		}
		if(reportName.equalsIgnoreCase(reportNameP))
		{
			String sql="update  [mailDehBoard] set"
					+ "[Time]=?,[EntrydateTime]=?,[reportName]=?,[frquencyOfMail]=?,[timeToCheck]=?,"
					+ "[status]=?,[erroCode]=?,[senderName]=?"
					+ " where reportName=?";
					
			jdbcTemplate.update(sql, new Object[]{
					time,date,reportName,frquencyOfMail,timeToCheck,status,
					erroCode,senderName,reportNameP
					});
			String sqlLog="insert into [mailDehBoardlog] ("
					+ "[Time],[EntrydateTime],[reportName],[frquencyOfMail],[timeToCheck],[status],[erroCode],[senderName],[reportId]"
					+ ") values(?,?,?,?,?,?,?,?,?)";
			if(!senderName.equalsIgnoreCase("AutoMailer"))
			{
				jdbcTemplate.update(sqlLog, new Object[]{
					time,date,reportName,frquencyOfMail,timeToCheck,status,
					erroCode,senderName,reportId
					});
			}
		}
		else
		{
		
			String sql="insert into [mailDehBoard] ("
					+ "[Time],[EntrydateTime],[reportName],[frquencyOfMail],[timeToCheck],[status],[erroCode],[senderName],[reportId]"
					+ ") values(?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql, new Object[]{
					time,date,reportName,frquencyOfMail,timeToCheck,status,
					erroCode,senderName,reportId
					});
			String sqlLog="insert into [mailDehBoardlog] ("
					+ "[Time],[EntrydateTime],[reportName],[frquencyOfMail],[timeToCheck],[status],[erroCode],[senderName],[reportId]"
					+ ") values(?,?,?,?,?,?,?,?,?)";
			if(!senderName.equalsIgnoreCase("AutoMailer"))
			{
				jdbcTemplate.update(sqlLog, new Object[]{
					time,date,reportName,frquencyOfMail,timeToCheck,status,
					erroCode,senderName,reportId
					});
			}
		}
	}

}
