<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>   
<script type="text/javascript">

	function insert() {
		location.href="insert.bd";
	}
	
</script>
	

<style type="text/css">
	h2{
		text-align: center;
	}
	table {
		font-family: "나눔스퀘어 네오";
		border-collapse: collapse;
		margin: 0 auto;
	}
	td,th { 
		padding: 5px 5px;
	}
	tr:first-child td {
		text-align: right;		
	}	
</style>

boardList.jsp<br>

<center>
	<h2>게시판 (${ pageInfo.totalCount })</h2>
	<form action="boardList.bd" method="get">
		<select name="whatColumn">
			<option value="all">전체 검색
			<option value="writer">이름
			<option value="subject">제목
		</select> 
		<input type="text" name="keyword" value=""> 
		<input type="submit" value="검색">
	</form>
</center>

<table border = 1 width = 800px>
	<tr>
		<td colspan = 6 align = "right">
			<input type="button" value="글쓰기" onClick="insert()">
		</td>
	</tr>
	
	<c:if test="${ totalCount == 0 }">
		<tr>
			<td>게시글이 없습니다</td>
		</tr>
	</c:if>
	<c:if test="${ totalCount > 0 }">
			<td>번호</td>
			<td>제   목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회</td>
			<td>IP</td>
		<c:forEach var="board" items="${ boardLists }" varStatus="status">
			<tr>
				<td>${ pageInfo.totalCount - ((pageInfo.pageNumber - 1) * pageInfo.pageSize + status.index) }</td>
				<td>
					<c:if test="${ board.re_level > 0 }">
						<img src="resources/images/level.gif" width = ${ board.re_level * 10 }>
						<img src="resources/images/re.gif">
						<a href = "detailArticle.bd?num=${ board.num }&pageNumber=${ pageInfo.pageNumber }&whatColumn=${ param.whatColumn }&keyword=${ param.keyword }">${ board.subject }</a>
					</c:if>
					<c:if test="${ board.re_level == 0 }">
						<a href = "detailArticle.bd?num=${ board.num }&pageNumber=${ pageInfo.pageNumber }&whatColumn=${ param.whatColumn }&keyword=${ param.keyword }">${ board.subject }</a>
					</c:if>
				</td>
				<td>${ board.writer }</td>
				<td>${ board.reg_date }</td>
				<td>${ board.readcount }</td>
				<td>${ board.ip }</td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<p align="center">${ pageInfo.pagingHtml }</p>