<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="TrangTinh.jsp" method="post">
  a=   <input name="txta" value="<%=request.getParameter("a")!=null?request.getParameter("a"):0 %>" type="number"> <br>
  b=   <input name="txtb" value="<%=request.getParameter("b")!=null?request.getParameter("b"):0 %>" type="number"> <br> 
  Ket qua: <%=request.getParameter("kq") %><br>
    <input name="butcong" value="+" type="submit">
    <input name="buttru" value="-" type="submit">
    <input name="butnhan" value="*" type="submit">
    <input name="butchia" value="/" type="submit">
    </form>
</body>
</html>