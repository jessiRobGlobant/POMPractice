package com.globant.Tests;

import com.globant.Pages.CartPage;
import com.globant.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class RemoveProdTest extends BaseTest{

    // Attributes
    private final Set<String> products = new HashSet<>();

    // Test
    @Test
    public void removeProductTest(){
        HomePage homePage = this.getHomePage();
        CartPage cartPage = addProducts(homePage);
        removeProducts(cartPage);
        checkIfEmpty(cartPage);
    }

    // Test steps methods
    private CartPage addProducts(HomePage homePage){

        while (products.size() < 3){
            String productName = homePage.addRandomProduct();
            products.add(productName);
            this.logInfo(String.format("Added product %s", productName));
        }

        return homePage.getToCart();
    }

    private void removeProducts(CartPage cartPage){
        cartPage.removeProducts(products);
    }

    private void checkIfEmpty(CartPage cartPage){
        Assert.assertEquals(cartPage.numProducts(), 0);
    }
}
