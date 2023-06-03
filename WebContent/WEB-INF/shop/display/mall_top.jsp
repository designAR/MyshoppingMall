<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall_top.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>���θ�Ȩ</title>
	<script type="text/javascript">
		function cglist(code, cname){
			document.clist.code.value = code
			document.clist.cname.value = cname
			document.clist.submit()
		}
	</script>
</head>
<body>
	<form name="clist" action="shop_cgProd.mall" method="post">
		<input type="hidden" name="code">
		<input type="hidden" name="cname">
	</form>
	<div align="center">
		<table border="1" width="800" height="600">
            <tr height="10%">
                <td colspan="2" align="center">
                    <a href="shop_home.mall">HOME</a> |
                    <a href="boardList1_admin.do">�Խ���</a> |
                    <a href="shop_cartList.mall">��ٱ���</a> |
                    <c:choose>
                        <c:when test="${not empty sessionScope.adminId}">
                            ${sessionScope.adminId}�� | <a href="memberLogout_admin.do">�α׾ƿ�</a>

                        </c:when>
                        <c:otherwise>
                            <a href="memberLogin_admin.do">�α���</a> |
                            <a href="memberInput_admin.do">ȸ������</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
				<td width="20%" valign="top" align="center">
					��ǰī�װ�<br>
					<table width="100%" border="1">
						<c:forEach var="cdto" items="${listCate}">
							<tr><td>
								<a href="javascript:cglist('${cdto.code}','${cdto.cname}')">
									${cdto.cname}[${cdto.code}]
								</a>
							</td></tr>
							</c:forEach>
					</table>
				</td>
				<td width="80%">