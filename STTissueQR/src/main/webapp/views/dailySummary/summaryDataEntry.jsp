<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
.dtable {
	border-collapse: collapse;
}

.dtable td, .dtable th {
	border: 1px solid gray;
	text-align: center;
}

.hbg {
	background-color: #EEE;
}

.dtable textarea {
	width: 535px;
	height: 50px;
	resize: none;
	margin-bottom: -4px;
}
</style>


<spring:url value="/pmsummarydata/save" var="saveURL"/>
<spring:url value="/pmsummarydata/main" var="newURL"/>
<spring:url value="/pmsummarydatareport/export/pdf" var="pdfURL"/>
<spring:url value="/pmsummarydatareport/mail/pdf" var="mailURL"/>


<spring:url value="/pmsummarydata/load/data" var="loadURL"/>




<script type="text/javascript">
	
	var mailTimer;
	
	$(function() {
		
		 $('textarea[maxlength]').keyup(function(){  
	        var limit = parseInt($(this).attr('maxlength'));  
	        var text = $(this).val();  
	        var chars = text.length;  
	  
	        if(chars > limit){  
	            var new_text = text.substr(0, limit);  
	            $(this).val(new_text);  
	        }  
	    });  
		
		$('input[name=date]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true
		});
		
		$('input[name=productionDate]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true,
			onClose:function(){
				$('#tableData').find('input[name=id]').val('0');
				loadData($(this).val());
			}
		});
		
		$('#pdfLink').click(function(){
			var id=$('#tableData').find('input[name=id]').val();
			if(id!='0'){
				$(this).attr('href','${pdfURL}/'+id);
				return true;
			}else{
				alert('Please save data before exporting in PDF.');
				return false;	
			}
			
		});
		
		$('#sendMailBtn').click(function(){
			
			/* var id=$('#tableData').find('input[name=id]').val();
			
			var btn=$(this);

			if(id & id!='0'){
				
				btn.prop("disabled",true);
				
				if(mailTimer){
					clearTimeout(mailTimer);
				}
				
				$('#tmessage').text('Sending mail.....');
				$.ajax({
					url:'${mailURL}',
					type:'POST',
					data: {id:id},
					success:function(data){
						if(data.flag){
							
							$('#tmessage').text('Mail sent successfully.');
							mailTimer=setTimeout(function(){
								$('#tmessage').text('');
							}, 5000);
						}else{
							alert(data.error);
						}
						
						
						btn.prop("disabled",false);
					},
					error:function(){
						alert('Server error..');
						btn.prop("disabled",false);
					}
						
				});
				
			}else{
				alert('Please save data before sending mail.');	
			} */
			var flag=true;
			$('#tableData tr').find('input[type=text]').each(function(){
				if(validate($(this))){
					flag=false;
					return;
				}
			});
			
			if(flag){
				saveData();
			}
			
		});
		
		
	/* 	$('#saveBtn').click(function(){
			var flag=true;
			$('#tableData tr').find('input[type=text]').each(function(){
				if(validate($(this))){
					flag=false;
					return;
				}
			});
			
			if(flag){
				saveData();
			}
		}); */
		
		
		$('#tableData').find('input[type=text]').each(function(){
			var val=$(this).val();
			if(val=='0' | val=='0.0'){
				$(this).val('');
			}
		});
		
		
		$('#newBtn').button({
			icons : {
				primary : "ui-icon-plus"
			}
		}).next().button({
			icons : {
				primary : "ui-icon-disk"
			}
		}).next().button({
			icons : {
				primary : "ui-icon-mail-closed"
			}
		}).next().button({
			icons : {
				primary : "ui-icon-document"
			}
		}).next().button({
			icons : {
				primary : "ui-icon-document"
			}
		}).next().button({
			icons : {
				primary : " ui-icon-circle-arrow-w"
			}
		});
		
	});

	
	function sendMail(){
		var id=$('#tableData').find('input[name=id]').val();
		
		if(id){
			
			if(mailTimer){
				clearTimeout(mailTimer);
			}
			
			$('#tmessage').text('Sending mail.....');
			$.ajax({
				url:'${mailURL}',
				type:'POST',
				data: {id:id},
				success:function(data){
					if(data.flag){
						
						$('#tmessage').text('Mail sent successfully.');
						mailTimer=setTimeout(function(){
							$('#tmessage').text('');
						}, 5000);
					}else{
						alert(data.error);
					}
					
				},
				error:function(){
					alert('Server error..');
					btn.prop("disabled",false);
				}
					
			});
			
		}else{
			alert('Please save data before sending mail.');	
		}
	}
	
</script>

<c:if test="${editFlag eq false}">
<fmt:formatDate value="${summaryData.productionDate}" pattern="MM-dd-yyyy" var="productionDate"/>
	<script type="text/javascript">
		$(function(){
			//loadData('${productionDate}');
		});
	</script>
</c:if>

<script type="text/javascript">	
	
	function loadData(date){
		
		$('#loadPage').show();
		
		$.ajax({
			url :'${loadURL}',
			type: 'POST',
			data: {date : date},
			success:function(data){
			//	$('#tableData').find('input[name=safety_MTD01]').val(data.safety_MTD01);
			//	$('#tableData').find('input[name=safety_MTD02]').val(data.safety_MTD02);
				$('#tableData').find('input[name=safety_MTD03]').val(data.safety_MTD03);
				$('#tableData').find('input[name=safety_MTD04]').val(data.safety_MTD04);
				
				
				$('#tableData').find('input[name=quality_MTD01]').val(data.quality_MTD01);
				$('#tableData').find('input[name=quality_MTD02]').val(data.quality_MTD02);
			//	$('#tableData').find('input[name=quality_MTD03]').val(data.quality_MTD03);
				$('#tableData').find('input[name=quality_MTD04]').val(data.quality_MTD04);
				
				$('#tableData').find('input[name=quality_Y01]').val(data.quality_Y01);
				$('#tableData').find('input[name=quality_Y02]').val(data.quality_Y02);
				$('#tableData').find('input[name=quality_Y03]').val(data.quality_Y03);
				$('#tableData').find('input[name=quality_Y04]').val(data.quality_Y04);
				
				
				
				$('#tableData').find('input[name=paperProd_MTD01]').val(data.paperProd_MTD01);
				$('#tableData').find('input[name=paperProd_MTD02]').val(data.paperProd_MTD02);
				$('#tableData').find('input[name=paperProd_MTD03]').val(data.paperProd_MTD03);
			 	//$('#tableData').find('input[name=paperProd_MTD04]').val(data.paperProd_MTD04);
				//$('#tableData').find('input[name=paperProd_MTD05]').val(data.paperProd_MTD05);
				$('#tableData').find('input[name=paperProd_MTD06]').val(data.paperProd_MTD06);
				
				$('#tableData').find('input[name=paperProd_Y01]').val(data.paperProd_Y01);
				$('#tableData').find('input[name=paperProd_Y02]').val(data.paperProd_Y02);
				$('#tableData').find('input[name=paperProd_Y03]').val(data.paperProd_Y03);
				$('#tableData').find('input[name=paperProd_Y04]').val(data.paperProd_Y04);
				//$('#tableData').find('input[name=paperProd_Y05]').val(data.paperProd_Y05);
				$('#tableData').find('input[name=paperProd_Y06]').val(data.paperProd_Y06);
				
				
				
				$('#tableData').find('input[name=fiberProd_Y01]').val(data.fiberProd_Y01);
				$('#tableData').find('input[name=fiberProd_Y02]').val(data.fiberProd_Y02);
				
				$('#tableData').find('input[name=fiberProd_Y03]').val(data.fiberProd_Y03);
				$('#tableData').find('input[name=fiberProd_Y04]').val(data.fiberProd_Y04);
				$('#tableData').find('input[name=fiberProd_Y05]').val(data.fiberProd_Y05);
				$('#tableData').find('input[name=fiberProd_Y06]').val(data.fiberProd_Y06);
				$('#tableData').find('input[name=fiberProd_Y07]').val(data.fiberProd_Y07);
				$('#tableData').find('input[name=fiberProd_Y08]').val(data.fiberProd_Y08);
				$('#tableData').find('input[name=fiberProd_Y09]').val(data.fiberProd_Y09);
				
				
				
				$('#tableData').find('input[name=costs_Y01]').val(data.costs_Y01);
				$('#tableData').find('input[name=costs_Y02]').val(data.costs_Y02);
				
				
				
				$('#tableData').find('input[name=shipping_Y01]').val(data.shipping_Y01);
				$('#tableData').find('input[name=shipping_Y02]').val(data.shipping_Y02);
				$('#tableData').find('input[name=shipping_Y03]').val(data.shipping_Y03);
				
				
				
				$('#tableData').find('input[name=safety_Y01]').val(data.safety_Y01);
				
				
				$('#loadPage').hide();
			},
			error:function(){
				$('#loadPage').hide();
			}
		});
	}

</script>

<script type="text/javascript">	
	var saveTimer;
	function saveData(){
		var table=$('#tableData');
		
		var idEle=table.find('input[name=id]');
		
		var id=table.find('input[name=id]').val();
		var date=table.find('input[name=date]').val();
		var productionDate=table.find('input[name=productionDate]').val();
		
		var safety_Y01=table.find('input[name=safety_Y01]').val() || 0 ;
		var safety_Y02=table.find('input[name=safety_Y02]').val() || 0 ;
		var safety_Y03=table.find('input[name=safety_Y03]').val() || 0 ;
		var safety_Y04=table.find('input[name=safety_Y04]').val() || 0 ;
	//	var safety_Y05=table.find('input[name=safety_Y05]').val() || 0 ;
	//	var safety_MTD01=table.find('input[name=safety_MTD01]').val() || 0 ;
	//	var safety_MTD02=table.find('input[name=safety_MTD02]').val() || 0 ;
		var safety_MTD03=table.find('input[name=safety_MTD03]').val() || 0 ;
		var safety_MTD04=table.find('input[name=safety_MTD04]').val() || 0 ;
	//	var safety_MTD05=table.find('input[name=safety_MTD05]').val() || 0 ;
		var safety_G01=table.find('input[name=safety_G01]').val() || 0 ;
		var safety_G02=table.find('input[name=safety_G02]').val() || 0 ;
	//	var safety_G03=table.find('input[name=safety_G03]').val() || 0 ;
	//	var safety_G04=table.find('input[name=safety_G04]').val() || 0 ;
	//	var safety_G05=table.find('input[name=safety_G05]').val() || 0 ;
		var safetyComment=table.find('textarea[name=safetyComment]').val();
		
		var housekeeping_Y01=table.find('input[name=housekeeping_Y01]').val() || 0 ;
		var housekeeping_MTD01=table.find('input[name=housekeeping_MTD01]').val() || 0 ;
		var housekeeping_G01=table.find('input[name=housekeeping_G01]').val() || 0 ;
		var housekeepingCommnet=table.find('textarea[name=housekeepingCommnet]').val();
		
		var quality_Y01=table.find('input[name=quality_Y01]').val() || 0 ;
		var quality_Y02=table.find('input[name=quality_Y02]').val() || 0 ;
		var quality_Y03=table.find('input[name=quality_Y03]').val() || 0 ;
		var quality_Y04=table.find('input[name=quality_Y04]').val() || 0 ;
		var quality_MTD01=table.find('input[name=quality_MTD01]').val() || 0 ;
		var quality_MTD02=table.find('input[name=quality_MTD02]').val() || 0 ;
		var quality_MTD03=table.find('input[name=quality_MTD03]').val() || 0 ;
		var quality_MTD04=table.find('input[name=quality_MTD04]').val() || 0 ;
		var quality_G01=table.find('input[name=quality_G01]').val() || 0 ;
	//	var quality_G02=table.find('input[name=quality_G02]').val() || 0 ;
	//	var quality_G03=table.find('input[name=quality_G03]').val() || 0 ;
	//	var quality_G04=table.find('input[name=quality_G04]').val() || 0 ;
		var qualityComment=table.find('textarea[name=qualityComment]').val();
		
		var fiberProd_Y01=table.find('input[name=fiberProd_Y01]').val() || 0 ;
		var fiberProd_Y02=table.find('input[name=fiberProd_Y02]').val() || 0 ;
		var fiberProd_Y03=table.find('input[name=fiberProd_Y03]').val() || 0 ;
		var fiberProd_Y04=table.find('input[name=fiberProd_Y04]').val() || 0 ;
		var fiberProd_Y05=table.find('input[name=fiberProd_Y05]').val() || 0 ;
		var fiberProd_Y06=table.find('input[name=fiberProd_Y06]').val() || 0 ;
		var fiberProd_Y07=table.find('input[name=fiberProd_Y07]').val() || 0 ;
		var fiberProd_Y08=table.find('input[name=fiberProd_Y08]').val() || 0 ;
		var fiberProd_Y09=table.find('input[name=fiberProd_Y09]').val() || 0 ;
		var fiberProd_MTD01=table.find('input[name=fiberProd_MTD01]').val() || 0 ;
		var fiberProd_MTD02=table.find('input[name=fiberProd_MTD02]').val() || 0 ;
		var fiberProd_MTD03=table.find('input[name=fiberProd_MTD03]').val() || 0 ;
		var fiberProd_MTD04=table.find('input[name=fiberProd_MTD04]').val() || 0 ;
		var fiberProd_MTD05=table.find('input[name=fiberProd_MTD05]').val() || 0 ;
		var fiberProd_MTD06=table.find('input[name=fiberProd_MTD06]').val() || 0 ;
		var fiberProd_MTD07=table.find('input[name=fiberProd_MTD07]').val() || 0 ;
		var fiberProd_MTD08=table.find('input[name=fiberProd_MTD08]').val() || 0 ;
		var fiberProd_MTD09=table.find('input[name=fiberProd_MTD09]').val() || 0 ;
	//	var fiberProd_G01=table.find('input[name=fiberProd_G01]').val() || 0 ;
	//	var fiberProd_G02=table.find('input[name=fiberProd_G02]').val() || 0 ;
		var fiberProd_G03=table.find('input[name=fiberProd_G03]').val() || 0 ;
		var fiberProd_G04=table.find('input[name=fiberProd_G04]').val() || 0 ;
		var fiberProd_G05=table.find('input[name=fiberProd_G05]').val() || 0 ;
		var fiberProd_G06=table.find('input[name=fiberProd_G06]').val() || 0 ;
		var fiberProd_G07=table.find('input[name=fiberProd_G07]').val() || 0 ;
		var fiberProd_G08=table.find('input[name=fiberProd_G08]').val() || 0 ;
		var fiberProd_G09=table.find('input[name=fiberProd_G09]').val() || 0 ;
		var fiberProdComment=table.find('textarea[name=fiberProdComment]').val();
		
		var paperProd_Y01=table.find('input[name=paperProd_Y01]').val() || 0 ;
		var paperProd_Y02=table.find('input[name=paperProd_Y02]').val() || 0 ;
		var paperProd_Y03=table.find('input[name=paperProd_Y03]').val() || 0 ;
		var paperProd_Y04=table.find('input[name=paperProd_Y04]').val() || 0 ;
		var paperProd_Y05=table.find('input[name=paperProd_Y05]').val() || 0 ;
		var paperProd_Y06=table.find('input[name=paperProd_Y06]').val() || 0 ;
		var paperProd_Y07=table.find('input[name=paperProd_Y07]').val() || 0 ;
		var paperProd_MTD01=table.find('input[name=paperProd_MTD01]').val() || 0 ;
		var paperProd_MTD02=table.find('input[name=paperProd_MTD02]').val() || 0 ;
		var paperProd_MTD03=table.find('input[name=paperProd_MTD03]').val() || 0 ;
	//	var paperProd_MTD04=table.find('input[name=paperProd_MTD04]').val() || 0 ;
	//	var paperProd_MTD05=table.find('input[name=paperProd_MTD05]').val() || 0 ;
		var paperProd_MTD06=table.find('input[name=paperProd_MTD06]').val() || 0 ;
		var paperProd_MTD07=table.find('input[name=paperProd_MTD07]').val() || 0 ;
	//	var paperProd_G01=table.find('input[name=paperProd_G01]').val() || 0 ;
	//	var paperProd_G02=table.find('input[name=paperProd_G02]').val() || 0 ;
		var paperProd_G03=table.find('input[name=paperProd_G03]').val() || 0 ;
	//	var paperProd_G04=table.find('input[name=paperProd_G04]').val() || 0 ;
	//	var paperProd_G05=table.find('input[name=paperProd_G05]').val() || 0 ;
		var paperProd_G06=table.find('input[name=paperProd_G06]').val() || 0 ;
		var paperProd_G07=table.find('input[name=paperProd_G07]').val() || 0 ;
		var paperProdComment=table.find('textarea[name=paperProdComment]').val();
		
		var shipping_Y01=table.find('input[name=shipping_Y01]').val() || 0 ;
		var shipping_Y02=table.find('input[name=shipping_Y02]').val() || 0 ;
		var shipping_Y03=table.find('input[name=shipping_Y03]').val() || 0 ;
		var shipping_Y04=table.find('input[name=shipping_Y04]').val() || 0 ;
/* 		var shipping_MTD01=table.find('input[name=shipping_MTD01]').val() || 0 ;
		var shipping_MTD02=table.find('input[name=shipping_MTD02]').val() || 0 ;
		var shipping_MTD03=table.find('input[name=shipping_MTD03]').val() || 0 ;
		var shipping_MTD04=table.find('input[name=shipping_MTD04]').val() || 0 ;
		var shipping_G01=table.find('input[name=shipping_G01]').val() || 0 ;
		var shipping_G02=table.find('input[name=shipping_G02]').val() || 0 ;
		var shipping_G03=table.find('input[name=shipping_G03]').val() || 0 ;
		var shipping_G04=table.find('input[name=shipping_G04]').val() || 0 ; */
		var shippingComment=table.find('textarea[name=shippingComment]').val();
		
		var costs_Y01=table.find('input[name=costs_Y01]').val() || 0 ;
		var costs_Y02=table.find('input[name=costs_Y02]').val() || 0 ;
		var costs_MTD01=table.find('input[name=costs_MTD01]').val() || 0 ;
		var costs_MTD02=table.find('input[name=costs_MTD02]').val() || 0 ;
		var costs_G01=table.find('input[name=costs_G01]').val() || 0 ;
		var costs_G02=table.find('input[name=costs_G02]').val() || 0 ;
		var costsComment=table.find('textarea[name=costsComment]').val();

		var safetyMeetingTopic =table.find('input[name=safetyMeetingTopic]').val();
		
		var notes =table.find('textarea[name=notes]').val();
		var meetingToday =table.find('textarea[name=meetingToday]').val();
		var attendee =table.find('textarea[name=attendee]').val();
		var visitor =table.find('textarea[name=visitor]').val();
		
		
		$('#tmessage').text('Saving data.....');
		if(saveTimer){
			clearTimeout(saveTimer);
		}
		
		
		$.ajax({
			url:'${saveURL}',
			type:'POST',
			data: {
				id : id,
				date : date,
				productionDate : productionDate,
				safety_Y01 : safety_Y01,
				safety_Y02 : safety_Y02,
				safety_Y03 : safety_Y03,
				safety_Y04 : safety_Y04,
			//	safety_Y05 : safety_Y05,
			//	safety_MTD01 : safety_MTD01,
			//	safety_MTD02 : safety_MTD02,
				safety_MTD03 : safety_MTD03,
				safety_MTD04 : safety_MTD04,
			//	safety_MTD05 : safety_MTD05,
				safety_G01 : safety_G01,
				safety_G02 : safety_G02,
			//	safety_G03 : safety_G03,
			//	safety_G04 : safety_G04,
			//	safety_G05 : safety_G05,
				safetyComment : safetyComment,
				housekeeping_Y01 : housekeeping_Y01,
				housekeeping_MTD01 : housekeeping_MTD01,
				housekeeping_G01 : housekeeping_G01,
				housekeepingCommnet : housekeepingCommnet,
				quality_Y01 : quality_Y01,
				quality_Y02 : quality_Y02,
				quality_Y03 : quality_Y03,
				quality_Y04 : quality_Y04,
				quality_MTD01 : quality_MTD01,
				quality_MTD02 : quality_MTD02,
				quality_MTD03 : quality_MTD03,
				quality_MTD04 : quality_MTD04,
				quality_G01 : quality_G01,
			//	quality_G02 : quality_G02,
			//	quality_G03 : quality_G03,
			//	quality_G04 : quality_G04,
				qualityComment : qualityComment,
				fiberProd_Y01 : fiberProd_Y01,
				fiberProd_Y02 : fiberProd_Y02,
				fiberProd_Y03 : fiberProd_Y03,
				fiberProd_Y04 : fiberProd_Y04,
				fiberProd_Y05 : fiberProd_Y05,
				fiberProd_Y06 : fiberProd_Y06,
				fiberProd_Y07 : fiberProd_Y07,
				fiberProd_Y08 : fiberProd_Y08,
				fiberProd_Y09 : fiberProd_Y09,
				fiberProd_MTD01 : fiberProd_MTD01,
				fiberProd_MTD02 : fiberProd_MTD02,
				fiberProd_MTD03 : fiberProd_MTD03,
				fiberProd_MTD04 : fiberProd_MTD04,
				fiberProd_MTD05 : fiberProd_MTD05,
				fiberProd_MTD06 : fiberProd_MTD06,
				fiberProd_MTD07 : fiberProd_MTD07,
				fiberProd_MTD08 : fiberProd_MTD08,
				fiberProd_MTD09 : fiberProd_MTD09,
			//	fiberProd_G01 : fiberProd_G01,
			//	fiberProd_G02 : fiberProd_G02,
				fiberProd_G03 : fiberProd_G03,
				fiberProd_G04 : fiberProd_G04,
				fiberProd_G05 : fiberProd_G05,
				fiberProd_G06 : fiberProd_G06,
				fiberProd_G07 : fiberProd_G07,
				fiberProd_G08 : fiberProd_G08,
				fiberProd_G09 : fiberProd_G09,
				fiberProdComment : fiberProdComment,
			
				paperProd_Y01 : paperProd_Y01,
				paperProd_Y02 : paperProd_Y02,
				paperProd_Y03 : paperProd_Y03,
				paperProd_Y04 : paperProd_Y04,
				paperProd_Y05 : paperProd_Y05,
				paperProd_Y06 : paperProd_Y06,
				paperProd_Y07 : paperProd_Y07,
				paperProd_MTD01 : paperProd_MTD01,
				paperProd_MTD02 : paperProd_MTD02,
				paperProd_MTD03 : paperProd_MTD03,
			//	paperProd_MTD04 : paperProd_MTD04,
			//	paperProd_MTD05 : paperProd_MTD05,
				paperProd_MTD06 : paperProd_MTD06,
				paperProd_MTD07 : paperProd_MTD07,
			//	paperProd_G01 : paperProd_G01,
			//	paperProd_G02 : paperProd_G02,
				paperProd_G03 : paperProd_G03,
			//	paperProd_G04 : paperProd_G04,
			//	paperProd_G05 : paperProd_G05,
				paperProd_G06 : paperProd_G06,
				paperProd_G07 : paperProd_G07,
				paperProdComment : paperProdComment,
				
				shipping_Y01 : shipping_Y01,
				shipping_Y02 : shipping_Y02,
				shipping_Y03 : shipping_Y03,
				shipping_Y04 : shipping_Y04,
				/* shipping_MTD01 : shipping_MTD01,
				shipping_MTD02 : shipping_MTD02,
				shipping_MTD03 : shipping_MTD03,
				shipping_MTD04 : shipping_MTD04,
				shipping_G01 : shipping_G01,
				shipping_G02 : shipping_G02,
				shipping_G03 : shipping_G03,
				shipping_G04 : shipping_G04, */
				shippingComment : shippingComment,
				costs_Y01 : costs_Y01,
				costs_Y02 : costs_Y02,
				costs_MTD01 : costs_MTD01,
				costs_MTD02 : costs_MTD02,
				costs_G01 : costs_G01,
				costs_G02 : costs_G02,
				costsComment : costsComment,
				safetyMeetingTopic : safetyMeetingTopic,
				notes : notes,
				meetingToday:meetingToday,
				attendee:attendee,
				visitor: visitor

			},
			success:function(data){
				if(data.flag){
					idEle.val(data.id);
					$('#tmessage').text('Data saved in database successfully.');
					
					setTimeout(function(){sendMail();}, 1000);
					
				}else{
					alert(data.error);
				}
			},
			error:function(){
				alert('Server error:-');
				location.reload(true);
			}
		});
	}
	
	function validate(tb){
		if($.trim(tb.val())!=''){
			if(tb.attr('name')=='date'
					|tb.attr('name')=='productionDate'
					|tb.attr('name')=='safetyComment'
					|tb.attr('name')=='housekeepingCommnet'
					|tb.attr('name')=='qualityComment'
					|tb.attr('name')=='fiberProdComment'
					|tb.attr('name')=='paperProdComment'
					|tb.attr('name')=='shippingComment'
					|tb.attr('name')=='costsComment'
					|tb.attr('name')=='safetyMeetingTopic'
					|tb.attr('name')=='paperProd_Y04'
					|tb.attr('name')=='notes'
				){
				return false;
			}else if(isNaN(tb.val())){
				alert('Enter a valid number.');
				setTimeout(function(){tb.focus();}, 10);
				return true;
			}
		}
		return false;
	}
</script>

</head>
<body>
<jsp:include page="../_loader.jsp"/>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<c:choose>
						<c:when test="${editFlag}">
							<span class="label">Daily Summary - Edit</span>
						</c:when>
						<c:otherwise>
							<span class="label">Daily Summary - Data Entry</span>
						</c:otherwise>
					</c:choose>
				</div>
				<br>
				<div class="table-selector">

					<table style="margin: auto;">
						<tr>
							<td>
								<button onclick="location.href='${newURL}'" id="newBtn">NEW</button>
								&nbsp;
								<button id="saveBtn" style="display: none;">SAVE</button>
								&nbsp;
								<button id="sendMailBtn">SEND MAIL</button>
								&nbsp;
								<a href='javascript:void(0);' target="_blank" id="pdfLink">PDF</a>
								&nbsp;
								<a href='<spring:url value="/pmsummarydatareport/export/pdf/blank"/>' target="_blank" id="pdfLink">BLANK PDF</a>
								&nbsp;
								<c:if test="${editFlag}">
									<a href='<spring:url value="/pmsummarydatareport/loaddata?id=${summaryData.id}&sdate=${sdate}&edate=${edate}"/>'>BACK</a>
								</c:if>
							</td>
						</tr>
					</table>

				</div>

				<br>

<div style="padding: 2px; overflow: auto; position: fixed;bottom: 0;left: 5px;right: 5px;top: 150px;">

<table class="dtable" style="width: auto;; margin: auto;" id="tableData">
	<tr>
		<td><b>Date: &nbsp;&nbsp; </b>
			<input type="text" name="date"	readonly="readonly" value='<fmt:formatDate value="${summaryData.date}" pattern="MM-dd-yyyy" />' style="width: 90px;">
		</td>
		<td></td>
		<td colspan="3"><b>Production Date :&nbsp;&nbsp;</b> 
			<input type="text" name="productionDate" readonly="readonly" value='<fmt:formatDate value="${summaryData.productionDate}" pattern="MM-dd-yyyy" />' style="width: 90px;">
			
			<input type="hidden" name="id" value="${summaryData.id}">
			
		</td>

	</tr>
	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	<tr class="hbg">
		<td></td>
		<td><div style="width: 250px;"></div></td>
		<td><b>Yesterday</b></td>
		<td><b>Month To Date</b></td>
		<td><b>Goal</b></td>
	</tr>

	<tr>
		<td rowspan="5" valign="top"><b>Safety</b></td>
		<td style="text-align: left;">Days Without Recordable Injury</td>
		<td><input type="text" name="safety_Y01" value="${summaryData.safety_Y01}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
		<td><input type="text" name="safety_G01" value="${summaryData.safety_G01}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Days Without Lost Time Injury</td>
		<td><input type="text" name="safety_Y02" value="${summaryData.safety_Y02}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
		<td><input type="text" name="safety_G02" value="${summaryData.safety_G02}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">First Aid Cases</td>
		<td><input type="text" name="safety_Y03" value="${summaryData.safety_Y03}" style="width: 90px;"></td>
		<td><input type="text" name="safety_MTD03" value="${summaryData.safety_MTD03}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>

	<tr>
		<td style="text-align: left;">Incident/Near Miss Reports</td>
		<td><input type="text" name="safety_Y04" value="${summaryData.safety_Y04}" style="width: 90px;"></td>
		<td><input type="text" name="safety_MTD04" value="${summaryData.safety_MTD04}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>

	<tr>
		<td style="text-align: left;">Safety Meeting Topic</td>
		<td colspan="2"><input type="text" name="safetyMeetingTopic" value="${summaryData.safetyMeetingTopic}" style="width: 186px;" maxlength="100"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4"><textarea name="safetyComment" maxlength="1000">${summaryData.safetyComment}</textarea></td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>



	<tr>
		<td rowspan="1" valign="top"><b>Housekeeping</b></td>
		<td style="text-align: left;">Fire Incidents</td>
		<td><input type="text" name="housekeeping_Y01" value="${summaryData.housekeeping_Y01}" style="width: 90px;"></td>
		<td><input type="text" name="housekeeping_MTD01" value="${summaryData.housekeeping_MTD01}" style="width: 90px;"></td>
		<td><input type="text" name="housekeeping_G01" value="${summaryData.housekeeping_G01}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4"><textarea name="housekeepingCommnet" maxlength="1000">${summaryData.housekeepingCommnet}</textarea></td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	
	
	
	<tr>
		<td rowspan="4" valign="top"><b>Quality</b></td>
		<td style="text-align: left;">First Quality Percentage</td>
		<td><input type="text" name="quality_Y01" value="${summaryData.quality_Y01}" style="width: 90px;"></td>
		<td><input type="text" name="quality_MTD01" value="${summaryData.quality_MTD01}" style="width: 90px;"></td>
		<td><input type="text" name="quality_G01" value="${summaryData.quality_G01}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Red Tons</td>
		<td><input type="text" name="quality_Y02" value="${summaryData.quality_Y02}" style="width: 90px;"></td>
		<td><input type="text" name="quality_MTD02" value="${summaryData.quality_MTD02}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Cull Tons (Slaboff)</td>
		<td><input type="text" name="quality_Y03" value="${summaryData.quality_Y03}" style="width: 90px;"></td>
		<td><input type="text" name="quality_MTD03" value="${summaryData.quality_MTD03}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Reject</td>
		<td><input type="text" name="quality_Y04" value="${summaryData.quality_Y04}" style="width: 90px;"></td>
		<td><input type="text" name="quality_MTD04" value="${summaryData.quality_MTD04}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4"><textarea name="qualityComment" maxlength="1000">${summaryData.qualityComment}</textarea></td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	
	
	
	<tr>
		<td rowspan="9" valign="top"><b>Fiber Production</b></td>
		<td style="text-align: left;">Input Tons</td>
		<td><input type="text" name="fiberProd_Y01" value="${summaryData.fiberProd_Y01}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_MTD01" value="${summaryData.fiberProd_MTD01}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Output Tons</td>
		<td><input type="text" name="fiberProd_Y02" value="${summaryData.fiberProd_Y02}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_MTD02" value="${summaryData.fiberProd_MTD02}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td style="text-align: left;">White Yield</td>
		<td><input type="text" name="fiberProd_Y03" value="${summaryData.fiberProd_Y03}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_MTD03" value="${summaryData.fiberProd_MTD03}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_G03" value="${summaryData.fiberProd_G03}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Last 24 hrs. Brightness</td>
		<td><input type="text" name="fiberProd_Y04" value="${summaryData.fiberProd_Y04}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_MTD04" value="${summaryData.fiberProd_MTD04}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_G04" value="${summaryData.fiberProd_G04}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Current Brightness</td>
		<td><input type="text" name="fiberProd_Y05" value="${summaryData.fiberProd_Y05}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_MTD05" value="${summaryData.fiberProd_MTD05}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_G05" value="${summaryData.fiberProd_G05}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">White % SOW & CBS</td>
		<td><input type="text" name="fiberProd_Y06" value="${summaryData.fiberProd_Y06}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_MTD06" value="${summaryData.fiberProd_MTD06}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_G06" value="${summaryData.fiberProd_G06}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Kraft Yield</td>
		<td><input type="text" name="fiberProd_Y07" value="${summaryData.fiberProd_Y07}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_MTD07" value="${summaryData.fiberProd_MTD07}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_G07" value="${summaryData.fiberProd_G07}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Kraft % Gwd/Mixed Paper</td>
		<td><input type="text" name="fiberProd_Y08" value="${summaryData.fiberProd_Y08}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_MTD08" value="${summaryData.fiberProd_MTD08}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_G08" value="${summaryData.fiberProd_G08}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Sludge % Solids</td>
		<td><input type="text" name="fiberProd_Y09" value="${summaryData.fiberProd_Y09}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_MTD09" value="${summaryData.fiberProd_MTD09}" style="width: 90px;"></td>
		<td><input type="text" name="fiberProd_G09" value="${summaryData.fiberProd_G09}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4"><textarea name="fiberProdComment" maxlength="1000">${summaryData.fiberProdComment}</textarea></td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	
	
	<tr>
		<td rowspan="7" valign="top"><b>Paper Production</b></td>
		<td style="text-align: left;">Reel Tons (Machine Production Actual)</td>
		<td><input type="text" name="paperProd_Y01" value="${summaryData.paperProd_Y01}" style="width: 90px;"></td>
		<td><input type="text" name="paperProd_MTD01" value="${summaryData.paperProd_MTD01}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td style="text-align: left;">White Tons</td>
		<td><input type="text" name="paperProd_Y02" value="${summaryData.paperProd_Y02}" style="width: 90px;"></td>
		<td><input type="text" name="paperProd_MTD02" value="${summaryData.paperProd_MTD02}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Machine Efficiency</td>
		<td><input type="text" name="paperProd_Y03" value="${summaryData.paperProd_Y03}" style="width: 90px;"></td>
		<td><input type="text" name="paperProd_MTD03" value="${summaryData.paperProd_MTD03}" style="width: 90px;"></td>
		<td><input type="text" name="paperProd_G03" value="${summaryData.paperProd_G03}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Rewinder Sets (D/N)</td>
		<td><input type="text" name="paperProd_Y04" value="${summaryData.paperProd_Y04}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Rewinder Speed</td>
		<td><input type="text" name="paperProd_Y05" value="${summaryData.paperProd_Y05}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Paper Yield</td>
		<td><input type="text" name="paperProd_Y06" value="${summaryData.paperProd_Y06}" style="width: 90px;"></td>
		<td><input type="text" name="paperProd_MTD06" value="${summaryData.paperProd_MTD06}" style="width: 90px;"></td>
		<td><input type="text" name="paperProd_G06" value="${summaryData.paperProd_G06}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Machine Sets</td>
		<td><input type="text" name="paperProd_Y07" value="${summaryData.paperProd_Y07}" style="width: 90px;"></td>
		<td><input type="text" name="paperProd_MTD07" value="${summaryData.paperProd_MTD07}" style="width: 90px;"></td>
		<td><input type="text" name="paperProd_G07" value="${summaryData.paperProd_G07}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4"><textarea name="paperProdComment" maxlength="1000">${summaryData.paperProdComment}</textarea></td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	
	
	<tr>
		<td rowspan="4" valign="top"><b>Shipping</b></td>
		<td style="text-align: left;">Trucks Loaded</td>
		<td><input type="text" name="shipping_Y01" value="${summaryData.shipping_Y01}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Warehouse White Inventory</td>
		<td><input type="text" name="shipping_Y02" value="${summaryData.shipping_Y02}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Warehouse Red Inventory</td>
		<td><input type="text" name="shipping_Y03" value="${summaryData.shipping_Y03}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td style="text-align: left;">Warehouse Cull / Broke Inventory</td>
		<td><input type="text" name="shipping_Y04" value="${summaryData.shipping_Y04}" style="width: 90px;"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
		<td><input type="text" name="" value="" style="width: 90px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4"><textarea name="shippingComment" maxlength="1000">${summaryData.shippingComment}</textarea></td>
	</tr>



	<tr>
		<td colspan="5" style="height: 20px;">&nbsp;</td>
	</tr>
	
	
	
	<tr>
		<td rowspan="2" valign="top"><b>Costs</b></td>
		<td style="text-align: left;">Fresh water flow (gal/ton)</td>
		<td><input type="text" name="costs_Y01" value="${summaryData.costs_Y01}" style="width: 90px;"></td>
		<td><input type="text" name="costs_MTD01" value="${summaryData.costs_MTD01}" style="width: 90px;"></td>
		<td><input type="text" name="costs_G01" value="${summaryData.costs_G01}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td style="text-align: left;">KW Hrs/Ton</td>
		<td><input type="text" name="costs_Y02" value="${summaryData.costs_Y02}" style="width: 90px;"></td>
		<td><input type="text" name="costs_MTD02" value="${summaryData.costs_MTD02}" style="width: 90px;"></td>
		<td><input type="text" name="costs_G02" value="${summaryData.costs_G02}" style="width: 90px;"></td>
	</tr>
	<tr>
		<td valign="top">Comments:</td>
		<td colspan="4"><textarea name="costsComment" maxlength="1000">${summaryData.costsComment}</textarea></td>
	</tr>

	<tr>
		
		<td colspan="5">
			<table style="width: 100%;border-collapse: collapse;">
				<tr>
					<td><b>Meeting Today</b></td>
					<td><b>Attendee</b></td>
					<td><b>Visitor Scheduled Today</b></td>
				</tr>
				<tr>
					<td><textarea style="width: 250px;" name="meetingToday" maxlength="1000">${summaryData.meetingToday}</textarea></td>
					<td><textarea style="width: 200px;" name="attendee" maxlength="1000">${summaryData.attendee}</textarea></td>
					<td><textarea style="width: 200px;" name="visitor" maxlength="1000">${summaryData.visitor}</textarea></td>
					
				</tr>
			</table>
		
		</td>
	</tr>

	<tr>
		<td colspan="5" style="height: 20px;text-align: left;"><b>Special Notes</b></td>
	</tr>
	<tr>
		<td colspan="5" style="height: 20px;">
			<textarea style="width: 99%;" name="notes" maxlength="1000">${summaryData.notes}</textarea>
		</td>
	</tr>
	
						
	</table>
<br>
<br>


</div>



			</div>

		</div>


	</div>


</body>
</html>
