package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.PageInfo;

// sub controller가 지녀야하는 기능에 대한 interface
public interface Controller {
	public PageInfo process(HttpServletRequest request, HttpServletResponse response) throws Exception ;
}
