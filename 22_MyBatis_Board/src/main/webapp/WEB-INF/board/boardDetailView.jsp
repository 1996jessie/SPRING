<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<script>
	function goUpdate(num, pageNumber, whatColumn, keyword) {
	    location.href = "update.bd?num="+num+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword;
	}
	
	function goDelete(num, pageNumber, whatColumn, keyword) {
		location.href="delete.bd?num="+num+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword;
	}
	
	function goReply(num, pageNumber, whatColumn, keyword) {
		location.href="reply.bd?num="+num+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword;
	}
	
	function goList(num, pageNumber, whatColumn, keyword) {
	    location.href = "boardList.bd?num="+num+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword;
	}
</script>

boardDetailView.jsp<br>

${ board.num } / ${ param.pageNumber } / ${ param.whatColumn } / ${ param.keyword } 
<table border = 1 width = "500">
	
		<tr align = "center">
			<td>글번호</td>
			<td width = "125">${ board.num }</td>
			<td width = "125">조회수</td>
			<td width = "125">${ board.readcount }</td>
		</tr>
		<tr align = "center">
			<td>작성자</td>
			<td>${ board.writer }</td>
			<td>작성일</td>
			<td>${ board.reg_date }</td>
		</tr>
		<tr align = "center">
			<td>글제목</td>
			<td colspan = "3">${ board.subject }</td>
		</tr>
		<tr align = "center">
			<td>글내용</td>
			<td colspan = "3">${ board.content }</td>
		</tr>
		<tr>
			<td colspan = "4" align = "right">
				<input type="button" value="글수정" onclick="goUpdate('${board.num}', '${param.pageNumber}', '${param.whatColumn}', '${param.keyword}')">
				<input type = "button" value = "글삭제" onClick = "goDelete('${board.num}', '${param.pageNumber}', '${param.whatColumn}', '${param.keyword}')">
				<input type = "button" value = "답글쓰기" onClick = "goReply('${board.num}', '${param.pageNumber}', '${param.whatColumn}', '${param.keyword}')">
				<input type = "button" value = "글목록" onclick="goList('${board.num}', '${param.pageNumber}', '${param.whatColumn}', '${param.keyword}')">
			</td>
	
		</tr>
	</table>