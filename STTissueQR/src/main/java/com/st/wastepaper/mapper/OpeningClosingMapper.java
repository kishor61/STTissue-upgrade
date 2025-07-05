/**
 *Jul 23, 2015
 *OpeningClosingMapper.java
 * TODO
 *com.st.wastepaperunloadbale.mapper
 *OpeningClosingMapper.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.wastepaper.model.BarcodeComman;

/**
 * @author roshan
 *
 */
public class OpeningClosingMapper implements RowMapper<BarcodeComman>{
	@Override
	public BarcodeComman mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		BarcodeComman barcodeComman=new BarcodeComman();
		//wastePaperBaleInventory.setGradeCode(rs.getLong("GradeCode"));
		barcodeComman.setPrtmix(rs.getInt("Prtmix"));
		barcodeComman.setClosemonth(rs.getInt("closemonth"));
		barcodeComman.setCloseyear(rs.getInt("closeyear"));
		/*barcodeComman.setMWL(rs.getInt("MWL"));
		barcodeComman.setMCL(rs.getInt("MCL"));
		barcodeComman.setMWLWIGS(rs.getInt("MWLWIGS"));
		barcodeComman.setCBS(rs.getInt("CBS"));
		barcodeComman.setCtdGdwd(rs.getInt("CtdGdwd"));
		barcodeComman.setSWLSortedWhite(rs.getInt("SWLSortedWhite"));
		barcodeComman.setONPOldNewsPrint(rs.getInt("ONPOldNewsPrint"));
		barcodeComman.setOINews(rs.getInt("OINews"));
		barcodeComman.setLightPrtSBS(rs.getInt("LightPrtSBS"));
		barcodeComman.setHW(rs.getInt("HW"));
		barcodeComman.setHeavyPrtSBS(rs.getInt("HeavyPrtSBS"));
		barcodeComman.setSOW(rs.getInt("SOW"));
		barcodeComman.setUnprtSBS(rs.getInt("UnprtSBS"));
		barcodeComman.setNewsblank(rs.getInt("Newsblank"));
		barcodeComman.setWhiteGdwdBlend(rs.getInt("WhiteGdwdBlend"));
		barcodeComman.setMailUndeliverable(rs.getInt("MailUndeliverable"));
		barcodeComman.setHoggedBooks(rs.getInt("HoggedBooks"));
		barcodeComman.setOCC(rs.getInt("OCC"));
		barcodeComman.setDLK(rs.getInt("DLK"));
		barcodeComman.setMixedPaper(rs.getInt("MixedPaper"));
		barcodeComman.setSoftWoodChips(rs.getInt("SoftWoodChips"));
		barcodeComman.setHardWoodChips(rs.getInt("HardWoodChips"));
		barcodeComman.setWhiteBroke(rs.getInt("WhiteBroke"));
		barcodeComman.setPWE(rs.getInt("PWE"));
		barcodeComman.setBrownNapkinBroke(rs.getInt("BrownNapkinBroke"));
		barcodeComman.setPULPWetLap(rs.getInt("PULPWetLap"));
		barcodeComman.setVirginPulp(rs.getInt("VirginPulp"));
		barcodeComman.setBrownWetLap(rs.getInt("BrownWetLap"));
		barcodeComman.setPulpDryLap(rs.getInt("PulpDryLap"));
		barcodeComman.setOtherRolls(rs.getInt("OtherRolls"));
		barcodeComman.setSTBaleswetlap(rs.getInt("STBaleswetlap"));
		barcodeComman.setSTTBaledBrokeButl(rs.getInt("STTBaledBrokeButl"));
		*/
		return barcodeComman;
		
	}

}
