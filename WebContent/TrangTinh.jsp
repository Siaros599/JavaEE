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
     String tama=request.getParameter("txta");
    String tamb=request.getParameter("txtb");
    Long kq=(long)0;
    if(tama!=null&&tamb!=null){
    	long a=Long.parseLong(tama);
    	long b=Long.parseLong(tamb);
    	if(request.getParameter("butcong")!=null)
    	 kq=a+b;
    	if(request.getParameter("buttru")!=null)
    	kq=a-b;
    	if(request.getParameter("butnhan")!=null)
        	kq=a*b;
    	if(request.getParameter("butchia")!=null)
        	kq=a/b;
    	 response.sendRedirect("MayTinh.jsp?kq="+kq+"&a="+tama+"&b="+tamb);
    }
   %>
</body>
</html>