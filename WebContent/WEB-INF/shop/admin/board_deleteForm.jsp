<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- board_deleteForm.jsp -->
<%@ include file="../display/mall_top.jsp" %>
<c:set var="num" value="${param.num}" />
<c:if test="${empty num}">
    <c:redirect url="boardList1_admin.do" />
</c:if>

<div align="center">
    <form name="f" action="boardDeletePro_admin.do" method="post">
        <input type="hidden" name="num" value="${num}"/>
        <table border="300">
            <tr bgcolor="yellow" style="width: 500px;">
			    <th style="width: 500px;">��й�ȣ�� �Է����ּ���</th>
			</tr>
			<tr>
			    <td align="center" style="width: 500px;">
			        ��й�ȣ : <input type="password" name="passwd"> 
			    </td>
			</tr>
			<tr bgcolor="yellow" style="width: 500px;">
			    <td align="center" style="width: 500px;">
			        <input type="submit" value="�����ϱ�">
			        <input type="button" value="�������" onclick="window.location='boardList1_admin.do'">
			    </td>
			</tr>
        </table>
    </form>
</div>