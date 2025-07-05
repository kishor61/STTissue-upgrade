package com.st.qualitypm6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.st.common.Columns;
import com.st.qualitypm6.mapper.GradeTargetMapper;
import com.st.qualitypm6.model.GradeTarget;

@Repository
public class GradeTargetDaoImp implements GradeTargetDao{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void save(final GradeTarget gradeTarget) throws Exception {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="insert into gradeTarget(GradeCode,PhysicalProperty,RejectMin,ControlMin,Target,ControlMax,RejectMax,Note) "
				+ "values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

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
		
	
		
	}

	@Override
	public List<GradeTarget> getGradeTargets(String gradeCode) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [gradeTarget] where [GradeCode]='"+gradeCode+"'";
		List<GradeTarget> gradeTargets=jdbcTemplate.query(sql, new GradeTargetMapper());
		
		if(gradeTargets.size()==0){
			String sql2="select * from gradePhysicalProperties order by PhysicalPropertyID";
			List<Map<String, Object>> gradesProp=jdbcTemplate.queryForList(sql2);
			for (Map<String, Object> map : gradesProp) {
				GradeTarget gradeTarget=new GradeTarget();
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
			String sql2="select * from gradePhysicalProperties order by PhysicalPropertyID";
			List<Map<String, Object>> gradesProp=jdbcTemplate.queryForList(sql2);
			for (Map<String, Object> map : gradesProp) {
				String propId=map.get("PhysicalPropertyID").toString();
				
				if(isPropertyExist(propId, gradeTargets)){
					for (GradeTarget gradeTarget : gradeTargets) {
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
					GradeTarget gradeTarget=new GradeTarget();
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

	
	private boolean isPropertyExist(String propId,List<GradeTarget> gradeTargets){
		boolean flag=false;
		for (GradeTarget gradeTarget : gradeTargets) {
			if(propId.equals(gradeTarget.getPhysicalProperty())){
				flag=true;
				break;
			}
		}
		return flag;
		
	}

	@Override
	public void save(List<GradeTarget> gradeTargets) throws Exception {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		for (final GradeTarget gradeTarget : gradeTargets) {
		//	System.out.println(gradeTarget.getGradeCode());
			
			String sql="select count(*) from [gradeTarget] where [GradeCode]='"+gradeTarget.getGradeCode()+"' and "
					+ "[PhysicalProperty]='"+gradeTarget.getPhysicalProperty()+"'";
			int num=jdbcTemplate.queryForObject(sql, Integer.class);
			
			if(num==0){
				//Insert
				String sql2="insert into [gradeTarget]([GradeCode],[PhysicalProperty],[RejectMin],[ControlMin],[Target],[ControlMax],[RejectMax],[Note]) "
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
				String sql2="update [gradeTarget] SET "
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

	@Override
	public GradeTarget getGradeTarget(String grade, String prop) {
		GradeTarget gradeTarget=new GradeTarget();
		Connection connection=null;
		try{
			connection=dataSource.getConnection();
			String sql="select * from [gradeTarget] where [GradeCode]='"+grade+"' and [PhysicalProperty]='"+prop+"'";
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			if(rs.next()){
				gradeTarget.setGradeCode(rs.getString(1));
				gradeTarget.setPhysicalProperty(rs.getString(2));
				gradeTarget.setRejectMin(rs.getDouble(3));
				gradeTarget.setControlMin(rs.getDouble(4));
				gradeTarget.setTarget(rs.getDouble(5));
				gradeTarget.setControlMax(rs.getDouble(6));
				gradeTarget.setRejectMax(rs.getDouble(7));
				gradeTarget.setNote(rs.getString(8));
			}
			rs.close();
			statement.close();
			connection.close();
		}catch(Exception e){
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return gradeTarget;
		
		/*JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [gradeTarget] where [GradeCode]=? and [PhysicalProperty]=?";
		GradeTarget gradeTarget=jdbcTemplate.queryForObject(sql, new Object[]{grade,prop}, new GradeTargetMapper());
		return gradeTarget;*/
	}

	@Override
	public List<GradeTarget> getGradeTarget(String gradeCode) {
		/*JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [gradeTarget] where [GradeCode]=?";
		List<GradeTarget> gradeTargets=jdbcTemplate.query(sql, new Object[]{gradeCode}, new GradeTargetMapper());
	
		System.out.println("GradeTarget---"+gradeCode);
		*/
		List<GradeTarget> gradeTargets=new ArrayList<GradeTarget>();
		Connection connection=null;
		try{
			connection=dataSource.getConnection();
			String sql="select * from [gradeTarget] where [GradeCode]='"+gradeCode+"'";
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()){
				GradeTarget gradeTarget=new GradeTarget();
				gradeTarget.setGradeCode(rs.getString(1));
				gradeTarget.setPhysicalProperty(rs.getString(2));
				gradeTarget.setRejectMin(rs.getDouble(3));
				gradeTarget.setControlMin(rs.getDouble(4));
				gradeTarget.setTarget(rs.getDouble(5));
				gradeTarget.setControlMax(rs.getDouble(6));
				gradeTarget.setRejectMax(rs.getDouble(7));
				gradeTarget.setNote(rs.getString(8));
				gradeTargets.add(gradeTarget);
			}
			rs.close();
			statement.close();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return gradeTargets;
	}

	
}
