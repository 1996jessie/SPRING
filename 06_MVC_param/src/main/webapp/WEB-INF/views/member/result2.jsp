<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result2.jsp<br>

id1 : ${ requestScope.id } <br>
pw1 : ${ requestScope.pw } <br>

id2 : <%= request.getAttribute("id") %><br>
pw2 : <%= request.getAttribute("pw") %><br>

id3 : ${ id }<br>
pw3 : ${ pw }<br>


id4: ${ param.id }<br>
pw4: ${ param.pw }<br>

id5 : <%= request.getParameter("id") %><br>
pw5 : <%= request.getParameter("pw") %><br>