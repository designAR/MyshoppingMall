<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!-- board_list -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../display/mall_top.jsp" %>
<div align="center">
    <b>�Խ��� ���</b>
    <table border="0" width="100%">
        <tr bgcolor="yellow">
            <td align="right"><a href="boardInsertForm_admin.do">�۾���</a></td>
        </tr>
    </table>
    <table border="1" width="100%">
        <tr bgcolor="green">
            <th>��ȣ</th>
            <th width="30%">����</th>
            <th>�ۼ���</th>
            <th>�ۼ���</th>
            <th>��ȸ</th>
            <th>IP</th>
        </tr>
        <c:if test="${empty listBoard}">
            <tr>
                <td colspan="6">���� ��ϵ� �Խù��� �����ϴ�.</td>
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
