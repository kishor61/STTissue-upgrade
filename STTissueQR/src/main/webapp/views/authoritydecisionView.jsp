<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css_main_roshan/style.css"/>'>

 

<script type="text/javascript" src='<spring:url value="/resources/js/TimeCircles.js"/>'></script>
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/TimeCircles.css"/>'>
<style>
	.block1
	{
		z-index: -1;
	}
	.countclass
	{
		width: 100%;
    	height: 60%;
    	background-color: rgba(0, 0, 0, 0.39);
	}
</style>
<script>
function passwordConformvalidation() {
	//alert("HI");
    var pass1 = document.getElementById("otp1").value;
    var pass2 = document.getElementById("otp2").value;
    var ok = true;
    if (pass1 != pass2) {
        $('#subbtn').prop('disabled', true);
        $('#notmatch').show();
         
         
    }
    else {
    	$('#subbtn').prop('disabled', false);
    	 $('#notmatch').hide();
    }
    return ok;
}
</script>

<script type="text/javascript"> 
      $(document).ready( function() {
        $("#maincls").hide(); 
        $('#deletesuccess').delay(5000).fadeOut();
      });
</script>
<c:if test="${showalert}">	
<spring:url value="/home" var="parentURl"></spring:url>
<script>
$( document ).ready(function() {
	$("#maincls").show();
	$("#content").hide();
	

$("#CountDownTimer").TimeCircles({ total_duration: 10,time: { Days: { show: false }, Hours: { show: false },Minutes: { show: false } }}).addListener(
		function(unit,value,total) { 
			if (value == 0) {  
				window.location = "${parentURl}";
			} 
		} 
	  );

});
  
</script>

</c:if>
</head>
<body>


	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				
<br /><br /><br /><br />			
<div class="container">
	<section id="content">
		<form action='<spring:url value="/higherauthoritydecision/apply/action/now"/>' method="POST">
		<c:if test ="${status eq 'Allow'}">
			<h1>Block Auto Mail</h1>
		</c:if>
		<c:if test ="${status eq 'Block'}">
			<h1>Allow Auto Mail</h1>
		</c:if>
			
			<div>
				<input type="text" placeholder="OTP" name="otp2" id="otp2" onchange="passwordConformvalidation()" required="required" />
				<input type="hidden" value="${otp}" name="otp1" id="otp1">
				<c:if test ="${status eq 'Allow'}">
					<input type="hidden" value="Block" name="status" id="status">
				</c:if>
				<c:if test ="${status eq 'Block'}">
					<input type="hidden" value="Allow" name="status" id="status">
				</c:if>
			</div>
			<c:if test ="${status eq 'Allow'}">
				<div>
					<input type="submit" value="Block" id="subbtn" disabled="disabled"/>
				</div>
			</c:if>
			<c:if test ="${status eq 'Block'}">
				<div>
					<input type="submit" value="Allow" id="subbtn" disabled="disabled"/>
				</div>
			</c:if>
			<div>
				<span id="deletesuccess" style="color: green;font-size: 14px;font-style: oblique;font-weight: 700;">${msg}</span>
			</div>
			<span id="notmatch" style="display: none;color: red;">Invalid Security Code.Please Enter Correct OTP.</span>
		</form>
		<div class="button">
			<!-- <a href="#">Download source file</a> -->
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->	

				
				
				
				
				
				

			</div>

		</div>
 
	</div>
	<div class="countclass" id="maincls">
	   <div id="CountDownTimer" data-timer="900" style="width: 1000px;height: 700px;margin-left: 350px;"></div>
	</div>
</body>
</html>
