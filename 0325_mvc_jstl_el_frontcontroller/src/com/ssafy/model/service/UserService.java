package com.ssafy.model.service;

import java.sql.SQLException;

import com.ssafy.model.dao.UserDAO;

public class UserService {

	private UserDAO userDao = new UserDAO();

	public String login(String id, String pass) throws SQLException {
		return userDao.login(id, pass);
	}

	public void signin(String id, String pass, String name, String email) throws SQLException {
		userDao.signin(id, pass, name, email);
		return;
	}
}
