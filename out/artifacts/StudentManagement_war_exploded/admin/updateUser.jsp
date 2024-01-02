<%--
  Created by IntelliJ IDEA.
  User: 蓬蒿
  Date: 2024/1/2
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8" import="dao.*,model.*,service.*,utils.*" %>
<html>

<head>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>管理员-修改信息</title>
    <link rel="stylesheet" type="text/css" href="../css/style_admin.css">

</head>

<body>
<form name="form1" action="/updateUserServlet" method="get">
    <table cellspacing="1" cellpadding="4" width="100%"
           class="tableborder" id="table3">

        <input type="hidden" name="action" value="save" />
        <tr>
            <td colspan="12" class="header">
                管理员-修改
            </td>
        </tr>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            UserDao userDao = new UserDao();
            User user = userDao.getUsersId(id);
        %>
        <input type="hidden" name="id" value="<%= user.getLevel() %>" />
        <tr>
            <td class="altbg1">
                管理员名称：
            </td>
            <td class="altbg2" colspan="11">
                <input type="text" name="username" value="<%=user.getUsername()%>"/>
            </td>
        </tr>
        <tr>
            <td class="altbg1">
                密&nbsp; 码：
            </td>
            <td class="altbg2" colspan="11">
                <input type="text" name="password" size="34" value="">
            </td>
        </tr>
        <tr>
            <td class="altbg1">
                确认密码：
            </td>
            <td class="altbg2" colspan="11">
                <input name="confirmpassword" size="34" type="password">
            </td>
        </tr>


        <tr>
            <td class="altbg1">
            </td>
            <td class="altbg2" colspan="11">
                <input type="submit" value="提交" name="B1"
                       onClick="return fun_check_form();">
                &nbsp;
                <input type="reset" value="重置" name="B2">
            </td>
        </tr>

    </table>
</form>
</body>

</html>

