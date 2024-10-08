<%@page import="com.spring.ex.bean.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result4.jsp<br>

title1 : ${ requestScope.musicBean.title } <br>
singer1 : ${ requestScope.musicBean.singer } <br>
price1 : ${ requestScope.musicBean.price } <br>
<hr>
title2 : ${ musicBean.title }<br>
singer2 : ${ musicBean.singer }<br>
price2 : ${ musicBean.price }<br>
<hr>
title3 : ${ param.title }<br>
singer3 : ${ param.singer }<br>
price3 : ${ param.price }<br>
<hr>
title4 : <%= request.getParameter("title") %><br>
singer4 : <%= request.getParameter("singer") %><br>
price4 : <%= request.getParameter("price") %><br>
<hr>
title5 : <%= ((MusicBean)request.getAttribute("musicBean")).getTitle() %><br>
singer5 : <%= ((MusicBean)request.getAttribute("musicBean")).getSinger() %><br>
price5 :  <%= ((MusicBean)request.getAttribute("musicBean")).getPrice() %><br>