package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * YandexPage
 */
public class YandexPage extends BasePage {

    private static final String PAGE_URL = "https://www.yandex.ru/";

    @FindBy(xpath = "html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[1]/div/a[2]")
    private WebElement marketbutton;

    @FindBy(css = ".home-tabs.i-bem.home-tabs_js_inited")
    private WebElement homeTabs;

    public YandexPage() {
        super(true);
    }


    public MarketPage goMarket(){
        marketbutton.click();
        return new MarketPage();
    }


    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return homeTabs.isDisplayed();
    }
}
