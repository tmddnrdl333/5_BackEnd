<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <a href="${pageContext.request.contextPath}/index.jsp">메인페이지로 이동</a> -->
<c:choose>
	<c:when test="${memberId == null}">
		<!-- <a href="${pageContext.request.contextPath}/loginForm.do">로그인하기</a> -->
        <ul class="navbar-nav ms-auto my-2 my-lg-0">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/loginForm.do">Login</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/signupForm.do">Sign Up</a></li>
        </ul>
	</c:when>
	<c:otherwise>
		<!-- <a href="${pageContext.request.contextPath}/logout.do">로그아웃하기</a> -->
		<ul class="navbar-nav ms-auto my-2 my-lg-0">
			<h6 style="font-family: 'Jua', sans-serif; font-size: 20px;">${memberNickname}님이 로그인 되었습니다. </h6>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/logout.do">Logout</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/mypage.do">My Page</a></li>
        </ul>
	</c:otherwise>
</c:choose>
</hr>



                   