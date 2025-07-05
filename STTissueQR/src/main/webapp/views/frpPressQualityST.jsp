<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="common.jsp"></jsp:include>

<style type="text/css">
.table input,.table select {
    width: inherit;
    text-align: center;
}
.table td{
    padding: 0 !important;
}
</style>

<spring:url value="/frppressquality/new" var="newTypeURL" />
<spring:url value="/frppressquality/savesstickies" var="saveURL" />
<spring:url value="/frppressquality/deleteStickiedata" var="deleteURL" />

<script type="text/javascript">
var currentVal='';
var saveLock;
var clearTimer;

$(function(){
    $('select[name=pType]').change(function(){
        var val=$(this).val();
        
        if(val!=''){
            location.href='${newTypeURL}/'+val;
        }else{
            location.href='${newTypeURL}';
        }
    });
    
    $('#addRowBtn').click(function(){
        var totalRows = $('#qualityDataTableST tbody tr').length;
        var existingSets = Math.floor(totalRows / 9);
        
        if (existingSets == 2) {
            $(this).prop('disabled', true);
            return;
        }

        // Special for Stickies Type
        var lastRowSet = $('#qualityDataTableST tbody tr:last').prevAll('tr').slice(0, 8).addBack();
        var currentDate = lastRowSet.find('input[name=date]').first().val();

        // Clone full 9 rows
        var separatorRow = $('<tr><td colspan="12" style="text-align: center; padding: 10px;"><span class="error">*</span> - Mandatory field.</td></tr>');
        separatorRow.appendTo($('#qualityDataTableST tbody'));

        lastRowSet.each(function() {
            var tr = $(this).clone();
            var ntr = tr.appendTo($('#qualityDataTableST tbody'));
            
            ntr.find('input').val('');
            ntr.find('select').val('');
            
            ntr.find('input[name=date]').val(currentDate); // copy date
            ntr.find('input[name=date]').datepicker({
                dateFormat: 'mm-dd-yy',
                changeMonth: true,
                changeYear: true,
                onClose: function(){
                    $(this).parent().next().children().focus();
                }
            });
        });
        
        // Bind events to the newly created rows
        $('#qualityDataTableST tbody tr:last').prevAll('tr').slice(0, 9).each(function() {
            $(this).find('input').unbind('focusin focusout');
            $(this).find('select').unbind('focusin focusout');
            $(this).find('input').on('focusin', doFocusInst).on('focusout', doFocusOutst);
            $(this).find('select').on('focusin', doFocusInst).on('focusout', doFocusOutst);
        });

        // Focus on the first time input of the new set
        $('#qualityDataTableST tbody tr:last').prevAll('tr').slice(0, 9).first().find('input[name=time]').focus();

        // Check if we've reached 2 sets after adding
        if (existingSets + 1 >= 2) {
            $(this).prop('disabled', true);
        }
    });

    $('#deleteRowBtn').click(function(){
        var rowCount = $('#qualityDataTableST tbody tr').length;
        if(rowCount==1){
            alert("You can't delete first row.");
            return;
        }
        
        var dbtn=$(this);
        var val=$('#qualityDataTableST tbody input[name=id]:checked').val();
        if(typeof val==='undefined'){
            alert('Select row');
        }else{
            if(val==''){
                $('#qualityDataTableST tbody input[name=id]:checked').parent().parent().remove();
            }else{
                dbtn.attr('disabled','disabled');
                $.ajax({
                    url:'${deleteURL}',
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

function doFocusInst(){
    currentVal=$(this).val();
}

function doFocusOutst(){
    saveData($(this));
}

function saveData(jq){
    $('#tmessage').text('');
    clearTimeout(clearTimer);
    
    var tr = jq.parent().parent();
    var id = tr.find('input[name=id]').val();
    var idEle = tr.find('input[name=id]');
    var date = tr.find('input[name=date]').val();
    
    // Get all data from both sets
    var data = {
        id: id,
        date: date,
        qualityType: 'ST'
    };
    
    // Get data from first set (A)
    data.psftimeA = $('input[name=psftimeA]').val();
    data.psfinitialsA = $('input[name=psfinitialsA]').val();
    data.psfcountA = $('input[name=psfcountA]').val();
    data.psftotalareaA = $('input[name=psftotalareaA]').val();
    data.psfavgareaA = $('input[name=psfavgareaA]').val();
    data.psfppmA = $('input[name=psfppmA]').val();
    data.psfcommentA = $('input[name=psfcommentA]').val();
    
    data.psatimeA = $('input[name=psatimeA]').val();
    data.psainitialsA = $('input[name=psainitialsA]').val();
    data.psacountA = $('input[name=psacountA]').val();
    data.psatotalareaA = $('input[name=psatotalareaA]').val();
    data.psaavgareaA = $('input[name=psaavgareaA]').val();
    data.psappmA = $('input[name=psappmA]').val();
    data.psacommentA = $('input[name=psacommentA]').val();
    
    data.ttimeA = $('input[name=ttimeA]').val();
    data.tinitialsA = $('input[name=tinitialsA]').val();
    data.tcountA = $('input[name=tcountA]').val();
    data.ttotalareaA = $('input[name=ttotalareaA]').val();
    data.tavgareaA = $('input[name=tavgareaA]').val();
    data.tppmA = $('input[name=tppmA]').val();
    data.tcommentA = $('input[name=tcommentA]').val();
    
    data.retimeA = $('input[name=retimeA]').val();
    data.reinitialsA = $('input[name=reinitialsA]').val();
    data.recountA = $('input[name=recountA]').val();
    data.retotalareaA = $('input[name=retotalareaA]').val();
    data.reavgareaA = $('input[name=reavgareaA]').val();
    data.reppmA = $('input[name=reppmA]').val();
    data.recommentA = $('input[name=recommentA]').val();
    
    data.patimeA = $('input[name=patimeA]').val();
    data.painitialsA = $('input[name=painitialsA]').val();
    data.pacountA = $('input[name=pacountA]').val();
    data.patotalareaA = $('input[name=patotalareaA]').val();
    data.paavgareaA = $('input[name=paavgareaA]').val();
    data.pappmA = $('input[name=pappmA]').val();
    data.pacommentA = $('input[name=pacommentA]').val();
    
    // Get data from second set (B)
    data.psftimeB = $('input[name=psftimeB]').val();
    data.psfinitialsB = $('input[name=psfinitialsB]').val();
    data.psfcountB = $('input[name=psfcountB]').val();
    data.psftotalareaB = $('input[name=psftotalareaB]').val();
    data.psfavgareaB = $('input[name=psfavgareaB]').val();
    data.psfppmB = $('input[name=psfppmB]').val();
    data.psfcommentB = $('input[name=psfcommentB]').val();
    
    data.psatimeB = $('input[name=psatimeB]').val();
    data.psainitialsB = $('input[name=psainitialsB]').val();
    data.psacountB = $('input[name=psacountB]').val();
    data.psatotalareaB = $('input[name=psatotalareaB]').val();
    data.psaavgareaB = $('input[name=psaavgareaB]').val();
    data.psappmB = $('input[name=psappmB]').val();
    data.psacommentB = $('input[name=psacommentB]').val();
    
    data.totimeB = $('input[name=totimeB]').val();
    data.toinitialsB = $('input[name=toinitialsB]').val();
    data.tocountB = $('input[name=tocountB]').val();
    data.tototalareaB = $('input[name=tototalareaB]').val();
    data.toavgareaB = $('input[name=toavgareaB]').val();
    data.toppmB = $('input[name=toppmB]').val();
    data.tocommentB = $('input[name=tocommentB]').val();
    
    data.retimeB = $('input[name=retimeB]').val();
    data.reinitialsB = $('input[name=reinitialsB]').val();
    data.recountB = $('input[name=recountB]').val();
    data.retotalareaB = $('input[name=retotalareaB]').val();
    data.reavgareaB = $('input[name=reavgareaB]').val();
    data.reppmB = $('input[name=reppmB]').val();
    data.recommentB = $('input[name=recommentB]').val();
    
    data.patimeB = $('input[name=patimeB]').val();
    data.painitialsB = $('input[name=painitialsB]').val();
    data.pacountB = $('input[name=pacountB]').val();
    data.patotalareaB = $('input[name=patotalareaB]').val();
    data.paavgareaB = $('input[name=paavgareaB]').val();
    data.pappmB = $('input[name=pappmB]').val();
    data.pacommentB = $('input[name=pacommentB]').val();
    
    // Calculate efficiencies
    if(parseInt(data.psfcountA) > 0 && parseInt(data.psacountA) >= 0) {
        data.efficiencyA = Math.round(((parseInt(data.psfcountA) - parseInt(data.psacountA)) / parseInt(data.psfcountA)) * 100);
    }
    
    if(parseInt(data.psfcountB) > 0 && parseInt(data.psacountB) >= 0) {
        data.efficiencyB = Math.round(((parseInt(data.psfcountB) - parseInt(data.psacountB)) / parseInt(data.psfcountB)) * 100);
    }
    
    if(saveLock){
        return;
    }
    
    saveLock = true;
    
    $.ajax({
        url: '${saveURL}',
        type: 'POST',
        data: data,
        dataType: 'json',
        success: function(response){
            if(response.status){
                idEle.val(response.id);
                $('#tmessage').text(response.message);
                clearTimer = setTimeout(function(){$('#tmessage').text('');}, 5000);
                location.reload();
            } else {
                alert("Error saving data: " + (response.error || 'Unknown error'));
            }
            saveLock = false;
        },
        error: function(xhr, status, error) {
            console.error('Server error details:', {
                status: status,
                error: error,
                response: xhr.responseText
            });
            alert('Server error while saving data. Please check console for details.');
            saveLock = false;
        }
    });
}
</script>

</head>
<body>
    <div class="container">
        <div class="block3" style="overflow: auto;">
            <div class="pageContent">
                <div class="page-title">
                    <span class="label">FRP Press Quality Data - Stickies</span>
                </div>
                <br>
                <div class="table-selector">
                    <table style="margin: auto;">
                        <tr>
                            <td> &nbsp;&nbsp; Press Quality Type</td>
                            <td>
                                <select name="pType" style="width: 200px;">
                                    <option value="">Select</option>
                                    <c:forEach items="${qtypes }" var="qtype">
                                        <c:choose>
                                            <c:when test="${qtype.key eq  type }">
                                                <option value="${qtype.key}" selected="selected">${qtype.value}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${qtype.key}">${qtype.value}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <c:if test="${not empty type}">
                                &nbsp;&nbsp;
                                <button id="addRowBtn">Add Row</button>
                                &nbsp;&nbsp;
                                <button id="deleteRowBtn">Delete</button>
                                </c:if>
                            </td>    
                        </tr>
                    </table>
                </div>

                <br>
                <c:if test="${not empty type}">
                    <table id="qualityDataTableST" class="table" style="width: 1000px; margin: auto;font-size: 12px;">
                        <thead>
                            <tr>
                                <th style="width: 20px;">&nbsp;</th>
                                <th>Date</th>
                                <th>Time<span class="error">*</span></th>
                                <th>Initials</th>
                                <th>Line</th>
                                <th>Location</th>
                                <th>Count</th>
                                <th>Total Area</th>
                                <th>Avg Area</th>
                                <th>PPM</th>
                                <th>Efficiency</th>
                                <th>Comments</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${fn:length(qualities) eq 0 }">
                                <tr>
                                    <td><input type="hidden" name="id" value=""></td>
                                    <td style="width: 80px;"><input readonly="readonly" type="text" name="date" value="${date}" autocomplete="off"> </td>
                                    <td style="width: 60px;"><input type="text" name="ttimeA" value="" autocomplete="off"> </td>
                                    <td style="width: 75px;"><input type="text" name="tinitialsA" value="" autocomplete="off"> </td>
                                    <td style="text-align: center;font-size:15px;">A</td>
                                    <td style="text-align: center;font-size:15px;">Pri Fine sceen feed</td>
                                    <td style="width: 75px;"><input type="text" name="psfcountA" value="" autocomplete="off">  </td>
                                    <td style="width: 75px;"><input type="text" name="psftotalareaA" value="" autocomplete="off">  </td>
                                    <td style="width: 75px;"><input type="text" name="psfavgareaA" value="" autocomplete="off">  </td>
                                    <td style="width: 75px;"><input type="text" name="psfppmA" value="" autocomplete="off">  </td>
                                    <td style="width: 75px;"><input type="text" name="" value="" autocomplete="off">  </td>
                                    <td style="width: 75px;"><input type="text" name="psfcommentA" value="" autocomplete="off">  </td>
                                </tr>
                                <!-- Add remaining rows for first set -->
                                <!-- ... (copy the remaining rows from the original file) ... -->
                            </c:if>
                            <c:if test="${fn:length(qualities)> 0 }">
                                <c:forEach items="${qualities}" var="quality">
                                    <!-- Add rows for existing data -->
                                    <!-- ... (copy the rows from the original file) ... -->
                                </c:forEach>
                            </c:if>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="12"><span class="error">*</span> - Mandatory field.</td>
                            </tr>
                        </tfoot>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html> 