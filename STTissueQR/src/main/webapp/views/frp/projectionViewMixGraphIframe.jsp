<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<!--[if lt IE 9]>
<script type="text/javascript" src='<spring:url value="/resources/js/chart/excanvas.min.js"/>'></script>
<![endif]-->





<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/chart/jquery.jqplot.css"/>'>
<script type="text/javascript" src='<spring:url value="/resources/js/chart/jquery.jqplot.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/chart/plugins/jqplot.barRenderer.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/chart/plugins/jqplot.categoryAxisRenderer.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/chart/plugins/jqplot.pointLabels.min.js"/>'></script>

<style type="text/css">
body {
	padding: 10px;	
	overflow: auto;
}
.jqplot-point-label{
font-size: 12px;
}
</style>



</head>
<body>
<jsp:include page="../_loader.jsp"/>
	
<div style="display: block; margin: auto; width: 90%; height: 450px;">
	
	<table id="tableBrightness" style="margin: auto;display: none;">
		<tr>
			<td>FRP Brightness : </td>
			<td><div id="frpBrightness" style="margin-right: 20px;"></div></td>
			<td>Machine Brightness : </td>
			<td><div id="mchBrightness" style="margin-right: 20px;"></div></td>
		</tr>
	</table>
	<br>
	<div id="graph" style="width: inherit ; height:inherit ; margin: auto;">
		
	</div>
	
	
</div>

<spring:url value="/frpprojectionmix/viewgraphdata/${grade}/${type}" var="viewGraphURL" />
<script type="text/javascript">
$(function(){
	
	
	$('#loadPage').show();
	
	$.ajax({
		url:'${viewGraphURL}',
		type:'POST',
		success:function(data){
		//	alert(JSON.stringify(data));
			$('#loadPage').hide();
			setGraph(data);
			
			$('#frpBrightness').text(data.avgFrpBrightness);
			$('#mchBrightness').text(data.avgMachineBrightness);
			$('#tableBrightness').show();
		},
		error: function(xhr, status, error) {
			alert('Server Error..');
			location.reload(true);
		}
	});
	function setGraph(data){
		var s1 = data.targets;
	  	var s2 = data.consumptions;
	     
	    var ticks = data.gradeCodes;
	    var color= data.colors;
	    
	    $.jqplot('graph', [s1,s2], {
	    	 title:'FRP MIX GRAPH ('+data.sdate+' To '+data.edate+')',
	    	 series:[
	    	         
	    	         {label :'Target',color:'#013ADF',seriesColors:['#013ADF','#013ADF','#013ADF','#013ADF','#013ADF']},
	    	       	 {label :'Consumed',color:'white',seriesColors:color}
	    	 ],      
	    	 
	    	 stackSeries: false,
	    	 seriesDefaults: {
	             renderer:$.jqplot.BarRenderer,
	             pointLabels: { show: true },
			     rendererOptions: {
			      varyBarColor: true
			     },
			     barMargin: 30, 
	         },
	         axes: {
	             xaxis: {
	                 renderer: $.jqplot.CategoryAxisRenderer,
	                 ticks: ticks,
	                // tickOptions:{formatString:'%d\%'}
	             },
	             yaxis: {
	                // renderer: $.jqplot.CategoryAxisRenderer,
	                 tickOptions:{formatString:'%#.2f\%'}
	             }
	         },
	         
	        legend: {
	             show: true,
	             location: 'e',
	             placement: 'outside'
	         }
	     }); 
	}
	setTimeout(function(){location.reload(true);}, 300000);
});
</script>
</body>
</html>
