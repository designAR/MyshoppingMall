<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="../display/mall_top.jsp" %>
<!-- member_input.jsp -->
<script type="text/javascript">
    function check() {
        if (f.name.value == "") {
            alert("이름을 입력해주세요!");
            f.name.focus();
            return false;
        }
        if (f.id.value == "") {
            alert("아이디를 입력해주세요!");
            f.id.focus();
            return false;
        }
        if (f.passwd.value == "") {
            alert("비밀번호를 입력해주세요!");
            f.passwd.focus();
            return false;
        }
        if (f.ssn1.value == "" || f.ssn2.value == "") {
            alert("주민등록번호를 입력해주세요!");
            f.ssn1.focus();
            return false;
        }
        if (f.email.value == "") {
            alert("이메일을 입력해주세요!");
            f.email.focus();
            return false;
        }
        if (f.hp1.value == "" || f.hp2.value == "" || f.hp3.value == "") {
            alert("전화번호를 입력해주세요!");
            f.hp1.focus();
            return false;
        }
        return true;
    }
</script>
<div align="center">
    <hr color="green" width="300">
    <h2>회원 가입</h2>
    <hr color="green" width="300">
    <form action="memberInputOk_admin.do" method="post">
        <table width="600" border="1">
            <tr>
                <td width="150" class="m3">이름</td>
                <td class="m3">
                    <input type="text" name="name" class="box" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">아이디</td>
                <td class="m3">
                    <input type="text" name="id" class="box" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">비밀번호</td>
                <td class="m3">
                    <input type="password" name="passwd" class="box" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">주민등록번호</td>
                <td class="m3">
                    <input type="text" name="ssn1" class="box" size="6" maxlength="6" /> -
                    <input type="password" name="ssn2" class="box" size="7" maxlength="7" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">이메일</td>
                <td class="m3">
                    <input type="text" name="email" class="box" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">전화번호</td>
                <td class="m3">
                    <input type="text" name="hp1" class="box" size="3" maxlength="3" /> -
                    <input type="text" name="hp2" class="box" size="4" maxlength="4" /> -
                    <input type="text" name="hp3" class="box" size="4" maxlength="4" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="가입" />
                    <button type="button" onclick="location.href='memberList_admin.do'">취소</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="../display/mall_bottom.jsp" %>

