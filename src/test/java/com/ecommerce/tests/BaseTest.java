package com.ecommerce.tests;

import com.ecommerce.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static com.ecommerce.utils.Variables.BASE_URL;
import static com.ecommerce.utils.Variables.TIME_OUT;

public class BaseTest {
    protected WebDriver driver;
    public HomePage homePage;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected OrderPage orderPage;
    protected CheckoutPage checkoutPage;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        driver.get(BASE_URL);
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        orderPage = new OrderPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
    /*

     */


    @AfterMethod
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
