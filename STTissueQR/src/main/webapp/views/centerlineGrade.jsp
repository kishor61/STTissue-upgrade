<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>

</head>

<spring:url value="/centerlinegrade/add" var="newURL"/>
<spring:url value="/centerlinegrade/view" var="viewURL"/>
<spring:url value="/centerlinegrade/edit" var="editURL"/>
<script type="text/javascript">
	$(function(){
		$('#newBtn').click(function(){
			location.href='${newURL}';
		});
		$('#viewBtn').click(function(){
		
			if($('select[name=cgrade]').val()!=''){
				location.href='${viewURL}/'+$('select[name=cgrade]').val();
			}else{
				alert('Select grade.');
			}
			
		});
		$('#editBtn').click(function(){
			if($('select[name=cgrade]').val()!=''){
				location.href='${editURL}/'+$('select[name=cgrade]').val();
			}else{
				alert('Select grade.');
			}
			
		});
		
	});
</script>
<script type="text/javascript" src='<spring:url value="/dist/js/old/centerline.js"/>'></script>
<style type="text/css">
	.centerline-table input{
		width: 50px !important;
	}
</style>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<c:choose>
						<c:when test="${newpage}">
							<span class="label">Centerline Grade-New</span>
						</c:when>
						<c:when test="${editpage}">
							<span class="label">Centerline Grade-Edit</span>
						</c:when>
						<c:when test="${viewpage}">
							<span class="label">Centerline Grade-View</span>
						</c:when>
						<c:otherwise>
							<span class="label">Centerline Grade</span>
						</c:otherwise>
					</c:choose>
					
					
				</div>
				<br>
				<div class="table-selector">

					<table>
						<tr>
							<td>Grade Code:</td>
							<td>
								<select name="cgrade" style="width: 200px">
									<option value="">Select</option>
									<c:forEach items="${cgrades}" var="cgrade">
										<c:choose>
											<c:when test="${cgrade.id eq id}">
												<option value="${cgrade.id}" selected="selected">${cgrade.grade}</option>
											</c:when>
											<c:otherwise>
												<option value="${cgrade.id}">${cgrade.grade}</option>
											</c:otherwise>
										</c:choose>
										
									</c:forEach>
								</select>
							
							</td>
							<td>
								<button id="newBtn">New</button>
								&nbsp;
								<button id="viewBtn">View</button>
								&nbsp;
								<button id="editBtn">Edit</button>
								<c:if test="${viewpage}">
								&nbsp;
								<button id="printBtn">Print</button>
								</c:if>
							</td>
							
						</tr>
					</table>

				</div>

				
			</div>


		<c:if test="${newpage}">
		
			<jsp:include page="centerlineGradeAdd.jsp"/>
		
		</c:if>
		
		
		<c:if test="${editpage}">
		
			<jsp:include page="centerlineGradeEdit.jsp"/>
		
		</c:if>
		
		<c:if test="${viewpage}">
		
			<jsp:include page="centerlineGradeView.jsp"/>
		
		</c:if>



		</div>


	</div>

<c:if test="${editpage}">
 <!-- Dailog -->
<div class="dialog" id="dialog" style="display: block;width: 400px;height: 184px;margin-left: -200px;left: 50%;">
	<div class="dialog-header" id="dialogHeader">
		<div style="float: left">
			<span>Authentication required</span>
		</div>
		<div style="float: right;">
			<a style="color: white;" href="javascript:void(0)" onclick="$('#dialog').hide();">Close</a>
		</div>
		
	</div>
	<div>
		<table id="passwordForm" style="margin:20px auto;">
			<tr>
				<td>Please Enter Password</td>
			</tr>
			<tr>
				<td><input type="password" id="passwordVal" value=""> </td>
			</tr>
			<tr>
				<td><button id="passwordBtn">OK</button> </td>
			</tr>
			<tr>
				<td>
					<span class="error" id="passError"></span>
				</td>
			</tr>
		</table>
	</div>
</div>
</c:if>
</body>
</html>
