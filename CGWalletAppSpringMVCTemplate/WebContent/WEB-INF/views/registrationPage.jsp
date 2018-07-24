<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>RegistrationPage</title>
<style>
.error{
	color:red;
	font-weight:bold;
}
</style>
</head>
<body>
<div align="center">
<h1>Registration Page</h1>
<h3>Enter your Details here:</h3>
<table>
<form:form action="registerCustomer" method="post" modelAttribute="customer">
	<tr>
		<td>Name:</td>
		<td><form:input path="name" size="30"/></td>
		<td><form:errors path="name" cssClass="error"/></td>
	</tr>
	<tr>
		<td>MobileNumber:</td>
		<td><form:input path="mobileNo" size="30"/></td>
		<td><form:errors path="mobileNo" cssClass="error"/></td>
	</tr>
	<tr>
		<td>Balance:</td>
		<td><form:input path="wallet.balance" size="30"/></td>
		<td><form:errors path="wallet.balance" cssClass="error"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Register"/></td>
	</tr>
</form:form>
</table>
<font color='red'>
	<c:if test="${not empty errorMessage }">
		${errorMessage }
	</c:if>
</font>
</div>
<hr>
<div align="center">
	<a href="/mypaymentapp">HomePage</a>
	</br>
	<hr>
	<button onclick="window.close()">Exit Application</button>
</div>
</body>
</html>