<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall_prodView.jsp -->
<%@ include file="mall_top.jsp"%>
<script type="text/javascript">
	function goCart(){
		document.f.action = "shop_cartAdd.mall"
		document.f.submit()
	}
	function goOrder(){
		document.f.action = "shop_order.mall"
		document.f.submit()
	}
</script>
<div align="center">
	<table border="1" width="100%">
		<tr>
			<td colspan="2" align="center">
				<b>[${pdto.pname}] ��ǰ ����</b>
			</td>
		</tr>
		<tr>
			<td align="center">
				<img src="${upPath}/${pdto.pimage}" width="200" height="200">
			</td>
			<td>
				<form name="f" method="post">
					��ǰ��ȣ : ${pdto.pnum}<br>
					��ǰ�̸� : ${pdto.pname}<br>
					��ǰ���� : <font color="red">${pdto.price}</font>��<br>
					��ǰ����Ʈ : <font color="red">${pdto.point}</font>point<br>
					��ǰ���� : <input type="text" name="pqty" size="3" value="1">��<br>
					<input type="hidden" name="pnum" value="${pdto.pnum}"/>
					<input type="hidden" name="select" value="${param.select}"/>
					<br>
					<a href="javascript:goCart()">��ٱ���</a>
					<a href="javascript:goOrder()">��ñ���</a>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				${pdto.pcontents}
			</td>
		</tr>
	</table>
</div>
<%@ include file="mall_bottom.jsp"%>