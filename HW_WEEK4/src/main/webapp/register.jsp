<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f0f2f5;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

form {
	width: 100%;
	max-width: 400px;
	background-color: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h2 {
	color: #333;
	text-align: center;
	margin-bottom: 20px;
}

.alert {
	text-align: center;
	color: red;
	margin-bottom: 20px;
}

.in {
	margin-bottom: 15px;
}

input[type="text"], input[type="password"], input[type="number"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #007bff;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	width: 100%;
	font-size: 16px;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

a {
	color: #007bff;
	text-decoration: none;
}

a:hover {
	color: #0056b3;
}

img {
	display: block;
	margin: 0 auto 20px;
	width: 80px;
	height: auto;
}

p {
	text-align: center;
	margin-top: 20px;
	color: #666;
}
</style>
</head>
<body>

	<form action="/HW_login/register" method="POST">
		<img
			src="https://hcmute.edu.vn/Resources/Images/Logo/Logo%20HCMUTE-Corel-white%20background.jpg"
			alt="Logo">
		<h2>Đăng kí tài khoản</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert">${alert}</h3>
		</c:if>
		<div class="in">
			<input type="number" name="number" placeholder="Nhập id" required>
		</div>
		<div class="in">
			<input type="text" name="name_r" placeholder="Nhập tên" required>
		</div>
		<div class="in">
			<input type="password" name="password_r" placeholder="Nhập mật khẩu"
				required>
		</div>
		<div class="in">
			<input type="text" name="fullname" placeholder="Nhập họ tên đầy đủ"
				required>
		</div>
		<div class="submit">
			<input type="submit" value="Đăng ký">
		</div>
		<p>
			Bạn đã có tài khoản? <a href="login.jsp">Đăng nhập</a>
		</p>
	</form>

</body>
</html>