<%@page import="com.spring.ex.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
member\result4.jsp<br>

id4: ${ param.id }<br>
pw4: ${ param.pw }<br>
addr4: ${ param.addr }<br>
age4: ${ param.age }<br>

id5 : <%= request.getParameter("id") %><br>
pw5 : <%= request.getParameter("pw") %><br>
addr5 : <%= request.getParameter("addr") %><br>
age5 : <%= request.getParameter("age") %><br>

<hr>

id6 : ${ memberBean.id }<br>
pw6 : ${ memberBean.getPw() }<br>
addr6 : ${ requestScope.memberBean.addr }<br>
age6 : ${ requestScope.memberBean.getAge() }<br> 

<%--
	MemberBean mb = (MemberBean)request.getAttribute("mb");
	pageContext.setAttribute("MB", mb);
--%>

id7 : ${ requestScope.memberBean.id }<br>
pw7 : ${ memberBean.pw }<br>
addr7 : ${ memberBean.addr }<br>
age7 : <%= ((MemberBean)request.getAttribute("memberBean")).getAge() %><br>