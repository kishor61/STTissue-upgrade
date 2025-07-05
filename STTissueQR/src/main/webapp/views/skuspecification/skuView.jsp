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
					<span class="label">Product Specification</span>
				</div>
				
				
				<div class="table-selector" style="margin-top: 2px;">
					 
						<table>
							<tr>
								<td>  
									&nbsp;&nbsp;
									<a class="js-open-modal btn" href="#" data-modal-id="popup1"> Add Customer</a>&nbsp;&nbsp;<a class="js-open-modal btn" href="#" data-modal-id="popup2"> Add Product Code</a>
									&nbsp;&nbsp;
								</td>	
								
							</tr>
							
							
							
						</table>
						 
						<div id="popup1" class="modal-box">
						  <header> <a href="#" class="js-modal-close close">×</a>
						    <h3>Add Customer</h3>
						  </header>
						  <div class="modal-body">
						  	 <spring:url value="/skuspecification/save" var="viewURL"/>
						     <form action="${viewURL}" method="post">
						     	<div style="text-align: -webkit-auto;">
						     	<div style="width: 50%;float: left;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;margin-left: 22px;">Customer Name: </h4> 
						      	<input type="text" name="customername" class="text1">
						      	</div>
						      	<div style="width: 50%;float: right;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;">Customer Address1: </h4> 
						      	<input type="text" name="customeraddress1" class="text1">
						      	</div>
						      	<div style="width: 50%;float: left;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;">Customer Address2: </h4> 
						      	<input type="text" name="customeraddress2" class="text1">
						      	</div>
						      	<div style="width: 50%;float: right;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;">Customer City: </h4> 
						      	<input type="text" name="customercity" class="text1" style="margin-left: 32px;">
						      	</div>
						      	<div style="width: 50%;float: left;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;">Customer State: </h4> 
						      	<input type="text" name="customerstate" class="text1" style="margin-left: 26px;">
						      	</div>
						      	<div style="width: 50%;float: right;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;">Customer Zip: </h4> 
						      	<input type="text" name="customerzip" class="text1" style="margin-left: 36px;">
						      	<br /></br><br /></br>
						      	</div>
						      	
						      	<input type="submit" style="margin-left: 39%;" class="button" value="Save"/>
						       </div>
						     	
						     </form>
						  </div>
						  <header style="border-top: 1px solid #ddd;"> <a href="#" class="js-modal-close close">×</a>
						    <h3>Edit Customer</h3>
						  </header>
						    <div class="modal-body">
						    <spring:url value="/skuspecification/update" var="updateURL"/>
						      <form action="${updateURL}" method="post">
						       	<input type="hidden" name="custid" id="custid" class="text1">
						     	<div style="text-align: -webkit-auto;">
						     	<div style="width: 50%;float: left;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;margin-left: 22px;">Customer Name: </h4> 
						      	<input type="text" name="custname" id="custname" class="text1">
						      	</div>
						      	<div style="width: 50%;float: right;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;">Customer Address1: </h4> 
						      	<input type="text" name="custaddress1" id="custaddress1" class="text1">
						      	</div>
						      	<div style="width: 50%;float: left;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;">Customer Address2: </h4> 
						      	<input type="text" name="custaddress2" id="custaddress2" class="text1">
						      	</div>
						      	<div style="width: 50%;float: right;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;">Customer City: </h4> 
						      	<input type="text" name="custcity" id="custcity" class="text1" style="margin-left: 32px;">
						      	</div>
						      	<div style="width: 50%;float: left;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;">Customer State: </h4> 
						      	<input type="text" name="custstate" id="custstate" class="text1" style="margin-left: 26px;">
						      	</div>
						      	<div style="width: 50%;float: right;">
						      	<h4 style="display: -webkit-inline-box;padding-top: 25px;">Customer Zip: </h4> 
						      	<input type="text" name="custzip" id="custzip" class="text1" style="margin-left: 36px;">
						      	<br /></br><br /></br>
						      	</div>
						      	
						      	<input type="submit" style="margin-left: 38%;" class="button" id="update" value="Update"/>
						       </div>
						     	
						     </form>
						     
						     <div style="overflow-y: scroll;height: 150px;">
						     <table>
						     	<tr>
						     		<th>S.No</th>
						     		<th>Name</th>
						     		<th>Address</th>
						     		<th>City</th>
						     		<th>State</th>
						     		<th>Action</th>
						     	</tr>
						     	
						     	 <%!int i = 1; %>
						     	
						     	
						     	<c:forEach items="${data}" var="map">
							    <tr>
							        <td><%=i++ %></td>
						     		<td>${map.getName()}</td>
						     		<td>${map.getAddress1()},${map.getAddress2()}</td>
						     		<td>${map.getCity()}</td>
						     		<td>${map.getState()}</td>
						     		 <spring:url value="/skuspecification/deleteCust/${map.getId()}" var="deleteURL"/>
						     		<td><a href='javascript:;' onclick='editProfile("${map.getName() }","${map.getId() }","${map.getAddress1()}","${map.getAddress2()}","${map.getCity()}","${map.getState()}","${map.getZip()}");'>Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href='${deleteURL}' onclick="return myFunction()">Delete</a></td> 
							    </tr>
							</c:forEach>
						     	 <%i = 1;%>
						     	
						     	
						     	<tr>
						     		
						     	</tr>
						     </table>
						    </div> 
						     
						     
						     
						  </div>
						 
						</div>
						
						
						<div id="popup2" class="modal-box modal-box1">
						  <header> <a href="#" class="js-modal-close close">×</a>
						    <h3>Add Product Code</h3>
						  </header>
						  <div class="modal-body">
						  	 <spring:url value="/skuspecification/saveproductcode" var="viewURL"/>
						     <form action="${viewURL}" method="post">
						     	<div style="text-align: -webkit-auto;margin-left: 39px;">
						      	<h3 style="display: -webkit-inline-box;float: left;padding-top: 11px;">Product Code: </h3>&nbsp;&nbsp;
						      	<input type="text" name="productcode" class="text1">
						      	<br /></br><br /></br>
						      	<input type="submit" style="margin-left: 35%;" class="button" value="Save"/>
						       </div>
						     	
						     </form>
						  </div>
						  <header style="border-top: 1px solid #ddd;"> <a href="#" class="js-modal-close close">×</a>
						    <h3>Edit Product Code</h3>
						  </header>
						    <div class="modal-body">
						    <spring:url value="/skuspecification/updateCode" var="updateURL"/>
						     <form action="${updateURL}" method="post">
						     	<div style="text-align: -webkit-auto;margin-left: 39px;">
						      	<h3 style="display: -webkit-inline-box;float: left;padding-top: 11px;">Product Code: </h3>&nbsp;&nbsp;
						      	<input type="text" name="prodcode" id="prodcode" class="text1">
						      	<input type="hidden" name="prodid" id="prodid">
						      	<br /></br><br /></br>
						      	<input type="submit" style="margin-left: 35%;" class="button" value="Update"/>
						      	<br /></br><br /></br>
						       </div>
						     	
						     </form>
						     <div style="overflow-y: scroll;height: 150px;">
						     <table>
						     	<tr>
						     		<th>S.No</th>
						     		<th>Product Code</th>
						     		<th>Action</th>
						     	</tr>
						     	
						     	 <%!int j = 1; %>
						     	 
						     	<c:forEach items="${productCode}" var="productCode">
							    <tr>
							        <td><%=j++ %></td>
						     		<td>${productCode.getProductCode()}</td>
						     		<spring:url value="/skuspecification/deleteProd/${productCode.getId()}" var="deleteProductCodeURL"/>
						     		<td><a href='javascript:;' onclick='editProductCode("${productCode.getProductCode() }","${productCode.getId() }");'>Edit</a> &nbsp;&nbsp;&nbsp; <a href='${deleteProductCodeURL}' onclick="return myFunction()">Delete</a></td> 
							    </tr>
							</c:forEach>
						     	 <%j = 1;%> 
						     	 
						     	<tr>
						     		
						     	</tr>
						     </table>
						    </div> 
						     
						     
						     
						  </div>
						 
						</div>
						
						
						
 
				</div>
				
				
			
			</div>
		    

		</div>


	</div>
	
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script> 
	<script>
$(function(){

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