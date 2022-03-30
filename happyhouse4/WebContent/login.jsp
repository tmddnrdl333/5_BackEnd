<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

${errorMsg}

<c:if test="${errorMsg != null}">
	<div style="color:red">에러내용 : ${errorMsg}</div>
</c:if>

<!--로그인/ 로그아웃 페이지-->
<div class = "login" style="font-family: 'Jua', sans-serif; text-align: center;">
    <!-- <h1 class = "title" style="font-family: 'Jua', sans-serif;">로그인 페이지</h1> -->
    <hr>
    <form action="${pageContext.request.contextPath}/member/login.do">
    <p>아이디: <input id="memberId" type="text" name="memberId"/></p>
    <p>비밀번호: <input id="memberPassword" type="password" name="memberPassword"/></p>
    <div style="display: flex; flex-wrap: wrap; justify-content: center;"> 
        <input type="submit" id="login-btn" class="btn btn-primary m-1" value="로그인" />
        <input type="reset" class="btn btn-primary m-1" value="취소" />
        <input type="button" id="find-pw" class="btn btn-secondary m-1" value="비밀번호찾기" formaction="${pageContext.request.contextPath}/sign/find_pw.jsp"/>
    </div>    
    </form>
    <hr>
</div>

<%@ include file="/footer.jsp" %>