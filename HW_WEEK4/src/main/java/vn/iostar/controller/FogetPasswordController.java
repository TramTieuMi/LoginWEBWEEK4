package vn.iostar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.service.UserService;
import vn.iostar.service.UserServiceImpl;

@WebServlet(urlPatterns = {"/forgotPassword"})
public class FogetPasswordController extends HttpServlet {

 
	private static final long serialVersionUID = 1L;
	private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl(); // Dependency Injection can be implemented here if needed
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/forgotPassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String newPassword = req.getParameter("password");
        String alertMessage;

        try {
            boolean isSuccess = userService.forgotPassWord(username, newPassword);
            if (isSuccess) {
                alertMessage = "Password reset successfully.";
                req.setAttribute("alert", alertMessage);
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                alertMessage = "User does not exist.";
                req.setAttribute("alert", alertMessage);
                req.getRequestDispatcher("/forgotPassword.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            alertMessage = "An error occurred while processing your request.";
            req.setAttribute("alert", alertMessage);
            req.getRequestDispatcher("/forgotPassword.jsp").forward(req, resp);
        }
    }
}
