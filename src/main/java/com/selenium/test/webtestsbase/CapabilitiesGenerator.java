package com.selenium.test.webtestsbase;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesGenerator {

    public static DesiredCapabilities getDefaultCapabilities(Browser browser) {
        switch (browser) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
                if (System.getProperty("webdriver.gecko.driver") == null) {
                    throw new IllegalStateException("System variable 'webdriver.gecko.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.firefox();
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
                if (System.getProperty("webdriver.chrome.driver") == null) {
                    throw new IllegalStateException("System variable 'webdriver.chrome.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.chrome();
            default:
                throw new IllegalStateException("Browser is not supported");
        }
    }

}
