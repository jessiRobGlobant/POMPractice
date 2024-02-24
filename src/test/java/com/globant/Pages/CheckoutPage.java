package com.globant.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends BasePage{

    // Elements
    @FindBy(id = "first-name")
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;
    @FindBy(id = "continue")
    private WebElement continueBtn;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void putFirstName(String firstName){
        super.waitAndClick(firstNameInput);
        firstNameInput.sendKeys(firstName);
    }

    public void putLastName(String lastName){
        super.waitAndClick(lastNameInput);
        lastNameInput.sendKeys(lastName);
    }

    public void putPostalCode(String zip){
        super.waitAndClick(postalCodeInput);
        postalCodeInput.sendKeys(zip);
    }

    public CheckoutOverviewPage goToCheckoutOverview (){
        super.waitAndClick(continueBtn);
        return new CheckoutOverviewPage(this.driver);
    }
}
