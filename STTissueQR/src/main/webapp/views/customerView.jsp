<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>

<spring:url value="/grade/editcustomer" var="editURL"/>
<script type="text/javascript">
	$(function(){
		$('[id^=editBtn_]').click(function(){
			var id=$('input[name=customer]:checked').val();
			
			if(id){
				location.href='${editURL}/'+id;
			}
		});
	});
</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="header.jsp"></jsp:include>
		
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div
		          class="content-header"
		          style="
		            padding-top: 10px !important;
		            padding-bottom: 0px !important;
		            line-height: 0px !important;
		          "
		><h5 style="text-align:center; font-weight:bold;color:#343e70;">View Customer</h5></div>

	


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				
	<span class="error">${error}</span>
	<span class="message">${message}</span>
			<spring:url value="/grade/main" var="gradeUrl"/>
			<form action='<spring:url value="/grade/deletecustomer"/>' method="post">
				<input type="submit" class="btn btn-danger" value="Delete">
				&nbsp; &nbsp; &nbsp;
				<input type="button" id="editBtn_0" class="btn btn-warning" value="Edit">
				&nbsp;
				<input type="button" onclick="window.location.href='${gradeUrl}'" class="btn btn-info" value="ST Tissue Internal Specification">

			<table class="table">
				<thead>
					<tr>
						<th ></th>
						<th >Customer Name</th>
						<th>Location</th>
						<th>City</th>
						<th>State</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${customers}" var="map">
						<tr>
							<td> <input type="radio" name="customer" value="${map['id']}"> </td>
							<td>${map['name']}</td>
							<td>${map['location']}</td>
							<td>${map['city']}</td>
							<td>${map['state']}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="submit" class="btn btn-danger" value="Delete">
			&nbsp; &nbsp; &nbsp;
			<input type="button" id="editBtn_1" class="btn btn-warning" value="Edit">
			&nbsp;
			<input type="button" onclick="window.location.href='${gradeUrl}'" class="btn btn-info" value="ST Tissue Internal Specification">

			</form>
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
