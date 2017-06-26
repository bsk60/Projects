<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<%
        if(session.getAttribute("user")==null)
            {
response.sendRedirect("index.jsp"); // GO TO LOGIN PAGE
            }

%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=PT+Sans'
	rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
 <%@ include file="Header.jsp" %>
 
 <h1>Update User</h1>
<form action="controller?action=doupdateuser&empID=${empObject.empID}" method="post">
<table>
<tr><td>Employee ID</td><td><c:out value="${empObject.empID}" /></td></tr>
<tr><td>First Name:</td><td><input type="text" name="fname" value="${empObject.fname}" placeholder="${empObject.fname}"></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="lname" value="${empObject.lname}" placeholder="${empObject.lname}"></td></tr>
<tr><td>Email:</td><td><input type="text" name="email" placeholder="${empObject.email}"></td></tr>
<tr><td>Password:</td><td><input type="text" name="pass" ="${empObject.pass}"></td></tr>
<tr><td>Role:</td><td><select name="roleName" width="50">
<c:forEach var="user" items="${roleList}">
<option value="${user.name}" >${user.name}</option>
</c:forEach>
 
</select></tr>
<tr><td><input type="submit" value="Update"></td></tr>
</table>
</form>
</body>
</html>