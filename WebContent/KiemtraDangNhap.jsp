<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String un=request.getParameter("txtun");
		String pw=request.getParameter("txtpw");
		if (un.equals("abc")&&pw.equals("123")){
			response.sendRedirect("menu.jsp?kt=1&&un="+un);
		}	else 
			response.sendRedirect("menu.jsp?kt=0");
	%>
</body>
</html>