package com.selenium.test.junit.tests;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.junit.rules.WebDriverRule;
import com.selenium.test.pages.*;
import com.selenium.test.webtestsbase.Browser;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.*;
import org.junit.rules.RuleChain;

/**
 * FireFoxTest
 */
public class FireFoxTest {
    @Rule
    public RuleChain ruleChain = RuleChain
            .outerRule(new WebDriverRule())
            .around(new ScreenShotOnFailRule());

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(Browser.FIREFOX);
    }

    @Test
    public void testMarket(){
        YandexPage yandexPage = new YandexPage();
        yandexPage.goMarket();
        MarketPage marketPage = new MarketPage();
        marketPage.gooMarketCatalogPage("Компьютеры", "Планшеты");
        MarketCatalogPage marketCatalogPage = new MarketCatalogPage();
        marketCatalogPage.goAdvancedFilter();
        AdvancedFilterPage advancedFilterPage = new AdvancedFilterPage();
        advancedFilterPage.setPrice("20000","25000");
        advancedFilterPage.setNameFirm("Acer");
        advancedFilterPage.setNameFirm("DELL");
        advancedFilterPage.showResult();
        marketCatalogPage.checkFindResult(12);
        String name = marketCatalogPage.getNameResult(0);
        marketPage.search(name);
        ProductPage productPage = new ProductPage();
        productPage.checkNameProduct(name);
    }
}
