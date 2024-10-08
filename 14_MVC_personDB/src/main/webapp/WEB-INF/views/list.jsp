<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
list.jsp<br>
 
<table>
	<tr align="center">
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var = "p" items = "${ lists }">  
		<tr align="center">
			<td>${ p.num }</td>
			<td>${ p.id }</td>
			<td>${ p.name }</td>
			<td>${ p.age }</td>
			<td><a href="updateForm?num=${ p.num }">수정</a></td>
			<td><a href="delete?num=${ p.num }">삭제</a></td>
		</tr>		
	</c:forEach>
</table>
<hr>
<table border="1" width = 80% align=center>
	<tr align="center"> 
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
  	<c:forEach var="i" begin="0" end="${ fn:length(lists)-1 }">
  		<tr align="center">
  			<td>${ lists[i].num }</td>
  			<td>${ lists[i].id }</td>
  			<td>${ lists.get(i).name }</td>
  			<td>${ lists.get(i).age }</td>
  			<td><a href="updateForm?num=${ lists.get(i).num }">수정</a></td>
  			<td><a href="delete?num=${ lists.get(i).num }">삭제</a></td>
  		</tr>
  	</c:forEach>
</table> 

<a href="insertForm">삽입</a>