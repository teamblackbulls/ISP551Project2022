<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Prayer</title>
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
			  <li><a href="ListStaffController">List Staff</a></li>
			  <li><a href="ListPrayerController">List Prayer</a></li>
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="container col-md-5">
	<a href="ListPrayerController"><button >Back</button></a><br><br>
		<div class="card">
			<div class="card-body">
			<form method="post" action="AddPrayerController">
					<caption>
						<h2> Add Prayer </h2>
					</caption>
					<fieldset class="form-group">
						<label>Prayer Name</label> 
						<input type="text" class="form-control" id="pname" name="prayerName" required="required" placeholder="Zuhur*">
					</fieldset>
					
					<button type="submit" class="btn btn-success">Submit</button>
					<button type="reset" class="btn btn-success">Reset</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>