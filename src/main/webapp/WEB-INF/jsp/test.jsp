<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2018/3/13
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/common_js.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${baseurl}ajaxLogin" method="post">
    <table border="1">
        <tr>
            <td colspan="2">
                用户登录
            </td>
        </tr>
        <tr>
            <td>登录ID：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>登录密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
