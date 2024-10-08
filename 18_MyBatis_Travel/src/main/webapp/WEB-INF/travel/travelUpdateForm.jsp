<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %> 
<style type="text/css">
	.err{
		font-size : 9pt;
		color : red;
		font-weight : bold;
	}
</style>
    
travelUpdateForm.jsp<br>
<h1>여행 정보 수정 화면(${ travel.num})</h1>
넘어온 페이지 번호 : ${ requestScope.pageNumber } <br>

<form:form commandName="travel" method="post" action="update.tv">
		<input type="hidden" name="num" value="${ travel.num }">
		<input type="hidden" name="pageNumber" value="${ pageNumber }">
	<p>
	이름 : <input type="text" name="name" value="${ travel.name }">
		<form:errors path="name" cssClass="err" />
	</p>
	
	<p>
	나이 : <input type="text" name="age" value="${ travel.age }">
		<form:errors path="age" cssClass="err" />
	</p>
	
	<p>
	<% String[] area = {"유럽", "동남아", "일본", "중국"}; %>
	관심지역 : 
		<c:forEach var="area" items="<%= area %>">
			<input type="checkbox" name="area" value="${ area }"
				<c:if test="${ fn:contains(travel.area, area) }">checked</c:if>> ${ area }
		</c:forEach>
		<form:errors path="area" cssClass="err" />
	</p>
	<p>
	<% String[] style = {"패키지", "크루즈", "자유여행", "골프여행"}; %>
	여행타입(${ tb.style }) : 
		<c:forEach var="style" items="<%= style %>">
			<input type="radio" name="style" value="${ style }"
				<c:if test="${ fn:contains(travel.style, style) }">checked</c:if>> ${ style }
		</c:forEach>
		<form:errors path="style" cssClass="err" />
	</p>
	
	<p>
	<% String[] price = {"100~200", "200~300", "300~400", "400~500"}; %>
	가격(${ travel.price }) : 
		<select name="price">
			<option value="">선택</option>
			<c:forEach var="price" items="<%= price %>">
				<option value="${ price }" <c:if test="${ travel.price eq price }">selected</c:if>> ${ price }
			</c:forEach>
		</select>
		<form:errors path="price" cssClass="err" />
	</p>
	
	<p>
		<input type="submit" value="수정하기">
	</p>
</form:form>
