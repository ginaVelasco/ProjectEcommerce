package com.ecommerce.pages;

import com.ecommerce.utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*(name = "Gina Velasco",
  date = "15/04/2024"
)*/

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Variables.TIME_OUT));
        driver.get(url);
    }

    public WebElement find(By element) {
        return driver.findElement(element);
    }

    public void type(By element, String text) {
        find(element).sendKeys(text);
    }

    public String getText(By element) {
        return find(element).getText();
    }

    public boolean compareText(By element, String expectText) {
        String title = getText(element);
        return title.contains(expectText);
    }

    public boolean compareMessage(By element, String msg) {
        return compareText(element, msg);
    }

    public void selector(By element, String value) {
        Select select = new Select(driver.findElement(element));
        select.selectByValue(value);
    }

    public void click(By element) {
        find(element).click();
    }

    public void submit(By element) {
        find(element).submit();
    }

    public void typeAndEnter(By element, String text) {
        find(element).sendKeys(text, Keys.ENTER);
    }

    public boolean isDisplayed(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
