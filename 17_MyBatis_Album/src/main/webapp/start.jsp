<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

start.jsp<br>

<%
String viewPage = request.getContextPath()+"/list.ab";
response.sendRedirect(viewPage);
%>

<%-- <% response.sendRedirect("list.ab"); %> --%>


<%-- <jsp:forward page ="list.ab"/>  --%>
