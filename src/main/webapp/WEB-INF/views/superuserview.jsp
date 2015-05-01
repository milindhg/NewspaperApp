<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Login</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
<!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>

<body>
	<div class="container" style="width:550px;"">
		<section class="register">
			<h2>Hi ${sessionUser.firstName } ${sessionUser.lastName }</h2>
			<h1>Super User View</h1>
			<h2>Manage Editors</h2>
			<div class="reg_section personal_info">
				<table border="1">
					<tr>
						<th><h3>First Name</h3></th>
						<th><h3>Last Name</h3></th>
						<th><h3>Contact Number</h3></th>
						<th><h3>Email</h3></th>
						<th><h3>Role</h3></th>
						<th><h3>Department</h3></th>
						<th></th>
					</tr>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.contactNumber}</td>
							<td>${user.email}</td>
							<td>${user.role}</td>
							<td>${user.department}</td>
							<td><a href="deleteuser?userId=${user.userId}"> delete </a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="reg_section password">
				<h3>
					<a href="adduser">Add New Editor</a>
				</h3>

				<!-- <input type="password" name="confirm" value="" placeholder="Confirm Password"> -->
			</div>
			<p class="terms">
				<label> <!-- <input type="checkbox" name="remember_me" id="remember_me"> -->
					${message}
				</label>
			</p>
		</section>
		<div class="reg_section password">
			<a href="logout"> Logout </a>
		</div>
	</div>


</body>
</html>