<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/LogIn" method="POST">
Enter user name: <input type="text" name="uname"><br>
Enter password: <input type="password" name="pass"><br>
<input type="submit" name = "LoginButten" value="LoginBtn"> <br>
<inpute type = "text" name = "ans">

</form>


</body>
</html>