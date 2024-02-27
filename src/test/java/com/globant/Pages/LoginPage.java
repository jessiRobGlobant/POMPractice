package com.globant.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    // Elements
    @FindBy(xpath = "//*[@id='user-name']") //(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginBtn;
    @FindBy(className = "login_logo")
    private WebElement loginLogo;

    // Constructors
    public LoginPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Methods
    public void putUsername(String username){
        super.waitAndClick(usernameInput);
        usernameInput.sendKeys(username);
    }

    public void putPassword(String password){
        super.waitAndClick(passwordInput);
        passwordInput.sendKeys(password);
    }

    public HomePage clickLogin(){
        super.waitAndClick(loginBtn);
        return new HomePage(this.driver);
    }

    public String getTittle(){
        super.waitTillVisible(loginLogo);
        return loginLogo.getText();
    }

    public String getLoginBtnText(){
        super.waitTillVisible(loginBtn);
        return loginBtn.getAttribute("value");
    }
}
