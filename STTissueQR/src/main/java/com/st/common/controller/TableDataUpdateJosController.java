/**
 *Sep 28, 2021
 *TableDataUpdateJosController.java
 * TODO
 *com.st.common.controller
 *TableDataUpdateJosController.java
 *Sohan Lal 
 */
package com.st.common.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Repository;

/**
 * @author Sohanlal
 *
 */
@Configuration
@EnableScheduling
@Repository
public class TableDataUpdateJosController {
//	@Autowired
//	private DataSource dataSourceP;
//
//	@Autowired
//	private DataSource dataSource;
//	
//	//@Scheduled(cron="0 01 00 * * ?")
//	public void DataFor_Grade_Table(){
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceP);
//			List<Grade> grades=null;
//			String sql="select * from [tlkpGradeCode] where [Machine]='6' order by GradeCode";
//			try {
//				grades=jdbcTemplate.query(sql,new RowMapper<Grade> (){
//					@Override
//					public Grade mapRow(ResultSet rs, int arg1) throws SQLException {
//						Grade grade=new Grade();
//						grade.setGradeCode(rs.getString(2));					
//						grade.setTmNo("F-6");			
//						grade.setCustomer(rs.getString(9));			
//						return grade;
//					}
//				});
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//			JdbcTemplate jdbcTemplate1 = new JdbcTemplate(dataSource);	
//			int i=0;
//			for (Grade grade : grades) {
//			try {
//				List<String> GradeCode=jdbcTemplate1.queryForList("SELECT  GradeCode FROM grade WHERE GradeCode=?", 
//						new Object[] { grade.getGradeCode() }, String.class);
//				if(GradeCode.size()==0)
//				{				i+=	jdbcTemplate1.update(
//						    "INSERT INTO [grade] ([GradeCode], [RevisionDate],[TMNo],[Customer]) VALUES (?,?,?,?)",
//						    new Object[]{grade.getGradeCode(),new Date(), grade.getTmNo(),grade.getCustomer()}
//						);
//				System.out.println("No of record inserted in Table " +i);
//				}
//				else
//				{
//					//System.out.println(GradeCode +" already in yhe data base table ");
//				}			
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//		}		
//	}
//	
//	//@Scheduled(cron="0 15 08 * * ?")
//	public void DataFor_grade_pm5_Table(){
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceP);
//			List<Grade> grades=null;
//			String sql="select * from [tlkpGradeCode] where [Machine]='5' order by GradeCode";
//			try {
//				grades=jdbcTemplate.query(sql,new RowMapper<Grade> (){
//					@Override
//					public Grade mapRow(ResultSet rs, int arg1) throws SQLException {
//						Grade grade=new Grade();
//						grade.setGradeCode(rs.getString(2));					
//						grade.setTmNo("F-6");			
//						grade.setCustomer(rs.getString(9));			
//						return grade;
//					}
//				});
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//			JdbcTemplate jdbcTemplate1 = new JdbcTemplate(dataSource);	
//			int i=0;
//			for (Grade grade : grades) {
//			try {
//				List<String> GradeCode=jdbcTemplate1.queryForList("SELECT  GradeCode FROM grade_pm5 WHERE GradeCode=?", 
//						new Object[] { grade.getGradeCode() }, String.class);
//				if(GradeCode.size()==0)
//				{				i+=	jdbcTemplate1.update(
//						    "INSERT INTO [grade_pm5] ([GradeCode], [RevisionDate],[TMNo],[Customer]) VALUES (?,?,?,?)",
//						    new Object[]{grade.getGradeCode(),new Date(), grade.getTmNo(),grade.getCustomer()}
//						);
//				System.out.println("No of record inserted in Table " +i);
//				}
//				else
//				{
//					//System.out.println(GradeCode +" already in yhe data base table ");
//				}			
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//		}		
//	}
//
}
