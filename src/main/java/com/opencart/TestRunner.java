package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        //new window
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(currentWindowName);
        driver.get("https://tekwill.md/course/manual-quality-assurance/");
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
        driver.quit();

        System.out.println("That's it!");

    }
}