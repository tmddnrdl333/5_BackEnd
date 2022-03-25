<%@page import="com.ssafy.model.dto.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp입니당</title>
<link href="${root}/css/table1.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/menu.jsp"></jsp:include>
	<h1>부서 목록</h1>
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${not empty deptList}">
				<c:forEach items="${deptList}" var="dept">
					<tr>
						<td>${dept.deptno}</td>
						<td><a href="${root}/dept/detail.do?deptNo=${dept.deptno}">${dept.dname}</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="2">등록된 부서 정보가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
			
		</tbody>
	</table>
</body>
</html>