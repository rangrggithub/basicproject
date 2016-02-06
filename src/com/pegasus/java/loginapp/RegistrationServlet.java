package com.pegasus.java.loginapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
//@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fname = request.getParameter("firstname");
		  String lname=request.getParameter("lastname");
		  String sex = request.getParameter("sex");
		  String uname = request.getParameter("username");
		  String pass = request.getParameter("password");
		  String cpass = request.getParameter("password");
		  String squestion = request.getParameter("securityquestion");
		  String ans = request.getParameter("answer");
		  
		  insertdata(fname, lname, sex, uname, pass, cpass, squestion, ans);
		  
		  request.getRequestDispatcher("home.jsp").forward(request, response);
		 }
		 public void insertdata(String firstname, String lastname, String sex, String username, String password, String cpassword, String securityquestion, String answer){
		  
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  
		  try {
		   Class.forName("com.mysql.jdbc.Driver");
		   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pegasus_schema", "root", "");
		   
		   String sql="Insert into customerdetails values (?,?,?,?,?,?,?,?)";
		   pstmt = con.prepareStatement(sql);
		   
		   pstmt.setString(1, firstname);
		   pstmt.setString(2, lastname);
		   pstmt.setString(3, sex);
		   pstmt.setString(4, username);
		   pstmt.setString(5, password);
		   pstmt.setString(6, cpassword);
		   pstmt.setString(7, securityquestion);
		   pstmt.setString(8, answer);
		   
		   pstmt.executeUpdate();
		   System.out.println("Inserted successfully....");
		  } catch (ClassNotFoundException e) {
		   e.printStackTrace();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		 }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
