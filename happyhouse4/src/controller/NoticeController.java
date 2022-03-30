package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.Member;
import model.dto.Notice;
import model.dto.PageInfo;
import model.service.NoticeService;
import util.PageNavigation;

public class NoticeController implements Controller{

	NoticeService noticeService = new NoticeService();
	
	@Override
	public PageInfo process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subUrl = request.getServletPath().substring(7);
		
		if(subUrl.equals("/mvregister.do")) {
			return mvRegisterNotice(request, response);
		}else if(subUrl.equals("/register.do")) {
			return registerNotice(request, response);
		}else if(subUrl.equals("/list.do")) {
			return listNotice(request, response);
		}else if(subUrl.equals("/mvmodify.do")) {
			return getNotice(request, response);
		}else if(subUrl.equals("/modify.do")) {
			return modifyNotice(request, response);
		}else if(subUrl.equals("/delete.do")) {
			return deleteNotice(request,response);
		}
		return null;
	}

	private PageInfo mvRegisterNotice(HttpServletRequest request, HttpServletResponse response) {
		return new PageInfo(false, "/notice/write.jsp");
	}

	private PageInfo registerNotice(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		String memberNickname = (String) session.getAttribute("memberNickname");

		Notice notice = new Notice();
		notice.setMemberId(memberId);
		notice.setMemberNickname(memberNickname);
		notice.setNoticeTitle(request.getParameter("noticeTitle"));
		notice.setNoticeBody(request.getParameter("noticeBody"));
		try {
			noticeService.registerNotice(notice);
			return new PageInfo(true, "/notice/writesuccess.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "글 작성중 에러가 발생했습니다.");
			return new PageInfo(true, "/index.jsp");
		}

	}

	private PageInfo listNotice(HttpServletRequest request, HttpServletResponse response) {
		String pg = request.getParameter("pg");
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		try {
			List<Notice> list = noticeService.listNotice(pg, key, word);
			PageNavigation navigation = noticeService.makePageNavigation(pg, key, word);
			request.setAttribute("notices", list);
			request.setAttribute("navi", navigation);
			request.setAttribute("key", key);
			request.setAttribute("word", word);
			return new PageInfo(true, "/notice/list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "글목록 얻기중 에러가 발생했습니다.");
			return new PageInfo(true, "/index.jsp");
		}
	}

	private PageInfo getNotice(HttpServletRequest request, HttpServletResponse response) {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		try {
			Notice notice = noticeService.getNotice(noticeNo);
			request.setAttribute("notice", notice);
			return new PageInfo(true, "/notice/modify.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "글 얻기중 에러가 발생했습니다.");
			return new PageInfo(true, "/index.jsp");
		}
	}

	private PageInfo modifyNotice(HttpServletRequest request, HttpServletResponse response) {
		Notice notice = new Notice();
		notice.setNoticeNo(Integer.parseInt(request.getParameter("noticeNo")));
		notice.setNoticeTitle(request.getParameter("noticeTitle"));
		notice.setNoticeBody(request.getParameter("noticeBody"));
		try {
			noticeService.modifyNotice(notice);
			return new PageInfo(false, "/notice/writesuccess.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "글 수정중 에러가 발생했습니다.");
			return new PageInfo(true, "/index.jsp");
		}
	}

	private PageInfo deleteNotice(HttpServletRequest request, HttpServletResponse response) {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		try {
			noticeService.deleteNotice(noticeNo);
			return new PageInfo(false, "/notice/list.do");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "글 삭제중 에러가 발생했습니다.");
			return new PageInfo(true, "/index.jsp");
		}
	}
}