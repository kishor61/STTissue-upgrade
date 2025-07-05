/**
 * 
 */
package com.st.chemicalinventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.chemicalinventory.mapper.ChemicalCodeMapper;
import com.st.chemicalinventory.mapper.ChemicalPrimaryCodeMapper;
import com.st.chemicalinventory.mapper.ChemicalSecondaryCodeMapper;
import com.st.chemicalinventory.model.Chemical;
import com.st.chemicalinventory.model.ChemicalCode;
import com.st.chemicalinventory.model.ChemicalData;
import com.st.chemicalinventory.model.ChemicalPrimaryCode;
import com.st.chemicalinventory.model.ChemicalReportData;
import com.st.chemicalinventory.model.ChemicalSecondaryCode;

/**
 * @author sbora
 *
 */
@Repository
public class ChemicalInventoryDaoImp implements ChemicalInventoryDao{
	@Autowired
	private DataSource dataSource;

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#saveOrUpdate(com.st.chemicalinventory.model.ChemicalPrimaryCode)
	 */
	@Override
	public void saveOrUpdate(ChemicalPrimaryCode chemicalPrimaryCode) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sqlTemp="select * from [chemicalPrimaryCode] where [Name]=?";
		ChemicalPrimaryCode chemicalPrimaryCodeTemp=null;
		try {
			chemicalPrimaryCodeTemp=jdbcTemplate.queryForObject(sqlTemp, new Object[]{chemicalPrimaryCode.getName().trim()},new ChemicalPrimaryCodeMapper());
		} catch (Exception e) {}
		if(chemicalPrimaryCodeTemp==null){
			if(chemicalPrimaryCode.getId()==0){
				String sql="insert into [chemicalPrimaryCode]([Name]) values(?)";
				jdbcTemplate.update(sql, new Object[]{chemicalPrimaryCode.getName().trim()});
			}else{
				String sql="update [chemicalPrimaryCode] set [Name]=?  where [ID]=?";
				jdbcTemplate.update(sql, new Object[]{
					chemicalPrimaryCode.getName().trim(),
					chemicalPrimaryCode.getId()
				});
			}
		}else{
			String sql="update [chemicalPrimaryCode] set [Deleted]=?  where [ID]=?";
			jdbcTemplate.update(sql, new Object[]{
				false,
				chemicalPrimaryCodeTemp.getId()
			});
		}
		
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#getChemicalPrimaryCodes()
	 */
	@Override
	public List<ChemicalPrimaryCode> getChemicalPrimaryCodes() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [chemicalPrimaryCode] where [Deleted]=?";
		List<ChemicalPrimaryCode> chemicalPrimaryCodes=jdbcTemplate.query(sql, new Object[]{false},new ChemicalPrimaryCodeMapper());
		return chemicalPrimaryCodes;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#getChemicalPrimaryCode(int)
	 */
	@Override
	public ChemicalPrimaryCode getChemicalPrimaryCode(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [chemicalPrimaryCode] where [ID]=?";
		ChemicalPrimaryCode chemicalPrimaryCode=jdbcTemplate.queryForObject(sql, new Object[]{id},new ChemicalPrimaryCodeMapper());
		return chemicalPrimaryCode;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#deletePrimaryCode(int)
	 */
	@Override
	public void deletePrimaryCode(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [chemicalPrimaryCode] set [Deleted]=?  where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{
			true,
			id
		});
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#saveOrUpdate(com.st.chemicalinventory.model.ChemicalSecondaryCode)
	 */
	@Override
	public void saveOrUpdate(ChemicalSecondaryCode chemicalSecondaryCode) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sqlTemp="select * from [chemicalSecondaryCode] where [Name]=?";
		ChemicalSecondaryCode chemicalSecondaryCodeTemp=null;
		try {
			chemicalSecondaryCodeTemp=jdbcTemplate.queryForObject(sqlTemp, new Object[]{chemicalSecondaryCode.getName().trim()},new ChemicalSecondaryCodeMapper());
		} catch (Exception e) {}
		
		if(chemicalSecondaryCodeTemp==null){
			if(chemicalSecondaryCode.getId()==0){
				String sql="insert into [chemicalSecondaryCode]([Name],[PID]) values(?,?)";
				jdbcTemplate.update(sql, new Object[]{
						chemicalSecondaryCode.getName().trim(),
						chemicalSecondaryCode.getPid()
					});
			}else{
				String sql="update [chemicalSecondaryCode] set [Name]=?, [PID]=?  where [ID]=?";
				jdbcTemplate.update(sql, new Object[]{
						chemicalSecondaryCode.getName().trim(),
						chemicalSecondaryCode.getPid(),
						chemicalSecondaryCode.getId()
				});
			}
		}else{
			String sql="update [chemicalSecondaryCode] set [Deleted]=?  where [ID]=?";
			jdbcTemplate.update(sql, new Object[]{
				false,
				chemicalSecondaryCodeTemp.getId()
			});
		}
		
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#deleteSecondary(int)
	 */
	@Override
	public void deleteSecondary(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [chemicalSecondaryCode] set [Deleted]=?  where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{
			true,
			id
		});
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#getChemicalSecondaryCode(int)
	 */
	@Override
	public ChemicalSecondaryCode getChemicalSecondaryCode(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [chemicalSecondaryCode] where [ID]=?";
		ChemicalSecondaryCode chemicalSecondaryCode=jdbcTemplate.queryForObject(sql, new Object[]{id},new ChemicalSecondaryCodeMapper());
		return chemicalSecondaryCode;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#getChemicalSecondaryCodes()
	 */
	@Override
	public List<ChemicalSecondaryCode> getChemicalSecondaryCodes() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select s.*,p.[Name] as [PrimaryCode] from [chemicalSecondaryCode] s,[chemicalPrimaryCode] p"
				+ " where s.[Deleted]=? and p.[Deleted]=? "
				+ " and "
				+ " p.[ID]=s.[PID] ";
		List<ChemicalSecondaryCode> chemicalSecondaryCodes=jdbcTemplate.query(sql, new Object[]{false,false},new ChemicalSecondaryCodeMapper());
		return chemicalSecondaryCodes;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#saveOrUpdate(com.st.chemicalinventory.model.ChemicalCode)
	 */
	@Override
	public void saveOrUpdate(ChemicalCode chemicalCode) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sqlTemp="select * from [chemicalCode] where [Code]=?";
		ChemicalCode chemicalCodeTemp=null;
		try {
			chemicalCodeTemp=jdbcTemplate.queryForObject(sqlTemp, new Object[]{chemicalCode.getCode().trim()},new ChemicalCodeMapper());
		} catch (Exception e) {}
		
		if(chemicalCodeTemp==null){
			if(chemicalCode.getId()==0){
				String sql="insert into [chemicalCode]([Code],[Min],[Target],[Max],[Unit]) values(?,?,?,?,?)";
				jdbcTemplate.update(sql, new Object[]{
						chemicalCode.getCode().trim(),
						chemicalCode.getMin(),
						chemicalCode.getTarget(),
						chemicalCode.getMax(),
						chemicalCode.getUnit()
					});
			}else{
				String sql="update [chemicalCode] set [Code]=?,[Min]=?,[Target]=?,[Max]=?,[Unit]=? where [ID]=?";
				jdbcTemplate.update(sql, new Object[]{
						chemicalCode.getCode().trim(),
						chemicalCode.getMin(),
						chemicalCode.getTarget(),
						chemicalCode.getMax(),
						chemicalCode.getUnit(),
						chemicalCode.getId()
				});
			}
		}else{
			String sql="update [chemicalCode] set [Code]=?,[Min]=?,[Target]=?,[Max]=?,[Unit]=?,[Deleted]=? where [ID]=?";
			jdbcTemplate.update(sql, new Object[]{
					chemicalCode.getCode().trim(),
					chemicalCode.getMin(),
					chemicalCode.getTarget(),
					chemicalCode.getMax(),
					chemicalCode.getUnit(),
					false,
					chemicalCodeTemp.getId()
			});
		}
		
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#getChemicalCodes()
	 */
	@Override
	public List<ChemicalCode> getChemicalCodes() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql=" select * "
				+ " from [chemicalCode]"
				+ " where [Deleted]=? ";
		List<ChemicalCode> chemicalCodes=jdbcTemplate.query(sql, new Object[]{false}, new ChemicalCodeMapper());
		return chemicalCodes;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#deleteChemicalCode(int)
	 */
	@Override
	public void deleteChemicalCode(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [chemicalCode] set [Deleted]=?  where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{
			true,
			id
		});
	}
	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#deleteChemical(int)
	 */
	@Override
	public void deleteChemical(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [chemical] set [Deleted]=?  where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{
			true,
			id
		});
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#getChemicalCode(int)
	 */
	@Override
	public ChemicalCode getChemicalCode(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [chemicalCode] where [ID]=?";
		ChemicalCode chemicalCode=jdbcTemplate.queryForObject(sql,new Object[]{id}, new ChemicalCodeMapper());
		return chemicalCode;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#saveOrUpdate(com.st.chemicalinventory.model.Chemical)
	 */
	@Override
	public void saveOrUpdate(Chemical chemical) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		if(chemical.getId()==0){
			String sql="insert into [chemical]([SID],[CID]) values(?,?)";
			jdbcTemplate.update(sql, new Object[]{chemical.getSid(),chemical.getCid()});
		}else{
			String sql="update [chemical] set [SID]=?,[CID]=?,[Deleted]=? where [ID]=?";
			jdbcTemplate.update(sql, new Object[]{chemical.getSid(),chemical.getCid(),chemical.isDeleted(),chemical.getId()});
		}
		
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#getChemical(int)
	 */
	@Override
	public Chemical getChemical(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [chemical] where [ID]=?";
		Chemical chemical=jdbcTemplate.queryForObject(sql, new Object[]{id},new RowMapper<Chemical>(){

			@Override
			public Chemical mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Chemical chemical=new Chemical();
				chemical.setId(rs.getInt("ID"));
				chemical.setSid(rs.getInt("SID"));
				chemical.setCid(rs.getInt("CID"));
				return chemical;
			}
			
		});
		return chemical;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#isChemicalExist(int, int)
	 */
	@Override
	public Chemical isChemicalExist(int sid, int cid) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [chemical] where [SID]=? and [CID]=?";
		Chemical chemical=null;
		try {
			 chemical=jdbcTemplate.queryForObject(sql, new Object[]{sid,cid},new RowMapper<Chemical>(){

					@Override
					public Chemical mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Chemical chemical=new Chemical();
						chemical.setId(rs.getInt("ID"));
						chemical.setCid(rs.getInt("SID"));
						chemical.setSid(rs.getInt("CID"));
						chemical.setDeleted(rs.getBoolean("Deleted"));
						return chemical;
					}
					
				});
		} catch (Exception e) {}
		return chemical;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#getChemicals()
	 */
	@Override
	public List<Chemical> getChemicals() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select ch.[ID], c.[Code],p.[Name] as [Pname],s.[Name] as [Sname],c.[Min],c.[Target],c.[Max],c.[Unit] "
				+ " from [chemical] ch,[chemicalCode] c,[chemicalSecondaryCode] s,[chemicalPrimaryCode] p"
				+ " where ch.[Deleted]=? and c.[Deleted]=? and s.[Deleted]=? and p.[Deleted]=? "
				+ "and ch.[CID]=c.[ID] and ch.[SID]=s.[ID] and p.[ID]=s.[PID]";
		List<Chemical> chemicals=jdbcTemplate.query(sql, new Object[]{false,false,false,false},new RowMapper<Chemical>(){

			@Override
			public Chemical mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Chemical chemical=new Chemical();
				chemical.setId(rs.getInt("ID"));
				chemical.setChemicalCode(rs.getString("Code"));
				chemical.setPrimaryName(rs.getString("Pname"));
				chemical.setSecondaryName(rs.getString("Sname"));
				chemical.setMin(rs.getDouble("Min"));
				chemical.setTarget(rs.getDouble("Target"));
				chemical.setMax(rs.getDouble("Max"));
				chemical.setUnit(rs.getString("Unit"));
				
				return chemical;
			}
			
		});
		return chemicals;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#saveOrUpdate(com.st.chemicalinventory.model.ChemicalData)
	 */
	@Override
	public int saveOrUpdate(final ChemicalData chemicalData) {
		int id=0;
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		if(chemicalData.getId()==0){
			
			KeyHolder holder=new GeneratedKeyHolder();
			
			final String sql="insert into [chemicalData] ("
					+ "[CID],"
					+ "[Date],"
					+ "[EntryID],"
					+ "[Consumption] "
					+ ") values(?,?,?,?)";
			
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
					
					statement.setInt(1, chemicalData.getCid());
					statement.setTimestamp(2, new Timestamp(chemicalData.getDate().getTime()));
					statement.setString(3, chemicalData.getEntryId());
					statement.setDouble(4, chemicalData.getConsumption());
					return statement;
				}
			},holder);
			
			id=holder.getKey().intValue();
			
		}else{
			final String sql="update [chemicalData] set "
					+ "[CID]=?,"
					+ "[Date]=?,"
					+ "[EntryID]=?,"
					+ "[Consumption]=? "
					+ " where [ID]=? ";
			
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql);
					
					statement.setInt(1, chemicalData.getCid());
					statement.setTimestamp(2, new Timestamp(chemicalData.getDate().getTime()));
					statement.setString(3, chemicalData.getEntryId());
					statement.setDouble(4, chemicalData.getConsumption());
					statement.setInt(5, chemicalData.getId());
					
					return statement;
				}
			});
			id=chemicalData.getId();
		}
		
		
		return id;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#getChemicalReportData(java.util.Date, java.util.Date, int, int, int)
	 */
	@Override
	public List<ChemicalReportData> getChemicalReportData(Date from, Date to,
			int pid, int sid) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	
		Object[] param=null;
		
		
		String sql="SELECT "
				+ " cd.[Date],cd.[EntryID],cd.[Consumption], "
				+ " cc.[code] as [Chemical], cc.[ID] as [CCID],"
				+ " sc.[Name] as [SecondaryCode], sc.[ID] as [SID],"
				+ "  pc.[Name] as [PrimaryCode] , pc.[ID] as [PID] "
				+ " FROM  "
				+ " [chemicalData] cd ,[chemical] ch,[chemicalCode] cc,[chemicalSecondaryCode] sc,[chemicalPrimaryCode] pc "
				+ " where "
				+ " ch.[ID]=cd.[CID] "
				+ "	and "
				+ " ch.[SID]=sc.[ID] "
				+ " and "
				+ " ch.[CID]=cc.[ID] "
				+ " and "
				+ " pc.[ID]=sc.[PID] "
				+ " and "
				+ " cc.[Deleted]=? "
				+ " and "
				+ " sc.[Deleted]=? "
				+ " and "
				+ " pc.[Deleted]=? "
				+ " and "
				+ " ch.[Deleted]=? "
				+ " and "
				+ " (cd.[Date] between ? and  ?) ";
		
		if(pid>0 && sid>0){
			sql+=" and pc.[ID]=? and sc.[ID]=? ";
			param=new Object[]{
					false,false,false,false, 
					new Timestamp(from.getTime()),
					new Timestamp(to.getTime()),
					pid,
					sid
			};
		}else if(pid==0 && sid>0){
			sql+="  and sc.[ID]=? ";
			param=new Object[]{
					false,false,false,false, 
					new Timestamp(from.getTime()),
					new Timestamp(to.getTime()),
					sid
			};
		}else if(pid>0 && sid==0){
			sql+=" and pc.[ID]=?";
			param=new Object[]{
					false,false,false,false, 
					new Timestamp(from.getTime()),
					new Timestamp(to.getTime()),
					pid
			};
		}else{
			param=new Object[]{
					false,false,false,false, 
					new Timestamp(from.getTime()),
					new Timestamp(to.getTime())
			};
		}
		
		sql+= " order by cd.[Date],cd.[EntryID],cc.[code] ";
		
		
		//System.out.println(sql);
		
		
		List<ChemicalData> datas=jdbcTemplate.query(sql,param, new RowMapper<ChemicalData>(){

			@Override
			public ChemicalData mapRow(ResultSet rs, int arg1)
					throws SQLException {
				ChemicalData chemicalData=new ChemicalData();
				chemicalData.setDate(new Date(rs.getTimestamp("Date").getTime()));
				chemicalData.setEntryId(rs.getString("EntryId"));
				chemicalData.setConsumption(rs.getDouble("Consumption"));
				chemicalData.setChemicalCode(rs.getString("Chemical"));
				chemicalData.setPrimaryName(rs.getString("PrimaryCode"));
				chemicalData.setSecondaryName(rs.getString("SecondaryCode"));
				chemicalData.setCcid(rs.getInt("CCID"));
				chemicalData.setSid(rs.getInt("SID"));
				chemicalData.setPid(rs.getInt("PID"));
				return chemicalData;
			}
			
		});
		
		List<ChemicalReportData> chemicalReportDatas=new ArrayList<ChemicalReportData>();
		ChemicalReportData chemicalReportData=null;
		String entryId="";
		for (ChemicalData chemicalData : datas) {
			if(!entryId.equals(chemicalData.getEntryId())){
				entryId=chemicalData.getEntryId();
				chemicalReportData=new ChemicalReportData();
				chemicalReportData.setDate(chemicalData.getDate());
				chemicalReportData.setEntryId(entryId);
				chemicalReportData.getDatas().add(chemicalData);
				
				chemicalReportDatas.add(chemicalReportData);
				
			}else{
				chemicalReportData.getDatas().add(chemicalData);
			}
			
			
		}
		
		
		
		return chemicalReportDatas;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#getChemicalData(java.util.Date, java.lang.String)
	 */
	@Override
	public List<Chemical> getChemicalData(Date date, String entryId) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select ch.[ID], c.[Code],p.[Name] as [Pname],s.[Name] as [Sname] "
				+ " from [chemical] ch,[chemicalCode] c,[chemicalSecondaryCode] s,[chemicalPrimaryCode] p"
				+ " where ch.[Deleted]=? and c.[Deleted]=? and s.[Deleted]=? and p.[Deleted]=? "
				+ "and ch.[CID]=c.[ID] and ch.[SID]=s.[ID] and p.[ID]=s.[PID]";
		List<Chemical> chemicals=jdbcTemplate.query(sql, new Object[]{false,false,false,false},new RowMapper<Chemical>(){

			@Override
			public Chemical mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Chemical chemical=new Chemical();
				chemical.setId(rs.getInt("ID"));
				chemical.setChemicalCode(rs.getString("Code"));
				chemical.setPrimaryName(rs.getString("Pname"));
				chemical.setSecondaryName(rs.getString("Sname"));
				return chemical;
			}
			
		});
		
		
		String sql2="select * from [chemicalData] where [EntryID]=? and [Date]=? ";
		List<ChemicalData> chemicalDatas=jdbcTemplate.query(sql2, new Object[]{
				entryId,
				new Timestamp(date.getTime())
			}, new RowMapper<ChemicalData>(){

			@Override
			public ChemicalData mapRow(ResultSet rs, int arg1)
					throws SQLException {
				ChemicalData chemicalData=new ChemicalData();
				chemicalData.setCid(rs.getInt("CID"));
				chemicalData.setId(rs.getInt("ID"));
				chemicalData.setConsumption(rs.getDouble("Consumption"));
				return chemicalData;
			}
			
		});
		
		for (ChemicalData chemicalData : chemicalDatas) {
			Chemical chemical=new Chemical(chemicalData.getCid());
			
			if(chemicals.contains(chemical)){
				Chemical chemicalUpdate=chemicals.get(chemicals.indexOf(chemical));
				chemicalUpdate.setConsumption(chemicalData.getConsumption());
				chemicalUpdate.setChemicalDataId(chemicalData.getId());
			}
			
		}
		
		return chemicals;
	}


	 
	@Override
	public List<ChemicalData>  getChemicalReportDataDetail(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql1="SELECT  "
				+ " cc.[code] as [Chemical], cc.[ID] as [CCID],  "
				+ " sc.[Name] as [SecondaryCode], sc.[ID] as [SID],  "
				+ " pc.[Name] as [PrimaryCode] , pc.[ID] as [PID]  "
				+ " FROM   "
				+ " [chemicalData] cd ,[chemical] ch,[chemicalCode] cc,[chemicalSecondaryCode] sc,[chemicalPrimaryCode] pc  "
				+ " where  "
				+ " ch.[ID]=cd.[CID] "
				+ "	and  "
				+ " ch.[SID]=sc.[ID]  "
				+ " and "
				+ " ch.[CID]=cc.[ID]  "
				+ " and  "
				+ " pc.[ID]=sc.[PID]  "
				+ " and "
				+ " cc.[Deleted]=? "
				+ " and "
				+ " sc.[Deleted]=? "
				+ " and "
				+ " pc.[Deleted]=? "
				+ " and "
				+ " ch.[Deleted]=? "
				
				+ " group by cc.[code],cc.[ID],sc.[Name],sc.[ID],pc.[Name],pc.[ID] "
				+ " order by sc.[Name],pc.[Name] ";
		
		
		
		List<ChemicalData> datas=jdbcTemplate.query(sql1,new Object[]{
				false,false,false,false
		}, new RowMapper<ChemicalData>(){

			@Override
			public ChemicalData mapRow(ResultSet rs, int arg1)
					throws SQLException {
				ChemicalData chemicalData=new ChemicalData();;
				chemicalData.setChemicalCode(rs.getString("Chemical"));
				chemicalData.setPrimaryName(rs.getString("PrimaryCode"));
				chemicalData.setSecondaryName(rs.getString("SecondaryCode"));
				chemicalData.setCcid(rs.getInt("CCID"));
				chemicalData.setSid(rs.getInt("SID"));
				chemicalData.setPid(rs.getInt("PID"));
				return chemicalData;
			}
			
		});
		return datas;
	}

	/* (non-Javadoc)
	 * @see com.st.chemicalinventory.dao.ChemicalInventoryDao#deleteChemicalData(java.util.Date, java.lang.String)
	 */
	@Override
	public void deleteChemicalData(Date date, String entryId) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [chemicalData] where [EntryID]=? and [Date]=?";
		jdbcTemplate.update(sql, new Object[]{entryId,new Timestamp(date.getTime())});
		
	}

	


}
