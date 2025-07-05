/**
 *Oct 22, 2019
 *R2OperatorPM5DaoImp.java
 * TODO
 *com.st.obccPM5.dao
 *R2OperatorPM5DaoImp.java
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.common.DatabaseUtil;
import com.st.obccPM5.model.R2OperatorPM5;

/**
 * @author sohan
 *
 */
@Repository
public class R2OperatorPM5DaoImp implements R2OperatorPM5Dao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");
	
	/* (non-Javadoc)
	 * @see com.st.oBcc1pm5.dao.R2OperatorPM5Dao#saveorUpdate(com.st.oBcc1pm5.model.R2OperatorPM5)
	 */
		@Override
		public void saveorUpdate(R2OperatorPM5 data) {
			
			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
		 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
		 	
		 	paramSource.addValue("position",data.getPosition());
			paramSource.addValue("operatorName",data.getOperatorName());
			paramSource.addValue("edate",data.getEdate());
			paramSource.addValue("crew",data.getCrew());
			paramSource.addValue("shift",data.getShift());
			paramSource.addValue("machinedown",data.isMachinedown());			
			
			paramSource.addValue("windedeckstopscol1",data.isWindedeckstopscol1());
			paramSource.addValue("conveyorcol1",data.isConveyorcol1());
			paramSource.addValue("conveyorcol2",data.isConveyorcol2());
			paramSource.addValue("conveyorcol3",data.isConveyorcol3());
			paramSource.addValue("conveyorcol4",data.isConveyorcol4());
			paramSource.addValue("conveyorcol5",data.isConveyorcol5());
			paramSource.addValue("coresawcol1",data.isCoresawcol1());
			paramSource.addValue("coresawcol2",data.isCoresawcol2());
			paramSource.addValue("coresawcol3",data.isCoresawcol3());
			paramSource.addValue("coresawcol4",data.isCoresawcol4());
			paramSource.addValue("corescol1",data.isCorescol1());
			paramSource.addValue("reelCrane",data.isReelCrane());
			paramSource.addValue("anymovementissue",data.isAnymovementissue());;
			paramSource.addValue("pendantintactandworkingproperly",data.isPendantintactandworkingproperly());
			paramSource.addValue("reelCraneDesc",data.getReelCraneDesc());
			paramSource.addValue("anymovementissueDesc",data.getAnymovementissueDesc());
			paramSource.addValue("pendantintactandworkingproperlyDesc",data.getPendantintactandworkingproperlyDesc());
			
			
			paramSource.addValue("windedeckstopscol1Desc",data.getWindedeckstopscol1Desc());
			paramSource.addValue("conveyorcol1Desc",data.getConveyorcol1Desc());
			paramSource.addValue("conveyorcol2Desc",data.getConveyorcol2Desc());
			paramSource.addValue("conveyorcol3Desc",data.getConveyorcol3Desc());
			paramSource.addValue("conveyorcol4Desc",data.getConveyorcol4Desc());
			paramSource.addValue("conveyorcol5Desc",data.getConveyorcol5Desc());
			paramSource.addValue("coresawcol1Desc",data.getCoresawcol1Desc());
			paramSource.addValue("coresawcol2Desc",data.getCoresawcol2Desc());
			paramSource.addValue("coresawcol3Desc",data.getCoresawcol3Desc());
			paramSource.addValue("coresawcol4Desc",data.getCoresawcol4Desc());
			paramSource.addValue("corescol1Desc",data.getCorescol1Desc());
			
			
			if (data.getId() == 0) {	
				
				String sql=DatabaseUtil.getSQL("sql/insertR2Operator_pm5.sql");
				jdbcTemplate.update(sql, paramSource);
			}	
			else
			{
				paramSource.addValue("id",data.getId());
				String sql=DatabaseUtil.getSQL("sql/updateR2Operatorpm5.sql");
				jdbcTemplate.update(sql, paramSource);
			}

	}

		
		@Override
		public List<R2OperatorPM5> getOperatorDataList(String position ,String shift,String sdate, String edate ) 
		{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
			
			String sql = "select * from [R2Operator_PM5] where position=? AND shift=? AND date BETWEEN ? AND ? ";
			 
			List<R2OperatorPM5> r2operatordatalist=null;
			try {
				 r2operatordatalist=jdbcTemplate.query(sql, new Object[] {position,shift, sdate,edate }, new RowMapper<R2OperatorPM5>() {

						@Override
						public R2OperatorPM5 mapRow(ResultSet rs, int arg1)
								throws SQLException {
							R2OperatorPM5 data = new R2OperatorPM5();
							try {
								
								String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
								
								data.setId(rs.getInt("id"));
								data.setPosition(rs.getString("position"));
								data.setOperatorName(rs.getString("operatorname"));
								data.setEdate(newDate);
								data.setCrew(rs.getString("crew"));
								data.setShift(rs.getString("shift"));
								data.setMachinedown(rs.getBoolean("machinedown"));
								data.setWindedeckstopscol1(rs.getBoolean("windedeckstopscol1"));
								data.setConveyorcol1(rs.getBoolean("conveyorcol1"));
								data.setConveyorcol2(rs.getBoolean("conveyorcol2"));
								data.setConveyorcol3(rs.getBoolean("conveyorcol3"));
								data.setConveyorcol4(rs.getBoolean("conveyorcol4"));
								data.setConveyorcol5(rs.getBoolean("conveyorcol5"));
								data.setCoresawcol1(rs.getBoolean("coresawcol1"));
								data.setCoresawcol2(rs.getBoolean("coresawcol2"));
								data.setCoresawcol3(rs.getBoolean("coresawcol3"));
								data.setCoresawcol4(rs.getBoolean("coresawcol4"));
								data.setCorescol1(rs.getBoolean("corescol1"));
								data.setWindedeckstopscol1Desc(rs.getString("windedeckstopscol1Desc"));
								data.setConveyorcol1Desc(rs.getString("conveyorcol1Desc"));
								data.setConveyorcol2Desc(rs.getString("conveyorcol2Desc"));
								data.setConveyorcol3Desc(rs.getString("conveyorcol3Desc"));
								data.setConveyorcol4Desc(rs.getString("conveyorcol4Desc"));
								data.setConveyorcol5Desc(rs.getString("conveyorcol5Desc"));
								data.setCoresawcol1Desc(rs.getString("coresawcol1Desc"));
								data.setCoresawcol2Desc(rs.getString("coresawcol2Desc"));
								data.setCoresawcol3Desc(rs.getString("coresawcol3Desc"));
								data.setCoresawcol4Desc(rs.getString("coresawcol4Desc"));
								data.setCorescol1Desc(rs.getString("corescol1Desc"));
								data.setReelCrane(rs.getBoolean("reelCrane"));
								data.setAnymovementissue(rs.getBoolean("anymovementissue"));;
								data.setPendantintactandworkingproperly(rs.getBoolean("pendantintactandworkingproperly"));
								data.setReelCraneDesc(rs.getString("reelCraneDesc"));
								data.setAnymovementissueDesc(rs.getString("anymovementissueDesc"));;
								data.setPendantintactandworkingproperlyDesc(rs.getString("pendantintactandworkingproperlyDesc"));
								
								
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							return data;
						}
						
				 	}
					);	
			} catch (Exception e) {
				System.out.println(e.getMessage());				
			}
			
			return r2operatordatalist;
		}

		/* (non-Javadoc)
		 * @see com.st.oBcc1pm5.dao.R2OperatorPM5Dao#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String)
		 */
		@Override
		public List<R2OperatorPM5> getOperatorDataList(String position,	String sdate, String edate) {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
			
			String sql = "select * from [R2Operator_PM5] where position=?  AND date BETWEEN ? AND ? ";
			 
			List<R2OperatorPM5> r2operatordatalist=null;
			try {
				 r2operatordatalist=jdbcTemplate.query(sql, new Object[] {position, sdate,edate }, new RowMapper<R2OperatorPM5>() {

						@Override
						public R2OperatorPM5 mapRow(ResultSet rs, int arg1)
								throws SQLException {
							R2OperatorPM5 data = new R2OperatorPM5();
							try {
								
								String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
								
								data.setId(rs.getInt("id"));
								data.setPosition(rs.getString("position"));
								data.setOperatorName(rs.getString("operatorname"));
								data.setEdate(newDate);
								data.setCrew(rs.getString("crew"));
								data.setShift(rs.getString("shift"));
								data.setMachinedown(rs.getBoolean("machinedown"));
								data.setWindedeckstopscol1(rs.getBoolean("windedeckstopscol1"));
								data.setConveyorcol1(rs.getBoolean("conveyorcol1"));
								data.setConveyorcol2(rs.getBoolean("conveyorcol2"));
								data.setConveyorcol3(rs.getBoolean("conveyorcol3"));
								data.setConveyorcol4(rs.getBoolean("conveyorcol4"));
								data.setConveyorcol5(rs.getBoolean("conveyorcol5"));
								data.setCoresawcol1(rs.getBoolean("coresawcol1"));
								data.setCoresawcol2(rs.getBoolean("coresawcol2"));
								data.setCoresawcol3(rs.getBoolean("coresawcol3"));
								data.setCoresawcol4(rs.getBoolean("coresawcol4"));
								data.setCorescol1(rs.getBoolean("corescol1"));
								data.setWindedeckstopscol1Desc(rs.getString("windedeckstopscol1Desc"));
								data.setConveyorcol1Desc(rs.getString("conveyorcol1Desc"));
								data.setConveyorcol2Desc(rs.getString("conveyorcol2Desc"));
								data.setConveyorcol3Desc(rs.getString("conveyorcol3Desc"));
								data.setConveyorcol4Desc(rs.getString("conveyorcol4Desc"));
								data.setConveyorcol5Desc(rs.getString("conveyorcol5Desc"));
								data.setCoresawcol1Desc(rs.getString("coresawcol1Desc"));
								data.setCoresawcol2Desc(rs.getString("coresawcol2Desc"));
								data.setCoresawcol3Desc(rs.getString("coresawcol3Desc"));
								data.setCoresawcol4Desc(rs.getString("coresawcol4Desc"));
								data.setCorescol1Desc(rs.getString("corescol1Desc"));
								data.setReelCrane(rs.getBoolean("reelCrane"));
								data.setAnymovementissue(rs.getBoolean("anymovementissue"));;
								data.setPendantintactandworkingproperly(rs.getBoolean("pendantintactandworkingproperly"));
								data.setReelCraneDesc(rs.getString("reelCraneDesc"));
								data.setAnymovementissueDesc(rs.getString("anymovementissueDesc"));;
								data.setPendantintactandworkingproperlyDesc(rs.getString("pendantintactandworkingproperlyDesc"));
								
								
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							return data;
						}
						
				 	}
					);	
			} catch (Exception e) {
				System.out.println(e.getMessage());				
			}
			
			return r2operatordatalist;
		}
		
		
		@Override
		public R2OperatorPM5 getOperatorData(String position, String shift,
				String date, String crew) throws Exception {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
			String sql = "select * from [R2Operator_PM5] where [position]=? AND [date]=? AND [shift] = ?";

			R2OperatorPM5 r2operator = null;

			try {
				r2operator = jdbcTemplate.queryForObject(sql, new Object[] {
						position, date, shift}, new RowMapper<R2OperatorPM5>() {

					@Override
					public R2OperatorPM5 mapRow(ResultSet rs, int arg1)
							throws SQLException {
						R2OperatorPM5 data = new R2OperatorPM5();
						try {
							
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operatorname"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setWindedeckstopscol1(rs.getBoolean("windedeckstopscol1"));
							data.setConveyorcol1(rs.getBoolean("conveyorcol1"));
							data.setConveyorcol2(rs.getBoolean("conveyorcol2"));
							data.setConveyorcol3(rs.getBoolean("conveyorcol3"));
							data.setConveyorcol4(rs.getBoolean("conveyorcol4"));
							data.setConveyorcol5(rs.getBoolean("conveyorcol5"));
							data.setCoresawcol1(rs.getBoolean("coresawcol1"));
							data.setCoresawcol2(rs.getBoolean("coresawcol2"));
							data.setCoresawcol3(rs.getBoolean("coresawcol3"));
							data.setCoresawcol4(rs.getBoolean("coresawcol4"));
							data.setCorescol1(rs.getBoolean("corescol1"));							
							data.setWindedeckstopscol1Desc(rs.getString("windedeckstopscol1Desc"));
							data.setConveyorcol1Desc(rs.getString("conveyorcol1Desc"));
							data.setConveyorcol2Desc(rs.getString("conveyorcol2Desc"));
							data.setConveyorcol3Desc(rs.getString("conveyorcol3Desc"));
							data.setConveyorcol4Desc(rs.getString("conveyorcol4Desc"));
							data.setConveyorcol5Desc(rs.getString("conveyorcol5Desc"));
							data.setCoresawcol1Desc(rs.getString("coresawcol1Desc"));
							data.setCoresawcol2Desc(rs.getString("coresawcol2Desc"));
							data.setCoresawcol3Desc(rs.getString("coresawcol3Desc"));
							data.setCoresawcol4Desc(rs.getString("coresawcol4Desc"));
							data.setCorescol1Desc(rs.getString("corescol1Desc"));
							data.setReelCrane(rs.getBoolean("reelCrane"));
							data.setAnymovementissue(rs.getBoolean("anymovementissue"));;
							data.setPendantintactandworkingproperly(rs.getBoolean("pendantintactandworkingproperly"));
							data.setReelCraneDesc(rs.getString("reelCraneDesc"));
							data.setAnymovementissueDesc(rs.getString("anymovementissueDesc"));;
							data.setPendantintactandworkingproperlyDesc(rs.getString("pendantintactandworkingproperlyDesc"));
							
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						return data;
					}

				});
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return r2operator;

		}
		
		
		
		/* (non-Javadoc)
		 * @see com.st.oBcc1pm5.dao.R2OperatorPM5Dao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String)
		 */
		@Override
		public long getDataCountDatePercentage(String position, String sdate,
				String edate,String shift) throws ParseException {
			List<R2OperatorPM5> daydata=null,nightdata=null;
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
			int days = CommonUtil.getDaysDiffernce(dateFormat.parse(sdate), dateFormat.parse(edate))+1;
			List<Integer> al=new ArrayList<Integer>();
			if(daydata!=null||nightdata!=null)	
			{
			if(shift.equals("day")||shift.equals("both")) {
				for(R2OperatorPM5 data:daydata )
				{
					if(data.isMachinedown()!=true) {
					if(data.isWindedeckstopscol1() == true||data.isWindedeckstopscol1()== false)
						count++;		
					if(data.isConveyorcol1() == true||data.isConveyorcol1() == false)
						count++;		
					if(data.isConveyorcol2() == true||data.isConveyorcol2() == false)
						count++;
					if(data.isConveyorcol3() == true||data.isConveyorcol3() == false)
						count++;			
					if(data.isConveyorcol4() == true||data.isConveyorcol4() == false)
			
						count++;			
					if(data.isConveyorcol5() == true||data.isConveyorcol5()== false)
						count++;			
					if(data.isCoresawcol1() == true||data.isCoresawcol1()== false)
						count++;			
					if(data.isCoresawcol2() == true||data.isCoresawcol2()== false)
						count++;			
					if(data.isCoresawcol3() == true||data.isCoresawcol3() == false)
						count++;		
					if(data.isCoresawcol4() == true||data.isCoresawcol4() == false)
						count++;			
					if(data.isCorescol1() == true||data.isCorescol1() == false)
						count++;
					}else count=6;
					al.add(count);
					count=0;
				}
			
				for(int n:al)
				{
					if(n>=5)
					{
						set=set+100;
					}
				}
				no++;
		}		
				daypercent=set/days;
				al.clear();
				if(shift.equals("night")||shift.equals("both")) {
				for(R2OperatorPM5 data:nightdata)
				{
					if(data.isMachinedown()!=true) {
					if(data.isWindedeckstopscol1() == true||data.isWindedeckstopscol1()== false)
						count++;		
					if(data.isConveyorcol1() == true||data.isConveyorcol1() == false)
						count++;		
					if(data.isConveyorcol2() == true||data.isConveyorcol2() == false)
						count++;
					if(data.isConveyorcol3() == true||data.isConveyorcol3() == false)
						count++;			
					if(data.isConveyorcol4() == true||data.isConveyorcol4() == false)
						count++;			
					if(data.isConveyorcol5() == true||data.isConveyorcol5()== false)
						count++;			
					if(data.isCoresawcol1() == true||data.isCoresawcol1()== false)
						count++;			
					if(data.isCoresawcol2() == true||data.isCoresawcol2()== false)
						count++;			
					if(data.isCoresawcol3() == true||data.isCoresawcol3() == false)
						count++;		
					if(data.isCoresawcol4() == true||data.isCoresawcol4() == false)
						count++;			
					if(data.isCorescol1() == true||data.isCorescol1() == false)
						count++;
					}else count=6;
					al.add(count);
					count=0;
				}
			
				set=0;
				for(int n:al)
				{
					if(n>=5)
					{
						set=set+100;
					}
				}
				nightpercent=set/days;
				no++;
				}
			
				al.clear();
		}	if(no==0)no=1;	
			percentage=(daypercent+nightpercent)/no;
			return percentage;
		}
}
