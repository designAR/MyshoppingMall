<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!-- member_delete.jsp -->
<%@ page import="myshop.admin.dao.MemberDAO" %>
<%
    String no = request.getParameter("no");
    if (no == null || no.trim().equals("")) {
        response.sendRedirect("memberList_admin.do");
        return;
    }

    MemberDAO dao = new MemberDAO();
    int res = dao.deleteMember(Integer.parseInt(no));
    String msg = null, url = "memberList_admin.do";
    if (res > 0) {
        msg = "회원 삭제 성공!! 회원 목록 페이지로 이동합니다.";
    } else {
        msg = "회원 삭제 실패!! 회원 목록 페이지로 이동합니다.";
    }
%>
<script type="text/javascript">
    alert("<%=msg%>");
    location.href = "<%=url%>";
</script>
