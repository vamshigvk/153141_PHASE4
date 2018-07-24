<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registrationSuccessPage</title>
</head>
<body>
<div align="center">
	<h2>Welcome ${customer.name} bro</h2></br>
	<h2>Your Registered MobileNumber is:- ${customer.mobileNo }</h2></br>
	<h2>Balance in your account is:- ${customer.wallet.balance}</h2></br>
	<a href="/mypaymentapp">HomePage</a>
</div>
</body>
</html>