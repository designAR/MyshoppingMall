<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!-- member_login.jsp -->
<%@ include file="../display/mall_top.jsp" %>
<div align="center">
    <table border="1" width="100%">
        <script type="text/javascript">
            function loginCheck() {
                if (f.id.value == "") {
                    alert("아이디를 입력해주세요!");
                    f.id.focus();
                    return;
                }
                if (f.passwd.value == "") {
                    alert("비밀번호를 입력해주세요!");
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
        <img src="img/tm_login.gif" width="100" height="13" border="0" align="center" alt="회원 로그인">
        <form name="f" action="memberLoginOk_admin.do" method="post">
            <table width="60%" align="center" height="120">
                <tr>
                    <td align="right" width="30%">
                        <img src="img/id01.gif" width="28" height="11" border="0" alt="아이디">&nbsp;&nbsp;
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
                            <img src="img/bt_login.gif" border="0" alt="로그인" tabindex="3">&nbsp;&nbsp;<br>
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
                            <font face="돋움" size="2">아이디 저장</font>
                        </nobr>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <img src="img/pwd.gif" width="37" height="11" alt="비밀번호">
                    </td>
                    <td>
                        <input type="password" name="passwd" tabindex="2">
                    </td>
                </tr>
                <tr>
                    <td colspan="3" align="center">
                        <a href="memberInput_admin.do">회원가입</a>
                        <a href="#">아이디 찾기</a>
                        <a href="#">비밀번호 찾기</a>
                    </td>
                </tr>
            </table>
        </form>
    </table>
</div>
<%@ include file="../display/mall_bottom.jsp" %>
