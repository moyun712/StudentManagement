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
					�û�����
				</td>
			</tr>
			<tr>
				<td align="center" class="altbg1">
					<b>�û���</b>
				</td>
				<td align="center" class="altbg1">
					<b>����</b>
				</td>
				<td align="center" class="altbg1">
					<b><INPUT onClick="return window.confirm('ȷ��Ҫ�޸�ѡ�е���Ϣ')"
							  type="submit" value="�޸�"> </b>
				</td>
				<td align="center" class="altbg1">
					<b><INPUT onClick="return window.confirm('ȷ��Ҫɾ��ѡ�е���Ϣ')"
							type="submit" value="ɾ��"> </b>
				</td>
			</tr>
			<%
				UserDao userDao = new UserDao();
				ArrayList<User> list = userDao.query_all_user();
				for(User user : list){
			%>
			<tr>
				<td rowspan="2" align="center" class="altbg2">
					<%=user.getUsername()%>
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<%=user.getPassword()%>
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="updateUser.jsp?id=<%=user.getLevel()%>">�޸�</a>
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="/deleteUserServlet?id=<%=user.getLevel()%>">ɾ��</a>
				</td>
			</tr>
			<tr>

			</tr>
			<%
				}
			%>
			</form>
			</table>
</body>
</html>