<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
member\list.jsp<br>

name1 : ${ requestScope.name }<br>
name2 : ${ name }<br>
name3 : <%= request.getAttribute("name") %><br>
<br>
age1 : ${ requestScope.age }<br>
age2 : ${ age }<br>
age3 : <%=  request.getAttribute("age") %><br>
