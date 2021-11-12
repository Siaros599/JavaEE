<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table align="center" width=1000px cellspacing="1" > 
	<tr>
	 <td colspan="3" bgcolor="blue" >
	 <img src="imgage.jpg" alt="ko tim thay anh" width="100px" heigt="30px">
	 </td>
	</tr>
	<tr> 
		<td width="200px" valign=top>
		<a href="dangnhap.jsp?ts=dn">Dang nhap</a><hr>
		<a href="thongbao.jsp?ts=tb">Thong Bao</a><hr>
		</td>
		<td width="600px">
		Học thẻ form và các thẻ con của nó <hr>
		<form action="KiemtraDangNhap.jsp" medthod="post">
			Username: <input type="text" name="txtun" value="abc"><br>
			Password: <input type="password" name="txtpw"><br>
			Giới Tính: <input type="radio" name="password"><br>
			Sở thích: <input type="checkbox" name="password"><br>
			Chọn file:<input type="file" name="Chọn tệp"><br><hr>
			
			HTML5<br>
			Nhập tuổi:<input type="number"><br>
			Email: <input type="email" placeholder="Nhap email"><br>
			Ngày Sinh:<input type="date" placeholder="dd/mm/yyyy"><br>
			<input type="submit" name="button" value="Đăng ký"><hr>
			Chọn quốc gia:
			<select name="cqg">
			<option>Lao</option>
			<option>VietNam</option>
			<option selected>Campuchia</option>
			</select>
			<br>
			Ghi chú:<br>
			<textarea rows="10" cols="50">gõ nội dung</textarea>
		</form>
		</td>
		<td width="200px">Quang Cao</td>
	</tr>
	<tr>
		<td colspan="3">Menu ngang</td>
	</tr>
	</table>
</body>
</html>
