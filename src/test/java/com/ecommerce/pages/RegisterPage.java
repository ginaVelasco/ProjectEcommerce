package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    WebDriver driver;

    /*
     * Web Elements
     * */

    By inpFemale = By.id("gender-female");
    By inpMale = By.id("gender-male");
    By inpFirstName = By.id("FirstName");
    By inpLastName = By.id("LastName");
    By slDay = By.name("DateOfBirthDay");
    By slMonth = By.name("DateOfBirthMonth");
    By slYear = By.name("DateOfBirthYear");
    By inpEmail = By.id("Email");
    By inpCompany = By.id("Company");
    By inpPass = By.id("Password");
    By inpConfirmPass = By.id("ConfirmPassword");
    By btnRegister = By.id("register-button");
    By msgResult = By.className("result");
    By btnContinue = By.linkText("Continue");
    By msgError = By.className("message-error");
    By msgValConfirmPass = By.id("ConfirmPassword-error");




    /*
     * constructor
     * */

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /*
     * Methods
     * */


    public void fillOutForm() {
        click(inpFemale);
        type(inpFirstName, "Gina");
        type(inpLastName, "Velasco");
        type(inpEmail, "gvelasco@gmail.com");
        selector(slDay, "07");
        selector(slMonth, "7");
        selector(slYear, "1990");
        type(inpCompany, "ABX Company");
        type(inpPass, "Password01");
        type(inpConfirmPass, "Password01");
    }

    public void fillOutFormWithData(Boolean gender, String fname, String lname, String day, String month, String year, String email, String company, String pass, String confirmPass) {
        if (gender) {
            click(inpFemale);
        } else {
            click(inpMale);
        }
        type(inpFirstName, fname);
        type(inpLastName, lname);
        selector(slDay, day);
        selector(slMonth, month);
        selector(slYear, year);
        type(inpEmail, email);
        type(inpCompany, company);
        type(inpPass, pass);
        type(inpConfirmPass, pass);
    }

    public void fillOutFormWithData(Boolean gender, String fname, String lname, String day, String month, String year, String email, String company, String pass) {
        if (gender) {
            click(inpFemale);
        } else {
            click(inpMale);
        }
        type(inpFirstName, fname);
        type(inpLastName, lname);
        selector(slDay, day);
        selector(slMonth, month);
        selector(slYear, year);
        type(inpEmail, email);
        type(inpCompany, company);
        type(inpPass, pass);
        type(inpConfirmPass, pass);
    }

    public void completeRegister() {
        submit(btnRegister);
    }

    public boolean btnContinueIsDisplayed() {
        return isDisplayed(btnContinue);
    }

    public boolean messageError(String msg) {
        return compareMessage(msgError, msg);
    }

    public boolean messageResult(String msg) {
        return compareMessage(msgResult, msg);
    }

    public boolean msgConfirmPassValidation(String msg) {
        return compareMessage(msgValConfirmPass, msg);
    }

}
