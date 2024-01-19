package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("http://localhost:83/");

        HomePage homePage = new HomePage(driver);
        homePage.acceptTermsAndConditions();
        homePage.navigateToRegisterPageFromHeader();

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.selectRegisterOption();

        registerPage.fillInTheRegisterForm(RandomDataManager.generateName(),
                RandomDataManager.generateName(),
                RandomDataManager.generateRandomEmail());

        registerPage.selectLegalResidenceOption();

        registerPage.fillPassword();

        registerPage.clickRegisterButton();

        DriverManager.getInstance().tearDown();
        System.out.println("That's it!");

    }
}