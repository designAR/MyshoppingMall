<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- member_list.jsp -->
<%@ include file="top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function checkDel(no) {
		var isDel = window.confirm("���� �����Ͻðڽ��ϱ�?");
		if (isDel) {
			location.href = "memberDelete_admin.do?no=" + no;
		}
	}
</script>
<div align="center">
	<hr color="green" width="300">
	<h2>ȸ�� ���</h2>
	<hr color="green" width="300">
	<table border="1" width="100%">
		<tr bgcolor="yellow">
			<th>�̸�</th>
			<th>���̵�</th>
			<th>��й�ȣ</th>
			<th>�ֹε�Ϲ�ȣ</th>
			<th>�̸���</th>
			<th>��ȭ��ȣ</th>
			<th>������</th>
			<th>���� | ����</th>
		</tr>
		<jsp:useBean id="memberDAO" class="myshop.admin.dao.MemberDAO" />
		<c:if test="${empty listMember}">
			<tr>
				<td colspan="9">��ϵ� ȸ���� �����ϴ�.</td>
			</tr>
		</c:if>
		<c:if test="${not empty listMember}">
			<c:set var="count" value="1" />
			<c:forEach var="member" items="${listMember}">
				<tr>
					<td>${member.name}</td>
					<td>${member.id}</td>
					<td>${member.passwd}</td>
					<td>${member.ssn1}-${member.ssn2}</td>
					<td>${member.email}</td>
					<td>${member.allHp}</td>
					<td>${member.joindate}</td>
					<td>
						<a href="memberUpdate_admin.do?no=${member.no}">����</a> | 
						<a href="javascript:checkDel('${member.no}')">����</a>
					</td>
				</tr>
				<c:set var="count" value="${count + 1}" />
			</c:forEach>
		</c:if>
	</table>
</div>
<%@ include file="bottom.jsp" %>
