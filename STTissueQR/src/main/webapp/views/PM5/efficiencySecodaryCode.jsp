<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
.table-selector td{
	vertical-align: top;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>
		
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div
		          class="content-header"
		          style="
		            padding-top: 10px !important;
		            padding-bottom: 0px !important;
		            line-height: 0px !important;
		          "
		><h5 style="text-align:center; font-weight:bold;color:#343e70;">Down Time Secondary Code For PM5</h5></div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				
				<div class="table-selector" style="background-color:#c2eadf73 !important; border: 1px solid #7e00ff42;">
				<spring:url value="/pm5effsecondarycode/save" var="saveURL" />
				<form:form action="${saveURL}" modelAttribute="secondaryCode">
				
				
					<table>
						<tr>
							<td>
								Select Primary Code
							</td>
							<td>
								<form:select id="primaryCode" path="primaryCode.id" cssStyle="padding: 2px; width: 111px;">
									<option value="">--Select--</option>
									<c:forEach items="${primaryCodes}" var="pCode">
										<c:choose>
											<c:when test="${pCode.id== secondaryCode.primaryCode.id}">
												<option value="${pCode.id}" selected="selected">${pCode.code}</option>	
											</c:when>
											<c:otherwise>
												<option value="${pCode.id}">${pCode.code}</option>
											</c:otherwise>
										</c:choose>
										
									</c:forEach>
								</form:select>
							</td>
							
							<td>
								Secodary Code
							</td>
							<td>
								<form:input id="code" path="code" cssStyle="height: 25px;"/>
							</td>
							
							<td>Note</td>
							<td>
								<form:textarea path="note" cssStyle="height: 25px;"/>
							</td>
							
							<td>
								<form:hidden path="id"/>
								<input type="submit" value="Save" id="saveBtn" class="btn btn-success btn-sm">
							</td>
							<td>
								<span class="error">${error}</span>
								<span class="message">${message}</span>
							</td>
						</tr>
					</table>
				</form:form>
				
				<spring:url value="/pm5effsecondarycode/main" var="mainURL" />
				<spring:url value="/pm5effsecondarycode/view" var="viewURL"/>
				<script type="text/javascript">
					$(function(){
						$('#saveBtn').click(function(data){
							if($('#primaryCode').val()==''){
								alert('Select primary code.');
								return false;
							}
							
							if($('#code').val()==''){
								alert('Please enter secodary code.');
								return false;
							}
							
							return true;
						});
				<%--		
						$('a[id^=delete_]').click(function(){
							if(confirm("You will lost all data mapped with this code. Do you want to delete this code?")){
								return true;
							}else{
								return false;
							}
							
						});
				--%>	
						
						$('select[name=sortPCode]').change(function(){
							if($(this).val()!=''){
								location.href='${viewURL}/'+$(this).val();
							}else{
								location.href='${mainURL}';
							}
						});
					});
				</script>
				
				</div>
			<br>
			
			<div style="padding: 2px;">
			
				<table class="table">
					<thead>
						<tr style="background-color: #F5DA81;">
							
							<th colspan="5" align="left">
							Sort by Primary Code:
								<select style="width: 200px;" name="sortPCode">
									<option value="">All</option>
									<c:forEach items="${primaryCodes}" var="pCode">
										<c:choose>
											<c:when test="${pCode.id== id}">
												<option value="${pCode.id}" selected="selected">${pCode.code}</option>	
											</c:when>
											<c:otherwise>
												<option value="${pCode.id}">${pCode.code}</option>
											</c:otherwise>
										</c:choose>
										
									</c:forEach>
								</select>
							</th>
						</tr>
						<tr>
							<th style="width: 30px;">&nbsp;</th>
							<th style="width: 200px;">Secondary Code </th>
							<th style="width: 200px;">Primary Code </th>
							<th>Note</th>
							
							<th style="width: 150px;">&nbsp; </th>
							
						</tr>
					</thead>
					<tbody>
						<c:if test="${fn:length(codes)==0}">
							<tr><td colspan="5" align="center">Records not available in database.</td></tr>
						</c:if>
					
						<c:if test="${fn:length(codes)!=0}">
							<c:forEach items="${codes}" var="code" varStatus="i">
								<tr>
									<td>${i.index+1}</td>
									<td>${code.code }</td>
									<td>${code.primaryCode.code }</td>
									<td>${code.note }</td>
									<td align="center">
									<%-- <a id="delete_${i.index}" href='<spring:url value="/effsecondarycode/delete"/>/${code.id}'>Delete</a> --%> &nbsp;
									 <a href='<spring:url value="/pm5effsecondarycode/edit"/>/${code.id}'>Edit</a> </td>
								</tr>
							</c:forEach>
						</c:if>						
					</tbody>
				</table>
			
			</div>



			</div>

		</div>


	</div>
	<!-- /.content-wrapper -->
	                   <footer class="main-footer" style="text-align:center;color:black; height:20px;">
	                       <strong> Copyright Barnwell Tissue Solutions 2025 </strong>
	                   </footer>
</div>
</body>
</html>
