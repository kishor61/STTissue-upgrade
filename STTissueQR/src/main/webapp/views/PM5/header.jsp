<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<div class="logo">
	<span><img style="height:35px; border: none;" alt="ST STissue" src='<spring:url value="/dist/images/STTissue.JPG"/>'> </span>
</div>

<div class="fixed-message">
	<span class="tmessage" id="tmessage"></span>
</div>




<security:authorize access="isAuthenticated()">
<div class="nav">
	<ul>
		<li>
			
				<a href='<spring:url value="/signout"></spring:url>' style="text-decoration: none;"><span class="flaticon-logout"> Sign Out</span></a>
			
		</li>

		<li>
			<span> Logged In as <b><security:authentication property="principal.username"/></b></span>
			
		</li>
		<security:authorize access="hasAnyRole('ROLE_ADMIN')">
			<li>
				<p style="color: green; font-size: 10px;text-align: center;">
					<span style="color: Red;background-color: #90C830;"><a href='<spring:url value="/higherauthoritydecision/apply"/>'>Stop Mails</a></span>
				 </p>
			</li>
		</security:authorize>
		<li>
			<p style="color: green; font-size: 10px;text-align: center;">
				<span style="color: red;"> Report Emergency # - Call 9-569-4777 or 9-911
				<br>
				LOCATE Emergency - Call 9-757-569-4711</span>
			 </p>
		</li>
	</ul>
</div>

<div id="warningDailog" style="display: none;" title="Message From Server">
	<p style="font-size: 16px;">Application has been stopped due to server maintenance or changes in code.<br>
		<br>
		<span style="font-weight: bold;">Please try after 2 minutes.</span>
	</p>
</div>

<div id="warningDailogAlert" style="display: none;" title="Alert Window">
	<p style="font-size: 50px;color: red;">Test emergency alarm today at 9:00 AM.</p>
</div>

<spring:url value="/timeoutcheck" var="timeouturl"/>
<spring:url value="/" var="singInURL"/>
<spring:url value="/reel/add" var="defaultReelURL"/>
<spring:url value="/rewind/add" var="defaultRewindURL"/>

<script type="text/javascript">
	$(function(){
		timeoutCheck();
		
		$('li.divider').click(function(){
			$('.'+$(this).attr('value')).toggle();
		});
		
	});
	function timeoutCheck(){
		
		$.ajax({
			url:'${timeouturl}',
			type:'GET',
			data:{
				reel:'${defaultReelURL}',
				rewind:'${defaultRewindURL}'
			},
			success:function(data){
				
				if(data.newDay){
					var url=location.href;
					if(url.indexOf("home")>=0){
					 	location.reload(true);
					}else if(url.indexOf("reel/add")>=0){
						timeCheckReelLoop();
					}else if(url.indexOf("rewind/add")>=0){
						timeCheckRewindLoop();
						
					}
				}
				
				//Code By Roshan For Height And Weight
				if(data.showAlarm){
					//alert("Roshan::"+data.showAlarm)
					if(data.emergencyAlramFlag=='Y'){
						//alert(data.emergencyAlramFlag);
						$('#warningDailogAlert').dialog({
							height: 300,
						    width: 800,
							modal: true,
						});
					}	
					
				}
				
				
				setTimeout(timeoutCheck, 10000);
			},
			error: function(xhr, status, error) {
				 $( "#warningDailog" ).dialog({
					 height: 200,
				     width: 350,
				     modal: true,
				     close: function() {
				     	 location.href='${singInURL}';
				     }
				 });
			}
		});
	}

	function timeCheckReelLoop(){
		if(!confirm('Your shift is over. Do you want to leave this page?')){
			setTimeout(timeCheckReelLoop, 10000);
		}else{
			location.href='${defaultReelURL}';
		}
		
	}
	function timeCheckRewindLoop(){
		if(!confirm('Your shift is over. Do you want to leave this page?')){
			setTimeout(timeCheckRewindLoop, 10000);
		}else{
			location.href='${defaultRewindURL}';
		}
		
	}
</script>
 
</security:authorize>


<div class="navbar ui-widget-header">
<ul>
<security:authorize access="isAuthenticated()">
	
		<li>
			<a href='<spring:url value="/home"></spring:url>'>HOME</a>
		</li>
		<li><div class="sep"></div></li>
		<%-- <li>
			<a href='<spring:url value="/operatingprocedure/manage"/>'>Procedures</a>
		</li> --%>
		<li>
			<a href='<spring:url value="/operatingprocedure/managenew"/>'>QMS </a>
			<%-- <a href='<spring:url value="/operatingprocedure/showarea"/>'>QMS1 </a> --%>
		</li>

	<security:authorize access="hasAnyRole('ROLE_OPERATOR')">
		<li><div class="sep"></div></li>	
		<li>
			<div>
			<c:choose>
				<c:when test="${empty reelentryurl}">
					<a href='<spring:url value="/reel/add"/>'>Reel</a>
				</c:when>
				<c:otherwise>
					<a href='${reelentryurl}'>Reel</a>
				</c:otherwise>
			</c:choose>
			</div>
		</li>
		<li><div class="sep"></div></li>
		<li>
			<div>
			<c:choose>
					<c:when test="${empty rewindentryurl}">
						<a href='<spring:url value="/rewind/add"/>'>Rewinder</a>
					</c:when>
					<c:otherwise>
						<a href='${rewindentryurl}'>Rewinder</a>
					</c:otherwise>
			</c:choose>
			</div>
		</li>
		
		
		
		<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/centerline/new"/>'>Centerline</a>
		</li>
		<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/efficiency/new"/>'>Efficiency</a>
		</li>
		
		<li><div class="sep"></div></li>
		
		<li>
			<a href='<spring:url value="/utilitykpimaster/new"/>'>Utility KPI </a>
		</li>
		
		<li><div class="sep"></div></li>
		<li  class="dropdown">
			<a href="javascript:void(0)">Chemical &#9662;  </a>
			<ul>
				<li><a href='<spring:url value="/chemicalinv/primary/manage"/>'>Primary Chemical Code </a></li>
				<li><a href='<spring:url value="/chemicalinv/secondary/manage"/>'>Secondary Chemical Code </a></li>
				<li><a href='<spring:url value="/chemicalinv/chemical/manage"/>'>Chemical Code</a></li>
				<li><a href='<spring:url value="/chemicalinv/chemicaldata/new"/>'>Chemical-Data Entry</a></li>
				<%-- <li><a href='<spring:url value="/chemicalinvreport/main"/>'>Chemical-Report</a></li> --%>
				<li><a href='<spring:url value="/chemicalinvreport/view/detail"/>'>Chemical-Report</a></li>
			</ul>
		</li>
		
		<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/certificateanalysis/main"/>'>Certificate</a>
		</li>
	
	</security:authorize>
		
		
		
	<security:authorize access="hasAnyRole('ROLE_OPERATOR2')">
	
		<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/frpproduction/new"/>'>Production </a>
		</li>
		
		<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/frpefficiency/new"/>'>Efficiency </a>
		</li>
		<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/frppressquality/new"/>'>Press Quality Data </a>
		</li>
		<li><div class="sep"></div></li>
		<li>
			<c:choose>
					<c:when test="${empty fprprojectionurl}">
						<a href='<spring:url value="/frpprojectionreport/view"/>'>Projection </a>
					</c:when>
					<c:otherwise>
						<a href="${fprprojectionurl}">Projection </a>
					</c:otherwise>
			</c:choose>
			
		</li>
		<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/frpprojectionmix/view"/>'>Mix Graph</a>
		</li>
	
	</security:authorize>	
	
	
	<!-- MILL CAL -->
			<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/staticdata/shiftscheduledownload"/>' target="_blank">Mill Calendar</a>
		</li>
		<%-- <li>
			<a href='<spring:url value="/staticdata/shiftscheduledownload1"/>' target="_blank">Shift Schedule</a>
		</li> --%>
	
	<security:authorize access="hasAnyRole('ROLE_ADMIN')">
		<li><div class="sep"></div></li>	
		<li>
			<div>
			<c:choose>
				<c:when test="${empty reelentryurl}">
					<a href='<spring:url value="/reel/add"/>'>Reel</a>
				</c:when>
				<c:otherwise>
					<a href='${reelentryurl}'>Reel</a>
				</c:otherwise>
			</c:choose>
			</div>
		</li>
		<li><div class="sep"></div></li>
		<li>
			<div>
			<c:choose>
					<c:when test="${empty rewindentryurl}">
						<a href='<spring:url value="/rewind/add"/>'>Rewinder</a>
					</c:when>
					<c:otherwise>
						<a href='${rewindentryurl}'>Rewinder</a>
					</c:otherwise>
			</c:choose>
			</div>
		</li>
		
		
		
		<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/centerline/new"/>'>PM6 Centerline</a>
		</li>
		<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/efficiency/new"/>'>PM6 Efficiency</a>
		</li>
		
		<li><div class="sep"></div></li>
		
		<li>
			<a href='<spring:url value="/utilitykpimaster/new"/>'>PM6 Utility KPI </a>
		</li>
		<li><div class="sep"></div></li>
		<li  class="dropdown">
			<a href="javascript:void(0)">Chemical &#9662;  </a>
			<ul>
				<li><a href='<spring:url value="/chemicalinv/primary/manage"/>'>Primary Chemical Code</a></li>
				<li><a href='<spring:url value="/chemicalinv/secondary/manage"/>'>Secondary Chemical Code</a></li>
				<li><a href='<spring:url value="/chemicalinv/chemical/manage"/>'>Chemical Code</a></li>
				<li><a href='<spring:url value="/chemicalinv/chemicaldata/new"/>'>Chemical-Data Entry</a></li>
				<%-- <li><a href='<spring:url value="/chemicalinvreport/main"/>'>Chemical-Report</a></li> --%>
				<li><a href='<spring:url value="/chemicalinvreport/view/detail"/>'>Chemical-Report</a></li>
			</ul>
		</li>
		
		<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/certificateanalysis/main"/>'>Certificate</a>
		</li>
		
		
		<li><div class="sep"></div></li>
		<li  class="dropdown">
			<a href="javascript:void(0)">FRP &#9662;  </a>
			<ul>
				<li><a href='<spring:url value="/frpproduction/new"/>'>Production </a></li>
				<li><a href='<spring:url value="/frpefficiency/new"/>'>Efficiency </a></li>
				<li><a href='<spring:url value="/frppressquality/new"/>'>Press Quality Data </a></li>
				<li>
					<c:choose>
							<c:when test="${empty fprprojectionurl}">
								<a href='<spring:url value="/frpprojectionreport/view"/>'>Projection </a>
							</c:when>
							<c:otherwise>
								<a href="${fprprojectionurl}">FRP Projection </a>
							</c:otherwise>
					</c:choose>
				</li>
				<li>
					<c:choose>
							<c:when test="${empty fiberpurchasingurl}">
								<a href='<spring:url value="/fiberpurchasingreport/view"/>'>Fiber Purchasing </a>
							</c:when>
							<c:otherwise>
								<a href="${fiberpurchasingurl}">Fiber Purchasing </a>
							</c:otherwise>
					</c:choose>
				</li>
				<li><a href='<spring:url value="/frpprojectionmix/view"/>'>Mix Graph</a></li>
			</ul>
		</li>
		
<%-- 	</security:authorize>
		

	<security:authorize access="hasAnyRole('ROLE_ADMIN')"> --%>
			<li><div class="sep"></div></li>
			<li class="dropdown">
				<a href="javascript:void(0)">PM &#9662;</a>
				<ul>
					<li class="divider">Process Improvement Notes</li>
					<li><a href='<spring:url value="/oimnotes/main"/>'>Data Entry </a></li>
					<li><a href='<spring:url value="/oimnotes/category"/>'>Category </a></li>
					<li><a href='<spring:url value="/oimnotesreport/main"/>'>Reports </a></li>
					<li><a href='<spring:url value="/oimnotesreport/load/openfollowups"/>'>Reports - Open Follow-up </a></li>
					<li><a href='<spring:url value="/pmsummarydata/main"/>'>Daily Summary-Data Entry </a></li>
					<li><a href='<spring:url value="/pmsummarydatareport/main"/>'>Daily Summary - Report</a></li>
					
					<li class="divider">Safety Log</li>
					<li><a href='<spring:url value="/safetylogreport/view"/>'>Safety Log - Data Entry/View </a></li>
					<li><a href='<spring:url value="/safetylogreport/view2"/>'>Safety Log - Reviews </a></li>
					
					<li class="divider">Safety Housekeeping</li>
					<li><a href='<spring:url value="/safetyhousekeeping/main"/>'>Safety Housekeeping</a></li>
					<li><a href='<spring:url value="/safetyhousekeeping/view/standard"/>'>Safety Housekeeping-Standard</a></li>
					
					
					<c:choose>
						<c:when test="${empty housekeepingscheduleurl}">
							<li><a href='<spring:url value="/safetyhousekeeping/schedule"/>'>Safety Housekeeping-Schedule</a></li>
						</c:when>
						<c:otherwise>
							<li><a href='${housekeepingscheduleurl}'>Safety Housekeeping-Schedule</a></li>
						</c:otherwise>
					</c:choose>		
								
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href='<spring:url value="/auditor/manage"/>'>Manage-Auditor</a></li>
					<li><a href='<spring:url value="/area/manage"/>'>Manage-Area</a></li>
				</security:authorize>					
					<li><a href='<spring:url value="/safetyhousekeepingreport/main"/>'>Reports </a></li>
					<li><a href='<spring:url value="/safetyhousekeepingreport/openreports"/>'>Reports - Open Actions </a></li>
				</ul>
			</li>
			
		</security:authorize>
		
		
		
		
		<security:authorize access="hasAnyRole('ROLE_OPERATOR4')">
			<li><div class="sep"></div></li>
			<li class="dropdown">
				<a href="javascript:void(0)">Safety Log &#9662;</a>
				<ul>
					<li><a href='<spring:url value="/safetylogreport/view"/>'>Safety Log - Data Entry/View </a></li>
					<li><a href='<spring:url value="/safetylogreport/view2"/>'>Safety Log - Reviews </a></li>
				</ul>
			</li>
			<li><div class="sep"></div></li>
			<li class="dropdown">
				<a href="javascript:void(0)">Process Improvement Notes &#9662;</a>
				<ul>
					<li><a href='<spring:url value="/oimnotes/main"/>'>Data Entry </a></li>
					<li><a href='<spring:url value="/oimnotes/category"/>'>Category </a></li>
					<li><a href='<spring:url value="/oimnotesreport/main"/>'>Reports </a></li>
					<li><a href='<spring:url value="/oimnotesreport/load/openfollowups"/>'>Reports - Open Follow-up </a></li>
					<li><a href='<spring:url value="/pmsummarydata/main"/>'>Daily Summary-Data Entry </a></li>
					<li><a href='<spring:url value="/pmsummarydatareport/main"/>'>Daily Summary - Report</a></li>
				</ul>
			</li>
			
			<li><div class="sep"></div></li>
			<li class="dropdown">
				<a href="javascript:void(0)">Safety Housekeeping&#9662;</a>
				<ul>
					<li><a href='<spring:url value="/safetyhousekeeping/main"/>'>Safety Housekeeping</a></li>
					<li><a href='<spring:url value="/safetyhousekeeping/view/standard"/>'>Safety Housekeeping-Standard</a></li>
					
					
					<c:choose>
						<c:when test="${empty housekeepingscheduleurl}">
							<li><a href='<spring:url value="/safetyhousekeeping/schedule"/>'>Safety Housekeeping-Schedule</a></li>
						</c:when>
						<c:otherwise>
							<li><a href='${housekeepingscheduleurl}'>Safety Housekeeping-Schedule</a></li>
						</c:otherwise>
					</c:choose>		
								
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href='<spring:url value="/auditor/manage"/>'>Manage-Auditor</a></li>
					<li><a href='<spring:url value="/area/manage"/>'>Manage-Area</a></li>
				</security:authorize>					
					<li><a href='<spring:url value="/safetyhousekeepingreport/main"/>'>Reports </a></li>
					<li><a href='<spring:url value="/safetyhousekeepingreport/openreports"/>'>Reports - Open Actions </a></li>
				</ul>
			</li>
			
		
	</security:authorize>
	

<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR', 'ROLE_OPERATOR2', 'ROLE_OPERATOR3', 'ROLE_OPERATOR4')">
	<li><div class="sep"></div></li>
	<li class="dropdown">
		<a href='<spring:url value="/report"></spring:url>'>Reports &#9662;</a>
		<ul>
			<li class="divider" value="sub1">&#10148; PM6 PRODUCTION</li>
			<li class="sub1"><a href='<spring:url value="/reelreport/"/>'>Reel Testing </a></li>
			<li class="sub1"><a href='<spring:url value="/rewindreport/"/>'>Rewinder Testing </a></li>
			<li class="sub1"><a href='<spring:url value="/qualitygraph/main"/>'>Quality Graph(Reel/Rewinder Testing) </a></li>
			<li class="sub1"><a href='<spring:url value="/centerlinereport/view"/>'>Centerline Data</a></li>
			<li class="sub1"><a href='<spring:url value="/centerlinereport/view2"/>'>Centerline Data 2</a></li>
			<li class="sub1"><a href='<spring:url value="/efficiencyreport/main"/>'>Efficiency </a></li>
			<li class="sub1"><a href='<spring:url value="/efficiencyreport/summary"/>'>Efficiency Summary</a></li>
			<li class="sub1"><a href='<spring:url value="/utilitykpimasterreport/view"/>'>KPI, Master and  Utility</a></li>
			<li class="sub1"><a href='<spring:url value="/wrapperredcodereport/view"/>'>Wrapper Red/Reject Tons Summary</a></li>
			<li class="sub1"><a href='<spring:url value="/certificateanalysis/main"/>'>Certificate</a></li>
			<%-- <li><a href='<spring:url value="/chemicalinvreport/main"/>'>Chemical</a></li> --%>
			<li class="sub1"><a href='<spring:url value="/chemicalinvreport/view/detail"/>'>Chemical-Report</a></li>
			
			
			<li class="divider" value="sub2">&#10148; FRP PRODUCTION</li>
			<li class="sub2"><a href='<spring:url value="/frpproductionreport/view"/>'>Production Data </a></li>
			<li class="sub2"><a href='<spring:url value="/frpefficiencyreport/main"/>'>Efficiency </a></li>
			<li class="sub2"><a href='<spring:url value="/frpefficiencyreport/summary"/>'>Efficiency Summary</a></li>
			<li class="sub2"><a href='<spring:url value="/frppressqualityreport/view"/>'>Press Quality Data</a></li>
			<li class="sub2">	
			<c:choose>
					<c:when test="${empty fprprojectionurl}">
						<a href='<spring:url value="/frpprojectionreport/view"/>'>Projection </a>
					</c:when>
					<c:otherwise>
						<a href="${fprprojectionurl}">FRP Projection </a>
					</c:otherwise>
				</c:choose>
			 </li>
			 <li class="sub2"><a href='<spring:url value="/frpprojectionmix/view"/>'>Mix Graph</a></li>
			 <li class="sub2"><a href='<spring:url value="/frpdailyreport/view"/>'>FRP Daily Report</a></li>
			 <li class="sub2"><a href='<spring:url value="/frpmonthlyreport/view"/>'>FRP IP Monthly Report</a></li>
			 <li class="sub2"><a href='<spring:url value="/fiberbalancereport/view"/>'>Fiber Balance Report</a></li>
			
			
			<li class="divider" value="sub3">&#10148; PM6 Production and Waste Paper</li>
			<li><a href='<spring:url value="/productionreport/view"/>'>Daily Report</a></li>
			<li><a href='<spring:url value="/productionwarpreport/view"/>'>PM6 Tissue Wrapped Tons</a></li>
			<li><a href='<spring:url value="/productionreport/viewsummary"/>'>PM6 Production Summary </a></li>
			<li><a href='<spring:url value="/productionwarpreport/gradenhours"/>'>Grade And Hours Report </a></li>
			<li><a href='<spring:url value="/productionwarpreport/gradenhoursWithSummary"/>'>Grade And Hours Report- With Summary </a></li>
			<li><a href='<spring:url value="/productionreport/gradenhours"/>'>Grade And Hours Report (Machine)</a></li>
			<li><a href='<spring:url value="/productionwarpreport/inventorysummary"/>'>Inventory Daily Summary </a></li>
			<%-- <li><a href='<spring:url value="/inventoryfloorreport/main"/>'>Current Inventory</a></li> --%>
			<li><a href='<spring:url value="/wastepaperreport/view"/>'>Wastepaper Detail Report </a></li>
			<li><a href='<spring:url value="/productionwarpreport/wrapperAverage"/>'>Wrapper Average Report</a></li>
			<li><a href='<spring:url value="/wrapperVsMachineReport/view"/>'>Machine Vs Wrapper Report</a></li>
			<li><a href='<spring:url value="/productionwarpreport/dataByDate"/>'>Wrapper Data By Date</a></li>
			
			<li class="divider" value="sub4">&#10148; PM Reports</li>
			
			<li class="sub4"><a href='<spring:url value="/safetylogreport/view"/>'>Safety Log - View </a></li>
			<li class="sub4"><a href='<spring:url value="/safetylogreport/view2"/>'>Safety Log - Reviews </a></li>
			<li class="sub4"><a href='<spring:url value="/safetyhousekeepingreport/main"/>'>Safety Housekeeping </a></li>
			<li class="sub4"><a href='<spring:url value="/safetyhousekeepingreport/openreports"/>'>Safety Housekeeping - Open Actions </a></li>
			<li class="sub4"><a href='<spring:url value="/safetyhousekeepingreport/closeditems"/>'>Safety Housekeeping - Closed Actions </a></li>
			<li class="sub4"><a href='<spring:url value="/oimnotesreport/main"/>'>Process Improvement Notes </a></li>
			<li class="sub4"><a href='<spring:url value="/oimnotesreport/load/openfollowups"/>'>Process Improvement Notes - Open Follow-up </a></li>
			<li class="sub4"><a href='<spring:url value="/pmsummarydatareport/main"/>'>Daily Summary - Report</a></li>
			
			
		</ul>
		
	</li>
	
</security:authorize>
	
	<li><div class="sep"></div></li>
	<li>
		<a href='http://blog.sttissuellc.com/home' target="_blank">ST Tissue Blog</a>
	</li>
	<li><div class="sep"></div></li>
<!-- 	Code Modified Starts From Here Done By Roshan Tailor Date:- 07/10/2015 MM/DD/YYYY Night Shift -->
	<li>
		<a href='http://192.168.4.5:8080/STT_Spares/doLogin.action?username=Operator&password=Op123' target="_blank">ST Spares</a>
	</li>
<!-- 	Code Modified Ends Here Done By Roshan Tailor Date :- 07/10/2015 MM/DD/YYYY Night Shift -->
	<li><div class="sep"></div></li>
	<li>
		<a href='https://msdsmanagement.msdsonline.com/39f24252-5cde-440c-a398-8fbb9eb3e764/ebinder/?nas=True' target="_blank">MSDS</a>
	</li>
	
	
	
</security:authorize>
	
<security:authorize access="isAnonymous()">
	<li>
		<a href='http://blog.sttissuellc.com/home' target="_blank">ST Tissue Blog</a>
	</li>
	<li><div class="sep"></div></li>
<!-- 	Code Modified Starts From Here Done By Roshan Tailor Date :- 07/10/2015 MM/DD/YYYY Night Shift -->
	<li>
		<a href='http://192.168.4.5:8080/STT_Spares/' target="_blank">ST Spares</a>
	</li>
<!-- 	Code Modified Ends Here Done By Roshan Tailor Date :- 07/10/2015 MM/DD/YYYY Night Shift  -->
	<li><div class="sep"></div></li>
	<li>
		<a href='https://msdsmanagement.msdsonline.com/39f24252-5cde-440c-a398-8fbb9eb3e764/ebinder/?nas=True' target="_blank">MSDS</a>
	</li>
	
</security:authorize>
	
</ul>
</div>
