<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Balance</title>
<style>
.error{
	color:red;
	font-weight:bold;
}
</style>
</head>
<body>
<div align="center">
<h1>Balance Page</h1>
<h3>Enter your Mobile number:</h3>
<form action="balanceSuccessPage" method="post" >
		<input name="mobileNo" size="30"/>
		<input type="submit" value="Request Balance"/>
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