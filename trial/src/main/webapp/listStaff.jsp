<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>List Staff</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
	<style type="text/css">
		ul {
		  list-style-type: none;
		  margin: 0;
		  padding: 0;
		  overflow: hidden;

		}
		
		li {
		  float: left;
		}
		
		li a {
		  color: white;
		  text-align: center;
		  padding: 14px 16px;
		  text-decoration: none;
		}
		
		li a:hover:not(.active) {
			color: black;
		}
		
		.active {
		   color: black;
		}
		
		table, th, td {
		  border: 1px solid;
		}
		table {
		  width: 95%;
		}
		
		.center {
		  margin: auto;

		  padding: 10px;
		}
	</style>
	
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #95ac80">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> MasjidSalam </a>
			</div>

			<ul>
			  <li><a href="index.html">Home</a></li>
			  <li><a href="addStaff.jsp">Add New Staff</a></li>
			  <li><a class="active" href="#ListStaffController">List of Staffs</a></li>
			  <li><a href="ListPrayerController">List Prayer</a></li>
			</ul>
		</nav>
	</header>
	
	<div class="center">
		<table>
			<tr>
				<th>ID</th>
				<th>Staff Name</th>
				<th>Staff Address</th>
				<th>Phone Number</th>
				<th>Email</th>
				<th>Role</th>
				<th colspan="3">Actions</th>
			</tr>
			<c:forEach  items="${staffs}" var="s" varStatus="staffs">
			<tr>
				<td><c:out value="${s.id}" /></td>
				<td><c:out value="${s.name}" /></td>
				<td><c:out value="${s.address}" /></td>
				<td><c:out value="${s.phone}" /></td>
				<td><c:out value="${s.email}" /></td>
				<td><c:out value="${s.role}" /></td>
							
				<td><a class="btn btn-primary" href="ViewStaffController?id=<c:out value="${s.id}"/>">View</a></td>
				<td><a class="btn btn-primary" href="UpdateStaffController?id=<c:out value="${s.id}"/>">Update</a></td>
				
				<td><button class="btn btn-danger" id="<c:out value="${s.id}"/>" onclick="confirmation(this.id)">Delete</button></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	
	
	<script>
		function confirmation(id) {
			console.log(id);
			var r = confirm("Are you sure you want to delete?");
			if (r == true) {
				location.href = 'DeleteStaffController?id=' + id;
				alert("Customer Request successfully deleted");
			} else {
				return false;
			}
		}
	</script>
</body>
</html>