<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result3.jsp<br>

id1 : ${ requestScope.id } <br>
pw1 : ${ requestScope.pw } <br>
addr1 : ${ requestScope.addr } <br>
age1 : ${ requestScope.age } <br>

id2 : <%= request.getAttribute("id") %><br>
pw2 : <%= request.getAttribute("pw") %><br>
addr2 : <%= request.getAttribute("addr") %><br>
age2 : <%= request.getAttribute("age") %><br>

id3 : ${ id }<br>
pw3 : ${ pw }<br>
addr3 : ${ addr }<br>
age3 : ${ age }<br>

id4: ${ param.id }<br>
pw4: ${ param.pw }<br>
addr4: ${ param.addr }<br>
age4: ${ param.age }<br>

id5 : <%= request.getParameter("id") %><br>
pw5 : <%= request.getParameter("pw") %><br>
addr5 : <%= request.getParameter("addr") %><br>
age5 : <%= request.getParameter("age") %><br>

<hr>

id6 : ${ mb.id }<br>
pw6 : ${ mb.getPw() }<br>
addr6 : ${ requestScope.mb.addr }<br>
age6 : ${ requestScope.mb.getAge() }<br>
    