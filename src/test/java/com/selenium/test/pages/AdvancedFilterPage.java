package com.selenium.test.pages;


import com.selenium.test.utils.TimeUtils;
import com.selenium.test.webtestsbase.BasePage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * AdvancedFilterPage
 */
public class AdvancedFilterPage extends BasePage {
    @FindBy (css = ".n-filter-panel-extend.i-bem.n-filter-panel-extend_js_inited")
    WebElement filterPanel;
    @FindBy (css = "#glf-pricefrom-var")
    WebElement priceFrom;
    @FindBy (css = "#glf-priceto-var")
    WebElement priceTo;
    @FindBy (css = ".button.button_size_l.button_theme_pseudo.i-bem.button_action_show-filtered.n-filter-panel-extend__controll-button_size_big.button_js_inited")
    WebElement showResultButton;
    @FindBy(xpath = "html/body/div[1]/div[4]/div/div[1]/div[1]/div[2]/div[2]/div/div[2]/button")
    WebElement fullListFirmButtton;
    @FindBy(xpath = "html/body/div[1]/div[4]/div/div[1]/div[1]/div[2]/div[2]/div/span/span/input")
    WebElement inputFieldFirm;


    public AdvancedFilterPage() {
        super(true);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        try {
            return filterPanel.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    /**
     * Setting price values
     */
    public void setPrice(String from, String to){
            priceFrom.sendKeys(from);
            priceTo.sendKeys(to);
        }
    /**
     * Search and installation of the checkbox by company name.
     * @param name - company name
     */
    public void setNameFirm(String name){
        if (fullListFirmButtton.getAttribute("textContent").equalsIgnoreCase("Ещё")){
            fullListFirmButtton.click();
            TimeUtils.waitForSeconds(2);
        }
        inputFieldFirm.sendKeys(name);
        TimeUtils.waitForSeconds(1);
        List<WebElement> oCheckBox = WebDriverFactory.getDriver().findElements(By.cssSelector(".checkbox__label"));
        int iSize = oCheckBox.size();
        for (int i=0; i<iSize; i++){
            String sValue = oCheckBox.get(i).getAttribute("textContent");
            if (sValue.equalsIgnoreCase(name)){
                oCheckBox.get(i).click();
                break;
            }
        }
        inputFieldFirm.clear();
        TimeUtils.waitForSeconds(4);
    }

    /**
     * Show results button
     */
    public MarketCatalogPage showResult (){
        showResultButton.click();
        return new MarketCatalogPage();
    }

    }

