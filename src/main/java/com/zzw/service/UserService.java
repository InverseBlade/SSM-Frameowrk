package com.zzw.service;

import com.zzw.entity.User;

import java.util.List;

public interface UserService {

    User getById(Integer id);

    List<User> getList();

    int addUser(User user);

    int updateUser(User user);

}
