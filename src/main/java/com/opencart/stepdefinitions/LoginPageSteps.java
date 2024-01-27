package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);
    @Given("Authentication page is displayed")
    public void authentificationPageIsDisplayed() {
        driver.get("http://localhost:83/authentication/login");
        System.out.println("The driver accessed the authentication page");

    }

    @When("The login form is populated with the fallowing details:")
    public void theLoginFormIsPopulatedWithTheFallowingDetails(List<String> loginCredentials) {
        loginPage.fillInTheLoginForm(loginCredentials.get(0), loginCredentials.get(1));
    }

    @Then("The expert profile is displayed")
    public void theExpertProfileIsDisplayed() {
        driver.get("http://localhost:83/expertprofile");
    }
}
