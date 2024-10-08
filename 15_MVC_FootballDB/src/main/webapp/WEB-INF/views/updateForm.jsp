<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions" %>    s
updateForm.jsp<br>

<form action="update" method="post">
<table border=1>
	<tr>
		<td>아이디</td>
		<td>
		<input type="hidden" name="num" value="${ fdto.num }">
		<input type="text" name="id" value="${ fdto.id }"></td>
	</tr>
	<tr>
		<td>비번</td>
		<td><input type="text" name="pw" value="${ fdto.pw }"></td>
	</tr>
	<tr>
		<td>우승예상국가</td>
		<td>
			<%String [] warr = {"한국","미국", "독일","스페인"};%>
			<c:set var="warr" value="<%=warr %>"/>
			<c:forEach var="win" items="${warr}">
				<input type="radio" name="win" value="${ win }" <c:if test="${ fdto.win eq win }">checked</c:if>>${ win }
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td>16강예상국가</td>
		<td>
			<%String [] rarr = {"한국","멕시코","독일","브라질","스위스","잉글랜드"};%>
			<c:set var="rarr" value="<%=rarr%>"/>
			<c:forEach var="round16" items="${rarr}">
        		<input type="checkbox" name="round16" value="${round16}" <c:if test="${fn:contains(fdto.round16, round16)}">checked</c:if>>${round16}
    		</c:forEach>
		</td>
	</tr>
	<tr>
		<td colspan=2>
			<input type="submit" value="수정">&nbsp;&nbsp;
			<a href="list">목록보기</a>
		</td>
	</tr>
</table>
</form>

