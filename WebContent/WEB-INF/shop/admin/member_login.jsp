<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!-- member_login.jsp -->
<%@ include file="../display/mall_top.jsp" %>
<div align="center">
    <table border="1" width="100%">
        <script type="text/javascript">
            function loginCheck() {
                if (f.id.value == "") {
                    alert("���̵� �Է����ּ���!");
                    f.id.focus();
                    return;
                }
                if (f.passwd.value == "") {
                    alert("��й�ȣ�� �Է����ּ���!");
                    f.passwd.focus();
                    return;
                }
                document.f.submit();
            }
        </script>
        <br>
        <img src="img/bottom.gif" width="570" height="40" border="0" alt="">
        <br>
        <p>
        <img src="img/tm_login.gif" width="100" height="13" border="0" align="center" alt="ȸ�� �α���">
        <form name="f" action="memberLoginOk_admin.do" method="post">
            <table width="60%" align="center" height="120">
                <tr>
                    <td align="right" width="30%">
                        <img src="img/id01.gif" width="28" height="11" border="0" alt="���̵�">&nbsp;&nbsp;
                    </td>
                    <td width="40%">
                        <c:choose>
                            <c:when test="${empty value}">
                                <input type="text" name="id" tabindex="1">
                            </c:when>
                            <c:otherwise>
                                <input type="text" name="id" tabindex="1" value="${value}">
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td rowspan="2" width="30%" valign="middle">
                        <a href="javascript:loginCheck()">
                            <img src="img/bt_login.gif" border="0" alt="�α���" tabindex="3">&nbsp;&nbsp;<br>
                        </a>
                        <nobr>
                            <c:choose>
                                <c:when test="${empty value}">
                                    <input type="checkbox" name="saveId">
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="saveId" checked>
                                </c:otherwise>
                            </c:choose>
                            <font face="����" size="2">���̵� ����</font>
                        </nobr>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <img src="img/pwd.gif" width="37" height="11" alt="��й�ȣ">
                    </td>
                    <td>
                        <input type="password" name="passwd" tabindex="2">
                    </td>
                </tr>
                <tr>
                    <td colspan="3" align="center">
                        <a href="memberInput_admin.do">ȸ������</a>
                        <a href="#">���̵� ã��</a>
                        <a href="#">��й�ȣ ã��</a>
                    </td>
                </tr>
            </table>
        </form>
    </table>
</div>
<%@ include file="../display/mall_bottom.jsp" %>
