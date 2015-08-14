package controller.login;

import entity.Course;
import entity.User;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import service.course.CourseService;
import service.course.iml.CourseServiceIml;
import service.login.UserService;
import service.login.iml.UserServiceIml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//负责处理登录注册的请求

public class LoginController extends MultiActionController {

    //到登录页
    public ModelAndView toLoginPage(HttpServletRequest request,HttpServletResponse response) throws ServletRequestBindingException{
        return new ModelAndView("login/login");
    }
    //到注册页
    public ModelAndView toRegisterPage(HttpServletRequest request,HttpServletResponse response) throws ServletRequestBindingException{
        return new ModelAndView("login/register");
    }
    //登录请求处理
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response)throws ServletRequestBindingException {
        HashMap model = new HashMap();

        String userName = (String)request.getParameter("username");
        String passWord = (String)request.getParameter("password");
        Connection connection = (Connection)getServletContext().getAttribute("connection");

        //判断用户是否存在,返回user实体
        UserService loginService = new UserServiceIml();
        User user = loginService.queryUserByNamePwd(userName, passWord, connection);

        //用户不存在，页面返回错误信息
        if (user.getId()<= 0 ){
            model.put("err","login error，name or password not right");
            return new ModelAndView("login/login",model);
        }

        //根据用户Id获取他的课程信息
        List<Course> list = new ArrayList<Course>();
        CourseService courseService = new CourseServiceIml();
        list = courseService.getCourseListByUserId(user.getId(),connection);

        //返回用户的课程信息,jsp页面处理
        model.put("userId",user.getId());
        model.put("loginName",user.getUserName());
        model.put("user", user);
        model.put("courseList", list);

        return new ModelAndView("vip/info/user_info",model);
    }

    //注册请求处理
    public ModelAndView register(HttpServletRequest request,HttpServletResponse response)throws ServletRequestBindingException{
        Map model = new HashMap();

        String userName = (String)request.getParameter("username");
        String passWord = (String)request.getParameter("password");
        Connection connection = (Connection)getServletContext().getAttribute("connection");

        //注册用户
        UserService userService = new UserServiceIml();
        userService.add(userName,passWord,connection);



        model.put("str","register success");
        return new ModelAndView("login/register",model);
    }
}
