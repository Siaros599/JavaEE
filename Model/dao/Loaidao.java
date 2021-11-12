package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Loaibean;

public class Loaidao {
	public ArrayList<Loaibean> getloai() throws Exception {
		ArrayList<Loaibean> ds =new ArrayList<Loaibean>();
//		ds.add(new Loaibean("cntt","Cong nghe thong tin"));
//		ds.add(new Loaibean("toan", "Toán học"));
//		ds.add(new Loaibean("kt", "Kinh tế"));
//		ds.add(new Loaibean("luat", "Luật học"));
//		ds.add(new Loaibean("va", "Văn học"));
		Connection cn;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	System.out.println("Da xac dinh HQTCSDL");
    	//B2: Ket noi vao csdl
    	String url="jdbc:sqlserver://localhost:1433;databaseName=QlSach;user=sa; password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("use QlSach Select * From loai");
    	while(rs.next()) {
    		ds.add(new Loaibean(rs.getString(1),rs.getString(2)));
    	}
    	cn.close();
		return ds;
	}
}
