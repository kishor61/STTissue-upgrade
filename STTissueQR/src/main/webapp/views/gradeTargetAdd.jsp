<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /> - Add Grade Target</title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/gradetarget/add" var="url"/>
<script type="text/javascript">
	
	$(function(){
		
		
		$('select[name=gradeCode]').change(function(){
			var val=$(this).val();
			
			if(val!='-1'){
				location.href='${url}/'+val;
			}else{
				location.href='${url}';
			}
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
					<span class="label">Grade Target Setting</span>
				</div>

				<div>
				
					<form action='<spring:url value="/gradetarget/save"/>' method="post">
				
					<table class="table">
						<thead>
							<tr>
								<th align="left" colspan="7">
									
										Grade Code 
										<select name="gradeCode" style="width: 200px;padding: 1px;">
											<option value="-1">Select</option>
											<c:forEach items="${grades}" var="grade">
												<c:choose>
													<c:when test="${grade.gradeCode eq gradeCode}">
														<option value="${grade.gradeCode}" selected="selected">${grade.gradeCode}</option>
													</c:when>
													<c:otherwise>
														<option value="${grade.gradeCode}">${grade.gradeCode}</option>
													</c:otherwise>
												</c:choose>
											
												
											</c:forEach>
										</select>
										
										<!-- <input type="button" value="Load" id="gradeCodeBtn"> -->
									
								</th>
							</tr>
							<c:if test="${showForm}">
								<tr>
									<th>Physical Property</th>
									<th>Reject Min</th>
									<th>Control Min</th>
									<th>Target</th>
									<th>Control Max</th>
									<th>Reject Max</th>
									<th>Notes</th>
								</tr>
							</c:if>
						</thead>
						
						<c:if test="${showForm}">
						
						<tbody>
							<c:forEach items="${gradesTargets}" var="gradeTarget">
								<tr>
										<td align="center">${gradeTarget.propertyName} <input type="hidden" name="PhysicalPropertyID" value="${gradeTarget.physicalProperty}"> </td>
										<td align="center"><input name="minReject" type="text" style="width: 100px;" value="${gradeTarget.rejectMin}"> </td>
										<td align="center"><input name="minControl" type="text" style="width: 100px;" value="${gradeTarget.controlMin}"></td>
										<td align="center"><input name="target" type="text" style="width: 100px;" value="${gradeTarget.target}"></td>
										<td align="center"><input name="maxControl" type="text" style="width: 100px;" value="${gradeTarget.controlMax}"></td>
										<td align="center"><input name="maxReject" type="text" style="width: 100px;" value="${gradeTarget.rejectMax}"></td>
										<td align="center"><input name="note" type="text" style="width: 200px;" value="${gradeTarget.note}"></td>
										
									</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="7" align="center">
									<input type="submit" value="Submit">
									
								</td>
							</tr>
						</tfoot>
						</c:if>
					</table>
					</form>
					<br>
					<span class="message">${message}</span>
					<br>
					<span class="error">${error}</span>
				</div>

			</div>

		</div>


	</div>

</body>
</html>
