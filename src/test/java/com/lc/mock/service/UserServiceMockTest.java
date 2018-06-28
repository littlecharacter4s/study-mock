package com.lc.mock.service;

import com.lc.mock.BaseMockTest;
import com.lc.mock.dao.UserDao;
import com.lc.mock.entity.User;
import com.lc.mock.service.impl.UserServiceImpl;
import com.lc.mock.util.DateUtil;
import com.lc.mock.util.KeyUtil;
import com.lc.mock.util.RetryUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.Date;

import static org.powermock.api.mockito.PowerMockito.*;

@PrepareForTest({UserServiceImpl.class, DateUtil.class, KeyUtil.class})
public class UserServiceMockTest extends BaseMockTest {
    @InjectMocks
    private UserService userService = spy(new UserServiceImpl());
    @Mock
    private UserDao userDao;

    @Test
    public void testSaveUser() throws Exception {
        doReturn(new User()).when(userService, "assembleUser", Mockito.anyString(), Mockito.anyString());

        doReturn(true).when(userDao).saveUser(Mockito.any(User.class));
        boolean result1 = userService.saveUser(Mockito.anyString(), Mockito.anyString());
        Assert.assertTrue("测试结果", result1);

        RetryUtil retryUtil = Mockito.mock(RetryUtil.class);
        whenNew(RetryUtil.class).withNoArguments().thenReturn(retryUtil);
        doThrow(new RuntimeException()).when(retryUtil).retryWithResult(Mockito.any(RetryUtil.RetryCode.class));
        boolean result2 = userService.saveUser(Mockito.anyString(), Mockito.anyString());
        Assert.assertTrue("测试结果", !result2);
    }

    @Test
    public void testGetUser() throws Exception {
        doReturn(new User()).when(userDao).getUser(Mockito.anyLong());
        User user = userService.getUser(Mockito.anyLong());
        Assert.assertTrue("测试结果", user != null);
    }

    @Test
    public void testAssembleUser() throws Exception {
        KeyUtil keyUtil = Mockito.mock(KeyUtil.class);
        mockStatic(KeyUtil.class);
        when(KeyUtil.getInstance()).thenReturn(keyUtil);
        doReturn(1L).when(keyUtil).getKey();

        mockStatic(DateUtil.class);
        when(DateUtil.convertToDate(Mockito.anyString(), Mockito.anyString())).thenReturn(new Date());

        User user = invokePrivateMethod(userService, "assembleUser", Mockito.anyString(), Mockito.anyString());
        Assert.assertTrue("测试结果", user != null);
    }
}