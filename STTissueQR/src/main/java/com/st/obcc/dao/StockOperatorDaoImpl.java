/**
 *Jul 4, 2016
 *StockOperatorDaoImpl.java
 * TODO
 *com.st.obcc.dao
 *StockOperatorDaoImpl.java
 *Sunil Singh Bora
 */
package com.st.obcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.st.obcc.model.StockOperator;
import com.st.obccPM5.model.LeadOperatorPM5;

/**
 * @author snavhaal
 *
 */
@Repository
public class StockOperatorDaoImpl implements StockOperatorDao {

	@Autowired
	@Qualifier("dataSourceOBCC")
	private DataSource dataSourceQRT;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.obcc.dao.StockOperatorDao#saveorUpdate(com.st.obcc.model.StockOperator
	 * )
	 */
	
	private SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat fromuser=new SimpleDateFormat("yyyy-MM-dd");
	
	
	@Override
	public void saveorUpdate(StockOperator data) {
		// TODO Auto-generated method stub
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRT);
	 	MapSqlParameterSource paramSource=new MapSqlParameterSource();
	 	
	 	paramSource.addValue("position",data.getPosition());
		paramSource.addValue("operatorName",data.getOperatorName());
		paramSource.addValue("edate",data.getEdate());
		paramSource.addValue("crew",data.getCrew());
		paramSource.addValue("shift",data.getShift());
		
		paramSource.addValue("machinedown",	data.isMachinedown());
		paramSource.addValue("hdStorageChestCol1",data.isHdStorageChestCol1());
		
		paramSource.addValue("hdStorageChestCol2Inbound",data.getHdStorageChestCol2Inbound());
		paramSource.addValue("hdStorageChestCol2Outbound",data.getHdStorageChestCol2Outbound());
		
		paramSource.addValue("hdStorageChestCol3",data.isHdStorageChestCol3());

		paramSource.addValue("hdStorageChestCol4Inbound",data.getHdStorageChestCol4Inbound());
		paramSource.addValue("hdStorageChestCol4Outbound",data.getHdStorageChestCol4Outbound());
		
		paramSource.addValue("hdStorageChestCol5",data.isHdStorageChestCol5());
		
		paramSource.addValue("hdStorageChestCol6Inbound",data.getHdStorageChestCol6Inbound());
		paramSource.addValue("hdStorageChestCol6Outbound",data.getHdStorageChestCol6Outbound());
		
		paramSource.addValue("hdStorageChestCol7",data.isHdStorageChestCol7());
		
		paramSource.addValue("hdStorageChestCol8Inbound",data.getHdStorageChestCol8Inbound());
		paramSource.addValue("hdStorageChestCol8Outbound",data.getHdStorageChestCol8Outbound());
		
		paramSource.addValue("hdStorageChestCol1Desc",data.getHdStorageChestCol1Desc());
		paramSource.addValue("hdStorageChestCol2Desc",data.getHdStorageChestCol2Desc());
		paramSource.addValue("hdStorageChestCol3Desc",data.getHdStorageChestCol3Desc());
		paramSource.addValue("hdStorageChestCol4Desc",data.getHdStorageChestCol4Desc());
		paramSource.addValue("hdStorageChestCol5Desc",data.getHdStorageChestCol5Desc());
		paramSource.addValue("hdStorageChestCol6Desc",data.getHdStorageChestCol6Desc());
		paramSource.addValue("hdStorageChestCol7Desc",data.getHdStorageChestCol7Desc());
		paramSource.addValue("hdStorageChestCol8Desc",data.getHdStorageChestCol8Desc());
		
		paramSource.addValue("blendChestCol1",data.isBlendChestCol1());
		
		paramSource.addValue("blendChestCol2Inbound",data.getBlendChestCol2Inbound());
		paramSource.addValue("blendChestCol2Outbound",data.getBlendChestCol2Outbound());
		paramSource.addValue("blendChestCol3",data.isBlendChestCol3());
		
		paramSource.addValue("blendChestCol4Inbound",data.getBlendChestCol4Inbound());
		paramSource.addValue("blendChestCol4Outbound",data.getBlendChestCol4Outbound());
		
		paramSource.addValue("blendChestCol1Desc",data.getBlendChestCol1Desc());
		paramSource.addValue("blendChestCol2Desc",data.getBlendChestCol2Desc());
		paramSource.addValue("blendChestCol3Desc",data.getBlendChestCol3Desc());
		paramSource.addValue("blendChestCol4Desc",data.getBlendChestCol4Desc());
		
		paramSource.addValue("seeScreenFeedTandCol1",data.isSeeScreenFeedTandCol1());
		
		paramSource.addValue("seeScreenFeedTandCol2Inbound",data.getSeeScreenFeedTandCol2Inbound());
		paramSource.addValue("seeScreenFeedTandcol2Outbound",data.getSeeScreenFeedTandcol2Outbound());
		
		paramSource.addValue("seeScreenFeedTandCol3",data.isSeeScreenFeedTandCol3());
		
		paramSource.addValue("seeScreenFeedTandCol4Inbound",data.getSeeScreenFeedTandCol4Inbound());
		paramSource.addValue("seeScreenFeedTandcol4Outbound",data.getSeeScreenFeedTandcol4Outbound());
		
		paramSource.addValue("seeScreenFeedTandCol1Desc",data.getSeeScreenFeedTandCol1Desc());
		paramSource.addValue("seeScreenFeedTandCol2Desc",data.getSeeScreenFeedTandCol2Desc());
		paramSource.addValue("seeScreenFeedTandCol3Desc",data.getSeeScreenFeedTandCol3Desc());
		paramSource.addValue("seeScreenFeedTandCol4Desc",data.getSeeScreenFeedTandCol4Desc());
		
		paramSource.addValue("machineChestCol1",data.isMachineChestCol1());
		
		
		paramSource.addValue("machineChestCol2Inbound",data.getMachineChestCol2Inbound());
		paramSource.addValue("machineChestCol2Outbound",data.getMachineChestCol2Outbound());
		
		paramSource.addValue("machineChestCol3",data.isMachineChestCol3());
		
		paramSource.addValue("machineChestCol4Inbound",data.getMachineChestCol4Inbound());
		paramSource.addValue("machineChestCol4Outbound",data.getMachineChestCol4Outbound());
		
		paramSource.addValue("machineChestCol5",data.isMachineChestCol5());
		
		paramSource.addValue("machineChestCol6Inbound",data.getMachineChestCol6Inbound());
		paramSource.addValue("machineChestCol6Outbound",data.getMachineChestCol6Outbound());
		
		paramSource.addValue("machineChestCol1Desc",data.getMachineChestCol1Desc());
		paramSource.addValue("machineChestCol2Desc",data.getMachineChestCol2Desc());
		paramSource.addValue("machineChestCol3Desc",data.getMachineChestCol3Desc());
		paramSource.addValue("machineChestCol4Desc",data.getMachineChestCol4Desc());
		paramSource.addValue("machineChestCol5Desc",data.getMachineChestCol5Desc());
		paramSource.addValue("machineChestCol6Desc",data.getMachineChestCol6Desc());
		
		paramSource.addValue("cleannersCol1",data.isCleannersCol1());
		paramSource.addValue("cleannersCol2",data.isCleannersCol2());
		
		paramSource.addValue("cleannersCol3Inbound",data.getCleannersCol3Inbound());
		paramSource.addValue("cleannersCol3Outbound",data.getCleannersCol3Outbound());
		
		
		paramSource.addValue("cleannersCol1Desc",data.getCleannersCol1Desc());
		paramSource.addValue("cleannersCol2Desc",data.getCleannersCol2Desc());
		paramSource.addValue("cleannersCol3Desc",data.getCleannersCol3Desc());
		
		
		paramSource.addValue("deLinkStockCol1",data.isDeLinkStockCol1());
		
		paramSource.addValue("deLinkStockCol2Inbound",data.getDeLinkStockCol2Inbound());
		paramSource.addValue("deLinkStockCol2Outbound",data.getDeLinkStockCol2Outbound());
		
		
		paramSource.addValue("deLinkStockCol1Desc",data.getDeLinkStockCol1Desc());
		paramSource.addValue("deLinkStockCol2Desc",data.getDeLinkStockCol2Desc());
		
		paramSource.addValue("whiteWaterCol1",data.isWhiteWaterCol1());
		
		paramSource.addValue("whiteWaterCol2Inbound",data.getWhiteWaterCol2Inbound());
		paramSource.addValue("whiteWaterCol2Outbound",data.getWhiteWaterCol2Outbound());
		
		paramSource.addValue("whiteWaterCol3",data.isWhiteWaterCol3());
		
		paramSource.addValue("whiteWaterCol4Inbound",data.getWhiteWaterCol4Inbound());
		paramSource.addValue("whiteWaterCol4Outbound",data.getWhiteWaterCol4Outbound());
		
		paramSource.addValue("whiteWaterCol5",data.isWhiteWaterCol5());
		
		paramSource.addValue("whiteWaterCol6Inbound",data.getWhiteWaterCol6Inbound());
		paramSource.addValue("whiteWaterCol6Outbound",data.getWhiteWaterCol6Outbound());
		
		paramSource.addValue("whiteWaterCol7",data.isWhiteWaterCol7());
		
		paramSource.addValue("whiteWaterCol8Inbound",data.getWhiteWaterCol8Inbound());
		paramSource.addValue("whiteWaterCol8Outbound",data.getWhiteWaterCol8Outbound());
		
		paramSource.addValue("whiteWaterCol1Desc",data.getWhiteWaterCol1Desc());
		paramSource.addValue("whiteWaterCol2Desc",data.getWhiteWaterCol2Desc());
		paramSource.addValue("whiteWaterCol3Desc",data.getWhiteWaterCol3Desc());
		paramSource.addValue("whiteWaterCol4Desc",data.getWhiteWaterCol4Desc());
		paramSource.addValue("whiteWaterCol5Desc",data.getWhiteWaterCol5Desc());
		paramSource.addValue("whiteWaterCol6Desc",data.getWhiteWaterCol6Desc());
		paramSource.addValue("whiteWaterCol7Desc",data.getWhiteWaterCol7Desc());
		paramSource.addValue("whiteWaterCol8Desc",data.getWhiteWaterCol8Desc());
		
		paramSource.addValue("couchPitCol1",data.isCouchPitCol1());
		paramSource.addValue("couchPitCol2",data.isCouchPitCol2());
		
		paramSource.addValue("couchPitCol3Inbound",data.getCouchPitCol3Inbound());
		paramSource.addValue("couchPitCol3Outbound",data.getCouchPitCol3Outbound());
		
		paramSource.addValue("couchPitCol4",data.isCouchPitCol4());
		
		paramSource.addValue("couchPitCol5Inbound",data.getCouchPitCol5Inbound());
		paramSource.addValue("couchPitCol5Outbound",data.getCouchPitCol5Outbound());
		
		paramSource.addValue("couchPitCol6",data.isCouchPitCol6());
		
		paramSource.addValue("couchPitCol7Inbound",data.getCouchPitCol7Inbound());
		paramSource.addValue("couchPitCol7Outbound",data.getCouchPitCol7Outbound());
		
		paramSource.addValue("couchPitCol8Inbound",data.getCouchPitCol8Inbound());
		paramSource.addValue("couchPitCol8Outbound",data.getCouchPitCol8Outbound());
		
		paramSource.addValue("couchPitCol9",data.isCouchPitCol9());
		
		paramSource.addValue("couchPitCol10Inbound",data.getCouchPitCol10Inbound());
		paramSource.addValue("couchPitCol10Outbound",data.getCouchPitCol10Outbound());
		
		paramSource.addValue("couchPitCol11Inbound",data.getCouchPitCol11Inbound());
		paramSource.addValue("couchPitCol11Outbound",data.getCouchPitCol11Outbound());
		
		paramSource.addValue("couchPitCol1Desc",data.getCouchPitCol1Desc());
		paramSource.addValue("couchPitCol2Desc",data.getCouchPitCol2Desc());
		paramSource.addValue("couchPitCol3Desc",data.getCouchPitCol3Desc());
		paramSource.addValue("couchPitCol4Desc",data.getCouchPitCol4Desc());
		paramSource.addValue("couchPitCol5Desc",data.getCouchPitCol5Desc());
		paramSource.addValue("couchPitCol6Desc",data.getCouchPitCol6Desc());
		paramSource.addValue("couchPitCol7Desc",data.getCouchPitCol7Desc());
		paramSource.addValue("couchPitCol8Desc",data.getCouchPitCol8Desc());
		paramSource.addValue("couchPitCol9Desc",data.getCouchPitCol9Desc());
		paramSource.addValue("couchPitCol10Desc",data.getCouchPitCol10Desc());
		paramSource.addValue("couchPitCol11Desc",data.getCouchPitCol11Desc());
		
		paramSource.addValue("yankeePulperCol1",data.isYankeePulperCol1());
		paramSource.addValue("yankeePulperCol1Drain",data.isYankeePulperCol1Drain());
		paramSource.addValue("yankeePulperCol2",data.isYankeePulperCol2());
		
		paramSource.addValue("yankeePulperCol3Inbound",data.getYankeePulperCol3Inbound());
		paramSource.addValue("yankeePulperCol3Outbound",data.getYankeePulperCol3Outbound());
		
		paramSource.addValue("yankeePulperCol4",data.isYankeePulperCol4());
		
		paramSource.addValue("yankeePulperCol5Inbound",data.getYankeePulperCol5Inbound());
		paramSource.addValue("yankeePulperCol5Outbound",data.getYankeePulperCol5Outbound());
		
		paramSource.addValue("yankeePulperCol6",data.isYankeePulperCol6());
		
		paramSource.addValue("yankeePulperCol7Inbound",data.getYankeePulperCol7Inbound());
		paramSource.addValue("yankeePulperCol7Outbound",data.getYankeePulperCol7Outbound());
		
		paramSource.addValue("yankeePulperCol8",data.isYankeePulperCol8());
		
		
		paramSource.addValue("yankeePulperCol9Inbound",data.getYankeePulperCol9Inbound());
		paramSource.addValue("yankeePulperCol9Outbound",data.getYankeePulperCol9Outbound());
		
		paramSource.addValue("yankeePulperCol1Desc",data.getYankeePulperCol1Desc());
		paramSource.addValue("yankeePulperCol1DrainDesc",data.getYankeePulperCol1DrainDesc());
		paramSource.addValue("yankeePulperCol2Desc",data.getYankeePulperCol2Desc());
		paramSource.addValue("yankeePulperCol3Desc",data.getYankeePulperCol3Desc());
		paramSource.addValue("yankeePulperCol4Desc",data.getYankeePulperCol4Desc());
		paramSource.addValue("yankeePulperCol5Desc",data.getYankeePulperCol5Desc());
		paramSource.addValue("yankeePulperCol6Desc",data.getYankeePulperCol6Desc());
		paramSource.addValue("yankeePulperCol7Desc",data.getYankeePulperCol7Desc());
		paramSource.addValue("yankeePulperCol8Desc",data.getYankeePulperCol8Desc());
		paramSource.addValue("yankeePulperCol9Desc",data.getYankeePulperCol9Desc());
		
		
		
		
		
		paramSource.addValue("brokeDeflakerCol1",data.isBrokeDeflakerCol1());
		
		paramSource.addValue("brokeDeflakerCol2Inbound",data.getBrokeDeflakerCol2Inbound());
		paramSource.addValue("brokeDeflakerCol2Outbound",data.getBrokeDeflakerCol2Outbound());
		
		paramSource.addValue("brokeDeflakerCol3",data.isBrokeDeflakerCol3());
		
		paramSource.addValue("brokeDeflakerCol1Desc",data.getBrokeDeflakerCol1Desc());
		paramSource.addValue("brokeDeflakerCol2Desc",data.getBrokeDeflakerCol2Desc());
		paramSource.addValue("brokeDeflakerCol3Desc",data.getBrokeDeflakerCol3Desc());
		
		paramSource.addValue("refiningSystemCol1",data.getRefiningSystemCol1());
		
		paramSource.addValue("refiningSystemCol2",data.isRefiningSystemCol2());
		
		paramSource.addValue("refiningSystemCol3Inbound",data.getRefiningSystemCol3Inbound());
		paramSource.addValue("refiningSystemCol3Outbound",data.getRefiningSystemCol3Outbound());
		
		paramSource.addValue("refiningSystemCol4",data.getRefiningSystemCol4());
		paramSource.addValue("refiningSystemCol5",data.getRefiningSystemCol5());
		paramSource.addValue("refiningSystemCol6",data.getRefiningSystemCol6());
		
		paramSource.addValue("refiningSystemCol7",data.isRefiningSystemCol7());
		
		paramSource.addValue("refiningSystemCol8Inbound",data.getRefiningSystemCol8Inbound());
		paramSource.addValue("refiningSystemCol8Outbound",data.getRefiningSystemCol8Outbound());
		
		paramSource.addValue("refiningSystemCol9",data.getRefiningSystemCol9());
		paramSource.addValue("refiningSystemCol10",data.getRefiningSystemCol10());
		
		
		paramSource.addValue("refiningSystemCol1Desc",data.getRefiningSystemCol1Desc());
		paramSource.addValue("refiningSystemCol2Desc",data.getRefiningSystemCol2Desc());
		paramSource.addValue("refiningSystemCol3Desc",data.getRefiningSystemCol3Desc());
		paramSource.addValue("refiningSystemCol4Desc",data.getRefiningSystemCol4Desc());
		paramSource.addValue("refiningSystemCol5Desc",data.getRefiningSystemCol5Desc());
		paramSource.addValue("refiningSystemCol6Desc",data.getRefiningSystemCol6Desc());
		paramSource.addValue("refiningSystemCol7Desc",data.getRefiningSystemCol7Desc());
		paramSource.addValue("refiningSystemCol8Desc",data.getRefiningSystemCol8Desc());
		paramSource.addValue("refiningSystemCol9Desc",data.getRefiningSystemCol9Desc());
		paramSource.addValue("refiningSystemCol10Desc",data.getRefiningSystemCol10Desc());
		
		 
		paramSource.addValue("whiteWaterPumpCol1",data.isWhiteWaterPumpCol1());
		
		paramSource.addValue("whiteWaterPumpCol2Inbound",data.getWhiteWaterPumpCol2Inbound());
		paramSource.addValue("whiteWaterPumpCol2Outbound",data.getWhiteWaterPumpCol2Outbound());
		
		
		paramSource.addValue("whiteWaterPumpCol3",data.isWhiteWaterPumpCol3());
		
		paramSource.addValue("whiteWaterPumpCol4Inbound",data.getWhiteWaterPumpCol4Inbound());
		paramSource.addValue("whiteWaterPumpCol4Outbound",data.getWhiteWaterPumpCol4Outbound());
		
		
		paramSource.addValue("whiteWaterPumpCol5",data.isWhiteWaterPumpCol5());
		
		paramSource.addValue("whiteWaterPumpCol6Inbound",data.getWhiteWaterPumpCol6Inbound());
		paramSource.addValue("whiteWaterPumpCol6Outbound",data.getWhiteWaterPumpCol6Outbound());
		
		paramSource.addValue("whiteWaterPumpCol1Desc",data.getWhiteWaterPumpCol1Desc());
		paramSource.addValue("whiteWaterPumpCol2Desc",data.getWhiteWaterPumpCol2Desc());
		paramSource.addValue("whiteWaterPumpCol3Desc",data.getWhiteWaterPumpCol3Desc());
		paramSource.addValue("whiteWaterPumpCol4Desc",data.getWhiteWaterPumpCol4Desc());
		paramSource.addValue("whiteWaterPumpCol5Desc",data.getWhiteWaterPumpCol5Desc());
		paramSource.addValue("whiteWaterPumpCol6Desc",data.getWhiteWaterPumpCol6Desc());
		
		paramSource.addValue("silloCol1",data.getSilloCol1());
		paramSource.addValue("silloCol2",data.isSilloCol2());
		paramSource.addValue("silloCol3",data.getSilloCol3());
		
		paramSource.addValue("silloCol1Desc",data.getSilloCol1Desc());
		paramSource.addValue("silloCol2Desc",data.getSilloCol2Desc());
		paramSource.addValue("silloCol3Desc",data.getSilloCol3Desc());
		
		
		paramSource.addValue("yankeePumplerCol1",data.isYankeePumplerCol1());
		
		paramSource.addValue("yankeePumplerCol1Drain",data.isYankeePumplerCol1Drain());
		
		paramSource.addValue("yankeePumplerCol2",data.isYankeePumplerCol2());
		
		
		paramSource.addValue("yankeePumplerCol3Inbound",data.getYankeePumplerCol3Inbound());
		paramSource.addValue("yankeePumplerCol3Outbound",data.getYankeePumplerCol3Outbound());
		
		paramSource.addValue("yankeePumplerCol4",data.isYankeePumplerCol4());
		
		
		paramSource.addValue("yankeePumplerCol5Inbound",data.getYankeePumplerCol5Inbound());
		paramSource.addValue("yankeePumplerCol5Outbound",data.getYankeePumplerCol5Outbound());

		paramSource.addValue("yankeePumplerCol6",data.isYankeePumplerCol6());
		
		
		paramSource.addValue("yankeePumplerCol7Inbound",data.getYankeePumplerCol7Inbound());
		paramSource.addValue("yankeePumplerCol7Outbound",data.getYankeePumplerCol7Outbound());
		
		paramSource.addValue("yankeePumplerCol8",data.isYankeePumplerCol8());
		
		
		paramSource.addValue("yankeePumplerCol9Inbound",data.getYankeePumplerCol9Inbound());
		paramSource.addValue("yankeePumplerCol9Outbound",data.getYankeePumplerCol9Outbound());
		
		paramSource.addValue("yankeePumplerCol1Desc",data.getYankeePumplerCol1Desc());
		
		paramSource.addValue("yankeePumplerCol1DrainDesc",data.getYankeePumplerCol1DrainDesc());
		
		paramSource.addValue("yankeePumplerCol2Desc",data.getYankeePumplerCol2Desc());
		paramSource.addValue("yankeePumplerCol3Desc",data.getYankeePumplerCol3Desc());
		paramSource.addValue("yankeePumplerCol4Desc",data.getYankeePumplerCol4Desc());
		paramSource.addValue("yankeePumplerCol5Desc",data.getYankeePumplerCol5Desc());
		paramSource.addValue("yankeePumplerCol6Desc",data.getYankeePumplerCol6Desc());
		paramSource.addValue("yankeePumplerCol7Desc",data.getYankeePumplerCol7Desc());
		paramSource.addValue("yankeePumplerCol8Desc",data.getYankeePumplerCol8Desc());
		paramSource.addValue("yankeePumplerCol9Desc",data.getYankeePumplerCol9Desc());
		
		
		paramSource.addValue("brokeSystemCol1",data.getBrokeSystemCol1());
		paramSource.addValue("brokeSystemCol2",data.getBrokeSystemCol2());
		paramSource.addValue("brokeSystemCol3",data.getBrokeSystemCol3());
		paramSource.addValue("brokeSystemCol4",data.getBrokeSystemCol4());
		paramSource.addValue("brokeSystemCol5",data.getBrokeSystemCol5());
		paramSource.addValue("brokeSystemCol6",data.getBrokeSystemCol6());
		paramSource.addValue("brokeSystemCol7",data.getBrokeSystemCol7());
		paramSource.addValue("brokeSystemCol8",data.getBrokeSystemCol8());
		paramSource.addValue("brokeSystemCol9",data.getBrokeSystemCol9());
		paramSource.addValue("brokeSystemCol10",data.getBrokeSystemCol10());
		paramSource.addValue("brokeSystemCol11",data.getBrokeSystemCol11());
		
		paramSource.addValue("brokeSystemCol1Desc",data.getBrokeSystemCol1Desc());
		paramSource.addValue("brokeSystemCol2Desc",data.getBrokeSystemCol2Desc());
		paramSource.addValue("brokeSystemCol3Desc",data.getBrokeSystemCol3Desc());
		paramSource.addValue("brokeSystemCol4Desc",data.getBrokeSystemCol4Desc());
		paramSource.addValue("brokeSystemCol5Desc",data.getBrokeSystemCol5Desc());
		paramSource.addValue("brokeSystemCol6Desc",data.getBrokeSystemCol6Desc());
		paramSource.addValue("brokeSystemCol7Desc",data.getBrokeSystemCol7Desc());
		paramSource.addValue("brokeSystemCol8Desc",data.getBrokeSystemCol8Desc());
		paramSource.addValue("brokeSystemCol9Desc",data.getBrokeSystemCol9Desc());
		paramSource.addValue("brokeSystemCol10Desc",data.getBrokeSystemCol10Desc());
		paramSource.addValue("brokeSystemCol11Desc",data.getBrokeSystemCol11Desc());
		
		
		paramSource.addValue("saveAllCol1",data.getSaveAllCol1());
		
		paramSource.addValue("saveAllCol2",data.isSaveAllCol2());
		paramSource.addValue("saveAllCol3",data.isSaveAllCol3());
		
		paramSource.addValue("saveAllCol4Inbound",data.getSaveAllCol4Inbound());
		paramSource.addValue("saveAllCol4Outbound",data.getSaveAllCol4Outbound());
		
		paramSource.addValue("saveAllCol5",data.isSaveAllCol5());
		paramSource.addValue("saveAllCol6",data.isSaveAllCol6());
		
		paramSource.addValue("saveAllCol1Desc",data.getSaveAllCol1Desc());
		paramSource.addValue("saveAllCol2Desc",data.getSaveAllCol2Desc());
		paramSource.addValue("saveAllCol3Desc",data.getSaveAllCol3Desc());
		paramSource.addValue("saveAllCol4Desc",data.getSaveAllCol4Desc());
		paramSource.addValue("saveAllCol5Desc",data.getSaveAllCol5Desc());
		paramSource.addValue("saveAllCol6Desc",data.getSaveAllCol6Desc());
		
		paramSource.addValue("hydrapulperCol1",data.isHydrapulperCol1());
		
		paramSource.addValue("hydrapulperCol2Inbound",data.getHydrapulperCol2Inbound());
		paramSource.addValue("hydrapulperCol2outbound",data.getHydrapulperCol2outbound());
		
		
		paramSource.addValue("hydrapulperCol3",data.isHydrapulperCol3());
		
		paramSource.addValue("hydrapulperCol4Inbound",data.getHydrapulperCol4Inbound());
		paramSource.addValue("hydrapulperCol4outbound",data.getHydrapulperCol4outbound());
		
		
		paramSource.addValue("hydrapulperCol5",data.isHydrapulperCol5());
		paramSource.addValue("hydrapulperCol6",data.isHydrapulperCol6());
		paramSource.addValue("hydrapulperCol7",data.isHydrapulperCol7());
		
		paramSource.addValue("hydrapulperCol8Inbound",data.getHydrapulperCol8Inbound());
		paramSource.addValue("hydrapulperCol8outbound",data.getHydrapulperCol8outbound());
		
		
		paramSource.addValue("hydrapulperCol9",data.isHydrapulperCol9());
		
		paramSource.addValue("hydrapulperCol10Inbound",data.getHydrapulperCol10Inbound());
		paramSource.addValue("hydrapulperCol10outbound",data.getHydrapulperCol10outbound());
		
		
		paramSource.addValue("hydrapulperCol11",data.isHydrapulperCol11());
		paramSource.addValue("hydrapulperCol12",data.isHydrapulperCol12());
		paramSource.addValue("hydrapulperCol13",data.isHydrapulperCol13());
		
		paramSource.addValue("hydrapulperCol14Inbound",data.getHydrapulperCol14Inbound());
		paramSource.addValue("hydrapulperCol14outbound",data.getHydrapulperCol14outbound());
		
		paramSource.addValue("hydrapulperCol15",data.isHydrapulperCol15());
		
		
		paramSource.addValue("hydrapulperCol16Inbound",data.getHydrapulperCol16Inbound());
		paramSource.addValue("hydrapulperCol16outbound",data.getHydrapulperCol16outbound());
		
		
		paramSource.addValue("hydrapulperCol1Desc",data.getHydrapulperCol1Desc());
		paramSource.addValue("hydrapulperCol2Desc",data.getHydrapulperCol2Desc());
		paramSource.addValue("hydrapulperCol3Desc",data.getHydrapulperCol3Desc());
		paramSource.addValue("hydrapulperCol4Desc",data.getHydrapulperCol4Desc());
		paramSource.addValue("hydrapulperCol5Desc",data.getHydrapulperCol5Desc());
		paramSource.addValue("hydrapulperCol6Desc",data.getHydrapulperCol6Desc());
		paramSource.addValue("hydrapulperCol7Desc",data.getHydrapulperCol7Desc());
		paramSource.addValue("hydrapulperCol8Desc",data.getHydrapulperCol8Desc());
		paramSource.addValue("hydrapulperCol9Desc",data.getHydrapulperCol9Desc());
		paramSource.addValue("hydrapulperCol10Desc",data.getHydrapulperCol10Desc());
		paramSource.addValue("hydrapulperCol11Desc",data.getHydrapulperCol11Desc());
		paramSource.addValue("hydrapulperCol12Desc",data.getHydrapulperCol12Desc());
		paramSource.addValue("hydrapulperCol13Desc",data.getHydrapulperCol13Desc());
		paramSource.addValue("hydrapulperCol14Desc",data.getHydrapulperCol14Desc());
		paramSource.addValue("hydrapulperCol15Desc",data.getHydrapulperCol15Desc());
		paramSource.addValue("hydrapulperCol16Desc",data.getHydrapulperCol16Desc());
		
		paramSource.addValue("desccol1",data.getDesccol1());
		paramSource.addValue("desccol1Desc",data.getDesccol1Desc());
		
		  
		paramSource.addValue("effluentsamplerworkingcondition",data.isEffluentsamplerworkingcondition());
		paramSource.addValue("effluentsamplerworkingconditionDesc",data.getEffluentsamplerworkingconditionDesc());
		
		 
		
		if (data.getId() == 0) {	
			
			String sql=DatabaseUtil.getSQL("sql/insertStockoperator.sql");
			jdbcTemplate.update(sql, paramSource);
		}	
		else
		{
			paramSource.addValue("id",data.getId());
			String sql=DatabaseUtil.getSQL("sql/updateStockOperator.sql");
			jdbcTemplate.update(sql, paramSource);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.obcc.dao.StockOperatorDao#getOperatorData(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public StockOperator getOperatorData(String position, String date,
			String shift, String crew) throws Exception {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		String sql = "select * from [stock_operator] where [position]=? AND [date]=? AND [shift] = ?  ";

		StockOperator stockOperator = null;

		try {
			stockOperator = jdbcTemplate.queryForObject(sql, new Object[] {
					position, date, shift },
					new RowMapper<StockOperator>() {

						@Override
						public StockOperator mapRow(ResultSet rs, int arg1)
								throws SQLException {
							StockOperator data = new StockOperator();
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operator_name"));
							data.setEdate(rs.getString("date"));
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setHdStorageChestCol1(rs.getBoolean("hd_storage_chest_col1"));
							data.setHdStorageChestCol2Inbound(rs.getString("hd_storage_chest_col2_inbound"));
							data.setHdStorageChestCol2Outbound(rs.getString("hd_storage_chest_col2_outbound"));
							data.setHdStorageChestCol3(rs.getBoolean("hd_storage_chest_col3"));
							
							
							data.setHdStorageChestCol4Inbound(rs.getString("hd_storage_chest_col4_inbound"));
							data.setHdStorageChestCol4Outbound(rs.getString("hd_storage_chest_col4_outbound"));
							data.setHdStorageChestCol5(rs.getBoolean("hd_storage_chest_col5"));
							
							data.setHdStorageChestCol6Inbound(rs.getString("hd_storage_chest_col6_inbound"));
							data.setHdStorageChestCol6Outbound(rs.getString("hd_storage_chest_col6_outbound"));
							data.setHdStorageChestCol7(rs.getBoolean("hd_storage_chest_col7"));
							data.setHdStorageChestCol8Inbound(rs.getString("hd_storage_chest_col8_inbound"));
							data.setHdStorageChestCol8Outbound(rs.getString("hd_storage_chest_col8_outbound"));
							
							data.setHdStorageChestCol1Desc(rs.getString("hd_storage_chest_col1_Desc"));
							data.setHdStorageChestCol2Desc(rs.getString("hd_storage_chest_col2_Desc"));
							data.setHdStorageChestCol3Desc(rs.getString("hd_storage_chest_col3_Desc"));
							data.setHdStorageChestCol4Desc(rs.getString("hd_storage_chest_col4_Desc"));
							data.setHdStorageChestCol5Desc(rs.getString("hd_storage_chest_col5_Desc"));
							data.setHdStorageChestCol6Desc(rs.getString("hd_storage_chest_col6_Desc"));
							data.setHdStorageChestCol7Desc(rs.getString("hd_storage_chest_col7_Desc"));
							data.setHdStorageChestCol8Desc(rs.getString("hd_storage_chest_col8_Desc"));
							
							
							data.setBlendChestCol1(rs.getBoolean("blend_chest_col1"));
							data.setBlendChestCol2Inbound(rs.getString("blend_chest_col2_inbound"));
							data.setBlendChestCol2Outbound(rs.getString("blend_chest_col2_outbound"));
							data.setBlendChestCol3(rs.getBoolean("blend_chest_col3"));
							
							data.setBlendChestCol4Inbound(rs.getString("blend_chest_col4_inbound"));
							data.setBlendChestCol4Outbound(rs.getString("blend_chest_col4_outbound"));
							
							data.setBlendChestCol1Desc(rs.getString("blend_chest_col1_Desc"));
							data.setBlendChestCol2Desc(rs.getString("blend_chest_col2_Desc"));
							data.setBlendChestCol3Desc(rs.getString("blend_chest_col3_Desc"));
							data.setBlendChestCol4Desc(rs.getString("blend_chest_col4_Desc"));
							
							
							data.setSeeScreenFeedTandCol1(rs.getBoolean("see_screen_feed_tand_col1"));
							data.setSeeScreenFeedTandCol2Inbound(rs.getString("see_screen_feed_tand_col2_inbound"));
							data.setSeeScreenFeedTandcol2Outbound(rs.getString("see_screen_feed_tand_col2_outbound"));
							
							data.setSeeScreenFeedTandCol3(rs.getBoolean("see_screen_feed_tand_col3"));
							
							data.setSeeScreenFeedTandCol4Inbound(rs.getString("see_screen_feed_tand_col4_inbound"));
							data.setSeeScreenFeedTandcol4Outbound(rs.getString("see_screen_feed_tand_col4_outbound"));
							
							data.setSeeScreenFeedTandCol1Desc(rs.getString("see_screen_feed_tand_col1_Desc"));
							data.setSeeScreenFeedTandCol2Desc(rs.getString("see_screen_feed_tand_col2_Desc"));
							data.setSeeScreenFeedTandCol3Desc(rs.getString("see_screen_feed_tand_col3_Desc"));
							data.setSeeScreenFeedTandCol4Desc(rs.getString("see_screen_feed_tand_col4_Desc"));
							
							data.setMachineChestCol1(rs.getBoolean("machine_chest_col1"));
							data.setMachineChestCol2Inbound(rs.getString("machine_chest_col2_inbound"));
							data.setMachineChestCol2Outbound(rs.getString("machine_chest_col2_outbound"));
							data.setMachineChestCol3(rs.getBoolean("machine_chest_col3"));
							
							data.setMachineChestCol4Inbound(rs.getString("machine_chest_col4_inbound"));
							data.setMachineChestCol4Outbound(rs.getString("machine_chest_col4_outbound"));
							data.setMachineChestCol5(rs.getBoolean("machine_chest_col5"));
							
							data.setMachineChestCol6Inbound(rs.getString("machine_chest_col6_inbound"));
							data.setMachineChestCol6Outbound(rs.getString("machine_chest_col6_outbound"));
							
							data.setMachineChestCol1Desc(rs.getString("machine_chest_col1_Desc"));
							data.setMachineChestCol2Desc(rs.getString("machine_chest_col2_Desc"));
							data.setMachineChestCol3Desc(rs.getString("machine_chest_col3_Desc"));
							data.setMachineChestCol4Desc(rs.getString("machine_chest_col4_Desc"));
							data.setMachineChestCol5Desc(rs.getString("machine_chest_col5_Desc"));
							data.setMachineChestCol6Desc(rs.getString("machine_chest_col6_Desc"));
														
							
							data.setCleannersCol1(rs.getBoolean("cleanners_col1"));
							data.setCleannersCol2(rs.getBoolean("cleanners_col2"));
							
							data.setCleannersCol3Inbound(rs.getString("cleanners_col3_inbound"));
							data.setCleannersCol3Outbound(rs.getString("cleanners_col3_outbound"));
							
							data.setCleannersCol1Desc(rs.getString("cleanners_col1_Desc"));
							data.setCleannersCol2Desc(rs.getString("cleanners_col2_Desc"));
							data.setCleannersCol3Desc(rs.getString("cleanners_col3_Desc"));
							
							data.setDeLinkStockCol1(rs.getBoolean("de_link_stock_col1"));
							data.setDeLinkStockCol2Inbound(rs.getString("de_link_stock_col2_inbound"));
							data.setDeLinkStockCol2Outbound(rs.getString("de_link_stock_col2_outbound"));
							
							data.setDeLinkStockCol1Desc(rs.getString("de_link_stock_col1_Desc"));
							data.setDeLinkStockCol2Desc(rs.getString("de_link_stock_col2_Desc"));
							
							data.setWhiteWaterCol1(rs.getBoolean("white_water_col1"));
							data.setWhiteWaterCol2Inbound(rs.getString("white_water_col2_inbound"));
							data.setWhiteWaterCol2Outbound(rs.getString("white_water_col2_outbound"));
							
							data.setWhiteWaterCol3(rs.getBoolean("white_water_col3"));
							
							data.setWhiteWaterCol4Inbound(rs.getString("white_water_col4_inbound"));
							data.setWhiteWaterCol4Outbound(rs.getString("white_water_col4_outbound"));
							
							data.setWhiteWaterCol5(rs.getBoolean("white_water_col5"));
							
							data.setWhiteWaterCol6Inbound(rs.getString("white_water_col6_inbound"));
							data.setWhiteWaterCol6Outbound(rs.getString("white_water_col6_outbound"));
							
							
							data.setWhiteWaterCol7(rs.getBoolean("white_water_col7"));
							
							data.setWhiteWaterCol8Inbound(rs.getString("white_water_col8_inbound"));
							data.setWhiteWaterCol8Outbound(rs.getString("white_water_col8_outbound"));
							
							data.setWhiteWaterCol1Desc(rs.getString("white_water_col1_Desc"));
							data.setWhiteWaterCol2Desc(rs.getString("white_water_col2_Desc"));
							data.setWhiteWaterCol3Desc(rs.getString("white_water_col3_Desc"));
							data.setWhiteWaterCol4Desc(rs.getString("white_water_col4_Desc"));
							data.setWhiteWaterCol5Desc(rs.getString("white_water_col5_Desc"));
							data.setWhiteWaterCol6Desc(rs.getString("white_water_col6_Desc"));
							data.setWhiteWaterCol7Desc(rs.getString("white_water_col7_Desc"));
							data.setWhiteWaterCol8Desc(rs.getString("white_water_col8_Desc"));
							
							data.setCouchPitCol1(rs.getBoolean("couch_pit_col1"));
							data.setCouchPitCol2(rs.getBoolean("couch_pit_col2"));
							
							data.setCouchPitCol3Inbound(rs.getString("couch_pit_col3_inbound"));
							data.setCouchPitCol3Outbound(rs.getString("couch_pit_col3_outbound"));
							
							data.setCouchPitCol4(rs.getBoolean("couch_pit_col4"));
							
							data.setCouchPitCol5Inbound(rs.getString("couch_pit_col5_inbound"));
							data.setCouchPitCol5Outbound(rs.getString("couch_pit_col5_outbound"));
							
							data.setCouchPitCol6(rs.getBoolean("couch_pit_col6"));
							
							data.setCouchPitCol7Inbound(rs.getString("couch_pit_col7_inbound"));
							data.setCouchPitCol7Outbound(rs.getString("couch_pit_col7_outbound"));
							data.setCouchPitCol8Inbound(rs.getString("couch_pit_col8_inbound"));
							data.setCouchPitCol8Outbound(rs.getString("couch_pit_col8_outbound"));
							
							data.setCouchPitCol9(rs.getBoolean("couch_pit_col9"));
							
							data.setCouchPitCol10Inbound(rs.getString("couch_pit_col10_inbound"));
							data.setCouchPitCol10Outbound(rs.getString("couch_pit_col10_outbound"));
							
							data.setCouchPitCol11Inbound(rs.getString("couch_pit_col11_inbound"));
							data.setCouchPitCol11Outbound(rs.getString("couch_pit_col11_outbound"));
							
							
							data.setCouchPitCol1Desc(rs.getString("couch_pit_col1_Desc"));
							data.setCouchPitCol2Desc(rs.getString("couch_pit_col2_Desc"));
							data.setCouchPitCol3Desc(rs.getString("couch_pit_col3_Desc"));
							data.setCouchPitCol4Desc(rs.getString("couch_pit_col4_Desc"));
							data.setCouchPitCol5Desc(rs.getString("couch_pit_col5_Desc"));
							data.setCouchPitCol6Desc(rs.getString("couch_pit_col6_Desc"));
							data.setCouchPitCol7Desc(rs.getString("couch_pit_col7_Desc"));
							data.setCouchPitCol8Desc(rs.getString("couch_pit_col8_Desc"));
							data.setCouchPitCol9Desc(rs.getString("couch_pit_col9_Desc"));
							data.setCouchPitCol10Desc(rs.getString("couch_pit_col10_Desc"));
							data.setCouchPitCol11Desc(rs.getString("couch_pit_col11_Desc"));
							
							
							data.setYankeePulperCol1(rs.getBoolean("yankee_pulper_col1"));
							data.setYankeePulperCol1Drain(rs.getBoolean("yankee_pulper_col1_drain"));
							
							
							data.setYankeePulperCol2(rs.getBoolean("yankee_pulper_col2"));
							
							data.setYankeePulperCol3Inbound(rs.getString("yankee_pulper_col3_inbound"));
							data.setYankeePulperCol3Outbound(rs.getString("yankee_pulper_col3_outbound"));
							
							data.setYankeePulperCol4(rs.getBoolean("yankee_pulper_col4"));
							
							
							data.setYankeePulperCol5Inbound(rs.getString("yankee_pulper_col5_inbound"));
							data.setYankeePulperCol5Outbound(rs.getString("yankee_pulper_col5_outbound"));
							
							data.setYankeePulperCol6(rs.getBoolean("yankee_pulper_col6"));
							
							data.setYankeePulperCol7Inbound(rs.getString("yankee_pulper_col7_inbound"));
							data.setYankeePulperCol7Outbound(rs.getString("yankee_pulper_col7_outbound"));
							
							data.setYankeePulperCol8(rs.getBoolean("yankee_pulper_col8"));
														
							
							data.setYankeePulperCol9Inbound(rs.getString("yankee_pulper_col9_inbound"));
							data.setYankeePulperCol9Outbound(rs.getString("yankee_pulper_col9_outbound"));
							
							data.setYankeePulperCol1Desc(rs.getString("yankee_pulper_col1_Desc"));
							data.setYankeePulperCol1DrainDesc(rs.getString("yankee_pulper_col1_Drain_Desc"));
							data.setYankeePulperCol2Desc(rs.getString("yankee_pulper_col2_Desc"));
							data.setYankeePulperCol3Desc(rs.getString("yankee_pulper_col3_Desc"));
							data.setYankeePulperCol4Desc(rs.getString("yankee_pulper_col4_Desc"));
							data.setYankeePulperCol5Desc(rs.getString("yankee_pulper_col5_Desc"));
							data.setYankeePulperCol6Desc(rs.getString("yankee_pulper_col6_Desc"));
							data.setYankeePulperCol7Desc(rs.getString("yankee_pulper_col7_Desc"));
							data.setYankeePulperCol8Desc(rs.getString("yankee_pulper_col8_Desc"));
							data.setYankeePulperCol9Desc(rs.getString("yankee_pulper_col9_Desc"));
							
							data.setBrokeDeflakerCol1(rs.getBoolean("broke_deflaker_col1"));
							data.setBrokeDeflakerCol2Inbound(rs.getString("broke_deflaker_col2_inbound"));
							data.setBrokeDeflakerCol2Outbound(rs.getString("broke_deflaker_col2_outbound"));
							
							data.setBrokeDeflakerCol3(rs.getBoolean("broke_deflaker_col3"));
							
							data.setBrokeDeflakerCol1Desc(rs.getString("broke_deflaker_col1_Desc"));
							data.setBrokeDeflakerCol2Desc(rs.getString("broke_deflaker_col2_Desc"));
							data.setBrokeDeflakerCol3Desc(rs.getString("broke_deflaker_col3_Desc"));
							
							data.setRefiningSystemCol1(rs.getString("refining_system_col1"));
							data.setRefiningSystemCol2(rs.getBoolean("refining_system_col2"));
							data.setRefiningSystemCol3Inbound(rs.getString("refining_system_col3_inbound"));
							data.setRefiningSystemCol3Outbound(rs.getString("refining_system_col3_outbound"));
							
							data.setRefiningSystemCol4(rs.getString("refining_system_col4"));
							data.setRefiningSystemCol5(rs.getString("refining_system_col5"));
							data.setRefiningSystemCol6(rs.getString("refining_system_col6"));
							data.setRefiningSystemCol7(rs.getBoolean("refining_system_col7"));
							
							data.setRefiningSystemCol8Inbound(rs.getString("refining_system_col8_inbound"));
							data.setRefiningSystemCol8Outbound(rs.getString("refining_system_col8_outbound"));
							
							data.setRefiningSystemCol9(rs.getString("refining_system_col9"));
							data.setRefiningSystemCol10(rs.getString("refining_system_col10"));
							
							data.setRefiningSystemCol1Desc(rs.getString("refining_system_col1_Desc"));
							data.setRefiningSystemCol2Desc(rs.getString("refining_system_col2_Desc"));
							data.setRefiningSystemCol3Desc(rs.getString("refining_system_col3_Desc"));
							data.setRefiningSystemCol4Desc(rs.getString("refining_system_col4_Desc"));
							data.setRefiningSystemCol5Desc(rs.getString("refining_system_col5_Desc"));
							data.setRefiningSystemCol6Desc(rs.getString("refining_system_col6_Desc"));
							data.setRefiningSystemCol7Desc(rs.getString("refining_system_col7_Desc"));
							data.setRefiningSystemCol8Desc(rs.getString("refining_system_col8_Desc"));
							data.setRefiningSystemCol9Desc(rs.getString("refining_system_col9_Desc"));
							data.setRefiningSystemCol10Desc(rs.getString("refining_system_col10_Desc"));
							 
							
							data.setWhiteWaterPumpCol1(rs.getBoolean("white_water_pump_col1"));
							data.setWhiteWaterPumpCol2Inbound(rs.getString("white_water_pump_col2_inbound"));
							data.setWhiteWaterPumpCol2Outbound(rs.getString("white_water_pump_col2_outbound"));
							
							data.setWhiteWaterPumpCol3(rs.getBoolean("white_water_pump_col3"));
							
							data.setWhiteWaterPumpCol4Inbound(rs.getString("white_water_pump_col4_inbound"));
							data.setWhiteWaterPumpCol4Outbound(rs.getString("white_water_pump_col4_outbound"));
							
							data.setWhiteWaterPumpCol5(rs.getBoolean("white_water_pump_col5"));
							
							data.setWhiteWaterPumpCol6Inbound(rs.getString("white_water_pump_col6_inbound"));
							data.setWhiteWaterPumpCol6Outbound(rs.getString("white_water_pump_col6_outbound"));
							
							data.setWhiteWaterPumpCol1Desc(rs.getString("white_water_pump_col1_Desc"));
							data.setWhiteWaterPumpCol2Desc(rs.getString("white_water_pump_col2_Desc"));
							data.setWhiteWaterPumpCol3Desc(rs.getString("white_water_pump_col3_Desc"));
							data.setWhiteWaterPumpCol4Desc(rs.getString("white_water_pump_col4_Desc"));
							data.setWhiteWaterPumpCol5Desc(rs.getString("white_water_pump_col5_Desc"));
							data.setWhiteWaterPumpCol6Desc(rs.getString("white_water_pump_col6_Desc"));
							
							
							data.setSilloCol1(rs.getString("silo_col1"));
							data.setSilloCol2(rs.getBoolean("silo_col2"));
							data.setSilloCol3(rs.getString("silo_col3"));
							data.setSilloCol1Desc(rs.getString("sillo_col1_Desc"));
							data.setSilloCol2Desc(rs.getString("sillo_col2_Desc"));
							data.setSilloCol3Desc(rs.getString("sillo_col3_Desc"));
							
							data.setYankeePumplerCol1(rs.getBoolean("yankee_pumpler_col1"));
							data.setYankeePumplerCol1Drain(rs.getBoolean("yankee_pumpler_col1_Drain"));
							
							data.setYankeePumplerCol2(rs.getBoolean("yankee_pumpler_col2"));
							
							data.setYankeePumplerCol3Inbound(rs.getString("yankee_pumpler_col3_inbound"));
							data.setYankeePumplerCol3Outbound(rs.getString("yankee_pumpler_col3_outbound"));
							
							data.setYankeePumplerCol4(rs.getBoolean("yankee_pumpler_col4"));
							
							data.setYankeePumplerCol5Inbound(rs.getString("yankee_pumpler_col5_inbound"));
							data.setYankeePumplerCol5Outbound(rs.getString("yankee_pumpler_col5_outbound"));
							
							
							data.setYankeePumplerCol6(rs.getBoolean("yankee_pumpler_col6"));
							
							data.setYankeePumplerCol7Inbound(rs.getString("yankee_pumpler_col7_inbound"));
							data.setYankeePumplerCol7Outbound(rs.getString("yankee_pumpler_col7_outbound"));
							
							data.setYankeePumplerCol8(rs.getBoolean("yankee_pumpler_col8"));
							
							data.setYankeePumplerCol9Inbound(rs.getString("yankee_pumpler_col9_inbound"));
							data.setYankeePumplerCol9Outbound(rs.getString("yankee_pumpler_col9_outbound"));
							
							data.setYankeePumplerCol1Desc(rs.getString("yankee_pumpler_col1_Desc"));
							data.setYankeePumplerCol1DrainDesc(rs.getString("yankee_pumpler_col1_Drain_Desc"));
							
							data.setYankeePumplerCol2Desc(rs.getString("yankee_pumpler_col2_Desc"));
							data.setYankeePumplerCol3Desc(rs.getString("yankee_pumpler_col3_Desc"));
							data.setYankeePumplerCol4Desc(rs.getString("yankee_pumpler_col4_Desc"));
							data.setYankeePumplerCol5Desc(rs.getString("yankee_pumpler_col5_Desc"));
							data.setYankeePumplerCol6Desc(rs.getString("yankee_pumpler_col6_Desc"));
							data.setYankeePumplerCol7Desc(rs.getString("yankee_pumpler_col7_Desc"));
							data.setYankeePumplerCol8Desc(rs.getString("yankee_pumpler_col8_Desc"));
							data.setYankeePumplerCol9Desc(rs.getString("yankee_pumpler_col9_Desc"));
							
							data.setBrokeSystemCol1(rs.getString("Broke_system_col1"));
							data.setBrokeSystemCol2(rs.getString("Broke_system_col2"));
							data.setBrokeSystemCol3(rs.getString("Broke_system_col3"));
							data.setBrokeSystemCol4(rs.getString("Broke_system_col4"));
							data.setBrokeSystemCol5(rs.getString("Broke_system_col5"));
							data.setBrokeSystemCol6(rs.getString("Broke_system_col6"));
							data.setBrokeSystemCol7(rs.getString("Broke_system_col7"));
							data.setBrokeSystemCol8(rs.getString("Broke_system_col8"));
							data.setBrokeSystemCol9(rs.getString("Broke_system_col9"));
							data.setBrokeSystemCol10(rs.getString("Broke_system_col10"));
							data.setBrokeSystemCol11(rs.getString("Broke_system_col11"));
							
							data.setBrokeSystemCol1Desc(rs.getString("Broke_system_col1_Desc"));
							data.setBrokeSystemCol2Desc(rs.getString("Broke_system_col2_Desc"));
							data.setBrokeSystemCol3Desc(rs.getString("Broke_system_col3_Desc"));
							data.setBrokeSystemCol4Desc(rs.getString("Broke_system_col4_Desc"));
							data.setBrokeSystemCol5Desc(rs.getString("Broke_system_col5_Desc"));
							data.setBrokeSystemCol6Desc(rs.getString("Broke_system_col6_Desc"));
							data.setBrokeSystemCol7Desc(rs.getString("Broke_system_col7_Desc"));
							data.setBrokeSystemCol8Desc(rs.getString("Broke_system_col8_Desc"));
							data.setBrokeSystemCol9Desc(rs.getString("Broke_system_col9_Desc"));
							data.setBrokeSystemCol10Desc(rs.getString("Broke_system_col10_Desc"));
							data.setBrokeSystemCol11Desc(rs.getString("Broke_system_col11_Desc"));
							
							data.setSaveAllCol1(rs.getString("save_All_col1"));
							data.setSaveAllCol2(rs.getBoolean("save_All_col2"));
							data.setSaveAllCol3(rs.getBoolean("save_All_col3"));
							
							data.setSaveAllCol4Inbound(rs.getString("save_All_col4_inbound"));
							data.setSaveAllCol4Outbound(rs.getString("save_All_col4_outbound"));
							
							data.setSaveAllCol5(rs.getBoolean("save_All_col5"));
							data.setSaveAllCol6(rs.getBoolean("save_All_col6"));
							
							data.setSaveAllCol1Desc(rs.getString("save_All_col1_Desc"));
							data.setSaveAllCol2Desc(rs.getString("save_All_col2_Desc"));
							data.setSaveAllCol3Desc(rs.getString("save_All_col3_Desc"));
							data.setSaveAllCol4Desc(rs.getString("save_All_col4_Desc"));
							data.setSaveAllCol5Desc(rs.getString("save_All_col5_Desc"));
							data.setSaveAllCol6Desc(rs.getString("save_All_col6_Desc"));
							
							data.setHydrapulperCol1(rs.getBoolean("hydrapulper_col1"));
							data.setHydrapulperCol2Inbound(rs.getString("hydrapulper_col2_inbound"));
							data.setHydrapulperCol2outbound(rs.getString("hydrapulper_col2_outbound"));
							
							data.setHydrapulperCol3(rs.getBoolean("hydrapulper_col3"));
							
							data.setHydrapulperCol4Inbound(rs.getString("hydrapulper_col4_inbound"));
							data.setHydrapulperCol4outbound(rs.getString("hydrapulper_col4_outbound"));
							
							
							data.setHydrapulperCol5(rs.getBoolean("hydrapulper_col5"));
							data.setHydrapulperCol6(rs.getBoolean("hydrapulper_col6"));
							data.setHydrapulperCol7(rs.getBoolean("hydrapulper_col7"));
							
							data.setHydrapulperCol8Inbound(rs.getString("hydrapulper_col8_inbound"));
							data.setHydrapulperCol8outbound(rs.getString("hydrapulper_col8_outbound"));
							
							data.setHydrapulperCol9(rs.getBoolean("hydrapulper_col9"));
							
							data.setHydrapulperCol10Inbound(rs.getString("hydrapulper_col10_inbound"));
							data.setHydrapulperCol10outbound(rs.getString("hydrapulper_col10_outbound"));
							 
							
							data.setHydrapulperCol11(rs.getBoolean("hydrapulper_col11"));
							data.setHydrapulperCol12(rs.getBoolean("hydrapulper_col12"));
							data.setHydrapulperCol13(rs.getBoolean("hydrapulper_col13"));
							
							
							data.setHydrapulperCol14Inbound(rs.getString("hydrapulper_col14_inbound"));
							data.setHydrapulperCol14outbound(rs.getString("hydrapulper_col14_outbound"));
							
							data.setHydrapulperCol15(rs.getBoolean("hydrapulper_col15"));
							
							data.setHydrapulperCol16Inbound(rs.getString("hydrapulper_col16_inbound"));
							data.setHydrapulperCol16outbound(rs.getString("hydrapulper_col16_outbound"));
							
							data.setHydrapulperCol1Desc(rs.getString("hydrapulper_col1_Desc"));
							data.setHydrapulperCol2Desc(rs.getString("hydrapulper_col2_Desc"));
							data.setHydrapulperCol3Desc(rs.getString("hydrapulper_col3_Desc"));
							data.setHydrapulperCol4Desc(rs.getString("hydrapulper_col4_Desc"));
							data.setHydrapulperCol5Desc(rs.getString("hydrapulper_col5_Desc"));
							data.setHydrapulperCol6Desc(rs.getString("hydrapulper_col6_Desc"));
							data.setHydrapulperCol7Desc(rs.getString("hydrapulper_col7_Desc"));
							data.setHydrapulperCol8Desc(rs.getString("hydrapulper_col8_Desc"));
							data.setHydrapulperCol9Desc(rs.getString("hydrapulper_col9_Desc"));
							data.setHydrapulperCol10Desc(rs.getString("hydrapulper_col10_Desc"));
							data.setHydrapulperCol11Desc(rs.getString("hydrapulper_col11_Desc"));
							data.setHydrapulperCol12Desc(rs.getString("hydrapulper_col12_Desc"));
							data.setHydrapulperCol13Desc(rs.getString("hydrapulper_col13_Desc"));
							data.setHydrapulperCol14Desc(rs.getString("hydrapulper_col14_Desc"));
							data.setHydrapulperCol15Desc(rs.getString("hydrapulper_col15_Desc"));
							data.setHydrapulperCol16Desc(rs.getString("hydrapulper_col16_Desc"));
							
							data.setDesccol1(rs.getString("desccol1"));
							data.setDesccol1Desc(rs.getString("desccol1Desc"));
							
						 
							data.setEffluentsamplerworkingcondition(rs.getBoolean("effluentsamplerworkingcondition"));
							data.setEffluentsamplerworkingconditionDesc(rs.getString("effluentsamplerworkingconditionDesc"));
							
							return data;
						}

					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return stockOperator;

	}
	
	/* (non-Javadoc)
	 * @see com.st.obcc.dao.StockOperatorDao#getOperatorDataList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<StockOperator> getOperatorDataList(String position,String shift,String Sdate, String edate) throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceQRT);
		
		String sql = "select * from [stock_operator] where [position]=? AND [shift] =? AND [date] BETWEEN ? AND ? ";

		List <StockOperator> stockOperator = null;

		try {
			stockOperator = jdbcTemplate.query(sql, new Object[] {position,shift,Sdate, edate},
					new RowMapper<StockOperator>() {

						@Override
						public StockOperator mapRow(ResultSet rs, int arg1)
								throws SQLException {
							StockOperator data = new StockOperator();
							
						try
						{
							String newDate = dateFormat.format(fromuser.parse(rs.getString("date")));
							
							data.setId(rs.getInt("id"));
							data.setPosition(rs.getString("position"));
							data.setOperatorName(rs.getString("operator_name"));
							data.setEdate(newDate);
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setMachinedown(rs.getBoolean("machinedown"));
							data.setHdStorageChestCol1(rs.getBoolean("hd_storage_chest_col1"));
							data.setHdStorageChestCol2Inbound(rs.getString("hd_storage_chest_col2_inbound"));
							data.setHdStorageChestCol2Outbound(rs.getString("hd_storage_chest_col2_outbound"));
							data.setHdStorageChestCol3(rs.getBoolean("hd_storage_chest_col3"));
							
							
							data.setHdStorageChestCol4Inbound(rs.getString("hd_storage_chest_col4_inbound"));
							data.setHdStorageChestCol4Outbound(rs.getString("hd_storage_chest_col4_outbound"));
							data.setHdStorageChestCol5(rs.getBoolean("hd_storage_chest_col5"));
							
							data.setHdStorageChestCol6Inbound(rs.getString("hd_storage_chest_col6_inbound"));
							data.setHdStorageChestCol6Outbound(rs.getString("hd_storage_chest_col6_outbound"));
							data.setHdStorageChestCol7(rs.getBoolean("hd_storage_chest_col7"));
							data.setHdStorageChestCol8Inbound(rs.getString("hd_storage_chest_col8_inbound"));
							data.setHdStorageChestCol8Outbound(rs.getString("hd_storage_chest_col8_outbound"));
							
							data.setHdStorageChestCol1Desc(rs.getString("hd_storage_chest_col1_Desc"));
							data.setHdStorageChestCol2Desc(rs.getString("hd_storage_chest_col2_Desc"));
							data.setHdStorageChestCol3Desc(rs.getString("hd_storage_chest_col3_Desc"));
							data.setHdStorageChestCol4Desc(rs.getString("hd_storage_chest_col4_Desc"));
							data.setHdStorageChestCol5Desc(rs.getString("hd_storage_chest_col5_Desc"));
							data.setHdStorageChestCol6Desc(rs.getString("hd_storage_chest_col6_Desc"));
							data.setHdStorageChestCol7Desc(rs.getString("hd_storage_chest_col7_Desc"));
							data.setHdStorageChestCol8Desc(rs.getString("hd_storage_chest_col8_Desc"));
							
							
							data.setBlendChestCol1(rs.getBoolean("blend_chest_col1"));
							data.setBlendChestCol2Inbound(rs.getString("blend_chest_col2_inbound"));
							data.setBlendChestCol2Outbound(rs.getString("blend_chest_col2_outbound"));
							data.setBlendChestCol3(rs.getBoolean("blend_chest_col3"));
							
							data.setBlendChestCol4Inbound(rs.getString("blend_chest_col4_inbound"));
							data.setBlendChestCol4Outbound(rs.getString("blend_chest_col4_outbound"));
							
							data.setBlendChestCol1Desc(rs.getString("blend_chest_col1_Desc"));
							data.setBlendChestCol2Desc(rs.getString("blend_chest_col2_Desc"));
							data.setBlendChestCol3Desc(rs.getString("blend_chest_col3_Desc"));
							data.setBlendChestCol4Desc(rs.getString("blend_chest_col4_Desc"));
							
							
							data.setSeeScreenFeedTandCol1(rs.getBoolean("see_screen_feed_tand_col1"));
							data.setSeeScreenFeedTandCol2Inbound(rs.getString("see_screen_feed_tand_col2_inbound"));
							data.setSeeScreenFeedTandcol2Outbound(rs.getString("see_screen_feed_tand_col2_outbound"));
							
							data.setSeeScreenFeedTandCol3(rs.getBoolean("see_screen_feed_tand_col3"));
							
							data.setSeeScreenFeedTandCol4Inbound(rs.getString("see_screen_feed_tand_col4_inbound"));
							data.setSeeScreenFeedTandcol4Outbound(rs.getString("see_screen_feed_tand_col4_outbound"));
							
							data.setSeeScreenFeedTandCol1Desc(rs.getString("see_screen_feed_tand_col1_Desc"));
							data.setSeeScreenFeedTandCol2Desc(rs.getString("see_screen_feed_tand_col2_Desc"));
							data.setSeeScreenFeedTandCol3Desc(rs.getString("see_screen_feed_tand_col3_Desc"));
							data.setSeeScreenFeedTandCol4Desc(rs.getString("see_screen_feed_tand_col4_Desc"));
							
							data.setMachineChestCol1(rs.getBoolean("machine_chest_col1"));
							data.setMachineChestCol2Inbound(rs.getString("machine_chest_col2_inbound"));
							data.setMachineChestCol2Outbound(rs.getString("machine_chest_col2_outbound"));
							data.setMachineChestCol3(rs.getBoolean("machine_chest_col3"));
							
							data.setMachineChestCol4Inbound(rs.getString("machine_chest_col4_inbound"));
							data.setMachineChestCol4Outbound(rs.getString("machine_chest_col4_outbound"));
							data.setMachineChestCol5(rs.getBoolean("machine_chest_col5"));
							
							data.setMachineChestCol6Inbound(rs.getString("machine_chest_col6_inbound"));
							data.setMachineChestCol6Outbound(rs.getString("machine_chest_col6_outbound"));
							
							data.setMachineChestCol1Desc(rs.getString("machine_chest_col1_Desc"));
							data.setMachineChestCol2Desc(rs.getString("machine_chest_col2_Desc"));
							data.setMachineChestCol3Desc(rs.getString("machine_chest_col3_Desc"));
							data.setMachineChestCol4Desc(rs.getString("machine_chest_col4_Desc"));
							data.setMachineChestCol5Desc(rs.getString("machine_chest_col5_Desc"));
							data.setMachineChestCol6Desc(rs.getString("machine_chest_col6_Desc"));
														
							
							data.setCleannersCol1(rs.getBoolean("cleanners_col1"));
							data.setCleannersCol2(rs.getBoolean("cleanners_col2"));
							
							data.setCleannersCol3Inbound(rs.getString("cleanners_col3_inbound"));
							data.setCleannersCol3Outbound(rs.getString("cleanners_col3_outbound"));
							
							data.setCleannersCol1Desc(rs.getString("cleanners_col1_Desc"));
							data.setCleannersCol2Desc(rs.getString("cleanners_col2_Desc"));
							data.setCleannersCol3Desc(rs.getString("cleanners_col3_Desc"));
							
							data.setDeLinkStockCol1(rs.getBoolean("de_link_stock_col1"));
							data.setDeLinkStockCol2Inbound(rs.getString("de_link_stock_col2_inbound"));
							data.setDeLinkStockCol2Outbound(rs.getString("de_link_stock_col2_outbound"));
							
							data.setDeLinkStockCol1Desc(rs.getString("de_link_stock_col1_Desc"));
							data.setDeLinkStockCol2Desc(rs.getString("de_link_stock_col2_Desc"));
							
							data.setWhiteWaterCol1(rs.getBoolean("white_water_col1"));
							data.setWhiteWaterCol2Inbound(rs.getString("white_water_col2_inbound"));
							data.setWhiteWaterCol2Outbound(rs.getString("white_water_col2_outbound"));
							
							data.setWhiteWaterCol3(rs.getBoolean("white_water_col3"));
							
							data.setWhiteWaterCol4Inbound(rs.getString("white_water_col4_inbound"));
							data.setWhiteWaterCol4Outbound(rs.getString("white_water_col4_outbound"));
							
							data.setWhiteWaterCol5(rs.getBoolean("white_water_col5"));
							
							data.setWhiteWaterCol6Inbound(rs.getString("white_water_col6_inbound"));
							data.setWhiteWaterCol6Outbound(rs.getString("white_water_col6_outbound"));
							
							
							data.setWhiteWaterCol7(rs.getBoolean("white_water_col7"));
							
							data.setWhiteWaterCol8Inbound(rs.getString("white_water_col8_inbound"));
							data.setWhiteWaterCol8Outbound(rs.getString("white_water_col8_outbound"));
							
							data.setWhiteWaterCol1Desc(rs.getString("white_water_col1_Desc"));
							data.setWhiteWaterCol2Desc(rs.getString("white_water_col2_Desc"));
							data.setWhiteWaterCol3Desc(rs.getString("white_water_col3_Desc"));
							data.setWhiteWaterCol4Desc(rs.getString("white_water_col4_Desc"));
							data.setWhiteWaterCol5Desc(rs.getString("white_water_col5_Desc"));
							data.setWhiteWaterCol6Desc(rs.getString("white_water_col6_Desc"));
							data.setWhiteWaterCol7Desc(rs.getString("white_water_col7_Desc"));
							data.setWhiteWaterCol8Desc(rs.getString("white_water_col8_Desc"));
							
							data.setCouchPitCol1(rs.getBoolean("couch_pit_col1"));
							data.setCouchPitCol2(rs.getBoolean("couch_pit_col2"));
							
							data.setCouchPitCol3Inbound(rs.getString("couch_pit_col3_inbound"));
							data.setCouchPitCol3Outbound(rs.getString("couch_pit_col3_outbound"));
							
							data.setCouchPitCol4(rs.getBoolean("couch_pit_col4"));
							
							data.setCouchPitCol5Inbound(rs.getString("couch_pit_col5_inbound"));
							data.setCouchPitCol5Outbound(rs.getString("couch_pit_col5_outbound"));
							
							data.setCouchPitCol6(rs.getBoolean("couch_pit_col6"));
							
							data.setCouchPitCol7Inbound(rs.getString("couch_pit_col7_inbound"));
							data.setCouchPitCol7Outbound(rs.getString("couch_pit_col7_outbound"));
							data.setCouchPitCol8Inbound(rs.getString("couch_pit_col8_inbound"));
							data.setCouchPitCol8Outbound(rs.getString("couch_pit_col8_outbound"));
							
							data.setCouchPitCol9(rs.getBoolean("couch_pit_col9"));
							
							data.setCouchPitCol10Inbound(rs.getString("couch_pit_col10_inbound"));
							data.setCouchPitCol10Outbound(rs.getString("couch_pit_col10_outbound"));
							
							data.setCouchPitCol11Inbound(rs.getString("couch_pit_col11_inbound"));
							data.setCouchPitCol11Outbound(rs.getString("couch_pit_col11_outbound"));
							
							
							data.setCouchPitCol1Desc(rs.getString("couch_pit_col1_Desc"));
							data.setCouchPitCol2Desc(rs.getString("couch_pit_col2_Desc"));
							data.setCouchPitCol3Desc(rs.getString("couch_pit_col3_Desc"));
							data.setCouchPitCol4Desc(rs.getString("couch_pit_col4_Desc"));
							data.setCouchPitCol5Desc(rs.getString("couch_pit_col5_Desc"));
							data.setCouchPitCol6Desc(rs.getString("couch_pit_col6_Desc"));
							data.setCouchPitCol7Desc(rs.getString("couch_pit_col7_Desc"));
							data.setCouchPitCol8Desc(rs.getString("couch_pit_col8_Desc"));
							data.setCouchPitCol9Desc(rs.getString("couch_pit_col9_Desc"));
							data.setCouchPitCol10Desc(rs.getString("couch_pit_col10_Desc"));
							data.setCouchPitCol11Desc(rs.getString("couch_pit_col11_Desc"));
							
							
							data.setYankeePulperCol1(rs.getBoolean("yankee_pulper_col1"));
							data.setYankeePulperCol1Drain(rs.getBoolean("yankee_pulper_col1_drain"));
							
							
							data.setYankeePulperCol2(rs.getBoolean("yankee_pulper_col2"));
							
							data.setYankeePulperCol3Inbound(rs.getString("yankee_pulper_col3_inbound"));
							data.setYankeePulperCol3Outbound(rs.getString("yankee_pulper_col3_outbound"));
							
							data.setYankeePulperCol4(rs.getBoolean("yankee_pulper_col4"));
							
							
							data.setYankeePulperCol5Inbound(rs.getString("yankee_pulper_col5_inbound"));
							data.setYankeePulperCol5Outbound(rs.getString("yankee_pulper_col5_outbound"));
							
							data.setYankeePulperCol6(rs.getBoolean("yankee_pulper_col6"));
							
							data.setYankeePulperCol7Inbound(rs.getString("yankee_pulper_col7_inbound"));
							data.setYankeePulperCol7Outbound(rs.getString("yankee_pulper_col7_outbound"));
							
							data.setYankeePulperCol8(rs.getBoolean("yankee_pulper_col8"));
														
							
							data.setYankeePulperCol9Inbound(rs.getString("yankee_pulper_col9_inbound"));
							data.setYankeePulperCol9Outbound(rs.getString("yankee_pulper_col9_outbound"));
							
							data.setYankeePulperCol1Desc(rs.getString("yankee_pulper_col1_Desc"));
							data.setYankeePulperCol1DrainDesc(rs.getString("yankee_pulper_col1_Drain_Desc"));
							data.setYankeePulperCol2Desc(rs.getString("yankee_pulper_col2_Desc"));
							data.setYankeePulperCol3Desc(rs.getString("yankee_pulper_col3_Desc"));
							data.setYankeePulperCol4Desc(rs.getString("yankee_pulper_col4_Desc"));
							data.setYankeePulperCol5Desc(rs.getString("yankee_pulper_col5_Desc"));
							data.setYankeePulperCol6Desc(rs.getString("yankee_pulper_col6_Desc"));
							data.setYankeePulperCol7Desc(rs.getString("yankee_pulper_col7_Desc"));
							data.setYankeePulperCol8Desc(rs.getString("yankee_pulper_col8_Desc"));
							data.setYankeePulperCol9Desc(rs.getString("yankee_pulper_col9_Desc"));
							
							data.setBrokeDeflakerCol1(rs.getBoolean("broke_deflaker_col1"));
							data.setBrokeDeflakerCol2Inbound(rs.getString("broke_deflaker_col2_inbound"));
							data.setBrokeDeflakerCol2Outbound(rs.getString("broke_deflaker_col2_outbound"));
							
							data.setBrokeDeflakerCol3(rs.getBoolean("broke_deflaker_col3"));
							
							data.setBrokeDeflakerCol1Desc(rs.getString("broke_deflaker_col1_Desc"));
							data.setBrokeDeflakerCol2Desc(rs.getString("broke_deflaker_col2_Desc"));
							data.setBrokeDeflakerCol3Desc(rs.getString("broke_deflaker_col3_Desc"));
							
							data.setRefiningSystemCol1(rs.getString("refining_system_col1"));
							data.setRefiningSystemCol2(rs.getBoolean("refining_system_col2"));
							data.setRefiningSystemCol3Inbound(rs.getString("refining_system_col3_inbound"));
							data.setRefiningSystemCol3Outbound(rs.getString("refining_system_col3_outbound"));
							
							data.setRefiningSystemCol4(rs.getString("refining_system_col4"));
							data.setRefiningSystemCol5(rs.getString("refining_system_col5"));
							data.setRefiningSystemCol6(rs.getString("refining_system_col6"));
							data.setRefiningSystemCol7(rs.getBoolean("refining_system_col7"));
							
							data.setRefiningSystemCol8Inbound(rs.getString("refining_system_col8_inbound"));
							data.setRefiningSystemCol8Outbound(rs.getString("refining_system_col8_outbound"));
							
							data.setRefiningSystemCol9(rs.getString("refining_system_col9"));
							data.setRefiningSystemCol10(rs.getString("refining_system_col10"));
							
							data.setRefiningSystemCol1Desc(rs.getString("refining_system_col1_Desc"));
							data.setRefiningSystemCol2Desc(rs.getString("refining_system_col2_Desc"));
							data.setRefiningSystemCol3Desc(rs.getString("refining_system_col3_Desc"));
							data.setRefiningSystemCol4Desc(rs.getString("refining_system_col4_Desc"));
							data.setRefiningSystemCol5Desc(rs.getString("refining_system_col5_Desc"));
							data.setRefiningSystemCol6Desc(rs.getString("refining_system_col6_Desc"));
							data.setRefiningSystemCol7Desc(rs.getString("refining_system_col7_Desc"));
							data.setRefiningSystemCol8Desc(rs.getString("refining_system_col8_Desc"));
							data.setRefiningSystemCol9Desc(rs.getString("refining_system_col9_Desc"));
							data.setRefiningSystemCol10Desc(rs.getString("refining_system_col10_Desc"));
							 
							
							data.setWhiteWaterPumpCol1(rs.getBoolean("white_water_pump_col1"));
							data.setWhiteWaterPumpCol2Inbound(rs.getString("white_water_pump_col2_inbound"));
							data.setWhiteWaterPumpCol2Outbound(rs.getString("white_water_pump_col2_outbound"));
							
							data.setWhiteWaterPumpCol3(rs.getBoolean("white_water_pump_col3"));
							
							data.setWhiteWaterPumpCol4Inbound(rs.getString("white_water_pump_col4_inbound"));
							data.setWhiteWaterPumpCol4Outbound(rs.getString("white_water_pump_col4_outbound"));
							
							data.setWhiteWaterPumpCol5(rs.getBoolean("white_water_pump_col5"));
							
							data.setWhiteWaterPumpCol6Inbound(rs.getString("white_water_pump_col6_inbound"));
							data.setWhiteWaterPumpCol6Outbound(rs.getString("white_water_pump_col6_outbound"));
							
							data.setWhiteWaterPumpCol1Desc(rs.getString("white_water_pump_col1_Desc"));
							data.setWhiteWaterPumpCol2Desc(rs.getString("white_water_pump_col2_Desc"));
							data.setWhiteWaterPumpCol3Desc(rs.getString("white_water_pump_col3_Desc"));
							data.setWhiteWaterPumpCol4Desc(rs.getString("white_water_pump_col4_Desc"));
							data.setWhiteWaterPumpCol5Desc(rs.getString("white_water_pump_col5_Desc"));
							data.setWhiteWaterPumpCol6Desc(rs.getString("white_water_pump_col6_Desc"));
							
							
							data.setSilloCol1(rs.getString("silo_col1"));
							data.setSilloCol2(rs.getBoolean("silo_col2"));
							data.setSilloCol3(rs.getString("silo_col3"));
							data.setSilloCol1Desc(rs.getString("sillo_col1_Desc"));
							data.setSilloCol2Desc(rs.getString("sillo_col2_Desc"));
							data.setSilloCol3Desc(rs.getString("sillo_col3_Desc"));
							
							data.setYankeePumplerCol1(rs.getBoolean("yankee_pumpler_col1"));
							data.setYankeePumplerCol1Drain(rs.getBoolean("yankee_pumpler_col1_Drain"));
							
							data.setYankeePumplerCol2(rs.getBoolean("yankee_pumpler_col2"));
							
							data.setYankeePumplerCol3Inbound(rs.getString("yankee_pumpler_col3_inbound"));
							data.setYankeePumplerCol3Outbound(rs.getString("yankee_pumpler_col3_outbound"));
							
							data.setYankeePumplerCol4(rs.getBoolean("yankee_pumpler_col4"));
							
							data.setYankeePumplerCol5Inbound(rs.getString("yankee_pumpler_col5_inbound"));
							data.setYankeePumplerCol5Outbound(rs.getString("yankee_pumpler_col5_outbound"));
							
							
							data.setYankeePumplerCol6(rs.getBoolean("yankee_pumpler_col6"));
							
							data.setYankeePumplerCol7Inbound(rs.getString("yankee_pumpler_col7_inbound"));
							data.setYankeePumplerCol7Outbound(rs.getString("yankee_pumpler_col7_outbound"));
							
							data.setYankeePumplerCol8(rs.getBoolean("yankee_pumpler_col8"));
							
							data.setYankeePumplerCol9Inbound(rs.getString("yankee_pumpler_col9_inbound"));
							data.setYankeePumplerCol9Outbound(rs.getString("yankee_pumpler_col9_outbound"));
							
							data.setYankeePumplerCol1Desc(rs.getString("yankee_pumpler_col1_Desc"));
							data.setYankeePumplerCol1DrainDesc(rs.getString("yankee_pumpler_col1_Drain_Desc"));
							
							data.setYankeePumplerCol2Desc(rs.getString("yankee_pumpler_col2_Desc"));
							data.setYankeePumplerCol3Desc(rs.getString("yankee_pumpler_col3_Desc"));
							data.setYankeePumplerCol4Desc(rs.getString("yankee_pumpler_col4_Desc"));
							data.setYankeePumplerCol5Desc(rs.getString("yankee_pumpler_col5_Desc"));
							data.setYankeePumplerCol6Desc(rs.getString("yankee_pumpler_col6_Desc"));
							data.setYankeePumplerCol7Desc(rs.getString("yankee_pumpler_col7_Desc"));
							data.setYankeePumplerCol8Desc(rs.getString("yankee_pumpler_col8_Desc"));
							data.setYankeePumplerCol9Desc(rs.getString("yankee_pumpler_col9_Desc"));
							
							data.setBrokeSystemCol1(rs.getString("Broke_system_col1"));
							data.setBrokeSystemCol2(rs.getString("Broke_system_col2"));
							data.setBrokeSystemCol3(rs.getString("Broke_system_col3"));
							data.setBrokeSystemCol4(rs.getString("Broke_system_col4"));
							data.setBrokeSystemCol5(rs.getString("Broke_system_col5"));
							data.setBrokeSystemCol6(rs.getString("Broke_system_col6"));
							data.setBrokeSystemCol7(rs.getString("Broke_system_col7"));
							data.setBrokeSystemCol8(rs.getString("Broke_system_col8"));
							data.setBrokeSystemCol9(rs.getString("Broke_system_col9"));
							data.setBrokeSystemCol10(rs.getString("Broke_system_col10"));
							data.setBrokeSystemCol11(rs.getString("Broke_system_col11"));
							
							data.setBrokeSystemCol1Desc(rs.getString("Broke_system_col1_Desc"));
							data.setBrokeSystemCol2Desc(rs.getString("Broke_system_col2_Desc"));
							data.setBrokeSystemCol3Desc(rs.getString("Broke_system_col3_Desc"));
							data.setBrokeSystemCol4Desc(rs.getString("Broke_system_col4_Desc"));
							data.setBrokeSystemCol5Desc(rs.getString("Broke_system_col5_Desc"));
							data.setBrokeSystemCol6Desc(rs.getString("Broke_system_col6_Desc"));
							data.setBrokeSystemCol7Desc(rs.getString("Broke_system_col7_Desc"));
							data.setBrokeSystemCol8Desc(rs.getString("Broke_system_col8_Desc"));
							data.setBrokeSystemCol9Desc(rs.getString("Broke_system_col9_Desc"));
							data.setBrokeSystemCol10Desc(rs.getString("Broke_system_col10_Desc"));
							data.setBrokeSystemCol11Desc(rs.getString("Broke_system_col11_Desc"));
							
							data.setSaveAllCol1(rs.getString("save_All_col1"));
							data.setSaveAllCol2(rs.getBoolean("save_All_col2"));
							data.setSaveAllCol3(rs.getBoolean("save_All_col3"));
							
							data.setSaveAllCol4Inbound(rs.getString("save_All_col4_inbound"));
							data.setSaveAllCol4Outbound(rs.getString("save_All_col4_outbound"));
							
							data.setSaveAllCol5(rs.getBoolean("save_All_col5"));
							data.setSaveAllCol6(rs.getBoolean("save_All_col6"));
							
							data.setSaveAllCol1Desc(rs.getString("save_All_col1_Desc"));
							data.setSaveAllCol2Desc(rs.getString("save_All_col2_Desc"));
							data.setSaveAllCol3Desc(rs.getString("save_All_col3_Desc"));
							data.setSaveAllCol4Desc(rs.getString("save_All_col4_Desc"));
							data.setSaveAllCol5Desc(rs.getString("save_All_col5_Desc"));
							data.setSaveAllCol6Desc(rs.getString("save_All_col6_Desc"));
							
							data.setHydrapulperCol1(rs.getBoolean("hydrapulper_col1"));
							data.setHydrapulperCol2Inbound(rs.getString("hydrapulper_col2_inbound"));
							data.setHydrapulperCol2outbound(rs.getString("hydrapulper_col2_outbound"));
							
							data.setHydrapulperCol3(rs.getBoolean("hydrapulper_col3"));
							
							data.setHydrapulperCol4Inbound(rs.getString("hydrapulper_col4_inbound"));
							data.setHydrapulperCol4outbound(rs.getString("hydrapulper_col4_outbound"));
							
							
							data.setHydrapulperCol5(rs.getBoolean("hydrapulper_col5"));
							data.setHydrapulperCol6(rs.getBoolean("hydrapulper_col6"));
							data.setHydrapulperCol7(rs.getBoolean("hydrapulper_col7"));
							
							data.setHydrapulperCol8Inbound(rs.getString("hydrapulper_col8_inbound"));
							data.setHydrapulperCol8outbound(rs.getString("hydrapulper_col8_outbound"));
							
							data.setHydrapulperCol9(rs.getBoolean("hydrapulper_col9"));
							
							data.setHydrapulperCol10Inbound(rs.getString("hydrapulper_col10_inbound"));
							data.setHydrapulperCol10outbound(rs.getString("hydrapulper_col10_outbound"));
							 
							
							data.setHydrapulperCol11(rs.getBoolean("hydrapulper_col11"));
							data.setHydrapulperCol12(rs.getBoolean("hydrapulper_col12"));
							data.setHydrapulperCol13(rs.getBoolean("hydrapulper_col13"));
							
							
							data.setHydrapulperCol14Inbound(rs.getString("hydrapulper_col14_inbound"));
							data.setHydrapulperCol14outbound(rs.getString("hydrapulper_col14_outbound"));
							
							data.setHydrapulperCol15(rs.getBoolean("hydrapulper_col15"));
							
							data.setHydrapulperCol16Inbound(rs.getString("hydrapulper_col16_inbound"));
							data.setHydrapulperCol16outbound(rs.getString("hydrapulper_col16_outbound"));
							
							data.setHydrapulperCol1Desc(rs.getString("hydrapulper_col1_Desc"));
							data.setHydrapulperCol2Desc(rs.getString("hydrapulper_col2_Desc"));
							data.setHydrapulperCol3Desc(rs.getString("hydrapulper_col3_Desc"));
							data.setHydrapulperCol4Desc(rs.getString("hydrapulper_col4_Desc"));
							data.setHydrapulperCol5Desc(rs.getString("hydrapulper_col5_Desc"));
							data.setHydrapulperCol6Desc(rs.getString("hydrapulper_col6_Desc"));
							data.setHydrapulperCol7Desc(rs.getString("hydrapulper_col7_Desc"));
							data.setHydrapulperCol8Desc(rs.getString("hydrapulper_col8_Desc"));
							data.setHydrapulperCol9Desc(rs.getString("hydrapulper_col9_Desc"));
							data.setHydrapulperCol10Desc(rs.getString("hydrapulper_col10_Desc"));
							data.setHydrapulperCol11Desc(rs.getString("hydrapulper_col11_Desc"));
							data.setHydrapulperCol12Desc(rs.getString("hydrapulper_col12_Desc"));
							data.setHydrapulperCol13Desc(rs.getString("hydrapulper_col13_Desc"));
							data.setHydrapulperCol14Desc(rs.getString("hydrapulper_col14_Desc"));
							data.setHydrapulperCol15Desc(rs.getString("hydrapulper_col15_Desc"));
							data.setHydrapulperCol16Desc(rs.getString("hydrapulper_col16_Desc"));
							
							data.setDesccol1(rs.getString("desccol1"));
							data.setDesccol1Desc(rs.getString("desccol1Desc"));
							
							data.setEffluentsamplerworkingcondition(rs.getBoolean("effluentsamplerworkingcondition"));
							data.setEffluentsamplerworkingconditionDesc(rs.getString("effluentsamplerworkingconditionDesc"));
						 
							}
							catch(Exception e)
							{
								System.out.println(e.getMessage());
							}
							
							return data;
						}

					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return stockOperator;
	}

	@Override
	public long getDataCountDatePercentage(String position,String shift, String sdate,String edate) throws Exception {
		
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		
		List<StockOperator> daydata=null, nightdata=null;
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
		int days = CommonUtil.getDaysDiffernce(format.parse(sdate), format.parse(edate))+1;
		List<Integer> al=new ArrayList<Integer>();
		List<Integer> al2=new ArrayList<Integer>();
		if(daydata!=null||nightdata!=null)	
		{
			if(shift.equals("day")||shift.equals("both"))
			{
			for(StockOperator data: daydata)
			{
				 if(data.isMachinedown()!=true)
				 {	
				
				 if(data.isHdStorageChestCol1() == true||data.isHdStorageChestCol1() == false){count++;}
				 if(data.getHdStorageChestCol2Inbound()!=null&&!data.getHdStorageChestCol2Inbound().equals("")){count++;}
				 if(data.getHdStorageChestCol2Outbound()!=null&&!data.getHdStorageChestCol2Outbound().equals("")){count++;}
				 if(data.isHdStorageChestCol3() == true||data.isHdStorageChestCol3() == false){count++;}
				 if(data.getHdStorageChestCol4Inbound()!=null&&!data.getHdStorageChestCol4Inbound().equals("")){count++;}
				 if(data.getHdStorageChestCol4Outbound()!=null&&!data.getHdStorageChestCol4Outbound().equals("")){count++;}
				 if(data.getHdStorageChestCol4Desc()!=null&&!data.getHdStorageChestCol4Desc().equals("")){count++;}
				
				 if(data.isHdStorageChestCol5() == true||data.isHdStorageChestCol5() == false){count++;}
				 if(data.getHdStorageChestCol6Inbound()!=null&&!data.getHdStorageChestCol6Inbound().equals("")){count++;}
				 if(data.getHdStorageChestCol6Outbound()!=null&&!data.getHdStorageChestCol6Outbound().equals("")){count++;}
				 if(data.isHdStorageChestCol7() == true||data.isHdStorageChestCol7() == false){count++;}
				 if(data.getHdStorageChestCol8Inbound()!=null&&!data.getHdStorageChestCol8Inbound().equals("")){count++;}
				 if(data.getHdStorageChestCol8Outbound()!=null&&!data.getHdStorageChestCol8Outbound().equals("")){count++;}
				 if(data.isBlendChestCol1() == true||data.isBlendChestCol1() == false){count++;}
				 if(data.getBlendChestCol2Inbound()!=null&&!data.getBlendChestCol2Inbound().equals("")){count++;}
				 if(data.getBlendChestCol2Outbound()!=null&&!data.getBlendChestCol2Outbound().equals("")){count++;}
				 if(data.isBlendChestCol3() == true||data.isBlendChestCol3() == false){count++;}
				 if(data.getBlendChestCol4Inbound()!=null&&!data.getBlendChestCol4Inbound().equals("")){count++;}
				 if(data.getBlendChestCol4Outbound()!=null&&!data.getBlendChestCol4Outbound().equals("")){count++;}
				 if(data.isSeeScreenFeedTandCol1()  == true||data.isHdStorageChestCol1() == false){count++;}
				 if(data.getSeeScreenFeedTandCol2Inbound()!=null&&!data.getSeeScreenFeedTandCol2Inbound().equals("")){count++;}
				 if(data.getSeeScreenFeedTandcol2Outbound()!=null&&!data.getSeeScreenFeedTandcol2Outbound().equals("")){count++;}
				 if(data.isSeeScreenFeedTandCol3()  == true||data.isSeeScreenFeedTandCol3() == false){count++;}
				 if(data.getSeeScreenFeedTandCol4Inbound()!=null&&!data.getSeeScreenFeedTandCol4Inbound().equals("")){count++;}
				 if(data.getSeeScreenFeedTandcol4Outbound()!=null&&!data.getSeeScreenFeedTandcol4Outbound().equals("")){count++;}
				 if(data.isMachineChestCol1()  == true||data.isMachineChestCol1() == false){count++;}
				 if(data.getMachineChestCol2Inbound()!=null&&!data.getMachineChestCol2Inbound().equals("")){count++;}
				 if(data.getMachineChestCol2Outbound()!=null&&!data.getMachineChestCol2Outbound().equals("")){count++;}
				 if(data.isMachineChestCol3()  == true||data.isMachineChestCol3() == false){count++;}
				 if(data.getMachineChestCol4Inbound()!=null&&!data.getMachineChestCol4Inbound().equals("")){count++;}
				 if(data.getMachineChestCol4Outbound()!=null&&!data.getMachineChestCol4Outbound().equals("")){count++;}
				 if(data.isMachineChestCol5()  == true||data.isMachineChestCol5() == false){count++;}
				 if(data.getMachineChestCol6Inbound()!=null&&!data.getMachineChestCol6Inbound().equals("")){count++;}
				 if(data.getMachineChestCol6Outbound()!=null&&!data.getMachineChestCol6Outbound().equals("")){count++;}
				 if(data.isCleannersCol1()  == true||data.isCleannersCol1() == false){count++;}
				 if(data.isCleannersCol2()  == true||data.isCleannersCol2() == false){count++;}
				 if(data.getCleannersCol3Inbound()!=null&&!data.getCleannersCol3Inbound().equals("")){count++;}
				 if(data.getCleannersCol3Outbound()!=null&&!data.getCleannersCol3Outbound().equals("")){count++;}
				 if(data.isDeLinkStockCol1()  == true||data.isDeLinkStockCol1() == false){count++;}
				 if(data.getDeLinkStockCol2Inbound()!=null&&!data.getDeLinkStockCol2Inbound().equals("")){count++;}
				 if(data.getDeLinkStockCol2Outbound()!=null&&!data.getDeLinkStockCol2Outbound().equals("")){count++;}
				 if(data.isWhiteWaterCol1()  == true||data.isWhiteWaterCol1() == false){count++;}
				 if(data.getWhiteWaterCol2Inbound()!=null&&!data.getWhiteWaterCol2Inbound().equals("")){count++;}
				 if(data.getWhiteWaterCol2Outbound()!=null&&!data.getWhiteWaterCol2Outbound().equals("")){count++;}
				 if(data.isWhiteWaterCol3()  == true||data.isWhiteWaterCol3() == false){count++;}
				 if(data.getWhiteWaterCol4Inbound()!=null&&!data.getWhiteWaterCol4Inbound().equals("")){count++;}
				 if(data.getWhiteWaterCol4Outbound()!=null&&!data.getWhiteWaterCol4Outbound().equals("")){count++;}
				 if(data.isWhiteWaterCol5()  == true||data.isWhiteWaterCol5() == false){count++;}
				 if(data.getWhiteWaterCol6Inbound()!=null&&!data.getWhiteWaterCol6Inbound().equals("")){count++;}
				 if(data.getWhiteWaterCol6Outbound()!=null&&!data.getWhiteWaterCol6Outbound().equals("")){count++;}
				 if(data.isWhiteWaterCol7()  == true||data.isWhiteWaterCol7() == false){count++;}
				 if(data.getWhiteWaterCol8Inbound()!=null&&!data.getWhiteWaterCol8Inbound().equals("")){count++;}
				 if(data.getWhiteWaterCol8Outbound()!=null&&!data.getWhiteWaterCol8Outbound().equals("")){count++;}
				 if(data.isCouchPitCol1()  == true||data.isCouchPitCol1() == false){count++;}
				 if(data.isCouchPitCol2()  == true||data.isCouchPitCol2() == false){count++;}
				 if(data.getCouchPitCol3Inbound()!=null&&!data.getCouchPitCol3Inbound().equals("")){count++;}
				 if(data.getCouchPitCol3Outbound()!=null&&!data.getCouchPitCol3Outbound().equals("")){count++;}
				 if(data.isCouchPitCol4()  == true||data.isCouchPitCol4() == false){count++;}
				 if(data.getCouchPitCol5Inbound()!=null&&!data.getCouchPitCol5Inbound().equals("")){count++;}
				 if(data.getCouchPitCol5Outbound()!=null&&!data.getCouchPitCol5Outbound().equals("")){count++;}
				 if(data.isCouchPitCol6()  == true||data.isCouchPitCol6() == false){count++;}
				 if(data.getCouchPitCol7Inbound()!=null&&!data.getCouchPitCol7Inbound().equals("")){count++;}
				 if(data.getCouchPitCol7Outbound()!=null&&!data.getCouchPitCol7Outbound().equals("")){count++;}
				 if(data.getCouchPitCol8Inbound()!=null&&!data.getCouchPitCol8Inbound().equals("")){count++;}
				 if(data.getCouchPitCol8Outbound()!=null&&!data.getCouchPitCol8Outbound().equals("")){count++;}
				 if(data.isCouchPitCol9()  == true||data.isCouchPitCol9() == false){count++;}
				 if(data.getCouchPitCol10Inbound()!=null&&!data.getCouchPitCol10Inbound().equals("")){count++;}
				 if(data.getCouchPitCol10Outbound()!=null&&!data.getCouchPitCol10Outbound().equals("")){count++;}
				 if(data.getCouchPitCol11Inbound()!=null&&!data.getCouchPitCol11Inbound().equals("")){count++;}
				 if(data.getCouchPitCol11Outbound()!=null&&!data.getCouchPitCol11Outbound().equals("")){count++;}
				 if(data.isYankeePulperCol1()  == true||data.isYankeePulperCol1() == false){count++;}
				 if(data.isYankeePulperCol1Drain()  == true||data.isYankeePulperCol1Drain() == false){count++;}
				 if(data.isYankeePulperCol2()  == true||data.isYankeePulperCol2() == false){count++;}
				 if(data.getYankeePulperCol3Inbound()!=null&&!data.getYankeePulperCol3Inbound().equals("")){count++;}
				 if(data.getYankeePulperCol3Outbound()!=null&&!data.getYankeePulperCol3Outbound().equals("")){count++;}
				 if(data.isYankeePulperCol4()  == true||data.isYankeePulperCol4() == false){count++;}
				 if(data.getYankeePulperCol5Inbound()!=null&&!data.getYankeePulperCol5Inbound().equals("")){count++;}
				 if(data.getYankeePulperCol5Outbound()!=null&&!data.getYankeePulperCol5Outbound().equals("")){count++;}
				 if(data.isYankeePulperCol6()  == true||data.isYankeePulperCol6() == false){count++;}
				 if(data.getYankeePulperCol7Inbound()!=null&&!data.getYankeePulperCol7Inbound().equals("")){count++;}
				 if(data.getYankeePulperCol7Outbound()!=null&&!data.getYankeePulperCol7Outbound().equals("")){count++;}
				 if(data.isYankeePulperCol8()  == true||data.isYankeePulperCol8() == false){count++;}
				 if(data.getYankeePulperCol9Inbound()!=null&&!data.getYankeePulperCol9Inbound().equals("")){count++;}
				 if(data.getYankeePulperCol9Outbound()!=null&&!data.getYankeePulperCol9Outbound().equals("")){count++;}
				 if(data.getDesccol1()!=null&&!data.getDesccol1().equals("")){count++;}
			}else
			  count=6;
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
				daypercent=set/days;
				no++;
	  }
	if(shift.equals("night")||shift.equals("both"))
	{
		 	for(StockOperator data:nightdata)
		 	{
				if(data.isMachinedown()!=true)
				{	
					if(data.isBrokeDeflakerCol1() == true||data.isBrokeDeflakerCol1() == false){count++;}			
					 if(data.getBrokeDeflakerCol2Inbound()!=null&&!data.getBrokeDeflakerCol2Inbound().equals("")){count++;}
					 if(data.getBrokeDeflakerCol2Outbound()!=null&&!data.getBrokeDeflakerCol2Outbound().equals("")){count++;}			
					if(data.isBrokeDeflakerCol3() == true||data.isBrokeDeflakerCol3() == false){count++;}
					 if(data.getRefiningSystemCol1()!=null||!data.getRefiningSystemCol1().equals("")){count++;}
					if(data.isRefiningSystemCol2() == true||data.isRefiningSystemCol2() == false){count++;}
					 if(data.getRefiningSystemCol3Inbound()!=null&&!data.getRefiningSystemCol3Inbound().equals("")){count++;}
					 if(data.getRefiningSystemCol3Outbound()!=null&&!data.getRefiningSystemCol3Outbound().equals("")){count++;}
					 if(data.getRefiningSystemCol4()!=null&&!data.getRefiningSystemCol4().equals("")){count++;}
					 if(data.getRefiningSystemCol5()!=null&&!data.getRefiningSystemCol5().equals("")){count++;}
					 if(data.getRefiningSystemCol6()!=null&&!data.getRefiningSystemCol6().equals("")){count++;}
					if(data.isRefiningSystemCol7() == true||data.isRefiningSystemCol7() == false){count++;}
					 if(data.getRefiningSystemCol8Inbound()!=null&&!data.getRefiningSystemCol8Inbound().equals("")){count++;}
					 if(data.getRefiningSystemCol8Outbound()!=null&&!data.getRefiningSystemCol8Outbound().equals("")){count++;}
					 if(data.getRefiningSystemCol9()!=null&&!data.getRefiningSystemCol9().equals("")){count++;}
					 if(data.getRefiningSystemCol10()!=null&&!data.getRefiningSystemCol10().equals("")){count++;}
					if(data.isWhiteWaterPumpCol1() == true||data.isWhiteWaterPumpCol1() == false){count++;}
					 if(data.getWhiteWaterPumpCol2Inbound()!=null&&!data.getWhiteWaterPumpCol2Inbound().equals("")){count++;}
					 if(data.getWhiteWaterPumpCol2Outbound()!=null&&!data.getWhiteWaterPumpCol2Outbound().equals("")){count++;}
					if(data.isWhiteWaterPumpCol3() == true||data.isWhiteWaterPumpCol3() == false){count++;}
					 if(data.getWhiteWaterPumpCol4Inbound()!=null&&!data.getWhiteWaterPumpCol4Inbound().equals("")){count++;}
					 if(data.getWhiteWaterPumpCol4Outbound()!=null&&!data.getWhiteWaterPumpCol4Outbound().equals("")){count++;}
					if(data.isWhiteWaterPumpCol5() == true||data.isWhiteWaterPumpCol5() == false){count++;}
					 if(data.getWhiteWaterPumpCol6Inbound()!=null&&!data.getWhiteWaterPumpCol6Inbound().equals("")){count++;}
					 if(data.getWhiteWaterPumpCol6Outbound()!=null&&!data.getWhiteWaterPumpCol6Outbound().equals("")){count++;}
					 if(data.getSilloCol1()!=null&&!data.getSilloCol1().equals("")){count++;}
					if(data.isSilloCol2() == true||data.isSilloCol2() == false){count++;}
					 if(data.getSilloCol3()!=null&&!data.getSilloCol3().equals("")){count++;}
					if(data.isYankeePumplerCol1() == true||data.isYankeePumplerCol1() == false){count++;}
					if(data.isYankeePumplerCol1Drain() == true||data.isYankeePumplerCol1Drain() == false){count++;}
					if(data.isYankeePumplerCol2() == true||data.isYankeePumplerCol2() == false){count++;}
					 if(data.getYankeePumplerCol3Inbound()!=null&&!data.getYankeePumplerCol3Inbound().equals("")){count++;}
					 if(data.getYankeePumplerCol3Outbound()!=null&&!data.getYankeePumplerCol3Outbound().equals("")){count++;}
					if(data.isYankeePumplerCol4() == true||data.isYankeePumplerCol4() == false){count++;}
					 if(data.getYankeePumplerCol5Inbound()!=null&&!data.getYankeePumplerCol5Inbound().equals("")){count++;}
					 if(data.getYankeePumplerCol5Outbound()!=null&&!data.getYankeePumplerCol5Outbound().equals("")){count++;}
					if(data.isYankeePumplerCol6() == true||data.isYankeePumplerCol6() == false){count++;}
					 if(data.getYankeePumplerCol7Inbound()!=null&&!data.getYankeePumplerCol7Inbound().equals("")){count++;}
					 if(data.getYankeePumplerCol7Outbound()!=null&&!data.getYankeePumplerCol7Outbound().equals("")){count++;}
					if(data.isYankeePumplerCol8() == true||data.isYankeePumplerCol8() == false){count++;}
					 if(data.getYankeePumplerCol9Inbound()!=null&&!data.getYankeePumplerCol9Inbound().equals("")){count++;}
					 if(data.getYankeePumplerCol9Outbound()!=null&&!data.getYankeePumplerCol9Outbound().equals("")){count++;}
					 if(data.getBrokeSystemCol1()!=null&&!data.getBrokeSystemCol1().equals("")){count++;}
					 if(data.getBrokeSystemCol2()!=null&&!data.getBrokeSystemCol2().equals("")){count++;}
					 if(data.getBrokeSystemCol3()!=null&&!data.getBrokeSystemCol3().equals("")){count++;}
					 if(data.getBrokeSystemCol4()!=null&&!data.getBrokeSystemCol4().equals("")){count++;}
					 if(data.getBrokeSystemCol5()!=null&&!data.getBrokeSystemCol5().equals("")){count++;}
					 if(data.getBrokeSystemCol6()!=null&&!data.getBrokeSystemCol6().equals("")){count++;}
					 if(data.getBrokeSystemCol7()!=null&&!data.getBrokeSystemCol7().equals("")){count++;}
					 if(data.getBrokeSystemCol8()!=null&&!data.getBrokeSystemCol8().equals("")){count++;}
					 if(data.getBrokeSystemCol9()!=null&&!data.getBrokeSystemCol9().equals("")){count++;}
					 if(data.getBrokeSystemCol10()!=null&&!data.getBrokeSystemCol10().equals("")){count++;}
					 if(data.getBrokeSystemCol11()!=null&&!data.getBrokeSystemCol11().equals("")){count++;}
					 if(data.getSaveAllCol1()!=null&&!data.getSaveAllCol1().equals("")){count++;}
					if(data.isSaveAllCol2() == true||data.isSaveAllCol2() == false){count++;}
					if(data.isSaveAllCol3() == true||data.isSaveAllCol3() == false){count++;}
					 if(data.getSaveAllCol4Inbound()!=null&&!data.getSaveAllCol4Inbound().equals("")){count++;}
					 if(data.getSaveAllCol4Outbound()!=null&&!data.getSaveAllCol4Outbound().equals("")){count++;}
					if(data.isSaveAllCol5() == true||data.isSaveAllCol5() == false){count++;}
					if(data.isSaveAllCol6() == true||data.isSaveAllCol6() == false){count++;}
					if(data.isHydrapulperCol1() == true||data.isHydrapulperCol1() == false){count++;}
					 if(data.getHydrapulperCol2Inbound()!=null&&!data.getHydrapulperCol2Inbound().equals("")){count++;}
					 if(data.getHydrapulperCol2outbound()!=null&&!data.getHydrapulperCol2outbound().equals("")){count++;}
					if(data.isHydrapulperCol3() == true||data.isHydrapulperCol3() == false){count++;}
					 if(data.getHydrapulperCol4Inbound()!=null&&!data.getHydrapulperCol4Inbound().equals("")){count++;}
					 if(data.getHydrapulperCol4outbound()!=null&&!data.getHydrapulperCol4outbound().equals("")){count++;}
					if(data.isHydrapulperCol5() == true||data.isHydrapulperCol5() == false){count++;}
					if(data.isHydrapulperCol6() == true||data.isHydrapulperCol6() == false){count++;}
					if(data.isHydrapulperCol7() == true||data.isHydrapulperCol7() == false){count++;}
					 if(data.getHydrapulperCol8Inbound()!=null&&!data.getHydrapulperCol8Inbound().equals("")){count++;}
					 if(data.getHydrapulperCol8outbound()!=null&&!data.getHydrapulperCol8outbound().equals("")){count++;}
					if(data.isHydrapulperCol9() == true||data.isHydrapulperCol9() == false){count++;}
					 if(data.getHydrapulperCol10Inbound()!=null&&!data.getHydrapulperCol10Inbound().equals("")){count++;}
					 if(data.getHydrapulperCol10outbound()!=null&&!data.getHydrapulperCol10outbound().equals("")){count++;}
					if(data.isHydrapulperCol11() == true||data.isHydrapulperCol11() == false){count++;}
					if(data.isHydrapulperCol12() == true||data.isHydrapulperCol12() == false){count++;}
					if(data.isHydrapulperCol13() == true||data.isHydrapulperCol13() == false){count++;}
					 if(data.getHydrapulperCol14Inbound()!=null&&!data.getHydrapulperCol14Inbound().equals("")){count++;}
					 if(data.getHydrapulperCol14outbound()!=null&&!data.getHydrapulperCol14outbound().equals("")){count++;}
					if(data.isHydrapulperCol15() == true||data.isHydrapulperCol15() == false){count++;}
					 if(data.getHydrapulperCol16Inbound()!=null&&!data.getHydrapulperCol16Inbound().equals("")){count++;}
					 if(data.getHydrapulperCol16outbound()!=null&&!data.getHydrapulperCol16outbound().equals("")){count++;}
					 if(data.getDesccol1()!=null&&!data.getDesccol1().equals("")){count++;}
					
				}else 
					count=6;
				al2.add(count);
				count=0;
			}
			 set=0;
			for(int n:al2)
			{
				if(n>=5)
				{
					set=set+100;
				}
			}
			nightpercent=set/days;
			no++;
	}
		if(no==0)no=1;
			
			percentage=(daypercent+nightpercent)/no;
}
	return percentage;	
}
	/* (non-Javadoc)
	 * @see com.st.obcc.dao.StockOperatorDao#getDataCountDatePercentage(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 
	@Override
	public long getDataCountDatePercentage(String position, String Sdate,
			String edate, String shift) throws Exception {
		// TODO Auto-generated method stub
		Date sDate=CommonUtil.checkDate(Sdate, dateFormat);
		Date esDate=CommonUtil.checkDate(edate, dateFormat);
		
		final  int days=CommonUtil.getDaysDiffernce(sDate, esDate);
         int total1 = 0;
         
        
        if(shift.equalsIgnoreCase("day")|| shift.equalsIgnoreCase("night")){
        	total1 = days;
        }else{
        	total1 = days*2;
        }

        final int total = total1;
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceQRT);
		Object[] param=null;
		String sql;
		 
			if(shift.equalsIgnoreCase("day")|| shift.equalsIgnoreCase("night"))
			{
				sql="SELECT COUNT(*) As [TotalDataEntry], ( "
						+ "SELECT COUNT(*) As [totaldata] "
						+ "FROM stock_operator "
						+ " WHERE (date between ? AND ? ) and shift=?"
						+ " )as TotalExport FROM stock_operator e1 where shift=?";
						param=new Object[]{
							Sdate,
							edate,
							shift,
							shift
						};
			}
			else
			{
				sql="SELECT COUNT(*) As [TotalDataEntry], ( "
						+ "SELECT COUNT(*) As [totaldata] "
						+ "FROM stock_operator "
						+ " WHERE (date between ? AND ? )"
						+ " )as TotalExport FROM stock_operator e1 ";
						param=new Object[]{
							Sdate,
							edate	
						};
			}
			
			 
			List<StockOperator> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<StockOperator>(){

							@Override
							public StockOperator mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								
								int totalDataEntry = rs.getInt("TotalDataEntry");
								int totalExport = rs.getInt("TotalExport");
								
								//int percentage = totalExport*100/totalDataEntry;
								int percentage = 0;
								if(total == 0)
								{
									percentage = 100;	
								}
								else
								{
									percentage = totalExport*100/total;
								}
								
								StockOperator wrapperProduction=new StockOperator();
								wrapperProduction.setProcessbarpercentage(percentage);
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return wrapperProductions.get(0).getProcessbarpercentage();
	}

	 (non-Javadoc)
	 * @see com.st.obcc.dao.StockOperatorDao#getDataCountDatePercentage(java.lang.String, java.lang.String)
	 
	@Override
	public double getDataCountDatePercentage(String Sdate, String edate)
			throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
		
		Date sDate=CommonUtil.checkDate(Sdate, dateFormat);
		Date esDate=CommonUtil.checkDate(edate, dateFormat);
		
 
        
        
		final  int days=CommonUtil.getDaysDiffernce(sDate, esDate);
        
        final int total = days*2;
        
       // System.out.println("getDaysDiff"+days);
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSourceQRT);
		Object[] param=null;
		String sql;
		 
			sql="SELECT COUNT(*) As [TotalDataEntry], ( "
					+ "SELECT COUNT(*) As [totaldata] "
					+ "FROM stock_operator "
					+ " WHERE (date between ? AND ? )"
					+ " )as TotalExport FROM stock_operator e1 ";
					param=new Object[]{
							Sdate,
						edate	
					};
			 
			List<StockOperator> wrapperProductions=null;
			try {
				wrapperProductions=jdbcTemplate.query(sql,param, new RowMapper<StockOperator>(){

							@Override
							public StockOperator mapRow(ResultSet rs, int arg1)
									throws SQLException {
								
								
								int totalDataEntry = rs.getInt("TotalDataEntry");
								int totalExport = rs.getInt("TotalExport");
								
								//int percentage = totalExport*100/totalDataEntry;
								double percentage = totalExport*100/total;
								
								
								StockOperator wrapperProduction=new StockOperator();
								wrapperProduction.setPercentage(percentage);
								return wrapperProduction;
							}
							
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return wrapperProductions.get(0).getPercentage();
	}*/
}