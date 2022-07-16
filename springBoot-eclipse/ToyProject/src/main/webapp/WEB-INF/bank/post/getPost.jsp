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
				작성자 : <span id="username"><i>${post.user.username }</i></span>
			</div>
			<br>
			<hr>
			<button type="button" class="btn btn-secondary"
				onclick="history.back()">돌아가기</button>
			<c:if test="${post.user.username == principal.username }">
				<a href="/post/updatePost/${post.id }" class="btn btn-warning">수정하기</a>
				<button type="button" id="btn-delete" class="btn btn-danger">삭제하기</button>
			</c:if>
		
			<c:if test="${post.user.username == principal.username }">
			<table class="table table-hover">
			    <thead>
			      <tr>
			        <th class="col-sm-10">내용</th>
			        <th class="col-sm-1">작성자</th>
			        <th class="col-sm-1">삭제</th>
			      </tr>
			    </thead>
			    <tbody>
 		    		<c:if test="${!empty replyList }">
						<c:forEach var="reply" items="${replyList }">
						<tr>
							<td>${reply.comment }</td>
							<td>${reply.user.username }</td>
							<td><button type="button" id="btn-replyDelete" class="btn btn-light">삭제</button></td>
						</tr>
						</c:forEach>
					</c:if>
			    </tbody>
		  	</table>
		  	<br>
		  	  <form>
			    <div class="mb-3 mt-3">
			      <textarea class="form-control" rows="1" id="comment" name="text"></textarea>
			    </div>
			    <button type="button" id="btn-insertReply" class="btn btn-primary">덧글등록</button>
			  </form>
	  	</c:if>
	  	</div>
  	</div>
</div>

<script src="/js/post.js"></script>
<script src="/js/reply.js"></script>

<%@ include file="../layout/footer.jsp"%>
