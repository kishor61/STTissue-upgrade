<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>
<spring:url value="/utilitykpimaster/savekpidate"  var="saveURL"/>
<spring:url value="/utilitykpimaster/deletekpirecordabledate"  var="deleteURL"/>

<script type="text/javascript">
	$(function(){
		$('input[name=date]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
		$('#saveBtn').click(function(){
			var date=$('#kpiRdTable input[name=date]').val();
			var remarks=$('#kpiRdTable textarea[name=remarks]').val();
			
			if(date==''){
				return;
			}
			
			var btn=$(this);
			btn.attr('disabled','disabled');
			
			$.ajax({
				url:'${saveURL}',
				type:'POST',
				data:{
					date : date,
					remarks :remarks
				},
				success: function(data){
					if(data.status){
						alert('Data saved successfully.');
						location.reload(true);
					}else{
						alert(data.error);
						btn.removeAttr('disabled');
					}
				},
				error: function(xhr, status, error) {
					alert('Fail to save data in database.' );
					location.reload(true);
				}
			});
			
		});
		
		
		$('[id^=delete_]').click(function(){
			var id=$(this).attr('data-id');
			$.ajax({
				url:'${deleteURL}',
				type:'POST',
				data:{
					id :id
				},
				success: function(data){
					if(data.status){
						alert('Data removed successfully.');
						location.reload(true);
					}else{
						alert(data.error);
					}
				},
				error: function(xhr, status, error) {
					alert('Fail to delete data from database.' );
					location.reload(true);
				}
			});
			
		});
		
	});
	
	
</script>


<table id="kpiRdTable" style="margin: auto;">
	<tr>
		<td>Last Recordable:</td>
		<td><input type="text" name="date" readonly="readonly" style="width: 100px;" value="${date}"> </td>
		<td>Remarks:</td>
		<td><textarea style="width: 200px; height: 18px;" name="remarks"></textarea> </td>
		<td>
			<button id="saveBtn">Save</button>
			&nbsp;&nbsp;
			<spring:url value="/utilitykpimasterreport/view" var="viewReportURL"/>
			<button onclick="location.href='${viewReportURL}'">View KPI Report</button>
		</td>
	</tr>
</table>
<hr>
<table class="table" style="width: 800px; margin: auto;">
	<thead>
		<tr>
			<th style="width: 10px;">S.No</th>
			<th style="width: 100px;">Date</th>
			<th>Remarks</th>
			<td style="width: 80px;"></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${kpiRecordableDates}" var="data" varStatus="index">
			<tr>
				<td style="text-align: center;">${index.index+1}</td>
				<td style="text-align: center;">
				<fmt:formatDate value="${data.date}" pattern="MM-dd-yyyy" var="date"/>
				${date}
				</td>
				<td>${data.remarks}</td>
				<td style="text-align: center;">
					<a href="javascript:void(0);" id="delete_${index.index+1}" data-id="${data.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>
</div>				

