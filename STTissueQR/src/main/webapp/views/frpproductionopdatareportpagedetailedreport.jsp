<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/frpproductionopdataentry/view/report/data"
	var="viewReportURL" />
<spring:url
	value="/frpproductionopdataentry/view/report/data/detailedreport/email"
	var="emailURL" />
<spring:url
	value="/frpproductionopdataentry/view/report/data/detailedreport/delete"
	var="deletewinderDataURL" />
<script type="text/javascript">
	$(function() {
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$('#printBtn').click(function() {
			$('#printDiv').printArea();
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$('#mailBtn')
				.click(
						function() {
							var sdate = $('input[name=sdate]').val();
							var edate = $('input[name=edate]').val();

							var btn = $(this);

							if (confirm('Do You Want To Send FRP-MTD Daily Production Report For '
									+ sdate)) {
								btn = btn.prop('disabled', true);

								$('#tmessage').text(
										'Sending mail.....Please wait.');
								$
										.ajax({
											url : '${emailURL}',
											type : 'POST',
											data : {
												sdate : sdate,
												edate : edate
											},
											success : function(data) {
												if (data) {
													$('#tmessage')
															.text(
																	'Mail sent successfully.');
												} else {
													$('#tmessage')
															.text(
																	'Failure to send email. Please contact to administrator.');
												}
												btn = btn.prop('disabled',
														false);
												setTimeout(function() {
													$('#tmessage').text('');
												}, 5000);
											}
										});
							}

						});
	});
</script>
<script type="text/javascript">
	$(function() {
		$('#deleteBtn')
				.click(
						function() {
							var dbtn = $(this);
							var val = $(
									'#yielddatatable input[type=radio]:checked')
									.val();
							if (typeof val === 'undefined') {
								alert('Please Select The Row That You Want To Delete.');
							} else {
								if (val == '') {
									$(
											'#yielddatatable tbody input[name=id]:checked')
											.parent().parent().remove();
								} else {
									dbtn.attr('disabled', 'disabled');
									$
											.ajax({
												url : '${deletewinderDataURL}',
												type : 'POST',
												data : {
													id : val
												},
												success : function(data) {
													if (data.status) {
														alert('Data removed from database.');
														location.reload(true);
													} else {
														alert(data.error);
													}
												}
											});
								}
							}
						});
	});
</script>
<spring:url
	value="/frpproductionopdataentry/view/report/data/detailedreport"
	var="update" />
<script type="text/javascript">
	$(function() {
		$('#editBtn').click(
				function() {
					var reelId = $(
							'#yielddatatable tr input[type=radio]:checked')
							.val();
					if (reelId == '') {
						alert('Please Select The Record To Delete.');
					} else {
						window.open("${update}/edit/" + reelId);
					}
				});

	});
</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
			<jsp:include page="../header.jsp"></jsp:include>
<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
	<div class="pageContent">
	<div class="block3" style="overflow: auto;">
				<div class="page-title">
					<span class="label">FRP Production Operator Data Entry
						Report</span>
				</div>
				<div class="table-selector">

					<form name="dataForm" action="${viewReportURL}" method="get">
						<table style="margin: auto;">
							<tr>
								<td>Start Date:</td>
								<td><input readonly="readonly" type="text" name="sdate"
									value="${sdate}"></td>
								<td>End Date:</td>
								<td><input readonly="readonly" type="text" name="edate"
									value="${edate}"></td>

								<c:if test="${showreport}">
									<td><input type="button" id="exportBtn"
										onclick="$('#exportFrom').submit();" value="Detailed Report">
									</td>
									<td><input type="button" id="exportBtn"
										onclick="$('#exportExcel').submit();" value="Export Excel">
									</td>
									<td><input type="button" id="mailBtn" value="Send Mail">
									</td>
									<td><input type="button" id="editBtn" value="Edit">
									</td>
									<td><input type="button" id="deleteBtn" value="Delete">
									</td>
								</c:if>
							</tr>
						</table>
					</form>

				</div>
				<form id="exportFrom"
					action='<spring:url value="/frpproductionopdataentry/view/report/data/detailedreport"/>'
					method="get">
					<input type="hidden" name="sdate" value="${sdate}"> <input
						type="hidden" name="edate" value="${edate}">
				</form>
				<form id="exportExcel"
					action='<spring:url value="/frpproductionopdataentry/view/report/data/detailedreport/export"/>'
					method="post">
					<input type="hidden" name="sdate" value="${sdate}"> <input
						type="hidden" name="edate" value="${edate}">
				</form>

				<c:if test="${showreport}">
					<c:if test="${fn:length(details) eq 0 }">
						<div>
							<p>
								<b style="color: red;">No Data Found For Related Search.</b>
							</p>
						</div>
					</c:if>

					<br>
					<c:if test="${fn:length(details) > 0 }">
						<div id="printDiv">
							<center>
								<center>
									<b style="color: green;">Waste Paper Report From <b
										style="color: red;">${sdate}</b> To <b style="color: red;">${edate}</b></b>
								</center>
								<br>
								<table id="yielddatatable" border="1"
									style="background-color: #FFFFCC; border-collapse: collapse; border: 1px solid #FFCC00; color: #000000; width: 100%"
									cellpadding="3" cellspacing="3">
									<tr>
										<td style="background-color: #5c7a98;"></td>
										<td style="background-color: #5c7a98;"><center>
												<b>Date</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b>Shift</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b>Crew</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b>Production Type</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b>DEINK W.W. PUMP<br>4 3 1 - FT -6875
												</b>
											</center></td>
										<%-- <td style="background-color: ##5c7a98;"><center><b>60 # STEAM TO<br>BACKUP HEATER<br>430-FT-6946</b></center</td> --%>
										<td style="background-color: #5c7a98;"><center>
												<b>WATER TO FIRE/<br>MILL WATER TANK<br>430-FT-6956<br>#
													1008
												</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b>FIRE SYSTEM WATER<br>430-FT-6959<br># 1009
												</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b>DEINKING PLANT<br>EFFLUENT<br>431-FT-6083
												</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b>SEWER FLOW</b>
											</center></td>

										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-A</span></br>HD LEVEL AS
													OF<br>7 AM / 7 PM</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-A</span></br>TONS
													PRODUCED TO <br>THE TUBE CONVEYOR</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-A</span></br>WETLAP TONS<br>PRODUCED</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-A</span></br>YIELD</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-A</span></br>WASTE PAPER
													FED</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-A</span></br># OF BATCHES
													FED<br>
												<b style="color: Red; font-size: 15px;">Shift Goal 16</b></b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-A</span></br>Current Run
													Rate<br></b>
											</center></td>


										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-B</span></br>PCC Tank AS
													OF<br>7 AM / 7 PM</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-B</span></br>TONS
													PRODUCED TO <br>THE TUBE CONVEYOR</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-B</span></br>WETLAP TONS<br>PRODUCED</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-B</span></br>YIELD</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-B</span></br>WASTE PAPER
													FED</b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-B</span></br># OF BATCHES
													FED<br>
												<b style="color: Red; font-size: 15px;">Shift Goal 16</b></b>
											</center></td>
										<td style="background-color: #5c7a98;"><center>
												<b><span style="color: black;">Line-B</span></br>Current Run
													Rate<br></b>
											</center></td>
									<c:forEach items="${details}" var="data">
										<tr>

											<td style="background-color: #6EA23E;"><input
												type="radio" value="${data.id}" name="radio"></td>
											<td style="background-color: #6EA23E;"><b><fmt:formatDate
														value="${data.date}" pattern="MM/dd/yyyy" /></b></td>
											<td><center>${data.shift}</center></td>
											<td><center>${data.crew}</center></td>
											<td><center>${data.productiontype}</center></td>
											<td><center>
													<fmt:formatNumber value="${data.col1}"
														maxFractionDigits="2" />
												</center></td>
											<%-- <td><center>${data.col2}</center></td> --%>
											<td><center>${data.col3}</center></td>
											<td><center>${data.col4}</center></td>
											<td><center>${data.col5}</center></td>
											<td><center>${data.col12}</center></td>

											<td style="width: 100px;"><center>
													<fmt:formatNumber value="${data.col11}"
														maxFractionDigits="2" />
												</center></td>
											<td style="width: 100px;"><center>
													<fmt:formatNumber value="${data.col6}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${data.col7}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber
														value="${(data.col6+data.col7)/data.col9*100}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${data.col9}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${data.col10}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${data.col10a}"
														maxFractionDigits="2" />
												</center></td>

											<td style="width: 100px;"><center>
													<fmt:formatNumber value="${data.col11b}"
														maxFractionDigits="2" />
												</center></td>
											<td style="width: 100px;"><center>
													<fmt:formatNumber value="${data.col6b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${data.col7b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber
														value="${(data.col6b+data.col7b)/data.col9b*100}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${data.col9b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${data.col10b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${data.col12b}"
														maxFractionDigits="2" />
												</center></td>

										</tr>
									</c:forEach>
									<br>
									<tr>

										<td style="background-color: white;"></td>
										<td style="background-color: white;"><b>Summary</b></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<!-- <td style="background-color: white;"></td> -->
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>
										<td style="background-color: white;"></td>


									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td style="background-color: #6EA23E;"><b>A</b></td>
										<td></td>
										<c:forEach items="${Aavg}" var="avg1">
											<td><center>
													<fmt:formatNumber value="${avg1.col1}"
														maxFractionDigits="2" />
												</center></td>
											<%-- <td><center><fmt:formatNumber value="${avg1.col2}" maxFractionDigits="2"/></center</td> --%>
											<td><center>
													<fmt:formatNumber value="${avg1.col3}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col4}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col5}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col12}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col11}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col6}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col7}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber
														value="${((avg1.getCol6()+avg1.getCol7())/avg1.getCol9())*100}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col9}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10a}"
														maxFractionDigits="2" />
												</center></td>

											<td><center>
													<fmt:formatNumber value="${avg1.col11b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col6b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col7b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col8b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col9b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col12b}"
														maxFractionDigits="2" />
												</center></td>
										</c:forEach>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td style="background-color: #6EA23E;"><b>B</b></td>
										<td></td>
										<c:forEach items="${Bavg}" var="avg1">
											<td><center>
													<fmt:formatNumber value="${avg1.col1}"
														maxFractionDigits="2" />
												</center></td>
											<%-- <td><center><fmt:formatNumber value="${avg1.col2}" maxFractionDigits="2"/></center</td> --%>
											<td><center>
													<fmt:formatNumber value="${avg1.col3}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col4}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col5}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col12}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col11}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col6}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col7}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber
														value="${((avg1.getCol6()+avg1.getCol7())/avg1.getCol9())*100}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col9}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10a}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col11b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col6b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col7b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col8b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col9b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col12b}"
														maxFractionDigits="2" />
												</center></td>
										</c:forEach>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td style="background-color: #6EA23E;"><b>C</b></td>
										<td></td>
										<c:forEach items="${Cavg}" var="avg1">
											<td><center>
													<fmt:formatNumber value="${avg1.col1}"
														maxFractionDigits="2" />
												</center></td>
											<%-- <td><center><fmt:formatNumber value="${avg1.col2}" maxFractionDigits="2"/></center</td> --%>
											<td><center>
													<fmt:formatNumber value="${avg1.col3}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col4}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col5}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col12}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col11}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col6}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col7}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber
														value="${((avg1.getCol6()+avg1.getCol7())/avg1.getCol9())*100}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col9}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10a}"
														maxFractionDigits="2" />
												</center></td>

											<td><center>
													<fmt:formatNumber value="${avg1.col11b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col6b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col7b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col8b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col9b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col12b}"
														maxFractionDigits="2" />
												</center></td>
										</c:forEach>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td style="background-color: #6EA23E;"><b>D</b></td>
										<td></td>
										<c:forEach items="${Davg}" var="avg1">
											<td><center>
													<fmt:formatNumber value="${avg1.col1}"
														maxFractionDigits="2" />
												</center></td>
											<%-- <td><center><fmt:formatNumber value="${avg1.col2}" maxFractionDigits="2"/></center</td> --%>
											<td><center>
													<fmt:formatNumber value="${avg1.col3}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col4}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col5}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col12}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col11}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col6}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col7}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber
														value="${((avg1.getCol6()+avg1.getCol7())/avg1.getCol9())*100}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col9}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10a}"
														maxFractionDigits="2" />
												</center></td>

											<td><center>
													<fmt:formatNumber value="${avg1.col11b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col6b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col7b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col8b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col9b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col10b}"
														maxFractionDigits="2" />
												</center></td>
											<td><center>
													<fmt:formatNumber value="${avg1.col12b}"
														maxFractionDigits="2" />
												</center></td>
										</c:forEach>
									</tr>
								</table>

							</center>
						</div>
					</c:if>
				</c:if>
			</div>

		</div>


	</div>

</body>
</html>