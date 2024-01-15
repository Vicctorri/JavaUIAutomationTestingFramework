package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        //new window
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://localhost:83/");
        Thread.sleep(1000);

        WebElement registerButton = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerButton.click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);

        WebElement registerOption = driver.findElement(By.xpath("//body//da-main-root//div[4]"));
        registerOption.click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

        WebElement organizationNameInput = driver.findElement(By.cssSelector("#name"));
        String orgName = RandomDataManager.generateName();
        organizationNameInput.sendKeys(orgName);

        WebElement organizationContactPersonInput = driver.findElement(By.cssSelector("#organizationContactPersonName"));
        String contactName = RandomDataManager.generateName();
        organizationContactPersonInput.sendKeys(contactName);

        WebElement organizationEmailInput = driver.findElement(By.cssSelector("#loginEmail"));
        String randomEmail = RandomDataManager.generateRandomEmail();
        organizationEmailInput.sendKeys(randomEmail);

        WebElement organizationLegalResidence = driver.findElement(By.cssSelector("#legalResidence"));
        organizationLegalResidence.click();
        WebElement legalResidenceOption = driver.findElement(By.xpath("//da-select-dropdown-radiobox-option[@ng-reflect-label='Angola']//div[@class='radio-field new-site-elements']"));
        legalResidenceOption.click();

        WebElement organizationPasswordInput = driver.findElement(By.cssSelector("#password"));
        organizationPasswordInput.sendKeys("1234qwer");
        Thread.sleep(3000);

        WebElement registerOrganization = driver.findElement(By.cssSelector("button[type='submit']"));
        registerOrganization.click();
        Thread.sleep(2000);



        System.out.println(driver.getTitle());
        driver.close();

//        driver.switchTo().window(currentWindowName);
//        driver.get("https://tekwill.md/course/manual-quality-assurance/");
//        Thread.sleep(1000);
//        System.out.println(driver.getTitle());

        driver.quit();

        System.out.println("That's it!");

    }
}