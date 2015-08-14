<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

courseId:${courseId}<br>
userId:${userId}
<br><br>

编辑课程：
<form action="Course.do" method="POST">
    课程名
    <input name="courseName" value="${courseName}">

    <button type="submit" name="method" value="editCourse">
        提交
    </button>
    <input type="hidden" name="userId" value=${userId}>
    <input type="hidden" name="courseId" value=${courseId}>

    <br>

</form>

</body>
</html>