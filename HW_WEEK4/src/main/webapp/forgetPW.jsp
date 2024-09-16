<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Forgot Password</title>
  <link rel="stylesheet" type="text/css" href="style.css">
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
      text-align: center;
    }

    h2 {
      color: #333;
      margin-bottom: 20px;
    }

    .alert {
      color: red;
      margin-bottom: 20px;
    }

    .in {
      margin-bottom: 15px;
      text-align: left;
    }

    label {
      display: block;
      margin-bottom: 5px;
      color: #333;
    }

    input[type="text"], input[type="password"] {
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

    img {
      display: block;
      margin: 0 auto 20px;
      width: 80px;
      height: auto;
    }
  </style>
</head>
<body>
  <form action="/HW_login/forgotpassword" method="POST">
    <img src="https://hcmute.edu.vn/Resources/Images/Logo/Logo%20HCMUTE-Corel-white%20background.jpg" alt="Logo">
    <h2>Quên mật khẩu</h2>
    <c:if test="${alert != null}">
      <h3 class="alert">${alert}</h3>
    </c:if>
    <div class="in">
      <label for="name">Tên Tài Khoản:</label>
      <input type="text" id="name" name="name" placeholder="Username" required>
    </div>
    <div class="in">
      <label for="password">Mật khẩu mới:</label>
      <input type="password" id="password" name="password" placeholder="Password" required>
    </div> 
    <div class="submit">
      <input type="submit" value="Lấy lại mật khẩu">
    </div>
  </form>
</body>
</html>
