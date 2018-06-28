package com.lc.mock.dao.impl;

import com.lc.mock.dao.UserDao;
import com.lc.mock.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public boolean saveUser(User user) {
        return user == null;
    }

    @Override
    public final User getUser(Long id) {
        return new User();
    }
}
