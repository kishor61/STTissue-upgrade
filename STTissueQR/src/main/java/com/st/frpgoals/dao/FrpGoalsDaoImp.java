/**
 *Dec 15, 2015
 *FrpGoalsDaoImp.java
 * TODO
 *com.st.frpgoals.dao
 *FrpGoalsDaoImp.java
 *Sunil Singh Bora
 */
package com.st.frpgoals.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.st.common.CommonUtil;
import com.st.frpgoals.mapper.FrpGoalsCheckDataMapper;
import com.st.frpgoals.mapper.FrpGoalsMapper;
import com.st.frpgoals.model.FrpGoals;
import com.st.frpgoals.service.FrpGoalsService;
import com.st.wastepaper.mapper.OpeningClosingMapper;
import com.st.wastepaper.model.BarcodeComman;

/**
 * @author Roshan Tailor
 *
 */
@Repository
public class FrpGoalsDaoImp  implements FrpGoalsDao{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	@Qualifier("dataSourceTracker")
	private DataSource dataSourceT;
	
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	/* (non-Javadoc)
	 * @see com.st.frpgoals.dao.FrpGoalsDao#saveOrUpdate(com.st.frpgoals.model.FrpGoals)
	 */
	
	@Override
	public void saveOrUpdate(final FrpGoals frpGoals) {
		//SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		
		System.out.println("Date::"+frpGoals.getSdateTmp());
		
		Date date;
		int month=0;
		int year=0; 
		List<FrpGoals> frpsize=null;
		try {
			date = dateFormat.parse(frpGoals.getSdateTmp());
			
			String monthS=monthFormat.format(date);
			String yearS=yearFormat.format(date);
			
			month = Integer.parseInt(monthS);
			year= Integer.parseInt(yearS);
			frpGoals.setMonth(month);
			frpGoals.setYear(year);
			frpsize=getOpenMonthData(month,year);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(frpsize.size()==0){
			System.out.println("Size Zero Hai...");
			
			final String sql="insert into frpGoalData("
					//+"ID"
					+"[monthS],"
					+"[yearS],"
					+"[sowAndCbsF],"
					+"[newsBankF],"
					+"[occF],"
					+"[dlkF],"
					+"[mailF],"
					+"[mixedOtherF],"
					+"[cutbookF],"
					+"[sowAndCbsP],"
					+"[newsBankP],"
					+"[occP],"
					+"[dlkP],"
					+"[mailP],"
					+"[mixedOtherP],"
					+"[cutbookP]"
					+ ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			//Insert query
			
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql);
					
					//statement.setInt(1, frpGoals.getId());
					//statement.setTimestamp(2, new Timestamp(frpGoals.getSdate().getTime()));
					statement.setInt(1, frpGoals.getMonth());
					statement.setInt(2, frpGoals.getYear());
					statement.setDouble(3, frpGoals.getSowAndCbsF());
					statement.setDouble(4, frpGoals.getNewsBankF());
					statement.setDouble(5, frpGoals.getOccF());
					statement.setDouble(6, frpGoals.getDlkF());
					statement.setDouble(7, frpGoals.getMailF());
					statement.setDouble(8, frpGoals.getMixedOtherF());
					statement.setDouble(9, frpGoals.getCutbookF());
					statement.setDouble(10, frpGoals.getSowAndCbsW());
					statement.setDouble(11, frpGoals.getNewsBankW());
					statement.setDouble(12, frpGoals.getOccW());
					statement.setDouble(13, frpGoals.getDlkW());
					statement.setDouble(14, frpGoals.getMailW());
					statement.setDouble(15, frpGoals.getMixedOtherW());
					statement.setDouble(16, frpGoals.getCutbookW());
					return statement;
				}
			});
			
			
		}else{
			// Update query
			System.out.println("Zero Nahi Hai");
			final String sql="update frpGoalData set "
					+"[monthS]=?,"
					+"[yearS]=?,"
					+"[sowAndCbsF]=?,"
					+"[newsBankF]=?,"
					+"[occF]=?,"
					+"[dlkF]=?,"
					+"[mailF]=?,"
					+"[mixedOtherF]=?,"
					+"[cutbookF]=?,"
					+"[sowAndCbsP]=?,"
					+"[newsBankP]=?,"
					+"[occP]=?,"
					+"[dlkP]=?,"
					+"[mailP]=?,"
					+"[mixedOtherP]=?,"
					+"[cutbookP]=?"
					+ " where monthS=? AND yearS=?";
			
			//Insert query
			
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection arg0)
						throws SQLException {
					PreparedStatement statement=arg0.prepareStatement(sql);
					
					
					//statement.setTimestamp(1, new Timestamp(frpGoals.getSdate().getTime()));
					statement.setInt(1, frpGoals.getMonth());
					statement.setInt(2, frpGoals.getYear());
					statement.setDouble(3, frpGoals.getSowAndCbsF());
					statement.setDouble(4, frpGoals.getNewsBankF());
					statement.setDouble(5, frpGoals.getOccF());
					statement.setDouble(6, frpGoals.getDlkF());
					statement.setDouble(7, frpGoals.getMailF());
					statement.setDouble(8, frpGoals.getMixedOtherF());
					statement.setDouble(9, frpGoals.getCutbookF());
					statement.setDouble(10, frpGoals.getSowAndCbsW());
					statement.setDouble(11, frpGoals.getNewsBankW());
					statement.setDouble(12, frpGoals.getOccW());
					statement.setDouble(13, frpGoals.getDlkW());
					statement.setDouble(14, frpGoals.getMailW());
					statement.setDouble(15, frpGoals.getMixedOtherW());
					statement.setDouble(16, frpGoals.getCutbookW());
					//statement.setInt(17, frpGoals.getId());
					statement.setInt(17, frpGoals.getMonth());
					statement.setInt(18, frpGoals.getYear());
					return statement;
				}
			});
		}
		
	}

	/* (non-Javadoc)
	 * @see com.st.frpgoals.dao.FrpGoalsDao#getOpenMonthData(int, int)
	 */
	@Override
	public List<FrpGoals> getOpenMonthData(int month, int year) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="Select * from  frpGoalData where [monthS]=? AND [yearS]=?";
		List<FrpGoals> availableOrNot=jdbcTemplate.query(sql, new Object[]{
			month,year	
		}, new FrpGoalsCheckDataMapper());
		
		return availableOrNot;
	}

	/* (non-Javadoc)
	 * @see com.st.frpgoals.dao.FrpGoalsDao#getFrpGoalsData(int, int)
	 */
	@Override
	public List<FrpGoals> getFrpGoalsData(int month, int year) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="Select * from  frpGoalData where [monthS]=? AND [yearS]=?";
		List<FrpGoals> data=jdbcTemplate.query(sql, new Object[]{
			month,year	
		}, new FrpGoalsMapper());
		
		return data;
	}

	/* (non-Javadoc)
	 * @see com.st.frpgoals.dao.FrpGoalsDao#getConsumedData(java.util.Date, java.util.Date)
	 */
	@Override
	public List<FrpGoals> getConsumedData(Date currentMonthSDate,Date currentMonthLDate) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceT);
		
		List<FrpGoals> consumedBales=new ArrayList<FrpGoals>();
		
		int days=CommonUtil.getDaysDiffernce(currentMonthSDate, currentMonthLDate);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(currentMonthSDate);
		System.out.println("Fetching BARCODE CONSUMED BALES - GRADEWISE <START>");
		for (int i = 0; i <=days; i++) {
			Date dateS=calendar.getTime();
			
			
			Calendar scal=Calendar.getInstance();
			scal.setTime(dateS);
			scal.set(Calendar.HOUR_OF_DAY, 7);
			scal.set(Calendar.MINUTE, 0);
			scal.set(Calendar.SECOND, 0);
			scal.set(Calendar.MILLISECOND, 0);
	
			
			Calendar ecal=Calendar.getInstance();
			ecal.setTime(dateS);
			ecal.set(Calendar.HOUR_OF_DAY, 6);
			ecal.set(Calendar.MINUTE, 59);
			ecal.set(Calendar.SECOND, 59);
			ecal.set(Calendar.MILLISECOND, 0);
			ecal.add(Calendar.DATE, 1);
			
			final FrpGoals frpGoals=new FrpGoals();
			
			double _totalConsumedBaleWeightCount=0;
			double sowandcbsW=0;
			double newsblankW=0;
			double occW=0;
			double dlkW=0;
			double mailW=0;
			double mixedcraftW=0;
			double cutorhoggedBookW=0;
			
			try{
				String sqlforConsumedBale="SELECT [ConsumedDate], sum(BaleWeight)/2000 as BALEWT,[GradeCode],count(*) as COUNTBALE FROM [tblBaleInventory] "
						+ "where ([ActualConsumedDateTime] between ? and ? ) AND [GradeCode] in (select GradeCode from tlkpGrade)group by [ConsumedDate],[GradeCode]";

				List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
				
				try{
					mapList=jdbcTemplate.queryForList(sqlforConsumedBale,new Object[]{
							new Timestamp(scal.getTime().getTime()),
							new Timestamp(ecal.getTime().getTime())
					});
					}catch(Exception rlt){
						rlt.printStackTrace();
					}
					if(mapList.size()>0){
						for(Map<String, Object> map1:mapList){
							double _totalConsumedBaleWeight=map1.get("BALEWT")==null?0:(Double)map1.get("BALEWT");
							int grade=(Integer)map1.get("GradeCode");
							_totalConsumedBaleWeightCount=_totalConsumedBaleWeightCount+_totalConsumedBaleWeight;
							if(grade==13 || grade==5){
								sowandcbsW=sowandcbsW+_totalConsumedBaleWeight;
								frpGoals.setSowandcbsweight(sowandcbsW);
							}if(grade==16){
								newsblankW=newsblankW+_totalConsumedBaleWeight;
								frpGoals.setNewsblankweight(newsblankW);
							}if(grade==23){
								occW=occW+_totalConsumedBaleWeight;
								frpGoals.setOccweight(occW);
							}if(grade==24){
								dlkW=dlkW+_totalConsumedBaleWeight;
								frpGoals.setDlkweight(dlkW);
							}if(grade==20){
								mailW=mailW+_totalConsumedBaleWeight;
								frpGoals.setMailweight(mailW);
							}if(grade==30){
								mixedcraftW=mixedcraftW+_totalConsumedBaleWeight;
								frpGoals.setMixedcraftweight(mixedcraftW);
							}if(grade==21){
								cutorhoggedBookW=cutorhoggedBookW+_totalConsumedBaleWeight;
								frpGoals.setCutorhoggedBookweight(cutorhoggedBookW);
							}else{}
						}
					}else{}
				
			}catch(Exception rlt){
				rlt.printStackTrace();
			}
			consumedBales.add(frpGoals);
			calendar.add(Calendar.DATE, 1);
		}
		return consumedBales;
	}

}
