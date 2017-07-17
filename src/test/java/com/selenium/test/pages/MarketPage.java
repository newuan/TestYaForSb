package com.selenium.test.pages;

import com.selenium.test.utils.TimeUtils;
import com.selenium.test.webtestsbase.BasePage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import sun.awt.SunHints;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * MarketPage
 */
public class MarketPage extends BasePage {

    @FindBy(css = ".logo.logo_type_link.logo_part_market")
    WebElement logomarket;
    @FindBy(xpath = "html/body/div[1]/div[2]/noindex/ul/li[2]/a")
    WebElement computers;
    @FindBy(xpath = "html/body/div[1]/div[2]/noindex/ul/li[2]/div/div/a[1]")
    WebElement marketNotebook;
    @FindBy(css = "#header-search")
    WebElement searchString;
    @FindBy(css = ".button2.button2_size_ml.button2_type_submit.button2_pin_brick-round.i-bem.button2_theme_action.button2_js_inited")
    WebElement searchButton;

    public MarketPage() {
        super(true);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        try {
            return logomarket.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Go to the menu item
     * @param generalName - general menu item
     * @param secondaryName - secondary menu item
     */
    public MarketCatalogPage gooMarketCatalogPage(String generalName, String secondaryName){
        List<WebElement> topMenuList = WebDriverFactory.getDriver().findElements(By.cssSelector(".link.topmenu__link"));
        int iSize = topMenuList.size();
        for (int i=0; i<iSize; i++){
            String sValue = topMenuList.get(i).getAttribute("textContent");
            if(sValue.equalsIgnoreCase(generalName)){
                Actions actions = new Actions(WebDriverFactory.getDriver());
                actions.moveToElement(topMenuList.get(i));
                actions.perform();
                TimeUtils.waitForSeconds(1);
                break;
            }
        }
        List<WebElement> topMenuSubwrapList = WebDriverFactory.getDriver().findElements((By.cssSelector(".link.topmenu__subitem")));
        int jSize =topMenuSubwrapList.size();
        for (int j=0; j<jSize; j++){
            String jValue = topMenuSubwrapList.get(j).getAttribute("textContent");
            if(jValue.equalsIgnoreCase(secondaryName)){
                topMenuSubwrapList.get(j).click();
                break;
            }
        }
        return new MarketCatalogPage();
    }

    /**
     * Search for a value through the search box
     * @param element - search query
     */
    public ProductPage search (String element) {
        searchString.sendKeys(element);
        TimeUtils.waitForSeconds(3);
        searchButton.click();
        TimeUtils.waitForSeconds(3);
        return new ProductPage();
    }
}
