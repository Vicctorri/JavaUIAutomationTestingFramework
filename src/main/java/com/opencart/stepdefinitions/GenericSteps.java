package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("The current url contains {string} keyword")
    public void theCurrentUrlContainsStringKeyword(String keywordFromTheUrl) {
        String currentUrl = driver.getCurrentUrl();
        boolean currentUrlContainsKeyword = currentUrl.contains(keywordFromTheUrl);

        Assertions.assertTrue(currentUrlContainsKeyword, "the keyword " + keywordFromTheUrl + "is present in " + currentUrl);

        System.out.println("last step");
    }

    @Then("The fallowing list of error messages is displayed:")
    public void theFallowingListOfErrorMessagesIsDisplayed(List<String> errorMessagesList) throws InterruptedException {
        Thread.sleep(500);
        errorMessagesList.forEach(errorMessage -> {
            boolean errorMessageIsDisplayed = driver.findElement(By.xpath("//div[@title='" + errorMessage + "']")).isDisplayed();
            Assertions.assertTrue(errorMessageIsDisplayed, "the error message " + errorMessage + " is displayed ");
        });
    }
}
