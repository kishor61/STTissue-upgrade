/**
 *Oct 12, 2017
 *ManintenanceLogCr6Pm6FrpDaoImp.java
 * TODO
 *com.st.manintenancelogcr6pm6frp.dao
 *ManintenanceLogCr6Pm6FrpDaoImp.java
 *Roshan Lal Tailor
 */
package com.st.manintenancelogcr6pm6frp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.st.manintenancelogcr6pm6frp.mapper.ManintenanceLogCr6Pm6FrpFullDataMapper;
import com.st.manintenancelogcr6pm6frp.mapper.ManintenanceLogCr6Pm6FrpMapper;
import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp;
import com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6FrpArea;
import com.st.qualitypm6.mapper.GradeMapper;
import com.st.qualitypm6.model.Grade;

/**
 * @author roshan
 *
 */
@Repository
public class ManintenanceLogCr6Pm6FrpDaoImp implements ManintenanceLogCr6Pm6FrpDao{

	private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	
	private SimpleDateFormat dateFormat1= new SimpleDateFormat("MM-dd-yyyy");
	
	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.dao.ManintenanceLogCr6Pm6FrpDao#save(com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6FrpArea)
	 */
	@Override
	public int save(ManintenanceLogCr6Pm6FrpArea ar) {
		// TODO Auto-generated method stub

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "INSERT INTO [tbl_ManintenanceLogCr6Pm6FrpArea](name,description,usertype) VALUES(?,?,?)";

		int i = jdbcTemplate.update(sql, new Object[] { ar.getName(),ar.getDescription(),ar.getUsertype() });

		return i;

	}

	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.dao.ManintenanceLogCr6Pm6FrpDao#getGrades()
	 */
	@Override
	public List<ManintenanceLogCr6Pm6Frp> getGrades() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String target="";
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {target=authority.getAuthority();}
		
		String sql="select * from [tbl_ManintenanceLogCr6Pm6FrpArea] where usertype=? order by name";
		List<ManintenanceLogCr6Pm6Frp> grades=jdbcTemplate.query(sql,new Object[]{
				target
		}, new ManintenanceLogCr6Pm6FrpMapper());
		return grades;
	}

	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.dao.ManintenanceLogCr6Pm6FrpDao#save(com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp)
	 */
	@Override
	public int save(ManintenanceLogCr6Pm6Frp data) {
		// TODO Auto-generated method stub
 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "INSERT INTO [tbl_ManintenanceLogCr6Pm6Frp] ([date],[ProdTypeOrGradeCode],[area],[error],[comments],[usertype],[team],[shift])"
				+ "VALUES(?,?,?,?,?,?,?,?)";

		int i = jdbcTemplate.update(
				sql,
				new Object[] { 
						data.getDate(),
						data.getProdtypeorgradecode(),
						data.getArea(),
						data.getError(),
						data.getComments(),
						data.getUsertype(),
						data.getTeam(),
						data.getShift()
						});

		 System.out.println("i"+i); 
		return i;

	}

	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.dao.ManintenanceLogCr6Pm6FrpDao#update(com.st.manintenancelogcr6pm6frp.model.ManintenanceLogCr6Pm6Frp)
	 */
	@Override
	public void update(final ManintenanceLogCr6Pm6Frp data) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [tbl_ManintenanceLogCr6Pm6Frp] set "
				+"[date]=?,"
				+"[ProdTypeOrGradeCode]=?,"
				+"[area]=?,"
				+"[error]=?,"
				+"[comments]=?,"
				//+"[usertype]=?,"
				+"[team]=?,"
				+"[shift]=?"
				+ " where [ID]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
 
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setTimestamp(1, new Timestamp(data.getDate().getTime()));
				statement.setString(2, data.getProdtypeorgradecode());
				statement.setString(3, data.getArea());
				statement.setString(4, data.getError());
				statement.setString(5, data.getComments());
				//statement.setString(6, data.getUsertype());
				
				statement.setString(6, data.getTeam());
				statement.setString(7, data.getShift());
				
				statement.setInt(8, data.getId());
				return statement;
			}
		});
	 	
	}

	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.dao.ManintenanceLogCr6Pm6FrpDao#getCurrentDateData(java.util.Date)
	 */
	@Override
	public List<ManintenanceLogCr6Pm6Frp> getCurrentDateData(Date sdate,String shift) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		final Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		final Calendar ecal=Calendar.getInstance();
		ecal.setTime(sdate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		String target="";
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {target=authority.getAuthority();}
		
		String sql=" select * from [tbl_ManintenanceLogCr6Pm6Frp] where usertype=? and shift=? and date between ? and ? order by date";
		List<ManintenanceLogCr6Pm6Frp> grades=jdbcTemplate.query(sql,new Object[]{
				target,
				shift,
				new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime())
		}, new ManintenanceLogCr6Pm6FrpFullDataMapper());
		return grades;
	}

	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.dao.ManintenanceLogCr6Pm6FrpDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="delete from [tbl_ManintenanceLogCr6Pm6Frp] where "
				+ " [ID]=?";
		
		jdbcTemplate.update(sql, new Object[]{id});
	}

	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.dao.ManintenanceLogCr6Pm6FrpDao#getArea_ForJSON()
	 */
	@Override
	public List<Map<String, Object>> getArea_ForJSON() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

		//String sql="select [GradeCode] from grade order by GradeCode";
		String sql="  select w.GradeCode from( "
				+ "SELECT GradeCode FROM grade "
				+ " UNION "
					+ " SELECT GradeCode FROM grade_PM5 "
				 + " ) as w group by w.GradeCode";
		
		List<Map<String, Object>> clGrades = jdbcTemplate.queryForList(sql);
		return clGrades;

	}

	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.dao.ManintenanceLogCr6Pm6FrpDao#getDateBetweenData(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ManintenanceLogCr6Pm6Frp> getDateBetweenData(String sdate, String edate,String userType) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Date s=null;
		try {
			s = dateFormat1.parse(sdate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date e=null;
		try {
			e = dateFormat1.parse(edate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		final Calendar scal=Calendar.getInstance();
		scal.setTime(s);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		final Calendar ecal=Calendar.getInstance();
		ecal.setTime(e);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		String target="";
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {target=authority.getAuthority();}
		
		String sql="";
		 List<ManintenanceLogCr6Pm6Frp> grades= null;
		if(target.equalsIgnoreCase("pm") || target.equalsIgnoreCase("OPERATOR4") || target.equalsIgnoreCase("ADMIN")){
			if(userType.equalsIgnoreCase("ALL")){
				sql="select "
				 		+ "	id,"
				 		+ " date,"
				 		+ " ProdTypeOrGradeCode,area,"
				 		+ " error,"
				 		+ " comments,"
				 		+ " usertype,"
				 		+ " team,"
				 		+ " shift from [tbl_ManintenanceLogCr6Pm6Frp] as p where  p.date "
				 		+ " BETWEEN ? and ? and (shift='Day' or shift='Night')  order by CONVERT(date, date) ASC,shift ASC";
				 grades=jdbcTemplate.query(sql,new Object[]{
						 new Timestamp(scal.getTime().getTime()),
						 new Timestamp(ecal.getTime().getTime())
				 }, new ManintenanceLogCr6Pm6FrpFullDataMapper());
			} else{
				sql="select "
				 		+ "	id,"
				 		+ " date,"
				 		+ " ProdTypeOrGradeCode,area,"
				 		+ " error,"
				 		+ " comments,"
				 		+ " usertype,"
				 		+ " team,"
				 		+ " shift from [tbl_ManintenanceLogCr6Pm6Frp] as p where  p.date "
				 		+ " BETWEEN ? and ? and (shift='Day' or shift='Night') and [usertype]=? order by CONVERT(date, date) ASC,shift ASC";
				 grades=jdbcTemplate.query(sql,new Object[]{
						 new Timestamp(scal.getTime().getTime()),
						 new Timestamp(ecal.getTime().getTime()),
						 userType
				 }, new ManintenanceLogCr6Pm6FrpFullDataMapper());
			}
			
		}else{
			// sql="  select * from [tbl_ManintenanceLogCr6Pm6Frp] as p where p.usertype=? And p.date BETWEEN ? and ?  and (shift='Day' or shift='Night')  order by date";
			if(userType.equalsIgnoreCase("ALL")){
				sql="select "
				 		+ "	id,"
				 		+ " date,"
				 		+ " ProdTypeOrGradeCode,area,"
				 		+ " error,"
				 		+ " comments,"
				 		+ " usertype,"
				 		+ " team,"
				 		+ " shift from [tbl_ManintenanceLogCr6Pm6Frp] as p where  p.usertype=? And p.date "
				 		+ " BETWEEN ? and ? and (shift='Day' or shift='Night')  order by CONVERT(date, date) ASC,shift ASC";
			 grades=jdbcTemplate.query(sql,new Object[]{
					 target,
					 new Timestamp(scal.getTime().getTime()),
					 new Timestamp(ecal.getTime().getTime())
			}, new ManintenanceLogCr6Pm6FrpFullDataMapper());
			}else{
				sql="select "
				 		+ "	id,"
				 		+ " date,"
				 		+ " ProdTypeOrGradeCode,area,"
				 		+ " error,"
				 		+ " comments,"
				 		+ " usertype,"
				 		+ " team,"
				 		+ " shift from [tbl_ManintenanceLogCr6Pm6Frp] as p where  p.usertype=? And p.date "
				 		+ " BETWEEN ? and ? and (shift='Day' or shift='Night') and [usertype]=? order by CONVERT(date, date) ASC,shift ASC";
			 grades=jdbcTemplate.query(sql,new Object[]{
					 target,
					 new Timestamp(scal.getTime().getTime()),
					 new Timestamp(ecal.getTime().getTime()),
					 userType
			}, new ManintenanceLogCr6Pm6FrpFullDataMapper());
			} 
			

		}
		
		return grades;
	}

	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.dao.ManintenanceLogCr6Pm6FrpDao#getDateBetweenData_Email(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ManintenanceLogCr6Pm6Frp> getDateBetweenData_Email(String sdate, String edate,String operator) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Date s=null;
		try {
			s = dateFormat1.parse(sdate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date e=null;
		try {
			e = dateFormat1.parse(edate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		final Calendar scal=Calendar.getInstance();
		scal.setTime(s);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		final Calendar ecal=Calendar.getInstance();
		ecal.setTime(e);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		//ecal.add(Calendar.DATE, -1);
		ecal.add(Calendar.DATE, 0);
		String sql="";
		 List<ManintenanceLogCr6Pm6Frp> grades= null;
		if(operator.equalsIgnoreCase("ALL") || operator==""){
			//This is For CR6
			sql="select "
			 		+ "	id,"
			 		+ " date,"
			 		+ " ProdTypeOrGradeCode,area,"
			 		+ " error,"
			 		+ " comments,"
			 		+ " usertype,"
			 		+ " team,"
			 		+ " shift from [tbl_ManintenanceLogCr6Pm6Frp] as p where  p.date "
			 		+ " BETWEEN ? and ? and (shift='Day' or shift='Night') and p.usertype<>'OPERATOR6' order by CONVERT(date, date) ASC,shift ASC";
			 grades=jdbcTemplate.query(sql,new Object[]{
					 new Timestamp(scal.getTime().getTime()),
					 new Timestamp(ecal.getTime().getTime())
			 }, new ManintenanceLogCr6Pm6FrpFullDataMapper());
		}else{
			//This Is For CR5
			sql="select "
			 		+ "	id,"
			 		+ " date,"
			 		+ " ProdTypeOrGradeCode,area,"
			 		+ " error,"
			 		+ " comments,"
			 		+ " usertype,"
			 		+ " team,"
			 		+ " shift from [tbl_ManintenanceLogCr6Pm6Frp] as p where  p.date "
			 		+ " BETWEEN ? and ? and (shift='Day' or shift='Night') and p.usertype='OPERATOR6' order by CONVERT(date, date) ASC,shift ASC";
			 grades=jdbcTemplate.query(sql,new Object[]{
					 new Timestamp(scal.getTime().getTime()),
					 new Timestamp(ecal.getTime().getTime())
			 }, new ManintenanceLogCr6Pm6FrpFullDataMapper());
		}
		 
		return grades;
	}

	/* (non-Javadoc)
	 * @see com.st.manintenancelogcr6pm6frp.dao.ManintenanceLogCr6Pm6FrpDao#getCurrentDateDataShiftWise(java.util.Date, java.lang.String)
	 */
	@Override
	public List<ManintenanceLogCr6Pm6Frp> getCurrentDateDataShiftWise(Date sdate, String shift) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		final Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);
		
		final Calendar ecal=Calendar.getInstance();
		ecal.setTime(sdate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		
		String target="";
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {target=authority.getAuthority();}
		
		List<ManintenanceLogCr6Pm6Frp> grades=null;
		String sql="";
		
		if(shift.equalsIgnoreCase("All")){
			//usertype=? and
			sql=" select * from [tbl_ManintenanceLogCr6Pm6Frp] where  date between ? and ? order by date";
			grades=jdbcTemplate.query(sql,new Object[]{
					//target,
					new Timestamp(scal.getTime().getTime()),
					new Timestamp(ecal.getTime().getTime())
			}, new ManintenanceLogCr6Pm6FrpFullDataMapper());	
		}else{
			sql=" select * from [tbl_ManintenanceLogCr6Pm6Frp] where shift=? and date between ? and ? order by date";
			grades=jdbcTemplate.query(sql,new Object[]{
					//target,
					shift,
					new Timestamp(scal.getTime().getTime()),
					new Timestamp(ecal.getTime().getTime())
			}, new ManintenanceLogCr6Pm6FrpFullDataMapper());
		}
		return grades;
	}

}
