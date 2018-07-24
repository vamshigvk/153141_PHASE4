<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filter success page</title>
</head>
<body>

<c:if test="${not empty customer}">
    <c:forEach items="${customer}" var="customer">
       ${customer}</br></br>
</c:forEach>
</c:if>

<hr>
<div align="center">
	<a href="/mypaymentapp">HomePage</a>
	</br>
	<hr>
	<button onclick="window.close()">Exit Application</button>
</div>
</body>
</html>