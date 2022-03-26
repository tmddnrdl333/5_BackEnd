package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.model.dto.Dept;
import com.ssafy.util.DBUtil;

public class UserDAO {

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

	public void signin(String id, String pass, String name, String email) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into userinfo values(?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, id);
			stmt.setString(2, pass);
			stmt.setString(3, name);
			stmt.setString(4, email);
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt, conn);
		}
	}
	// userinfo 구현, 세션에서 정보 가져와서 select해서 뿌리기
	// 여기(DAO)와 Service와 MainServlet에도 구현하기
}
