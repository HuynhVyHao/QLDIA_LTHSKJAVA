package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection con = null;
	private static Connect instance = new Connect();	
	public static Connect getInstance() {
		return instance;
	}
	public void connect() throws SQLException {				
			String url = "jdbc:sqlserver://localhost:1433;databasename=QL_BanDia";
			String user = "sa";
			String password = "123456789";
			con = DriverManager.getConnection(url, user, password);		
	}	
	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {	e.printStackTrace();			}
	}
	
	public static Connection getConnection() {
		return con;
	}
}
