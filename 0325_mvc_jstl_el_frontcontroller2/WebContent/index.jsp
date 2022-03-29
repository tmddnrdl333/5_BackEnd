<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp입니당</title>
</head>
<body>
	<jsp:include page="/menu.jsp"></jsp:include>
	<ul>
		<li><a href="${root}/dept/list.do">부서 목록 조회</a></li>
		<li><a href="${root}/dept/rest/list.do">부서 목록 조회-Rest</a></li>
		<li><a href="${root}/dept/rest/detail.do?deptNo=10">부서 목록 조회-Rest 10</a></li>
		<li><a href="${root}/dept/regist_form.do">부서 등록</a></li>
	</ul>
</body>
</html>