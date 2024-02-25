package com.globant.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.List;

public class CartPage extends BasePage{

    // Elements
    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(className = "cart_item_label")
    private List<WebElement> cartProducts;

    // Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }


    // Page methods
    public CheckoutPage goToCheckout(){
        super.waitAndClick(checkoutBtn);
        return new CheckoutPage(this.driver);
    }

    public String getProductName(WebElement product){
        // super.waitTillVisible(product);
        WebElement productLbl = product.findElement(By.className("inventory_item_name"));
        return productLbl.getText();
    }

    public void removeProduct(WebElement product){
        // class = btn btn_secondary btn_small cart_button
        WebElement removeBtn = product.findElement(By.cssSelector("button.cart_button"));
        super.waitAndClick(removeBtn);
    }

    public void removeProducts(Collection<String> products){
        for (WebElement product: cartProducts){
            if (products.contains(getProductName(product))){
                removeProduct(product);
            }
        }
    }

    public int numProducts(){
        return cartProducts.size();
    }

}
