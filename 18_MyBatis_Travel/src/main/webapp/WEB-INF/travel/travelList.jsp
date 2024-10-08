<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/common.jsp" %>    
web-inf\travel\travelList.jsp<br>

	<script type="text/javascript">
		function insert(){
			location.href="insert.tv";
		}
		
		function update(num,pageNumber) {
			location.href = "update.tv?num=" + num+ "&pageNumber=" + pageNumber;
		}
	</script>
<center>	
<h2 align="center">여행 리스트 화면(전체 레코드갯수:${ pageInfo.totalCount }/${ totalCount })</h2>
현재 클릭한 페이지번호 : ${ pageInfo.pageNumber } <br>
<form action="list.tv">
   <select name="whatColumn">
      <option value="">전체검색
      <option value="area">지역
      <option value="style">여행타입
   </select>
   <input type="text" name="keyword" value="">
   <input type="submit" value="검색">
</form>
</center>   
<table border="1" align="center">
	<tr>
		<td colspan="8" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>지역</th>
		<th>스타일</th>
		<th>가격</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="travel" items="${ lists }">
		<tr>
			<td>${ travel.num }</td>
			<td>${ travel.name }</td>
			<td>${ travel.age }</td>
			<td>${ travel.area }</td>
			<td>${ travel.style }</td>
			<td>${ travel.price }</td>
			<td>
				<input type="button" value="수정" onClick="update('${ travel.num }', '${ pageInfo.pageNumber }')">
			</td>
			
			<td>
				<a href="delete.tv?num=${ travel.num }&pageNumber=${ pageInfo.pageNumber }">삭제</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br><br>
<center>
${ pageInfo.pagingHtml }
</center>
<!-- 
<a href="list.tv?pageNumber=1&pageSize=2&whatColumn=area&keyword=남">1</a>
<a href="list.tv?pageNumber=2&pageSize=2&whatColumn=area&keyword=남">2</a>
 -->
 