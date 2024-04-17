package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ecommerce.utils.Variables.TEST_EMAIL;
import static com.ecommerce.utils.Variables.TEST_PASS;

public class RegisterTest extends BaseTest {

    @Test(testName = "Successful registration", groups = {"Functional"})
    public void doRegister() {
        homePage.goToRegisterOption();
        registerPage.fillOutFormWithData(true, "Didier", "Velasco", "9", "6", "2012", TEST_EMAIL, "Company", TEST_PASS);
        registerPage.completeRegister();
        Assert.assertTrue(registerPage.messageResult("Your registration completed"));
    }


    @Test(testName = "Registration with missing required fields", groups = {"Functional", "Integration"})
    public void doRegisterValidations() {
        homePage.goToRegisterOption();
        registerPage.fillOutFormWithData(true, "", "", "9", "6", "2012", "dcondor@yahoo.com", "Company", "");
        registerPage.completeRegister();
        Assert.assertFalse(registerPage.btnContinueIsDisplayed());
    }

    @Test(testName = "Mail format valid email", groups = {"Functional", "Regression"})
    public void doRegisterValidationEmail() {
        homePage.goToRegisterOption();
        registerPage.fillOutFormWithData(true, "Didier", "Velasco", "9", "6", "2012", "dcondor@yahoo.com", "Company", "Password11");
        registerPage.completeRegister();
        Assert.assertTrue(registerPage.messageError("Wrong email"));
    }

    @Test(testName = "Secure password", groups = {"Regression"})
    public void doRegisterValidationPass() {
        homePage.goToRegisterOption();
        registerPage.fillOutFormWithData(true, "Didier", "Velasco", "9", "6", "2012", "dcondor@yahoo.com", "Company", "Pass11111");
        registerPage.completeRegister();
        Assert.assertFalse(registerPage.btnContinueIsDisplayed());
    }

    @Test(testName = "Confirmation of password", groups = {"Functional", "Integration"})
    public void doRegisterValidationConfirmPass() {
        homePage.goToRegisterOption();
        registerPage.fillOutFormWithData(true, "Didier", "Velasco", "9", "6", "2012", "dcondor@yahoo.com", "Company", "Password11", "Password1");
        registerPage.completeRegister();
        Assert.assertTrue(registerPage.msgConfirmPassValidation("not match"));
    }

    @Test(testName = "Single email", groups = {"Integration"})
    public void doRegisterValidationUniqueEmail() {
        homePage.goToRegisterOption();
        registerPage.fillOutFormWithData(true, "Didier", "Velasco", "9", "6", "2012", "dcondor@yahoo.com", "Company", "Password11", "Password11");
        registerPage.completeRegister();
        Assert.assertTrue(registerPage.messageError("The specified email already exists"));
    }

}
