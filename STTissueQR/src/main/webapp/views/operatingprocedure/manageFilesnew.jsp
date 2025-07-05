<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
.table td{
	height: 18px;
}
.table a{
	color: blue;
}
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

/* DivTable.com */
.divTable{
	display: table;
	width: 100%;
}
.divTableRow {
	display: table-row;
}
.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
}
.divTableCell, .divTableHead {
	border: 1px solid #999999;
	display: table-cell;
	padding: 3px 10px;
}
.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
	font-weight: bold;
}
.divTableFoot {
	background-color: #EEE;
	display: table-footer-group;
	font-weight: bold;
}
.divTableBody {
	display: table-row-group;
}
</style>
<style type="text/css">
/* DivTable.com */
.divTable{
	display: table;
	width: 30%;
}
.divTableRow {
	display: table-row;
}
.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
}
.divTableCell, .divTableHead {
	border: 1px solid #999999;
	display: table-cell;
	padding: 3px 10px;
}
.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
	font-weight: bold;
}
.divTableFoot {
	background-color: #EEE;
	display: table-footer-group;
	font-weight: bold;
}
.divTableBody {
	display: table-row-group;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>
		
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div class="content-header" style="padding-top: 10px !important;padding-bottom: 0px !important;line-height: 0px !important;">
			<h5 style="text-align:center; font-weight:bold;color:#343e70;">Procedures</h5>
		</div>
		<div class="block3" style="overflow: auto;">
		 
			<div class="pageContent">
				<security:authorize access="hasAnyRole('ADMIN')">
				<div class="table-selector" style="background-color:#2189b9 !important; border: 1px solid #7e00ff42;">

					<spring:url value="/operatingprocedure/save" var="saveURL"/>
					<form action="${saveURL}" method="post" enctype="multipart/form-data">
						<table>
							<tr>
								<%-- <td>Category</td>
								<td>
									<input type="text" name="type" maxlength="50" value="${type}" style="width: 150px;">
								</td>
								<td>Sub Category</td>
								<td>
									<input type="text" name="subType" maxlength="50" value="${subType}" style="width: 150px;">
								</td>
								<td>
									<input type="file" name="file">
								</td>
								<td>
									<input type="submit" value="SAVE">
								</td>
								<td>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<c:if test="${not empty error}">
										<span class="error">${error}</span>
									</c:if>
									<c:if test="${not empty message}">
										<span class="message">${message}</span>
									</c:if>
								</td>
								 --%>
								
								<td>
									 &nbsp;&nbsp;&nbsp;
									<button type="button" id="manageCategory">Upload Document</button>
									&nbsp;&nbsp;
									<button type="button"  id="manageAreapopup" onclick="showManageArea()">Manage Area</button>
									&nbsp;&nbsp;
									<button type="button"  id="manageCategorypopupshow" onclick="showlogin()">Manage Category</button>
									&nbsp;&nbsp;
									<!-- <button type="button" id="manageSubCategory">Manage Sub Category</button> -->
									<button type="button"  id="manageSubCategorypopupshow" onclick="showSublogin()">Manage Sub Category</button>
									<button type="button"  id="showAllAreaPopUp" onclick="showAllArea()">Show Uploaded Documents</button>
								</td>	
								
							</tr>
							
							
							
						</table>
					
					</form>
					
					
					

				</div>
				
				
				<c:if test="${not empty error}">
				<script>
				function closeIFrame(){
				     $('#dialog').remove();
				}
				closeIFrame
				</script>
			</c:if>
			<c:if test="${not empty message}">
				<span class="message">${message}</span>
			</c:if>


					
				
				
				
		
</security:authorize>				
<br>
<div style="padding: 2px; overflow: auto; position: inherit;bottom: 0;left: 5px;right: 5px;top: 131px;">
<!-- <div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 131px;"> -->
<%-- <spring:url value="/operatingprocedure/search" var="searchURL"/>
<form action="${searchURL}" method="get">
<center>
<table>
	<tr>
		<td>File Name</td>
		<td><input type="text" name="file" value="${file}" style="width: 200px;"></td>
		<td>Area</td>
		<td>
		<select name="area" style="width: 150px; padding: 3px;" required="required">
					<option value="-1">Select</option>
					<c:forEach items="${areas}" var="are">
						<option value="${are.area}">${are.area}</option>
					</c:forEach>
			</select>
		</td>
		<td>Category</td>
		<td>
			<select name="category" style="width: 200px;padding: 2px;">
				<option value="">Select</option>
				<c:forEach items="${types}" var="type">
					<c:choose>
						<c:when test="${type eq category}">
							<option value="${type}" selected="selected">${type}</option>
						</c:when>
						<c:otherwise>
							<option value="${type}">${type}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
		<td>Sub Category</td>
		<td>
			<select name="subCategory" style="width: 200px;padding: 2px;">
				<option value="">Select</option>
				<c:forEach items="${subTypes}" var="subType">
					<c:if test="${not empty subType}">
					<c:choose>
						<c:when test="${subType eq subCategory}">
							<option value="${subType}" selected="selected">${subType}</option>
						</c:when>
						<c:otherwise>
							<option value="${subType}">${subType}</option>
						</c:otherwise>
					</c:choose>
					</c:if>
				</c:forEach>
			</select>
		</td>
		<td><button type="submit">SEARCH</button> </td>
	</tr>
</table>
</center>
</form>

<center> --%>
<%--< table class="table" style="width:900px;margin: inherit;" id="data_table" >
	<c:forEach items="${uniqueTypes}" var="typeOb">
		<tr style="background: rgba(193, 123, 38, 0.94);color: white;">
			<td colspan="4" ><b>${typeOb.name}</b></td>
		</tr>
		<c:forEach items="${typeOb.subType}" var="subTypeOb">
			<tr style="background: rgba(88, 68, 20, 0.45);color: white;">
				<td colspan="4" ><b>${subTypeOb}</b></td>
			</tr>		
				<c:set value="${1}" var="count"/>
				<c:forEach items="${procedures}" var="op">
					<c:if test="${typeOb.name eq op.type &&  subTypeOb eq op.subType}">
						<tr>
							<td style="width: 20px;">${count}</td>
							<td style="width: 120px;text-align: center;"> <fmt:formatDate value="${op.entryDate}" pattern="MM/dd/yyyy hh:mma"/> </td>
							<td><a href="javascript:viewFile('${op.name}','<spring:url value="/assets/UploadedOperatingProcedureDocuments/${op.file}"/>');">${op.name}</a></td>
							<td style="width: 118px;text-align: center;">
								<security:authorize access="hasAnyRole('ADMIN')">
									<button onclick="deleteFile(this)" value="${op.id}">DELETE</button>
									<button onclick="editFile(this)" value="${op.id}">EDIT</button>
									 
								</security:authorize>
							</td>
						</tr>
						<c:set value="${count+1}" var="count"/>
					</c:if>
				</c:forEach>
		</c:forEach>
		
		
		
		
	</c:forEach>

</table> --%>
<br><br><br>
					<center>
					<div class="divTable" style="border: 1px solid #000;" id="data_table">
						<div class="divTableBody">
							<div class="divTableRow">
								<div class="divTableCell" style="font-size: 21px;">Select
									The Area</div>
							</div>
							<%int i=1; %>
							<c:forEach items="${areas}" var="are">
								<div class="divTableRow">
									<div class="divTableCell" style="text-align:  left;">
										<b><%=i%>&nbsp;.&nbsp;<a
											href='<spring:url value="/operatingprocedure/showMainCatogoeryByAreaWise?aera=${are.area}"/>'><span style="color: blue !important;">${are.area}</span></a>
										</b>
									</div>
								</div>
								<%i++;%>
							</c:forEach>
						</div>
					</div>
					</center>
</div>





					
					
					
					
					


			</div>
					<br /><br /><br /><br />
					<center>
						<div class="divTable" id="manageCategorypopup" style="width: 50%; border: 1px solid #000;">
							<div class="divTableBody">
								<div class="divTableRow">
									<div class="divTableCell">Create New Main Category</div>
									<div class="divTableCell">Enter Name: <input type="text" id="maincategoname" value="" name="maincategoname"></div>
									<div class="divTableCell">
										<button type="button" class="btn btn-primary" onclick="saveDetails()"><i class="fa fa-lock"></i> Save</button>
										<span id="saveinfo" style="display: inline;color: green;">Information Updated.</span>
									</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell"> &nbsp;</div>
									<div class="divTableCell"> &nbsp;</div>
									<div class="divTableCell"> &nbsp;</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell">Category:</div>
									<div class="divTableCell">Edit Action</div>
									<div class="divTableCell">Delete Action</div>
								</div>
								<c:forEach items="${maincategory}" var="pcode">
								<div class="divTableRow" id="divclose_${pcode.id}" data-id="${pcode.id}">
									<div class="divTableCell">${pcode.maincategoname} <input type="text" value="" name="" id="editcatename_${pcode.id}" data-id="${pcode.id}"></div>
									<div class="divTableCell">
										<button type="button" onclick="showEditFun()" id="edit_${pcode.id}" data-id="${pcode.id}">Edit</button>
										<button type="button" onclick="showEditFunSave()" id="editandsave_${pcode.id}" data-id="${pcode.id}">Save</button>
									</div>
									<div class="divTableCell"><button type="button" onclick="showDeleteFun()" id="close_${pcode.id}" data-id="${pcode.id}">Delete</button></div>
									
								</div>
								</c:forEach>
							</div>

					
					<br/><br/>
							<div  >
									<div  >
										<div  >
											<div  >
											
											<div class="input-group" id="loader">
									        	<center>
									        		<img alt="" style="width: 50px;" src='<spring:url value="/resources/rlt/Loader.gif"/>'>
									        	</center>
									        </div>
											</div>
											<div  >
											<span id="deleteinfo" style="display: inline;color: green;">Category Deleted Successfully.</span>											
												<button type="button" onclick="showloginclose()">Close</button>
											 </div>
										</div>
									</div>
								</div>
							</div>
							<!-- This Section Is For MAnage The Area Starts From Here -->
							<div class="divTable" id="manageAreapopupshow" style="width: 50%; border: 1px solid #000;">
							<div class="divTableBody">
								<div class="divTableRow">
									<div class="divTableCell">Create Area</div>
									<div class="divTableCell">Enter Area Name: <input type="text" id="areaname" value="" name="areaname"></div>
									<div class="divTableCell">
										<button type="button" class="btn btn-primary" onclick="saveAeraDetails()"><i class="fa fa-lock"></i>Save</button>
										<span id="saveinfo2" style="display: inline;color: green;">Information Updated.</span>
									</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell"> &nbsp;</div>
									<div class="divTableCell"> &nbsp;</div>
									<div class="divTableCell"> &nbsp;</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell">Area:</div>
									<div class="divTableCell">Edit Action</div>
									<div class="divTableCell">Delete Action</div>
								</div>
								 <c:forEach items="${areas}" var="are">
								<div class="divTableRow" id="divcloseArea_${are.id}" data-id="${are.id}">
									<div class="divTableCell">${are.area} <input type="text" value="" name="" id="editAreaName_${are.id}" data-id="${are.id}"></div>
									<div class="divTableCell">
										<button type="button" onclick="showEditFunArea()" id="editArea_${are.id}" data-id="${are.id}">Edit</button>
										<button type="button" onclick="showEditFunSaveArea()" id="editandsaveArea_${are.id}" data-id="${are.id}">Save</button>
									</div>
									<div class="divTableCell"><button type="button" onclick="showDeleteFunArea()" id="closeArea_${are.id}" data-id="${are.id}">Delete</button></div>
									
								</div>
								</c:forEach>
							</div>

					
					<br/><br/>
							<div  >
									<div  >
										<div  >
											<div  >
											
											<div class="input-group" id="loader2">
									        	<center>
									        		<img alt="" style="width: 50px;" src='<spring:url value="/resources/rlt/Loader.gif"/>'>
									        	</center>
									        </div>
											</div>
											<div  >
											<span id="deleteinfo2" style="display: inline;color: green;">Category Deleted Successfully.</span>											
												<button type="button" onclick="showloginclose()">Close</button>
											 </div>
										</div>
									</div>
								</div>
							</div>
							<!-- Manage Area Section Ends Here -->
							
<!-- 							This Is For Manage Sub-Category -->
								<div class="divTable" id="manageSubCategorypopup" style="width: 50%; border: 1px solid #000;">
							<div class="divTableBody">
								<div class="divTableRow">
									<div class="divTableCell">
										Select Main Category: 
										<select name="maincategoryname" style="width: 150px; padding: 3px;" id="maincategoryname">
											<option value="">Select</option>
											<c:forEach items="${maincategory}" var="pcode">
												<option value="${pcode.maincategoname}">${pcode.maincategoname}</option>
											</c:forEach>
									</select>
									</div>
									<div class="divTableCell">Enter Sub Category Name: <input type="text" id="entersubcatname" value="" name="entersubcatname"></div>
									<div class="divTableCell">
										<button type="button" class="btn btn-primary" onclick="saveSubDetails()"><i class="fa fa-lock"></i> Save</button>
										<span id="savesubinfo1" style="display: inline;color: green;">Information Updated.</span>
									</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell"> &nbsp;</div>
									<div class="divTableCell"> &nbsp;</div>
									<div class="divTableCell"> &nbsp;</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell">Main Category:</div>
									<div class="divTableCell">Sub Category:</div>
									<div class="divTableCell">Edit Action</div>
									<div class="divTableCell">Delete Action</div>
								</div>
								<c:forEach items="${subcategory}" var="pcode">
								<div class="divTableRow" id="divsubclose_${pcode.id}" data-id="${pcode.id}">
									<div class="divTableCell">${pcode.maincategoname}</div>
									<div class="divTableCell">${pcode.entersubcatname}
									<input type="text" value="" name="" id="editsubcatename1_${pcode.id}" data-id="${pcode.id}">
									</div>
									<div class="divTableCell">
										<button type="button" onclick="showSubEditFun()" id="edit_${pcode.id}" data-id="${pcode.id}">Edit</button>
										<button type="button" onclick="showEditSubFunSave()" id="editandsave_${pcode.id}" data-id="${pcode.id}">Save</button>
									</div>
									<div class="divTableCell"><button type="button" onclick="showDeleteSubCatFun()" id="DeleteSub_${pcode.id}" data-id="${pcode.id}">Delete</button></div>
									
								</div>
								</c:forEach>
							</div>

						<br /><br />
								<div  >
									<div  >
										<div  >
											<div  >
											
											<div class="input-group" id="loader1">
									        	<center>
									        		<img alt="" style="width: 50px;" src='<spring:url value="/resources/rlt/Loader.gif"/>'>
									        	</center>
									        </div>
											</div>
											<div  >
											
											<span id="deleteinfo1" style="display: inline;color: green;">Category Deleted Successfully.</span>
												<button type="button" onclick="showSubloginclose()">Close</button>
											 </div>
										</div>
									</div>
								</div>
							</div>				
<!-- 							Ends Here For Manage Sub-Category-->
							
								
					</center>
					<!-- DivTable.com -->
		</div>
		
	</div>
	
	
<spring:url value="/operatingprocedure/delete" var="deleteURL"/>
<spring:url value="/operatingprocedure/managecategorynew" var="managecategoryURL"/>
<spring:url value="/operatingprocedure/managecsubategory" var="managesubcategoryURL"/>
<spring:url value="/operatingprocedure/category/types" var="cattypeURL"/>

<spring:url value="/operatingprocedure/edit" var="editURL"/>

	
<script type="text/javascript">

$(function(){
	
	
	$.ajax({
		url:'${cattypeURL}',
		success:function(data){
			
			 $("input[name=type]").autocomplete({
			      source: data.types
			 });
			 $("input[name=subType]").autocomplete({
			      source: data.subTypes
			 });
		}
	});
	
	
	$('#manageCategory').click(function(){
		$("#dialog2 #dialogPage").attr('src', '${managecategoryURL}');
		$("#dialog2").dialog({
			title : 'Upload Document',
			width : 400,
			height : 500,
			modal : true,
			close : function() {
				$("#dialog2 #dialogPage").attr('src', "about:blank");
				location.reload(true);
			}

		});
	});
	
	$('#manageSubCategory').click(function(){
		$("#dialog2 #dialogPage").attr('src', '${managesubcategoryURL}');
		$("#dialog2").dialog({
			title : 'Manage Sub Category',
			width : 600,
			height : 500,
			modal : true,
			close : function() {
				$("#dialog2 #dialogPage").attr('src', "about:blank");
				location.reload(true);
			}

		});
	});
});

function deleteFile(btn){
	var ele=$(btn);
	ele.prop('disabled',true);
	var id=$(btn).val();
	$.ajax({
		url:'${deleteURL}',
		data:{id:id},
		success:function(data){
			if(data){
				alert('File removed successfully.')
				location.href=location.href;
			}else{
				alert('Failed to remove file.');
			}
			ele.prop('disabled',false);
		}
	});
}

function editFile(btn){

	var id=$(btn).val();
	$("#dialog2 #dialogPage").attr('src', '${editURL}/'+id);
	$("#dialog2").dialog({
		title : 'Edit',
		width : 500,
		height : 300,
		modal : true,
		close : function() {
			$("#dialog2 #dialogPage").attr('src', "about:blank");
			location.reload(true);
		}

	});
}



	function viewFile(name, file) {

		$("#dialog #dialogPage").attr('src', file);
		$("#dialog").dialog({
			title : name,
			width : $(window).width()-50,
			height : $(window).height()-50,
			modal : true,
			close : function() {
				$("#dialog #dialogPage").attr('src', "about:blank");
			},
			buttons : {
				'Close' : function() {
					$(this).dialog("close");
				}
			},
			resize : function(event, ui) {

			}

		});
	}
</script>

<div id="dialog" style="display: none;overflow: hidden;position: relative;padding-bottom: 65.25%;padding-top: 30px;">
	<iframe id="dialogPage" style="	position: absolute;top: 10%;left: 0;border: 0;width: 100%;height: 100%;"></iframe>
</div>
<div id="dialog2" style="display: none;overflow: hidden;position: relative;padding-bottom: 65.25%;padding-top: 30px;">
	<iframe id="dialogPage" style="	position: absolute;top: 10%;left: 0;border: 0;width: 100%;height: 100%;"></iframe>
</div>


<script>
		$('document').ready(function() {
			$('#manageCategorypopup').hide();
			$('#manageAreapopupshow').hide();
			$('#loader').hide();
			$('#saveinfo').hide();
			$('#saveinfo2').hide();
			$('#savesubinfo1').hide();
			$('#deleteinfo').hide();
			$('#deleteinfo2').hide();
			$('*[id^=editcatename_').hide();
			$('*[id^=editandsave_').hide();
			$('#manageSubCategorypopup').hide();
			$('#loader1').hide();
			$('#loader2').hide();
			$('#deleteinfo1').hide();
			$('*[id^=editsubcatename1_').hide();
			
			$('*[id^=editAreaName_').hide();
			
			
			
});
		function showlogin() {
			$('#manageCategorypopup').show();
			$('#manageSubCategorypopup').hide();
			$('#data_table').hide(); 
			$('#manageAreapopupshow').hide();
		}
		//Manage Area
		function showManageArea() {
			$('#manageAreapopupshow').show();
			$('#manageCategorypopup').hide();
			$('#manageSubCategorypopup').hide();
			$('#data_table').hide(); 
		}
		function showSublogin() {
			$('#manageSubCategorypopup').show();
			$('#manageCategorypopup').hide();
			$('#data_table').hide(); 
			$('#manageAreapopupshow').hide();
		}
		function showAllArea() {
			$('#manageSubCategorypopup').hide();
			$('#manageCategorypopup').hide();
			$('#data_table').show(); 
			$('#manageAreapopupshow').hide();
		}
		function showloginclose() {
			$('#manageCategorypopupclose').hide();
			$('#manageCategorypopup').hide();
			$('#data_table').show(); 
		}
		function showSubloginclose() {
			$('#manageSubCategorypopupclose').hide();
			$('#manageSubCategorypopup').hide();
			$('#data_table').show(); 
		}
		
</script>
<spring:url value="/operatingprocedure/savemaincatogery" var="saveBusinessDetails" />
<spring:url value="/operatingprocedure/deletemaincatogery" var="deleteBusinessDetails" />
<spring:url value="/operatingprocedure/Editmaincatogery" var="editBusinessDetails" />
<spring:url value="/operatingprocedure/updatemaincatogery" var="editandsaveBusinessDetails" />
<spring:url value="/operatingprocedure/saveSubCatBusinessDetails" var="saveSubCatBusinessDetails" />
<spring:url value="/operatingprocedure/deleteSubBusinessDetails" var="deleteSubBusinessDetails" />


<spring:url value="/operatingprocedure/areaname" var="saveAreaNameDetails" />
<spring:url value="/operatingprocedure/updateareaname" var="editandsaveAreaName" />
<spring:url value="/operatingprocedure/deletareaname" var="deleteArea" />


<script>
function saveDetails() {
	var maincategoname =document.getElementById("maincategoname").value;
    
	//alert(maincategoname);

    $('#loader').show();
	 $.ajax({
		url:'${saveBusinessDetails}',
		type:'POST',
		data:{
			maincategoname : maincategoname
		},
		
		success:function(data){
			 
		},
		error: function(xhr, status, error) {
			alert(xhr);
			alert(status);
			alert(error);
		}
	});
	
	var ok = true;
	$('#saveinfo').show();
	 $('#loader').delay(3000).hide(400);
	 	$('#saveinfo').delay(3000).hide(400);
	return ok;
}
/*  Now Want To Delete Any Catogery */

function showDeleteFun() {
	
	$('*[id^=close_]').click(function(){
		var id=$(this).attr('data-id');
		
		 $('#loader').show();
		 $.ajax({
			url:'${deleteBusinessDetails}',
			type:'POST',
			data:{
				id : id
			},
			
			success:function(data){
				 
			},
			error: function(xhr, status, error) {
				alert(xhr);
				alert(status);
				alert(error);
			}
		});
		 $('#deleteinfo').show();
		 $('#deleteinfo').show();
		 
		 $('*[id^=divclose_]').click(function(){
				var id1=$(this).attr('data-id');
				$('#divclose_'+id1).hide();
		 });
		 
		 $('#loader').delay(3000).hide(400);
		 $('#deleteinfo').delay(3000).hide(400);
	});
}
 /* To Edit Catogery Name */
function showEditFun() {
	 
	$('*[id^=edit_]').click(function(){
		var id=$(this).attr('data-id');
		$('*[id^=editcatename_'+id).show();
		$('*[id^=edit_'+id).hide();
		$('*[id^=editandsave_'+id).show();
	});
	
}

function showEditFunSave() {
	$('*[id^=editandsave_]').click(function(){
		var id=$(this).attr('data-id');
		
		var value =document.getElementById("editcatename_"+id).value;
		
		//alert(value);
		$('#loader').show();
		 $.ajax({
			url:'${editandsaveBusinessDetails}',
			type:'POST',
			data:{
				value : value,
				id : id
			},
			
			success:function(data){
				 
			},
			error: function(xhr, status, error) {
				alert(xhr);
				alert(status);
				alert(error);
			}
		});
		 $('#saveinfo').show();
		 $('#loader').delay(3000).hide(400);
		 $('#saveinfo').delay(3000).hide(400);
	});
}
/* The Below Code Is To Save The Area */
//Below Function is for Manage Area Starts Sfrom here
function saveAeraDetails() {
	var areaname =document.getElementById("areaname").value;
    
	//alert(maincategoname);

    $('#loader2').show();
	 $.ajax({
		url:'${saveAreaNameDetails}',
		type:'POST',
		data:{
			areaname : areaname
		},
		
		success:function(data){
			 
		},
		error: function(xhr, status, error) {
			alert(xhr);
			alert(status);
			alert(error);
		}
	});
	
	var ok = true;
	$('#saveinfo2').show();
	 $('#loader2').delay(3000).hide(400);
	 	$('#saveinfo2').delay(3000).hide(400);
	return ok;
}
//Manage Area Code Ends Here

/* To Edit The Area Name */
function showEditFunArea() {
	 
	$('*[id^=editArea_]').click(function(){
		var id=$(this).attr('data-id');
		$('*[id^=editAreaName_'+id).show();
		$('*[id^=editArea_'+id).hide();
		$('*[id^=editandsaveArea_'+id).show();
	});
	
}
function showEditFunSaveArea() {
	$('*[id^=editandsaveArea_]').click(function(){
		var id=$(this).attr('data-id');
		
		var value =document.getElementById("editAreaName_"+id).value;
		
		//alert(value);
		$('#loader2').show();
		 $.ajax({
			url:'${editandsaveAreaName}',
			type:'POST',
			data:{
				value : value,
				id : id
			},
			
			success:function(data){
				 
			},
			error: function(xhr, status, error) {
				alert(xhr);
				alert(status);
				alert(error);
			}
		});
		 $('#saveinfo2').show();
		 $('#loader2').delay(3000).hide(400);
		 $('#saveinfo2').delay(3000).hide(400);
	});
}
// Edit Area Code Ends Here

/* Below Code Is To Delete The Area */
function showDeleteFunArea() {
	
	$('*[id^=closeArea_]').click(function(){
		var id=$(this).attr('data-id');
		
		 $('#loader2').show();
		 $.ajax({
			url:'${deleteArea}',
			type:'POST',
			data:{
				id : id
			},
			
			success:function(data){
				 
			},
			error: function(xhr, status, error) {
				alert(xhr);
				alert(status);
				alert(error);
			}
		});
		 $('#deleteinfo2').show();
		 $('#deleteinfo2').show();
		 
		 $('*[id^=divcloseArea_]').click(function(){
				var id1=$(this).attr('data-id');
				$('#divcloseArea_'+id1).hide();
		 });
		 
		 $('#loader2').delay(3000).hide(400);
		 $('#deleteinfo2').delay(3000).hide(400);
	});
}
/* To Delete Area Code Ends Here */

/* Save Sub Catogery Name */
 
 function saveSubDetails() {
	var maincategoryname =document.getElementById("maincategoryname").value;
	var entersubcatname =document.getElementById("entersubcatname").value;
    
	//alert(maincategoryname);
	//alert(entersubcatname);

	$('#loader1').show();
	 $.ajax({
		url:'${saveSubCatBusinessDetails}',
		type:'POST',
		data:{
			maincategoryname : maincategoryname,
			entersubcatname : entersubcatname
		},
		
		success:function(data){
			 
		},
		error: function(xhr, status, error) {
			alert(xhr);
			alert(status);
			alert(error);
		}
	});
	
	var ok = true;
	$('#savesubinfo1').show();
	$('#loader1').delay(3000).hide(400);
	$('#saveinfo').delay(3000).hide(400);
	return ok;
}
/* Now Want To Delete Sub Category */
function showDeleteSubCatFun() {
	
	$('*[id^=divsubclose_]').click(function(){
		var id=$(this).attr('data-id');
		
		 $('#loader1').show();
		 $.ajax({
			url:'${deleteSubBusinessDetails}',
			type:'POST',
			data:{
				id : id
			},
			
			success:function(data){
				 
			},
			error: function(xhr, status, error) {
				alert(xhr);
				alert(status);
				alert(error);
			}
		});
		 $('#deleteinfo1').show();
		 
		 
		 $('*[id^=divsubclose_]').click(function(){
				var idr=$(this).attr('data-id');
				$('#divsubclose_'+idr).hide();
		 });
		 $('#divsubclose_'+id).hide();
		 $('#loader1').delay(3000).hide(400);
		 $('#deleteinfo1').delay(3000).hide(400);
	});
}
/* Edit Sub Category Name */
 
 function showSubEditFun() {
	 
	$('*[id^=edit_]').click(function(){
		var id=$(this).attr('data-id');
		$('*[id^=editsubcatename1_'+id).show();
		$('*[id^=edit_'+id).hide();
		$('*[id^=editandsave_'+id).show();
	});
	
}
 function showEditSubFunSave(){
	 //alert("Hi.........");
		$('*[id^=editsubcatename1_]').click(function(){
			var id=$(this).attr('data-id');
			
			var value =document.getElementById("editsubcatename1_"+id).value;
			
			//alert(value);
			$('#loader').show();
			 $.ajax({
				url:'${editandsaveBusinessDetails}',
				type:'POST',
				data:{
					value : value,
					id : id
				},
				
				success:function(data){
					 
				},
				error: function(xhr, status, error) {
					alert(xhr);
					alert(status);
					alert(error);
				}
			});
			 $('#saveinfo').show();
			 $('#loader').delay(3000).hide(400);
			 $('#saveinfo').delay(3000).hide(400);
		});
	}
 </script>
</body>
</html>
 