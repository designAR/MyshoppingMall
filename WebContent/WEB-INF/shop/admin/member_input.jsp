<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="../display/mall_top.jsp" %>
<!-- member_input.jsp -->
<script type="text/javascript">
    function check() {
        if (f.name.value == "") {
            alert("�̸��� �Է����ּ���!");
            f.name.focus();
            return false;
        }
        if (f.id.value == "") {
            alert("���̵� �Է����ּ���!");
            f.id.focus();
            return false;
        }
        if (f.passwd.value == "") {
            alert("��й�ȣ�� �Է����ּ���!");
            f.passwd.focus();
            return false;
        }
        if (f.ssn1.value == "" || f.ssn2.value == "") {
            alert("�ֹε�Ϲ�ȣ�� �Է����ּ���!");
            f.ssn1.focus();
            return false;
        }
        if (f.email.value == "") {
            alert("�̸����� �Է����ּ���!");
            f.email.focus();
            return false;
        }
        if (f.hp1.value == "" || f.hp2.value == "" || f.hp3.value == "") {
            alert("��ȭ��ȣ�� �Է����ּ���!");
            f.hp1.focus();
            return false;
        }
        return true;
    }
</script>
<div align="center">
    <hr color="green" width="300">
    <h2>ȸ�� ����</h2>
    <hr color="green" width="300">
    <form action="memberInputOk_admin.do" method="post">
        <table width="600" border="1">
            <tr>
                <td width="150" class="m3">�̸�</td>
                <td class="m3">
                    <input type="text" name="name" class="box" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">���̵�</td>
                <td class="m3">
                    <input type="text" name="id" class="box" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">��й�ȣ</td>
                <td class="m3">
                    <input type="password" name="passwd" class="box" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">�ֹε�Ϲ�ȣ</td>
                <td class="m3">
                    <input type="text" name="ssn1" class="box" size="6" maxlength="6" /> -
                    <input type="password" name="ssn2" class="box" size="7" maxlength="7" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">�̸���</td>
                <td class="m3">
                    <input type="text" name="email" class="box" />
                </td>
            </tr>
            <tr>
                <td width="150" class="m3">��ȭ��ȣ</td>
                <td class="m3">
                    <input type="text" name="hp1" class="box" size="3" maxlength="3" /> -
                    <input type="text" name="hp2" class="box" size="4" maxlength="4" /> -
                    <input type="text" name="hp3" class="box" size="4" maxlength="4" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="����" />
                    <button type="button" onclick="location.href='memberList_admin.do'">���</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="../display/mall_bottom.jsp" %>

