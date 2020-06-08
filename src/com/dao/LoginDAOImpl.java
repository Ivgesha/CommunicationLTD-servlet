package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.Login;

import com.util.DBConnectionUtil;

public class LoginDAOImpl implements LoginDao {

	@Override
	public String authenticate(Login login) {
		String sql = "select * from tbl_login where username=? and password=?";
		
		try {
			// first lookup in the tbl_login
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());
			ResultSet result = preparedStatement.executeQuery();
			
			

			// if we are getting a result
			if (result.next()) {
				 
				return "true";
			}
				
			else {
				 
				return "false";
			}
				

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		// return error if our sql connection was not successfull
		return "error";
	}

	
	
	@Override
	public boolean insertUser(Login login) {
		
		String sql = "INSERT INTO tbl_login(username , password , salt , email)" + "VALUES(?,?,?,?)";
		
		try {
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login.getUsername());			  
			preparedStatement.setString(2, login.getPassword());
			preparedStatement.setString(3, login.getSalt());
			preparedStatement.setString(4, login.getEmail());
			preparedStatement.execute();
			System.out.println("inserted new user\n");
			return true;
		} catch (SQLException e) {
		 
			// TODO Auto-generated catch block
			System.out.println("could not insert new user(operator)\n");
			e.printStackTrace();
		}
		
		return false;
	}

}
