<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>



<style type="text/css">
.table-selector td {
	vertical-align: middle;
	text-align: left;
}

.table thead th {
	font-size: 10px;
}

.table tbody td {
	text-align: center;
}
.trrowgray{
	background: rgb(221, 221, 221);
	color: black;
	font-weight: bold;
}
.trrowgray2{
	background: rgba(213, 207, 207, 0.46);
	color: black;
	font-weight: bold;
}

@MEDIA print {
	.no-print,.no-print * {
		display: none !important;
	}
}
</style>

<script type="text/javascript">
	$(function() {
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});
		$('select[name=pcode]').change(function() {
			$('select[name=scode]').val('');
		});
		$('select[name=scode]').change(function() {
			var element = $(this).find('option:selected'); 
			if(element.attr('data-pid')){
				$('select[name=pcode]').val(element.attr('data-pid'));
			}else{
				$('select[name=pcode]').val('');
			}
		});
	});
</script>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
			<jsp:include page="header.jsp"></jsp:include>
<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
	<div class="pageContent">
	<div class="block3" style="overflow: auto;">
				<div class="page-title">
					<span class="label">FRP Efficiency Summary- Report</span>
				</div>
				<br> <span class="message">${message}</span>

				<div style="padding: 2px;"></div>

				<div class="table-selector">
					<spring:url value="/frpefficiencyreport/viewsummary" var="viewviewsummaryURL" />
					<form action="${viewviewsummaryURL}" method="get">
						<table>
							<tr>
								<td>Start Date: <input type="text" name="sdate"
									value="${sdate}" style="width: 80px;"></td>

								<td>End Date: <input type="text" name="edate"
									value="${edate}" style="width: 80px;"></td>

								<td>Down Time Primary Code <select name="pcode"
									style="width: 180px;">
										<option value="">All</option>
										<c:forEach items="${pcodes}" var="pc">
											<c:choose>
												<c:when test="${pc.id eq pcode}">
													<option value="${pc.id}" selected="selected">${pc.code}</option>
												</c:when>
												<c:otherwise>
													<option value="${pc.id}">${pc.code}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</select>
								</td>

								<td>Down Time Secodary Code <select name="scode"
									style="width: 180px;">
										<option value="">All</option>
										<c:forEach items="${scodes}" var="sc">
											<c:choose>
												<c:when test="${sc.id eq scode }">
													<option value="${sc.id}" selected="selected" data-pid="${sc.primaryCode.id}">${sc.code}</option>
												</c:when>
												<c:otherwise>
													<option value="${sc.id}" data-pid="${sc.primaryCode.id}">${sc.code}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</select></td>

								<td>
								
									<input type="submit" value="Search">
									<c:if test="${showTable}">
										 &nbsp; 
										<input id="printBtn" type="button" value="Print">
										 &nbsp; 
										<input id="exportBtn" type="button" value="Export">
									</c:if>
								</td>
								<td></td>

							</tr>
						</table>
					</form>
				</div>

<br>
<c:if test="${fn:length(datas)>0}">
<spring:url value="/frpefficiencyreport/exportsummary" var="exportURL" />
<form id="exportForm" style="display: none;" action="${exportURL}" method="post">
	<input type="hidden" name="sdate" value="${sdate}"> 
	<input type="hidden" name="edate" value="${edate}"> 
	<input type="hidden" name="pcode" value="${pcode}"> 
	<input type="hidden" name="scode" value="${scode}"> 
</form>

<script type="text/javascript">
	$(function() {
		

		$('#printBtn').click(function() {

			$('#printDiv').printArea({
				retainAttr : [ 'class', 'style' ]
			});
		});
		
		$('#exportBtn').click(function(){
			$('#exportForm').submit();
			
		});

	});
</script>

</c:if>

<br>

				<c:if test="${showTable}">
					<span class="error">${error}</span>
					

					<div id="printDiv">

<c:set value="${fn:length(datas['summaryPrimaries'])}" var="len"/>
			
<c:if test="${len >0 }">

<table class="table" style="margin: auto; width: 400px;">
	<thead>
		<tr>
			<td></td>
			<td style="text-align: center;">HH</td>
			<td style="text-align: center;">MM</td>
			<td style="text-align: center;">OCCURRENCE</td>
		</tr>
	</thead>
	<tbody>
		
	
		<c:forEach items="${datas['summaryPrimaries']}" var="pSum">
		<tr>
			<td style="text-align: left;">
				<b>${pSum.code}</b>
			</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
				
		<c:set value="${fn:length(pSum.summarySecondaries)}" var="len2"/>
		<c:if test="${len2 > 0}">
	
		<c:forEach items="${pSum.summarySecondaries}" var="sSum">
				<tr>
					<td style="text-align: left;">${sSum.code}</td>
					<td>${sSum.hh}</td>
					<td>${sSum.mm}</td>
					<td>${sSum.counter}</td>
				</tr>
		</c:forEach>
		<tr>
			<td class="trrowgray" style="text-align: right;"><b>TOTAL</b></td>
			<td class="trrowgray">${pSum.hh}</td>
			<td class="trrowgray">${pSum.mm}</td>
			<td class="trrowgray"></td>
		</tr>	
			
			
		</c:if>
		
		</c:forEach>
		
		<tr>
			<td class="trrowgray2" style="text-align: right;"><b>GRAND TOTAL</b></td>
			<td class="trrowgray2">${datas['hh']}</td>
			<td class="trrowgray2">${datas['mm']}</td>
			<td class="trrowgray"></td>
		</tr>
		
	</tbody>
</table>

</c:if>


						
					</div>
				</c:if>
			</div>
			<br>
					</div>
	</div>

</body>
</html>
