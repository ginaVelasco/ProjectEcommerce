package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ecommerce.utils.Variables.*;

public class OrderTest extends BaseTest {

    @Test(testName = " Add products to cart", groups = {"Regression"})
    public void addProducts() {
        homePage.goToLogin();
        loginPage.fillLoginFormAndClic(TEST_EMAIL, TEST_PASS);
        orderPage.goToProducts();
        orderPage.addProducts();
        Assert.assertTrue(orderPage.successBarNotification("The product has been added"));
    }

    @Test(testName = "Delete products from cart", groups = {"Regression"})
    public void deleteProducts() {
        homePage.goToLogin();
        loginPage.fillLoginFormAndClic(TEST_EMAIL, TEST_PASS);
        orderPage.goToShoppingCart();
        orderPage.removeProduct();
        Assert.assertTrue(orderPage.isDeleted());
    }

    @Test(testName = "Modify quantity of products in the cart", groups = {"Functional", "Integration"})
    public void modifyQuantityCart() {
        homePage.goToLogin();
        loginPage.fillLoginFormAndClic(TEST_EMAIL, TEST_PASS);
        orderPage.goToShoppingCart();
        orderPage.updateQty("3");
    }

    @Test(testName = "Successful order creation", groups = {"Regression"})
    public void successfulOrder() {
        homePage.goToLogin();
        loginPage.fillLoginFormAndClic(TEST_EMAIL, TEST_PASS);
        orderPage.goToShoppingCart();
        orderPage.continueBuying();
        checkoutPage.fillBillingAddress();
        checkoutPage.shippingMethod();
        checkoutPage.PaymentMethod();
        checkoutPage.PaymentInformation();
        checkoutPage.ConfirmOrder();
        boolean msg = checkoutPage.msgTitleOrder("Click here for order details.");
        System.out.println("msg " + msg);
        Assert.assertTrue(msg);
    }


}
