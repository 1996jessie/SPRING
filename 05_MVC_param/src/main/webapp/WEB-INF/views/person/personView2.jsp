<%@page import="com.spring.ex.bean.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
personView2.jsp<br>

id : ${ requestScope.personBean.id }<br>
pw : ${ requestScope.personBean.getPw() }<br>
name : ${ personBean.name }<br>
addr : <%= ((PersonBean)request.getAttribute("personBean")).getAddr() %>