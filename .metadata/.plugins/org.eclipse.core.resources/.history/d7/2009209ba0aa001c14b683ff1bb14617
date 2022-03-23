<%@page import="com.ssafy.model.dto.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/table1.css"
	rel="stylesheet">
</head>
<body>
	<h1>부서 목록</h1>
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Dept> list = (List<Dept>) request.getAttribute("deptList");
				for (Dept dept : list) {
			%>
			<tr>
				<td><%=dept.getDeptno()%></td>
				<td><%=dept.getDname()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>