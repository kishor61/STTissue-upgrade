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
								<td>Area</td>
								<td><input type="text" name="area" maxlength="50" value="${type}" style="width: 150px;"></td>
								<td>Category</td>
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
								
								<td>
									|&nbsp;&nbsp;&nbsp;
									<button type="button" id="manageArea">Manage Area</button>
									
									|&nbsp;&nbsp;&nbsp;
									<button type="button" id="manageCategory">Manage Category</button>
									&nbsp;&nbsp;
									<button type="button" id="manageSubCategory">Manage Sub Category</button>
								</td>
								
								
							</tr>
						</table>
					
					</form>

				</div>
		
</security:authorize>				
<br>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 131px;">
<spring:url value="/operatingprocedure/search" var="searchURL"/>
<form action="${searchURL}" method="get">
<table>
	<tr>
		<td>File Name</td>
		<td><input type="text" name="file" value="${file}" style="width: 200px;"></td>
		<td>Area</td>
		<td>
				<select name="area" style="width: 150px; padding: 3px;"
					required="required">
						<option value="-1">Select</option>
						<c:forEach items="${areasType}" var="are">
							<c:choose>
								<c:when test="${are eq areas}">
									<option value="${are}" selected="selected">${are}</option>
								</c:when>
								<c:otherwise>
									<option value="${are}">${are}</option>
								</c:otherwise>
							</c:choose>
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
</form>

<table class="table" style="width:900px;margin: inherit;;">
	<c:forEach items="${uniqueTypes}" var="typeOb">
		<tr style="background: #F5E09C;">
			<td colspan="4" ><b>${typeOb.name}</b></td>
		</tr>
		<c:forEach items="${typeOb.subType}" var="subTypeOb">
			<tr style="background: #E6E6E6;">
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
		
		<%--  --%>
		
		
	</c:forEach>

</table>
</div>

			</div>

		</div>
	</div>
	
<spring:url value="/operatingprocedure/delete" var="deleteURL"/>
<spring:url value="/operatingprocedure/managecategory" var="managecategoryURL"/>
<spring:url value="/operatingprocedure/managecsubategory" var="managesubcategoryURL"/>
<spring:url value="/operatingprocedure/category/types" var="cattypeURL"/>

<spring:url value="/operatingprocedure/edit" var="editURL"/>

<spring:url value="/operatingprocedure/managearea" var="manageAreaURL"/>

	
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
			 $("input[name=area]").autocomplete({
			      source: data.allarea
			 });
		}
	});
	
	$('#manageArea').click(function(){
		$("#dialog2 #dialogPage").attr('src', '${manageAreaURL}');
		$("#dialog2").dialog({
			title : 'Manage Area',
			width : 600,
			height : 500,
			modal : true,
			close : function() {
				$("#dialog2 #dialogPage").attr('src', "about:blank");
				location.reload(true);
			}

		});
	});
	
	
	$('#manageCategory').click(function(){
		$("#dialog2 #dialogPage").attr('src', '${managecategoryURL}');
		$("#dialog2").dialog({
			title : 'Manage Category',
			width : 600,
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

<div id="dialog" style="display: none;overflow: hidden;">
	<iframe id="dialogPage" style="width: 100%; height: inherit;border: none;"></iframe>
</div>
<div id="dialog2" style="display: none;overflow: hidden;">
	<iframe id="dialogPage" style="width: 100%; height: inherit;border: none;"></iframe>
</div>



</body>
</html>
