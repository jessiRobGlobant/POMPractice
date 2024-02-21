package com.globant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class UserTest {
    String user;
    String password;
    private final Logger log = Logger.getLogger(AppTest.class.getName());
    private WebDriver driver;

    public UserTest(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Test
    public void purchaseProduct() {
        // Test logic using data
        addRandomProduct();
        log.info("Tesing");
    }

    private void addRandomProduct(){
        List<WebElement> productsCards = getElementsByClass("inventory_item_description");
        // Get Random product
        Random rand = new Random();
        WebElement randomProduct = productsCards.get(rand.nextInt(productsCards.size()));
        // Add it to the cart
        log.info(randomProduct.getAttribute("innerHTML"));
        randomProduct.findElement(By.className("btn_inventory")).click();
    }

    private List<WebElement> getElementsById( String id){
        return driver.findElements(By.id(id));
    }

    private List<WebElement> getElementsByClass(String className){
        return driver.findElements(By.className(className));
    }

    @Test
    public void removeElementsShoppingCart() {
        // Test logic using data
        log.info("Tesing");
    }

    @Test
    public void logout() {
        // Test logic using data
        log.info("Tesing");
    }

    @Test
    public void myTestMethod() {
        // Test logic using data
        log.info("Tesing");
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

    @BeforeClass
    public void logging(){
        log.info(String.format("Loggin with Username: %s, Password: %s", user, password));

        // Find elements
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        // Put username
        usernameInput.click();
        usernameInput.sendKeys(getUser());

        // Put password
        passwordInput.click();
        passwordInput.sendKeys(getPassword());

        // Loggin button
        loginBtn.click();

        log.info("Loggin made");
    }

    @AfterSuite
    public void closeGoogle(){
        log.info("Clossing Chrome");
        // driver.close();
    }

}
