<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="bg.jsp" %>
	<b>Xin chào</b><hr>
	<i>Hello world</i><br>
	 Lẫn lộn 1 trong 4 loại:<br>
  1. Văn bản thường -> gõ như thế nào hiển thị như thế đó printf("xin chao\n") <br>
  2. Thẻ HTML -> thi hành chức năng của thẻ <br>
  3. Đoạn javascript 
  <script type="text/javascript">alert('chay thanh cong');</script>
  4.Code java
  <%
     for(int i=1;i<=10;i++)
    	 out.print("5x"+ i+"="+i*5 +"<hr>");
  %>
</body>
</html>