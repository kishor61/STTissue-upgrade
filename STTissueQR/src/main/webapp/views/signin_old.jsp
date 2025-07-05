<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="app.name" /> - Sign In</title>
<jsp:include page="common.jsp"></jsp:include>

</head>
<body>

<spring:url value="/home" var="homeURL"/>

<div class="container">

		<div class="block1">
			<jsp:include page="header.jsp"></jsp:include>
		</div>
		
		
		


		<div class="block3 ui-widget">
			<div class="pageContent">

<security:authorize access="isRememberMe()">
	<script type="text/javascript">
		$(function(){
			location.href='${homeURL}';
		});
	</script>
</security:authorize>

<security:authorize access="isAuthenticated()">
	<script type="text/javascript">
		$(function(){
			location.href='${homeURL}';
		});
	</script>
</security:authorize>

<security:authorize access="isAnonymous()">

				<div class="page-title">
					 <span class="label">Sign In</span>
				</div>

				<div style="padding: 2px;">

					<div>
						<br><br>
						<form action="j_spring_security_check" method="post">
							<table >
								<tr>
									<td><spring:message code="label.username" /></td>
									<td><input type="text" name="j_username" class="k-textbox"
										placeholder='<spring:message code="label.username.hint"/>'
										autofocus style="width: 150px;"></td>
								</tr>
								<tr>
									<td><spring:message code="label.password" /></td>
									<td><input type="password" name="j_password"
										placeholder='<spring:message code="label.password.hint"/>'
										style="width: 150px;"></td>
								</tr>
								<tr>
									<td>Remember me</td>
									<td><input type="checkbox" name="_spring_security_remember_me" checked="checked"/></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td align="left">
										<button type="submit">
											<spring:message code="label.signin" />
										</button>
									</td>
								</tr>

								<tr>
									<td colspan="2" align="center"><c:if test="${not empty param.error}">
											<p style="color: red;">
												<spring:message code="error.signin.fail" />
											</p>
										</c:if></td>

								</tr>

							</table>

							<br>


						</form>

					</div>
				</div>
</security:authorize>	
			</div>

		</div>


	</div>

</body>
</html>
