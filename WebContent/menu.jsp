<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="bo.Loaibo"
    import="bo.Sachbo"
    import="java.util.ArrayList"
    import="bean.Sachbean"
    import="bean.Loaibean"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
  <%
  	request.setCharacterEncoding("utf-8");
  	response.setCharacterEncoding("utf-8");
  	Loaibo loai=new Loaibo();
  	Sachbo sbo=new Sachbo();
  	ArrayList<Loaibean> dsloai=loai.getloai();
  	ArrayList<Sachbean> dssach=sbo.getSach();
  	String ml=request.getParameter("ml");
    String key=request.getParameter("key");
    if(ml!=null)
   	 dssach=sbo.timMaLoai(ml);
    else
   	 if(key!=null)
   		 dssach=sbo.Tim(key);
  %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Trang chủ</a></li>
      <li><a href="#">Giỏ hàng</a></li>
      <li><a href="#">Thanh toán</a></li>
      <li><a href="#">Lịch sử mua hàng</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#" data-toggle="modal" data-target="#myModal2"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
      <li>
      <%String kt=request.getParameter("kt");
      	if(kt!=null&&kt.equals("1")){
      %>
      <a href="#">Xin Chào: <%=request.getParameter("un") %></a>
      <%} else { %>
      <a href="#" data-toggle="modal" data-target="#myModal">
      <span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
      <%if(kt!=null&&kt.equals("0")){ %>
      	<script>alert("E! Dang nhap sai")</script>
      	<%}
      	}
     %>
    </ul>
  </div>
</nav>
<div class="container">


  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <form action="KiemtraDangNhap.jsp" method=post>
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Đăng nhập</h4>
        </div>
        <div class="modal-body">
        <b><label >Username:</label><br></b>
    	<input type="text" name="txtun"><br>
    	<b><label>Pasword:</label><br></b>
    	<input type="password" name="txtpw"><br>
        </div>
        <div class="modal-footer">
        	<input type="submit" name="button" value="Dang Nhap"><hr>
        </div>
      </div>
      </form>
    </div>
  </div>
  
</div>
    <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Đăng ký</h4>
        </div>
        <div class="modal-body">
    	<table>
    		<tr>
    			<td >
    			<input type="Text" placeholder="Nhập username"><br>
    			<input type="Password" placeholder="Nhập Mật khẩu"><br>
    			<input type="Password" placeholder="Nhập lại mật khẩu"><br>
    			<input type="Text" placeholder="Nhập địa chỉ email"><br>
    			<input type="Text" placeholder="Nhập lại địa chỉ email"><br>
    			</td>
    			<td>
    			<input type="Text" placeholder="Nhập Họ và tên"><br>
    			<select><option selected>Giới tính</option></select><br>
    			<select><option selected>Ngày Sinh</option></select>
    			<select><option selected>Tháng</option></select>
    			<select><option selected>Năm</option></select><br>
    			<select><option selected>Tỉnh/TP</option></select><br>
    			<input type="Text" placeholder="Nhập Mã xác nhận">
    			</td>
    		</tr>
    	</table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Đăng ký</button>
        </div>
      </div>
      
    </div>
  </div>
 

  <table width="1000" align="center">
     
     <tr>
		<td width="200" valign="top">
             <table class="table table-hover">
                <%for(Loaibean L:dsloai){ %>
                    <tr>
                        <td><a href="menu.jsp?ml=<%=L.getMaloai()%>"><%=L.getTenloai() %></a> </td>
                    </tr>
                    <%} %>
             </table>
         </td>
 		<td width="600" valign="top">
          <table class="table table-hover">
          
          <%
          		int n=dssach.size();
          		for (int i=0;i<n;i++){
        	  		Sachbean s=dssach.get(i);%>
        	  <tr>
        	  	<td>
        	  		<img src="image_sach/<%=s.getAnh() %>"><br>
        	  		<a href="giohang.jsp"><img src="buynow.jpg"></a><br>
        	  		<%=s.getTensach() %><br>
        	  		<%=s.getTacgia() %><br>
        	  		<%=s.getGia() %><br>
        	  		
        	  	</td>
        	  		<%i++;
            	    if(i<n){
            	    	s=dssach.get(i);
            	    %>
            	    <td>
            	        <img src="image_sach/<%=s.getAnh() %>"><br>
            	        <a href="giohang.jsp"> <img src="mua.jpg"> </a> <br>
            	        <%=s.getTensach() %> <br>
            	        <%=s.getTacgia() %> <br>
            	       <b><%=s.getGia() %> </b>  
            	    </td>
            	    <%} %>
        	  </tr>
          <%} %>
          </table>
         </td>
         <td width="200" valign="top">
             Tim kiem 
          	<form action="menu.jsp" method="post">
             	 <input type="text" name="key">
             	 <input type="submit" name="sendkey" value="Tim Kiem">
    		</form>
            
         </td>
     </tr>
     
  </table>

</body>
</html>