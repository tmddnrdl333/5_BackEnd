<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
<script>
      $(document).ready(function () {
          $('#reset-pw').click(function(){
              let id = $('#id').val();
              let name = $('#name').val();
              let phone = $('#phone').val();
              if(id==='id'&&name==='name'&&phone==='01000000000'){
                  console.log('새 비밀번호를 이메일로 전송했습니다.');
              }
          });


          $('#search-in').on('keypress', function(e){ 
              if(e.keyCode == '13'){ 
                  $('#search-btn').click(); 
              } 
          });
          $("#search-btn").one('click', function () {
          });
      });
</script>
        
    <!--로그인/ 로그아웃 페이지-->
    <div id="findpage" class = "login" style="text-align: center; font-family: 'Jua', sans-serif">
    
        <div style="text-align: center; font-weight: bold; font-size: larger; margin: 10px;">비밀번호 찾기</div>
    </div>
    <div class="container" style="font-family: 'Jua', sans-serif;">
        <div class="m-2">
          <div class="row">
            <div class="col-sm-5" style="text-align: end;">ID : </div>
            <div class="col-sm-7">
              <input type="text" id="id" placeholder="User ID"/>
              <button type="button" id="dupcheck" class="btn btn-primary">중복체크</button>
            </div>
          </div>
        </div>
        <div class="m-2">
          <div class="row">
            <div class="col-sm-5" style="text-align: end;">이름 : </div>
            <div class="col-sm-7">
              <input type="text" id="name" placeholder=" User Name" />
            </div>
          </div>
        </div>
        <div class="m-2">
          <div class="row">
            <div class="col-sm-5" style="text-align: end;">전화번호 : </div>
            <div class="col-sm-7">
              <input type="text" id="phone" onblur="phonenumber()" placeholder=" 010-0000-0000" />
            </div>
          </div>
        </div>
        <div class="justify-content-center" style="text-align: center;">
          <button type="button" id="reset-pw" class="btn btn-success">비밀번호 재설정</button>
        </div>
      </div>

<%@ include file="/footer.jsp" %>