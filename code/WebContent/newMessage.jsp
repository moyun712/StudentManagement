<%@ page language="java" pageEncoding="gbk"%>
<html>
<head>
<title>�ظ�����</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="description" content="���Ա�">
<link href="img/1/jd100.css" rel="stylesheet" type="text/css">
</head>

<body>
<body background=img/1/bookbg.gif leftmargin='0' topmargin='3'
	marginwidth='0' marginheight='0'>
<div align='center'><IMG src=img/1/welcome.jpg></div>
<!--   ������Ϣ��ʾ    ��ʼ -->
<div align='center'>
<div align='center' style='width=750'>
<table width='750' border='0' cellspacing='1' cellpadding='4'
				align='center'>
				<tr>
					<td height='20' colspan='2' align='right' class='unnamed2'>
						<marquee onMouseOut=start(); onMouseOver=stop(); scrollamount=3>
							<b><font color=#000099>��ӭ��ʹ��&nbsp;���Ա�&nbsp;</font> </b>
						</marquee>
					</td>
				</tr>

			</table>
<div align='left'>
<table width='%' height='20' border='0' cellpadding='0' cellspacing='0'>
	<tr>
		<td width='11' background='img/1/titlemu_1.gif'></td>
		<td width='*' background='img/1/titlemu_2.gif'>
		<div align='center'><a href='messageBoard.jsp' class=jdmenu><b>����</b></a>
		</div>
		</td>
		<td width='12' background='img/1/titlemu_3.gif'></td>

	</tr>
</table>
</div>
</div>
<TABLE width='750' height=0 border=1 align=center cellPadding=0
	cellSpacing=0 class='jd_tab' style='border-collapse:collapse'>
	<TBODY>
		<TR>
			<TD height=25 class=jd_titlemu>
			<div align='center'><strong>�� �� �� </strong></div>
			</TD>
		</TR>
		<TR>
			<TD align=middle valign='top'>
			<form name='form' method='post' action='saveMessage.jsp' onSubmit=''>
			<table width='100%' border='0' align='center' cellpadding='1'
				cellspacing='1' class='unnamed1'>

				<tr>
					<td width='86' align='right'>������</td>
					<td width='577'><input name='writer' type='text'
						class='input1' value='' size='20' maxLength=10> <font
						color='#FF0000'>*</font></td>
				</tr>
				<tr>
					<td align='right'>���⣺</td>
					<td><input name='title' type='text' class='input1' value=''
						size='30' maxlength=50></td>
				</tr>
				<tr>
					<td align='right' valign='top'>���ݣ�</td>
					<td><textarea name='content' cols='80' rows='6' class='input1'></textarea>
					<br>
					&nbsp;&nbsp; <input type='submit' name='Submit' value=' �� �� '>
					&nbsp; <br>
					</td>
				</tr>


			</table>
			</form>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</div>
</body>
</html>
