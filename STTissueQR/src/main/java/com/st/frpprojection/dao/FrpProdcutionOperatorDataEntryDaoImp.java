/**
 *Mar 3, 2016
 *FrpProdcutionOperatorDataEntryDaoImp.java
 * TODO
 *com.st.frpprojection.dao
 *FrpProdcutionOperatorDataEntryDaoImp.java
 *Roshan Lal Tailor
 */
package com.st.frpprojection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.st.frpproduction.model.FrpProdcutionOperatorDataEntry;

/**
 * @author sbora
 *
 */
@Repository
public class FrpProdcutionOperatorDataEntryDaoImp implements FrpProdcutionOperatorDataEntryDao {

	@Autowired
	private DataSource dataSource;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#save(com.st.
	 * frpproduction.model.FrpProdcutionOperatorDataEntry)
	 */
	@Override
	public int save(final FrpProdcutionOperatorDataEntry colum) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		KeyHolder keyHolder = new GeneratedKeyHolder();

		final String sql = "insert into [FrpProdcutionOperatorDataEntry]" + "(" + "[dates]," + "[crew]," + "[shift],"
				+ "[col1]," + "[col2]," + "[col3]," + "[col4]," + "[col5]," + "[col6]," + "[col7]," + "[col8],"
				+ "[col9]," + "[col10]," + "[col11]," + "[productiontype]," + "[col11b]," + "[col6b]," + "[col7b],"
				+ "[col8b]," + "[col9b]," + "[col10b]," + "[col10a]," + "[col12b]," + "[col12]" + ")" + " values("
				+ "?," + "?," + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" + ")";

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				PreparedStatement statement = arg0.prepareStatement(sql, new String[] { "ID" });
				statement.setTimestamp(1, new Timestamp(colum.getDate().getTime()));
				statement.setString(2, colum.getCrew());
				statement.setString(3, colum.getShift());
				statement.setDouble(4, colum.getCol1());
				statement.setDouble(5, colum.getCol2());
				statement.setDouble(6, colum.getCol3());
				statement.setDouble(7, colum.getCol4());
				statement.setDouble(8, colum.getCol5());
				statement.setDouble(9, colum.getCol6());
				statement.setDouble(10, colum.getCol7());
				statement.setDouble(11, colum.getCol8());
				statement.setDouble(12, colum.getCol9());
				statement.setDouble(13, colum.getCol10());
				statement.setDouble(14, colum.getCol11());
				statement.setString(15, colum.getProductiontype());

				statement.setDouble(16, colum.getCol11b());
				statement.setDouble(17, colum.getCol6b());
				statement.setDouble(18, colum.getCol7b());
				statement.setDouble(19, colum.getCol8b());
				statement.setDouble(20, colum.getCol9b());
				statement.setDouble(21, colum.getCol10b());
				statement.setDouble(22, colum.getCol10a());
				statement.setDouble(23, colum.getCol12b());
				statement.setDouble(24, colum.getCol12());
				return statement;
			}
		}, keyHolder);
		// Second Enrty
		/*
		 * jdbcTemplate.update(new PreparedStatementCreator() {
		 * 
		 * @Override public PreparedStatement createPreparedStatement(Connection arg0)
		 * throws SQLException { PreparedStatement
		 * statement=arg0.prepareStatement(sql,new String[]{"ID"});
		 * statement.setTimestamp(1, new Timestamp(colum.getDate().getTime()));
		 * statement.setString(2,""); if(colum.getShift().equalsIgnoreCase("DAY")){
		 * statement.setString(3,"NIGHT"); }else{ statement.setString(3,"DAY"); }
		 * statement.setDouble(4,0); statement.setDouble(5,0); statement.setDouble(6,0);
		 * statement.setDouble(7,0); statement.setDouble(8,0); statement.setDouble(9,0);
		 * statement.setDouble(10,0); statement.setDouble(11,0);
		 * statement.setDouble(12,0); statement.setDouble(13,0); return statement; }
		 * },keyHolder);
		 */

		return keyHolder.getKey().intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#checkexistentry(
	 * java.util.Date, java.lang.String)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> checkexistentry(Date date, String shift, String crew) {
		// TODO Auto-generated method stub

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "select * From [FrpProdcutionOperatorDataEntry] Where [dates]=:sdate And [Shift]=:shift And [crew]=:crew";

		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("sdate", date);
		source.addValue("shift", shift);
		source.addValue("crew", crew);

		List<FrpProdcutionOperatorDataEntry> datas = jdbcTemplate.query(sql, source,
				new RowMapper<FrpProdcutionOperatorDataEntry>() {

					@Override
					public FrpProdcutionOperatorDataEntry mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						FrpProdcutionOperatorDataEntry data = new FrpProdcutionOperatorDataEntry();
						data.setId(rs.getInt("ID"));
						data.setDate(new Date(rs.getTimestamp("dates").getTime()));
						data.setShift(rs.getString("SHIFT") == null ? "" : rs.getString("SHIFT").toUpperCase());
						data.setCrew(rs.getString("crew") == null ? "" : rs.getString("crew").toUpperCase());
						data.setCol1(rs.getDouble("col1"));
						data.setCol2(rs.getDouble("col2"));
						data.setCol3(rs.getDouble("col3"));
						data.setCol4(rs.getDouble("col4"));
						data.setCol5(rs.getDouble("col5"));
						data.setCol6(rs.getDouble("col6"));
						data.setCol7(rs.getDouble("col7"));
						data.setCol8(rs.getDouble("col8"));
						data.setCol9(rs.getDouble("col9"));
						data.setCol10(rs.getDouble("col10"));
						data.setCol11(rs.getDouble("col11"));
						data.setCol12(rs.getDouble("col12"));
						return data;
					}

				});
		return datas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#checkexistentry(
	 * int)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> checkexistentry(int id) {
		// TODO Auto-generated method stub

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "select * From [FrpProdcutionOperatorDataEntry] Where [id]=:id";

		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("id", id);

		List<FrpProdcutionOperatorDataEntry> datas = jdbcTemplate.query(sql, source,
				new RowMapper<FrpProdcutionOperatorDataEntry>() {

					@Override
					public FrpProdcutionOperatorDataEntry mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						FrpProdcutionOperatorDataEntry data = new FrpProdcutionOperatorDataEntry();
						data.setId(rs.getInt("ID"));
						data.setDate(new Date(rs.getTimestamp("dates").getTime()));
						data.setCrew(rs.getString("Crew") == null ? "" : rs.getString("Crew").toUpperCase());
						data.setShift(rs.getString("SHIFT") == null ? "" : rs.getString("SHIFT").toUpperCase());
						data.setCol1(rs.getDouble("col1"));
						data.setCol2(rs.getDouble("col2"));
						data.setCol3(rs.getDouble("col3"));
						data.setCol4(rs.getDouble("col4"));
						data.setCol5(rs.getDouble("col5"));
						data.setCol6(rs.getDouble("col6"));
						data.setCol7(rs.getDouble("col7"));
						data.setCol8(rs.getDouble("col8"));
						data.setCol9(rs.getDouble("col9"));
						data.setCol10(rs.getDouble("col10"));
						data.setCol11(rs.getDouble("col11"));
						data.setCol12(rs.getDouble("col12"));
						data.setProductiontype(rs.getString("productiontype"));

						data.setCol11b(rs.getDouble("col11b"));
						data.setCol6b(rs.getDouble("col6b"));
						data.setCol7b(rs.getDouble("col7b"));
						data.setCol8b(rs.getDouble("col8b"));
						data.setCol9b(rs.getDouble("col9b"));
						data.setCol10b(rs.getDouble("col10b"));
						data.setCol10a(rs.getDouble("col10a"));
						data.setCol12b(rs.getDouble("col12b"));
						return data;
					}

				});
		return datas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#update(com.st.
	 * frpproduction.model.FrpProdcutionOperatorDataEntry)
	 */
	@Override
	public void update(final FrpProdcutionOperatorDataEntry colum) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		final String sql = "update [FrpProdcutionOperatorDataEntry] set " + "[crew]=?," + "[shift]=?," + "[col1]=?,"
				+ "[col2]=?," + "[col3]=?," + "[col4]=?," + "[col5]=?," + "[col6]=?," + "[col7]=?," + "[col8]=?,"
				+ "[col9]=?," + "[col10]=?," + "[col11]=?," + "[productiontype]=?,"

				+ "[col11b]=?," + "[col6b]=?," + "[col7b]=?," + "[col8b]=?," + "[col9b]=?," + "[col10b]=?,"
				+ "[col10a]=?," + "[col12b]=?," + "[col12]=?"

				// +"[crew]=?"
				+ " where [ID]=?";

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				PreparedStatement statement = arg0.prepareStatement(sql);
				// statement.setTimestamp(1, new Timestamp(colum.getDate().getTime()));
				statement.setString(1, colum.getCrew());
				statement.setString(2, colum.getShift());
				statement.setDouble(3, colum.getCol1());
				statement.setDouble(4, colum.getCol2());
				statement.setDouble(5, colum.getCol3());
				statement.setDouble(6, colum.getCol4());
				statement.setDouble(7, colum.getCol5());
				statement.setDouble(8, colum.getCol6());
				statement.setDouble(9, colum.getCol7());
				statement.setDouble(10, colum.getCol8());
				statement.setDouble(11, colum.getCol9());
				statement.setDouble(12, colum.getCol10());
				statement.setDouble(13, colum.getCol11());
				statement.setString(14, colum.getProductiontype());
				// statement.setString11, colum.getCrew());

				statement.setDouble(15, colum.getCol11b());
				statement.setDouble(16, colum.getCol6b());
				statement.setDouble(17, colum.getCol7b());
				statement.setDouble(18, colum.getCol8b());
				statement.setDouble(19, colum.getCol9b());
				statement.setDouble(20, colum.getCol10b());
				statement.setDouble(21, colum.getCol10a());
				statement.setDouble(22, colum.getCol12b());
				statement.setDouble(23, colum.getCol12());

				statement.setInt(24, colum.getId());
				return statement;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#
	 * getFrpProducationDataEntryReport(java.util.Date, java.util.Date)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> getFrpProducationDataEntryReport(Date sDate, Date eDate) {
		List<FrpProdcutionOperatorDataEntry> data = new ArrayList<FrpProdcutionOperatorDataEntry>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "Select * From [FrpProdcutionOperatorDataEntry] where [dates] between ? And ? ";
		List<Map<String, Object>> data1 = jdbcTemplate.queryForList(sql, new Object[] { sDate, eDate });
		final FrpProdcutionOperatorDataEntry opdetails = new FrpProdcutionOperatorDataEntry();
		double totalCol1 = 0;
		double totalCol2 = 0;
		double totalCol3 = 0;
		double totalCol4 = 0;
		double totalCol5 = 0;
		double totalCol6 = 0;
		double totalCol7 = 0;
		double totalCol8 = 0;
		double totalCol9 = 0;
		double totalCol10 = 0;
		double totalCol11 = 0;
		double totalCol12 = 0;
		double totalCol10a = 0;

		double totalCol11b = 0;
		double totalCol6b = 0;
		double totalCol7b = 0;
		double totalCol8b = 0;
		double totalCol9b = 0;
		double totalCol10b = 0;
		double totalCol12b = 0;

		double COL1forday = 0;
		double COL1fornight = 0;
		double COL2forday = 0;
		double COL2fornight = 0;
		double COL3forday = 0;
		double COL3fornight = 0;
		double COL4forday = 0;
		double COL4fornight = 0;
		double COL5forday = 0;
		double COL5fornight = 0;
		double COL6forday = 0;
		double COL6fornight = 0;
		double COL7forday = 0;
		double COL7fornight = 0;
		double COL8forday = 0;
		double COL8fornight = 0;
		double COL9forday = 0;
		double COL9fornight = 0;
		double COL10forday = 0;
		double COL10fornight = 0;
		double COL11forday = 0;
		double COL11fornight = 0;
		double COL10afornight = 0;
		double COL10aforday = 0;

		double COL12fornight = 0;
		double COL12forday = 0;

		double COL11bforday = 0;
		double COL6bforday = 0;
		double COL7bforday = 0;
		double COL8bforday = 0;
		double COL9bforday = 0;
		double COL10bforday = 0;
		double COL12bforday = 0;

		double COL11bfornight = 0;
		double COL6bfornight = 0;
		double COL7bfornight = 0;
		double COL8bfornight = 0;
		double COL9bfornight = 0;
		double COL10bfornight = 0;
		double COL12bfornight = 0;

		if (data1.size() > 0) {
			for (Map<String, Object> datas : data1) {
				int gradeId = (Integer) datas.get("id");
				Date date = (Date) datas.get("WeightDate".toUpperCase());
				String shift = (String) datas.get("shift".toUpperCase());
				double col1 = (Double) datas.get("col1") == null ? 0 : (Double) (datas.get("col1"));
				double col2 = (Double) datas.get("col2") == null ? 0 : (Double) (datas.get("col2"));
				double col3 = (Double) datas.get("col3") == null ? 0 : (Double) (datas.get("col3"));
				double col4 = (Double) datas.get("col4") == null ? 0 : (Double) (datas.get("col4"));
				double col5 = (Double) datas.get("col5") == null ? 0 : (Double) (datas.get("col5"));
				double col6 = (Double) datas.get("col6") == null ? 0 : (Double) (datas.get("col6"));
				double col7 = (Double) datas.get("col7") == null ? 0 : (Double) (datas.get("col7"));
				double col8 = (Double) datas.get("col8") == null ? 0 : (Double) (datas.get("col8"));
				double col9 = (Double) datas.get("col9") == null ? 0 : (Double) (datas.get("col9"));
				double col10 = (Double) datas.get("col10") == null ? 0 : (Double) (datas.get("col10"));
				double col11 = (Double) datas.get("col11") == null ? 0 : (Double) (datas.get("col11"));
				double col12 = (Double) datas.get("col12") == null ? 0 : (Double) (datas.get("col12"));
				double col10a = (Double) datas.get("col10a") == null ? 0 : (Double) (datas.get("col10a"));

				double col11b = (Double) datas.get("col11b") == null ? 0 : (Double) (datas.get("col11b"));
				double col6b = (Double) datas.get("col6b") == null ? 0 : (Double) (datas.get("col6b"));
				double col7b = (Double) datas.get("col7b") == null ? 0 : (Double) (datas.get("col7b"));
				double col8b = (Double) datas.get("col8b") == null ? 0 : (Double) (datas.get("col8b"));
				double col9b = (Double) datas.get("col9b") == null ? 0 : (Double) (datas.get("col9b"));
				double col10b = (Double) datas.get("col10b") == null ? 0 : (Double) (datas.get("col10b"));
				double col12b = (Double) datas.get("col12b") == null ? 0 : (Double) (datas.get("col12b"));

				totalCol1 = totalCol1 + col1;
				totalCol2 = totalCol2 + col2;
				totalCol3 = totalCol3 + col3;
				totalCol4 = totalCol4 + col4;
				totalCol5 = totalCol5 + col5;
				totalCol6 = totalCol6 + col6;
				totalCol7 = totalCol7 + col7;
				totalCol8 = totalCol8 + col8;
				totalCol9 = totalCol9 + col9;
				totalCol10 = totalCol10 + col10;
				totalCol11 = totalCol11 + col11;
				totalCol12 = totalCol12 + col12;
				totalCol10a = totalCol10a + col10a;

				totalCol11b = totalCol11b + col11b;
				totalCol6b = totalCol6b + col6b;
				totalCol7b = totalCol7b + col7b;
				totalCol8b = totalCol8b + col8b;
				totalCol9b = totalCol9b + col9b;
				totalCol10b = totalCol10b + col10b;
				totalCol12b = totalCol12b + col12b;

				if (shift.equalsIgnoreCase("DAY")) {
					COL1forday = COL1forday + col1;
					COL2forday = COL2forday + col2;
					COL3forday = COL3forday + col3;
					COL4forday = COL4forday + col4;
					COL5forday = COL5forday + col5;
					COL6forday = COL6forday + col6;
					COL7forday = COL7forday + col7;
					COL8forday = COL8forday + col8;
					COL9forday = COL9forday + col9;
					COL10forday = COL10forday + col10;
					COL11forday = COL11forday + col11;
					COL12forday = COL12forday + col12;
					COL10aforday = COL10aforday + col10a;

					COL11bforday = COL11bforday + col11b;
					COL6bforday = COL6bforday + col6b;
					COL7bforday = COL7bforday + col7b;
					COL8bforday = COL8bforday + col8b;
					COL9bforday = COL9bforday + col9b;
					COL10bforday = COL10bforday + col10b;
					COL12bforday = COL12bforday + col12b;

					opdetails.setDayshift("Day");
					opdetails.setCol1forday(COL1forday);
					opdetails.setCol2forday(COL2forday);
					opdetails.setCol3forday(COL3forday);
					opdetails.setCol4forday(COL4forday);
					opdetails.setCol5forday(COL5forday);
					opdetails.setCol6forday(COL6forday);
					opdetails.setCol7forday(COL7forday);
					opdetails.setCol8forday(COL8forday);
					opdetails.setCol9forday(COL9forday);
					opdetails.setCol10forday(COL10forday);
					opdetails.setCol10aforday(COL10aforday);
					opdetails.setCol11forday(COL11forday);
					opdetails.setCol12forday(COL12forday);
					opdetails.setCol10aforday(COL11forday);

					opdetails.setCol11bforday(COL11bforday);
					opdetails.setCol6bforday(COL6bforday);
					opdetails.setCol7bforday(COL7bforday);
					opdetails.setCol8bforday(COL8bforday);
					opdetails.setCol9bforday(COL9bforday);
					opdetails.setCol10bforday(COL10bforday);
					opdetails.setCol12bforday(COL12bforday);
				} else {
					COL1fornight = COL1fornight + col1;
					COL2fornight = COL2fornight + col2;
					COL3fornight = COL3fornight + col3;
					COL4fornight = COL4fornight + col4;
					COL5fornight = COL5fornight + col5;
					COL6fornight = COL6fornight + col6;
					COL7fornight = COL7fornight + col7;
					COL8fornight = COL8fornight + col8;
					COL9fornight = COL9fornight + col9;
					COL10fornight = COL10fornight + col10;
					COL12fornight = COL12fornight + col12;
					COL10afornight = COL10afornight + col10a;
					COL11fornight = COL11fornight + col11;

					COL11bfornight = COL11bfornight + col11b;
					COL6bfornight = COL6bfornight + col6b;
					COL7bfornight = COL7bfornight + col7b;
					COL8bfornight = COL8bfornight + col8b;
					COL9bfornight = COL9bfornight + col9b;
					COL10bfornight = COL10bfornight + col10b;
					COL12bfornight = COL12bfornight + col12b;

					opdetails.setNightshift("Night");
					opdetails.setCol1fornight(COL1fornight);
					opdetails.setCol2fornight(COL2fornight);
					opdetails.setCol3fornight(COL3fornight);
					opdetails.setCol4fornight(COL4fornight);
					opdetails.setCol5fornight(COL5fornight);
					opdetails.setCol6fornight(COL6fornight);
					opdetails.setCol7fornight(COL7fornight);
					opdetails.setCol8fornight(COL8fornight);
					opdetails.setCol9fornight(COL9fornight);
					opdetails.setCol10fornight(COL10fornight);
					opdetails.setCol11fornight(COL11fornight);
					opdetails.setCol10afornight(COL10afornight);

					opdetails.setCol11bfornight(COL11bfornight);
					opdetails.setCol6bfornight(COL6bfornight);
					opdetails.setCol7bfornight(COL7bfornight);
					opdetails.setCol8bfornight(COL8bfornight);
					opdetails.setCol9bfornight(COL9bfornight);
					opdetails.setCol10bfornight(COL10bfornight);
					opdetails.setCol12bfornight(COL12bfornight);
					opdetails.setCol12fornight(COL12fornight);
				}
			}
			opdetails.setTotalcol1(totalCol1);
			opdetails.setTotalcol2(totalCol2);
			opdetails.setTotalcol3(totalCol3);
			opdetails.setTotalcol4(totalCol4);
			opdetails.setTotalcol5(totalCol5);
			opdetails.setTotalcol6(totalCol6);
			opdetails.setTotalcol7(totalCol7);
			opdetails.setTotalcol8(totalCol8);
			opdetails.setTotalcol9(totalCol9);
			opdetails.setTotalcol10(totalCol10);
			opdetails.setTotalcol10a(totalCol10a);
			opdetails.setTotalcol11(totalCol11);
			opdetails.setTotalcol12(totalCol12);

			opdetails.setTotalcol11b(totalCol11b);
			opdetails.setTotalcol6b(totalCol6b);
			opdetails.setTotalcol7b(totalCol7b);
			opdetails.setTotalcol8b(totalCol8b);
			opdetails.setTotalcol9b(totalCol9b);
			opdetails.setTotalcol10b(totalCol10b);
			opdetails.setTotalcol12b(totalCol12b);

			data.add(opdetails);
		} else {
			System.out.println("DataSize  "+data1.size());
		}
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#
	 * getFrpProducationDataEntryDetailedReport(java.util.Date, java.util.Date)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> getFrpProducationDataEntryDetailedReport(Date sdate, Date edate) {
		List<FrpProdcutionOperatorDataEntry> data = new ArrayList<FrpProdcutionOperatorDataEntry>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdate);

		System.out.println("sdate:" + sdate);
		int days = Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();

		Calendar date = Calendar.getInstance();
		date.setTime(sdate);

		for (int i = 0; i <= days; i++) {

			Calendar scal = Calendar.getInstance();
			scal.setTime(date.getTime());

			/*
			 * final FrpProdcutionOperatorDataEntry opdetails=new
			 * FrpProdcutionOperatorDataEntry();
			 */

			double totalCol1 = 0;
			double totalCol2 = 0;
			double totalCol3 = 0;
			double totalCol4 = 0;
			double totalCol5 = 0;
			double totalCol6 = 0;
			double totalCol7 = 0;
			double totalCol8 = 0;
			double totalCol9 = 0;
			double totalCol10 = 0;
			double totalCol11 = 0;
			double totalCol12 = 0;
			double totalCol10a = 0;

			double totalCol11b = 0;
			double totalCol6b = 0;
			double totalCol7b = 0;
			double totalCol8b = 0;
			double totalCol9b = 0;
			double totalCol10b = 0;
			double totalCol12b = 0;

			double COL1forday = 0;
			double COL1fornight = 0;
			double COL2forday = 0;
			double COL2fornight = 0;
			double COL3forday = 0;
			double COL3fornight = 0;
			double COL4forday = 0;
			double COL4fornight = 0;
			double COL5forday = 0;
			double COL5fornight = 0;
			double COL6forday = 0;
			double COL6fornight = 0;
			double COL7forday = 0;
			double COL7fornight = 0;
			double COL8forday = 0;
			double COL8fornight = 0;
			double COL9forday = 0;
			double COL9fornight = 0;
			double COL10forday = 0;
			double COL10fornight = 0;
			double COL11forday = 0;
			double COL11fornight = 0;
			double COL10aforday = 0;
			double COL10afornight = 0;
			double COL12forday = 0;
			double COL12fornight = 0;

			double COL11bforday = 0;
			double COL6bforday = 0;
			double COL7bforday = 0;
			double COL8bforday = 0;
			double COL9bforday = 0;
			double COL10bforday = 0;
			double COL12bforday = 0;

			double COL11bfornight = 0;
			double COL6bfornight = 0;
			double COL7bfornight = 0;
			double COL8bfornight = 0;
			double COL9bfornight = 0;
			double COL10bfornight = 0;
			double COL12bfornight = 0;

			Date dateS = scal.getTime();
//			opdetails.setDate(dateS);

			String sql = "Select * From [FrpProdcutionOperatorDataEntry] where [dates]=? order by [shift]";
			List<Map<String, Object>> data1 = jdbcTemplate.queryForList(sql, new Object[] { scal.getTime() });

			double col1 = 0;
			double col2 = 0;
			double col3 = 0;
			double col4 = 0;
			double col5 = 0;
			double col6 = 0;
			double col7 = 0;
			double col8 = 0;
			double col9 = 0;
			double col10 = 0;
			double col11 = 0;
			double col12 = 0;
			double col10a = 0;

			double col11b = 0;
			double col6b = 0;
			double col7b = 0;
			double col8b = 0;
			double col9b = 0;
			double col10b = 0;
			double col12b = 0;

			if (data1.size() > 0) {
				for (Map<String, Object> datas : data1) {

					final FrpProdcutionOperatorDataEntry opdetails = new FrpProdcutionOperatorDataEntry();

					opdetails.setDate(dateS);

					int id = (int) datas.get("id".toUpperCase());
					String shift = (String) datas.get("shift".toUpperCase());
					String crew = (String) datas.get("crew".toUpperCase());
					String productiontype = (String) datas.get("productiontype".toUpperCase());
					opdetails.setId(id);
					opdetails.setShift(shift);
					opdetails.setCrew(crew);
					opdetails.setProductiontype(productiontype);

					col1 = (Double) datas.get("col1") == null ? 0 : (Double) (datas.get("col1"));
					col2 = (Double) datas.get("col2") == null ? 0 : (Double) (datas.get("col2"));
					col3 = (Double) datas.get("col3") == null ? 0 : (Double) (datas.get("col3"));
					col4 = (Double) datas.get("col4") == null ? 0 : (Double) (datas.get("col4"));
					col5 = (Double) datas.get("col5") == null ? 0 : (Double) (datas.get("col5"));
					col6 = (Double) datas.get("col6") == null ? 0 : (Double) (datas.get("col6"));
					col7 = (Double) datas.get("col7") == null ? 0 : (Double) (datas.get("col7"));
					col8 = (Double) datas.get("col8") == null ? 0 : (Double) (datas.get("col8"));
					col9 = (Double) datas.get("col9") == null ? 0 : (Double) (datas.get("col9"));
					col10 = (Double) datas.get("col10") == null ? 0 : (Double) (datas.get("col10"));
					col11 = (Double) datas.get("col11") == null ? 0 : (Double) (datas.get("col11"));
					col12 = (Double) datas.get("col12") == null ? 0 : (Double) (datas.get("col12"));
					col10a = (Double) datas.get("col10a") == null ? 0 : (Double) (datas.get("col10a"));

					col11b = (Double) datas.get("col11b") == null ? 0 : (Double) (datas.get("col11b"));
					col6b = (Double) datas.get("col6b") == null ? 0 : (Double) (datas.get("col6b"));
					col7b = (Double) datas.get("col7b") == null ? 0 : (Double) (datas.get("col7b"));
					col8b = (Double) datas.get("col8b") == null ? 0 : (Double) (datas.get("col8b"));
					col9b = (Double) datas.get("col9b") == null ? 0 : (Double) (datas.get("col9b"));
					col10b = (Double) datas.get("col10b") == null ? 0 : (Double) (datas.get("col10b"));
					col12b = (Double) datas.get("col12b") == null ? 0 : (Double) (datas.get("col12b"));

					totalCol1 = totalCol1 + col1;
					totalCol2 = totalCol2 + col2;
					totalCol3 = totalCol3 + col3;
					totalCol4 = totalCol4 + col4;
					totalCol5 = totalCol5 + col5;
					totalCol6 = totalCol6 + col6;
					totalCol7 = totalCol7 + col7;
					totalCol8 = totalCol8 + col8;
					totalCol9 = totalCol9 + col9;
					totalCol10 = totalCol10 + col10;
					totalCol12 = totalCol12 + col12;
					totalCol10a = totalCol10a + col10a;

					totalCol11b = totalCol11b + col11b;
					totalCol6b = totalCol6b + col6b;
					totalCol7b = totalCol7b + col7b;
					totalCol8b = totalCol8b + col8b;
					totalCol9b = totalCol9b + col9b;
					totalCol10b = totalCol10b + col10b;
					totalCol12b = totalCol12b + col12b;

					if (shift.equalsIgnoreCase("DAY")) {
						COL1forday = COL1forday + col1;
						COL2forday = COL2forday + col2;
						COL3forday = COL3forday + col3;
						COL4forday = COL4forday + col4;
						COL5forday = COL5forday + col5;
						COL6forday = COL6forday + col6;
						COL7forday = COL7forday + col7;
						COL8forday = COL8forday + col8;
						COL9forday = COL9forday + col9;
						COL10forday = COL10forday + col10;
						COL11forday = COL11forday + col11;
						COL12forday = COL12forday + col12;
						COL10aforday = COL10aforday + col10a;

						COL11bforday = COL11bforday + col11b;
						COL6bforday = COL6bforday + col6b;
						COL7bforday = COL7bforday + col7b;
						COL8bforday = COL8bforday + col8b;
						COL9bforday = COL9bforday + col9b;
						COL10bforday = COL10bforday + col10b;
						COL12bforday = COL12bforday + col12b;

						opdetails.setDayshift("Day");
						opdetails.setCol1forday(COL1forday);
						opdetails.setCol2forday(COL2forday);
						opdetails.setCol3forday(COL3forday);
						opdetails.setCol4forday(COL4forday);
						opdetails.setCol5forday(COL5forday);
						opdetails.setCol6forday(COL6forday);
						opdetails.setCol7forday(COL7forday);
						opdetails.setCol8forday(COL8forday);
						opdetails.setCol9forday(COL9forday);
						opdetails.setCol10forday(COL10forday);
						opdetails.setCol11forday(COL11forday);
						opdetails.setCol12forday(COL12forday);
						opdetails.setCol10aforday(COL10aforday);

						opdetails.setCol11bforday(COL11bforday);
						opdetails.setCol6bforday(COL6bforday);
						opdetails.setCol7bforday(COL7bforday);
						opdetails.setCol8bforday(COL8bforday);
						opdetails.setCol9bforday(COL9bforday);
						opdetails.setCol10bforday(COL10bforday);
						opdetails.setCol12bforday(COL12bforday);

					} else {
						COL1fornight = COL1fornight + col1;
						COL2fornight = COL2fornight + col2;
						COL3fornight = COL3fornight + col3;
						COL4fornight = COL4fornight + col4;
						COL5fornight = COL5fornight + col5;
						COL6fornight = COL6fornight + col6;
						COL7fornight = COL7fornight + col7;
						COL8fornight = COL8fornight + col8;
						COL9fornight = COL9fornight + col9;
						COL10fornight = COL10fornight + col10;
						COL11fornight = COL11fornight + col11;
						COL12fornight = COL12fornight + col12;
						COL10afornight = COL10afornight + col10a;

						COL11bfornight = COL11bfornight + col11b;
						COL6bfornight = COL6bfornight + col6b;
						COL7bfornight = COL7bfornight + col7b;
						COL8bfornight = COL8bfornight + col8b;
						COL9bfornight = COL9bfornight + col9b;
						COL10bfornight = COL10bfornight + col10b;
						COL12bfornight = COL12bfornight + col12b;

						opdetails.setNightshift("Night");
						opdetails.setCol1fornight(COL1fornight);
						opdetails.setCol2fornight(COL2fornight);
						opdetails.setCol3fornight(COL3fornight);
						opdetails.setCol4fornight(COL4fornight);
						opdetails.setCol5fornight(COL5fornight);
						opdetails.setCol6fornight(COL6fornight);
						opdetails.setCol7fornight(COL7fornight);
						opdetails.setCol8fornight(COL8fornight);
						opdetails.setCol9fornight(COL9fornight);
						opdetails.setCol10fornight(COL10fornight);
						opdetails.setCol11fornight(COL11fornight);
						opdetails.setCol10afornight(COL10afornight);
						opdetails.setCol12fornight(COL12fornight);

						opdetails.setCol11bfornight(COL11bfornight);
						opdetails.setCol6bfornight(COL6bfornight);
						opdetails.setCol7bfornight(COL7bfornight);
						opdetails.setCol8bfornight(COL8bfornight);
						opdetails.setCol9bfornight(COL9bfornight);
						opdetails.setCol10bfornight(COL10bfornight);
						opdetails.setCol12bfornight(COL12bfornight);

					}
					opdetails.setCol1(col1);
					opdetails.setCol2(col2);
					opdetails.setCol3(col3);
					opdetails.setCol4(col4);
					opdetails.setCol5(col5);
					opdetails.setCol6(col6);
					opdetails.setCol7(col7);
					opdetails.setCol8(col8);
					opdetails.setCol9(col9);
					opdetails.setCol10(col10);
					opdetails.setCol11(col11);
					opdetails.setCol12(col12);
					opdetails.setCol10a(col10a);

					opdetails.setCol11b(col11b);
					opdetails.setCol6b(col6b);
					opdetails.setCol7b(col7b);
					opdetails.setCol8b(col8b);
					opdetails.setCol9b(col9b);
					opdetails.setCol10b(col10b);
					opdetails.setCol12b(col12b);

					opdetails.setTotalcol1(totalCol1);
					opdetails.setTotalcol2(totalCol2);
					opdetails.setTotalcol3(totalCol3);
					opdetails.setTotalcol4(totalCol4);
					opdetails.setTotalcol5(totalCol5);
					opdetails.setTotalcol6(totalCol6);
					opdetails.setTotalcol7(totalCol7);
					opdetails.setTotalcol8(totalCol8);
					opdetails.setTotalcol9(totalCol9);
					opdetails.setTotalcol10(totalCol10);
					opdetails.setTotalcol11(totalCol11);
					opdetails.setTotalcol12(totalCol12);
					opdetails.setTotalcol10a(totalCol10a);

					opdetails.setTotalcol11b(totalCol11b);
					opdetails.setTotalcol6b(totalCol6b);
					opdetails.setTotalcol7b(totalCol7b);
					opdetails.setTotalcol8b(totalCol8b);
					opdetails.setTotalcol9b(totalCol9b);
					opdetails.setTotalcol10b(totalCol10b);
					opdetails.setTotalcol12b(totalCol12b);

					data.add(opdetails);
				}
				/*
				 * opdetails.setTotalcol1(totalCol1); opdetails.setTotalcol2(totalCol2);
				 * opdetails.setTotalcol3(totalCol3); opdetails.setTotalcol4(totalCol4);
				 * opdetails.setTotalcol5(totalCol5); opdetails.setTotalcol6(totalCol6);
				 * opdetails.setTotalcol7(totalCol7); opdetails.setTotalcol8(totalCol8);
				 * opdetails.setTotalcol9(totalCol9); opdetails.setTotalcol10(totalCol10);
				 */

				/* data.add(opdetails); */
			} /*
				 * else{
				 * 
				 * 
				 * final FrpProdcutionOperatorDataEntry opdetails=new
				 * FrpProdcutionOperatorDataEntry();
				 * 
				 * opdetails.setDate(dateS);
				 * 
				 * opdetails.setShift(""); opdetails.setCrew("");
				 * 
				 * 
				 * col1=(Double)datas.get("col1")==null?0:(Double)(datas.get("col1"));
				 * col2=(Double)datas.get("col2")==null?0:(Double)(datas.get("col2"));
				 * col3=(Double)datas.get("col3")==null?0:(Double)(datas.get("col3"));
				 * col4=(Double)datas.get("col4")==null?0:(Double)(datas.get("col4"));
				 * col5=(Double)datas.get("col5")==null?0:(Double)(datas.get("col5"));
				 * col6=(Double)datas.get("col6")==null?0:(Double)(datas.get("col6"));
				 * col7=(Double)datas.get("col7")==null?0:(Double)(datas.get("col7"));
				 * col8=(Double)datas.get("col8")==null?0:(Double)(datas.get("col8"));
				 * col9=(Double)datas.get("col9")==null?0:(Double)(datas.get("col9"));
				 * col10=(Double)datas.get("col10")==null?0:(Double)(datas.get("col10"));
				 * col11=(Double)datas.get("col11")==null?0:(Double)(datas.get("col11"));
				 * 
				 * totalCol1=totalCol1+col1; totalCol2=totalCol2+col2; totalCol3=totalCol3+col3;
				 * totalCol4=totalCol4+col4; totalCol5=totalCol5+col5; totalCol6=totalCol6+col6;
				 * totalCol7=totalCol7+col7; totalCol8=totalCol8+col8; totalCol9=totalCol9+col9;
				 * totalCol10=totalCol10+col10; totalCol10a=totalCol10a+col10a;
				 * 
				 * totalCol11b=totalCol11b+col11b; totalCol6b=totalCol6b+col6b;
				 * totalCol7b=totalCol7b+col7b; totalCol8b=totalCol8b+col8b;
				 * totalCol9b=totalCol9b+col9b; totalCol10b=totalCol10b+col10b;
				 * totalCol12b=totalCol12b+col12b;
				 * 
				 * 
				 * 
				 * COL1forday=COL1forday+col1; COL2forday=COL2forday+col2;
				 * COL3forday=COL3forday+col3; COL4forday=COL4forday+col4;
				 * COL5forday=COL5forday+col5; COL6forday=COL6forday+col6;
				 * COL7forday=COL7forday+col7; COL8forday=COL8forday+col8;
				 * COL9forday=COL9forday+col9; COL10forday=COL10forday+col10;
				 * COL11forday=COL11forday+col11; COL10aforday=COL10aforday+col10a;
				 * 
				 * 
				 * COL11bforday=COL11bforday+col11b; COL6bforday=COL6bforday+col6b;
				 * COL7bforday=COL7bforday+col7b; COL8bforday=COL8bforday+col8b;
				 * COL9bforday=COL9bforday+col9b; COL10bforday=COL10bforday+col10b;
				 * COL12bforday=COL12bforday+col12b;
				 * 
				 * opdetails.setDayshift("Day"); opdetails.setCol1forday(COL1forday);
				 * opdetails.setCol2forday(COL2forday); opdetails.setCol3forday(COL3forday);
				 * opdetails.setCol4forday(COL4forday); opdetails.setCol5forday(COL5forday);
				 * opdetails.setCol6forday(COL6forday); opdetails.setCol7forday(COL7forday);
				 * opdetails.setCol8forday(COL8forday); opdetails.setCol9forday(COL9forday);
				 * opdetails.setCol10forday(COL10forday); opdetails.setCol11forday(COL11forday);
				 * opdetails.setCol10aforday(COL10aforday);
				 * 
				 * opdetails.setCol11bforday(COL11bforday);
				 * opdetails.setCol6bforday(COL6bforday); opdetails.setCol7bforday(COL7bforday);
				 * opdetails.setCol8bforday(COL8bforday); opdetails.setCol9bforday(COL9bforday);
				 * opdetails.setCol10bforday(COL10bforday);
				 * opdetails.setCol12bforday(COL12bforday);
				 * 
				 * 
				 * COL1fornight=COL1fornight+col1; COL2fornight=COL2fornight+col2;
				 * COL3fornight=COL3fornight+col3; COL4fornight=COL4fornight+col4;
				 * COL5fornight=COL5fornight+col5; COL6fornight=COL6fornight+col6;
				 * COL7fornight=COL7fornight+col7; COL8fornight=COL8fornight+col8;
				 * COL9fornight=COL9fornight+col9; COL10fornight=COL10fornight+col10;
				 * COL11fornight=COL11fornight+col11; COL10afornight=COL10afornight+col10a;
				 * 
				 * 
				 * COL11bfornight=COL11bfornight+col11b; COL6bfornight=COL6bfornight+col6b;
				 * COL7bfornight=COL7bfornight+col7b; COL8bfornight=COL8bfornight+col8b;
				 * COL9bfornight=COL9bfornight+col9b; COL10bfornight=COL10bfornight+col10b;
				 * COL12bfornight=COL12bfornight+col12b;
				 * 
				 * 
				 * opdetails.setNightshift("Night"); opdetails.setCol1fornight(COL1fornight);
				 * opdetails.setCol2fornight(COL2fornight);
				 * opdetails.setCol3fornight(COL3fornight);
				 * opdetails.setCol4fornight(COL4fornight);
				 * opdetails.setCol5fornight(COL5fornight);
				 * opdetails.setCol6fornight(COL6fornight);
				 * opdetails.setCol7fornight(COL7fornight);
				 * opdetails.setCol8fornight(COL8fornight);
				 * opdetails.setCol9fornight(COL9fornight);
				 * opdetails.setCol10fornight(COL10fornight);
				 * opdetails.setCol11fornight(COL11fornight);
				 * opdetails.setCol10afornight(COL10afornight);
				 * 
				 * opdetails.setCol11bfornight(COL11bfornight);
				 * opdetails.setCol6bfornight(COL6bfornight);
				 * opdetails.setCol7bfornight(COL7bfornight);
				 * opdetails.setCol8bfornight(COL8bfornight);
				 * opdetails.setCol9bfornight(COL9bfornight);
				 * opdetails.setCol10bfornight(COL10bfornight);
				 * opdetails.setCol12bfornight(COL12bfornight);
				 * 
				 * 
				 * opdetails.setCol1(col1); opdetails.setCol2(col2); opdetails.setCol3(col3);
				 * opdetails.setCol4(col4); opdetails.setCol5(col5); opdetails.setCol6(col6);
				 * opdetails.setCol7(col7); opdetails.setCol8(col8); opdetails.setCol9(col9);
				 * opdetails.setCol10(col10); opdetails.setCol11(col11);
				 * opdetails.setCol10a(col10a);
				 * 
				 * opdetails.setCol11b(col11b); opdetails.setCol6b(col6b);
				 * opdetails.setCol7b(col7b); opdetails.setCol8b(col8b);
				 * opdetails.setCol9b(col9b); opdetails.setCol10b(col10b);
				 * opdetails.setCol12b(col12b);
				 * 
				 * 
				 * opdetails.setTotalcol1(totalCol1); opdetails.setTotalcol2(totalCol2);
				 * opdetails.setTotalcol3(totalCol3); opdetails.setTotalcol4(totalCol4);
				 * opdetails.setTotalcol5(totalCol5); opdetails.setTotalcol6(totalCol6);
				 * opdetails.setTotalcol7(totalCol7); opdetails.setTotalcol8(totalCol8);
				 * opdetails.setTotalcol9(totalCol9); opdetails.setTotalcol10(totalCol10);
				 * opdetails.setTotalcol11(totalCol11); opdetails.setTotalcol10a(totalCol10a);
				 * 
				 * opdetails.setTotalcol11b(totalCol11b); opdetails.setTotalcol6b(totalCol6b);
				 * opdetails.setTotalcol7b(totalCol7b); opdetails.setTotalcol8b(totalCol8b);
				 * opdetails.setTotalcol9b(totalCol9b); opdetails.setTotalcol10b(totalCol10b);
				 * opdetails.setTotalcol12b(totalCol12b);
				 * 
				 * 
				 * 
				 * data.add(opdetails);
				 * 
				 * }
				 */
			date.add(Calendar.DATE, 1);
		}
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#
	 * getFrpProducationBackDatedEntryShow(java.util.Date, java.lang.String)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> getFrpProducationBackDatedEntryShow(Date sDate, String shift,
			String crew) {
		// TODO Auto-generated method stub

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "select * From [FrpProdcutionOperatorDataEntry] Where [dates]=:sdate And [Shift]=:shift And [crew]=:crew";

		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("sdate", sDate);
		source.addValue("shift", shift);
		source.addValue("crew", crew);

		List<FrpProdcutionOperatorDataEntry> datas = jdbcTemplate.query(sql, source,
				new RowMapper<FrpProdcutionOperatorDataEntry>() {

					@Override
					public FrpProdcutionOperatorDataEntry mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						FrpProdcutionOperatorDataEntry data = new FrpProdcutionOperatorDataEntry();
						data.setId(rs.getInt("ID"));
						data.setDate(new Date(rs.getTimestamp("dates").getTime()));
						data.setShift(rs.getString("SHIFT") == null ? "" : rs.getString("SHIFT").toUpperCase());
						data.setCrew(rs.getString("crew") == null ? "" : rs.getString("crew").toUpperCase());
						data.setCol1(rs.getDouble("col1"));
						data.setCol2(rs.getDouble("col2"));
						data.setCol3(rs.getDouble("col3"));
						data.setCol4(rs.getDouble("col4"));
						data.setCol5(rs.getDouble("col5"));
						data.setCol6(rs.getDouble("col6"));
						data.setCol7(rs.getDouble("col7"));
						data.setCol8(rs.getDouble("col8"));
						data.setCol9(rs.getDouble("col9"));
						data.setCol10(rs.getDouble("col10"));
						data.setCol11(rs.getDouble("col11"));
						data.setCol12(rs.getDouble("col12"));
						data.setCol10a(rs.getDouble("col10a"));

						data.setCol11b(rs.getDouble("col11b"));
						data.setCol6b(rs.getDouble("col6b"));
						data.setCol7b(rs.getDouble("col7b"));
						data.setCol8b(rs.getDouble("col8b"));
						data.setCol9b(rs.getDouble("col9b"));
						data.setCol10b(rs.getDouble("col10b"));
						data.setCol12b(rs.getDouble("col12b"));

						return data;
					}

				});
		return datas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#
	 * getFrpProducationBackDatedEntryShow1(java.util.Date, java.lang.String)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> getFrpProducationBackDatedEntryShow1(Date sDate, String shift) {
		// TODO Auto-generated method stub

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "select * From [FrpProdcutionOperatorDataEntry] Where [dates]=:sdate And [Shift]=:shift";

		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("sdate", sDate);
		source.addValue("shift", shift);

		List<FrpProdcutionOperatorDataEntry> datas = jdbcTemplate.query(sql, source,
				new RowMapper<FrpProdcutionOperatorDataEntry>() {

					@Override
					public FrpProdcutionOperatorDataEntry mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						FrpProdcutionOperatorDataEntry data = new FrpProdcutionOperatorDataEntry();
						data.setId(rs.getInt("ID"));
						data.setDate(new Date(rs.getTimestamp("dates").getTime()));
						data.setShift(rs.getString("SHIFT") == null ? "" : rs.getString("SHIFT").toUpperCase());
						data.setCrew(rs.getString("crew") == null ? "" : rs.getString("crew").toUpperCase());
						data.setCol1(rs.getDouble("col1"));
						data.setCol2(rs.getDouble("col2"));
						data.setCol3(rs.getDouble("col3"));
						data.setCol4(rs.getDouble("col4"));
						data.setCol5(rs.getDouble("col5"));
						data.setCol6(rs.getDouble("col6"));
						data.setCol7(rs.getDouble("col7"));
						data.setCol8(rs.getDouble("col8"));
						data.setCol9(rs.getDouble("col9"));
						data.setCol10(rs.getDouble("col10"));
						data.setCol11(rs.getDouble("col11"));
						data.setCol12(rs.getDouble("col12"));
						data.setCol10a(rs.getDouble("col10a"));

						data.setCol11b(rs.getDouble("col11b"));
						data.setCol6b(rs.getDouble("col6b"));
						data.setCol7b(rs.getDouble("col7b"));
						data.setCol8b(rs.getDouble("col8b"));
						data.setCol9b(rs.getDouble("col9b"));
						data.setCol10b(rs.getDouble("col10b"));
						data.setCol12b(rs.getDouble("col12b"));
						return data;
					}

				});
		return datas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#checkexistentry1(
	 * java.util.Date, java.lang.String)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> checkexistentry1(Date date, String shift) {
		// TODO Auto-generated method stub

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "select * From [FrpProdcutionOperatorDataEntry] Where [dates]=:sdate And [Shift]=:shift";

		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("sdate", date);
		source.addValue("shift", shift);

		List<FrpProdcutionOperatorDataEntry> datas = jdbcTemplate.query(sql, source,
				new RowMapper<FrpProdcutionOperatorDataEntry>() {

					@Override
					public FrpProdcutionOperatorDataEntry mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						FrpProdcutionOperatorDataEntry data = new FrpProdcutionOperatorDataEntry();
						data.setId(rs.getInt("ID"));
						data.setDate(new Date(rs.getTimestamp("dates").getTime()));
						data.setShift(rs.getString("SHIFT") == null ? "" : rs.getString("SHIFT").toUpperCase());
						data.setCrew(rs.getString("crew") == null ? "" : rs.getString("crew").toUpperCase());
						data.setCol1(rs.getDouble("col1"));
						data.setCol2(rs.getDouble("col2"));
						data.setCol3(rs.getDouble("col3"));
						data.setCol4(rs.getDouble("col4"));
						data.setCol5(rs.getDouble("col5"));
						data.setCol6(rs.getDouble("col6"));
						data.setCol7(rs.getDouble("col7"));
						data.setCol8(rs.getDouble("col8"));
						data.setCol9(rs.getDouble("col9"));
						data.setCol10(rs.getDouble("col10"));
						data.setCol12(rs.getDouble("col12"));
						return data;
					}

				});
		return datas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#getcol1avg(java.
	 * util.Date, java.util.Date)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> getcol1avg(Date sDate, Date eDate) {
		// TODO Auto-generated method stub

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "SELECT AVG (col1) As Col1AVG, AVG (col2) As Col2AVG, AVG (col3) As Col3AVG, AVG (col4) As Col4AVG, AVG (col5) As Col5AVG, AVG (col12) As Col12AVG"
				+ ", AVG (col6) As Col6AVG, AVG (col7) As Col7AVG, AVG (col8) As Col8AVG, AVG (col9) As Col9AVG, AVG (col10) As Col10AVG, AVG (col11) As Col11AVG, "
				+ " AVG (col11b) As col11b,AVG (col6b) As col6b,AVG (col7b) As col7b,AVG (col8b) As col8b,AVG (col9b) As col9b,AVG (col10b) As col10b"
				+ " ,AVG (col10a) As col10a, AVG (col12b) As col12b"
				+ " FROM FrpProdcutionOperatorDataEntry where Dates between :sdate And :eDate AND [crew]='A'";

		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("sdate", sDate);
		source.addValue("eDate", eDate);

		List<FrpProdcutionOperatorDataEntry> datas = jdbcTemplate.query(sql, source,
				new RowMapper<FrpProdcutionOperatorDataEntry>() {

					@Override
					public FrpProdcutionOperatorDataEntry mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						FrpProdcutionOperatorDataEntry data = new FrpProdcutionOperatorDataEntry();
						data.setCol1(rs.getDouble("Col1AVG"));
						data.setCol2(rs.getDouble("Col2AVG"));
						data.setCol3(rs.getDouble("Col3AVG"));
						data.setCol4(rs.getDouble("Col4AVG"));
						data.setCol5(rs.getDouble("Col5AVG"));
						data.setCol6(rs.getDouble("Col6AVG"));
						data.setCol7(rs.getDouble("Col7AVG"));
						data.setCol8(rs.getDouble("Col8AVG"));
						data.setCol9(rs.getDouble("Col9AVG"));
						data.setCol10(rs.getDouble("Col10AVG"));
						data.setCol11(rs.getDouble("Col11AVG"));
						data.setCol12(rs.getDouble("Col12AVG"));

						data.setCol11b(rs.getDouble("Col11b"));
						data.setCol6b(rs.getDouble("Col6b"));
						data.setCol7b(rs.getDouble("Col7b"));
						data.setCol8b(rs.getDouble("Col8b"));
						data.setCol9b(rs.getDouble("Col9b"));
						data.setCol10b(rs.getDouble("Col10b"));
						data.setCol10a(rs.getDouble("Col10a"));
						data.setCol12b(rs.getDouble("Col12b"));
						return data;
					}

				});
		return datas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#getcol1avg1(java.
	 * util.Date, java.util.Date)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> getcol1avg1(Date sDate, Date eDate) {
		// TODO Auto-generated method stub

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "SELECT AVG (col1) As Col1AVG, AVG (col2) As Col2AVG, AVG (col3) As Col3AVG, AVG (col4) As Col4AVG, AVG (col5) As Col5AVG,AVG (col12) As Col12AVG"
				+ ", AVG (col6) As Col6AVG, AVG (col7) As Col7AVG, AVG (col8) As Col8AVG, AVG (col9) As Col9AVG, AVG (col10) As Col10AVG, AVG (col11) As Col11AVG, "
				+ " AVG (col11b) As col11b,AVG (col6b) As col6b,AVG (col7b) As col7b,AVG (col8b) As col8b,AVG (col9b) As col9b,AVG (col10b) As col10b,"
				+ " AVG (col10a) As col10a,AVG (col12b) As col12b"
				+ " FROM FrpProdcutionOperatorDataEntry where Dates between :sdate And :eDate AND [crew]='B'";

		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("sdate", sDate);
		source.addValue("eDate", eDate);

		List<FrpProdcutionOperatorDataEntry> datas = jdbcTemplate.query(sql, source,
				new RowMapper<FrpProdcutionOperatorDataEntry>() {

					@Override
					public FrpProdcutionOperatorDataEntry mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						FrpProdcutionOperatorDataEntry data = new FrpProdcutionOperatorDataEntry();
						data.setCol1(rs.getDouble("Col1AVG"));
						data.setCol2(rs.getDouble("Col2AVG"));
						data.setCol3(rs.getDouble("Col3AVG"));
						data.setCol4(rs.getDouble("Col4AVG"));
						data.setCol5(rs.getDouble("Col5AVG"));
						data.setCol6(rs.getDouble("Col6AVG"));
						data.setCol7(rs.getDouble("Col7AVG"));
						data.setCol8(rs.getDouble("Col8AVG"));
						data.setCol9(rs.getDouble("Col9AVG"));
						data.setCol10(rs.getDouble("Col10AVG"));
						data.setCol11(rs.getDouble("Col11AVG"));
						data.setCol12(rs.getDouble("Col12AVG"));

						data.setCol11b(rs.getDouble("Col11b"));
						data.setCol6b(rs.getDouble("Col6b"));
						data.setCol7b(rs.getDouble("Col7b"));
						data.setCol8b(rs.getDouble("Col8b"));
						data.setCol9b(rs.getDouble("Col9b"));
						data.setCol10b(rs.getDouble("Col10b"));
						data.setCol10a(rs.getDouble("Col10a"));
						data.setCol12b(rs.getDouble("Col12b"));
						return data;
					}

				});
		return datas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#getcol1avg2(java.
	 * util.Date, java.util.Date)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> getcol1avg2(Date sDate, Date eDate) {
		// TODO Auto-generated method stub

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "SELECT AVG (col1) As Col1AVG, AVG (col2) As Col2AVG, AVG (col3) As Col3AVG, AVG (col4) As Col4AVG, AVG (col5) As Col5AVG,AVG (col12) As Col12AVG"
				+ ", AVG (col6) As Col6AVG, AVG (col7) As Col7AVG, AVG (col8) As Col8AVG, AVG (col9) As Col9AVG, AVG (col10) As Col10AVG, AVG (col11) As Col11AVG, "
				+ " AVG (col11b) As col11b,AVG (col6b) As col6b,AVG (col7b) As col7b,AVG (col8b) As col8b,AVG (col9b) As col9b,AVG (col10b) As col10b"
				+ " ,AVG (col10a) As col10a,AVG (col12b) As col12b"
				+ " FROM FrpProdcutionOperatorDataEntry where Dates between :sdate And :eDate AND [crew]='C'";

		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("sdate", sDate);
		source.addValue("eDate", eDate);

		List<FrpProdcutionOperatorDataEntry> datas = jdbcTemplate.query(sql, source,
				new RowMapper<FrpProdcutionOperatorDataEntry>() {

					@Override
					public FrpProdcutionOperatorDataEntry mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						FrpProdcutionOperatorDataEntry data = new FrpProdcutionOperatorDataEntry();
						data.setCol1(rs.getDouble("Col1AVG"));
						data.setCol2(rs.getDouble("Col2AVG"));
						data.setCol3(rs.getDouble("Col3AVG"));
						data.setCol4(rs.getDouble("Col4AVG"));
						data.setCol5(rs.getDouble("Col5AVG"));
						data.setCol6(rs.getDouble("Col6AVG"));
						data.setCol7(rs.getDouble("Col7AVG"));
						data.setCol8(rs.getDouble("Col8AVG"));
						data.setCol9(rs.getDouble("Col9AVG"));
						data.setCol10(rs.getDouble("Col10AVG"));
						data.setCol11(rs.getDouble("Col11AVG"));
						data.setCol12(rs.getDouble("Col12AVG"));

						data.setCol11b(rs.getDouble("Col11b"));
						data.setCol6b(rs.getDouble("Col6b"));
						data.setCol7b(rs.getDouble("Col7b"));
						data.setCol8b(rs.getDouble("Col8b"));
						data.setCol9b(rs.getDouble("Col9b"));
						data.setCol10b(rs.getDouble("Col10b"));
						data.setCol10a(rs.getDouble("Col10a"));
						data.setCol12b(rs.getDouble("Col12b"));
						return data;
					}

				});
		return datas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#getcol1avg3(java.
	 * util.Date, java.util.Date)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> getcol1avg3(Date sDate, Date eDate) {
		// TODO Auto-generated method stub

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql = "SELECT AVG (col1) As Col1AVG, AVG (col2) As Col2AVG, AVG (col3) As Col3AVG, AVG (col4) As Col4AVG, AVG (col5) As Col5AVG,AVG (col12) As Col12AVG"
				+ ", AVG (col6) As Col6AVG, AVG (col7) As Col7AVG, AVG (col8) As Col8AVG, AVG (col9) As Col9AVG, AVG (col10) As Col10AVG, AVG (col11) As Col11AVG, "
				+ " AVG (col11b) As col11b,AVG (col6b) As col6b,AVG (col7b) As col7b,AVG (col8b) As col8b,AVG (col9b) As col9b,AVG (col10b) As col10b"
				+ " ,AVG (col10a) As col10a,AVG (col12b) As col12b"
				+ " FROM FrpProdcutionOperatorDataEntry where Dates between :sdate And :eDate AND [crew]='D'";

		MapSqlParameterSource source = new MapSqlParameterSource();

		source.addValue("sdate", sDate);
		source.addValue("eDate", eDate);

		List<FrpProdcutionOperatorDataEntry> datas = jdbcTemplate.query(sql, source,
				new RowMapper<FrpProdcutionOperatorDataEntry>() {

					@Override
					public FrpProdcutionOperatorDataEntry mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						FrpProdcutionOperatorDataEntry data = new FrpProdcutionOperatorDataEntry();
						data.setCol1(rs.getDouble("Col1AVG"));
						data.setCol2(rs.getDouble("Col2AVG"));
						data.setCol3(rs.getDouble("Col3AVG"));
						data.setCol4(rs.getDouble("Col4AVG"));
						data.setCol5(rs.getDouble("Col5AVG"));
						data.setCol6(rs.getDouble("Col6AVG"));
						data.setCol7(rs.getDouble("Col7AVG"));
						data.setCol8(rs.getDouble("Col8AVG"));
						data.setCol9(rs.getDouble("Col9AVG"));
						data.setCol10(rs.getDouble("Col10AVG"));
						data.setCol11(rs.getDouble("Col11AVG"));
						data.setCol12(rs.getDouble("Col12AVG"));

						data.setCol11b(rs.getDouble("Col11b"));
						data.setCol6b(rs.getDouble("Col6b"));
						data.setCol7b(rs.getDouble("Col7b"));
						data.setCol8b(rs.getDouble("Col8b"));
						data.setCol9b(rs.getDouble("Col9b"));
						data.setCol10b(rs.getDouble("Col10b"));
						data.setCol10a(rs.getDouble("Col10a"));
						data.setCol12b(rs.getDouble("Col12b"));
						return data;
					}

				});
		return datas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#
	 * getFrpProducationDataEntryDetailedReport1(java.util.Date, java.util.Date)
	 */
	@Override
	public List<FrpProdcutionOperatorDataEntry> getFrpProducationDataEntryDetailedReport1(Date sdate, Date edate) {
		List<FrpProdcutionOperatorDataEntry> data = new ArrayList<FrpProdcutionOperatorDataEntry>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdate);

		System.out.println("sdate:" + sdate);
		int days = Days.daysBetween(new DateTime(sdate.getTime()), new DateTime(edate.getTime())).getDays();

		Calendar date = Calendar.getInstance();
		date.setTime(sdate);

		for (int i = 0; i <= days; i++) {

			Calendar scal = Calendar.getInstance();
			scal.setTime(date.getTime());

			final FrpProdcutionOperatorDataEntry opdetails = new FrpProdcutionOperatorDataEntry();

			double totalCol1 = 0;
			double totalCol2 = 0;
			double totalCol3 = 0;
			double totalCol4 = 0;
			double totalCol5 = 0;
			double totalCol6 = 0;
			double totalCol7 = 0;
			double totalCol8 = 0;
			double totalCol9 = 0;
			double totalCol10 = 0;
			double totalCol11 = 0;
			double totalCol12 = 0;

			double COL1forday = 0;
			double COL1fornight = 0;
			double COL2forday = 0;
			double COL2fornight = 0;
			double COL3forday = 0;
			double COL3fornight = 0;
			double COL4forday = 0;
			double COL4fornight = 0;
			double COL5forday = 0;
			double COL5fornight = 0;
			double COL6forday = 0;
			double COL6fornight = 0;
			double COL7forday = 0;
			double COL7fornight = 0;
			double COL8forday = 0;
			double COL8fornight = 0;
			double COL9forday = 0;
			double COL9fornight = 0;
			double COL10forday = 0;
			double COL10fornight = 0;
			double COL11forday = 0;
			double COL11fornight = 0;
			double COL12forday = 0;
			double COL12fornight = 0;

			Date dateS = scal.getTime();
//			opdetails.setDate(dateS);

			String sql = "Select * From [FrpProdcutionOperatorDataEntry] where [dates]=? order by [shift]";
			List<Map<String, Object>> data1 = jdbcTemplate.queryForList(sql, new Object[] { scal.getTime() });

			double col1 = 0;
			double col2 = 0;
			double col3 = 0;
			double col4 = 0;
			double col5 = 0;
			double col6 = 0;
			double col7 = 0;
			double col8 = 0;
			double col9 = 0;
			double col10 = 0;
			double col11 = 0;
			double col12 = 0;

			if (data1.size() > 0) {
				for (Map<String, Object> datas : data1) {

					opdetails.setDate(dateS);

					String shift = (String) datas.get("shift".toUpperCase());
					String crew = (String) datas.get("crew".toUpperCase());
					opdetails.setShift(shift);
					opdetails.setCrew(crew);

					col1 = (Double) datas.get("col1") == null ? 0 : (Double) (datas.get("col1"));
					col2 = (Double) datas.get("col2") == null ? 0 : (Double) (datas.get("col2"));
					col3 = (Double) datas.get("col3") == null ? 0 : (Double) (datas.get("col3"));
					col4 = (Double) datas.get("col4") == null ? 0 : (Double) (datas.get("col4"));
					col5 = (Double) datas.get("col5") == null ? 0 : (Double) (datas.get("col5"));
					col6 = (Double) datas.get("col6") == null ? 0 : (Double) (datas.get("col6"));
					col7 = (Double) datas.get("col7") == null ? 0 : (Double) (datas.get("col7"));
					col8 = (Double) datas.get("col8") == null ? 0 : (Double) (datas.get("col8"));
					col9 = (Double) datas.get("col9") == null ? 0 : (Double) (datas.get("col9"));
					col10 = (Double) datas.get("col10") == null ? 0 : (Double) (datas.get("col10"));
					col11 = (Double) datas.get("col11") == null ? 0 : (Double) (datas.get("col11"));
					col12 = (Double) datas.get("col12") == null ? 0 : (Double) (datas.get("col12"));

					totalCol1 = totalCol1 + col1;
					totalCol2 = totalCol2 + col2;
					totalCol3 = totalCol3 + col3;
					totalCol4 = totalCol4 + col4;
					totalCol5 = totalCol5 + col5;
					totalCol6 = totalCol6 + col6;
					totalCol7 = totalCol7 + col7;
					totalCol8 = totalCol8 + col8;
					totalCol9 = totalCol9 + col9;
					totalCol10 = totalCol10 + col10;
					totalCol12 = totalCol12 + col12;
					if (shift.equalsIgnoreCase("DAY")) {
						COL1forday = COL1forday + col1;
						COL2forday = COL2forday + col2;
						COL3forday = COL3forday + col3;
						COL4forday = COL4forday + col4;
						COL5forday = COL5forday + col5;
						COL6forday = COL6forday + col6;
						COL7forday = COL7forday + col7;
						COL8forday = COL8forday + col8;
						COL9forday = COL9forday + col9;
						COL10forday = COL10forday + col10;
						COL11forday = COL11forday + col11;
						COL12forday = COL12forday + col12;

						opdetails.setDayshift("Day");
						opdetails.setCol1forday(COL1forday);
						opdetails.setCol2forday(COL2forday);
						opdetails.setCol3forday(COL3forday);
						opdetails.setCol4forday(COL4forday);
						opdetails.setCol5forday(COL5forday);
						opdetails.setCol6forday(COL6forday);
						opdetails.setCol7forday(COL7forday);
						opdetails.setCol8forday(COL8forday);
						opdetails.setCol9forday(COL9forday);
						opdetails.setCol10forday(COL10forday);
						opdetails.setCol11forday(COL11forday);
						opdetails.setCol12forday(COL12forday);
					} else {
						COL1fornight = COL1fornight + col1;
						COL2fornight = COL2fornight + col2;
						COL3fornight = COL3fornight + col3;
						COL4fornight = COL4fornight + col4;
						COL5fornight = COL5fornight + col5;
						COL6fornight = COL6fornight + col6;
						COL7fornight = COL7fornight + col7;
						COL8fornight = COL8fornight + col8;
						COL9fornight = COL9fornight + col9;
						COL10fornight = COL10fornight + col10;
						COL11fornight = COL11fornight + col11;
						COL12fornight = COL12fornight + col12;

						opdetails.setNightshift("Night");
						opdetails.setCol1fornight(COL1fornight);
						opdetails.setCol2fornight(COL2fornight);
						opdetails.setCol3fornight(COL3fornight);
						opdetails.setCol4fornight(COL4fornight);
						opdetails.setCol5fornight(COL5fornight);
						opdetails.setCol6fornight(COL6fornight);
						opdetails.setCol7fornight(COL7fornight);
						opdetails.setCol8fornight(COL8fornight);
						opdetails.setCol9fornight(COL9fornight);
						opdetails.setCol10fornight(COL10fornight);
						opdetails.setCol11fornight(COL11fornight);
						opdetails.setCol12fornight(COL12fornight);
					}
					opdetails.setCol1(col1);
					opdetails.setCol2(col2);
					opdetails.setCol3(col3);
					opdetails.setCol4(col4);
					opdetails.setCol5(col5);
					opdetails.setCol6(col6);
					opdetails.setCol7(col7);
					opdetails.setCol8(col8);
					opdetails.setCol9(col9);
					opdetails.setCol10(col10);
					opdetails.setCol11(col11);
					opdetails.setCol12(col12);

				}
				opdetails.setTotalcol1(totalCol1);
				opdetails.setTotalcol2(totalCol2);
				opdetails.setTotalcol3(totalCol3);
				opdetails.setTotalcol4(totalCol4);
				opdetails.setTotalcol5(totalCol5);
				opdetails.setTotalcol6(totalCol6);
				opdetails.setTotalcol7(totalCol7);
				opdetails.setTotalcol8(totalCol8);
				opdetails.setTotalcol9(totalCol9);
				opdetails.setTotalcol10(totalCol10);
				opdetails.setTotalcol12(totalCol12);

				data.add(opdetails);
			} else {

			}
			date.add(Calendar.DATE, 1);
		}
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.frpprojection.dao.FrpProdcutionOperatorDataEntryDao#deleteRecord(int)
	 */
	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "delete from [FrpProdcutionOperatorDataEntry] where [ID]=?";
		jdbcTemplate.update(sql, new Object[] { id });

	}

}
