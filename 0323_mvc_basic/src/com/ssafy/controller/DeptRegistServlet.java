package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

@WebServlet("/dept/regist.do")
public class DeptRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		String dName = request.getParameter("dName");
		String loc = request.getParameter("loc");

		DeptService deptService = new DeptService();
		try {
			deptService.registDept(new Dept(deptNo, dName, loc));
			// 성공페이지로 이동 => 부서 목록으로 이동 (부서목록 조회하는 컨트롤러로 이동)

			// forwarding으로 가면 에러 남. (405 : 포워드는 이전 method 그대로 이어서 주기 때문)
			response.sendRedirect(request.getContextPath() + "/dept/list.do");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			// 에러페이지로 이동 =>
			request.setAttribute("exception", e);
			request.setAttribute("errorMsg", "부서 등록에 실패했습니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
	}

}
