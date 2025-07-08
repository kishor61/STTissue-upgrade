<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/frpproductionopdataentry/edit" var="editpage" />
<spring:url value="/frpproductionopdataentry/save" var="saveURL" />
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
<form action="${saveURL}" method="post">	
			<div class="pageContent">

				<div class="page-title">
					<span class="label">FRP Production Data Entry Edit Page</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>Id:
								<c:forEach items="${reportDataEdit}" var="CKT">	
									<b style="color: green;">   ${CKT.id}</b>
								</c:forEach>
							</td>	
							<td>Date:     <b style="color: green;">${date}</b></td>
							<td>Shift:    <b style="color: green;">${shift}</b></td>
							<td>Crew:
								<c:forEach items="${reportDataEdit}" var="CKT">	
									<b style="color: green;">    ${CKT.crew}</b>
									<c:set value="${CKT.crew}" var="crew"/>		
								</c:forEach>
							</td>
							<td style="width: 200px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>Date:<input type="text" name="sdate"	value="${date}" style="width: 80px;" readonly="readonly"></td>
							<td>Crew:
							<select name="crew" style="width: 80px; padding: 2px;" tabindex="2" required="required">
									<option value="">Select</option>
									<c:if test="${crew=='A'}">
										<option value="A" selected="selected" >A</option>
										<option value="B" >B</option>
										<option value="C" >C</option>
										<option value="D" >D</option>
									</c:if>
									<c:if test="${crew=='B'}">
										<option value="A" >A</option>
										<option value="B" selected="selected" >B</option>
										<option value="C" >C</option>
										<option value="D" >D</option>
									</c:if>
									<c:if test="${crew=='C'}">
										<option value="A" >A</option>
										<option value="B" >B</option>
										<option value="C"selected="selected"  >C</option>
										<option value="D" >D</option>
									</c:if>
									<c:if test="${crew=='D'}">
										<option value="A" >A</option>
										<option value="B" >B</option>
										<option value="C" >C</option>
										<option value="D"selected="selected"  >D</option>
									</c:if>
									<c:if test="${crew=='None'}">
										<option value="A" >A</option>
										<option value="B" >B</option>
										<option value="C" >C</option>
										<option value="D" >D</option>
									</c:if>
							</select>
							</td>
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
						</tr>
					</table>
				</div>
<br>

<center>
<%-- <center><p style="color: red;"><b>${message}</b></p></center> --%>

<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		
		<%-- <tr>
			<td style="width: 242px;"><center><b>DEINK W.W. PUMP<BR>4 3 1 - FT -6875</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="hidden" name="id"	value="${CKT.id}" style="width: 40px;" readonly="readonly">
					<input type="text" value="${CKT.col1}" name="col1"/>
				</c:forEach>
			</center></td>
		</tr> --%>
		<tr>
			<td style="width: 242px;"><center><b>DEINK W.W. PUMP<BR>4 3 1 - FT -6875</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="hidden" name="id"	value="${CKT.id}" style="width: 40px;" readonly="readonly">
					<input type="text" value="${CKT.col1}" name="col1"/>
				</c:forEach>
			</center></td>
		</tr>
		<%-- <tr>
			<td><center><b>60 # STEAM TO<BR>BACKUP HEATER<BR>430-FT-6946</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="text" value="${CKT.col2}" name="col2"/>
				</c:forEach>
			</center></td>
		</tr> --%>
		<tr>
			<td><center><b>WATER TO FIRE/<BR>MILL WATER TANK<BR>430-FT-6956<br># 1008</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="text" value="${CKT.col3}" name="col3"/>
				</c:forEach>	
			</center></td>
		</tr>
		<tr>
			<td><center><b>FIRE SYSTEM WATER<BR>430-FT-6959<br># 1009</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="text" value="${CKT.col4}" name="col4"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b>DEINKING PLANT<BR>EFFLUENT<BR>431-FT-6083</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="text" value="${CKT.col5}" name="col5"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b>SEWER FLOW</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="text" value="${CKT.col12}" name="col12"/>
				</c:forEach>
			</center></td>
		</tr>
		<%-- <tr>
		<td><center><b>HD LEVEL AS OF<BR>7 AM TO 7PM</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="text" value="${CKT.col11}" name="col11"/>
				</c:forEach>
			</center></td>
		</tr> --%>
	</table>
	<BR>
		<p style="MARGIN: 0px 0px 0px -277px;"><b>ALL MEASUREMENTS ABOVE IN GALLONS</b></p>
	<BR>
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 240px;"><center><b>HD LEVEL AS OF<BR>7 AM TO 7PM</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="text" value="${CKT.col11}" name="col11"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td style="width: 240px;"><center><b>TONS PRODUCED TO <BR>THE TUBE CONVEYOR</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="text" value="${CKT.col6}" name="col6"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b>WETLAP TONS<BR>PRODUCED</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
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
				<c:forEach items="${reportDataEdit}" var="CKT">
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
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="text" value="${CKT.col9}" name="col9"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b># OF BATCHES FED</b><br><b style="color: Red;font-size: 15px;">Shift Goal 16</b></center></td>
			<td><center>
				<c:forEach items="${reportDataEdit}" var="CKT">
					<input type="text" value="${CKT.col10}" name="col10"/>
				</c:forEach>
			</center></td>
		</tr>
	</table>
<%-- <c:if test="${showsubmitbutton}">
	<table><tr><td><input type="submit" class="button" value="Save"></tr></table>
</c:if> --%>
<br>
<input type="submit" class="button" value="Save">

</form>
<!-- <td><a href='/STTissueQR/frpproductionopdataentry/new'><button class="button">Go Back</button></a></td> -->
</center>

<br>
<center>
<%-- <c:if test="${showeditbutton}">
<table>
		
		<tr>
				<td>
				<form action="${editpage}" method="POST">
					<c:forEach items="${checkTon}" var="CKT">
						<input type="hidden" value="${CKT.id}" name="id"/>
					</c:forEach>
					<input type="submit" class="button" value="Save">
				</form>
				</td>
				
		</tr>
		
</table>
</c:if> --%>

			</div>

		</div>


	</div>

</body>
</html>
