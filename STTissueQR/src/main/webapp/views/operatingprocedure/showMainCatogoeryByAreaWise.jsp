<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /></title>
<jsp:include page="../common.jsp"></jsp:include>

<style type="text/css">
/* DivTable.com */
.divTable{
	display: table;
	width: 30%;
}
.divTableRow {
	display: table-row;
}
.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
}
.divTableCell, .divTableHead {
	border: 1px solid #999999;
	display: table-cell;
	padding: 3px 10px;
}
.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
	font-weight: bold;
}
.divTableFoot {
	background-color: #EEE;
	display: table-footer-group;
	font-weight: bold;
}
.divTableBody {
	display: table-row-group;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">

		<jsp:include page="../header.jsp"></jsp:include>
		
	<div class="content-wrapper" style=" padding-top: 0px !important; background-color: #d4d8e559 !important;">
		<div class="content-header" style="padding-top: 10px !important;padding-bottom: 0px !important;line-height: 0px !important;">
			<h5 style="text-align:center; font-weight:bold;color:#343e70;">PROCEDURES Main Category Area Wise</h5>
		</div>
		<div class="block3" style="overflow: auto;">
		 
			<div class="pageContent">
				<div class="table-selector" style="background-color:#2189b9 !important; border: 1px solid #7e00ff42;">
	<table>
						<tr>
							<td>Main Category</td>
							<td>
								
							
							</td>
							
						</tr>
					</table>

				</div>
<br><br><br>
<center>
					<div class="divTable" style="border: 1px solid #000;">
						<div class="divTableBody">
							<div class="divTableRow" >
								<div class="divTableCell" style="font-size:  21px;">Area: ${area}</div>
								<input type="hidden" value="${area}" name="area">
							</div>
							<div class="divTableRow" >
								<div class="divTableCell" style="font-size:  21px;">Select The Main Category</div>
							</div>
							<c:if test="${fn:length(maincategory) gt 0}">
							<%int i=1; %>
								<c:forEach items="${maincategory}" var="are">
									<div class="divTableRow">
										<div class="divTableCell" style="text-align:  left;">
											<b><%=i%>&nbsp;.&nbsp;
											<a href='<spring:url value="/operatingprocedure/showSubCatogoeryByAreaAndMainCatWise?maincat=${are.type}&&aera=${area}"/>'><span style="color: blue !important;">${are.type}</span></a>
											</b>
										</div>
									</div>
									<%i++;%>
								</c:forEach>
							</c:if>
							<c:if test="${fn:length(maincategory) eq 0}">
								<div class="divTableRow" style="background-color: #9496ce94;">
									<div class="divTableCell">
										<b>Sorry!! There Is No Main Category Under <b style="color: red;">${area}</b> Area</b>
									</div>
								</div>
							</c:if>
						</div>
					</div>
					<!-- DivTable.com -->
</center>
			</div>

		</div>


	</div>

</body>
</html>
