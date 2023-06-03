<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall_cartList.jsp -->
<%@ include file="mall_top.jsp"%>
<div align="center">
	<table border="1" width="100%">
		<tr>
			<td colspan="6" align="center">
				<h4>��ٱ��� ����</h4>
			</td>
		</tr>
		<tr>
			<th>��ȣ</th>
			<th>��ǰ��</th>
			<th>����</th>
			<th>�ܰ�</th>
			<th>�ݾ�</th>
			<th>����</th>
		</tr>
	<c:if test="${empty cart}">
		<tr>
			<td colspan="6">��ٱ��Ͽ� ��ϵ� ��ǰ�� �����ϴ�.</td>
		</tr>	
	</c:if>
	<c:set var="cartTotalPrice" value="0"/>
	<c:set var="cartTotalPoint" value="0"/>
	<c:forEach var="dto" items="${cart}">
		<tr>
			<td>${dto.pnum}</td>
			<td>	
				<img src="${upPath}/${dto.pimage}" width="30" height="30"><br>
				${dto.pname}
			</td>
			<td>
				<form name="f" method="post" action="shop_cartEdit.mall">
					<input type="text" size="3" name="pqty" value="${dto.pqty}">��<br>
					<input type="hidden" name="pnum" value="${dto.pnum}">
					<input type="submit" value="����">
				</form>
			</td>	
			<td>
				<b>${dto.price}</b>��<br>
				[${dto.point}]point
			</td>
			<td>
				<b>${dto.price*dto.pqty}</b>��<br>
				[${dto.point*dto.pqty}]point
				<c:set var="cartTotalPrice" value="${cartTotalPrice + (dto.price*dto.pqty)}"/>
				<c:set var="carttotalPoint" value="${cartTotalPoint + (dto.point*dto.pqty)}"/>
			</td>
			<td><a href="shop_cartDel.mall?pnum=${dto.pnum}">����</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="4">
			��ٱ��� �Ѿ� : ${cartTotalPrice} ��<br>
			�� ���� ����Ʈ : ${carttotalPoint} point
		</td>
		<td colspan="2">
			[<a href="shop_order.mall?mode=all">�ֹ��ϱ�</a>] [<a href="javascript:history.go(-2)">��Ӽ���</a>]
		</td>
	</tr>
	</table>
</div>
<%@ include file="mall_bottom.jsp"%>









