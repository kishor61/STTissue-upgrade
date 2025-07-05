<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /> - Rewinder Report PM5</title>
<jsp:include page="../common.jsp"></jsp:include>
<style>
.report-header {
    background: linear-gradient(135deg, #007bff, #0056b3);
    color: white;
    padding: 20px;
    text-align: center;
    border-radius: 8px;
    margin: 20px auto;
    max-width: 500px;
    box-shadow: 0 4px 6px rgba(0,0,0,0.1);
}

.report-title {
    font-size: 24px;
    font-weight: 600;
    margin: 0;
    text-transform: uppercase;
    letter-spacing: 1px;
}

.filter-container {
    background: #f8f9fa;
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    margin: 20px auto;
    max-width: 500px;
}

.filter-label {
    font-weight: 600;
    color: #333;
    width: 120px;
    display: inline-block;
}

.filter-input {
    padding: 8px 12px;
    border: 1px solid #ddd;
    border-radius: 4px;
    width: 200px;
    margin-bottom: 10px;
    transition: border-color 0.3s;
}

.filter-input:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 0 2px rgba(0,123,255,0.25);
}

.filter-select {
    padding: 8px 12px;
    border: 1px solid #ddd;
    border-radius: 4px;
    width: 200px;
    margin-bottom: 10px;
    background-color: white;
}

.filter-button {
    background-color: #007bff;
    color: white;
    border: none;
    padding: 8px 20px;
    border-radius: 4px;
    cursor: pointer;
    margin: 5px;
    transition: background-color 0.3s;
}

.filter-button:hover {
    background-color: #0056b3;
}

.filter-button:disabled {
    background-color: #6c757d;
    cursor: not-allowed;
}

.fixed-message {
    position: fixed;
    top: 10px;
    right: 10px;
    z-index: 1000;
}

.tmessage {
    padding: 10px;
    background-color: #f8f9fa;
    border: 1px solid #ddd;
    border-radius: 4px;
    display: none;
}
</style>
<script type="text/javascript">
$(function() {
    $( "input[name=fromDate]" ).datepicker({
      dateFormat:'mm-dd-yy',
      changeMonth: true,
      changeYear: true
    });
    $( "input[name=toDate]" ).datepicker({
       dateFormat:'mm-dd-yy',
       changeMonth: true,
       changeYear: true
    });
});
</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
        <jsp:include page="../header.jsp"></jsp:include>
        
        <div class="block3">
            <div class="pageContent">
                <div class="report-header">
                    <h1 class="report-title">Quality Report - Rewinder Testing PM5</h1>
                </div>
                
                <fmt:formatDate value="<%=new Date()%>" pattern="MM-dd-yyyy" var="dateFrom"/>
                <fmt:formatDate value="<%=new Date()%>" pattern="MM-dd-yyyy" var="dateTo"/>
                
                <div class="filter-container">
                    <form id="rewindReportForm" action="#">
                        <table class="table" style="width: 100%; margin: auto;">
                            <tbody>
                                <tr>
                                    <td class="filter-label">From date:</td>
                                    <td><input readonly="readonly" name="fromDate" type="text" class="filter-input" value="${dateFrom}"></td>
                                </tr>
                                <tr>
                                    <td class="filter-label">To date:</td>
                                    <td><input readonly="readonly" name="toDate" type="text" class="filter-input" value="${dateTo}"></td>
                                </tr>
                                <tr>
                                    <td class="filter-label">Grade Code:</td>
                                    <td>
                                        <select class="filter-select" name="grade">
                                            <option value="">All</option>
                                            <c:forEach items="${grades}" var="grade">
                                                <option value="${grade.gradeCode}">${grade.gradeCode}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="filter-label">Customer:</td>
                                    <td>
                                        <select class="filter-select" name="customer">
                                            <option value="">All</option>
                                            <c:forEach items="${customers}" var="customer">
                                                <option value="${customer}">${customer}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="filter-label">Reel No:</td>
                                    <td><input type="text" name="reel" class="filter-input"></td>
                                </tr>
                                <tr>
                                    <td class="filter-label">Grade Type:</td>
                                    <td>
                                        <select class="filter-select" name="type">
                                            <option value="">All</option>
                                            <option value="1">Napkin</option>
                                            <option value="2">Bath Tissue</option>
                                            <option value="3">Towel</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="text-align: center;">
                                        <button id="viewBtn" class="filter-button">View</button>
                                        <button id="exportBtn" class="filter-button">Excel</button>
                                        <button id="exportPdfBtn" class="filter-button">PDF</button>
                                        <security:authorize access="hasAnyRole('ADMIN,OPERATOR')">
                                            <button id="editBtn" class="filter-button">Edit</button>
                                        </security:authorize>
                                        <button id="sendMailBtn" class="filter-button">Send Mail</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>

<spring:url value="/pm5rewindreport/view" var="viewReportDateWise"/>	
<spring:url value="/pm5rewindreport/export" var="exportReportDateWise"/>	
<spring:url value="/pm5rewindreport/update" var="updateReportDateWise"/>	
<spring:url value="/pm5reelreport/email" var="emailURL"/>
<spring:url value="/pm5rewindreport/view/report" var="rewindReportView"/>
<spring:url value="/pm5rewindreport/view/update" var="rewindReportEdit"/>
<spring:url value="/pm5rewindreport/view/export" var="rewindReportExport"/>
<spring:url value="/pm5rewindreport/view/exportpdf" var="rewindReportExportPdf"/>

<script type="text/javascript">
$(function(){
    $('#viewBtn').click(function(){
        $('#rewindReportForm').attr('action','${rewindReportView}');
        $('#rewindReportForm').attr('target','_blank');
        $('#rewindReportForm').submit();
        return false;
    });
    
    $('#editBtn').click(function(){
        $('#rewindReportForm').attr('action','${rewindReportEdit}');
        $('#rewindReportForm').attr('target','');
        $('#rewindReportForm').submit();
        return false;
    });
    
    $('#exportBtn').click(function(){
        $('#rewindReportForm').attr('action','${rewindReportExport}');
        $('#rewindReportForm').attr('target','_blank');
        $('#rewindReportForm').submit();
        return false;
    });
    
    $('#exportPdfBtn').click(function(){
        $('#rewindReportForm').attr('action','${rewindReportExportPdf}');
        $('#rewindReportForm').attr('target','_blank');
        $('#rewindReportForm').submit();
        return false;
    });
    
    $('#sendMailBtn').click(function(){
        var date=$('input[name=fromDate]').val();
        var btn=$(this);
        if(confirm('Do You Want To Send Quality Report Of PM5 For:: '+date)){
            btn.prop('disabled',true);
            
            $('#tmessage').text('Sending mail.....Please wait.').show();
            $.ajax({
                url:'${emailURL}',
                type: 'GET',
                data : {
                    date : date
                },
                success : function(data){
                    if(data){
                        $('#tmessage').text('Mail sent successfully.');
                    }else{
                        $('#tmessage').text('Failure to send email. Please contact to administrator.');
                    }
                    btn.prop('disabled',false);
                    setTimeout(function(){
                        $('#tmessage').fadeOut();
                    }, 5000);
                }
            });
        }
    });
});
</script>

</body>
</html>
