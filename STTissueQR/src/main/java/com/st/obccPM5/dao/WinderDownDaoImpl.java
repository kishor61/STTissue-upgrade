/**
 *May 7, 2021
 *WinderDownDaoImpl.java
 * TODO
 *com.st.obccPM5.dao
 *WinderDownDaoImpl.java
 *Sohan Lal 
 */
package com.st.obccPM5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.common.DatabaseUtil;
import com.st.obccPM5.model.WinderDown;

/**
 * @author Sohanlal
 *
 */
@Repository
public class WinderDownDaoImpl implements WinderDownDao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	private static final Logger logger=LoggerFactory.getLogger(WinderDownDaoImpl.class);
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void saveorUpdate(WinderDown data) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
	 	
	 	paramSource.addValue("position",data.getPosition());
		paramSource.addValue("operatorname",data.getOperatorName());
		paramSource.addValue("date",data.getEdate());
		paramSource.addValue("crew",data.getCrew());
		paramSource.addValue("shift",data.getShift());
		paramSource.addValue("machinedown",data.isMachinedown());
		
		
		paramSource.addValue("power",data.isPower());
		paramSource.addValue("blade",data.isBlade());
		paramSource.addValue("sizeadjustmentmovement",data.isSizeadjustmentmovement());
		paramSource.addValue("rollkickerworkingproperly",data.isRollkickerworkingproperly());
		paramSource.addValue("anyhydraulicleaks",data.isAnyhydraulicleaks());
		paramSource.addValue("uprightbumperandcushionbumperworkingproperly",data.isUprightbumperandcushionbumperworkingproperly());
		paramSource.addValue("anycontrolpanelissues",data.isAnycontrolpanelissues());
		paramSource.addValue("anynoticeableissueswithconveyor",data.isAnynoticeableissueswithconveyor());
		paramSource.addValue("powerDesc",data.getPowerDesc());
		paramSource.addValue("bladeDesc",data.getBladeDesc());
		paramSource.addValue("sizeadjustmentmovementDesc",data.getSizeadjustmentmovementDesc());
		paramSource.addValue("rollkickerworkingproperlyDesc",data.getRollkickerworkingproperlyDesc());
		paramSource.addValue("anyhydraulicleaksDesc",data.getAnyhydraulicleaksDesc());
		paramSource.addValue("uprightbumperandcushionbumperworkingproperlyDesc",data.getUprightbumperandcushionbumperworkingproperlyDesc());
		paramSource.addValue("anycontrolpanelissuesDesc",data.getAnycontrolpanelissuesDesc());
		paramSource.addValue("anynoticeableissueswithconveyorDesc",data.getAnynoticeableissueswithconveyorDesc());
		
		if (data.getId() == 0) {	
			
			String sql=DatabaseUtil.getSQL("sql/winderDown.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateWinderDown.sql");
			jdbcTemplate.update(sql, paramSource);
		}

	}

	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.R1OperatorPM5Dao#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<WinderDown> getOperatorDataList(String position, String sdate, String edate,String shift) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql="";
		if(shift.equalsIgnoreCase("both"))
			sql = "select * from [WinderDown] where position=? AND date BETWEEN ? AND ? order by date ";
		else
			sql = "select * from [WinderDown] where position=? AND shift=? AND date BETWEEN ? AND ? ";
		
		List<WinderDown> r1OperatorPM5datalist=null;
		try {
			r1OperatorPM5datalist=jdbcTemplate.query(sql, new Object[]{position,shift,sdate,edate},new RowMapper<WinderDown>()
				{
						
					
					@Override
					public WinderDown mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							WinderDown data=new WinderDown();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							
							data.setPower(rs.getBoolean("power"));
							data.setBlade(rs.getBoolean("blade"));
							data.setSizeadjustmentmovement(rs.getBoolean("sizeadjustmentmovement"));
							data.setRollkickerworkingproperly(rs.getBoolean("rollkickerworkingproperly"));
							data.setAnyhydraulicleaks(rs.getBoolean("anyhydraulicleaks"));
							data.setUprightbumperandcushionbumperworkingproperly(rs.getBoolean("uprightbumperandcushionbumperworkingproperly"));
							data.setAnycontrolpanelissues(rs.getBoolean("anycontrolpanelissues"));
							data.setAnynoticeableissueswithconveyor(rs.getBoolean("anynoticeableissueswithconveyor"));
							data.setPowerDesc(rs.getString("powerDesc"));
							data.setBladeDesc(rs.getString("bladeDesc"));
							data.setSizeadjustmentmovementDesc(rs.getString("sizeadjustmentmovementDesc"));
							data.setRollkickerworkingproperlyDesc(rs.getString("rollkickerworkingproperlyDesc"));
							data.setAnyhydraulicleaksDesc(rs.getString("anyhydraulicleaksDesc"));
							data.setUprightbumperandcushionbumperworkingproperlyDesc(rs.getString("uprightbumperandcushionbumperworkingproperlyDesc"));
							data.setAnycontrolpanelissuesDesc(rs.getString("anycontrolpanelissuesDesc"));
							data.setAnynoticeableissueswithconveyorDesc(rs.getString("anynoticeableissueswithconveyorDesc"));
							 
						} catch (Exception e) {
							logger.info("WinderDown List Data Exception  "+e);
						}
						return data;
					}
				});
		} catch (Exception e) {
			logger.info("WinderDown List Data Exception  "+e);
		}		
		return r1OperatorPM5datalist;
	}

	@Override
	public List<WinderDown> getOperatorDataListForBothShift(String position, String sdate, String edate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [WinderDown] where position=? AND date BETWEEN ? AND ? order by date ";
		
		List<WinderDown> r1OperatorPM5datalist=null;
		try {
			r1OperatorPM5datalist=jdbcTemplate.query(sql, new Object[]{position,sdate,edate},new RowMapper<WinderDown>()
				{
						
					
					@Override
					public WinderDown mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							WinderDown data=new WinderDown();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							
							data.setPower(rs.getBoolean("power"));
							data.setBlade(rs.getBoolean("blade"));
							data.setSizeadjustmentmovement(rs.getBoolean("sizeadjustmentmovement"));
							data.setRollkickerworkingproperly(rs.getBoolean("rollkickerworkingproperly"));
							data.setAnyhydraulicleaks(rs.getBoolean("anyhydraulicleaks"));
							data.setUprightbumperandcushionbumperworkingproperly(rs.getBoolean("uprightbumperandcushionbumperworkingproperly"));
							data.setAnycontrolpanelissues(rs.getBoolean("anycontrolpanelissues"));
							data.setAnynoticeableissueswithconveyor(rs.getBoolean("anynoticeableissueswithconveyor"));
							data.setPowerDesc(rs.getString("powerDesc"));
							data.setBladeDesc(rs.getString("bladeDesc"));
							data.setSizeadjustmentmovementDesc(rs.getString("sizeadjustmentmovementDesc"));
							data.setRollkickerworkingproperlyDesc(rs.getString("rollkickerworkingproperlyDesc"));
							data.setAnyhydraulicleaksDesc(rs.getString("anyhydraulicleaksDesc"));
							data.setUprightbumperandcushionbumperworkingproperlyDesc(rs.getString("uprightbumperandcushionbumperworkingproperlyDesc"));
							data.setAnycontrolpanelissuesDesc(rs.getString("anycontrolpanelissuesDesc"));
							data.setAnynoticeableissueswithconveyorDesc(rs.getString("anynoticeableissueswithconveyorDesc"));
							 
						} catch (Exception e) {
							logger.info("WinderDown List Data Exception  "+e);
						}
						return data;
					}
				});
		} catch (Exception e) {
			logger.info("WinderDown List Data Exception  "+e);
		}		
		return r1OperatorPM5datalist;
	}

	
	@Override
	public WinderDown getOperatorData(String position, String shift,	String date, String crew) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [WinderDown] where [position]=? AND [date]=? AND [shift] = ? ";

		WinderDown r1OperatorPM5data=null;
		try {
				r1OperatorPM5data=jdbcTemplate.queryForObject(sql, new Object[]{position, date, shift },new RowMapper<WinderDown>()
				{					
					@Override
					public WinderDown mapRow(ResultSet rs ,int arg1)
							throws SQLException {
						
							WinderDown data=new WinderDown();
						try {
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setPower(rs.getBoolean("power"));
							data.setBlade(rs.getBoolean("blade"));
							data.setSizeadjustmentmovement(rs.getBoolean("sizeadjustmentmovement"));
							data.setRollkickerworkingproperly(rs.getBoolean("rollkickerworkingproperly"));
							data.setAnyhydraulicleaks(rs.getBoolean("anyhydraulicleaks"));
							data.setUprightbumperandcushionbumperworkingproperly(rs.getBoolean("uprightbumperandcushionbumperworkingproperly"));
							data.setAnycontrolpanelissues(rs.getBoolean("anycontrolpanelissues"));
							data.setAnynoticeableissueswithconveyor(rs.getBoolean("anynoticeableissueswithconveyor"));
							data.setPowerDesc(rs.getString("powerDesc"));
							data.setBladeDesc(rs.getString("bladeDesc"));
							data.setSizeadjustmentmovementDesc(rs.getString("sizeadjustmentmovementDesc"));
							data.setRollkickerworkingproperlyDesc(rs.getString("rollkickerworkingproperlyDesc"));
							data.setAnyhydraulicleaksDesc(rs.getString("anyhydraulicleaksDesc"));
							data.setUprightbumperandcushionbumperworkingproperlyDesc(rs.getString("uprightbumperandcushionbumperworkingproperlyDesc"));
							data.setAnycontrolpanelissuesDesc(rs.getString("anycontrolpanelissuesDesc"));
							data.setAnynoticeableissueswithconveyorDesc(rs.getString("anynoticeableissueswithconveyorDesc"));
							
						} catch (Exception e) {
							
						}
						return data;
					}
				
					
				});
			
		} catch (Exception e) {
			logger.info("WinderDown Data Exception  "+e);
		}
		
		return r1OperatorPM5data;
	}
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.LeadOperatorPM5Dao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getDataCountDatePercentage(String position, String sdate,String edate,String shift) throws ParseException {
		
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		
		List<WinderDown> daydata=null, nightdata=null;
		if(shift.equals("both"))
		{
			 daydata=getOperatorDataList(position,sdate,edate,"day");
			 nightdata=getOperatorDataList(position,sdate,edate,"night");
		}else if(shift.equals("day"))
		{
			daydata=getOperatorDataList(position,sdate,edate,"day");
		}
		else
		{
			nightdata=getOperatorDataList(position,sdate,edate,"night");
		}
			
		
		int count=0,no=0;long set=0,daypercent=0,nightpercent=0,percentage=0;
		int days = CommonUtil.getDaysDiffernce(format.parse(sdate), format.parse(edate))+1;
		List<Integer> al=new ArrayList<Integer>();
		List<Integer> al2=new ArrayList<Integer>();
	if(daydata!=null||nightdata!=null)	
	{
		if(shift.equals("day")||shift.equals("both"))
		{
			for(WinderDown data:daydata) { 
				if(data.isMachinedown()==false){
					if(data.isPower()==true){count++;}
					if(data.isBlade()==true){count++;}
					if(data.isSizeadjustmentmovement()==true){count++;}
					if(data.isRollkickerworkingproperly()==true){count++;}
					if(data.isAnyhydraulicleaks()==true){count++;}
					if(data.isUprightbumperandcushionbumperworkingproperly()==true){count++;}
					if(data.isAnycontrolpanelissues()==true){count++;}
					if(data.isAnynoticeableissueswithconveyor()==true){count++;}
			 }else count=6;
			  al.add(count); count=0; }
			  for(int n:al) {
				  if(n>=5) { 
					  set=set+100; 
					  } 
				  } 
			  daypercent=set/days; no++; }
			  if(shift.equals("night")||shift.equals("both")) { 
				  set=0; 
				  for(WinderDown data:nightdata) { 
					  if(data.isMachinedown()==false){
						  if(data.isPower()==true){count++;}
						  if(data.isBlade()==true){count++;}
						  if(data.isSizeadjustmentmovement()==true){count++;}
						  if(data.isRollkickerworkingproperly()==true){count++;}
						  if(data.isAnyhydraulicleaks()==true){count++;}
						  if(data.isUprightbumperandcushionbumperworkingproperly()==true){count++;}
						  if(data.isAnycontrolpanelissues()==true){count++;}
						  if(data.isAnynoticeableissueswithconveyor()==true){count++;}
					  }else count=6;
			 al2.add(count); count=0; }
			 
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
