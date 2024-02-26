package com.globant.Tests;

import com.globant.Pages.HomePage;
import com.globant.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.logging.Logger;

public class BaseTest {

    // Attributes
    private static final String username = "standard_user";
    private static final String password = "secret_sauce";
    protected WebDriver driver;
    private static final Logger log = Logger.getLogger(BaseTest.class.getName());
    private static final String driverPath =  "src\\utils\\chromedriver.exe";
    private static final String url =  "https://www.saucedemo.com";
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        login();
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public void login() {
        LoginPage loginPage = new LoginPage(driver, url);
        loginPage.putUsername(username);
        loginPage.putPassword(password);
        this.homePage = loginPage.clickLogin();
    }

    public void logInfo(String msg){
        log.info(msg);
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        logInfo("Clossing Chrome");
        driver.close();
    }
}
