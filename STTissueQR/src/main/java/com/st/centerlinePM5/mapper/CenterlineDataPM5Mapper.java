/**
 *Mar 17, 2018
 *CenterlineDataPM5Mapper.java
 * TODO
 *com.st.centerlinePM5.mapper
 *CenterlineDataPM5Mapper.java
 *Roshan Lal Tailor
 */
package com.st.centerlinePM5.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.centerline.model.CenterlineData;

/**
 * @author roshan
 *
 */
public class CenterlineDataPM5Mapper  implements RowMapper<CenterlineData> {

	@Override
	public CenterlineData mapRow(ResultSet rs, int arg1) throws SQLException {
		CenterlineData centerline=new CenterlineData();

		centerline.setId(rs.getInt("ID"));
		centerline.setGradeId(rs.getInt("GradeId"));
		centerline.setCrew(rs.getString("Crew"));
		centerline.setShift(rs.getString("Shift"));
		centerline.setYankeeSpeed(rs.getDouble("YankeeSpeed"));
		centerline.setQcsBasisWtTarget(rs.getDouble("QCSBasisWtTarget"));
		centerline.setReelMoisture(rs.getDouble("ReelMoisture"));
		centerline.setCrepe(rs.getDouble("Crepe"));
		centerline.setYankeeSteam(rs.getDouble("YankeeSteam"));
		centerline.setYankeeRelease(rs.getDouble("YankeeRelease"));
		centerline.setYankeeAdesive(rs.getDouble("YankeeAdesive"));
		centerline.setJetWireRatio(rs.getDouble("JetWireRatio"));
		centerline.setFanPumpFlowRate(rs.getDouble("FanPumpFlowRate"));
		centerline.setAfterDryerSteam(rs.getDouble("AfterDryerSteam"));
		centerline.setSprLoading(rs.getString("SPRLoading"));
		centerline.setFeltPassivator(rs.getDouble("FeltPassivator"));
		centerline.setSprayboomPressure(rs.getDouble("SprayboomPressure"));
		centerline.setSprayboomTemparature(rs.getDouble("SprayboomTemparature"));
		centerline.setWefanSpeed(rs.getDouble("WEFanSpeed"));
		centerline.setDefanSpeed(rs.getDouble("DEFanSpeed"));
		centerline.setMakeUpAirDamper(rs.getDouble("MakeUpAirDamper"));
		centerline.setExhaustDamper(rs.getDouble("ExhaustDamper"));
		centerline.setExhaustFanSpeed(rs.getDouble("ExhaustFanSpeed"));
		centerline.setWehoodTemperature(rs.getDouble("WEHoodTemperature"));
		centerline.setDehoodTemperature(rs.getDouble("DEHoodTemperature"));
		centerline.setYankeeAP(rs.getDouble("YankeeAP"));
		centerline.setAfterDryerAP(rs.getDouble("AfterDryerAP"));
		centerline.setSecArmLoading(rs.getDouble("SecArmLoading"));
		centerline.setReelOffset(rs.getDouble("ReelOffset"));
		centerline.setUhleBoxNorthValve(rs.getDouble("UhleBoxNorthValve"));
		centerline.setUhleBoxSouthValve(rs.getDouble("UhleBoxSouthValve"));
		centerline.setFaltBox1VacuumValve(rs.getDouble("FaltBox1VacuumValve"));
		centerline.setFaltBox2VacuumValve(rs.getDouble("FaltBox2VacuumValve"));
		centerline.setFaltBox4VacuumValve(rs.getDouble("FaltBox4VacuumValve"));
		centerline.setFanPumpSpeed(rs.getDouble("FanPumpSpeed"));
		centerline.setTotalHead(rs.getDouble("TotalHead"));
		centerline.setHeadboxLevel(rs.getDouble("HeadboxLevel"));
		centerline.setHorizontalSlice(rs.getString("HorizontalSlice"));
		centerline.setVerticalSlice(rs.getString("VerticalSlice"));
		centerline.setSelectifierRejectFlow1(rs.getDouble("SelectifierRejectFlow1"));
		centerline.setSelectifierRejectFlow2(rs.getDouble("SelectifierRejectFlow2"));
		centerline.setSecScreenCycleTime(rs.getDouble("SecScreenCycleTime"));
		centerline.setLowDensityCycleTime(rs.getDouble("LowDensityCycleTime"));
		centerline.setRefinersEnergy(rs.getDouble("RefinersEnergy"));
		centerline.setNumberOfRefiners(rs.getDouble("NumberOfRefiners"));
		centerline.setRefinerInletConsistency(rs.getDouble("RefinerInletConsistency"));
		centerline.setMachineChestConsistency(rs.getDouble("MachineChestConsistency"));
		centerline.setStockFlow(rs.getDouble("StockFlow"));
		centerline.setSweetnerFlow(rs.getDouble("SweetnerFlow"));
		centerline.setBroke(rs.getDouble("Broke"));
		centerline.setWetStrength(rs.getDouble("WetStrength"));
		centerline.setDate(rs.getDate("Date"));
		centerline.setIssueDate(rs.getDate("IssueDate"));
		centerline.setRevision(rs.getString("Revision"));
		centerline.setNoteSecA(rs.getString("NoteSecA"));
		centerline.setNoteSecB(rs.getString("NoteSecB"));
		
		
		//New Field
		centerline.setAfterDryerDraw(rs.getDouble("AfterDryerDraw"));
		centerline.setHorizontalSliceDcs(rs.getString("HorizontalSliceDcs"));
		centerline.setVerticalSliceDcs(rs.getString("VerticalSliceDcs"));
		
		//New Fields Added Here By Roshan
		
		centerline.setSprloadingfront(rs.getDouble("sprloadingfront"));
		centerline.setSprloadingback(rs.getDouble("sprloadingback"));
		centerline.setPickuprollvacuum(rs.getDouble("pickuprollvacuum"));
		centerline.setUhleboxvacuum(rs.getDouble("uhleboxvacuum"));
		centerline.setSprvacuum(rs.getDouble("sprvacuum"));
		centerline.setPrimaryscreenrejectflow(rs.getDouble("primaryscreenrejectflow"));
		centerline.setBlendchestcy(rs.getDouble("blendchestcy"));
		centerline.setRefiner1power(rs.getDouble("refiner1power"));
		centerline.setRefiner2power(rs.getDouble("refiner2power"));
		centerline.setRefiner1inletcy(rs.getDouble("refiner1inletcy"));
		centerline.setRefiner2inletcy(rs.getDouble("refiner2inletcy"));
		
		centerline.setBasisweighttarget(rs.getDouble("basisweighttarget"));
		centerline.setMoisturetarget(rs.getDouble("moisturetarget"));
		centerline.setYankeemapflow(rs.getDouble("yankeemapflow"));
		centerline.setMachinechestpumpspeed(rs.getDouble("machinechestpumpspeed"));
		
		
		return centerline;
	}

}
