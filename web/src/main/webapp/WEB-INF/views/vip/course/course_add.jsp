<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

Hello,${userLoginName} <br>
您的userId是:${userId}


<br><br><br>

新增课程：
<form action="/Course.do" method="POST">

    课程名 <input name="courseName">
    <input type="hidden" name="userId" value=${userId}>
    <button type="submit" name="method" value="addCourse">
        提交
    </button>
    <br>


</form>

</body>
</html>