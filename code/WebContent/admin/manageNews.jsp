<%@ page language="java" pageEncoding="utf-8" import="dao.*,model.*,service.*,utils.*" %>
<%@ page import="java.util.ArrayList" %>


<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>管理人员-管理</title>
		<link rel="stylesheet" type="text/css" href="../css/style_admin.css">
</head>
<body>
		<table cellspacing="1" cellpadding="4" width="100%"
			class="tableborder" id="table3">
			<form name="form1" action="showUserList.jsp" method="post">
			<tr>
				<td colspan="15" class="header">
					新闻管理
				</td>
			</tr>
			<tr>
				<td align="center" class="altbg1">
					<b>新闻标题</b>
				</td>
				<td align="center" class="altbg1">
					<b>新闻发布时间</b>
				</td>
				<td align="center" class="altbg1">
					<b>修改</b>
				</td>
				<td align="center" class="altbg1">
					<b>删除</b>
				</td>
			</tr>
			<%
				NewsDao newsDao = new NewsDao();
				ArrayList<News> list = newsDao.getAllNews();
				for(News news : list){
			%>

			<tr>
				<td rowspan="2" align="center" class="altbg2">
					<%=news.getTitle()%>
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<%=news.getTime()%>
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="updateNews.jsp?id=<%=news.getId()%>">修改</a>
				</td>
				<td class="altbg2" rowspan="2" align="center">
					<a href="/deleteNewsServlet?id=<%=news.getId()%>">删除</a>
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