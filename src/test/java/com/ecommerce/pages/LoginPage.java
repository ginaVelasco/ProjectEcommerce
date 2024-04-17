package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    /*(name = "Gina Velasco",
  date = "15/04/2024"
)*/
    WebDriver driver;

    By inpEmail = By.id("Email");
    By inpPass = By.id("Password");
    By btnLogin = By.className("login-button");
    By btnRecover = By.name("send-email");
    By linkForgotPass = By.linkText("Forgot password?");
    By msgError = By.className("message-error");
    By msgEmailError = By.id("Email-error");
    By linkMyAccount = By.linkText("My account");


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void fillLoginFormAndClic(String email, String pass) {
        type(inpEmail, email);
        type(inpPass, pass);
        click(btnLogin);
    }

    public void ForgotPass(String email) {
        click(linkForgotPass);
        type(inpEmail, email);
    }

    public void completeRecover() {
        submit(btnRecover);
    }

    public boolean validationMsgError(String msg) {
        return compareMessage(msgError, msg);
    }

    public boolean validationMsgEmailError(String msg) {
        return compareMessage(msgEmailError, msg);
    }

    public boolean loginSuccessful() {
        return isDisplayed(linkMyAccount);
    }
}
