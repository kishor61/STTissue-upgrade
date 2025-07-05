/**
 * 
 */
package com.st.utilitykpimaster.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.utilitykpimaster.model.MasterData;

/**
 * @author sbora
 *
 */
public class MasterDataMapper implements RowMapper<MasterData> {

	
	@Override
	public MasterData mapRow(ResultSet rs, int arg1) throws SQLException {
		MasterData masterData=new MasterData();
		masterData.setId(rs.getInt("ID"));
		masterData.setDate(new Date(rs.getTimestamp("Date").getTime()));
		masterData.setAvgThp(rs.getDouble("AvgThp"));
		masterData.setProdBlead(rs.getDouble("ProdBlead"));
		masterData.setProdKraft(rs.getDouble("ProdKraft"));
		masterData.setProdSlabOff(rs.getDouble("ProdSlabOff"));
		masterData.setProdWrapBlead(rs.getDouble("ProdWrapBlead"));
		masterData.setProdProdWhite(rs.getDouble("ProdProdWhite"));
		masterData.setProdProdRed(rs.getDouble("ProdProdRed"));
		masterData.setProdProdReject(rs.getDouble("ProdProdReject"));
		
		masterData.setNaturalGasFlow(rs.getDouble("NaturalGasFlow"));
		masterData.setFiberLossSewerFlow(rs.getDouble("FiberLossSewerFlow"));
		masterData.setFiberLossSfConsy(rs.getDouble("FiberLossSfConsy"));
		masterData.setFiberLossWwToFrp(rs.getDouble("FiberLossWwToFrp"));
		masterData.setFiberLossWfFlow(rs.getDouble("FiberLossWfFlow"));
		masterData.setPulpWlap(rs.getDouble("PulpWlap"));
		masterData.setEnergyElectrical(rs.getDouble("EnergyElectrical"));
		masterData.setPulpDataFromFrp(rs.getDouble("PulpDataFromFrp"));
		masterData.setPulpConsumedFromHd(rs.getDouble("PulpConsumedFromHd"));
		masterData.setPulpDataProdDcs(rs.getDouble("PulpDataProdDcs"));
		masterData.setPulpDataHdLevel(rs.getDouble("PulpDataHdLevel"));
		masterData.setPulpInHd(rs.getDouble("PulpInHd"));
		masterData.setTissueGrade(rs.getString("TissueGrade"));
		masterData.setDowntimeMin(rs.getInt("DowntimeMin"));
		masterData.setConsumedStock(rs.getDouble("ConsumedStock"));
		masterData.setNaturalGasFlowDryend(rs.getDouble("NaturalGasFlowDryend"));
		
		masterData.setDowntimeDayMin(rs.getInt("DowntimeDayMin"));
		masterData.setDowntimeNightMin(rs.getInt("DowntimeNightMin"));
		masterData.setMachineDowntimeMin(rs.getInt("MachineDowntimeMin"));
		
		masterData.setChemWetStrength(rs.getInt("ChemWetStrength"));
		masterData.setChemRelease(rs.getInt("ChemRelease"));
		masterData.setChemAdhesive(rs.getInt("ChemAdhesive"));
		masterData.setChemMap(rs.getInt("ChemMap"));
		masterData.setChemDefoamer(rs.getInt("ChemDefoamer"));
		masterData.setChemPassivator(rs.getInt("ChemPassivator"));
		masterData.setCoddischarge(rs.getDouble("coddischarge"));
		
		return masterData;
	}

}
