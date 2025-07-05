/**
 *Oct 22, 2019
 *R1OperatorDaoImpl.java
 * TODO
 *com.st.obccPM5.dao
 *R1OperatorDaoImpl.java
 *sohan
 */
package com.st.obccPM5.dao;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.common.DatabaseUtil;
import com.st.obccPM5.model.R2WaterJetsDown;

/**
 * @author sohan lal
 *
 */
@Repository
public class R2WaterJetsDownDaoImpl implements R2WaterJetsDownDao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");

	
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.R1OperatorPM5Dao#saveorUpdate(com.st.oBcc1pm5.model.R1OperatorPM5)
	 */
	@Override
	public void saveorUpdate(R2WaterJetsDown data) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
	 	
	 	paramSource.addValue("position",data.getPosition());
		paramSource.addValue("operatorname",data.getOperatorName());
		paramSource.addValue("date",data.getEdate());
		paramSource.addValue("crew",data.getCrew());
		paramSource.addValue("shift",data.getShift());
		paramSource.addValue("machinedown",data.isMachinedown());
		
		paramSource.addValue("sketchWrapdozier",data.isSketchWrapdozier());
		paramSource.addValue("anycontrolpanelissues",data.isAnycontrolpanelissues());
		paramSource.addValue("turntableWorkingproperly",data.isTurntableWorkingproperly());
		paramSource.addValue("automaticWeightinputOk",data.isAutomaticWeightinputOk());
		paramSource.addValue("safetygatesintacandbeingused",data.isSafetygatesintacandbeingused());
		paramSource.addValue("rollStopperinplaceandbeingused",data.isRollStopperinplaceandbeingused());
		paramSource.addValue("laserandMirrorCleaned",data.isLaserandMirrorCleaned());
		paramSource.addValue("allHandRailsIntact",data.isAllHandRailsIntact());
		paramSource.addValue("allEnjectionSystemWorkingProperly",data.isAllEnjectionSystemWorkingProperly());			
		paramSource.addValue("wrapper150ml_360",data.isWrapper150ml_360());
		paramSource.addValue("rollRampOk",data.isRollRampOk());
		paramSource.addValue("dryandCraneWorkingProperly",data.isDryandCraneWorkingProperly());
		paramSource.addValue("allHooksWorking",data.isAllHooksWorking());
		
		paramSource.addValue("sketchWrapdozierDesc",data.getSketchWrapdozierDesc());
		paramSource.addValue("anycontrolpanelissuesDesc",data.getAnycontrolpanelissuesDesc());
		paramSource.addValue("turntableWorkingproperlyDesc",data.getTurntableWorkingproperlyDesc());
		paramSource.addValue("automaticWeightinputOkDesc",data.getAutomaticWeightinputOkDesc());
		paramSource.addValue("safetygatesintacandbeingusedDesc",data.getSafetygatesintacandbeingusedDesc());
		paramSource.addValue("rollStopperinplaceandbeingusedDesc",data.getRollStopperinplaceandbeingusedDesc());
		paramSource.addValue("laserandMirrorCleanedDesc",data.getLaserandMirrorCleanedDesc());
		paramSource.addValue("allHandRailsIntactDesc",data.getAllHandRailsIntactDesc());
		paramSource.addValue("allEnjectionSystemWorkingProperlyDesc",data.getAllEnjectionSystemWorkingProperlyDesc());			
		paramSource.addValue("wrapper150ml_360Desc",data.getWrapper150ml_360Desc());
		paramSource.addValue("rollRampOkDesc",data.getRollRampOkDesc());
		paramSource.addValue("dryandCraneWorkingProperlyDesc",data.getDryandCraneWorkingProperlyDesc());
		paramSource.addValue("allHooksWorkingDesc",data.getAllHooksWorkingDesc());
		
		
		
		if (data.getId() == 0) {	
			
			String sql=DatabaseUtil.getSQL("sql/R2WaterJetsDown.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateR2WaterJetsDown.sql");
			jdbcTemplate.update(sql, paramSource);
		}

	}

	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.R1OperatorPM5Dao#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<R2WaterJetsDown> getOperatorDataList(String position,	String shift, String sdate, String edate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R2WaterJetsDown] where position=? AND shift=? AND date BETWEEN ? AND ? ";
		
		List<R2WaterJetsDown> r1OperatorPM5datalist=null;
		try {
				r1OperatorPM5datalist=jdbcTemplate.query(sql, new Object[]{position,shift,sdate,edate},new RowMapper<R2WaterJetsDown>()
				{
						
					
					@Override
					public R2WaterJetsDown mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							R2WaterJetsDown data=new R2WaterJetsDown();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							
							data.setSketchWrapdozier(rs.getBoolean("sketchWrapdozier"));
							data.setAnycontrolpanelissues(rs.getBoolean("anycontrolpanelissues"));
							data.setTurntableWorkingproperly(rs.getBoolean("turntableWorkingproperly"));
							data.setAutomaticWeightinputOk(rs.getBoolean("automaticWeightinputOk"));
							data.setSafetygatesintacandbeingused(rs.getBoolean("safetygatesintacandbeingused"));
							data.setRollStopperinplaceandbeingused(rs.getBoolean("rollStopperinplaceandbeingused"));
							data.setLaserandMirrorCleaned(rs.getBoolean("laserandMirrorCleaned"));
							data.setAllHandRailsIntact(rs.getBoolean("allHandRailsIntact"));
							data.setAllEnjectionSystemWorkingProperly(rs.getBoolean("allEnjectionSystemWorkingProperly"));			
							data.setWrapper150ml_360(rs.getBoolean("wrapper150ml_360"));
							data.setRollRampOk(rs.getBoolean("rollRampOk"));
							data.setDryandCraneWorkingProperly(rs.getBoolean("dryandCraneWorkingProperly"));
							data.setAllHooksWorking(rs.getBoolean("allHooksWorking"));
							
							data.setSketchWrapdozierDesc(rs.getString("sketchWrapdozierDesc"));
							data.setAnycontrolpanelissuesDesc(rs.getString("anycontrolpanelissuesDesc"));
							data.setTurntableWorkingproperlyDesc(rs.getString("turntableWorkingproperlyDesc"));
							data.setAutomaticWeightinputOkDesc(rs.getString("automaticWeightinputOkDesc"));
							data.setSafetygatesintacandbeingusedDesc(rs.getString("safetygatesintacandbeingusedDesc"));
							data.setRollStopperinplaceandbeingusedDesc(rs.getString("rollStopperinplaceandbeingusedDesc"));
							data.setLaserandMirrorCleanedDesc(rs.getString("laserandMirrorCleanedDesc"));
							data.setAllHandRailsIntactDesc(rs.getString("allHandRailsIntactDesc"));
							data.setAllEnjectionSystemWorkingProperlyDesc(rs.getString("allEnjectionSystemWorkingProperlyDesc"));			
							data.setWrapper150ml_360Desc(rs.getString("wrapper150ml_360Desc"));
							data.setRollRampOkDesc(rs.getString("rollRampOkDesc"));
							data.setDryandCraneWorkingProperlyDesc(rs.getString("dryandCraneWorkingProperlyDesc"));
							data.setAllHooksWorkingDesc(rs.getString("allHooksWorkingDesc"));
							
						} catch (Exception e) {
							
						}
						return data;
					}
				});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return r1OperatorPM5datalist;
	}

	@Override
	public List<R2WaterJetsDown> getOperatorDataListForBothShift(String position, String sdate, String edate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R2WaterJetsDown] where position=? AND date BETWEEN ? AND ?  order by date";
		
		List<R2WaterJetsDown> r1OperatorPM5datalist=null;
		try {
				r1OperatorPM5datalist=jdbcTemplate.query(sql, new Object[]{position,sdate,edate},new RowMapper<R2WaterJetsDown>()
				{
						
					
					@Override
					public R2WaterJetsDown mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							R2WaterJetsDown data=new R2WaterJetsDown();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							
							data.setSketchWrapdozier(rs.getBoolean("sketchWrapdozier"));
							data.setAnycontrolpanelissues(rs.getBoolean("anycontrolpanelissues"));
							data.setTurntableWorkingproperly(rs.getBoolean("turntableWorkingproperly"));
							data.setAutomaticWeightinputOk(rs.getBoolean("automaticWeightinputOk"));
							data.setSafetygatesintacandbeingused(rs.getBoolean("safetygatesintacandbeingused"));
							data.setRollStopperinplaceandbeingused(rs.getBoolean("rollStopperinplaceandbeingused"));
							data.setLaserandMirrorCleaned(rs.getBoolean("laserandMirrorCleaned"));
							data.setAllHandRailsIntact(rs.getBoolean("allHandRailsIntact"));
							data.setAllEnjectionSystemWorkingProperly(rs.getBoolean("allEnjectionSystemWorkingProperly"));			
							data.setWrapper150ml_360(rs.getBoolean("wrapper150ml_360"));
							data.setRollRampOk(rs.getBoolean("rollRampOk"));
							data.setDryandCraneWorkingProperly(rs.getBoolean("dryandCraneWorkingProperly"));
							data.setAllHooksWorking(rs.getBoolean("allHooksWorking"));
							
							data.setSketchWrapdozierDesc(rs.getString("sketchWrapdozierDesc"));
							data.setAnycontrolpanelissuesDesc(rs.getString("anycontrolpanelissuesDesc"));
							data.setTurntableWorkingproperlyDesc(rs.getString("turntableWorkingproperlyDesc"));
							data.setAutomaticWeightinputOkDesc(rs.getString("automaticWeightinputOkDesc"));
							data.setSafetygatesintacandbeingusedDesc(rs.getString("safetygatesintacandbeingusedDesc"));
							data.setRollStopperinplaceandbeingusedDesc(rs.getString("rollStopperinplaceandbeingusedDesc"));
							data.setLaserandMirrorCleanedDesc(rs.getString("laserandMirrorCleanedDesc"));
							data.setAllHandRailsIntactDesc(rs.getString("allHandRailsIntactDesc"));
							data.setAllEnjectionSystemWorkingProperlyDesc(rs.getString("allEnjectionSystemWorkingProperlyDesc"));			
							data.setWrapper150ml_360Desc(rs.getString("wrapper150ml_360Desc"));
							data.setRollRampOkDesc(rs.getString("rollRampOkDesc"));
							data.setDryandCraneWorkingProperlyDesc(rs.getString("dryandCraneWorkingProperlyDesc"));
							data.setAllHooksWorkingDesc(rs.getString("allHooksWorkingDesc"));
							
						} catch (Exception e) {
							
						}
						return data;
					}
				});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return r1OperatorPM5datalist;
	}


	
	@Override
	public R2WaterJetsDown getOperatorData(String position, String shift,	String date, String crew) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [R2WaterJetsDown] where [position]=? AND [date]=? AND [shift] = ? ";

		R2WaterJetsDown r1OperatorPM5data=null;
		try {
				r1OperatorPM5data=jdbcTemplate.queryForObject(sql, new Object[]{position, date, shift },new RowMapper<R2WaterJetsDown>()
				{
						
					
					@Override
					public R2WaterJetsDown mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							R2WaterJetsDown data=new R2WaterJetsDown();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setSketchWrapdozier(rs.getBoolean("sketchWrapdozier"));
							data.setAnycontrolpanelissues(rs.getBoolean("anycontrolpanelissues"));
							data.setTurntableWorkingproperly(rs.getBoolean("turntableWorkingproperly"));
							data.setAutomaticWeightinputOk(rs.getBoolean("automaticWeightinputOk"));
							data.setSafetygatesintacandbeingused(rs.getBoolean("safetygatesintacandbeingused"));
							data.setRollStopperinplaceandbeingused(rs.getBoolean("rollStopperinplaceandbeingused"));
							data.setLaserandMirrorCleaned(rs.getBoolean("laserandMirrorCleaned"));
							data.setAllHandRailsIntact(rs.getBoolean("allHandRailsIntact"));
							data.setAllEnjectionSystemWorkingProperly(rs.getBoolean("allEnjectionSystemWorkingProperly"));			
							data.setWrapper150ml_360(rs.getBoolean("wrapper150ml_360"));
							data.setRollRampOk(rs.getBoolean("rollRampOk"));
							data.setDryandCraneWorkingProperly(rs.getBoolean("dryandCraneWorkingProperly"));
							data.setAllHooksWorking(rs.getBoolean("allHooksWorking"));
							
							data.setSketchWrapdozierDesc(rs.getString("sketchWrapdozierDesc"));
							data.setAnycontrolpanelissuesDesc(rs.getString("anycontrolpanelissuesDesc"));
							data.setTurntableWorkingproperlyDesc(rs.getString("turntableWorkingproperlyDesc"));
							data.setAutomaticWeightinputOkDesc(rs.getString("automaticWeightinputOkDesc"));
							data.setSafetygatesintacandbeingusedDesc(rs.getString("safetygatesintacandbeingusedDesc"));
							data.setRollStopperinplaceandbeingusedDesc(rs.getString("rollStopperinplaceandbeingusedDesc"));
							data.setLaserandMirrorCleanedDesc(rs.getString("laserandMirrorCleanedDesc"));
							data.setAllHandRailsIntactDesc(rs.getString("allHandRailsIntactDesc"));
							data.setAllEnjectionSystemWorkingProperlyDesc(rs.getString("allEnjectionSystemWorkingProperlyDesc"));			
							data.setWrapper150ml_360Desc(rs.getString("wrapper150ml_360Desc"));
							data.setRollRampOkDesc(rs.getString("rollRampOkDesc"));
							data.setDryandCraneWorkingProperlyDesc(rs.getString("dryandCraneWorkingProperlyDesc"));
							data.setAllHooksWorkingDesc(rs.getString("allHooksWorkingDesc"));
							
						} catch (Exception e) {
							
						}
						return data;
					}
				
					
				});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return r1OperatorPM5data;
	}
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.LeadOperatorPM5Dao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position, String sdate,String edate,String shift) throws ParseException {
		
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		
		List<R2WaterJetsDown> daydata=null, nightdata=null;
		if(shift.equals("both"))
		{
			 daydata=getOperatorDataList(position,"day",sdate,edate);
			 nightdata=getOperatorDataList(position,"night",sdate,edate);
		}else if(shift.equals("day"))
		{
			daydata=getOperatorDataList(position,"day",sdate,edate);
		}
		else
		{
			nightdata=getOperatorDataList(position,"night",sdate,edate);
		}
			
		
		int count=0,no=0;long set=0,daypercent=0,nightpercent=0,percentage=0;
		int days = CommonUtil.getDaysDiffernce(format.parse(sdate), format.parse(edate))+1;
		List<Integer> al=new ArrayList<Integer>();
		List<Integer> al2=new ArrayList<Integer>();
	if(daydata!=null||nightdata!=null)	
	{
		if(shift.equals("day")||shift.equals("both"))
		{
			
			  for(R2WaterJetsDown data:daydata) { 
				  if(data.isMachinedown()==false){
					  if(data.isSketchWrapdozier()== true){count++;}
					  if(data.isAnycontrolpanelissues()== true){count++;}
					  if(data.isTurntableWorkingproperly()== true){count++;}
					  if(data.isAutomaticWeightinputOk()== true){count++;}
					  if(data.isSafetygatesintacandbeingused()== true){count++;}
					  if(data.isRollStopperinplaceandbeingused()== true){count++;}
					  if(data.isLaserandMirrorCleaned()== true){count++;}
					  if(data.isAllHandRailsIntact()== true){count++;}
					  if(data.isAllEnjectionSystemWorkingProperly()== true){count++;}			
					  if(data.isWrapper150ml_360()== true){count++;}
					  if(data.isRollRampOk()== true){count++;}
					  if(data.isDryandCraneWorkingProperly()== true){count++;}
					  if(data.isAllHooksWorking()== true){count++;}
			  }else count=6;
			  al.add(count); count=0; }
			  for(int n:al) { 
				  if(n>=5) { set=set+100; } 
			} daypercent=set/days; no++; }
			  if(shift.equals("night")||shift.equals("both")) {
				  set=0; 
				 for(R2WaterJetsDown data:nightdata) {					  
				  if(data.isMachinedown()==false){
					  if(data.isSketchWrapdozier()== true){count++;}
					  if(data.isAnycontrolpanelissues()== true){count++;}
					  if(data.isTurntableWorkingproperly()== true){count++;}
					  if(data.isAutomaticWeightinputOk()== true){count++;}
					  if(data.isSafetygatesintacandbeingused()== true){count++;}
					  if(data.isRollStopperinplaceandbeingused()== true){count++;}
					  if(data.isLaserandMirrorCleaned()== true){count++;}
					  if(data.isAllHandRailsIntact()== true){count++;}
					  if(data.isAllEnjectionSystemWorkingProperly()== true){count++;}			
					  if(data.isWrapper150ml_360()== true){count++;}
					  if(data.isRollRampOk()== true){count++;}
					  if(data.isDryandCraneWorkingProperly()== true){count++;}
					  if(data.isAllHooksWorking()== true){count++;}
				  }else count=6;
			 al2.add(count); count=0; 
			 }
		 for(int n:al2)
		{
			if(n>=5)
			{
				set=set+100;
			}
		}
			nightpercent=set/days;
			no++;
		}
	if(no==0)
		no=1;
		percentage=(daypercent+nightpercent)/no;
	}
		return percentage;
	}
}
