<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${errorMsg!=null}">
		<div style="color: red">에러내용 : ${errorMsg}</div>
	</c:if>
	<form action="${root}/user/login.do"	method="post">
		id : <input type="text" name="id" /> <br />
		password : <input type="password" name="pass" /> <br />
		<input type="submit" value="로그인" />
		<input type="reset" value="취소" />
	</form>
</body>
</html>