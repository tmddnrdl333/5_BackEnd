<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

<script type="text/javascript">
        $(document).ready(function () {
            $("#mvListBtn").click(function () {
                location.href = "${pageContext.request.contextPath}/notice/list.do";
            });
        });
    </script>
<div style="text-align: center; font-family: 'Jua', sans-serif">
    <div class="container text-center mt-3">
        <div class="col-lg-8 mx-auto">
            <div class="jumbotron">
                <h1 class="text-primary">글작성 성공 ^^</h1>
                <p class="mt-4"><button type="button" id="mvListBtn" class="btn btn-outline-dark">글목록 페이지로 이동</button>
                </p>
            </div>
        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>