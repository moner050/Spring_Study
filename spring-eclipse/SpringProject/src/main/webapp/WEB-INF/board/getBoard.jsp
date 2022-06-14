<%@page contentType="text/html; charset=UTF-8" %>

<!-- 
	EL(Expression Lanaguage)이란?
	request, session, application 내장객체에 등록된 데이터를 접근하기 위한 표현식
	
	JSTL(JSP Standard Tag Library)이란?
	JSP 파일에서 if, for, switch 같은 자바 코드를 대체하기 위한 표준 태그
-->
 
<%@ include file="../layout/header.jsp" %>

<center>
<form action="updateBoard.do" method="post">
<input name="seq" type="hidden" value="${board.seq }"/>
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td>
		<td align="left"><input name="title" type="text" value="${board.title }"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td align="left">${board.writer }</td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td align="left">
			<textarea name="content" cols="40" rows="10">${board.content }</textarea>
		</td>
	</tr>
	<tr>
		<td bgcolor="orange">등록일</td>
		<td align="left">${board.regDate }</td>
	</tr>
	<tr>
		<td bgcolor="orange">조회수</td>
		<td align="left">${board.cnt }</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="글 수정"/>
		</td>
	</tr>
</table>
</form>
<br>

<c:if test="${user.role == 'ADMIN' }">
<a href="deleteBoard.do?seq=${board.seq }">글삭제</a>
</c:if>

</center>

<%@ include file="../layout/footer.jsp" %>
 
