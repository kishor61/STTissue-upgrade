<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
.frameContainer {
	position: fixed;
	/* border: 1px solid; */
	left: 0;
	right: 0;
	top: 95px;
	bottom: 0;
	text-align: center;
}

.frameBox {
	height: 100%;
	display: inline-block;
	vertical-align: top;
}
iframe {
	width: 100%;
	height: 100%;
	border: none;
}
</style>
<script type="text/javascript">
	$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
	});
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Safety and Housekeeping</span>
				</div>
				<br>
				<div class="frameContainer">
					<div class="frameBox" style="width: 49%; border-right: 1px solid #B3A186;">
					<c:if test="${not empty housekeepingTask}">
						<fmt:formatDate value="${housekeepingTask.date}" var="date" pattern="MM-dd-yyyy"/>
						<iframe id="stdFrame" src='<spring:url value="/safetyhousekeeping/view/task/${housekeepingTask.auditor}/${housekeepingTask.area}/${date}"/>'></iframe>
					</c:if>
					<c:if test="${empty housekeepingTask}">
						<iframe id="stdFrame" src='<spring:url value="/safetyhousekeeping/view/task"/>'></iframe>
					</c:if>
					</div>
					<div class="frameBox" style="width: 49%;">
						<iframe id="actionFrame" src='about:blank'></iframe>				
					</div>
				</div>

		</div>

	</div>

</div>
	
	
<div id="dialog" title="Safety Housekeeping" style="display: none; overflow: hidden;">
	<iframe id="dialogPage" style="width: 100%; height: inherit; border: none;"></iframe>
</div>
	
<spring:url value="/safetyhousekeeping/add/action" var="addActionURL" />
<spring:url value="/safetyhousekeeping/add/task" var="addTaskURL" />
<spring:url value="/safetyhousekeeping/edit/task" var="editTaskURL" />
	
	
<spring:url value="/safetyhousekeeping/view/action" var="viewActionURL"/>
<spring:url value="/safetyhousekeeping/edit/action" var="editActionURL"/>

	
<script type="text/javascript">
	
	function viewAction(sid,taskId){
		$('#actionFrame').attr('src','${viewActionURL}/'+sid+'/'+taskId);
	}
	
	function resetAction(){
		$('#actionFrame').attr('src','about:blank');
	}

	
	function addAction(sid,taskId){
		
		$("#dialog #dialogPage").attr('src', '${addActionURL}/'+sid+'/'+taskId);
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
				document.getElementById('actionFrame').contentDocument.location.reload(true);
			//	location.reload(true);
			}

		});
	}

	function addTask(){
		$("#dialog #dialogPage").attr('src', '${addTaskURL}');
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
				document.getElementById('stdFrame').contentDocument.location.reload(true);
			}

		});
	}
	
	function editTask(id){
		$("#dialog #dialogPage").attr('src', '${editTaskURL}/'+id);
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
				document.getElementById('stdFrame').contentDocument.location.reload(true);
			}

		});
	}
	
	function editAction(id){
		$("#dialog #dialogPage").attr('src', '${editActionURL}/'+id);
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
				document.getElementById('actionFrame').contentDocument.location.reload(true);
			}

		});
	}

</script>
</body>
</html>
