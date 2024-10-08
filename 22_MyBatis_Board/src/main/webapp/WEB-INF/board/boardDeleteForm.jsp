<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>     
boardDeleteForm.jsp<br>
${ param.num } / ${ param.pageNumber } / ${ param.whatColumn } / ${ param.keyword } 
<script type="text/javascript">
	function check(){
		if(delForm.passwd.value == "") {
			alert("비밀번호를 입력하세요.");
			delForm.passwd.focus();
			return false;
		}
	}
</script>

	<form name = "delForm" action="delete.bd?num=${ param.num }&pageNumber=${ param.pageNumber }&whatColumn=${ param.whatColumn }&keyword=${ param.keyword }" method = "post">
		<table border = 1 width = "200">
			<tr>
				<td>비밀번호를 입력해 주세요.</td>
			</tr>
			<tr>
				<td><input type = "password" name = "passwd"></td>
			</tr>
			<tr>
				<td>
					<input type = "submit" value = "글삭제" onClick = "return check()">
					<input type = "button" value = "글목록" onClick = "location.href = 'boardList.bd?pageNum=${ param.pageNumber }'">
				</td>
			</tr>
		
		</table>
	
	
	</form>