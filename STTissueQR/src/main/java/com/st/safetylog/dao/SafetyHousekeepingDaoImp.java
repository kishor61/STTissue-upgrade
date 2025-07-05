/**
 * 
 */
package com.st.safetylog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.st.common.CommonUtil;
import com.st.customercomplaint.mapper.CustomerComplaintMapper;
import com.st.customercomplaint.model.CustomerComplaint;
import com.st.safetylog.mapper.SafetyHousekeepingSchedulesStatusMapper;
import com.st.safetylog.model.PositiveObservation;
import com.st.safetylog.model.PositiveObservationP;
import com.st.safetylog.model.SafetyHousekeeping;
import com.st.safetylog.model.SafetyHousekeepingAction;
import com.st.safetylog.model.SafetyHousekeepingSchedule;
import com.st.safetylog.model.SafetyHousekeepingStdType;
import com.st.safetylog.model.SafetyHousekeepingTask;

/**
 * @author sbora
 * 
 */
@Repository
public class SafetyHousekeepingDaoImp implements SafetyHousekeepingDao {
	@Autowired
	private DataSource dataSource;

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeeping(java.lang.String)
	 */
	@Override
	public List<SafetyHousekeeping> getSafetyHousekeeping(String type) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [safetyHousekeepingStd] where [Type]=? and [Deleted]=?";
		List<SafetyHousekeeping> housekeepings=jdbcTemplate.query(sql, new Object[]{type,false},new RowMapper<SafetyHousekeeping>(){

			@Override
			public SafetyHousekeeping mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeeping housekeeping=new SafetyHousekeeping();
				housekeeping.setId(rs.getInt("ID"));
				housekeeping.setDescription(rs.getString("Description"));
				housekeeping.setType(rs.getString("Type"));
				
				return housekeeping;
			}
			
		});
		
		return housekeepings;
	}
	@Override
	public List<SafetyHousekeeping> getSafetyHousekeeping() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [safetyHousekeepingStd] where [Deleted]=?";
		List<SafetyHousekeeping> housekeepings=jdbcTemplate.query(sql, new Object[]{false},new RowMapper<SafetyHousekeeping>(){

			@Override
			public SafetyHousekeeping mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeeping housekeeping=new SafetyHousekeeping();
				housekeeping.setId(rs.getInt("ID"));
				housekeeping.setDescription(rs.getString("Description"));
				housekeeping.setType(rs.getString("Type"));
				
				return housekeeping;
			}
			
		});
		
		return housekeepings;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#saveOrUpdate(com.st.safetylog.model.SafetyHousekeeping)
	 */
	@Override
	public void saveOrUpdate(SafetyHousekeeping housekeeping) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		if(housekeeping.getId()==0){
			String sql="insert into [safetyHousekeepingStd]"
					+ "([Description], [Type])"
					+ " values(?,?)";
			jdbcTemplate.update(sql, new Object[]{
					housekeeping.getDescription(),
					housekeeping.getType()
			});
		}else{
			String sql="update [safetyHousekeepingStd] set "
					+ "[Description]=?, "
					+ "[Type]=? "
					
					+ "where [ID]=? ";
			jdbcTemplate.update(sql, new Object[]{
					housekeeping.getDescription(),
					housekeeping.getType(),
					housekeeping.getId()
			});
		}
		
		
		
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#deleteStandard(int)
	 */
	@Override
	public void deleteStandard(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [safetyHousekeepingStd] set [Deleted]=? where [ID]=? ";
		jdbcTemplate.update(sql, new Object[]{true,id});
		
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeeping(int)
	 */
	@Override
	public SafetyHousekeeping getSafetyHousekeeping(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [safetyHousekeepingStd] where [ID]=? and [Deleted]=?";
		SafetyHousekeeping housekeeping=jdbcTemplate.queryForObject(sql, new Object[]{id,false},new RowMapper<SafetyHousekeeping>(){
			@Override
			public SafetyHousekeeping mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeeping housekeeping=new SafetyHousekeeping();
				housekeeping.setId(rs.getInt("ID"));
				housekeeping.setDescription(rs.getString("Description"));
				housekeeping.setType(rs.getString("Type"));
				
				return housekeeping;
			}
			
		});
		return housekeeping;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#saveOrUpdate(com.st.safetylog.model.SafetyHousekeepingAction)
	 */
	@Override
	public void saveOrUpdate(SafetyHousekeepingAction housekeepingAction) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		if(housekeepingAction.getId()==0){
			String sql="insert into [safetyHousekeepingAction]("
					+ "[DescOfFinding],"
					+ "[CorrectiveAction],"
					+ "[ByWhom],"
					+ "[TID],"
					+ "[SID],"
					+ "[File] "
					+ ") values(?,?,?,?,?,?)";
			jdbcTemplate.update(sql,new Object[]{
					housekeepingAction.getDescOfFinding(),
					housekeepingAction.getCorrectiveAction(),
					housekeepingAction.getByWhom(),
					housekeepingAction.getTid(),
					housekeepingAction.getSid(),
					housekeepingAction.getDocument()
			});
		}else{
			if(StringUtils.isEmpty(housekeepingAction.getDocument())){
				String sql="update [safetyHousekeepingAction] set "
						+ "[DescOfFinding]=?,"
						+ "[CorrectiveAction]=?,"
						+ "[ByWhom]=?,"
						+ "[TID]=?,"
						+ "[SID]=? "
						+ " where [ID]=?";
				jdbcTemplate.update(sql,new Object[]{
						housekeepingAction.getDescOfFinding(),
						housekeepingAction.getCorrectiveAction(),
						housekeepingAction.getByWhom(),
						housekeepingAction.getTid(),
						housekeepingAction.getSid(),
						housekeepingAction.getId()
				});
			}else{
				String sql="update [safetyHousekeepingAction] set "
						+ "[DescOfFinding]=?,"
						+ "[CorrectiveAction]=?,"
						+ "[ByWhom]=?,"
						+ "[TID]=?,"
						+ "[SID]=?,"
						+ "[File]=? "
						+ " where [ID]=?";
				jdbcTemplate.update(sql,new Object[]{
						housekeepingAction.getDescOfFinding(),
						housekeepingAction.getCorrectiveAction(),
						housekeepingAction.getByWhom(),
						housekeepingAction.getTid(),
						housekeepingAction.getSid(),
						housekeepingAction.getDocument(),
						housekeepingAction.getId()
				});
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeepingAction(int)
	 */
	@Override
	public List<SafetyHousekeepingAction> getSafetyHousekeepingAction(int sid,int taskId) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [safetyHousekeepingAction] where [Deleted]=? and  [SID]=? and [TID]=? "
				+ " order by [ID],[Closed]";
		List<SafetyHousekeepingAction> housekeepingActions=jdbcTemplate.query(sql, new Object[]{
				false,sid,taskId
		},new RowMapper<SafetyHousekeepingAction>(){

			@Override
			public SafetyHousekeepingAction mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeepingAction housekeepingAction=new SafetyHousekeepingAction();
				housekeepingAction.setId(rs.getInt("ID"));
				housekeepingAction.setSid(rs.getInt("SID"));
				housekeepingAction.setTid(rs.getInt("TID"));
				housekeepingAction.setDescOfFinding(rs.getString("DescOfFinding"));
				housekeepingAction.setCorrectiveAction(rs.getString("CorrectiveAction"));
				housekeepingAction.setByWhom(rs.getString("ByWhom"));
				Timestamp timestamp=rs.getTimestamp("Closed");
				housekeepingAction.setDocument(rs.getString("File"));
				
				if(timestamp!=null){
					housekeepingAction.setClosed(new Date(timestamp.getTime()));
				}
				
				return housekeepingAction;
			}});
		
		
		return housekeepingActions;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeepingAction(int)
	 */
	@Override
	public SafetyHousekeepingAction getSafetyHousekeepingAction(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [safetyHousekeepingAction] where [ID]=? ";
		SafetyHousekeepingAction housekeepingAction=jdbcTemplate.queryForObject(sql, new Object[]{
				id
		},new RowMapper<SafetyHousekeepingAction>(){

			@Override
			public SafetyHousekeepingAction mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeepingAction housekeepingAction=new SafetyHousekeepingAction();
				housekeepingAction.setId(rs.getInt("ID"));
				housekeepingAction.setSid(rs.getInt("SID"));
				housekeepingAction.setTid(rs.getInt("TID"));
				housekeepingAction.setDescOfFinding(rs.getString("DescOfFinding"));
				housekeepingAction.setCorrectiveAction(rs.getString("CorrectiveAction"));
				housekeepingAction.setByWhom(rs.getString("ByWhom"));
				housekeepingAction.setDocument(rs.getString("File"));
				return housekeepingAction;
			}});
		
		return housekeepingAction;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#deleteAction(int)
	 */
	@Override
	public void deleteAction(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [safetyHousekeepingAction] set [Deleted]=? where [ID]=? ";
		jdbcTemplate.update(sql, new Object[]{true,id});
	}

	
	@Override
	public void closeAction(SafetyHousekeepingAction housekeepingAction) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [safetyHousekeepingAction] set [Closed]=?,[ClosedBy]=?  where [ID]=? ";
		jdbcTemplate.update(sql, new Object[]{
				new Timestamp(housekeepingAction.getClosed().getTime()),
				housekeepingAction.getClosedBy(),
				housekeepingAction.getId()
		});
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#checkStandard(int, boolean)
	 */
	@Override
	public void checkTaskStandard(int sid,SafetyHousekeepingTask housekeepingTask, boolean checked) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String ids=null;
		
		if(checked){
			//Add to checked list
			List<Integer> integers=housekeepingTask.getCompletedIds();
			if(!integers.contains(sid)){
				integers.add(sid);
			}
			ids=StringUtils.join(integers, "-");
		}else{
			// Remove from checked list
			List<Integer> integers=housekeepingTask.getCompletedIds();
			if(integers.contains(sid)){
				boolean flag=integers.remove(new Integer(sid));
				if(flag){
					System.out.println("Removed ID from task completed;");
				}
			}
			ids=StringUtils.join(integers, "-");
		}
		
		String sql="update [safetyHousekeepingTask] set [Completed]=? where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{ids,housekeepingTask.getId()});
		
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeepingAndActions(java.lang.String)
	 */
	@Override
	public List<SafetyHousekeeping> getSafetyHousekeepingAndActions(final int taskId) {
		final JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [safetyHousekeepingStd] where [Deleted]=?";
		List<SafetyHousekeeping> housekeepings=jdbcTemplate.query(sql, new Object[]{false},new RowMapper<SafetyHousekeeping>(){

			@Override
			public SafetyHousekeeping mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeeping housekeeping=new SafetyHousekeeping();
				housekeeping.setId(rs.getInt("ID"));
				housekeeping.setDescription(rs.getString("Description"));
				housekeeping.setType(rs.getString("Type"));
			
				
				
				
				//
				String sql="select * from [safetyHousekeepingAction] where [Deleted]=? and  [SID]=? and  [TID]=? "
						+ " order by [Date]";
				List<SafetyHousekeepingAction> housekeepingActions=jdbcTemplate.query(sql, new Object[]{
						false,housekeeping.getId(),taskId,
				},new RowMapper<SafetyHousekeepingAction>(){

					@Override
					public SafetyHousekeepingAction mapRow(ResultSet rs, int arg1)
							throws SQLException {
						SafetyHousekeepingAction housekeepingAction=new SafetyHousekeepingAction();
						housekeepingAction.setId(rs.getInt("ID"));
						housekeepingAction.setSid(rs.getInt("SID"));
						
						housekeepingAction.setDescOfFinding(rs.getString("DescOfFinding"));
						housekeepingAction.setCorrectiveAction(rs.getString("CorrectiveAction"));
						housekeepingAction.setByWhom(rs.getString("ByWhom"));
						Timestamp timestamp=rs.getTimestamp("Closed");
						
						if(timestamp!=null){
							housekeepingAction.setClosed(new Date(timestamp.getTime()));
						}
						housekeepingAction.setClosedBy(rs.getString("ClosedBy"));
						housekeepingAction.setDocument(rs.getString("File"));
						
						return housekeepingAction;
					}});
				
				
				
				housekeeping.setActions(housekeepingActions);
				
				return housekeeping;
			}
			
		});
		
		
		return housekeepings;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeepingTask(int)
	 */
	@Override
	public SafetyHousekeepingTask getSafetyHousekeepingTask(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select t.*, a.[name] as [AreaName],u.[name] as [AuditorName]"
				+ " from [safetyHousekeepingTask] t, [area] a, [userAuditor] u "
				+ "where t.[ID]=? and  a.[ID]=t.[area] and u.[ID]=t.[Auditor]";
		SafetyHousekeepingTask housekeepingTask=jdbcTemplate.queryForObject(sql,new Object[]{
				id
			},new RowMapper<SafetyHousekeepingTask>(){

				@Override
				public SafetyHousekeepingTask mapRow(ResultSet rs, int arg1)
						throws SQLException {
					SafetyHousekeepingTask housekeepingTask=new SafetyHousekeepingTask();
					housekeepingTask.setArea(rs.getInt("Area"));
					housekeepingTask.setAuditor(rs.getInt("Auditor"));
					housekeepingTask.setDate(new Date(rs.getTimestamp("Date").getTime()));
					housekeepingTask.setCompleted(rs.getString("Completed"));
					housekeepingTask.setAreaName(rs.getString("AreaName"));
					housekeepingTask.setAuditorName(rs.getString("AuditorName"));
					housekeepingTask.setId(rs.getInt("ID"));
					
					return housekeepingTask;
				}
			
		});
		return housekeepingTask;
	}

	
	@Override
	public int saveOrUpdate(final SafetyHousekeepingTask housekeepingTask) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int id=0;
		
		if(housekeepingTask.getId()==0){
			KeyHolder holder=new GeneratedKeyHolder();
			
			final String sql="insert into [safetyHousekeepingTask]("
					+ "[Area],"
					+ "[Auditor],"
					+ "[Date],"
					+"[GenKeyID] "
					+ ") values(?,?,?,?)";
			try {
				jdbcTemplate.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection arg0)
							throws SQLException {
						PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
						
						statement.setInt(1, housekeepingTask.getArea());
						statement.setInt(2, housekeepingTask.getAuditor());
						statement.setTimestamp(3, new Timestamp(housekeepingTask.getDate().getTime()));
						statement.setString(4, housekeepingTask.getGenKeyId());
						
						return statement;
					}
				}, holder);
			} catch (Exception e) {
				e.printStackTrace();
			}
			id=holder.getKey().intValue();
		}else{
			String sql="update [safetyHousekeepingTask] set "
					+ "[Area]=?,"
					+ "[Auditor]=?,"
					+ "[Date]=?,"
					+ "[GenKeyID]=? "
					+ " where [ID]=? "
					+ "";
			jdbcTemplate.update(sql, new Object[]{
					housekeepingTask.getArea(),
					housekeepingTask.getAuditor(),
					new Timestamp(housekeepingTask.getDate().getTime()),
					housekeepingTask.getGenKeyId(),
					housekeepingTask.getId()
			});
			
			id=housekeepingTask.getId();
		}
		return id;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#isHousekeepingTaskExist(java.lang.String)
	 */
	@Override
	public SafetyHousekeepingTask isHousekeepingTaskExist(String genKeyId) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [safetyHousekeepingTask] where [GenKeyID]=? ";
		SafetyHousekeepingTask housekeepingTask=null;
		
		try {
			housekeepingTask=jdbcTemplate.queryForObject(sql,new Object[]{
					genKeyId
				},new RowMapper<SafetyHousekeepingTask>(){

					@Override
					public SafetyHousekeepingTask mapRow(ResultSet rs, int arg1)
							throws SQLException {
						SafetyHousekeepingTask housekeepingTask=new SafetyHousekeepingTask();
						housekeepingTask.setArea(rs.getInt("Area"));
						housekeepingTask.setAuditor(rs.getInt("Auditor"));
						housekeepingTask.setDate(new Date(rs.getTimestamp("Date").getTime()));
						housekeepingTask.setId(rs.getInt("ID"));
						housekeepingTask.setCompleted(rs.getString("Completed"));
						
						return housekeepingTask;
					}
				
			});

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		return housekeepingTask;
		
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#saveOrUpdate(com.st.safetylog.model.SafetyHousekeepingSchedule)
	 */
	@Override
	public int saveOrUpdate(final SafetyHousekeepingSchedule housekeepingSchedule)throws Exception {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		int id=0;
		if(housekeepingSchedule.getId()==0){
			final String sql="insert into [safetyHousekeepingSchedule]("
					+ "[Auditor],"
					+ "[Area],"
					+ "[Date],"
					+ "[Recurrence] "
					
					+ ") values(?,?,?,?)";
			KeyHolder keyHolder=new GeneratedKeyHolder();
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql, new String[]{"ID"});
					statement.setInt(1, housekeepingSchedule.getAuditor());
					statement.setInt(2, housekeepingSchedule.getArea());
					statement.setTimestamp(3, new Timestamp(housekeepingSchedule.getDate().getTime()));
					statement.setString(4, housekeepingSchedule.getRecurrence());
			/*		statement.setString(5, housekeepingSchedule.getWeekId());
					statement.setString(6, housekeepingSchedule.getMonthId());*/
					return statement;
				}
			}, keyHolder);
			id=keyHolder.getKey().intValue();
		}else{
			String sql="update [safetyHousekeepingSchedule] set "
					+ "[Auditor]=?,"
					+ "[Area]=?,"
					+ "[Date]=?,"
					+ "[Recurrence]=? "
					+ " where [ID]=? ";
			jdbcTemplate.update(sql, new Object[]{
					housekeepingSchedule.getAuditor(),
					housekeepingSchedule.getArea(),
					new Timestamp(housekeepingSchedule.getDate().getTime()),
					housekeepingSchedule.getRecurrence(),
					housekeepingSchedule.getId()
			});
			
			id=housekeepingSchedule.getId();
		}
		return id;
	}





	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#deleteSechedule(int)
	 */
	@Override
	public void deleteSechedule(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from [safetyHousekeepingSchedule] where [ID]=? ";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeepingSchedules(java.util.Date, java.util.Date, java.lang.String)
	 */
	@Override
	public List<SafetyHousekeepingSchedule> getSafetyHousekeepingSchedules(
			Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select s.*,u.[name] as [AuditorName] from [safetyHousekeepingSchedule] s,[userAuditor] u "
				+ "where (s.[Date] between ? and ?) and s.[Auditor]=u.[ID]";
		List<SafetyHousekeepingSchedule> housekeepingSchedules=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime()),
		},new RowMapper<SafetyHousekeepingSchedule>(){

			@Override
			public SafetyHousekeepingSchedule mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeepingSchedule housekeepingSchedule=new SafetyHousekeepingSchedule();
				housekeepingSchedule.setId(rs.getInt("ID"));
				housekeepingSchedule.setAuditor(rs.getInt("Auditor"));
				housekeepingSchedule.setArea(rs.getInt("Area"));
				Date date=new Date(rs.getTimestamp("Date").getTime());
				housekeepingSchedule.setDate(date);
				housekeepingSchedule.setRecurrence(rs.getString("Recurrence"));
				/*housekeepingSchedule.setWeekId(rs.getString("WeekID"));
				housekeepingSchedule.setMonthId(rs.getString("MonthID"));
				housekeepingSchedule.setDayId(rs.getString("DayID"));*/
				housekeepingSchedule.setAuditStatus(rs.getBoolean("AuditStatus"));
			
				
				housekeepingSchedule.setFormatedDate(new SimpleDateFormat("MM-dd-yyyy").format(date));	
				housekeepingSchedule.setAuditorName(rs.getString("AuditorName"));
				return housekeepingSchedule;
			}
			
		});
		return housekeepingSchedules;
	}

	

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHouseStandard()
	 */
	@Override
	public List<SafetyHousekeepingStdType> getSafetyHouseStandard() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [safetyHousekeepingStdType] where [Deleted]=?";
		List<SafetyHousekeepingStdType> housekeepingStdTypes=jdbcTemplate.query(sql, new Object[]{false}, new RowMapper<SafetyHousekeepingStdType>(){

			@Override
			public SafetyHousekeepingStdType mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeepingStdType housekeepingStdType=new SafetyHousekeepingStdType();
				housekeepingStdType.setId(rs.getString("ID"));
				housekeepingStdType.setName(rs.getString("Name"));
				
				return housekeepingStdType;
			}});
		return housekeepingStdTypes;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#saveOrUpdate(com.st.safetylog.model.SafetyHousekeepingStdType)
	 */
	@Override
	public String saveOrUpdate(SafetyHousekeepingStdType housekeepingStdType) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		
		String key=null;
		
		if(StringUtils.isEmpty(housekeepingStdType.getId())){
			key=housekeepingStdType.getName().replaceAll("\\s+", "").toUpperCase();
			
			String sql="insert into [safetyHousekeepingStdType]([ID],[Name]) values(?,?)";
			jdbcTemplate.update(sql, new Object[]{key,housekeepingStdType.getName()});
			
		}else{
			key=housekeepingStdType.getId();
			String sql="update [safetyHousekeepingStdType] SET [Name]=? where [ID]=?";
			jdbcTemplate.update(sql, new Object[]{housekeepingStdType.getName(),key});
			
		}
		
		return key;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeepingStdType(java.lang.String)
	 */
	@Override
	public SafetyHousekeepingStdType getSafetyHousekeepingStdType(String id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [safetyHousekeepingStdType] where [ID]=?";
		SafetyHousekeepingStdType housekeepingStdType=jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<SafetyHousekeepingStdType>(){

			@Override
			public SafetyHousekeepingStdType mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeepingStdType housekeepingStdType=new SafetyHousekeepingStdType();
				housekeepingStdType.setId(rs.getString("ID"));
				housekeepingStdType.setName(rs.getString("Name"));
				
				return housekeepingStdType;
			}});
		return housekeepingStdType;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#deleteStdType(java.lang.String)
	 */
	@Override
	public void deleteStdType(String id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [safetyHousekeepingStdType] set [Deleted]=? where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{true,id});
	}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getScheduledList(java.util.Date)
	 */
	@Override
	public List<SafetyHousekeepingSchedule> getScheduledList(Date date) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select s.[Date],u.[name] as [Auditor],u.[email] as [Email],a.[name] as [Area] "
				+ " from "
				+ "[safetyHousekeepingSchedule] s, [userAuditor] u, [area] a "
				+ " where s.[Area]=a.[ID] "
				+ " and "
				+ " s.[Auditor]=u.[ID] "
				+ " and "
				+ " u.[Email] is not NULL "
				+ " and "
				+ " [Date]=? ";
		List<SafetyHousekeepingSchedule> housekeepingSchedules=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(date.getTime())
		},new RowMapper<SafetyHousekeepingSchedule>(){

			@Override
			public SafetyHousekeepingSchedule mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeepingSchedule housekeepingSchedule=new SafetyHousekeepingSchedule();
				housekeepingSchedule.setAreaName(rs.getString("Area"));
				housekeepingSchedule.setAuditorName(rs.getString("Auditor"));
				housekeepingSchedule.setAuditorEamil(rs.getString("Email"));
				housekeepingSchedule.setDate(new Date(rs.getTimestamp("Date").getTime()));
				return housekeepingSchedule;
			}
			
		});
		return housekeepingSchedules;
	}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeepingTasks(java.util.Date, java.util.Date)
	 */
	@Override
	public List<SafetyHousekeepingTask> getSafetyHousekeepingTasks(Date sDate,
			Date eDate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select t.*, a.[name] as [AreaName],u.[name] as [AuditorName]"
				+ " from [safetyHousekeepingTask] t, [area] a, [userAuditor] u "
				+ " where (t.[Date] between ? and  ? ) and  a.[ID]=t.[area] and u.[ID]=t.[Auditor]";
	
		
		
		List<SafetyHousekeepingTask> housekeepingTasks=jdbcTemplate.query(sql,new Object[]{
				new Timestamp(sDate.getTime()),
				new Timestamp(eDate.getTime())
			},new RowMapper<SafetyHousekeepingTask>(){

				@Override
				public SafetyHousekeepingTask mapRow(ResultSet rs, int arg1)
						throws SQLException {
					SafetyHousekeepingTask housekeepingTask=new SafetyHousekeepingTask();
					housekeepingTask.setArea(rs.getInt("Area"));
					housekeepingTask.setAuditor(rs.getInt("Auditor"));
					housekeepingTask.setDate(new Date(rs.getTimestamp("Date").getTime()));
					housekeepingTask.setCompleted(rs.getString("Completed"));
					housekeepingTask.setAreaName(rs.getString("AreaName"));
					housekeepingTask.setAuditorName(rs.getString("AuditorName"));
					housekeepingTask.setId(rs.getInt("ID"));
					
					return housekeepingTask;
				}
			
		});
		
		
		return housekeepingTasks;
	}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#scheduleStatus(int, boolean)
	 */
	@Override
	public void scheduleStatus(int id, boolean auditStatus) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [safetyHousekeepingSchedule] set [AuditStatus]=? where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{auditStatus,id});
		
	}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#actionsColosed(int)
	 */
	@Override
	public boolean actionsColosed(int sid,int taskId) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select count(*) from [safetyHousekeepingAction] where [Deleted] =? and [Closed] is NULL and [SID]=? and [TID]=?";
		int count=jdbcTemplate.queryForObject(sql,new Object[]{false,sid,taskId},Integer.class);
		//System.out.println(count);
		if(count==0){
			return true;
		}else{
			return false;
		}
		
	}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#actionsColosed(int)
	 */
	@Override
	public boolean taskExist(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select count(*) from [safetyHousekeepingAction] where [TID]=?";
		int count=jdbcTemplate.queryForObject(sql,new Object[]{id},Integer.class);
		//System.out.println(count);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeepingTasks(java.util.Date, java.util.Date, int, int)
	 */
	@Override
	public List<SafetyHousekeepingTask> getSafetyHousekeepingTasks(Date sdate,
			Date edate, int area, int auditor) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [safetyHousekeepingTask] "
				+ "where "
				+ " [Area]=? "
				+ " and "
				+ " [Auditor]=? "
				+ " and "
				+ " [Date] between ? and ?";
		List<SafetyHousekeepingTask> housekeepingTasks=jdbcTemplate.query(sql, new Object[]{
				area,
				auditor,
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime())
		}, new RowMapper<SafetyHousekeepingTask>(){

			@Override
			public SafetyHousekeepingTask mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeepingTask housekeepingTask=new SafetyHousekeepingTask();
				housekeepingTask.setArea(rs.getInt("Area"));
				housekeepingTask.setAuditor(rs.getInt("Auditor"));
				housekeepingTask.setDate(new Date(rs.getTimestamp("Date").getTime()));
				housekeepingTask.setCompleted(rs.getString("Completed"));
				housekeepingTask.setId(rs.getInt("ID"));
				return housekeepingTask;
			}
			
		});
		return housekeepingTasks;
	}

	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#removeUnwantedTasks(java.util.Date, java.util.Date)
	 */
	@Override
	public void removeUnwantedTasks(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

		
		String sql="select * from [safetyHousekeepingTask] "
				+ "where "
				+ " [Date] between ? and ?";
		List<SafetyHousekeepingTask> housekeepingTasks=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime())
		}, new RowMapper<SafetyHousekeepingTask>(){

			@Override
			public SafetyHousekeepingTask mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeepingTask housekeepingTask=new SafetyHousekeepingTask();
				housekeepingTask.setArea(rs.getInt("Area"));
				housekeepingTask.setAuditor(rs.getInt("Auditor"));
				housekeepingTask.setDate(new Date(rs.getTimestamp("Date").getTime()));
				housekeepingTask.setCompleted(rs.getString("Completed"));
				housekeepingTask.setId(rs.getInt("ID"));
				return housekeepingTask;
			}
			
		});
		for (SafetyHousekeepingTask safetyHousekeepingTask : housekeepingTasks) {
			if(StringUtils.isEmpty(safetyHousekeepingTask.getCompleted())){
				String sql2="select count(*) from [safetyHousekeepingAction] where [TID]=?";
				int count=jdbcTemplate.queryForObject(sql2,new Object[]{safetyHousekeepingTask.getId()},Integer.class);
				if(count==0){
					String sql3="delete from [safetyHousekeepingTask] where [ID]=?";
					jdbcTemplate.update(sql3, new Object[]{safetyHousekeepingTask.getId()});
				//	System.out.println("Task Removed ="+safetyHousekeepingTask.getId());
				}
			}
		}
	}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#deleteTask(int)
	 */
	@Override
	public void deleteTask(int taskId) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql1="delete from [safetyHousekeepingAction] where [TID]=?";
		jdbcTemplate.update(sql1, new Object[]{taskId});
		
		String sql="delete from [safetyHousekeepingTask] where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{taskId});
	}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeepingOpen()
	 */
	@Override
	public List<SafetyHousekeeping> getSafetyHousekeepingOpen(int area,
			int auditor, String bywhom) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT h.[ID],h.[Description],t.[Name] as [Type] FROM safetyHousekeepingStd h,safetyHousekeepingStdType t where t.[ID]=h.[Type] and t.[Deleted]=0 and h.[Deleted]=0 order by t.[ID] ";
		List<SafetyHousekeeping> housekeepings=jdbcTemplate.query(sql,new RowMapper<SafetyHousekeeping>(){

			@Override
			public SafetyHousekeeping mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeeping housekeeping=new SafetyHousekeeping();
				housekeeping.setId(rs.getInt("ID"));
				housekeeping.setDescription(rs.getString("Description"));
				housekeeping.setType(rs.getString("Type"));
				
				return housekeeping;
			}
			
		});
		
		
		String sql2="SELECT "
				+ "	a.[ID],a.[DescOfFinding],a.[CorrectiveAction],a.[ByWhom],a.[TID],a.[SID],a.[File], "
				+ " t.[Date],ar.[name] as [AreaName],u.[name]  as [AuditorName] "
				+ " FROM [safetyHousekeepingAction] a,[safetyHousekeepingTask] t,[userAuditor] u,[area] ar "
				+ " where "
				+ " t.[ID]=a.[TID] and a.[deleted]=0 and u.[ID]=t.[Auditor] and ar.[ID]=t.[Area] and a.[Closed] is NULL ";
		
		//System.out.println(sql2);
		
		Object[] params=null;
		
		if(area>0 && auditor>0 && StringUtils.isNotEmpty(bywhom)){
			sql2+=" and t.[Area]=? and t.[Auditor]=? and a.[ByWhom]=? ";
			params=new Object[]{area,auditor,bywhom};
		}else if(area==0 && auditor>0 && StringUtils.isNotEmpty(bywhom)){
			sql2+=" and t.[Auditor]=? and a.[ByWhom]=? ";
			params=new Object[]{auditor,bywhom};
		}else if(area>0 && auditor==0 && StringUtils.isNotEmpty(bywhom)){
			sql2+=" and t.[Area]=? and a.[ByWhom]=? ";
			params=new Object[]{area,bywhom};
		}else if(area>0 && auditor>0 && StringUtils.isEmpty(bywhom)){
			sql2+=" and t.[Area]=? and t.[Auditor]=?  ";
			params=new Object[]{area,auditor};
		}else if(area>0 && auditor==0 && StringUtils.isEmpty(bywhom)){
			sql2+=" and t.[Area]=?  ";
			params=new Object[]{area};
		}else if(area==0 && auditor>0 && StringUtils.isEmpty(bywhom)){
			sql2+=" and  t.[Auditor]=? ";
			params=new Object[]{auditor};
		}else if(area==0 && auditor==0 && StringUtils.isNotEmpty(bywhom)){
			sql2+=" and  a.[ByWhom]=? ";
			params=new Object[]{bywhom};
		}else{
			params=new Object[]{};
		}
		
		sql2+=" order by t.[Date] ";
		
		List<SafetyHousekeepingAction> housekeepingActions=jdbcTemplate.query(sql2,params,new RowMapper<SafetyHousekeepingAction>(){

			@Override
			public SafetyHousekeepingAction mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeepingAction housekeepingAction=new SafetyHousekeepingAction();
				housekeepingAction.setId(rs.getInt("ID"));
				housekeepingAction.setSid(rs.getInt("SID"));
				housekeepingAction.setTid(rs.getInt("TID"));
				housekeepingAction.setDescOfFinding(rs.getString("DescOfFinding"));
				housekeepingAction.setCorrectiveAction(rs.getString("CorrectiveAction"));
				housekeepingAction.setByWhom(rs.getString("ByWhom"));
				housekeepingAction.setDate(new Date(rs.getDate("Date").getTime()));
				housekeepingAction.setAreaName(rs.getString("AreaName"));
				housekeepingAction.setAuditorName(rs.getString("AuditorName"));
				housekeepingAction.setDocument(rs.getString("File"));
				
				int days=CommonUtil.getDaysDiffernce(housekeepingAction.getDate(), new Date());
				housekeepingAction.setDays(days);
				
				
				return housekeepingAction;
			}});
		
		
		for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
			List<SafetyHousekeepingAction> actions=new ArrayList<>();
			for (SafetyHousekeepingAction safetyHousekeepingAction : housekeepingActions) {
				if(safetyHousekeeping.getId()==safetyHousekeepingAction.getSid()){
					actions.add(safetyHousekeepingAction);
				}
			}
			safetyHousekeeping.setActions(actions);
		}
		
		return housekeepings;
	}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeepingClosedItem(java.util.Date, java.util.Date)
	 */
	@Override
	public List<SafetyHousekeeping> getSafetyHousekeepingClosedItem(Date sdate,
			Date edate) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT h.[ID],h.[Description],t.[Name] as [Type] FROM safetyHousekeepingStd h,safetyHousekeepingStdType t where t.[ID]=h.[Type] and t.[Deleted]=0 and h.[Deleted]=0 order by t.[ID] ";
		List<SafetyHousekeeping> housekeepings=jdbcTemplate.query(sql,new RowMapper<SafetyHousekeeping>(){

			@Override
			public SafetyHousekeeping mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeeping housekeeping=new SafetyHousekeeping();
				housekeeping.setId(rs.getInt("ID"));
				housekeeping.setDescription(rs.getString("Description"));
				housekeeping.setType(rs.getString("Type"));
				
				return housekeeping;
			}
			
		});
		
		
		String sql2="SELECT "
				+ "	a.[ID],a.[DescOfFinding],a.[CorrectiveAction],a.[ByWhom],a.[TID],a.[SID],a.[Closed],a.[File],  "
				+ " t.[Date],ar.[name] as [AreaName],ar.[ID] as [AreaId],ar.[type] as [AreaType],u.[name]  as [AuditorName] "
				+ " FROM [safetyHousekeepingAction] a,[safetyHousekeepingTask] t,[userAuditor] u,[area] ar "
				+ " where "
				+ " t.[ID]=a.[TID] and a.[deleted]=0 and u.[ID]=t.[Auditor] and ar.[ID]=t.[Area] and a.[Closed] is not NULL "
				+ " and  (t.[Date] between ? and ? )"
				+ " order by t.[Date] ";
		
		
		
		
		
		List<SafetyHousekeepingAction> housekeepingActions=jdbcTemplate.query(sql2,new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime())
		},new RowMapper<SafetyHousekeepingAction>(){

			@Override
			public SafetyHousekeepingAction mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeepingAction housekeepingAction=new SafetyHousekeepingAction();
				housekeepingAction.setId(rs.getInt("ID"));
				housekeepingAction.setSid(rs.getInt("SID"));
				housekeepingAction.setTid(rs.getInt("TID"));
				housekeepingAction.setDescOfFinding(rs.getString("DescOfFinding"));
				housekeepingAction.setCorrectiveAction(rs.getString("CorrectiveAction"));
				housekeepingAction.setByWhom(rs.getString("ByWhom"));
				housekeepingAction.setDate(new Date(rs.getDate("Date").getTime()));
				housekeepingAction.setAreaName(rs.getString("AreaName"));
				housekeepingAction.setAuditorName(rs.getString("AuditorName"));
				housekeepingAction.setClosed(new Date(rs.getDate("Closed").getTime()));
				housekeepingAction.setArea(rs.getInt("AreaId"));
				housekeepingAction.setAreaType(rs.getInt("AreaType"));
				housekeepingAction.setDocument(rs.getString("File"));
				
				int days=CommonUtil.getDaysDiffernce(housekeepingAction.getDate(), housekeepingAction.getClosed());
				housekeepingAction.setDays(days);
				
				
				return housekeepingAction;
			}});
		
		
		for (SafetyHousekeeping safetyHousekeeping : housekeepings) {
			List<SafetyHousekeepingAction> actions=new ArrayList<>();
			for (SafetyHousekeepingAction safetyHousekeepingAction : housekeepingActions) {
				if(safetyHousekeeping.getId()==safetyHousekeepingAction.getSid()){
					actions.add(safetyHousekeepingAction);
				}
			}
			safetyHousekeeping.setActions(actions);
		}
		
		return housekeepings;
	}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getSafetyHousekeepingAuditSchedulesStatus(java.util.Date, java.util.Date)
	 */
	@Override
	public List<SafetyHousekeepingSchedule> getSafetyHousekeepingAuditSchedulesStatus(Date sdate, Date edate) {

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="SELECT s.*, u.[name] AS AuditorName FROM safetyHousekeepingSchedule AS s, userAuditor AS u WHERE (s.[Date] between ? and ?) and s.[Auditor]=u.[ID];";
		List<SafetyHousekeepingSchedule> codes=jdbcTemplate.query(sql,new Object[]{sdate,edate}, new SafetyHousekeepingSchedulesStatusMapper());
		return codes;
		}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#getauditerDetails(int)
	 */
	@Override
	public List<SafetyHousekeepingSchedule> getauditerDetails(int auditorId) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="SELECT * FROM userAuditor where id=?;";
		List<SafetyHousekeepingSchedule> housekeepingTasks=jdbcTemplate.query(sql, new Object[]{
				auditorId
		}, new RowMapper<SafetyHousekeepingSchedule>(){

			@Override
			public SafetyHousekeepingSchedule mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SafetyHousekeepingSchedule housekeepingTask=new SafetyHousekeepingSchedule();
				housekeepingTask.setAuditorName(rs.getString("name"));
				housekeepingTask.setAuditorEamil(rs.getString("email"));

				return housekeepingTask;
			}
			
		});
		return housekeepingTasks;
	}
	/* (non-Javadoc)
	 * @see com.st.safetylog.dao.SafetyHousekeepingDao#positiveStatus(java.util.Date, boolean, java.lang.String)
	 */
	@Override
	public void positiveStatus(Date date, boolean auditStatus, String auditorId) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);	
		String dt=new SimpleDateFormat("MM-dd-yyyy").format(date);
		List<PositiveObservation> list= getpositiveStatus( date,date);
		String sql="";int i=0;
		for(PositiveObservation l:list) {			
		if(l.getDate().equals(dt)&&l.getAuditorId().equals(auditorId))
		{			
			sql="update [positiveObservations]  set"
					+"[date]=? ,"
					 +"[auditStatus]=?,"
					+"[auditorId]=? "
					 +"where [id]=?";
			i= jdbcTemplate.update(sql, new Object[]{date,auditStatus,auditorId,l.getId()});
			 
		}
	}
		if(i<=0) {
			sql="insert into [positiveObservations]"
					+"([date],[auditStatus],[auditorId])"
					+"values(?,?,?)";
			jdbcTemplate.update(sql, new Object[]{date,auditStatus,auditorId});	
		}
	
}
	
	@Override
	public List<PositiveObservation> getpositiveStatus(Date sdate, Date edate) {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="SELECT * FROM positiveObservations  where date between ? and ?;";
		List<PositiveObservation> positiveobservation=jdbcTemplate.query(sql, new Object[]{sdate,edate}, new RowMapper<PositiveObservation>(){

			@Override
			public PositiveObservation mapRow(ResultSet rs, int arg1)
					throws SQLException {
				PositiveObservation po=new PositiveObservation();
				po.setId(rs.getInt("id"));
				po.setDate(new SimpleDateFormat("MM-dd-yyyy").format(rs.getDate("date")));
				//po.setDate(rs.getDate("date"));
				po.setAuditStatus(rs.getBoolean("auditStatus"));
				po.setAuditorId(rs.getString("auditorId"));

				return po;
			}
			
		});
		return positiveobservation;
	}
	
}