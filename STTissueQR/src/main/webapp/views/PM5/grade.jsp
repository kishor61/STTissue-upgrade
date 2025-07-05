<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /> - Grade Specification</title>
<meta charset="utf-8" />

<jsp:include page="../common.jsp"></jsp:include>
<style type="text/css">
	pre {
		margin: 0px;
	}
	
	/* Header and Title Styles */
	.content-header h5 {
		text-align: center;
		font-weight: bold;
		color: #343e70;
		margin: 15px 0;
	}
	
	/* Table Selector Styles */
	.table-selector {
		background-color: #c2eadf73;
		border: 1px solid #7e00ff42;
		padding: 10px;
		border-radius: 5px;
		margin-bottom: 20px;
	}
	
	.table-selector table {
		width: 100%;
	}
	
	.table-selector td {
		padding: 5px 10px;
	}
	
	/* Form Styles */
	form table {
		width: 100%;
		border-collapse: collapse;
		margin-bottom: 20px;
	}
	
	form td {
		padding: 8px;
		vertical-align: top;
	}
	
	form input[type="text"],
	form select,
	form textarea {
		padding: 5px;
		border: 1px solid #ddd;
		border-radius: 3px;
	}
	
	form input[type="text"]:focus,
	form select:focus,
	form textarea:focus {
		border-color: #343e70;
		outline: none;
	}
	
	/* Table Styles */
	.table {
		width: 100%;
		border-collapse: collapse;
		margin-bottom: 20px;
	}
	
	.table th {
		background-color: #343e70;
		color: white;
		padding: 8px;
		text-align: center;
	}
	
	.table td {
		padding: 8px;
		border: 1px solid #ddd;
		text-align: center;
	}
	
	/* Section Headers */
	.section-header {
		font-size: 16px;
		font-weight: bold;
		color: #343e70;
		margin: 20px 0 10px 0;
	}
	
	/* Button Styles */
	.btn {
		padding: 5px 15px;
		border-radius: 3px;
		border: none;
		cursor: pointer;
	}
	
	.btn-success {
		background-color: #28a745;
		color: white;
	}
	
	.btn-secondary {
		background-color: #6c757d;
		color: white;
	}
	
	.btn-info {
		background-color: #17a2b8;
		color: white;
	}
	
	/* Print Div Styles */
	#printDiv {
		background-color: white;
		padding: 20px;
		border-radius: 5px;
		box-shadow: 0 0 10px rgba(0,0,0,0.1);
	}
	
	/* Footer Styles */
	.main-footer {
		background-color: #343e70;
		color: white;
		padding: 10px 0;
		text-align: center;
		position: fixed;
		bottom: 0;
		width: 100%;
	}

	/* Toggle Icon Styles */
	.toggle-icon {
		display: inline-block;
		width: 20px;
		height: 20px;
		text-align: center;
		line-height: 20px;
		cursor: pointer;
		transition: transform 0.3s ease;
	}

	.toggle-icon.empty {
		display: none;
	}

	.toggle-icon.rotated {
		transform: rotate(180deg);
	}
</style>
<spring:url value="/pm5grade" var="gradeUrl"/>
<spring:url value="/pm5grade/print" var="printURL"/>
<spring:url value="/pm5grade/copy" var="copyURL"/>

<script type="text/javascript">
	$(function(){
		// Initialize dialog
		$("#gradeDailog").dialog({
			autoOpen: false,
			width: 500,
			height: 400,
			modal: true,
			close: function () {
				$("#gradeDailog #dialogPage").attr('src', "about:blank");
				location.reload(true);
			}
		});

		// Function to check if a section has data
		function hasData(section) {
			var hasContent = false;
			$(section).find('input, textarea').each(function() {
				if($(this).val() && $(this).val().trim() !== '') {
					hasContent = true;
					return false;
				}
			});
			return hasContent;
		}

		// Function to check if this is the last section with data
		function isLastSectionWithData(currentSection) {
			var sections = $('.section-content');
			var currentIndex = sections.index(currentSection);
			var hasDataAfter = false;
			
			sections.slice(currentIndex + 1).each(function() {
				if(hasData($(this))) {
					hasDataAfter = true;
					return false;
				}
			});
			
			return !hasDataAfter;
		}

		// Function to update toggle icons
		function updateToggleIcons() {
			var sections = $('.section-content');
			var lastSectionWithData = null;
			
			// Find the last section with data
			sections.each(function() {
				if(hasData($(this))) {
					lastSectionWithData = $(this);
				}
			});
			
			// Update all sections
			$('.section-header').each(function() {
				var section = $(this).next('.section-content');
				var toggleIcon = $(this).find('.toggle-icon');
				
				if(!hasData(section)) {
					// Hide icon if section has no data
					toggleIcon.addClass('empty');
				} else if(section[0] === lastSectionWithData[0]) {
					// Hide icon if this is the last section with data
					toggleIcon.addClass('empty');
				} else {
					// Show icon for all other sections with data
					toggleIcon.removeClass('empty');
				}
			});
		}

		// Initialize toggle icons
		$('.section-header').each(function() {
			$(this).prepend('<span class="toggle-icon">▼</span> ');
		});

		// Toggle section content
		$('.section-header').click(function() {
			var section = $(this).next('.section-content');
			var toggleIcon = $(this).find('.toggle-icon');
			
			if(!toggleIcon.hasClass('empty')) {
				section.slideToggle();
				toggleIcon.toggleClass('rotated');
				
				// Update all toggle icons after toggling
				updateToggleIcons();
			}
		});

		// Update toggle icons on form changes
		$('form').on('change', 'input, textarea', function() {
			updateToggleIcons();
		});

		// Initial update of toggle icons
		updateToggleIcons();

		$('#cpopyBtn').click(function(){
			var gradeCode = $(this).val();
			if(gradeCode) {
				$("#gradeDailog #dialogPage").attr('src', '${copyURL}/'+gradeCode);
				$("#gradeDailog").dialog('open');
			}
		});

		$('textarea').keypress(function(e) {
			var tval = $(this).val(),
				tlength = tval.length,
				set = 1000,
				remain = parseInt(set - tlength);
			
			if (remain <= 0 && e.which !== 0 && e.charCode !== 0) {
				$(this).val((tval).substring(0, tlength - 1));
			}
		});

		$("input[type=text]").attr('maxlength','50');
		
		$('input[name=revisionDate]').datepicker({
			dateFormat:'mm/dd/yy',
			changeMonth: true,
			changeYear: true
		});
		
		$('#viewBtn').click(function(){
			var gradeCode = $('select[name=gradeCode]').val();
			if(gradeCode != '-1'){
				window.location.href = '${gradeUrl}/view/'+gradeCode;
			} else {
				alert('Please select a grade code.');
			}
		});

		$('#editBtn').click(function(){
			var gradeCode = $('select[name=gradeCode]').val();
			if(gradeCode != '-1'){
				window.location.href = '${gradeUrl}/edit/'+gradeCode;
			} else {
				alert('Please select a grade code.');
			}
		});

		$('#newBtn').click(function(){
			window.location.href = '${gradeUrl}/new';
		});
		
		$('#saveBtn').click(function(e){
			e.preventDefault();
			var flag = false;
			var val = $('input[name=gradeCode]').val();
			
			if(val == ''){
				alert('Please enter grade code.');
				return false;
			}

			$('select[name=gradeCode] option').each(function(){
				if($(this).val() == val){
					flag = true;
					return false;
				}
			});
			
			if(flag){
				alert('Grade code already exists in database');
				return false;
			}
			
			$(this).closest('form').submit();
		});

		$('#updateBtn').click(function(e){
			e.preventDefault();
			$(this).closest('form').submit();
		});
		
		$('#printBtn').click(function(){
			var gradeCode = $('#gradeText').text();
			if(gradeCode != ''){
				window.open("${printURL}/"+gradeCode);	
			}
		});
	});
</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
		<jsp:include page="../header.jsp"></jsp:include>
		<div class="content-wrapper" style="padding-top: 0px !important; background-color: #f8f9fa !important;">
			<div id="gradeDailog" style="display: none;" title="Grade">
				<iframe id="dialogPage" style="width: 100%; height: 100%; border: none;"></iframe>
			</div>
			<div
					          class="content-header"
					          style="
					            padding-top: 10px !important;
					            padding-bottom: 0px !important;
					            line-height: 0px !important;
					          "
					><h5 style="text-align:center; font-weight:bold;color:#343e70;">ST Tissue Internal Specification For PM5</h5></div>

		<div class="block3" style="overflow: auto;">
			<div class="pageContent" style="padding: 5px; ">

				<security:authorize access="hasRole('ROLE_ADMIN')">
				
				<div class="table-selector">
					
					<table>
						<tr>
							<td style="width: 100px;">Grade Code:</td>
							<td style="width: 200px;">
								<select name="gradeCode" class="form-control">
									<option value="-1">Select</option>
									<c:forEach items="${grades}" var="grade">
										<c:choose>
											<c:when test="${grade.gradeCode eq gradeCode}">
												<option value="${grade.gradeCode}" selected="selected">${grade.gradeCode}</option>
											</c:when>
											<c:otherwise>
												<option value="${grade.gradeCode}">${grade.gradeCode}</option>
											</c:otherwise>
										</c:choose>

									</c:forEach>
								</select>
							
							</td>
							<td>
								 &nbsp; <button id="viewBtn"class="btn btn-success btn-sm">View</button>
								 &nbsp; <button id="editBtn"class="btn btn-secondary btn-sm">Edit</button>
								 &nbsp; <button id="newBtn"class="btn btn-info btn-sm">New</button>
								 <c:if test="${viewpage}">
								 	&nbsp; <button id="printBtn"class="btn btn-success btn-sm">Print</button>
								 	&nbsp; <button id="cpopyBtn" value="${grade.gradeCode}"class="btn btn-success btn-sm">Copy Grade</button>
								 </c:if>
								 <c:if test="${editpage}">
								 	&nbsp; <button id="cpopyBtn" value="${grade.gradeCode}"class="btn btn-success btn-sm">Copy Grade</button>
								 </c:if>
								  &nbsp; 
								  &nbsp; 
							 </td>
							 <td style="border-left: 2px solid gray;">
							 
							  <spring:url value="/pm5grade/newcustomer" var="addcustURL"/>
							  <spring:url value="/pm5grade/viewcustomer" var="viewcustURL"/>
							  &nbsp;&nbsp;Customer:
							  &nbsp; <button onclick="window.location='${addcustURL}'"class="btn btn-info btn-sm">Add</button>
							  &nbsp;<button onclick="window.location='${viewcustURL}'"class="btn btn-success btn-sm">View</button>
							 </td>
						</tr>
					</table>

				</div>
		</security:authorize>
	<br>
	<br>

<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR6')">	
	
<span class="message">${message}</span>
<c:if test="${newpage}">
<!-- New Entry -->
<c:set var="now" value="<%=new java.util.Date()%>" />
<fmt:formatDate value="${now}" pattern="MM/dd/yyyy" var="revisionDate"/>

<form action="${gradeUrl}/save" method="post">
	<div>
	
		<table style="width: 100%;">
			<tr>
				<td style="width: 130px;">GRADE CODE:</td>
				<td style="width: 250px;"><input type="text" name="gradeCode" style="width: 200px;" value=""> </td>
				<td style="width: 130px;">Revision Date:</td>
				<td><input readonly="readonly" type="text" name="revisionDate" style="width: 200px;" value="${revisionDate}"></td>
			</tr>
			<tr>
				<td valign="top">TM No.</td>
				<td valign="top"><input type="text" name="tmNo" style="width: 200px;" value=""></td>
				<td valign="top">Description.</td>
				<td valign="top"><textarea name="description" style="width: 200px; height: 40px;"></textarea></td>
			</tr>
			<tr>
				<td>Customer Grade:</td>
				<td><input type="text" name="customerGrade" style="width: 200px;" value=""></td>
				<td>Customer:</td>
				<td>
					<select name="customer" style="width: 204px; padding: 2px;">
						<option value="">Select</option>
						<c:forEach items="${customers}" var="customer">
							<option value="${customer}">${customer }</option>
						</c:forEach>
					</select>
					
				</td>
			</tr>
			<tr>
				<td>ST Tissue Approval.</td>
				<td><input type="text" name="tissueApproval" style="width: 200px;" value=""></td>
				<td>Customer Approval</td>
				<td><input type="text" name="customerApproval" style="width: 200px;" value=""></td>
			</tr>
		</table>
	
	
		<br><br>
		<div class="section-header">PHYSICAL PROPERTIES:-</div>
		<div class="section-content">
			<table class="table" style="font-size: 12px;text-align: center;border-collapse: collapse;">
				<thead>
				<tr>
					<th style="width: 120px;">&nbsp;</th>
					<th style="width: 100px;">Units</th>
					<th style="width: 80px;">Reject Min</th>
					<th style="width: 80px;">Control Min</th>
					<th style="width: 80px;">TARGET</th>
					<th style="width: 80px;">Control Max</th>
					<th style="width: 80px;">Reject Max</th>
					<th style="width: 200px;">Notes</th>
				</tr>
				</thead>
				
				<tbody>
				<c:forEach items="${gradeProperties}" var="map">
					<tr>
						<td>${map['Name']}</td>
						<td>${map['Unit']}<input type="hidden" name="physicalProperty" value="${map['PhysicalPropertyID']}"> </td>
						<td><input name="rejectMin" type="text" style="width: 80px;text-align: center;" value=""> </td>
						<td><input name="controlMin" type="text" style="width: 80px;text-align: center;" value=""> </td>
						<td><input name="target" type="text" style="width: 80px;text-align: center;" value=""> </td>
						<td><input name="controlMax" type="text" style="width: 80px;text-align: center;" value=""> </td>
						<td><input name="rejectMax" type="text" style="width: 80px;text-align: center;" value=""> </td>
						<td><input name="note" type="text" style="width: 200px;text-align: center;" value=""> </td>
					</tr>
				</c:forEach>
				</tbody>
				
			</table>
		</div>
		
		<br>
		<div class="section-header">NOTES:-</div>
		<div class="section-content">
			<textarea style="width: 100%; height: 100px;" name="notes"></textarea>
		</div>
		
		
		<div class="section-header">VISUAL STANDARDS:-</div>
		<div class="section-content">
			<textarea style="width: 100%; height: 100px;" name="visualStandard"></textarea>
		</div>
		<br>
		<table >
			<tr>
				<th></th>
				<th>Min</th>
				<th>Target</th>
				<th>Max</th>
			</tr>
			<tr>
				<td>TRIM</td>
				<td><input type="text" style="width: 100px;" name="trimMin" value=""> </td>
				<td><input type="text" style="width: 100px;" name="trimTarget" value=""> </td>
				<td><input type="text" style="width: 100px;" name="trimMax" value=""> </td>
			</tr>
			<tr>
				<td>DIAMETER</td>
				<td><input type="text" style="width: 100px;" name="diameterMin" value=""> </td>
				<td><input type="text" style="width: 100px;" name="diameterTarget" value=""> </td>
				<td><input type="text" style="width: 100px;" name="diameterMax" value=""> </td>
			</tr>
			<tr>
				<td>BREAKS</td>
				<td><input type="text" style="width: 100px;" name="breakMin" value=""> </td>
				<td><input type="text" style="width: 100px;" name="breakTarget" value=""> </td>
				<td><input type="text" style="width: 100px;" name="breakMax" value=""> </td>
			</tr>
		</table>
		
		
		<br>
		<br>
		<div class="section-header">SPECIAL INSTRUCTIONS:-</div>
		<div class="section-content">
			<textarea style="width: 100%; height: 150px;" name="specialInstruction"></textarea>
		</div>
		<br><br>
		<input type="submit" value="Submit" id="saveBtn">
		<br><br>
		<br><br>
	</div>
	
	
</form>	
	
</c:if>

</security:authorize>

<!-- View Page -->
<c:if test="${viewpage}">

<div id="printDiv">
	
	<table style="width: 100%;">
		<tr>
			<td style="width: 130px;">GRADE CODE:</td>
			<td style="width: 250px;" id="gradeText">${grade.gradeCode}</td>
			<td style="width: 130px;">Revision Date:</td>
			<td><fmt:formatDate value="${grade.revisionDate}" pattern="MM/dd/yyyy" var="rdate"/>${rdate }</td>
		</tr>
		<tr>
			<td valign="top">TM No.</td>
			<td valign="top">${grade.tmNo}</td>
			<td valign="top">Description.</td>
			<td valign="top">${grade.description}</td>
		</tr>
		<tr>
			<td>Customer Grade:</td>
			<td>${grade.customerGrade }</td>
			<td>Customer:</td>
			<td>
				${grade.customer }
			</td>
		</tr>
		<tr>
			<td>ST Tissue Approval.</td>
			<td>${grade.tissueApproval }</td>
			<td>Customer Approval</td>
			<td>${grade.customerApproval }</td>
		</tr>
	</table>
	<br>
	<span style="font-size: 14px; font-weight: bold;">PHYSICAL PROPERTIES:-</span>
	<table class="table" style="font-size: 12px;text-align: center;border-collapse: collapse;">
		<thead>
		<tr>
			<th style="width: 120px;">&nbsp;</th>
			<th style="width: 100px;">Units</th>
			<th style="width: 80px;">Reject Min</th>
			<th style="width: 80px;">Control Min</th>
			<th style="width: 80px;">TARGET</th>
			<th style="width: 80px;">Control Max</th>
			<th style="width: 80px;">Reject Max</th>
			<th style="width: 200px;">Notes</th>
		</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${gradeTargets}" var="gradeTarget">
			<tr>
				<td>${gradeTarget.propertyName}</td>
				<td>${gradeTarget.unitName}</td>
				<td>${gradeTarget.rejectMin}</td>
				<td>${gradeTarget.controlMin}</td>
				<td>${gradeTarget.target}</td>
				<td>${gradeTarget.controlMax}</td>
				<td>${gradeTarget.rejectMax}</td>
				<td>${gradeTarget.note}</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	
	<br>
	<span style="font-size: 14px; font-weight: bold;">NOTES:-</span>
		<pre>
		${grade.notes }
		</pre>
	<br>
	
	
	<span style="font-size: 14px; font-weight: bold;">VISUAL STANDARDS:-</span>
	<pre>
	${grade.visualStandard }
	</pre>
		
	<br>
	<table class="table" style="text-align: center;">
		<tbody>
		<tr>
			<th width="200"></th>
			<th width="200">Min</th>
			<th width="200">Target</th>
			<th width="200">Max</th>
		</tr>
		<tr>
			<td>TRIM</td>
			<td>${grade.trimMin}</td>
			<td>${grade.trimTarget}</td>
			<td>${grade.trimMax}</td>
		</tr>
		<tr>
			<td>DIAMETER</td>
			<td>${grade.diameterMin }</td>
			<td>${grade.diameterTarget }</td>
			<td>${grade.diameterMax }</td>
		</tr>
		<tr>
			<td>BREAKS</td>
			<td>${grade.breakMin }</td>
			<td>${grade.breakTarget }</td>
			<td>${grade.breakMax }</td>
		</tr>
		</tbody>
	</table>

	<br>
	<span style="font-size: 14px; font-weight: bold;">SPECIAL INSTRUCTIONS:-</span>
	<pre>
		${grade.specialInstruction }
	</pre>
	<br>
</div>

</c:if>


<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR6')">

<!-- Edit Page -->
<c:if test="${editpage}">

<form action="${gradeUrl}/update" method="post">
	<div>
	
		<table style="width: 100%;">
			<tr>
				<td style="width: 130px;">GRADE CODE:</td>
				<td style="width: 250px;"><input readonly="readonly" type="text" name="gradeCode" style="width: 200px;" value="${grade.gradeCode}"> </td>
				<td style="width: 130px;">Revision Date:</td>
				<td>
				<fmt:formatDate value="${grade.revisionDate}" pattern="MM/dd/yyyy" var="urdate"/>
				<input readonly="readonly" type="text" name="revisionDate" style="width: 200px;" value="${urdate}"></td>
			</tr>
					<tr>
				<td valign="top">TM No.</td>
				<td valign="top"><input type="text" name="tmNo" style="width: 200px;" value="${grade.tmNo}"></td>
				<td valign="top">Description.</td>
				<td valign="top"><textarea name="description" style="width: 200px; height: 40px;">${grade.description}</textarea></td>
			</tr>
			<tr>
				<td>Customer Grade:</td>
				<td><input type="text" name="customerGrade" style="width: 200px;" value="${grade.customerGrade }"></td>
				<td>Customer:</td>
				<td>
					<select name="customer" style="width: 204px; padding: 2px;">
						<option value="">Select</option>
						<c:set var="cutName">${grade.customer}</c:set>
						<c:forEach items="${customers}" var="customer">
							<c:choose>
								<c:when test="${customer == cutName}">
									<option value="${customer}" selected="selected">${customer}</option>
								</c:when>
								<c:otherwise>
									<option value="${customer}">${customer}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					
				</td>
			</tr>
			<tr>
				<td>ST Tissue Approval.</td>
				<td><input type="text" name="tissueApproval" style="width: 200px;" value="${grade.tissueApproval }"></td>
				<td>Customer Approval</td>
				<td><input type="text" name="customerApproval" style="width: 200px;" value="${grade.customerApproval }"></td>
			</tr>
		</table>
	
	
		<br><br>
		<div class="section-header">PHYSICAL PROPERTIES:-</div>
		<div class="section-content">
			<table class="table" style="font-size: 12px;text-align: center;border-collapse: collapse;">
				<thead>
				<tr>
					<th style="width: 120px;">&nbsp;</th>
					<th style="width: 100px;">Units</th>
					<th style="width: 80px;">Reject Min</th>
					<th style="width: 80px;">Control Min</th>
					<th style="width: 80px;">TARGET</th>
					<th style="width: 80px;">Control Max</th>
					<th style="width: 80px;">Reject Max</th>
					<th style="width: 200px;">Notes</th>
				</tr>
				</thead>
				
				<tbody>
				<c:forEach items="${gradeTargets}" var="gradeTarget">
					<tr>
						<td>${gradeTarget.propertyName}</td>
						<td>${gradeTarget.unitName}<input type="hidden" name="physicalProperty" value="${gradeTarget.physicalProperty}"> </td>
						<td><input name="rejectMin" type="text" style="width: 80px;text-align: center;" value="${gradeTarget.rejectMin}"> </td>
						<td><input name="controlMin" type="text" style="width: 80px;text-align: center;" value="${gradeTarget.controlMin}"> </td>
						<td><input name="target" type="text" style="width: 80px;text-align: center;" value="${gradeTarget.target}"> </td>
						<td><input name="controlMax" type="text" style="width: 80px;text-align: center;" value="${gradeTarget.controlMax}"> </td>
						<td><input name="rejectMax" type="text" style="width: 80px;text-align: center;" value="${gradeTarget.rejectMax}"> </td>
						<td><input name="note" type="text" style="width: 200px;text-align: center;" value="${gradeTarget.note}"> </td>
					</tr>
				</c:forEach>
				</tbody>
				
			</table>
		</div>
		
		<br>
		<div class="section-header">NOTES:-</div>
		<div class="section-content">
			<textarea style="width: 100%; height: 100px;" name="notes">${grade.notes }</textarea>
		</div>
		
		
		<div class="section-header">VISUAL STANDARDS:-</div>
		<div class="section-content">
			<textarea style="width: 100%; height: 100px;" name="visualStandard">${grade.visualStandard }</textarea>
		</div>
		<br>
		<table >
			<tr>
				<th></th>
				<th>Min</th>
				<th>Target</th>
				<th>Max</th>
			</tr>
			<tr>
				<td>TRIM</td>
				<td><input type="text" style="width: 100px;" name="trimMin" value="${grade.trimMin}"> </td>
				<td><input type="text" style="width: 100px;" name="trimTarget" value="${grade.trimTarget}"> </td>
				<td><input type="text" style="width: 100px;" name="trimMax" value="${grade.trimMax}"> </td>
			</tr>
			<tr>
				<td>DIAMETER</td>
				<td><input type="text" style="width: 100px;" name="diameterMin" value="${grade.diameterMin }"> </td>
				<td><input type="text" style="width: 100px;" name="diameterTarget" value="${grade.diameterTarget }"> </td>
				<td><input type="text" style="width: 100px;" name="diameterMax" value="${grade.diameterMax }"> </td>
			</tr>
			<tr>
				<td>BREAKS</td>
				<td><input type="text" style="width: 100px;" name="breakMin" value="${grade.breakMin }"> </td>
				<td><input type="text" style="width: 100px;" name="breakTarget" value="${grade.breakTarget }"> </td>
				<td><input type="text" style="width: 100px;" name="breakMax" value="${grade.breakMax }"> </td>
			</tr>
		</table>
		
		
		<br>
		<br>
		<div class="section-header">SPECIAL INSTRUCTIONS:-</div>
		<div class="section-content">
			<textarea style="width: 100%; height: 150px;" name="specialInstruction">${grade.specialInstruction }</textarea>
		</div>
		<br><br>
		<input type="submit" value="Submit" id="updateBtn">
		<br><br>
		<br><br>
	</div>
</form>	



</c:if>

</security:authorize>
			</div>

		</div>


	</div>

</div>
<!-- /.content-wrapper -->
                   <footer class="main-footer" style="text-align:center;color:black; height:20px;">
                       <strong> Copyright Barnwell Tissue Solutions 2025 </strong>
                   </footer>
</div>	
</body>
</html>
