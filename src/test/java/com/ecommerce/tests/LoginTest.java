package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ecommerce.utils.Variables.TEST_EMAIL;
import static com.ecommerce.utils.Variables.TEST_PASS;

public class LoginTest extends BaseTest {

    @Test(testName = "Successful Log in", groups = {"Regression", "Integration"})
    public void successfulLogin() {
        homePage.goToLogin();
        loginPage.fillLoginFormAndClic(TEST_EMAIL, TEST_PASS);
        Assert.assertTrue(loginPage.loginSuccessful());
    }

    @Test(testName = "Login with incorrect credentials", groups = {"Functional"})
    public void loginValidationCredentianls() {
        homePage.goToLogin();
        loginPage.fillLoginFormAndClic("gvelasco@gmail.com", "Password01");
        Assert.assertTrue(loginPage.validationMsgError("The credentials provided are incorrect"));
    }

    @Test(testName = "Blank credentials", groups = {"Functional"})
    public void loginBlankCredentials() {
        homePage.goToLogin();
        loginPage.fillLoginFormAndClic(" ", " ");
        Assert.assertTrue(loginPage.validationMsgEmailError("Please enter your email"));
    }

    @Test(testName = "Unregistered email", groups = {"Regression"})
    public void loginUnregisteredEmail() {
        homePage.goToLogin();
        loginPage.fillLoginFormAndClic("gvelsco@gmail.com", "password01");
        Assert.assertTrue(loginPage.validationMsgError("No customer account found"));
    }

    @Test(testName = "Forgotten password", groups = {"Functional", "Integration"})
    public void loginForgottenPass() {
        homePage.goToLogin();
        loginPage.ForgotPass("gvelasco@gmail.com");
        loginPage.completeRecover();
    }


}
