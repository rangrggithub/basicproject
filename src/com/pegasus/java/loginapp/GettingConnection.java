package com.pegasus.java.loginapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class GettingConnection {
	 public static Connection getConnection(){
		  Connection con = null;
		  try {
		   Class.forName("com.mysql.jdbc.Driver");
		   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pegasus_schema", "root", "");
		  } catch (ClassNotFoundException e) {
		   e.printStackTrace();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  return con;
		 }

}
