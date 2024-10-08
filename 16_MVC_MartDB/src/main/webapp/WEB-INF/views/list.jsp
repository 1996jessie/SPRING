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

<script type="text/javascript">
	
	function allCheck(obj) {
		var rowcheck = document.getElementsByName("rowcheck");
		var check = obj.checked;
 		if(check){
			for(var i=0;i<rowcheck.length;i++) {
				rowcheck[i].checked = true; 
			}
		} else {
			for(var i=0;i<rowcheck.length;i++) {
				rowcheck[i].checked = false; 
			}			
		} 
	}//allCheck
	
	function selectDelete(){
		var rowcheck = document.getElementsByName("rowcheck");
		var flag = false;
		for(var i=0;i<rowcheck.length;i++) {
			if(rowcheck[i].checked) {
				flag = true;
			}
		}
		if(flag == false) {
			alert("삭제할 항목을 1개 이상 선택하세요.");
			return;
		}
		document.myform.submit();
	}//selectDelete
	
</script>
<form name="myform" action="deleteAll" method="post">
	<table border="1">
		<tr align="center">
			<th><input type="checkbox" name = "allcheck" onClick = "allCheck(this)"></th>
			<th>번호</th>
			<th>아이디</th>
			<th>비번</th>
			<th>구매상품</th>
			<th>배송시간</th>
			<th>결제방법</th>
			<th>동의여부</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		<c:choose>
			<c:when test="${fn:length(lists) == 0}">
				<tr>
					<td colspan = 10>list 비어있음</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var = "m" items = "${ lists }">  
					<tr align="center">
						<td><input type="checkbox" name = "rowcheck" value = "${ m.num }"></td>
						<td>${ m.num }</td>
						<td>${ m.id }</td>
						<td>${ m.pw }</td>
						<td>${ m.product }</td>
						<td>${ m.time }</td>
						<td>${ m.approve }</td>
						<td>${ m.agree }</td>
						<td><a href="updateForm?num=${ m.num }">수정</a></td>
						<td><a href="delete?num=${ m.num }">삭제</a></td>
					</tr>		
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<a href="insertForm">삽입</a>
	<input type = "submit" value = "삭제" onClick = "selectDelete()"> 
</form>

