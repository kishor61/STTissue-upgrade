<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
.table-selector td{
	vertical-align: top;
}
/* General form styling for inputs and textareas */
.form-input, .form-textarea {
    font-size: 14px;
    padding: 10px 12px;
    border: 2px solid #ccc;
    border-radius: 6px;
    background-color: #f9f9f9;
    width: 100%;
    box-sizing: border-box;
    transition: all 0.3s ease;
}

/* Focus styling for inputs and textareas */
.form-input:focus, .form-textarea:focus {
    border-color: #4CAF50;
    background-color: #e6f7ff; /* Light blue background */
    outline: none;
    box-shadow: 0 0 8px rgba(72, 144, 226, 0.3); /* Light blue glow */
}

/* Styling for the textarea to make it visually appealing */
.form-textarea {
    resize: vertical; /* Allow resizing of textarea vertically */
    height: 100px; /* Set height for a better look */
}

/* Label styling (if applicable) */
td {
    padding: 12px;
}

/* Placeholder styling for inputs and textareas */
.form-input::placeholder, .form-textarea::placeholder {
    color: #aaa;
    font-style: italic;
}

/* Add hover effect */
.form-input:hover, .form-textarea:hover {
    border-color: #45a049;
}

/* Optional: Styling for the "Note" label */
td:nth-child(2) {
    font-weight: bold;
    color: #333;
    font-size: 16px;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>
		
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div
		          class="content-header"
		          style="
		            padding-top: 10px !important;
		            padding-bottom: 0px !important;
		            line-height: 0px !important;
		          "
		><h5 style="text-align:center; font-weight:bold;color:#343e70;">Down Time Primary Code For PM5</h5></div>
		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				
				<div class="table-selector"style="background-color:#c2eadf73 !important; border: 1px solid #7e00ff42;">
				<spring:url value="/pm5effprimarycode/save" var="saveURL" />
				<form:form action="${saveURL}" modelAttribute="primaryCode">
				
				
					<table>
						<tr>
							<td>
								Primary Code
							</td>
							<td>
							    <form:input path="code" cssStyle="height: 18px;" class="form-input"/>
							</td>
							<td>Note</td>
							<td>
							    <form:textarea path="note" cssStyle="height: 20px;" class="form-textarea"/>
							</td>
							<td>
								<form:hidden path="id"/>
								<input type="submit" value="Save"class="btn btn-success btn-sm">
							</td>
							<td>
								<span class="error">${error}</span>
								<span class="message">${message}</span>
							</td>
						</tr>
					</table>
				</form:form>
				</div>


			<br>
		<%--	
			<script type="text/javascript">
				$(function(){
					$('a[id^=delete_]').click(function(){
						if(confirm("You will lost all data mapped with this code. Do you want to delete this code?")){
							return true;
						}else{
							return false;
						}
						
					});
				});
			</script>
		 --%>	
			
			<div style="padding: 2px;">
			
				<table class="table">
					<thead>
						<tr>
							<th style="width: 30px;">&nbsp;</th>
							<th style="width: 300px;">Primary Code </th>
							<th>Note</th>
							<th style="width: 150px;">Secondary Code</th>
							<th style="width: 150px;">&nbsp; </th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${fn:length(codes)==0}">
							<tr><td colspan="5" align="center">Records not available in database.</td></tr>
						</c:if>
					
						<c:if test="${fn:length(codes)!=0}">
							<c:forEach items="${codes}" var="code" varStatus="i">
								<tr>
									<td>${i.index+1}</td>
									<td>${code.code }</td>
									<td>${code.note }</td>
									<td align="center">
									<a href='<spring:url value="/pm5effsecondarycode/view"/>/${code.id}'>View</a> 
									</td>
									<td align="center">
									<%-- <a id="delete_${i.index}" href='<spring:url value="/effprimarycode/delete"/>/${code.id}'>Delete</a> --%> &nbsp;
									<a href='<spring:url value="/pm5effprimarycode/edit"/>/${code.id}'>Edit</a> </td>
								</tr>
							</c:forEach>
						</c:if>						
					</tbody>
				</table>
			
			</div>



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
