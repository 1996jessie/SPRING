<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
mallList.jsp<br>

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

<h2> 주문 내역 </h2>

<table border = 1>
	<tr>
		<td colspan = 5> 주문자 정보 : ${ sessionScope.loginInfo.getName() }(${ loginInfo.id })</td>
	</tr>
	<tr>
		<th>상품번호</th>
		<th>상품명</th>
		<th>주문 수량</th>
		<th>단가</th>
		<th>금액</th>
	</tr>
	
	<c:forEach var="shop" items="${ shopLists }">
		<tr>
			<td>${ shop.pnum }</td>
			<td>${ shop.pname }</td>
			<td>${ shop.qty }</td>
			<td><fmt:formatNumber value = "${ shop.price }" type = "number" pattern = "#,###"/>원</td>
			<td><fmt:formatNumber value = "${ shop.amount }" type = "number" pattern = "#,###"/>개</td>
		</tr>	
	</c:forEach>
	
	<tr>
		<td colspan = 3>
			<a href="calculate.mall">결제하기</a>
			<a href="list.prd">추가 주문</a>
		</td>
		<td colspan = 2>
			총 금액 : <fmt:formatNumber value = "${ totalAmount }" type = "number" pattern = "#,###"/>원
		</td>
	</tr>
</table>