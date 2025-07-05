<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<spring:url value="/frpproductionopdataentry/save" var="saveURL" />
<spring:url value="/frpproductionopdataentry/new" var="newTypeURL" />
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
<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;


$(function(){
		$('select[name=shift]').change(function(){
			var val=$(this).val();
			
			var otr = $('#qualityDataTable tbody tr:last');
			var odate=otr.find('input[name=sdate]').val();
			var crew=otr.find('select[name=crew]').val();
			if(crew==''){
				alert('Please Select Crew ?');
				return;	
			}
				
			if(val!=''){
				location.href='${newTypeURL}/'+val+'/'+odate+'/'+crew;
			}else{
				location.href='${newTypeURL}';
			}
			
		});
		
		(function blink() { 
		    $('#blink_me').fadeOut(500).fadeIn(500, blink); 
		})();
		
	});
	

	function validateform()
	{
		$('#loadPage').show();
	}

	
</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
			<jsp:include page="header.jsp"></jsp:include>
<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
	<div class="pageContent">
	<div class="block3" style="overflow: auto;">
		<div class="page-title">
			<span class="label">FRP Production Operator Data Entry</span>
		</div>	
	

<form action="${saveURL}" method="post" onsubmit="validateform()">	
		
			<div class="table-selector">

					<center>
					<table id="qualityDataTable">
						<tr>
							<td>Date:<input type="text" name="sdate"	value="${sdate}" style="width: 80px;" readonly="readonly"></td>
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
							<td>Production Type:
								<select name="productiontype" style="width: 80px; padding: 2px;" tabindex="2" required="required">
									<option value="">Select</option>
									<option value="Kraft" selected="selected">Kraft</option>
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
							<%-- <td>
							&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<button onclick="location.href='<spring:url value="/frpproductionopdataentry/back"/>'">Back Dated Entry</button></td> --%>
							
						</tr>
					</table>
					</center>

				</div>
 <center>
<p><b style="color: green;">${message}</b></p>
<c:if test="${details.size() gt 0}">
<c:if test="${backdatedentryshow}">
<div ><p style="color: green;"><b>You Have Already Entered Data For The Related Search,<br>Modify It And Press Save Button To Save. </b></p></div>
<center>
<form action="${saveURL}" method="post">	
<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		
		<%-- <tr>
			<td style="width: 242px;"><center><b>DEINK W.W. PUMP<BR>4 3 1 - FT -6875</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="hidden" name="id"	value="${CKT.id}" style="width: 40px;" readonly="readonly">
					<input type="text" value="${CKT.col1}" name="col1"/>
				</c:forEach>
			</center></td>
		</tr> --%>
		<tr>
			<td style="width: 242px;"><center><b>DEINK W.W. PUMP<BR>4 3 1 - FT -6875</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="hidden" name="id"	value="${CKT.id}" style="width: 40px;" >
					<input type="text" value="${CKT.col1}" name="col1" autofocus="autofocus"/>
				</c:forEach>
			</center></td>
		</tr>
		<%-- <tr>
			<td><center><b>60 # STEAM TO<BR>BACKUP HEATER<BR>430-FT-6946</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col2}" name="col2" readonly="readonly"/>
				</c:forEach>
			</center></td>
		</tr> --%>
		<tr>
			<td><center><b>WATER TO FIRE/<BR>MILL WATER TANK<BR>430-FT-6956<br> # 1008</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col3}" name="col3" />
				</c:forEach>	
			</center></td>
		</tr>
		<tr>
			<td><center><b>FIRE SYSTEM WATER<BR>430-FT-6959<br># 1009</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col4}" name="col4" />
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b>DEINKING PLANT<BR>EFFLUENT<BR>431-FT-6083</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col5}" name="col5" />
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b>SEWER FLOW </b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col12}" name="col12" />
				</c:forEach>
			</center></td>
		</tr>
		<%-- <tr>
			<td><center><b>HD LEVEL AS OF<BR>7 AM TO 7PM</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col11}" name="col11" readonly="readonly"/>
				</c:forEach>
			</center></td>
		</tr> --%>
	</table>

		<p style="MARGIN: 0px 0px 0px -277px;"><b>ALL MEASUREMENTS ABOVE IN GALLONS</b></p>
	
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 240px;"><center><b><p style="color: green;">Line-A</p>HD LEVEL AS OF<BR>7 AM / 7PM</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col11}" name="col11" />
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td style="width: 240px;"><center><b><p style="color: green;">Line-A</p>TONS PRODUCED TO <BR>THE TUBE CONVEYOR</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col6}" name="col6" />
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-A</p>WETLAP TONS<BR>PRODUCED</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col7}" name="col7" />
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td style="width: 241px;"><center><b><p style="color: green;">Line-A</p>YIELD</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col8}" name="col8" />
				</c:forEach>
			</center></td>
		</tr>
		
		<tr>
			<td style="width: 241px;"><center><b><p style="color: green;">Line-A</p>WASTE PAPER FED<BR>(TONS)</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col9}" name="col9" />
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-A</p># OF BATCHES FED</b><br><b style="color: Red;font-size: 15px;">Shift Goal 16</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col10}" name="col10"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-A</p>Current Run rate</b><br></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col10a}" name="col10a"/>
				</c:forEach>
			</center></td>
		</tr>
	</table>
	<br/>
	<!-- Code For Line B Starts From Here -->
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 240px;"><center><b><p style="color: green;">Line-B</p>PCC Tank LEVEL AS OF<BR>7 AM / 7PM</b></center></td>
			<td><center>
					<c:forEach items="${details}" var="CKT">
						<input type="text" value="${CKT.col11b}" name="col11b"/>
					</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td style="width: 240px;"><center><b><p style="color: green;">Line-B</p>TONS PRODUCED TO <BR>THE TUBE CONVEYOR</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col6b}" name="col6b"/>
				</c:forEach>	
			</center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-B</p>B to A PULP</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col7b}" name="col7b"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td style="width: 241px;"><center><b><p style="color: green;">Line-B</p>YIELD</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col8b}" name="col8b"/>
				</c:forEach>	
			</center></td>
		</tr>
		
		<tr>
			<td style="width: 241px;"><center><b><p style="color: green;">Line-B</p>WASTE PAPER FED<BR>(TONS)</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col9b}" name="col9b"/>
				</c:forEach>
			</center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-B</p># OF BATCHES FED</b><br><b style="color: Red;font-size: 15px;">Shift Goal 16</b></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col10b}" name="col10b"/>
				</c:forEach>	
		</center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-B</p>Current Run Rate</b><br></center></td>
			<td><center>
				<c:forEach items="${details}" var="CKT">
					<input type="text" value="${CKT.col12b}" name="col12b"/>
				</c:forEach>	
		</center></td>
		</tr>
	</table>
	
	<!-- Code For Line B Ends Here -->
	
<!-- 	<table><tr><td><input type="submit" class="button" value="Edit"></tr></table> -->
	<table><tr><td><input type="submit" class="button" value="Save"></tr></table>
<!-- 	<table><tr><td><input type="submit" class="button" value="Save"></tr></table> -->

</form>
</center>
</c:if>
</c:if>
<!-- If List Size Is Equals To Zero -->
<c:if test="${details.size() eq 0}">
<center>
<form action="${saveURL}" method="post">	
<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		${sdate}
		<tr>
			<td style="width: 242px;"><center><b>DEINK W.W. PUMP <BR>4 3 1 - FT -6875</b></center></td>
			<td><center>
					<input type="text" value="" name="col1"/>
			</center></td>
		</tr>
		<%-- <tr>
			<td><center><b>60 # STEAM TO<BR>BACKUP HEATER<BR>430-FT-6946</b></center></td>
			<td><center>
					<input type="text" value="" name="col2"/>
			</center></td>
		</tr> --%>
		<tr>
			<td><center><b>WATER TO FIRE/<BR>MILL WATER TANK<BR>430-FT-6956<br> # 1008</b></center></td>
			<td><center>
					<input type="text" value="" name="col3"/>
			</center></td>
		</tr>
		<tr>
			<td><center><b>FIRE SYSTEM WATER<BR>430-FT-6959<br> # 1009</b></center></td>
			<td><center>
					<input type="text"value="" name="col4"/>
			</center></td>
		</tr>
		<tr>
			<td><center><b>DEINKING PLANT<BR>EFFLUENT<BR>431-FT-6083</b></center></td>
			<td><center>
					<input type="text" value="" name="col5"/>
			</center></td>
		</tr>
		<tr>
			<td><center><b>SEWER FLOW </b></center></td>
			<td><center>
					<input type="text" value="" name="col12"/>
			</center></td>
		</tr>
		<%-- <tr>
			<td><center><b>HD LEVEL AS OF<BR>7 AM TO 7PM</b></center></td>
			<td><center>
					<input type="text" value="" name="col11"/>
			</center></td>
		</tr> --%>
	</table>

		<p style="MARGIN: 0px 0px 0px -277px;"><b>ALL MEASUREMENTS ABOVE IN GALLONS</b></p>
	
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 240px;"><center><b><p style="color: green;">Line-A</p>HD LEVEL AS OF<BR>7 AM / 7PM</b></center></td>
			<td><center>
					<input type="text" value="" name="col11"/>
			</center></td>
		</tr>
		<tr>
			<td style="width: 240px;"><center><b><p style="color: green;">Line-A</p>TONS PRODUCED TO <BR>THE TUBE CONVEYOR</b></center></td>
			<td><center>
					<input type="text" value="" name="col6"/>
			</center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-A</p>WETLAP TONS<BR>PRODUCED</b></center></td>
			<td><center>
					<input type="text" value="" name="col7"/>
			</center></td>
		</tr>
		<tr>
			<td style="width: 241px;"><center><b><p style="color: green;">Line-A</p>YIELD</b></center></td>
			<td><center>
					<input type="text" value="" name="col8"/>
			</center></td>
		</tr>
		
		<tr>
			<td style="width: 241px;"><center><b><p style="color: green;">Line-A</p>WASTE PAPER FED<BR>(TONS)</b></center></td>
			<td><center>
					<input type="text" value="" name="col9"/>
			</center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-A</p># OF BATCHES FED</b><br><b style="color: Red;font-size: 15px;">Shift Goal 16</b></center></td>
			<td><center>
					<input type="text" value="" name="col10"/>
		</center></td>
		</tr>
		
		<tr>
			<td><center><b><p style="color: green;">Line-A</p># Current Run Rate</b><br><b style="color: Red;font-size: 15px;"></b></center></td>
			<td><center>
					<input type="text" value="" name="col10a"/>
		</center></td>
		</tr>
	</table>
	<BR>
	<%-- <table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 241px;"><center><b>YIELD</b></center></td>
			<td><center>
					<input type="text" value="" name="col8"/>
			</center></td>
		</tr>
	</table> --%>
	<BR>
	<%-- <table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 241px;"><center><b>WASTE PAPER FED<BR(TONS)</b></center></td>
			<td><center>
					<input type="text" value="" name="col9"/>
			</center></td>
		</tr>
		<tr>
			<td><center><b># OF BATCHES FED</b><br><b style="color: Red;font-size: 15px;">Shift Goal 16</b></center></td>
			<td><center>
					<input type="text" value="" name="col10"/>
		</center></td>
		</tr>
	</table> --%>
	
	<!-- Code For Line B Starts From Here -->
	<table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:40%" cellpadding="2" cellspacing="3">
		<tr>
			<td style="width: 240px;"><center><b><p style="color: green;">Line-B</p>PCC Tank LEVEL AS OF<BR>7 AM / 7PM</b></center></td>
			<td><center>
					<input type="text" value="" name="col11b"/>
			</center></td>
		</tr>
		<tr>
			<td style="width: 240px;"><center><b><p style="color: green;">Line-B</p>TONS PRODUCED TO <BR>THE TUBE CONVEYOR</b></center></td>
			<td><center>
					<input type="text" value="" name="col6b"/>
			</center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-B</p>B to A PULP</b></center></td>
			<td><center>
					<input type="text" value="" name="col7b"/>
			</center></td>
		</tr>
		<tr>
			<td style="width: 241px;"><center><b><p style="color: green;">Line-B</p>YIELD</b></center></td>
			<td><center>
					<input type="text" value="" name="col8b"/>
			</center></td>
		</tr>
		
		<tr>
			<td style="width: 241px;"><center><b><p style="color: green;">Line-B</p>WASTE PAPER FED<BR>(TONS)</b></center></td>
			<td><center>
					<input type="text" value="" name="col9b"/>
			</center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-B</p># OF BATCHES FED</b><br><b style="color: Red;font-size: 15px;">Shift Goal 16</b></center></td>
			<td><center>
					<input type="text" value="" name="col10b"/>
		</center></td>
		</tr>
		<tr>
			<td><center><b><p style="color: green;">Line-B</p># Current Run Rate</b><br><b style="color: Red;font-size: 15px;"></b></center></td>
			<td><center>
					<input type="text" value="" name="col12b"/>
		</center></td>
		</tr>
		
	</table>
	
	<!-- Code For Line B Ends Here -->
	
	<table><tr><td><center><input type="submit" class="button" value="Save"></center></td></tr></table>
<!-- 	<table><tr><td><input type="submit" class="button" value="Save"></tr></table> -->
	
</form>
</center>

</c:if>	
		
</form>
</div>
</div>
</div>

</body>
</html>
