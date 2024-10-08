<%@page import="com.spring.ex.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
member\result5.jsp<br>

id4: ${ param.id }<br>
pw4: ${ param.pw }<br>
addr4: ${ param.addr }<br>
age4: ${ param.age }<br>

id5 : <%= request.getParameter("id") %><br>
pw5 : <%= request.getParameter("pw") %><br>
addr5 : <%= request.getParameter("addr") %><br>
age5 : <%= request.getParameter("age") %><br>

<hr>

id6 : ${ abcd.id }<br>
pw6 : ${ abcd.getPw() }<br>
addr6 : ${ requestScope.abcd.addr }<br>
age6 : ${ requestScope.abcd.getAge() }<br>

<%--
	MemberBean mb = (MemberBean)request.getAttribute("mb");
	pageContext.setAttribute("MB", mb);
--%>

id7 : ${ requestScope.abcd.id }<br>
pw7 : ${ abcd.pw }<br>
addr7 : ${ abcd.addr }<br>
age7 : <%= ((MemberBean)request.getAttribute("abcd")).getAge() %><br>