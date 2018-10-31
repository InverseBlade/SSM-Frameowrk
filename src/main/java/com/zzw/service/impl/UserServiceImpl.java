package com.zzw.service.impl;

import com.zzw.dao.UserDao;
import com.zzw.entity.User;
import com.zzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    /**
     * 构造依赖注入
     *
     * @param userDao UserDao
     */
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getById(Integer id) {
        User user;
        try {
            user = userDao.getUser(id);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> getList() {
        return userDao.getUserList(0, 50);
    }

    @Override
    public int addUser(User user) {
        int count;
        try {
            count = userDao.insertUser(user);
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int updateUser(User user) {
        try {
            return userDao.updateUser(user);
        } catch (Exception e) {
            return 0;
        }
    }
}
