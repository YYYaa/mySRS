package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sun.net.www.content.text.plain;
public class DataConnection {
	
	private static final String SqliteDBDRIVER = "org.sqlite.JDBC";
	private static final String MysqlDBDRIVER = "com.mysql.jdbc.Driver";
	private static final String SqliteDBURL = "jdbc:sqlite://d:/mySRS.db";
	private static final String MysqlDBURL = "jdbc:mysql://localhost:3306/mySRS?characterEncoding=UTF-8";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "123456";
	private static Connection conn;
	public static  Connection getConnection(String type) throws Exception {
	if (type.equals("sqlite")) {
		System.out.println("数据库是sqlite");
			Class.forName(SqliteDBDRIVER);
			conn = DriverManager.getConnection(SqliteDBURL);	
	}else if (type.equals("mysql")){
//		System.out.println("数据库是mysql");
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(MysqlDBURL, DBUSER, DBPASSWORD);	
	}else{
		conn=null;
	}
	return conn;
}

	
	
	
	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
	

	
	
	
	
	

