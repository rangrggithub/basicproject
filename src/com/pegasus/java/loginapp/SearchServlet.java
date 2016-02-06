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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String lname = request.getParameter("lastname");
		  Connection con = GettingConnection.getConnection();
		  try {
		   PreparedStatement pstmt = null;
		   String sql = "select * from customerdetails where lastname=" + "'"
		    + lname + "'";
		   
		   PrintWriter out = response.getWriter(); 
		   if (checkToDataBase(lname)) {
		    out.print("<html><center><h3>Your serch detais is as follows</h3></center><hr></html>");
		     sql = "Select customerdetails.firstName,customerdetails.lastName,customerdetails.Sex,customerdetails.SecurityQuestion,customerdetails.answer, customerprofile.Email, customerprofile.Phonenumber, customerprofile.Address,customerprofile.City, customerprofile.State,customerprofile.Country From customerdetails,customerprofile WHERE customerdetails.lastName=customerprofile.lastName";
		   } else if (lname != null && !lname.equals("")) {
		    out.print("<html><h4>Lastname you entered is not match with the data we have.</h4></html>");
		    out.print("Please enter the correct lastname.");
		    request.getRequestDispatcher("search.jsp").include(request,
		      response);
		   } else {
		    out.print("<html><h4>You cannot leave the box blank.</h4></html>");
		    out.print("Please entered the lastname to search the details");
		    request.getRequestDispatcher("search.jsp").include(request,
		      response);
		   }
		   pstmt = con.prepareStatement(sql);
		   ResultSet rs = pstmt.executeQuery();
		   out.print("<html><table border='1'>");
		   
		   out.print("<tr bgcolor=" + "\"#00FF00\" align="+"\"center\"+>");
		   out.print("<td>FirstName</td><td>Lastname </td><td>Sex</td><td>SecurityQuestion</td><td>Answer</td><td>Email</td><td>PhoneNumber</td><td>Address</td><td>City</td><td>State</td><td>Country</td>");
		   out.print("</tr>");
		   
		   while (rs.next()) {
		    out.print("<tr bgcolor=" + "\"#FFFF00\">");
		    out.print("<td>" + rs.getString(1) + "</td>");
		    out.print("<td>" + rs.getString(2) + "</td>");
		    out.print("<td>" + rs.getString(3) + "</td>");
		    out.print("<td>" + rs.getString(4) + "</td>");
		    out.print("<td>" + rs.getString(5) + "</td>");
		    out.print("<td>" + rs.getString(6) + "</td>");
		    out.print("<td>" + rs.getString(7) + "</td>");
		    out.print("<td>" + rs.getString(8) + "</td>");
		    out.print("<td>" + rs.getString(9) + "</td>");
		    out.print("<td>" + rs.getString(10) + "</td>");
		    out.print("<td>" + rs.getString(11) + "</td>");
		    
		    out.print("</tr>");
		   }
		   out.print("</table></html>");
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		 }
		 public boolean checkToDataBase(String lastname) {
		  boolean status = false;
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  try {
		   con = GettingConnection.getConnection();
		   String sql = "select * from customerdetails where lastname=?";
		   pstmt = con.prepareStatement(sql);
		   pstmt.setString(1, lastname);
		   ResultSet rs = pstmt.executeQuery();
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
