package com.globant.Tests;

import com.globant.Pages.HomePage;
import com.globant.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @Test
    public void clickOnLogout(){
        HomePage homePage = this.getHomePage();
        homePage.openMenu();
        LoginPage loginPage = homePage.clickLogout();
        Assert.assertEquals(loginPage.getTittle(), "Swag Labs");
    }
}
