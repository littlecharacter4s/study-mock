package com.lc.mock.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class SpringUtil {
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/application-context.xml");

    private SpringUtil() {
    }

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            applicationContext = new ClassPathXmlApplicationContext("classpath:/application-context.xml");
        }

        return applicationContext;
    }

    public static <T> T getBean(Class<T> type) {
        return type == null ? null : applicationContext.getBean(type);
    }

    public static Object getBean(String name) {
        return StringUtils.isEmpty(name) ? null : applicationContext.getBean(name);
    }
}
