package com.Pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.com.pack.base.TestBaseSetup;


public class SignInPage extends TestBaseSetup {

    private WebDriver driver;

    private By signInButton = By.xpath("//button[@id='signIn']");
    private By emailTextBox = By.xpath( "//input[@id='username']");
    private By passwordTextBox = By.xpath("//input[@id='password']");
  //  private By loginBtn = By.xpath("//button[@id='signIn']");
    private By errorMsgTxt = By.id("errormsg_0_Passwd");


    public SignInPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getSignInPageTitle() {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public String gethomePageTitle() {
        String HpageTitle = driver.getTitle();
        return HpageTitle;
    }


    public boolean verifySignInPageTitle() {
        String expectedTitle = "Login";
        return getSignInPageTitle().contains(expectedTitle);
    }

    /*public boolean verifyHomePageTitle() {
        String expectedTitle = "Fitch Connect - Fitch Solutions";
        return gethomePageTitle().contains(expectedTitle);
    }*/


    public SignInPage enterUserName() {
        WebElement emailTxtBox = driver.findElement(emailTextBox);
        if(emailTxtBox.isDisplayed())
            emailTxtBox.sendKeys("aminul.islam@fitchsolutions.com");
        return null;
    }

    public SignInPage enterPassword() {
        WebElement passwordTxtBox = driver.findElement(passwordTextBox);
        if(passwordTxtBox.isDisplayed())
            passwordTxtBox.sendKeys("Connect1");

        return null;
    }

 /*   public void clickOnSignIn() {
        WebElement signInBtn = driver.findElement(loginBtn);
        if(signInBtn.isDisplayed())
            signInBtn.click();
    }*/

    public SignInPage clickSignInBtn() {
        System.out.println("clicking on sign in button");
        WebElement signInBtnElement=driver.findElement(signInButton);
        if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
            signInBtnElement.click();
        else System.out.println("Element not found");
        return new SignInPage(driver);
    }

    public String getErrorMessage() {
        String strErrorMsg = null;
        WebElement errorMsg = driver.findElement(errorMsgTxt);
        if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
            strErrorMsg = errorMsg.getText();
        return strErrorMsg;
    }


    }




