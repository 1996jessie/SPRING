<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %> 
insertForm.jsp<br>
<style>
	.err{
		font-size: 9pt;
		color : red;
		font-weight: bold;
	}
</style>
<h1> 마트 상품 구매 내역 </h1>
<form:form commandName="mb" action="insert" method="post">
<table border = 1>
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="id" value="${ mb.id }">
			<form:errors cssClass="err" path="id"/>
		</td>
	</tr>
	<tr>
		<td>비번</td>
		<td>
			<input type="text" name="pw" value="${ mb.pw }">
			<form:errors cssClass="err" path="pw"/>
		</td>
	</tr>
	<tr>
		<td>구매상품</td>
		<td>
			<%
				String[] product = {"식품", "의류", "도서", "가구"};
			%>
				<c:forEach var="p" items="<%= product %>">
					<input type="checkbox" name="product" value="${ p }" <c:if test="${fn:contains(mb.product, p)}">checked</c:if>>${ p }
				</c:forEach>
			<form:errors cssClass="err" path="product"/>
		</td>
	</tr>
	<tr>
		<td>배송시간</td>
		<td>
			<select name="time">
				<option value="">선택</option>
				<option value="8-12" <c:if test="${ mb.time eq '8-12' }">selected</c:if>>8-12</option>
				<option value="12-16" <c:if test="${ mb.time eq '12-16' }">selected</c:if>>12-16</option>
				<option value="16-20" <c:if test="${ mb.time eq '16-20' }">selected</c:if>>16-20</option>
			</select>
			<form:errors cssClass="err" path="time"/>
		</td>
	</tr>
	<tr>
		<td>결제방법</td>
		<td>
			<input type="radio" name="approve" value="카드" <c:if test="${ mb.approve eq '카드'}">checked</c:if>> 카드
			<input type="radio" name="approve" value="핸드폰" <c:if test="${ mb.approve eq '핸드폰'}">checked</c:if>> 핸드폰
			<form:errors cssClass="err" path="approve"/>
		</td>
	</tr>
	<tr>
		<td>결제 동의합니다</td>
		<td>
			<input type="checkbox" name="agree" value="동의" <c:if test="${ mb.agree eq '동의'}">checked</c:if>>
			<form:errors cssClass="err" path="agree"/>
		</td>
	</tr>
	<tr>
		<td colspan = 2 align = "center"><input type = "submit" value="보내기"></td>
	</tr>
</table>
</form:form>