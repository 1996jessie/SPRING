<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
cafeDetailView.jsp<br>
<style>
	th{
		background: cyan;
	}
</style>

<h2 align="center">세부 주문 내역</h2>

<table border="1" align="center" width="50%" height="60%">
	<tr>
		<th>번호</th>
		<td>${ cafe.num }</td>
	</tr>
	
	<tr>
		<th>구분</th>
		<td>${ cafe.category }</td>
	</tr>
	
	<tr>
		<th>메뉴</th>
		<td>${ cafe.menu }</td>
	</tr>
	
	<tr>
		<th>온도</th>
		<td>${ cafe.temp }</td>
	</tr>
	
	<tr>
		<th>수량</th>
		<td>${ cafe.amount }</td>
	</tr>
	
	<tr>
		<th>기타 요청사항</th>
		<td>${ cafe.req }</td>
	</tr>
	
	<tr>
		<th colspan="2" align="center">
			<a href="list.cf?pageNumber=${ pageNumber }&whatColumn=${ param.whatColumn }&keyword=${ param.keyword }">
				전체 주문 내역
			</a>
		</th>
	</tr>
	
</table>