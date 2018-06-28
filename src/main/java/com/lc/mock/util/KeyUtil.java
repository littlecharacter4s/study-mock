package com.lc.mock.util;

public class KeyUtil {
    private KeyUtil() {}

    private static final class KeyUtilInner {
        private static final KeyUtil keyUtil = new KeyUtil();
        private KeyUtilInner() {}
    }

    public static KeyUtil getInstance() {
        return KeyUtilInner.keyUtil;
    }

    public Long getKey() {
        return Math.round(Math.random() * 100000000);
    }
}
