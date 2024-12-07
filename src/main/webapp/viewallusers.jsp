<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>
<%@ include file="adminnavbar.jsp" %>
<h3 align="center">View all users</h3>
<table align="center" border="2">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>GENDER</th>
        <th>EMAIL</th>
        <th>PASSWORD</th>
        <th>CONTACT NUMBER</th>
    </tr>
    <c:forEach var="user" items="${userlist}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.contactNumber}</td> <!-- Ensure this line is correct -->
        </tr>
    </c:forEach>
</table>

</body>
</html>
