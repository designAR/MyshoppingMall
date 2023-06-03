<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- prod_list.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="top.jsp" %>
<script type="text/javascript">
	function checkDel(pnum, pimage){
		var isDel = window.confirm("������ �����Ͻðڽ��ϱ�?")
		if (isDel){
			document.del.pnum.value = pnum
			document.del.pimage.value = pimage
			document.del.submit()
		}
	}
</script>
<div align="center">
	<font size="4">��ǰ���</font><br>
	<table border="1" width="100%">
		<tr bgcolor="yellow">
			<th>��ȣ</th>
			<th>��ǰ�ڵ�</th>
			<th>��ǰ��</th>
			<th>�̹���</th>
			<th>����</th>
			<th>������</th>
			<th>����</th>
			<th>����|����</th>
		</tr>
	<c:if test="${empty listProd}">
		<tr>
			<td colspan="8">��ϵ� ��ǰ�� �����ϴ�.</td>
		</tr>
	</c:if>		
	<c:forEach var="dto" items="${listProd}">
		<tr>
			<td>${dto.pnum}</td>
			<td>${dto.pcategory_fk}</td>
			<td>${dto.pname}</td>
			<td>
				<a href="prodView_admin.do?pnum=${dto.pnum}">
					<img src="${upPath}/${dto.pimage}" width="30" height="30">
				</a>
			</td>
			<td>${dto.price}</td>
			<td>${dto.pcompany}</td>
			<td>${dto.pqty}</td>
			<td>
			<a href="prodUpdate_admin.do?pnum=${dto.pnum}">����</a> | 
			<a href="javascript:checkDel('${dto.pnum}','${dto.pimage}')">����</a></td>
		</tr>
	</c:forEach>
	</table>
</div>
<form name="del" action="prodDelete_admin.do" method="post">
	<input type="hidden" name="pnum">
	<input type="hidden" name="pimage">
</form>
<%@ include file="bottom.jsp" %>








