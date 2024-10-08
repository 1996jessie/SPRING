<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>   
boardInsertForm.jsp<br>
<script>
	function goList(num, pageNumber, whatColumn, keyword) {
	    location.href = "boardList.bd?num="+num+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword;
	}
</script>  

<form:form commandName="board" action="insert.bd" method="post">
	<table border = 1 width = "500">
		<tr>
			<td colspan = "2" onclick="goList('${board.num}', '${param.pageNumber}', '${param.whatColumn}', '${param.keyword}')">글목록</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type = "text" name = "writer" maxlength="10" value = "${ loginInfo.name }">
				<form:errors path="writer" cssClass="err"/>
			</td>
			
		</tr>
		<tr>
			<td>제목</td>
			<td>
				<input type = "text" name = "subject">
				<form:errors path="subject" cssClass="err"/>
			</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>
				<input type = "text" name = "email">
				<form:errors path="email" cssClass="err"/>
			</td>
		</tr>
		<tr>
			<td>내 용</td>
			<td>
				<textarea name = "content" rows = "20" cols = "50" ></textarea>
				<form:errors path="content" cssClass="err"/>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type = "password" name = "passwd">
				<form:errors path="passwd" cssClass="err"/>
			</td>
		</tr>
		<tr>
			<td colspan = 2>
				<input type = "submit" value = "글쓰기">
				<input type = "reset" value = "다시작성">
				<input type = "button" value = "목록보기" onclick="goList('${board.num}', '${param.pageNumber}', '${param.whatColumn}', '${param.keyword}')">
			</td>			
		</tr>	
	</table>	
</form:form>