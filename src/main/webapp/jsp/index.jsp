<%--
  Created by IntelliJ IDEA.
  User: relyy
  Date: 2017/6/6
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登陆页面</title>
  </head>
  <body>
  这是一个登录页面：<br>
  <form action="${pageContext.request.contextPath }/user/login.action" method="POST">
    <table border="2" align="center">
      <tr>
        <td>用户名</td>
        <td><input type="text" name="userName"/></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="text" name="password"/></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" name="确定" style="width:111px"/>
        </td>
      </tr>

    </table>

  </form>
  </body>
</html>
