package dao;


import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public Connection cn;
	public void KetNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	System.out.println("Da xac dinh HQTCSDL");
    	//B2: Ket noi vao csdl
    	String url="jdbc:sqlserver://ADMIN:1433;databaseName=QlSach;user=sa; password=123";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	}
}
