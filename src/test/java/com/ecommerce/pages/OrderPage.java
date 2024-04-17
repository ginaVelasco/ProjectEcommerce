package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage extends BasePage {
    WebDriver driver;

    /*
     * Web Elements
     * */

    By linkElectronics = By.linkText("Electronics");
    By linkOthers = By.linkText("Others");
    By btnAddToCart = By.xpath("//button[contains(@class, 'product-box-add-to-cart-button')]");
    By barSuccess = By.className("content");
    By btnClose = By.className("close");
    By linkShoppingCart = By.linkText("Shopping cart");
    By btnRemove = By.className("remove-btn");
    By inpQty = By.className("qty-input");
    By chTerms = By.id("termsofservice");
    By btnCheckout = By.id("checkout");
    By qtyGrid = By.className("sku-number");


    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void goToProducts() {
        click(linkElectronics);
        click(linkOthers);
    }

    public void goToShoppingCart() {
        click(linkShoppingCart);

    }

    public void continueBuying() {
        click(chTerms);
        click(btnCheckout);
    }

    public void removeProduct() {
        List<WebElement> buttons = driver.findElements(btnRemove);
        WebElement button = buttons.get(0);
        if (button.isDisplayed()) {
            button.click();
        } else {
            System.out.println("No es visible");
        }

    }

    public void addProducts() {
        List<WebElement> buttons = driver.findElements(btnAddToCart);
        WebElement button = null;
        for (int i = 0; i < buttons.size(); i++) {
            button = buttons.get(i);
            button.click();
            find(btnClose).click();
        }
    }

    public void updateQty(String number) {
        List<WebElement> inputs = driver.findElements(inpQty);
        WebElement inp = inputs.get(0);
        inp.clear();
        inp.sendKeys(number, Keys.ENTER);
    }

    public boolean isDeleted() {
        List<WebElement> inputs = driver.findElements(inpQty);
        if (inputs.size() < 3) {
            return true;
        }
        return false;
    }

    public boolean successBarNotification(String msg) {
        return compareMessage(barSuccess, msg);
    }


}
