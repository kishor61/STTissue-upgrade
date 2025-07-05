<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>
<head>
	<title>ST Tissue </title>
	<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/newLoginPage/css/style.css"/>'>
	<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/newLoginPage/fonts/css.css"/>'>
	<link rel="icon" type="image/x-icon" href='<spring:url value="/resources/newLoginPage/images/STTissue.png"/>'>
		<!-- For-Mobile-Apps-and-Meta-Tags -->
			<meta name="viewport" content="width=device-width, initial-scale=1" />
 		<!-- //For-Mobile-Apps-and-Meta-Tags -->
 	<jsp:include page="common.jsp"></jsp:include>	
<spring:url value="/home" var="homeURL"/>
</head>

<body>
<security:authorize access="isRememberMe()">
	<script type="text/javascript">
		$(function(){
			location.href='${homeURL}';
		});
	</script>
</security:authorize>

<security:authorize access="isAuthenticated()">
	<script type="text/javascript">
		$(function(){
			location.href='${homeURL}';
		});
	</script>
</security:authorize>

<security:authorize access="isAnonymous()">

		<c:if test="${newyear}">
			<marquee attribute_name="attribute_value" style="position: absolute;">
				<img alt="santa" src='<spring:url value="/resources/newLoginPage/images/animated-happy-new-year-image-0044.gif"/>'>
				<img alt="santa" src='<spring:url value="/resources/newLoginPage/images/14.gif"/>' style="width: 200px;">
			</marquee>
			<div style="position: absolute;display: flex;overflow: hidden;padding: 111px 7px 6px 23px;">	
				<img alt="chrismas" style="repeat-y" src='<spring:url value="/resources/newLoginPage/images/xbunting_010.png.pagespeed.ic.Y_QcY-oGZz.webp" />'>
				<img alt="chrismas" style="repeat-y" src='<spring:url value="/resources/newLoginPage/images/xbunting_010.png.pagespeed.ic.Y_QcY-oGZz.webp" />'>
				<img alt="chrismas" style="repeat-y" src='<spring:url value="/resources/newLoginPage/images/xbunting_010.png.pagespeed.ic.Y_QcY-oGZz.webp" />'>
			</div>
		</c:if>
	 <c:if test="${christmas}">
		 <marquee attribute_name="attribute_value" style="position: absolute;">
			<img alt="santa" src='<spring:url value="/resources/newLoginPage/images/santa.png"/>'>
			<img alt="santa" src='<spring:url value="/resources/newLoginPage/images/Merry-XMAS-Show-Image.png"/>' style="width: 350px;">
		 </marquee>
	 </c:if>
		<h1><img src='<spring:url value="/resources/newLoginPage/images/STTissue.png"/>'style="margin-left: -23px;"><p style="margin-top: -21px;">ST Tissue</p></h1>
    <c:if test="${christmas}">
     <div style="position: absolute;display: flex;overflow: hidden;padding: 8px 7px 6px 23px;">	
			<img alt="chrismas" style="repeat-y" src='<spring:url value="/resources/newLoginPage/images/xbunting_010.png.pagespeed.ic.Y_QcY-oGZz.webp" />'>
			<img alt="chrismas" style="repeat-y" src='<spring:url value="/resources/newLoginPage/images/xbunting_010.png.pagespeed.ic.Y_QcY-oGZz.webp" />'>
			<img alt="chrismas" style="repeat-y" src='<spring:url value="/resources/newLoginPage/images/xbunting_010.png.pagespeed.ic.Y_QcY-oGZz.webp" />'>
	</div>
	</c:if>
    <div class="container w3">
        <h2>Login Now</h2>
		<form action="j_spring_security_check" method="post">
			<div class="username">
				<%-- <spring:message code="label.username" /> --%>
				<span class="username">Username:</span>
				<input type="text" name="j_username"  class="name" placeholder="" required="">
				<div class="clear"></div>
			</div>
			<div class="password-agileits">
				<%-- <spring:message code="label.password" /> --%>
				<span class="username">Password:</span>
				<input type="password" name="j_password" class="password" placeholder="" required="">
				<div class="clear"></div>
			</div>
			<c:if test="${not empty param.error}">
				<p style="color: red;float: left;">
					<spring:message code="error.signin.fail" />
				</p>
				<br />
			</c:if>	
			<div class="rem-for-agile">
				<input type="checkbox" name="_spring_security_remember_me" checked="checked" class="remember">Remember me<br>
			</div>
			<div class="login-w3">
					<input type="submit" class="login" value="Login">
			</div>
			<div class="clear"></div>
		</form>
		
		<div class="login-w3" style="width: 100% !important;"><br />
		  
		
		<a href="https://msdsmanagement.msdsonline.com/39f24252-5cde-440c-a398-8fbb9eb3e764/ebinder/?nas=True" target="_blank"><input type="button" class="login" value="MSDS"></a>
	</div>
	</div>
</security:authorize>	
	<div class="footer-w3l">
		<p> &copy;<a href="http://www.stpaperllc.com/" target="_blank">ST Tissue LLC. All rights reserved.  </a></p>
	</div>
</body>
</html>