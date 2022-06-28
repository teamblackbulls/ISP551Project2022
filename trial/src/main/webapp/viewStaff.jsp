<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>My Profile</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	
	<style type="text/css">
		.center {
		  margin: auto;
		  width: 60%;
		  border: 3px solid #111;
		  padding: 10px;
		}
	
		ul {
		  list-style-type: none;
		  margin: 0;
		  padding: 0;
		  overflow: hidden;
		  background-color: #333;
		}
		
		li {
		  float: left;
		}
		
		li a {
		  display: block;
		  color: white;
		  text-align: center;
		  padding: 14px 16px;
		  text-decoration: none;
		}
		
		li a:hover:not(.active) {
		  background-color: #111;
		}
		
		.active {
		  background-color: #ECE2E0;
		   color: black;
		}
	</style>
	
</head>
<body>
<br>
	<ul>
	  <li><a href="index.html">Home</a></li>
	  <li><a class="active" href="#viewCustReq">View Customer Request</a></li>
	  <li><a href="ListCustReqController">List Customer Request</a></li>
	  <li><a href="addPrayer.jsp">Add Prayer</a></li>
	  <li><a href="ListPrayerController">List Prayer</a></li>
	</ul>
	<br>
	<div class="center">
		<h2>My Information</h2>
		ID: <c:out value="${s.id}"/> <br>
		Name: <c:out value="${s.name}"/> <br>
		Address: <c:out value="${s.address}"/> <br>
		Phone Number: <c:out value="${s.phone}"/> <br>
		Email: <c:out value="${s.email}"/> <br>
		Role: <c:out value="${s.role}"/> <br><br>
	</div>
</body>
</html>