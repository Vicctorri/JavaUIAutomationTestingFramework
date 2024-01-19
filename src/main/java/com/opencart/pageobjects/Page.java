package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    public Page(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[normalize-space()='I Accept']")
    protected WebElement termsAndConditions;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    protected WebElement registerBtn;

    @FindBy(xpath = "//body//da-main-root//div[4]")
    protected WebElement registerOption;

    @FindBy(xpath = "//button[@type='button'][normalize-space()='Sign in']")
    protected WebElement loginBtn;

    public void acceptTermsAndConditions(){
        termsAndConditions.click();
    }

    public void navigateToRegisterPageFromHeader(){
        registerBtn.click();
    }

    public void selectRegisterOption(){
        registerOption.click();
    }

    public void loginFromHeader(){
        loginBtn.click();
    }


}
