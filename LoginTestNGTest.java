package com.example.tests;

import com.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestNGTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        // Initialize the WebDriver and open the URL
        driver = new ChromeDriver();
        driver.get("https://example.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        loginPage.enterUsername("test_user");
        loginPage.enterPassword("Test@123");
        loginPage.clickLoginButton();
        
        // Validate if the page title contains 'Dashboard'
        Assert.assertTrue(loginPage.getPageTitle().contains("Dashboard"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
