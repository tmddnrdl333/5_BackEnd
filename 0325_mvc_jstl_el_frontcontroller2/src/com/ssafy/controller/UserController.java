package com.ssafy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.dto.User;
import com.ssafy.model.service.UserService;

public class UserController implements Controller {

	UserService userService = new UserService();

	@Override
	public PageInfo process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subUrl = request.getServletPath().substring(5);
		if (subUrl.equals("/login.do")) {
			return login(request, response);
		} else if (subUrl.equals("/logout.do")) {
			return logout(request, response);
		} else if (subUrl.equals("/login_form.do")) {
			return loginForm(request, response);
		} else if (subUrl.equals("/signin_form.do")) {
			return signinForm(request, response);
		} else if (subUrl.equals("/signin.do")) {
			return signin(request, response);
		} else if (subUrl.equals("/userinfo.do")) {
			return userInfo(request, response);
		}
		return null;
	}

	private PageInfo login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		try {
			String name = userService.login(id, pass);
			if (name != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", id);
				session.setAttribute("userName", name);
				return new PageInfo(false, "/index.jsp");
			} else {
				request.setAttribute("errorMsg", "아이디나 비밀번호가 일치하지 않습니다.");
				return new PageInfo(true, "/user/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "로그인 실행 중 문제가 발생하였습니다.");
			throw e;
		}
	}

	private PageInfo loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(false, "/user/login.jsp");
	}

	private PageInfo logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		return new PageInfo(false, "/index.jsp");
	}

	private PageInfo signinForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(false, "/user/signin.jsp");
	}

	private PageInfo signin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		User user = new User(id, pass, name, email);

		UserService userService = new UserService();
		try {
			userService.signin(user);
			return new PageInfo(false, "/index.jsp");
		} catch (Exception e) {
			// 에러페이지로 이동 =>
			request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
			throw e;
		}
	}

	private PageInfo userInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserService userService = new UserService();
		String id = (String) request.getSession().getAttribute("userId");
		System.out.println(userService.userInfo(id));
		request.setAttribute("userinfo", userService.userInfo(id));
		return new PageInfo(true, "/auth/userinfo.jsp");
	}

	// 회원정보수정 그냥 userinfo에서 바로 할 건지 아니면 따로 또 페이지 만들건지 (비밀번호 수정 때문에..ㅋㅋ 근데 안해도 어차피
	// 기능적인 부분은 확인 될듯)
	// 그리고 service랑 dao에도 추가해줘야 실행될듯ㄴ
//	private PageInfo userInfoModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		UserService userService = new UserService();
//		String name = "";
//		String email = "";
//		System.out.println(userService.userInfo(id));
//		request.setAttribute("userinfo", userService.userInfo(id));
//		return new PageInfo(true, "/auth/userinfo.jsp");
//	}

}
