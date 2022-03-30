<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp"%>

<%@ include file="/map.jsp"%>

<!-- 아파트별 실거래가 조회 결과 페이지-->
<div id="number_search" style="text-align: center; margin: 30px auto;">
	<h2 style="font-family: 'Jua', sans-serif;">${aptName} 조회 결과</h2>
</div>
<div style="text-align: center; margin: 20px auto; width: 40%;">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>거래년도</th>
				<th>거래일</th>
				<th>거래액(만원)</th>				
			</tr>
		</thead>
		<tbody>
			<% int i = 1; %>
			<c:forEach var="hd" items="${housedealList}">
				<tr>
					<td><%=i++%></td>
					<td>${hd.dealYear}년</td>
					<td>${hd.dealMonth}월${hd.dealDay}일</td>
					<td>${hd.dealAmount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="/footer.jsp"%>
