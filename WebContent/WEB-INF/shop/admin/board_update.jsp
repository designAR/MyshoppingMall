<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ include file="../display/mall_top.jsp" %>
<!-- board_update.jsp -->

<script type="text/javascript">
    function check() {
        if (document.f.writer.value == "") {
            alert("�ۼ��ڸ� �Է����ּ���!!");
            document.f.writer.focus();
            return false;
        }
        if (document.f.subject.value == "") {
            alert("������ �Է����ּ���!!");
            document.f.subject.focus();
            return false;
        }
        if (document.f.content.value == "") {
            alert("������ �Է����ּ���!!");
            document.f.content.focus();
            return false;
        }
        if (document.f.passwd.value == "") {
            alert("��й�ȣ�� �Է����ּ���!!");
            document.f.passwd.focus();
            return false;
        }
        return true;
    }
</script>
<div align="center">
     <form name="f" action="boardUpdateOk_admin.do" method="post" onsubmit="return check()">
        <h2>�Խñ� �����ϱ�</h2>
        <input type="hidden" name="num" value="${dto.num}" />
        <table border="1" width="70%">
            <tr>
                <th width="20%" bgcolor="yellow">�ۼ���</th>
                <td width="80%"><input type="text" name="writer" value="${dto.writer}" /></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">����</th>
                <td width="80%"><input type="text" name="subject" size="50" value="${dto.subject}" /></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">Email</th>
                <td width="80%"><input type="text" name="email" size="50" value="${dto.email}" /></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">����</th>
                <td width="80%"><textarea name="content" rows="11" cols="50">${dto.content}</textarea></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">��й�ȣ</th>
                <td width="80%"><input type="password" name="passwd" /></td>
            </tr>
            <tr bgcolor="yellow">
                <td colspan="2" align="center">
                    <input type="submit" value="�����ϱ�" />
                    <input type="reset" value="�ٽ��ۼ�" />
                    <a href="boardList1_admin.do"><input type="button" value="�������"/></a>
                </td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="../display/mall_bottom.jsp" %>
