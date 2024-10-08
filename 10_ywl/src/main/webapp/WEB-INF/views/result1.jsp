<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result1.jsp<br>

title1 : ${ requestScope.title } <br>
author1 : ${ requestScope.author } <br>
price1 : ${ requestScope.price } <br>
publisher1 : ${ requestScope.publisher } <br>
<hr>
title2 : <%= request.getAttribute("title") %><br>
author2 : <%= request.getAttribute("author") %><br>
price2 : <%= request.getAttribute("price") %><br>
publisher2 : <%= request.getAttribute("publisher") %><br>
<hr>
title3 : ${ title }<br>
author3 : ${ author }<br>
price3 : ${ price }<br>
publisher3 : ${ publisher }
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