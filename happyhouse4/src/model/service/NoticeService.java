package model.service;

import java.util.List;

import model.dao.NoticeDAO;
import model.dto.ListParameterDto;
import model.dto.Notice;
import util.PageNavigation;

public class NoticeService {

	private NoticeDAO noticeDao = new NoticeDAO();
	
	public void registerNotice(Notice notice) throws Exception {
		noticeDao.registerNotice(notice);
	}
	
	public List<Notice> listNotice(String pg, String key, String word) throws Exception {
		int pgno = pg != null ? Integer.parseInt(pg) : 1;
		int countPerPage = 10;
		int start= (pgno - 1) * countPerPage;
		
		ListParameterDto listParameterDto = new ListParameterDto();
		listParameterDto.setKey(key == null ? "" : key.trim());
		listParameterDto.setWord(word == null ? "" : word.trim());
		listParameterDto.setStart(start);
		listParameterDto.setCurrentPerPage(countPerPage);
		return noticeDao.listNotice(listParameterDto);
	}
	
	public PageNavigation makePageNavigation(String pg, String key, String word) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();
		int currentPage = pg != null ? Integer.parseInt(pg) : 1;
		int naviSize = 5;
		int countPerPage = 10;
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setCountPerPage(countPerPage);
		pageNavigation.setNaviSize(naviSize);
		
		ListParameterDto listParameterDto = new ListParameterDto();
		listParameterDto.setKey(key == null ? "" : key.trim());
		listParameterDto.setWord(word == null ? "" : word.trim());
		
		int totalCount = noticeDao.getTotalCount(listParameterDto);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / countPerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setStartRange(currentPage <= naviSize);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}
	
	public Notice getNotice(int noticeNo) throws Exception {
		return noticeDao.getNotice(noticeNo);
	}
	
	public void modifyNotice(Notice notice) throws Exception {
		noticeDao.modifyNotice(notice);
	}
	
	public void deleteNotice(int noticeNo) throws Exception {
		noticeDao.deleteNotice(noticeNo);
	}
}
