<%@ page language="java" pageEncoding="gbk" import="dao.*,model.*,service.*,utils.*" %>
<%@ page import="java.util.ArrayList" %>


<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>������Ա-����</title>
		<link rel="stylesheet" type="text/css" href="../css/style_admin.css">
</head>
<body>
		<table cellspacing="1" cellpadding="4" width="100%"
			class="tableborder" id="table3">
			<form name="form1" action="showUserList.jsp" method="post">
				<tr>
					<td colspan="15" class="header">
						��Ʒ����
					</td>
				</tr>
				<tr>
					<td align="center" class="altbg1">
						<b>��Ʒ���</b>
					</td>
					<td align="center" class="altbg1">
						<b>��Ʒ����</b>
					</td>
					<td align="center" class="altbg1">
						<b>��Ʒ�̱�</b>
					</td>
					<td align="center" class="altbg1">
						<b>��Ʒ�ͺ�</b>
					</td>
					<td align="center" class="altbg1">
						<b>��Ʒ�۸�</b>
					</td>
					<td align="center" class="altbg1">
						<b>�޸�</b>
					</td>
					<td align="center" class="altbg1">
						<b>ɾ��</b>
					</td>
				</tr>

				<%
					ProductDao productDao = new ProductDao();
					ArrayList<Product> list = productDao.getAllProducts();
					for(Product product : list){
				%>
				<tr>
					<td rowspan="2" align="center" class="altbg2">
						<%=product.getId()%>
					</td>
					<td class="altbg2" rowspan="2" align="center">
						<%=product.getName()%>
					</td>
					<td class="altbg2" rowspan="2" align="center">
						<%=product.getBrand()%>
					</td>
					<td class="altbg2" rowspan="2" align="center">
						<%=product.getType()%>
					</td>
					<td class="altbg2" rowspan="2" align="center">
						<%=product.getPrice()%>
					</td>
					<td class="altbg2" rowspan="2" align="center">
						<a href="updateProduct.jsp?id=<%=product.getId()%>">�޸�</a>
					</td>
					<td class="altbg2" rowspan="2" align="center">
						<a href="manageProduct.jsp?action=delete&productID=<%=product.getId()%>">ɾ��</a>
					</td>
				</tr>
				<%
					}
				%>
				<tr>

				</tr>
			</form>
		</table>
	</body>
</html>