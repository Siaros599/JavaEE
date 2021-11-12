<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<style>
	.button {
  background-color: #09527d; //blue
  border-style:groove;
  border-radius: 8px;
  color: white;
  padding: 10px 150px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 18px;
}
	.label{
	font-size:14px;
	font-family: Palatino Linotype;
	color: black;
	text-alighn: left;
	}
	.head{
	color: #2BA5F4;
	text-align:left;
	font-family: Palatino Linotype;
	margin: 50px 0 30px 0;
	font-size:30px;
	}

	.input{
	padding: 12px 120px;
	background-color: #D0ECFE;
	border-radius: 8px;
	display:block;
	border-style:groove;
	border:none;
	}
	.frame{
	width: 400px;
	height:500px;
  	margin:auto;
  	background: white;
  	padding: 10px;
  	border-style: solid;
  	border-color: #2BA5F4;
	}
</style>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="frame">
		<p class="head">Sinh Viên</p><br>
    	<b><label class="label">Mã Sinh viên:</label><br></b>
    	<input type="text" class="input"><br>
    	<b><label class="label">Mật khẩu:</label><br></b>
    	<input type="text" class="input"><br>
    	<button class="button">Đăng Nhập</button>
	</div>
</body>
</html>