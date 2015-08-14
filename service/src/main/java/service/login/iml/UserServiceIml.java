package service.login.iml;

import entity.User;
import service.login.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2015/5/19.
 */
public class UserServiceIml implements UserService {

    @Override
    public void add(String userName, String password, Connection connection) {
        ResultSet resultSet = null;
        try {
            String sql ="INSERT INTO t_user(user_name,user_password) VALUES(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,password);

            int result = ps.executeUpdate();
            if (result > 0){
                resultSet=ps.getGeneratedKeys();
            }
        }catch (SQLException e){
            System.out.println(e.getErrorCode());;
        }
    }

    @Override
    public User queryUserByNamePwd(String userName, String password,Connection connection) {
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM t_user u WHERE u.`user_name`=? AND u.`user_password`= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,password);
            Boolean result = ps.execute();
            if (result!=false){
                resultSet=ps.getResultSet();
            }
        }catch (SQLException e){
            System.out.println(e.getErrorCode());;
        }
        int userId = 0;
        try {
            while (resultSet.next()){
                userId = resultSet.getInt(1);
            }
        }catch (SQLException e){
            System.out.print(e);
        }

        User user = new User();
        user.setId(userId);
        user.setUserName(userName);
        user.setPassword(password);

        return user;
    }
}
