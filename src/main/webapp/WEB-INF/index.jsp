<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Landing Page</title>
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<div class="nav">
				<h2>Assignment: Events Belt Reviewer</h2>
			</div>
		</div>
		<div class="main_content">
				<h1>Welcome, <c:out value="${user.fName}" /></h1>
				<a href="/logout">Logout</a>
		</div>
	</div>
</body>
</html>