<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
list.jsp<br>
<style>
	table{
		width: 90%;
		align: center;
		border-collapse: collapse;
		text-align: center;
	}
	td, th{
		border: 1px solid gray;
		padding: 5
	}
	th{
		background: green;
	}
	a{
		text-decoration: none;
		color: olive;
	}
	a:hover{
		font-weight: bold;
		color: olive;
		text-decoration: underline;
	}
</style>
<table border="1">
	<tr align="center">
		<th>번호</th>
		<th>아이디</th>
		<th>비번</th>
		<th>우승예상국가</th>
		<th>16강예상국가</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var = "f" items = "${ lists }">  
		<tr align="center">
			<td>${ f.num }</td>
			<td>${ f.id }</td>
			<td>${ f.pw }</td>
			<td>${ f.win }</td>
			<td>${ f.round16 }</td>
			<td><a href="updateForm?num=${ f.num }">수정</a></td>
			<td><a href="delete?num=${ f.num }">삭제</a></td>
		</tr>		
	</c:forEach>
</table>
<hr>
<table border="1">
	<tr align="center"> 
		<th>번호</th>
		<th>아이디</th>
		<th>비번</th>
		<th>우승예상국가</th>
		<th>16강예상국가</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
  	<c:forEach var="i" begin="0" end="${ fn:length(lists)-1 }">
  		<tr align="center">
  			<td>${ lists[i].num }</td>
  			<td>${ lists[i].id }</td>
  			<td>${ lists.get(i).pw }</td>
  			<td>${ lists.get(i).win }</td>
  			<td>${ lists.get(i).round16 }</td>
  			<td><a href="validUpdateForm?num=${ lists.get(i).num }">수정</a></td>
  			<td><a href="delete?num=${ lists.get(i).num }">삭제</a></td>
  		</tr>
  	</c:forEach>
</table> 

<a href="insertForm">삽입</a>