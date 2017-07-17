package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

/**
 * ProductPage
 */
public class ProductPage extends BasePage {
    @FindBy (css = ".n-product-summary__content")
    WebElement summaruContent;
    @FindBy (xpath = "html/body/div[1]/div[4]/div[1]/div[1]/div/div[1]/h1")
    WebElement productTitle;


    public ProductPage() {
        super(true);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        try {
            return summaruContent.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Verification of the name of the product
     * @param name -  name product
     */
    public void checkNameProduct(String name){
        String checkName = productTitle.getText();
        Assert.assertEquals("Product name: "+ name + " does not match the value: " + checkName,checkName,name);
    }
}
