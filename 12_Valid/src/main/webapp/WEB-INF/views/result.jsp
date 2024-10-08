<%@page import="com.spring.ex.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
result.jsp <br>

title1 : <%= request.getParameter("title") %><br>
author1 : <%= request.getParameter("author") %><br>
price1 : <%= request.getParameter("price") %><br>
publisher1 : <%= request.getParameter("publisher") %><br>
bookstore1 : 
<% 
	String[] barr = request.getParameterValues("bookstore"); 
	String bookstore = "";
	for(int i=0; i<barr.length; i++){
		bookstore += barr[i];
		if(i != barr.length-1) {
			bookstore += ", ";
		}
	}
%>
<%= bookstore %> <br>
kind1 : <%= request.getParameter("kind") %>

<hr>

title2 : ${ param.title }<br>
author2 : ${ param.author }<br>
price2 : ${ param.price }<br>
publisher2 : ${ param.publisher }<br>
bookstore2 :  
<c:forEach var="b" items="${ paramValues.bookstore }" varStatus="a">
	${ b }
	<c:if test="${ !a.last }">
		, 
	</c:if>
</c:forEach><br>
kind2 : ${ param.kind }<br>

<hr>

title3 : <%= ((BookBean)request.getAttribute("book")).getTitle() %><br>
author3 : <%= ((BookBean)request.getAttribute("book")).getAuthor() %><br>
price3 : <%= ((BookBean)request.getAttribute("book")).getPrice() %> <br>
publisher3 : <%= ((BookBean)request.getAttribute("book")).getPublisher() %><br>
bookstore3 : <%= ((BookBean)request.getAttribute("book")).getBookstore() %><br>
kind3 : <%= ((BookBean)request.getAttribute("book")).getKind() %><br>

<hr>

title4 : ${ book.getTitle() }<br>
author4 : ${ book.author }<br>
price4 : ${ book.price }<br>
publisher4 : ${ book.publisher }<br>
bookstore4 : ${ book.bookstore }<br> <!-- 자동으로 , 붙어서 나옴 -->
kind4 : ${ book.kind }<br>

<hr>    

    	    
    
    
    
    
    
    
    