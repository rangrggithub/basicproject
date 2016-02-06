package com.pegasus.java.loginapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ForgetPasswordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String uname = request.getParameter("username");
		  String squestion = request.getParameter("securityquestion");
		  String answer = request.getParameter("answer");
		  
		  String pass = null;
		  Connection con = GettingConnection.getConnection();
		  String sql = "SELECT Password from customerdetails where UserName=" +"'"+uname+"'";
		  
		   try {
		    Statement pst = con.createStatement();
		    
		    ResultSet rs = pst.executeQuery(sql);
		   while(rs.next()){
		      pass = rs.getString("Password");
		   }
		   } catch (SQLException e) {
		    e.printStackTrace();
		   }
		  
		  PrintWriter out = response.getWriter();
		  
		  if(dataCheck(uname, squestion, answer)){
		   out.print("<html><h3>Your password is </h3></html>" + pass);
		  }else{
		   out.print("<html><h3>You entered a wrong answer for security question.</h3></html>");
		  }
		 }
		 public boolean dataCheck(String username, String securityQuestion, String answer){
		  boolean status = false;
		  Connection con = GettingConnection.getConnection();
		  
		  try {
		   String sql = "Select * from customerdetails where Username = ? && SecurityQuestion = ? && answer =?";
		   PreparedStatement ps = con.prepareStatement(sql);
		   
		   ps.setString(1, username);
		   ps.setString(2, securityQuestion);
		   ps.setString(3, answer);
		   
		   ResultSet rs = ps.executeQuery();
		  
		   status = rs.next();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  
		  return status;
		 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
