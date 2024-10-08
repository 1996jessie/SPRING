<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result3.jsp<br>

title1 : ${ requestScope.title } <br>
singer1 : ${ requestScope.singer } <br>
price1 : ${ requestScope.price } <br>
<hr>
title2 : <%= request.getAttribute("title") %><br>
singer2 : <%= request.getAttribute("singer") %><br>
price2 : <%= request.getAttribute("price") %><br>
<hr>
title3 : ${ title }<br>
singer3 : ${ singer }<br>
price3 : ${ price }<br>
<hr>
title4 : ${ param.title }<br>
singer4 : ${ param.singer }<br>
price4 : ${ param.price }<br>
<hr>
title5 : <%= request.getParameter("title") %><br>
singer5 : <%= request.getParameter("singer") %><br>
price5 : <%= request.getParameter("price") %><br>
<hr>
title6: ${ mb.title }<br>
singer6: ${ mb.getSinger() }<br>
price6: ${ mb.price }<br>
