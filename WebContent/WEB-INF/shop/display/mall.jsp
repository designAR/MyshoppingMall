<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall.jsp -->
<%@ include file="mall_top.jsp" %>
<div align="center">
	<c:if test="${empty HIT}">
		<font size="4">HIT상품이 없습니다.</font>
	</c:if>
	<c:if test="${not empty HIT}">
		<hr color="green" width="300">
		<font color="red" size="4">H I T</font>
		<hr color="green" width="300">
		<br>
		<table width="100%" border="0">
			<tr>
				<c:set var="count" value="0"/>
				<c:forEach var="pdto" items="${HIT}">
					<c:set var="count" value="${count+1}"/>
				<td align="center">
					<a href="shop_prodView.mall?pnum=${pdto.pnum}&select=HIT">
						<img src="${upPath}/${pdto.pimage}" width="80" height="80"><br>
					</a>
					${pdto.pname}<br>
					<font color="red">${pdto.price}</font>원<br>
					<font color="green">${pdto.point}</font>point
				</td>
					<c:if test="${count%3==0}">
						</tr><tr>
					</c:if>
				</c:forEach>
			</tr>
		</table>
	</c:if>
	<c:if test="${empty NEW}">
		<font size="4">NEW상품이 없습니다.</font>
	</c:if>
	<c:if test="${not empty NEW}">
		<hr color="green" width="300">
		<font color="red" size="4">N E W</font>
		<hr color="green" width="300">
		<br>
		<table width="100%" border="0">
			<tr>
				<c:set var="count" value="0"/>
				<c:forEach var="pdto" items="${NEW}">
					<c:set var="count" value="${count+1}"/>
				<td align="center">
					<a href="shop_prodView.mall?pnum=${pdto.pnum}&select=NEW">
						<img src="${upPath}/${pdto.pimage}" width="80" height="80"><br>
					</a>
					${pdto.pname}<br>
					<font color="red">${pdto.price}</font>원<br>
					<font color="green">${pdto.point}</font>point
				</td>
					<c:if test="${count%3==0}">
						</tr><tr>
					</c:if>
				</c:forEach>
			</tr>
		</table>
	</c:if>	
	<c:if test="${empty BEST}">
		<font size="4">BEST상품이 없습니다.</font>
	</c:if>
	<c:if test="${not empty BEST}">
		<hr color="green" width="300">
		<font color="red" size="4">B E S T</font>
		<hr color="green" width="300">
		<br>
		<table width="100%" border="0">
			<tr>
				<c:set var="count" value="0"/>
				<c:forEach var="pdto" items="${BEST}">
					<c:set var="count" value="${count+1}"/>
				<td align="center">
					<a href="shop_prodView.mall?pnum=${pdto.pnum}&select=BEST">
						<img src="${upPath}/${pdto.pimage}" width="80" height="80"><br>
					</a>
					${pdto.pname}<br>
					<font color="red">${pdto.price}</font>원<br>
					<font color="green">${pdto.point}</font>point
				</td>
					<c:if test="${count%3==0}">
						</tr><tr>
					</c:if>
				</c:forEach>
			</tr>
		</table>
	</c:if>	
</div>					
<%@ include file="mall_bottom.jsp"%>					
				