<%@page import="com.spring.ex.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result4.jsp<br>

title1 : ${ requestScope.bookBean.title }<br>
author1 : ${ requestScope.bookBean.author }<br>
price1 : ${ requestScope.bookBean.price }<br>
publisher1 : ${ requestScope.bookBean.publisher }<br>
<hr>
title2 : <%= ((BookBean)request.getAttribute("bookBean")).getTitle() %><br>
author2 : <%= ((BookBean)request.getAttribute("bookBean")).getAuthor() %><br>
price2 : <%= ((BookBean)request.getAttribute("bookBean")).getPrice() %><br>
publisher2 : <%= ((BookBean)request.getAttribute("bookBean")).getPublisher() %><br>
<hr>
title3 : ${ bookBean.title }<br>
author3 : ${ bookBean.author }<br>
price3 : ${ bookBean.price }<br>
publisher3 : ${ bookBean.publisher }
<hr>
title4 : ${ param.title }<br>
author4 : ${ param.author }<br>
price4 : ${ param.price }<br>
publisher4 : ${ param.publisher }<br>
<hr>
title5 : <%= request.getParameter("title") %><br>
author5 : <%= request.getParameter("author") %><br>
price5 : <%= request.getParameter("price") %><br>
publisher5 : <%= request.getParameter("publisher") %><br>