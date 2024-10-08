<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>    
<script>
	function goList(num, pageNumber, whatColumn, keyword) {
	    location.href = "boardList.bd?num="+num+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword;
	}
	
</script>

boardReplyForm.jsp<br>
${ param.num } / ${ param.pageNumber } / ${ param.whatColumn } / ${ param.keyword } 
<form action="reply.bd?num=${ param.num }&pageNumber=${ param.pageNumber }&whatColumn=${ param.whatColumn }&keyword=${ param.keyword }" method = "post">
	<table border = 1 width = "500">
		<tr>
			<td colspan = "2" align = "right" onclick="goList('${board.num}', '${param.pageNumber}', '${param.whatColumn}', '${param.keyword}')">글목록</td>
		</tr>
		<tr>
			<td width = "150" align = "center">이름</td>
			<td><input type = "text" name = "writer" maxlength="10" value="${ loginInfo.name }"></td>
		</tr>
		<tr>
			<td width = "150" align = "center">제목</td>
			<td><input type = "text" name = "subject" value = "[답글]"></td>
		</tr>
		<tr>
			<td width = "150" align = "center">Email</td>
			<td><input type = "text" name = "email"></td>
		</tr>
		<tr>
			<td width = "150" align = "center">내 용</td>
			<td><textarea name = "content" rows = "20" cols = "50" ></textarea></td>
		</tr>
		<tr>
			<td width = "150" align = "center">비밀번호</td>
			<td>
				<input type = "password" name = "passwd">
				<input type = "hidden" name = "num" value = "${ board.num }">
				<input type = "hidden" name = "ref" value = "${ board.ref }">
				<input type = "hidden" name = "re_step" value = "${ board.re_step }">
				<input type = "hidden" name = "re_level" value = "${ board.re_level }">
			</td>
		</tr>
		<tr>
			<td colspan = "2" width = "150" align = "center">
				<input type = "submit" value = "답글쓰기">
				<input type = "reset" value = "다시작성">
				<input type = "button" value = "목록보기" onclick="goList('${board.num}', '${param.pageNumber}', '${param.whatColumn}', '${param.keyword}')">
			</td>			
		</tr>	
	</table>
</form>