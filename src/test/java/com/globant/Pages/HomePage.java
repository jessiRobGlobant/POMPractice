package com.globant.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage{

    // Elements
    @FindBy(className = "inventory_item_description")
    List<WebElement> productsCards;
    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String addRandomProduct(){
        // Get Random product
        Random rand = new Random();
        WebElement randomProduct = productsCards.get(rand.nextInt(productsCards.size()));
        // Add it to the cart
        randomProduct.findElement(By.className("btn_inventory")).click();
        return randomProduct.findElement(By.className("inventory_item_name")).getText();
    }

    public CartPage getToCart(){
        super.waitAndClick(shoppingCartBtn);
        return new CartPage(this.driver);
    }

}
