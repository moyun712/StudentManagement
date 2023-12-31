<%--
  Created by IntelliJ IDEA.
  User: 蓬蒿
  Date: 2023/12/30
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8" import="dao.*,model.*,service.*,utils.*" %>


<html>

<head>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>修改新闻</title>
    <link rel="stylesheet" type="text/css" href="../css/style_admin.css">

</head>

<body>
<form name="form1" action="/updateNewsServlet" method="get" onSubmit="return fun_check_form()">
    <table cellspacing="1" cellpadding="4" width="100%"
           class="tableborder" id="table3">

        <input type="hidden" name="action" value="save">
        <tr>
            <td colspan="12" class="header">
                修改新闻信息
            </td>
        </tr>
        <%
            //得到要修改的新闻的内容
            int id = Integer.parseInt(request.getParameter("id"));
            NewsDao newsDao = new NewsDao();
            News news = newsDao.getNewsId(id);
        %>
        <tr>
            <td class="altbg1">
                新闻编号：
            </td>
            <td class="altbg2" colspan="11" >
                <input type="hidden" name="id" value="<%= news.getId() %>"/>
                <%=news.getId()%>
            </td>
        </tr>
        <tr>
            <td class="altbg1">
                新闻标题：
            </td>
            <td class="altbg2" colspan="11">
                <input type="text" name="title" size="34" value="<%=news.getTitle()%>">
            </td>
        </tr>
        <tr>
            <td class="altbg1">
                新闻内容：
            </td>
            <td class="altbg2" colspan="11">
                <textarea rows="5" cols="60" name="content" >
                    <%=news.getContent()%>
                </textarea>
            </td>
        </tr>


        <tr>
            <td class="altbg1">
            </td>
            <td class="altbg2" colspan="11">
                <input type="submit" value="提交" name="B1" />
                &nbsp;
                <input type="reset" value="重置" name="B2" />
            </td>
        </tr>

    </table>
</form>
</body>

</html>

