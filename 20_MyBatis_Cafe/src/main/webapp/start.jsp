<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

start.jsp<br>

<%
String viewPage = request.getContextPath()+"/list.cf";
response.sendRedirect(viewPage);
%>

<%-- <% response.sendRedirect("list.cf"); %> --%>

<%-- <jsp:forward page ="list.cf"/>  --%>
