<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<button class="btn btn-primary"
			onclick="window.location.href='views/Customer-register.jsp'">Register</button>
		<table class="table table-bordered">
			<tr class="thead-dark">
				<th>ID</th>
				<th>USERNAME</th>
				<th>EMAIL</th>
			</tr>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.username}</td>
					<td>${customer.email}</td>
				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>