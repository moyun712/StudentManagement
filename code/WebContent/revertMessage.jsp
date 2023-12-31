<%@ page import="model.Message" %>
<%@ page import="dao.MessageDao" %>
<%@ page import="dao.ReplyDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Reply" %>
<%@ page language="java" pageEncoding="utf-8"%>
<html>
	<head>
		<title>回复留言</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="description" content="留言本">
		<link href="img/1/jd100.css" rel="stylesheet" type="text/css">
	</head>
	
	<body background=img/1/bookbg.gif leftmargin='0' topmargin='3'
		marginwidth='0' marginheight='0'>
		<div align='center'>
			<IMG src=img/1/welcome.jpg>
		</div>
		<!--   留言信息显示    开始 -->
		<div align='center'>

			<%
				int mid = Integer.parseInt(request.getParameter("messageID"));
				MessageDao messageDao = new MessageDao();
				Message message = messageDao.getMessageId(mid);
			%>


			<table width='750' border='0' cellspacing='1' cellpadding='4'
				align='center'>
				<tr>
					<td height='20' colspan='2' class='unnamed2'>
						<marquee onMouseOut=start(); onMouseOver=stop(); scrollamount=3>
							<b><font color=#000099>欢迎您使用&nbsp;留言本&nbsp;</font> </b>
						</marquee>
					</td>
				</tr>
				<tr>
					<td height='20' class='unnamed1'>
						主题:
						 <%=message.getTitle()%>
					</td>
					<td height='20' class='unnamed1' align='right'></td>
				</tr>
			</table>
			
			<div align='center' style='width:750px'>
				<div align='left'>
					<table width='%' height='20' border='0' cellpadding='0'
						cellspacing='0'>
						<tr>
							<td width='11' background='img/1/titlemu_1.gif'></td>
							<td width='*' background='img/1/titlemu_2.gif'>
								<div align='center'>
									<a href='messageBoard.jsp' class=jdmenu><b>留言</b></a>
								</div>
							</td>
							<td width='12' background='img/1/titlemu_3.gif'></td>
							
						</tr>
					</table>
				</div>
			</div>
			
			<TABLE width='750' border=0 align='center' cellPadding=0
				cellSpacing=0 borderColor=#111111 style='BORDER-COLLAPSE: collapse'>
				<TBODY>
					<TR>
						<TD width='2%'>
							<IMG src='img/1/T_left.gif' border=0>
						</TD>
						<TD width='96%' background='img/1/Tt_bg.gif'></TD>
						<TD width='2%'>
							<IMG src='img/1/T_right.gif' border=0>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE width='750' border=1 align=center cellPadding=0 cellSpacing=0
				class='jd_tab' style='border-collapse:collapse'>

				<tr>
					<td height='150' valign='top' class='jd_tab'>
						<table width='100%' height='20' border='0' cellpadding='0'
							cellspacing='0'
							style='table-layout:fixed;word-break:break-all;word-wrap:break-word;'>
							<tr>
								<td style='word-break:break-all' class=jd_title>
									&nbsp; ※&nbsp;
									<b><%=message.getTitle()%>
									</b>
								</td>
							</tr>
						</table>
						<table width='100%' border='0' cellpadding='3'
							style='table-layout:fixed;word-break:break-all;word-wrap:break-word;'>
							<tr>
								<td width='' style='word-break:break-all'>
									<div class=unnamed2>
										<%=message.getContent()%>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height='18' valign='bottom' class='jd_tab'
						style='font-size: 12px;'>
						<font color=#666666><%=message.getName()%>写于&nbsp;<%=message.getTime()%>
							&nbsp;</font>
					</td>
				</tr>
			</table>


			<TABLE width='750' border=0 align='center' cellPadding=0
				cellSpacing=0 style='BORDER-COLLAPSE:collapse'>
				<TBODY>
					<TR>
						<TD>
							<IMG src='img/1/T_bottomleft.gif' border=0>
						</TD>
						<TD width='100%' background='img/1/T_bottombg.gif'></TD>
						<TD>
							<IMG src='img/1/T_bottomright.gif' border=0>
						</TD>
					</TR>
				</TBODY>
			</TABLE>


			<table width='750' border='0' cellspacing='1' cellpadding='4'
				align='center'>
				<tr>
					<td width='' height='20' align='right' class='unnamed1'></td>
				</tr>
			</table>

			<!-- 留言显示  结束 -->
			<!-- 回复   开始 -->
			<%
				ReplyDao replyDao = new ReplyDao();
				ArrayList<Reply> list = replyDao.getAllReply(mid);
				int count = list.size();
				if(count>0){
			%>

			<TABLE width='750' border=0 align='center' cellPadding=0
				cellSpacing=0>
				<TR>
					<TD height=5 align="left" class='unnamed1'>
						回复内容：
					</TD>
				</TR>
			</TABLE>

			<%
				for(Reply reply : list){
			%>
			<TABLE width='750' border=1 align=center cellPadding=0 cellSpacing=0
				   class='jd_tab' style='border-collapse:collapse'>

				<tr>
					<td height='150' valign='top' class='jd_tab'>
						<table width='100%' height='20' border='0' cellpadding='0'
							   cellspacing='0'
							   style='table-layout:fixed;word-break:break-all;word-wrap:break-word;'>
							<tr>
								<td style='word-break:break-all' class=jd_title>
									&nbsp; ※&nbsp;
									<b><%=message.getName()%>
									</b>
								</td>
							</tr>
						</table>
						<table width='100%' border='0' cellpadding='3'
							   style='table-layout:fixed;word-break:break-all;word-wrap:break-word;'>
							<tr>
								<td width='' style='word-break:break-all'>
									<div class=unnamed2>
										<%=reply.getContent()%>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height='18' valign='bottom' class='jd_tab'
						style='font-size: 12px;'>
						<font color=#666666><%=reply.getName()%>写于&nbsp;<%=reply.getTime()%>
							&nbsp;</font>
					</td>
				</tr>
			</table>
			<%
				}}
			%>

			<!-- 回复  结束    -->
			<table width='750' border='0' cellspacing='1' cellpadding='4'
				align='center'>
				<tr>
					<td width='' height='20' align='right' class='unnamed1'></td>
				</tr>
			</table>
			<TABLE width='750' height=0 border=1 align=center cellPadding=0
				cellSpacing=0 class='jd_tab' style='border-collapse:collapse'>
				<TBODY>
					<TR>
						<TD height=25 class=jd_titlemu>
							<div align='center'>
								<strong>快 速 回 复 </strong>
							</div>
						</TD>
					</TR>
					<TR>
						<TD align=middle valign='top'>
						<form name='form' method='get' action='saveRevert' onSubmit=''>
							<table width='100%' border='0' align='center' cellpadding='1'
								cellspacing='1' class='unnamed1'>
								
									<input type="hidden" name="messageID" value="<%=mid%>" />
								<tr>
									<td width='86' align='right'>
										姓名：
									</td>
									<td width='577'>
										<input name='name' type='text' class='input1' value=''
											size='20' maxLength=10>
										<font color='#FF0000'>*</font>
									</td>
								</tr>
								<tr>
									<td align='right' valign='top'>
										内容：
									</td>
									<td>
										<textarea name='content' cols='80' rows='6' class='input1'></textarea>
										<br>
										&nbsp;&nbsp;
										<input type='submit' name='Submit' value=' 提 交 '>
										&nbsp;
										<br>
									</td>
								</tr>
							</table>
							</form>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</div>

		<br>
	</body>
</html>
