package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OperatorRegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String validationPassword = req.getParameter("validationPassword");

		System.out.println(validationPassword);

		// TODO hash the password , save the operator in the tbl_operators

		// TODO after hashing the password , you will need to decrypt when
		// validating users

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("EDIT"))
			handleFrogetOperatorPassword(request, response);

	}

	public void handleFrogetOperatorPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("username");

		System.out.println("username -> " + username);

		// TODO set the operator password to null , send a new hashed value

		// TODO add a new page to enter the value send by mail , and redirecting
		// to change password page if values are matched
	}

}
