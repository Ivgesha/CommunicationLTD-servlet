<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ForgotPassword" method="POST">
Enter Username <input type = "text" name ="username"><br> 
<input type = "submit" value = "Send reset to email" name = "btnSend"><br>
Enter generated number from your email: <input type="number" name="num"><br>
<input type="submit" value="submit" name = "btnSubmit">
</form>

</body>
</html>