package com.selenium.test.utils;

public class TimeUtils {

    /**
     * waiting for seconds
     */
    public static void waitForSeconds(int timeoutInSeconds) {
        try {
            Thread.sleep(timeoutInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
