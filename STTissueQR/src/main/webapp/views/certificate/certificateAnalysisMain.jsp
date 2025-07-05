<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat : 'mm-dd-yy',
		changeMonth : true,
		changeYear : true
	});

	$('#loadBtn').button({
		icons : {
			primary : "ui-icon-search"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-document"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-document"
		}
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
					<span class="label">Certificate Of Analysis</span>
				</div>
				<br>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>From:</td>
							<td><input type="text" name="sdate" value="${sdate}" style="width: 80px;"></td>
							<td>To:</td>
							<td> <input type="text" name="edate" value="${edate}" style="width: 80px;"></td>

							<%-- <td>Customer:</td>
							<td>
								<select name="customer" style="padding: 2px;">
									<option value="">Select</option>
									<c:forEach items="${rewdinder.customers}" var="cust">
										<option value="${cust['Customer']}">${cust['Customer']}</option>
									</c:forEach>
								</select>							
							</td> --%>
							
							<td>Customer<td>
										<td>
											<select style="width: 202px; padding: 2px;" name="customer">
												<option value="">All</option>
												<c:forEach items="${customers}" var="customer">
													<option value="${customer}">${customer}</option>
												</c:forEach>
											</select>
										<td>
							<%-- <td>
								Grade
							</td>
							<td>
								<select name="grade" style="padding: 2px;">
									<option value="">Select</option>
									<c:forEach items="${rewdinder.grades}" var="grade">
										<option value="${grade}">${grade}</option>
									</c:forEach>
								</select>
							</td> --%>
							<td>
								<button id="loadBtn">LOAD</button>
								<a href="javascript:void(0);" id="excelLink" target="_blank">EXCEL</a>
								<a href="javascript:void(0);" id="pdfLink" target="_blank">PDF</a>
							</td>
							
						</tr>
					</table>

				</div>
<br>
<spring:url value="/certificateanalysis/load" var="loadURL"/>

<spring:url value="/certificateanalysis/excel/certificate" var="excelURL" />
<spring:url value="/certificateanalysis/pdf/certificate/multi" var="pdfURL" />

<script type="text/javascript">
	$(function(){
		
		
		$('select[name=customer]').change(function(){
			$('#viewFrame').attr('src','about:blank');
			$('#excelLink').attr('href','javascript:void(0)');
		});
		
		$('#loadBtn').click(function(){
			var customer=$('select[name=customer]').val();
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			
		/* 	var grade=$('select[name=grade]').val();
			
		 */	if(!customer){
				alert('Select customer.')
			}/* else if(!grade){
				alert('Select Grade.')
			} */else{
				
				$('#viewFrame').attr('src','${loadURL}?sdate='+encodeURIComponent(sdate)+
						'&edate='+encodeURIComponent(edate)+
						'&customer='+encodeURIComponent(customer));
			}
			
		});
		
		$('#excelLink').click(function(){
			var reels=$('#viewFrame')[0].contentWindow.getSelectedReel();
			var customer=$('select[name=customer]').val();
			
			
			if(!customer){
				alert('Select customer.');
				return false;
			}else if(!reels | reels.length==0){
				alert('Select reels.');
				return false;
			}else{
				var url='${excelURL}?reels='+encodeURIComponent(reels.toString())+'&customer='+encodeURIComponent(customer);
				$(this).attr('href',url);
			}
			
			return true;
		});
		
		$('#pdfLink').click(function(){
			var reels=$('#viewFrame')[0].contentWindow.getSelectedReel();
			var customer=$('select[name=customer]').val();
			
			
			if(!customer){
				alert('Select customer.');
				return false;
			}else if(!reels | reels.length==0){
				alert('Select reels.');
				return false;
			}else{
				var url='${pdfURL}?reels='+encodeURIComponent(reels.toString())+'&customer='+encodeURIComponent(customer);
				$(this).attr('href',url);
			}
			
			return true;
		});
	});
</script>
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

	<iframe id="viewFrame" style="width: 100%; height: 98%; border: none;" src="about:blank"></iframe>

</div>
			</div>

		</div>


	</div>

</body>
</html>
