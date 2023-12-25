<%--
  Created by IntelliJ IDEA.
  User: Εξέο
  Date: 2023/12/25
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gbk" language="java" %>



<html>
<head>
    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link href="../css/right.css" rel="stylesheet" type="text/css" />
</head>

<frameset rows="85%,*">


    <frameset cols="80%,*">


        <frame src="message.jsp" name="message" />

        <frame src="userList.jsp" name="userList">


    </frameset>

    <frame src="sendMessage.jsp" name="sendMessage" />

</frameset>
<noframes></noframes>
</html>

