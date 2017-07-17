package com.selenium.test.junit.rules;

import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.rules.ExternalResource;

/**
 * Because "The Statement passed to the TestRule will run any Before methods, then the Test method,
 * and finally any After methods, throwing an exception if any of these fail"
 */
public class WebDriverRule extends ExternalResource {
    @Override
    protected void after(){
        WebDriverFactory.finishBrowser();
    }
}
