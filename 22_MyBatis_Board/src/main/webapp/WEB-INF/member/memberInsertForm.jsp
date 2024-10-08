<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>    
memberInsertForm.jsp<br>

<style>
	h2{
		text-align: center;
	}
	table {
		font-family: "나눔스퀘어 네오";
		border-collapse: collapse;
		margin: 0 auto;
	}
	th { 
		text-align: center;
		padding: 5px 5px;
		background-color: #E6E6FA;
	}
	tr:last-child td {
		text-align: center;		
	}		
	.err{
		color: red;
		font-size: 14px;
	}
</style>

<c:if test="${ not empty message }">
	<script type="text/javascript">
		alert("${ message }");
	</script>
</c:if>

<h2 align="center">회원 가입 화면</h2>
<form:form commandName="member" action="insert.mb" method="post">
<table border="1" align="center" width="60%" height="30%">
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="id" value="${ member.id }">
			<form:errors path="id" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>
			<input type="text" name="name" value="${ member.name }">
			<form:errors path="name" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>비번</th>
		<td>
			<input type="text" name="password" value="${ member.password }">
			<form:errors path="password" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>성별</th>
		<td>
			<% String[] gender = {"여자","남자"}; %>
				<c:forEach var="gender" items="<%= gender %>">
					<input type="radio" name="gender" value="${ gender }" <c:if test="${ member.gender eq gender }">checked</c:if>>${ gender }
				</c:forEach>
			<form:errors path="gender" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>관심사</th>
		<td>
			<% String [] interest = {"아시아","유럽","아프리카","미주"}; %>
			<c:forEach var="interest" items="<%= interest %>">
			<input type="checkbox" name="interest" value="${ interest }" <c:if test="${ fn:contains(member.interest , interest) }">checked</c:if>>${ interest }
			</c:forEach>
			<form:errors path="interest" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>직업</th>
		<td>
			<% String [] job = {"학생","직장인","무직"}; %>
			<c:set var="job" value="<%= job %>"/>
			<select name = "job">
				<option value="">선택</option>
				<c:forEach var="j" begin="0" end="${ fn:length(job)-1 }">
					<option value="${ job[j] }" <c:if test="${ member.job eq job[j] }">selected</c:if>>${ job[j] }</option>
				</c:forEach>
			</select>
			<form:errors path="job" cssClass="err"/>
		</td>
	<tr>
	<tr>
		<th>주소</th>
		<td>
			<input type="text" name="address" value="${ member.address }">
			<form:errors path="address" cssClass="err"/>
		</td>
	</tr>
		<td colspan="2"><input type="submit" value="추가하기"></td>
	</tr>
	</table>
</form:form>
 

