<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<body>
<%@include file="mainnavbar.jsp" %>
<h3 align="center">Admin Login</h3>
<form method="post" action="checkadminlogin">
<label>Enter Username</label>
<input type="text" name="auname" required />
<br/>

<label>Enter Password</label>
<input type="password" name="apwd" required />
<br/>
<input type="submit" value="Register" class="btn btn-success"/>
<input type="reset" value="Clear" class="btn btn-success"/>

</form>
</body>
</html>