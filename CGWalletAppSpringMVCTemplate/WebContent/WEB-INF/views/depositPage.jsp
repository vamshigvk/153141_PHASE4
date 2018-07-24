<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit</title>
</head>
<body>
<div align="center">
<h1>Deposit Page</h1>
<form action="depositSuccessPage" method="post" >
	Enter your Mobile number:	<input name="mobileNo" size="30"/></br>
		Enter Amount to deposit : <input name="wallet.balance" size="30"/></br>
		<input type="submit" value="deposit"/>
</form>
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