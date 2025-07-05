/**
 * 
 */
package com.st.frpproduction.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.st.frpproduction.model.FrpProdcution;

/**
 * @author sbora
 *
 */
public class FrpProdcutionMapper implements RowMapper<FrpProdcution> {


	@Override
	public FrpProdcution mapRow(ResultSet rs, int arg1) throws SQLException {
		FrpProdcution frpProdcution=new FrpProdcution();
		frpProdcution.setId(rs.getInt("ID"));
		frpProdcution.setDate(new Date(rs.getTimestamp("Date").getTime()));
		frpProdcution.setHdStorage(rs.getDouble("HdStorage"));
		frpProdcution.setDcsWPFeedADST(rs.getDouble("DcsWPFeedADST"));
		frpProdcution.setPrimaryPressADST(rs.getDouble("PrimaryPressADST"));
		frpProdcution.setWetLapProdADST(rs.getDouble("WetLapProdADST"));
		frpProdcution.setTotalProdADST(rs.getDouble("TotalProdADST"));
		frpProdcution.setTrackerWPfeed(rs.getDouble("TrackerWPfeed"));
		frpProdcution.setYieldDcs(rs.getDouble("YieldDcs"));
		frpProdcution.setYieldTracker(rs.getDouble("YieldTracker"));
		frpProdcution.setFreshWater(rs.getDouble("FreshWater"));
		frpProdcution.setMrMwlAndSwl(rs.getDouble("MRMwlAndSwl"));
		frpProdcution.setMrSowAndCbs(rs.getDouble("MRSowAndCbs"));
		frpProdcution.setMrDlk(rs.getDouble("MRDlk"));
		frpProdcution.setMrOcc(rs.getDouble("MROcc"));
		frpProdcution.setMrWhiteGrades(rs.getDouble("MRWhiteGrades"));
		frpProdcution.setMrGroundwood(rs.getDouble("MRGroundwood"));
		frpProdcution.setMrOther(rs.getDouble("MROther"));
		frpProdcution.setWpmMwl(rs.getDouble("WPMMwl"));
		frpProdcution.setWpmPrintMix(rs.getDouble("WPMPrintMix"));
		frpProdcution.setWpmSow(rs.getDouble("WPMSow"));
		frpProdcution.setWpmCbs(rs.getDouble("WPMCbs"));
		frpProdcution.setWpmSowAndCbs(rs.getDouble("WPMSowAndCbs"));
		frpProdcution.setWpmCtdGrwd(rs.getDouble("WPMCtdGrwd"));
		frpProdcution.setWpmSwl(rs.getDouble("WPMSwl"));
		frpProdcution.setWpmOcc(rs.getDouble("WPMOcc"));
		frpProdcution.setWpmNewsNewsblank(rs.getDouble("WPMNewsNewsblank"));
		frpProdcution.setWpmDlk(rs.getDouble("WPMDlk"));
		frpProdcution.setWpmOther(rs.getDouble("WPMOther"));
		frpProdcution.setWpmTotal(rs.getDouble("WPMTotal"));
		frpProdcution.setTargetBrightness(rs.getString("TargetBrightness"));
		frpProdcution.setDailyAvg(rs.getDouble("DailyAvg"));
		frpProdcution.setPmTargetBrite(rs.getString("PMTargetBrite"));
		frpProdcution.setPmAvgBrite(rs.getString("PMAvgBrite"));
		frpProdcution.setComments(rs.getString("Comments"));
		frpProdcution.setProdType(rs.getString("ProdType"));
		frpProdcution.setWpMailUndeliverable(rs.getDouble("WPMailUndeliverable"));
		frpProdcution.setGrade(rs.getString("Grade"));
		
		frpProdcution.setFreshWater2(rs.getDouble("FreshWater2"));
		
		return frpProdcution;
	}

}
