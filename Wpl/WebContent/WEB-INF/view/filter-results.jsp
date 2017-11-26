<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Public Registry</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Filter Result</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
			<table border = 1>
				<tr>
					<th>Item ID</th>
					<th>Item Name</th>
					<th>Price</th>
					<th>Category</th>
					<th>Weight</th>
				</tr>
				
				<c:forEach var= "r" items= "${filterList}">
					<tr>
						<td>${r.itemId}</td>
						<td>${r.itemName}</td>
						<td>${r.price}</td>
						<td>${r.category}</td>
						<td>${r.weight}</td>
					</tr>
				</c:forEach>
			</table>
		</div>	
	
	</div>
</body>
</html>