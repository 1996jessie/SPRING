<%@page import="com.spring.ex.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result5.jsp<br>

title1 : ${ requestScope.book.title } <br>
author1 : ${ requestScope.book.author } <br>
price1 : ${ requestScope.book.price } <br>
publisher1 : ${ requestScope.book.publisher } <br>
<hr>
title2 : <%= ((BookBean)request.getAttribute("book")).getTitle() %><br>
author2 : <%= ((BookBean)request.getAttribute("book")).getAuthor() %><br>
price2 : <%= ((BookBean)request.getAttribute("book")).getPrice() %><br>
publisher2 : <%= ((BookBean)request.getAttribute("book")).getPublisher() %><br>
<hr>
title3 : ${ book.title }<br>
author3 : ${ book.author }<br>
price3 : ${ book.price }<br>
publisher3 : ${ book.publisher }
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