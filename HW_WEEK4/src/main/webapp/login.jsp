<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
<style>
    body {
        font-family: 'Roboto', sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    form {
        width: 100%;
        max-width: 400px;
        background-color: white;
        padding: 30px 40px;
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
    .alertdanger {
        text-align: center;
        color: red;
    }
    .submit {
        text-align: center;
        margin-top: 20px;
    }
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #007BFF;
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
        color: #007BFF;
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
    .in {
        margin-bottom: 20px;
    }
    .checkbox-container {
        display: flex;
        align-items: center;
        margin-bottom: 20px;
    }
    .checkbox-container input {
        margin-right: 10px;
    }
    .footer-links {
        text-align: center;
        margin-top: 20px;
    }
</style>
</head>
<body>
    <form action="/HW_login/home" method="POST">
        <img src="https://hcmute.edu.vn/Resources/Images/Logo/Logo%20HCMUTE-Corel-white%20background.jpg" alt="Logo">
        <h2>Đăng nhập</h2>
        <c:if test="${alert != null}">
            <h3 class="alert alertdanger">${alert}</h3>
        </c:if>
        <div class="in">
            <label for="name">Tên Tài Khoản:</label>
            <input type="text" id="name" name="name" placeholder="Username">
        </div>
        <div class="in">
            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" placeholder="Password">
        </div>
        <div class="checkbox-container">
            <input type="checkbox" id="remember" name="remember" value="on">
            <label for="remember">Nhớ tôi</label>
        </div>
        <div class="submit">
            <input type="submit" value="Đăng nhập">
        </div>
        <div class="footer-links">
            <p><a href="forgetPW.jsp">Quên mật khẩu?</a></p>
            <p>Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <br>
            <a href="register.jsp">Đăng ký</a></p>
        </div>
    </form>
</body>
</html>