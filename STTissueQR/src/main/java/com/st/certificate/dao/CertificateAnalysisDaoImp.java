package com.st.certificate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.certificate.model.Rewdinder;

@Repository
public class CertificateAnalysisDaoImp implements CertificateAnalysisDao {
	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;

	@Autowired
	private DataSource dataSource;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.certificate.dao.CertificateAnalysisDao#getCustomers()
	 */
	@Override
	public Rewdinder getRewinder() {

		Rewdinder rewdinder = new Rewdinder();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select DISTINCT([name]) from [customerDetail]";
		List<Map<String, Object>> customers = jdbcTemplate.queryForList(sql);
		rewdinder.setCustomers(customers);

		return rewdinder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.certificate.dao.CertificateAnalysisDao#getRewinders(java.util.Date,
	 * java.util.Date, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Rewdinder> getRewinders(Date dateFrom, Date dateTo, String customer, String grade) {

		Calendar scal = Calendar.getInstance();
		scal.setTime(dateFrom);
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		Calendar ecal = Calendar.getInstance();
		ecal.setTime(dateTo);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select[Reel],[GradeCode],[Customer] " + " from [reelTesting] where "
				+ " ([Date] between ? and  ? ) " + " and " + " [customer]=? " + " and " + " [GradeCode]=? "
				+ " group by [Reel],[GradeCode],[Customer]";

		List<Rewdinder> rewdinders = jdbcTemplate.query(sql, new Object[] { new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime()), customer, grade }, new RowMapper<Rewdinder>() {

					@Override
					public Rewdinder mapRow(ResultSet rs, int arg1) throws SQLException {
						Rewdinder rewdinder = new Rewdinder();
						rewdinder.setCustomer(rs.getString("Customer"));
						rewdinder.setReel(rs.getInt("Reel"));
						rewdinder.setGrade(rs.getString("GradeCode"));
						// rewdinder.setRollId(rs.getString("RewinderID"));
						return rewdinder;
					}
				});

		return rewdinders;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.certificate.dao.CertificateAnalysisDao#getRewindersGrade(java.lang.
	 * String)
	 */
	@Override
	public List<String> getRewindersGrade(Date dateFrom, Date dateTo, String customer) {

		Calendar scal = Calendar.getInstance();
		scal.setTime(dateFrom);
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		Calendar ecal = Calendar.getInstance();
		ecal.setTime(dateTo);
		ecal.add(Calendar.DAY_OF_WEEK, 1);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql2 = "select distinct([GradeCode]) from [reelTesting] where GradeCode is not NULL and [Customer]=? "
				+ " and [Date] between ? and ?";
				System.out.println(new Timestamp(scal.getTime().getTime())+""+ new Timestamp(ecal.getTime().getTime()));
		List<String> grades = jdbcTemplate.queryForList(sql2, new Object[] { customer,
				new Timestamp(scal.getTime().getTime()), new Timestamp(ecal.getTime().getTime())

		}, String.class);

		return grades;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.certificate.dao.CertificateAnalysisDao#getRewindersByReel(java.lang.
	 * String)
	 */
	/*
	 * @Override public List<Rewdinder> getRewindersByReel(String string) {
	 * JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceP);
	 * 
	 * 
	 * 
	 * String sql="select [RewinderID] " + " from [tblRewinderProduction] where "
	 * 
	 * + " [ReelNumber1]=? ";
	 * 
	 * 
	 * 
	 * 
	 * List<Rewdinder> rewdinders=jdbcTemplate.query(sql, new Object[]{
	 * 
	 * string }, new RowMapper<Rewdinder>() {
	 * 
	 * @Override public Rewdinder mapRow(ResultSet rs, int arg1) throws SQLException
	 * { Rewdinder rewdinder=new Rewdinder();
	 * 
	 * rewdinder.setRollId(rs.getString("RewinderID")); return rewdinder; } });
	 * 
	 * 
	 * 
	 * return rewdinders; }
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.certificate.dao.CertificateAnalysisDao#getRewindersByReel(java.lang.
	 * String, java.util.Date, java.util.Date)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.certificate.dao.CertificateAnalysisDao#getRewinderpm5()
	 */
	@Override
	public Rewdinder getRewinderpm5() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		final Rewdinder rewdinder = new Rewdinder();
		String sql = "select DISTINCT([name]) from [customerDetail]";

		
		List<Map<String, Object>> customers = jdbcTemplate.queryForList(sql);
		rewdinder.setCustomers(customers);

		/*
		 * Rewdinder rewdinder=new Rewdinder(); JdbcTemplate jdbcTemplate=new
		 * JdbcTemplate(dataSource); String
		 * sql="select distinct([Customer]) from tblRewinderProduction where Customer is not NULL"
		 * ; List<Map<String, Object>> customers=jdbcTemplate.queryForList(sql);
		 * rewdinder.setCustomers(customers);
		 */

		return rewdinder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.certificate.dao.CertificateAnalysisDao#getRewindersGradepm5(java.util.
	 * Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<String> getRewindersGradepm5(Date dateFrom, Date dateTo, String customer) {

		Calendar scal = Calendar.getInstance();
		scal.setTime(dateFrom);
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		Calendar ecal = Calendar.getInstance();
		ecal.setTime(dateTo);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql2 = "select distinct([GradeCode]) from [reelTesting_pm5] where GradeCode is not NULL and [Customer]=? "
				+ " and [Date] between ? and ?";

		List<String> grades = jdbcTemplate.queryForList(sql2, new Object[] { customer,
				new Timestamp(scal.getTime().getTime()), new Timestamp(ecal.getTime().getTime())

		}, String.class);

		return grades;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.certificate.dao.CertificateAnalysisDao#getRewinderspm5(java.util.Date,
	 * java.util.Date, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Rewdinder> getRewinderspm5(Date dateFrom, Date dateTo, String customer, String grade) {
		Calendar scal = Calendar.getInstance();
		scal.setTime(dateFrom);
		scal.set(Calendar.HOUR_OF_DAY, 6);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		Calendar ecal = Calendar.getInstance();
		ecal.setTime(dateTo);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select[Reel],[GradeCode],[Customer] " + " from [reelTesting_pm5] where "
				+ " ([Date] between ? and  ? ) " + " and " + " [customer]=? " + " and " + " [GradeCode]=? "
				+ " group by [Reel],[GradeCode],[Customer]";

		List<Rewdinder> rewdinders = jdbcTemplate.query(sql, new Object[] { new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime()), customer, grade }, new RowMapper<Rewdinder>() {

					@Override
					public Rewdinder mapRow(ResultSet rs, int arg1) throws SQLException {
						Rewdinder rewdinder = new Rewdinder();
						rewdinder.setCustomer(rs.getString("Customer"));
						rewdinder.setReel(rs.getInt("Reel"));
						rewdinder.setGrade(rs.getString("GradeCode"));
						// rewdinder.setRollId(rs.getString("RewinderID"));
						return rewdinder;
					}
				});

		return rewdinders;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.certificate.dao.CertificateAnalysisDao#getRewindersByReel(java.lang.
	 * String, java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<Rewdinder> getRewindersByReel(String string, Date dateFrom, Date dateTo, String customer) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceP);

		Calendar scal = Calendar.getInstance();
		scal.setTime(dateFrom);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		Calendar ecal = Calendar.getInstance();
		ecal.setTime(dateTo);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		String sql = "select [RewinderID] "
				+ " from [tblRewinderProduction] where [DateTimeEntered] between ? and ? and  "

				+ " [ReelNumber1]=? and [RewinderNumber]='RW6'";

		List<Rewdinder> rewdinders = jdbcTemplate.query(sql, new Object[] { new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime()), string }, new RowMapper<Rewdinder>() {

					@Override
					public Rewdinder mapRow(ResultSet rs, int arg1) throws SQLException {
						Rewdinder rewdinder = new Rewdinder();

						rewdinder.setRollId(rs.getString("RewinderID"));
						return rewdinder;
					}
				});

		return rewdinders;
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.dao.CertificateAnalysisDao#getRewindersByReel(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Rewdinder> getRewindersByReel(String string, Date dateFrom, Date dateTo) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.dao.CertificateAnalysisDao#getRewindersGradeWithReelpm5(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<Rewdinder> getRewindersGradeWithReelpm6(Date sDate, Date eDate, String customer) {
		Calendar scal = Calendar.getInstance();
		scal.setTime(sDate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		Calendar ecal = Calendar.getInstance();
		ecal.setTime(eDate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select[Reel],[Customer] from [reelTesting] where ([Date] between ? and  ? ) and [Customer]=? group by [Reel],[Customer]";
			
try {
	
 	List<Rewdinder> rewdinders = jdbcTemplate.query(sql, new Object[] { new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime()), customer }, new RowMapper<Rewdinder>() {
	

					@Override
					public Rewdinder mapRow(ResultSet rs, int arg1) throws SQLException {
						
						Rewdinder rewdinder = new Rewdinder();
						try {
						
							rewdinder.setCustomer(rs.getString("Customer"));
							rewdinder.setReel(rs.getInt("Reel"));
							//rewdinder.setGrade(rs.getString("GradeCode"));
							// rewdinder.setRollId(rs.getString("RewinderID"));
							
						} catch (Exception e) {
							System.out.println("***reeor"+e);
						}
						
						return rewdinder;
						
					}
				});
 	return rewdinders;
}catch (Exception e) {
	System.out.println("***reeor"+e);
                     }
return null;
	
		

		
	}
	@Override
	public List<Rewdinder> getCustomers(Date eDate, Date sDate) {
		Calendar scal = Calendar.getInstance();
		scal.setTime(eDate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		Calendar ecal = Calendar.getInstance();
		ecal.setTime(sDate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select DISTINCT [Customer] from [reelTesting] where ([Date] between ? and  ? )";
			
try {
	
 	List<Rewdinder> rewdinders = jdbcTemplate.query(sql, new Object[] { new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime())}, new RowMapper<Rewdinder>() {
	

					@Override
					public Rewdinder mapRow(ResultSet rs, int arg1) throws SQLException {
						
						Rewdinder rewdinder = new Rewdinder();
						try {
						
							rewdinder.setCustomer(rs.getString("Customer"));							
						} catch (Exception e) {
							System.out.println("***reeor"+e);
						}
						
						return rewdinder;
						
					}
				});
 	return rewdinders;
}catch (Exception e) {
	System.out.println("***reeor"+e);
                     }
return null;
	
		

		
	}
	/* (non-Javadoc)
	 * @see com.st.certificate.dao.CertificateAnalysisDao#getRewindersGradeWithReelpm6(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<Rewdinder> getRewindersGradeWithReelpm5(Date sDate, Date eDate, String customer) {
		Calendar scal = Calendar.getInstance();
		scal.setTime(sDate);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		Calendar ecal = Calendar.getInstance();
		ecal.setTime(eDate);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println(new Timestamp(scal.getTime().getTime())+"  "+new Timestamp(ecal.getTime().getTime()));
		String sql = "select[Reel],[Customer] from [reelTesting_pm5] where ([Date] between ? and  ? ) and [Customer]=? group by [Reel],[Customer]";
			
try {
	
 	List<Rewdinder> rewdinders = jdbcTemplate.query(sql, new Object[] { new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime()), customer }, new RowMapper<Rewdinder>() {
	

					@Override
					public Rewdinder mapRow(ResultSet rs, int arg1) throws SQLException {
						
						Rewdinder rewdinder = new Rewdinder();
						try {
						
							rewdinder.setCustomer(rs.getString("Customer"));
							rewdinder.setReel(rs.getInt("Reel"));
							//rewdinder.setGrade(rs.getString("GradeCode"));
							// rewdinder.setRollId(rs.getString("RewinderID"));
							
						} catch (Exception e) {
							System.out.println("***reeor"+e);
						}
						
						return rewdinder;
						
					}
				});
 	return rewdinders;
}catch (Exception e) {
	System.out.println("***reeor"+e);
                     }
return null;
	
		

		
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.dao.CertificateAnalysisDao#getRewindersByReel_Pm5(java.lang.String, java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<Rewdinder> getRewindersByReel_Pm5(String reel, Date dateTo, Date dateFrom, String customer) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceP);

		Calendar scal = Calendar.getInstance();
		scal.setTime(dateFrom);
		scal.set(Calendar.HOUR_OF_DAY, 7);
		scal.set(Calendar.MINUTE, 0);
		scal.set(Calendar.SECOND, 0);
		scal.set(Calendar.MILLISECOND, 0);

		Calendar ecal = Calendar.getInstance();
		ecal.setTime(dateTo);
		ecal.set(Calendar.HOUR_OF_DAY, 6);
		ecal.set(Calendar.MINUTE, 59);
		ecal.set(Calendar.SECOND, 59);
		ecal.set(Calendar.MILLISECOND, 0);
		ecal.add(Calendar.DATE, 1);
		String sql = "select [RewinderID] "
				+ " from [tblRewinderProduction] where [DateTimeEntered] between ? and ? and  "

				+ " [ReelNumber1]=? and [RewinderNumber]='RW5'";

		List<Rewdinder> rewdinders = jdbcTemplate.query(sql, new Object[] { new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime()), reel}, new RowMapper<Rewdinder>() {

					@Override
					public Rewdinder mapRow(ResultSet rs, int arg1) throws SQLException {
						Rewdinder rewdinder = new Rewdinder();

						rewdinder.setRollId(rs.getString("RewinderID"));
						return rewdinder;
					}
				});

		return rewdinders;
	}

	/* (non-Javadoc)
	 * @see com.st.certificate.dao.CertificateAnalysisDao#getCustMails(java.lang.String)
	 */
	@Override
	public String getCustMails(String customer) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select emails from autoFiringMails where [customerName]=?";
		String emails = jdbcTemplate.queryForObject(sql, new Object[] {customer },String.class);
		return emails;
	}

	
	

}
