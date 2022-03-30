package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.Member;
import model.dto.PageInfo;
import model.service.MemberService;

public class MemberController implements Controller{

	MemberService memberService = new MemberService();
	@Override
	public PageInfo process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subUrl = request.getServletPath().substring(7);
		if(subUrl.equals("/login.do")) {
			return login(request, response);
		}else if(subUrl.equals("/logout.do")) {
			return logout(request, response);
		}else if(subUrl.equals("/loginForm.do")) {
			return loginForm(request, response);
		}else if(subUrl.equals("/signup.do")) {
			return signup(request, response);
		}else if(subUrl.equals("/signupForm.do")) {
			return signupForm(request, response);
		}else if(subUrl.equals("/delete.do")) {
			return delete(request,response);
		}else if(subUrl.equals("/mypage.do")) {
			return mypage(request, response);
		}else if(subUrl.equals("/modify.do")) {
			return modify(request, response);
		}
		return null;
	}

	private PageInfo login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		try {
			String memberNickname = memberService.login(memberId, memberPassword);
			if(memberNickname != null) {
				HttpSession session = request.getSession();
				session.setAttribute("memberId", memberId);
				session.setAttribute("memberNickname", memberNickname);				
				return new PageInfo(false, "/index.jsp");
			}else {
				request.setAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
				return new PageInfo(true, "/login.jsp");
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", "로그인 실행 중 문제가 발생하였습니다.");
			throw e;
		}
	}
	
	private PageInfo loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(true, "/login.jsp");
	}
	
	private PageInfo logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		return new PageInfo(false, "/index.jsp");
	}
	
	private PageInfo signupForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(true, "/sign/signup.jsp");
	}
	
	private PageInfo signup(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		String memberName = request.getParameter("memberName");
		String memberNickname = request.getParameter("memberNickname");
		String memberEmail = request.getParameter("memberEmail");
		String memberPhone = request.getParameter("memberPhone");
		String memberAddress = request.getParameter("memberAddress");
		
		try {
			// 회원가입 성공
			memberService.signup(new Member(memberId, memberPassword, memberName, memberNickname, memberEmail, memberPhone, memberAddress));
			return new PageInfo(true, "/index.jsp");
		}catch(Exception e) {
			// 회원가입 실패
			request.setAttribute("errorMsg", "이미 등록된 회원입니다.");
			return new PageInfo(false, "/login.jsp");
		}
		
	}
	
	private PageInfo delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      String memberId = (String) request.getSession().getAttribute("memberId");
	      try {
	    	  memberService.delete(memberId);
	         request.getSession().invalidate();
	         return new PageInfo(false, "/index.jsp");
	      } catch (SQLException e) {
	         request.setAttribute("errorMsg", "회원탈퇴에 실패하였습니다.");
	         return new PageInfo(true, "/error.jsp");
	      }
	}
	
	private PageInfo mypage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memberId = (String) request.getSession().getAttribute("memberId");
		try{
			Member member = memberService.mypage(memberId);
			request.setAttribute("member", member);
			return new PageInfo(true, "/sign/mypage.jsp");
		}catch(SQLException e) {
			request.setAttribute("errorMsg", "에러 발생");
			return new PageInfo(true, "/index.jsp");
		}
	}
	
	private PageInfo modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		String memberName = request.getParameter("memberName");
		String memberNickname = request.getParameter("memberNickname");
		String memberEmail = request.getParameter("memberEmail");
		String memberPhone = request.getParameter("memberPhone");
		String memberAddress = request.getParameter("memberAddress");
		
		try {
			memberService.modify(new Member(memberId, memberPassword, memberName, memberNickname, memberEmail, memberPhone, memberAddress));
			return new PageInfo(true, "/index.jsp");
		}catch(Exception e) {
			request.setAttribute("errorMsg", "수정 불가");
			return new PageInfo(true, "/index.jsp");
		}
	}
}