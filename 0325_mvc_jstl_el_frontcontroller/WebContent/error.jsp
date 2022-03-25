<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp입니당</title>
</head>
<body>
<jsp:include page="/menu.jsp"></jsp:include>
	<h1>실행시 문제가 발생하였습니다.-${requestScope.errorMsg}</h1>

	<!--  <a href="index.jsp">메인으로 이동</a> -->
	<!-- regist.jsp에서 포워딩시 유지하면서 error.jsp의 응답을 띄워버리면 위 링크가 뜨면서, 파일위치가 꼬여버림.
	그래서 index.jsp를 상대주소로 저렇게 적어주면 안되고... 절대위치로 적어줘야 함.-->
	<a href="${root}/index.jsp">메인으로 이동</a>
</body>
</html>