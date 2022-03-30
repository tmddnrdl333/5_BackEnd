package model.service;
import java.sql.SQLException;
import java.util.List;

import model.dao.BusinessinfoDAO;
import model.dao.HousedealDAO;
import model.dao.HouseinfoDAO;
import model.dto.Businessinfo;
import model.dto.Housedeal;
import model.dto.Houseinfo;

public class HouseService {

	private HouseinfoDAO houseinfoDao = new HouseinfoDAO();
	private HousedealDAO housedealDao = new HousedealDAO();
	private BusinessinfoDAO businessinfoDao = new BusinessinfoDAO();

	public List<Houseinfo> getHouseinfoList(String dongCode) throws SQLException {
		return houseinfoDao.selectHouseinfoByDongCode(dongCode);
	}

	public List<Housedeal> getHousedeal(int aptCode) throws SQLException {
		return housedealDao.selectHousedealByAptCode(aptCode);
	}

	public List<Businessinfo> getBusinessinfo(String dongCode) throws SQLException {
		return businessinfoDao.selectBusinessinfoByDongCode(dongCode);
	}
}
