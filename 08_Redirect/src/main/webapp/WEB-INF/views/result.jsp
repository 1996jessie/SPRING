<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result.jsp<br>

name1 : ${ param.name }<br>
name2 : <%= request.getParameter("name") %><br>
<hr>
name1 : ${ param.rname } <br>
name2 : <%= request.getAttribute("rname") %><br>
name3 : ${ requestScope.rname }<br>
<hr>
name1 : ${ param.mname }<br> <!-- 이 방법만 가능 -->
name2 : <%= request.getAttribute("mname") %><br>
name3 : ${ requestScope.mname }<br>
<hr>
name1 : ${ mapAttr.map_name }<br>

