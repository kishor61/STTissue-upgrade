/**
 *Mar 27, 2018
 *IncidentalDaoImp.java
 * TODO
 *com.st.incidental.dao
 *IncidentalDaoImp.java
 *Roshan Lal Tailor
 */
package com.st.incidental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.common.Columns;
import com.st.incidental.model.Incidental;
import com.st.wastepaper.model.WastepaperDetail;

/**
 * @author roshan
 *
 */
@Repository
public class IncidentalDaoImp implements IncidentalDao{

	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#getUserAutiors()
	 */
	@Override
	public List<Incidental> getUserAutiors() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [tbl_Incidental_User] order by name";
		List<Incidental> autiors=jdbcTemplate.query(sql, new RowMapper<Incidental>(){

			@Override
			public Incidental mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Incidental autior=new Incidental();
				autior.setId(rs.getInt("ID"));
				autior.setName(rs.getString("name"));
				autior.setEmail(rs.getString("email"));
				autior.setStatus(rs.getString("status"));
				
				return autior;
			}
			
		});
		
		return autiors;
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#saveOrUpdate(com.st.incidental.model.Incidental)
	 */
	@Override
	public void saveOrUpdate(Incidental auditor) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		if(auditor.getId()==0){
			String sql="insert into [tbl_Incidental_User]("
					+ "[name],"
					+ "[email],"
					+ "[status]"
					+ ") values(?,?,?)";
			jdbcTemplate.update(sql, new Object[]{auditor.getName(),auditor.getEmail(),"Active"});
		}else{
			String sql="update [tbl_Incidental_User] set "
					+ "[name]=?,"
					+ "[email]=? "
					+ " where [ID]=?";
			jdbcTemplate.update(sql, new Object[]{auditor.getName(),auditor.getEmail(),auditor.getId()});
		}
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#getUserAuditor(int)
	 */
	@Override
	public Incidental getUserAuditor(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [tbl_Incidental_User] where [ID]=? ";
		Incidental autior=jdbcTemplate.queryForObject(sql,new Object[]{id}, new RowMapper<Incidental>(){

			@Override
			public Incidental mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Incidental autior=new Incidental();
				autior.setId(rs.getInt("ID"));
				autior.setName(rs.getString("name"));
				autior.setEmail(rs.getString("email"));
				
				return autior;
			}
			
		});
		return autior;
		
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#editAuditorStatus(com.st.incidental.model.Incidental)
	 */
	@Override
	public void editAuditorStatus(final Incidental data) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		final String sql="update [tbl_Incidental_User] set "
				+"[status]=?"
				+ " where [email]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setString(1, data.getStatus());
				statement.setString(2, data.getEmail());
				return statement;
			}
		});
		
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#uploadDocuments(com.st.incidental.model.Incidental)
	 */
	@Override
	public void uploadDocuments(Incidental auditor) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		if(auditor.getId()==0){
			String sql="insert into tbl_Incidental_Documents ("
					+ "date,"
					+ "documents,"
					+ "comment,"
					+ "docid,"
					+ "description"
					+ ") values(?,?,?,?,?)";
			jdbcTemplate.update(sql,new Object[]{
					auditor.getDate(),
					auditor.getFile(),
					auditor.getComment(),
					auditor.getDocid(),
					auditor.getDescription()
			});
			System.out.println(sql);
		}else{
			if(StringUtils.isEmpty(auditor.getFile())){
				String sql="update tbl_Incidental_Documents set "
						+ "[date]=?,"
						+ "[documents]=?,"
						+ "[comment]=?,"
						+ "[description]=? "
						+ " where [ID]=?";
				jdbcTemplate.update(sql,new Object[]{
						auditor.getDate(),
						auditor.getFile(),
						auditor.getComment(),
						auditor.getDescription(),
						auditor.getId()
				});
			}else{
				String sql="update tbl_Incidental_Documents set "
						+ "[date]=?,"
						+ "[documents]=?,"
						+ "[comment]=?,"
						+ "[description]=? "
						+ " where [ID]=?";
				jdbcTemplate.update(sql,new Object[]{
						auditor.getDate(),
						auditor.getFile(),
						auditor.getComment(),
						auditor.getDescription(),
						auditor.getId()
				});
			}
		}
		/*try{
			String useremail=ufp.getEmail();
			String productName=ufp.getName();
			String phNumber=ufp.getPhonenumber();
			String pid=ufp.getPid();
			
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("tailor.roshanamity.roshan@gmail.com", "*99***1#ISRO"));
			email.setStartTLSEnabled(true);
			email.setSSLOnConnect(true);
			email.setFrom("tailor.roshanamity.roshan@gmail.com");
			email.setSubject(pid+" New Product Add Into Data Base");
			email.setMsg(pid+" Added Into Your Database.");
			email.addTo(useremail);
			email.setDebug(true);
			email.send();
			
		}catch(Exception rlt){
			System.out.println("Error Whhile sending Email.");
			rlt.printStackTrace();
		}
		try{
			String useremail=ufp.getEmail();
			String productName=ufp.getName();
			String phNumber=ufp.getPhonenumber();
			String pid=ufp.getPid();
			
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("tailor.roshanamity.roshan@gmail.com", "*99***1#ISRO"));
			email.setStartTLSEnabled(true);
			email.setSSLOnConnect(true);
			email.setFrom("tailor.roshanamity.roshan@gmail.com");
			email.setSubject(pid+" New Product Add Into Data Base");
			email.setMsg(pid+" Added Into Your Database.");
			email.addTo("ebizerajay@hotmail.com");
			email.setDebug(true);
			email.send();
			
		}catch(Exception rlt){
			System.out.println("Error Whhile sending Email.");
			rlt.printStackTrace();
		}*/
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#getIncidentalReportData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Incidental> getIncidentalReportData(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [tbl_Incidental_Documents] where date between ? and ? ";
		List<Incidental> autiors=jdbcTemplate.query(sql,new Object[]{sdate,edate},new RowMapper<Incidental>(){

			@Override
			public Incidental mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Incidental autior=new Incidental();
				autior.setId(rs.getInt("ID"));
				autior.setDate(new Date(rs.getTimestamp("date").getTime()));
				autior.setFile(rs.getString("documents"));
				autior.setComment(rs.getString("comment"));
				autior.setDescription(rs.getString("Description"));
				
				return autior;
			}
			
		});
		
		return autiors;
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#getUploadedFileById(int)
	 */
	@Override
	public List<Incidental> getUploadedFileById(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [tbl_Incidental_Documents] where id=?";
		List<Incidental> autiors=jdbcTemplate.query(sql,new Object[]{id}, new RowMapper<Incidental>(){

			@Override
			public Incidental mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Incidental autior=new Incidental();
				autior.setId(rs.getInt("ID"));
				autior.setDate(new Date(rs.getTimestamp("date").getTime()));
				autior.setFile(rs.getString("documents"));
				autior.setComment(rs.getString("comment"));
				autior.setDescription(rs.getString("Description"));
				
				return autior;
			}
			
		});
		
		return autiors;
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#getLastUplodedDocId(java.lang.String)
	 */
	@Override
	public int getLastUplodedDocId(String docid) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int OpeningVacation =0;
		try{
			String query = "select [id] from [tbl_Incidental_Documents] where [docid]=?"; 
	        Object[] inputs = new Object[] {docid};
	        OpeningVacation = jdbcTemplate.queryForObject(query, inputs, Integer.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return OpeningVacation;
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#reviewAction(com.st.incidental.model.Incidental)
	 */
	@Override
	public void reviewAction(Incidental incidental) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		/*if(incidental.getId()==0){
			String sql="insert into [tbl_Incidental_Documents_ReviewedAction]("
					+ "[docid],"
					+ "[date],"
					+ "[name],"
					+ "[comment]"
					+ ") values(?,?,?,?)";
			jdbcTemplate.update(sql, new Object[]{incidental.getId(),incidental.getDate(),incidental.getName(),incidental.getComment()});
		}else{
			String sql="update [tbl_Incidental_Documents_ReviewedAction] set "
					+ "[date]=?,"
					+ "[name]=?,"
					+ "[comment]=? "
					+ " where [ID]=?";
			jdbcTemplate.update(sql, new Object[]{incidental.getDate(),incidental.getName(),incidental.getComment(),incidental.getId()});
		}*/
		
		String sql="insert into [tbl_Incidental_Documents_ReviewedAction]("
				+ "[docid],"
				+ "[date],"
				+ "[name],"
				+ "[comment]"
				+ ") values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{incidental.getId(),incidental.getDate(),incidental.getName(),incidental.getComment()});
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#checkDocumentIsReviewdOrNot(java.lang.String, int)
	 */
	@Override
	public double checkDocumentIsReviewdOrNot(String name, int id) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		double count =0;
		try{
			String query = "select COUNT(*) as count from [tbl_Incidental_Documents_ReviewedAction] where name=? and docid=? "; 
	        Object[] inputs = new Object[] {name,id};
	        count = jdbcTemplate.queryForObject(query, inputs, Double.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return count;
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#getReportReviewedActionsShow(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Incidental> getReportReviewedActionsShow(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		List<Incidental> datas= new ArrayList<Incidental>();
		
		String sql="select * from  tbl_Incidental_Documents where date between ? and ? order by id";
		List<Map<String, Object>> maps=jdbcTemplate.queryForList(sql, new Object[]{sdate,edate});
		
		if(maps.size()>0){
		for (Map<String, Object> map : maps) {
			final Incidental data=new Incidental();
			
			int id=(int)map.get("id");
			Date dateDocUpload=(Date)map.get("date");
			String subject=(String)map.get("comment");
			String docid=(String)map.get("docid");
			String description=(String)map.get("description");
			
			data.setId(id);
			data.setDate(dateDocUpload);
			data.setSubject(subject);
			data.setDocid(docid);
			data.setDescription(description);
			
			String notrevieduser="";
			try{
				
				String sql1="SELECT t1.name as notrevieduser "
						+ "FROM tbl_Incidental_User t1  where t1.name NOT IN "
						+ " ( "
						+ " SELECT b.name "
						+ " FROM tbl_Incidental_Documents as a JOIN tbl_Incidental_Documents_ReviewedAction as b "
						+ " ON b.docid = a.id where a.date between ? and ? "
						+ " ) ";
				List<Map<String, Object>> maps1=jdbcTemplate.queryForList(sql1, new Object[]{sdate,edate});
				for (Map<String, Object> map1 : maps1) {
					notrevieduser=(String)map1.get("notrevieduser")+","+notrevieduser;
				}
				
			}catch(Exception rlt){
				rlt.printStackTrace();
			}
			
			data.setNotrevieduser(notrevieduser);
			datas.add(data);
			
			/*try{
				
				String sql1="select * from  tbl_Incidental_Documents_ReviewedAction where docid=? ";
				List<Map<String, Object>> maps1=jdbcTemplate.queryForList(sql1, new Object[]{data.getId()});
				for (Map<String, Object> map1 : maps1) {
					
					Date reviewdate=(Date)map1.get("date");
					String name=(String)map1.get("name");
					String comment=(String)map1.get("comment");
					
					data.setReviewdate(reviewdate);
					data.setName(name);
					data.setComment(comment);
					
					datas.add(data);
				}
			}catch(Exception rlt){
				System.out.println("Roshan, Says You Have An Error At getReportReviewedActionsShow Method In IncidentalDaoImp.java");
				rlt.printStackTrace();
			}*/
		}
		}
		return datas;
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#getReportReviewedActionsShow_Comment()
	 */
	@Override
	public List<Incidental> getReportReviewedActionsShow_Comment() {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		List<Incidental> datas= new ArrayList<Incidental>();
		
		try{
		
		String sql1="select * from  tbl_Incidental_Documents_ReviewedAction order by id";
		List<Map<String, Object>> maps1=jdbcTemplate.queryForList(sql1, new Object[]{});
		for (Map<String, Object> map1 : maps1) {
			
			final Incidental data=new Incidental();
			
			Date reviewdate=(Date)map1.get("date");
			String name=(String)map1.get("name");
			String comment=(String)map1.get("comment");
			int docid=(int)map1.get("docid");
			
			data.setReviewdate(reviewdate);
			data.setName(name);
			data.setComment(comment);
			data.setId(docid);
			
			datas.add(data);
		}
	}catch(Exception rlt){
		System.out.println("Roshan, Says You Have An Error At getReportReviewedActionsShow Method In IncidentalDaoImp.java");
		rlt.printStackTrace();
	}
		return datas;
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#getUserAutiors_Active()
	 */
	@Override
	public List<Incidental> getUserAutiors_Active() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [tbl_Incidental_User] where status='Active' ";
		List<Incidental> autiors=jdbcTemplate.query(sql, new RowMapper<Incidental>(){

			@Override
			public Incidental mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Incidental autior=new Incidental();
				autior.setId(rs.getInt("ID"));
				autior.setName(rs.getString("name"));
				autior.setEmail(rs.getString("email"));
				autior.setStatus(rs.getString("status"));
				
				return autior;
			}
			
		});
		
		return autiors;
	}

	/* (non-Javadoc)
	 * @see com.st.incidental.dao.IncidentalDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [tbl_Incidental_Documents] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
		
	}

}
