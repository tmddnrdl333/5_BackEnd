<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
<script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
    <script>
      // ID 중복체크
      function dupcheck() {
        let id = $('#memberId').val();
        if (memberId === 'hi') {
          alert('중복된 아이디입니다.');
          $('#memberId').val('');
        }
      }

      // 영문 숫자 포함 6자리 이상
      function lengthCheck() {
        let pw = $('#memberPassword').val();
        if (pw.length != 0 && pw.length < 6) {
          alert('비밀번호가 너무 짧습니다.');
          $('#memberPassword').val('');
        }
      }

      // 전화번호 길이 형식
      function phonenumber() {
        let phonenum = $('#memberPhone').val();
        if (phonenum.length != 11 && phonenum.length != 0) {
          alert('전화번호를 제대로 입력해주세요.');
          $('#memberPhone').val('');
        }
      }
</script>
<!-- 회원정보 등록, 수정, 삭제, 조회 페이지 Start -->
<div style="text-align: center; font-family: 'Jua', sans-serif">

     <form action="${pageContext.request.contextPath}/member/modify.do" method="post">
	   <div style="text-align: center; font-weight: bold; font-size: larger; margin: 10px;">마이페이지</div>
	   <div class="container" style="font-family: 'Jua', sans-serif;">
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberId" >ID : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="text" id="memberId" name="memberId" value="${member.memberId}" />
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberPassword">PW : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="password" id="memberPassword" name="memberPassword" maxlegth="10" value="${member.memberPassword}" />
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberName">이름 : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="text" id="memberName" name="memberName" value="${member.memberName}"/>
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberNickname">닉네임 : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="text" id="memberNickname" name="memberNickname" value="${member.memberNickname}" />
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberEmail">이메일 : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="email" id="memberEmail" name="memberEmail" value="${member.memberEmail}" />
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberPhone">전화번호 : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="text" id="memberPhone" name="memberPhone" value="${member.memberPhone}"/>
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberAddress">주소 : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="text" id="memberAddress" name="memberAddress" value="${member.memberAddress}"/>
	         </div>
	       </div>
	     </div>
	     <div class="justify-content-center" style="text-align: center;">
			<input type = "submit" class="btn btn-success" value="수정" >
			<input type = "reset" class="btn btn-success" value="초기화" >
			<a type = "button" class="btn btn-success" value="회원탈퇴" href="${pageContext.request.contextPath}/member/delete.do">회원탈퇴</a>
	     </div>
	   </div>
     </form>
</div>
<!-- 회원가입 End -->

<%@ include file="/footer.jsp" %>
