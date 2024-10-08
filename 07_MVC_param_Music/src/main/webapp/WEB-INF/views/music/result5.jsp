<%@page import="com.spring.ex.bean.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result4.jsp<br>

title1 : ${ requestScope.music.title } <br>
singer1 : ${ requestScope.music.singer } <br>
price1 : ${ requestScope.music.price } <br>
<hr>
title2 : ${ music.title }<br>
singer2 : ${ music.singer }<br>
price2 : ${ music.price }<br>
<hr>
title3 : ${ param.title }<br>
singer3 : ${ param.singer }<br>
price3 : ${ param.price }<br>
<hr>
title4 : <%= request.getParameter("title") %><br>
singer4 : <%= request.getParameter("singer") %><br>
price4 : <%= request.getParameter("price") %><br>
<hr>
title5 : <%= ((MusicBean)request.getAttribute("music")).getTitle() %><br>
singer5 : <%= ((MusicBean)request.getAttribute("music")).getSinger() %><br>
price5 :  <%= ((MusicBean)request.getAttribute("music")).getPrice() %><br>