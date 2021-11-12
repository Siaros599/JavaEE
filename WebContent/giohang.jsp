<%@page import="bean.Giohangbean"%>
<%@page import="bo.Giohangbo"%>
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
	String masach=request.getParameter("ms");
	String tensach=request.getParameter("ts");
	String tacgia=request.getParameter("tg");
	String giatam=request.getParameter("gia");
	if (masach!=null){
	//Tao cho 1 giohang khi dat mua quyen sach dau tien
	Giohangbo gh=null;
	if(session.getAttribute("gh")==null){
		gh=new Giohangbo();
		session.setAttribute("gh", gh);
	}
	//b1:gan session vao bien
	gh=(Giohangbo)session.getAttribute("gh");
	gh.Them(masach, tensach, tacgia, Long.parseLong(giatam), (long)1);
	session.setAttribute("gh", gh);
	response.sendRedirect("htgio.jsp");
	}
%>
gio hang

</body>
</html>