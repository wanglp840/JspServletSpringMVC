package controller.vip;

import entity.Course;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import service.course.CourseService;
import service.course.iml.CourseServiceIml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2015/5/16.
 */
public class UserInfoController extends MultiActionController{

    private CourseService courseService = new CourseServiceIml();

    //到增加页
    public ModelAndView toAddPage(HttpServletRequest request,HttpServletResponse response)throws ServletRequestBindingException {
        String userId = request.getParameter("userId");
        HashMap model = new HashMap();
        model.put("userId", userId);
        return new ModelAndView("vip/course/course_add",model);
    }

    //到编辑页
    public ModelAndView toEditPage(HttpServletRequest request,HttpServletResponse response)throws ServletRequestBindingException {
        String userId = request.getParameter("userId");
        String courseName = request.getParameter("courseName");
        String courseId = request.getParameter("courseId");
        HashMap model = new HashMap();
        model.put("userId", userId);
        model.put("courseName", courseName);
        model.put("courseId", courseId);
        return new ModelAndView("vip/course/course_edit", model);
    }
    //增加
    public ModelAndView addCourse(HttpServletRequest request,HttpServletResponse response)throws ServletRequestBindingException{

        String courseName = request.getParameter("courseName");
        String userId = request.getParameter("userId");
        int userId2 = Integer.parseInt(userId);
        Connection connection = (Connection)getServletContext().getAttribute("connection");

        //新增课程
        courseService.addByCourseNameAndUserId(courseName, userId2,connection);

        //获取新增后该用户的课程列表
        List<Course> list = new ArrayList<Course>();
        list = courseService.getCourseListByUserId(userId2,connection);

        HashMap model = new HashMap();
        model.put("userId",userId2);
        model.put("courseList",list);

        return new ModelAndView("vip/info/user_info",model);
    }

    //删除
    public ModelAndView delCourse(HttpServletRequest request,HttpServletResponse response)throws ServletRequestBindingException{
        String courseId = request.getParameter("courseId");
        int courseId2 = Integer.parseInt(courseId);
        String userId = request.getParameter("userId");
        Integer userId2 = Integer.parseInt(userId);
        String loginName = request.getParameter("userLoginName");
        request.setAttribute("loginName",loginName);
        Connection connection = (Connection)getServletContext().getAttribute("connection");

        //删除
        courseService.deleteCourseByCourseId(courseId2,connection);

        //获取删除后其余课程信息

        List<Course> list = new ArrayList<Course>();
        list = courseService.getCourseListByUserId(userId2,connection);

        HashMap model = new HashMap();
        model.put("userId",userId2);
        model.put("courseList",list);

        return new ModelAndView("vip/info/user_info",model);
    }

    //编辑
    public ModelAndView editCourse(HttpServletRequest request,HttpServletResponse response)throws ServletRequestBindingException{
        ResultSet resultSet = null;
        String courseName = request.getParameter("courseName");
        String courseId = request.getParameter("courseId");
        int courseId2 = Integer.parseInt(courseId);
        String userId = request.getParameter("userId");
        int userId2 = Integer.parseInt(userId);
        Connection connection = (Connection)getServletContext().getAttribute("connection");

        //修改课程信息
        courseService.editCourseByCourseId(courseId2,courseName,connection);

        //获取修改后的课程列表
        List<Course> list = new ArrayList<Course>();
        list = courseService.getCourseListByUserId(userId2,connection);

        String loginName = request.getParameter("userLoginName");
        request.setAttribute("loginName",loginName);
        HashMap model =new HashMap();
        model.put("userId",userId2);
        model.put("userId",userId2);
        model.put("courseList",list);
        return new ModelAndView("vip/info/user_info",model);
    }
}
