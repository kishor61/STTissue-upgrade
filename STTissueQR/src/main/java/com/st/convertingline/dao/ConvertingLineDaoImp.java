/**
 *Mar 25, 2017
 *ConvertingLineDaoImp.java
 * TODO
 *com.st.convertingline.dao
 *ConvertingLineDaoImp.java
 *Roshan Lal Tailor
 */
package com.st.convertingline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import productspecificationsignoffsheet.ProductSpecificationSignOffSheet;
import com.st.common.CommonUtil;
import com.st.convertingline.mapper.ConvertingLineMapper;
import com.st.convertingline.mapper.ConvertingLineMapperForCasteData;
import com.st.convertingline.mapper.ConvertingLineMapperForCasteDataGroupBySKUCode;
import com.st.convertingline.model.ConvertingLine;
import com.st.convertingline.model.ConvertingPackagerObcc;
import com.st.convertingline.model.RewinderAndUnwindStand;

/**
 * @author roshan
 *
 */
@Repository
public class ConvertingLineDaoImp implements ConvertingLineDao {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

	private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

	@Autowired
	private DataSource dataSource;

	@Autowired
	@Qualifier("dataSourceProduction")
	private DataSource dataSourceP;

	@Autowired
	private DataSource dataSourceQRT;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#getAllCustName()
	 */
	@Override
	public List<ConvertingLine> getAllCustName() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceP);
		String sql = "SELECT Customer as name FROM tlkpCustomerConv where Customer <>''  group by Customer order by Customer";
		List<ConvertingLine> procedures = jdbcTemplate.query(sql, new RowMapper<ConvertingLine>() {

			@Override
			public ConvertingLine mapRow(ResultSet rs, int arg1) throws SQLException {
				ConvertingLine operatingProcedure = new ConvertingLine();
				operatingProcedure.setCustomer(rs.getString("name"));
				return operatingProcedure;
			}

		});

		return procedures;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#getAllSkuCode()
	 */
	@Override
	public List<ConvertingLine> getAllSkuCode() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from sku_productCode order by product_code";

		List<ConvertingLine> procedures = jdbcTemplate.query(sql, new RowMapper<ConvertingLine>() {

			@Override
			public ConvertingLine mapRow(ResultSet rs, int arg1) throws SQLException {
				ConvertingLine operatingProcedure = new ConvertingLine();
				operatingProcedure.setId(rs.getInt("ID"));
				operatingProcedure.setProductcode(rs.getString("product_code"));
				return operatingProcedure;
			}

		});

		return procedures;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#save(com.st.convertingline.model.
	 * ConvertingLine)
	 */
	@Override
	public int save(final ConvertingLine data) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		final String sql = "insert into [tbl_ComplaintLine_Cust_Projections]" + "(" + "[Date]," + "[custname],"
				+ "[skucode]," + "[January]," + "[February]," + "[March]," + "[April]," + "[May]," + "[June],"
				+ "[July]," + "[August]," + "[September]," + "[October]," + "[November]," + "[December] )"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				PreparedStatement statement = arg0.prepareStatement(sql, new String[] { "ID" });

				statement.setTimestamp(1, new Timestamp(data.getDate().getTime()));
				statement.setString(2, data.getCustomer());
				statement.setString(3, data.getSkucode());
				statement.setDouble(4, data.getJanuary());
				statement.setDouble(5, data.getFebruary());
				statement.setDouble(6, data.getMarch());
				statement.setDouble(7, data.getApril());
				statement.setDouble(8, data.getMay());
				statement.setDouble(9, data.getJune());
				statement.setDouble(10, data.getJuly());
				statement.setDouble(11, data.getAugust());
				statement.setDouble(12, data.getSeptember());
				statement.setDouble(13, data.getOctober());
				statement.setDouble(14, data.getNovember());
				statement.setDouble(15, data.getDecember());
				return statement;
			}
		}, keyHolder);

		return keyHolder.getKey().intValue();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#update(com.st.convertingline.
	 * model.ConvertingLine)
	 */
	@Override
	public void update(final ConvertingLine data) {
		System.out.println(data.getCustomer());
		String sql = "update [tbl_ComplaintLine_Cust_Projections] SET "

				+ "[date]=?," + "[custname]=?," + "[skucode]=?," + "[January]=?," + "[February]=?," + "[March]=?,"
				+ "[April]=?," + "[May]=?," + "[June]=?," + "[July]=?," + "[August]=?," + "[September]=?,"
				+ "[October]=?," + "[November]=?," + "[December]=? " + " where [ID]=?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException {
				statement.setTimestamp(1, new Timestamp(data.getDate().getTime()));
				statement.setString(2, data.getCustomer());
				statement.setString(3, data.getSkucode());
				statement.setDouble(4, data.getJanuary());
				statement.setDouble(5, data.getFebruary());
				statement.setDouble(6, data.getMarch());
				statement.setDouble(7, data.getApril());
				statement.setDouble(8, data.getMay());
				statement.setDouble(9, data.getJune());
				statement.setDouble(10, data.getJuly());
				statement.setDouble(11, data.getAugust());
				statement.setDouble(12, data.getSeptember());
				statement.setDouble(13, data.getOctober());
				statement.setDouble(14, data.getNovember());
				statement.setDouble(15, data.getDecember());
				statement.setInt(16, data.getId());
				return statement.execute();
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getCurrentDateData(java.lang.
	 * String)
	 */
	@Override
	public List<ConvertingLine> getCurrentDateData(String format) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from tbl_ComplaintLine_Cust_Projections where date=?";
		List<ConvertingLine> reel = null;
		try {
			reel = jdbcTemplate.query(sql, new Object[] { format }, new ConvertingLineMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "delete from tbl_ComplaintLine_Cust_Projections where [ID]=?";
		jdbcTemplate.update(sql, new Object[] { id });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getCurrentBackDateData(java.util.
	 * Date, java.util.Date)
	 */
	@Override
	public List<ConvertingLine> getCurrentBackDateData(Date date1, Date date2) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from tbl_ComplaintLine_Cust_Projections where date between ? and ?  ORDER BY date ASC";
		List<ConvertingLine> reel = null;
		try {
			reel = jdbcTemplate.query(sql, new Object[] { date1, date2 }, new ConvertingLineMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * saveproductspecificationsignoffsheet(productspecificationsignoffsheet.
	 * ProductSpecificationSignOffSheet)
	 */
	@Override
	public int saveproductspecificationsignoffsheet(final ProductSpecificationSignOffSheet wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		KeyHolder keyHolder = new GeneratedKeyHolder();

		final String sql = "insert into [tbl_clproductspecificationsignoffsheet]" + "(" + "[time]," + "[date],"
				+ "[skucode]," + "[rolldiameter]," + "[tailseal]," + "[core]," + "[rollwidth]," + "[embossing],"
				+ "[overallapprience]," + "[appereianceapllet]," + "[rejectedkdf]," + "[rewinderspeed]," + "[comment],"
				+ "[initials]," + "[datecodeprinted]," + "[boxappr]," + "[tape]," + "[enoghdle]" + ")" + " values("
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" + ")";

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				PreparedStatement statement = arg0.prepareStatement(sql, new String[] { "ID" });
				statement.setString(1, wm.getTime());
				statement.setTimestamp(2, new Timestamp(wm.getDate().getTime()));
				statement.setString(3, wm.getSkucode());
				statement.setString(4, wm.getRolldiameter());
				statement.setString(5, wm.getTailseal());
				statement.setString(6, wm.getCore());
				statement.setString(7, wm.getRollwidth());
				statement.setString(8, wm.getEmbossing());
				statement.setString(9, wm.getAppereiance());
				statement.setString(10, wm.getAppereianceapllet());
				statement.setDouble(11, wm.getRejectedkdf());
				statement.setDouble(12, wm.getRewinderspeed());
				statement.setString(13, wm.getComment());
				statement.setString(14, wm.getInitials());
				statement.setString(15, wm.getBoxappr());
				statement.setString(16, wm.getTape());
				statement.setString(17, wm.getEnoghdle());
				statement.setString(18, wm.getDatecodeprinted());
				return statement;
			}
		}, keyHolder);

		return keyHolder.getKey().intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * updateproductspecificationsignoffsheet(productspecificationsignoffsheet.
	 * ProductSpecificationSignOffSheet)
	 */
	@Override
	public void updateproductspecificationsignoffsheet(final ProductSpecificationSignOffSheet wm) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		final String sql = "update [tbl_clproductspecificationsignoffsheet] set " + "[time]=?," + "[date]=?,"
				+ "[skucode]=?," + "[rolldiameter]=?," + "[tailseal]=?," + "[core]=?," + "[rollwidth]=?,"
				+ "[embossing]=?," + "[overallapprience]=?," + "[appereianceapllet]=?," + "[rejectedkdf]=?,"
				+ "[rewinderspeed]=?," + "[comment]=?," + "[initials]=?," + "[datecodeprinted]=?," + "[boxappr]=?,"
				+ "[tape]=?," + "[enoghdle]=?" + " where [ID]=?";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				PreparedStatement statement = arg0.prepareStatement(sql);
				statement.setString(1, wm.getTime());
				statement.setTimestamp(2, new Timestamp(wm.getDate().getTime()));
				statement.setString(3, wm.getSkucode());
				statement.setString(4, wm.getRolldiameter());
				statement.setString(5, wm.getTailseal());
				statement.setString(6, wm.getCore());
				statement.setString(7, wm.getRollwidth());
				statement.setString(8, wm.getEmbossing());
				statement.setString(9, wm.getAppereiance());
				statement.setString(10, wm.getAppereianceapllet());
				statement.setDouble(11, wm.getRejectedkdf());
				statement.setDouble(12, wm.getRewinderspeed());
				statement.setString(13, wm.getComment());
				statement.setString(14, wm.getInitials());
				statement.setString(15, wm.getDatecodeprinted());
				statement.setString(16, wm.getBoxappr());
				statement.setString(17, wm.getTape());
				statement.setString(18, wm.getEnoghdle());
				statement.setInt(19, wm.getId());
				return statement;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * getDataOfProductSpecificationSignOffSheet(java.lang.String)
	 */
	@Override
	public List<ProductSpecificationSignOffSheet> getDataOfProductSpecificationSignOffSheet(String sdate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from tbl_clproductspecificationsignoffsheet where [Date] between ? And ?";

		List<ProductSpecificationSignOffSheet> procedures = jdbcTemplate.query(sql, new Object[] { sdate, sdate },
				new RowMapper<ProductSpecificationSignOffSheet>() {

					@Override
					public ProductSpecificationSignOffSheet mapRow(ResultSet rs, int arg1) throws SQLException {
						ProductSpecificationSignOffSheet operatingProcedure = new ProductSpecificationSignOffSheet();
						operatingProcedure.setId(rs.getInt("ID"));
						operatingProcedure.setTime(rs.getString("time"));
						operatingProcedure.setDate(new Date(rs.getTimestamp("date").getTime()));
						operatingProcedure.setSkucode(rs.getString("skucode"));
						operatingProcedure.setRolldiameter(rs.getString("rolldiameter"));
						operatingProcedure.setTailseal(rs.getString("tailseal"));
						operatingProcedure.setCore(rs.getString("core"));
						operatingProcedure.setRollwidth(rs.getString("rollwidth"));
						operatingProcedure.setEmbossing(rs.getString("embossing"));
						operatingProcedure.setAppereiance(rs.getString("overallapprience"));
						operatingProcedure.setAppereianceapllet(rs.getString("appereianceapllet"));
						operatingProcedure.setRejectedkdf(rs.getDouble("rejectedkdf"));
						operatingProcedure.setRewinderspeed(rs.getDouble("rewinderspeed"));
						operatingProcedure.setComment(rs.getString("comment"));
						operatingProcedure.setInitials(rs.getString("initials"));
						operatingProcedure.setDatecodeprinted(rs.getString("datecodeprinted"));
						operatingProcedure.setBoxappr(rs.getString("boxappr"));
						operatingProcedure.setTape(rs.getString("tape"));
						operatingProcedure.setEnoghdle(rs.getString("enoghdle"));
						return operatingProcedure;
					}

				});

		return procedures;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * productspecificationsignoffsheetdelete(int)
	 */
	@Override
	public void productspecificationsignoffsheetdelete(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "delete from [tbl_clproductspecificationsignoffsheet] where [ID]=?";
		jdbcTemplate.update(sql, new Object[] { id });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * getDataOfProductSpecificationSignOffSheetByDate(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<ProductSpecificationSignOffSheet> getDataOfProductSpecificationSignOffSheetByDate(String sdate,
			String edate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from tbl_clproductspecificationsignoffsheet where [Date] between ? And ? order by date";

		List<ProductSpecificationSignOffSheet> procedures = jdbcTemplate.query(sql, new Object[] { sdate, edate },
				new RowMapper<ProductSpecificationSignOffSheet>() {

					@Override
					public ProductSpecificationSignOffSheet mapRow(ResultSet rs, int arg1) throws SQLException {
						ProductSpecificationSignOffSheet operatingProcedure = new ProductSpecificationSignOffSheet();
						operatingProcedure.setId(rs.getInt("ID"));
						operatingProcedure.setTime(rs.getString("time"));
						operatingProcedure.setDate(new Date(rs.getTimestamp("date").getTime()));
						operatingProcedure.setSkucode(rs.getString("skucode"));
						operatingProcedure.setRolldiameter(rs.getString("rolldiameter"));
						operatingProcedure.setTailseal(rs.getString("tailseal"));
						operatingProcedure.setCore(rs.getString("core"));
						operatingProcedure.setRollwidth(rs.getString("rollwidth"));
						operatingProcedure.setEmbossing(rs.getString("embossing"));
						operatingProcedure.setAppereiance(rs.getString("overallapprience"));
						operatingProcedure.setAppereianceapllet(rs.getString("appereianceapllet"));
						operatingProcedure.setRejectedkdf(rs.getDouble("rejectedkdf"));
						operatingProcedure.setRewinderspeed(rs.getDouble("rewinderspeed"));
						operatingProcedure.setComment(rs.getString("comment"));
						operatingProcedure.setInitials(rs.getString("initials"));
						operatingProcedure.setDatecodeprinted(rs.getString("datecodeprinted"));
						operatingProcedure.setBoxappr(rs.getString("boxappr"));
						operatingProcedure.setTape(rs.getString("tape"));
						operatingProcedure.setEnoghdle(rs.getString("enoghdle"));
						return operatingProcedure;
					}

				});

		return procedures;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * getDataOfProductSpecificationSignOffSheetToEdit(int)
	 */
	@Override
	public List<ProductSpecificationSignOffSheet> getDataOfProductSpecificationSignOffSheetToEdit(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from tbl_clproductspecificationsignoffsheet where [id]=?";

		List<ProductSpecificationSignOffSheet> procedures = jdbcTemplate.query(sql, new Object[] { id },
				new RowMapper<ProductSpecificationSignOffSheet>() {

					@Override
					public ProductSpecificationSignOffSheet mapRow(ResultSet rs, int arg1) throws SQLException {
						ProductSpecificationSignOffSheet operatingProcedure = new ProductSpecificationSignOffSheet();
						operatingProcedure.setId(rs.getInt("ID"));
						operatingProcedure.setTime(rs.getString("time"));
						operatingProcedure.setDate(new Date(rs.getTimestamp("date").getTime()));
						operatingProcedure.setSkucode(rs.getString("skucode"));
						operatingProcedure.setRolldiameter(rs.getString("rolldiameter"));
						operatingProcedure.setTailseal(rs.getString("tailseal"));
						operatingProcedure.setCore(rs.getString("core"));
						operatingProcedure.setRollwidth(rs.getString("rollwidth"));
						operatingProcedure.setEmbossing(rs.getString("embossing"));
						operatingProcedure.setAppereiance(rs.getString("overallapprience"));
						operatingProcedure.setAppereianceapllet(rs.getString("appereianceapllet"));
						operatingProcedure.setRejectedkdf(rs.getDouble("rejectedkdf"));
						operatingProcedure.setRewinderspeed(rs.getDouble("rewinderspeed"));
						operatingProcedure.setComment(rs.getString("comment"));
						operatingProcedure.setInitials(rs.getString("initials"));
						operatingProcedure.setDatecodeprinted(rs.getString("datecodeprinted"));
						operatingProcedure.setBoxappr(rs.getString("boxappr"));
						operatingProcedure.setTape(rs.getString("tape"));
						operatingProcedure.setEnoghdle(rs.getString("enoghdle"));
						return operatingProcedure;
					}

				});

		return procedures;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getEditForecast(java.util.Date,
	 * java.util.Date, java.util.List)
	 */
	@Override
	public List<ConvertingLine> getEditForecast(Date date1, Date date2, String custname) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ConvertingLine> reel = null;
		String sql = "";
		try {
			if (custname.equalsIgnoreCase("All")) {
				sql = "select * from tbl_ComplaintLine_Cust_Projections where date between ? and ?  ORDER BY date ASC";
				reel = jdbcTemplate.query(sql, new Object[] { date1, date2 }, new ConvertingLineMapper());
			} else {
				sql = "select * from tbl_ComplaintLine_Cust_Projections where date between ? and ? and custname=? ORDER BY date ASC";
				reel = jdbcTemplate.query(sql, new Object[] { date1, date2, custname }, new ConvertingLineMapper());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * getskuSpecificationDataEntryViewBackdatedDataEditId(int)
	 */
	@Override
	public List<ConvertingLine> getskuSpecificationDataEntryViewBackdatedDataEditId(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ConvertingLine> reel = null;
		String sql = "";
		try {
			sql = "select * from tbl_ComplaintLine_Cust_Projections where id=? ORDER BY date ASC";
			reel = jdbcTemplate.query(sql, new Object[] { id }, new ConvertingLineMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getForeCastData(java.util.Date,
	 * java.util.Date, java.lang.String)
	 */
	@Override
	public List<ConvertingLine> getForeCastData(Date date1, Date date2, String customer) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ConvertingLine> reel = null;
		String sql = "";
		try {
			if (customer.equalsIgnoreCase("All")) {
				sql = "SELECT w.custname, w.skucode,Sum(w.January) AS January, Sum(w.February) AS February, "
						+ "Sum(w.March) AS March, Sum(w.April) AS April, Sum(w.May) AS May, Sum(w.June) AS June, Sum(w.July) AS July, Sum(w.August) AS August, "
						+ "Sum(w.September) AS September, Sum(w.October) AS October, Sum(w.November) AS November, Sum(w.December) AS December "
						+ " FROM tbl_ComplaintLine_Cust_Projections AS w WHERE (w.[date] Between ? And ? )  And w.custname<>'ST Tissue- Sample Room' "
						+ " GROUP BY w.[custname],w.[skucode] ORDER BY w.[custname] ASC";
				reel = jdbcTemplate.query(sql, new Object[] { date1, date2 }, new ConvertingLineMapperForCasteData());
			} else {
				sql = "SELECT w.custname, w.skucode,Sum(w.January) AS January, Sum(w.February) AS February, "
						+ "Sum(w.March) AS March, Sum(w.April) AS April, Sum(w.May) AS May, Sum(w.June) AS June, Sum(w.July) AS July, Sum(w.August) AS August, "
						+ "Sum(w.September) AS September, Sum(w.October) AS October, Sum(w.November) AS November, Sum(w.December) AS December "
						+ " FROM tbl_ComplaintLine_Cust_Projections AS w WHERE (w.[date] Between ? And ? )  And w.custname=?   And w.custname<>'ST Tissue- Sample Room' "
						+ " GROUP BY w.[custname],w.[skucode] ORDER BY w.[custname] ASC";
				reel = jdbcTemplate.query(sql, new Object[] { date1, date2, customer },
						new ConvertingLineMapperForCasteData());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * getCheckDataIsPresentOrNotInTempTable(java.lang.String, java.lang.String)
	 */
	@Override
	public int getCheckDataIsPresentOrNotInTempTable(String customer, String skucode) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int ProbationData = 0;
		try {
			String query = "Select count(*) as count from tbl_ComplaintLine_Cust_Projections_Temp where customer=? and skucode=?;";
			Object[] inputs = new Object[] { customer, skucode };
			ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
		} catch (Exception rlt) {
			rlt.printStackTrace();
		} finally {

		}
		return ProbationData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getFetchDataNotInTempTable(java.
	 * util.Date, java.util.Date, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ConvertingLine> getFetchDataNotInTempTable(Date date1, Date date2, String customer, String skucode) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ConvertingLine> reel = null;
		String sql = "";
		String endYear = yearFormat.format(date2);
		try {
			// Code/Query Again Changed
			sql = "SELECT TOP 1 w.[date], w.custname, w.skucode,Sum(w.January) AS January, Sum(w.February) AS February,  Sum(w.March) AS March,"
					+ " Sum(w.April) AS April, Sum(w.May) AS May, Sum(w.June) AS June, Sum(w.July) AS July, Sum(w.August) AS August, "
					+ " Sum(w.September) AS September, Sum(w.October) AS October, Sum(w.November) AS November, Sum(w.December) AS December "
					+ " FROM tbl_ComplaintLine_Cust_Projections AS w WHERE  w.custname=? and skucode=?  and year(w.[date])=?  And w.custname<>'ST Tissue- Sample Room' "
					+ " GROUP BY w.[date],w.[custname],w.[skucode] ORDER BY w.[date] DESC ";
			reel = jdbcTemplate.query(sql, new Object[] { customer, skucode, endYear },
					new ConvertingLineMapperForCasteData());

			// Updated Code Is Below Here We Removed The Year

			sql = "SELECT TOP 1 w.[date], w.custname, w.skucode,Sum(w.January) AS January, Sum(w.February) AS February,  Sum(w.March) AS March,"
					+ " Sum(w.April) AS April, Sum(w.May) AS May, Sum(w.June) AS June, Sum(w.July) AS July, Sum(w.August) AS August, "
					+ " Sum(w.September) AS September, Sum(w.October) AS October, Sum(w.November) AS November, Sum(w.December) AS December "
					+ " FROM tbl_ComplaintLine_Cust_Projections AS w WHERE  w.custname=? and skucode=?  And w.custname<>'ST Tissue- Sample Room' "
					+ " GROUP BY w.[date],w.[custname],w.[skucode] ORDER BY w.[date] DESC ";
			reel = jdbcTemplate.query(sql, new Object[] { customer, skucode }, new ConvertingLineMapperForCasteData());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getForeCastDataGroupBySKUCode(
	 * java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<ConvertingLine> getForeCastDataGroupBySKUCode(Date date1, Date date2, String skucode) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ConvertingLine> reel = null;
		String sql = "";
		String endYear = yearFormat.format(date2);
		try {
			if (skucode.equalsIgnoreCase("All")) {

				sql = "SELECT t1.skucode,Sum(t1.January) AS January, Sum(t1.February) AS February, Sum(t1.March) AS March, "
						+ " Sum(t1.April) AS April, Sum(t1.May) AS May, Sum(t1.June) AS June, Sum(t1.July) AS July, Sum(t1.August) AS August, "
						+ " Sum(t1.September) AS September, Sum(t1.October) AS October, Sum(t1.November) AS November, Sum(t1.December) AS December "
						+ " FROM tbl_ComplaintLine_Cust_Projections t1 " + " WHERE t1.date = (SELECT MAX(t2.date) "
						+ " FROM tbl_ComplaintLine_Cust_Projections t2 "
						+ " WHERE t2.skucode = t1.skucode and t2.custname = t1.custname  And t2.custname<>'ST Tissue- Sample Room' ) group by t1.skucode";

				reel = jdbcTemplate.query(sql, new Object[] {}, new ConvertingLineMapperForCasteDataGroupBySKUCode());
			} else {
				sql = "SELECT t1.skucode,Sum(t1.January) AS January, Sum(t1.February) AS February, Sum(t1.March) AS March, "
						+ " Sum(t1.April) AS April, Sum(t1.May) AS May, Sum(t1.June) AS June, Sum(t1.July) AS July, Sum(t1.August) AS August, "
						+ " Sum(t1.September) AS September, Sum(t1.October) AS October, Sum(t1.November) AS November, Sum(t1.December) AS December "
						+ " FROM tbl_ComplaintLine_Cust_Projections t1 " + " WHERE t1.date = (SELECT MAX(t2.date) "
						+ " FROM tbl_ComplaintLine_Cust_Projections t2 "
						+ " WHERE t2.skucode = t1.skucode and t2.custname = t1.custname and t2.skucode=? And t2.custname<>'ST Tissue- Sample Room' ) group by t1.skucode";
				reel = jdbcTemplate.query(sql, new Object[] { skucode },
						new ConvertingLineMapperForCasteDataGroupBySKUCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * getCheckDataIsPresentOrNotInTempTableForSKUCode(java.lang.String)
	 */
	@Override
	public int getCheckDataIsPresentOrNotInTempTableForSKUCode(String skucode) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int ProbationData = 0;
		try {
			String query = "Select count(*) as count from tbl_ComplaintLine_SKU_Projections_Temp where skucode=?;";
			Object[] inputs = new Object[] { skucode };
			ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
		} catch (Exception rlt) {
			rlt.printStackTrace();
		} finally {

		}
		return ProbationData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * getFetchDataNotInTempTableForSKUCode(java.util.Date, java.util.Date,
	 * java.lang.String)
	 */
	@Override
	public List<ConvertingLine> getFetchDataNotInTempTableForSKUCode(Date date1, Date date2, String skucode) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ConvertingLine> reel = null;
		String sql = "";

		String endYear = yearFormat.format(date2);

		try {

			sql = "SELECT t1.skucode,Sum(t1.January) AS January, Sum(t1.February) AS February, Sum(t1.March) AS March, "
					+ " Sum(t1.April) AS April, Sum(t1.May) AS May, Sum(t1.June) AS June, Sum(t1.July) AS July, Sum(t1.August) AS August, "
					+ " Sum(t1.September) AS September, Sum(t1.October) AS October, Sum(t1.November) AS November, Sum(t1.December) AS December "
					+ " FROM tbl_ComplaintLine_Cust_Projections t1 " + " WHERE t1.date = (SELECT MAX(t2.date) "
					+ " FROM tbl_ComplaintLine_Cust_Projections t2 "
					+ " WHERE t2.skucode = t1.skucode and t2.custname = t1.custname and t2.skucode=?  And t2.custname<>'ST Tissue- Sample Room') group by t1.skucode";

			reel = jdbcTemplate.query(sql, new Object[] { skucode },
					new ConvertingLineMapperForCasteDataGroupBySKUCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * getSearchForecastCustomerAndSKUCodeWise(java.util.Date, java.util.Date,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public List<ConvertingLine> getSearchForecastCustomerAndSKUCodeWise(Date date1, Date date2, String customer_Name,
			String sKU_Code) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ConvertingLine> reel = null;
		String sql = "";
		try {
			if (customer_Name.equalsIgnoreCase("All")) {
				sql = "select * from tbl_ComplaintLine_Cust_Projections as w where (w.[date] Between ? And ? )  And w.skucode=? ORDER BY date ASC";
				reel = jdbcTemplate.query(sql, new Object[] { date1, date2, sKU_Code }, new ConvertingLineMapper());
			} else {
				sql = "select * from tbl_ComplaintLine_Cust_Projections as w where (w.[date] Between ? And ? )  And w.skucode=?  and w.custname=?  ORDER BY date ASC";
				reel = jdbcTemplate.query(sql, new Object[] { date1, date2, sKU_Code, customer_Name },
						new ConvertingLineMapper());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * getForeCastDataGroupBySKUCode_ByShipToDate(java.util.Date, java.util.Date,
	 * java.lang.String)
	 */
	@Override
	public List<ConvertingLine> getForeCastDataGroupBySKUCode_ByShipToDate(Date date1, Date date2, String skucode) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ConvertingLine> reel = null;
		String sql = "";
		try {
			if (skucode.equalsIgnoreCase("All")) {
				sql = "SELECT t1.skucode,Sum(t1.January) AS January, Sum(t1.February) AS February, Sum(t1.March) AS March, "
						+ " Sum(t1.April) AS April, Sum(t1.May) AS May, Sum(t1.June) AS June, Sum(t1.July) AS July, Sum(t1.August) AS August, "
						+ " Sum(t1.September) AS September, Sum(t1.October) AS October, Sum(t1.November) AS November, Sum(t1.December) AS December "
						+ " FROM tbl_ComplaintLine_Cust_Projections t1 " + " WHERE t1.date = (SELECT MAX(t2.date) "
						+ " FROM tbl_ComplaintLine_Cust_Projections t2 "
						+ " WHERE t2.skucode = t1.skucode and t2.custname = t1.custname ) group by t1.skucode";

				reel = jdbcTemplate.query(sql, new Object[] {}, new ConvertingLineMapperForCasteDataGroupBySKUCode());
			} else {
				sql = "SELECT t1.skucode,Sum(t1.January) AS January, Sum(t1.February) AS February, Sum(t1.March) AS March, "
						+ " Sum(t1.April) AS April, Sum(t1.May) AS May, Sum(t1.June) AS June, Sum(t1.July) AS July, Sum(t1.August) AS August, "
						+ " Sum(t1.September) AS September, Sum(t1.October) AS October, Sum(t1.November) AS November, Sum(t1.December) AS December "
						+ " FROM tbl_ComplaintLine_Cust_Projections t1 " + " WHERE t1.date = (SELECT MAX(t2.date) "
						+ " FROM tbl_ComplaintLine_Cust_Projections t2 "
						+ " WHERE t2.skucode = t1.skucode and t2.custname = t1.custname and t2.skucode=?) group by t1.skucode";
				reel = jdbcTemplate.query(sql, new Object[] { skucode },
						new ConvertingLineMapperForCasteDataGroupBySKUCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * getCheckDataIsPresentOrNotInTempTableForSKUCode_ByShipToDate(java.lang.
	 * String)
	 */
	@Override
	public int getCheckDataIsPresentOrNotInTempTableForSKUCode_ByShipToDate(String skucode) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int ProbationData = 0;
		try {
			String query = "Select count(*) as count from tbl_ComplaintLine_SKU_Projections_ByShiftToDate_Temp where skucode=?;";
			Object[] inputs = new Object[] { skucode };
			ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
		} catch (Exception rlt) {
			rlt.printStackTrace();
		} finally {

		}
		return ProbationData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#
	 * getFetchDataNotInTempTableForSKUCode_ByShipToDate(java.util.Date,
	 * java.util.Date, java.lang.String)
	 */
	@Override
	public List<ConvertingLine> getFetchDataNotInTempTableForSKUCode_ByShipToDate(Date date1, Date date2,
			String skucode) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ConvertingLine> reel = null;
		String sql = "";
		try {
			sql = "SELECT t1.skucode,Sum(t1.January) AS January, Sum(t1.February) AS February, Sum(t1.March) AS March, "
					+ " Sum(t1.April) AS April, Sum(t1.May) AS May, Sum(t1.June) AS June, Sum(t1.July) AS July, Sum(t1.August) AS August, "
					+ " Sum(t1.September) AS September, Sum(t1.October) AS October, Sum(t1.November) AS November, Sum(t1.December) AS December "
					+ " FROM tbl_ComplaintLine_Cust_Projections t1 " + " WHERE t1.date = (SELECT MAX(t2.date) "
					+ " FROM tbl_ComplaintLine_Cust_Projections t2 "
					+ " WHERE t2.skucode = t1.skucode and t2.custname = t1.custname and t2.skucode=?) group by t1.skucode";

			reel = jdbcTemplate.query(sql, new Object[] { skucode },
					new ConvertingLineMapperForCasteDataGroupBySKUCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getCheckLastEntryData(java.lang.
	 * String, java.lang.String, java.util.Date)
	 */
	@Override
	public Date getCheckLastEntryData(String customer, String skucode, Date date) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Date lastEntryDate = null;
		String endYear = yearFormat.format(date);
		try {
			String query = "SELECT TOP 1 w.[date] as Date FROM tbl_ComplaintLine_Cust_Projections AS w WHERE w.custname=? And w.skucode=? and year(w.[date])=? ";
			Object[] inputs = new Object[] { customer, skucode, endYear };
			lastEntryDate = jdbcTemplate.queryForObject(query, inputs, Date.class);
		} catch (Exception rlt) {
			rlt.printStackTrace();
		} finally {

		}
		return lastEntryDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#skuspecificationForecasteUpdate(
	 * com.st.convertingline.model.ConvertingLine)
	 */
	@Override
	public void skuspecificationForecasteUpdate(final ConvertingLine data) {
		System.out.println(data.getCustomer());
		String sql = "update [tbl_ComplaintLine_Cust_Projections] SET "
				// + "[date]=?,"
				// + "[custname]=?,"
				// + "[skucode]=?,"
				+ "[January]=?," + "[February]=?," + "[March]=?," + "[April]=?," + "[May]=?," + "[June]=?,"
				+ "[July]=?," + "[August]=?," + "[September]=?," + "[October]=?," + "[November]=?," + "[December]=? "
				+ " where [date]=? And [custname]=? And [skucode]=? ";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException {

				statement.setDouble(1, data.getJanuary());
				statement.setDouble(2, data.getFebruary());
				statement.setDouble(3, data.getMarch());
				statement.setDouble(4, data.getApril());
				statement.setDouble(5, data.getMay());
				statement.setDouble(6, data.getJune());
				statement.setDouble(7, data.getJuly());
				statement.setDouble(8, data.getAugust());
				statement.setDouble(9, data.getSeptember());
				statement.setDouble(10, data.getOctober());
				statement.setDouble(11, data.getNovember());
				statement.setDouble(12, data.getDecember());

				statement.setTimestamp(13, new Timestamp(data.getDate().getTime()));
				statement.setString(14, data.getCustomer());
				statement.setString(15, data.getSkucode());

				return statement.execute();
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#skuspecificationForecasteSave(com
	 * .st.convertingline.model.ConvertingLine)
	 */
	@Override
	public int skuspecificationForecasteSave(final ConvertingLine data) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		final String sql = "insert into [tbl_ComplaintLine_Cust_Projections]" + "(" + "[Date]," + "[custname],"
				+ "[skucode]," + "[January]," + "[February]," + "[March]," + "[April]," + "[May]," + "[June],"
				+ "[July]," + "[August]," + "[September]," + "[October]," + "[November]," + "[December] )"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				PreparedStatement statement = arg0.prepareStatement(sql, new String[] { "ID" });

				statement.setTimestamp(1, new Timestamp(data.getDate().getTime()));
				statement.setString(2, data.getCustomer());
				statement.setString(3, data.getSkucode());
				statement.setDouble(4, data.getJanuary());
				statement.setDouble(5, data.getFebruary());
				statement.setDouble(6, data.getMarch());
				statement.setDouble(7, data.getApril());
				statement.setDouble(8, data.getMay());
				statement.setDouble(9, data.getJune());
				statement.setDouble(10, data.getJuly());
				statement.setDouble(11, data.getAugust());
				statement.setDouble(12, data.getSeptember());
				statement.setDouble(13, data.getOctober());
				statement.setDouble(14, data.getNovember());
				statement.setDouble(15, data.getDecember());
				return statement;
			}
		}, keyHolder);

		return keyHolder.getKey().intValue();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getRewiderHoursAvg(java.util.
	 * Date, java.util.Date)
	 */
	@Override
	public Double getRewiderHoursAvg(Date dateS, Date dateS2) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		double ProbationData = 0;
		try {
			String query = "select ISNULL(AVG(w.rewinderspeed), 0 ) as Speed from tbl_clproductspecificationsignoffsheet as w where w.date between ? And ? ";
			Object[] inputs = new Object[] { dateS, dateS2 };
			ProbationData = jdbcTemplate.queryForObject(query, inputs, Double.class);
		} catch (Exception rlt) {
			rlt.printStackTrace();
		} finally {

		}
		return ProbationData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#saveorUpdate(com.st.
	 * convertingline.model.Casepacker)
	 */
	@Override
	public void saveorUpdate(final ConvertingPackagerObcc data) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);

		if (data.getId() == 0) {
			final String sql = "insert into [CasePackaerConvertingObcc]([date],[operatorname],[Shift],[skucode],[kdfbox],[boxesHmi],[boxespallet],[layerperpallet],[palletlabel],[datecode],[tapeStraight],[AreaClean],[MachineDown]) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Date sdate = null;
			try {
				sdate = dateFormat.parse(data.getDate());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String newdate = dateFormat.format(sdate);

			java.sql.Date sqlDate = null;
			try {
				sqlDate = new java.sql.Date(dateFormat.parse(newdate).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jdbcTemplate.update(sql, new Object[] {

					sqlDate, data.getOperatorname(), data.getShift(), data.getSkucode(), data.getKdfbox(),
					data.getBoxesHmi(), data.getBoxespallet(), data.getLayerperpallet(), data.getPalletlabel(),
					data.getDatecode(), data.getTapeStraight(), data.getAreaClean(), data.isMachinedown() });
		} else {

			final String sql = "update  [CasePackaerConvertingObcc] set [date]=?, [operatorname]=?,[Shift]=?,[skucode]=?,[kdfbox]=?,[boxesHmi]=?,[boxespallet]=?,[layerperpallet]=?,[palletlabel]=?,[datecode]=?,[tapeStraight]=?,[AreaClean]=?,[MachineDown]=? where id=?";
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
					PreparedStatement statement = arg0.prepareStatement(sql);

					Date sdate = null;
					try {
						sdate = dateFormat.parse(data.getDate());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String newdate = dateFormat.format(sdate);

					java.sql.Date sqlDate = null;
					try {
						sqlDate = new java.sql.Date(dateFormat.parse(newdate).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					statement.setDate(1, sqlDate);
					statement.setString(2, data.getOperatorname());
					statement.setString(3, data.getShift());
					statement.setString(4, data.getSkucode());
					statement.setString(5, data.getKdfbox());
					statement.setString(6, data.getBoxesHmi());
					statement.setString(7, data.getBoxespallet());
					statement.setString(8, data.getLayerperpallet());
					statement.setString(9, data.getPalletlabel());
					statement.setString(10, data.getDatecode());
					statement.setString(11, data.getTapeStraight());
					statement.setString(12, data.getAreaClean());
					statement.setBoolean(13, data.isMachinedown());
					statement.setInt(14, data.getId());
					return statement;
				}
			});

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.convertingline.dao.ConvertingLineDao#saveorUpdateRewind(com.st.
	 * convertingline.model.RewinderAndUnwindStand)
	 */
	@Override
	public void saveorUpdateRewind(final RewinderAndUnwindStand data) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		if (data.getId() == 0) {
			String sql = "insert into [Rewind_UnwindStandObcc]([date],[operatorname],[Shift],[itemonrewind],[footagenumber],[diameternumber],[actualfootage],[actualdiameter],[papergrade],[logsawstone],[unwindstandcleaned],[transferglue],[tailtieglue],[nomore1stlog],[rolllength],[MachineDown]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			Date sdate = null;
			try {
				sdate = dateFormat.parse(data.getDate());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String newdate = dateFormat.format(sdate);

			java.sql.Date sqlDate = null;
			try {
				sqlDate = new java.sql.Date(dateFormat.parse(newdate).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jdbcTemplate.update(sql, new Object[] {

					sqlDate, data.getOperatorname(), data.getShift(), data.getItemonrewind(), data.getFootagenumber(),
					data.getDiameternumber(), data.getActualfootage(), data.getActualdiameter(), data.getPapergrade(),
					data.getLogsawstone(), data.getUnwindstandcleaned(), data.getTransferglue(), data.getTailtieglue(),
					data.getNomore1stlog(), data.getRolllength(), data.isMachinedown() });
		} else {
			final String sql = "update  [Rewind_UnwindStandObcc] set [date]=?,[operatorname]=?,[Shift]=?,[itemonrewind]=?,[footagenumber]=?,[diameternumber]=?,[actualfootage]=?,[actualdiameter]=?,[papergrade]=?,[logsawstone]=?,[unwindstandcleaned]=?,[transferglue]=?,[tailtieglue]=?,[nomore1stlog]=?,[rolllength]=?,[MachineDown]=? where id=?";

			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
					PreparedStatement statement = arg0.prepareStatement(sql);
					Date sdate = null;
					try {
						sdate = dateFormat.parse(data.getDate());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String newdate = dateFormat.format(sdate);

					java.sql.Date sqlDate = null;
					try {
						sqlDate = new java.sql.Date(dateFormat.parse(newdate).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					statement.setDate(1, sqlDate);
					statement.setString(2, data.getOperatorname());
					statement.setString(3, data.getShift());
					statement.setString(4, data.getItemonrewind());
					statement.setString(5, data.getFootagenumber());
					statement.setString(6, data.getDiameternumber());
					statement.setString(7, data.getActualfootage());
					statement.setString(8, data.getActualdiameter());
					statement.setString(9, data.getPapergrade());
					statement.setString(10, data.getLogsawstone());
					statement.setString(11, data.getUnwindstandcleaned());
					statement.setString(12, data.getTransferglue());
					statement.setString(13, data.getTailtieglue());
					statement.setString(14, data.getNomore1stlog());
					statement.setString(15, data.getRolllength());
					statement.setBoolean(16, data.isMachinedown());
					statement.setInt(17, data.getId());

					return statement;
				}
			});
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getDataCountDatePercentageCase(
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentageCase(String position, String startDate, String endDate, String shift) {

		long p1 = 0, p2 = 0, p3 = 0, percentage = 0;

		Set<String> day_Set = new HashSet<String>();
		Set<String> night_Set = new HashSet<String>();
		Set<String> thired_Set = new HashSet<String>();

		final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date sDate = CommonUtil.checkDate(startDate, dateFormat);
		Date esDate = CommonUtil.checkDate(endDate, dateFormat);
		int days = CommonUtil.getDaysDiffernce(sDate, esDate) + 1;
		if (shift.equals("1")) {
			List<ConvertingPackagerObcc> daylist = getCasepackOperatorDataList("1", startDate, endDate);
			for (ConvertingPackagerObcc d : daylist) {
				day_Set.add(d.getDate());
			}
			p1 = day_Set.size();
			percentage = p1 * 100;
		}
		if (shift.equals("2")) {
			List<ConvertingPackagerObcc> nightlist = getCasepackOperatorDataList("2", startDate, endDate);
			for (ConvertingPackagerObcc n : nightlist) {
				night_Set.add(n.getDate());
			}
			p2 = night_Set.size();
			percentage = p2 * 100;
		}
		if (shift.equals("3")) {
			List<ConvertingPackagerObcc> thiredlist = getCasepackOperatorDataList("3", startDate, endDate);
			for (ConvertingPackagerObcc n : thiredlist) {
				thired_Set.add(n.getDate());
			}
			p3 = thired_Set.size();
			percentage = p3 * 100;
		}
		
		
		//for all shift reports
		if (shift.equals("both")) {
			List<ConvertingPackagerObcc> daylist = getCasepackOperatorDataList("1", startDate, endDate);
			for (ConvertingPackagerObcc d : daylist) {
				day_Set.add(d.getDate());
			}
			p1 = day_Set.size();
			List<ConvertingPackagerObcc> nightlist = getCasepackOperatorDataList("2", startDate, endDate);
			for (ConvertingPackagerObcc n : nightlist) {
				night_Set.add(n.getDate());
			}
			p2 = night_Set.size();

			List<ConvertingPackagerObcc> thiredlist = getCasepackOperatorDataList("3", startDate, endDate);
			for (ConvertingPackagerObcc n : thiredlist) {
				thired_Set.add(n.getDate());
			}
			p3 = thired_Set.size();

			percentage = ((p1 + p2 + p3) * 100) / 3;
		}

		percentage = percentage / days;
		return percentage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getCasepackOperatorDataList(java.
	 * lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ConvertingPackagerObcc> getCasepackOperatorDataList(String shift, String startDate, String endDate) {

		final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date sDate = CommonUtil.checkDate(startDate, dateFormat);
		Date esDate = CommonUtil.checkDate(endDate, dateFormat);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		Object[] param = null;
		String sql;

		Calendar scal = Calendar.getInstance();
		scal.setTime(sDate);
		Calendar ecal = Calendar.getInstance();
		ecal.setTime(sDate);
		sql = "SELECT * FROM CasePackaerConvertingObcc WHERE Shift=? and date between ? AND ?";
		param = new Object[] { scal.getTime(), ecal.getTime() };
		List<ConvertingPackagerObcc> wrapperProductions = null;

		try {
			// wrapperProductions = jdbcTemplate.query(sql, param, new 14(this));
			wrapperProductions = jdbcTemplate.query(sql, new Object[] { shift, sDate, esDate },
					new RowMapper<ConvertingPackagerObcc>() {

						@Override
						public ConvertingPackagerObcc mapRow(ResultSet rs, int arg1) throws SQLException {
							ConvertingPackagerObcc data = new ConvertingPackagerObcc();

							data.setId(rs.getInt("id"));
							data.setDate(rs.getString("date"));
							data.setShift(rs.getString("shift"));
							data.setSkucode(rs.getString("skucode"));
							data.setKdfbox(rs.getString("kdfbox"));
							data.setBoxesHmi(rs.getString("boxesHmi"));
							data.setBoxespallet(rs.getString("boxespallet"));
							data.setLayerperpallet(rs.getString("layerperpallet"));
							data.setPalletlabel(rs.getString("palletlabel"));
							data.setDatecode(rs.getString("datecode"));
							data.setTapeStraight(rs.getString("tapeStraight"));
							data.setAreaClean(rs.getString("AreaClean"));
							data.setMachinedown(rs.getBoolean("MachineDown"));

							return data;
						}

					});

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return wrapperProductions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getDataCountDatePercentageRewind(
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentageRewind(String position, String startDate, String endDate, String shift) {

		long p1 = 0, p2 = 0, p3 = 0, percentage = 0;

		Set<String> day_Set = new HashSet<String>();
		Set<String> night_Set = new HashSet<String>();
		Set<String> thired_Set = new HashSet<String>();

		final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date sDate = CommonUtil.checkDate(startDate, dateFormat);
		Date esDate = CommonUtil.checkDate(endDate, dateFormat);
		int days = CommonUtil.getDaysDiffernce(sDate, esDate) + 1;
		if (shift.equals("1")) {

			List<RewinderAndUnwindStand> daylist = getOperatorDataListRewind("1", startDate, endDate);

			for (RewinderAndUnwindStand d : daylist) {
				day_Set.add(d.getDate());
			}
			p1 = day_Set.size();
			percentage = p1 * 100;
		}
		if (shift.equals("2")) {
			List<RewinderAndUnwindStand> nightlist = getOperatorDataListRewind("2", startDate, endDate);
			for (RewinderAndUnwindStand n : nightlist) {
				night_Set.add(n.getDate());
			}
			p2 = night_Set.size();
			percentage = p2 * 100;
		}
		if (shift.equals("3")) {
			List<RewinderAndUnwindStand> thiredlist = getOperatorDataListRewind("3", startDate, endDate);
			for (RewinderAndUnwindStand n : thiredlist) {
				thired_Set.add(n.getDate());
			}
			p3 = thired_Set.size();
			percentage = p3 * 100;
		}
		if (shift.equals("both")) {
			List<RewinderAndUnwindStand> daylist = getOperatorDataListRewind("1", startDate, endDate);
			for (RewinderAndUnwindStand d : daylist) {
				day_Set.add(d.getDate());
			}
			p1 = day_Set.size();
			List<RewinderAndUnwindStand> nightlist = getOperatorDataListRewind("2", startDate, endDate);
			for (RewinderAndUnwindStand n : nightlist) {
				night_Set.add(n.getDate());
			}
			p2 = night_Set.size();

			List<RewinderAndUnwindStand> thiredlist = getOperatorDataListRewind("3", startDate, endDate);
			for (RewinderAndUnwindStand n : thiredlist) {
				thired_Set.add(n.getDate());
			}
			p3 = thired_Set.size();

			percentage = ((p1 + p2 + p3) * 100) / 3;
		}

		percentage = percentage / days;
		return percentage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.convertingline.dao.ConvertingLineDao#getOperatorDataListRewind(java.
	 * lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List getOperatorDataListRewind(String string, String startDate, String endDate) {

		final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date sDate = CommonUtil.checkDate(startDate, dateFormat);
		Date esDate = CommonUtil.checkDate(endDate, dateFormat);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		Object[] param = null;
		String sql;

		Calendar scal = Calendar.getInstance();
		scal.setTime(sDate);
		Calendar ecal = Calendar.getInstance();
		ecal.setTime(sDate);
		sql = "SELECT * FROM Rewind_UnwindStandObcc WHERE Shift=? and date between ? AND ?";
		param = new Object[] { scal.getTime(), ecal.getTime() };
		List<RewinderAndUnwindStand> wrapperProductions = null;

		try {
			// wrapperProductions = jdbcTemplate.query(sql, param, new 14(this));
			wrapperProductions = jdbcTemplate.query(sql, new Object[] { string, sDate, esDate },
					new RowMapper<RewinderAndUnwindStand>() {

						@Override
						public RewinderAndUnwindStand mapRow(ResultSet rs, int arg1) throws SQLException {
							RewinderAndUnwindStand data = new RewinderAndUnwindStand();

							try {
								String newDate = dateFormat
										.format(ConvertingLineDaoImp.this.dateFormat.parse(rs.getString("date")));
//final String 

								data.setId(rs.getInt("id"));
								data.setDate(rs.getString("date"));
								data.setShift(rs.getString("shift"));
								data.setItemonrewind(rs.getString("itemonrewind"));
								data.setFootagenumber(rs.getString("footagenumber"));
								data.setDiameternumber(rs.getString("diameternumber"));
								data.setActualfootage(rs.getString("actualfootage"));
								data.setActualdiameter(rs.getString("actualdiameter"));
								data.setPapergrade(rs.getString("papergrade"));

								data.setLogsawstone(rs.getString("logsawstone"));
								data.setUnwindstandcleaned(rs.getString("unwindstandcleaned"));

								data.setTransferglue(rs.getString("transferglue"));
								data.setTailtieglue(rs.getString("tailtieglue"));
								data.setNomore1stlog(rs.getString("nomore1stlog"));
								data.setRolllength(rs.getString("rolllength"));
								data.setMachinedown(rs.getBoolean("MachineDown"));

							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							return data;
						}

					});

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return wrapperProductions;

	}

}
