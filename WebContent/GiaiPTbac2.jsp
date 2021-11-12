<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="GiaiPTbac2.jsp" method="post">
	Nhap tham so cua phuong trinh: <br>
	a= <input name="txta" value="<%=request.getParameter("txta")!=null?request.getParameter("txta"):0 %>" type="number"> <br>
	b= <input name="txtb" value="<%=request.getParameter("txtb")!=null?request.getParameter("txtb"):0 %>" type="number"> <br>
	c= <input name="txtc" value="<%=request.getParameter("txtc")!=null?request.getParameter("txtc"):0 %>" type="number"> <br>
  <input name="gpt" value="Giai phuog trinh" type="submit"><br>
	<%
	long denta=0;
    String tempa=request.getParameter("txta");
	String tempb=request.getParameter("txtb");
	String tempc=request.getParameter("txtc");
	if(tempa!=null&&tempb!=null&&tempc!=null){
	long a=Long.parseLong(tempa);
	if (a!=0){
	long b=Long.parseLong(tempb);
	long c=Long.parseLong(tempc);
	denta=b*b-4*a*c;
	if (denta<0) {%>
	denta = <%out.print(String.format("%d^2-4*%d*%d<0",b,a,c));%> : Phuong trinh vo nghiem 
   	<%}if (denta==0) {%>
   	denta = <%out.print(String.format("%d^2-4*%d*%d=0",b,a,c));%> : Phuong trinh co nghiem kep x1 = x2 = <%out.print(String.format("(-b)/(2*a) = (%d)/(2*%d) = %2f",b,a,(float)(-b)/(2*a)));%>
   	<%}if (denta>0) {%>
   	denta = <%out.print(String.format("%d^2-4*%d*%d>0",b,a,c));%> : Phuong trinh co 2 nghiem phan biet: <br>
   	x1 = <%out.print(String.format("(-b+sqrt(denta))/(2*a) = (%d+sqrt(%d))/(2*%d) = %2f",-b,denta,a,(float)(-b+Math.sqrt(denta))/(2*a)));%><br>
   	x2 = <%out.print(String.format("(-b-sqrt(denta))/(2*a) = (%d-sqrt(%d))/(2*%d) = %2f",-b,denta,a,(float)(-b-Math.sqrt(denta))/(2*a)));%>
   	<%
   	}
   	}
	}
   	%>
    </form>
</body>
</html>