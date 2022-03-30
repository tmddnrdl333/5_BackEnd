<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

<%@ include file="/map.jsp" %>
       
<!-- 아파트별 실거래가 조회 결과 페이지-->
<div id="number_search" style="text-align: center; margin: 30px auto;">
    <h2 style="font-family: 'Jua', sans-serif; font-size: 50px;">아파트 동별 실거래가 조회하기</h2>
</div>
<form action="${pageContext.request.contextPath}/house/dong_list.do" method="post">
	<div style="text-align: center; margin: 20px auto;display: flex;  width: 50%; justify-content: space-evenly;">
	    <p style="font-family: 'Jua', sans-serif; font-size: 25px; margin: auto;">주소로 검색하기</p>
	    <select id="sidocode" name="" style="font-family: 'Jua', sans-serif; font-size: 20px; flex: 1; margin: 0px 20px; padding: 2px;">
	      <!-- 임시 데이터 -->
	      <option value="">없음</option>
	      <option value="">서울특별시</option>
	    </select><br/>
	    <select id="guguncode" name="" style="font-family: 'Jua', sans-serif; font-size: 20px; flex: 1; margin: 0px 10px;">
	
	      <option value="">없음</option>
	      <option value="">종로구</option>
	    </select>
	    <select id="dongcode" name="dongCode" style="font-family: 'Jua', sans-serif; font-size: 20px; flex: 1; margin: 0px 10px;">
	      <option value="">없음</option>
	      <option value="1111011800">내수동</option>
	      <option value="1111017400">창신동</option>
	      <option value="1111017500">숭인동</option>
	      <option value="1111018700">무악동</option>
	    </select>
	    <input type="submit" value="조회하기" class="btn btn-light" style="font-family: 'Jua', sans-serif; font-size: medium;">
	    <br/>
	</div>
</form>

        
<%@ include file="/footer.jsp" %>
