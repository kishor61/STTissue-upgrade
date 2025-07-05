<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>


<spring:url value="/pm5utilitykpimaster/deleteutility"  var="deleteUrl"/>
<spring:url value="/pm5utilitykpimaster/edit"  var="editUrl"/>
<script type="text/javascript">
	$(function(){
		//utilityTable
		
		$('#deleteRowBtn').click(function(){
			var rowCount = $('#utilityTable tbody tr').length;
			if(rowCount==1){
				alert("You can't delete first row.");
				return;
			}
			var dbtn=$(this);
			var val=$('#utilityTable tbody input[name=id]:checked').val();
			if(typeof val==='undefined'){
				alert('Select row');
			}else{
				if(val==''){
					$('#utilityTable tbody input[name=id]:checked').parent().parent().remove();
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
			var val=$('#utilityTable tbody input[name=id]:checked').val();
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
<spring:url value="/pm5utilitykpimasterreport/exportutility" var="exportDataURL"/>
<form id="exportForm" action="${exportDataURL}" method="post" target="_blank">
<input type="hidden" name="sdate" value="${sdate}">
<input type="hidden" name="edate" value="${edate }">
<input type="hidden" name="type" value="${page }">

</form>


<table id="utilityTable" class="table" style="width: 900px; margin: auto;font-size: 12px;">
	<thead>
		<tr>
			<th style="width: 10px;"></th>
			<th>Date</th>
			<th>Time</th>
			<!-- <th>60 lb</th> -->
			<th><!-- Consumption <br>lbs -->60lb Steam <br /> lbs</th>
			<!-- <th>150 lb <br>lbs</th> -->
			<th><!-- Consumption<br>lbs -->150 lb Steam <br /> lbs</th>
			<!-- <th>Mill water<br>Gallons</th> -->
			<th><!-- Consumption<br>Gallons -->Mill water <br /> M gal</th>
		<!-- 	<th>Condensate</th> -->
			<th><!-- Consumption -->Condensate <br /> gal</th>
			<th>River water <br /> M gal</th>
			<th>River water temp <br /> deg F</th>
		</tr>
	</thead>
	<tbody>
	
	<c:if test="${fn:length(datas) eq 0 }">
		<tr>
			<td colspan="10"></td>
			
		</tr>
	</c:if>	
	
	<c:if test="${fn:length(datas)>0 }">
		<c:forEach items="${datas}" var="data">
			<tr>
				<td><input type="radio" name="id" value="${data['1']}"> </td>
				<td style="width: 80px;"><div>${data['2']}</div></td>
				<td style="width: 90px;"><div>${data['3']}</div></td>
				<%-- <td style="width: 90px;"><div>${data['4']}</div></td> --%>
				<td style="width: 90px;"><div>${data['5']}</div></td>
				<%-- <td style="width: 90px;"><div>${data['6']}</div></td> --%>
				<td style="width: 90px;"><div>${data['7']}</div></td>
				<%-- <td style="width: 90px;"><div>${data['8']}</div></td> --%>
				<td style="width: 90px;"><div>${data['9']}</div></td>
				<%-- <td style="width: 90px;"><div>${data['10']}</div></td> --%>
				<td style="width: 90px;"><div>${data['11']}</div></td>
				<td style="width: 90px;"><div>${data['13']}</div></td>
				<td style="width: 90px;"><div>${data['12']}</div></td>
			</tr>
		</c:forEach>
	</c:if>
	
	</tbody>
</table>
</div>				

