<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Registration Form</title>

</head>

<body>

<h4>Please fill of the following form for registration</h4>

<form action="register" method="get">

<table border="0">

<tr>

<td>Firstname:</td>

<td><input type="text" name="firstname" ></td>

</tr>

<tr>

<td>Lastname:</td>

<td><input type="text" name="lastname" ></td>

</tr>

<tr>

<td>Sex:</td>

<td><input type="radio" name="sex" value="male">Male<input type="radio" name="sex" value="female">Female</td>

</tr>

<tr>

<tr>

<td>Username:</td>

<td><input type="text" name="username" ></td>

</tr>

<tr>

<td>Password:</td>

<td><input type="text" name="password" ></td>

</tr>

<tr>

<td>Confirm Password:</td>

<td><input type="text" name="password" ></td>

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

<button type="reset" value="Reset">Cancel</button>

<input align="right" type="submit" value="Submit">

</form><br>

<a href="Login.jsp"><button>Back</button></a>

</body>

</html>