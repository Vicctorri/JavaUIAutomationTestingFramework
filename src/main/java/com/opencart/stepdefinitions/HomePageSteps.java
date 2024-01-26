package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);


    @Given("Homepage is displayed")
    public void homepageIsDisplayed() {
        driver.get("http://localhost:83/");
        System.out.println("The driver accessed the homepage");
    }

    @When("Terms and conditions are accepted")
    public void termsAndConditionsAreAccepted() {
        homePage.acceptTermsAndConditions();
        System.out.println("Terms and conditions are accepted");
    }

    @And("Register button from header is clicked")
    public void registerButtonFromHeaderIsClicked() {
        homePage.navigateToRegisterPageFromHeader();
        System.out.println("Register button is clicked");

    }
}
