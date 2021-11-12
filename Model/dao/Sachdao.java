package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import bean.Sachbean;

public class Sachdao {
	public ArrayList<Sachbean> getSach() throws Exception{
		ArrayList<Sachbean> ds =new ArrayList<Sachbean>();
		Connection cn;
//		ds.add(new Sachbean("s11", "Cấu trúc dữ liệu1", "Đỗ Ngọc", (long)120000, (long)1000,"image_sach/b21.jpg", "toan"));
//		ds.add(new Sachbean("s22", "Cơ sở dữ liệu2", "Đỗ Ngọc", (long)120000, (long)1000,"image_sach/b22.jpg", "cntt"));
//		ds.add(new Sachbean("s33", "lập trình Java3", "Quách Tuấn Ngọc", (long)120000, (long)1000,"image_sach/b24.jpg", "cntt"));
//		ds.add(new Sachbean("s4", "Đại chất công trình", "Đỗ Ngọc", (long)120000, (long)1000,"image_sach/b16.jpg", "luat"));
//		ds.add(new Sachbean("s5", "Bản đồ", "Đỗ Ngọc", (long)120000, (long)1000,"image_sach/b11.jpg", "va"));
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	System.out.println("Da xac dinh HQTCSDL");
    	//B2: Ket noi vao csdl
    	String url="jdbc:sqlserver://localhost:1433;databaseName=QlSach;user=sa; password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("use QlSach Select * From sach where anh is not null");
    	while(rs.next()) {
				ds.add(new Sachbean(rs.getString(1),rs.getString(2),rs.getString(9),rs.getLong(4),rs.getLong(3),rs.getString(7),rs.getString(5)));
			
    	}
    	cn.close();
		return ds;
	}	
	
}
