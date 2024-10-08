<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
shopList.jsp<br>

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
</style>

<h2>주문 내역</h2>

<table border = 1>
	<tr>
		<td colspan = 3>
			주문자 정보 : ${ sessionScope.loginInfo.getName() }(${ loginInfo.id })
		</td>
	</tr>
	<tr bgcolor="#E6E6FA">
		<th>주문 번호</th>
		<th>주문 일자</th>
		<th>상세보기</th>
	</tr>
	<c:forEach var="order" items="${ orderLists }">
		<tr>
			<td>${ order.oid }</td>
			<td>${ order.orderdate }</td>
			<td><a href = "detailView.mall?oid=${ order.oid }">상세보기</a></td>
		</tr>
	</c:forEach>
</table>