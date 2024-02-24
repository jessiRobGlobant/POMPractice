package com.globant.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    // Elements
    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    // Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage goToCheckout(){
        super.waitAndClick(checkoutBtn);
        return new CheckoutPage(this.driver);
    }
}
