package com.lc.mock.util;

public class RetryUtil {
    private static final byte MAX_RETRY_COUNT = 5;
    private static final int MAX_SLEEP_MS = 500;

    public boolean retryWithResult(RetryCode retryCode) {
        boolean result = false;
        for (int retryCount = 1; retryCount <= MAX_RETRY_COUNT; retryCount++) {
            try {
                if (retryCount > 1) {
                    Thread.sleep(MAX_SLEEP_MS);
                }
                result = retryCode.execute();
                if (result) {
                    break;
                }
            } catch (Exception e) {
                if (retryCount == MAX_RETRY_COUNT) {
                    return false;
                }
            }
        }
        return result;
    }


    public interface RetryCode {
        boolean execute();
    }
}