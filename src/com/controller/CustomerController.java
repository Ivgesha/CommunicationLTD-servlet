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

		System.out.println("entered doGet");
		String action = request.getParameter("action");
		System.out.println("action = " + action);
		if (action == null)
			action = "LIST";

		switch (action) {
		case "LIST":
			handleListCustomrs(request, response);
			break;
		default:
			handleListCustomrs(request, response);
			break;
		}
	}

	
	// pressing submit in the addCustomer page 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entered doPost");
		String email = request.getParameter("email");
		String customerName = request.getParameter("customerName");
		String internetPackage = request.getParameter("internetPackage");
		String sector = request.getParameter("sector");
		String customerID = request.getParameter("customerID");

		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setCustomerName(customerName);
		customer.setInternetPackage(internetPackage);
		customer.setSector(sector);
		customer.setCustomerID(customerID);

		// The insertion to database succeed
		if (customerDAO.saveCustomer(customer)) {
			request.setAttribute("message", "Saved Successfully");
		}

		handleListCustomrs(request, response);

	}

	public void handleListCustomrs(HttpServletRequest request, HttpServletResponse response)
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