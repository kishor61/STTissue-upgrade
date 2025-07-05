<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" contant="IE=edge" />
<title><spring:message code="app.name" /></title>
<link rel="stylesheet" type="text/css"  href='<spring:url value="/resources/css/style.css"/>'>
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/chart/jquery.jqplot.css"/>'>


<style type="text/css">
@media print {
	button {
		display: none;
	}
	.optionTable {
		display: none;
	}
	hr {
		display: none;
	}
	div {
		page-break-inside: avoid;
	}
	html, body {
		width: 210mm;
	}
}
</style>

<!--[if lt IE 9]>
<script type="text/javascript" src='<spring:url value="/resources/js/chart/excanvas.min.js"/>'></script>
<![endif]-->






<script type="text/javascript" src='<spring:url value="/resources/js/jquery.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/chart/jquery.jqplot.min.js"/>'></script>


<script type="text/javascript" src='<spring:url value="/resources/js/chart/plugins/jqplot.canvasOverlay.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/chart/plugins/jqplot.dateAxisRenderer.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/chart/plugins/jqplot.enhancedLegendRenderer.min.js"/>'></script>



<script type="text/javascript">
	$(function() {
		$('#actualBasis').click(function() {
			$('#actualBasisChart').toggle();
		});
		$('#bulk').click(function() {
			$('#bulkChart').toggle();
		});
		$('#mdTensile').click(function() {
			$('#mdTensileChart').toggle();
		});
		$('#cdTensile').click(function() {
			$('#cdTensileChart').toggle();
		});
		$('#mdStrech').click(function() {
			$('#mdStrechChart').toggle();
		});
		
		$('#brightness').click(function() {
			$('#brightnessChart').toggle();
		});
	});
	
	
function createPDF(){
	$('input[name=actualBasisflag]').val($('#actualBasis').prop('checked'));
	if($('#actualBasis').prop('checked')){
		$('input[name=actualBasis]').val($('#actualBasisChart').jqplotToImageStr({}));	
	}
	
	
	$('input[name=bulkflag]').val($('#bulk').prop('checked'));
	if($('#bulk').prop('checked')){
		$('input[name=bulk]').val($('#bulkChart').jqplotToImageStr({}));	
	}
	
	
	$('input[name=mdTensileflag]').val($('#mdTensile').prop('checked'));
	if($('#mdTensile').prop('checked')){
		$('input[name=mdTensile]').val($('#mdTensileChart').jqplotToImageStr({}));	
	}
	
	
	$('input[name=cdTensileflag]').val($('#cdTensile').prop('checked'));
	if($('#cdTensile').prop('checked')){
		$('input[name=cdTensile]').val($('#cdTensileChart').jqplotToImageStr({}));
	}
	
	
	$('input[name=mdStrechflag]').val($('#mdStrech').prop('checked'));
	if($('#mdStrech').prop('checked')){
		$('input[name=mdStrech]').val($('#mdStrechChart').jqplotToImageStr({}));
	}
	
	$('input[name=brightnessflag]').val($('#brightness').prop('checked'));
	if($('#brightness').prop('checked')){
		$('input[name=brightness]').val($('#brightnessChart').jqplotToImageStr({}));
	}
	
	
	
	$('#pdfForm').submit();
}	
</script>

</head>
<body style="overflow: auto;">
	<spring:url value="/qualitygraph/export/pdf" var="pdfURL"/>
	<form id="pdfForm" action="${pdfURL}" style="display: none;" method="post" target="_blank">
		
		<input type="hidden" name="actualBasisflag" value="">
		<input type="hidden" name="actualBasis" value="">
		
		<input type="hidden" name="bulkflag" value="">
		<input type="hidden" name="bulk" value="">
	
		<input type="hidden" name="mdTensileflag" value="">
		<input type="hidden" name="mdTensile" value="">
	
		<input type="hidden" name="cdTensileflag" value="">
		<input type="hidden" name="cdTensile" value="">
		
		<input type="hidden" name="mdStrechflag" value="">
		<input type="hidden" name="mdStrech" value="">
		
		<input type="hidden" name="brightnessflag" value="">
		<input type="hidden" name="brightness" value="">
	
	
	</form>
	
	
	<table class="optionTable" style="margin: auto;">
		<tr>
			<td><input type="checkbox" checked="checked" id="actualBasis"><label for="actualBasis">Actual Basis </label></td>
			<td>&nbsp;&nbsp;</td>
			<td><input type="checkbox" checked="checked" id="bulk"><label for="bulk">Bulk</label></td>
			<td>&nbsp;&nbsp;</td>
			<td><input type="checkbox" checked="checked" id="mdTensile"><label for="mdTensile">MD Tensile</label></td>
			<td>&nbsp;&nbsp;</td>
			<td><input type="checkbox" checked="checked" id="cdTensile"><label for="cdTensile">CD Tensile</label></td>
			<td>&nbsp;&nbsp;</td>
			<td><input type="checkbox" checked="checked" id="mdStrech"><label for="mdStrech">MD Stretch</label></td>
			<td>&nbsp;&nbsp;</td>
			<td><input type="checkbox" checked="checked" id="brightness"><label for="brightness">Brightness</label></td>
			
		</tr>
	</table>
	<hr>
	<br>

<div style="width: 800px;height: auto;margin: auto;">
	<!--  -->
	<div id="actualBasisChart" style="width: 98%; height: 400px; margin-bottom: 20px;"></div>

	<div id="bulkChart" style="width: 98%; height: 400px; margin-bottom: 20px;"></div>

	<div id="mdTensileChart" style="width: 98%; height: 400px;  margin-bottom: 20px;"></div>

	<div id="cdTensileChart" style="width: 98%; height: 400px;  margin-bottom: 20px;"></div>

	<div id="mdStrechChart" style="width: 98%; height: 400px;  margin-bottom: 20px;"></div>
	
	<div id="brightnessChart" style="width: 98%; height: 400px;  margin-bottom: 20px;"></div>
	
</div>
	<br>

	<spring:url value="/qualitygraph/graph/data" var="loadGraphDataURL" />
	<script type="text/javascript">
		$(function() {
			$.ajax({
				url : '${loadGraphDataURL}',
				type : 'POST',
				data : {
					sdate : '${sdate}',
					edate : '${edate}',
					gradeCode : '${gradeCode}',
					customer : '${customer}'
				},
				success : function(data) {

					setGraph(data);

				}
			});
		});
	</script>

	<script type="text/javascript">
		function setGraph(data) {

		//
		parent.showPrintBtn();
	
			
			
			/* Actual Basis */
			{
				var targetS = [];
				var minS = [];
				var maxS = [];
				var reelS = [];
				var winderS = [];

				$.each(data.actualBasisReels, function(index, value) {
					targetS.push([ value.x, data.actualBasisTarget ]);
					
					if(data.actualBasisMinR!=0){
						minS.push([ value.x, data.actualBasisMinR ]);
					}
					
					if(data.actualBasisMaxR!=0){
						maxS.push([ value.x, data.actualBasisMaxR ]);	
					}
					
					reelS.push([ value.x, value.y ]);
				});
			 	$.each(data.actualBasisRewinds, function(index, value) {
					winderS.push([ value.x, value.y ]);
				}); 

				var max = reelS.length;

				var grid = {
					gridLineWidth : 1.5,
					gridLineColor : 'rgb(235,235,235)',
					drawGridlines : true
				};
				
				
				$.jqplot('actualBasisChart', [ targetS, reelS, winderS,minS,maxS], {
					title : 'Actual Basis wt lbs/3000ft',
					series : [ {
						renderer : $.jqplot.BarRenderer,
						rendererOptions : {
							barWidth : 30
						}
					} ],
					axes : {
						xaxis : {
							renderer:$.jqplot.DateAxisRenderer,
							tickOptions:{formatString:'%b %#d, %#I %p'},
						}
					},
					grid : grid,
					legend : {
						renderer : $.jqplot.EnhancedLegendRenderer,
						show : true,
						location : 's',
						placement : 'outsideGrid',
						rendererOptions : {
							numberRows : 1
						}
					},
					series : [ {
						label : 'Target(' + data.actualBasisTarget + ')',
						color : '#00FF00',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					}, {
						label : 'Reel',
						color : '#FACC2E',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Rewinder',
						color : '#B404AE',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Reject Min(' + data.actualBasisMinR + ')',
						color : '#B40404',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					},  {
						label : 'Reject Max(' + data.actualBasisMaxR + ')',
						color : '#FE2E2E',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					} ], 
				});
			}
		
			// Bulk  
			{
				var targetS = [];
				var minS = [];
				var maxS = [];
				var reelS = [];
				var winderS = [];

				$.each(data.bulkReels, function(index, value) {
					targetS.push([ value.x, data.bulkTarget ]);
					if(data.bulkMinR!=0){
						minS.push([ value.x, data.bulkMinR ]);
					}
					
					if(data.bulkMaxR!=0){
						maxS.push([ value.x, data.bulkMaxR ]);	
					}
					reelS.push([ value.x, value.y ]);
				});
				$.each(data.bulkRewinds, function(index, value) {
					winderS.push([ value.x, value.y ]);
				});

				var max = reelS.length;

				var grid = {
					gridLineWidth : 1.5,
					gridLineColor : 'rgb(235,235,235)',
					drawGridlines : true
				};

				$.jqplot('bulkChart', [ targetS, reelS, winderS,minS,maxS], {
					title : 'Bulk mils/8 ply',
					series : [ {
						renderer : $.jqplot.BarRenderer,
						rendererOptions : {
							barWidth : 30
						}
					} ],
					axes : {
						xaxis : {
							renderer:$.jqplot.DateAxisRenderer,
							tickOptions:{formatString:'%b %#d, %#I %p'},
						}
					},
					grid : grid,
					legend : {
						renderer : $.jqplot.EnhancedLegendRenderer,
						show : true,
						location : 's',
						placement : 'outsideGrid',
						rendererOptions : {
							numberRows : 1
						}
					},
					series : [ {
						label : 'Target(' + data.bulkTarget + ')',
						color : '#00FF00',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					}, {
						label : 'Reel',
						color : '#FACC2E',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Rewinder',
						color : '#B404AE',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Reject Min(' + data.bulkMinR + ')',
						color : '#B40404',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					},  {
						label : 'Reject Max(' + data.bulkMaxR + ')',
						color : '#FE2E2E',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					}  ],
				});
			}
			
			// Md Tensile  
			{
				var targetS = [];
				var minS = [];
				var maxS = [];
				var reelS = [];
				var winderS = [];

				$.each(data.mdTensileReels, function(index, value) {
					targetS.push([ value.x, data.mdTensileTarget ]);
					if(data.mdTensileMinR!=0){
						minS.push([ value.x, data.mdTensileMinR ]);
					}
					
					if(data.mdTensileMaxR!=0){
						maxS.push([ value.x, data.mdTensileMaxR ]);	
					}
					reelS.push([ value.x, value.y ]);
				});
				$.each(data.mdTensileRewinds, function(index, value) {
					winderS.push([ value.x, value.y ]);
				});

				var max = reelS.length;

				var grid = {
					gridLineWidth : 1.5,
					gridLineColor : 'rgb(235,235,235)',
					drawGridlines : true
				};

				$.jqplot('mdTensileChart', [ targetS, reelS, winderS,minS,maxS], {
					title : 'MD Tensile g/inch',
					series : [ {
						renderer : $.jqplot.BarRenderer,
						rendererOptions : {
							barWidth : 30
						}
					} ],
					axes : {
						xaxis : {
							renderer:$.jqplot.DateAxisRenderer,
							tickOptions:{formatString:'%b %#d, %#I %p'},
						}
					},
					grid : grid,
					legend : {
						renderer : $.jqplot.EnhancedLegendRenderer,
						show : true,
						location : 's',
						placement : 'outsideGrid',
						rendererOptions : {
							numberRows : 1
						}
					},
					series : [ {
						label : 'Target(' + data.mdTensileTarget + ')',
						color : '#00FF00',
						markerOptions : {
							size : 7,
							style : "x"
						},
						lineWidth : 1,
					}, {
						label : 'Reel',
						color : '#FACC2E',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Rewinder',
						color : '#B404AE',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Reject Min(' + data.mdTensileMinR + ')',
						color : '#B40404',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					},  {
						label : 'Reject Max(' + data.mdTensileMaxR + ')',
						color : '#FE2E2E',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					}  ],
				});
			}

			// CD Tensile  
			{
				var targetS = [];
				var minS = [];
				var maxS = [];
				var reelS = [];
				var winderS = [];

				$.each(data.cdTensileReels, function(index, value) {
					targetS.push([ value.x, data.cdTensileTarget ]);
					if(data.cdTensileMinR!=0){
						minS.push([ value.x, data.cdTensileMinR ]);
					}
					
					if(data.cdTensileMaxR!=0){
						maxS.push([ value.x, data.cdTensileMaxR ]);	
					}
					reelS.push([ value.x, value.y ]);
				});
				$.each(data.cdTensileRewinds, function(index, value) {
					winderS.push([ value.x, value.y ]);
				});

				var max = reelS.length;

				var grid = {
					gridLineWidth : 1.5,
					gridLineColor : 'rgb(235,235,235)',
					drawGridlines : true
				};

				$.jqplot('cdTensileChart',[ targetS, reelS, winderS,minS,maxS], {
					title : 'CD Tensile g/inch',
					series : [ {
						renderer : $.jqplot.BarRenderer,
						rendererOptions : {
							barWidth : 30
						}
					} ],
					axes : {
						xaxis : {
							renderer:$.jqplot.DateAxisRenderer,
							tickOptions:{formatString:'%b %#d, %#I %p'},
						}
					},
					grid : grid,
					legend : {
						renderer : $.jqplot.EnhancedLegendRenderer,
						show : true,
						location : 's',
						placement : 'outsideGrid',
						rendererOptions : {
							numberRows : 1
						}
					},
					series : [ {
						label : 'Target(' + data.cdTensileTarget + ')',
						color : '#00FF00',
						markerOptions : {
							size : 7,
							style : "x"
						},
						lineWidth : 1,
					}, {
						label : 'Reel',
						color : '#FACC2E',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Rewinder',
						color : '#B404AE',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Reject Min(' + data.cdTensileMinR + ')',
						color : '#B40404',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					},  {
						label : 'Reject Max(' + data.cdTensileMaxR + ')',
						color : '#FE2E2E',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					}  ],
				});
			}

			// MD Strech 
			{
				var targetS = [];
				var minS = [];
				var maxS = [];
				var reelS = [];
				var winderS = [];

				$.each(data.mdStretchReels, function(index, value) {
					targetS.push([ value.x, data.mdStretchTarget ]);
					if(data.mdStretchMinR!=0){
						minS.push([ value.x, data.mdStretchMinR ]);
					}
					
					if(data.mdStretchMaxR!=0){
						maxS.push([ value.x, data.mdStretchMaxR ]);	
					}
					reelS.push([ value.x, value.y ]);
				});
				$.each(data.mdStretchRewinds, function(index, value) {
					winderS.push([ value.x, value.y ]);
				});

				var max = reelS.length;

				var grid = {
					gridLineWidth : 1.5,
					gridLineColor : 'rgb(235,235,235)',
					drawGridlines : true
				};

				$.jqplot('mdStrechChart', [ targetS, reelS, winderS,minS,maxS], {
					title : 'MD % Stretch',
					series : [ {
						renderer : $.jqplot.BarRenderer,
						rendererOptions : {
							barWidth : 30
						}
					} ],
					axes : {
						xaxis : {
							renderer:$.jqplot.DateAxisRenderer,
							tickOptions:{formatString:'%b %#d, %#I %p'},
						}
					},
					grid : grid,
					legend : {
						renderer : $.jqplot.EnhancedLegendRenderer,
						show : true,
						location : 's',
						placement : 'outsideGrid',
						rendererOptions : {
							numberRows : 1
						}
					},
					series : [ {
						label : 'Target(' + data.mdStretchTarget + ')',
						color : '#00FF00',
						markerOptions : {
							size : 7,
							style : "x"
						},
						lineWidth : 1,
					}, {
						label : 'Reel',
						color : '#FACC2E',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Rewinder',
						color : '#B404AE',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Reject Min(' + data.mdStretchMinR + ')',
						color : '#B40404',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					},  {
						label : 'Reject Max(' + data.mdStretchMaxR + ')',
						color : '#FE2E2E',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					}  ],
				});
			}
			
			
			// Brightness 
			{
				var targetS = [];
				var minS = [];
				var maxS = [];
				var reelS = [];
				var winderS = [];

				$.each(data.brightnessReels, function(index, value) {
					targetS.push([ value.x, data.brightnessTarget ]);
					if(data.brightnessMinR!=0){
						minS.push([ value.x, data.brightnessMinR ]);
					}
					
					if(data.brightnessMaxR!=0){
						maxS.push([ value.x, data.brightnessMaxR ]);	
					}
					reelS.push([ value.x, value.y ]);
				});
				$.each(data.brightnessRewinds, function(index, value) {
					winderS.push([ value.x, value.y ]);
				});

				var max = reelS.length;

				var grid = {
					gridLineWidth : 1.5,
					gridLineColor : 'rgb(235,235,235)',
					drawGridlines : true
				};

				$.jqplot('brightnessChart', [ targetS, reelS, winderS,minS,maxS], {
					title : 'Brightness',
					series : [ {
						renderer : $.jqplot.BarRenderer,
						rendererOptions : {
							barWidth : 30
						}
					} ],
					axes : {
						xaxis : {
							renderer:$.jqplot.DateAxisRenderer,
							tickOptions:{formatString:'%b %#d, %#I %p'},
						}
					},
					grid : grid,
					legend : {
						renderer : $.jqplot.EnhancedLegendRenderer,
						show : true,
						location : 's',
						placement : 'outsideGrid',
						rendererOptions : {
							numberRows : 1
						}
					},
					series : [ {
						label : 'Target(' + data.brightnessTarget + ')',
						color : '#00FF00',
						markerOptions : {
							size : 7,
							style : "x"
						},
						lineWidth : 1,
					}, {
						label : 'Reel',
						color : '#FACC2E',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Rewinder',
						color : '#B404AE',
						markerOptions : {
							style : "filledSquare",
							size : 10
						}
					}, {
						label : 'Reject Min(' + data.brightnessMinR + ')',
						color : '#B40404',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					},  {
						label : 'Reject Max(' + data.brightnessMaxR + ')',
						color : '#FE2E2E',
						markerOptions : {
							size : 4,
							style : "x"
						},
						lineWidth : 1,
					}  ],
				});
			}
			
		}
	</script>

</body>
</html>
