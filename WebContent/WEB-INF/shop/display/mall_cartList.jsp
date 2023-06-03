<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall_cartList.jsp -->
<%@ include file="mall_top.jsp"%>
<div align="center">
	<table border="1" width="100%">
		<tr>
			<td colspan="6" align="center">
				<h4>장바구니 보기</h4>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>수량</th>
			<th>단가</th>
			<th>금액</th>
			<th>삭제</th>
		</tr>
	<c:if test="${empty cart}">
		<tr>
			<td colspan="6">장바구니에 등록된 상품이 없습니다.</td>
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
					<input type="text" size="3" name="pqty" value="${dto.pqty}">개<br>
					<input type="hidden" name="pnum" value="${dto.pnum}">
					<input type="submit" value="수정">
				</form>
			</td>	
			<td>
				<b>${dto.price}</b>원<br>
				[${dto.point}]point
			</td>
			<td>
				<b>${dto.price*dto.pqty}</b>원<br>
				[${dto.point*dto.pqty}]point
				<c:set var="cartTotalPrice" value="${cartTotalPrice + (dto.price*dto.pqty)}"/>
				<c:set var="carttotalPoint" value="${cartTotalPoint + (dto.point*dto.pqty)}"/>
			</td>
			<td><a href="shop_cartDel.mall?pnum=${dto.pnum}">삭제</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="4">
			장바구니 총액 : ${cartTotalPrice} 원<br>
			총 적립 포인트 : ${carttotalPoint} point
		</td>
		<td colspan="2">
			[<a href="shop_order.mall?mode=all">주문하기</a>] [<a href="javascript:history.go(-2)">계속쇼핑</a>]
		</td>
	</tr>
	</table>
</div>
<%@ include file="mall_bottom.jsp"%>









