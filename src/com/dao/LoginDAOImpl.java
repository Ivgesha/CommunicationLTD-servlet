package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			if (result.next())
				return "true";
			else
				return "false";

		} catch (Exception e) {
			e.printStackTrace();
		}

		// return error if our sql connection was not successfull
		return "error";
	}

}
