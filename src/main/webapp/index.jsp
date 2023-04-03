<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/main.css"></c:url>" rel="stylesheet" >
<title>Library Application</title>
</head>
<body>
	<h1>Library Application</h1>
	<a href="staffform">Add Staff</a>
	<a href="viewstaff">View Staff</a>
	<br><br>
	
	<a href="studentform">Add Student</a>
	<a href="viewstudent">View Students</a>
	<br><br>
	
	<a href="borrowerform">Add Borrower</a>
	<a href="viewborrower">View Borrowers</a>
	<br><br>
	
	<img src="<c:url value="/resources/img/klein.jpg"></c:url>" width="300px" alt="image of amon">
	
</body>
</html>