<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<!-- <script type="text/javascript">
$(function(){
	
	$('input[name=sdateTmp]').datepicker({
		changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        minDate:  new Date(2013, 09, 01, 0, 0, 0, 0),
        dateFormat: 'MM yy',
        onClose: function(dateText, inst) { 
            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, month, 1));
        }
	});
	
	$('input[name=edateTmp]').datepicker({
		changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        dateFormat: 'MM yy',
        onClose: function(dateText, inst) { 
            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, month, 1));
        }
	});
});
</script> -->
<script type="text/javascript">
$(function(){
	$('input[name=sdateTmp]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script> 
<style>
	.demo {
		border:1px solid #C0C0C0;
		border-collapse:collapse;
		padding:5px;
	}
	.demo th {
		border:1px solid #C0C0C0;
		padding:5px;
		background:#F0F0F0;
	}
	.demo td {
		border:1px solid #C0C0C0;
		padding:5px;
	}
</style>
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
<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
		<form name="dataForm" action='<spring:url value="/frpcostoptimization/save"/>' method="post">	
			<div class="pageContent">

				<div class="page-title">
					<span class="label">FRP COST OPTIMIZATION DATA ENTRY</span>
				</div>
				<div class="table-selector">
					
					
					<table style="margin: auto;">
						<tr>
							<td>Select Month And Year:</td>
							<td>
								
								<input readonly="readonly" type="text" name="sdateTmp" value="${frpGoals.sdateTmp}">							
							</td>
							<%-- <td>End Date:</td>
							<td>
								<input readonly="readonly" type="text" name="edateTmp" value="${frpGoals.edateTmp}">							
							</td> --%>
						</tr>
					</table>
				

				</div>
<center>
<b style="color: green;">${message}</b>
<br><br>
<table class="demo" style="width: 420px;">
	<%-- <caption></caption> --%>
	<thead>
	<tr>
		<th>Waste Paper Mix</th>
		<th>Mix Range %</th>
		<th style="width: 20px;">Waste with Freight</th>
		<th style="width: 20px;">Avg.Waste Price</th>
		<!-- <th>Till 15th Nov.</th>
		<th>Consumption $</th> -->
	</tr>
	</thead>
	<tbody>
	<tr>
		<td><center><b>SOW & CBS</b></center></td>
		<td><center><b>0--5</b></center></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.sowAndCbsF}" name="sowAndCbsF"/></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.sowAndCbsW}" name="sowAndCbsW"/></td>
		<!-- <td>&nbsp;</td>
		<td>&nbsp;</td> -->
	</tr>
	<tr>
		<td><center><b>News / News Blank</b></center></td>
		<td><center><b>5--15</b></center></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.newsBankF}" name="newsBankF"/></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.newsBankW}" name="newsBankW"/></td>
		<!-- <td>&nbsp;</td>
		<td>&nbsp;</td> -->
	</tr>
	<tr>
		<td><center><b>OCC</b></center></td>
		<td><center><b>35--55</b></center></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.occF}" name="occF"/></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.occW}" name="occW"/></td>
		<!-- <td>&nbsp;</td>
		<td>&nbsp;</td> -->
	</tr>
	<tr>
		<td><center><b>DLK</b></center></td>
		<td><center><b>5--15</b></center></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.dlkF}" name="dlkF"/></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.dlkW}" name="dlkW"/></td>
		<!-- <td>&nbsp;</td>
		<td>&nbsp;</td> -->
	</tr>
	<tr>
		<td><center><b>Mail</b></center></td>
		<td><center><b>0--15</b></center></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.mailF}" name="mailF"/></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.mailW}" name="mailW"/></td>
		<!-- <td>&nbsp;</td>
		<td>&nbsp;</td> -->
	</tr>
	<tr>
		<td><center><b>Mixed / other Krft</b></center></td>
		<td><center><b>5--20</b></center></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.mixedOtherF}" name="mixedOtherF"/></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.mixedOtherW}" name="mixedOtherW"/></td>
		<!-- <td>&nbsp;</td>
		<td>&nbsp;</td> -->
	</tr>
	<tr>
		<td><center><b>Cut Book</b></center></td>
		<td><center><b>5--20</b></center></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.cutbookF}" name="cutbookF"/></td>
		<td><input type="text" style="width: 60px;" value="${frpGoals.cutbookW}" name="cutbookW"/></td>
		<!-- <td>&nbsp;</td>
		<td>&nbsp;</td> -->
	</tr>
	<tbody>
</table>
<br>
<table>
<tr>		
	<td><input type="submit" class="button" value="Submit" name="Submit"></td>
</tr>
</table>

</center>
</form>		
	</div>

		</div>


	</div>

</body>
</html>
