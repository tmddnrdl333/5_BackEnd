package com.ssafy.model.service;

import java.sql.SQLException;

import com.ssafy.model.dao.UserDAO;
import com.ssafy.model.dto.User;

public class UserService {

	private UserDAO userDao = new UserDAO();

	public String login(String id, String pass) throws SQLException {
		return userDao.login(id, pass);
	}

	public void signin(User user) throws SQLException {
		userDao.signin(user);
		return;
	}

	public User userInfo(String id) throws SQLException {
		return userDao.userInfo(id);
	}
}
