<%@page import="bo.Sachbo"%>
<%@page import="bean.Sachbean"%>
<%@page import="java.util.ArrayList"%>
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
//Lay ve ma sac
	int fail=0;
	String ms=request.getParameter("ms");
	long sl=Long.parseLong(request.getParameter("txtsl"));
	if(ms!=null){
		Giohangbo gh=(Giohangbo)session.getAttribute("gh");
		if(request.getParameter("butxoa")!=null)
			gh.Xoa(ms);
		if(request.getParameter("butsua")!=null){
		for(Giohangbean g:gh.ds)
			if(g.getMasach().equals(ms))
			if(g.getSlmua()+sl<=0)
				break;
			else	{
				gh.Them(ms,"", "", (long)0,sl);
				break;
			}
		}
		session.setAttribute("gh", gh);
		response.sendRedirect("htgio.jsp");
		
//lay ve so luong
//gan sesion gh ra 1 bien
//Neu nguoi dung kich vao nut Xoa:
	  //gọi ham xoa
//Neu nguoi dung kich vao nut Sua
   //goi ham Them(masach,"","",0,sl lay ve)
//Luu bien vao lai session
//Mo lai trang htgio
	}
%>
</body>
</html>