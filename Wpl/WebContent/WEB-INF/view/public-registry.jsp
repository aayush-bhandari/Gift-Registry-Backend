<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Public Registry</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
			<table>
				<tr>
					<th>Registry ID</th>
					<th>Registry Name</th>
					<th>Event Date</th>
					<th>AddressID</th>
				</tr>
				${publicRegistries}
				<c:forEach var = "public" items = '${publicRegistries}'>
					<tr>
						<td> ${public.registryId}</td>
						<td> ${public.registryName}</td>
						<td> ${public.eventDate}</td>
						<td> ${public.addressId}</td>
					</tr>
				</c:forEach>
			</table>
		</div>	
	
	</div>
</body>
</html>