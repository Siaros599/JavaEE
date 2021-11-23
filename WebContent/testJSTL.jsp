<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br> Dung code java <br>
  <%
     String tb=(String)request.getAttribute("tb");
      out.print(tb);
  %>
  <br> Dung thu vien the <br>
  <c:out value="${tb }"></c:out>
  <br>C2
  ${tb}<br>
<br> Dung code java <br>
  <%
     String[] dsht=(String[])session.getAttribute("dsht");
     for(String ht: dsht)
    	   out.print(ht+"<hr>");
  %>
   <br> Dung thu vien the <br>
<c:forEach items="${sessionScope.dsht }" var="ht"> 
        ${ht} <hr>
   </c:forEach>
  <br> Dung code java <br>
  <%
    //ArrayList<sachbean> dssach=(ArrayList<sachbean>)request.getAttribute("dssach");
   //  for(sachbean s: dssach)
    //	   out.print("<img src='"+s.getAnh()+"'> <br>" + s.getTensach()+"<hr>");
  %>
<br> Dung thu vien the <br>
   <c:forEach items="${dssach }" var="s"> 
       <img src='${s.getAnh()}'> <br>
       ${s.getTensach() } <hr>
   </c:forEach>
</body>
</html>