<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>
<style type="text/css">

</style>

<script type="text/javascript">
	$(function(){
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			changeMonth: true,
		    changeYear: true
		});
		
		$('#viewBtn').click(function(){
			var val=$('select[name=prodType]').val();
			if(val==''){
				alert('Select production type.');
				setTimeout(function(){$('select[name=prodType]').focus();}, 100);
				return false;
			}else{
				return true;
			}
		});
	});
</script>
<spring:url value="/frpproductionreport/view/data/sendmail" var="emailURL" />
<script type="text/javascript">
	$(function(){
		$('#mailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			
			var prodType=$('input[name=prodType]').val();
			var grade=$('input[name=grade]').val();
			
			var btn=$(this);
			
			if(confirm('Do You Want To Send FRP Production Report For '+sdate)){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						sdate : sdate,
						edate : edate,
						prodType : prodType,
						grade : grade
					},
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
<style type="text/css">
.table td:FIRST-CHILD {
	text-align: left;
	width: 150px !important;
}

.table td {
	text-align: center;
	width: 30px;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
			<jsp:include page="header.jsp"></jsp:include>
<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
	<div class="pageContent">
	<div class="block3" style="overflow: auto;">
				<div class="page-title">
					<span class="label">FRP Production - Report</span>
				</div>
				<br>
				<div class="table-selector">
					<spring:url value="/frpproductionreport/view/data" var="viewDataURL"/>
				<form action="${viewDataURL}" method="get">
					<table style="margin: auto;">
						<tr>
							<td> Start Date</td>
							<td>
								<input readonly="readonly" type="text" name="sdate" value="${sdate}" style="width: 90px;" tabindex="1">
							</td>
							<td> End Date</td>
							<td>
								<input readonly="readonly" type="text" name="edate" value="${edate}" style="width: 90px;" tabindex="1">
							</td>
							<td>Production Type</td>
							<td>
								<select name="prodType" style="width: 150px;" tabindex="2">
									<option value="">Select</option>
									<c:forEach items="${ptypes}" var="ptype">
										<c:choose>
											<c:when test="${prodType eq ptype.key }">
												<option value="${ptype.key}" selected="selected">${ptype.value}</option>																
											</c:when>
											<c:otherwise>
												<option value="${ptype.key}" >${ptype.value}</option>
											</c:otherwise>
										</c:choose>
										
									</c:forEach>
								</select>
							</td>
							<td>Grade Type</td>
							<td>
								<select name="grade" style="padding: 2px;" tabindex="3">
									<option value="">All</option>
									<c:forEach items="${grades}" var="gtype">
										<c:choose>
											<c:when test="${gtype.key eq grade}">
												<option value="${gtype.key}" selected="selected">${gtype.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${gtype.key}" >${gtype.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
							<td>
								<input type="submit" id="viewBtn" value="View">
								
								<c:if test="${fn:length(datas)>0}">
									&nbsp;
									<input type="button" value="Edit" id="editBtn">
									&nbsp;&nbsp;
									<input type="button" value="Delete" id="deleteBtn">
									&nbsp;&nbsp;
									<input type="button" value="Export" id="exportBtn">
									<input type="button" value="Send Mail" id="mailBtn">
								</c:if>
								
							</td>
							
						</tr>
					</table>
				</form>	
				
				</div>
				
<div>
<c:if test="${viewFlag}">

<!-- Export form -->
<spring:url value="/frpproductionreport/export" var="exportURL" />
<form  id="exportForm" action="${exportURL}" method="post">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
	<input type="hidden" name="prodType" value="${prodType}">
	<input type="hidden" name="grade" value="${grade}">
</form>

<%-- <spring:url value="/frpproductionreport/view/data/sendmail" var="mailForm" />
<form  id="mailForm" action="${mailForm}" method="post">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
	<input type="hidden" name="prodType" value="${prodType}">
	<input type="hidden" name="grade" value="${grade}">
</form> --%>
	
<c:if test="${fn:length(datas)eq 0}">
<h5 align="center">Data not available for search query.</h5>
</c:if>

<c:if test="${fn:length(datas)>0}">
<c:set value="${fn:length(datas['ROW01'])}" var="collen" />

<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<table class="table" style=" width: auto;">
	<thead>
		<tr>
			<td style="width: 150px;">&nbsp;</td>
			<c:forEach items="${datas['ROW01']}" var="id">
				<td><input type="radio" name="editId" value="${id}"> </td>
			</c:forEach>
		</tr>
		
		
	</thead>
	<tbody>
		<tr>
			<td><div style="display: block; width: 150px;">Date</div></td>
			<c:forEach items="${datas['ROW02']}" var="date">
				<td><div style="display: block; width: 64px;margin: auto;">${date}</div></td>
			</c:forEach>
		</tr>
		<tr>
			<td> &nbsp; </td>
			<c:forEach items="${datas['ROW03']}" var="day">
				<td>${day}</td>
			</c:forEach>
		</tr>
		
		<tr>
			<td> Grade </td>
			<c:forEach items="${datas['ROW48']}" var="grade">
				<td>${grade}</td>
			</c:forEach>
		</tr>
		<tr class="trobjrow">
			<td  colspan="${collen+1}"></td>
		</tr>
		<tr>
			<td>HD storage (%)</td>
			<c:forEach items="${datas['ROW04']}" var="hdStorage">
				<td>${hdStorage}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>DCS Wastepaper feed ADST</td>
			<c:forEach items="${datas['ROW05']}" var="dcsWPFeedADST">
				<td>${dcsWPFeedADST}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Secondary press ADST</td>
			<c:forEach items="${datas['ROW06']}" var="primaryPressADST">
				<td>${primaryPressADST}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Wet Lap production ADST</td>
			<c:forEach items="${datas['ROW07']}" var="wetLapProdADST">
				<td>${wetLapProdADST}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Total Production ADST</td>
			<c:forEach items="${datas['ROW08']}" var="totalProdADST">
				<td>${totalProdADST}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Tracker Wastepaper feed</td>
			<c:forEach items="${datas['ROW09']}" var="trackerWPfeed">
				<td>${trackerWPfeed}</td>
			</c:forEach>
		</tr>
		<tr>
			<td  colspan="${collen+1}">&nbsp;</td>
		</tr>
		<tr>
			<td>Yield DCS</td>
			<c:forEach items="${datas['ROW10']}" var="yieldDcs">
				<td>${yieldDcs}%</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Yield Tracker</td>
			<c:forEach items="${datas['ROW11']}" var="yieldTracker">
				<td>${yieldTracker}%</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Fresh Water #1008</td>
			<c:forEach items="${datas['ROW12']}" var="freshWater">
				<td>${freshWater}</td>
			</c:forEach>
		</tr>
		
		<tr>
			<td>Fresh Water #1009</td>
			<c:forEach items="${datas['ROW49']}" var="freshWater2">
				<td>${freshWater2}</td>
			</c:forEach>
		</tr>
		<tr>
			<td  colspan="${collen+1}">&nbsp;</td>
		</tr>
		<tr class="trobjrow">
			<td  colspan="${collen+1}">Mix Ratio</td>
		</tr>
		<tr>
			<td>MWL &#38; SWL</td>
			<c:forEach items="${datas['ROW13']}" var="mrMwlAndSwl">
				<td>${mrMwlAndSwl}%</td>
			</c:forEach>
		</tr>
		<tr>
			<td>SOW &#38; CBS</td>
			<c:forEach items="${datas['ROW14']}" var="mrSowAndCbs">
				<td>${mrSowAndCbs}%</td>
			</c:forEach>
		</tr>
		<tr>
			<td>White grades</td>
			<c:forEach items="${datas['ROW17']}" var="mrWhiteGrades">
				<td>${mrWhiteGrades}%</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Groundwood</td>
			<c:forEach items="${datas['ROW18']}" var="mrGroundwood">
				<td>${mrGroundwood}%</td>
			</c:forEach>
		</tr>
		<tr>
			<td>DLK</td>
			<c:forEach items="${datas['ROW15']}" var="mrDlk">
				<td>${mrDlk}%</td>
			</c:forEach>
		</tr>
		<tr>
			<td>OCC</td>
			<c:forEach items="${datas['ROW16']}" var="mrOcc">
				<td>${mrOcc}%</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Mixed/Other</td>
			<c:forEach items="${datas['ROW19']}" var="mrOther">
				<td>${mrOther}%</td>
			</c:forEach>
		</tr>
		<tr>
			<td  colspan="${collen+1}">&nbsp;</td>
		</tr>
		<tr class="trobjrow">
			<td  colspan="${collen+1}">Month to Date</td>
		</tr>
		<tr>
			<td>MTD DCS yield</td>
			<td colspan="${collen}" style="text-align: left;">${datas['ROW37']}%</td>
		</tr>
		<tr>
			<td>MTD Tracker yield</td>
			<td colspan="${collen}" style="text-align: left;">${datas['ROW38']}%</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr class="trobjrow">
			<td  colspan="${collen+1}">MTD Mix</td>
		</tr>
		<tr>
			<td>MWL &#38; SWL</td>
			<td colspan="${collen}" style="text-align: left;">${datas['ROW39']}%</td>
		</tr>
		<tr>
			<td>SOW</td>
			<td colspan="${collen}" style="text-align: left;">${datas['ROW40']}%</td>
		</tr>
		<tr>
			<td>White grades</td>
			<td colspan="${collen}" style="text-align: left;">${datas['ROW41']}%</td>
		</tr>
		<tr>
			<td>Groundwood</td>
			<td colspan="${collen}" style="text-align: left;">${datas['ROW42']}%</td>
		</tr>
		<tr>
			<td>DLK</td>
			<td colspan="${collen}" style="text-align: left;">${datas['ROW43']}%</td>
		</tr>
		<tr>
			<td>OCC</td>
			<td colspan="${collen}" style="text-align: left;">${datas['ROW44']}%</td>
		</tr>
		<tr>
			<td>Mail Undeliverable</td>
			<td colspan="${collen}" style="text-align: left;">${datas['ROW47']}%</td>
		</tr>
		<tr>
			<td>Mixed/Other</td>
			<td colspan="${collen}" style="text-align: left;">${datas['ROW45']}%</td>
		</tr>
		<tr>
			<td  colspan="${collen+1}">&nbsp;</td>
		</tr>
		<tr class="trobjrow">
			<td  colspan="${collen+1}">Wastepaper Mix</td>
		</tr>
		<tr>
			<td>MWL</td>
			<c:forEach items="${datas['ROW20']}" var="wpmMwl">
				<td>${wpmMwl}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Print mix</td>
			<c:forEach items="${datas['ROW21']}" var="wpmPrintMix">
				<td>${wpmPrintMix}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>CBS</td>
			<c:forEach items="${datas['ROW23']}" var="wpmCbs">
				<td>${wpmCbs}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>SOW</td>
			<c:forEach items="${datas['ROW22']}" var="wpmSow">
				<td>${wpmSow}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>SOW &#38; CBS</td>
			<c:forEach items="${datas['ROW24']}" var="wpmSowAndCbs">
				<td>${wpmSowAndCbs}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>SWL</td>
			<c:forEach items="${datas['ROW26']}" var="wpmSwl">
				<td>${wpmSwl}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Ctd grwd</td>
			<c:forEach items="${datas['ROW25']}" var="wpmCtdGrwd">
				<td>${wpmCtdGrwd}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>OCC</td>
			<c:forEach items="${datas['ROW27']}" var="wpmOcc">
				<td>${wpmOcc}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>News / newsblank</td>
			<c:forEach items="${datas['ROW28']}" var="wpmNewsNewsblank">
				<td>${wpmNewsNewsblank}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>DLK</td>
			<c:forEach items="${datas['ROW29']}" var="wpmDlk">
				<td>${wpmDlk}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Mail Undeliverable</td>
			<c:forEach items="${datas['ROW46']}" var="mrMailUndeliverable">
				<td>${mrMailUndeliverable}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Mixed/other</td>
			<c:forEach items="${datas['ROW30']}" var="wpmOther">
				<td>${wpmOther}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Total</td>
			<c:forEach items="${datas['ROW31']}" var="wpmTotal">
				<td>${wpmTotal}</td>
			</c:forEach>
		</tr>
		<tr>
			<td  colspan="${collen+1}">&nbsp; </td>
		</tr>
		<tr>
			<td>Target brightness</td>
			<c:forEach items="${datas['ROW32']}" var="targetBrightness">
				<td>${targetBrightness}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>Daily avg</td>
			<c:forEach items="${datas['ROW33']}" var="dailyAvg">
				<td>${dailyAvg}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>PM target brite</td>
			<c:forEach items="${datas['ROW34']}" var="pmTargetBrite">
				<td>${pmTargetBrite}</td>
			</c:forEach>
		</tr>
		<tr>
			<td>PM avg brite</td>
			<c:forEach items="${datas['ROW35']}" var="pmAvgBrite">
				<td>${pmAvgBrite}</td>
			</c:forEach>
		</tr>
		<tr>
			<td  colspan="${collen+1}">&nbsp;</td>
		</tr>
		<tr>
			<td class="trobjrow" colspan="${collen+1}">Comments</td>
		</tr>
		<tr>
			<td>&nbsp; </td>
			<c:forEach items="${datas['ROW36']}" var="comments">
				<td>${comments}</td>
			</c:forEach>
		</tr>
		
	</tbody>
</table>			

</div>			
			
<spring:url value="/frpproduction/edit" var="editURL"/>
<spring:url value="/frpproduction/delete" var="deleteURL"/>
<script type="text/javascript">
	$(function(){
		
		$('#exportBtn').click(function(){
			$('#exportForm').submit();
		});
		
		$('#editBtn').click(function(){
			var query=location.search;
			var id=$('input[name=editId]:checked').val();
			if(id){
				var url='${editURL}/'+id+query;
				location.href=url;
			}else{
				alert('Select column!');
			}
		});
		
		$('#deleteBtn').click(function(){
			var btn=$(this);
			
			var id=$('input[name=editId]:checked').val();
			if(id){
				btn.attr('disabled','disabled');
				$.ajax({
					url:'${deleteURL}',
					type:'POST',
					data:{id :id },
					success:function(data){
						if(data.status){
							alert('Data removed from database successfully.');
							location.reload(true);
						}else{
							alert(data.error);
							btn.removeAttr('disabled','disabled');
						}
					},
					error: function(xhr, status, error) {
						alert('Server error.. :-(' );
					}
				});
			}else{
				alert('Select column!');
			}
		});
	});

</script>
			
			
</c:if>		
			
</c:if>				
				</div>
			</div>

		</div>


	</div>

</body>
</html>
