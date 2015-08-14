<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>


请输入注册信息：
<form action="/Login.do" method="POST">

    用户名
    <input name="username">
    密码
    <input name="password"/>
    <button type="submit" name="action" value="register">
        提交
    </button>
</form>


<br><br><br><br>

<!--登录成功提示-->
${str}

<form>
    <button type="submit" name="action" value="toLoginPage">
        去登录页
    </button>
</form>

</body>
</html>