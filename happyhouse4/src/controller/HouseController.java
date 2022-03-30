package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Businessinfo;
import model.dto.Housedeal;
import model.dto.Houseinfo;
import model.dto.PageInfo;
import model.service.HouseService;

public class HouseController implements Controller {

	HouseService houseService = new HouseService();

	@Override
	public PageInfo process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subUrl = request.getServletPath().substring(6); // '/house'~
		if (subUrl.equals("/dong_search.do")) {
			return dongbyul(request, response);
		} else if (subUrl.equals("/dong_list.do")) {
			return dongList(request, response);
		} else if (subUrl.equals("/apt_list.do")) {
			return aptbyul(request, response);
		} else if (subUrl.equals("/interest_list.do")) {
			return interest(request, response);
		}
		return null;
	}

	// 동을 선택하면 그 동에 있는 아파트들을 다 보여줌
	private PageInfo dongbyul(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(false, "/search/dong_search.jsp");
	}

	private PageInfo dongList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dongCode = request.getParameter("dongCode");
		try {
			List<Houseinfo> list = houseService.getHouseinfoList(dongCode);
			request.setAttribute("houseinfoList", list);

			return new PageInfo(true, "/search/dong_list.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "동별 조회에 실패했습니다.");
			throw e;
		}
	}

	// 선택된 동에 나열된 아파트들 중 하나를 고르면 정보를 보여줌
	private PageInfo aptbyul(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int aptCode = Integer.parseInt(request.getParameter("aptCode"));
		request.setAttribute("aptName", request.getParameter("aptName"));
		try {
			List<Housedeal> list = houseService.getHousedeal(aptCode);
			request.setAttribute("housedealList", list);

			return new PageInfo(true, "/search/apt_list.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "아파트별 조회에 실패했습니다.");
			throw e;
		}
	}

	// 관심지역 정보
	private PageInfo interest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dongCode = request.getParameter("dongCode");
		try {
			List<Businessinfo> businessinfo = houseService.getBusinessinfo(dongCode);
			request.setAttribute("businessinfo", businessinfo);

			return new PageInfo(true, "interest_list.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "관심지역 상가 조회에 실패했습니다.");
			throw e;
		}
	}
}
