<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>    
MemberUpdateController=> memberUpdateForm.jsp<br>
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

<h2 align="center">회원 수정 화면</h2>
<form:form commandName="member" action="update.mb" method="post">
		<input type="hidden" name="id" value="${ member.id }">
		<input type="hidden" name="pageNumber" value="${ param.pageNumber }">
		<input type="hidden" name="whatColumn" value="${ param.whatColumn }">
		<input type="hidden" name="keyword" value="${ param.keyword }">
<table border="1" align="center" width="60%" height="30%">
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="id" value="${ member.id }" disabled>
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
		<th>취미</th>
		<td>
			<%String [] hobby = {"마라톤","영화감상","게임","공부"}; %>
			<c:forEach var="hobby" items="<%= hobby %>">
			<input type="checkbox" name="hobby" value="${ hobby }" <c:if test="${ fn:contains(member.hobby , hobby) }">checked</c:if>>${ hobby }
			</c:forEach>
			<form:errors path="hobby" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>주소1</th>
		<td>
			<input type="text" name="address1" value="${ member.address1 }">
			<form:errors path="address1" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>주소2</th>
		<td>
			<input type="text" name="address2" value="${ member.address2 }">
			<form:errors path="address2" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>적립포인트</th>
		<td>
			<input type="text" name="mpoint" value="${ member.mpoint }">
			<form:errors path="mpoint" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="수정하기"></td>
	</tr>
	</table>
</form:form>
 

