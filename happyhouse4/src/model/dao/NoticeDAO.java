package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.ListParameterDto;
import model.dto.Member;
import model.dto.Notice;
import util.DBUtil;

public class NoticeDAO {

	public void registerNotice(Notice notice) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into notice (memberId, memberNickname, noticeTitle, noticeBody, noticeDate) \n");
			sql.append("values (?, ?, ?, ?, now())");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, notice.getMemberId());
			pstmt.setString(2, notice.getMemberNickname());
			pstmt.setString(3, notice.getNoticeTitle());
			pstmt.setString(4, notice.getNoticeBody());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	public List<Notice> listNotice(ListParameterDto listParameterDto) throws SQLException {
		List<Notice> list = new ArrayList<Notice>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select n.noticeNo, n.memberId, n.memberNickname, n.noticeTitle, n.noticeBody, \n");
			sql.append(" 		case when date_format(n.noticeDate, '%y%m%d') = date_format(now(), '%y%m%d') \n");
			sql.append("			then date_format(n.noticeDate, '%H:%i:%d') \n");
			sql.append("			else date_format(n.noticeDate, '%y.%m.%d') \n");
			sql.append("		end noticeDate \n");
			sql.append("from notice n, member m \n");
			sql.append("where n.memberId = m.memberId \n");
			String key = listParameterDto.getKey();
			String word = listParameterDto.getWord();
			if(!word.isEmpty()) {
				if(key.equals("noticeTitle")) {
					sql.append("and n.noticeTitle like concat('%', ?, '%') \n");
				} else {
					sql.append("and n." + key + " = ? \n");
				}
			}
			sql.append("order by n.noticeNo desc limit ?, ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			if(!word.isEmpty()) {
				pstmt.setString(++idx, word);
			}
			pstmt.setInt(++idx, listParameterDto.getStart());
			pstmt.setInt(++idx, listParameterDto.getCurrentPerPage());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rs.getInt("noticeNo"));
				notice.setMemberId(rs.getString("memberId"));
				notice.setMemberNickname(rs.getString("memberNickname"));
				notice.setNoticeTitle(rs.getString("noticeTitle").replace("<", "&lt;"));
				notice.setNoticeBody(rs.getString("noticeBody"));
				notice.setNoticeDate(rs.getString("noticeDate"));
				
				list.add(notice);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}
	
	public int getTotalCount(ListParameterDto listParameterDto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(noticeNo) \n");
			sql.append("from notice \n");
			String key = listParameterDto.getKey();
			String word = listParameterDto.getWord();
			if(!word.isEmpty()) {
				if(key.equals("noticeTitle")) {
					sql.append("where noticeTitle like concat('%', ?, '%') \n");
				} else {
					sql.append("where " + key + " = ? \n");
				}
			}

			pstmt = conn.prepareStatement(sql.toString());
			if(!word.isEmpty())
				pstmt.setString(1, word);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return cnt;
	}

	public Notice getNotice(int noticeNo) throws SQLException {
		Notice notice = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select n.noticeNo, n.memberId, n.memberNickname, n.noticeTitle, n.noticeBody, n.noticeDate \n");
			sql.append("from notice n, member m \n");
			sql.append("where n.memberId = m.memberId \n");
			sql.append("and n.noticeNo = ? \n");
//			System.out.println(sql.toString());
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, noticeNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				notice = new Notice();
				notice.setNoticeNo(rs.getInt("noticeNo"));
				notice.setMemberId(rs.getString("memberId"));
				notice.setMemberNickname(rs.getString("memberNickname"));
				notice.setNoticeTitle(rs.getString("noticeTitle").replace("<", "&lt;"));
				notice.setNoticeBody(rs.getString("noticeBody"));
				notice.setNoticeDate(rs.getString("noticeDate"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return notice;
	}

	public void modifyNotice(Notice notice) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update notice \n");
			sql.append("set noticeTitle = ?, noticeBody = ? \n");
			sql.append("where noticeNo = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeBody());
			pstmt.setInt(3, notice.getNoticeNo());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	public void deleteNotice(int noticeNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from notice \n");
			sql.append("where noticeNo = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, noticeNo);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}
}
