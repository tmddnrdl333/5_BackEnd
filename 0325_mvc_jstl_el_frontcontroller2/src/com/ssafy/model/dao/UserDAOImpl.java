package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.model.dto.User;
import com.ssafy.util.DBUtil;

public class UserDAOImpl implements UserDAO {

	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String login(String id, String pass) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select name from userinfo where userid = ? and password = ?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pass);

			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public void signin(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into userinfo values(?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, user.getId());
			stmt.setString(2, user.getPass());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getEmail());
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt, conn);
		}
	}

	@Override
	public User userInfo(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from userinfo where userid = ?";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new User(id, rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return null;
	}

	// userinfo 구현, 세션에서 정보 가져와서 select해서 뿌리기
	// 여기(DAO)와 Service와 MainServlet에도 구현하기
}
