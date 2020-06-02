<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/ChangePassword" method="POST">
Current password: <input type="text" name="text"><br>
Enter new password: <input type="text" name="text"><br>
Confirm new password: <input type="text" name="text"><br>
<input type="submit" value="submit" name = "btnSubmit"><br>


</form>
</body>
</html>