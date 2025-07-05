<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<!-- 
<http-equiv="X-UA-Compatible" content="IE=edge"/>
 -->
<title><spring:message code="app.name" /> - Print Grade</title>
<link type="text/css" rel="stylesheet" media="all" href="<spring:url value="/resources/css/print.css"/>">

<script type="text/javascript" src='<spring:url value="/resources/js/jquery.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>

<script type="text/javascript">
	$(function(){
		$('#printBtn').click(function(){
			$('#printDiv').printArea();
		});
	});
</script>
</head>
<body>
<div>
	<button id="printBtn">Print</button>
	&nbsp;<button onclick="window.close();">Close</button>
</div>
<hr>
<div id="printDiv" style="width: 960px; padding: 2px;">
<div style="margin-bottom: 2px;">
	<span style="font-size: 24px;">ST Tissue Internal Specification</span>
</div>

	<table style="font-size: 12px;">
		<tr>
			<td style="width: 130px;">GRADE CODE:</td>
			<td style="width: 250px;">${grade.gradeCode}</td>
			<td style="width: 130px;">Revision Date:</td>
			<td><fmt:formatDate value="${grade.revisionDate}" pattern="MM/dd/yyyy" var="rdate"/>${rdate }</td>
		</tr>
		<tr>
			<td valign="top">TM No.</td>
			<td valign="top">${grade.tmNo}</td>
			<td valign="top">Description.</td>
			<td valign="top">${grade.description}</td>
		</tr>
		<tr>
			<td>Customer Grade:</td>
			<td>${grade.customerGrade }</td>
			<td>Customer:</td>
			<td>
				${grade.customer }
			</td>
		</tr>
		<tr>
			<td>ST Tissue Approval.</td>
			<td>${grade.tissueApproval }</td>
			<td>Customer Approval</td>
			<td>${grade.customerApproval }</td>
		</tr>
	</table>
	<br>
	<span class="span-label">PHYSICAL PROPERTIES:-</span>
	<table class="table">
		<thead>
		<tr>
			<th style="width: 120px;">&nbsp;</th>
			<th style="width: 100px;">Units</th>
			<th style="width: 80px;">Reject Min</th>
			<th style="width: 80px;">Control Min</th>
			<th style="width: 80px;">TARGET</th>
			<th style="width: 80px;">Control Max</th>
			<th style="width: 80px;">Reject Max</th>
			<th style="width: 200px;">Notes</th>
		</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${gradeTargets}" var="gradeTarget">
			<tr>
				<td>${gradeTarget.propertyName}</td>
				<td>${gradeTarget.unitName}</td>
				<td>${gradeTarget.rejectMin}</td>
				<td>${gradeTarget.controlMin}</td>
				<td>${gradeTarget.target}</td>
				<td>${gradeTarget.controlMax}</td>
				<td>${gradeTarget.rejectMax}</td>
				<td>${gradeTarget.note}</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	
	<br>
	<span class="span-label">NOTES:-</span>
		<pre>
		${grade.notes }
		</pre>
	<br>
	
	
	<span class="span-label">VISUAL STANDARDS:-</span>
	<pre>
	${grade.visualStandard }
	</pre>
		
	<br>
	<table class="table" style="text-align: center;">
		<tbody>
		<tr>
			<th width="200"></th>
			<th width="200">Min</th>
			<th width="200">Target</th>
			<th width="200">Max</th>
		</tr>
		<tr>
			<td>Trim</td>
			<td>${grade.trimMin}</td>
			<td>${grade.trimTarget}</td>
			<td>${grade.trimMax}</td>
		</tr>
		<tr>
			<td>Diameter</td>
			<td>${grade.diameterMin }</td>
			<td>${grade.diameterTarget }</td>
			<td>${grade.diameterMax }</td>
		</tr>
		<tr>
			<td>Breaks</td>
			<td>${grade.breakMin }</td>
			<td>${grade.breakTarget }</td>
			<td>${grade.breakMax }</td>
		</tr>
		</tbody>
	</table>

	<br>
	<span class="span-label" >SPECIAL INSTRUCTIONS:-</span>
	<pre>
		${grade.specialInstruction }
	</pre>
	<br>
</div>
</body>
</html>
