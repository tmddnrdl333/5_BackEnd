<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Map-->
<div class="row">
    <div class="col-4 page-section bg-primary" id="map-page">
        <div class="container px-4 px-lg-5">
            <div class="row gx-4 gx-lg-5 justify-content-center">
                <div class="col-lg-8 text-center">
                    <h2 class="text-white mt-0" style="font-family: 'Jua', sans-serif; font-size: 60px;">지도를 보자!</h2>
                    <hr class="divider divider-light" />
                    <p class="text-white-75 mb-4" style="font-family: 'Jua', sans-serif; font-size: 25px;">어디에 거주하고 싶으세요?</p>
                    <a class="btn btn-light btn-xl" href="${pageContext.request.contextPath}/house/dong_search.do" style="font-family: 'Jua', sans-serif; font-size: medium;margin: 7px">동별 실거래가 조회</a>
                </div>
            </div>
        </div>
    </div>
    <div id="map" class="col-8 container justify-content-center"></div>
</div>