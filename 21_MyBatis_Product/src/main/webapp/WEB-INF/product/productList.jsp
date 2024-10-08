<%@page import="member.model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>   
<script type="text/javascript">
	function insert(){
		location.href="insert.prd";
	}
	function goUpdate(num, whatColumn, keyword, pageNumber) {
		location.href="update.prd?num=" + num + "&whatColumn=" + whatColumn + "&keyword=" + keyword + "&pageNumber=" + pageNumber;
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
		text-align: center;
		padding: 5px 5px;
	}
	tr:last-child td {
		text-align: center;		
	}
	tr:first-child td {
		text-align: right;		
	}	
	.err{
		color: red;
		font-size: 14px;
	}
</style> 

productList.jsp<br><br>

<h1 align="center">상품 리스트 화면(${ pageInfo.totalCount })</h1>
	<form action="list.prd" align="center">
		<select name="whatColumn">
			<option value="all">전체검색 
			<option value="name">상품명
			<option value="contents">설명
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	<table border="1" align="center" width="80%">
		<tr>
			<td colspan="7" align="right">
				<input type="button" value="추가하기" onClick="insert()">
			</td>
		</tr>
		<tr bgcolor="#E6E6FA">
			<th>상품번호</th>
			<th>상품명</th>
			<th>이미지</th>
			<th>설명</th>
			<th>가격</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		
		<c:forEach var="product" items="${ productLists }">

			<tr>
				<td>${ product.num }</td>
				<td>
					<a href="detail.prd?num=${ product.num }&pageNumber=${ pageInfo.pageNumber }&whatColumn=${ param.whatColumn }&keyword=${ param.keyword }">${ product.name }</a>
				</td>
				<td>
					<img src="<%= request.getContextPath()+"/resources/uploadImage/" %>${ product.image }" width="100" height="70">
				</td>
				<td>${ product.contents }</td>
				<td>${ product.price }</td>
				<td>
					<input type="button" value="수정" onClick="goUpdate('${ product.num }', '${ param.whatColumn }', '${ param.keyword }', '${ pageInfo.pageNumber }')">
				</td>
				<td>
					<a href="delete.prd?num=${ product.num }&pageNumber=${ pageInfo.pageNumber }&whatColumn=${ param.whatColumn }&keyword=${ param.keyword }">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<center>${ pageInfo.pagingHtml }</center>
	