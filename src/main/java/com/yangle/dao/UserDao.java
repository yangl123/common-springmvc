package com.yangle.dao;

import com.yangle.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yangle on 2017/10/12.
 */
@Repository("UserDao")
public interface UserDao {

    /**
     * 	Created by Vitelon on 2017-03-22
     * 	根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPwd(@Param("username") String username, @Param("password") String password);

    public User getUserInfo(String userName);


    /**
     * 	Created by Vitelon on 2017-03-30
     * 	获取用户
     * @return
     */
    public List<User> find(User User);

    /**
     * 	Created by Vitelon on 2017-03-30
     * 	新增
     * @param User
     */
    public void add(User User);

    /**
     * 	Created by Vitelon on 2017-03-30
     * 	修改
     * @param User
     */
    public void update(User User);

    /**
     * 	Created by Vitelon on 2017-03-30
     * 	删除
     * @param id
     */
    public void delete(String id);
}
