<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="../display/mall_top.jsp" %>
<!-- board_insertForm.jsp -->
<script type="text/javascript">
    function check() {
        if (f.writer.value == "") {
            alert("�ۼ��ڸ� �Է����ּ���!");
            f.writer.focus();
            return false;
        }
        if (f.subject.value == "") {
            alert("������ �Է����ּ���!");
            f.subject.focus();
            return false;
        }
        if (f.content.value == "") {
            alert("������ �Է����ּ���!");
            f.content.focus();
            return false;
        }
        if (f.passwd.value == "") {
            alert("��й�ȣ�� �Է����ּ���!");
            f.passwd.focus();
            return false;
        }
        return true;
    }
</script>
<div align="center">
    <form name="f" action="boardInsertPro_admin.do" method="post" onsubmit="return check()">
        <table border="1" width="70%">
            <tr bgcolor="yellow">
                <td align="center" colspan="2">�� �ۼ�</td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">�ۼ���</th>
                <td width="80%"><input type="text" name="writer"></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">����</th>
                <td width="80%"><input type="text" name="subject" size="50"></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">Email</th>
                <td width="80%"><input type="text" name="email" size="50"></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">����</th>
                <td width="80%"><textarea name="content" rows="11" cols="50"></textarea></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">��й�ȣ</th>
                <td width="80%"><input type="password" name="passwd"></td>
            </tr>
            <tr bgcolor="yellow">
                <td colspan="2" align="center">
                    <input type="submit" value="�ۼ��ϱ�">
                    <input type="reset" value="�ٽþ���">
                    <input type="button" value="�������" onclick="window.location='boardList1_admin.do'">
                </td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="../display/mall_bottom.jsp" %>
