<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<div class="logo">
	<span><img style="height:35px; border: none;" alt="ST STissue" src='<spring:url value="/resources/images/STTissue.JPG"/>'> </span>
</div>

<div class="fixed-message">
	<span class="tmessage" id="tmessage"></span>
</div>



<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR6')">
<div class="nav">
	<ul>
		<li>
			
				<a href='<spring:url value="/signout"></spring:url>' style="text-decoration: none;"><span class="flaticon-logout"> Sign Out</span></a>
			
		</li>

		<li>
			
			<span> Logged In as <b><security:authentication property="principal.username"/></b></span>
			
		</li>
	</ul>
</div>
</security:authorize>


<div class="navbar">

<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR6')">
	<ul>
		<li>
			<a href='<spring:url value="/home"></spring:url>'>Main Menu</a>
		</li>

		<li><div class="sep"></div></li>
		<li class="dropdown">
			<a href='<spring:url value="/report"></spring:url>'>Reports &#9662;</a>
			<ul>
				<li class="divider">PM6 PRODUCTION</li>
				<li><a href='<spring:url value="/reelreport/"/>'>Reel Testing </a></li>
				<li><a href='<spring:url value="/rewindreport/"/>'>Rewinder Testing </a></li>
				<li><a href='<spring:url value="/centerlinereport/view"/>'>Centerline Data</a></li>
				<li><a href='<spring:url value="/efficiencyreport/main"/>'>Efficiency </a></li>
				<li><a href='<spring:url value="/efficiencyreport/summary"/>'>Efficiency Summary</a></li>
				<li><a href='<spring:url value="/utilitykpimasterreport/view"/>'>KPI, Master and  Utility</a></li>
				<li><a href='<spring:url value="/wrapperredcodereport/view"/>'>Wrapper Red/Reject Tons Summary</a></li>
				<li class="divider">FRP PRODUCTION</li>
				<li><a href='<spring:url value="/frpproduction/view"/>'>Production Data </a></li>
				<li><a href='<spring:url value="/frpefficiencyreport/main"/>'>Efficiency </a></li>
				<li><a href='<spring:url value="/frpefficiencyreport/summary"/>'>Efficiency Summary</a></li>
				<li><a href='<spring:url value="/frppressqualityreport/view"/>'>Press Quality Data</a></li>
			</ul>
		</li>
	</ul>
</security:authorize>

</div>
