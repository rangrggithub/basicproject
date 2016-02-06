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
 * Servlet implementation class CreateProfileServlet
 */
@WebServlet("/CreateProfileServlet")
public class CreateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateProfileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  String fname = request.getParameter("firstname");
		  String lname= request.getParameter("lastname");
		  String email = request.getParameter("email");
		  String phone = request.getParameter("phonenumber");
		  String address = request.getParameter("address");
		  String city = request.getParameter("city");
		  String state = request.getParameter("state");
		  String country = request.getParameter("country");
		  
		 
		  
		  insertData(fname, lname, email, phone, address, city, state, country);
		 }
		 public void insertData(String firstname, String lastname, String email, String phonenumber, String address, String city, String state, String country){
		  
		  Connection con =null;
		  try {
		   Class.forName("com.mysql.jdbc.Driver");
		   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pegasus_schema", "root", "");
		   
		   String sql = "Insert into customerprofile values(?,?,?,?,?,?,?,?)";
		   PreparedStatement ps = con.prepareStatement(sql);
		   
		   ps.setString(1, firstname);
		   ps.setString(2, lastname);
		   ps.setString(3, email);
		   ps.setString(4, phonenumber);
		   ps.setString(5, address);
		   ps.setString(6, city);
		   ps.setString(7, state);
		   ps.setString(8, country);
		   
		   ps.executeUpdate();
		   System.out.println("Inserted Successfully..........");
		  } catch (ClassNotFoundException e) {
		   e.printStackTrace();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		 }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
