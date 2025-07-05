<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /> Add Grade</title>
<jsp:include page="common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('#date').datepicker({
			dateFormat:'mm/dd/yy',
			changeMonth: true,
		    changeYear: true
		});
		
		
		$('#submitBtn').click(function(){
			
			var gradeCode=$('input[name=gradeCode]').val();
			if(gradeCode==''){
				alert('Please enter grade code.');
				$('input[name=gradeCode]').focus();
				return false;
			}
			
			
			var revisionDate=$('input[name=revisionDate]').val();
			if(revisionDate==''){
				alert('Please enter revision date.');
				$('input[name=revisionDate]').focus();
				return false;
			}
			
			return true;
		});
		
	});
	
	
</script>

</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Add New Grade</span>
				</div>

				<div>
				
				<span class="message">${message}</span>
				<br>
				<span class="error">${error}</span>
				
				<spring:url value="/grade/save" var="saveURL"/>
				
				<form:form action="${saveURL}" modelAttribute="grade" method="POST">
					<table>
						<tr>
							<td>GRADE CODE:</td>
							<td>
								<form:input path="gradeCode" cssStyle="width:200px;"/>
								<form:errors path="gradeCode" cssClass="error"/>
							</td>
							<td>Revision Date:</td>
							<td>
								<fmt:formatDate value="${grade.revisionDate}" pattern="MM/dd/yyyy" var="date"/>
								<form:input path="revisionDate" value="${date}"  cssStyle="width:200px;" id="date" readonly="true" />
							
							</td>
						</tr>
						<tr>
							<td>TM No.</td>
							<td><form:input path="tmNo"  cssStyle="width:200px;"/></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>Customer Grade:</td>
							<td><form:input path="customerGrade"  cssStyle="width:200px;"/></td>
							<td>Customer:</td>
							<td>
							<form:select path="customer" cssStyle="width:200px;">
								<c:forEach items="${customers}" var="customer">
									<option value="${customer}">${customer }</option>
								</c:forEach>
							</form:select>
						</td>
						</tr>
						<tr>
							<td valign="top">Description.</td>
							<td><form:textarea path="description"  cssStyle="width:200px;"  rows="8"/> </td>
							<td valign="top">Notes:</td>
							<td><form:textarea path="notes" cssStyle="width:200px;"  rows="8"/></td>
						</tr>
						<tr>
							<td></td>
							<td colspan="3">
								<input type="submit" value="Submit" id="submitBtn">
								&nbsp;&nbsp;
								<input type="reset" value="Clear">
								&nbsp;&nbsp;
								<spring:url value="/home" var="homeurl"/>
								<input type="button" onclick="location.href='${homeurl}'" value="Back">
							</td>
						</tr>
					</table>
					
				</form:form>
				</div>

			</div>

		</div>


	</div>

</body>
</html>
