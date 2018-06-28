package com.lc.mock.dao;

import com.lc.mock.entity.User;

public interface UserDao {
    boolean saveUser(User user);
    User getUser(Long id);
}
