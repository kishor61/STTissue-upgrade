<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('input[name=sdate],input[name=edate]').datepicker({
		dateFormat : 'mm-dd-yy',
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true,
		beforeShow : function(input, inst) {
			$(inst.dpDiv).addClass('custom-datepicker');
			// Position the datepicker relative to the input
			var offset = $(input).offset();
			$(inst.dpDiv).css({
				'position': 'absolute',
				'top': offset.top + $(input).outerHeight(),
				'left': offset.left
			});
		}
	});

	$('#loadBtn').button({
		icons : {
			primary : "ui-icon-search"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-document"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-document"
		}
	});
});
</script>
<style>
    .form-container {
        margin: 20px auto;
        padding: 25px;
        background: #f8f9fa;
        border-radius: 5px;
        max-width: 800px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        min-height: 200px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        width: 95%;
    }
    .form-row {
        display: flex;
        align-items: center;
        margin-bottom: 20px;
        gap: 15px;
        justify-content: center;
        flex-wrap: wrap;
    }
    .form-label {
        min-width: 80px;
        font-weight: 500;
        text-align: right;
        color: #2c3e50;
    }
    .form-input {
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
        transition: border-color 0.3s ease;
        height: 35px;
        width: 150px;
    }
    .form-input:focus {
        border-color: #3498db;
        outline: none;
        box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
    }
    .button-group {
        display: flex;
        gap: 15px;
        margin: 20px 0;
        justify-content: center;
        flex-wrap: wrap;
    }
    .button-group button, .button-group a {
        padding: 10px 20px;
        border-radius: 4px;
        border: none;
        background: #3498db;
        cursor: pointer;
        text-decoration: none;
        color: white;
        font-weight: 500;
        transition: background-color 0.3s ease;
        font-size: 14px;
        white-space: nowrap;
    }
    .button-group button:hover, .button-group a:hover {
        background: #2980b9;
    }
    .pageContent {
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
        background: #f5f7fa;
        min-height: calc(100vh - 100px);
        width: 100%;
    }
    .page-title {
        margin-bottom: 30px;
        padding: 15px 0;
        border-bottom: none;
        text-align: center;
        width: 60%;
        background: linear-gradient(135deg, #3498db, #2c3e50);
        color: white;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    .page-title .label {
        font-size: 1.8em;
        font-weight: 600;
        color: white;
        text-shadow: 1px 1px 2px rgba(0,0,0,0.2);
    }
    .iframe-container {
        width: 100%;
        margin-top: 30px;
        background: white;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        padding: 15px;
        display: none; /* Initially hidden */
    }
    .loading-container {
        display: none;
        text-align: center;
        padding: 20px;
        margin-top: 20px;
    }
    .loading-spinner {
        border: 4px solid #f3f3f3;
        border-top: 4px solid #3498db;
        border-radius: 50%;
        width: 40px;
        height: 40px;
        animation: spin 1s linear infinite;
        margin: 0 auto;
    }
    @keyframes spin {
        0% { transform: rotate(0deg); }
        100% { transform: rotate(360deg); }
    }
    .loading-text {
        margin-top: 10px;
        color: #3498db;
        font-weight: 500;
    }
    #viewFrame {
        width: 100%;
        height: 500px;
        border: 1px solid #ddd;
        border-radius: 4px;
        background: white;
        display: block;
    }
    select.form-input {
        background-color: white;
        cursor: pointer;
        width: 200px;
    }
    .block3 {
        background: #f5f7fa;
        min-height: 100vh;
        padding: 20px;
        width: 100%;
        box-sizing: border-box;
    }

    /* Responsive Design */
    @media screen and (max-width: 768px) {
        .form-container {
            padding: 15px;
            margin: 10px auto;
        }
        .form-row {
            flex-direction: column;
            align-items: flex-start;
            gap: 10px;
        }
        .form-label {
            text-align: left;
            min-width: auto;
            width: 100%;
        }
        .form-input {
            width: 100%;
            max-width: 200px;
        }
        .date-input-container {
            width: 100%;
        }
        .button-group {
            width: 100%;
            justify-content: flex-start;
        }
        .button-group button, .button-group a {
            width: 100%;
            max-width: 200px;
            text-align: center;
        }
        #viewFrame {
            height: 400px;
        }
    }

    @media screen and (max-width: 480px) {
        .form-container {
            padding: 10px;
        }
        .page-title .label {
            font-size: 1.4em;
        }
        .form-input {
            max-width: 100%;
        }
        #viewFrame {
            height: 300px;
        }
    }

    /* Date Picker Responsive Styles */
    @media screen and (max-width: 768px) {
        .ui-datepicker {
            width: 100%;
            max-width: 300px;
        }
        .ui-datepicker-calendar th, 
        .ui-datepicker-calendar td {
            padding: 2px;
        }
    }

    /* Date Picker Positioning Fix */
    .ui-datepicker {
        position: absolute !important;
        z-index: 1000 !important;
        background: white;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        padding: 10px;
        margin-top: 5px;
    }
    .ui-datepicker-header {
        background: #3498db;
        color: white;
        border: none;
        border-radius: 4px;
        padding: 5px;
    }
    .ui-datepicker-title {
        font-weight: 500;
    }
    .ui-datepicker-calendar th {
        color: #2c3e50;
        font-weight: 500;
        padding: 5px;
    }
    .ui-datepicker-calendar td {
        padding: 3px;
    }
    .ui-datepicker-calendar td a {
        border-radius: 4px;
        padding: 5px;
        text-align: center;
        transition: all 0.3s ease;
    }
    .ui-datepicker-calendar td a:hover {
        background: #3498db;
        color: white;
    }
    .ui-datepicker-calendar .ui-state-active {
        background: #3498db;
        color: white;
        border: none;
    }
    .ui-datepicker-trigger {
        cursor: pointer;
        margin-left: 5px;
        color: #3498db;
    }
    .date-input-container {
        position: relative;
        display: inline-flex;
        align-items: center;
    }
    .date-input-container input[type="text"] {
        padding-right: 30px;
        background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="%233498db" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect><line x1="16" y1="2" x2="16" y2="6"></line><line x1="8" y1="2" x2="8" y2="6"></line><line x1="3" y1="10" x2="21" y2="10"></line></svg>');
        background-repeat: no-repeat;
        background-position: right 8px center;
    }
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>


		<div class="block3">
			<div class="pageContent">
				<div class="page-title">
					<span class="label">Certificate Of Analysis</span>
				</div>
				<div class="form-container">
					<div class="form-row">
						<span class="form-label">From:</span>
						<div class="date-input-container">
							<input type="text" name="sdate" value="${sdate}" class="form-input">
						</div>
						<span class="form-label">To:</span>
						<div class="date-input-container">
							<input type="text" name="edate" value="${edate}" class="form-input">
						</div>
					</div>
					<div class="form-row">
						<span class="form-label">Customer:</span>
						<select name="customer" class="form-input">
							<option value="">All</option>
							<c:forEach items="${customers}" var="customer">
								<option value="${customer}">${customer}</option>
							</c:forEach>
						</select>
						<div class="button-group">
							<button id="loadBtn">LOAD</button>
							<a href="javascript:void(0);" id="excelLink" target="_blank">EXCEL</a>
						</div>
					</div>
				</div>
				<div class="loading-container">
					<div class="loading-spinner"></div>
					<div class="loading-text">Loading data...</div>
				</div>
				<div class="iframe-container">
					<iframe id="viewFrame" src="about:blank"></iframe>
				</div>
			</div>
		</div>


	</div>
	<jsp:include page="../footer.jsp"></jsp:include>

<spring:url value="/certificateanalysis/loadNewpm5" var="loadURL"/>
<spring:url value="/certificateanalysis/excel/certificateNewpm5" var="excelURL" />
<spring:url value="/certificateanalysis/pdf/certificate/multi" var="pdfURL" />

<script type="text/javascript">
$(function(){
    $('select[name=customer]').change(function(){
        $('#viewFrame').attr('src','about:blank');
        $('#excelLink').attr('href','javascript:void(0)');
        $('.iframe-container').hide();
        $('.loading-container').hide();
    });
    
    $('#loadBtn').click(function(){
        var customer=$('select[name=customer]').val();
        var sdate=$('input[name=sdate]').val();
        var edate=$('input[name=edate]').val();
        
        if(!customer){
            alert('Select customer.')
        }else{
            // Show loading state
            $('.loading-container').show();
            $('.iframe-container').hide();
            
            // Load data
            $('#viewFrame').attr('src','${loadURL}?sdate='+encodeURIComponent(sdate)+
                    '&edate='+encodeURIComponent(edate)+
                    '&customer='+encodeURIComponent(customer));
            
            // Handle iframe load event
            $('#viewFrame').on('load', function() {
                $('.loading-container').hide();
                $('.iframe-container').show();
            });
        }
    });
    
    $('#excelLink').click(function(){
        var reels=$('#viewFrame')[0].contentWindow.getSelectedReel();
        var customer=$('select[name=customer]').val();
        var sdate=$('input[name=sdate]').val();
        var edate=$('input[name=edate]').val();
        
        if(!customer){
            alert('Select customer.');
            return false;
        }else if(!reels || reels.length==0){
            alert('Select reels.');
            return false;
        }else{
            var url='${excelURL}?reels='+encodeURIComponent(reels.toString())+'&customer='+encodeURIComponent(customer)+'&sdate='+encodeURIComponent(sdate)+
                '&edate='+encodeURIComponent(edate);
            $(this).attr('href',url);
        }
        
        return true;
    });
});
</script>
</body>
</html>
