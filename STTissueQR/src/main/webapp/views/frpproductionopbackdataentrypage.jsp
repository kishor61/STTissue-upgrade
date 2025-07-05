<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/frpproductionopdataentry/backdatedentry/show" var="showURL" />
<spring:url value="/frpproductionopdataentry/save" var="saveURL" />
<script type="text/javascript">
	$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});
	});
</script>
<style type="text/css">
.button{
 text-decoration:none; 
 text-align:center; 
padding: 5px 17px;
 border:solid 1px #004F72; 
 -webkit-border-radius:4px;
 -moz-border-radius:4px; 
 border-radius: 4px; 
 font: 20px Arial, Helvetica, sans-serif;
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
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">FRP Production Operator Data Back Dated Entry</span>
				</div>
				<div class="table-selector">

					<center>
					<form action="${showURL}" method="post">	
					<table>
						<tr>
							<td>Date:<input type="text" name="sdate"	value="${sdate}" style="width: 80px;" readonly="readonly"></td>
							<td>Shift:
							<select name="shift" style="width: 80px; padding: 2px;" tabindex="2" required="required">
									<option value="">Select</option>
									<c:if test="${shift=='DAY'}">
										<option value="DAY" selected="selected">Day</option>
										<option value="NIGHT">Night</option>
									</c:if>
									<c:if test="${shift=='NIGHT'}">
										<option value="DAY" >Day</option>
										<option value="NIGHT" selected="selected">Night</option>
									</c:if>
									<c:if test="${shift=='None'}">
										<option value="DAY" >Day</option>
										<option value="NIGHT" >Night</option>
									</c:if>
							</select>
							</td>
							<td><input type="submit" value="Edit" style="margin: 0px 0px 0px 0px;"></td>
						</tr>
					</table>
					</form>
					</center>
				</div>
<c:if test="${details.size() gt 0}">

		
<c:if test="${backdatedentryshow}">
<center>
<br>
<form action="${saveURL}" method="post">	
<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		
		<tr>
			<td style="width: 242px;"><center><b>DEINK W.W. PUMP<BR>4 3 1 - FT -6875</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="hidden" name="id"	value="${CKT.id}" style="width: 40px;" readonly="readonly">
					<input type="text" value="${CKT.col1}" name="col1"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td style="width: 242px;"><center><b>DEINK W.W. PUMP<BR>4 3 1 - FT -6875</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="hidden" name="id"	value="${CKT.id}" style="width: 40px;" readonly="readonly">
					<input type="text" value="${CKT.col1}" name="col1"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b>60 # STEAM TO<BR>BACKUP HEATER<BR>430-FT-6946</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col2}" name="col2"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b>WATER TO FIRE/<BR>MILL WATER TANK<BR>430-FT-6959</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col3}" name="col3"/>
				</c:forEach>	
			</center></td>
		</tr>
		<tr>
			<td><center><b>FIRE SYSTEM WATER<BR>430-FT-6959</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col4}" name="col4"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b>DEINKING PLANT<BR>EFFLUENT<BR>431-FT-6083</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col5}" name="col5"/>
				</c:forEach>
			</center></td>
		</tr>
	</table>

		<p style="MARGIN: 0px 0px 0px -277px;"><b>ALL MEASUREMENTS ABOVE IN GALLONS</b></p>
	
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 240px;"><center><b>TONS PRODUCED TO <BR>THE TUBE CONVEYOR</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col6}" name="col6"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b>WETLAP TONS<BR>PRODUCED</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col7}" name="col7"/>
				</c:forEach>
			</center></td>
		</tr>
	</table>
	<BR>
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 241px;"><center><b>YIELD</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col8}" name="col8"/>
				</c:forEach>
			</center></td>
		</tr>
	</table>
	<BR>
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 241px;"><center><b>WASTE PAPER FED<BR(TONS)</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col9}" name="col9"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b># OF BATCHES FED</b><br><b style="color: Red;font-size: 15px;">Shift Goal 16</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col10}" name="col10"/>
				</c:forEach>
			</center></td>
		</tr>
	</table>

	<table><tr><td><input type="submit" class="button" value="Save"></tr></table>

</form>
</center>
</c:if>
</c:if>	
<c:if test="${details.size() eq 0}">]
<br>
<br><br><br>
<center>
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td><center><b style="color:green; ">No Data Found For Related Search.</b></center></td>
		</tr>
	</table>
</center>	
</c:if>	
			</div>		
</div>

</div>
</body>
</html>
