package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "outlined-field__content")
    private WebElement loginEmail;

    @FindBy(className = "outlined-field__content")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='button button-large button-primary-blue']")
    private WebElement signinBtn;

    public void fillInTheLoginForm(String login, String password){
        loginEmail.sendKeys(login);
        passwordInput.sendKeys(password);
    }

    public void clickSignInBtn(){
        signinBtn.click();
    }

}
