package com.globant.Tests;

import com.globant.Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class PurchaseTest extends BaseTest{

    // Attributes
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private SuccessCheckPage successCheckPage;
    private final Faker faker = new Faker();

    // Tests
    @Test(priority = 1)
    public void addProduct(){
        // Attributes
        HomePage homePage = this.getHomePage();
        String productName = homePage.addRandomProduct();
        this.logInfo(String.format("Added product %s", productName));
        cartPage = homePage.getToCart();
    }

    @Test(priority = 2)
    public void goToCheckout(){
        checkoutPage = cartPage.goToCheckout();
    }

    @Test(priority = 3)
    public void addCheckoutInfo(){
        // Get fake data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String zipCode = faker.address().zipCode();

        // Add info
        checkoutPage.putFirstName(firstName);
        checkoutPage.putLastName(lastName);
        checkoutPage.putPostalCode(zipCode);

        // Go to checkout overview
        checkoutOverviewPage = checkoutPage.goToCheckoutOverview();

        logInfo(String.format(
                "Inserted user data. First Name: %s, Last Name: %s, Zip Code: %s",
                firstName, lastName, zipCode));
    }

    @Test(priority = 4)
    public void overviewToFinish(){
        successCheckPage = checkoutOverviewPage.finishPurchase();
    }
    @Test(priority = 5)
    public void checkFinishText(){
        Assert.assertEquals(successCheckPage.getFinishTxt(),
                "Thank you for your order!");
    }
}
