package com.globant.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    // Attributes
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Getters
    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    // Constructor
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        // this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Waits
//    public void waitTillVisible(WebElement element){
//        getWait().until(ExpectedConditions.visibilityOf(element));
//    }
//
//    public void waitTillClickable(WebElement element){
//        getWait().until(ExpectedConditions.elementToBeClickable(element));
//    }

    public void waitAndClick(WebElement element) {
        // waitTillClickable(element);
        element.click();
    }
}
