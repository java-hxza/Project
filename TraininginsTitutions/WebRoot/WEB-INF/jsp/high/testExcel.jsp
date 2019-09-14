<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Export to Excel - Demo</title>
</head>
<body>
	<table align="left" border="2">
        <thead>
            <tr bgcolor="lightgreen">
                <th>ID</th>
                <th>文本内容</th>
                <th>序列</th>
                <td style="display: none">序列222</td>
            </tr>
        </thead>
        <tbody>
            <%
                for (int i = 0; i < 10; i++) {%>
            <tr bgcolor="lightblue">
                <td align="center"><%=i%></td>
                <td align="center">文本内容 <%=i%></td>
                <td align="center"><%=i*10%></td>
                <td style="display: none" align="center"><%=i * 20%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    </body>
</html>