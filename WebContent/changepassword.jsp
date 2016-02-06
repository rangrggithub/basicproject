<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>

<form action="changepassword" method="get">
<table >
<tr>
<td>Existing Password:</td>
<td><input type="password" name="epassword"><td>
</tr>
<tr>
<td>New Password:</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td>Confirm Password:</td>
<td><input type="password" name="password"></td>
</tr>
</table>
<input type="submit" value="Submit">
</form>
</body>
</html>