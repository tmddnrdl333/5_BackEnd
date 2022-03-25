<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regist.jsp입니당</title>
<link href="${root}/css/table1.css"
	rel="stylesheet">
</head>
<body>
<jsp:include page="/menu.jsp"></jsp:include>
	<h2>부서 등록</h2>
	<form method="post"
		action="${root}/dept/regist.do">
		<table>
			<tbody>
				<tr>
					<th>부서 번호</th>
					<td><input type="text" name="deptNo" placeholder="부서번호를 입력하세요"
						required="required" /></td>
				</tr>
				<tr>
					<th>부서 이름</th>
					<td><input type="text" name="dName" placeholder="부서이름을 입력하세요"
						required="required" /></td>
				</tr>
				<tr>
					<th>부서 지역</th>
					<td><input type="text" name="loc" placeholder="지역을 입력하세요"
						required="required" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="등록" /> <input
						type="reset" value="취소" /></td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>