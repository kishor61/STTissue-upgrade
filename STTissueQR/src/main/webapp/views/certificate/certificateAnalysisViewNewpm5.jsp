<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<style>
.table-container {
    margin: 20px auto;
    width: 90%;
    max-width: 1200px;
    background: white;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
}

.table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
}

.table th, .table td {
    padding: 12px;
    text-align: center;
    border: 1px solid #ddd;
}

.table th {
    background-color: #f5f5f5;
    font-weight: bold;
}

.table tr:hover {
    background-color: #f9f9f9;
}

.back-button {
    margin: 20px;
    padding: 8px 16px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.back-button:hover {
    background-color: #45a049;
}

.no-data {
    text-align: center;
    padding: 20px;
    color: #666;
    font-style: italic;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>


        <div class="block3" style="overflow: auto;">
            <div class="pageContent">
                <div class="page-title">
                    <span class="label">Certificate Analysis View</span>
                </div>
                
                <button class="back-button" onclick="history.back();">Back</button>
                
                <div class="table-container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th style="width: 5%;"><input type="checkbox" id="checkFlag"></th>
                                <th style="width: 20%;">Reel#</th>
                                <th style="width: 25%;">Grade Code</th>
                                <th style="width: 50%;">Customer</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${fn:length(rewdinders) gt 0 }">
                                <c:forEach items="${rewdinders}" var="rw">
                                    <tr>
                                        <td><input type="checkbox" name="reel" value="${rw.reel}"></td>
                                        <td>${rw.reel}</td>
                                        <td>${rw.grade}</td>
                                        <td>${rw.customer}</td>
                                    </tr>    
                                </c:forEach>
                            </c:if>
                            
                            <c:if test="${fn:length(rewdinders) eq 0 }">
                                <tr>
                                    <td colspan="4" class="no-data">Data not available for this selection.</td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
    $(function(){
        $('#checkFlag').click(function(){
            $('table input[name=reel]').prop('checked',$(this).prop('checked'));
        });
    });

    function getSelectedReel(){
        var reels = $("input[name=reel]:checkbox:checked").map(function(){
            return $(this).val();
        }).get();
        
        return reels;
    }
    </script>
</body>
</html>
