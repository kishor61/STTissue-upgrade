<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true,
		    onClose:function(){
		    	var sdate=$('input[name=sdate]').val();
				var edate=$('input[name=edate]').val();
				var customer=$('select[name=customer]').val();
				if(customer!=''){
					location.href='${gradeURL}?sdate='+sdate+'&edate='+edate+'&customer='+encodeURIComponent(customer);
				}
		    }
		});
	});
	function showPrintBtn(){
		$('#printBtn').show();
	}
</script>
</head>
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Quality Graph(Reel/Rewinder Graph)</span>
				</div>
				<br>	
				<div class="table-selector">
					
					<table>
						<tr>
							<td>From</td>
							<td>
								<input type="text" name="sdate" value="${sdate}" readonly="readonly" style="width: 80px;">
							</td>
							<td>To</td>
							<td>
								<input type="text" name="edate" value="${edate}" readonly="readonly" style="width: 80px;">
							</td>
							<td>Customer</td>
							<td>
								<select name="customer" style="width: 130px;padding: 2px;">
									<option value="">Select</option>
									<c:forEach items="${customers}" var="cust">
										
										<c:choose>
											<c:when test="${cust eq customer }">
												<option value="${cust}" selected="selected">${cust}</option>
											</c:when>
											<c:otherwise>
												<option value="${cust}">${cust}</option>	
											</c:otherwise>
										</c:choose>
										
									</c:forEach>
								</select>
							</td>
							<td>Grade</td>
							<td>
								<select name="gradeCode" style="width: 130px;padding: 2px;">
									<option value="">Select</option>
									<c:forEach items="${grades}" var="grade">
										<option value="${grade}">${grade}</option>
									</c:forEach>
								</select>
							</td>
							
							<td>
								<button id="viewBtn">VIEW</button>
								<button id="printBtn" style="display: none;">PRINT</button>
							</td>
						</tr>
					</table>

				</div>
				<br>

<div style="padding: 0px; overflow: hidden; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
	<iframe id="graphFrame" src="about:blank" style="width: 100%;height: 100%;border: none;"></iframe>

<!-- <!-- <img alt="" src=""> --> -->
</div>

<spring:url value="/qualitygraph/graph" var="graphURL"/>
<spring:url value="/qualitygraph/main/grade" var="gradeURL"/>

<script type="text/javascript">
$(function(){
	
	$('#printBtn').click(function(){
		document.getElementById("graphFrame").contentWindow.createPDF();
		//document.getElementById("graphFrame").contentWindow.print();
	});
	
	$('select[name=customer]').change(function(){
		var sdate=$('input[name=sdate]').val();
		var edate=$('input[name=edate]').val();
		
		if($(this).val()!=''){
			location.href='${gradeURL}?sdate='+sdate+'&edate='+edate+'&customer='+encodeURIComponent($(this).val());
		}
	});
	
	$('#viewBtn').click(function(){
		var sdate=$('input[name=sdate]').val();
		var edate=$('input[name=edate]').val();
		var gradeCode=$('select[name=gradeCode]').val();
		var customer=$('select[name=customer]').val();
		
		if($.trim(gradeCode)==''){
			alert('Select grade code!');
			return;
		}
		if($.trim(customer)==''){
			alert('Select Customer!');
			return;
		}
		
		$('#graphFrame').attr('src','${graphURL}?sdate='+sdate+'&edate='+edate+'&gradeCode='+gradeCode+'&customer='+encodeURIComponent(customer));
		
		
		
	});
});

</script>
				
			</div>

		</div>


	</div>

</body>
</html>
