<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/common/common.jsp" %>    
main.jsp<br>

<%
	String viewBoard = request.getContextPath() + "/boardList.bd";
	String viewMember = request.getContextPath() + "/memberList.mb";
%>

<a href = "<%= viewBoard %>"> 게시판 바로가기 </a>
<br>
<a href = "<%= viewMember %>"> 회원 목록 바로가기 </a>

