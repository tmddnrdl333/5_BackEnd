<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Happy House 4</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/favicon.png" />
        <!-- Bootstrap Icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <!-- SimpleLightbox plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
        <!-- script 추가-->
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    	<script>
            $(document).ready(function() {
                $('#search-in').on('keypress', function(e){ 
                    if(e.keyCode == '13'){ 
                        $('#search-btn').click(); 
                    } 
                });
                $("#search-btn").one('click', function () {
                });
            });
        </script>
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav" style="flex-direction: column;">
            <div class="container px-4 px-lg-5">
                <img src="${pageContext.request.contextPath}/assets/img/house_gif.gif" style="width: 40px; height: auto; margin-right: 10px;">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Happy House</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <!--
                    <ul class="navbar-nav ms-auto my-2 my-lg-0">
                        <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
                        <li class="nav-item"><a class="nav-link" href="sign.jsp">Sign Up</a></li>
                    </ul>
                    -->
                    <jsp:include page="/menu.jsp"></jsp:include>
                </div>
            </div>
            <div class="container px-4 px-lg-5">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive2" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive2">
                    <ul class="navbar-nav ms-auto my-2 my-lg-0">
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/notice/list.do">공지사항</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">오늘의 뉴스</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">주변 탐방</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">관심 지역 설정</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">관심 지역 둘러보기</a></li>
                        <li><input type="text" id="search-in" autocomplete="off" placeholder="검색하세요" style="width: 120px;"><button  id='search-btn'><img src="${pageContext.request.contextPath}/assets/img/search.png" style="width: 20px; height: auto;"></button></li>
                    </ul>
                </div>
            </div>
        </nav>
        
    <!-- Masthead-->
    <header class="masthead">
      <div class="container px-4 px-lg-5 h-100">
          <div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
              <div class="col-lg-8 align-self-end">
                  <h1 class="text-white font-weight-bold" style="font-family: 'Jua', sans-serif; font-size: 80px;">행복한 우리 집</h1>
                  <hr class="divider" />
              </div>
              <div class="col-lg-8 align-self-baseline">
                  <p class="text-white-75 mb-5" style="font-family: 'Jua', sans-serif; font-size: 30px;">승욱, 다은이와 알아보는 가구별 실거래가 조회하기</p>
                  <a class="btn btn-primary btn-xl" href="#map" style="font-family: 'Jua', sans-serif; font-size: medium;">지도 확인하기</a>
              </div>
          </div>
      </div>
    </header>
    