<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="${root}/index.jsp">홈으로 이동</a>
<c:choose>
	<c:when test="${userId==null}">
		<div><a href="${root}/user/login_form.do">로그인</a><a>회원가입</a></div>
	</c:when>
	<c:otherwise>
		<div>${userName}횐님 안농? <a href="${root}/auth/logout.do">로그아웃</a></div>
	</c:otherwise>
</c:choose>
<hr />