<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<style type="text/css">
.table-selector td{
	vertical-align: top;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
			<jsp:include page="header.jsp"></jsp:include>
<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
	<div class="pageContent">
	<div class="block3" style="overflow: auto;">
				<div class="page-title">
					<span class="label">FRP - Down Time Primary Code</span>
				</div>
				<br>
				<div class="table-selector">
				<spring:url value="/frpeffprimarycode/save" var="saveURL" />
				<form:form action="${saveURL}" modelAttribute="primaryCode">
				
				
					<table>
						<tr>
							<td>
								Primary Code
							</td>
							<td>
								<form:input path="code" cssStyle="height: 18px;"/>
							</td>
							<td>Note</td>
							<td>
								<form:textarea path="note" cssStyle="height: 20px;"/>
							</td>
							<td>
								<form:hidden path="id"/>
								<input type="submit" value="Save">
							</td>
							<td>
								<span class="error">${error}</span>
								<span class="message">${message}</span>
							</td>
						</tr>
					</table>
				</form:form>
				</div>


			<br>
				<%--
			<script type="text/javascript">
				$(function(){
					$('a[id^=delete_]').click(function(){
						if(confirm("You will lost all data mapped with this code. Do you want to delete this code?")){
							return true;
						}else{
							return false;
						}
						
					});
				});
			</script>
			--%>
			
			<div style="padding: 2px;">
			
				<table class="table">
					<thead>
						<tr>
							<th style="width: 30px;">&nbsp;</th>
							<th style="width: 300px;">Primary Code </th>
							<th>Note</th>
							<th style="width: 150px;">Secondary Code</th>
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
									<td>${code.note }</td>
									<td align="center">
									<a href='<spring:url value="/frpeffsecondarycode/view"/>/${code.id}'>View</a> 
									</td>
									<td align="center">
									<%-- <a id="delete_${i.index}" href='<spring:url value="/frpeffprimarycode/delete"/>/${code.id}'>Delete</a> &nbsp; --%>
									<a href='<spring:url value="/frpeffprimarycode/edit"/>/${code.id}'>Edit</a> </td>
								</tr>
							</c:forEach>
						</c:if>						
					</tbody>
				</table>
			
			</div>



			</div>

		</div>


	</div>

</body>
</html>
