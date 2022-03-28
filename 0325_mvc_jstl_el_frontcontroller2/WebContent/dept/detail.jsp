<%@page import="com.ssafy.model.dto.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp입니당</title>
<link href="${root}/css/table1.css"
	rel="stylesheet">
</head>
<body>
<jsp:include page="/menu.jsp"></jsp:include>
	<h2>부서 상세 조회</h2>
	<form method="post" action="${root}/dept/modify_form.do">
		<table>
			<tbody>
				<tr>
					<th>부서 번호</th>
					<td><input type="text" name="deptNo" required="required"
						readonly="readonly" value="${dept.deptno}" /></td>
				</tr>
				<tr>
					<th>부서 이름</th>
					<td><input type="text" name="dName" required="required"
						readonly="readonly" value="${requestScope.dept.dname}" /></td>
				</tr>
				<tr>
					<th>부서 지역</th>
					<td><input type="text" name="loc" required="required"
						readonly="readonly" value="${dept.loc}" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="수정" /> <input
						type="submit" value="삭제"
						formaction="${root}/dept/remove.do" />
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>