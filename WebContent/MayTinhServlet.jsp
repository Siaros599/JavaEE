<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=session.getAttribute("alo") %>
<%
//String[] ds= (String[])request.getAttribute("dsht");
//for(String ht:ds)
	//out.print("<hr>"+ ht);
	long kq=0;
	if(request.getAttribute("kq")!=null){
		kq=(long)request.getAttribute("kq");
	}
%>
<form action="maytinhController" method="post">
  a=   <input name="txta" value="<%=request.getParameter("txta")!=null?request.getParameter("txta"):0 %>" type="number"> <br>
  b=   <input name="txtb" value="<%=request.getParameter("txtb")!=null?request.getParameter("txtb"):0 %>" type="number"> <br> 
  Ket qua: <%=kq %><br>
    <input name="butcong" value="+" type="submit">
    <input name="buttru" value="-" type="submit">
    <input name="butnhan" value="*" type="submit">
    <input name="butchia" value="/" type="submit">
    </form>
</body>
</html>