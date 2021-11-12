<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="MayTinh2.jsp" method="post">
  a= <input name="txta" value="<%=request.getParameter("txta")!=null?request.getParameter("txta"):0 %>" type="number"> <br>
  b= <input name="txtb" value="<%=request.getParameter("txtb")!=null?request.getParameter("txtb"):0 %>" type="number"> <br> 
<%
    String tama=request.getParameter("txta");
    String tamb=request.getParameter("txtb");
    if(tama!=null&&tamb!=null){
    	long a=Long.parseLong(tama);
    	long b=Long.parseLong(tamb);
    	if(request.getParameter("butcong")!=null){%>
    	 Ket qua:<%out.println(a+b);%><br>
    	<%}if(request.getParameter("buttru")!=null){%>
    	Ket qua:<%out.println(a-b);%><br>
    	<%}if(request.getParameter("butnhan")!=null){%>
        	Ket qua:<%out.print(a*b);%><br>
    	<%}if(request.getParameter("butchia")!=null){%>
        	Ket qua:<%out.print(a/b);%><br>
   <%
    	}
    }
   %>
   	 <input name="butcong" value="+" type="submit">
    <input name="buttru" value="-" type="submit">
    <input name="butnhan" value="*" type="submit">
    <input name="butchia" value="/" type="submit">
    </form>
</body>
</html>