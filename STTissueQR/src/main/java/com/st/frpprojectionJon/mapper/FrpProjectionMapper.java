/**
 * 
 */
package com.st.frpprojectionJon.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.frpprojection.model.FrpProjection;

/**
 * @author sbora
 *
 */
public class FrpProjectionMapper implements RowMapper<FrpProjection> {

	
	@Override
	public FrpProjection mapRow(ResultSet rs, int arg1) throws SQLException {
		FrpProjection frpProjection=new FrpProjection();
		frpProjection.setId(rs.getInt("ID"));
		frpProjection.setType(rs.getString("Type"));
		frpProjection.setType2(rs.getString("Type2"));
		frpProjection.setInput(rs.getDouble("Input"));
		frpProjection.setMwlAndSwl(rs.getDouble("MwlAndSwl"));
		frpProjection.setSow(rs.getDouble("Sow"));
		frpProjection.setCbs(rs.getDouble("Cbs"));
		frpProjection.setSowAndMail(rs.getDouble("SowAndMail"));
		frpProjection.setGrowndwood(rs.getDouble("Growndwood"));
		frpProjection.setDlk(rs.getDouble("Dlk"));
		frpProjection.setOcc(rs.getDouble("Occ"));
		frpProjection.setOthers(rs.getDouble("Others"));
		frpProjection.setRemarks(rs.getString("Remarks"));
		
		//New Fields
		frpProjection.setOccMinR(rs.getDouble("OccMinR"));
		frpProjection.setOccMinC(rs.getDouble("OccMinC"));
		frpProjection.setOccTarget(rs.getDouble("OccTarget"));
		frpProjection.setOccMaxC(rs.getDouble("OccMaxC"));
		frpProjection.setOccMaxR(rs.getDouble("OccMaxR"));
		frpProjection.setDlkMinR(rs.getDouble("DlkMinR"));
		frpProjection.setDlkMinC(rs.getDouble("DlkMinC"));
		frpProjection.setDlkTarget(rs.getDouble("DlkTarget"));
		frpProjection.setDlkMaxC(rs.getDouble("DlkMaxC"));
		frpProjection.setDlkMaxR(rs.getDouble("DlkMaxR"));
		frpProjection.setSowAndMailMinR(rs.getDouble("SowAndMailMinR"));
		frpProjection.setSowAndMailMinC(rs.getDouble("SowAndMailMinC"));
		frpProjection.setSowAndMailTarget(rs.getDouble("SowAndMailTarget"));
		frpProjection.setSowAndMailMaxC(rs.getDouble("SowAndMailMaxC"));
		frpProjection.setSowAndMailMaxR(rs.getDouble("SowAndMailMaxR"));
		frpProjection.setGrowndwoodMinR(rs.getDouble("GrowndwoodMinR"));
		frpProjection.setGrowndwoodMinC(rs.getDouble("GrowndwoodMinC"));
		frpProjection.setGrowndwoodTarget(rs.getDouble("GrowndwoodTarget"));
		frpProjection.setGrowndwoodMaxC(rs.getDouble("GrowndwoodMaxC"));
		frpProjection.setGrowndwoodMaxR(rs.getDouble("GrowndwoodMaxR"));
		frpProjection.setMwlAndSwlMinR(rs.getDouble("MwlAndSwlMinR"));
		frpProjection.setMwlAndSwlMinC(rs.getDouble("MwlAndSwlMinC"));
		frpProjection.setMwlAndSwlTarget(rs.getDouble("MwlAndSwlTarget"));
		frpProjection.setMwlAndSwlMaxC(rs.getDouble("MwlAndSwlMaxC"));
		frpProjection.setMwlAndSwlMaxR(rs.getDouble("MwlAndSwlMaxR"));
		frpProjection.setSowMinR(rs.getDouble("SowMinR"));
		frpProjection.setSowMinC(rs.getDouble("SowMinC"));
		frpProjection.setSowTarget(rs.getDouble("SowTarget"));
		frpProjection.setSowMaxC(rs.getDouble("SowMaxC"));
		frpProjection.setSowMaxR(rs.getDouble("SowMaxR"));
		frpProjection.setCbsMinR(rs.getDouble("CbsMinR"));
		frpProjection.setCbsMinC(rs.getDouble("CbsMinC"));
		frpProjection.setCbsTarget(rs.getDouble("CbsTarget"));
		frpProjection.setCbsMaxC(rs.getDouble("CbsMaxC"));
		frpProjection.setCbsMaxR(rs.getDouble("CbsMaxR"));
		frpProjection.setOthersMinR(rs.getDouble("OthersMinR"));
		frpProjection.setOthersMinC(rs.getDouble("OthersMinC"));
		frpProjection.setOthersTarget(rs.getDouble("OthersTarget"));
		frpProjection.setOthersMaxC(rs.getDouble("OthersMaxC"));
		frpProjection.setOthersMaxR(rs.getDouble("OthersMaxR"));

		
		frpProjection.setMixedPaper(rs.getDouble("MixedPaper"));
		frpProjection.setMixedPaperMinR(rs.getDouble("MixedPaperMinR"));
		frpProjection.setMixedPaperMinC(rs.getDouble("MixedPaperMinC"));
		frpProjection.setMixedPaperTarget(rs.getDouble("MixedPaperTarget"));
		frpProjection.setMixedPaperMaxC(rs.getDouble("MixedPaperMaxC"));
		frpProjection.setMixedPaperMaxR(rs.getDouble("MixedPaperMaxR"));
		
		
		frpProjection.setCutBook(rs.getDouble("CutBook"));
		frpProjection.setCutBookMinR(rs.getDouble("CutBookMinR"));
		frpProjection.setCutBookMinC(rs.getDouble("CutBookMinC"));
		frpProjection.setCutBookTarget(rs.getDouble("CutBookTarget"));
		frpProjection.setCutBookMaxC(rs.getDouble("CutBookMaxC"));
		frpProjection.setCutBookMaxR(rs.getDouble("CutBookMaxR"));
		
		//Code Starts From Here Done By Roshan Tailor
		
		frpProjection.setHw(rs.getDouble("hw"));
		frpProjection.setHwMinR(rs.getDouble("hwMinR"));
		frpProjection.setHwMinC(rs.getDouble("hwMinC"));
		frpProjection.setHwTarget(rs.getDouble("hwTarget"));
		frpProjection.setHwMaxC(rs.getDouble("hwMaxC"));
		frpProjection.setHwMaxR(rs.getDouble("hwMaxR"));
		
		
		frpProjection.setUnprtsbs(rs.getDouble("unprtsbs"));
		frpProjection.setUnprtsbsMinR(rs.getDouble("unprtsbsMinR"));
		frpProjection.setUnprtsbsMinC(rs.getDouble("unprtsbsMinC"));
		frpProjection.setUnprtsbsTarget(rs.getDouble("unprtsbsTarget"));
		frpProjection.setUnprtsbsMaxC(rs.getDouble("unprtsbsMaxC"));
		frpProjection.setUnprtsbsMaxR(rs.getDouble("unprtsbsMaxR"));
		
		
		//Code Ends Here Done By Roshan Tailor
		
		return frpProjection;
	}

}
