<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});
		
	});
</script>
<style type="text/css">
.trrowgray {
    background: rgb(221, 221, 221);
    color: black;
    font-weight: bold;
}
</style>
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
<spring:url value="/convertinglinereport/efficiencysummary/report/mail/send" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		$('#sendMailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			var pcode=$('select[name=pcode]').val();
			var scode=$('select[name=scode]').val();
			if(pcode==''){
				pcode='ALL';
			}
			if(scode==''){
				scode='ALL';			
			}
			var btn=$(this);
			
			if(confirm('Do you want to send Converting Line 171 - Efficiency Summary Report for '+sdate)){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						sdate : sdate,
						edate : edate,
						pcode : pcode,
						scode : scode
					},
					success : function(data){
						if(data){
							$('#tmessage').text('Mail sent successfully.');
						}else{
							$('#tmessage').text('Failure to send email. Please contact to administrator.');
						}
						btn=btn.prop('disabled',false);
						setTimeout(function(){
							$('#tmessage').text('');
						}, 5000);
					}
				});
			}
			
			
			
		});
	});
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Converting Line 171 - Efficiency Summary Report</span>
				</div>
				<div class="table-selector">
					
					<spring:url value="/convertinglinereport/efficiencysummary/report/show" var="viewviewsummaryURL" />
					<form action="${viewviewsummaryURL}" method="get">
						<table>
							<tr>
								<td>Start Date: <input type="text" name="sdate"
									value="${sdate}" style="width: 80px;"></td>

								<td>End Date: <input type="text" name="edate"
									value="${edate}" style="width: 80px;"></td>

								<td>Down Time Primary Code 
								<%-- <select name="pcode">
									<option value="">Select </option>
									<option value="All">All</option>
									<c:forEach items="${pcodes}" var="pcode">
												<option value="${pcode.primarycode}">${pcode.primarycode}</option>
									</c:forEach>
								</select> --%>
								<select name="pcode">
									<option value="">Select</option>
									<option value="All">All</option>
									<c:forEach items="${pcodes}" var="pcode">
											<c:choose>
												<c:when test="${pcode.primarycode eq code1}">
													<option value="${pcode.primarycode}" selected="selected">${pcode.primarycode}</option>
												</c:when>
												<c:otherwise>
													<option value="${pcode.primarycode}">${pcode.primarycode}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</select>
								</td>

								<td>Down Time Secondary Code 
								<%-- <select name="scode">
									<option value="">Select </option>
									<option value="All">All</option>
									<c:forEach items="${scodes}" var="scode">
												<option value="${scode.secondarycode}">${scode.secondarycode}</option>
									</c:forEach>
								</select> --%>
								<select name="scode">
									<option value="">Select</option>
									<option value="All">All</option>
									<c:forEach items="${scodes}" var="scode">
											<c:choose>
												<c:when test="${scode.secondarycode eq code2}">
													<option value="${scode.secondarycode}" selected="selected">${scode.secondarycode}</option>
												</c:when>
												<c:otherwise>
													<option value="${scode.secondarycode}">${scode.secondarycode}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</select>
								</td>

								<td>
								
									<input type="submit" value="Search">
									<c:if test="${showTable}">
										 &nbsp; 
										<input id="printBtn" type="button" value="Print">
										 &nbsp; 
										<input id="exportBtn" type="button" value="Export">
										 &nbsp; <input type="button" value="Send Mail" id="sendMailBtn">
									</c:if>
								</td>
								<td></td>

							</tr>
						</table>
					</form>

				</div>
<c:if test="${showTable}">				
<spring:url value="/convertinglinereport/efficiencysummary/report/export" var="exportURL" />
<form id="exportForm" style="display: none;" action="${exportURL}" method="get">
	<input type="hidden" name="sdate" value="${sdate}"> 
	<input type="hidden" name="edate" value="${edate}"> 
	<input type="hidden" name="pcode" value="${pcode}"> 
	<input type="hidden" name="scode" value="${scode}"> 
</form>
</c:if>				
<div id="printDiv">
<br/><br/>
<table class="table" style="margin: auto; width: 400px;">
	<thead>
		<tr>
			<td style="width: 130px;"></td>
			<td style="text-align: center;">HH</td>
			<td style="text-align: center;">MM</td>
			<td style="text-align: center;">OCCURRENCE</td>
			<td style="text-align: center;">Comments</td>
		</tr>
	</thead>
	<tbody>
 <c:forEach items="${data}" var="datas">
		<tr>
			<td style="text-align: left;">
				<b>${datas.primarycode}</b>
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
				
				<tr>
					<td style="text-align: left;">${datas.secondarycode}</td>
					<td style="text-align: center;">${datas.totalhr}</td>
					<td style="text-align: center;">${datas.totalmin}</td>
					<td style="text-align: center;">${datas.occurrence}</td>
					<td style="text-align: center;">${datas.comment}</td>
				</tr>
			<tr>
				<td class="trrowgray" style="text-align: right;"><b>TOTAL</b></td>
				<td class="trrowgray" style="text-align: center;">${datas.grandtotalhr}</td>
				<td class="trrowgray" style="text-align: center;">${datas.grandtotalmin}</td>
				<td class="trrowgray" style="text-align: center;"></td>
				<td class="trrowgray" style="text-align: center;"></td>
			</tr>	
</c:forEach>
		<tr>
			<td class="trrowgray2" style="text-align: right;"><b>GRAND TOTAL</b></td>
			<td class="trrowgray2" style="text-align: center;">${totalhr}</td>
			<td class="trrowgray2" style="text-align: center;">${totalmin }</td>
			<td class="trrowgray"></td>
			<td class="trrowgray"></td>
		</tr>
	</tbody>

</table>




						
					</div>
			</div>

		</div>


	</div>

</body>
</html>
