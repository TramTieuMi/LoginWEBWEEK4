package vn.iostar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.model.User;
import vn.iostar.service.UserService;
import vn.iostar.service.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
	public static final String SESSION_USERNAME = "username";
	public static final String COOKIE_REMEMBER = "username";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (COOKIE_REMEMBER.equals(cookie.getName())) {
					session = req.getSession(true);
					session.setAttribute(SESSION_USERNAME, cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("name");
        String pw = req.getParameter("password");
        
        boolean isRemember = false;
        String remember = req.getParameter("remember");

        if ("on".equals(remember)) {
            isRemember = true;
        }
        String alert = "";
        if (username.isEmpty() || pw.isEmpty()) {
            alert = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alert", alert);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        UserService service = new UserServiceImpl();
        User user = service.login(username, pw);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            if (isRemember) {
                save(resp, username);
            }
            resp.sendRedirect(req.getContextPath() + "/waiting");
        } else {
            alert = "Tài khoản hoặc mật khẩu sai";
            req.setAttribute("alert", alert);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    private void save(HttpServletResponse resp, String username) {
        Cookie cookie = new Cookie(COOKIE_REMEMBER, username);
        cookie.setMaxAge(30 * 60); 
        cookie.setPath("/"); 
        cookie.setHttpOnly(true);
        resp.addCookie(cookie);
    }
}