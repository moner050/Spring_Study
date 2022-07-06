<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="./layout/header.jsp"%>

<h1>안녕 : ${username }</h1>

<form action="bank" method="post">
    <input type="submit" value="POST 전송"/>
</form>

<%@include file="./layout/footer.jsp"%>