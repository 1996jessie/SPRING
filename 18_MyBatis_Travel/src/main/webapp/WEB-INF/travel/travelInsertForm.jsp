<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
travelInsertForm.jsp<br>
<%@ include file="../common/common.jsp" %>   
<style type="text/css">
	.err{
		font-size : 9pt;
		color : red;
		font-weight : bold;
	}
</style>

<%
	String [] area = {"유럽", "동남아", "일본", "중국"};
	String [] style = {"패키지", "크루즈", "자유여행", "골프여행"};
	String [] price = {"100~200", "200~300", "300~400","400~500"};
%>

<h2>Travel Information Register</h2>
<form:form commandName = "travel" action = "insert.tv" method = "post">
	<p>
	이름 : <input type = "text" name = "name" value = "${ travel.name }">
	<form:errors path = "name" cssClass = "err"></form:errors>
	</p>
	
	<p>
	나이 : <input type = "text" name = "age" value = "${ travel.age }"> 
	<form:errors path = "age" cssClass = "err"></form:errors>
	</p>
<p>
	관심 지역 : 
	<c:set var = "area" value = "<%= area %>"/>
		<c:forEach var = "i" begin = "0" end = "${ fn:length(area) -1 }">
			<input type = "checkbox" name = "area" value = "${ area[i] }" <c:if test = "${ fn:contains(travel.area, area[i]) }">checked</c:if>>${ area[i] }
		</c:forEach>
	<form:errors path = "area" cssClass = "err"></form:errors>
	</p>
	
	<p>
	여행 타입 : 
 		<c:set var = "style" value = "<%=style %>"/>
		<c:forEach var = "i" begin = "0" end = "${ fn:length(style) -1 }">
			<input type = "radio" name = "style" value = "${ style[i] }"  <c:if test = "${ travel.style eq style[i] }">checked</c:if>>${ style[i] }
		</c:forEach> 
	<form:errors path = "style" cssClass = "err"></form:errors>
	</p>
	<p>
	가격 : 
		<select name = "price">
			<option value = ""> 선택하세요 </option>
			
	<c:set var = "price" value = "<%= price %>"/>
 		<c:forEach var = "i" begin = "0" end = "${ fn:length(price) -1 }">
			<option value = "${ price[i] }" <c:if test = "${ travel.price eq price[i] }">selected</c:if> >${ price[i] } </option>
		</c:forEach> 
	</select>
	<form:errors path = "price" cssClass = "err"></form:errors>
	</p>
	
	<p>
		<input type = "submit" value = "추가하기">
	</p>
</form:form>