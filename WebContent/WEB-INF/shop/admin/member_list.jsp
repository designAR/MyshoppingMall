<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- member_list.jsp -->
<%@ include file="top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function checkDel(no) {
		var isDel = window.confirm("정말 삭제하시겠습니까?");
		if (isDel) {
			location.href = "memberDelete_admin.do?no=" + no;
		}
	}
</script>
<div align="center">
	<hr color="green" width="300">
	<h2>회원 목록</h2>
	<hr color="green" width="300">
	<table border="1" width="100%">
		<tr bgcolor="yellow">
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>주민등록번호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>가입일</th>
			<th>수정 | 삭제</th>
		</tr>
		<jsp:useBean id="memberDAO" class="myshop.admin.dao.MemberDAO" />
		<c:if test="${empty listMember}">
			<tr>
				<td colspan="9">등록된 회원이 없습니다.</td>
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
						<a href="memberUpdate_admin.do?no=${member.no}">수정</a> | 
						<a href="javascript:checkDel('${member.no}')">삭제</a>
					</td>
				</tr>
				<c:set var="count" value="${count + 1}" />
			</c:forEach>
		</c:if>
	</table>
</div>
<%@ include file="bottom.jsp" %>
