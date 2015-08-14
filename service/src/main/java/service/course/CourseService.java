package service.course;

import entity.Course;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrator on 2015/5/19.
 */
public interface CourseService {

    /**
     * 新增课程
     * @param courseName
     * @param userId
     */
    public void addByCourseNameAndUserId(String courseName,int userId,Connection connection);

    /**
     * 根据userId获取课程信息
     * @param userId
     * @param connection
     * @return
     */
    public List<Course> getCourseListByUserId(int userId, Connection connection);

    /**
     * 根据课程Id删除课程
     * @param courseId
     * @param connection
     */
    public void deleteCourseByCourseId(int courseId,Connection connection);

    /**
     * 修改课程的信息
     * @param courseId
     * @param connection
     */
    public void editCourseByCourseId(int courseId,String courseName, Connection connection);
}
