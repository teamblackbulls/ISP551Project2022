<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Update Staff</title>
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
			  <li><a class="active" href="#updateStaff">Update Staff</a></li>
			  <li><a href="ListStaffController">List Staff</a></li>
			  <li><a href="ListPrayerController">List Prayer</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<form method="post" action="UpdateStaffController">
					<caption>
						<h2> Update Staff </h2>
					</caption>
					<fieldset class="form-group">
						<label>Staff Name</label> 
						<input type="text" class="form-control" id="name" name="name" required="required" placeholder="Ahmad Hakim*" value="${s.name}"/>
					</fieldset>
					
					<fieldset class="form-group">
						<label>Staff Address</label> 
						<input type="text" class="form-control" id="address" name="address" required="required" value="${s.address}"/>
					</fieldset>
	
					<fieldset class="form-group">
						<label>Staff Phone Number</label> 
						<input type="text" class="form-control" name="phone" id="phone" placeholder="0172547654*" value="${s.phone}"/>
					</fieldset>
	
					<fieldset class="form-group">
						<label>Staff Email</label> 
						<input type="text" value="${s.email}" class="form-control" id="email" name="email" placeholder="ahmadh@gmail.com*"/>
					</fieldset>
	
					<fieldset class="form-group">
						<label>Staff Role</label> 
						<select class="form-control" name="role">
							<option value="Imam">Imam</option>
							<option value="Bilal">Bilal</option>
						</select>
					</fieldset>
					<input type="hidden" name="id" value="${s.id}"/><br><br>
					<button type="submit" class="btn btn-success">Submit</button>
					<button type="reset" class="btn btn-success">Reset</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>