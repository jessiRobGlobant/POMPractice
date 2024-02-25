package com.globant.Tests;

import com.globant.Pages.CartPage;
import com.globant.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class RemoveProdTest extends BaseTest{

    // Attributes
    private CartPage cartPage;

    private final Set<String> products = new HashSet<>();

    @Test(priority = 1)
    public void addProducts(){
        HomePage homePage = this.getHomePage();

        while (products.size() < 3){
            String productName = homePage.addRandomProduct();
            products.add(productName);
            this.logInfo(String.format("Added product %s", productName));
        }

        cartPage = homePage.getToCart();
    }

    @Test(priority = 2)
    public void removeProducts(){
        cartPage.removeProducts(products);
    }

    @Test(priority = 3)
    public void checkIfEmpty(){
        Assert.assertEquals(cartPage.numProducts(), 0);
    }
}
