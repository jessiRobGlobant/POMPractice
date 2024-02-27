package com.globant.Tests;

import com.globant.Pages.HomePage;
import com.globant.Pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogoutTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void clickOnLogout(){
        HomePage homePage = this.getHomePage();
        homePage.openMenu();
        LoginPage loginPage = homePage.clickLogout();
        // Made two assertions to practice softAssert
        softAssert.assertEquals(loginPage.getTittle(), "Swag Labs");
        softAssert.assertEquals(loginPage.getLoginBtnText(), "Login");

        softAssert.assertAll();

    }
}
