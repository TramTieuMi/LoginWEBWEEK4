package vn.iostar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import vn.iostar.models.UserModels;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserService;
import vn.iostar.utils.Email;

@WebServlet(urlPatterns = { "/home", "/login", "/register", "/forgotpass", "/waiting", "/VerifyCode" })
	
public class HomeController extends HttpServlet {

    //private static final long serialVersionUID = 5889168824989045500L;

    //ICategoryService cateService = new CategoryServiceImpl();
    IUserService userService = new UserService();
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();

        if (url.contains("register")) {
            getRegister(req, resp);
        } else if (url.contains("login")) {
        //    getLogin(req, resp);
        } else if (url.contains("forgotpass")) {
            req.getRequestDispatcher("views/web/forgotpassword.jsp").forward(req, resp);
        //} else if (url.contains("waiting")) {
           // getWaiting(req, resp);
        } else if (url.contains("VerifyCode")) {
            req.getRequestDispatcher("views/web/verify.jsp").forward(req, resp);
        } else {
            homePage(req, resp);
        }
    }
    protected void homePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
    }
    protected void getRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("register")) {
            postRegister(req, resp);
        } else if (url.contains("login")) {
         //   postLogin(req, resp);
        } else if (url.contains("forgotpass")) {
       //     postForgotPassword(req, resp);
        } else if (url.contains("VerifyCode")) {
            postVerifyCode(req, resp);
        }
    }
    
    protected void postRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // Lấy tham số từ form
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");

        String alertMsg = "";
        if (userService.checkExistEmail(email)) {
            alertMsg = "Email đã tồn tại!";
            req.setAttribute("error", alertMsg);
            req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
        } else if (userService.checkExistUsername(username)) {
            alertMsg = "Tài khoản đã tồn tại!";
            req.setAttribute("error", alertMsg);
            req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
        }
        else {
            Email sm = new Email();
            // get the 6-digit code
            String code = sm.getRandom();

            // create new user using all information
            UserModels user = new UserModels(username, email, fullname, code);

            boolean test = sm.sendEmail(user);
            if (test) {
                HttpSession session = req.getSession();
                session.setAttribute("account", user);

                boolean isSuccess = userService.register(email, password, username, fullname, code);

                if (isSuccess) {
                    resp.sendRedirect(req.getContextPath() + "/VerifyCode");
                } else {
                    alertMsg = "Lỗi hệ thống!";
                    req.setAttribute("Error", alertMsg);
                    req.getRequestDispatcher("/views/web/register.jsp");
                    
                }
            } else {
                PrintWriter out = resp.getWriter();
                out.print("Lỗi khi gửi mail");
            }
        }
    }
    
    protected void postVerifyCode(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    		    resp.setContentType("text/html; charset=UTF-8");
    		    try (PrintWriter out = resp.getWriter()) {

    		        HttpSession session = req.getSession();
    		        UserModels user = (UserModels) session.getAttribute("account");

    		        String code = req.getParameter("authcode");

    		        if (code.equals(user.getCode())) {
    		            user.setEmail(user.getEmail());
    		            //user.setStatus(1);
    		           // userService.updatestatus(user);

    		            out.println("<div class=\"container\"><br/>\r\n" +
    		                    "<br/>\r\n" +
    		                    "<br/>Kích hoạt tài khoản thành công!<br/>\r\n" +
    		                    " <br/>\r\n" +
    		                    "<br/></div>");
    		        } else {
    		        	out.println("<div class=\"container\"><br/>\r\n" +
    		        	        "<br/>\r\n" +
    		        	        "<br/>Sai mã kích hoạt, vui lòng kiểm tra lại!<br/>\r\n" +
    		        	        " <br/>\r\n" +
    		        	        "<br/></div>");
    		        }
    		    }
    		}
    
}