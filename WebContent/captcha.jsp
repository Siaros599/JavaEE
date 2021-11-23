<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Captcha</title>
</head>
<body>
<div style="text-align:center">
		<h3>Vd CAPTCHA </h3>
	<img src="simpleCaptcha.jpg" />
	<form action="testCaptchaServlet" method="post">
	<input type="text" name="answer" /><br>
	<input type="submit" value="Submit"></form>
</div>
</body>
</html>