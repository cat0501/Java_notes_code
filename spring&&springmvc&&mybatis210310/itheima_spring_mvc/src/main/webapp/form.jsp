<%--
  Created by IntelliJ IDEA.
  User: cat
  Date: 2022/2/13
  Time: 下午3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/user/quick14">
        <%--表明是第一个User对象的username password--%>
        <input type="text" name="userList[0].username"><br>
        <input type="text" name="userList[0].password"><br>
        <input type="text" name="userList[1].username"><br>
        <input type="text" name="userList[1].password"><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
