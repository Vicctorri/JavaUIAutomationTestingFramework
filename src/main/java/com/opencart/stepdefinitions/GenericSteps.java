package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("The current url contains {string} keyword")
    public void theCurrentUrlContainsStringKeyword(String keywordFromTheUrl) {
        String currentUrl = driver.getCurrentUrl();
        boolean currentUrlContainsKeyword = currentUrl.contains(keywordFromTheUrl);

        Assertions.assertTrue(currentUrlContainsKeyword, "the keyword " + keywordFromTheUrl + "is present in " + currentUrl);

        System.out.println("last step");
    }
}
