package vn.iostar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.service.UserService;
import vn.iostar.service.UserServiceImpl;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.sendRedirect(req.getContextPath() + "/admin");
            return;
        }
        
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/admin");
                    return;
                }
            }
        }
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("name_r");
        String password = req.getParameter("password_r");
        String fullname = req.getParameter("fullname");
        String idStr = req.getParameter("number");
        
        String alertMessage = "";
        try {
            int id = Integer.parseInt(idStr);

            if (userService.checkExistUsername(username)) {
                alertMessage = "Tài khoản đã tồn tại";
                req.setAttribute("alert", alertMessage);
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                return;
            }
            if (userService.checkExistId(id)) {
                alertMessage = "ID đã tồn tại";
                req.setAttribute("alert", alertMessage);
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                return;
            }
            
            boolean isSuccess = userService.register(id, username, password, fullname);
            if (isSuccess) {
                resp.sendRedirect(req.getContextPath() + "/home");
            } else {
                alertMessage = "System error";
                req.setAttribute("alert", alertMessage);
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            alertMessage = "ID không hợp lệ";
            req.setAttribute("alert", alertMessage);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
