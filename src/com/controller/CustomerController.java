package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDAO;
import com.dao.CustomerDAOImpl;
import com.entity.Customer;

public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDAO customerDAO = null;
	RequestDispatcher dispatcher = null;

	public CustomerController() {
		customerDAO = new CustomerDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null)
			action = "LIST";

		switch (action) {
		case "LIST":
			listCustomrs(request, response);
			break;

		default:
			listCustomrs(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setUsername(username);

		// The insertion to database succeed
		if (customerDAO.saveCustomer(customer)) {
			request.setAttribute("message", "Saved Successfully");
		}

		listCustomrs(request, response);

	}

	public void listCustomrs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// call dao to get list of customers
		List<Customer> customers = customerDAO.get();

		// Add customers to request object
		request.setAttribute("customers", customers);
		// Get the request dispatcher and forward the request
		dispatcher = request.getRequestDispatcher("/views/Customer-list.jsp");
		dispatcher.forward(request, response);

	}

}
