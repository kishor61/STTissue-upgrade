/**
 *Dec 21, 2017
 *GradeTargetPM5DaoImp.java
 * TODO
 *com.st.qualitypm5.dao
 *GradeTargetPM5DaoImp.java
 *Roshan Lal Tailor
 */
package com.st.qualitypm5.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.st.common.Columns;
import com.st.qualitypm5.mapper.GradeTargetPM5Mapper;
import com.st.qualitypm5.model.GradeTargetPM5;
import com.st.qualitypm6.mapper.GradeTargetMapper;
import com.st.qualitypm6.model.GradeTarget;

/**
 * @author roshan
 *
 */
@Repository
public class GradeTargetPM5DaoImp implements GradeTargetPM5Dao{

	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.GradeTargetPM5Dao#getGradeTargets(java.lang.String)
	 */
	@Override
	public List<GradeTargetPM5> getGradeTargets(String gradeCode) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [gradeTarget_pm5] where [GradeCode]='"+gradeCode+"'";
		List<GradeTargetPM5> gradeTargets=jdbcTemplate.query(sql, new GradeTargetPM5Mapper());
		
		if(gradeTargets.size()==0){
			String sql2="select * from gradePhysicalProperties_pm5 order by PhysicalPropertyID";
			List<Map<String, Object>> gradesProp=jdbcTemplate.queryForList(sql2);
			for (Map<String, Object> map : gradesProp) {
				GradeTargetPM5 gradeTarget=new GradeTargetPM5();
				gradeTarget.setPhysicalProperty(map.get("PhysicalPropertyID").toString());
				if(map.get("Name")!=null){
					gradeTarget.setPropertyName(map.get("Name").toString());
				}
				if(map.get("Unit")!=null){
					gradeTarget.setUnitName(map.get("Unit").toString());
				}

				gradeTargets.add(gradeTarget);
			}
			
		}else{
			String sql2="select * from gradePhysicalProperties_pm5 order by PhysicalPropertyID";
			List<Map<String, Object>> gradesProp=jdbcTemplate.queryForList(sql2);
			for (Map<String, Object> map : gradesProp) {
				String propId=map.get("PhysicalPropertyID").toString();
				
				if(isPropertyExist(propId, gradeTargets)){
					for (GradeTargetPM5 gradeTarget : gradeTargets) {
						if(gradeTarget.getPhysicalProperty().equals(propId)){
							if(map.get("Name")!=null){
								gradeTarget.setPropertyName(map.get("Name").toString());
							}
							if(map.get("Unit")!=null){
								gradeTarget.setUnitName(map.get("Unit").toString());
							}
							
							break;
						}
					}
				}else{
					GradeTargetPM5 gradeTarget=new GradeTargetPM5();
					gradeTarget.setPhysicalProperty(propId);
					if(map.get("Name")!=null){
						gradeTarget.setPropertyName(map.get("Name").toString());
					}
					if(map.get("Unit")!=null){
						gradeTarget.setUnitName(map.get("Unit").toString());
					}

					gradeTargets.add(gradeTarget);
				}
			}
		}

		return gradeTargets;
	}

	/**
	 * @param propId
	 * @param gradeTargets
	 * @return
	 */
	private boolean isPropertyExist(String propId, List<GradeTargetPM5> gradeTargets) {
		boolean flag=false;
		for (GradeTargetPM5 gradeTarget : gradeTargets) {
			if(propId.equals(gradeTarget.getPhysicalProperty())){
				flag=true;
				break;
			}
		}
		return flag;
		
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.GradeTargetPM5Dao#save(java.util.List)
	 */
	@Override
	public void save(List<GradeTargetPM5> gradeTargets) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		for (final GradeTargetPM5 gradeTarget : gradeTargets) {
		//	System.out.println(gradeTarget.getGradeCode());
			
			String sql="select count(*) from [gradeTarget_pm5] where [GradeCode]='"+gradeTarget.getGradeCode()+"' and "
					+ "[PhysicalProperty]='"+gradeTarget.getPhysicalProperty()+"'";
			int num=jdbcTemplate.queryForObject(sql, Integer.class);
			
			if(num==0){
				//Insert
				String sql2="insert into [gradeTarget_pm5]([GradeCode],[PhysicalProperty],[RejectMin],[ControlMin],[Target],[ControlMax],[RejectMax],[Note]) "
						+ "values(?,?,?,?,?,?,?,?)";
				
				jdbcTemplate.execute(sql2, new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement statement)
							throws SQLException, DataAccessException {
						statement.setString(Columns.COL_01, gradeTarget.getGradeCode());
						statement.setString(Columns.COL_02, gradeTarget.getPhysicalProperty());
						statement.setDouble(Columns.COL_03, gradeTarget.getRejectMin());
						statement.setDouble(Columns.COL_04, gradeTarget.getControlMin());
						statement.setDouble(Columns.COL_05, gradeTarget.getTarget());
						statement.setDouble(Columns.COL_06, gradeTarget.getControlMax());
						statement.setDouble(Columns.COL_07, gradeTarget.getRejectMax());
						statement.setString(Columns.COL_08, gradeTarget.getNote());
						return statement.execute();
					}
				});

			}else{
				String sql2="update [gradeTarget_pm5] SET "
						+ "[RejectMin]=?,"
						+ "[ControlMin]=?,"
						+ "[Target]=?,"
						+ "[ControlMax]=?,"
						+ "[RejectMax]=?,"
						+ "[Note]=? "
						+ "where [GradeCode]=? and [PhysicalProperty]=?";
				
				jdbcTemplate.execute(sql2, new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement statement)
							throws SQLException, DataAccessException {
						statement.setDouble(Columns.COL_01, gradeTarget.getRejectMin());
						statement.setDouble(Columns.COL_02, gradeTarget.getControlMin());
						statement.setDouble(Columns.COL_03, gradeTarget.getTarget());
						statement.setDouble(Columns.COL_04, gradeTarget.getControlMax());
						statement.setDouble(Columns.COL_05, gradeTarget.getRejectMax());
						statement.setString(Columns.COL_06, gradeTarget.getNote());
						
						statement.setString(Columns.COL_07, gradeTarget.getGradeCode());
						statement.setString(Columns.COL_08, gradeTarget.getPhysicalProperty());
						return statement.execute();
					}
				
				});

			}
			
			
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.st.qualitypm5.dao.GradeTargetPM5Dao#getGradeTarget(java.lang.String)
	 */
	@Override
	public List<GradeTargetPM5> getGradeTarget(String gradeCode) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [gradeTarget_pm5] where [GradeCode]='"+gradeCode+"'";
		List<GradeTargetPM5> gradeTargets=jdbcTemplate.query(sql, new GradeTargetPM5Mapper());
		
		if(gradeTargets.size()==0){
			String sql2="select * from gradePhysicalProperties_pm5 order by PhysicalPropertyID";
			List<Map<String, Object>> gradesProp=jdbcTemplate.queryForList(sql2);
			for (Map<String, Object> map : gradesProp) {
				GradeTargetPM5 gradeTarget=new GradeTargetPM5();
				gradeTarget.setPhysicalProperty(map.get("PhysicalPropertyID").toString());
				if(map.get("Name")!=null){
					gradeTarget.setPropertyName(map.get("Name").toString());
				}
				if(map.get("Unit")!=null){
					gradeTarget.setUnitName(map.get("Unit").toString());
				}

				gradeTargets.add(gradeTarget);
			}
			
		}else{
			String sql2="select * from gradePhysicalProperties_pm5 order by PhysicalPropertyID";
			List<Map<String, Object>> gradesProp=jdbcTemplate.queryForList(sql2);
			for (Map<String, Object> map : gradesProp) {
				String propId=map.get("PhysicalPropertyID").toString();
				
				if(isPropertyExist(propId, gradeTargets)){
					for (GradeTargetPM5 gradeTarget : gradeTargets) {
						if(gradeTarget.getPhysicalProperty().equals(propId)){
							if(map.get("Name")!=null){
								gradeTarget.setPropertyName(map.get("Name").toString());
							}
							if(map.get("Unit")!=null){
								gradeTarget.setUnitName(map.get("Unit").toString());
							}
							
							break;
						}
					}
				}else{
					GradeTargetPM5 gradeTarget=new GradeTargetPM5();
					gradeTarget.setPhysicalProperty(propId);
					if(map.get("Name")!=null){
						gradeTarget.setPropertyName(map.get("Name").toString());
					}
					if(map.get("Unit")!=null){
						gradeTarget.setUnitName(map.get("Unit").toString());
					}

					gradeTargets.add(gradeTarget);
				}
			}
		}

		return gradeTargets;
	}

}
