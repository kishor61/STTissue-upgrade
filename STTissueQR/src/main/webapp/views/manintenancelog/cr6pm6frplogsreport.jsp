<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>

<style>
    /* Base styles */
    body {
        display: flex;
        flex-direction: column;
        min-height: 100vh;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
    }

    .container {
        flex: 1;
        max-width: 95%;
        margin: 20px auto;
        padding: 20px;
        width: 100%;
        box-sizing: border-box;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .page-title {
        width: 100%;
        max-width: 1200px;
        background: #1a237e; /* Dark blue to match header */
        color: white;
        padding: 15px;
        border-radius: 5px;
        margin-bottom: 20px;
        text-align: center;
        font-size: 1.5em;
        box-shadow: 0 2px 4px rgba(0,0,0,0.2);
		margin-left: 200px;
    }

    .search-container {
        width: 100%;
        max-width: 1200px;
        background: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        margin-bottom: 20px;
        box-sizing: border-box;
        border: 1px solid #e0e0e0;
		position: relative;
		margin-left: 200px;
    }

    .search-form {
        display: flex;
        flex-wrap: wrap;
        gap: 15px;
        align-items: flex-start;
        justify-content: center;
        width: 100%;
    }

    .form-group {
        flex: 1;
        min-width: 200px;
        max-width: 300px;
    }

    .form-group label {
        color: #1a237e; /* Dark blue to match header */
        font-weight: 600;
        margin-bottom: 5px;
    }

    .form-group input[type="text"],
    .form-group select {
        border: 1px solid #bdbdbd;
        background-color: #f8f9fa;
    }

    .form-group input[type="text"]:focus,
    .form-group select:focus {
        border-color: #1a237e;
        box-shadow: 0 0 5px rgba(26, 35, 126, 0.3);
    }

    .button-group {
        display: flex;
        flex-wrap: wrap;
        gap: 10px;
        align-items: center;
        justify-content: center;
        margin-top: 10px;
        width: 100%;
    }

    .button-group button,
    .button-group input[type="submit"],
    .button-group input[type="button"] {
        background: #1a237e; /* Dark blue to match header */
        color: white;
        border: none;
        padding: 8px 16px;
        border-radius: 4px;
        cursor: pointer;
        font-weight: 600;
        transition: all 0.3s ease;
    }

    .button-group button:hover,
    .button-group input[type="submit"]:hover,
    .button-group input[type="button"]:hover {
        background: #0d47a1; /* Slightly lighter blue for hover */
        transform: translateY(-1px);
    }

    .fixed-container {
        width: 100%;
        max-width: 1200px;
        position: relative;
        overflow-x: auto;
        -webkit-overflow-scrolling: touch;
        margin: 20px 0;
        background: white;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        border: 1px solid #e0e0e0;
		margin-left: 200px;
    }

    .table-selector {
        background: #f8f9fa;
        padding: 20px;
        border-radius: 5px;
        margin-bottom: 20px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }

    .table-selector table {
        width: 100%;
        border-collapse: separate;
        border-spacing: 10px;
    }

    .table-selector td {
        padding: 8px;
    }

    .table-selector input[type="text"],
    .table-selector select {
        width: 100%;
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
    }

    .table-selector input[type="submit"],
    .table-selector input[type="button"],
    .table-selector button {
        background: #3498db;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
        transition: background 0.3s;
    }

    .table-selector input[type="submit"]:hover,
    .table-selector input[type="button"]:hover,
    .table-selector button:hover {
        background: #2980b9;
    }

    #yielddatatable {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background: white;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        table-layout: fixed;
    }

    #yielddatatable thead {
        background: #1a237e; /* Dark blue to match header */
        color: white;
        position: sticky;
        top: 0;
        z-index: 1;
    }

    #yielddatatable th,
    #yielddatatable td {
        padding: 12px;
        text-align: center;
        border-bottom: 1px solid #e0e0e0;
        vertical-align: middle;
    }

    #yielddatatable td:first-child {
        width: 60px;
    }

    #yielddatatable td:nth-child(2) {
        width: 100px;
    }

    #yielddatatable td:nth-child(3) {
        width: 100px;
    }

    #yielddatatable td:nth-child(4) {
        width: 100px;
    }

    #yielddatatable td:nth-child(5) {
        width: 200px;
    }

    #yielddatatable td:nth-child(6) {
        width: 100px;
    }

    #yielddatatable td:last-child {
        width: auto;
        min-width: 300px;
    }

    #yielddatatable textarea {
        width: 100%;
        min-height: 70px;
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
        resize: vertical;
        box-sizing: border-box;
    }

    #yielddatatable select {
        width: 100%;
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
        background-color: white;
        cursor: pointer;
        font-size: 14px;
        min-height: 36px;
    }

    #yielddatatable select:focus {
        border-color: #3498db;
        outline: none;
        box-shadow: 0 0 5px rgba(52, 152, 219, 0.5);
    }

    #yielddatatable select option {
        padding: 8px;
    }

    #yielddatatable tr[style*="display: none"] {
        background-color: #f8f9fa;
    }

    #yielddatatable tr[style*="display: none"] td {
        padding: 15px;
    }

    #yielddatatable tr[style*="display: none"] select,
    #yielddatatable tr[style*="display: none"] input,
    #yielddatatable tr[style*="display: none"] textarea {
        background-color: white;
        border: 1px solid #ddd;
    }

    .edit-mode {
        display: table-row !important;
        background-color: #f8f9fa;
    }

    .edit-mode td {
        padding: 15px;
    }

    .tmessage {
        position: fixed;
        top: 10px;
        right: 10px;
        padding: 10px 20px;
        background: #2ecc71;
        color: white;
        border-radius: 4px;
        display: none;
    }

    .redBorder {
        border: 2px solid #e74c3c !important;
    }

    .ui-autocomplete {
        max-height: 200px;
        overflow-y: auto;
        overflow-x: hidden;
    }

    .ui-autocomplete li {
        padding: 8px;
        cursor: pointer;
    }

    .ui-autocomplete li:hover {
        background: #f5f5f5;
    }

    .action-buttons {
        display: flex;
        gap: 10px;
        justify-content: center;
    }

    .action-buttons button {
        padding: 8px 16px;
        border-radius: 4px;
        border: none;
        cursor: pointer;
        transition: background 0.3s;
    }

    .action-buttons button:hover {
        opacity: 0.9;
    }

    .delete-btn {
        background: #c62828; /* Red for delete */
    }

    .delete-btn:hover {
        background: #b71c1c;
    }

    .edit-btn {
        background: #f57f17; /* Orange for edit */
    }

    .edit-btn:hover {
        background: #e65100;
    }

    .send-mail-btn {
        background: #4527a0; /* Purple for send mail */
    }

    .send-mail-btn:hover {
        background: #311b92;
    }

    .no-data-message {
        text-align: center;
        padding: 40px;
        background: white;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        margin: 20px auto;
        max-width: 600px;
        border: 1px solid #e0e0e0;
        color: #1a237e;
		    margin-left: 200px;
    }

    .no-data-message h3 {
        color: #2c3e50;
        margin-bottom: 15px;
    }

    .no-data-message p {
        color: #7f8c8d;
        font-size: 1.1em;
    }

    #yielddatatable {
        display: none;
    }

    #yielddatatable:not(:empty) {
        display: table;
    }

    .view-btn {
        background: #1a237e;
    }

    .view-btn:hover {
        background: #0d47a1;
    }

    .export-btn {
        background: #2e7d32; /* Green for export */
    }

    .export-btn:hover {
        background: #1b5e20;
    }

    /* Media Queries */
    @media (max-width: 1200px) {
        .container {
            padding: 15px;
        }

        .search-form {
            gap: 10px;
        }

        .form-group {
            min-width: 180px;
        }
    }

    @media (max-width: 992px) {
        .container {
            padding: 10px;
        }

        .search-form {
            flex-direction: column;
            align-items: center;
        }

        .form-group {
            max-width: 100%;
            width: 100%;
        }

        .button-group {
            width: 100%;
            justify-content: center;
        }

        .button-group button,
        .button-group input[type="submit"],
        .button-group input[type="button"] {
            flex: 1;
            text-align: center;
            min-width: 100px;
        }
    }

    @media (max-width: 768px) {
        .container {
            padding: 5px;
            margin: 10px auto;
        }

        .page-title {
            font-size: 1.2em;
            padding: 10px;
            margin-bottom: 10px;
            background: #1a237e;
        }

        .search-container {
            padding: 15px;
            background: white;
        }

        .button-group {
            flex-direction: column;
            width: 100%;
        }

        .button-group button,
        .button-group input[type="submit"],
        .button-group input[type="button"] {
            width: 100%;
            margin-bottom: 5px;
        }
    }

    @media (max-width: 576px) {
        .container {
            padding: 0;
            margin: 5px auto;
        }

        .page-title {
            font-size: 1.1em;
            padding: 8px;
        }

        .search-container {
            padding: 10px;
        }
    }

    @media print {
        .search-container,
        .button-group {
            display: none;
        }

        .fixed-container {
            position: static;
            overflow: visible;
            box-shadow: none;
        }

        #yielddatatable {
            width: 100%;
            border: 1px solid #000;
        }

        #yielddatatable th,
        #yielddatatable td {
            border: 1px solid #000;
            padding: 5px;
        }

        #yielddatatable th {
            background: #1a237e !important;
            color: white !important;
        }
    }

    @media (prefers-contrast: high) {
        .search-container {
            background: #fff;
            border: 2px solid #000;
        }

        .form-group input[type="text"],
        .form-group select {
            border: 2px solid #000;
        }

        #yielddatatable th {
            background: #000;
            color: #fff;
        }
    }

    /* Date Picker Styles */
    .ui-datepicker {
        background: white;
        border: 1px solid #e0e0e0;
        border-radius: 4px;
        padding: 10px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        width: auto;
    }

    .ui-datepicker-header {
        background: #1a237e;
        color: white;
        border: none;
        border-radius: 4px;
        padding: 5px;
        text-align: center;
    }

    .ui-datepicker-prev,
    .ui-datepicker-next {
        position: absolute;
        top: 5px;
        width: 30px;
        height: 30px;
        cursor: pointer;
        text-indent: -9999px;
        background: transparent;
        border: none;
        overflow: hidden;
    }

    .ui-datepicker-prev {
        left: 5px;
        background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 24 24' fill='none' stroke='white' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3E%3Cpath d='M15 18l-6-6 6-6'/%3E%3C/svg%3E");
        background-repeat: no-repeat;
        background-position: center;
        background-size: 16px;
    }

    .ui-datepicker-next {
        right: 5px;
        background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 24 24' fill='none' stroke='white' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3E%3Cpath d='M9 18l6-6-6-6'/%3E%3C/svg%3E");
        background-repeat: no-repeat;
        background-position: center;
        background-size: 16px;
    }

    .ui-datepicker-prev:hover,
    .ui-datepicker-next:hover {
        opacity: 0.8;
    }

    .ui-datepicker-prev span,
    .ui-datepicker-next span {
        display: none;
    }

    .ui-datepicker-prev:before,
    .ui-datepicker-next:before {
        display: none;
    }

    .ui-datepicker-title {
        margin: 0;
        line-height: 30px;
        font-size: 14px;
        font-weight: bold;
    }

    .ui-datepicker-calendar {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
    }

    .ui-datepicker-calendar th {
        padding: 5px;
        text-align: center;
        font-weight: bold;
        color: #1a237e;
    }

    .ui-datepicker-calendar td {
        padding: 5px;
        text-align: center;
    }

    .ui-datepicker-calendar a {
        display: block;
        padding: 5px;
        text-decoration: none;
        color: #333;
        border-radius: 3px;
    }

    .ui-datepicker-calendar a:hover {
        background: #1a237e;
        color: white;
    }

    .ui-datepicker-calendar .ui-state-active {
        background: #1a237e;
        color: white;
    }

    .ui-datepicker-calendar .ui-state-disabled {
        color: #ccc;
    }

    /* Ensure date picker appears above other elements */
    .ui-datepicker {
        z-index: 1000 !important;
    }

    /* Adjust input field styling */
    input[type="text"].hasDatepicker {
        background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="%231a237e" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect><line x1="16" y1="2" x2="16" y2="6"></line><line x1="8" y1="2" x2="8" y2="6"></line><line x1="3" y1="10" x2="21" y2="10"></line></svg>');
        background-repeat: no-repeat;
        background-position: right 10px center;
        padding-right: 35px;
    }
</style>
<script type="text/javascript">
$(function(){
	$('input[name=date],input[name=sdate],input[name=edate]').datepicker({
		dateFormat:'mm-dd-yy',
		changeMonth: true,
	    changeYear: true
	});
});
</script>
<spring:url value="/manintenancelog/delete" var="deletewinderDataURL" />
<spring:url value="/manintenancelog/save" var="saveURL" />
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
<script type="text/javascript">
$(function(){
	$('#EditRowButton').click(function() {
		var val = $('#yielddatatable tbody input[name=id]:checked').val();
		if (typeof val === "undefined") {
			alert('Please Select A Row To Edit The Record.');
			return;
		}
		if(val == "") {
			alert('Please Select A Row To Edit The Record.');
			return;
		}
		
		// Hide all edit rows first
		$('tr[id]').removeClass('edit-mode').hide();
		
		// Show selected row's edit form
		$('#' + val).addClass('edit-mode').show();
		
		// Initialize select2 for better select box styling
		$('#' + val + ' select').each(function() {
			$(this).select2({
				width: '100%',
				dropdownParent: $(this).parent()
			});
		});
	});

	// Initialize select2 for all select boxes
	$('select').select2({
		width: '100%',
		dropdownParent: $('body')
	});

	// Handle form submission
	$('form').on('submit', function() {
		// Clean up select2 before form submission
		$('select').select2('destroy');
	});
});
</script>
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
			if(target==='ADMIN' || target==='OPERATOR' || target==='OPERATOR4'|| target==='OPERATOR6' || target==='OPERATOR5'){
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
	
});
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
	if(target==='Admin' || target==='OPERATOR' || target==='OPERATOR4' || target==='OPERATOR6' || target==='OPERATOR5'){
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
	if(target1==='ADMIN' || target1==='OPERATOR' || target1==='OPERATOR4' || target==='OPERATOR6' || target==='OPERATOR5'){
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
	
	var change="change";
	var change1="change1";
	
	var time=tr.find('input[name=time]').val();
	if(typeof time==='undefined'){
		time='';
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
			shift : shift,
			change : change,
			time : time,
			change1 : change1
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
<spring:url value="/manintenancelog/reportpage/email" var="emailURL"/>
<script type="text/javascript">
	$(function(){
		
		
		$('#sendMailBtn').click(function(){
			var sdate=$('input[name=sdate]').val();
			var edate=$('input[name=edate]').val();
			var userType=$('input[name=userType]').val();
			var btn=$(this);
			
			if(confirm('Do you want to send Daily Shift Log - REPORT for :'+sdate)){
				btn=btn.prop('disabled',true);
				
				$('#tmessage').text('Sending mail.....Please wait.');
				$.ajax({
					url:'${emailURL}',
					type: 'POST',
					data : {
						sdate : sdate,
						edate : edate,
						userType : userType
					},
					success : function(data){
						if(data){
							$('#tmessage').text('Mail sent successfully.');
						}else{
							$('#tmessage').text('Failure to send email. Please contact to Roshan.');
						}
						btn=btn.prop('disabled',false);
						setTimeout(function(){
							$('#tmessage').text('');
						}, 5000);
					}
				});
			}
			
			
			
		});
	});
</script>
<script type="text/javascript">
$(function(){
    // Handle window resize
    $(window).on('resize', function() {
        adjustTableLayout();
    });

    function adjustTableLayout() {
        var windowWidth = $(window).width();
        if (windowWidth < 768) {
            $('.fixed-container').css({
                'position': 'relative',
                'top': 'auto',
                'bottom': 'auto',
                'left': 'auto',
                'right': 'auto'
            });
        } else {
            $('.fixed-container').css({
                'position': 'fixed',
                'top': '200px',
                'bottom': '0',
                'left': '0',
                'right': '0'
            });
        }
    }

    // Initial adjustment
    adjustTableLayout();
});
</script>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
	
		<div class="page-title">
			<span class="label">Daily Shift Log Report</span>
		</div>

		<div class="search-container">
			<spring:url value="/manintenancelog/reportpage/view" var="viewURL"/>
			<form name="dataForm" action="${viewURL}" method="get" class="search-form">
				<div class="form-group">
					<label for="sdate">Start Date</label>
					<input type="text" name="sdate" id="sdate" value="${sdate}" readonly="readonly">
				</div>

				<div class="form-group">
					<label for="edate">End Date</label>
					<input type="text" name="edate" id="edate" value="${edate}" readonly="readonly">
				</div>

				<div class="form-group">
					<label for="userType">User Type</label>
					<select name="userType" id="userType" required="required">
						<option value="">Select User Type</option>
						<c:if test="${userTypeEditTrue}">
							<c:if test="${userType eq 'ALL'}">
								<option value="ALL" selected="selected">ALL</option>
								<option value="OPERATOR6">CR5</option>
								<option value="OPERATOR">CR6</option>
								<option value="OPERATOR2">FRP</option>
								<option value="OPERATOR4">PM</option>
								<option value="OPERATOR5">CL</option>
							</c:if>
							<c:if test="${userType eq 'OPERATOR6'}">
								<option value="ALL">ALL</option>
								<option value="OPERATOR6" selected="selected">CR5</option>
								<option value="OPERATOR">CR6</option>
								<option value="OPERATOR2">FRP</option>
								<option value="OPERATOR4">PM</option>
								<option value="OPERATOR5">CL</option>
							</c:if>
							<c:if test="${userType eq 'OPERATOR'}">
								<option value="ALL">ALL</option>
								<option value="OPERATOR6">CR5</option>
								<option value="OPERATOR" selected="selected">CR6</option>
								<option value="OPERATOR2">FRP</option>
								<option value="OPERATOR4">PM</option>
								<option value="OPERATOR5">CL</option>
							</c:if>
							<c:if test="${userType eq 'OPERATOR2'}">
								<option value="ALL">ALL</option>
								<option value="OPERATOR6">CR5</option>
								<option value="OPERATOR">CR6</option>
								<option value="OPERATOR2" selected="selected">FRP</option>
								<option value="OPERATOR4">PM</option>
								<option value="OPERATOR5">CL</option>
							</c:if>
							<c:if test="${userType eq 'OPERATOR4'}">
								<option value="ALL">ALL</option>
								<option value="OPERATOR6">CR5</option>
								<option value="OPERATOR">CR6</option>
								<option value="OPERATOR2">FRP</option>
								<option value="OPERATOR4" selected="selected">PM</option>
								<option value="OPERATOR5">CL</option>
							</c:if>
							<c:if test="${userType eq 'OPERATOR5'}">
								<option value="ALL">ALL</option>
								<option value="OPERATOR6">CR5</option>
								<option value="OPERATOR">CR6</option>
								<option value="OPERATOR2">FRP</option>
								<option value="OPERATOR4">PM</option>
								<option value="OPERATOR5" selected="selected">CL</option>
							</c:if>
						</c:if>
						<c:if test="${userTypeEditFalse}">
							<c:if test="${userType eq 'OPERATOR6'}">
								<option value="${userType}" selected="selected">CR5</option>
							</c:if>
							<c:if test="${userType eq 'OPERATOR'}">
								<option value="${userType}" selected="selected">CR6</option>
							</c:if>
							<c:if test="${userType eq 'OPERATOR2'}">
								<option value="${userType}" selected="selected">FRP</option>
							</c:if>
							<c:if test="${userType eq 'OPERATOR4'}">
								<option value="ALL">ALL</option>
								<option value="${userType}" selected="selected">PM</option>
								<option value="${userType}">CR5</option>
								<option value="${userType}">CR6</option>
								<option value="${userType}">FRP</option>
								<option value="${userType}">CL</option>
							</c:if>
							<c:if test="${userType eq 'OPERATOR5'}">
								<option value="${userType}" selected="selected">CL</option>
							</c:if>
						</c:if>
					</select>
				</div>

				<div class="button-group">
					<input type="submit" value="View" class="view-btn">
					<c:if test="${export}">
						<input type="button" id="exportBtn" onclick="$('#exportFrom').submit();" value="Export" class="export-btn">
						<button id="deleterowbutton" class="delete-btn">Delete</button>
						<input type="button" id="EditRowButton" name="editrow" value="Edit" class="edit-btn">
						<input type="button" value="Send Mail" id="sendMailBtn" class="send-mail-btn">
					</c:if>
				</div>
			</form>
		</div>

		<form id="exportFrom" action='<spring:url value="/manintenancelog/reportpage/export"/>' method="GET" style="display:none;" target="_blank">
			<input type="hidden" name="userType" value="${userType}">
			<input type="hidden" name="sdate" value="${sdate}">
			<input type="hidden" name="edate" value="${edate}">
		</form>

		<div class="fixed-container">
			<c:choose>
				<c:when test="${not empty details}">
					<table id="yielddatatable" class="table">
						<thead>
							<tr>
								<th>Action</th>
								<th>Date</th>
								<th>User Type</th>
								<th>Shift</th>
								<security:authorize access="hasAnyRole('OPERATOR2')">
									<th>Production Type</th>
								</security:authorize>
								<security:authorize access="hasAnyRole('ADMIN,OPERATOR4,OPERATOR,OPERATOR6,OPERATOR5')">
									<th>Grade Code</th>
								</security:authorize>
								<th>Team</th>
								<th>Comments/Note</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${details}" var="data">
								<tr>
									<td><input type="radio" name="id" value="${data.id}"></td>
									<td>
										<fmt:formatDate value="${data.date}" var="dateS" pattern="MM-dd-yyyy"/>
										<b>${dateS}</b>
									</td>
									<td>
										<c:choose>
											<c:when test="${data.usertype eq 'ADMIN'}">ADMIN</c:when>
											<c:when test="${data.usertype eq 'OPERATOR'}">CR6</c:when>
											<c:when test="${data.usertype eq 'OPERATOR2'}">FRP</c:when>
											<c:when test="${data.usertype eq 'OPERATOR3'}">STI</c:when>
											<c:when test="${data.usertype eq 'OPERATOR4'}">PM</c:when>
											<c:when test="${data.usertype eq 'OPERATOR5'}">CL</c:when>
											<c:when test="${data.usertype eq 'OPERATOR6'}">CR5</c:when>
										</c:choose>
									</td>
									<td>${data.shift}</td>
									<td>${data.prodtypeorgradecode}</td>
									<td>${data.team}</td>
									<td>${data.comments}</td>
								</tr>
								<tr id="${data.id}" style="display: none;">
									<td>
										<input type="radio" name="id" value="${data.id}">
										<input type="hidden" value="change1" name="change1" id="change1">
									</td>
									<td>
										<fmt:formatDate value="${data.date}" var="dateS" pattern="MM-dd-yyyy"/>
										<input type="text" name="date" value="${dateS}" autocomplete="off" id="date">
										<input type="hidden" value="${data.time}" name="time">
									</td>
									<td>${data.usertype}</td>
									<td>
										<select name="shift" id="shift" required="required">
											<option value="">Select Shift</option>
											<c:forEach items="${shift}" var="shifts">
												<option value="${shifts.key}" ${shifts.key eq data.shift ? 'selected' : ''}>${shifts.value}</option>
											</c:forEach>
										</select>
									</td>
									<td>
										<security:authorize access="hasAnyRole('ADMIN,OPERATOR4,OPERATOR,OPERATOR6,OPERATOR5')">
											<input type="text" name="prodtypeorgradecode" value="${data.prodtypeorgradecode}">
										</security:authorize>
										<security:authorize access="hasAnyRole('OPERATOR2')">
											<select name="prodtypeorgradecode" id="prodtypeorgradecode" required="required">
												<option value="">Select Production Type</option>
												<c:forEach items="${prodtypeorgradecode}" var="grades">
													<option value="${grades.key}" ${grades.key eq data.prodtypeorgradecode ? 'selected' : ''}>${grades.value}</option>
												</c:forEach>
											</select>
										</security:authorize>
									</td>
									<td>
										<select name="team" id="team" required="required">
											<option value="">Select Team</option>
											<c:forEach items="${team}" var="teams">
												<option value="${teams.key}" ${teams.key eq data.team ? 'selected' : ''}>${teams.value}</option>
											</c:forEach>
										</select>
									</td>
									<td><textarea name="comments">${data.comments}</textarea></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<div class="no-data-message">
						<h3>No data found for the selected criteria</h3>
						<p>Please try adjusting your search parameters or select a different date range.</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

</body>
</html>
