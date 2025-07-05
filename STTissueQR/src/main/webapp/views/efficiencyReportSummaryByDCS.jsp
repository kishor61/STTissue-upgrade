<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/efficiencyreport/byDcs/save"  var="saveURL"/>
<spring:url value="/efficiencyreport/byDcs/edit" var="editDataURL" />
<spring:url value="/efficiencyreport/byDcs/editton" var="editURL" />
<script type="text/javascript">
	$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});
	});
</script>
<script type="text/javascript">
$(function(){
		$('#editbutton').click(function(){			
			var id=$('#barcodedatatable tbody input[name=id]:checked').val();
			if(id=='' || typeof id ==='undefined'){
				alert("Select The Row.");
				return false;
			}
			if(id!='0'){
				location.href='${editDataURL}/'+encodeURIComponent(id);
			}
			else if(typeof gradeDate ==='undefined'){
				alert('Select grade code.');
				return false;
			}	
		});
});
</script>
<style type="text/css">
.button{
 text-decoration:none; 
 text-align:center; 
 padding:11px 32px; 
 border:solid 1px #004F72; 
 -webkit-border-radius:4px;
 -moz-border-radius:4px; 
 border-radius: 4px; 
 font:18px Arial, Helvetica, sans-serif; 
 font-weight:bold; 
 color:#E5FFFF; 
 background-color:#3BA4C7; 
 background-image: -moz-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -webkit-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -o-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -ms-linear-gradient(top, #3BA4C7 0% ,#1982A5 100%); 
 filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1982A5', endColorstr='#1982A5',GradientType=0 ); 
 background-image: linear-gradient(top, #3BA4C7 0% ,#1982A5 100%);   
 -webkit-box-shadow:0px 0px 2px #bababa, inset 0px 0px 1px #ffffff; 
 -moz-box-shadow: 0px 0px 2px #bababa,  inset 0px 0px 1px #ffffff;  
 box-shadow:0px 0px 2px #bababa, inset 0px 0px 1px #ffffff;  
  
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
					><h5 style="text-align:center; font-weight:bold;color:#343e70;">ST Tissue Internal Specification For PM5</h5></div>

		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				
				<div class="table-selector">
					<form action="${saveURL}" method="POST">
					<table>
						<tr>
							<td>From Date:<input type="text" name="sdate"	value="${sdate}" style="width: 80px;" readonly="readonly"></td>
							<td>Shift:
							<select name="shift" style="width: 80px; padding: 2px;" tabindex="2" required="required">
									<option value="">Select</option>
									<option value="DAY">Day</option>
									<option value="NIGHT">Night</option>
							</select>
							</td>
							<td>Tons:<input type="text" value="${searchtons}" name="tons" style="width: 50px;" required="required"></td>
							<td><input type="submit" value="Submit"></td>
						</tr>
					</table>
					</form>
				</div>
				<center><div><b style="color: Green;">${message}</b></div></center>
<c:if test="${checkTonResult}">
<center>
<br><br>
<table  id="barcodedatatable"  border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:20%" cellpadding="3" cellspacing="3">
	<thead style="text-align: center;">
		<tr>
			<td><center><b>&nbsp;</b></center></td>
			<td><center><b>Date:</b></center></td>
			<td><center><b>Shift:</b></center></td>
			<td><center><b>Ton:</b></center></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${checkTon}" var="CKT">
			<tr>
				<td><center><input type="radio" value="${CKT.id}" name="id"/></center></td>
				<td><center><fmt:formatDate value="${CKT.date}" pattern="MM/dd/yyyy"/></center></td>
				<td><center>${CKT.shift}</center></td>
				<td><center>${CKT.actualWt}</center></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br><br>
<table>
	<tr>
		<td><button id="editbutton" class="button" >Edit</button></td>	
	</tr>
</table>
</center>
</c:if>
<c:if test="${view}">
<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">
<center>
<table class="table" style="text-align: center;width: 50%;">
			<tr style="background: #CD7B32;">
				<td><b>Date</b></td>
				<td><b>Roll ID</b></td>
				<td><b>Reel Number</b></td>
				<td><b>Shift</b></td>
				<td><b>Team</b></td>
				<td><b>Grade Code</b></td>
				<td><b>Good Weight</b></td>
				<td><b>Last Roll</b></td>
			</tr>
			<c:forEach items="${datas}" var="data">
			<tr>
					<td><b><fmt:formatDate value="${data.date}" pattern="MM/dd/yyyy"/></b></td>
					<td>${data.rollid}</td>
					<td>${data.reelnumber}</td>
					<td>${data.shift}</td>
					<td>${data.crew}</td>
					<td>${data.gradecode}</td>
					<td>${data.actualWt}</td>
					<td>${data.lastroll}</td>
			</tr>
			</c:forEach>
</table>
</center>
</div>
</c:if>
<c:if test="${edit}">
<br><br>
<center>
<form action="${editURL}" method="POST">
<table  border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:20%" cellpadding="3" cellspacing="3">
		<c:forEach items="${reportDataEdit}" var="EditCKT">
		<input type="hidden" value="${editForEdit}" name="id"/>
		<tr>
			<td><center><b>Date:</b></center></td>
			<fmt:formatDate value="${EditCKT.date}" pattern="MM-dd-yyyy" var="dateS"/>
			<td><center><input type="text" value="${dateS}" name="sdate" readonly="readonly"></center></td>
		</tr>
		<tr>
			<td><center><b>Shift:</b></center></td>
			<td><center><input type="text" value="${EditCKT.shift}" name="shift" readonly="readonly"/></center></td>
		</tr>
		<tr>
			<td><center><b>Ton:</b></center></td>
			<td><center><input type="text" value="${EditCKT.actualWt}" name="tons"/></center></td>
		</tr>
		</c:forEach>
</table>
<br><br>
<table>
	<tr>
		<td><input class="button" type="Submit" value="Submit" name="Submit"/></td>	
	</tr>
</table>
</form>
</center>
</c:if>

			</div>

		</div>


	</div>

</body>
</html>
