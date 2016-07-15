package util;

import java.sql.*;

import DaoImpl.CourseDaoImpl;

import java.io.*;

public class DBUtil {
	private static final long serialVersionUID = 1L;

	private static Connection conn;
	public static Connection getSqliteConnection(){
		String driver="org.sqlite.JDBC";
		String conStr="jdbc:sqlite://d:/mySRS.db";
		
		conn=null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;			
	}
	public static Connection getConn() {
		getSqliteConnection();
		
		return conn;
	}
	public static void setConn(Connection conn) {
		DBUtil.conn = conn;
	}
	public static void main(String[] args) {
		CourseDaoImpl courseDaoImpl=new CourseDaoImpl();
		
		try {
		System.out.println(getConn().getAutoCommit());
		try {
			System.out.println(courseDaoImpl.findAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
