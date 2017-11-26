<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Items </title>
</head>
<body>


<form:form method = "POST" action = "search" modelAttribute = "searchItem" >

Item Name <form:input path = "itemName"/> <br/>
<input type = "submit" value = "Search" /> <br/>

</form:form>

<form:form method = "GET" action = "apply" modelAttribute = "filter" >
Select Category <br/>

<form:checkbox path="category" value="Apparels"/>Apparels
<form:checkbox path="category" value="Electronics"/>Electronics
<br/>

Weight <form:input path = "weight"/> <br/>
Price  <form:input path = "price"/> <br/>

Select Size <br/>
<form:checkbox path="size" value="small"/>Small
<form:checkbox path="size" value="large"/>Large
<br/>

<input type = "submit" value = "Apply" /> 

</form:form>



</body>
</html>