package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAOImpl;
import com.dao.LoginDao;
import com.entity.Login;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginDao loginDao = null;

	public LoginController() {
		loginDao = new LoginDAOImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// save the http session
		HttpSession httpSession = req.getSession();

		// get the parameters of the form
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// Instantiate a new login and set values
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);

		String status = loginDao.authenticate(login);
		System.out.println(status);

		// redirect based on the status
		switch (status) {
		case "true":
			httpSession.setAttribute("username", username);
			resp.sendRedirect("CustomerController?action=LIST");
			break;
		case "false":
			// TODO add an error message "invalid username or password"
			resp.sendRedirect("index.jsp?status=false");
			break;
		case "error":
			resp.sendRedirect("index.jsp?status=error");
			break;

		default:
			break;
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
