<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-CbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2yLzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
</head>
<title>Register</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<c:if test="${not empty message}">
					<div class="alert alert-success">${message}</div>
				</c:if>

				<c:if test="${not empty error}">
					<div class="alert alert-danger">${error}</div>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<form action="register" method="post">
					<div class="form-group">
						<label for="username">User Name:</label> <input type="text"
							class="form-control" id="username" name="username">
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="email" name="email">
					</div>
					<div class="form-group">
						<label for="fullName">Full Name:</label> <input type="text"
							class="form-control" id="fullName" name="fullName">
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" id="password" name="password">
					</div>
					<div class="form-group">
						<label for="confirmPassword">Confirm Password:</label> <input
							type="password" class="form-control" id="confirmPassword"
							name="confirmPassword" />
					</div>
					<button type="submit" class="btn btn-primary">Register</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

