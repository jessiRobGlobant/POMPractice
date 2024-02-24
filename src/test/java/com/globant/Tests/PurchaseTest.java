package com.globant.Tests;

import com.globant.Pages.HomePage;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest{

    private HomePage homePage;

    @Test
    public void purchase(){
        homePage = this.getHomePage();
        String productName = homePage.addRandomProduct();
        this.logInfo(String.format("Added product %s", productName));
    }
}
