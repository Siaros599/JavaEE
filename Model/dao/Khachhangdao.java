package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import bean.Khachhangbean;



public class Khachhangdao {
	public ArrayList<Khachhangbean> getKhachHang() throws Exception{
		ArrayList<Khachhangbean> ds= new ArrayList<Khachhangbean>();
		ds.add(new Khachhangbean("kh01","Nguyen Van A","72 Ngo Si Lien","nva123"));
		ds.add(new Khachhangbean("kh02","Tran Duc B","85 Nguyen Hue","tdb123"));
		ds.add(new Khachhangbean("kh03","La Van C","12 Cao Thang","lvc123"));
		ds.add(new Khachhangbean("kh04","Duong Thi D","50 Dang Dung","dtd123"));
		ds.add(new Khachhangbean("kh05","Nguyen Anh K","34 Mac Dinh Chi","nak123"));
		Connection cn;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	System.out.println("Da xac dinh HQTCSDL");
    	//B2: Ket noi vao csdl
    	String url="jdbc:sqlserver://localhost:1433;databaseName=QlSach;user=sa; password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("use QlSach Select * From KhachHang");
    	while(rs.next()) {
    		ds.add(new Khachhangbean(rs.getString(6),rs.getString(2),rs.getString(3),rs.getString(7)));
    	}
    	cn.close();
		return ds;
	}
	public Khachhangbean ktdn(String un, String pass) throws Exception {
		Connection cn;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	System.out.println("Da xac dinh HQTCSDL");
    	//B2: Ket noi vao csdl
    	String url="jdbc:sqlserver://localhost:1433;databaseName=QlSach;user=sa; password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("use QlSach Select * From KhachHang where tendn=? and pass=?");
    	st.setString(1, un);
    	st.setString(2, pass);
    	ResultSet rs;
    	rs=st.executeQuery();
    	if (rs.next()) {
    		System.out.println(rs.getString(6)+"  "+rs.getString(7));;
    		Khachhangbean kh = new Khachhangbean(rs.getString(6),rs.getString(2),rs.getString(3),rs.getString(7));
    		cn.close();
    		return kh;
    	} else {
    		cn.close();
    		return null;
		}
	}
	public void add(String name,String un,String pass,String repass, String email,String address,String phone) throws Exception{
		Connection cn;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	System.out.println("Da xac dinh HQTCSDL");
    	//B2: Ket noi vao csdl
    	String url="jdbc:sqlserver://localhost:1433;databaseName=QlSach;user=sa; password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("use QlSach Select * From KhachHang where tendn=?");
    	st.setString(1, un);
    	ResultSet rs;
    	rs=st.executeQuery();
    	if(!rs.next()&&pass.equals(repass)) {
    		PreparedStatement st1=cn.prepareStatement("insert into KhachHang values (?,?,?,?,?,?)");
    		st1.setString(1, name);
    		st1.setString(2, address);
    		st1.setString(3, phone);
    		st1.setString(4, email);
    		st1.setString(5, un);
    		st1.setString(6, pass);
    		st1.executeUpdate();
    	}
    	cn.close();
	}
}
