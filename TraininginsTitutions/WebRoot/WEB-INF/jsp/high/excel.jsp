<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <meta charset="utf-8" />
</head>
<body>
    <table border="1">
        <caption>游戏级别统计表</caption>
        <tr>
            <th rowspan="2">序号</th>
            <th rowspan="2">游戏号</th>
            <th rowspan="2">姓名</th>
            <th rowspan="2">性别</th>
            <th rowspan="2">年龄</th>
            <th colspan="3">等级</th>
        </tr>
        <tr>
            <th>lol</th>
            <th>cf</th>
            <th>dnf</th>
            <th>lsd</th>
        </tr>
        <tr>
            <td>1</td>
            <td>20180811</td>
            <td>RedAnt</td>
            <td>男</td>
            <td>不详</td>
            <td>80</td>
            <td>双杠一星</td>
            <td>80</td>
            <td>213</td>
        </tr>
        <tr>
            <td>2</td>
            <td>20180812</td>
            <td>HoYL</td>
            <td>男</td>
            <td>不详</td>
            <td>81</td>
            <td>双杠一星</td>
            <td>80</td>
            <td>999</td>
        </tr>
        <tr>
            <td>2</td>
            <td>20180813</td>
            <td>Thinking</td>
            <td>男</td>
            <td>不详</td>
            <td>81</td>
            <td>双杠一星</td>
            <td>80</td>
            <td>999</td>
        </tr>
    </table>
    <a download="游戏级别统计表.xls">导出表格</a>
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script>
        $(document).ready(function(){
            var now_html = "<html><head><meta charset='utf-8' /></head><body>" + document.getElementsByTagName("table")[0].outerHTML + "</body></html>";
            /*outerHTML:获取整个table元素的HTML代码（包括<table>标签）,包装成一个完整的HTML文档
             charset为urf-8以防止中文乱码*/
            var blob = new Blob([now_html], { type: "application/vnd.ms-excel" });
            /*实例化一个Blob对象
             * Blob构造函数:[now_html]包含文件的数组
             * { type: "application/vnd.ms-excel" }：是包含文件类型属性的对象*/
            var a = document.getElementsByTagName("a")[0];
            //利用URL.createObjectURL()方法为a元素生成blob URL
            a.href = URL.createObjectURL(blob);
        })
    </script>
</body>
</html>