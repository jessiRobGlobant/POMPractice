package com.globant.Tests;

import com.globant.Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class PurchaseTest extends BaseTest{

    // Attributes
    private SuccessCheckPage successCheckPage;
    private final Faker faker = new Faker();

    // Test
    @Test()
    public void purchaseTest(){
        HomePage homePage = this.getHomePage();
        CartPage cartPage = addProduct(homePage);
        CheckoutPage checkoutPage = goToCheckout(cartPage);
        CheckoutOverviewPage checkoutOverviewPage = addCheckoutInfo(checkoutPage);
        SuccessCheckPage successCheckPage = overviewToFinish(checkoutOverviewPage);
        checkFinishText(successCheckPage);
    }

    // Test steps methods
    private CartPage addProduct(HomePage homePage){
        String productName = homePage.addRandomProduct();
        this.logInfo(String.format("Added product %s", productName));
        return homePage.getToCart();
    }

    private CheckoutPage goToCheckout(CartPage cartPage){
        return cartPage.goToCheckout();
    }

    private CheckoutOverviewPage addCheckoutInfo(CheckoutPage checkoutPage){
        // Get fake data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String zipCode = faker.address().zipCode();

        // Add info
        checkoutPage.putFirstName(firstName);
        checkoutPage.putLastName(lastName);
        checkoutPage.putPostalCode(zipCode);

        logInfo(String.format(
                "Inserted user data. First Name: %s, Last Name: %s, Zip Code: %s",
                firstName, lastName, zipCode));

        return checkoutPage.goToCheckoutOverview();
    }

    private SuccessCheckPage overviewToFinish( CheckoutOverviewPage checkoutOverviewPage){
        return checkoutOverviewPage.finishPurchase();
    }

    private void checkFinishText(SuccessCheckPage successCheckPage){
        Assert.assertEquals(successCheckPage.getFinishTxt(),
                "Thank you for your order!");
    }
}
