<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
webapp\WEB-INF\views\member\input.jsp<br>

id1 : ${ id }<br>
id2 : <%= request.getAttribute("id")  %><br>
id3 : ${ requestScope.id }<br>
<br>
name1 : ${ name }<br>
name2 : <%= request.getAttribute("name")  %><br>
name3 : ${ requestScope.name }<br>