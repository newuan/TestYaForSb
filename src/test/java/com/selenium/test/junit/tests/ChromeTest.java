package com.selenium.test.junit.tests;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.junit.rules.WebDriverRule;
import com.selenium.test.pages.*;
import com.selenium.test.webtestsbase.Browser;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.*;
import org.junit.rules.RuleChain;

/**
 * ChromeTest
 */

public class ChromeTest {
    @Rule
    public RuleChain ruleChain = RuleChain
            .outerRule(new WebDriverRule())
            .around(new ScreenShotOnFailRule());

    @Before
    public void beforeTest () {
        WebDriverFactory.startBrowser(Browser.CHROME);
    }

    @Test
    public void testMarket(){
        YandexPage yandexPage = new YandexPage();
        yandexPage.goMarket();
        MarketPage marketPage = new MarketPage();
        marketPage.gooMarketCatalogPage("Компьютеры", "Ноутбуки");
        MarketCatalogPage marketCatalogPage = new MarketCatalogPage();
        marketCatalogPage.goAdvancedFilter();
        AdvancedFilterPage advancedFilterPage = new AdvancedFilterPage();
        advancedFilterPage.setPrice("0", "30000");
        advancedFilterPage.setNameFirm("HP");
        advancedFilterPage.setNameFirm("Lenovo");
        advancedFilterPage.showResult();
        marketCatalogPage.checkFindResult(12);
        String name = marketCatalogPage.getNameResult(0);
        marketPage.search(name);
        ProductPage productPage = new ProductPage();
        productPage.checkNameProduct(name);
    }
}
