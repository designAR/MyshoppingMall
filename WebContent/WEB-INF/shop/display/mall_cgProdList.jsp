<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall_cgProdList.jsp -->
<%@ include file="mall_top.jsp" %>
<div align="center">
	<hr color="green" width="300">
		<font color="red" size="4">${param.cname}</font>
		<hr color="green" width="300">
		<br>
		<table width="100%" border="0">
			<tr>
				<c:set var="count" value="0"/>
				<c:forEach var="pdto" items="${requestScope[param.code]}">
					<c:set var="count" value="${count+1}"/>
				<td align="center">
					<a href="shop_prodView.mall?pnum=${pdto.pnum}&select=${param.code}">
						<img src="${upPath}/${pdto.pimage}" width="80" height="80"><br>
					</a>	
					${pdto.pname}<br>
					<font color="red">${pdto.price}</font>¿ø<br>
					<font color="green">${pdto.point}</font>point
				</td>
					<c:if test="${count%3==0}">
						</tr><tr>
					</c:if>
				</c:forEach>
			</tr>
		</table>
</div>
<%@ include file="mall_bottom.jsp"%>