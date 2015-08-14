# JspServletSpringMVC_150814_09-24


工程说明:

add－time:150814 11:00

     1.在之前纯servlet工程的基础上加上springMVC 2.0的实现方法，
     2.配置diapatcher servlet，和在application中配置请求转发mapping来处理请求，到某个controoler，
       cotroller继承MultiActionController,不用写dopost doget方法，直接在controller中写方法,方法名称来源于请求带过来的value值，请求格式如下，
           <form action="/Login.do">
              <button type="submit" name="action" value="toLoginPage">

     3.数据库 jsp_servlet_test   表1：t_user(id user_name user_password)  表2:(id user_id course_name)  配置context数据库连接,通过contexlistener去读取并创建连接存放在context中

     4.views 直接放在web-inf下面，在application中定义视图和路径 ， 在controller方法类型为modelandview类型，
       返回页面如下写即可，用model存储业务数据（纯servlet 用request），页面路径不需要.jsp,
     
      model.put("str","register success");
      return new ModelAndView("vip/course/course_edit", model);。

     5.所有请求都是发送post、get请求都行
     
     6.工程划分为controller、service（处理具体逻辑）、实体层，
             
     7.修改上次纯servlet的删除错乱bug，原因（传送到controller中的参数过多，应该只传改用到的参数即可）


       <a href="/Course.do?method=delCourse&courseId=${course.courseId}&userId=${userId}">删除</a>

       <%--<button type="submit" name="method" value="delCourse">del</button>
       <input type="hidden" name="courseId" value=${course.courseId}>  这样得通过ajax请求才能生效--%> 
