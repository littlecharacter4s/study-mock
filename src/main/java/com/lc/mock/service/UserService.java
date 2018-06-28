package com.lc.mock.service;

import com.lc.mock.entity.User;

public interface UserService {
    boolean saveUser(String name, String birthday);
    User getUser(Long id);
}
