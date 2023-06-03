<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- member_update.jsp -->
<%@ include file="top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    function check() {
        if (f.passwd.value == "") {
            alert("비밀번호를 입력해주세요!");
            f.passwd.focus();
            return false;
        }
        return true;
    }
</script>
<div align="center">
    <hr color="green" width="300">
    <h2>회원 정보 수정</h2>
    <hr color="green" width="300">
    <form name="f" method="POST" action="memberUpdateOk_admin.do" onsubmit="return check()">
        <table width="600" border="1">
            <tr>
                <td width="150" class="m3">이름</td>
                <td class="m3">${member.name}</td>
            </tr>
            <tr>
                <td width="150" class="m3">아이디</td>
                <td class="m3">${member.id}</td>
            </tr>
            <tr>
                <td width="150" class="m3">비밀번호</td>
                <td class="m3">
                    <input type="password" name="passwd" class="box" value="${member.passwd}" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">주민등록번호</td>
                <td class="m3">${member.ssn1}-${member.ssn2}</td>
            </tr>
            <tr>
                <td width="150" class="m3">이메일</td>
                <td class="m3">
                    <input type="text" name="email" class="box" value="${member.email}" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">전화번호</td>
                <td class="m3">
                    <input type="text" name="hp1" class="box" size="3" maxlength="3" value="${member.hp1}" /> -
                    <input type="text" name="hp2" class="box" size="4" maxlength="4" value="${member.hp2}" /> -
                    <input type="text" name="hp3" class="box" size="4" maxlength="4" value="${member.hp3}" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="hidden" name="no" value="${member.no}" />
                    <input type="submit" value="수정" />
                    <button type="button" onclick="location.href='memberList_admin.do'">취소</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="bottom.jsp" %>
