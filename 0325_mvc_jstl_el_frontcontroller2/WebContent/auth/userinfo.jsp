<%@page import="com.ssafy.model.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userinfo.jsp입니당</title>
<link href="${root}/css/table1.css" rel="stylesheet">
</head>
<body>
	<h2>회원정보</h2>
	<form action="${root}/auth/userinfo_modify.do" method="post">
		<table>
			<tbody>
				<tr>
					<th>ID :</th>
					<td><input type="text" name="id" readonly="readonly" value="${requestScope.userinfo.id}"/></td>
				</tr>
				<tr>
					<th>이름 :</th>
					<td><input type="text" name="name" value="${userinfo.name}"/></td>
				</tr>
				<tr>
					<th>이메일 :</th>
					<td><input type="email" name="email" value="${userinfo.email}"/></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정하기"/>
						<input type="reset" value="취소" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>