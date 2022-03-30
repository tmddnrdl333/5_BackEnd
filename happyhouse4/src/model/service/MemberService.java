package model.service;

import java.sql.SQLException;

import model.dao.MemberDAO;
import model.dto.Member;

public class MemberService {

	private MemberDAO memberDao = new MemberDAO();
	
	public String login(String memberId,String memberPassword) throws SQLException {
		return memberDao.login(memberId, memberPassword);
	}
	
	public boolean signup(Member member) throws SQLException {
		return memberDao.signup(member);
	}
	
	public boolean delete(String memberId) throws SQLException {
		return memberDao.delete(memberId);
	}
	
	public Member mypage(String memberId) throws SQLException{
		return memberDao.mypage(memberId);
	}
	
	public boolean modify(Member member) throws SQLException {
		return memberDao.modify(member);
	}
}
