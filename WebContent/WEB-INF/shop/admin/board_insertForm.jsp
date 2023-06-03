<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="../display/mall_top.jsp" %>
<!-- board_insertForm.jsp -->
<script type="text/javascript">
    function check() {
        if (f.writer.value == "") {
            alert("작성자를 입력해주세요!");
            f.writer.focus();
            return false;
        }
        if (f.subject.value == "") {
            alert("제목을 입력해주세요!");
            f.subject.focus();
            return false;
        }
        if (f.content.value == "") {
            alert("내용을 입력해주세요!");
            f.content.focus();
            return false;
        }
        if (f.passwd.value == "") {
            alert("비밀번호를 입력해주세요!");
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
                <td align="center" colspan="2">글 작성</td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">작성자</th>
                <td width="80%"><input type="text" name="writer"></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">제목</th>
                <td width="80%"><input type="text" name="subject" size="50"></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">Email</th>
                <td width="80%"><input type="text" name="email" size="50"></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">내용</th>
                <td width="80%"><textarea name="content" rows="11" cols="50"></textarea></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">비밀번호</th>
                <td width="80%"><input type="password" name="passwd"></td>
            </tr>
            <tr bgcolor="yellow">
                <td colspan="2" align="center">
                    <input type="submit" value="작성하기">
                    <input type="reset" value="다시쓰기">
                    <input type="button" value="목록으로" onclick="window.location='boardList1_admin.do'">
                </td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="../display/mall_bottom.jsp" %>
