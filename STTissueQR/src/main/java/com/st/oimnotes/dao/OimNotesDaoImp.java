/**
 * 
 */
package com.st.oimnotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
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
import com.st.oimnotes.model.Category;
import com.st.oimnotes.model.FollowUp;
import com.st.oimnotes.model.FollowUpHistory;
import com.st.oimnotes.model.Summary;

/**
 * @author sbora
 *
 */
@Repository
public class OimNotesDaoImp implements OimNotesDao {

	@Autowired
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#saveOrUpdate(com.st.oimnotes.model.Category)
	 */
	@Override
	public void saveOrUpdate(Category category) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		if(category.getId()>0){
			
			String sql="update [oimNotesCategory] set [Category]=? where [ID]=?";
			jdbcTemplate.update(sql, new Object[]{category.getCategory(),category.getId()});
			
		}else{
			String sql="insert into [oimNotesCategory]([Category]) values(?)";
			jdbcTemplate.update(sql, new Object[]{category.getCategory()});
		}
		
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getCategory()
	 */
	@Override
	public List<Category> getCategory() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [oimNotesCategory]";
		
		List<Category> categories=jdbcTemplate.query(sql, new RowMapper<Category>(){

			@Override
			public Category mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Category category=new Category();
				category.setId(rs.getInt("ID"));
				category.setCategory(rs.getString("Category"));
				return category;
			}
			
		});
		
		return categories;
	}
	
	@Override
	public Category getCategory(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="select * from [oimNotesCategory] where [ID]=?";
		
		Category category=jdbcTemplate.queryForObject(sql,new Object[]{id}, new RowMapper<Category>(){

			@Override
			public Category mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Category category=new Category();
				category.setId(rs.getInt("ID"));
				category.setCategory(rs.getString("Category"));
				return category;
			}
			
		});
		
		return category;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#saveOrUpdate(com.st.oimnotes.model.Summary)
	 */
	@Override
	public void saveOrUpdate(Summary summary) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		if(summary.getId()>0){
			String sql="update [oimNotesSummary] set "
					+ "[Summary]=?,"
					+ "[EntryDate]=?,"
					+ "[Category]=? "
					+ "where "
					+ "[ID]=?"
					+ "";
			jdbcTemplate.update(sql, new Object[]{
					summary.getSummary(),
					new Timestamp(summary.getEntryDate().getTime()),
					summary.getCategoryId(),
					summary.getId()});
		}else{
			String sql="insert into [oimNotesSummary]("
					+ "[Summary],"
					+ "[EntryDate],"
					+ "[Category]"
					+ ") values(?,?,?)";
				
			jdbcTemplate.update(sql, new Object[]{
					summary.getSummary(),
					new Timestamp(summary.getEntryDate().getTime()),
					summary.getCategoryId()
					});
		}
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getSummaries(int, java.util.Date)
	 */
	@Override
	public List<Summary> getSummaries(int categoryId, Date date,Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="SELECT s.[ID] as [Sid],s.[EntryDate],s.[Summary],c.[ID] as [Cid], c.[Category] as [Category] "
				+ "FROM [oimNotesSummary] s, [oimNotesCategory] c "
				+ "where "
				+ "c.[ID]= s.[Category] "
				+ "and "
				+ "s.[Category]=? "
				+ "and "
				+ "(s.[EntryDate] between ? and ? ) "
				+ "and "
				+ "s.[Deleted]=? order by [ID]";
		List<Summary> summaries=jdbcTemplate.query(sql, new Object[]{categoryId,
				new Timestamp(date.getTime()),
				new Timestamp(edate.getTime()),
				false}, new RowMapper<Summary>(){

			@Override
			public Summary mapRow(ResultSet rs, int arg1) throws SQLException {
				Summary summary=new Summary();
				summary.setId(rs.getInt("Sid"));
				summary.setSummary(rs.getString("Summary"));
				summary.setCategoryId(rs.getInt("Cid"));
				summary.setCategory(rs.getString("Category"));
				summary.setEntryDate(new Date(rs.getTimestamp("EntryDate").getTime()));
				return summary;
			}
			
		});
		
		return summaries;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getSummary(int)
	 */
	@Override
	public Summary getSummary(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="SELECT s.[ID] as [SID] ,s.[Summary],s.[EntryDate],s.[Category] as [CategoryID], c.[Category] "
				+ " FROM oimNotesSummary s,oimNotesCategory c "
				+ " where s.[ID]=? "
				+ " and "
				+ " c.[ID]=s.[Category] ";
		
		Summary summary=jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Summary>(){

			@Override
			public Summary mapRow(ResultSet rs, int arg1) throws SQLException {
				Summary summary=new Summary();
				summary.setId(rs.getInt("SID"));
				summary.setSummary(rs.getString("Summary"));
				summary.setCategoryId(rs.getInt("CategoryID"));
				summary.setEntryDate(new Timestamp(rs.getDate("EntryDate").getTime()));
				summary.setCategory(rs.getString("Category"));
				return summary;
			}
			
		});
		return summary;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#deleteSummary(int)
	 */
	@Override
	public void deleteSummary(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="update [oimNotesSummary] set [Deleted]=? where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{true,id});
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#saveOrUpdate(com.st.oimnotes.model.FollowUp)
	 */
	@Override
	public void saveOrUpdate(final FollowUp followUpOb) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		int id=0;
		
		
		if(followUpOb.getId()>0){
						jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {

					
					
					if(StringUtils.isEmpty(followUpOb.getFile())){
						
						String sql="update [oimNotesFollowUp] set "
								+ "[FollowUp]=?,"
								+ "[Responsibility]=?,"
								+ "[Timeline]=?,"
								+ "[SummaryID]=?,"
								+ "[entryDate]=?,"
								+ "[Recurrance]=?,"
								+ "[TagColor]=? "
								+ " where "
								+ "[ID]=?";
						
						PreparedStatement statement=arg0.prepareStatement(sql);
						
						statement.setString(1, followUpOb.getFollowUp());
						statement.setString(2, followUpOb.getResponsibility());
						if(followUpOb.getTimeline()==null){
							statement.setNull(3, Types.TIMESTAMP);
						}else{
							statement.setTimestamp(3, new Timestamp(followUpOb.getTimeline().getTime()));
						}
						statement.setInt(4, followUpOb.getSummaryId());
						statement.setTimestamp(5, new Timestamp(followUpOb.getEntryDate().getTime()));
						statement.setString(6, followUpOb.getRecurrence());
						statement.setString(7, followUpOb.getTagColor());
						statement.setInt(8, followUpOb.getId());

						return statement;
					}else{
						String sql="update [oimNotesFollowUp] set "
								+ "[FollowUp]=?,"
								+ "[Responsibility]=?,"
								+ "[Timeline]=?,"
								+ "[SummaryID]=?,"
								+ "[entryDate]=?,"
								+ "[Recurrance]=?,"
								+ "[TagColor]=?,"
								+ "[File]=? "
								+ " where "
								+ "[ID]=?";
						
						PreparedStatement statement=arg0.prepareStatement(sql);
						
						statement.setString(1, followUpOb.getFollowUp());
						statement.setString(2, followUpOb.getResponsibility());
						if(followUpOb.getTimeline()==null){
							statement.setNull(3, Types.TIMESTAMP);
						}else{
							statement.setTimestamp(3, new Timestamp(followUpOb.getTimeline().getTime()));
						}
						statement.setInt(4, followUpOb.getSummaryId());
						statement.setTimestamp(5, new Timestamp(followUpOb.getEntryDate().getTime()));
						statement.setString(6, followUpOb.getRecurrence());
						statement.setString(7, followUpOb.getTagColor());
						statement.setString(8, followUpOb.getFile());
						statement.setInt(9, followUpOb.getId());
						

						return statement;
					}
					

					
					
					
				}
			});
			id=followUpOb.getId();
		}else{
			KeyHolder holder=new GeneratedKeyHolder();
			
			final String sql="insert into [oimNotesFollowUp]("
					+ "[FollowUp],"
					+ "[Responsibility],"
					+ "[Timeline],"
					+ "[SummaryID],"
					+ "[entryDate],"
					+ "[Recurrance],"
					+ "[TagColor],[File] "
					+ ") values(?,?,?,?,?,?,?,?)";
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql,new String[]{"ID"});
					
					statement.setString(1, followUpOb.getFollowUp());
					statement.setString(2, followUpOb.getResponsibility());
					if(followUpOb.getTimeline()==null){
						statement.setNull(3, Types.TIMESTAMP);
					}else{
						statement.setTimestamp(3, new Timestamp(followUpOb.getTimeline().getTime()));
					}
					statement.setInt(4, followUpOb.getSummaryId());
					statement.setTimestamp(5, new Timestamp(followUpOb.getEntryDate().getTime()));
					statement.setString(6, followUpOb.getRecurrence());
					statement.setString(7, followUpOb.getTagColor());
					statement.setString(8, followUpOb.getFile());
					
					return statement;
				}
			},holder);
			
			id=holder.getKey().intValue();
		}
		
		if(id>0){
			String sql="insert into [oimNotesFollowUpHistory]("
					+ "[FollowUp],"
					+ "[LastUpdated],"
					+ "[Notes],"
					+ "[FID] "
					+ ") values(?,?,?,?)";
			
			StringBuilder builder=new StringBuilder();
			builder.append("<b>Follow Up:-</b>");
			builder.append(followUpOb.getFollowUp()==null?"":followUpOb.getFollowUp());
			builder.append("<br>");
			builder.append("<b>Responsibility:-</b>");
			builder.append(followUpOb.getResponsibility()==null?"":followUpOb.getResponsibility());
			builder.append("<br>");
			builder.append("<b>Timeline:-</b>");
			builder.append(followUpOb.getTimeline()==null?"":new SimpleDateFormat("MM-dd-yyyy").format(followUpOb.getTimeline()));
			builder.append("<br>");
			builder.append("<b>Recurrence:-</b>");
			builder.append(followUpOb.getRecurrence()==null?"":followUpOb.getRecurrence());
			
			jdbcTemplate.update(sql, new Object[]{
					builder.toString(),
					new Timestamp(new Date().getTime()),
					followUpOb.getNoteHistory(),
					id
			});
			
		}
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getFollowUps(int)
	 */
	@Override
	public List<FollowUp> getFollowUps(int sid) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [oimNotesFollowUp] where [SummaryID]=? and [Deleted]=? and [Closed] is NULL";
		
		List<FollowUp> followUps=jdbcTemplate.query(sql, new Object[]{sid,false}, new RowMapper<FollowUp>(){

			@Override
			public FollowUp mapRow(ResultSet rs, int arg1)
					throws SQLException {
				FollowUp followUp=new FollowUp();
				followUp.setId(rs.getInt("ID"));
				followUp.setSummaryId(rs.getInt("SummaryID"));
				followUp.setFollowUp(rs.getString("FollowUp"));
				followUp.setResponsibility(rs.getString("Responsibility"));
				followUp.setEntryDate(new Date(rs.getTimestamp("entryDate").getTime()));
				Timestamp timeline=rs.getTimestamp("Timeline");
				if(timeline!=null){
					followUp.setTimeline(new Date(timeline.getTime()));	
				}
				
				followUp.setRecurrence(rs.getString("Recurrance"));
				followUp.setTagColor(rs.getString("TagColor"));
				followUp.setFile(rs.getString("File"));
				
				return followUp;
			}
			
		});
		
		return followUps;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getFollowUp(int)
	 */
	@Override
	public FollowUp getFollowUp(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [oimNotesFollowUp] where [ID]=? and [Deleted]=? ";
		
		FollowUp followUp=jdbcTemplate.queryForObject(sql, new Object[]{id,false}, new RowMapper<FollowUp>(){

			@Override
			public FollowUp mapRow(ResultSet rs, int arg1)
					throws SQLException {
				FollowUp followUp=new FollowUp();
				followUp.setId(rs.getInt("ID"));
				followUp.setSummaryId(rs.getInt("SummaryID"));
				followUp.setFollowUp(rs.getString("FollowUp"));
				followUp.setResponsibility(rs.getString("Responsibility"));
				followUp.setEntryDate(new Date(rs.getTimestamp("entryDate").getTime()));
				Timestamp timeline=rs.getTimestamp("Timeline");
				if(timeline!=null){
					followUp.setTimeline(new Date(timeline.getTime()));	
				}
				followUp.setRecurrence(rs.getString("Recurrance"));
				followUp.setTagColor(rs.getString("TagColor"));
				followUp.setFile(rs.getString("File"));
				
				return followUp;
			}
			
		});
		
		return followUp;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#deleteFollowUp(int)
	 */
	@Override
	public void deleteFollowUp(int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="update [oimNotesFollowUp] set [Deleted]=? where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{true,id});
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getSummariesAll()
	 */
	@Override
	public List<Summary> getSummariesAll(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="SELECT s.[ID] as [Sid],s.[EntryDate],s.[Summary],c.[ID] as [Cid], c.[Category] as [Category] "
				+ "FROM [oimNotesSummary] s, [oimNotesCategory] c "
				+ "where "
				+ "c.[ID]= s.[Category] "
				+ "and "
				+ "(s.[EntryDate] between ? and ? ) "
				+ "and "
				+ "s.[Deleted]=? order by [EntryDate]";
		List<Summary> summaries=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime()),
				false
				}, new RowMapper<Summary>(){

			@Override
			public Summary mapRow(ResultSet rs, int arg1) throws SQLException {
				Summary summary=new Summary();
				summary.setId(rs.getInt("Sid"));
				summary.setSummary(rs.getString("Summary"));
				summary.setCategoryId(rs.getInt("Cid"));
				summary.setCategory(rs.getString("Category"));
				summary.setEntryDate(new Date(rs.getTimestamp("EntryDate").getTime()));
				return summary;
			}
			
		});
		
		return summaries;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getSummariesFolloUps(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Summary> getSummariesFolloUps(Date sdate, Date edate) {
final JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="SELECT s.[ID] as [Sid],s.[EntryDate],s.[Summary],c.[ID] as [Cid], c.[Category] as [Category] "
				+ "FROM [oimNotesSummary] s, [oimNotesCategory] c "
				+ "where "
				+ "c.[ID]= s.[Category] "
				+ "and "
				+ "(s.[EntryDate] between ? and ? ) "
				+ "and "
				+ "s.[Deleted]=? order by [EntryDate]";
		List<Summary> summaries=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime()),
				false
				}, new RowMapper<Summary>(){

			@Override
			public Summary mapRow(ResultSet rs, int arg1) throws SQLException {
				Summary summary=new Summary();
				summary.setId(rs.getInt("Sid"));
				summary.setSummary(rs.getString("Summary"));
				summary.setCategoryId(rs.getInt("Cid"));
				summary.setCategory(rs.getString("Category"));
				summary.setEntryDate(new Date(rs.getTimestamp("EntryDate").getTime()));
				
				String sql="select * from [oimNotesFollowUp] where [SummaryID]=? and [Deleted]=? ";
				
				List<FollowUp> followUps=jdbcTemplate.query(sql, new Object[]{summary.getId(),false}, new RowMapper<FollowUp>(){

					@Override
					public FollowUp mapRow(ResultSet rs, int arg1)
							throws SQLException {
						FollowUp followUp=new FollowUp();
						followUp.setId(rs.getInt("ID"));
						followUp.setSummaryId(rs.getInt("SummaryID"));
						followUp.setFollowUp(rs.getString("FollowUp"));
						followUp.setResponsibility(rs.getString("Responsibility"));
						followUp.setEntryDate(new Date(rs.getTimestamp("entryDate").getTime()));
						Timestamp timeline=rs.getTimestamp("Timeline");
						if(timeline!=null){
							followUp.setTimeline(new Date(timeline.getTime()));	
						}
						
						followUp.setRecurrence(rs.getString("Recurrance"));
						Timestamp closed=rs.getTimestamp("Closed");
						if(closed!=null){
							followUp.setClosed(new Date(closed.getTime()));
						}
						followUp.setClosedBy(rs.getString("ClosedBy"));
						followUp.setTagColor(rs.getString("TagColor"));
						
						
						try {
							String sql="select count(*) from [oimNotesFollowUpHistory] where [FID]=?";
							Integer integer=jdbcTemplate.queryForObject(sql,new Object[]{followUp.getId()}, Integer.class);
							if(integer==null){
								followUp.setHistoryCount(0);
							}else{
								followUp.setHistoryCount(integer);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						return followUp;
					}
					
				});
				summary.setFollowUps(followUps);
				return summary;
			}
			
		});
		return summaries;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getSummariesFolloUps(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Summary> getSummariesFolloUps(int category, Date sdate,
			Date edate) {
		final JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="SELECT s.[ID] as [Sid],s.[EntryDate],s.[Summary],c.[ID] as [Cid], c.[Category] as [Category] "
				+ "FROM [oimNotesSummary] s, [oimNotesCategory] c "
				+ "where "
				+ "c.[ID]= s.[Category] "
				+ "and "
				+ "s.[Category]=? "
				+ "and "
				+ "(s.[EntryDate] between ? and ? ) "
				+ "and "
				+ "s.[Deleted]=? order by [EntryDate]";
		List<Summary> summaries=jdbcTemplate.query(sql, new Object[]{
				category,
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime()),
				false
				}, new RowMapper<Summary>(){

			@Override
			public Summary mapRow(ResultSet rs, int arg1) throws SQLException {
				Summary summary=new Summary();
				summary.setId(rs.getInt("Sid"));
				summary.setSummary(rs.getString("Summary"));
				summary.setCategoryId(rs.getInt("Cid"));
				summary.setCategory(rs.getString("Category"));
				summary.setEntryDate(new Date(rs.getTimestamp("EntryDate").getTime()));
				
				String sql="select * from [oimNotesFollowUp] where [SummaryID]=? and [Deleted]=? ";
				
				List<FollowUp> followUps=jdbcTemplate.query(sql, new Object[]{summary.getId(),false}, new RowMapper<FollowUp>(){

					@Override
					public FollowUp mapRow(ResultSet rs, int arg1)
							throws SQLException {
						FollowUp followUp=new FollowUp();
						followUp.setId(rs.getInt("ID"));
						followUp.setSummaryId(rs.getInt("SummaryID"));
						followUp.setFollowUp(rs.getString("FollowUp"));
						followUp.setResponsibility(rs.getString("Responsibility"));
						followUp.setEntryDate(new Date(rs.getTimestamp("entryDate").getTime()));
						Timestamp timeline=rs.getTimestamp("Timeline");
						if(timeline!=null){
							followUp.setTimeline(new Date(timeline.getTime()));	
						}
						
						followUp.setRecurrence(rs.getString("Recurrance"));
						Timestamp closed=rs.getTimestamp("Closed");
						if(closed!=null){
							followUp.setClosed(new Date(closed.getTime()));
						}
						followUp.setClosedBy(rs.getString("ClosedBy"));
						followUp.setTagColor(rs.getString("TagColor"));
						
						try {
							String sql="select count(*) from [oimNotesFollowUpHistory] where [FID]=?";
							Integer integer=jdbcTemplate.queryForObject(sql,new Object[]{followUp.getId()}, Integer.class);
							if(integer==null){
								followUp.setHistoryCount(0);
							}else{
								followUp.setHistoryCount(integer);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						return followUp;
					}
					
				});
				summary.setFollowUps(followUps);
				
				return summary;
			}
			
		});
		return summaries;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getFollowUpHistory(int)
	 */
	@Override
	public List<FollowUpHistory> getFollowUpHistory(int fid) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [oimNotesFollowUpHistory] where [FID]=?";
		List<FollowUpHistory> histories=jdbcTemplate.query(sql, new Object[]{fid}, new RowMapper<FollowUpHistory>(){

			@Override
			public FollowUpHistory mapRow(ResultSet rs, int arg1)
					throws SQLException {
					FollowUpHistory followUpHistory=new FollowUpHistory();
					followUpHistory.setFollowUp(rs.getString("FollowUp"));
					followUpHistory.setLastUpdated(new Date(rs.getTimestamp("LastUpdated").getTime()));
					followUpHistory.setNotes(rs.getString("Notes"));
				return followUpHistory;
			}
			
		});
		
		return histories;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#closeFollowUp(int)
	 */
	@Override
	public void closeFollowUp(Date closed, String closedBy, int id) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update [oimNotesFollowUp] set [Closed]=?,[ClosedBy]=? where [ID]=?";
		jdbcTemplate.update(sql, new Object[]{closed,closedBy,id});
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getFollowUps(int, java.lang.String)
	 */
	@Override
	public List<FollowUp> getFollowUps(int sid, String tag) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="select * from [oimNotesFollowUp] where [SummaryID]=? and [Deleted]=? and [ClosedOld]=? and [TagColor]=?";
		
		List<FollowUp> followUps=jdbcTemplate.query(sql, new Object[]{sid,false,false,tag}, new RowMapper<FollowUp>(){

			@Override
			public FollowUp mapRow(ResultSet rs, int arg1)
					throws SQLException {
				FollowUp followUp=new FollowUp();
				followUp.setId(rs.getInt("ID"));
				followUp.setSummaryId(rs.getInt("SummaryID"));
				followUp.setFollowUp(rs.getString("FollowUp"));
				followUp.setResponsibility(rs.getString("Responsibility"));
				followUp.setEntryDate(new Date(rs.getTimestamp("entryDate").getTime()));
				Timestamp timeline=rs.getTimestamp("Timeline");
				if(timeline!=null){
					followUp.setTimeline(new Date(timeline.getTime()));	
				}
				
				followUp.setRecurrence(rs.getString("Recurrance"));
				followUp.setTagColor(rs.getString("TagColor"));
				followUp.setFile(rs.getString("File"));
				return followUp;
			}
			
		});
		
		return followUps;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getSummariesDates(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Summary> getSummariesDates(Date sdate, Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		//System.out.println(sdate);
		//System.out.println(edate);
		
		String sql="SELECT [EntryDate]"
				+ " FROM [oimNotesSummary] "
				+ "where ([EntryDate] between ? and ?) and [Deleted]=? "
				+"  group by [EntryDate]";
		
		List<Summary> summaries=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime()),
				false
		}, new RowMapper<Summary>(){

			@Override
			public Summary mapRow(ResultSet rs, int arg1) throws SQLException {
				Summary summary=new Summary();
				summary.setEntryDate(new Timestamp(rs.getDate("EntryDate").getTime()));
				return summary;
			}
			
		});
		return summaries;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getSummariesDates(int, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Summary> getSummariesDates(int categoryId, Date sdate,
			Date edate) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="SELECT s.[EntryDate],c.[Category],c.[ID] "
				+ " FROM [oimNotesSummary] s,oimNotesCategory c  "
				+ "where (s.[EntryDate] between ? and ?)"
				+ " and "
				+ " s.[Category]=c.[ID] "
				+ " and "
				+ " c.[ID]=? "
				+ " and "
				+ " s.[Deleted]=? "
				+"  group by s.[EntryDate],c.[Category],c.[ID] ";
		
		List<Summary> summaries=jdbcTemplate.query(sql, new Object[]{
				new Timestamp(sdate.getTime()),
				new Timestamp(edate.getTime()),
				categoryId,
				false
		}, new RowMapper<Summary>(){

			@Override
			public Summary mapRow(ResultSet rs, int arg1) throws SQLException {
				Summary summary=new Summary();
				summary.setEntryDate(new Timestamp(rs.getDate("EntryDate").getTime()));
				summary.setCategoryId(rs.getInt("ID"));
				summary.setCategory(rs.getString("Category"));
				return summary;
			}
			
		});
		return summaries;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#getOpenSummariesFolloUps()
	 */
	@Override
	public List<Summary> getOpenSummariesFolloUps() {
		final JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		String sql="SELECT s.[ID] as [Sid],s.[EntryDate],s.[Summary],c.[ID] as [Cid], c.[Category] as [Category] "
				+ "FROM [oimNotesSummary] s, [oimNotesCategory] c "
				+ "where "
				+ "c.[ID]= s.[Category] "
				+ " and "
				+ "s.[Deleted]=0 order by s.[Category]";
		List<Summary> summaries=jdbcTemplate.query(sql, new RowMapper<Summary>(){

			@Override
			public Summary mapRow(ResultSet rs, int arg1) throws SQLException {
				Summary summary=new Summary();
				summary.setId(rs.getInt("Sid"));
				summary.setSummary(rs.getString("Summary"));
				summary.setCategoryId(rs.getInt("Cid"));
				summary.setCategory(rs.getString("Category"));
				summary.setEntryDate(new Date(rs.getTimestamp("EntryDate").getTime()));
				summary.setDays(CommonUtil.getDaysDiffernce(summary.getEntryDate(), new Date()));
				
				
				String sql="select * from [oimNotesFollowUp] where [SummaryID]=? and [Deleted]=0 and [Closed] is NULL ";
				
				List<FollowUp> followUps=jdbcTemplate.query(sql, new Object[]{summary.getId()}, new RowMapper<FollowUp>(){

					@Override
					public FollowUp mapRow(ResultSet rs, int arg1)
							throws SQLException {
						FollowUp followUp=new FollowUp();
						followUp.setId(rs.getInt("ID"));
						followUp.setSummaryId(rs.getInt("SummaryID"));
						followUp.setFollowUp(rs.getString("FollowUp"));
						followUp.setResponsibility(rs.getString("Responsibility"));
						followUp.setEntryDate(new Date(rs.getTimestamp("entryDate").getTime()));
						Timestamp timeline=rs.getTimestamp("Timeline");
						if(timeline!=null){
							followUp.setTimeline(new Date(timeline.getTime()));	
						}
						
						followUp.setRecurrence(rs.getString("Recurrance"));
						Timestamp closed=rs.getTimestamp("Closed");
						if(closed!=null){
							followUp.setClosed(new Date(closed.getTime()));
						}
						followUp.setClosedBy(rs.getString("ClosedBy"));
						followUp.setTagColor(rs.getString("TagColor"));
						followUp.setDays(CommonUtil.getDaysDiffernce(followUp.getEntryDate(), new Date()));
						
						return followUp;
					}
					
				});
				summary.setFollowUps(followUps);
				
				return summary;
			}
			
		});
		return summaries;
	}

	/* (non-Javadoc)
	 * @see com.st.oimnotes.dao.OimNotesDao#addFollowUpChangeHistory(int, java.lang.String, java.lang.String)
	 */
	@Override
	public void addFollowUpChangeHistory(int id, String message, String notes) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="insert into [oimNotesFollowUpHistory]("
				+ "[FollowUp],"
				+ "[LastUpdated],"
				+ "[Notes],"
				+ "[FID] "
				+ ") values(?,?,?,?)";
		
		
		jdbcTemplate.update(sql, new Object[]{
				message,
				new Timestamp(new Date().getTime()),
				notes,
				id
		});
	}

}
