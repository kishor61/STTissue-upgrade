package com.st.centerline.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.centerline.model.CenterlineGrade;

public class CenterlineGradeMapper implements RowMapper<CenterlineGrade> {

	@Override
	public CenterlineGrade mapRow(ResultSet rs, int arg1) throws SQLException {
		CenterlineGrade centerline=new CenterlineGrade();
		
		centerline.setId(rs.getInt("ID"));
		centerline.setGrade(rs.getString("Grade"));
		centerline.setCrew(rs.getString("Crew"));
		centerline.setShift(rs.getString("Shift"));
		
		centerline.setYankeeSpeedMinC(rs.getDouble("YankeeSpeedMinC"));	
		centerline.setYankeeSpeed(rs.getDouble("YankeeSpeed"));	
		centerline.setYankeeSpeedMaxC(rs.getDouble("YankeeSpeedMaxC"));	
		centerline.setQcsBasisWtTargetMinC(rs.getDouble("QCSBasisWtTargetMinC"));
		centerline.setQcsBasisWtTarget(rs.getDouble("QCSBasisWtTarget"));
		centerline.setQcsBasisWtTargetMaxC(rs.getDouble("QCSBasisWtTargetMaxC"));
		centerline.setReelMoistureMinC(rs.getDouble("ReelMoistureMinC"));
		centerline.setReelMoisture(rs.getDouble("ReelMoisture"));
		centerline.setReelMoistureMaxC(rs.getDouble("ReelMoistureMaxC"));
		centerline.setCrepeMinC(rs.getDouble("CrepeMinC"));
		centerline.setCrepe(rs.getDouble("Crepe"));
		centerline.setCrepeMaxC(rs.getDouble("CrepeMaxC"));
		centerline.setYankeeSteamMinC(rs.getDouble("YankeeSteamMinC"));
		centerline.setYankeeSteam(rs.getDouble("YankeeSteam"));
		centerline.setYankeeSteamMaxC(rs.getDouble("YankeeSteamMaxC"));
		centerline.setYankeeReleaseMinC(rs.getDouble("YankeeReleaseMinC"));
		centerline.setYankeeRelease(rs.getDouble("YankeeRelease"));
		centerline.setYankeeReleaseMaxC(rs.getDouble("YankeeReleaseMaxC"));
		centerline.setYankeeAdesiveMinC(rs.getDouble("YankeeAdesiveMinC"));
		centerline.setYankeeAdesive(rs.getDouble("YankeeAdesive"));
		centerline.setYankeeAdesiveMaxC(rs.getDouble("YankeeAdesiveMaxC"));
		centerline.setJetWireRatioMinC(rs.getDouble("JetWireRatioMinC"));
		centerline.setJetWireRatio(rs.getDouble("JetWireRatio"));
		centerline.setJetWireRatioMaxC(rs.getDouble("JetWireRatioMaxC"));
		centerline.setFanPumpFlowRateMinC(rs.getDouble("FanPumpFlowRateMinC"));
		centerline.setFanPumpFlowRate(rs.getDouble("FanPumpFlowRate"));
		centerline.setFanPumpFlowRateMaxC(rs.getDouble("FanPumpFlowRateMaxC"));
		centerline.setAfterDryerSteamMinC(rs.getDouble("AfterDryerSteamMinC"));
		centerline.setAfterDryerSteam(rs.getDouble("AfterDryerSteam"));
		centerline.setAfterDryerSteamMaxC(rs.getDouble("AfterDryerSteamMaxC"));
		centerline.setSprLoadingMinC(rs.getString("SPRLoadingMinC"));
		centerline.setSprLoading(rs.getString("SPRLoading"));
		centerline.setSprLoadingMaxC(rs.getString("SPRLoadingMaxC"));
		centerline.setFeltPassivatorMinC(rs.getDouble("FeltPassivatorMinC"));
		centerline.setFeltPassivator(rs.getDouble("FeltPassivator"));
		centerline.setFeltPassivatorMaxC(rs.getDouble("FeltPassivatorMaxC"));
		centerline.setSprayboomPressureMinC(rs.getDouble("SprayboomPressureMinC"));
		centerline.setSprayboomPressure(rs.getDouble("SprayboomPressure"));
		centerline.setSprayboomPressureMaxC(rs.getDouble("SprayboomPressureMaxC"));
		centerline.setSprayboomTemparatureMinC(rs.getDouble("SprayboomTemparatureMinC"));
		centerline.setSprayboomTemparature(rs.getDouble("SprayboomTemparature"));
		centerline.setSprayboomTemparatureMaxC(rs.getDouble("SprayboomTemparatureMaxC"));
		centerline.setWefanSpeedMinC(rs.getDouble("WEFanSpeedMinC"));
		centerline.setWefanSpeed(rs.getDouble("WEFanSpeed"));
		centerline.setWefanSpeedMaxC(rs.getDouble("WEFanSpeedMaxC"));
		centerline.setDefanSpeedMinC(rs.getDouble("DEFanSpeedMinC"));
		centerline.setDefanSpeed(rs.getDouble("DEFanSpeed"));
		centerline.setDefanSpeedMaxC(rs.getDouble("DEFanSpeedMaxC"));
		centerline.setMakeUpAirDamperMinC(rs.getDouble("MakeUpAirDamperMinC"));
		centerline.setMakeUpAirDamper(rs.getDouble("MakeUpAirDamper"));
		centerline.setMakeUpAirDamperMaxC(rs.getDouble("MakeUpAirDamperMaxC"));
		centerline.setExhaustDamperMinC(rs.getDouble("ExhaustDamperMinC"));
		centerline.setExhaustDamper(rs.getDouble("ExhaustDamper"));
		centerline.setExhaustDamperMaxC(rs.getDouble("ExhaustDamperMaxC"));
		centerline.setExhaustFanSpeedMinC(rs.getDouble("ExhaustFanSpeedMinC"));
		centerline.setExhaustFanSpeed(rs.getDouble("ExhaustFanSpeed"));
		centerline.setExhaustFanSpeedMaxC(rs.getDouble("ExhaustFanSpeedMaxC"));
		centerline.setWehoodTemperatureMinC(rs.getDouble("WEHoodTemperatureMinC"));
		centerline.setWehoodTemperature(rs.getDouble("WEHoodTemperature"));
		centerline.setWehoodTemperatureMaxC(rs.getDouble("WEHoodTemperatureMaxC"));
		centerline.setDehoodTemperatureMinC(rs.getDouble("DEHoodTemperatureMinC"));
		centerline.setDehoodTemperature(rs.getDouble("DEHoodTemperature"));
		centerline.setDehoodTemperatureMaxC(rs.getDouble("DEHoodTemperatureMaxC"));
		centerline.setYankeeAPMinC(rs.getDouble("YankeeAPMinC"));
		centerline.setYankeeAP(rs.getDouble("YankeeAP"));
		centerline.setYankeeAPMaxC(rs.getDouble("YankeeAPMaxC"));
		centerline.setAfterDryerAPMinC(rs.getDouble("AfterDryerAPMinC"));
		centerline.setAfterDryerAP(rs.getDouble("AfterDryerAP"));
		centerline.setAfterDryerAPMaxC(rs.getDouble("AfterDryerAPMaxC"));
		centerline.setSecArmLoadingMinC(rs.getDouble("SecArmLoadingMinC"));
		centerline.setSecArmLoading(rs.getDouble("SecArmLoading"));
		centerline.setSecArmLoadingMaxC(rs.getDouble("SecArmLoadingMaxC"));
		centerline.setReelOffsetMinC(rs.getDouble("ReelOffsetMinC"));
		centerline.setReelOffset(rs.getDouble("ReelOffset"));
		centerline.setReelOffsetMaxC(rs.getDouble("ReelOffsetMaxC"));
		centerline.setUhleBoxNorthValveMinC(rs.getDouble("UhleBoxNorthValveMinC"));
		centerline.setUhleBoxNorthValve(rs.getDouble("UhleBoxNorthValve"));
		centerline.setUhleBoxNorthValveMaxC(rs.getDouble("UhleBoxNorthValveMaxC"));
		centerline.setUhleBoxSouthValveMinC(rs.getDouble("UhleBoxSouthValveMinC"));
		centerline.setUhleBoxSouthValve(rs.getDouble("UhleBoxSouthValve"));
		centerline.setUhleBoxSouthValveMaxC(rs.getDouble("UhleBoxSouthValveMaxC"));
		centerline.setFaltBox1VacuumValveMinC(rs.getDouble("FaltBox1VacuumValveMinC"));
		centerline.setFaltBox1VacuumValve(rs.getDouble("FaltBox1VacuumValve"));
		centerline.setFaltBox1VacuumValveMaxC(rs.getDouble("FaltBox1VacuumValveMaxC"));
		centerline.setFaltBox2VacuumValveMinC(rs.getDouble("FaltBox2VacuumValveMinC"));
		centerline.setFaltBox2VacuumValve(rs.getDouble("FaltBox2VacuumValve"));
		centerline.setFaltBox2VacuumValveMaxC(rs.getDouble("FaltBox2VacuumValveMaxC"));
		centerline.setFaltBox4VacuumValveMinC(rs.getDouble("FaltBox4VacuumValveMinC"));
		centerline.setFaltBox4VacuumValve(rs.getDouble("FaltBox4VacuumValve"));
		centerline.setFaltBox4VacuumValveMaxC(rs.getDouble("FaltBox4VacuumValveMaxC"));
		centerline.setFanPumpSpeedMinC(rs.getDouble("FanPumpSpeedMinC"));
		centerline.setFanPumpSpeed(rs.getDouble("FanPumpSpeed"));
		centerline.setFanPumpSpeedMaxC(rs.getDouble("FanPumpSpeedMaxC"));
		centerline.setTotalHeadMinC(rs.getDouble("TotalHeadMinC"));
		centerline.setTotalHead(rs.getDouble("TotalHead"));
		centerline.setTotalHeadMaxC(rs.getDouble("TotalHeadMaxC"));
		centerline.setHeadboxLevelMinC(rs.getDouble("HeadboxLevelMinC"));
		centerline.setHeadboxLevel(rs.getDouble("HeadboxLevel"));
		centerline.setHeadboxLevelMaxC(rs.getDouble("HeadboxLevelMaxC"));
		centerline.setHorizontalSliceMinC(rs.getString("HorizontalSliceMinC"));
		centerline.setHorizontalSlice(rs.getString("HorizontalSlice"));
		centerline.setHorizontalSliceMaxC(rs.getString("HorizontalSliceMaxC"));
		centerline.setVerticalSliceMinC(rs.getString("VerticalSliceMinC"));
		centerline.setVerticalSlice(rs.getString("VerticalSlice"));
		centerline.setVerticalSliceMaxC(rs.getString("VerticalSliceMaxC"));
		centerline.setSelectifierRejectFlow1MinC(rs.getDouble("SelectifierRejectFlow1MinC"));
		centerline.setSelectifierRejectFlow1(rs.getDouble("SelectifierRejectFlow1"));
		centerline.setSelectifierRejectFlow1MaxC(rs.getDouble("SelectifierRejectFlow1MaxC"));
		centerline.setSelectifierRejectFlow2MinC(rs.getDouble("SelectifierRejectFlow2MinC"));
		centerline.setSelectifierRejectFlow2(rs.getDouble("SelectifierRejectFlow2"));
		centerline.setSelectifierRejectFlow2MaxC(rs.getDouble("SelectifierRejectFlow2MaxC"));
		centerline.setSecScreenCycleTimeMinC(rs.getDouble("SecScreenCycleTimeMinC"));
		centerline.setSecScreenCycleTime(rs.getDouble("SecScreenCycleTime"));
		centerline.setSecScreenCycleTimeMaxC(rs.getDouble("SecScreenCycleTimeMaxC"));
		centerline.setLowDensityCycleTimeMinC(rs.getDouble("LowDensityCycleTimeMinC"));
		centerline.setLowDensityCycleTime(rs.getDouble("LowDensityCycleTime"));
		centerline.setLowDensityCycleTimeMaxC(rs.getDouble("LowDensityCycleTimeMaxC"));
		centerline.setRefinersEnergyMinC(rs.getDouble("RefinersEnergyMinC"));
		centerline.setRefinersEnergy(rs.getDouble("RefinersEnergy"));
		centerline.setRefinersEnergyMaxC(rs.getDouble("RefinersEnergyMaxC"));
		centerline.setNumberOfRefinersMinC(rs.getDouble("NumberOfRefinersMinC"));
		centerline.setNumberOfRefiners(rs.getDouble("NumberOfRefiners"));
		centerline.setNumberOfRefinersMaxC(rs.getDouble("NumberOfRefinersMaxC"));
		centerline.setRefinerInletConsistencyMinC(rs.getDouble("RefinerInletConsistencyMinC"));
		centerline.setRefinerInletConsistency(rs.getDouble("RefinerInletConsistency"));
		centerline.setRefinerInletConsistencyMaxC(rs.getDouble("RefinerInletConsistencyMaxC"));
		centerline.setMachineChestConsistencyMinC(rs.getDouble("MachineChestConsistencyMinC"));
		centerline.setMachineChestConsistency(rs.getDouble("MachineChestConsistency"));
		centerline.setMachineChestConsistencyMaxC(rs.getDouble("MachineChestConsistencyMaxC"));
		centerline.setStockFlowMinC(rs.getDouble("StockFlowMinC"));
		centerline.setStockFlow(rs.getDouble("StockFlow"));
		centerline.setStockFlowMaxC(rs.getDouble("StockFlowMaxC"));
		centerline.setSweetnerFlowMinC(rs.getDouble("SweetnerFlowMinC"));
		centerline.setSweetnerFlow(rs.getDouble("SweetnerFlow"));
		centerline.setSweetnerFlowMaxC(rs.getDouble("SweetnerFlowMaxC"));
		centerline.setBrokeMinC(rs.getDouble("BrokeMinC"));
		centerline.setBroke(rs.getDouble("Broke"));
		centerline.setBrokeMaxC(rs.getDouble("BrokeMaxC"));
		centerline.setWetStrengthMinC(rs.getDouble("WetStrengthMinC"));
		centerline.setWetStrength(rs.getDouble("WetStrength"));
		centerline.setWetStrengthMaxC(rs.getDouble("WetStrengthMaxC"));
		centerline.setIssueDate(rs.getDate("IssueDate"));
		centerline.setRevision(rs.getString("Revision"));
		
		centerline.setAfterDryerDrawMinC(rs.getDouble("AfterDryerDrawMinC"));
		centerline.setAfterDryerDraw(rs.getDouble("AfterDryerDraw"));
		centerline.setAfterDryerDrawMaxC(rs.getDouble("AfterDryerDrawMaxC"));
		
		centerline.setHorizontalSliceDcsMinC(rs.getString("HorizontalSliceDcsMinC"));
		centerline.setHorizontalSliceDcs(rs.getString("HorizontalSliceDcs"));
		centerline.setHorizontalSliceDcsMaxC(rs.getString("HorizontalSliceDcsMaxC"));
		
		centerline.setVerticalSliceDcsMinC(rs.getString("VerticalSliceDcsMinC"));
		centerline.setVerticalSliceDcs(rs.getString("VerticalSliceDcs"));
		centerline.setVerticalSliceDcsMaxC(rs.getString("VerticalSliceDcsMaxC"));
		
		//New Fields Added From Heree By Roshan
		/*centerline.setSprloadingfrontMinC(rs.getDouble("sprloadingfrontMinC"));
		centerline.setSprloadingfront(rs.getDouble("sprloadingfront"));
		centerline.setSprloadingfrontMaxC(rs.getDouble("sprloadingfrontMaxC"));

		centerline.setSprloadingbackMinC(rs.getDouble("sprloadingbackMinC"));
		centerline.setSprloadingback(rs.getDouble("sprloadingback"));
		centerline.setSprloadingbackMaxC(rs.getDouble("sprloadingbackMaxC"));

		centerline.setPickuprollvacuumMinC(rs.getDouble("pickuprollvacuumMinC"));
		centerline.setPickuprollvacuum(rs.getDouble("pickuprollvacuum"));
		centerline.setPickuprollvacuumMaxC(rs.getDouble("pickuprollvacuumMaxC"));

		centerline.setUhleboxvacuumMinC(rs.getDouble("uhleboxvacuumMinC"));
		centerline.setUhleboxvacuum(rs.getDouble("uhleboxvacuum"));
		centerline.setUhleboxvacuumMaxC(rs.getDouble("uhleboxvacuumMaxC"));

		centerline.setSprvacuumMinC(rs.getDouble("sprvacuumMinC"));
		centerline.setSprvacuum(rs.getDouble("sprvacuum"));
		centerline.setSprvacuumMaxC(rs.getDouble("sprvacuumMaxC"));

		centerline.setPrimaryscreenrejectflowMinC(rs.getDouble("primaryscreenrejectflowMinC"));
		centerline.setPrimaryscreenrejectflow(rs.getDouble("primaryscreenrejectflow"));
		centerline.setPrimaryscreenrejectflowMaxC(rs.getDouble("primaryscreenrejectflowMaxC"));

		centerline.setBlendchestcyMinC(rs.getDouble("blendchestcyMinC"));
		centerline.setBlendchestcy(rs.getDouble("blendchestcy"));
		centerline.setBlendchestcyMaxC(rs.getDouble("blendchestcyMaxC"));

		centerline.setRefiner1powerMinC(rs.getDouble("refiner1powerMinC"));
		centerline.setRefiner1power(rs.getDouble("refiner1power"));
		centerline.setRefiner1powerMaxC(rs.getDouble("refiner1powerMaxC"));

		centerline.setRefiner2powerMinC(rs.getDouble("refiner2powerMinC"));
		centerline.setRefiner2power(rs.getDouble("refiner2power"));
		centerline.setRefiner2powerMaxC(rs.getDouble("refiner2powerMaxC"));

		centerline.setRefiner1inletcyMinC(rs.getDouble("refiner1inletcyMinC"));
		centerline.setRefiner1inletcy(rs.getDouble("refiner1inletcy"));
		centerline.setRefiner1inletcyMaxC(rs.getDouble("refiner1inletcyMaxC"));

		centerline.setRefiner2inletcyMinC(rs.getDouble("refiner2inletcyMinC"));
		centerline.setRefiner2inletcy(rs.getDouble("refiner2inletcy"));
		centerline.setRefiner2inletcyMaxC(rs.getDouble("refiner2inletcyMaxC"));*/


		return centerline;
	}

}
