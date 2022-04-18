package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Dept;

public interface DeptDAO {

	// DAO에서 예외가 발생했을 때, try-catch해주면 안되고 throw해서 controller가 처리하게 해줘야 함.
	boolean insertDept0(Dept dept) throws SQLException;

	boolean insertDept(Dept dept) throws SQLException;

	Dept selectDept(int deptNo) throws SQLException;

	List<Dept> selectDeptList() throws SQLException;

	boolean deleteDept(int deptNo) throws SQLException;

	boolean updateDept(Dept dept) throws SQLException;

	// 부서이름을 이용하여 포함검색한 부서리스트 리턴
	List<Dept> selectDeptListByName(String dName) throws SQLException;

}