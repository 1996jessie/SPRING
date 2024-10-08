<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person\personView.jsp<br>

id1 : ${ param.id }<br>
pw1 : ${ param.pw }<br>
name1 : ${ param.name }<br>
addr1 : ${ param.addr }<br>
<br>
id2 : <%= request.getParameter("id") %><br>
pw2 : <%= request.getParameter("pw") %><br>
name2 : <%= request.getParameter("name") %><br>
addr2 : <%= request.getParameter("addr") %><br>
<br>
id3 : ${ pb.id }<br>
pw3 : ${ pb.pw }<br>
name3 : ${ pb.name }<br>
addr3 : ${ pb.addr }<br>

