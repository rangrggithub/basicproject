<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Form</title>

</head>

<body>

<form action="login" method="get">

Username:<input type="text" name="username"><br><br>

Password:<input type="password" name="password"><br><br>

<input type="submit" value="Submit">

<button type="reset" value="Reset">Reset</button><br><br>

If you are visiting for the first time <a href="register.jsp">click here</a> to register<br><br>

</form>

<a href="forgetpassword.jsp"><button>Forget your Password</button></a>

</body>

</html>
