package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Giohangbean;
import bean.Khachhangbean;
import bo.Giohangbo;

public class Giohangdao {
	public void addHD(Giohangbo gh,Khachhangbean kh) throws Exception {
		//lấy time mua hàng
		java.util.Date javaDate = new java.util.Date();
	    long javaTime = javaDate.getTime();
	  	gh.timebuy=new java.sql.Timestamp(javaTime);
	  	System.out.println(gh.timebuy);
	  	Connection cn;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	System.out.println("Da xac dinh HQTCSDL");
    	//B2: Ket noi vao csdl
    	String url="jdbc:sqlserver://localhost:1433;databaseName=QlSach;user=sa; password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	//lấy makh từ tendn
    	System.out.println("ten dang nhap la :"+kh.getMakh());
    	PreparedStatement st=cn.prepareStatement("select * from KhachHang where tendn=?");
    	st.setString(1, kh.getMakh());
    	ResultSet rs=st.executeQuery();
    	int makh;
    	if(rs.next()) { 
    		makh=rs.getInt(1);
    		System.out.println(makh);
    		st=cn.prepareStatement("insert into hoadon values(?,?,?,?)");
    		st.setInt(1, makh);
    		st.setTimestamp(2, gh.timebuy);
    		st.setBoolean(3, false);
    		st.setLong(4, gh.Tongtien());
    		st.executeUpdate();
    		st=cn.prepareStatement("select * from hoadon where NgayMua=?");
    		st.setTimestamp(1, gh.timebuy);
    		rs=st.executeQuery();
    		if(rs.next()) {
    			int mahd=rs.getInt(1);
    			System.out.println("Ma hoa don la: "+mahd);
    			for(Giohangbean i:gh.ds) {
    				st=cn.prepareStatement("insert into ChiTietHoaDon values(?,?,?,?)");
    				st.setString(1, i.getMasach());
    				st.setLong(2, i.getSlmua());
    				st.setInt(3, mahd);
    				st.setBoolean(4, false);
    				st.executeUpdate();
    			}
    		}
    	}
    	cn.close();
	}
}
