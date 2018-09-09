package com.cg.artistsmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection con=null;
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
	/*
	 *Method to get Connection Object
	*/
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ishita");
	//con=DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521:orcl","trg214","training214");
	return con;
	}
}
