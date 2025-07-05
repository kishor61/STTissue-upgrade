<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>


<link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<link href="http://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.1/normalize.css" rel="stylesheet" type="text/css">
 
 
 
 <style>
html {
  height: 100%;
  color: #444;
}

h2 {
  margin: 1.75em 0 0;
  font-size: 5vw;
}

h3 { font-size: 1.3em; }

.v-center {
  height: 100vh;
  width: 100%;
  display: table;
  position: relative;
  text-align: center;
}

.v-center > div {
  display: table-cell;
  vertical-align: middle;
  position: relative;
  top: -10%;
}

.btn {
  padding: 0.75em 1.5em;
  background-color: #fff;
  border: 1px solid #bbb;
  color: #333;
  text-decoration: none;
  display: inline;
  border-radius: 4px;
  -webkit-transition: background-color 1s ease;
  -moz-transition: background-color 1s ease;
  transition: background-color 1s ease;
}

.btn:hover {
  background-color: #ddd;
  -webkit-transition: background-color 1s ease;
  -moz-transition: background-color 1s ease;
  transition: background-color 1s ease;
}

.btn-small {
  padding: .75em 1em;
  font-size: 0.8em;
}

.modal-box {
  display: none;
  position: absolute;
  z-index: 1000;
  width: 98%;
  background: white;
  border-bottom: 1px solid #aaa;
  border-radius: 4px;
  box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
  border: 1px solid rgba(0, 0, 0, 0.1);
  background-clip: padding-box;
}
@media (min-width: 35em) {

.modal-box { width: 52%; }
.modal-box1 { width: 35%; }
}
@media screen and (min-width: 1600px) {
    .modal-box { width: 45%; }
}

.modal-box header,
.modal-box .modal-header {
  padding: 1.25em 1.5em;
  border-bottom: 1px solid #ddd;
}

.modal-box header h3,
.modal-box header h4,
.modal-box .modal-header h3,
.modal-box .modal-header h4 { margin: 0; }

.modal-box .modal-body { padding: 2em 1.5em; }

.modal-box footer,
.modal-box .modal-footer {
  padding: 1em;
  border-top: 1px solid #ddd;
  background: rgba(0, 0, 0, 0.02);
  text-align: right;
}

.modal-overlay {
  opacity: 0;
  filter: alpha(opacity=0);
  position: absolute;
  top: 0;
  left: 0;
  z-index: 900;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.3) !important;
}

a.close {
  line-height: 1;
  font-size: 1.5em;
  position: absolute;
  top: 5%;
  right: 2%;
  text-decoration: none;
  color: #bbb;
}

a.close:hover {
  color: #222;
  -webkit-transition: color 1s ease;
  -moz-transition: color 1s ease;
  transition: color 1s ease;
}
.table-selector {
    padding: 12px;
}
.text1
{
border: 2px solid rgb(173, 204, 204);
height: 22px;
width: 195px;
box-shadow: 0px 0px 27px rgb(204, 204, 204) inset;
transition:500ms all ease;
padding:3px 3px 3px 3px;
}
.text2
{
border: 2px solid rgb(173, 204, 204);
box-shadow: 0px 0px 27px rgb(204, 204, 204) inset;
transition:500ms all ease;
}
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 9px 21px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
input, optgroup, select, textarea {
	    color: black !important;
}

</style>
 
 
  
</head>
<body>


<div class="page-box" id="loadPage">
		<div style="margin-top: 200px;">
			<img alt="Loading" src='<spring:url value="/resources/images/ajax-loader.gif"/>'>
		</div>
</div>
	
	

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			
				<div class="pageContent">

				<div class="page-title">
					<span class="label">Maintenance Log</span>
				</div>
				
				
				<div class="table-selector" style="margin-top: 2px;">
					 
					 <spring:url value="/manintenanceMonitoring/MaintenanceMonitoring/report/data" var="searchURL"/>
			          <form action="${searchURL}" method="post">
						<table>
							<tr>
								<td style="width:6%;border: none;">  
									Start Date : <input type="text" name="sDate">
								</td>
								<td style="width:5%;border: none;">
									End Date : <input type="text" name="eDate">
								</td>
								<td style="width: 7%;border: none;">  
									SKU Code : 
									<select name="skuCode" id="skucode" style="width: 200px; padding: 2px;" required="required" tabindex="2">
									<option value="-1">Select</option>
									<c:forEach items="${skucode}" var="skucode">
										<c:choose>
											<c:when test="${skucode.productcode eq searchedskucode }">
												<option value="${skucode.productcode}" selected="selected">${skucode.productcode}</option>
											</c:when>
											<c:otherwise>
												<option value="${skucode.productcode}">${skucode.productcode}</option>	
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
								
								</td>
								
								<td style="width: 5%;border: none;">  
								Area : 
								<select name="area" style="width: 200px; padding: 2px;" required="required" tabindex="3">
							      	  <option value="-1">Select</option>
									<c:forEach items="${arealst}" var="arealst">
										<c:choose>
											<c:when test="${arealst.name eq searchedskucode }">
												<option value="${arealst.name}" selected="selected">${arealst.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${arealst.name}">${arealst.name}</option>	
											</c:otherwise>
										</c:choose>
									</c:forEach>
							    </select>
								</td>
								
								<td style="width: 7%;border: none;">  
									Error Code : 
									
									<input type="text" name="errorCode">
								</td>
								
								<td style="width: 13%;border: none;">  
									<input type="submit" value="Search" />
								</td>
								
									
								
							</tr>
							 
							
						</table>
					</form> 
						  
 
				</div>
				
				<c:if test="${not empty data }">
				
				  <div>
						     <table>
						     	<tr>
						     		<th>S.No</th>
						     		<th>Date</th>
						     		<th>Sku Code</th>
						     		<th>Area</th>
						     		<th>Error Code</th>
						     		<th>Error Description</th>
						     		<th>Commants</th>
						     		<!-- <th>Picture</th> -->
						     	</tr>
						     	
						     	  <%!int i = 1; %>
						     	
						     	
						     	<c:forEach items="${data}" var="map">
							    <tr>
							        <td><%=i++ %></td>
						     		<td>${map.geteDate()}</td>
						     		<td>${map.getSkuCode()}</td>
						     		<td>${map.getArea()}</td>
						     		<td>${map.getErrorCode()}</td>
						     		<td>${map.getErrorDescription()}</td>
						     		<td>${map.getCommants()}</td>
						     		<!-- <td>Picture</td> -->
							    </tr>
							</c:forEach>
						     	 <%i = 1;%>
						     	 
						     	
						     	<tr>
						     		
						     	</tr>
						     </table>
						</div> 
					 
  				</c:if>
				
				
			 
			</div>
		    

		</div>


	</div>
	
	
	 
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
	<script>
$(function(){
	

	$('input[name=eDate]').datepicker({
		dateFormat:'mm/dd/yy',
		changeMonth: true,
	    changeYear: true
	});	
	
	$('input[name=sDate]').datepicker({
		dateFormat:'mm/dd/yy',
		changeMonth: true,
	    changeYear: true
	});	
	
	

var appendthis =  ("<div class='modal-overlay js-modal-close'></div>");

	$('a[data-modal-id]').click(function(e) {
		e.preventDefault();
    //$("body").append(appendthis);
    $(".modal-overlay").fadeTo(500, 0.0);
   // $(".js-modalbox").fadeIn(500);
		var modalBox = $(this).attr('data-modal-id');
		$('#'+modalBox).fadeIn($(this).data());
	});  
  
  
$(".js-modal-close, .modal-overlay").click(function() {
    $(".modal-box, .modal-overlay").fadeOut(500, function() {
        $(".modal-overlay").remove();
    });
 
});
 
$(window).resize(function() {
    $(".modal-box").css({
      //  top: ($(window).height() - $(".modal-box").outerHeight()) / 2,
        left: ($(window).width() - $(".modal-box").outerWidth()) / 2
    });
});
 
$(window).resize();



$("#custname").prop("disabled", true);
$("#custaddress1").prop("disabled", true);
$("#custaddress2").prop("disabled", true);
$("#custcity").prop("disabled", true);
$("#custstate").prop("disabled", true);
$("#custzip").prop("disabled", true);
$("#update").prop("disabled", true);



});
//"${map.getName() }","${map.getId() }","${map.getAddress1()}","${map.getAddress2()}","${map.getCity()}","${map.getState()}","${map.getZip()}")
function editProfile(a,b,c,address2,city,state,zip)
{
	$("#custname").prop("disabled", false);
	$("#custaddress1").prop("disabled", false);
	$("#custaddress2").prop("disabled", false);
	$("#custcity").prop("disabled", false);
	$("#custstate").prop("disabled", false);
	$("#custzip").prop("disabled", false);
	$("#update").prop("disabled", false);
	
	$('#custid').val(b);
	$('#custname').val(a)
	$('#custaddress1').val(c)
	$('#custaddress2').val(address2)
	$('#custcity').val(city)
	$('#custstate').val(state)
	$('#custzip').val(zip)
}
function editProductCode(a,b)
{
	$('#prodid').val(b);
	$('#prodcode').val(a)
}

 
function myFunction()
	{
		var r=confirm("you want to Delete this Record ?"); 		
		
		if(r==false) { 
			return false;
		} 
		return true;	
	}
</script>

</body>
</html>