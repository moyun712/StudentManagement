
<%@ page language="java" pageEncoding="utf-8" import="dao.*,model.*,service.*,utils.*" %>

<html>

<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>管理员-添加</title>
<link rel="stylesheet" type="text/css" href="../css/style_admin.css">

</head>

<body>
<form name="form1" action="/addProductServlet" method="get" onSubmit="return fun_check_form()">
<table cellspacing="1" cellpadding="4" width="100%" class="tableborder"
	id="table3">

	<input type="hidden" name="action" value="save">
	<tr>
		<td colspan="12" class="header">添加商品信息</td>
	</tr>
	<tr>
		<td class="altbg1">商品编号（系列）：</td>
		<td class="altbg2" colspan="11"><input type="text"
			name="id" size="34"></td>
	</tr>
	<tr>
		<td class="altbg1">商品名称：</td>
		<td class="altbg2" colspan="11"><input type="text" name="name"
			size="34"></td>
	</tr>
	<tr>
		<td class="altbg1">商品商标：</td>
		<td class="altbg2" colspan="11"><input type="text" name="brand"
			size="34"></td>
	</tr>
	<tr>
		<td class="altbg1">商品型号：</td>
		<td class="altbg2" colspan="11"><input type="text" name="type"
			size="34"></td>
	</tr>
	<tr>
		<td class="altbg1">商品价格：</td>
		<td class="altbg2" colspan="11"><input type="text" name="price"
			size="34" onkeypress="checkIsFloat();" /></td>
	</tr>
	<tr>
		<td class="altbg1">商品图片：</td>
		<td class="altbg2" colspan="11"><input type="text" name="picture"
			size="34"></td>
	</tr>
	<tr>
		<td class="altbg1">商品介绍：</td>
		<td class="altbg2" colspan="11"><textarea rows="5" cols="60"
			name="content"></textarea></td>
	</tr>


	<tr>
		<td class="altbg1"></td>
		<td class="altbg2" colspan="11">
			<input type="submit" value="提交" name="B1" /> &nbsp;
			<input type="reset" value="重置" name="B2" />
		</td>
	</tr>

</table>
</form>
</body>

</html>
