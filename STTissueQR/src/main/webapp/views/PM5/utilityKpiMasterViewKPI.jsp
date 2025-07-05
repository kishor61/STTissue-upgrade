<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>


<spring:url value="/pm5utilitykpimaster/edit"  var="editUrl"/>



<script type="text/javascript">

	$(function(){
		
	
		$('#deleteRowBtn').click(function(){
			var rowCount = $('#kpiTable tbody tr').length;
			if(rowCount==1){
				alert("You can't delete first row.");
				return;
			}
			var dbtn=$(this);
			var val=$('#kpiTable tbody input[name=id]:checked').val();
			if(typeof val==='undefined'){
				alert('Select row');
			}else{
				if(val==''){
					$('#kpiTable tbody input[name=id]:checked').parent().parent().remove();
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
			var val=$('#kpiTable tbody input[name=id]:checked').val();
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

<spring:url value="/pm5utilitykpimasterreport/kpiemail"  var="kpiemailURL"/>
<script type="text/javascript">
	$(function(){
		$('#sendMailBtn').click(function(){
			var btn=$(this);
			if(confirm('Do you want to send Daily KPI report?')){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${kpiemailURL}',
					type: 'POST',
					success : function(data){
						if(data){
							$('#tmessage').text('Mail sent successfully.');
						}else{
							$('#tmessage').text('Failure to send email. Please contact to administrator.');
						}
						btn=btn.prop('disabled',false);
						setTimeout(function(){
							$('#tmessage').text('');
						}, 5000);
					}
				});
			}
			
		});
	});
</script>

<spring:url value="/pm5utilitykpimasterreport/exportkpi" var="exportDataURL"/>
<form id="exportForm" action="${exportDataURL}" method="post"  target="_blank">
<input type="hidden" name="sdate" value="${sdate}">
<input type="hidden" name="edate" value="${edate }">
<input type="hidden" name="type" value="${page}">

</form>

<div style="right: 10px; overflow: auto; position: absolute; bottom: 0; top: 110px; left: 10px;">
<c:if test="${fn:length(datas) > 0 }">

<c:set value="${0}" var="downTime"/>

<table id="kpiTable" class="table" style="width: auto;; margin: auto; font-size: 12px;">
	<thead>
		<tr>
			<th class="trobjrow" colspan="11">DAILY KPI's</th>
			<th class="trobjrow" colspan="6">Last Recordable:</th>
			<th  class="trobjrow" colspan="4" >${lrdate}</th>
			<th  class="trobjrow" colspan="4">Days since Last Recordable</th>
			<th  class="trobjrow" >${lrdays}</th>
			<th  class="trobjrow" >Date</th>
			<th  class="trobjrow" colspan="2">${lrcdate}</th>
		</tr>
		
		<tr><th rowspan="3">Date</th>
			<th colspan="2">Machine Production</th>
			<th colspan="4">Wrapper Production</th>
			<th colspan="4">Efficiency</th>
			<th  colspan="2">Mill water</th>
			<th  colspan="2">River water</th>
			<th  colspan="1" rowspan="2">Total Water<br />Consumption</th>
			<th colspan="4">Fiberloss</th>
			
			
			<th colspan="3">Energy Consumption</th>
			
			<!-- <th rowspan="2">60# Steam</th>
			
			<th rowspan="2">150# Steam</th>
			
			<th rowspan="2">Gas Flow</th>-->
			
			<th rowspan="2">Cond Recovery</th> 
			
			<th colspan="5">Energy Consumption</th>				
			
			
		</tr>
		<tr>
			<th>Actual</th>
			<th>Slaboff</th>
			
			<th>White</th>
			<th>Red</th>
			<th>Reject</th>
			<th>Total</th>
			
			<th>Uptime</th>
			<th>Quality</th>
			<th>Yield</th>
			<th>Total</th>
			
			
			<th>Total</th>
			<th>Specific</th>
			<th>Total</th>
			<th>Specific</th>
			
			
			
			
			<th>TM Sewer</th>
			<!-- <th>FRP</th> -->
			<th>FRP Effluent</th>
			<th>Total</th>
			<th>COD Discharge</th>			
			
			<th>60 #Steam</th>
			<th>150 #Steam</th>
			<th>Natural Gas</th>
			
			
			
			<th>60#</th>
			<th>150#</th>
			<th>Gas</th>
			<th>Elect</th>
			<th>Total</th>
			
		</tr>
		<tr>
			<th colspan="6">Tons</th>
			<th colspan="4">%</th>
			
			<th>M Gal</th>
			<th>Gal/T</th>
			<th>M Gal</th>
			<th>Gal/T</th>
			<th>Gal/T</th>
			
			
			
			<th colspan="3">T/day</th>
			
			<th>lbs/day</th>
			
			<th>lbs/T</th>
			
			<th>lbs/T</th>
			
			<th>Kscf/T</th>
			
			<th>%</th>
			<th colspan="5">kW/T</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${datas}" var="data">
		<tr>
			<td style="width: 80px;"><div>${data['1']}</div></td>
			<td style="width: 60px;"><div>${data['2']}</div></td>
			<td style="width: 60px;"><div>${data['3']}</div></td>
			<td style="width: 60px;"><div>${data['4']}</div></td>
			<td style="width: 60px;"><div>${data['5']}</div></td>
			<td style="width: 60px;"><div>${data['6']}</div></td>
			<td style="width: 60px;"><div>${data['7']}</div></td>
			<td style="width: 60px;"><div>${data['8']}%</div></td>
			<td style="width: 60px;"><div>${data['9']}%</div></td>
			<td style="width: 60px;"><div>${data['10']}%</div></td>
			<td style="width: 60px;"><div>${data['11']}%</div></td>
			<td style="width: 60px;"><div>${data['27']}</div></td>
			<td style="width: 60px;"><div>${data['12']}</div></td>
			
			<td style="width: 60px;"><div>${data['31']}</div></td>
			<td style="width: 60px;"><div>${data['32']}</div></td>
			
			<td style="width: 60px;"><div><fmt:formatNumber type="number" maxFractionDigits="0" value="${data['12']+data['32']}" /></div></td>
			
			<td style="width: 60px;"><div>${data['13']}</div></td>
			<%-- <td style="width: 60px;"><div>${data['14']}</div></td> --%>
			<td style="width: 60px;"><div>${data['30']}</div></td>
			
			<%-- <fmt:parseNumber var="i" type="number" value="${data['30']+data['13']}" maxFractionDigits="2"/> --%>
			
			 <fmt:formatNumber var="i" type="number" maxFractionDigits="5" value="${data['30']+data['13']}" />
			
			
			<td style="width: 60px;"><div>${i}</div></td>
			
			<td style="width: 60px;"><div>${data['33']}</div></td> <!-- COD -->
			<td style="width: 60px;"><div>${data['15']}</div></td>
			<td style="width: 60px;"><div>${data['16']}</div></td>
			<td style="width: 60px;"><div>${data['17']}</div></td>
			<td style="width: 60px;"><div>${data['18']}%</div></td>
			<td style="width: 60px;"><div>${data['19']}</div></td>
			<td style="width: 60px;"><div>${data['20']}</div></td>
			<td style="width: 60px;"><div>${data['21']}</div></td>
			<td style="width: 60px;"><div>${data['22']}</div></td>
			<td style="width: 60px;"><div>${data['23']}</div></td>
		</tr>	
		<c:set var="downTime" value="${downTime + data['24']}" />
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td>Avg/Day</td>
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
		</tr>
		<tr>
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
			<td></td>
			<td></td>
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
		var row=$('#kpiTable tbody tr').length | 0;
		var col=$('#kpiTable tbody tr:nth-child(1) td').length;
		
		var totalDowntime=parseInt('${downTime}', 10) | 0;
		var whiteTons=0;
		var wrapTotal=0;
		var machineTotal=0;
		var tMSewer = 0
		var FRPEffluent = 0
		var TotalWaterConsumption = 0
		if(row){
			
			for(var c=0;c<col;c++){
				var total=0;
				var perc=-1;
				for(var r=0;r<row;r++){
				
					
					var txt=$('#kpiTable tbody tr:eq('+r+')').find('td:eq('+c+')').text();
					perc=txt.indexOf('%');
					txt=txt.replace('%','');
					if($.isNumeric( txt )){
						total+=parseFloat(txt);
					}
				}
				if(total!=0){
					if(c==0 | c==7 | c==8 | c==9 | c==10){
						//No Query
					}else{
						var avg=total/row;
						$('#kpiTable tfoot tr:eq(0)').find('td:eq('+c+')').text(avg.toFixed(2));
						
						if(perc==-1 & c!==11 &!(c>=14)){
							$('#kpiTable tfoot tr:eq(1)').find('td:eq('+c+')').text(total.toFixed(2));	
						}
						
						if(c==3){
							whiteTons=total;
						}
						
						if(c==6){
							wrapTotal=total;
						}
						
						if(c==1){
							machineTotal=total;
						}
						if(c==15)
						{
							TotalWaterConsumption = total;
						}
						if(c==16)
						{
						 tMSewer = total;
						}
						if(c==17)
						{
						 FRPEffluent = total;
						}
						
						
					}
				}
						
				
			}
		}
		
		var uptime=0;
		if(row>0){
			uptime=((1440*row)-totalDowntime)/(1440*row);
		}
		var yield=0;
		if(machineTotal!=0){
			yield=(wrapTotal/machineTotal);
		}
		var quality=0;
		if(wrapTotal!=0){
			quality=(whiteTons/wrapTotal);
		}
		
		var efficiency=(uptime*quality*yield);
			
		
		$('#kpiTable tfoot tr:eq(1)').find('td:eq(7)').text((uptime*100).toFixed(2));
		$('#kpiTable tfoot tr:eq(1)').find('td:eq(8)').text((quality*100).toFixed(2));
		$('#kpiTable tfoot tr:eq(1)').find('td:eq(9)').text((yield*100).toFixed(2));
		$('#kpiTable tfoot tr:eq(1)').find('td:eq(10)').text((efficiency*100).toFixed(2));
		
		$('#kpiTable tfoot tr:eq(1)').find('td:eq(15)').text((TotalWaterConsumption).toFixed(0));
		$('#kpiTable tfoot tr:eq(1)').find('td:eq(16)').text((tMSewer).toFixed(2));
		$('#kpiTable tfoot tr:eq(1)').find('td:eq(17)').text((FRPEffluent).toFixed(2)); 
		
	});

</script>

</div>				

