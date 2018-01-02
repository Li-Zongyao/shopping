package com.connect;

import java.sql.*;


public class ConnectMysql {
	public Connection con = null;
	public Statement sql = null;
	
	public synchronized void getCon(String url) {
		// TODO 自动生成的方法存根
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, "root", "");
			sql = con.createStatement();
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("connect mysql success");
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDriverName());

		}
		catch (Exception e) 
		{
			System.out.println("connect MySQL error");
			e.printStackTrace();	
		}
	}

	
	public synchronized void closeCon()
	{
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("close MySQL error");
			e.printStackTrace();
		}
	}
	
	public synchronized  boolean sqlexecute(String in)
	{
		try {if ((sql.executeUpdate(in)) > 0) return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	ResultSet result;
	public synchronized ResultSet select(String SQLSel)
	{
		try {
			result = sql.executeQuery(SQLSel);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
