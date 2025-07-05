<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<spring:url value="/911Emergency/view/inident/save" var="saveURL" />
<spring:url value="/911Emergency/incidentReportEntry/save/"
	var="viewURL" />

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
<script type="text/javascript"
	src='<spring:url value="/resources/js/jquery.PrintArea.js"/>'></script>

<style type="text/css">
/* Main Layout */
.container {
	padding-top: 75px;
	padding-left: 250px;
	padding-bottom: 50px;
	max-width: 1400px;
	margin: 0 auto;
	position: relative;
	z-index: 1;
	min-height: calc(100vh - 75px);
}

/* Page Title */
.page-title {
	background: #2189b9;
	color: white;
	padding: 15px 20px;
	margin-bottom: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.page-title .label {
	font-size: 24px;
	font-weight: 600;
}

/* Form Styling */
.form-container {
	background: #fff;
	padding: 25px;
	padding-bottom: 40px;
	border-radius: 8px;
	box-shadow: 0 2px 6px rgba(0,0,0,0.1);
	position: relative;
	z-index: 1;
	margin-left: 190px;
}

/* Star Categories Section - Updated Styles */
.star-categories {
	background: #f8f9fa;
	padding: 25px;
	border-radius: 8px;
	margin: 20px 0;
	border: 1px solid #e9ecef;
}

.category-section {
	margin-bottom: 25px;
	padding: 20px;
	background: #fff;
	border-radius: 6px;
	box-shadow: 0 1px 3px rgba(0,0,0,0.05);
	border: 1px solid #e9ecef;
	transition: all 0.3s ease;
}

.category-section:hover {
	box-shadow: 0 2px 6px rgba(0,0,0,0.1);
	transform: translateY(-1px);
}

.category-title {
	font-weight: 600;
	margin-bottom: 20px;
	color: #2189b9;
	font-size: 16px;
	padding-bottom: 10px;
	border-bottom: 2px solid #e9ecef;
	text-transform: uppercase;
	letter-spacing: 0.5px;
}

.category-items {
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
	gap: 15px;
}

.checkbox-wrapper {
	display: flex;
	align-items: center;
	gap: 10px;
	padding: 12px 15px;
	background: #f8f9fa;
	border-radius: 6px;
	transition: all 0.2s ease;
	border: 1px solid #e9ecef;
}

.checkbox-wrapper:hover {
	background: #e9ecef;
	transform: translateX(5px);
}

.checkbox-wrapper input[type="checkbox"] {
	width: 20px;
	height: 20px;
	margin: 0;
	cursor: pointer;
	accent-color: #2189b9;
}

.checkbox-wrapper label {
	margin: 0;
	font-size: 14px;
	color: #333;
	cursor: pointer;
	flex: 1;
	line-height: 1.4;
	font-weight: 500;
}

/* Responsive Design for Star Categories */
@media (max-width: 768px) {
	.category-items {
		grid-template-columns: 1fr;
	}
	
	.checkbox-wrapper {
		padding: 15px;
	}
	
	.star-categories {
		padding: 15px;
	}
}

/* Form Row Styling */
.form-row {
	display: flex;
	align-items: center;
	margin-bottom: 25px;
	gap: 15px;
}

.form-group {
	flex: 1;
	position: relative;
	z-index: 1;
}

.form-label {
	display: block;
	margin-bottom: 10px;
	font-weight: 600;
	color: #333;
	font-size: 14px;
}

/* Input Styling */
input[type="text"],
select,
textarea {
	width: 100%;
	padding: 10px 15px;
	border: 1px solid #ddd;
	border-radius: 6px;
	font-size: 14px;
	transition: all 0.3s ease;
	background: #fff;
}

input[type="text"]:focus,
select:focus,
textarea:focus {
	border-color: #2189b9;
	outline: none;
	box-shadow: 0 0 0 3px rgba(33, 137, 185, 0.1);
}

/* Button Styling */
.button {
	display: inline-block;
	padding: 12px 28px;
	font-size: 16px;
	font-weight: 600;
	color: #fff;
	background: linear-gradient(to bottom, #3BA4C7 0%, #1982A5 100%);
	border: none;
	border-radius: 6px;
	cursor: pointer;
	transition: all 0.3s ease;
	text-decoration: none;
	text-align: center;
	box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.button:hover {
	transform: translateY(-2px);
	box-shadow: 0 4px 8px rgba(0,0,0,0.15);
	background: linear-gradient(to bottom, #1982A5 0%, #3BA4C7 100%);
}

/* Message Styling */
.message {
	padding: 15px 20px;
	margin: 20px 0;
	border-radius: 6px;
	background: #d4edda;
	color: #155724;
	text-align: center;
	font-weight: 500;
	box-shadow: 0 2px 4px rgba(0,0,0,0.05);
}

/* Error Message Styling */
.error-message {
	color: #dc3545;
	font-size: 12px;
	margin-top: 5px;
	display: none;
	font-weight: 500;
}

/* Radio Button Styling */
input[type="radio"] {
	width: 18px;
	height: 18px;
	margin-right: 8px;
	accent-color: #2189b9;
}

/* Loading Overlay */
.loading-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(255, 255, 255, 0.8);
    display: none;
    justify-content: center;
    align-items: center;
    z-index: 9999;
}

.loading-spinner {
    width: 50px;
    height: 50px;
    border: 5px solid #f3f3f3;
    border-top: 5px solid #2189b9;
    border-radius: 50%;
    animation: spin 1s linear infinite;
}

@keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
}

.loading-text {
    margin-top: 20px;
    color: #2189b9;
    font-weight: 600;
    font-size: 16px;
}

/* Updated Date Picker Styles with Header Color Scheme */
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

.ui-datepicker select.ui-datepicker-month:hover,
.ui-datepicker select.ui-datepicker-year:hover {
    background-color: rgba(255,255,255,0.2);
}

/* Fix for button positioning */
.ui-datepicker .ui-datepicker-prev.ui-state-hover,
.ui-datepicker .ui-datepicker-next.ui-state-hover {
    border: 2px solid #ffffff;
    background: rgba(255, 255, 255, 0.2);
    top: 50%;
    margin-top: -15px;
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
	position: fixed !important;
	z-index: 999999 !important;
	background: #fff;
	border: 1px solid #ddd;
	border-radius: 4px;
	box-shadow: 0 2px 8px rgba(0,0,0,0.15);
}

/* Form Group Positioning */
.form-group {
	position: relative !important;
	z-index: 1;
}

/* Disabled dates */
.ui-datepicker td.ui-state-disabled {
	opacity: 0.3;
}

/* Today's date */
.ui-datepicker td.ui-datepicker-today a {
	position: relative;
	font-weight: 600;
	color: #2189b9;
	background: rgba(33, 137, 185, 0.1);
}

.ui-datepicker td.ui-datepicker-today a:after {
	content: '';
	position: absolute;
	bottom: 4px;
	left: 50%;
	transform: translateX(-50%);
	width: 4px;
	height: 4px;
	background: #2189b9;
	border-radius: 50%;
}

/* Weekend Days */
.ui-datepicker tr td:first-child a,
.ui-datepicker tr td:last-child a {
	color: #e74c3c;
}

/* Load Button Container */
.form-group.load-button {
	margin-top: 33px;
}

/* Ensure header stays above other elements */
.wrapper > header {
	position: relative;
	z-index: 1000000;
}

/* Success Message */
.success-message {
    position: fixed;
    top: 20px;
    right: 20px;
    background: #4CAF50;
    color: white;
    padding: 15px 25px;
    border-radius: 4px;
    box-shadow: 0 2px 5px rgba(0,0,0,0.2);
    display: none;
    z-index: 10000;
    animation: slideIn 0.5s ease;
}

@keyframes slideIn {
    from { transform: translateX(100%); opacity: 0; }
    to { transform: translateX(0); opacity: 1; }
}

@keyframes slideOut {
    from { transform: translateX(0); opacity: 1; }
    to { transform: translateX(100%); opacity: 0; }
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		// Destroy any existing datepicker instances
		$('input[name=edate],input[name=dateOfIncident]').datepicker('destroy');
		
		// Initialize datepicker with improved options
		$('input[name=edate],input[name=dateOfIncident]').datepicker({
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
				// Get input position
				var inputOffset = $(input).offset();
				var inputHeight = $(input).outerHeight();
				
				// Calculate position
				var top = inputOffset.top + inputHeight + 5;
				var left = inputOffset.left;
				
				// Set position
				inst.dpDiv.css({
					position: 'fixed',
					top: top + 'px',
					left: left + 'px',
					zIndex: 999999
				});
				
				// Ensure datepicker stays within viewport
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
		$('input[name=edate],input[name=dateOfIncident]').on('keydown', function(e) {
			e.preventDefault();
		});
		
		// Add calendar icon indicator class
		$('input[name=edate],input[name=dateOfIncident]').addClass('hasDatepicker');

		// Handle star category checkboxes
		$("input[type='checkbox']").on("change", function() {
			// Update the hidden starCategory input with all checked values
			var selectedCategories = [];
			$(".star-categories input[type='checkbox']:checked").each(function() {
				selectedCategories.push($(this).next('label').text().trim());
			});
			$("input[name='starCategory']").val(selectedCategories.join(','));
		});

		// Initialize checkboxes based on existing value
		var existingCategories = $("input[name='starCategory']").val().split(',');
		$(".star-categories input[type='checkbox']").each(function() {
			var labelText = $(this).next('label').text().trim();
			if (existingCategories.includes(labelText)) {
				$(this).prop('checked', true);
			}
		});

		// Auto-hide success message after 3 seconds
		$('.message').delay(3000).fadeOut(500);

		// Add real-time validation
		$('.form-group input, .form-group select').on('blur', function() {
			validateField($(this));
		});
		
		// Form submission handler
		$('#form').on('submit', function(e) {
			e.preventDefault(); // Always prevent default first
			
			// Validate form
			var isValid = validateform();
			
			if (isValid) {
				// Show loading overlay
				$('.loading-overlay').css('display', 'flex');
				
				// Submit form using AJAX
				$.ajax({
					url: $(this).attr('action'),
					type: 'POST',
					data: $(this).serialize(),
					success: function(response) {
						// Hide loader
						$('.loading-overlay').css('display', 'none');
						
						// Show success message
						var successMessage = $('<div class="success-message">Form submitted successfully!</div>');
						$('body').append(successMessage);
						successMessage.fadeIn();
						
						// Reset form fields
						$('#form')[0].reset();
						$('#incidentType').val('-1');
						$('#shift').val('-1');
						$('#crew').val('-1');
						$('#status').val('-1');
						$('#starIncidentLocation').val('-1');
						$('input[type="checkbox"]').prop('checked', false);
						$('input[type="radio"][name="investigation"][value="No"]').prop('checked', true);
						
						// Hide message after 2 seconds and redirect
						setTimeout(function() {
							successMessage.animate({
								opacity: 0,
								right: '-100%'
							}, 300, function() {
								successMessage.remove();
								// Redirect to 911Emergency/view
								window.location.href = '../911Emergency/view';
							});
						}, 2000);
					},
					error: function(xhr, status, error) {
						// Hide loader
						$('.loading-overlay').css('display', 'none');
						// Show error message
						alert('Error submitting form: ' + error);
					}
				});
			}
		});
		
		function validateField($field) {
			var value = $field.val();
			var $error = $field.siblings('.error-message');
			
			if ($field.prop('required') && !value) {
				showError($field, 'This field is required');
				return false;
			}
			
			hideError($field);
			return true;
		}
		
		function showError($field, message) {
			var $error = $field.siblings('.error-message');
			$error.text(message).show();
			$field.addClass('error');
		}
		
		function hideError($field) {
			var $error = $field.siblings('.error-message');
			$error.hide();
			$field.removeClass('error');
		}
	});

	function operatorSelect() {
		var incidentType = $('#incidentType').val();
		var edate = $('#edate').val();
		var employeeNumber = $('#employeeNumber').val();
		var crew = $('#crew').val();
		var shift = $('#shift').val();
		if (incidentType == '-1') {
			alert("Please select IncidentType");
		} else if (shift == '-1') {
			alert("Please select shift");
		} else if (shift != '-1' || incidentType != '-1' || crew != '-1') {
			location.href = "../911Emergency/incident?shift=" + shift
					+ "&incidentType=" + incidentType + "&date=" + edate
					+ "&employeeNumber=" + employeeNumber + "&crew=" + crew;
		}
	}
$(function() {
		var wid = 900;
		$('#printBtn').click(function() {
			$('#tbbl').width(wid)
			$("#checkpoint").css({
				marginLeft : "-284px"
			});
			$('#div_show').show();
			$('#printDiv').printArea();
			$('#tbbl').width(800)
			$("#checkpoint").css({
				marginLeft : "-356px"
			});
			$('#div_show').hide();
		});
	});

	function validateform() {
		var isValid = true;
		
		// Validate required fields
		var requiredFields = [
			{ id: 'crew', errorId: 'err_crew' },
			{ id: 'status', errorId: 'err_status' },
			{ id: 'starIncidentLocation', errorId: 'err_starIncidentLocation' },
			{ id: 'dateOfIncident', errorId: 'err_dateOfIncident' },
			{ id: 'timeOfIncident', errorId: 'err_timeOfIncident' },
			{ id: 'effectedbytheincident', errorId: 'err_effectedbytheincident' },
			{ id: 'employeeNumber', errorId: 'err_employeeNumber' }
		];

		requiredFields.forEach(function(field) {
			var value = $('#' + field.id).val();
			if (!value || value === '-1' || value.trim() === '') {
				$('#' + field.errorId).show();
				isValid = false;
			} else {
				$('#' + field.errorId).hide();
			}
		});

		// Validate time format
		var timeRegex = /^([01]\d|2[0-3]):([0-5]\d):([0-5]\d)$/;
		var timeValue = $('#timeOfIncident').val();
		if (!timeRegex.test(timeValue)) {
			$('#err_timeOfIncident').show();
			isValid = true;
		}

		if (!isValid) {
			$('#err_').show();
			return false;
		}

		return true;
	}

		$('#printBtn').click(function() {
			$('#tbbl td').css("fontSize", 25);
			$('#tbbl td h2').css("fontSize", 25);
			$('#tbbl td span').css("fontSize", 25);
			$('#printDiv').printArea();
		});
$(document).ready(function() {
		$(function() {
			$('#printBtn').click(function() {
				$('#tbbl td').css("fontSize", 25);
				$('#tbbl td h2').css("fontSize", 25);
				$('#tbbl td span').css("fontSize", 25);
				$('#printDiv').printArea();
			});
		});

		$('#submit').click(function() {
			var starIncidentLocation = $('#starIncidentLocation').val();
			var status = $('#status').val();
			var dateOfIncident = $('#dateOfIncident').val();
			var timeOfIncident = $('#timeOfIncident').val();
			var dateReported = $('#dateReported').val();
			
			var effectedbytheincident=$('#effectedbytheincident').val();
			
			var employeeNumber=$('#employeeNumber').val();
			var crew = $('#crew').val();	
			if (status == '-1' || starIncidentLocation == '-1'|| dateOfIncident == '' || timeOfIncident == ''
				|| effectedbytheincident == ''|| employeeNumber == ''|| crew=='-1') {
				if (crew == '-1') {
					$('#err_crew').show();
					$('#err_crew').css({
						"color" : "red"
					});
				} else {
					$('#err_crew').hide();
				}
				if (status == '-1') {
					$('#err_status').show();
					$('#err_status').css({
						"color" : "red"
					});
				} else {
					$('#err_status').hide();
				}
				if (starIncidentLocation == '-1') {
					$('#err_starIncidentLocation').show();
					$('#err_starIncidentLocation').css({
						"color" : "red"
					});
				} else {
					$('#err_starIncidentLocation').hide();
				}

				if (dateOfIncident == '') {
					$('#err_dateOfIncident').show();
					$('#err_dateOfIncident').css({
						"color" : "red"
					});
				} else {
					$('#err_dateOfIncident').hide();
				}
				if (timeOfIncident == '') {
					$('#err_timeOfIncident').show();
					$('#err_timeOfIncident').css({
						"color" : "red"
					});
				} else {
					$('#err_timeOfIncident').hide();
				}
				if (effectedbytheincident == '') {
					$('#err_effectedbytheincident').show();
					$('#err_effectedbytheincident').css({
						"color" : "red"
					});
				} else {
					$('#err_effectedbytheincident').hide();
				}
				if (employeeNumber == '') {
					$('#err_employeeNumber').show();
					$('#err_employeeNumber').css({
						"color" : "red"
					});
				} else {
					$('#err_employeeNumber').hide();
				}
				$('#err_').show();
				$('#err_').css({
					"color" : "red"
				});
				return false;
			} else {
				return true;
			}
		});
		$('select').on('change', function() {
			var starIncidentLocation = $('#starIncidentLocation').val();
			var status = $('#status').val();
			if (status != '-1') {
				$('#err_status').hide();

			}
			if (starIncidentLocation != '-1') {
				$('#err_starIncidentLocation').hide();

			}
		});

		$('input').on('change', function() {
			var dateOfIncident = $('#dateOfIncident').val();
			var timeOfIncident = $('#timeOfIncident').val();
			if (dateOfIncident != '') {
				$('#err_dateOfIncident').hide();
			} 
			if (timeOfIncident != '') {
				$('#err_timeOfIncident').hide();
			}
		});

		$('input[type=checkbox]').change(function() {
			var status = '';
			$('input[type=checkbox]:checked').each(function() {
				// status= status+(this.id)+","; 
				status = status + (this.id) + ",";
			});
			$('input[name=starCategory]').val(status);
		});
		
		$('input[name=furtherFollowUpRequested]').change(function() {
			$('input[name=furtherFollowUpRequested]').val($(this).val());
		});

		$('input[name=investigation]').change(function() {
			$('input[name=investigation]').val($(this).val());
		});
		
	});
</script>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<!-- Loading Overlay -->
	<div class="loading-overlay">
		<div class="loading-content">
			<div class="loading-spinner"></div>
			<div class="loading-text">Submitting form...</div>
		</div>
	</div>

	<div class="wrapper">
		<!-- Include Header -->
		<jsp:include page="../header.jsp" />
		

		<div class="container">
			<div class="form-container">
				<div class="page-title">
					<span class="label">Incident Analysis Report Entry</span>
				</div>

				<form name="dataForm" id="form" action="${saveURL}" method="post" onsubmit="validateform()">
					<!-- Top Selection Row -->
					<div class="form-section">
						<div class="form-row">
							<div class="form-group">
								<label class="form-label">Incident Type</label>
								<select name="incidentType" id="incidentType">
									<option value="-1">Select Incident Type</option>
									<option value="Near_Miss" ${data.incidentType == 'Near_Miss' ? 'selected' : ''}>Near Miss</option>
									<option value="First_Aid" ${data.incidentType == 'First_Aid' ? 'selected' : ''}>First Aid</option>
									<option value="Medical_Treatment" ${data.incidentType == 'Medical_Treatment' ? 'selected' : ''}>Medical Treatment</option>
									<option value="Intervention" ${data.incidentType == 'Intervention' ? 'selected' : ''}>Intervention</option>
									<option value="Unsafe_Condition" ${data.incidentType == 'Unsafe_Condition' ? 'selected' : ''}>Unsafe Condition</option>
									<option value="Safe_Report" ${data.incidentType == 'Safe_Report' ? 'selected' : ''}>Safe Report</option>
									<option value="Damage_Report" ${data.incidentType == 'Damage_Report' ? 'selected' : ''}>Damage Report</option>
								</select>
							</div>

							<div class="form-group">
								<label class="form-label">Reported By</label>
								<input type="text" name="employeeNumber" value="${data.employeeNumber}" id="employeeNumber" />
								<span class="error-message" id="err_employeeNumber">Please Fill The Reported By</span>
							</div>

							<div class="form-group">
								<label class="form-label">Date</label>
								<input type="text" readonly name="edate" value="${data.edate}" id="edate" />
							</div>

							<div class="form-group">
								<label class="form-label">Shift</label>
								<select name="shift" id="shift">
									<option value="-1">Select Shift</option>
									<option value="day" ${data.shift == 'day' ? 'selected' : ''}>Day</option>
									<option value="night" ${data.shift == 'night' ? 'selected' : ''}>Night</option>
								</select>
							</div>

							<div class="form-group load-button">
								<button type="button" class="button" onClick="operatorSelect();">Load</button>
							</div>
						</div>
					</div>

					<c:if test="${not empty message}">
						<div class="message">
							<h3>${message}</h3>
						</div>
					</c:if>

					<c:if test="${not empty data.incidentType}">
						<div class="form-section">
							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Team</label>
									<select name="crew" id="crew">
										<option value="-1">Select Team</option>
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
									<span class="error-message" id="err_crew">Please select a team</span>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Effected by The Incident</label>
									<input type="text" name="effectedbytheincident" value="${data.effectedbytheincident}" id="effectedbytheincident" />
									<span class="error-message" id="err_effectedbytheincident">Please fill the effected by the incident</span>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Safe Report</label>
									<textarea id="safeReportId" placeholder="What did You See....." value="${data.safeReport}" name="safeReport" rows="7" cols="100">${data.safeReport}</textarea>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Status</label>
									<select name="status" id="status">
										<option value="-1">Select status</option>
										<option value="Open" ${data.status == 'Open' ? 'selected' : 'selected'}>Open</option>
										<option value="Closed" ${data.status == 'Closed' ? 'selected' : ''}>Closed</option>
									</select>
									<span class="error-message" id="err_status">Please select status</span>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Date Of Incident</label>
									<input type="text" value="${data.dateOfIncident}" name="dateOfIncident" id="dateOfIncident" />
									<span class="error-message" id="err_dateOfIncident">Please choose date of incident</span>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Time Of Incident(Military Time)</label>
									<input type="text"  value="${data.timeOfIncident}" name="timeOfIncident" id="timeOfIncident" placeholder="HH:MM:SSS" />
									<span class="error-message" id="err_timeOfIncident">Please put time of incident(Military Time) like HH:MM:SSS</span>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Date Reported</label>
									<input type="text" readonly value="${data.dateReported}" name="dateReported" id="dateReported" />
									<span class="error-message" id="err_dateReported">Please choose date reported</span>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Mill Area Where Incident Occured</label>
									<select name="starIncidentLocation" id="starIncidentLocation" onChange="changearea(this.value);">
										<option value="-1" selected>Select Incident Area</option>
										<option value="TM6" ${data.starIncidentLocation == 'TM6' ? 'selected' : ''}>TM6</option>
										<option value="TM5" ${data.starIncidentLocation == 'TM5' ? 'selected' : ''}>TM5</option>
										<option value="FRP" ${data.starIncidentLocation == 'FRP' ? 'selected' : ''}>FRP</option>
										<option value="Shipping" ${data.starIncidentLocation == 'Shipping' ? 'selected' : ''}>Shipping</option>
										<option value="MaterialHandling" ${data.starIncidentLocation == 'MaterialHandling' ? 'selected' : ''}>Material Handling</option>
										<option value="Utilities" ${data.starIncidentLocation == 'Utilities' ? 'selected' : ''}>Utilities</option>
										<option value="StockPrep" ${data.starIncidentLocation == 'StockPrep' ? 'selected' : ''}>Stock</option>
										<option value="Shopsandstores" ${data.starIncidentLocation == 'Shopsandstores' ? 'selected' : ''}>Shops and stores</option>
										<option value="Other" ${data.starIncidentLocation == 'Other' ? 'selected' : ''}>Other</option>
									</select>
									<span class="error-message" id="err_starIncidentLocation">Please select mill area where incident occured</span>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Mill Area System</label>
									<select name="locationIncidentOccured" id="locationIncidentOccured">
										<option value="" selected>Select</option>
									</select>
									<span class="error-message" id="err_locationIncidentOccured">Please select mill area system</span>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Description Of Event</label>
									<textarea id="descpOfEvent" value="${data.descpOfEvent}" name="descpOfEvent" rows="9" cols="150">${data.descpOfEvent}</textarea>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Incident Category</label>
									<p>(Mark the star category that best fit the risk involved)</p>
									<div class="star-categories">
										<input hidden type="text" value="${data.starCategory}" name="starCategory" />
										<div class="category-section">
											<div class="category-title">1.0 Body Position</div>
											<div class="category-items">
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox11" />
													<label for="checkbox11">1.1 Struck By/Struck Against</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox12" />
													<label for="checkbox12">1.2 Pinch Point</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox13" />
													<label for="checkbox13">1.3 Eyes on Path</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox14" />
													<label for="checkbox14">1.4 Eyes on Task</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox15" />
													<label for="checkbox15">1.5 Ascending /Descending</label>
												</div>
											</div>
										</div>

										<div class="category-section">
											<div class="category-title">2.0 ERGONOMICS</div>
											<div class="category-items">
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox21" />
													<label for="checkbox21">2.1 Lifting/Lowering</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox22" />
													<label for="checkbox22">2.2 Awkward Posture</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox23" />
													<label for="checkbox23">2.3 Repetition /Long Duration</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox24" />
													<label for="checkbox24">2.4 Forceful Excretion /Push/Pull/Grip</label>
												</div>
											</div>
										</div>

										<div class="category-section">
											<div class="category-title">3.0 SELECTION/CONDITION/USE</div>
											<div class="category-items">
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox31" />
													<label for="checkbox31">3.1 Tools & Equipment</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox32" />
													<label for="checkbox32">3.2 Mobile Equipment</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox33" />
													<label for="checkbox33">3.3 Cranes</label>
												</div>
											</div>
										</div>

										<div class="category-section">
											<div class="category-title">4.0 PROCEDURES</div>
											<div class="category-items">
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox41" />
													<label for="checkbox41">4.1 Lockout/Tagout/Energy ISO</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox42" />
													<label for="checkbox42">4.2 Communication of Hazards</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox43" />
													<label for="checkbox43">4.3 Pre/Post Job Inspection</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox44" />
													<label for="checkbox44">4.4 Communication of Location</label>
												</div>
											</div>
										</div>

										<div class="category-section">
											<div class="category-title">5.0 PPE</div>
											<div class="category-items">
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox51" />
													<label for="checkbox51">5.1 Standard PPE</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox52" />
													<label for="checkbox52">5.2 Job Specific PPE</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox53" />
													<label for="checkbox53">5.3 Fall Protection</label>
												</div>
											</div>
										</div>

										<div class="category-section">
											<div class="category-title">6.0 Environment</div>
											<div class="category-items">
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox61" />
													<label for="checkbox61">6.1 Walking /Working Surfaces</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox62" />
													<label for="checkbox62">6.2 Housekeeping Storage</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox63" />
													<label for="checkbox63">6.3 Lighting</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox64" />
													<label for="checkbox64">6.4 Air Quality</label>
												</div>
											</div>
										</div>

										<div class="category-section">
											<div class="category-title">7.0 STATE OF MIND</div>
											<div class="category-items">
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox71" />
													<label for="checkbox71">7.1 Hurried</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox72" />
													<label for="checkbox72">7.2 Frustrated</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox73" />
													<label for="checkbox73">7.3 Fatigued</label>
												</div>
												<div class="checkbox-wrapper">
													<input type="checkbox" value="" id="checkbox74" />
													<label for="checkbox74">7.4 Complacent</label>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Further Follow Up Requested</label>
									<input type="checkbox" name="furtherFollowUpRequested" value="${data.furtherFollowUpRequested}" />
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<label class="form-label">Incident Investigation Report</label>
									<label><input type="radio" value="Yes" name="investigation"> Yes </label>  
									<label><input type="radio" value="No"  name="investigation" checked> No </label>
								</div>
							</div>

							<div class="form-section">
								<div class="form-row">
									<div class="form-group">
										<c:choose>
											<c:when test="${edit == 'yes'}">
												<button class="button" type="submit" id="submit">Edit Form</button>
											</c:when>
											<c:otherwise>
												<button class="button" type="submit" id="submit">Submit</button>
												<span class="error-message" id="err_">Please correct all errors</span>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</form>
			</div>
		</div>
	</div>
<script type="text/javascript">
		var locationIncidentOccuredByStarIncidentLocation = {
				TM6 : [ "wetend", "dryend","rewinder", "wrapper", "docks" ],
				TM5 : [ "wetend", "dryend","rewinder", "wrapper", "docks" ],
				FRP : [ "Machine floor", "Machine basement", "warehouse", "receiving�docks", "office" ],
				Shipping : [ "warehouse","Loading Docks","office "],
				MaterialHandling : [ "Pulp Make Down", "Additives" ],
				Utilities : [ "Boiler", "Clarifier", "Air Systems" ],
				StockPrep : [ "Stock Prep" ],
				Shopsandstores : [ "Shops "," stores " ],
				Other : [ "PGW", "Wood Room/Wood Yard", "Scale House",
						"Super Calendars", "Winders" ]
				
			}
	    function changearea(value) {
	        if (value.length == 0) document.getElementById("locationIncidentOccured").innerHTML = "<option></option>";
	        else {
	            var locationIncidentOccuredOptions = "";
	            for (locationIncidentOccuredId in locationIncidentOccuredByStarIncidentLocation[value]) {
	            	locationIncidentOccuredOptions += "<option>" + locationIncidentOccuredByStarIncidentLocation[value][locationIncidentOccuredId] + "</option>";
	            }
	            document.getElementById("locationIncidentOccured").innerHTML = locationIncidentOccuredOptions;
	        }
	    }
</script>
</body>
</html>
