package com.ecommerce.pages;

import com.ecommerce.utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    /*(name = "Gina Velasco",
  date = "15/04/2024"
)*/
    By slCountry = By.id("BillingNewAddress_CountryId"); //179
    By slState = By.id("BillingNewAddress_StateProvinceId");//0
    By inpCity = By.id("BillingNewAddress_City");
    By inpAddress1 = By.id("BillingNewAddress_Address1");
    By inpZip = By.id("BillingNewAddress_ZipPostalCode");
    By inpPhone = By.id("BillingNewAddress_PhoneNumber");
    By btnContinue = By.name("save");
    By btnContinueShipper = By.className("shipping-method-next-step-button");
    By btnConfirm = By.className("confirm-order-next-step-button");
    By msgTitle = By.className("details-link");
    By btnPaymentMethod = By.className("payment-method-next-step-button");
    By btnPaymentInfo = By.className("payment-info-next-step-button");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public CheckoutPage(WebDriver driver) {
        super(driver);
        visit(Variables.BASE_URL);
    }

    public void fillBillingAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(slCountry));
        selector(slCountry, "179");
        selector(slState, "0");
        type(inpCity, "Quito");
        type(inpAddress1, "Manuel Lizarzaburo");
        type(inpZip, "0");
        type(inpPhone, "89647815");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinue));
        click(btnContinue);

    }

    public void shippingMethod() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinueShipper));
        click(btnContinueShipper);
    }

    public void PaymentMethod() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnPaymentMethod));
        click(btnPaymentMethod);

    }

    public void PaymentInformation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnPaymentInfo));
        click(btnPaymentInfo);

    }

    public void ConfirmOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnConfirm));
        click(btnConfirm);

    }

    public boolean msgTitleOrder(String msg) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(msgTitle));
        if (getText(msgTitle).contains(msg)) {
            return true;
        }
        return false;
    }
}
