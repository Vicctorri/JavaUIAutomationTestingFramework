package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunit {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeAll
    public static void executeThisMethodBeforeAllTests(){
        System.out.println("execution of test has been started");
    }

    @BeforeEach
    public void executeTheCodeBeforeEachTest(){
        System.out.println("executed before each test");
        driver = DriverManager.getInstance().getDriver();
        driver.get("http://localhost:83/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.acceptTermsAndConditions();

    }
    @Test
    @DisplayName("The registration of the new user is successfully")
    public void registerWithValidCredentialTest() throws InterruptedException {
        homePage.navigateToRegisterPageFromHeader();
        registerPage.selectRegisterOption();

        registerPage.fillInTheRegisterForm(RandomDataManager.generateName(),
                RandomDataManager.generateName(),
                RandomDataManager.generateRandomEmail());

        registerPage.selectLegalResidenceOption();
        registerPage.fillPassword();
        registerPage.clickRegisterButton();
        Thread.sleep(1000);

        String actualNotificationMessage = driver.findElement(By.xpath("//p[@class='main ng-star-inserted']")).getText();
        String expectedNotificationMessage = "Thank you for registering an account.";

        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);
    }

    @Test
    @DisplayName("The registration failed, lacks of the Legal Residence")
    public void registerWithInvalidData(){
        homePage.navigateToRegisterPageFromHeader();
        registerPage.selectRegisterOption();

        registerPage.fillInTheRegisterForm(RandomDataManager.generateName(),
                RandomDataManager.generateName(),
                RandomDataManager.generateRandomEmail());

        registerPage.fillPassword();
        registerPage.clickRegisterButton();

        String actualErrorMessage = driver.findElement(By.xpath("//div[@title='Required']")).getText();
        String expectedErrorMessage = "Required";

        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @AfterEach
    public void executeAfterEachTest(){
        System.out.println("finished");
        DriverManager.getInstance().tearDown();

    }

    @AfterAll
    public static void executeAfterAll(){
        System.out.println("finished2");
    }


}
