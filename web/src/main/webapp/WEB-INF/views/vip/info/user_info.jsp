<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

登陆成功, userId:${userId} 姓名：${loginName} <br>

sessionTest:<br>
SessionId:${pageContext.session.getId()}<br>
SessionAttribute:${pageContext.session.getAttribute("sessionIdTest")}<br>
SessionAttribute:${pageContext.session.getAttribute("sessionIdTest")}<br><br>

<table>
    <form action="/Course.do" method="get">
        <tr>
            <td>课程id&nbsp;&nbsp;&nbsp;</td>
            <td>课程名称&nbsp;&nbsp;&nbsp;</td>
            &nbsp;
            <td>操作&nbsp;&nbsp;&nbsp;</td>

            <button type="submit" name="method" value="toAddPage">去增加课程</button>
            <input type="hidden" name="userId" value="${userId}">

        </tr>
        <c:forEach items="${courseList}" var="course">
            <tr>
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>
                    <a href="/Course.do?method=delCourse&courseId=${course.courseId}&userId=${userId}">删除</a>

                    <%--<button type="submit" name="method" value="delCourse">del</button>
                    <input type="hidden" name="courseId" value=${course.courseId}>  这样得通过ajax请求才能生效--%>

                </td>
                <td>
                    <a href="/Course.do?method=toEditPage&courseId=${course.courseId}&userId=${userId}&courseName=${course.courseName}">编辑</a>

                    <%--<button type="submit" name="method" value="toEditPage">edit</button>
                    <input type="hidden" name="courseName" value=${course.courseName}>--%>
                </td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
</html>