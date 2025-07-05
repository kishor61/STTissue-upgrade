/**
 *Feb 1, 2018
 *MasterDataDaoImpPM5.java
 * TODO
 *com.st.utilitykpimasterPM5.dao
 *MasterDataDaoImpPM5.java
 *Roshan Lal Tailor
 */
package com.st.utilitykpimasterPM5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.utilitykpimaster.mapper.MasterDataMapper;
import com.st.utilitykpimaster.model.MasterData;
import com.st.utilitykpimasterPM5.mapper.MasterDataMapperPM5;

/**
 * @author roshan
 *
 */
@Repository
public class MasterDataDaoImpPM5 implements MasterDataDaoPM5{

	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.dao.MasterDataDaoPM5#getMasterDatasL31()
	 */
	@Override
	public List<MasterData> getMasterDatasL31() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select TOP 1 * from [masterData_PM5] order by [Date] desc";
		List<MasterData> masterDatas=jdbcTemplate.query(sql,new MasterDataMapper());
		Collections.reverse(masterDatas);
		return masterDatas;
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.dao.MasterDataDaoPM5#save(com.st.utilitykpimaster.model.MasterData)
	 */
	@Override
	public int save(final MasterData masterData) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		final String sql="insert into [masterData_PM5]"
				+ "("
				+"[Date],"
				+"[AvgThp],"
				+"[ProdBlead],"
				+"[ProdKraft],"
				+"[ProdSlabOff],"
				+"[ProdWrapBlead],"
				+"[ProdProdWhite],"
				+"[ProdProdRed],"
				+"[ProdProdReject],"
				+"[NaturalGasFlow],"
				+"[FiberLossSewerFlow],"
				+"[FiberLossSfConsy],"
				+"[FiberLossWwToFrp],"
				+"[FiberLossWfFlow],"
				+"[PulpWlap],"
				+"[EnergyElectrical],"
				+"[PulpDataFromFrp],"
				+"[PulpConsumedFromHd],"
				+"[PulpDataProdDcs],"
				+"[PulpDataHdLevel],"
				+"[PulpInHd],"
				+"[TissueGrade], "
				+"[ChemWetStrength], "
				+"[ChemRelease], "
				+"[ChemAdhesive], "
				+"[ChemMap], "
				+"[ChemDefoamer], "
				+"[ChemPassivator],"
				+"[coddischarge] "
				+ ")"
				+ " values("
				+ "?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?"
				+ ",?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
				statement.setTimestamp(1, new Timestamp(masterData.getDate().getTime()));
				statement.setDouble(2, masterData.getAvgThp());
				statement.setDouble(3, masterData.getProdBlead());
				statement.setDouble(4, masterData.getProdKraft());
				statement.setDouble(5, masterData.getProdSlabOff());
				statement.setDouble(6, masterData.getProdWrapBlead());
				statement.setDouble(7, masterData.getProdProdWhite());
				statement.setDouble(8, masterData.getProdProdRed());
				statement.setDouble(9, masterData.getProdProdReject());
				statement.setDouble(10, masterData.getNaturalGasFlow());
				statement.setDouble(11, masterData.getFiberLossSewerFlow());
				statement.setDouble(12, masterData.getFiberLossSfConsy());
				statement.setDouble(13, masterData.getFiberLossWwToFrp());
				statement.setDouble(14, masterData.getFiberLossWfFlow());
				statement.setDouble(15, masterData.getPulpWlap());
				statement.setDouble(16, masterData.getEnergyElectrical());
				statement.setDouble(17, masterData.getPulpDataFromFrp());
				statement.setDouble(18, masterData.getPulpConsumedFromHd());
				statement.setDouble(19, masterData.getPulpDataProdDcs());
				statement.setDouble(20, masterData.getPulpDataHdLevel());
				statement.setDouble(21, masterData.getPulpInHd());
				statement.setString(22, masterData.getTissueGrade());

				statement.setDouble(23, masterData.getChemWetStrength());
				statement.setDouble(24, masterData.getChemRelease());
				statement.setDouble(25, masterData.getChemAdhesive());
				statement.setDouble(26, masterData.getChemMap());
				statement.setDouble(27, masterData.getChemDefoamer());
				statement.setDouble(28, masterData.getChemPassivator());
				statement.setDouble(29, masterData.getCoddischarge());
				
				return statement;
			}
		},keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.dao.MasterDataDaoPM5#update(com.st.utilitykpimaster.model.MasterData)
	 */
	@Override
	public void update(final MasterData masterData) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		final String sql="update [masterData_PM5] set "
				+"[Date]=?,"
				+"[AvgThp]=?,"
				+"[ProdBlead]=?,"
				+"[ProdKraft]=?,"
				+"[ProdSlabOff]=?,"
				+"[ProdWrapBlead]=?,"
				+"[ProdProdWhite]=?,"
				+"[ProdProdRed]=?,"
				+"[ProdProdReject]=?,"
				+"[NaturalGasFlow]=?,"
				+"[FiberLossSewerFlow]=?,"
				+"[FiberLossSfConsy]=?,"
				+"[FiberLossWwToFrp]=?,"
				+"[FiberLossWfFlow]=?,"
				+"[PulpWlap]=?,"
				+"[EnergyElectrical]=?,"
				+"[PulpDataFromFrp]=?,"
				+"[PulpConsumedFromHd]=?,"
				+"[PulpDataProdDcs]=?,"
				+"[PulpDataHdLevel]=?,"
				+"[PulpInHd]=?,"
				+"[TissueGrade]=?, "
				+"[ChemWetStrength]=?, "
				+"[ChemRelease]=?, "
				+"[ChemAdhesive]=?, "
				+"[ChemMap]=?, "
				+"[ChemDefoamer]=?, "
				+"[ChemPassivator]=?,"
				+"[coddischarge]=?  "
				
				+ " where [ID]=?";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql);
				statement.setTimestamp(1, new Timestamp(masterData.getDate().getTime()));
				statement.setDouble(2, masterData.getAvgThp());
				statement.setDouble(3, masterData.getProdBlead());
				statement.setDouble(4, masterData.getProdKraft());
				statement.setDouble(5, masterData.getProdSlabOff());
				statement.setDouble(6, masterData.getProdWrapBlead());
				statement.setDouble(7, masterData.getProdProdWhite());
				statement.setDouble(8, masterData.getProdProdRed());
				statement.setDouble(9, masterData.getProdProdReject());
				statement.setDouble(10, masterData.getNaturalGasFlow());
				statement.setDouble(11, masterData.getFiberLossSewerFlow());
				statement.setDouble(12, masterData.getFiberLossSfConsy());
				statement.setDouble(13, masterData.getFiberLossWwToFrp());
				statement.setDouble(14, masterData.getFiberLossWfFlow());
				statement.setDouble(15, masterData.getPulpWlap());
				statement.setDouble(16, masterData.getEnergyElectrical());
				statement.setDouble(17, masterData.getPulpDataFromFrp());
				statement.setDouble(18, masterData.getPulpConsumedFromHd());
				statement.setDouble(19, masterData.getPulpDataProdDcs());
				statement.setDouble(20, masterData.getPulpDataHdLevel());
				statement.setDouble(21, masterData.getPulpInHd());
				statement.setString(22, masterData.getTissueGrade());
				
				statement.setDouble(23, masterData.getChemWetStrength());
				statement.setDouble(24, masterData.getChemRelease());
				statement.setDouble(25, masterData.getChemAdhesive());
				statement.setDouble(26, masterData.getChemMap());
				statement.setDouble(27, masterData.getChemDefoamer());
				statement.setDouble(28, masterData.getChemPassivator());
				
				statement.setDouble(29, masterData.getCoddischarge());
				
				statement.setInt(30, masterData.getId());

				return statement;
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.dao.MasterDataDaoPM5#delete(int)
	 */
	@Override
	public void delete(int id) {
	JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

		String sql="delete from [masterData_PM5] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.dao.MasterDataDaoPM5#getMasterDatas(java.util.Date, java.util.Date)
	 */
	@Override
	public List<MasterData> getMasterDatas(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Calendar scal=Calendar.getInstance();
		scal.setTime(sdate);
		
		Calendar ecal=Calendar.getInstance();
		ecal.setTime(edate);
		//ecal.add(Calendar.DATE, 1);
		
		String sql="select * from [masterData_PM5]"
				+ " where [Date] between ? and ? "
				+ " order by [Date]";
		
		List<MasterData> masterDatas=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(scal.getTime().getTime()),
				new Timestamp(ecal.getTime().getTime()),
		}, new MasterDataMapperPM5());
		return masterDatas;
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.dao.MasterDataDaoPM5#getMasterData(int)
	 */
	@Override
	public MasterData getMasterData(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [masterData_PM5] where [ID]=?";
		MasterData masterData=jdbcTemplate.queryForObject(sql, new Object[]{id},new MasterDataMapper());
		return masterData;
	}

	/* (non-Javadoc)
	 * @see com.st.utilitykpimasterPM5.dao.MasterDataDaoPM5#getMasterDatasBetweenDates(java.util.Date, java.util.Date)
	 */
	@Override
	public List<MasterData> getMasterDatasBetweenDates(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [masterData_PM5] where [Date] between ? and ? order by [Date] desc";
		List<MasterData> masterDatas=jdbcTemplate.query(sql,new Object[]{sdate,edate},new MasterDataMapper());
		Collections.reverse(masterDatas);
		return masterDatas;
	}

}
