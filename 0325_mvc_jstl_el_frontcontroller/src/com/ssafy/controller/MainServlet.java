package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.UserService;

@WebServlet(value = "*.do", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DeptService deptService = new DeptService();

	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("root", getServletContext().getContextPath());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 공통 전처리로직 코드

		// 요청 url에 따른 요청처리 컨트롤러 분기처리
		try {
			String url = request.getServletPath();
			PageInfo pageInfo = null;
			System.out.println("url : " + url);
			if (url.equals("/user/login.do")) {
				pageInfo = login(request, response);
			} else if (url.equals("/user/login_form.do")) {
				pageInfo = loginForm(request, response);
			} else if (url.equals("/auth/logout.do")) {
				pageInfo = logout(request, response);
			} else if (url.equals("/dept/list.do")) {
				pageInfo = deptList(request, response);
			} else if (url.equals("/dept/detail.do")) {
				pageInfo = deptDetail(request, response);
			} else if (url.equals("/dept/regist.do")) {
				pageInfo = deptRegist(request, response);
			} else if (url.equals("/dept/regist_form.do")) {
				pageInfo = deptRegistForm(request, response);
			}

			if (pageInfo.isForward()) {
				request.getRequestDispatcher(pageInfo.getUrl()).forward(request, response);
				return;
			} else {
				response.sendRedirect(request.getContextPath() + pageInfo.getUrl());
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// 에러 페이지로 이동
			e.printStackTrace();
			request.setAttribute("exception", e);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}

		// 공통 후처리로직 코드

	}

	private PageInfo login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		UserService userService = new UserService();
		try {
			String name = userService.login(id, pass);
			if (name != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", id);
				session.setAttribute("userName", name);
				return new PageInfo(false, "/index.jsp");
			} else {
				request.setAttribute("errorMsg", "아이디나 비밀번호가 일치하지 않습니다.");
				return new PageInfo(true, "/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	private PageInfo deptList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			List<Dept> list = deptService.getDeptList();
			request.setAttribute("deptList", list);

			return new PageInfo(true, "/dept/list.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			// 에러페이지로 이동 =>
			request.setAttribute("errorMsg", "부서 목록조회에 실패했습니다.");
			throw e;
		}
	}

	private PageInfo deptDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		DeptService deptService = new DeptService();
		try {
			Dept dept = deptService.getDept(deptNo);
			request.setAttribute("dept", dept);

			return new PageInfo(true, "/dept/detail.jsp");
		} catch (SQLException e) {
			// 에러페이지로 이동
			request.setAttribute("errorMsg", "부서 상세조회에 실패했습니다.");
			throw e;
		}
	}

	private PageInfo deptRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		String dName = request.getParameter("dName");
		String loc = request.getParameter("loc");

		try {
			deptService.registDept(new Dept(deptNo, dName, loc));
			// 성공페이지로 이동 => 부서 목록으로 이동 (부서목록 조회하는 컨트롤러로 이동)
			return new PageInfo(false, "/dept/list.do");
		} catch (Exception e) {
			// 에러페이지로 이동 =>
			request.setAttribute("errorMsg", "부서 등록에 실패했습니다.");
			throw e;
		}
	}

	private PageInfo deptRegistForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(true, "/dept/regist.jsp");
	}
	
	
}
