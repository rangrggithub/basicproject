<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Password Reset Form</title>

</head>

<body>

<h3>Please answer the security question to reset your password</h3>

<form action="resetpassword" method="get">

<table>

<tr>

<td>Username:</td>

<td><input type="text" name="username"></td>

</tr>

<tr>

<td>Select Security Question:</td>

<td><select name="securityquestion">

<option>What is your mother maiden name?</option>

<option>what is the make of your first car?</option>

<option>Which school did you attend for the first time?</option>

<option>In which city you born?</option>

</select></td>

</tr>

<tr>

<td>Answer:</td>

<td><input type="text" name="answer"></td>

</tr>

</table>

<input type="submit" value="Submit"><br><br>

</form>

<a href="Login.jsp"><button>Back to Login</button></a>

</body>

</html>