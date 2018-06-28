package com.lc.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.internal.WhiteboxImpl;

import java.lang.reflect.Method;
import java.time.LocalDate;

@RunWith(PowerMockRunner.class)
public class BaseMockTest {
    public <T> T invokePrivateMethod(Object target, String methodName, Object... args) {
        try {
            Method method = WhiteboxImpl.findMethodOrThrowException(target, null, methodName, args);
            method.setAccessible(true);
            return (T) method.invoke(target, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("方法执行错误!");
    }

    @Test
    public void test() {
        Assert.assertTrue("这只是一个测试!", LocalDate.now().getYear() < Integer.MAX_VALUE);
    }
}

