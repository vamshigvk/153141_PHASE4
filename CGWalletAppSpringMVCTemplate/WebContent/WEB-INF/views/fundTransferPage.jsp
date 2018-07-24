<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Fund Transfer Page</h1>
<form action="fundTransferSuccessPage" method="post" ></br>
	Enter your Mobile number:	<input name="sourceMobileNo" size="30"/></br>
		Enter destination Mobile number :	<input name="destinationMobileNo" size="30"/></br>
		Enter Amount to Transfer:<input name="wallet.balance" size="30"/></br>
		<input type="submit" value="withdraw"/>
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