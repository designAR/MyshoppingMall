<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!-- content.jsp -->
<%@ include file="../display/mall_top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty param.num}">
    <c:redirect url="boardList1_admin.do" />
</c:if>

<c:set var="num" value="${param.num}" />
<c:set var="dto" value="${dto}" scope="request" /> 

<div align="center">
    <b>�Խñ� ��</b>
    <table border="1" width="100%">
        <tr>
            <th bgcolor="yellow" width="20%">�۹�ȣ</th>
            <td width="30%"><c:out value="${dto.num}" /></td>
            <th bgcolor="yellow" width="20%">��ȸ��</th>
            <td width="30%"><c:out value="${dto.readcount}" /></td>
        </tr>
        <tr>
            <th bgcolor="yellow" width="20%">�ۼ���</th>
            <td width="30%"><c:out value="${dto.writer}" /></td>
            <th bgcolor="yellow" width="20%">�ۼ���</th>
            <td width="30%"><c:out value="${dto.reg_date}" /></td>
        </tr>
        <tr>
            <th bgcolor="yellow" width="20%">����</th>
            <td width="80%" colspan="3"><c:out value="${dto.subject}" /></td>
        </tr>
        <tr>
            <th bgcolor="yellow" width="20%">����</th>
            <td width="80%" colspan="3"><c:out value="${dto.content}" /></td>
        </tr>

        <tr bgcolor="yellow">
            <td colspan="4" align="right">
                <a href="boardUpdate_admin.do?num=${dto.num}"><input type="button" value="�����ϱ�"></a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href= "boardDeleteForm_admin.do?num=${dto.num}"><input type="button" value="�����ϱ�"></a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="boardList1_admin.do"><input type="button" value="�������"></a>
            </td>
        </tr>
    </table>
</div>

<%@ include file="../display/mall_bottom.jsp" %>
