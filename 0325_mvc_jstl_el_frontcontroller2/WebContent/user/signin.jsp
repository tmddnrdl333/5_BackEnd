<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signin.jsp입니당</title>
<link href="${root}/css/table1.css"
	rel="stylesheet">
</head>
<body>
	<h2>회원가입</h2>
	<c:if test="${errorMsg!=null}">
		<div style="color: red">에러내용 : ${errorMsg}</div>
	</c:if>
	<form action="${root}/user/signin.do"	method="post">
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
				<tr>
					<th>이름 :</th>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<th>이메일 :</th>
					<td><input type="email" name="email" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="회원가입" /><input type="reset" value="취소" /></td>
				</tr>
			</tfoot>	
		</table>
	</form>
</body>
</html>