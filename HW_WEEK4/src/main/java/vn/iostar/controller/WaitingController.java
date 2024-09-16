package vn.iostar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.model.User;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/waiting")
public class WaitingController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	if (session != null && session.getAttribute("account") != null) {
		User u = (User) session.getAttribute("account");
		req.setAttribute("username", u.getName());
		if (u.getId() == 1) {
			resp.sendRedirect(req.getContextPath() + "/admin_home.html");
		} else {
			resp.sendRedirect(req.getContextPath() + "/home.html");
		}
	} else {
		resp.sendRedirect(req.getContextPath() + "/home");
	}
}
}