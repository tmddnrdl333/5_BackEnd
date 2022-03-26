<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp입니당</title>
<link href="${root}/css/table1.css"
	rel="stylesheet">
</head>
<body>
	<c:if test="${errorMsg!=null}">
		<div style="color: red">에러내용 : ${errorMsg}</div>
	</c:if>
	<h2>로그인</h2>
	<form action="${root}/user/login.do"	method="post">
		<table>
			<tbody>
				<tr>
					<th>ID :</th>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<th>PW :</th>
					<td><input type="password" name="pass" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="로그인" /><input type="reset" value="취소" /></td>
				</tr>
			</tfoot>		
		</table>
	</form>
</body>
</html>