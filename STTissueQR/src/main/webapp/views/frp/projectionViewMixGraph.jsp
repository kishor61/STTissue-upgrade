<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

<spring:url value="/frpprojectionmix/view" var="viewURL"/>
<spring:url value="/frpprojectionmix/viewgraph" var="viewGraphURL"/>
<script type="text/javascript">
	$(function(){
		
		var url="about:blank";
		
		$('select[name=type]').change(function(){
			if($(this).val()==''){
				alert('Select production type.');
			}else{
				location.href='${viewURL}/'+$(this).val();
			}
		});
		
		$('#loadBtn').click(function(){
			var grade=$('select[name=type]').val();
			var type=$('select[name=type2]').val();
			if(grade==''){
				alert('Select production type.');
				return;
			}
			
			if(type==''){
				alert('Select Napkin or Towel.');
				return;
			}
			
			//$('#loadPage').show();
			url='${viewGraphURL}/'+grade+'/'+type;
			//alert(url);
			$('#graphiframe').attr('src',url);
			
		});
		
		
		$('#refreshBtn').click(function(){
			var iframe = document.getElementById('graphiframe');
			iframe.src = iframe.src;
			/* $('#graphiframe').attr('src',url); */
		});
		
		$('#newWinBtn').click(function(){
			window.open($('#graphiframe').get(0).contentWindow.location);
		});
	});

</script>

</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>
	

		<div class="block3">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">FRP  Mix Graph</span>
				</div>
				<br>
				<div class="table-selector">
				
					<table style="margin: auto;">
						<tr>
							 <td>
							 	Production Type
							 </td>
							 <td>
							 	<select name="type" tabindex="1" style="width: 120px; padding: 2px;">
									<option value="" >Select</option>
									<c:forEach items="${frpgrade}" var="grade">
										<c:choose>
											<c:when test="${grade.key eq type}">
												<option value="${grade.key}" selected="selected">${grade.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${grade.key}" >${grade.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							 </td>
							 <td>
							 	Napkin/Towel
							 </td>
							 <td>
							 	<select name="type2" tabindex="1" style="width: 120px; padding: 2px;">
									<option value="">Select</option>
									<c:forEach items="${frpProjection}" var="projection">
										<c:choose>
											<c:when test="${projection.type2 eq type2}">
												<option value="${projection.id}" selected="selected">${frpgradeType[projection.type2]} - ${projection.input}</option>
											</c:when>
											<c:otherwise>
												<option value="${projection.id}" >${frpgradeType[projection.type2]} - ${projection.input}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							 </td>
							 <td>
							 	<button id="loadBtn">Load</button>
							 	<button id="refreshBtn">Refresh</button>
							 	<button id="newWinBtn">View In New Window</button>
							 </td>
							 
						</tr>
					</table>
					
			</div>
			
			<br>
			<div style="position: fixed;left: 0;right: 0;bottom: 0;top: 154px;">
				<iframe id="graphiframe" src="about:blank" style="width: 100%;height:  100%; border: none;"/>
			</div>
		</div>


	</div>
</div>


</body>
</html>
