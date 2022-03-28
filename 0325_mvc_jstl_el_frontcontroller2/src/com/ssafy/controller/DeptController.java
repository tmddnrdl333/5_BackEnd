package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;

public class DeptController implements Controller {

	DeptService deptService = new DeptService();

	@Override
	public PageInfo process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subUrl = request.getServletPath().substring(5);
		if (subUrl.equals("/list.do")) {
			return deptList(request, response);
		} else if (subUrl.equals("/detail.do")) {
			return deptDetail(request, response);
		} else if (subUrl.equals("/regist.do")) {
			return deptRegist(request, response);
		} else if (subUrl.equals("/regist_form.do")) {
			return deptRegistForm(request, response);
		} else if (subUrl.equals("/modify.do")) {
			return deptModify(request, response);
		} else if (subUrl.equals("/modify_form.do")) {
			return deptModifyForm(request, response);
		} else if (subUrl.equals("/remove.do")) {
			return deptRemove(request, response);
		}
		return null;
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

	private PageInfo deptModifyForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		DeptService deptService = new DeptService();
		try {
			Dept dept = deptService.getDept(deptNo);
			request.setAttribute("dept", dept);

			return new PageInfo(true, "/dept/modify.jsp");
		} catch (SQLException e) {
			// 에러페이지로 이동
			request.setAttribute("errorMsg", "부서 상세조회에 실패했습니다.");
			throw e;
		}

	}

	private PageInfo deptModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		String dName = request.getParameter("dName");
		String loc = request.getParameter("loc");
		try {
			deptService.modifyDept(new Dept(deptNo, dName, loc));
			// 성공페이지로 이동 => 부서 목록으로 이동 (부서목록 조회하는 컨트롤러로 이동)
			return new PageInfo(false, "/dept/list.do");
		} catch (Exception e) {
			// 에러페이지로 이동 =>
			request.setAttribute("errorMsg", "부서 수정에 실패했습니다.");
			throw e;
		}
	}

	private PageInfo deptRemove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		try {
			deptService.removeDept(deptNo);
			// 성공페이지로 이동 => 부서 목록으로 이동 (부서목록 조회하는 컨트롤러로 이동)
			return new PageInfo(false, "/dept/list.do");
		} catch (Exception e) {
			// 에러페이지로 이동 =>
			request.setAttribute("errorMsg", "부서 삭제에 실패했습니다.");
			throw e;
		}
	}
}
