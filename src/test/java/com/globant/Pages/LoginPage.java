package com.globant.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    // Elements
    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public void putUsername(String username){
        super.waitAndClick(usernameInput);
        usernameInput.sendKeys(username);
    }

    public void putPassword(String password){
        super.waitAndClick(passwordInput);
        passwordInput.sendKeys(password);
    }

    public void clickLogin(){
        super.waitAndClick(loginBtn);
    }
}
