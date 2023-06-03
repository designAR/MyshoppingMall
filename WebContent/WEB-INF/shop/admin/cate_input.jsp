<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- cate_input.jsp -->
<%@ include file="top.jsp"%>
<div align="center">
	<font size="3">카테고리 등록</font><br>
	<form name="f" action="cateInputOk_admin.do" method="post">
		<table border="1" width="400">
			<tr>
				<th width="30%" bgcolor="yellow">카테고리 코드</th>
				<td width="70%"><input type="text" name="code" size="30"></td>
			</tr>
			<tr>
				<th width="30%" bgcolor="yellow">카테고리 이름</th>
				<td width="70%"><input type="text" name="cname" size="30"></td>
			</tr>
			<tr bgcolor="orange">
				<td align="center" colspan="2">
					<input type="submit" value="등록">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp"%>