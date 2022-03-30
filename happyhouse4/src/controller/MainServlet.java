package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.PageInfo;

@WebServlet(value = "*.do",loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MemberController memberController = new MemberController();
	NoticeController noticeController = new NoticeController();
	HouseController houseController = new HouseController();
	
	@Override
	public void init() throws ServletException {
		System.out.println("init..");
		getServletContext().setAttribute("root", getServletContext().getContextPath());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통 전처리로직 코드
		
		// 요청 url에 따른 요청처리 컨트롤러 분기처리 
		try {
			String url = request.getServletPath();
			PageInfo pageInfo = null;
			System.out.println("url : "+url);
			
			if(url.startsWith("/notice")) { // 로그인이 필요한 기능
				HttpSession session = request.getSession();
				if(session.getAttribute("memberId") == null) {
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
			}
			
			if(url.startsWith("/member")) {
				pageInfo = memberController.process(request, response);
			}else if(url.startsWith("/notice")) {
				pageInfo = noticeController.process(request, response);
			}else if (url.startsWith("/house")) {
				pageInfo = houseController.process(request, response);
			}
			
			if(pageInfo.isForward()) {
				request.getRequestDispatcher(pageInfo.getUrl()).forward(request, response);
				return;
			}else {
				response.sendRedirect(request.getContextPath()+pageInfo.getUrl());
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// 에러페이지로 이동
			request.setAttribute("exception", e );
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		// 공통 후처리로직코드
	}


}
