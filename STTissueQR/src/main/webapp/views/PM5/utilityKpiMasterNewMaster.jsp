<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>

<spring:url value="/pm5utilitykpimaster/savemaster"  var="saveUrl"/>
<spring:url value="/pm5utilitykpimaster/deletemaster"  var="deleteUrl"/>

<script type="text/javascript">
var centerlineGrades=${centerlineGrades};
var currentVal='';
var saveLock;
var clearTimer;


	$(function(){
		$('input[name=date]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true,
			onClose:function(){
				$(this).parent().next().children().focus();
			}
		});
		
		$('#masterTable tbody input').focusin(doFocusIn);
		$('#masterTable tbody input').focusout(doFocusOut);
		
		$('#masterTable tbody input[name=tissueGrade]').autocomplete({
			minLength: 1,
	        source: function( request, response ) {
	          response( $.ui.autocomplete.filter(
	        	 centerlineGrades, extractLast( request.term ) ) );
	        },
	        focus: function() {
	          return false;
	        },
	        select: function( event, ui ) {
	          var terms = split( this.value );
	          terms.pop();
	          terms.push( ui.item.value );
	          terms.push( "" );
	          this.value = terms.join( ", " );
	          return false;
	        }
	    });
		
		//masterTable
		$('#addRowBtn').click(function(){
			var otr = $('#masterTable tbody tr:last');
			var odate=otr.find('input[name=date]').val();
			var tr = $('#masterTable tbody tr:last').clone();
			
			var ntr = tr.appendTo($('#masterTable tbody'));
			
			ntr.find('input').val('');
			ntr.find('input[name=date]').removeAttr('id');
			ntr.find('input[name=date]').removeAttr('class');
			ntr.find('input[name=date]').datepicker({
				dateFormat : 'mm-dd-yy',
				changeMonth : true,
				changeYear : true,
				onClose:function(){
					$(this).parent().next().children().focus();
				}
			});
			
			
			ntr.find('input[name=tissueGrade]').removeAttr('id');
			ntr.find('input[name=tissueGrade]').removeAttr('class');
			ntr.find('input[name=tissueGrade]').autocomplete({
				minLength: 1,
		        source: function( request, response ) {
		          response( $.ui.autocomplete.filter(
		        	 centerlineGrades, extractLast( request.term ) ) );
		        },
		        focus: function() {
		          return false;
		        },
		        select: function( event, ui ) {
		          var terms = split( this.value );
		          terms.pop();
		          terms.push( ui.item.value );
		          terms.push( "" );
		          this.value = terms.join( ", " );
		          return false;
		        }
		    });
			
			var date=new Date(odate);
			date.setDate(date.getDate()+1);
			ntr.find('input[name=date]').datepicker('setDate',date);
			ntr.find('input[name=avgThp]').focus();
			ntr.find('input').focusin(doFocusIn);
			ntr.find('input').focusout(doFocusOut);
		});
		
		
		$('#deleteRowBtn').click(function(){
			/* var rowCount = $('#masterTable tbody tr').length;
			if(rowCount==1){
				currentVal='';
				alert("You can't delete first row.");
				return;
			} */
			var dbtn=$(this);
			var val=$('#masterTable tbody input[name=id]:checked').val();
			if(typeof val==='undefined'){
				alert('Select row');
			}else{
				if(val==''){
					$('#masterTable tbody input[name=id]:checked').parent().parent().remove();
					location.reload(true);
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
		
	});
function split( val ) {
      return val.split( /,\s*/ );
}
function extractLast( term ) {
	  return split( term ).pop();
}	
function doFocusIn(){
	currentVal=$(this).val();
}
function doFocusOut(){
	if(validatePQ($(this))){
		return;
	}
	
	if($(this).val()==currentVal){
		return;
	}
	
	saveData($(this));
}
function saveData(jq){
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');
	
	var date=tr.find('input[name=date]').val();
	var avgThp=tr.find('input[name=avgThp]').val();
	
	/* var prodBlead=tr.find('input[name=prodBlead]').val(); */
	/* var prodKraft=tr.find('input[name=prodKraft]').val(); */
	/* var prodSlabOff=tr.find('input[name=prodSlabOff]').val();
	var prodWrapBlead=tr.find('input[name=prodWrapBlead]').val(); */
	/* var prodProdWhite=tr.find('input[name=prodProdWhite]').val();
	var prodProdRed=tr.find('input[name=prodProdRed]').val();
	var prodProdReject=tr.find('input[name=prodProdReject]').val(); */
	
	var prodKraft=0;
	var prodBlead=0;
	var prodWrapBlead=0;
	var prodSlabOff=0;
	var prodProdWhite=0;
	var prodProdRed=0;
	var prodProdReject=0;
	
	var naturalGasFlow=tr.find('input[name=naturalGasFlow]').val();
	var fiberLossSewerFlow=tr.find('input[name=fiberLossSewerFlow]').val();
	var fiberLossSfConsy=tr.find('input[name=fiberLossSfConsy]').val();
	var fiberLossWwToFrp=tr.find('input[name=fiberLossWwToFrp]').val();
	var fiberLossWfFlow=tr.find('input[name=fiberLossWfFlow]').val();
	/* var pulpWlap=tr.find('input[name=pulpWlap]').val(); */
	 var pulpWlap=0;
	var energyElectrical=tr.find('input[name=energyElectrical]').val();
	var pulpDataFromFrp=tr.find('input[name=pulpDataFromFrp]').val();
	var pulpConsumedFromHd=tr.find('input[name=pulpConsumedFromHd]').val();
	var pulpDataProdDcs=tr.find('input[name=pulpDataProdDcs]').val();
	var pulpDataHdLevel=tr.find('input[name=pulpDataHdLevel]').val();
	var pulpInHd=tr.find('input[name=pulpInHd]').val();
	var tissueGrade=tr.find('input[name=tissueGrade]').val();
	
	var chemWetStrength=tr.find('input[name=chemWetStrength]').val();
	var chemRelease=tr.find('input[name=chemRelease]').val();
	var chemAdhesive=tr.find('input[name=chemAdhesive]').val();
	var chemMap=tr.find('input[name=chemMap]').val();
	var chemDefoamer=tr.find('input[name=chemDefoamer]').val();
	var chemPassivator=tr.find('input[name=chemPassivator]').val();
	var coddischarge=tr.find('input[name=coddischarge]').val();
	
	
	
	if(saveLock){
		return;
	}
	
	saveLock=true;
	
	$.ajax({
		url:'${saveUrl}',
		type:'POST',
		data:{
			id : id,
			date : date,
			avgThp : avgThp,
			prodBlead : prodBlead,
			prodKraft : prodKraft,
			prodSlabOff : prodSlabOff,
			prodWrapBlead : prodWrapBlead,
			prodProdWhite : prodProdWhite,
			prodProdRed : prodProdRed,
			prodProdReject : prodProdReject,
			naturalGasFlow : naturalGasFlow,
			fiberLossSewerFlow : fiberLossSewerFlow,
			fiberLossSfConsy : fiberLossSfConsy,
			fiberLossWwToFrp : fiberLossWwToFrp,
			fiberLossWfFlow : fiberLossWfFlow,
			pulpWlap : pulpWlap,
			energyElectrical : energyElectrical,
			pulpDataFromFrp : pulpDataFromFrp,
			pulpConsumedFromHd : pulpConsumedFromHd,
			pulpDataProdDcs : pulpDataProdDcs,
			pulpDataHdLevel : pulpDataHdLevel,
			pulpInHd:pulpInHd,
			tissueGrade : tissueGrade,
			chemWetStrength :chemWetStrength,
			chemRelease :chemRelease,
			chemAdhesive :chemAdhesive,
			chemMap :chemMap,
			chemDefoamer :chemDefoamer,
			chemPassivator :chemPassivator,
			coddischarge :coddischarge
		},
		success:function(data){
			if(data.status){
				idEle.val(data.id);
				$('#tmessage').text(data.message);
				clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
				
			}else{
				alert(data.error);
			}
			saveLock=false;
		},
		error: function(xhr, status, error) {
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});
}

function validatePQ(tb){
	if($.trim(tb.val())!=''){
		if( (tb.attr('name')=='date') |
			(tb.attr('name')=='tissueGrade')
			){
			saveLock=false;
			return false;
		}else if(isNaN(tb.val())){
			alert('Enter a valid number.');
			setTimeout(function(){tb.focus();}, 10);
			saveLock=true;
			return true;
		}
	}
	saveLock=false;
	return false;
}
</script>

<div style="right: 10px; overflow: auto; position: absolute; bottom: 0; top: 110px; left: 10px;">

<table id="masterTable" class="table" style="width: auto;; margin: auto; font-size: 12px;">
	<thead>
		<tr>
			<th rowspan="3" style="width: 10px;"></th>
			<th rowspan="3">Date</th>
			<th rowspan="3">Average<br>Throughput (TPH)</th>
			<!-- <th colspan="2">Production</th> -->
			<th rowspan="3">Tissue grade</th>
			<th>Natural<br>Gas</th>
			<th colspan="5">Paper mill <br />fiber loss</th>
			<!-- <th>Pulp<br>(Calculated)</th> -->
			<th>PM #6<br>Energy<br>Data
			</th>
			<!-- <th colspan="5">PM #6 &#38; FRP Pulp Utilization</th> -->
			<th colspan="7">Chemical</th>
		</tr>
		<tr>
			<!-- <th>Blea'd</th>
			<th>Kraft</th> -->
			<!-- <th>Slab off</th>
			<th>Wrapper</th> -->
			<!-- <th colspan="3">Production</th> -->
			<th>Gas flow</th>
			<th>Sewer<br>flow</th>
			<th>Consy</th>
			<th>COD Discharge</th>
			<th>WW to FRP</th>
			<th>Consy</th>
			<!-- <th>W Lap</th> -->
			<th>Electrical</th>
			<!-- <th>Pulp from FRP</th>
			<th>M/c consumed <br>from HD Chest</th>
			<th>M/c prod DCS</th>
			<th>HD Level @ <br>8:00 AM</th>
			<th>HD In HD @ <br>8:00 AM</th> -->
			
			<th>Wet strength</th>
			<th>Release</th>
			<th>Adhesive</th>
			<th>MAP</th>
			<th>Defoamer</th>
			<th>Passivator</th>
		
			
		</tr>
		<tr class="subtr">
			<!-- <th>T/day</th>
			<th>T/day</th> -->
			<!-- <th>At Reel</th>
			<th>Ble'd</th> -->
			<!-- <th>White</th>
			<th>Red</th>
			<th>Reject</th> -->
			<th>Kscf</th>
			<th>M Gal</th>
			<th>%</th>
			<th>mg/L</th>
			<th>M gal<!-- Consy --></th>
			<th>%</th>
			<!-- <th>AD T/day</th> -->
			<th>kWh</th>
			<!-- <th>Tons</th>
			<th>Tons</th>
			<th>Tons</th>
			<th>%</th>
			<th>Tons</th> -->
			
			<th>Gallons</th>
			<th>Liter</th>
			<th>Liter</th>
			<th>Liter</th>
			<th>Liter</th>
			<th>Liter</th>
			
		</tr>
	</thead>
	<tbody>

<c:if test="${fn:length(masterDatas) eq 0 }">
	<tr>
		<td><input type="radio" name="id" value=""></td>
		<td style="width: 80px;"><input readonly="readonly" type="text" name="date" value="${date}"></td>
		<td style="width: 80px;"><input type="text" name="avgThp" value=""></td>
		<!-- <td style="width: 80px;"><input type="text" name="prodBlead" value=""></td>
		<td style="width: 80px;"><input type="text" name="prodKraft" value=""></td> -->
		<!-- <td style="width: 80px;"><input type="text" name="prodSlabOff" value=""></td>
		<td style="width: 80px;"><input type="text" name="prodWrapBlead" value=""></td> -->
		<!-- <td style="width: 80px;"><input type="text" name="prodProdWhite" value=""></td>
		<td style="width: 80px;"><input type="text" name="prodProdRed" value=""></td>
		<td style="width: 80px;"><input type="text" name="prodProdReject" value=""></td> -->
		<td style="width: 200px;"><input type="text" name="tissueGrade" value=""></td>
		<td style="width: 80px;"><input type="text" name="naturalGasFlow" value=""></td>
		<td style="width: 80px;"><input type="text" name="fiberLossSewerFlow" value=""></td>
		<td style="width: 80px;"><input type="text" name="fiberLossSfConsy" value=""></td>
		<td style="width: 80px;"><input type="text" name="coddischarge" value=""></td>
		<td style="width: 80px;"><input type="text" name="fiberLossWwToFrp" value=""></td>
		<td style="width: 80px;"><input type="text" name="fiberLossWfFlow" value=""></td>
		<!-- <td style="width: 80px;"><input type="text" name="pulpWlap" value=""></td> -->
		<td style="width: 80px;"><input type="text" name="energyElectrical" value=""></td>
		<!-- <td style="width: 80px;"><input type="text" name="pulpDataFromFrp" value=""></td>
		<td style="width: 80px;"><input type="text" name="pulpConsumedFromHd" value=""></td>
		<td style="width: 80px;"><input type="text" name="pulpDataProdDcs" value=""></td>
		<td style="width: 80px;"><input type="text" name="pulpDataHdLevel" value=""></td>
		<td style="width: 80px;"><input type="text" name="pulpInHd" value=""></td> -->
		
		<td style="width: 80px;"><input type="text" name="chemWetStrength" value=""></td>
		<td style="width: 80px;"><input type="text" name="chemRelease" value=""></td>
		<td style="width: 80px;"><input type="text" name="chemAdhesive" value=""></td>
		<td style="width: 80px;"><input type="text" name="chemMap" value=""></td>
		<td style="width: 80px;"><input type="text" name="chemDefoamer" value=""></td>
		<td style="width: 80px;"><input type="text" name="chemPassivator" value=""></td>
		
	</tr>

</c:if>

<c:if test="${fn:length(masterDatas)>0 }">
	<c:forEach items="${masterDatas}" var="data">
	<fmt:formatDate value="${data.date}" pattern="MM-dd-yyyy" var="fdate"/>
	<tr>
		<td><input type="radio" name="id" value="${data.id}"></td>
		<td style="width: 80px;"><input readonly="readonly" type="text" name="date" value="${fdate}"></td>
		<td style="width: 80px;"><input type="text" name="avgThp" value="${data.avgThp}"></td>
		<%-- <td style="width: 80px;"><input type="text" name="prodBlead" value="${data.prodBlead}"></td>
		<td style="width: 80px;"><input type="text" name="prodKraft" value="${data.prodKraft}"></td> --%>
		<%-- <td style="width: 80px;"><input type="text" name="prodSlabOff" value="${data.prodSlabOff}"></td>
		<td style="width: 80px;"><input type="text" name="prodWrapBlead" value="${data.prodWrapBlead}"></td> --%>
		<%-- <td style="width: 80px;"><input type="text" name="prodProdWhite" value="${data.prodProdWhite}"></td>
		<td style="width: 80px;"><input type="text" name="prodProdRed" value="${data.prodProdRed}"></td>
		<td style="width: 80px;"><input type="text" name="prodProdReject" value="${data.prodProdReject}"></td> --%>
		<td style="width: 200px;"><input type="text" name="tissueGrade" value="${data.tissueGrade}"></td>
		<td style="width: 80px;"><input type="text" name="naturalGasFlow" value="${data.naturalGasFlow}"></td>
		<td style="width: 80px;"><input type="text" name="fiberLossSewerFlow" value="${data.fiberLossSewerFlow}"></td>
		<td style="width: 80px;"><input type="text" name="fiberLossSfConsy" value="${data.fiberLossSfConsy}"></td>
		<td style="width: 80px;"><input type="text" name="coddischarge" value="${data.coddischarge}"></td>
		<td style="width: 80px;"><input type="text" name="fiberLossWwToFrp" value="${data.fiberLossWwToFrp}"></td>
		<td style="width: 80px;"><input type="text" name="fiberLossWfFlow" value="${data.fiberLossWfFlow}"></td>
		<%-- <td style="width: 80px;"><input type="text" name="pulpWlap" value="${data.pulpWlap}"></td> --%>
		<td style="width: 80px;"><input type="text" name="energyElectrical" value="${data.energyElectrical}"></td>
		<%-- <td style="width: 80px;"><input type="text" name="pulpDataFromFrp" value="${data.pulpDataFromFrp}"></td>
		<td style="width: 80px;"><input type="text" name="pulpConsumedFromHd" value="${data.pulpConsumedFromHd}"></td>
		<td style="width: 80px;"><input type="text" name="pulpDataProdDcs" value="${data.pulpDataProdDcs}"></td>
		<td style="width: 80px;"><input type="text" name="pulpDataHdLevel" value="${data.pulpDataHdLevel}"></td>
		<td style="width: 80px;"><input type="text" name="pulpInHd" value="${data.pulpInHd}"></td> --%>
		
		<td style="width: 80px;"><input type="text" name="chemWetStrength" value="${data.chemWetStrength}"></td>
		<td style="width: 80px;"><input type="text" name="chemRelease" value="${data.chemRelease}"></td>
		<td style="width: 80px;"><input type="text" name="chemAdhesive" value="${data.chemAdhesive}"></td>
		<td style="width: 80px;"><input type="text" name="chemMap" value="${data.chemMap}"></td>
		<td style="width: 80px;"><input type="text" name="chemDefoamer" value="${data.chemDefoamer}"></td>
		<td style="width: 80px;"><input type="text" name="chemPassivator" value="${data.chemPassivator}"></td>
	
	</tr>
	</c:forEach>
</c:if>

		</tbody>
	</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>	
</div>

</div>				

