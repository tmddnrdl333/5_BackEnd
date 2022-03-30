<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
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

// 전화번호 길이 형식?
function phonenumber() {
  let phonenum = $('#memberPhone').val();
  if (phonenum.length != 11 && phonenum.length != 0) {
    alert('전화번호를 제대로 입력해주세요.');
    $('#memberPhone').val('');
  }
}

$(function () {
  // 중복체크 버튼
  $('#dupcheck').click(dupcheck);
</script>
    <!-- 회원정보 등록, 수정, 삭제, 조회 페이지 Start -->
    <div id="findpage" style="text-align: center; font-family: 'Jua', sans-serif">
     <form action="${pageContext.request.contextPath}/member/signup.do" method="post">
	   <div style="text-align: center; font-weight: bold; font-size: larger; margin: 10px;">회원가입</div>
	   <div class="container" style="font-family: 'Jua', sans-serif;">
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberId" >ID : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="text" id="memberId" name="memberId" placeholder="User ID"/>
	           <button type="button" id="dupcheck" class="btn btn-primary">중복체크</button>
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberPassword">PW : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="password" id="memberPassword" name="memberPassword" maxlegth="10" onblur="lengthCheck()" placeholder=" 영문 숫자 포함 6자리 이상" />
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberName">이름 : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="text" id="memberName" name="memberName" placeholder=" User Name" />
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberNickname">닉네임 : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="text" id="memberNickname" name="memberNickname" placeholder=" User NickName" />
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberEmail">이메일 : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="email" id="memberEmail" name="memberEmail" placeholder=" email" />
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberPhone">전화번호 : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="text" id="memberPhone" name="memberPhone" onblur="phonenumber()" placeholder=" 010-0000-0000" />
	         </div>
	       </div>
	     </div>
	     <div class="m-2">
	       <div class="row">
	         <label class="col-sm-5" style="text-align: end;" for="memberAddress">주소 : </label>
	         <div class="col-sm-7" style="text-align: left;">
	           <input type="text" id="memberAddress" name="memberAddress" placeholder=" address" />
	         </div>
	       </div>
	     </div>
	     <div class="justify-content-center" style="text-align: center;">
	       	<input type = "submit" class="btn btn-success" value="회원가입" >
			<input type = "reset" class="btn btn-success" value="초기화" >
	     </div>
	   </div>
     </form>
</div>
    <!-- 회원가입 End -->

<%@ include file="/footer.jsp" %>
