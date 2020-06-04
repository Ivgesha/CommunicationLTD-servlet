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


	<%
		String username = (String) session.getAttribute("username");

		if (username == null)
			response.sendRedirect("index.jsp");
	%>
	<div class="container">
		<div class="float-right">
			<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
		</div>
		<div class="float-right">
			<form
				action="${pageContext.request.contextPath}/OperatorRegisterController?action=EDIT'"
				method="get">
				<button type="submit">Discard password</button>
			</form>
		</div>


		<button class="btn btn-primary"
			onClick="window.location.href='views/Customer-register.jsp'">Add
			Customer</button>


		<table class="table table-bordered">
			<tr class="thead-dark">
				<th>ID</th>
				<th>USERNAME</th>
				<th>EMAIL</th>
				<th>Actions</th>
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