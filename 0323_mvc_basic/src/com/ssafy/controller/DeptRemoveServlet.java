package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.service.DeptService;

@WebServlet("/dept/remove.do")
public class DeptRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeptService deptService = new DeptService();
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		try {
			deptService.removeDept(deptNo);
			// success
			response.sendRedirect(request.getContextPath() + "/dept/list.do");
			return;
		} catch (SQLException e) {
			// error
			e.printStackTrace();
			request.setAttribute("exception", e);
			request.setAttribute("errorMsg", "부서 삭제에 실패했습니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
	}

}
