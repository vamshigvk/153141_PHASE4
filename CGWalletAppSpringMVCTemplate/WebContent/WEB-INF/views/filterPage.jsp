<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filter Request</title>
</head>
<body>
<div align="center">
<h1>Filter Page</h1>
<h3>Press to get filter results</h3></hr>

<form action="filterSuccessPage" method="post">
Amount Below:<input name="amount"/>
<input type="submit" value="Filter "/>
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