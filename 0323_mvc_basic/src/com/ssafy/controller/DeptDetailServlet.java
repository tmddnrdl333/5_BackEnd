package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

@WebServlet("/dept/detail.do")
public class DeptDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		DeptService deptService = new DeptService();
		try {
			Dept dept = deptService.getDept(deptNo);
			request.setAttribute("dept", dept);
			request.getRequestDispatcher("/dept/detail.jsp").forward(request, response);
			return;
		} catch (SQLException e) {
			// 에러페이지로 이동
			request.setAttribute("exception", e);
			request.setAttribute("errorMsg", "부서 상세조회에 실패했습니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}

	}

}
