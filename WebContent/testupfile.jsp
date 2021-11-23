<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="testupfile" enctype= "multipart/form-data">
  Ho Ten: <input type="text" name="txthoten" value=""> <br>
  Đia chi: <input type="text" name="txtdiachi" value=""> <br>
  file: <input type="file" name="txtfile" title="chọn file"><br>
  <button type="submit" name="sbutton">Chon file</button> 
  <button type="submit" name="s1button">Chon file 2</button> 
  </form>
</body>
</html>