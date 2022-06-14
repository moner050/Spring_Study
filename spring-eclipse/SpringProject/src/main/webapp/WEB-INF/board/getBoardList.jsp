<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../layout/header.jsp" %>

<center>

<!-- 검색 화면 시작 -->
<form action="getBoardList.do" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
				<option value="TITLE" <c:if test="${condition == 'TITLE' }">selected</c:if>>제목				
				<option value="CONTENT" <c:if test="${condition == 'CONTENT' }">selected</c:if>>내용
			</select>
			<input type="text" name="searchKeyword" value="${keyword }" />
			<input type="submit" value="검색" />
		</td>
	</tr>
</table>
</form>
<!-- 검색 화면 종료 -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100">번호</th>
	<th bgcolor="orange" width="200">제목</th>
	<th bgcolor="orange" width="150">작성자</th>
	<th bgcolor="orange" width="150">등록일</th>
	<th bgcolor="orange" width="100">조회수</th>
</tr>

<c:forEach var="board" items="${boardList }">
<tr>
	<td>${board.seq }</td>
	<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
	<td>${board.writer }</td>
	<td>${board.regDate }</td>
	<td>${board.cnt }</td>
</tr>
</c:forEach>

</table>


</center>

<%@include file="../layout/footer.jsp" %>

