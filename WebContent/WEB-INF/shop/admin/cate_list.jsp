<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- cate_list.jsp -->
<%@ include file="top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<font size="4">카테고리 목록</font><br>
	<table border="1" width="500">
		<tr bgcolor="yellow">
			<th width="10%">번호</th>
			<th width="30%">카테고리코드</th>
			<th width="50%">카테고리명</th>
			<th width="10%">삭제</th>
		</tr>
	<c:if test="${empty listCate}">
		<tr>
			<td colspan="3">등록된 카테고리가 없습니다.</td>
		</tr>
	</c:if>		
	<c:forEach var="dto" items="${listCate}">
		<tr>
			<td>${dto.cnum}</td>
			<td>${dto.code}</td>
			<td>${dto.cname}</td>
			<td><a href="cateDelete_admin.do?cnum=${dto.cnum}">삭제</a></td>
		</tr>
	</c:forEach>
	</table>
</div>
<%@ include file="bottom.jsp"%>