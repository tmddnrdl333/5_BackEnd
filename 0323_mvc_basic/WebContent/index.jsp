<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp입니당</title>
</head>
<body>

	<ul>
		<li><a href="<%=request.getContextPath() %>/dept/list.do">부서 목록 조회</a></li>
		<li><a href="<%=request.getContextPath() %>/dept/list.ssafy">부서 목록 조회</a></li>
		<li><a href="<%=request.getContextPath()%>/dept/regist.jsp">부서 등록</a></li>
	</ul>
</body>
</html>