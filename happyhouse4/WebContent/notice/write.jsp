<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

<style>
        mark.sky {
            background: linear-gradient(to top, #54fff9 20%, transparent 30%);
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#registerBtn").click(function () {
                if (!$("#noticeTitle").val()) {
                    alert("제목 입력!!!!");
                    return;
                } else if (!$("#noticeBody").val()) {
                    alert("내용 입력!!!!");
                    return;
                } else {
                    $("#writeform").attr("action", "${pageContext.request.contextPath}/notice/register.do").submit();
                }
            });
        });
    </script>
<div style="text-align: center; font-family: 'Jua', sans-serif">
    <div class="container text-center mt-3">
        <div class="col-lg-8 mx-auto">
            <h2 class="p-3 mb-3 shadow bg-light"><mark style="text-align: center; font-family: 'Jua', sans-serif">글쓰기</mark></h2>
            <form id="writeform" class="text-left mb-3" method="post" action="">
            	<input type="hidden" name="noticeNo" value="${notice.noticeNo}" />
                <div class="form-group">
                    <label for="noticeTitle">제목</label>
                    <input type="text" class="form-control" id="noticeTitle" name="noticeTitle" value="${notice.noticeTitle}" placeholder="제목...">
                </div>
                <div class="form-group">
                    <label for="noticeBody">내용</label>
                    <textarea class="form-control" rows="15" id="noticeBody" name="noticeBody">${notice.noticeBody}</textarea>
                </div>
                <div class="text-center">
                    <button class="btn btn-success" type="button" id="registerBtn" class="btn btn-outline-primary">글작성</button>
                    <button class="btn btn-success" type="reset" class="btn btn-outline-danger">초기화</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="/footer.jsp" %>