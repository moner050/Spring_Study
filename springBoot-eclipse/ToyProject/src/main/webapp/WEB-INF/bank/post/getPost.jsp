<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container-fluid mt-3">
	<div class="card">
		<div class="card-body">
			<h1 class="card-title">${post.title }</h1>
			<br>
			<h2>${post.content }</h2>
			<div>
				포스트 번호 : <span id="id"><i>${post.id }</i></span> <br> 
				작성자 : <span><i>${post.user.username }</i></span>
			</div>
			<br>
			<hr>
			<button type="button" class="btn btn-secondary"
				onclick="history.back()">돌아가기</button>
			<c:if test="${post.user.username == principal.username }">
				<a href="/post/updatePost/${post.id }" class="btn btn-warning">수정하기</a>
				<button type="button" id="btn-delete" class="btn btn-danger">삭제하기</button>
			</c:if>
		</div>
		<c:if test="${post.user.username == principal.username }">
		<table class="table table-hover">
		    <thead>
		      <tr>
		        <th>내용</th>
		        <th>작성자</th>
		        <th>삭제</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td>John</td>
		        <td>Doe</td>
		        <td>john@example.com</td>
		      </tr>
		      <tr>
		        <td>Mary</td>
		        <td>Moe</td>
		        <td>mary@example.com</td>
		      </tr>
		      <tr>
		        <td>July</td>
		        <td>Dooley</td>
		        <td>july@example.com</td>
		      </tr>
		    </tbody>
	  	</table>
	  	</c:if>
  	</div>
</div>

<script src="/js/post.js"></script>

<%@ include file="../layout/footer.jsp"%>
