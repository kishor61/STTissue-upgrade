<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page import="com.st.timecard.utility.CustomUser"%>
<!DOCTYPE html>

<%
CustomUser user = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

%>


<html>
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Admin Home | ST TimeCard</title>
      <!-- Tell the browser to be responsive to screen width -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- Font Awesome -->
      <link rel="stylesheet" href="/timecard/plugins/fontawesome-free/css/all.min.css">
      <!-- Tempusdominus Bbootstrap 4 -->
      <link rel="stylesheet" href="/timecard/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">

      <!-- Theme style -->
      <link rel="stylesheet" href="/timecard/dist/css/layout.css">
      <link href="/timecard/dist/css/stylesheet.css" rel="stylesheet">

      <!-- Google Font: Source Sans Pro -->
      <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
      <!-- togglecss -->
      <link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/css/bootstrap4-toggle.min.css" rel="stylesheet">
      <style>


.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #3368FF;
  color: white;
}
.topnav small{
	  float: left;
	  color: #f2f2f2;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	  font-size: 17px;
  }
.topnav small.split {
  float: right;  
  color: white;
}
.topnav a.loggedout {
  float: right;
  background-color: #3368FF;
  color: white;
}
</style>  
</head>
<body class="hold-transition sidebar-mini layout-fixed  sidebar-collapse">
	<div class="topnav">
			<a class="active" href="/timecard/adminHome">Home</a>
			<a href="/timecard/register">Add Employee</a>
			<a href="#" id="EmployeeList">Download Employee List</a> 
			<a href="/timecard/getallPositions" >ViewPositions</a> 
			<a href="/timecard/login" class="loggedout">Logged out</a> 
			<small class="split">Logged In As <span>Administrator</span></small>
		</div>		
       <img src="images/loader.gif" style="position:absolute; top:0; bottom:0; left:0; right:0; margin:auto;"/>         
   </body>
</html>
