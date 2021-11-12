<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BangCuuChuong.jsp" method="post">
  Nhap so tao bang cuu chuong: <input name="num" value="<%=request.getParameter("num")!=null?request.getParameter("num"):0 %>" type="number"> <br>
  <input name="bcc" value="Hien Thi Bang Cuu Chuong" type="submit"><br>
<%
    String temp=request.getParameter("num");
	int count=1;
    if(temp!=null){
    	long n=Long.parseLong(temp);
    	if(request.getParameter("bcc")!=null)
    		for (count=1;count<=10;count++){
    	%>
    	<%out.print(String.format("%d * %d = %d",n,count,n*(long)count));%><br>
   <%
    		}
    }
   %>
    </form>
</body>
</html>