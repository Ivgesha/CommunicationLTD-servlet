package com.dao;

import com.entity.Login;

public interface LoginDao {
	String authenticate(Login login);
	boolean insertUser(Login login);
}
