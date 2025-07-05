<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>View Customer</title>
<jsp:include page="../common.jsp"></jsp:include>

<spring:url value="/pm5grade/editcustomer" var="editURL"/>
<style>
    .content-wrapper {
        background-color: #f8f9fa !important;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: calc(100vh - 100px);
    }
    .page-header {
        background-color: #343e70;
        color: white;
        padding: 20px;
        margin-bottom: 20px;
        border-radius: 8px;
        text-align: center;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    .page-header h2 {
        margin: 0;
        font-size: 24px;
        font-weight: 600;
    }
    .table {
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        width: 100%;
        max-width: 1200px;
        margin: 0 auto;
    }
    .table thead th {
        background-color: #343e70;
        color: white;
        font-weight: 500;
        padding: 12px;
        text-align: center;
    }
    .table tbody td {
        padding: 10px;
        vertical-align: middle;
        text-align: center;
        color: #343e70;
    }
    .table tbody tr:hover {
        background-color: #f0f2f5;
    }
    .btn {
        padding: 8px 16px;
        border-radius: 4px;
        font-weight: 500;
        margin: 5px;
        transition: all 0.3s ease;
    }
    .btn-danger {
        background-color: #dc3545;
        border-color: #dc3545;
    }
    .btn-warning {
        background-color: #ffc107;
        border-color: #ffc107;
        color: #343e70;
    }
    .btn-info {
        background-color: #17a2b8;
        border-color: #17a2b8;
    }
    .btn:hover {
        opacity: 0.9;
        transform: translateY(-1px);
    }
    .error {
        color: #dc3545;
        font-weight: 500;
        display: block;
        text-align: center;
        margin: 10px 0;
    }
    .message {
        color: #28a745;
        font-weight: 500;
        display: block;
        text-align: center;
        margin: 10px 0;
    }
    .pageContent {
        padding: 30px;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        margin: 20px auto;
        width: 90%;
        max-width: 1200px;
        border: 1px solid #e9ecef;
    }
    .content-header h5 {
        color: #343e70;
        font-size: 1.5rem;
        margin-bottom: 20px;
        text-align: center;
    }
    .button-container {
        text-align: center;
        margin: 20px 0;
    }
    .table-container {
        overflow-x: auto;
    }
    input[type="radio"] {
        accent-color: #343e70;
    }
</style>
<script type="text/javascript">
	$(function(){
		$('[id^=editBtn_]').click(function(){
			var id=$('input[name=customer]:checked').val();
			
			if(id){
				location.href='${editURL}/'+id;
			}
		});

		// Auto-remove success message after 5 seconds
		$(document).ready(function() {
			var message = $('.message');
			if (message.length > 0 && message.text().trim() !== '') {
				setTimeout(function() {
					message.fadeOut(300, function() {
						$(this).remove();
					});
				}, 3000);
			}
		});
	});
</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>
		
	<div class="content-wrapper">
		
		<div class="pageContent">
			<div class="page-header">
				<h2>View Customer</h2>
			</div>
			<span class="error">${error}</span>
			<span class="message">${message}</span>
			<spring:url value="/pm5grade/main" var="gradeUrl"/>
			<form action='<spring:url value="/pm5grade/deletecustomer"/>' method="post">
				<div class="button-container">
					<input type="submit" value="Delete" class="btn btn-danger">
					<input type="button" id="editBtn_0" class="btn btn-warning" value="Edit">
					<input type="button" onclick="window.location.href='${gradeUrl}'" class="btn btn-info" value="ST Tissue Internal Specification">
				</div>
				<div class="table-container">
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
				</div>
				<div class="button-container">
					<input type="submit" value="Delete" class="btn btn-danger">
					<input type="button" id="editBtn_1" class="btn btn-warning" value="Edit">
					<input type="button" onclick="window.location.href='${gradeUrl}'" class="btn btn-info" value="ST Tissue Internal Specification">
				</div>
			</form>
		</div>
	</div>
	<!-- /.content-wrapper -->
	<jsp:include page="../footer.jsp"></jsp:include>
</div>
</body>
</html>
