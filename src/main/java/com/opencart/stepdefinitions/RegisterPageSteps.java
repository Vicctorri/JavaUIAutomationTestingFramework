package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    RegisterPage registerPage = new RegisterPage(driver);

    @When("The register form is populated with data")
    public void theRegisterFormIsPopulatedWithData() {
        registerPage.fillInTheRegisterForm(RandomDataManager.generateName(),
                RandomDataManager.generateName(),
                RandomDataManager.generateRandomEmail());

        registerPage.selectLegalResidenceOption();
        registerPage.fillPassword();
    }

    @And("The register button is clicked")
    public void theRegisterButtonIsClicked() {
        registerPage.clickRegisterButton();
    }

    @And("The register option is selected")
    public void theRegisterOptionIsSelected() throws InterruptedException {
        Thread.sleep(1000);
        registerPage.selectRegisterOption();
    }

    @Then("User is registered and is displayed {string}")
    public void userIsRegisteredAndIsDisplayed(String arg0) {
        String actualNotificationMessage = driver.findElement(By.xpath("//p[@class='main ng-star-inserted']")).getText();
        String expectedNotificationMessage = "Thank you for registering an account.";

        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);
    }


    @When("The register form is populated with the fallowing data:")
    public void theRegisterFormIsPopulatedWithTheFallowingData(Map<String, String> formdataMap) {
        String organizationNameValue = formdataMap.get("organizationName");
        String contactPersonValue = formdataMap.get("contactPerson");
        String emailInput = formdataMap.get("email");

        registerPage.fillInTheRegisterForm(organizationNameValue, contactPersonValue, emailInput);
        registerPage.selectLegalResidenceOption();
        registerPage.fillPassword();
    }
}
