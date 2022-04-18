package com.ssafy.model.dao;

import java.sql.SQLException;

import com.ssafy.model.dto.User;

public interface UserDAO {

	String login(String id, String pass) throws SQLException;

	void signin(User user) throws SQLException;

	User userInfo(String id);

}