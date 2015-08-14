<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

${err} <br>

登录：
<form action="/Login.do" method="POST">
    用户名
    <input name="username">
    密码
    <input name="password"/>
    <button type="submit" name="action" value="login">
        提交
    </button>
    <br>


</form>

</body>
</html>