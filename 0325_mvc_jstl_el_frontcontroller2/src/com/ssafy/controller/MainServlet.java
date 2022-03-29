package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.PageInfo;

@WebServlet(value = "*.do", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserController userController = new UserController();
	DeptController deptController = new DeptController();

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
			Object resInfo = null;
			System.out.println("url : " + url);

			if (url.startsWith("/dept")) {
				HttpSession session = request.getSession();
				if (session.getAttribute("userId") == null) {
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
			}

			if (url.startsWith("/user")) {
				resInfo = userController.process(request, response);
			} else if (url.startsWith("/dept")) {
				resInfo = deptController.process(request, response);
			}
			
			if(resInfo instanceof PageInfo) {
				PageInfo pageInfo = (PageInfo) resInfo;
				if (pageInfo.isForward()) {
					request.getRequestDispatcher(pageInfo.getUrl()).forward(request, response);
					return;
				} else {
					response.sendRedirect(request.getContextPath() + pageInfo.getUrl());
					return;
				}				
			} else {
				DataInfo dataInfo = (DataInfo) resInfo;
				String contentType = dataInfo.getContentType();
				
				response.setContentType(contentType);
				if(contentType.startsWith("application/json")) {
					Gson gson = new Gson();
					response.getWriter().println(gson.toJson(dataInfo.getData()));
				}
			}
			


		} catch (Exception e) {
			// 에러 페이지로 이동
			e.printStackTrace();
			request.setAttribute("exception", e);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}

	}

}
