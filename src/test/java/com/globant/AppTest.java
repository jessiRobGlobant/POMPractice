package com.globant;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private Logger log = Logger.getLogger(AppTest.class.getName());
    private WebDriver driver;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        log.info("Si lo hizo");
        assertTrue( true );
    }

    @BeforeSuite
    public void googleSetUp(){
        String url = "https://www.saucedemo.com";

        String driverPath = "src\\utils\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.navigate().to(url);
        log.info("Chrome initialized");
    }

    @BeforeTest
    public void logging(){
        
        log.info("Loggin made");
    }

}
