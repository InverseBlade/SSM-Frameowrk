package com.zzw.dao;

import com.zzw.BaseTest;
import com.zzw.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;
import java.util.List;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testGetUser() throws Exception {
        int userId = 1;
        User user = userDao.getUser(userId);
        System.out.println(user);
    }

    @Test
    public void testGetUserList() throws Exception {
        int offset = 0, limit = 50;
        List<User> list = userDao.getUserList(offset, limit);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateUser() {
        int id = 5;
        User user = new User();
        user.setId(id);
        user.setPasswd("123456gg");
        user.setNickName("RNG牛逼");
        System.out.println(userDao.updateUser(user));
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUserName("spring");
        user.setPasswd("mvc");
        user.setNickName("framework");
        System.out.println(userDao.insertUser(user));
    }

}
