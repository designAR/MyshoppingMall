<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!-- board_list -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../display/mall_top.jsp" %>
<div align="center">
    <b>게시판 목록</b>
    <table border="0" width="100%">
        <tr bgcolor="yellow">
            <td align="right"><a href="boardInsertForm_admin.do">글쓰기</a></td>
        </tr>
    </table>
    <table border="1" width="100%">
        <tr bgcolor="green">
            <th>번호</th>
            <th width="30%">제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회</th>
            <th>IP</th>
        </tr>
        <c:if test="${empty listBoard}">
            <tr>
                <td colspan="6">현재 등록된 게시물이 없습니다.</td>
            </tr>
        </c:if>
        <c:forEach items="${listBoard}" var="dto">
		    <tr>
		        <td>${dto.num}</td>
		        <td>
				    <a href="boardContent_admin.do?num=${dto.num}">${dto.subject}</a> 
				</td>
		        <td>${dto.writer}</td>
		        <td>${dto.reg_date}</td>
		        <td>${dto.readcount}</td>
		        <td>${dto.ip}</td>
		    </tr>
		</c:forEach>
    </table>
</div>
<%@ include file="../display/mall_bottom.jsp" %>
