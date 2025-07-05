<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Process Improvement Meeting Notes</span>
				</div>



				<div class="frameContainer">
					<div class="frameBox" style="width: 49%;border-right: 1px solid #B3A186;">
						<c:choose>
							<c:when test="${(not empty categoryId) && (not empty sdate) && (not empty edate)}">
								<iframe id="summaryFrame" src='<spring:url value="/oimnotes/summary/view/${categoryId}/${sdate}/${edate}"/>'></iframe>
							</c:when>
							<c:when test="${(not empty sdate) && (not empty edate)}">
								<iframe id="summaryFrame" src='<spring:url value="/oimnotes/summary/${sdate}/${edate}"/>'></iframe>
							</c:when>
							<c:otherwise>
								<iframe id="summaryFrame" src='<spring:url value="/oimnotes/summary"/>'></iframe>							
							</c:otherwise>
						</c:choose>
						
						
					</div>
					<div class="frameBox" style="width: 49%;">
						<iframe id="followUpFrame" src='<spring:url value="/oimnotes/followup"/>'></iframe>				
					</div>
				</div>



			</div>

		</div>


	</div>

<div id="dialog" title="PROCESS IMPROVEMENT MEETING NOTES" style="display: none;">
	<iframe id="dialogPage" style="width: 98%; height: inherit;border: none;"></iframe>
</div>
<spring:url value="/oimnotes/summary/add" var="summaryAddURL"/>
<spring:url value="/oimnotes/summary/edit" var="summaryEditURL"/>

<spring:url value="/oimnotes/followup/add" var="followAddURL"/>
<spring:url value="/oimnotes/followup/edit" var="followEditURL"/>

<script type="text/javascript">
	function createSummary(){
		$("#dialog #dialogPage").attr('src', '${summaryAddURL}');
		$("#dialog").dialog({
	        width: 600,
	        height: 400,
	        modal: true,
	        position: {my: "center", at: "center", of: window.top},
	        close: function () {
	        	$("#dialog #dialogPage").attr('src', "about:blank");
	        	
	        	document.getElementById('summaryFrame').contentWindow.location.reload(true);
	        }
	    
	    });
	}
	function editSummary(id){
		var editUrl='${summaryEditURL}/'+id;
		$("#dialog #dialogPage").attr('src',editUrl);
		$("#dialog").dialog({
	        width: 600,
	        height: 400,
	        modal: true,
	        position: {my: "center", at: "center", of: window.top},
	        close: function () {
	        	$("#dialog #dialogPage").attr('src', "about:blank");
	        }
	    
	    });
	}
	function viewFollowUp(url){
		$('#followUpFrame').attr('src',url);
	}
	
	function addFollowUp(id){
		
		var url='${followAddURL}/'+id;
		$("#dialog #dialogPage").attr('src',url);
		$("#dialog").dialog({
	        width: 600,
	        height: 450,
	        modal: true,
	        position: {my: "center", at: "center", of: window.top},
	        close: function () {
	        	$("#dialog #dialogPage").attr('src', "about:blank");
	        	$('#followUpFrame').attr('src',$('#followUpFrame').attr('src'));
	        }
	    
	    });
	}
	function editFollowUp(id){
		var editUrl='${followEditURL}/'+id;
		//alert(editUrl);
		$("#dialog #dialogPage").attr('src',editUrl);
		$("#dialog").dialog({
	        width: 600,
	        height: 450,
	        modal: true,
	        position: {my: "center", at: "center", of: window.top},
	        close: function () {
	        	$("#dialog #dialogPage").attr('src', "about:blank");
	        	$('#followUpFrame').attr('src',$('#followUpFrame').attr('src'));
	        }
	    
	    });
	}
</script>
</body>
</html>
