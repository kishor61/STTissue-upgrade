<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
	.table th, .table td{
		font-size: 10px;
	}
	.table th div,.table td div{
		font-size: 10px;
		display: block;
		text-align: center;
		
	}
	.table td{
		border: 1px solid gray !important;
	}
</style>

<script type="text/javascript">
	$(function(){
		$('input[name=sdate]').datepicker({
			dateFormat:'mm-dd-yy',
			defaultDate: "+1w",
			changeMonth: true,
		    changeYear: true,
		    onClose: function( selectedDate ) {
		        $( "input[name=edate]" ).datepicker( "option", "minDate", selectedDate );
		     }
		});
		$('input[name=edate]').datepicker({
			dateFormat:'mm-dd-yy',
			defaultDate: "+1w",
			changeMonth: true,
		    changeYear: true,
		    onClose: function( selectedDate ) {
		        $( "input[name=sdate]" ).datepicker( "option", "maxDate", selectedDate );
		     }
		});
	});

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
					<span class="label">Fiber Purchasing</span>
				</div>
				
				<div class="table-selector" style="padding: 0px;margin: 1px 0 1px 0;">
				<%-- <spring:url value="/frpprojection/view/data" var="viewDataURL" /> --%>
				
					<table style="margin: auto;">
						<tr>
							<td>
								Start Date
							 </td>
							 <td>
							 	<input type="text" name="sdate" value="${sdate}" style="width: 100px;" readonly="readonly">
							 </td>
							 <td>
								End Date
							 </td>
							 <td>
							 	<input type="text" name="edate" value="${edate}" style="width: 100px;" readonly="readonly">
							 </td>
							
							 <td>
							 	<input type="hidden" name="oldtype" value="${oldtype}">
							 	<button id="viewDataBtn">Load Data</button>
							 	<button id="exportBtn">Export</button>
							 </td>
							 <td> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
							 	<button id="newFormulaBtn">Create/Edit Formula</button>
							 </td>
							 
						</tr>
					</table>
					
<spring:url value="/fiberpurchasingreport/view/data" var="viewDataURL"/>				
<script type="text/javascript">
	$(function(){
		$('#viewDataBtn').click(function(){
			
			var projIds=[];
			$('select[name=projectionId]').each(function(){
				projIds.push($(this).val());
			});
			
			var data={
					sdate: $('input[name=sdate]').val(),
					edate: $('input[name=edate]').val(),
					//type: $('select[name=type]').val(),
					//oldtype : $('input[name=oldtype]').val(),
					r : 'N',
					pid : projIds
			};
			location.href='${viewDataURL}?'+$.param(data);
		});		
	});
</script>

					
				</div>
<br>

<c:if test="${showFlag }">
<spring:url value="/fiberpurchasingreport/export" var="exportURL"/>
<form id="exportFrom" action="${exportURL }" method="post">
	<input type="hidden" name="sdate" value="${sdate}">
	<input type="hidden" name="edate" value="${edate}">
	<input type="hidden" name="type" value="${type}">
	<c:forEach items="${productIds}" var="pid">
		<input type="hidden" name="pid[]" value="${pid}">
	</c:forEach>
</form>
<input type="hidden" name="sdateO" value="${sdate}">
<input type="hidden" name="edateO" value="${edate}">
<input type="hidden" name="typeO" value="${type}">

<script type="text/javascript">
	$(function(){
		

		$('.phyprop').qtip({
			 content: {
				text:function(event, api) {
		           var id=$(this).val();
		           var txt=$(this).find('option[value='+id+']').attr('title').split('##');
		           var txtTip='';
		           for(var i=0;i<txt.length;i++){
		        	   txtTip+=txt[i]+'<br/>';
		           }
		            return txtTip;
		        },
			    title: 'Physical Properties'
			  },
			  position: {
			        my: 'bottom center',
			        at: 'top center'
			 }
		});
		
		$('#exportBtn').click(function(){
			$('#exportFrom').submit();
		});
		
		$('select[name=projectionId]').change(function(){
			var projIds=[];
			$('select[name=projectionId]').each(function(){
				projIds.push($(this).val());
			});
			
			var data={
					sdate: $('input[name=sdateO]').val(),
					edate: $('input[name=edateO]').val(),
				//	type: $('input[name=typeO]').val(),
				//	oldtype : $('input[name=oldtype]').val(),
					r : 'O',
					pid : projIds
			};
			$('#loadPage').show();
			location.href='${viewDataURL}?'+$.param(data);
		});
	});

</script>


<div style="position: fixed;overflow: auto;top: 120px;bottom: 0px;width: 98%;left: 11px;right: 5px;">	


	<table class="table" style="width: auto;margin: auto;">
		<tr>
			<th>&nbsp;</th>
			<th></th>
			<th></th>
			<td style="padding: 0;margin: 0;vertical-align: top;" rowspan="${fn:length(projectionData.projectionDatas)+17}">
			
				<!-- Scrollo Data -->
				<div style="height: inherit;width:700px; overflow: auto; border: 1px;margin-top: -3px;">
				<!-- <div style="height: inherit;width:1300px; overflow: auto; border: 1px;margin-top: -3px;"> -->
					<table class="table">
						<tr>
							<c:forEach begin="0" end="${projectionData.length}">
								<th style="width: 80px;"><div>Inbound</div></th>
							</c:forEach>
							<th rowspan="3">Total</th>
						</tr>
						<tr>
							<c:forEach items="${projectionData.days}" var="day">
								<th style="width: 80px;"><div>${day}</div></th>
							</c:forEach>
							
						</tr>
						<tr>
							<c:forEach items="${projectionData.dates}" var="date">
								<th style="width: 80px;"><div>${date}</div></th>
							</c:forEach>
						</tr>
						
						
						<c:set var="netTotal" value="${0}"/>
						
						<c:forEach items="${projectionData.projectionDatas}" var="pdata">
							<tr>
								<c:set var="total" value="${pdata.weight}"/>
								<c:forEach items="${pdata.inbounds}" var="inboud">
									<td style="width:80px;"><div>${inboud}</div></td>
									<c:set var="total"  value="${total+inboud}"/>
								</c:forEach>
								<td style="width:80px;"><div><fmt:formatNumber value="${total}" maxFractionDigits="2"/> </div></td>
								<c:set var="netTotal" value="${netTotal+total}"/>
							</tr>
						</c:forEach>
						
						<tr>
							<c:forEach begin="0" end="${projectionData.length}" varStatus="index">
								<c:set var="inboundTotal" value="${0}"/>
								<c:forEach items="${projectionData.projectionDatas}" var="inboud">
									<c:set var="inboundTotal" value="${inboundTotal+inboud.inbounds[index.index]}"/>
								</c:forEach>
								<td style="width:80px;"><div><b><fmt:formatNumber value="${inboundTotal}" maxFractionDigits="2"/></b> </div></td>
							</c:forEach>
							<td style="width:80px;"><div><b><fmt:formatNumber value="${netTotal}" maxFractionDigits="2"/></b></div></td>
						</tr>
						<tr>
							<td colspan="${projectionData.length+2}" style="height: 20px;">&nbsp;</td>
						</tr>
						
						<tr>
							<c:forEach items="${projectionData.mwlAndSwl}" var="mwlAndSwl">
								<c:if test="${mwlAndSwl lt 0 }">
									<td class="redcolor" style="width: 80px;"><div><fmt:formatNumber value="${mwlAndSwl}" maxFractionDigits="2" /> </div></td>
								</c:if>
								<c:if test="${mwlAndSwl ge 0 }">
									<td style="width: 80px;"><div><fmt:formatNumber value="${mwlAndSwl}" maxFractionDigits="2" /> </div></td>
								</c:if>
							</c:forEach>
						</tr>
						
					 	<tr>
							<c:forEach items="${projectionData.sowAndCbs}" var="sowAndCbs">
								<c:if test="${sowAndCbs lt 0 }">
									<td class="redcolor" style="width: 80px;"><div><fmt:formatNumber value="${sowAndCbs}" maxFractionDigits="2" /> </div></td>
								</c:if>
								<c:if test="${sowAndCbs ge 0 }">
									<td style="width: 80px;"><div><fmt:formatNumber value="${sowAndCbs}" maxFractionDigits="2" /> </div></td>
								</c:if>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach items="${projectionData.growndwood}" var="growndwood">
								<c:if test="${growndwood lt 0 }">
									<td  class="redcolor"  style="width: 80px;"><div><fmt:formatNumber value="${growndwood}" maxFractionDigits="2" /> </div></td>
								</c:if>
								<c:if test="${growndwood ge 0 }">
									<td style="width: 80px;"><div><fmt:formatNumber value="${growndwood}" maxFractionDigits="2" /> </div></td>
								</c:if>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach items="${projectionData.dlk}" var="dlk">
								<c:if test="${dlk lt 0 }">
									<td class="redcolor" style="width: 80px;"><div><fmt:formatNumber value="${dlk}" maxFractionDigits="2" /> </div></td>
								</c:if>
								<c:if test="${dlk ge 0 }">
									<td style="width: 80px;"><div><fmt:formatNumber value="${dlk}" maxFractionDigits="2" /> </div></td>
								</c:if>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach items="${projectionData.occ}" var="occ">
								<c:if test="${occ lt 0 }">
									<td class="redcolor" style="width: 80px;"><div><fmt:formatNumber value="${occ}" maxFractionDigits="2" /> </div></td>
								</c:if>
								<c:if test="${occ ge 0 }">
									<td style="width: 80px;"><div><fmt:formatNumber value="${occ}" maxFractionDigits="2" /> </div></td>
								</c:if>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach items="${projectionData.mail}" var="mail">
								<c:if test="${mail lt 0 }">
									<td class="redcolor" style="width: 80px;"><div><fmt:formatNumber value="${mail}" maxFractionDigits="2" /> </div></td>
								</c:if>
								<c:if test="${mail ge 0 }">
									<td style="width: 80px;"><div><fmt:formatNumber value="${mail}" maxFractionDigits="2" /> </div></td>
								</c:if>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach items="${projectionData.mixedPaper}" var="mixedPaper">
								<c:if test="${mixedPaper lt 0 }">
									<td class="redcolor" style="width: 80px;"><div><fmt:formatNumber value="${mixedPaper}" maxFractionDigits="2" /> </div></td>
								</c:if>
								<c:if test="${mixedPaper ge 0 }">
									<td style="width: 80px;"><div><fmt:formatNumber value="${mixedPaper}" maxFractionDigits="2" /> </div></td>
								</c:if>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach items="${projectionData.cutBook}" var="cutBook">
								<c:if test="${cutBook lt 0 }">
									<td class="redcolor" style="width: 80px;"><div><fmt:formatNumber value="${cutBook}" maxFractionDigits="2" /> </div></td>
								</c:if>
								<c:if test="${cutBook ge 0 }">
									<td style="width: 80px;"><div><fmt:formatNumber value="${cutBook}" maxFractionDigits="2" /> </div></td>
								</c:if>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach items="${projectionData.others}" var="others">
								<c:if test="${others lt 0 }">
									<td class="redcolor" style="width: 80px;"><div><fmt:formatNumber value="${others}" maxFractionDigits="2" /> </div></td>
								</c:if>
								<c:if test="${others ge 0 }">
									<td style="width: 80px;"><div><fmt:formatNumber value="${others}" maxFractionDigits="2" /></div></td>
								</c:if>
							</c:forEach>
						</tr>
						
						<!-- Code Starts From Here Done By Roshan Tailor -->
						<%-- <tr>
							<c:forEach items="${projectionData.hwAndUnprtSBS}" var="hwAndUnprtSBS">
								<c:if test="${hwAndUnprtSBS lt 0 }">
									<td class="redcolor" style="width: 80px;"><div><fmt:formatNumber value="${hwAndUnprtSBS}" maxFractionDigits="2" /> </div></td>
								</c:if>
								<c:if test="${hwAndUnprtSBS ge 0 }">
									<td style="width: 80px;"><div><fmt:formatNumber value="${hwAndUnprtSBS}" maxFractionDigits="2" /> </div></td>
								</c:if>
							</c:forEach>
						</tr> --%>
						<!-- Code Ends Here Done By Roshan Tailor -->
						<tr>
							<c:forEach begin="0" end="${projectionData.length}" varStatus="index">
								<td style="width: 80px;">
									<div style="height: 20px;text-align: center;">
										<select class="phyprop" name="projectionId" style="width: 65px;padding: 1px;">
											<option value="0">Select</option>
											<c:forEach items="${projections}" var="projection">
												<c:choose>
													<c:when test="${projection.id eq productIds[index.index]}">
														<c:set var="tipTxt" value="Input=${projection.input}##MWL&SWL=${projection.mwlAndSwl}##SOW=${projection.sow}##CBS=${projection.cbs}##Groundwood=${projection.growndwood}##Others=${projection.others}##DLK=${projection.dlk}##OCC=${projection.occ}##Sow & Mail=${projection.sowAndMail}" />
														<option value="${projection.id}" selected="selected" title="${tipTxt}">${frpgrade[projection.type]} - ${projection.type2} - ${projection.input}</option>
													</c:when>
													<c:otherwise>
														<option value="${projection.id}">${frpgrade[projection.type]} - ${projection.type2} - ${projection.input}</option>
													</c:otherwise>
												</c:choose>
												
											</c:forEach>
										</select>
									</div>
								</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach begin="0" end="${projectionData.length}" varStatus="i">
								<td style="width: 80px;"><div>
								
								<c:set var="availTotal" value="${0}" />
								<c:set var="availTotal" value="${availTotal+projectionData.mwlAndSwl[i.index]}" />
								<c:set var="availTotal" value="${availTotal+projectionData.sowAndCbs[i.index]}" />
								<c:set var="availTotal" value="${availTotal+projectionData.growndwood[i.index]}" />
								<c:set var="availTotal" value="${availTotal+projectionData.dlk[i.index]}" />
								<c:set var="availTotal" value="${availTotal+projectionData.occ[i.index]}" />
								<c:set var="availTotal" value="${availTotal+projectionData.mail[i.index]}" />
								<c:set var="availTotal" value="${availTotal+projectionData.mixedPaper[i.index]}" />
								<c:set var="availTotal" value="${availTotal+projectionData.cutBook[i.index]}" />
								<c:set var="availTotal" value="${availTotal+projectionData.others[i.index]}" />
								
								<c:set var="availTotal" value="${availTotal+projectionData.hwAndUnprtSBS[i.index]}" />
								
								<fmt:formatNumber value="${availTotal}" maxFractionDigits="2"/>
								</div>
							</td>
							</c:forEach>
						</tr>
					</table>
				
				</div>
			</td>
		</tr>
		<tr>
			<th>&nbsp;</th>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<th><div>Code</div></th>
			<th><div>Grade</div></th>
			<th><div>${sdate}</div></th>
		</tr>
		
		
		<c:set var="totalWeight" value="${0}"/>
		<c:forEach items="${projectionData.projectionDatas}" var="pdata">
			<tr>
				<td><div>${pdata.gradeCode}</div></td>
				<td><div style="text-align: left;">${pdata.grade}</div></td>
				<td><div><fmt:formatNumber value="${pdata.weight}" maxFractionDigits="2"/> </div></td>
				
				<c:set var="totalWeight" value="${totalWeight+pdata.weight}"/>
				
			</tr>
		</c:forEach>
		<tr>
			<th colspan="2" align="right"><b>TOTAL</b></th>
			<td><div><b><fmt:formatNumber value="${totalWeight}" maxFractionDigits="2"/></b></div></td>
		</tr>
		<tr>
			<td colspan="3" style="height: 20px;">
				<b>Predicted inventory at the end of the day</b>
			</td>
		</tr>
		
		<tr>
			<td colspan="3"><div style="text-align: left;">MWL And SWL (1/7)</div></td>
		</tr>
		<tr>
			<td colspan="3"><div style="text-align: left;">SOW (13)</div></td>
		</tr>
		<tr>
			<td colspan="3"><div style="text-align: left;">Groundwood(6/8/9)</div></td>
		</tr>
		<tr>
			<td colspan="3"><div style="text-align: left;">DLK (24)</div></td>
		</tr>
		<tr>
			<td colspan="3"><div style="text-align: left;">OCC (23)</div></td>
		</tr>
		<tr>
			<td colspan="3"><div style="text-align: left;">Mail-Undeliverable (20)</div></td>
		</tr>
		<tr>
			<td colspan="3"><div style="text-align: left;">Mixed Paper (30)</div></td>
		</tr>
		<tr>
			<td colspan="3"><div style="text-align: left;">Cut Book (21)</div></td>
		</tr>
		<tr>
			<td colspan="3"><div style="text-align: left;">Others (60/65)</div></td>
		</tr>
		
		<!-- Code Starts From Here Done By Roshan Tailor -->
		 <!-- <tr>
			<td colspan="3"><div style="text-align: left;">HW And Unprt SBS (11/14)</div></td>
			<td colspan="3"><div style="text-align: left;">Unprt SBS (11)</div></td>
		</tr> -->
		<!-- Code Ends Here Done By Roshan Tailor -->
		<tr>
			<td colspan="3"><div style="height: 20px;">&nbsp;</div> </td>
		</tr>
		<tr>
			<td colspan="3"><div style="text-align: left;"><b>TOTAL AVAIL</b></div></td>
		</tr>
				
		<tr>
			<th colspan="3"><div style="height: 20px;">&nbsp;</div></th>
		</tr>

	</table>
	
	
</div>	
</c:if>
			</div>

		</div>


	</div>



<div id="newDialog" style="display: none;overflow: hidden;" title="Projection Formula">
	<iframe id="dialogPage" style="width: 100%; height: inherit;border: none;"></iframe>
</div>


<spring:url value="/frpprojection/new" var="newFormulaURL"/>

<script type="text/javascript">
	$(function(){
		$('#newFormulaBtn').click(function(){
			$("#newDialog #dialogPage").attr('src', '${newFormulaURL}');
	        $("#newDialog").dialog({
	            width: 900,
	            height: 500,
	            modal: true,
	            close: function () {
	                $("#newDialog #dialogPage").attr('src', "about:blank");
	            }
	        });
		});
	});

</script>
</body>
</html>
