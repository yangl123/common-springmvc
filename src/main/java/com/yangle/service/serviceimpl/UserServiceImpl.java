package com.yangle.service.serviceimpl;

import com.yangle.dao.UserDao;
import com.yangle.entity.User;
import com.yangle.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangle on 2017/10/12.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource(name = "UserDao")
    private UserDao userDao;

    public User findByUsernameAndPwd(String name, String pwd) {

        return userDao.findByUsernameAndPwd(name, pwd);
    }

    public List<User> find(User user){

        return userDao.find(user);
    }


    public void add(User user) {

        userDao.add(user);
    }

    public void update(User user) {

        userDao.update(user);
    }

    public void delete(String id) {

        userDao.delete(id);
    }

    @Override
    public User getUserInfo(String username) {
        return userDao.getUserInfo(username);
    }
}