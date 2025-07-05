/**
 *Jan 10, 2015
 *OperatingProcedureServiceDaoImp.java
 * TODO
 *com.st.operatingprocedure.dao
 *OperatingProcedureServiceDaoImp.java
 *Sunil Singh Bora
 */
package com.st.operatingprocedure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.st.operatingprocedure.model.OperatingProcedure;
import com.st.operatingprocedure.model.Type;

/**
 * @author roshan
 *
 */
@Repository
public class OperatingProcedureDaoImp implements OperatingProcedureDao{

	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#save(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	public void save(OperatingProcedure operatingProcedure) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="insert into [operatingprocedure]("
				+ "[Type],"
				+ "[Name],"
				+ "[File],"
				+ "[EntryDate],[SubType],[Area]"
				+ ") values (?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql,new Object[]{operatingProcedure.getType(),operatingProcedure.getName(),
				operatingProcedure.getFile(),new Timestamp(operatingProcedure.getEntryDate().getTime()),operatingProcedure.getSubType(),operatingProcedure.getArea()});
		
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getTypes()
	 */
	@Override
	public List<String> getTypes() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select distinct(Type) from [operatingprocedure]";
		
		List<String> types=jdbcTemplate.query(sql, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getString(1);
			}
		});
		
		return types;
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getOperatingProcedure()
	 */
	@Override
	public List<OperatingProcedure> getOperatingProcedure() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [operatingprocedure] order by [EntryDate]";
		
		List<OperatingProcedure> procedures=jdbcTemplate.query(sql, new RowMapper<OperatingProcedure>(){

			@Override
			public OperatingProcedure mapRow(ResultSet rs, int arg1)
					throws SQLException {
				OperatingProcedure operatingProcedure=new OperatingProcedure();
				operatingProcedure.setId(rs.getInt("ID"));
				operatingProcedure.setType(rs.getString("Type"));
				operatingProcedure.setFile(rs.getString("File"));
				operatingProcedure.setName(rs.getString("Name"));
				operatingProcedure.setSubType(rs.getString("SubType"));
				operatingProcedure.setEntryDate(new Date(rs.getTimestamp("EntryDate").getTime()));
				return operatingProcedure;
			}
			
		});
		
		return procedures;
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [operatingprocedure] where [ID]=? ";
		jdbcTemplate.update(sql,new Object[]{id});
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#updateCategory(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateCategory(String newCat, String oldCat) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update  [operatingprocedure] set [Type]=? where [Type]=? ";
		jdbcTemplate.update(sql,new Object[]{newCat.toUpperCase(),oldCat.toUpperCase()});
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getOperatingProcedure(java.lang.String, java.lang.String)
	 */
	@Override
	public List<OperatingProcedure> getOperatingProcedure(String file,String area,String category,String subCategory) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	
		Object[] param=null;
		
		String sql="select * from [operatingprocedure]";
		
		if(StringUtils.isNotEmpty(file) && StringUtils.isEmpty(area) && StringUtils.isEmpty(category) && StringUtils.isEmpty(subCategory)){
			sql+=" where [Name] like ? ";
			param=new Object[]{"%"+file+"%"};
		}else if(StringUtils.isEmpty(file) && StringUtils.isNotEmpty(area) && StringUtils.isNotEmpty(category) && StringUtils.isEmpty(subCategory)){
			sql+=" where [Area] like ? And [Type] like ? ";
			param=new Object[]{"%"+area+"%","%"+category+"%"};
		}else if(StringUtils.isEmpty(file) && StringUtils.isEmpty(area) && StringUtils.isNotEmpty(category) && StringUtils.isEmpty(subCategory)){
			sql+=" where [Type] like ? ";
			param=new Object[]{"%"+category+"%"};
		}else if(StringUtils.isEmpty(file) && StringUtils.isEmpty(area) && StringUtils.isEmpty(category) && StringUtils.isNotEmpty(subCategory)){
			sql+=" where [SubType] like ? ";
			param=new Object[]{"%"+subCategory+"%"};
		}else if(StringUtils.isNotEmpty(file) && StringUtils.isNotEmpty(area) && StringUtils.isEmpty(category) && StringUtils.isEmpty(subCategory)){
			sql+=" where [Name] like ? and [Area] like ? ";
			param=new Object[]{"%"+file+"%","%"+area+"%"};
		}else if(StringUtils.isNotEmpty(file) && StringUtils.isNotEmpty(category) && StringUtils.isEmpty(area) && StringUtils.isEmpty(subCategory)){
			sql+=" where [Type] like ? and [Name] like ? ";
			param=new Object[]{"%"+category+"%","%"+file+"%"};
		}else if(StringUtils.isEmpty(file) && StringUtils.isEmpty(area) && StringUtils.isNotEmpty(category) && StringUtils.isNotEmpty(subCategory)){
			sql+=" where [SubType] like ? and [Type] like ? ";
			param=new Object[]{"%"+subCategory+"%","%"+category+"%"};
		}else if(StringUtils.isNotEmpty(file) && StringUtils.isEmpty(category) && StringUtils.isEmpty(area) && StringUtils.isNotEmpty(subCategory)){
			sql+=" where [Name] like ? and [SubType] like ? ";
			param=new Object[]{"%"+file+"%","%"+subCategory+"%"};
		}else if(StringUtils.isNotEmpty(file) && StringUtils.isNotEmpty(category) && StringUtils.isNotEmpty(subCategory) && StringUtils.isNotEmpty(area) ){
			sql+=" where [Type] like ? and [Name] like ? and [SubType] like ? and [Area] like ?";
			param=new Object[]{"%"+category+"%","%"+file+"%","%"+subCategory+"%","%"+area+"%"};
		}else if(StringUtils.isEmpty(file) && StringUtils.isEmpty(category) && StringUtils.isEmpty(subCategory) && StringUtils.isNotEmpty(area) ){
			sql+=" where [Area] like ?";
			param=new Object[]{"%"+area+"%"};
		}else if(StringUtils.isEmpty(file) && StringUtils.isNotEmpty(category) && StringUtils.isEmpty(subCategory) && StringUtils.isNotEmpty(area) ){
			sql+=" where [Area] like ? And [Type] like ? ";
			param=new Object[]{"%"+area+"%","%"+category+"%"};
		}else if(StringUtils.isEmpty(file) && StringUtils.isEmpty(category) && StringUtils.isNotEmpty(subCategory) && StringUtils.isNotEmpty(area) ){
			sql+=" where [Area] like ? And [SubType] like ? ";
			param=new Object[]{"%"+area+"%","%"+subCategory+"%"};
		}else if(StringUtils.isEmpty(file) && StringUtils.isNotEmpty(category) && StringUtils.isNotEmpty(subCategory) && StringUtils.isNotEmpty(area) ){
			sql+=" where [Type] like ? And [SubType] like ? And [Area] like ? ";
			param=new Object[]{"%"+category+"%","%"+subCategory+"%","%"+area+"%"};
		}else{
			param=new Object[]{};
		}
				
				
		sql+= " order by [EntryDate]";
		
		
		List<OperatingProcedure> procedures=jdbcTemplate.query(sql, param,new RowMapper<OperatingProcedure>(){

			@Override
			public OperatingProcedure mapRow(ResultSet rs, int arg1)
					throws SQLException {
				OperatingProcedure operatingProcedure=new OperatingProcedure();
				operatingProcedure.setId(rs.getInt("ID"));
				operatingProcedure.setType(rs.getString("Type"));
				operatingProcedure.setArea(rs.getString("Area"));
				operatingProcedure.setFile(rs.getString("File"));
				operatingProcedure.setName(rs.getString("Name"));
				operatingProcedure.setSubType(rs.getString("SubType"));
				operatingProcedure.setEntryDate(new Date(rs.getTimestamp("EntryDate").getTime()));
				return operatingProcedure;
			}
			
		});
		
		
		return procedures;
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getSubTypes()
	 */
	@Override
	public List<String> getSubTypes() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select distinct(SubType) from [operatingprocedure]";
		
		
		
		
		List<String> subTypes=jdbcTemplate.query(sql, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getString(1);
			}
		});
		
		return subTypes;
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getTypesAndSubTypes()
	 */
	@Override
	public List<Type> getTypesAndSubTypes() {
		final JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select distinct(Type) from [operatingprocedure]";
		
		List<Type> types=jdbcTemplate.query(sql, new RowMapper<Type>(){
			@Override
			public Type mapRow(ResultSet rs, int arg1) throws SQLException {
				Type type=new Type(rs.getString(1));
				
				String sql="select distinct(SubType) from [operatingprocedure] where [Type]=?";
				List<String> subtypes=jdbcTemplate.query(sql,new Object[]{type.getName()}, new RowMapper<String>(){

					@Override
					public String mapRow(ResultSet rs, int arg1)
							throws SQLException {
						
						return rs.getString(1);
					}
					
				});
				for (String string : subtypes) {
					if(string!=null){
						type.getSubType().add(string);
					}
				}
				
				return type;
			}
		});
		return types;
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#updateSubCategory(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateSubCategory(String newcat, String oldcat, String type) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update  [operatingprocedure] set [SubType]=? where [SubType]=? and [Type]=?";
		jdbcTemplate.update(sql,new Object[]{newcat.toUpperCase(),oldcat.toUpperCase(),type});
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getOperatingProcedure(int)
	 */
	@Override
	public OperatingProcedure getOperatingProcedure(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [operatingprocedure] where [ID]=?";
		
		List<OperatingProcedure> procedures=jdbcTemplate.query(sql,new Object[]{id}, new RowMapper<OperatingProcedure>(){

			@Override
			public OperatingProcedure mapRow(ResultSet rs, int arg1)
					throws SQLException {
				OperatingProcedure operatingProcedure=new OperatingProcedure();
				operatingProcedure.setId(rs.getInt("ID"));
				operatingProcedure.setType(rs.getString("Type"));
				operatingProcedure.setFile(rs.getString("File"));
				operatingProcedure.setName(rs.getString("Name"));
				operatingProcedure.setSubType(rs.getString("SubType"));
				operatingProcedure.setArea(rs.getString("Area"));
				operatingProcedure.setEntryDate(new Date(rs.getTimestamp("EntryDate").getTime()));
				return operatingProcedure;
			}
			
		});
		
		OperatingProcedure operatingProcedure=null;
		if(procedures.size()>0){
			operatingProcedure=procedures.get(0);
		}
		return operatingProcedure;
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#update(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	public void update(OperatingProcedure procedure) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update  [operatingprocedure] set [SubType]=?,[Type]=?,[Name]=?,[Area]=? where [ID]=? ";
		jdbcTemplate.update(sql,new Object[]{
				procedure.getSubType().toUpperCase(),
				procedure.getType().toUpperCase(),
				procedure.getName(),
				procedure.getArea().toUpperCase(),
				procedure.getId()
		});
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#saveMainCatgoryNameData(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	public int saveMainCatgoryNameData(final OperatingProcedure vendorSeller) {

		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into tlb_procedure_manage_category"
				+ "("
				+"main_catego_name"
				+ ")"
				+ " values("
				+ "?"	
				+ ")";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				statement.setString(1,vendorSeller.getMaincategoname());
				return statement;
			}
	
		},keyHolder);
		return keyHolder.getKey().intValue();
	
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getMainCategory()
	 */
	@Override
	public List<OperatingProcedure> getMainCategory() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from tlb_procedure_manage_category order by main_catego_name";
		
		List<OperatingProcedure> procedures=jdbcTemplate.query(sql, new RowMapper<OperatingProcedure>(){

			@Override
			public OperatingProcedure mapRow(ResultSet rs, int arg1)
					throws SQLException {
				OperatingProcedure operatingProcedure=new OperatingProcedure();
				operatingProcedure.setId(rs.getInt("ID"));
				operatingProcedure.setMaincategoname(rs.getString("main_catego_name"));
				return operatingProcedure;
			}
			
		});
		
		return procedures;
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#deleteMainCatgoryNameData(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	public void deleteMainCatgoryNameData(final OperatingProcedure vendorSeller) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from tlb_procedure_manage_category where [ID]=? ";
		jdbcTemplate.update(sql,new Object[]{vendorSeller.getId()});
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#updateMainCatgoryNameData(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	public void updateMainCatgoryNameData(final OperatingProcedure vendorSeller) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update  tlb_procedure_manage_category set [main_catego_name]=? where [id]=? ";
		jdbcTemplate.update(sql,new Object[]{vendorSeller.getMaincategoname(),vendorSeller.getId()});
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#saveSubCatgoryNameData(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	public int saveSubCatgoryNameData(final OperatingProcedure vendorSeller) {

		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into tlb_procedure_manage_subcategory"
				+ "("
				+"sub_catego_name,"
				+"main_catego_name"
				+ ")"
				+ " values("
				+ "?,?"	
				+ ")";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				statement.setString(1,vendorSeller.getEntersubcatname());
				statement.setString(2,vendorSeller.getMaincategoname());
				return statement;
			}
	
		},keyHolder);
		return keyHolder.getKey().intValue();
	
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getSubCategory()
	 */
	@Override
	public List<OperatingProcedure> getSubCategory() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from tlb_procedure_manage_subcategory order by sub_catego_name";
		
		List<OperatingProcedure> procedures=jdbcTemplate.query(sql, new RowMapper<OperatingProcedure>(){

			@Override
			public OperatingProcedure mapRow(ResultSet rs, int arg1)
					throws SQLException {
				OperatingProcedure operatingProcedure=new OperatingProcedure();
				operatingProcedure.setId(rs.getInt("ID"));
				operatingProcedure.setMaincategoname(rs.getString("main_catego_name"));
				operatingProcedure.setEntersubcatname(rs.getString("sub_catego_name"));
				return operatingProcedure;
			}
			
		});
		
		return procedures;
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#deleteSubCatgoryNameData(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	public void deleteSubCatgoryNameData(final OperatingProcedure vendorSeller) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from tlb_procedure_manage_subcategory where [ID]=? ";
		jdbcTemplate.update(sql,new Object[]{vendorSeller.getId()});
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#saveAreaName(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	public int saveAreaName(final OperatingProcedure vendorSeller) {

		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		final String sql="insert into tlb_procedure_manage_area"
				+ "("
				+"area"
				+ ")"
				+ " values("
				+ "?"	
				+ ")";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
				statement.setString(1,vendorSeller.getArea());
				return statement;
			}
	
		},keyHolder);
		return keyHolder.getKey().intValue();
	
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getArea()
	 */
	@Override
	public List<OperatingProcedure> getArea() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from tlb_procedure_manage_area order by area";
		
		List<OperatingProcedure> procedures=jdbcTemplate.query(sql, new RowMapper<OperatingProcedure>(){

			@Override
			public OperatingProcedure mapRow(ResultSet rs, int arg1)
					throws SQLException {
				OperatingProcedure operatingProcedure=new OperatingProcedure();
				operatingProcedure.setId(rs.getInt("ID"));
				operatingProcedure.setArea(rs.getString("area"));
				return operatingProcedure;
			}
			
		});
		
		return procedures;
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#updateAreaName(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	public void updateAreaName(OperatingProcedure vendorSeller) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update  tlb_procedure_manage_area set [area]=? where [id]=? ";
		jdbcTemplate.update(sql,new Object[]{vendorSeller.getArea(),vendorSeller.getId()});
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#deletAreaName(com.st.operatingprocedure.model.OperatingProcedure)
	 */
	@Override
	public void deletAreaName(OperatingProcedure vendorSeller) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from tlb_procedure_manage_area where [ID]=? ";
		jdbcTemplate.update(sql,new Object[]{vendorSeller.getId()});
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getAreas()
	 */
	@Override
	public List<String> getAreas() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select distinct(Area) from [operatingprocedure]";
		
		
		
		
		List<String> aeraTypes=jdbcTemplate.query(sql, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getString(1);
			}
		});
		
		return aeraTypes;
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#updateAreaNameEdit(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateAreaNameEdit(String newcat, String oldcat) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update  [operatingprocedure] set [Area]=? where [Area]=? ";
		jdbcTemplate.update(sql,new Object[]{newcat.toUpperCase(),oldcat.toUpperCase()});
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getMainCatogoeryByAreaWise(java.lang.String)
	 */
	@Override
	public List<OperatingProcedure> getMainCatogoeryByAreaWise(String area) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Object[] param=null;
		String sql="select distinct(Type) from operatingprocedure where Area=? order by Type";
		
		param=new Object[]{area};
		
		List<OperatingProcedure> procedures=jdbcTemplate.query(sql,param, new RowMapper<OperatingProcedure>(){

			@Override
			public OperatingProcedure mapRow(ResultSet rs, int arg1)
					throws SQLException {
				OperatingProcedure operatingProcedure=new OperatingProcedure();
				//operatingProcedure.setId(rs.getInt("ID"));
				operatingProcedure.setType(rs.getString("Type"));
				return operatingProcedure;
			}
			
		});
		
		return procedures;
	}

	/* (non-Javadoc)
	 * @see com.st.operatingprocedure.dao.OperatingProcedureDao#getSubCatogoeryByAreaAndMainCatWise(java.lang.String, java.lang.String)
	 */
	@Override
	public List<OperatingProcedure> getSubCatogoeryByAreaAndMainCatWise(String area, String maincat) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		Object[] param=null;
		String sql="select distinct(SubType) from operatingprocedure where Area=? And Type=? order by SubType";
		
		param=new Object[]{area,maincat};
		
		List<OperatingProcedure> procedures=jdbcTemplate.query(sql,param, new RowMapper<OperatingProcedure>(){

			@Override
			public OperatingProcedure mapRow(ResultSet rs, int arg1)
					throws SQLException {
				OperatingProcedure operatingProcedure=new OperatingProcedure();
				//operatingProcedure.setId(rs.getInt("ID"));
				operatingProcedure.setSubType(rs.getString("SubType"));
				return operatingProcedure;
			}
			
		});
		
		return procedures;
	}

}
