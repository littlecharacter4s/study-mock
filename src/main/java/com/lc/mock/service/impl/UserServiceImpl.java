package com.lc.mock.service.impl;

import com.lc.mock.service.UserService;
import com.lc.mock.dao.UserDao;
import com.lc.mock.entity.User;
import com.lc.mock.util.DateUtil;
import com.lc.mock.util.KeyUtil;
import com.lc.mock.util.RetryUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public boolean saveUser(String name, String birthday) {
        try {
            User user = this.assembleUser(name, birthday);
            return new RetryUtil().retryWithResult(() -> userDao.saveUser(user));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    private User assembleUser(String name, String birthday) throws Exception {
        User user = new User();
        user.setId(KeyUtil.getInstance().getKey());
        user.setName(name);
        user.setBirthday(DateUtil.convertToDate(birthday, DateUtil.YYYY_MM_DD));
        return user;
    }
}
