/**
 *May 5, 2016
 *WetlapInventoryDaoImp.java
 * TODO
 *com.st.wetlapinventory.dao
 *WetlapInventoryDaoImp.java
 *Sunil Singh Bora
 */
package com.st.wetlapinventory.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.wastepaper.model.WastePaperBaleInventory;
import com.st.wastepaper.model.WastepaperDetail;
import com.st.wetlapinventory.model.WetlapInventory;

/**
 * @author roshan
 *
 */
@Repository
public class WetlapInventoryDaoImp implements WetlapInventoryDao{

	@Autowired
	@Qualifier("dataSourceTracker")
	private DataSource dataSourceT;
	
	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.wetlapinventory.dao.WetlapInventoryDao#getReportData()
	 */
	@Override
	public List<WetlapInventory> getReportData() {
		// TODO Auto-generated method stub
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceT);
		double totalnetTonforFRP=0;
		double totalgrosstonforFRP=0;
		
		double totalnetTonforYard=0;
		double totalgrosstonforYard=0;
		
		
		double totalnetlbsforFRP=0;
		double totalgrosslbsforFRP=0;
		
		double totalnetlbsforYard=0;
		double totalgrosslbsforYard=0;
		
		List<WetlapInventory> details=new ArrayList<WetlapInventory>();
		final WetlapInventory inventory=new WetlapInventory();
		try{
			
			
			/*String sql_Frp="SELECT tblWetLapLotHeader.LotHeaderID, tblWetLapLotHeader.ProductionDate, tblWetLapLotDetail.WLBaleID, [WLBaleWeightLbsNet]+0 AS NetLbs, [WLBaleWeightLbsGross]+0 AS GrossLbs, IIf([BaleStatus]='','FRP',[BaleStatus]) AS Status, tblWetLapLotHeader.AirDriedPercent, tblWetLapLotHeader.LotColor "
					+ " FROM tblWetLapLotHeader INNER JOIN tblWetLapLotDetail ON tblWetLapLotHeader.LotHeaderID = tblWetLapLotDetail.LotHeaderID "
					+ " WHERE (((IIf(Nz([BaleStatus])='','FRP',[BaleStatus]))<>'Shipped'))";*/
			String sql_Frp="SELECT tblWetLapLotHeader.LotHeaderID,[tblWetLapLotDetail.WLBaleWeightLbsNet]/2000 AS NetTON1,[tblWetLapLotDetail.WLBaleWeightLbsGross]/2000 as GrossTON2, "
							+ " [tblWetLapLotDetail.WLBaleWeightLbsNet] AS NetLBS1,[tblWetLapLotDetail.WLBaleWeightLbsGross] as GrossLBS2, "
							+ " tblWetLapLotDetail.BaleStatus AS BaleStatus  FROM tblWetLapLotHeader INNER JOIN tblWetLapLotDetail ON tblWetLapLotHeader.LotHeaderID = tblWetLapLotDetail.LotHeaderID";
			List<Map<String, Object>> datas=jdbcTemplate.queryForList(sql_Frp, new Object[]{});
			
			if(datas.size()>0){
			
				int i=1;
				int j=1;
				for(Map<String , Object> data: datas){
					
					
					
					String loadStatus=(String)data.get("BaleStatus");
					double netTon=data.get("NetTON1")==null?0:(Double)data.get("NetTON1");
					double grossTON=data.get("GrossTON2")==null?0:(Double)data.get("GrossTON2");
					
					double netLBS=data.get("NetLBS1")==null?0:(Double)data.get("NetLBS1");
					double grossLBS=data.get("GrossLBS2")==null?0:(Double)data.get("GrossLBS2");
					
					
					if(loadStatus==null || loadStatus=="" || loadStatus.equalsIgnoreCase("FRP") ){
						
					
						totalnetTonforFRP=totalnetTonforFRP+netTon;
						totalgrosstonforFRP=totalgrosstonforFRP+grossTON;
						
						totalnetlbsforFRP=totalnetlbsforFRP+netLBS;
						totalgrosslbsforFRP=totalgrosslbsforFRP+grossLBS;
						
						inventory.setFrpnetwtton(CommonUtil.round(totalnetTonforFRP, 2));
						inventory.setFrpgrosswtton(CommonUtil.round(totalgrosstonforFRP, 2));
						
						inventory.setFrpnetwtlbs(totalnetlbsforFRP);
						inventory.setFrpgrosswtlbs(totalgrosslbsforFRP);
						
						inventory.setTownfrp("FRP");
						inventory.setTotalbalesfrp(i);
						i++;
					}else if(loadStatus.equalsIgnoreCase("Yard")){
						
						totalnetTonforYard=totalnetTonforYard+netTon;
						totalgrosstonforYard=totalgrosstonforYard+grossTON;
						
						totalnetlbsforYard=totalnetlbsforYard+netLBS;
						totalgrosslbsforYard=totalgrosslbsforYard+grossLBS;
						
						inventory.setYardnetwtton(CommonUtil.round(totalnetTonforYard, 2));
						inventory.setYardgrosswtton(CommonUtil.round(totalgrosstonforYard, 2));
						
						inventory.setYardnetwtlbs(totalnetlbsforYard);
						inventory.setYardgrosswtlbs(totalgrosslbsforYard);
						
						inventory.setTownyard("Yard");
						
						inventory.setTotalbalesyard(j);
						j++;
					}
					
					
				}
				 details.add(inventory);	
			}
		}catch(Exception rlt){
			System.out.println("You Have An Problem In Query For Estimated Freight.");
			rlt.printStackTrace();
		}
		return details;
	}

	/* (non-Javadoc)
	 * @see com.st.wetlapinventory.dao.WetlapInventoryDao#getReportMillData()
	 */
	@Override
	public List<WetlapInventory> getReportMillData() {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceT);
		
		double totalnetTonforMill=0;
		double totalgrosstonforMill=0;
		
		double totalnetlbsforMill=0;
		double totalgrosslbsforMill=0;
		
		List<WetlapInventory> details=new ArrayList<WetlapInventory>();
		final WetlapInventory inventory=new WetlapInventory();
		
		try{
			
			String sql_Mill="SELECT tblBaleInventory.GradeCode, IIf([GradeCode]=80,'Brown','White') AS LotColor, tblBaleInventory.TagID, tblWetLapLotDetail.LotHeaderID,[WLBaleWeightLbsGross] AS GrossLbs,[WLBaleWeightLbsNet] AS NetLbs,[WLBaleWeightLbsGross]/2000 AS GrossTON,[WLBaleWeightLbsNet]/2000 AS NetTON "
					+ "FROM tblBaleInventory LEFT JOIN tblWetLapLotDetail ON tblBaleInventory.TagID = tblWetLapLotDetail.WLBaleID "
					+ "WHERE (((tblBaleInventory.GradeCode)=80 Or (tblBaleInventory.GradeCode)=95) AND ((tblBaleInventory.ConsumedDate) Is Null));";
	List<Map<String, Object>> millDatas=jdbcTemplate.queryForList(sql_Mill, new Object[]{});
	
		int i=1;
		if(millDatas.size()>0){
			
			for(Map<String , Object> data: millDatas){
			
				double grossLbs=data.get("GrossLbs")==null?0:(Double)data.get("GrossLbs");
				double netLbs=data.get("NetLbs")==null?0:(Double)data.get("NetLbs");
				
				double grossTON=data.get("GrossTON")==null?0:(Double)data.get("GrossTON");
				double netTON=data.get("NetTON")==null?0:(Double)data.get("NetTON");
				
				totalgrosslbsforMill=totalgrosslbsforMill+grossLbs;
				totalnetlbsforMill=totalnetlbsforMill+netLbs;
				totalgrosstonforMill=totalgrosstonforMill+grossTON;
				totalnetTonforMill=totalnetTonforMill+netTON;
				
				inventory.setGrosslbsmill(totalgrosslbsforMill);
				inventory.setNetlbsmill(totalnetlbsforMill);
				
				inventory.setGrosstonmill(CommonUtil.round(totalgrosstonforMill, 2));
				inventory.setNettonmill(CommonUtil.round(totalnetTonforMill, 2));
				
				inventory.setTotalbalesmill(i);
				i++;
				
			}
			 details.add(inventory);	
		}
		}catch(Exception rlt){
			System.out.println("Roshan Says You Have An Error While Finding The Data OF Mill");
			rlt.printStackTrace();
		}
		return details;
	}

}
