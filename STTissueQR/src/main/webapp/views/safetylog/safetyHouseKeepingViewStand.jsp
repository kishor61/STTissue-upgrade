<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">SAFETY AND HOUSEKEEPING - Standard</span>
				</div>
				<div class="table-selector">
					
					<table style="margin: auto;">
						<tr>
							<td>Standard Type</td>	
							<td>
								<select name="type" style="padding: 2px;width: 200px;">
									<option value="">Select</option>
									<c:forEach items="${types}" var="st">
										<c:choose>
											<c:when test="${st.id eq type}">
												<option value="${st.id}" selected="selected">${st.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${st.id}">${st.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
							<td>
								<button id="viewStdBtn">View</button>
								<button id="addStdBtn">Add</button>
								<button id="editStdBtn">Edit</button>
								<button id="deleteStdBtn">Delete</button>
								<button id="printBtn">Print</button>
								&nbsp;
								<a href='<spring:url value="/safetyhousekeepingreport/export/standard/master/pdf"/>' target="_blank">PDF</a>
								&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;
								<button id="manageTypeBtn">Manage Standard Type</button>
							</td>
							<td>
							
							</td>
							
						</tr>
					</table>

				</div>


<c:if test="${showFlag}">
<script type="text/javascript">
	$(function(){
		$('#printBtn').click(function(){
			$('#printDiv').printArea({
				retainAttr:['class','style']
			});
		});
	});

</script>
<br>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<div id="printDiv">


	<table class="table" style="width: 600px; margin: auto;">
		<thead>
			<tr>
				<th style="width: 15px;"></th>
				<th>S.No.</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody id="tableBody">
			<c:forEach items="${housekeepings}" var="safetyHouse" varStatus="i">
				<tr>
					<td><input type="radio" name="id" value="${safetyHouse.id}"></td>
					<td style="text-align: center;">${i.count}</td>
					<td>${safetyHouse.description}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<br>
<br>	
	
</div>	
</c:if>




			</div>

		</div>


	</div>

<div id="dialog" title="Safety Housekeeping" style="display: none; overflow: hidden;">
	<iframe id="dialogPage" style="width: 100%; height: inherit; border: none;"></iframe>
</div>	

<spring:url value="/safetyhousekeeping/add/standard" var="addStandardURL" />
<spring:url value="/safetyhousekeeping/edit/standard" var="editStandardURL" />	
<spring:url value="/safetyhousekeeping/view/standard" var="viewURL" />
<spring:url value="/safetyhousekeeping/delete/standard" var="deleteURL" />
<spring:url value="/safetyhousekeeping/check/standard" var="checkedURL" />

<spring:url value="/safetyhousekeeping/manage/stdtype" var="viewTypeURL" />	
<script type="text/javascript">
	$(function() {

		
		$('#manageTypeBtn').click(function(){
			$("#dialog #dialogPage").attr('src', '${viewTypeURL}');
			$("#dialog").dialog({
				width : 800,
				height : 550,
				modal : true,
				position : {
					my : "center",
					at : "center",
					of : window.top
				},
				close : function() {
					$("#dialog #dialogPage").attr('src', "about:blank");
					location.reload(true);
				}

			});
		});
		
		$('#viewStdBtn').click(function(){
			if($('select[name=type]').val()==''){
					alert('Select Type!');
			}else{
			 location.href='${viewURL}/'+$('select[name=type]').val();
			}
		});
		
		$('#addStdBtn').click(function() {
			$("#dialog #dialogPage").attr('src', '${addStandardURL}');
			$("#dialog").dialog({
				width : 600,
				height : 400,
				modal : true,
				position : {
					my : "center",
					at : "center",
					of : window.top
				},
				close : function() {
					$("#dialog #dialogPage").attr('src', "about:blank");
					location.reload(true);
				}

			});
		});

		$('#deleteStdBtn').click(function(){
			var id=$('input[name=id]:checked').val();
			
			if(id){
				$.ajax({
					url:'${deleteURL}',
					type:'GET',
					data:{id:id},
					success:function(data){
						if(data.flag){
							alert('Data removed from database.');
						}else{
							alert(data.error);
						}
						location.reload(true);
					}
				});
			}else{
				alert('Select row!');
			}
		});
		
		$('#editStdBtn').click(function(){
			var id=$('input[name=id]:checked').val();
			if(id){
				$("#dialog #dialogPage").attr('src', '${editStandardURL}/'+id);
				$("#dialog").dialog({
					width : 600,
					height : 400,
					modal : true,
					position : {
						my : "center",
						at : "center",
						of : window.top
					},
					close : function() {
						$("#dialog #dialogPage").attr('src', "about:blank");
						location.reload(true);
					}

				});
			}else{
				alert('Select row!');
			}
		});
	});
</script>	
</body>
</html>
