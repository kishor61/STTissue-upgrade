/**
 *Jan 12, 2018
 *DespatchDaoImp.java
 * TODO
 *com.st.despatch.dao
 *DespatchDaoImp.java
 *Roshan Lal Tailor
 */
package com.st.despatch.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.despatch.model.Despatch;

/**
 * @author roshan
 *
 */
@Repository
public class DespatchDaoImp implements DespatchDao {

	@Autowired
	private DataSource dataSourceT;
	
	@Autowired
	private DataSource dataSource;
	
		
	/* (non-Javadoc)
	 * @see com.st.despatch.dao.DespatchDao#getDespatchData(java.util.Date)
	 */
	@Override
	public List<Despatch> getDespatchData(Date sDate,String carrierId) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceT);
		
		List<Despatch> details=new ArrayList<Despatch>();
		
		/*String sql="SELECT * FROM tblPurchaseHeader WHERE  PickUpDate>= ? And LoadStatus='Enroute' And CarrierID='BN'  order by PickUpDate ";*/
		
		/*List<Map<String, Object>> maps=jdbcTemplate.queryForList(sql, new Object[]{sDate});*/
		
		String sql="SELECT * FROM tblPurchaseHeader WHERE  LoadStatus='Enroute' And CarrierID=?  order by PickUpDate ";
		List<Map<String, Object>> maps=jdbcTemplate.queryForList(sql, new Object[]{carrierId});
		
		if(maps.size()>0){
			for (Map<String, Object> map : maps) {
				
				final Despatch data=new Despatch();	
			
				Date pickupdate=(Date)map.get("PickUpDate".toUpperCase()); 
				String pickuppoint=(String) (map.get("PickUpPoint")==null?"":(String)map.get("PickUpPoint"));
				String pickupcity=(String) (map.get("PickUpCity")==null?"":(String)map.get("PickUpCity"));
				String pickupstate=(String) (map.get("PickUpState")==null?"":(String)map.get("PickUpState"));
				
				//int releasenumber=(Integer) (map.get("ReleaseNumber")==null?0:(Integer)map.get("ReleaseNumber"));
				BigDecimal d1 = BigDecimal.ZERO;
				d1= (BigDecimal) (map.get("ReleaseNumber")==null?0:(BigDecimal)(map.get("ReleaseNumber")));
				int releasenumber=d1.intValueExact();
				
				String careeririd=(String) (map.get("CarrierID")==null?"":(String)map.get("CarrierID"));
				String unloadcomments=(String) (map.get("UnloadComment")==null?"":(String)map.get("UnloadComment"));
				BigDecimal carrierRate = BigDecimal.ZERO;
				 carrierRate=(BigDecimal) (map.get("CarrierRate")==null?0:(BigDecimal)map.get("CarrierRate"));
				
				data.setPickupdate(pickupdate);
				data.setPickuppoint(pickuppoint);
				data.setPickupcity(pickupcity);
				data.setPickupstate(pickupstate);
				data.setReleasenumber(releasenumber);
				data.setCareeririd(careeririd);
				data.setUnloadcomments(unloadcomments);
				data.setCarrierRate(carrierRate.intValue());
				
				
				try{
					
					String sql1="SELECT * FROM tblPurchaseDetail WHERE  ReleaseNumber=?";
					List<Map<String, Object>> maps1=jdbcTemplate.queryForList(sql1, new Object[]{data.getReleasenumber()});
					
					for (Map<String, Object> map1 : maps1) {
						String grade=(String) (map1.get("Grade")==null?0:(String)map1.get("Grade"));
						data.setGrade(grade);
					}
				}catch(Exception rlt){
					rlt.printStackTrace();
					System.out.println(rlt);
				}
				finally{
					
				}
				
				try{
					
					String sql2="SELECT * FROM tlkpPickUpPoint WHERE  PickUpPoint=? AND PickUpCity=?  And PickUpState=? ";
					List<Map<String, Object>> maps2=jdbcTemplate.queryForList(sql2, new Object[]{data.getPickuppoint(),data.getPickupcity(),data.getPickupstate()});
					
					for (Map<String, Object> map2 : maps2) {
						String cell=String.valueOf((map2.get("PickUpPhone"))==null?0:String.valueOf(map2.get("PickUpPhone")));
						data.setCellnumber(cell);
					}
				}catch(Exception rlt){
					rlt.printStackTrace();
					System.out.println(rlt);
					
				}
				finally{
					
				}

				details.add(data);
			}
			
		}
		return details;
	}

	/* (non-Javadoc)
	 * @see com.st.despatch.dao.DespatchDao#getDespatchData_Temp()
	 */
	@Override
	public List<Despatch> getDespatchData_Temp() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		List<Despatch> details=new ArrayList<Despatch>();
		
		/*String sql="SELECT * FROM tblPurchaseHeader WHERE  PickUpDate>= ? And LoadStatus='Enroute' And CarrierID='BN'  order by PickUpDate ";*/
		
		/*List<Map<String, Object>> maps=jdbcTemplate.queryForList(sql, new Object[]{sDate});*/
		
		String sql="SELECT * FROM tbldispatch_temp  order by PickUpDate ";
		List<Map<String, Object>> maps=jdbcTemplate.queryForList(sql, new Object[]{});
		
		if(maps.size()>0){
			for (Map<String, Object> map : maps) {
				
				final Despatch data=new Despatch();	
			
				Date pickupdate=(Date)map.get("PickUpDate".toUpperCase()); 
				String pickuppoint=(String) (map.get("PickUpPoint")==null?"":(String)map.get("PickUpPoint"));
				String pickupcity=(String) (map.get("PickUpCity")==null?"":(String)map.get("PickUpCity"));
				String pickupstate=(String) (map.get("PickUpState")==null?"":(String)map.get("PickUpState"));
				int releasenumber=(Integer) (map.get("ReleaseNumber")==null?0:(Integer)map.get("ReleaseNumber"));
				String careeririd=(String) (map.get("CarrierID")==null?"":(String)map.get("CarrierID"));
				String unloadcomments=(String) (map.get("UnloadComment")==null?"":(String)map.get("UnloadComment"));
				int carrierRate=(int) (map.get("CarrierRate")==null?"":(int)map.get("CarrierRate"));
				data.setPickupdate(pickupdate);
				data.setPickuppoint(pickuppoint);
				data.setPickupcity(pickupcity);
				data.setPickupstate(pickupstate);
				data.setReleasenumber(releasenumber);
				data.setCareeririd(careeririd);
				data.setUnloadcomments(unloadcomments);
				data.setCarrierRate(carrierRate);
				
				
				details.add(data);
			}
			
		}
		return details;
	}

	/* (non-Javadoc)
	 * @see com.st.despatch.dao.DespatchDao#getCheckDateTempTable(int, java.util.Date)
	 */
	@Override
	public int getCheckDateTempTable(String tblName,int releasenumber, Date pickupdate) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int ProbationData =0;
		try{
			String query = "Select count(*) as count from "+tblName+" where Release=? and PickUpDate=?;"; 
	        Object[] inputs = new Object[] {releasenumber,pickupdate};
	        ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return ProbationData;
	}

	/* (non-Javadoc)
	 * @see com.st.despatch.dao.DespatchDao#getCheckPickUpPointTempTable(int, java.util.Date)
	 */
	@Override
	public int getCheckPickUpPointTempTable(String tblName,int releasenumber, String pickuppoint) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int ProbationData =0;
		try{
			String query = "Select count(*) as count from "+tblName+" where Release=? and PickUpPoint=?;"; 
	        Object[] inputs = new Object[] {releasenumber,pickuppoint};
	        ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return ProbationData;
	}

	/* (non-Javadoc)
	 * @see com.st.despatch.dao.DespatchDao#getCheckPickUpCityTempTable(int, java.lang.String)
	 */
	@Override
	public int getCheckPickUpCityTempTable(String tblName,int releasenumber, String pickupcity) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int ProbationData =0;
		try{
			String query = "Select count(*) as count from "+tblName+" where Release=? and PickUpCity=?;"; 
	        Object[] inputs = new Object[] {releasenumber,pickupcity};
	        ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return ProbationData;
	}

	/* (non-Javadoc)
	 * @see com.st.despatch.dao.DespatchDao#getCheckPickUpStateTempTable(int, java.lang.String)
	 */
	@Override
	public int getCheckPickUpStateTempTable(String tblName,int releasenumber,String pickupstate) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int ProbationData =0;
		try{
			String query = "Select count(*) as count from "+tblName+" where Release=? and PickUpState=?;"; 
	        Object[] inputs = new Object[] {releasenumber,pickupstate};
	        ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return ProbationData;
	}

	/* (non-Javadoc)
	 * @see com.st.despatch.dao.DespatchDao#getCheckPickUpCellNumberTempTable(int, java.lang.String)
	 */
	@Override
	public int getCheckPickUpCellNumberTempTable(String tblName,int releasenumber,String cellnumber) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int ProbationData =0;
		try{
			String query = "Select count(*) as count from "+tblName+" where Release=? and PickUpPhone=?;"; 
	        Object[] inputs = new Object[] {releasenumber,cellnumber};
	        ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return ProbationData;
	}

	/* (non-Javadoc)
	 * @see com.st.despatch.dao.DespatchDao#getCheckGradeTempTable(int, java.lang.String)
	 */
	@Override
	public int getCheckGradeTempTable(String tblName,int releasenumber, String grade) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int ProbationData =0;
		try{
			String query = "Select count(*) as count from "+tblName+" where Release=? and Grade=?;"; 
	        Object[] inputs = new Object[] {releasenumber,grade};
	        ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return ProbationData;
	}

	/* (non-Javadoc)
	 * @see com.st.despatch.dao.DespatchDao#getCheckCareerirIdTempTable(int, java.lang.String)
	 */
	@Override
	public int getCheckCareerirIdTempTable(String tblName,int releasenumber, String careeririd) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int ProbationData =0;
		try{
			String query = "Select count(*) as count from "+tblName+" where Release=? and CarrierId=?;"; 
	        Object[] inputs = new Object[] {releasenumber,careeririd};
	        ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return ProbationData;
	}

	/* (non-Javadoc)
	 * @see com.st.despatch.dao.DespatchDao#getCheckUnloadCommantsTempTable(int, java.lang.String)
	 */
	@Override
	public int getCheckUnloadCommantsTempTable(String tblName,int releasenumber,
			String unloadcomments) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int ProbationData =0;
		try{
			String query = "Select count(*) as count from "+tblName+" where Release=? and Comments=?;"; 
	        Object[] inputs = new Object[] {releasenumber,unloadcomments};
	        ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return ProbationData;
	}

	/* (non-Javadoc)
	 * @see com.st.despatch.dao.DespatchDao#getCheckReleaseTempTable(int, int)
	 */
	@Override
	public int getCheckReleaseTempTable(String tblName,int releasenumber, int releasenumber2) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int ProbationData =0;
		try{
			String query = "Select count(*) as count from "+tblName+" where Release=? and Release=?;"; 
	        Object[] inputs = new Object[] {releasenumber,releasenumber};
	        ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return ProbationData;
	}
	
	@Override
	public int getCarrirRateTempTable(String tblName,int releasenumber, int carrirRate) {
		// TODO Auto-generated method stub]
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int ProbationData =0;
		try{
			String query = "Select count(*) as count from "+tblName+" where Release=? and carrirRate=?;"; 
	        Object[] inputs = new Object[] {releasenumber,carrirRate};
	        ProbationData = jdbcTemplate.queryForObject(query, inputs, Integer.class);
	    }catch(Exception rlt){
			rlt.printStackTrace();
		}
		finally{
			
		}
		return ProbationData;
	}

	
}
