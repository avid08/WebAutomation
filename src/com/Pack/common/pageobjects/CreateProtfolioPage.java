package com.Pack.common.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateProtfolioPage {


    private WebDriver driver;
    private By headerPageTxt = By.cssSelector(".signuponepage.main.content.clearfix>h1");
    public CreateProtfolioPage(WebDriver driver) {
        this.driver=driver;
    }
    private By homPageHeader = By.xpath("/html/head/title");


    public String gethomePageTitle() {
        String HpageTitle = driver.getTitle();
        return HpageTitle;
    }
    public CreateProtfolioPage homePageVerification() {
        WebElement homePageTitle = driver.findElement(homPageHeader);
        if(homePageTitle.isDisplayed())
            homePageTitle.getText();
        return null;
    }

    public boolean verifyHomePageTitle() {
        String expectedTitle = "Fitch Connect - Fitch Solutions";
        return gethomePageTitle().contains(expectedTitle);
    }


    public boolean verifyCreateAccountPageText() {
        WebElement element = driver.findElement(headerPageTxt);
        String pageText ="Create your Google Account";
        return element.getText().contains(pageText);
    }

    public void createAccount() {
        //need to write steps for creating an account
    }
}
