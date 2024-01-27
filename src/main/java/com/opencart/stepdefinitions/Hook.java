package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hook {
    @BeforeAll
    public  static void theMethodExecutedBeforeAllTests(){
        System.out.println("test execution started");
    }

    @Before
    public void beforeEachTest(){
        System.out.println("new test execution started");
    }

    @After
    public void afterEachTest(){
        DriverManager.getInstance().deleteCookies();
        System.out.println("test execution finished");

    }

    @AfterAll
    public static void afterAlTests(){
        DriverManager.getInstance().tearDown();
        System.out.println("the tests execution has been finished");
    }
}
