<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>    

cafeList.jsp<br>

<script type="text/javascript">
	function insert(){
		location.href="insert.cf";
	}
</script>

<h1 align="center">주문 리스트 화면(${ pageInfo.totalCount })</h1>
	    <form action="list.cf" align="center">
			<select name="whatColumn">
				<option value="all">전체 검색
				<option value="category">구분
				<option value="temp">온도
				<option value="amount">수량
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>
    <table border="1" align="center">
    	<tr>
    		<td colspan="9" align="right">
    			<input type="button" value="추가하기" onClick="insert()">
    		</td>
    	</tr>
    	<tr>
    		<th>번호</th>
    		<th>구분</th>
    		<th>메뉴</th>
    		<th>온도</th>
    		<th>수량</th>
    		<th>요청사항</th>
    		<th>수정</th>
    		<th>삭제</th>
    	</tr>
    	
    	<c:forEach var="cf" items="${ cafeList }">
    		
    		<tr>
    			<td>
    				<a href="detail.cf?num=${ cf.num }&pageNumber=${ pageInfo.pageNumber }&whatColumn=${ param.whatColumn }&keyword=${ param.keyword }">
    					${ cf.num }
    				</a>
    			</td>
    			<td>
    				${ cf.category }
    			</td>
    			<td>
    				<a href="detail.cf?num=${ cf.num }&pageNumber=${ pageInfo.pageNumber }&whatColumn=${ param.whatColumn }&keyword=${ param.keyword }">
    					${ cf.menu }
    				</a>
    			</td>
    			<td>${ cf.temp }</td>
    			<td>${ cf.amount }</td>
    			<td>${ cf.req }</td>
    			<td><a href="update.cf?num=${ cf.num }&pageNumber=${ pageInfo.pageNumber }&whatColumn=${ whatColumn }&keyword=${ keyword }">수정</a></td>
    			<td><a href="delete.cf?num=${ cf.num }&pageNumber=${ pageInfo.pageNumber }&whatColumn=${ whatColumn }&keyword=${ keyword }">삭제</a></td>
    		</tr>
    		
    	</c:forEach>
    	
    </table>
    <br><br>
    <center>
    ${ pageInfo.pagingHtml }
    </center>
    
    