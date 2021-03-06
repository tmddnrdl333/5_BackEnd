package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

// @WebServlet("/dept/list.do") // xml에 list.ssafy도 추가했음.
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeptService deptService = new DeptService();
		try {
			List<Dept> list = deptService.getDeptList();
			request.setAttribute("deptList", list);

			request.getRequestDispatcher("/dept/list.jsp").forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			// 에러페이지로 이동 =>
			request.setAttribute("exception", e);
			request.setAttribute("errorMsg", "부서 목록조회에 실패했습니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}

	}

}
