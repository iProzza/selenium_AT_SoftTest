package ru.stqa.training.selenium.PageObjects.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

import static java.lang.Thread.sleep;


public class ShopCartPage extends Page{

  public ShopCartPage(WebDriver driver) {
    super(driver);
  }

  public void removeProductFromCart() throws InterruptedException {
    //Удаление товаров из корзины
    List<WebElement> productsList = driver.findElements(By.cssSelector("#box-checkout-summary tr:not(.header) .item"));
    String productName = productsList.get(0).getText();
    driver.findElement(By.xpath(String.format("//div[contains(.,'%s')]/p/button[text()='Remove']", productName))).click();
    sleep(500);
  }

}
