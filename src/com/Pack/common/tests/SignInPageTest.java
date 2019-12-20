package com.Pack.common.tests;

import com.Pack.common.pageobjects.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.com.pack.base.TestBaseSetup;


public class SignInPageTest extends TestBaseSetup {
    private WebDriver driver;
    private SignInPage SignInPage;
    private SignInPage signInPage;



    @BeforeClass
    public void setUp() {
        driver=getDriver();
    }


    @Test
    public void verifySignInFunction()   {
        SignInPage  = new SignInPage(driver);
        signInPage = SignInPage.enterUserName();
        signInPage = SignInPage.enterPassword();
        signInPage = SignInPage.clickSignInBtn();
        Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");



    }

}