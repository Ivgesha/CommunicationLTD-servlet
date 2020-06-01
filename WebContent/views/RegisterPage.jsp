<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Register" method="POST">

Enter user name: <input type="text" name="uname"><br>
Enter password: <input type="password" name="pass"><br>
Confirm password: <input type="password" name="pass"><br>
Enter e-mail: <input type="email" name="email"><br>

<input type="submit" value="Register" name = "btnRegister">
</form>



</body>
</html>