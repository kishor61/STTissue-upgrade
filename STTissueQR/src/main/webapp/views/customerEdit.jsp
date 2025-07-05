<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('#saveBtn').click(function(){
			var name=$.trim($('input[name=name]').val());
			if(name==''){
				alert('Please enter customer name.');
				return false;
			}
			
			return true;
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
		><h5 style="text-align:center; font-weight:bold;color:#343e70;">Edit Customer</h5></div>

	<div class="container">


		<div class="block3">
			<div class="pageContent">

	<br>
	<span class="error">${error}</span>
	<span class="message">${message}</span>
	
	<form action='<spring:url value="/grade/savecustomer"/>' method="post">
	    <div style="max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 15px; background: linear-gradient(135deg, #2189b9, #5aafdb); box-shadow: 0 15px 30px rgba(0, 0, 0, 0.2);">
	        <h3 style="text-align: center; margin-bottom: 20px; font-family: 'Arial', sans-serif; color: #fff;">Customer Information</h3>
	        
	        <!-- Customer Name -->
	        <div class="mb-3">
	            <label for="name" class="form-label" style="font-weight: bold; color: #fff;">Customer Name</label>
	            <input type="text" class="form-control" name="name" id="name" style="width: 100%; border-radius: 10px; padding: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); background-color: #fff; border: 1px solid #ddd;" value="${customer['name']}" required>
	        </div>

	        <!-- Location -->
	        <div class="mb-3">
	            <label for="location" class="form-label" style="font-weight: bold; color: #fff;">Location</label>
	            <input type="text" class="form-control" name="location" id="location" style="width: 100%; border-radius: 10px; padding: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); background-color: #fff; border: 1px solid #ddd;" value="${customer['location']}" required>
	        </div>

	        <!-- City -->
	        <div class="mb-3">
	            <label for="city" class="form-label" style="font-weight: bold; color: #fff;">City</label>
	            <input type="text" class="form-control" name="city" id="city" style="width: 100%; border-radius: 10px; padding: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); background-color: #fff; border: 1px solid #ddd;" value="${customer['city']}" required>
	        </div>

	        <!-- State -->
	        <div class="mb-3">
	            <label for="state" class="form-label" style="font-weight: bold; color: #fff;">State</label>
	            <input type="text" class="form-control" name="state" id="state" style="width: 100%; border-radius: 10px; padding: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); background-color: #fff; border: 1px solid #ddd;" value="${customer['state']}" required>
	        </div>

	        <div class="text-center">
	            <!-- Submit Button -->
	            <button type="submit" class="btn btn-primary btn-sm" style="width: 45%; margin-right: 10px; padding: 8px 16px; font-size: 14px; border-radius: 20px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);" onmouseover="this.style.boxShadow='0 4px 15px rgba(0, 123, 255, 0.5)';" onmouseout="this.style.boxShadow='0 4px 8px rgba(0, 0, 0, 0.1)';">Submit</button>
	            
	            <!-- View Customer Button -->
	            <spring:url value="/grade/viewcustomer" var="viewUrl"/>
	            <button type="button" class="btn btn-secondary btn-sm" onclick="window.location.href='${viewUrl}'" style="width: 45%; padding: 8px 16px; font-size: 14px; border-radius: 20px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);" onmouseover="this.style.boxShadow='0 4px 15px rgba(0, 123, 255, 0.5)';" onmouseout="this.style.boxShadow='0 4px 8px rgba(0, 0, 0, 0.1)';">View Customer</button>
	        </div>
	        
	        <!-- Hidden ID -->
	        <input type="hidden" name="id" value="${customer['id']}">
	        
	        <!-- ST Tissue Internal Specification Button -->
	        <spring:url value="/grade/main" var="gradeUrl"/>
	        <div class="text-center" style="margin-top: 10px;">
	            <button type="button" class="btn btn-info btn-sm" onclick="window.location.href='${gradeUrl}'" style="width: 45%; padding: 8px 16px; font-size: 14px; border-radius: 20px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);" onmouseover="this.style.boxShadow='0 4px 15px rgba(0, 123, 255, 0.5)';" onmouseout="this.style.boxShadow='0 4px 8px rgba(0, 0, 0, 0.1)';">ST Tissue Internal Specification</button>
	        </div>
	    </div>
	</form>

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
