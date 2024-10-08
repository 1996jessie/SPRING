<%@page import="com.spring.ex.MartBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
result.jsp<br>

id1 : <%=request.getParameter("id")%><br>
pw1 : <%=request.getParameter("pw")%><br>
product1 : 
<%
String[] parr = request.getParameterValues("product"); 
	String product = "";
	for(int i=0; i<parr.length; i++){
		product += parr[i];
		if(i != parr.length-1) {
	product += ", ";
		}
	}
%>
<%=product%><br>
time1 : <%=request.getParameter("time")%><br>
approve1 : <%=request.getParameter("approve")%><br>
agree1 : <%=request.getParameter("agree")%><br>

<hr>

id2 : ${ param.id }<br>
pw2 : ${ param.pw }<br>
product2 : 
	<c:forEach var="p" items="${ paramValues.product }" varStatus="a">
		${ p }
		<c:if test="${ !a.last }">
			, 
		</c:if>
	</c:forEach><br>
time2 : ${ param.time }<br>
approve2 : ${ param.approve }<br>
agree2 : ${ param.agree }<br>

<hr>

id3 : <%= ((MartBean)request.getAttribute("m")).getId() %><br>
pw3 : <%= ((MartBean)request.getAttribute("m")).getPw() %><br>
product3 : <%= ((MartBean)request.getAttribute("m")).getProduct() %><br>
time3 : <%= ((MartBean)request.getAttribute("m")).getTime() %><br>
approve3 : <%= ((MartBean)request.getAttribute("m")).getApprove() %><br>
agree3 : <%= ((MartBean)request.getAttribute("m")).getAgree() %><br>

<hr>

id4 : ${ m.id }<br>
pw4 : ${ m.pw }<br>
product4 : ${ m.product }<br>
time4 : ${ m.time }<br>
approve4 : ${ m.approve }<br>
agree4 : ${ m.agree }<br>