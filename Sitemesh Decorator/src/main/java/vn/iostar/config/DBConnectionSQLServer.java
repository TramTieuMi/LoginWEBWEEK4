package vn.iostar.config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import vn.iostar.models.UserModels;

public class DBConnectionSQLServer {
	private final String serverName = "DESKTOP-UR1R776\\SQLEXPRESS";
	private final String dbName = "LabWEBLogin";
	private final String portNumber = "60584";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "1234567";

	public Connection getConnection() throws Exception{
		//Connection conn = null;

	
			String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance
					+ ";integratedSecurity=true;databaseName=" + dbName;

			if (instance == null || instance.trim().isEmpty()) 
				url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";integratedSecurity=true;databaseName="
						+ dbName;
			

			return DriverManager.getConnection(url);
		
//			if (conn != null) {
//				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//				System.out.println("Driver name: " + dm.getDriverName());
//				System.out.println("Driver version: " + dm.getDriverVersion());
//				System.out.println("Product name: " + dm.getDatabaseProductName());
//				System.out.println("Product version: " + dm.getDatabaseProductVersion());
//			}
//
//			return conn;
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//		return null;
	}
	

	// Test chương trình. Kích phải chuột chọn run as->java application
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectionSQLServer().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
