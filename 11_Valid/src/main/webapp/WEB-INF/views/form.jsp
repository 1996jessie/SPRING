<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}

</style>
form.jsp<br>

<form:form commandName="per" action="insert" method="post"> <!-- commandName="속성명" (안 쓰면 에러 메시지 안 나옴) -->
	이름 : <input type="text" name="name" value="${ per.name }"><form:errors cssClass="err" path="name"/><br>
	비밀번호 : <input type="text" name="pw" value="${ per.pw }"><form:errors cssClass="err" path="pw"/><br>
	
	<input type="submit" value="전송">
</form:form>
