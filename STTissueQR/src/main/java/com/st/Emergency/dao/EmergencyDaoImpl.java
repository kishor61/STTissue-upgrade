/**
 *May 25, 2021
 *EmergencyServiceImpl.java
 * TODO
 *com.st.Emergency.Service
 *EmergencyServiceImpl.java
 *Sohan Lal 
 */
package com.st.Emergency.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.st.Emergency.model.EmergencyIncident;
import com.st.Emergency.model.IncidentReport;
import com.st.common.DatabaseUtil;

/**
 * @author kishore
 *
 */
@Repository
public class EmergencyDaoImpl implements EmergencyDao {
	@Autowired
	private JdbcTemplate dataSourceQRTTemplate;

	@Override
	public Integer saveorUpdate(EmergencyIncident data) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRTTemplate);
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		paramSource.addValue("incidentType", data.getIncidentType());
		paramSource.addValue("employeeNumber", data.getEmployeeNumber());
		paramSource.addValue("edate", data.getEdate());
		paramSource.addValue("crew", data.getCrew());
		paramSource.addValue("shift", data.getShift());
		paramSource.addValue("safeReport", data.getSafeReport());
		paramSource.addValue("status", data.getStatus());
		paramSource.addValue("yourStartArea", data.getYourStartArea());
		paramSource.addValue("dateOfIncident", data.getDateOfIncident());
		paramSource.addValue("timeOfIncident", data.getTimeOfIncident());
		paramSource.addValue("dateReported", data.getDateReported());
		paramSource.addValue("starIncidentLocation", data.getStarIncidentLocation());
		paramSource.addValue("locationIncidentOccured", data.getLocationIncidentOccured());
		paramSource.addValue("descpOfEvent", data.getDescpOfEvent());
		paramSource.addValue("starCategory", data.getStarCategory());
		paramSource.addValue("furtherFollowUpRequested", data.getFurtherFollowUpRequested());
		paramSource.addValue("isView", data.isEdited());
		paramSource.addValue("effectedbytheincident", data.getEffectedbytheincident());

		String sqlinsert = "insert into EmergencyIncident(	incidentType,	employeeNumber,	edate,	crew,	shift,	safeReport,	status,	yourStartArea,	dateOfIncident ,"
				+ "timeOfIncident,	dateReported,	starIncidentLocation,	locationIncidentOccured,	descpOfEvent,	starCategory,furtherFollowUpRequested,effectedbytheincident)"
				+ "VALUES (:incidentType,:employeeNumber,:edate,:crew,:shift,:safeReport,:status,:yourStartArea,:dateOfIncident ,"
				+ ":timeOfIncident,:dateReported,:starIncidentLocation,:locationIncidentOccured,:descpOfEvent,:starCategory,:furtherFollowUpRequested,:effectedbytheincident)";

		String sqlupdate = "update EmergencyIncident SET	incidentType=:incidentType,	employeeNumber=:employeeNumber,	edate=:edate,	crew=:crew,	shift=:shift,	"
				+ "safeReport=:safeReport,	status=:status,	yourStartArea=:yourStartArea,	dateOfIncident=:dateOfIncident ,"
				+ "timeOfIncident=:timeOfIncident,dateReported=:dateReported,	starIncidentLocation=:starIncidentLocation,	locationIncidentOccured=:locationIncidentOccured,"
				+ "descpOfEvent=:descpOfEvent,starCategory=:starCategory,furtherFollowUpRequested=:furtherFollowUpRequested ,isView=:isView,effectedbytheincident=:effectedbytheincident where id=:id";
		int i = 0;
		if (data.getId() == 0) {
			i = jdbcTemplate.update(sqlinsert, paramSource);
		} else {
			paramSource.addValue("id", data.getId());
			i = jdbcTemplate.update(sqlupdate, paramSource);
		}
		return i;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<EmergencyIncident> getData(String sdate, String edate) {
		String sql = "select * from [EmergencyIncident] where edate BETWEEN ? AND ?";
		List<EmergencyIncident> emergencyIncident = null;
		try {
			emergencyIncident = dataSourceQRTTemplate.query(sql, new Object[] { sdate, edate },
					new RowMapper<EmergencyIncident>() {

						@Override
						public EmergencyIncident mapRow(ResultSet rs, int arg1) throws SQLException {
							EmergencyIncident data = new EmergencyIncident();
							data.setId(rs.getInt("id"));
							data.setIncidentType(rs.getString("incidentType"));
							data.setEmployeeNumber(rs.getString("employeeNumber"));
							data.setEdate(rs.getString("edate"));
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setSafeReport(rs.getString("safeReport"));
							data.setStatus(rs.getString("status"));
							data.setYourStartArea(rs.getString("yourStartArea"));
							data.setDateOfIncident(rs.getString("dateOfIncident"));
							data.setDateReported(rs.getString("dateReported"));
							data.setStarIncidentLocation(rs.getString("starIncidentLocation"));
							data.setLocationIncidentOccured(rs.getString("locationIncidentOccured"));
							data.setDescpOfEvent(rs.getString("descpOfEvent"));
							data.setStarCategory(rs.getString("starCategory"));
							data.setFurtherFollowUpRequested(rs.getString("furtherFollowUpRequested"));
							data.setEffectedbytheincident(rs.getString("effectedbytheincident"));
							return data;
						}
					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emergencyIncident;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.Emergency.dao.EmergencyDao#getData(int)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<EmergencyIncident> getData(int id) {
		String sql = "select * from [EmergencyIncident] where id=?";
		List<EmergencyIncident> emergencyIncident = null;
		try {
			emergencyIncident = dataSourceQRTTemplate.query(sql, new Object[] { id },
					new RowMapper<EmergencyIncident>() {

						@Override
						public EmergencyIncident mapRow(ResultSet rs, int arg1) throws SQLException {
							EmergencyIncident data = new EmergencyIncident();
							data.setId(rs.getInt("id"));
							data.setIncidentType(rs.getString("incidentType"));
							data.setEmployeeNumber(rs.getString("employeeNumber"));
							data.setEdate(rs.getString("edate"));
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setSafeReport(rs.getString("safeReport"));
							data.setStatus(rs.getString("status"));
							data.setYourStartArea(rs.getString("yourStartArea"));
							data.setDateOfIncident(rs.getString("dateOfIncident"));
							data.setDateReported(rs.getString("dateReported"));
							data.setStarIncidentLocation(rs.getString("starIncidentLocation"));
							data.setLocationIncidentOccured(rs.getString("locationIncidentOccured"));
							data.setDescpOfEvent(rs.getString("descpOfEvent"));
							data.setStarCategory(rs.getString("starCategory"));
							data.setFurtherFollowUpRequested(rs.getString("furtherFollowUpRequested"));
							data.setEffectedbytheincident(rs.getString("effectedbytheincident"));
							return data;
						}
					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emergencyIncident;
	}

	@Override
	public List<EmergencyIncident> getData() {
		String sql = "select TOP 1 * from [EmergencyIncident] order by id desc";
		List<EmergencyIncident> emergencyIncident = null;
		try {
			emergencyIncident = dataSourceQRTTemplate.query(sql, new RowMapper<EmergencyIncident>() {

				@Override
				public EmergencyIncident mapRow(ResultSet rs, int arg1) throws SQLException {
					EmergencyIncident data = new EmergencyIncident();
					data.setId(rs.getInt("id"));
					data.setIncidentType(rs.getString("incidentType"));
					data.setEmployeeNumber(rs.getString("employeeNumber"));
					data.setEdate(rs.getString("edate"));
					data.setCrew(rs.getString("crew"));
					data.setShift(rs.getString("shift"));
					data.setSafeReport(rs.getString("safeReport"));
					data.setStatus(rs.getString("status"));
					data.setYourStartArea(rs.getString("yourStartArea"));
					data.setDateOfIncident(rs.getString("dateOfIncident"));
					data.setDateReported(rs.getString("dateReported"));
					data.setStarIncidentLocation(rs.getString("starIncidentLocation"));
					data.setLocationIncidentOccured(rs.getString("locationIncidentOccured"));
					data.setDescpOfEvent(rs.getString("descpOfEvent"));
					data.setStarCategory(rs.getString("starCategory"));
					data.setFurtherFollowUpRequested(rs.getString("furtherFollowUpRequested"));
					data.setEffectedbytheincident(rs.getString("effectedbytheincident"));
					return data;
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emergencyIncident;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.Emergency.dao.EmergencyDao#getData(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<EmergencyIncident> getData(String sdate, String edate, String status, String starIncidentLocation,
			String incidentType, String locationIncidentOccured, String team) {

		List<Object> oParams = new ArrayList<>();

		oParams.add(sdate);
		oParams.add(edate);
		String sql = "select * from [EmergencyIncident] where ( edate BETWEEN ? AND ? )";
		if (!status.equals("-1")) {
			sql += " AND status=?";
			oParams.add(status);
		}
		if (!team.equals("-1")) {
			sql += " AND crew=?";
			oParams.add(team);
		}
		if (!starIncidentLocation.equals("")) {
			String starIncidentLocations[] = starIncidentLocation.split(",");
			for (Object obj : starIncidentLocations) {
				StringBuilder sb1 = new StringBuilder();
				sb1.append(obj.toString()).append(",");
				String starIncidentLocationss = sb1.substring(0, sb1.length() - 1).toString();
				oParams.add(starIncidentLocationss);
			}
			String inSql = String.join(",", Collections.nCopies(starIncidentLocations.length, "?"));
			sql += " AND starIncidentLocation IN(" + inSql + ")";
		}
		if (!incidentType.equals("")) {
			String incidentTypes[] = incidentType.split(",");
			for (Object obj : incidentTypes) {
				StringBuilder sb2 = new StringBuilder();
				sb2.append(obj.toString()).append(",");
				String incidentTypess = sb2.substring(0, sb2.length() - 1);
				oParams.add(incidentTypess);

			}
			String inSql = String.join(",", Collections.nCopies(incidentTypes.length, "?"));
			sql += " AND incidentType IN(" + inSql + ")";
		}
		if (!locationIncidentOccured.equals("")) {
			String locationIncidentOccureds[] = locationIncidentOccured.split(",");
			for (Object obj : locationIncidentOccureds) {
				StringBuilder sb3 = new StringBuilder();
				sb3.append(obj.toString()).append(",");
				String locationIncidentOccuredss = sb3.substring(0, sb3.length() - 1);
				oParams.add(locationIncidentOccuredss);

			}
			String inSql = String.join(",", Collections.nCopies(locationIncidentOccureds.length, "?"));
			sql += " AND locationIncidentOccured IN(" + inSql + ")";
		}

		// AND status=? OR starIncidentLocation IN(?) OR incidentType IN(?) OR
		// locationIncidentOccured IN(?)";
		List<EmergencyIncident> emergencyIncident = null;
		try {
			emergencyIncident = dataSourceQRTTemplate.query(sql, oParams.toArray(), new RowMapper<EmergencyIncident>() {

				@Override
				public EmergencyIncident mapRow(ResultSet rs, int arg1) throws SQLException {
					EmergencyIncident data = new EmergencyIncident();
					data.setId(rs.getInt("id"));
					data.setIncidentType(rs.getString("incidentType"));
					data.setEmployeeNumber(rs.getString("employeeNumber"));
					data.setEdate(rs.getString("edate"));
					data.setCrew(rs.getString("crew"));
					data.setShift(rs.getString("shift"));
					data.setSafeReport(rs.getString("safeReport"));
					data.setStatus(rs.getString("status"));
					data.setYourStartArea(rs.getString("yourStartArea"));
					data.setDateOfIncident(rs.getString("dateOfIncident"));
					data.setTimeOfIncident(rs.getString("timeOfIncident"));
					data.setDateReported(rs.getString("dateReported"));
					data.setStarIncidentLocation(rs.getString("starIncidentLocation"));
					data.setLocationIncidentOccured(rs.getString("locationIncidentOccured"));
					data.setDescpOfEvent(rs.getString("descpOfEvent"));
					data.setStarCategory(rs.getString("starCategory"));
					data.setFurtherFollowUpRequested(rs.getString("furtherFollowUpRequested"));
					data.setEdited(rs.getBoolean("isView"));
					data.setEffectedbytheincident(rs.getString("effectedbytheincident"));
					return data;
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emergencyIncident;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.Emergency.dao.EmergencyDao#getDataWithDate(java.lang.String,
	 * java.lang.String)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<EmergencyIncident> getDataWithDate(String sdate, String edate) {
		String sql = "select * from [EmergencyIncident] where  edate BETWEEN ? AND ? ";
		List<EmergencyIncident> emergencyIncident = null;
		try {
			emergencyIncident = dataSourceQRTTemplate.query(sql, new Object[] { sdate, edate },
					new RowMapper<EmergencyIncident>() {

						@Override
						public EmergencyIncident mapRow(ResultSet rs, int arg1) throws SQLException {
							EmergencyIncident data = new EmergencyIncident();
							data.setId(rs.getInt("id"));
							data.setIncidentType(rs.getString("incidentType"));
							data.setEmployeeNumber(rs.getString("employeeNumber"));
							data.setEdate(rs.getString("edate"));
							data.setCrew(rs.getString("crew"));
							data.setShift(rs.getString("shift"));
							data.setSafeReport(rs.getString("safeReport"));
							data.setStatus(rs.getString("status"));
							data.setYourStartArea(rs.getString("yourStartArea"));
							data.setDateOfIncident(rs.getString("dateOfIncident"));
							data.setTimeOfIncident(rs.getString("timeOfIncident"));
							data.setDateReported(rs.getString("dateReported"));
							data.setStarIncidentLocation(rs.getString("starIncidentLocation"));
							data.setLocationIncidentOccured(rs.getString("locationIncidentOccured"));
							data.setDescpOfEvent(rs.getString("descpOfEvent"));
							data.setStarCategory(rs.getString("starCategory"));
							data.setFurtherFollowUpRequested(rs.getString("furtherFollowUpRequested"));
							data.setEdited(rs.getBoolean("isView"));
							data.setEffectedbytheincident(rs.getString("effectedbytheincident"));
							return data;
						}
					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emergencyIncident;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.Emergency.dao.EmergencyDao#updateViewStatus()
	 */
	@Override
	public void updateViewStatus(int id) {
		String sql = "update EmergencyIncident SET	isView='true' where id = " + id;
		dataSourceQRTTemplate.execute(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.st.Emergency.dao.EmergencyDao#incidentReportSaveorUpdate(com.st.Emergency
	 * .model.IncidentReport)
	 */
	@Override
	public Integer incidentReportSaveorUpdate(IncidentReport data) {

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSourceQRTTemplate);
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		paramSource.addValue("number", data.getNumber());
		paramSource.addValue("owner", data.getOwner());
		paramSource.addValue("revision", data.getRevision());
		paramSource.addValue("date1", data.getDate1());
		paramSource.addValue("investigator", data.getInvestigator());
		paramSource.addValue("incidentType", data.getIncidentType());
		paramSource.addValue("area", data.getArea());
		paramSource.addValue("date2", data.getDate2());
		paramSource.addValue("preCheck1", data.isPreCheck1());
		paramSource.addValue("preCheck2", data.isPreCheck2());
		paramSource.addValue("preCheck3", data.isPreCheck3());
		paramSource.addValue("PreCheck4", data.isPreCheck4());
		paramSource.addValue("initCheck1", data.isInitCheck1());
		paramSource.addValue("initValue1", data.getInitValue1());
		paramSource.addValue("initCheck2", data.isInitCheck2());
		paramSource.addValue("initValue2", data.getInitValue2());
		paramSource.addValue("initCheck3", data.isInitCheck3());
		paramSource.addValue("initValue3", data.getInitValue3());
		paramSource.addValue("initCheck4", data.isInitCheck4());
		paramSource.addValue("initValue4", data.getInitValue4());
		paramSource.addValue("initCheck5", data.isInitCheck5());
		paramSource.addValue("initCheck6", data.isInitCheck6());
		paramSource.addValue("initCheck7", data.isInitCheck7());
		paramSource.addValue("initCheck8", data.isInitCheck8());
		paramSource.addValue("initCheck9", data.isInitCheck9());
		paramSource.addValue("descOfIncident", data.getDescOfIncident());
		paramSource.addValue("causeOfIncident", data.getCauseOfIncident());
		paramSource.addValue("lackOfCheckBox", data.isLackOfCheckBox());
		paramSource.addValue("proceNotFollCheckbox", data.isProceNotFollCheckbox());
		paramSource.addValue("jsaCheckBox", data.isJsaCheckBox());
		paramSource.addValue("lackOfTraningCheckbox", data.isLackOfTraningCheckbox());
		paramSource.addValue("preUseInspecCheckbox", data.isPreUseInspecCheckbox());
		paramSource.addValue("equipmtCheckbox", data.isEquipmtCheckbox());
		paramSource.addValue("correctToolCheckbox", data.isCorrectToolCheckbox());
		paramSource.addValue("enviromentCondtnCheckbox", data.isEnviromentCondtnCheckbox());
		paramSource.addValue("walkingSurfaceCheckbox", data.isWalkingSurfaceCheckbox());
		paramSource.addValue("lightVisibilityCheckbox", data.isLightVisibilityCheckbox());
		paramSource.addValue("poorHousekeepingCheckbox", data.isPoorHousekeepingCheckbox());
		paramSource.addValue("ergonCheckbox", data.isErgonCheckbox());
		paramSource.addValue("tightCheckbox", data.isTightCheckbox());
		paramSource.addValue("lineOfFireCheckbox", data.isLineOfFireCheckbox());
		paramSource.addValue("eyesOnTaskCheckbox", data.isEyesOnTaskCheckbox());
		paramSource.addValue("hurriedCheckbox", data.isHurriedCheckbox());
		paramSource.addValue("frustratedCheckbox", data.isFrustratedCheckbox());
		paramSource.addValue("fatiguedCheckbox", data.isFatiguedCheckbox());
		paramSource.addValue("complacentCheckbox", data.isComplacentCheckbox());
		paramSource.addValue("EmergencyIncidentID", data.getEmergencyIncidentID());

		int i = 0;
		if (data.getId() == 0) {
			String sql = DatabaseUtil.getSQL("sql/insertIncidentReport.sql");
			i = jdbcTemplate.update(sql, paramSource);
		} else {
			paramSource.addValue("id", data.getId());
			String sql = DatabaseUtil.getSQL("sql/updateIncidentReport.sql");
			i = jdbcTemplate.update(sql, paramSource);
		}
		return i;
	}

	@SuppressWarnings("deprecation")
	@Override
	public IncidentReport getIncidentReportData(int id) {
		String sql = "select * from [EmergencyIncident_report] where EmergencyIncidentID=?";
		IncidentReport incidentReport = null;
		try {
			incidentReport = dataSourceQRTTemplate.queryForObject(sql, new Object[] { id },
					new RowMapper<IncidentReport>() {

						@Override
						public IncidentReport mapRow(ResultSet rs, int arg1) throws SQLException {
							IncidentReport data = new IncidentReport();
							data.setId(rs.getInt("id"));
							data.setIncidentType(rs.getString("incidentType"));
							data.setNumber(rs.getString("number"));
							data.setOwner(rs.getString("owner"));
							data.setRevision(rs.getString("revision"));
							data.setDate1(rs.getString("date1"));
							data.setInvestigator(rs.getString("investigator"));
							data.setIncidentType(rs.getString("incidentType"));
							data.setArea(rs.getString("area"));
							data.setDate2(rs.getString("date2"));
							data.setPreCheck1(rs.getBoolean("preCheck1"));
							data.setPreCheck2(rs.getBoolean("preCheck2"));
							data.setPreCheck3(rs.getBoolean("preCheck3"));
							data.setPreCheck4(rs.getBoolean("PreCheck4")); // data.isPreCheck4());
							data.setInitCheck1(rs.getBoolean("initCheck1"));// data.isInitCheck1());
							data.setInitValue1(rs.getString("initValue1")); /// data.getInitValue1());
							data.setInitCheck2(rs.getBoolean("initCheck2"));// data.isInitCheck2() );
							data.setInitValue2(rs.getString("initValue2"));// data.getInitValue2() );
							data.setInitCheck3(rs.getBoolean("initCheck3"));// data.isInitCheck3() );
							data.setInitValue3(rs.getString("initValue3")); // data.getInitValue3());
							data.setInitCheck4(rs.getBoolean("initCheck4")); // data.isInitCheck4());
							data.setInitValue4(rs.getString("initValue4")); // data.getInitValue4());
							data.setInitCheck5(rs.getBoolean("initCheck5")); // data.isInitCheck5());
							data.setInitCheck6(rs.getBoolean("initCheck6")); // data.isInitCheck6());
							data.setInitCheck7(rs.getBoolean("initCheck7"));/// data.isInitCheck7() );
							data.setInitCheck8(rs.getBoolean("initCheck8"));
							data.setInitCheck9(rs.getBoolean("initCheck9"));
							data.setDescOfIncident(rs.getString("descOfIncident"));
							data.setCauseOfIncident(rs.getString("causeOfIncident"));
							data.setLackOfCheckBox(rs.getBoolean("lackOfCheckBox"));
							data.setProceNotFollCheckbox(rs.getBoolean("proceNotFollCheckbox"));
							data.setJsaCheckBox(rs.getBoolean("jsaCheckBox"));
							data.setLackOfTraningCheckbox(rs.getBoolean("lackOfTraningCheckbox"));
							data.setPreUseInspecCheckbox(rs.getBoolean("preUseInspecCheckbox"));
							data.setEquipmtCheckbox(rs.getBoolean("equipmtCheckbox"));
							data.setCorrectToolCheckbox(rs.getBoolean("correctToolCheckbox"));
							data.setEnviromentCondtnCheckbox(rs.getBoolean("enviromentCondtnCheckbox"));
							data.setWalkingSurfaceCheckbox(rs.getBoolean("walkingSurfaceCheckbox"));
							data.setLightVisibilityCheckbox(rs.getBoolean("lightVisibilityCheckbox"));
							data.setPoorHousekeepingCheckbox(rs.getBoolean("poorHousekeepingCheckbox"));
							data.setErgonCheckbox(rs.getBoolean("ergonCheckbox"));
							data.setTightCheckbox(rs.getBoolean("tightCheckbox"));
							data.setLineOfFireCheckbox(rs.getBoolean("lineOfFireCheckbox"));
							data.setEyesOnTaskCheckbox(rs.getBoolean("eyesOnTaskCheckbox"));
							data.setHurriedCheckbox(rs.getBoolean("hurriedCheckbox"));
							data.setFrustratedCheckbox(rs.getBoolean("frustratedCheckbox"));
							data.setFatiguedCheckbox(rs.getBoolean("fatiguedCheckbox"));
							data.setComplacentCheckbox(rs.getBoolean("complacentCheckbox"));
							data.setEmergencyIncidentID(rs.getInt("EmergencyIncidentID"));
							return data;
						}
					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return incidentReport;
	}

	@Override
	public IncidentReport getIncidentReportDataTop1() {
		String sql = "select top 1 from [EmergencyIncident_report] order by id desc";
		IncidentReport incidentReport = null;
		try {
			incidentReport = dataSourceQRTTemplate.queryForObject(sql, new RowMapper<IncidentReport>() {

				@Override
				public IncidentReport mapRow(ResultSet rs, int arg1) throws SQLException {
					IncidentReport data = new IncidentReport();
					data.setId(rs.getInt("id"));
					data.setIncidentType(rs.getString("incidentType"));
					data.setNumber(rs.getString("number"));
					data.setOwner(rs.getString("owner"));
					data.setRevision(rs.getString("revision"));
					// data.setDate1(rs.getString("date1"));
					data.setInvestigator(rs.getString("investigator"));
					data.setIncidentType(rs.getString("incidentType"));
					data.setArea(rs.getString("area"));
					/// data.setDate2(rs.getString("date2"));
					data.setPreCheck1(rs.getBoolean("preCheck1"));
					data.setPreCheck2(rs.getBoolean("preCheck2"));
					data.setPreCheck3(rs.getBoolean("preCheck3"));
					data.setPreCheck4(rs.getBoolean("PreCheck4")); // data.isPreCheck4());
					data.setInitCheck1(rs.getBoolean("initCheck1"));// data.isInitCheck1());
					data.setInitValue1(rs.getString("initValue1")); /// data.getInitValue1());
					data.setInitCheck2(rs.getBoolean("initCheck2"));// data.isInitCheck2() );
					data.setInitValue2(rs.getString("initValue2"));// data.getInitValue2() );
					data.setInitCheck3(rs.getBoolean("initCheck3"));// data.isInitCheck3() );
					data.setInitValue3(rs.getString("initValue3")); // data.getInitValue3());
					data.setInitCheck4(rs.getBoolean("initCheck4")); // data.isInitCheck4());
					data.setInitValue4(rs.getString("initValue4")); // data.getInitValue4());
					data.setInitCheck5(rs.getBoolean("initCheck5")); // data.isInitCheck5());
					data.setInitCheck6(rs.getBoolean("initCheck6")); // data.isInitCheck6());
					data.setInitCheck7(rs.getBoolean("initCheck7"));/// data.isInitCheck7() );
					data.setInitCheck8(rs.getBoolean("initCheck8"));
					data.setInitCheck9(rs.getBoolean("initCheck9"));
					data.setDescOfIncident(rs.getString("descOfIncident"));
					data.setCauseOfIncident(rs.getString("causeOfIncident"));
					data.setLackOfCheckBox(rs.getBoolean("lackOfCheckBox"));
					data.setProceNotFollCheckbox(rs.getBoolean("proceNotFollCheckbox"));
					data.setJsaCheckBox(rs.getBoolean("jsaCheckBox"));
					data.setLackOfTraningCheckbox(rs.getBoolean("lackOfTraningCheckbox"));
					data.setPreUseInspecCheckbox(rs.getBoolean("preUseInspecCheckbox"));
					data.setEquipmtCheckbox(rs.getBoolean("equipmtCheckbox"));
					data.setCorrectToolCheckbox(rs.getBoolean("correctToolCheckbox"));
					data.setEnviromentCondtnCheckbox(rs.getBoolean("enviromentCondtnCheckbox"));
					data.setWalkingSurfaceCheckbox(rs.getBoolean("walkingSurfaceCheckbox"));
					data.setLightVisibilityCheckbox(rs.getBoolean("lightVisibilityCheckbox"));
					data.setPoorHousekeepingCheckbox(rs.getBoolean("poorHousekeepingCheckbox"));
					data.setErgonCheckbox(rs.getBoolean("ergonCheckbox"));
					data.setTightCheckbox(rs.getBoolean("tightCheckbox"));
					data.setLineOfFireCheckbox(rs.getBoolean("lineOfFireCheckbox"));
					data.setEyesOnTaskCheckbox(rs.getBoolean("eyesOnTaskCheckbox"));
					data.setHurriedCheckbox(rs.getBoolean("hurriedCheckbox"));
					data.setFrustratedCheckbox(rs.getBoolean("frustratedCheckbox"));
					data.setFatiguedCheckbox(rs.getBoolean("fatiguedCheckbox"));
					data.setComplacentCheckbox(rs.getBoolean("complacentCheckbox"));
					data.setEmergencyIncidentID(rs.getInt("EmergencyIncidentID"));
					return data;
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return incidentReport;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.st.Emergency.dao.EmergencyDao#deleteData(int)
	 */
	@Override
	public void deleteData(int id) {
		String sql = "delete EmergencyIncident where id = " + id;
		dataSourceQRTTemplate.execute(sql);

	}

}
