<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!-- 브라우저가 인증에 성공했나 확인-->
<sec:authorize access="isAuthenticated()">
    <!-- JSP 파일에서 사용할 인증과 관련한 변수를 초기화한다. -->
    <sec:authentication property="principal" var="principal" />
</sec:authorize>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>은행 홈페이지</title>
    <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <!-- Summernote 시작 -->
    <link href="/webjars/summernote/0.8.10/summernote-bs4.css" rel="stylesheet">
    <script src="/webjars/summernote/0.8.10/summernote-bs4.min.js"></script>
    <!-- Summernote 종료 -->
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Main</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <c:if test="${principal == null }">
                <div class="navbar-nav">
                    <a class="nav-link" href="/auth/login">로그인</a>
                    <a class="nav-link" href="/auth/insertUser">회원가입</a>
                </div>
            </c:if>
            <c:if test="${principal != null }">
                <div class="navbar-nav">
                    <a class="nav-link" href="/user/updateUser">회원상세</a>
                    <a class="nav-link" href="/post/insertPost">1:1문의</a>
                    <a class="nav-link" href="/auth/login">로그아웃</a>
                </div>
            </c:if>
        </div>
    </div>
</nav>