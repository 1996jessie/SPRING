<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person\result.jsp<br>
name1 : ${ name }<br>
name2 : ${ param.name }<br>
name3 : <%= request.getParameter("name") %><br>

name4 : ${ requestScope.name2 } <br>
name5 : <%= request.getAttribute("name2") %><br>
name6 : ${ name2 }<br>

age1 : ${ param.age }<br>
age2 : <%= request.getParameter("age") %>