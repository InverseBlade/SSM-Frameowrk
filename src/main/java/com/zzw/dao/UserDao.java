package com.zzw.dao;

import com.zzw.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * Returns a user by his primary key id.
     *
     * @param id primary key of the user
     * @return User
     */
    User getUser(Integer id);

    /**
     * Returns a list of users
     *
     * @param offset the page where to start
     * @param limit  rows of the list
     * @return List<User>
     */
    List<User> getUserList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    int insertUser(User user);

    int updateUser(User user);

}
