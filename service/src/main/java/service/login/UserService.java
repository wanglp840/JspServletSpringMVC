package service.login;

import entity.User;

import java.sql.Connection;

/**
 * Created by Administrator on 2015/5/19.
 */
public interface UserService {

    /**
     * 查询该用户是否存在
     * @param userName
     * @param password
     * @return
     */
    public User queryUserByNamePwd(String userName, String password, Connection connection);

    //新增用户
    public void add(String userName, String password, Connection connection);
}
