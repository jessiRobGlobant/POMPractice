package com.globant.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage{

    // Elements
    @FindBy(id = "finish")
    private WebElement finishBtn;

    // Constructor
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public SuccessCheckPage finishPurchase(){
        super.waitAndClick(finishBtn);
        return new SuccessCheckPage(this.driver);
    }
}
