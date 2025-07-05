<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>
<spring:url value="/clrewinder/editWinderReport" var="saveURL" />
</head>
<style type="text/css">
.button{
 text-decoration:none; 
 text-align:center; 
 padding:11px 32px; 
 border:solid 1px #004F72; 
 -webkit-border-radius:4px;
 -moz-border-radius:4px; 
 border-radius: 4px; 
 font:18px Arial, Helvetica, sans-serif; 
 font-weight:bold; 
 color:#E5FFFF; 
 background-color:#3BA4C7; 
 background-image: -moz-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -webkit-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -o-linear-gradient(top, #3BA4C7 0%, #1982A5 100%); 
 background-image: -ms-linear-gradient(top, #3BA4C7 0% ,#1982A5 100%); 
 filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1982A5', endColorstr='#1982A5',GradientType=0 ); 
 background-image: linear-gradient(top, #3BA4C7 0% ,#1982A5 100%);   
 -webkit-box-shadow:0px 0px 2px #bababa, inset 0px 0px 1px #ffffff; 
 -moz-box-shadow: 0px 0px 2px #bababa,  inset 0px 0px 1px #ffffff;  
 box-shadow:0px 0px 2px #bababa, inset 0px 0px 1px #ffffff;  
  
  }
</style>

<body>

	<div class="container">

		<div class="block1">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>


		<div class="block3" style="overflow: auto;">
			<div class="pageContent">

				<div class="page-title">
					<span class="label">Edit Winder Break Report</span>
				</div>
				<div class="table-selector">
					
					<table>
						<tr>
							<td>Grade Code:</td>
							<td>
								
							
							</td>
							
						</tr>
					</table>

				</div>
<br><br>
<center>
<c:if test="${fn:length(moniterdatasforid)> 0 }">
<c:forEach items="${moniterdatasforid}" var="md">
<form action="${saveURL}" method="POST">
<table class="tg">
<tr><input type="hidden" name="id" value="${md.id}"></tr>
<tr><input type="hidden" name="Sdate" value="${sdate}"></tr>
<tr><input type="hidden" name="Edate" value="${edate}"></tr>	
<tr>
    <td class="tg-yw4l">Date:</td>
    <td class="tg-yw4l">
    	<fmt:formatDate value="${md.date}" var="dateS"  pattern="MM-dd-yyyy"/>
    	<input type="text" value="${dateS}" name="Date"/>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Shift:</td>
    <td class="tg-yw4l">
    	<select name="Shift" style="padding: 2px;" tabindex="2">
				<option value="">Select</option>
				<c:forEach items="${shifts}" var="ptype">
					<c:choose>
						<c:when test="${ptype.key eq md.shift}">
							<option value="${ptype.key}" selected="selected">${ptype.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${ptype.key}" >${ptype.value}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Crew:</td>
    <td class="tg-yw4l">
    	<select name="Crew" style="padding: 2px;" tabindex="2">
				<option value="">Select</option>
				<c:forEach items="${crews}" var="crew">
					<c:choose>
						<c:when test="${crew.key eq md.crew}">
							<option value="${crew.key}" selected="selected">${crew.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${crew.key}" >${crew.value}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Grade Code:</td>
    <td class="tg-yw4l">
	    <select name="gradeCode" style="width: 120px;padding: 1px;">
					<option value="-1">Select</option>
					<c:forEach items="${grades}" var="grade">
						<c:choose>
							<c:when test="${grade.gradeCode eq md.gradeCode}">
								<option value="${grade.gradeCode}" selected="selected">${grade.gradeCode}</option>
							</c:when>
							<c:otherwise>
								<option value="${grade.gradeCode}">${grade.gradeCode}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
		</select>
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Reel # :</td>
    <td class="tg-yw4l"><input  type="text" value="${md.reel}" name="Reel"/></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Set No:</td>
    <td class="tg-yw4l"><input  type="text" value="${md.setNo}" name="SetNo"/></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Breaks/Stops:</td>
    <td class="tg-yw4l"><input  type="text" value="${md.breakAt}" name="BreakAt"/></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  
  <tr>
    <td class="tg-yw4l">Break/Stop Time:</td>
    <td class="tg-yw4l">
    <fmt:formatDate value="${md.stoptime}" pattern="H" var="sH"/>
		
		<b>HH:</b><select name="Stophr">
			<option value="0">00</option>
			<c:forEach begin="1" end="24" var="h">
				<c:choose>
					<c:when test="${h eq  sH}">
						<option value="${h}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
					</c:when>
					<c:otherwise>
						<option value="${h}"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
    </td>
    <td class="tg-yw4l">
    <fmt:formatDate value="${md.stoptime}" pattern="m" var="sM"/>
		
		<b>MM:</b><select name="Stopmin">
			<option value="0">00</option>
			<c:forEach begin="1" end="59" var="m">
				<c:choose>
					<c:when test="${m eq sM}">
						<option value="${m}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
					</c:when>
					<c:otherwise>
						<option value="${m}"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
    </td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Start Time:</td>
    <td class="tg-yw4l">
    	<fmt:formatDate value="${md.starttime}" pattern="H" var="sH"/>
			<b>HH:</b><select name="Starthr">
				<option value="0">00</option>
				<c:forEach begin="1" end="24" var="h">
					<c:choose>
						<c:when test="${h eq  sH}">
							<option value="${h}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
						</c:when>
						<c:otherwise>
							<option value="${h}"><fmt:formatNumber minIntegerDigits="2" value="${h}" /></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			
    </td>
    <td class="tg-yw4l">
    <fmt:formatDate value="${md.starttime}" pattern="m" var="sM"/>
			
			<b>MM:</b><select name="Startmin">
				<option value="0">00</option>
				<c:forEach begin="1" end="59" var="m">
					<c:choose>
						<c:when test="${m eq sM}">
							<option value="${m}" selected="selected"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
						</c:when>
						<c:otherwise>
							<option value="${m}"><fmt:formatNumber minIntegerDigits="2" value="${m}" /> </option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
    </td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-yw4l">Downtime:</td>
    <td class="tg-yw4l"><input  type="text" value="${md.downtime}" name="Downtime"/></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  
  <tr>
    <td class="tg-yw4l">Reason For Break:</td>
    <td class="tg-yw4l">
    	<select name="Reasonforbreak">
					<option value="">Select</option>
					<c:forEach items="${moniterbreakreason}" var="mbrare">
						<c:choose>
							<c:when test="${mbrare.reasonforbreak eq md.reasonforbreak}">
								<option value="${mbrare.reasonforbreak}" selected="selected">${mbrare.reasonforbreak}</option>
							</c:when>
							<c:otherwise>
								<option value="${mbrare.reasonforbreak}">${mbrare.reasonforbreak}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>   
    </td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <!-- <td class="tg-yw4l">Loss Time:</td> -->
    <td class="tg-yw4l">Reason:</td>
    <td class="tg-yw4l"><input  type="text" value="${md.losstime}" name="Losstime"/></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <!-- <td class="tg-yw4l">Left Out In Spool:</td> -->
    <td class="tg-yw4l">Comments:</td>
    <td class="tg-yw4l"><input type="text" value="${md.leftoutinSpool}" name="LeftoutinSpool"/></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
   
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"><input class="button" type="Submit" value="Edit" name="Submit"/></td>
  </tr>
</table>
</form>
</c:forEach>
</c:if>
</center>

			</div>

		</div>


	</div>

</body>
</html>
