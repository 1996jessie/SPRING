<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
updateForm.jsp<br>

<form action="update" method="post">
	<table border=1 width=400>
		
		<tr>
			<td>아이디</td>
			<td>
			<input type="hidden" name="num" value="${ pdto.num }">
			<input type="text" name="id" value="${ pdto.id }">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${ pdto.name }"></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="${ pdto.age }"></td>
		</tr>
		<tr>
			<td colspan=2>
				<input type="submit" value="수정"> &nbsp;&nbsp;
				<a href="list">목록보기</a>
			</td>
		</tr>
	</table>

</form>