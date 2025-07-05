<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<spring:url value="/manintenancelog/save" var="saveURL" />
<spring:url value="/manintenancelog/delete" var="deletewinderDataURL" />
<spring:url value="/manintenancelog/view" var="oldDataURL" />
<!-- <script type="text/javascript">
$(function(){
	$('input[name=Proddate],input[name=Targetdate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>  -->

<script type="text/javascript">
var centerlineGrades=${centerlineGrades};

$(function(){
$('#yielddatatable tbody input[name=prodtypeorgradecode]').autocomplete({
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
function split( val ) {
    return val.split( /,\s*/ );
}
function extractLast( term ) {
	  return split( term ).pop();
}	
	
});
</script>
<script type="text/javascript">
	$(function(){
		 $('input[name=eedate],input[name=date]').datepicker({
			dateFormat : 'mm-dd-yy',
			changeMonth : true,
			changeYear : true,
			maxDate : 0
		});
		
		$('#loadDataBtn').click(function(){
			var shiftDate=$('input[name=shiftdate]').val();
			var odate=$('input[name=eedate]').val();
			
			
			if(shiftDate!=odate){
				var flag=confirm("Do you want to load old data?");
				if(flag){
					location.href='${oldDataURL}/'+odate;
				}
			}else{
				location.href='${oldDataURL}';
			}
		});
		
		
		
	});
</script>
<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;
 $(function(){
		$('#yielddatatable tbody input, #yielddatatable tbody select').focusin(doFocusIn);
		$('#yielddatatable tbody input, #yielddatatable tbody select').focusout(doFocusOut);
		
		$('#yielddatatable tbody textarea, #yielddatatable tbody textarea').focusout(doFocusOut);
		
		 $('#addRowBtn').click(function(){
			
			var date = new Date(); //New Logic Applied By Roshan Tailor
			var currentmonth=(date.getMonth() + 1);
			var currentdate=date.getDate();
			var currentyeare=date.getFullYear();
			var mdy;
			
			if(currentmonth<10){
				 currentmonth='0'+currentmonth
				 mdy=(currentmonth + '-' + currentdate + '-' + currentyeare); //New Logic Applied By Roshan Tailor
			}else{
				mdy=(date.getMonth() + 1) + '-' + date.getDate() + '-' +  date.getFullYear();
			}
			var currenttime = date.getHours() + ":" + date.getMinutes();
			
			var otr = $('#yielddatatable tbody tr:last');
			var tr = $('#yielddatatable tbody tr:last').clone();
			var ntr = tr.appendTo($('#yielddatatable tbody'));
			console.log(ntr)
			
			ntr.find('input').val('');
			ntr.find('select').val('');
			ntr.find('input[name=date]').removeAttr('id');
			ntr.find('input[name=date]').removeAttr('class');
			ntr.find('input[name=date]').val(mdy); //New Logic Applied By Roshan Tailor
			ntr.find('input[name=time]').val(currenttime);
			
			
			var text = ntr.find('select[name=skuCode]').val($("#skuCode option:selected" ).parent().parent().parent().text()); // Find the text
		    //alert(text);
			
			ntr.find('select[name=area]').val($("#area option:selected" ).text());
			ntr.find('textarea[name=comments]').val($("" ).text());
			  
			ntr.find('input[name=date]').val($('#date').val());
			
			
			
			var target='${target}';
			if(target==='ADMIN' || target==='OPERATOR' || target==='OPERATOR4'){
				ntr.find('input[name=prodtypeorgradecode]').removeAttr('id');
				ntr.find('input[name=prodtypeorgradecode]').removeAttr('class');
				ntr.find('input[name=prodtypeorgradecode]').autocomplete({
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
				
				function split( val ) {
				    return val.split( /,\s*/ );
				}
				function extractLast( term ) {
					  return split( term ).pop();
				}	
					
			}else{
				ntr.find('select[name=prodtypeorgradecode]').val($("#prodtypeorgradecode option:selected" ).text());
			}
			
			ntr.find('input[name=time]').focus();
			ntr.find('input').focusin(doFocusIn);
			ntr.find('select').focusin(doFocusIn);
			ntr.find('input').focusout(doFocusOut);
			ntr.find('select').focusout(doFocusOut);
			
		}); 
		
	});
 
	function validatePQ(tb){
		if($.trim(tb.val())!=''){
			if( 
				(tb.attr('name')=='date')|
				(tb.attr('name')=='prodtypeorgradecode')|
				(tb.attr('name')=='area')|
				(tb.attr('name')=='error')|
				(tb.attr('name')=='comments')|
				(tb.attr('name')=='prodtypeorgradecode')|
				(tb.attr('name')=='team')|
				(tb.attr('name')=='shift')
			)
			{
				//Do Nothing 
					}
			else if(isNaN(tb.val())){
				alert('Enter a valid number.');
				setTimeout(function(){tb.focus();}, 10);
				saveLock=true;
				return true;
			}
		}
		saveLock=false;
		return false;
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
	
	
	function uploadFile() {
  
		 console.log("file",f1);
		  //var file = $('#file').val();
		  
		  var filename = tr.find('input[name=comments]').val().replace(/C:\\fakepath\\/i, '')
		  console.log("file",filename)
		  f1 = i.concat("_").concat(filename);
		  console.log("bankstatement1",f1)
}
	
</script>
<script type="text/javascript">
var f1=''
function saveData(jq){
	$('#tmessage').text('');
	clearTimeout(clearTimer);
	
	var tr=jq.parent().parent();
	
	var id=tr.find('input[name=id]').val();
	var idEle=tr.find('input[name=id]');
	
	var date=tr.find('input[name=date]').val();
	
	var target='${target}';
	var prodtypeorgradecode='';
	if(target==='Admin' || target==='OPERATOR' || target==='OPERATOR4'){
		prodtypeorgradecode=tr.find('input[name=prodtypeorgradecode]').val();	
	}else{
		prodtypeorgradecode=tr.find('select[name=prodtypeorgradecode]').val();	
	}
	
	var area=tr.find('select[name=area]').val();
	var error=tr.find('input[name=error]').val();
	var comments=tr.find('textarea[name=comments]').val();
	
	var shift=tr.find('select[name=shift]').val();
	var team=tr.find('select[name=team]').val();
	 
	 
	//alert(id); 
	
	 
	
	var date=tr.find('input[name=date]').val();
	if(typeof date==='undefined'){
		date='';
	}
	var target1='${target}';
	var prodtypeorgradecode='';
	if(target1==='ADMIN' || target1==='OPERATOR' || target1==='OPERATOR4'){
		prodtypeorgradecode=tr.find('input[name=prodtypeorgradecode]').val();
		if(typeof prodtypeorgradecode==='undefined'){
			prodtypeorgradecode='';
		}
	}else{
		prodtypeorgradecode=tr.find('select[name=prodtypeorgradecode]').val();
		if(typeof prodtypeorgradecode==='undefined'){
			prodtypeorgradecode='';
		}
	}
	
	
	var area=tr.find('select[name=area]').val();
	if(typeof area==='undefined'){
		area='';
	}
	 
	var error=tr.find('input[name=error]').val();
	if(typeof error==='undefined'){
		error='';
	}
	
	var comments=tr.find('textarea[name=comments]').val();
	if(typeof comments==='undefined'){
		comments='';
	}
	
	var shift=tr.find('select[name=shift]').val();
	if(typeof shift==='undefined'){
		shift='';
	}
	
	var team=tr.find('select[name=team]').val();
	if(typeof team==='undefined'){
		team='';
	}
	
	
	if(saveLock){
		return;
	}
	saveLock=true;
	$('#loadPage').show();
	$.ajax({
		url:'${saveURL}',
		type:'POST',
		data:{
			id : id,
			date : date,
			prodtypeorgradecode : prodtypeorgradecode,
			area : area,
			error : error,
			comments : comments,
			team : team,
			shift : shift
		},
		success:function(data){
			
			//countTotalDuration();
			
			var lotEle=tr.find('input[name=lot]');
			
			if(data.status){
				idEle.val(data.id);
				$('#tmessage').text(data.message);
				clearTimer=setTimeout(function(){$('#tmessage').text('');}, 5000);
				location.reload();
				if(lotEle){
					lotEle.removeClass('redBorder');
				}
				
			}else{
				
				if(data.ERLOT){
					setTimeout(function(){lotEle.focus();}, 100);
					lotEle.addClass('redBorder');
					alert(data.error);
				}else{
					alert(data.error);
				}
				
			}
			saveLock=false;
		},
		error: function(xhr, status, error) {
			$('#loadPage').hide();
			alert('Server error.. :-(' );
			saveLock=false;
		}
	});	
}
 

</script>
<script type="text/javascript">
$(function(){
	$('#deleterowbutton').click(function()
		{
		var dbtn=$(this);
		var val=$('#yielddatatable tbody input[name=id]:checked').val();
		if(typeof val==='undefined'){
			alert('Select row');
		}else{
			if(val==''){
				alert("First Row Can't Delete.");
				//$('#yielddatatable tbody input[name=id]:checked').parent().parent().remove();
			}else{
				dbtn.attr('disabled','disabled');
				$.ajax({
					url:'${deletewinderDataURL}',
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
</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>
		
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div
		          class="content-header"
		          style="
		            padding-top: 10px !important;
		            padding-bottom: 0px !important;
		            line-height: 0px !important;
		          "
		><h5 style="text-align:center; font-weight:bold;color:#343e70;">Log Data Entry</h5></div>


	

	


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">
				
				<div class="table-selector"  style="background-color:#c2eadf73 !important; border: 1px solid #7e00ff42;">
					
					<table>
						<tr>
							<td>
								<spring:url value="/manintenancelog/page/shift" var="dayPath"/>
								<button onclick="window.location.href='${dayPath}?shift=Day'"class="btn btn-info btn-sm">Day Shift Logs Entry</button>
							</td>
							<td>
								<spring:url value="/manintenancelog/page/shift" var="nightPath"/>
								<button onclick="window.location.href='${nightPath}?shift=Night'"class="btn btn-info btn-sm">Night Shift Logs Entry</button>
							</td>
						</tr>
					</table>
				

				</div>

			</div>

		</div>

		<!--<div class="page-box" id="loadPage">
								<div style="margin-top: 200px;">
									<img alt="Loading" src='<spring:url value="/dist/images/ajax-loader.gif"/>'>
								</div>
						</div>-->
						
	</div>
	<!-- /.content-wrapper -->
	                   <footer class="main-footer" style="text-align:center;color:black; height:20px;">
	                       <strong> Copyright Barnwell Tissue Solutions 2025 </strong>
	                   </footer>
</div>
</body>
</html>
