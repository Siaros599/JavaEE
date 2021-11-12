<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="bo.Khachhangbo"
    import="bean.Khachhangbean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String un=request.getParameter("txtun");
		String pass=request.getParameter("txtpw");
		Khachhangbo khbo=new Khachhangbo();
		Khachhangbean kh= khbo.ktdn(un, pass);
	     if(kh!=null){
	    	 session.setAttribute("kh", kh);
	    	 response.sendRedirect("menu2.jsp");
	     }else{
	    	 session.setAttribute("tb", "Dang nhap sai");
	    	 response.sendRedirect("menu2.jsp");
	     }
	%>
</body>
</html>