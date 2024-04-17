package com.ecommerce.pages;

import com.ecommerce.utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver;

    /*
     * WebElements
     * */
    public By linkLogIn = By.linkText("Log in");
    public By linkRegister = By.linkText("Register");
    public By linkShopping = By.linkText("Shopping cart");

    /*
     * constructor
     * */

    public HomePage(WebDriver driver) {
        super(driver);
        visit(Variables.BASE_URL);
    }

    /*
     * Methods
     * */

    public void goToRegisterOption() {
        click(linkRegister);
    }

    public void goToLogin() {
        click(linkLogIn);
    }
}
