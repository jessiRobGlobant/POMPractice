package com.globant.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessCheckPage extends BasePage{

    // Elements
    @FindBy(css = "h2") // With class would be class="complete-header"
    private WebElement finishTxt;

    // Constructor
    public SuccessCheckPage(WebDriver driver) {
        super(driver);
    }

    // Method
    public String getFinishTxt() {
        return finishTxt.getText();
    }
}
