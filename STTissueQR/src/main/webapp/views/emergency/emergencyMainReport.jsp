<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<jsp:include page="../common.jsp"></jsp:include>

<!-- Make sure jQuery UI is loaded after jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<style type="text/css">
/* Date Picker Styles */
.ui-datepicker {
	width: 320px;
	padding: 0;
	display: none;
	background: #fff;
	border: none;
	box-shadow: 0 5px 15px rgba(0,0,0,0.15);
	font-family: Arial, sans-serif;
	border-radius: 8px;
	overflow: hidden;
	position: absolute !important;
}

/* Calendar Navigation Buttons */
.ui-datepicker .ui-datepicker-prev, 
.ui-datepicker .ui-datepicker-next {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    width: 30px;
    height: 30px;
    cursor: pointer;
    background: rgba(255, 255, 255, 0.1);
    border: 2px solid rgba(255, 255, 255, 0.6);
    border-radius: 50%;
    transition: all 0.3s ease;
    display: flex;
    align-items: center;
    justify-content: center;
}

.ui-datepicker .ui-datepicker-prev {
    left: 8px;
}

.ui-datepicker .ui-datepicker-next {
    right: 8px;
}

.ui-datepicker .ui-datepicker-prev span,
.ui-datepicker .ui-datepicker-next span {
    display: none;
}

.ui-datepicker .ui-datepicker-prev:before,
.ui-datepicker .ui-datepicker-next:before {
    content: '';
    width: 0;
    height: 0;
    border-style: solid;
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
}

.ui-datepicker .ui-datepicker-prev:before {
    border-width: 7px 10px 7px 0;
    border-color: transparent #ffffff transparent transparent;
    left: 8px;
}

.ui-datepicker .ui-datepicker-next:before {
    border-width: 7px 0 7px 10px;
    border-color: transparent transparent transparent #ffffff;
    right: 8px;
}

.ui-datepicker .ui-datepicker-prev:hover,
.ui-datepicker .ui-datepicker-next:hover {
    background: rgba(255, 255, 255, 0.2);
    border-color: #ffffff;
}

/* Calendar Header Layout */
.ui-datepicker .ui-datepicker-header {
    background: linear-gradient(to bottom, #2189b9, #1c7aa6);
    color: white;
    border: none;
    padding: 15px 45px;
    margin: 0;
    position: relative;
    border-bottom: 1px solid rgba(255,255,255,0.1);
    display: flex;
    align-items: center;
    justify-content: center;
}

.ui-datepicker .ui-datepicker-title {
    margin: 0;
    line-height: 1.8em;
    text-align: center;
    font-weight: 600;
    font-size: 16px;
    color: #ffffff;
    text-shadow: 0 1px 1px rgba(0,0,0,0.1);
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 5px;
}

/* Month/Year Dropdowns */
.ui-datepicker select.ui-datepicker-month,
.ui-datepicker select.ui-datepicker-year {
    width: 45%;
    height: 32px;
    margin: 0 2px;
    border: 1px solid rgba(255,255,255,0.3);
    background: rgba(255,255,255,0.1);
    color: white;
    border-radius: 4px;
    padding: 5px;
    font-size: 14px;
    font-weight: 600;
    cursor: pointer;
    appearance: none;
    -webkit-appearance: none;
    -moz-appearance: none;
    background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' viewBox='0 0 24 24' fill='none' stroke='white' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3E%3Cpolyline points='6 9 12 15 18 9'%3E%3C/polyline%3E%3C/svg%3E");
    background-repeat: no-repeat;
    background-position: right 8px center;
    background-size: 12px;
    padding-right: 25px;
}

/* Input field styling */
input.hasDatepicker {
	cursor: pointer;
	background: #fff url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="%232189b9" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect><line x1="16" y1="2" x2="16" y2="6"></line><line x1="8" y1="2" x2="8" y2="6"></line><line x1="3" y1="10" x2="21" y2="10"></line></svg>') no-repeat right 8px center;
	padding: 8px 12px;
	padding-right: 35px;
	border: 1px solid #ddd;
	border-radius: 4px;
	font-size: 14px;
	transition: all 0.3s ease;
}

input.hasDatepicker:hover {
	border-color: #2189b9;
}

input.hasDatepicker:focus {
	border-color: #2189b9;
	box-shadow: 0 0 0 3px rgba(33, 137, 185, 0.1);
	outline: none;
}

/* Ensure datepicker appears above other elements */
#ui-datepicker-div {
	z-index: 999999 !important;
	position: absolute !important;
}

/* Fix positioning context */
.form-group {
	position: relative !important;
	z-index: 1;
}

/* Basic styles */
body {
    background-color: #f5f5f5;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 1600px;
    margin: 80px auto 20px;
    padding: 0 20px;
}

/* Page Title */
.page-title {
    text-align: center;
    margin-bottom: 40px;
    padding: 20px 0;
}

.page-title h1 {
    font-size: 2.5rem;
    color: #2c3e50;
    font-weight: 700;
    margin: 0;
}

/* Search Form */
.search-form {
    background: #fff;
    border-radius: 12px;
    padding: 25px;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
    margin-bottom: 30px;
    max-width: 1600px;
    margin-left: 140px;
    margin-right: auto;
}

.form-row {
    display: flex;
    flex-wrap: nowrap !important;
    gap: 20px;
    margin-bottom: 25px;
    align-items: flex-start;
    padding: 0 5px;
}

.form-group {
    flex: 1;
    min-width: 200px;
    position: relative;
}

.form-group label {
    display: block;
    font-size: 0.95rem;
    color: #2c3e50;
    margin-bottom: 8px;
    font-weight: 500;
    padding-left: 2px;
}

.form-control {
    width: 100%;
    padding: 10px 15px;
    border: 1px solid #e0e0e0;
    border-radius: 8px;
    font-size: 0.95rem;
    transition: all 0.3s ease;
    box-sizing: border-box;
    background-color: #f8f9fa;
    color: #2c3e50;
}

.form-control:focus {
    border-color: #2189b9;
    box-shadow: 0 0 0 3px rgba(33, 137, 185, 0.1);
    background-color: #fff;
    outline: none;
}

.form-control:hover {
    border-color: #2189b9;
    background-color: #fff;
}

/* Select Dropdowns */
select.form-control {
    appearance: none;
    background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' viewBox='0 0 24 24' fill='none' stroke='%232c3e50' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3E%3Cpolyline points='6 9 12 15 18 9'%3E%3C/polyline%3E%3C/svg%3E");
    background-repeat: no-repeat;
    background-position: right 12px center;
    padding-right: 35px;
    cursor: pointer;
}

/* Button */
.btn {
    background: linear-gradient(135deg, #2189b9, #1c7aa6);
    color: white;
    border: none;
    padding: 12px 25px;
    border-radius: 8px;
    font-size: 1rem;
    cursor: pointer;
    transition: all 0.3s ease;
    font-weight: 500;
    min-width: 120px;
    text-align: center;
    display: inline-block;
}

.btn:hover {
    background: linear-gradient(135deg, #1c7aa6, #166d96);
}

/* Checkbox Groups */
.checkbox-group {
    margin-top: 15px;
    margin-bottom: 20px;
    background: #f8f9fa;
    padding: 15px;
    border-radius: 8px;
    border: 1px solid #e0e0e0;
}

.checkbox-group h3 {
    font-size: 1.1rem;
    color: #2c3e50;
    margin-bottom: 15px;
    font-weight: 600;
    padding-left: 5px;
}

.checkbox-options {
    display: flex;
    flex-wrap: wrap;
    gap: 8px;
    margin-bottom: 10px;
    padding: 0 5px;
}

.checkbox-option {
    display: flex;
    align-items: center;
    gap: 6px;
    min-width: 120px;
    flex: 0 1 auto;
    margin-bottom: 5px;
    padding: 5px 8px;
    background: #fff;
    border-radius: 6px;
    border: 1px solid #e0e0e0;
    transition: all 0.2s ease;
}

.checkbox-option:hover {
    border-color: #2189b9;
    background: #f0f7fb;
}

.checkbox-option input[type="checkbox"] {
    width: 16px;
    height: 16px;
    border: 2px solid #ddd;
    border-radius: 4px;
    cursor: pointer;
    margin: 0;
    flex-shrink: 0;
    transition: all 0.2s ease;
}

.checkbox-option input[type="checkbox"]:checked {
    border-color: #2189b9;
    background-color: #2189b9;
}

.checkbox-option label {
    font-size: 0.9rem;
    color: #2c3e50;
    cursor: pointer;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    flex: 1;
}

/* Loader */
.loader-overlay {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(255, 255, 255, 0.8);
    z-index: 9999;
    justify-content: center;
    align-items: center;
}

.loader {
    width: 100px;
    height: 100px;
    border: 5px solid #f3f3f3;
    border-radius: 50%;
    border-top: 5px solid #2189b9;
    -webkit-animation: spin 1s linear infinite;
    animation: spin 1s linear infinite;
    position: relative;
}

.loader::after {
    content: "Loading...";
    position: absolute;
    top: 120%;
    left: 50%;
    transform: translateX(-50%);
    color: #2189b9;
    font-size: 16px;
    font-weight: 500;
    white-space: nowrap;
}

@-webkit-keyframes spin {
    0% { -webkit-transform: rotate(0deg); }
    100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
}

/* Responsive styles */
@media screen and (max-width: 1200px) {
    .container {
        margin: 60px auto 20px;
        padding: 0 15px;
    }
    
    .search-form {
        padding: 20px;
    }
    
    .form-row {
        gap: 15px;
    }
}

@media screen and (max-width: 768px) {
    .container {
        margin: 50px auto 15px;
    }
    
    .page-title h1 {
        font-size: 2rem;
    }
    
    .search-form {
        padding: 15px;
        margin-left: 0;
    }
    
    .form-row {
        flex-wrap: wrap;
        gap: 10px;
    }
    
    .form-group {
        flex: 1 1 100%;
        min-width: 100%;
    }
    
    .btn {
        width: 100%;
        margin-top: 10px;
    }
}

@media screen and (max-width: 480px) {
    .container {
        margin: 40px auto 10px;
    }
    
    .page-title h1 {
        font-size: 1.75rem;
    }
    
    .search-form {
        padding: 12px;
    }
    
    .form-control {
        padding: 8px 12px;
        font-size: 0.9rem;
    }
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		// Destroy any existing datepicker instances
		$('input[name=sdate],input[name=edate]').datepicker('destroy');
		
		// Initialize datepicker with improved options
		$('input[name=sdate],input[name=edate]').datepicker({
			dateFormat: 'mm-dd-yy',
			changeMonth: true,
			changeYear: true,
			yearRange: '-100:+0',
			maxDate: -1,
			showAnim: 'fadeIn',
			duration: 'fast',
			showOtherMonths: true,
			selectOtherMonths: true,
			beforeShow: function(input, inst) {
				// Calculate position relative to input
				var inputOffset = $(input).offset();
				var windowHeight = $(window).height();
				var datepickerHeight = inst.dpDiv.outerHeight();
				
				// Check if there's enough space below the input
				var spaceBelow = windowHeight - (inputOffset.top - $(window).scrollTop() + $(input).outerHeight());
				
				// Position above input if not enough space below
				var top = spaceBelow < datepickerHeight ? 
						  -(datepickerHeight + 5) : // Position above with 5px gap
						  $(input).outerHeight() + 5; // Position below with 5px gap
				
				// Set position
				inst.dpDiv.css({
					top: top + 'px',
					left: '0px',
					position: 'absolute',
					zIndex: 999999
				});
				
				// Ensure datepicker is contained within viewport
				setTimeout(function() {
					var dpOffset = inst.dpDiv.offset();
					var rightEdge = dpOffset.left + inst.dpDiv.outerWidth();
					var viewportWidth = $(window).width();
					
					if (rightEdge > viewportWidth) {
						inst.dpDiv.css('left', (viewportWidth - inst.dpDiv.outerWidth() - 10) + 'px');
					}
				}, 0);
			},
			onSelect: function(dateText, inst) {
				$(this).change();
			}
		});
		
		// Prevent keyboard input but allow clicking
		$('input[name=sdate],input[name=edate]').on('keydown', function(e) {
			e.preventDefault();
		});
		
		// Add calendar icon indicator class
		$('input[name=sdate],input[name=edate]').addClass('hasDatepicker');

		// Existing checkbox code
		$('input[type=checkbox]')
			.change(
				function() {
					var incidentType = '';
					var starIncidentLocation = '';
					var locationIncidentOccured = '';
					$('input[type=checkbox]:checked')
						.each(
							function() {
								var id = $(this).attr('id');
								if (id >= 1 & id <= 8) {
									starIncidentLocation = starIncidentLocation + $(this).val() + ",";
								} else if (id >= 9 & id <= 14) {
									incidentType = incidentType + $(this).val() + ",";
								} else if (id >= 15 & id <= 33) {
									locationIncidentOccured = locationIncidentOccured + $(this).val() + ",";
								}
							});
					$('input[name=starIncidentLocation]').val(starIncidentLocation);
					$('input[name=incidentType]').val(incidentType);
					$('input[name=locationIncidentOccured]').val(locationIncidentOccured);
				});

		// Initialize resizable on the iframe container
		$('.iframe-container').resizable({
			handles: 'se',
			minHeight: 400,
			minWidth: 800,
			animate: true,
			animateDuration: 'fast',
			animateEasing: 'easeOutQuad',
			start: function(event, ui) {
				$(this).css('transition', 'none'); // Disable transition during resize
			},
			stop: function(event, ui) {
				$(this).css('transition', 'all 0.1s ease'); // Re-enable transition
			}
		});
	});
</script>
</head>
<body>
	<div class="wrapper">
		<!-- Add loader overlay -->
		<div class="loader-overlay">
			<div class="loader"></div>
		</div>
		
		<!-- Include Header -->
		<header style="position: fixed; top: 0; left: 0; right: 0; z-index: 1000; background: white;">
			<jsp:include page="../header.jsp" />
		</header>
		
		<div class="container">
			<div class="page-title">
				<h1>Incident Analysis Report</h1>
			</div>
			
			<div class="search-form">
				<div class="form-row">
					<div class="form-group">
						<label>Start Date</label>
						<input type="text" class="form-control" readonly name="sdate" value="${sdate}" id="sdate">
					</div>
					<div class="form-group">
						<label>End Date</label>
						<input type="text" class="form-control" readonly name="edate" value="${edate}" id="edate">
					</div>
					<div class="form-group">
						<label>Status</label>
						<select class="form-control" name="status" id="status">
							<option value="-1">Select status</option>
							<option value="Open" ${status == 'Open' ? 'selected' : ''}>Open</option>
							<option value="Closed" ${status == 'Closed' ? 'selected' : ''}>Closed</option>
						</select>
					</div>
					<div class="form-group">
						<label>Team</label>
						<select class="form-control" name="crew" id="crew">
							<option value="-1">Select team</option>
							<option value="A" ${data.crew == 'A' ? 'selected' : ''}>A</option>
							<option value="B" ${data.crew == 'B' ? 'selected' : ''}>B</option>
							<option value="C" ${data.crew == 'C' ? 'selected' : ''}>C</option>
							<option value="D" ${data.crew == 'D' ? 'selected' : ''}>D</option>
							<option value="E&I" ${data.crew == 'E&I' ? 'selected' : ''}>E&I</option>
							<option value="maintenance" ${data.crew == 'maintenance' ? 'selected' : ''}>Maintenance</option>
							<option value="officeadmin" ${data.crew == 'officeadmin' ? 'selected' : ''}>Office Admin</option>
							<option value="dayTeam1" ${data.crew == 'dayTeam1' ? 'selected' : ''}>Day Team 1</option>
							<option value="dayTeam2" ${data.crew == 'dayTeam2' ? 'selected' : ''}>Day Team 2</option>
							<option value="other" ${data.crew == 'other' ? 'selected' : ''}>Other</option>
						</select>
					</div>
					<div class="form-group" style="flex: 0;">
						<label>&nbsp;</label>
						<button class="btn" id="viewButton">View</button>
					</div>
				</div>

				<div class="checkbox-group">
					<h3>Mill Area Where Incident Occurred</h3>
					<div class="checkbox-options">
						<input hidden type="text" value="${data.starIncidentLocation}" name="starIncidentLocation" />
						<div class="checkbox-option">
							<input type="checkbox" value="Down" id="1">
							<label for="1">Down</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Trans" id="2">
							<label for="2">Trans</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Shipping" id="4">
							<label for="4">Shipping</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Temp Matrial Handling" id="5">
							<label for="5">Temp Matrial Handling</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Utilities" id="6">
							<label for="6">Utilities</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Stock" id="7">
							<label for="7">Stock</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Other" id="8">
							<label for="8">Other</label>
						</div>
					</div>
				</div>

				<div class="checkbox-group">
					<h3>Incident Type</h3>
					<div class="checkbox-options">
						<input hidden type="text" value="${data.incidentType}" name="incidentType" />
						<div class="checkbox-option">
							<input type="checkbox" value="Near_Miss" id="9">
							<label for="9">Near Miss</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="First_Aid" id="10">
							<label for="10">First Aid</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Medical_Treatment" id="11">
							<label for="11">Medical Treatment</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Unsafe_Condition" id="12">
							<label for="12">Unsafe Condition</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Safe_Work" id="13">
							<label for="13">Safe Work</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Damage_Report" id="14">
							<label for="14">Damage Report</label>
						</div>
					</div>
				</div>

				<div class="checkbox-group">
					<h3>Mill Area System</h3>
					<div class="checkbox-options">
						<input hidden type="text" value="${data.locationIncidentOccured}" name="locationIncidentOccured" />
						<div class="checkbox-option">
							<input type="checkbox" value="Shipping" id="15">
							<label for="15">Shipping</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Receiving, Production" id="16">
							<label for="16">Receiving, Production</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Wet End" id="17">
							<label for="17">Wet End</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Drying" id="18">
							<label for="18">Drying</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Disaster" id="19">
							<label for="19">Disaster</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Shipping" id="20">
							<label for="20">Shipping</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Lab" id="21">
							<label for="21">Lab</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Additive" id="22">
							<label for="22">Additive</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Boller" id="23">
							<label for="23">Boller</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Clarifier" id="24">
							<label for="24">Clarifier</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Air Systems" id="25">
							<label for="25">Air Systems</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Stock Prep" id="26">
							<label for="26">Stock Prep</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Wood Room" id="27">
							<label for="27">Wood Room</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Wood Yard" id="28">
							<label for="28">Wood Yard</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Scale House" id="29">
							<label for="29">Scale House</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Divi" id="30">
							<label for="30">Divi</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Super Calender" id="31">
							<label for="31">Super Calender</label>
						</div>
						<div class="checkbox-option">
							<input type="checkbox" value="Winder" id="32">
							<label for="32">Winder</label>
						</div>
					</div>
				</div>
			</div>

			<div class="iframe-container">
				<iframe id="viewFrame" style="width: 100%; height: 600px; border: none;" src="about:blank" onload="styleIframeContent(this)"></iframe>
			</div>
		</div>
	</div>

	<spring:url value="/911EmergencyReport/reportview" var="emrgencyUrl" />
	<script type="text/javascript">
		$(function() {
			// Show loader when View button is clicked
			$('#viewButton').click(function() {
				$('.loader-overlay').css('display', 'flex');
				
				var status = $('select[name=status]').val();
				var sdate = $('input[name=sdate]').val();
				var edate = $('input[name=edate]').val();
				var starIncidentLocation = $('input[name=starIncidentLocation]').val();
				var incidentType = $('input[name=incidentType]').val();
				var locationIncidentOccured = $('input[name=locationIncidentOccured]').val();
				var crew = $('select[name=crew]').val();

				// Hide iframe container and remove any existing table classes
				$('.iframe-container').hide().removeClass('has-data');
				$('.no-data-message').remove();

				// Load data directly into iframe
				var iframeUrl = '${emrgencyUrl}?sdate=' + encodeURIComponent(sdate) +
					'&edate=' + encodeURIComponent(edate) +
					'&starIncidentLocation=' + encodeURIComponent(starIncidentLocation) +
					'&incidentType=' + encodeURIComponent(incidentType) +
					'&status=' + encodeURIComponent(status) +
					'&locationIncidentOccured=' + encodeURIComponent(locationIncidentOccured) +
					'&crew=' + encodeURIComponent(crew);

				$('#viewFrame').attr('src', iframeUrl);

				// Handle iframe load event
				$('#viewFrame').on('load', function() {
					$('.loader-overlay').hide();
					
					try {
						var iframeDoc = this.contentDocument || this.contentWindow.document;
						var table = iframeDoc.querySelector('table');
						
						if (table && table.rows.length > 1) { // Check if table has more than header row
							$('.iframe-container').show().addClass('has-data');
						} else {
							$('.iframe-container').hide();
							showNoDataMessage();
						}
					} catch (e) {
						console.log('Error checking iframe content:', e);
						$('.iframe-container').hide();
						showNoDataMessage();
					}
				});
			});

			// Function to show no data message
			function showNoDataMessage() {
				// Remove existing message if any
				$('.no-data-message').remove();
				
				// Create and show message
				var message = $('<div class="no-data-message">')
					.css({
						'text-align': 'center',
						'padding': '30px',
						'background': '#f8f9fa',
						'border-radius': '8px',
						'margin': '20px auto',
						'max-width': '600px',
						'box-shadow': '0 2px 10px rgba(0,0,0,0.05)',
						'border': '1px solid rgba(0,0,0,0.05)'
					})
					.html('<h3 style="color: #2c3e50; margin-bottom: 15px;">No Data Found</h3>' +
						'<p style="color: #666;">No records match your search criteria. Please try different filters.</p>');
				
				$('.container').append(message);
			}
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$('#excelLink')
					.click(
							function() {
								var reels = $('#viewFrame')[0].contentWindow
										.getSelectedReel();
								var customer = $(
										'select[name=customer]')
										.val();
								var sdate = $('input[name=sdate]')
										.val();
								var edate = $('input[name=edate]')
										.val();

								if (!customer) {
									alert('Select customer.');
									return false;
								} else if (!reels
										| reels.length == 0) {
									alert('Select reels.');
									return false;
								} else {
									var url = '${excelURL}?reels='
											+ encodeURIComponent(reels
													.toString())
											+ '&customer='
											+ encodeURIComponent(customer)
											+ '&sdate='
											+ encodeURIComponent(sdate)
											+ '&edate='
											+ encodeURIComponent(edate);
									$(this).attr('href', url);
								}

								return true;
							});
			$('#pdfLink')
					.click(
							function() {
								var reels = $('#viewFrame')[0].contentWindow
										.getSelectedReel();
								var customer = $(
										'select[name=customer]')
										.val();

								if (!customer) {
									alert('Select customer.');
									return false;
								} else if (!reels
										| reels.length == 0) {
									alert('Select reels.');
									return false;
								} else {
									var url = '${pdfURL}?reels='
											+ encodeURIComponent(reels
													.toString())
											+ '&customer='
											+ encodeURIComponent(customer);
									$(this).attr('href', url);
								}

								return true;
							});
		});
	</script>
	<script type="text/javascript">
	// Add this function to apply styles to the iframe content
	function styleIframeContent(iframe) {
		try {
			if (iframe.contentDocument) {
				const style = document.createElement('style');
				style.textContent = `
					/* Table Container */
					.table-container {
						background: white;
						border-radius: 12px;
						box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
						overflow: hidden;
						margin: 20px;
					}

					/* Table Styles */
					table {
						width: 100%;
						border-collapse: separate;
						border-spacing: 0;
						background: white;
						font-size: 14px;
						margin-left: 172px !important;
						font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
					}

					/* Table Header */
					th {
						background: linear-gradient(135deg, #2189b9, #1c7aa6);
						color: white;
						padding: 15px 20px;
						text-align: left;
						font-weight: 600;
						border: none;
						white-space: nowrap;
						position: sticky;
						top: 0;
						z-index: 10;
					}

					th:first-child {
						border-top-left-radius: 12px;
					}

					th:last-child {
						border-top-right-radius: 12px;
					}

					/* Table Cells */
					td {
						padding: 15px 20px;
						border-bottom: 1px solid #eee;
						color: #2c3e50;
						transition: all 0.3s ease;
					}

					/* Row Hover Effect */
					tr:hover td {
						background-color: #f0f7fb;
						transform: translateY(-1px);
						box-shadow: 0 2px 8px rgba(0,0,0,0.05);
					}

					/* Even Row Background */
					tr:nth-child(even) td {
						background-color: #f8f9fa;
					}

					tr:nth-child(even):hover td {
						background-color: #e6f2f8;
					}

					/* Last Row */
					tr:last-child td {
						border-bottom: none;
					}

					/* Links */
					a {
						color: #2189b9;
						text-decoration: none;
						font-weight: 500;
						transition: all 0.3s ease;
						display: inline-block;
						padding: 4px 8px;
						border-radius: 4px;
					}

					a:hover {
						color: #1c7aa6;
						background-color: rgba(33, 137, 185, 0.1);
						text-decoration: none;
					}

					/* Excel Link */
					a.excel-link {
						color: #217346;
						background-color: rgba(33, 115, 70, 0.1);
					}

					a.excel-link:hover {
						background-color: rgba(33, 115, 70, 0.2);
					}

					/* Status Badges */
					.status-badge {
						display: inline-block;
						padding: 6px 12px;
						border-radius: 20px;
						font-size: 12px;
						font-weight: 600;
						text-transform: uppercase;
						letter-spacing: 0.5px;
					}

					.status-open {
						background-color: rgba(220, 53, 69, 0.1);
						color: #dc3545;
					}

					.status-closed {
						background-color: rgba(40, 167, 69, 0.1);
						color: #28a745;
					}

					/* Scrollbar Styling */
					::-webkit-scrollbar {
						width: 8px;
						height: 8px;
					}

					::-webkit-scrollbar-track {
						background: #f1f1f1;
						border-radius: 4px;
					}

					::-webkit-scrollbar-thumb {
						background: #c1c1c1;
						border-radius: 4px;
					}

					::-webkit-scrollbar-thumb:hover {
						background: #a8a8a8;
					}

					/* Responsive Table */
					@media screen and (max-width: 768px) {
						.table-container {
							margin: 10px;
						}

						th, td {
							padding: 12px 15px;
						}
					}
				`;
				iframe.contentDocument.head.appendChild(style);
			}
		} catch (e) {
			console.log('Could not style iframe content:', e);
		}
	}
	</script>
</body>
</html>
