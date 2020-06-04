package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Customer;
import com.util.DBConnectionUtil;

public class CustomerDAOImpl implements CustomerDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;

	@Override
	public List<Customer> get() {

		// Create Reference variables
		List<Customer> customers = null;
		Customer customer = null;

		try {
			customers = new ArrayList<Customer>();

			// create the sql query
			String sql = "SELECT * FROM tbl_customers";

			// get a database connection
			connection = DBConnectionUtil.openConnection();

			// create a statement
			statement = connection.createStatement();

			// execute the query
			resultSet = statement.executeQuery(sql);

			// process the resultset
			while (resultSet.next()) {
				customer = new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setUsername(resultSet.getString("username"));
				customer.setEmail(resultSet.getString("email"));

				customers.add(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customers;
	}

	@Override
	public boolean saveCustomer(Customer customer) {
		boolean flag = false;

		try {
			String sql = "INSERT INTO tbl_customers(username , password , email)" + "VALUES (?,?,?)";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, customer.getUsername());
			preparedStatement.setString(2, customer.getPassword());
			preparedStatement.setString(3, customer.getEmail());

			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;

	}
	
	
	
	// TODO generalize the authenticate method for 
	@Override
	public boolean authenticate(String username,String password) {
		boolean isUser = false;
        try {
        	System.out.println("username -> " + username + " and password -> " + password + "\n");
            Connection con = DBConnectionUtil.openConnection();
            PreparedStatement statement = con.prepareStatement("select username,password from tbl_operators where username=? and password=?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                isUser = true;
                System.out.println("User authenticated successfully");
            } else {
            	
                System.out.println("Invalid username or password!");
            }
        } catch (Exception e) {
            System.out.println("DB related Error");
            e.printStackTrace();
        }
        return isUser;
    }
		
		
}
	
