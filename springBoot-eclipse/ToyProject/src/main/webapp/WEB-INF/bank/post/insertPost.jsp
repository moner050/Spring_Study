<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
	<c:if test="${post == null }">
		<form>
			<div class="mb-3">
				<label for="title">Title:</label> 
				<input type="text" class="form-control" id="title" placeholder="Enter title">
				<div class="mb-3">
					<label for="content">Content:</label>
					<textarea class="form-control" rows="5" id="content"></textarea>
				</div>
			</div>
		</form>
		<button id="btn-insert" class="btn btn-secondary">포스트등록</button>
	</c:if>
	
	<c:if test="${post != null }">
		<form>
			<div class="mb-3">
				<label for="title">Title:</label> 
				<input type="text" class="form-control" id="title" placeholder="Enter title" value="${post.title }">
				<div class="mb-3">
					<label for="content">Content:</label>
					<textarea class="form-control" rows="5" id="content" >${post.content }</textarea>
				</div>
			</div>
		</form>
		<button type="button" class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		<button id="btn-update" class="btn btn-warning">포스트 수정</button>
	</c:if>


	<script>
		$(document).ready(function() {
			$("#content").summernote({
				height : 300
			});
		});
	</script>

</div>

<script src="/js/post.js"></script>

<%@ include file="../layout/footer.jsp"%>
