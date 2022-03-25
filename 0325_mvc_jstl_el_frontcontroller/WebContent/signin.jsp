<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signin.jsp입니당</title>
</head>
<body>
	<c:if test="${errorMsg!=null}">
		<div style="color: red">에러내용 : ${errorMsg}</div>
	</c:if>
	<form action="${root}/user/signin.do"	method="post">
		id : <input type="text" name="id" /> <br />
		password : <input type="password" name="pass" /> <br />
		name : <input type="text" name="name" /> <br />
		email : <input type="email" name="email" /> <br />
		<input type="submit" value="회원가입" />
		<input type="reset" value="취소" />
	</form>
</body>
</html>