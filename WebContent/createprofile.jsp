<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="createprofile" method="get">
<h4 align="center">Please fill of the following to create your profile</h4>
<hr>
<table align="center" border="0">
<tr>
<td>Firstname:</td>
<td><input type="text" name="firstname" ></td>
</tr>
<tr>
<td>Lastname:</td>
<td><input type="text" name="lastname" ></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="text" name="email" ></td>
</tr>
<tr>
<tr>
<td>Phone Number:</td>
<td><input type="text" name="phonenumber" ></td>
</tr>
<tr>
<td>Address:</td>
<td><input type="text" name="address" ></td>
</tr>
<tr>
<td>City:</td>
<td><input type="text" name="city" ></td>
</tr>
<tr>
<td>State:</td>
<td><input type="text" name="state"></td>
</tr>
<tr>
<td>Country:</td>
<td><input type="text" name="country" ></td>
</tr>
<tr>
<td><input align="right" type="submit" value="Submit"></td>
</tr>
</table>
</form>
<a href="home.jsp"><button>Back</button></a>
</body>
</html>