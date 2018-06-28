package com.lc.mock.service;

import com.lc.mock.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/application-context.xml")
public class UserServiceTest extends BaseTest {
    @Resource
    private UserService userService;

    @Test
    public void testSaveUser() throws Exception {
        userService.saveUser("world", "2018-01-01");
    }

    @Test
    public void testGetUser() throws Exception {
        userService.getUser(1L);
    }
}