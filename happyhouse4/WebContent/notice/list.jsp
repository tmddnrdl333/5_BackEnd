<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

<!-- 공지사항 수정 페이지 Start -->
<style>
       mark.sky {
           background: linear-gradient(to top, #54fff9 20%, transparent 30%);
       }
   </style>
   <div style="text-align: left; font-family: 'Jua', sans-serif">
   <script type="text/javascript">
       $(document).ready(function () {
       	$("#mvRegisterBtn").click(function () {
               location.href = "${pageContext.request.contextPath}/notice/mvregister.do";
           });
       	
       	$(".page-item").click(function () {
              	$("#pg").val($(this).attr("data-pg"));
              	$("#pageForm").attr("action", "${pageContext.request.contextPath}/notice").submit();
           });
       });
       
       function deleteNo(noticeNo) {
       	if(confirm("정말로 삭제??")) {
       		location.href = "${root}/notice/delete.do?noticeNo="+noticeNo;
       	}
       }
   </script>
   <form action="${pageContext.request.contextPath}/notice/list.do" name="pageForm" id="pageForm" method="get">
   	<input type="hidden" name="pg" id="pg" value="" />
   	<input type="hidden" name="key" id="key" value="${key}" />
   	<input type="hidden" name="word" id="word" value="${word}" />
   </form>

   <div class="container mt-3">
       <div class="col-lg-8 mx-auto">
           <h2 class="p-3 mb-3 shadow bg-light" style="text-align: center;"><mark style="font-family: 'Jua', sans-serif">공지사항</mark></h2>
           <div class="m-3 text-right" style="text-align: right;">
               <button type="button" id="mvRegisterBtn" class="btn btn-success" style="font-family: 'Jua', sans-serif">글작성</button>
           </div>
           <div class="m-2 row justify-content-end">
           	<form  style="display:flex; justify-content: flex-end;" action="${pageContext.request.contextPath}/notice/list.do">
            	<input type="hidden" name="pg" value="1">
            	<select class="m-1" name="key" >
            		<option value="memberId"> 아이디
            		<option value="noticeTitle"> 제목
            		<option value="noticeNo"> 글번호
            	</select>
            	<input type="text" class="m-1" name="word">
            	<button type="submit" class="m-1 btn btn-outline-primary" style="text-align: center; font-family: 'Jua', sans-serif">검색</button>
           	</form>
           </div>
<c:if test="${!empty notices}">    
	<c:forEach var="notice" items="${notices}">
           <table class="table table-active text-left">
               <tbody>
                   <tr class="table-info">
                       <td>작성자 : ${notice.memberNickname}</td>
                       <td class="text-right">작성일 : ${notice.noticeDate}</td>
                   </tr>
                   <tr>
                       <td colspan="2" class="table-danger">
                           <strong>${notice.noticeNo}. ${notice.noticeTitle}</strong>
                          <c:if test="${memberId eq notice.memberId}">
                           <div class="text-right" style="display:flex; justify-content: flex-end;">
                           	<a class="btn btn-success m-1" href="${pageContext.request.contextPath}/notice/mvmodify.do?noticeNo=${notice.noticeNo}">수정</a>
                           	<a class="btn btn-success m-1" href="${pageContext.request.contextPath}/notice/delete.do?noticeNo=${notice.noticeNo}">삭제</a>
                           </div>
                           </c:if> 
                       </td>
                   </tr>
                   <tr>
                       <td class="p-4" colspan="2">${notice.noticeBody}</td>
                   </tr>
               </tbody>
           </table>
	</c:forEach>
	${navi.navigator}
</c:if>  
<c:if test="${empty notices}">    
		<table class="table table-active text-left">
                   <tr class="table-info">
                       <td colspan="2">작성한 글이 없습니다.</td>
                   </tr>
           </table>
</c:if>       
       </div>
   </div>
</div>
    <!-- 공지사항 수정 페이지 End -->
<%@ include file="/footer.jsp" %>