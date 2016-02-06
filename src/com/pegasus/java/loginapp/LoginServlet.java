package com.pegasus.java.loginapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String user = request.getParameter("username");
		  String pass = request.getParameter("password");
		  
		  PrintWriter out = response.getWriter();
		  
		  if(checkingToDataBase(user, pass)){
		   request.getRequestDispatcher("home.jsp").forward(request, response);
		  }else{
		   out.print("<html><h4>You entered incorrect username and password.Please try again.<h4></html>");
		   request.getRequestDispatcher("Login.jsp").include(request, response);
		  }
		 }
		 
		 public boolean checkingToDataBase(String username, String password){
		  boolean status = false;
		  Connection con=null;
		  PreparedStatement pstmt = null;
		  
		  try {
		   Class.forName("com.mysql.jdbc.Driver");
		   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pegasus_schema", "root", "");
		   String sql = "select * from customerdetails where username=? && Password=?";
		   pstmt = con.prepareStatement(sql);
		   
		   pstmt.setString(1, username);
		   pstmt.setString(2, password);
		   
		   ResultSet rs = pstmt.executeQuery();
		   status = rs.next();
		   
		  } catch (ClassNotFoundException e) {
		   e.printStackTrace();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  return status;
		 }
		 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
