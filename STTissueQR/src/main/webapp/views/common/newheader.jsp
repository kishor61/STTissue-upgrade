<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

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
	</ul>
</div>

<div id="warningDailog" style="display: none;" title="Message From Server">
	<p style="font-size: 16px;">Application has been stopped due to server maintenance or changes in code.<br>
		<br>
		<span style="font-weight: bold;">Please try after 2 minutes.</span>
	</p>
</div>

<spring:url value="/timeoutcheck" var="timeouturl"/>
<spring:url value="/" var="singInURL"/>
<spring:url value="/reel/add" var="defaultReelURL"/>
<spring:url value="/rewind/add" var="defaultRewindURL"/>

<script type="text/javascript">
	$(function(){
		timeoutCheck();
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
			<a href='<spring:url value="/home"></spring:url>'>Main Menu</a>
		</li>
		
	
	<security:authorize access="hasAnyRole('OPERATOR')">
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
		
		
	<security:authorize access="hasAnyRole('OPERATOR2')">
	
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
			<c:choose>
					<c:when test="${empty fprprojectionjonurl}">
						<a href='<spring:url value="/frpprojectionreport/view/john"/>'>Projection_John </a>
					</c:when>
					<c:otherwise>
						<a href="${fprprojectionjonurl}">Projection_John </a>
					</c:otherwise>
			</c:choose>
			
		</li>
		<li><div class="sep"></div></li>
		<li>
			<a href='<spring:url value="/frpprojectionmix/view"/>'>Mix Graph</a>
		</li>
	
	</security:authorize>	
	
	
	<security:authorize access="hasAnyRole('ADMIN')">
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
				<li><a href='<spring:url value="/frpprojectionmix/view"/>'>Mix Graph</a></li>
			</ul>
		</li>
		
<%-- 	</security:authorize>
		

	<security:authorize access="hasAnyRole('ADMIN')"> --%>
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
								

					<li><a href='<spring:url value="/auditor/manage"/>'>Manage-Auditor</a></li>
					<li><a href='<spring:url value="/area/manage"/>'>Manage-Area</a></li>
					<li><a href='<spring:url value="/safetyhousekeepingreport/main"/>'>Reports </a></li>
					<li><a href='<spring:url value="/safetyhousekeepingreport/openreports"/>'>Reports - Open Actions </a></li>
				</ul>
			</li>
			
		</security:authorize>
		
		
		
		
		<security:authorize access="hasAnyRole('OPERATOR4')">
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
								

					<li><a href='<spring:url value="/auditor/manage"/>'>Manage-Auditor</a></li>
					<li><a href='<spring:url value="/area/manage"/>'>Manage-Area</a></li>
					<li><a href='<spring:url value="/safetyhousekeepingreport/main"/>'>Reports </a></li>
					<li><a href='<spring:url value="/safetyhousekeepingreport/openreports"/>'>Reports - Open Actions </a></li>
				</ul>
			</li>
			
		
	</security:authorize>
	

<security:authorize access="hasAnyRole('ADMIN,OPERATOR,OPERATOR2,OPERATOR3,OPERATOR4')">
	<li><div class="sep"></div></li>
	<li class="dropdown">
		<a href='<spring:url value="/report"></spring:url>'>Reports &#9662;</a>
		<ul>
			<li class="divider">PM6 PRODUCTION</li>
			<li><a href='<spring:url value="/reelreport/"/>'>Reel Testing </a></li>
			<li><a href='<spring:url value="/rewindreport/"/>'>Rewinder Testing </a></li>
			<li><a href='<spring:url value="/centerlinereport/view"/>'>Centerline Data</a></li>
			<li><a href='<spring:url value="/efficiencyreport/main"/>'>Efficiency </a></li>
			<li><a href='<spring:url value="/efficiencyreport/summary"/>'>Efficiency Summary</a></li>
			<li><a href='<spring:url value="/utilitykpimasterreport/view"/>'>KPI, Master and  Utility</a></li>
			<li><a href='<spring:url value="/wrapperredcodereport/view"/>'>Wrapper Red/Reject Tons Summary</a></li>
			<li class="divider">FRP PRODUCTION</li>
			<li><a href='<spring:url value="/frpproduction/view"/>'>Production Data </a></li>
			<li><a href='<spring:url value="/frpefficiencyreport/main"/>'>Efficiency </a></li>
			<li><a href='<spring:url value="/frpefficiencyreport/summary"/>'>Efficiency Summary</a></li>
			<li><a href='<spring:url value="/frppressqualityreport/view"/>'>Press Quality Data</a></li>
		</ul>
	</li>
</security:authorize>
	
</security:authorize>
	
</ul>
</div>
