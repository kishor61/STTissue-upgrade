/**
 *Oct 17, 2019
 *QulityCheck_Pm6DaoImp.java
 * TODO
 *com.st.qualitypm6.dao
 *QulityCheck_Pm6DaoImp.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.st.common.CommonUtil;
import com.st.qualitypm6.model.QulityCheck_Pm6;
import java.sql.Timestamp;

import productspecificationsignoffsheet.ProductSpecificationSignOffSheet;

/**
 * @author roshan
 *
 */
@Service
public class QulityCheckPm5DaoImp implements QulityCheckPm5Dao {

	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.QulityCheck_Pm6Dao#getDataOfQulityCheck_Pm6(java.util.Date)
	 */
	@Override
	public List<QulityCheck_Pm6> getDataOfQulityCheck_Pm6(Date date) {
		
		
JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar scal=Calendar.getInstance();
		
		scal.setTime(CommonUtil.getShiftDate());
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(CommonUtil.getShiftDate());
		ecal.set(Calendar.HOUR_OF_DAY, 5);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		java.sql.Date sdate1 = new java.sql.Date(scal.getTime().getTime());
		java.sql.Date edate1 = new java.sql.Date(ecal.getTime().getTime());
		
		
		
		String sql="select * from tbl_QulityCheck_Pm5 where date between ? and ?  order by date";   
		
		List<QulityCheck_Pm6> procedures=jdbcTemplate.query(sql,new Object[]{new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime())},new RowMapper<QulityCheck_Pm6>(){

			@Override
			public QulityCheck_Pm6 mapRow(ResultSet rs, int arg1)throws SQLException {
				QulityCheck_Pm6 operatingProcedure=new QulityCheck_Pm6();
				operatingProcedure.setId(rs.getInt("id"));
				operatingProcedure.setTime(rs.getString("time"));
				operatingProcedure.setDate(new Date(rs.getTimestamp("date").getTime()));
				operatingProcedure.setGradecode(rs.getString("gradecode"));
				operatingProcedure.setCustomer(rs.getString("customer"));
				operatingProcedure.setSetnumber(rs.getString("setnumber"));
				operatingProcedure.setPosition(rs.getString("position"));
				operatingProcedure.setWidthofroll(rs.getString("widthofroll"));
				operatingProcedure.setDiameterofroll(rs.getString("diameterofroll"));
				operatingProcedure.setCore(rs.getString("core"));
				operatingProcedure.setCorrugation(rs.getString("corrugation"));
				operatingProcedure.setHoles(rs.getString("holes"));
				operatingProcedure.setEdgequlity(rs.getString("EdgeQulity"));
				operatingProcedure.setR1r2initial(rs.getString("r1r2initial"));
				operatingProcedure.setAuditerinitial(rs.getString("auditerinitial"));
				operatingProcedure.setMachinedown(rs.getString("machinedown"));
				operatingProcedure.setStime(rs.getTimestamp("stime"));
				operatingProcedure.setEtime(rs.getTimestamp("etime"));
				operatingProcedure.setShift(rs.getString("shift"));
				
				
				
				return operatingProcedure;
			}
			
		});
		
		return procedures;

		
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.QulityCheckPm6Dao#savequalitychecklist(com.st.qualitypm6.model.QulityCheck_Pm6)
	 */
	@Override
	public int savequalitychecklist(final QulityCheck_Pm6 wm) {
JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		/*
		 * Date timeVal=null; Calendar calendar=Calendar.getInstance();
		 * timeVal=calendar.getTime();
		 * 
		 * final Date datetime= CommonUtil.getDateTime(wm.getDate(), timeVal); final
		 * Calendar scal=Calendar.getInstance();
		 * 
		 * scal.setTime(datetime);
		 */
	
		
		
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into [tbl_QulityCheck_Pm5]"
				+ "("
				+"[time],"
				+"[date],"
				+"[gradecode],"
				+"[customer],"
				+"[setnumber],"
				+"[position],"
				+"[widthofroll],"
				+"[diameterofroll],"
				+"[core],"
				+"[corrugation],"
				+"[holes],"
				+"[EdgeQulity],"
				+"[r1r2initial],"
				+"[auditerinitial],"
				+"[stime],"
				+"[etime],"
				+"[machinedown],"
				+"[shift]"
				+ ")"
				+ " values("
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
				+ ")";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				statement.setString(1, wm.getTime());
				statement.setTimestamp(2, new Timestamp(wm.getDate().getTime()));
			//	statement.setTimestamp(2, new Timestamp(wm.getDate().getTime()));
				statement.setString(3, wm.getGradecode());
				statement.setString(4, wm.getCustomer());
				statement.setString(5, wm.getSetnumber());
				statement.setString(6, wm.getPosition());
				statement.setString(7, wm.getWidthofroll());
				statement.setString(8, wm.getDiameterofroll());
				statement.setString(9, wm.getCore());
				statement.setString(10, wm.getCorrugation());
				statement.setString(11, wm.getHoles());
				statement.setString(12, wm.getEdgequlity());
				statement.setString(13, wm.getR1r2initial());
				statement.setString(14, wm.getAuditerinitial());
				statement.setTimestamp(15, new Timestamp(wm.getStime().getTime()));
				statement.setTimestamp(16, new Timestamp(wm.getEtime().getTime()));
				statement.setString(17, wm.getMachinedown());
				statement.setString(18, wm.getShift());
				
				return statement;
			}
		},keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.QulityCheckPm6Dao#qualitychecklistdelete(int)
	 */
	@Override
	public void qualitychecklistdelete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [tbl_QulityCheck_Pm5] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
		
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.QulityCheckPm6Dao#updatequalitychecklist(com.st.qualitypm6.model.QulityCheck_Pm6)
	 */
	@Override
	public void updatequalitychecklist(final QulityCheck_Pm6 wm) {
		// TODO Auto-generated method stub
		
		/*
		 * Date timeVal=null; Calendar calendar=Calendar.getInstance();
		 * timeVal=calendar.getTime();
		 * 
		 * final Date datetime= CommonUtil.getDateTime(wm.getDate(), timeVal);
		 */
				JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
				final String sql="update [tbl_QulityCheck_Pm5] set "
						+"[time]=?,"
						+"[date]=?,"
						+"[gradecode]=?,"
						+"[customer]=?,"
						+"[setnumber]=?,"
						+"[position]=?,"
						+"[widthofroll]=?,"
						+"[diameterofroll]=?,"
						+"[core]=?,"
						+"[corrugation]=?,"
						+"[holes]=?,"
						+"[EdgeQulity]=?,"
						+"[r1r2initial]=?,"
						+"[auditerinitial]=?,"
						+"[stime]=?,"
						+"[etime]=?,"
						+"[machinedown]=?,"
						+"[shift]=?"
						+ " where [ID]=?";
				jdbcTemplate.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection arg0)
							throws SQLException {
						PreparedStatement statement=arg0.prepareStatement(sql);
						statement.setString(1, wm.getTime());
						statement.setTimestamp(2, new Timestamp(wm.getDate().getTime()));
						statement.setString(3, wm.getGradecode());
						statement.setString(4, wm.getCustomer());
						statement.setString(5, wm.getSetnumber());
						statement.setString(6, wm.getPosition());
						statement.setString(7, wm.getWidthofroll());
						statement.setString(8, wm.getDiameterofroll());
						statement.setString(9, wm.getCore());
						statement.setString(10, wm.getCorrugation());
						statement.setString(11, wm.getHoles());
						statement.setString(12, wm.getEdgequlity());
						statement.setString(13, wm.getR1r2initial());
						statement.setString(14, wm.getAuditerinitial());
						statement.setTimestamp(15, new Timestamp(wm.getStime().getTime()));
						statement.setTimestamp(16, new Timestamp(wm.getEtime().getTime()));
						statement.setString(17, wm.getMachinedown());
						statement.setString(18, wm.getShift());
						statement.setInt(19, wm.getId());
						return statement;
					}
				});
		
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.QulityCheckPm6Dao#getDataOfQulityCheck_Pm6(java.util.Date, java.util.Date)
	 */
	@Override
	public List<QulityCheck_Pm6> getDataOfQulityCheck_Pm6(Date sdate, Date edate) {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar scal=Calendar.getInstance();
		
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		ecal.set(Calendar.HOUR_OF_DAY, 5);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		java.sql.Date sdate1 = new java.sql.Date(scal.getTime().getTime());
		java.sql.Date edate1 = new java.sql.Date(ecal.getTime().getTime());
	System.out.println("StartTime****0"+sdate1);
	System.out.println("ETime****0"+edate1);
		
		
		
		String sql="select * from tbl_QulityCheck_Pm5 where date between ? and ?  order by date";   
		
		List<QulityCheck_Pm6> procedures=jdbcTemplate.query(sql,new Object[]{new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime())},new RowMapper<QulityCheck_Pm6>(){

			@Override
			public QulityCheck_Pm6 mapRow(ResultSet rs, int arg1)throws SQLException {
				QulityCheck_Pm6 operatingProcedure=new QulityCheck_Pm6();
				operatingProcedure.setId(rs.getInt("id"));
				operatingProcedure.setTime(rs.getString("time"));
				operatingProcedure.setDate(new Date(rs.getTimestamp("date").getTime()));
				operatingProcedure.setGradecode(rs.getString("gradecode"));
				operatingProcedure.setCustomer(rs.getString("customer"));
				operatingProcedure.setSetnumber(rs.getString("setnumber"));
				operatingProcedure.setPosition(rs.getString("position"));
				operatingProcedure.setWidthofroll(rs.getString("widthofroll"));
				operatingProcedure.setDiameterofroll(rs.getString("diameterofroll"));
				operatingProcedure.setCore(rs.getString("core"));
				operatingProcedure.setCorrugation(rs.getString("corrugation"));
				operatingProcedure.setHoles(rs.getString("holes"));
				operatingProcedure.setEdgequlity(rs.getString("EdgeQulity"));
				operatingProcedure.setR1r2initial(rs.getString("r1r2initial"));
				operatingProcedure.setAuditerinitial(rs.getString("auditerinitial"));
				operatingProcedure.setShift(rs.getString("shift"));
				operatingProcedure.setStime(rs.getTimestamp("stime"));
				operatingProcedure.setEtime(rs.getTimestamp("etime"));
				operatingProcedure.setMachinedown(rs.getString("machinedown"));
				operatingProcedure.setShift(rs.getString("shift"));
				operatingProcedure.setStime(rs.getTimestamp("stime"));
				operatingProcedure.setEtime(rs.getTimestamp("etime"));
				
				return operatingProcedure;
			}
			
		});
		
		return procedures;
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.QulityCheckPm6Dao#getDataOfQulityCheck_Pm6(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ProductSpecificationSignOffSheet> getDataOfQulityCheck_Pm6(String sdate, String edate) {
    
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm6.dao.QulityCheckPm6Dao#getDataOfQulityCheck_Pm6(int)
	 */
	@Override
	public List<QulityCheck_Pm6> getDataOfQulityCheck_Pm6(int id) {
JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from tbl_QulityCheck_Pm5 where [id]=?";
		
		List<QulityCheck_Pm6> procedures=jdbcTemplate.query(sql, new Object[]{id},new RowMapper<QulityCheck_Pm6>(){

			@Override
			public QulityCheck_Pm6 mapRow(ResultSet rs, int arg1)
					throws SQLException {
				QulityCheck_Pm6 operatingProcedure=new QulityCheck_Pm6();
				operatingProcedure.setId(rs.getInt("id"));
				operatingProcedure.setTime(rs.getString("time"));
				operatingProcedure.setDate(new Date(rs.getTimestamp("date").getTime()));
				operatingProcedure.setGradecode(rs.getString("gradecode"));
				operatingProcedure.setCustomer(rs.getString("customer"));
				operatingProcedure.setSetnumber(rs.getString("setnumber"));
				operatingProcedure.setPosition(rs.getString("position"));
				operatingProcedure.setWidthofroll(rs.getString("widthofroll"));
				operatingProcedure.setDiameterofroll(rs.getString("diameterofroll"));
				operatingProcedure.setCore(rs.getString("core"));
				operatingProcedure.setCorrugation(rs.getString("corrugation"));
				operatingProcedure.setHoles(rs.getString("holes"));
				operatingProcedure.setEdgequlity(rs.getString("EdgeQulity"));
				operatingProcedure.setR1r2initial(rs.getString("r1r2initial"));
				operatingProcedure.setAuditerinitial(rs.getString("auditerinitial"));
				operatingProcedure.setMachinedown(rs.getString("machinedown"));
				operatingProcedure.setShift(rs.getString("shift"));
				operatingProcedure.setStime(rs.getTimestamp("stime"));
				operatingProcedure.setEtime(rs.getTimestamp("etime"));
				
				
				return operatingProcedure;
			}
			
		});
		
		return procedures;

	}

}
