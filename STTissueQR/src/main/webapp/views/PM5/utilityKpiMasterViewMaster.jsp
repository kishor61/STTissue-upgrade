<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>

<spring:url value="/pm5utilitykpimaster/deletemaster"  var="deleteUrl"/>
<spring:url value="/pm5utilitykpimaster/edit"  var="editUrl"/>

<script type="text/javascript">

	$(function(){
		
	
		$('#deleteRowBtn').click(function(){
			var rowCount = $('#masterTable tbody tr').length;
			if(rowCount==1){
				alert("You can't delete first row.");
				return;
			}
			var dbtn=$(this);
			var val=$('#masterTable tbody input[name=id]:checked').val();
			if(typeof val==='undefined'){
				alert('Select row');
			}else{
				if(val==''){
					$('#masterTable tbody input[name=id]:checked').parent().parent().remove();
				}else{
					dbtn.attr('disabled','disabled');
					$.ajax({
						url:'${deleteUrl}',
						type:'POST',
						data:{id:val},
						success:function(data){
							if(data.status){
								alert('Data removed from database.');
								location.reload(true);
							}else{
								alert(data.error);
							}
						}
					});
				}
			}
		});
		
		$('#exportRowBtn').click(function(){
			$('#exportForm').submit();
		});
		
		
		$('#editBtn').click(function(){
			var val=$('#masterTable tbody input[name=id]:checked').val();
			if(typeof val==='undefined'){
				alert('Select row');
			}else{
				if(val!=''){
					location.href='${editUrl}/'+$('#exportForm input[name=type]').val()+'/'+val+location.search;
				}
			}
		});
		
	});
	

</script>


<spring:url value="/pm5utilitykpimasterreport/exportmaster" var="exportDataURL"/>
<form id="exportForm" action="${exportDataURL}" method="post"  target="_blank">
<input type="hidden" name="sdate" value="${sdate}">
<input type="hidden" name="edate" value="${edate }">
<input type="hidden" name="type" value="${page}">

</form>

<div style="right: 10px; overflow: auto; position: absolute; bottom: 0; top: 110px; left: 10px;">
<c:if test="${fn:length(datas)>0 }">
<table id="masterTable" class="table"
	style="width: auto;; margin: auto; font-size: 12px;">
	<thead>
		<tr>
			<th class="trobjrow"> &nbsp; </th>
			<th class="trobjrow"> &nbsp; </th>
			<th class="trobjrow" colspan="44"><!-- Code Modified By Roshan Tailor Date :- 03/21/2016 40 T0 43  -->
				<span style="font-size: 16px;">MACHINE PULP AND UTILITY CONSUMPTION REPORT</span>
			</th>
			
			<th class="trobjrow"> &nbsp; </th>
			<th class="trobjrow" colspan="20"><span style="font-size: 16px;">FRP PRODUCTION AND MIX DATA</span> </th>
			
			<th class="trobjrow"> &nbsp; </th>
			<th class="trobjrow" colspan="6"><span style="font-size: 16px;">ENERGY</span> </th>
			
			<th class="trobjrow"> &nbsp; </th>
			<th class="trobjrow" colspan="4"><span style="font-size: 16px;">Condensate Efficiency</span> </th>
			<th class="trobjrow"> &nbsp; </th>
			<!-- <th class="trobjrow" colspan="6"><span style="font-size: 16px;">Pulp Data</span> </th> -->
			<th class="trobjrow" colspan="6"><span style="font-size: 16px;">Chemicals</span></th>	
			
		</tr>
		<tr>
			<th rowspan="3" style="width: 10px;"></th>
			<th rowspan="3">Date</th>
			<th rowspan="2">Average<br>Production</th>
			
			<th colspan="3">Machine Production</th>
			<th colspan="3">Wrapper Production</th>
			<th colspan="3">Winder Production</th>
			
			<th colspan="2" rowspan="2">Machine Downtime</th>	
			<th colspan="3">60lb Steam</th>
			<th colspan="3">150lb Steam</th>
			<th rowspan="2">Cond Flow</th>
			<th colspan="2">Natural Gas</th>
			<th colspan="2">Mill water</th>
			
			<th colspan="10">Paper Mill Fiber Loss</th> <!-- Code Modified By Roshan Tailor Date :- 03/21/2016 -->
			<th colspan="2">Pulp(Calculated)</th>
			<th rowspan="2">Consumed stock (DCS Display)</th>
			<th colspan="3">FRP Production ADT</th>
			<th colspan="2">Waste paper feed</th>
			<th rowspan="2">FRP Water usage</th>
			<th rowspan="3">Tissue grade</th>

			<th rowspan="3"></th>
			
			<th colspan="3">FRP Production</th>
			
			<th colspan="16">FRP MIX DATA</th>
			
			<th rowspan="2">Yield (Tracker)</th>
			<th rowspan="3"></th>
			
			<th colspan="6">PM #5 Energy Data</th>
			
			<th rowspan="3"></th>
			
			<th colspan="4">PM #5 Condensate Efficiency</th>
			
			<th rowspan="3"></th>
			
			<!-- <th colspan="6">PM #5 &#38; FRP Pulp Utilization</th> -->
			<th colspan="6"></th>	

		</tr>
		<tr>
			<th>Bleached</th>
			<th>Kraft</th>
			<th>Slab off(Reel)</th>
			<th>Bleached</th>
			<th>Kraft</th>
			<th>Total</th>
			
			
			<th>White</th>
			<th>Red</th>
			<th>Reject</th>
			
			<th>Total cons </th>
			<th>Avg Cons</th>
			<th>Sp.Cons</th>
			<th>Total cons </th>
			<th>Avg Cons</th>
			<th>Sp.Cons</th>
			<th>Total Cons</th>
			<th>Sp.Cons</th>
			<th>Total cons</th>
			<th>Sp. Cons</th>
			<th>TM Sewer flow</th>
			<th>TM Sewer Consy</th>
			<th>TM Fiber loss</th>
			<!-- <th>WW to FRP</th> -->
			<!-- <th>Consy</th> -->
			<th>WW to FRP Flow</th>
			<th>WW To FRP Flow<br />Consy</th>
			
			<th  rowspan="1">WW to FRP</th>
			<!-- Code Starts From Here Done By Roshan Tailor Date :- 03/21/2016 -->
			<!-- <th style="color: red;">Deinking Plant Effluent</th> -->
			<th style="color: Black;">FRP Effluent</th>
			<th style="color: Black;">FRP Effluent Consy</th>
			<th style="color: Black;">FRP Fiber loss</th>
			<!--Code Ends Here Done By Roshan Tailor Date :- 03/21/2016 -->
			
			<!-- <th>Total Fiber loss</th> -->
			<th>Total Fiber loss</th>
			<th>W Lap</th>
			<th>Total</th>
			<th>White</th>
			<th>Kraft</th>
			<th>Wet lap</th>
			<th>White</th>
			<th>Kraft</th>

			<th>DCS FRP Production</th>
			<th>DCS Waste paper feed</th>
			<th>Yield (DCS)</th>
			
			
			<th>MWL</th>
			<th>Pmix</th>
			<th>CBS</th>
			<th>Ctd Gdwd</th>
			<th>SWL</th>
			<th>News/ Newsblank</th>
			<th>SOW</th>
			<th>SOW &#38; CBS</th>
			<th>SBS</th>
			<th>White Gdwd</th>
			<th>OCC</th>
			<th>DLK</th>
			<th>Mixed paper</th>
			<th>Other</th>
			<th>Total White mix</th>
			<th>Total Kraft mix</th>
			
			


			<th>60 lb Steam</th>
			<th>150 lb Steam</th>
			<th>Natural Gas</th>
			<th colspan="2">Electrical</th>
			<th>Total</th>
			
			
			<th>Total Steam</th>
			<th></th>
			<th>Avg Daily Power Cost</th>
			<th>Efficiency</th>
			
		<!-- 	
			<th>Pulp from FRP</th>
			<th>M/c consumed from HD Chest</th>
			<th>M/c prod DCS</th>
			<th>HD Level @ 8:00 AM</th>
			<th>Pulp in HD @ 8:00 AM</th>
			<th></th> -->
			
			<th>Wet strength</th>
			<th>Release</th>
			<th>Adhesive</th>
			<th>MAP</th>
			<th>Defoamer</th>
			<th>Passivator</th>
		</tr>
		<tr>
			<th>T/H</th>
			<th colspan="9">T/day</th>
		<!-- 	<th>T/day</th>
			<th>At Reel</th>
			<th>Ble'd</th>
			<th>Kraft</th>
			<th>Total</th>
			<th>White</th>
			<th>Red</th>
			<th>Reject</th> -->
			<th>Min</th>
			<th>%</th>
			<th>(lbs)</th>
			<th>lbs/hr</th>
			<th>lbs/T</th>
			<th>(lbs)</th>
			<th>lbs/hr</th>
			<th>lbs/T</th>
			
			
			
			<th>M Gal</th>
			<th>Kscf</th>
			
			<th>Kscf/T</th>
			<!-- <th>kWh</th> -->
			
			<th>M Gal</th>
			<th>Gal T</th>
			
			
			<th>M Gal</th>
			<th>%</th>
			<th>T/day</th>
			<th>M/Gal</th>
			<th>%</th>
			<!--<th>T/day</th> -->
			<!-- <th>M gallons</th> -->
			
			
			
			<th>T/ day</th>
			
			
			<th style="color: black;">M Gal</th>
			<th style="color: black;">%</th>
			
			<th>T/day</th>
			<!-- <th>T/day</th> -->
			
			<th>T/day</th>
			<th>T/day</th>
			
			<th>AD T/day</th>
			<th>AD T/day</th>
			<th>Tons</th>
			<th>Ton</th>
			<th>Tons</th>
			<th>Tons</th>
			<th>Ton</th>
			<th>Tons</th>
			<th>M Gal</th>


			<th>Ton</th>
			<th>Ton</th>
			<th>%</th>
			<th>Ton</th>
			<th>Ton</th>
			<th>Ton</th>
			<th>Ton</th>
			<th>Ton</th>
			<th>Ton</th>
			<th>Ton</th>
			<th>Ton</th>
			<th>Ton</th>
			<th>Ton</th>
			<th>Ton</th>
			<th>Ton</th>
			<th>Ton</th>
			<!-- <th>Ton</th> -->
			<th>Ton</th>
			<th>Ton</th>
			<th>%</th>
			
			<th>KWh/T</th>
			<th>KWh/T</th>
			<th>KWh/T</th>
			<th>kWh</th>
			<th>KWh/T</th>
			<th>KWh/T</th>
			
			<th>Klbs/Day</th>
			<th>Gallon/day</th>
			<th>$/kWh</th>
			<th>%</th>
			
		<!-- 	<th>Tons</th>
			<th>Tons</th>
			<th>Tons</th>
			<th>%</th>
			<th>Tons</th>
			<th></th> -->
			<th>Gal<!-- Gallons --></th>
			<th>Liter<!-- Gallons --></th>
			<th>Liter<!-- Gallons --></th>
			<th>Liter<!-- Gallons --></th>
			<th>Liter<!-- Gallons --></th>
			<th>Liter<!-- Gallons --></th>
			<!-- <th>Gallons</th> -->
		</tr>
	</thead>
	
	<tbody>




	<c:forEach items="${datas}" var="data">
	<tr>
		<td><input type="radio" name="id" value="${data['1']}"></td>
		<td style="width: 60px;"><div>${data['2']}</div></td>
		<td style="width: 60px;"><div>${data['3']}</div></td>
		<td style="width: 60px;"><div>${data['4']}</div></td>
		<td style="width: 60px;"><div>${data['5']}</div></td>
		<td style="width: 60px;"><div>${data['6']}</div></td>
		<td style="width: 60px;"><div>${data['7']}</div></td>
		<td style="width: 60px;"><div>${data['8']}</div></td>
		<td style="width: 60px;"><div>${data['9']}</div></td>
		<td style="width: 60px;"><div>${data['10']}</div></td>
		<td style="width: 60px;"><div>${data['11']}</div></td>
		<td style="width: 60px;"><div>${data['12']}</div></td>
		<td style="width: 60px;"><div>${data['13']}</div></td>
		<td style="width: 60px;"><div>${data['14']}</div></td>
		<td style="width: 60px;"><div>${data['15']}</div></td>
		<td style="width: 60px;"><div>${data['16']}</div></td>
		<td style="width: 60px;"><div>${data['17']}</div></td>
		<td style="width: 60px;"><div>${data['18']}</div></td>
		<td style="width: 60px;"><div>${data['19']}</div></td>
		<td style="width: 60px;"><div>${data['20']}</div></td>
		<td style="width: 60px;"><div>${data['21']}</div></td>
		<td style="width: 60px;"><div>${data['22']}</div></td>
		<td style="width: 60px;"><div>${data['23']}</div></td>
		<td style="width: 60px;"><div>${data['24']}</div></td>
		<td style="width: 60px;"><div>${data['25']}</div></td>
		<td style="width: 60px;"><div>${data['26']}</div></td>
		<td style="width: 60px;"><div>${data['27']}</div></td>
		<td style="width: 60px;"><div>${data['28']}</div></td>
		<!-- <td style="width: 60px;"><div>Roshan</div></td> -->
		<td style="width: 60px;"><div>${data['29']}</div></td>
	<%-- 	<td style="width: 60px;"><div>${data['29']}</div></td> --%>
		<td style="width: 60px;"><div>${data['30']}</div></td>
		<td style="width: 60px;"><div>${data['31']}</div></td>
<!-- 		Ccode Starts From Here Done By Roshan Tailor Date :- 03/21/2016 -->
		<td style="width: 80px;"><div><fmt:formatNumber value="${data['85']/1000000}" maxFractionDigits="2"/></div></td>
		<td style="width: 80px;"><div><fmt:formatNumber value="${data['86']}" maxFractionDigits="2"/></div></td>
		<td style="width: 80px;"><div><fmt:formatNumber value="${data['87']}" maxFractionDigits="2"/></div></td>
<!-- 		Code Ends Here Done By Roshan Tailor Date :- 03/21/2016 -->
		<%-- <td style="width: 60px;"><div>${data['32']}</div></td> --%>
		
		<%-- <td style="width: 60px;"><div><fmt:formatNumber value="${data['28']+data['31']+data['87']}" maxFractionDigits="2"/></div></td> --%>
		<td style="width: 60px;"><div><fmt:formatNumber value="${data['28']+data['87']}" maxFractionDigits="2"/></div></td>
		
		<td style="width: 60px;"><div>${data['33']}</div></td>
		<td style="width: 60px;"><div>${data['34']}</div></td>
		<td style="width: 60px;"><div>${data['35']}</div></td>
		<td style="width: 60px;"><div>${data['36']}</div></td>
		<td style="width: 60px;"><div>${data['37']}</div></td>
		<td style="width: 60px;"><div>${data['38']}</div></td>
		<td style="width: 60px;"><div>${data['39']}</div></td>
		<td style="width: 60px;"><div>${data['40']}</div></td>
		<td style="width: 60px;"><div>${data['41']}</div></td>
		<td style="width: 200px;"><div>${data['42']}</div></td>
		
		<td style="width: 60px;"><div></div></td>
		<td style="width: 60px;"><div>${data['43']}</div></td>
		<td style="width: 60px;"><div>${data['44']}</div></td>
		<td style="width: 60px;"><div>${data['45']}%</div></td>

		<td style="width: 60px;"><div>${data['46']}</div></td>
		<td style="width: 60px;"><div>${data['47']}</div></td>
		<td style="width: 60px;"><div>${data['48']}</div></td>
		<td style="width: 60px;"><div>${data['49']}</div></td>
		<td style="width: 60px;"><div>${data['50']}</div></td>
		<td style="width: 60px;"><div>${data['51']}</div></td>
		<td style="width: 60px;"><div>${data['52']}</div></td>
		<td style="width: 60px;"><div>${data['53']}</div></td>
		<td style="width: 60px;"><div>${data['54']}</div></td>
		<td style="width: 60px;"><div>${data['55']}</div></td>
		<td style="width: 60px;"><div>${data['56']}</div></td>
		<td style="width: 60px;"><div>${data['57']}</div></td>
		<td style="width: 60px;"><div>${data['58']}</div></td>
		<td style="width: 60px;"><div>${data['59']}</div></td>
		<td style="width: 60px;"><div>${data['60']}</div></td>
		<td style="width: 60px;"><div>${data['61']}</div></td>
		<td style="width: 60px;"><div>${data['62']}</div></td>
		
		<td style="width: 60px;"><div></div></td>
		
		<td style="width: 60px;"><div>${data['63']}</div></td>
		<td style="width: 60px;"><div>${data['64']}</div></td>
		<td style="width: 60px;"><div>${data['65']}</div></td>
		<td style="width: 60px;"><div>${data['66']}</div></td>
		<td style="width: 60px;"><div>${data['67']}</div></td>
		<td style="width: 60px;"><div>${data['68']}</div></td>
		
		<td style="width: 60px;"><div></div></td>
		<td style="width: 60px;"><div>${data['69']}</div></td>
		<td style="width: 60px;"><div>${data['70']}</div></td>
		<td style="width: 60px;"><div>${data['71']}</div></td>
		<td style="width: 60px;"><div>${data['72']}%</div></td>
		
		<td style="width: 60px;"><div></div></td>
		
		<%-- <td style="width: 60px;"><div>${data['73']}</div></td>
		<td style="width: 60px;"><div>${data['74']}</div></td>
		<td style="width: 60px;"><div>${data['75']}</div></td>
		<td style="width: 60px;"><div>${data['76']}</div></td>
		<td style="width: 60px;"><div>${data['77']}</div></td>
		<td style="width: 60px;"><div>${data['78']}</div></td> --%>
		
		<td style="width: 60px;"><div>${data['79']}</div></td>
		<td style="width: 60px;"><div>${data['80']}</div></td>
		<td style="width: 60px;"><div>${data['81']}</div></td>
		<td style="width: 60px;"><div>${data['82']}</div></td>
		<td style="width: 60px;"><div>${data['83']}</div></td>
		<td style="width: 60px;"><div>${data['84']}</div></td>
	</tr>
	</c:forEach>

	</tbody>
	<tfoot>
	<tr>
		<td></td>
		<td>Avgy</td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<!-- <td>LAl</td> -->
		<td>0.0</td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
<!--		<td></td>
 		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td> -->
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
<!-- 		Code Starts From Here Done By Roshan Tailor Date :- 03/21/2016 -->
		<td></td>
		<!-- <td></td> -->
		<!-- <td></td> -->
<!-- 		Code Ends Here Done By Roshan Tailor Date :- 03/21/2016 -->
		</tr>
		
		
		<tr>
		<td></td>
		<td>Total</td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<!-- <td>Tailor</td> -->
		<td>0.0</td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
<!-- 		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td> -->
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<!-- <td></td> -->
<!-- 		Code Starts From Here Done By Roshan Tailor Date :- 03/21/2016 -->
		<td></td>
		<td></td>
		<!-- <td></td> -->
<!-- 		Code Ends Here Done By Roshan Tailor Date :- 03/21/2016 -->
		
		</tr>
	</tfoot>
	
	</table>
</c:if>
	<c:if test="${fn:length(datas) eq 0 }">
		<div style="text-align: center;"><span>Data not available for this selection.</span></div>
	</c:if>
</div>

<script type="text/javascript">
	$(function(){
		var row=$('#masterTable tbody tr').length;
		var col=$('#masterTable tbody tr:nth-child(1) td').length;
		
		var totalSteam=0;
		var totalGalon=0;
		var prodWhite=0;
		var prodRed=0;
		var avgcons150lbs=0;
		var naturalGasFlow=0;
		var millWaterT=0;
		var enrgy150Steam=0;
		var enrgyNaturalGas=0;
		var enrgyElectrical=0;
		var enrgyElectricalT=0;
		var dscFrpProduction=0;
		var dscWastePaperfeed=0;

		
		if(row){
			
			for(var c=0;c<col;c++){
				var total=0;
				
				for(var r=0;r<row;r++){
				
					
					var txt=$('#masterTable tbody tr:eq('+r+')').find('td:eq('+c+')').text();
					perc=txt.indexOf('%');
					txt=txt.replace('%','');
					if($.isNumeric( txt )){
						total+=parseFloat(txt);
					}
				}
				if(total!=0){
					if(c==0|c==1){
						//No Query
					}else{
						var avg=total/row;
						if(c!==0
							& c!==15
							& c!==20
							& c!==26
							& c!==29
							& c!==37
							& c!==43
							& c!==44
							& c!==47
							& c!==48
							& c!==49
							& c!==51
							& c!==54
							& c!==55
							& c!==58
							& c!==59
							& c!==61
							& c!==67
							& c!==68
							& c!==73
							& c!==76
							& c!==77
							& c!==78
							& c!==79
							& c!==80
							& c!==81
							& c!==82
							& c!==19){
							$('#masterTable tfoot tr:eq(0)').find('td:eq('+c+')').text(avg.toFixed(2));	
						}
						if(c!==2 
								& c!==13 
								& c!==15
								& c!==16
								& c!==18
								& c!==19
								& c!==24
								& c!==26
								& c!==27
								
								& c!==29
								& c!==30
								& c!==31
								& c!==32
								& c!==33
								& c!==34
								& c!==43
								& c!==45
								& c!==62
							//	& c!==67
								& c!==68
								& c!==71
								& c!==72
								& c!==73
								& c!==74
								& c!==75
								& c!==65
								& c!==66
								& c!==69
								& c!==22){
							$('#masterTable tfoot tr:eq(1)').find('td:eq('+c+')').text(total.toFixed(2));
							
							
						}
						
					}
					
					
					if(c==71){
						totalSteam=total;
					}else if(c==72){
						totalGalon=total;
					}else if(c==9){
						prodWhite=total;
					
					}else if(c==10){
						prodRed=total;
					}else if(c==17){
						avgcons150lbs=total;
		
					}else if(c==19){
						$('#masterTable tfoot tr:eq(0)').find('td:eq('+c+')').text((avgcons150lbs/(prodWhite+prodRed)).toFixed(2));	
		
					}else if(c==21){
						naturalGasFlow=total;
					}else if(c==22){
						$('#masterTable tfoot tr:eq(0)').find('td:eq('+c+')').text((naturalGasFlow/(prodWhite+prodRed)).toFixed(2));	
					}else if(c==23){
						millWaterT=total;
					}else if(c==24){
						$('#masterTable tfoot tr:eq(0)').find('td:eq('+c+')').text(((millWaterT*1000000)/(prodWhite+prodRed)).toFixed(2));	
		
					}else if(c==66){
						enrgy150Steam=avg;
						
					}else if(c==67){
						enrgyNaturalGas=avg;
					}else if(c==68){
						enrgyElectrical=total;
					}else if(c==69){
						enrgyElectricalT=enrgyElectrical/(prodWhite+prodRed);
						$('#masterTable tfoot tr:eq(0)').find('td:eq('+c+')').text((enrgyElectricalT).toFixed(2));	
					}else if(c==70){
						$('#masterTable tfoot tr:eq(0)').find('td:eq('+c+')').text((enrgyElectricalT+enrgyNaturalGas+enrgy150Steam).toFixed(2));	
					}else if(c==43){
						//$('#masterTable tfoot tr:eq(0)').find('td:eq('+c+')').text((enrgyElectricalT+enrgyNaturalGas+enrgy150Steam).toFixed(2));
						dscFrpProduction=total;
					}else if(c==44){
						//$('#masterTable tfoot tr:eq(0)').find('td:eq('+c+')').text((enrgyElectricalT+enrgyNaturalGas+enrgy150Steam).toFixed(2));
						dscWastePaperfeed=total;
					}else if(c==45){
						$('#masterTable tfoot tr:eq(0)').find('td:eq('+c+')').text((dscFrpProduction/dscWastePaperfeed*100).toFixed(2));
					}
					
					
				}

				
			}
		}
		
		
		
	//	var efficienyPerc=0;
		/* if(totalSteam!=0){
			efficienyPerc=(totalGalon*8.33/totalSteam/1000)*100;
		}
		$('#masterTable tfoot tr:eq(1)').find('td:eq(74)').text(efficienyPerc.toFixed(2)); */
	});

</script>

</div>				

