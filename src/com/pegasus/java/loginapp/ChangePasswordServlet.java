package com.pegasus.java.loginapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ChangePasswordServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String epass = request.getParameter("epassword");
		  String npass=request.getParameter("password");
		  String cpass= request.getParameter("password");
		  
		  PrintWriter out = response.getWriter();
		  if(databaseChecking(epass)){
		   Connection con = GettingConnection.getConnection();
		   try {
		    String sql = "UPDATE customerdetails SET Password="+ "'" + npass+"'" + "," + "ConfirmPassword=" + "'" + cpass + "'"+ " WHERE Password=" + "'" + epass + "'";
		    PreparedStatement pstmt = con.prepareStatement(sql);
		    pstmt.executeUpdate();
		    out.print("<html><h3>Your password is successfully changed.</h3></html>");
		   } catch (SQLException e) {
		    e.printStackTrace();
		   }
		  }else{
		  }
		 }
		 public boolean databaseChecking(String password) {
		  boolean status = false;
		  Connection con = GettingConnection.getConnection();
		  try {
		   String sql = "select * from customerdetails where password = ?";
		   PreparedStatement pstm = con.prepareStatement(sql);
		   pstm.setString(1, password);
		   ResultSet rs = pstm.executeQuery();
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
