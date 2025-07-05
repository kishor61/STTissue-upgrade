/**
 * 
 */
package com.st.common.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.st.common.model.Area;

/**
 * @author sbora
 *
 */
@Repository
public class AreaDaoImp implements AreaDao {
	@Autowired
	private DataSource dataSource;

	/* (non-Javadoc)
	 * @see com.st.common.dao.AreaDao#getAreas()
	 */
	@Override
	public List<Area> getAreas() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [area] order by name asc";
		
		List<Area> areas=jdbcTemplate.query(sql, new RowMapper<Area>(){

			@Override
			public Area mapRow(ResultSet rs, int arg1) throws SQLException {
				Area area=new Area();
				area.setId(rs.getInt("ID"));
				area.setName(rs.getString("name"));
				area.setType(rs.getInt("type"));
				return area;
			}});
		
		return areas;
	}

	/* (non-Javadoc)
	 * @see com.st.common.dao.AreaDao#getArea(int)
	 */
	@Override
	public Area getArea(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [area] where [ID]=?";
		
		Area area=jdbcTemplate.queryForObject(sql,new Object[]{id}, new RowMapper<Area>(){

			@Override
			public Area mapRow(ResultSet rs, int arg1) throws SQLException {
				Area area=new Area();
				area.setId(rs.getInt("ID"));
				area.setName(rs.getString("name"));
				area.setType(rs.getInt("type"));
				return area;
			}});
		
		return area;
	}

	/* (non-Javadoc)
	 * @see com.st.common.dao.AreaDao#saveOrUpdate(com.st.common.model.Area)
	 */
	@Override
	public void saveOrUpdate(Area area) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		if(area.getId()==0){
			String sql="insert into [Area] ("
					+ "[name],[type]"
					+ ") values(?,?)";
			jdbcTemplate.update(sql, new Object[]{area.getName(),area.getType()});
		}else{
			String sql="update [Area] set "
					+ "[name]=?,[type]=?"
					+ " where [ID]=? ";
			jdbcTemplate.update(sql, new Object[]{area.getName(),area.getType(),area.getId()});
			
		}
		
	}
}
