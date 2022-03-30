package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dto.Member;
import util.DBUtil;

public class MemberDAO {

	public String login(String memberId,String memberPassword) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select memberNickname from member where memberId = ? and memberPassword= ?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setString(2, memberPassword);

			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1);
			}
		}finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		} 
		return null;
	}

	public boolean signup(Member member) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "insert into member values(?,?,?,?,?,?,?)";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,member.getMemberId());
			stmt.setString(2,member.getMemberPassword());
			stmt.setString(3,member.getMemberName());
			stmt.setString(4,member.getMemberNickname());
			stmt.setString(5,member.getMemberEmail());
			stmt.setString(6,member.getMemberPhone());
			stmt.setString(7,member.getMemberAddress());
			int row = stmt.executeUpdate();
			return row>0;
		} finally {
			DBUtil.close(stmt, conn);
		}
	}
	
	public boolean delete(String memberId) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from member where memberId = ? ";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,memberId);
			int row = stmt.executeUpdate();
			return row>0;
		}finally {
			DBUtil.close(stmt, conn);
		}
		
	}
	
	public Member mypage(String memberId) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from member where memberId = ?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return new Member(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		}finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return null;
	}
	
	public boolean modify(Member member) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "update member set memberPassword = ?, memberName = ?, memberNickname = ?"
				+ ", memberEmail = ?, memberPhone = ?, memberAddress = ?"
				+ "where memberId = ? ";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,member.getMemberPassword());
			stmt.setString(2,member.getMemberName());
			stmt.setString(3,member.getMemberNickname());
			stmt.setString(4,member.getMemberEmail());
			stmt.setString(5,member.getMemberPhone());
			stmt.setString(6,member.getMemberAddress());
			stmt.setString(7,member.getMemberId());
			int row = stmt.executeUpdate();
			return row>0;
		}finally {
			DBUtil.close(stmt, conn);
		}
	}
}
