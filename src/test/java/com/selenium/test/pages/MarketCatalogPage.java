package com.selenium.test.pages;

import com.selenium.test.utils.TimeUtils;
import com.selenium.test.webtestsbase.BasePage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * MarketCatalogPage
 */
public class MarketCatalogPage extends BasePage{

    @FindBy(css = ".n-filter-applied-results__content.preloadable.i-bem.preloadable_js_inited")
    WebElement content;
    @FindBy(linkText = "Перейти ко всем фильтрам")
    WebElement advancedFilter;


    public MarketCatalogPage() {
        super(true);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        try {
            return content.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Advanced filter button
     */
    public AdvancedFilterPage goAdvancedFilter (){
        advancedFilter.click();
        return new AdvancedFilterPage();
    }

    /**
     * Number of results per page
     * @param count - number - 1
     */
    public void checkFindResult (int count){
        List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector(".snippet-card__header.i-bem.snippet-card__header_js_inited"));
        Assert.assertEquals("Number of results on page "+elements.size()+" and not equal to "+count, elements.size(), count);
        }

    /**
     * Getting a name by item number
     * @param number - item number
     */
    public String getNameResult (int number){
        List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.cssSelector(".snippet-card__header.i-bem.snippet-card__header_js_inited"));
        return elements.get(number).getText();
    }
}
