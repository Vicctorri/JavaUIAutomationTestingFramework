package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page{
    public RegisterPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='name']")
    private WebElement organizationNameInput;

    @FindBy(xpath = "//input[@id='organizationContactPersonName']")
    private WebElement organizationContactPersonInput;

    @FindBy(xpath = "//input[@id='loginEmail']")
    private WebElement organizationEmailInput;

    @FindBy(xpath = "//input[@id='legalResidence']")
    private WebElement organizationLegalResidence;

    @FindBy(xpath = "//da-select-dropdown-radiobox-option[@ng-reflect-label='Angola']//div[@class='radio-field new-site-elements']")
    private WebElement legalResidenceOption;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement organizationPasswordInput;

    @FindBy(xpath = "//button[normalize-space()='Register']")
    private WebElement registerOrganization;


    public void fillInTheRegisterForm(String organizationName, String organizationContactPerson, String organizationEmail){
        organizationNameInput.sendKeys(organizationName);
        organizationContactPersonInput.sendKeys(organizationContactPerson);
        organizationEmailInput.sendKeys(organizationEmail);
    }

    public void selectLegalResidenceOption(){
        organizationLegalResidence.click();
        legalResidenceOption.click();
    }

    public void fillPassword(){
        organizationPasswordInput.sendKeys("1234qwer");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickRegisterButton(){
        registerOrganization.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
