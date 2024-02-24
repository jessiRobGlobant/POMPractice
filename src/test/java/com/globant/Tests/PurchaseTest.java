package com.globant.Tests;

import com.globant.Pages.CartPage;
import com.globant.Pages.CheckoutOverviewPage;
import com.globant.Pages.CheckoutPage;
import com.globant.Pages.HomePage;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class PurchaseTest extends BaseTest{

    // Attributes
    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private final Faker faker = new Faker();


    @Test(priority = 1)
    public void addProduct(){
        homePage = this.getHomePage();
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
}
