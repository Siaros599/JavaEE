<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="thu1ty.jsp" method="post">
		n=<input type="number" name="txtn"><br>
	    <input type="submit" value="Tinh" ><br>
    	</form><% 
    	//kiem tra xem da tao bien session chua
    	if(session.getAttribute("ss")==null)//chua tao bien session
    	    session.setAttribute("ss", (long)0);//tao bien session:ss
    	String tamn=request.getParameter("txtn");
     	 if(tamn!=null){
     		 //b1: gan sesion vao bien
     		 long s=(long) session.getAttribute("ss");
//b2 thay doi gia tri cua bien
    		  s=s +Long.parseLong(tamn);
     		 //b3: Luu bien vao session
     		 session.setAttribute("ss", s);
    	 }
     	 %>
    	Tong:<%=session.getAttribute("ss")  %>
</body>
</html>