package com.selenium.test.junit.rules;

import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

public class ScreenShotOnFailRule implements TestRule {


    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                try {
                    base.evaluate();
                } catch (Throwable t) {
                    WebDriver driver = WebDriverFactory.getDriver();
                    byte[] srcFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    saveScreenshot(srcFile);
                    throw t;
                }
            }
        };
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot){
        return screenshot;
    }
}
