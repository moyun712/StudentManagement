<%@ page language="java" pageEncoding="gbk" import="dao.*,model.*,service.*,utils.*" %>


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
					<b>��ݴ���</b>
				</td>
				<td align="center" class="altbg1">
					<b><INPUT onClick="return window.confirm('ȷ��Ҫɾ��ѡ�е���Ϣ')"
							type="submit" value="ɾ��"> </b>
				</td>
			</tr>
			
			<tr>
				<td rowspan="2" align="center" class="altbg2">
					accp
				</td>
				<td class="altbg2" rowspan="2" align="center">
					1
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="showUserList.jsp?action=delete&userID=1">ɾ��</a>
				</td>
			</tr>
			<tr>

			</tr>
			
			<tr>
				<td rowspan="2" align="center" class="altbg2">
					zzg
				</td>
				<td class="altbg2" rowspan="2" align="center">
					0
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="showUserList.jsp?action=delete&userID=3">ɾ��</a>
				</td>
			</tr>
			<tr>

			</tr>
			
			<tr>
				<td rowspan="2" align="center" class="altbg2">
					bobo
				</td>
				<td class="altbg2" rowspan="2" align="center">
					0
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="showUserList.jsp?action=delete&userID=4">ɾ��</a>
				</td>
			</tr>
			<tr>

			</tr>
			
			<tr>
				<td rowspan="2" align="center" class="altbg2">
					balr
				</td>
				<td class="altbg2" rowspan="2" align="center">
					0
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="showUserList.jsp?action=delete&userID=5">ɾ��</a>
				</td>
			</tr>
			<tr>

			</tr>
			
			<tr>
				<td rowspan="2" align="center" class="altbg2">
					lgy
				</td>
				<td class="altbg2" rowspan="2" align="center">
					0
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="showUserList.jsp?action=delete&userID=6">ɾ��</a>
				</td>
			</tr>
			<tr>

			</tr>
			
			<tr>
				<td rowspan="2" align="center" class="altbg2">
					aa
				</td>
				<td class="altbg2" rowspan="2" align="center">
					0
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="showUserList.jsp?action=delete&userID=7">ɾ��</a>
				</td>
			</tr>
			<tr>

			</tr>
			
			<tr>
				<td rowspan="2" align="center" class="altbg2">
					aaa
				</td>
				<td class="altbg2" rowspan="2" align="center">
					0
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="showUserList.jsp?action=delete&userID=8">ɾ��</a>
				</td>
			</tr>
			<tr>

			</tr>
			
			<tr>
				<td rowspan="2" align="center" class="altbg2">
					teacher
				</td>
				<td class="altbg2" rowspan="2" align="center">
					0
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="showUserList.jsp?action=delete&userID=9">ɾ��</a>
				</td>
			</tr>
			<tr>

			</tr>
			</form>
			</table>
</body>
</html>